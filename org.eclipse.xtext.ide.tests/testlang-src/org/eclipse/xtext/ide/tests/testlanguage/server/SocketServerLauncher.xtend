/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.testlanguage.server

import com.google.inject.Guice
import java.io.PrintWriter
import java.net.InetSocketAddress
import java.nio.channels.Channels
import java.nio.channels.ServerSocketChannel
import org.eclipse.lsp4j.launch.LSPLauncher
import org.eclipse.lsp4j.services.LanguageServer
import org.eclipse.xtext.ide.server.ServerModule

/**
 * @author kosyakov - Initial contribution and API
 */
class SocketServerLauncher {

	def static void main(String[] args) {
		val injector = Guice.createInjector(new ServerModule)
		val languageServer = injector.getInstance(LanguageServer)
		val serverSocket = ServerSocketChannel.open()
		serverSocket.bind(new InetSocketAddress('localhost', 5007));
		val socketChannel = serverSocket.accept()
		val launcher = LSPLauncher.createServerLauncher(languageServer, Channels.newInputStream(socketChannel), Channels.newOutputStream(socketChannel), true, new PrintWriter(System.out));
		launcher.startListening.get
	}

}
