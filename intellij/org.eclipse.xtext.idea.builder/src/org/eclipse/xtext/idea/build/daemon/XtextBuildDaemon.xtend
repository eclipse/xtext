/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.build.daemon

import com.google.inject.Guice
import com.google.inject.Inject
import java.net.InetAddress
import java.net.InetSocketAddress
import java.net.ServerSocket
import java.nio.channels.SelectionKey
import java.nio.channels.ServerSocketChannel
import java.nio.channels.SocketChannel
import java.nio.channels.spi.SelectorProvider
import org.apache.log4j.FileAppender
import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.log4j.TTCCLayout
import org.eclipse.xtext.builder.standalone.IIssueHandler
import org.eclipse.xtext.builder.standalone.incremental.BuildRequest
import org.eclipse.xtext.builder.standalone.incremental.IncrementalStandaloneBuilder
import org.eclipse.xtext.builder.standalone.incremental.IndexState
import org.eclipse.xtext.idea.build.net.ObjectChannel
import org.eclipse.xtext.idea.build.net.Protocol.BuildFailureMessage
import org.eclipse.xtext.idea.build.net.Protocol.BuildRequestMessage
import org.eclipse.xtext.idea.build.net.Protocol.BuildResultMessage

import static org.eclipse.xtext.idea.build.daemon.XtextBuildDaemon.*

import static extension org.eclipse.xtext.builder.standalone.incremental.FilesAndURIs.*

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class XtextBuildDaemon {

	static val LOG = Logger.getLogger(XtextBuildDaemon)

	def static void main(String[] args) {
		try {
			LOG.parent.addAppender(new FileAppender(new TTCCLayout(), 'xtext_builder_daemon.log', false))
			LOG.level = Level.INFO
			val injector = Guice.createInjector(new BuildDaemonModule)
			injector.getInstance(Server).run(args.parse)
		} catch (Exception exc) {
			System.err.println('Error ' + exc.message)
		}
	}

	private static def Arguments parse(String... args) {
		val arguments = new Arguments
		val i = args.iterator
		while (i.hasNext) {
			val arg = i.next
			switch arg.toLowerCase {
				case '-port':
					arguments.port = Integer.parseInt(i.next)
				case '-timeout':
					arguments.timeout= Long.parseLong(i.next)
				case '-initialtimeout':
					arguments.timeout= Long.parseLong(i.next)
				default:
					throw new IllegalArgumentException("Invalid argument '" + arg + "'")
			}
		}
		if (arguments.port == 0)
			throw new IllegalArgumentException('Port number must be set')
		return arguments
	}

	static class Arguments {
		int port
		long timeout = 1000 * 60 * 60 * 3 // 3h in ms
		long initialTimeout = 5000
	}

	static class Server {
		@Inject Worker worker

		def void run(Arguments arguments) {
			var ServerSocket serverSocket = null
			try {
				LOG.info('Starting xtext build daemon at port ' + arguments.port + '...')
				val socketSelector = SelectorProvider.provider.openSelector
				val serverChannel = ServerSocketChannel.open
				serverChannel.configureBlocking(false)
				val socketAddress = new InetSocketAddress(InetAddress.getByName('127.0.0.1'), arguments.port)
				serverChannel.socket.bind(socketAddress)
				serverChannel.register(socketSelector, SelectionKey.OP_ACCEPT)

				LOG.info('... success')
				var currentTimeout = arguments.initialTimeout
				var shutdown = false
				while (!shutdown) {
					LOG.info('Accepting connections...')
					try {
						socketSelector.select(currentTimeout)
						for (key : socketSelector.selectedKeys) {
							if (key.acceptable) {
								var SocketChannel socketChannel = null
								try {
									socketChannel = serverChannel.accept
									if (socketChannel == null) {
										LOG.info('No requests within ' + currentTimeout + 'ms.')
										shutdown = true
									} else {
										socketChannel.configureBlocking(true)
										currentTimeout = arguments.timeout
										shutdown = worker.serve(socketChannel)
									}
								} finally {
									socketChannel?.close
								}
							}
						}
					} catch (Exception exc) {
						LOG.error('Error during build', exc)
					}
				}
			} catch (Exception exc) {
				LOG.error('Error starting server socket', exc)
			}
			LOG.info('Shutting down')
			serverSocket?.close
		}
	}

	static class Worker {

		@Inject IncrementalStandaloneBuilder incrementalBuilder

		@Inject IBuildSessionSingletons.Impl singletons

		@Inject XtextBuildResultCollector xtextBuildResultCollector
		
		@Inject IIssueHandler issueHandler
		
		IndexState indexState

		ObjectChannel channel

		def boolean serve(SocketChannel socketChannel) {
			channel = new ObjectChannel(socketChannel)
			try {
				val msg = channel.readObject
				switch (msg) {
					BuildRequestMessage: {
						LOG.info('Received BuildRequest. Start build...')
						val buildResult = build(msg)
						LOG.info('...finished.')
						channel.writeObject(buildResult)
						LOG.info('Result sent.')
					}
				}
				return false
			} catch(Exception exc) {
				LOG.error('Build failed', exc)
				channel.writeObject(new BuildFailureMessage => [
					message = exc.message
				])
				return false
			}
		}

		def BuildResultMessage build(BuildRequestMessage request) {
			singletons => [
				objectChannel = channel
				moduleBaseURL = request.baseDir
			]
			val buildRequest = new BuildRequest => [
				baseDir = request.baseDir.asURI
				defaultEncoding = request.encoding
				classPath = request.classpath.map[asURI]
				outputs = request.outputs.map[asURI]
				sourceRoots = request.sourceRoots.map[asURI]
				dirtyFiles = request.dirtyFiles.map[asURI]
				deletedFiles = request.deletedFiles.map[asURI]
				failOnValidationError = false
				
				if (indexState != null) {
					previousState = indexState
				} else {
					isFullBuild = true
				}
				
				it.issueHandler = issueHandler
				
				afterGenerateFile = [ source, target |
					xtextBuildResultCollector.generatedFile2sourceURI.put(source,target)
				]
				afterDeleteFile = [ deleted |
					xtextBuildResultCollector.deletedFiles.add(deleted)
				]
			]
			indexState = incrementalBuilder.build(buildRequest, XtextLanguages.getLanguageAccesses)
			return xtextBuildResultCollector.buildResult
		}
	}
}