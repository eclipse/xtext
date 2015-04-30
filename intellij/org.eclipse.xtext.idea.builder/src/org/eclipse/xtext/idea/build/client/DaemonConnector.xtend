/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.build.client

import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.FileWriter
import java.io.IOException
import java.lang.management.ManagementFactory
import java.net.ConnectException
import java.net.InetAddress
import java.net.InetSocketAddress
import java.net.URLClassLoader
import java.nio.channels.SocketChannel
import java.util.regex.Pattern
import org.apache.log4j.Logger
import org.eclipse.xtext.idea.build.daemon.XtextBuildDaemon

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class DaemonConnector {

	static val LOG = Logger.getLogger(DaemonConnector)

	static val DAEMON_LOCK_FILE = ".xtext_build_daemon_port"

	static val DEFAULT_PORT = 8000

	boolean debug = false

	def SocketChannel connect() {
		val portFile = new File(DaemonConnector.DAEMON_LOCK_FILE)
		try {
			if (portFile.exists) {
				val line = new BufferedReader(new FileReader(portFile)).readLine
				val port = Integer.parseInt(line.trim)
				var socketChannel = SocketChannel.open() 
				socketChannel.configureBlocking(true)
				socketChannel.connect(new InetSocketAddress(InetAddress.getByName('127.0.0.1'), port))
				return socketChannel
			}
		} catch (Exception exc) {
			// ignore and launch new process
		}
		launch(portFile)
	}

	def launch(File lockFile) {
		for (port : DEFAULT_PORT .. DEFAULT_PORT + 10) {
			val runtimeMxBean = ManagementFactory.runtimeMXBean
			val java = System.getProperty('java.home') + File.separator + 'bin' + File.separator + 'java'
			val classpath = <String>newLinkedHashSet
			classpath += runtimeMxBean.classPath.split(Pattern.quote(File.pathSeparator))
			val classLoader = class.classLoader
			if (classLoader instanceof URLClassLoader) {
				classLoader.URLs.forEach [
					if (protocol == 'file')
						classpath += new File(toURI).path
				]
			}
			val command = newArrayList
			command += java
			command += '-cp'
			command += classpath.toList.reverseView.join(File.pathSeparator)
			command += runtimeMxBean.inputArguments.filter [
				!startsWith('-agentlib')
			]
			if (debug) {
				command += '-agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=5006'
			}
			command += XtextBuildDaemon.canonicalName
			command += '-port'
			command += port.toString
			val daemonProcess = new ProcessBuilder().command(command).start
			for (i : 0 .. 200) {
				try {
					var socketChannel = SocketChannel.open() 
					socketChannel.configureBlocking(true)
					socketChannel.connect(new InetSocketAddress(InetAddress.getByName('127.0.0.1'), port))
					writeLockFile(lockFile, port)
					return socketChannel
				} catch (ConnectException exc) {
					Thread.sleep(100)
				}
			}
			LOG.warn('Failed to start daemon on port ' + port)
			daemonProcess?.destroy
		}
	}

	protected def writeLockFile(File lockFile, int port) {
		var FileWriter fileWriter = null
		try {
			fileWriter = new FileWriter(lockFile)
			fileWriter.write(port.toString)
			fileWriter.close
		} catch (IOException exc) {
			LOG.error('Error wrting port file')
		} finally {
			fileWriter?.close
		}
	}
}