/*******************************************************************************
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.testlanguage.server;

import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.nio.channels.Channels;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

import org.eclipse.lsp4j.jsonrpc.Launcher;
import org.eclipse.lsp4j.launch.LSPLauncher;
import org.eclipse.lsp4j.services.LanguageClient;
import org.eclipse.lsp4j.services.LanguageServer;
import org.eclipse.xtext.ide.server.ServerModule;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author kosyakov - Initial contribution and API
 */
public class SocketServerLauncher {

	public static void main(String[] args) throws Exception {
		Injector injector = Guice.createInjector(new ServerModule());
		LanguageServer languageServer = injector.getInstance(LanguageServer.class);
		ServerSocketChannel serverSocket = ServerSocketChannel.open();
		serverSocket.bind(new InetSocketAddress("localhost", 5007));
		SocketChannel socketChannel = serverSocket.accept();
		Launcher<LanguageClient> launcher = LSPLauncher.createServerLauncher(languageServer, Channels.newInputStream(socketChannel), Channels.newOutputStream(socketChannel), true, new PrintWriter(System.out));
		launcher.startListening().get();
	}

}
