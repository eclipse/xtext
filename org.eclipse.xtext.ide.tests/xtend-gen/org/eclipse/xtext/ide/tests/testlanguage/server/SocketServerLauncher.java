/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.testlanguage.server;

import com.google.inject.Guice;
import com.google.inject.Injector;
import java.io.InputStream;
import java.io.OutputStream;
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
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class SocketServerLauncher {
  public static void main(final String[] args) {
    try {
      ServerModule _serverModule = new ServerModule();
      final Injector injector = Guice.createInjector(_serverModule);
      final LanguageServer languageServer = injector.<LanguageServer>getInstance(LanguageServer.class);
      final ServerSocketChannel serverSocket = ServerSocketChannel.open();
      InetSocketAddress _inetSocketAddress = new InetSocketAddress("localhost", 5007);
      serverSocket.bind(_inetSocketAddress);
      final SocketChannel socketChannel = serverSocket.accept();
      InputStream _newInputStream = Channels.newInputStream(socketChannel);
      OutputStream _newOutputStream = Channels.newOutputStream(socketChannel);
      PrintWriter _printWriter = new PrintWriter(System.out);
      final Launcher<LanguageClient> launcher = LSPLauncher.createServerLauncher(languageServer, _newInputStream, _newOutputStream, true, _printWriter);
      launcher.startListening().get();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
