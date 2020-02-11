/*******************************************************************************
 * Copyright (c) 2019 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
 
package org.eclipse.xtext.ide.server

import com.google.inject.Guice
import java.io.PrintWriter
import java.net.InetSocketAddress
import java.nio.channels.AsynchronousServerSocketChannel
import java.nio.channels.Channels
import org.eclipse.lsp4j.jsonrpc.Launcher
import org.eclipse.lsp4j.services.LanguageClient
import org.eclipse.xtext.ide.server.LanguageServerImpl
import org.eclipse.xtext.ide.server.ServerModule
import org.eclipse.xtext.util.internal.Log
import com.google.inject.Module

/**
 * Allows to launch a language server vie a server socket.
 * 
 * Useful for debugging live language servers.
 * 
 * @author Jan K&ouml;hnlein - Initial contribution and API
 * @since 2.18
 */
@Log
class SocketServerLauncher {

	public static val HOST = '-host'
	public static val PORT = '-port'
	public static val TRACE = '-trace'
	public static val NO_VALIDATE = '-noValidate'

	public static val DEFAULT_PORT = 5008
	public static val DEFAULT_HOST = '0.0.0.0'

	def static void main(String[] args) {
		new SocketServerLauncher().launch(args)
	}

	def void launch(String[] args) {
		try {
			val injector = Guice.createInjector(serverModule)
			val serverSocket = AsynchronousServerSocketChannel.open.bind(args.socketAddress)
			LOG.info("Started server socket at " + args.socketAddress)
			while (true) {
				val socketChannel = serverSocket.accept.get
				val in = Channels.newInputStream(socketChannel)
				val out = Channels.newOutputStream(socketChannel)
				val trace = args.trace
				val validate = args.shouldValidate
				val languageServer = injector.getInstance(LanguageServerImpl)
				LOG.info("Starting Xtext Language Server for client " + socketChannel.remoteAddress)
				val launcher = Launcher.createLauncher(languageServer, LanguageClient, in, out, validate, trace)
				languageServer.connect(launcher.remoteProxy)
				launcher.startListening
				LOG.info("Xtext Language Server has been started.")
			}
		} catch (Throwable throwable) {
			throwable.printStackTrace()
		}
	}

	protected def Module getServerModule() {
		new ServerModule
	}

	protected def PrintWriter getTrace(String... args) {
		if (args.contains(TRACE))
			new PrintWriter(System.out)
	}

	protected def boolean shouldValidate(String... args) {
		!args.contains(NO_VALIDATE)
	}

	protected def InetSocketAddress getSocketAddress(String... args) {
		new InetSocketAddress(args.host, args.port)
	}

	protected def String getHost(String... args) {
		args.getValue(HOST) ?: DEFAULT_HOST
	}

	protected def int getPort(String... args) {
		Integer.getInteger(args.getValue(PORT)) ?: DEFAULT_PORT
	}

	protected def String getValue(String[] args, String argName) {
		for (var i = 0; i < args.length - 1; i++) {
			if (args.get(i) == argName)
				return args.get(i + 1)
		}
		return null
	}
}
