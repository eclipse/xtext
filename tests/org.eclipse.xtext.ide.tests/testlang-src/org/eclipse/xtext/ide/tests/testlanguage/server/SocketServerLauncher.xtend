/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.testlanguage.server

import com.google.inject.Guice
import java.io.IOException
import java.io.PrintWriter
import java.net.InetSocketAddress
import java.nio.channels.AsynchronousServerSocketChannel
import java.nio.channels.AsynchronousSocketChannel
import java.nio.channels.Channels
import java.nio.channels.CompletionHandler
import org.eclipse.xtext.ide.server.ServerModule

/**
 * @author kosyakov - Initial contribution and API
 */
class SocketServerLauncher {

	def static void main(String[] args) {
		var AsynchronousServerSocketChannel serverSocket
		try {
			val injector = Guice.createInjector(new ServerModule)
			val server = injector.getInstance(VSCodeJsonAdapter)
			server.errorLog = new PrintWriter(System.err)
			server.messageLog = new PrintWriter(System.out)

			serverSocket = AsynchronousServerSocketChannel.open

			val address = new InetSocketAddress('localhost', 5007)
			serverSocket.bind(address)
			println('Listening to ' + address)
			serverSocket.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {

				override completed(AsynchronousSocketChannel channel, Object attachment) {
					val in = Channels.newInputStream(channel)
					val out = Channels.newOutputStream(channel)
					println('Connection accepted')

					server.connect(in, out)
					server.start()
					server.join()

					channel.close()
					println('Connection closed')
				}

				override failed(Throwable exc, Object attachment) {
					exc.printStackTrace
				}

			})
			while (!server.exitRequested) {
				Thread.sleep(2000)
			}
		} catch (Throwable t) {
			t.printStackTrace()
		} finally {
			if (serverSocket !== null) {
				try {
					serverSocket.close()
				} catch (IOException e) {
				}
			}
		}
	}

}
