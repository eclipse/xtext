/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.testlanguage.server;

import com.google.inject.Guice;
import com.google.inject.Injector;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.Channels;
import java.nio.channels.CompletionHandler;
import org.eclipse.xtext.ide.server.ServerModule;
import org.eclipse.xtext.ide.tests.testlanguage.server.VSCodeJsonAdapter;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class SocketServerLauncher {
  public static void main(final String[] args) {
    AsynchronousServerSocketChannel serverSocket = null;
    try {
      ServerModule _serverModule = new ServerModule();
      final Injector injector = Guice.createInjector(_serverModule);
      final VSCodeJsonAdapter server = injector.<VSCodeJsonAdapter>getInstance(VSCodeJsonAdapter.class);
      PrintWriter _printWriter = new PrintWriter(System.err);
      server.setErrorLog(_printWriter);
      PrintWriter _printWriter_1 = new PrintWriter(System.out);
      server.setMessageLog(_printWriter_1);
      AsynchronousServerSocketChannel _open = AsynchronousServerSocketChannel.open();
      serverSocket = _open;
      final InetSocketAddress address = new InetSocketAddress("localhost", 5007);
      serverSocket.bind(address);
      InputOutput.<String>println(("Listening to " + address));
      serverSocket.<Object>accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {
        @Override
        public void completed(final AsynchronousSocketChannel channel, final Object attachment) {
          try {
            final InputStream in = Channels.newInputStream(channel);
            final OutputStream out = Channels.newOutputStream(channel);
            InputOutput.<String>println("Connection accepted");
            server.connect(in, out);
            server.start();
            server.join();
            channel.close();
            InputOutput.<String>println("Connection closed");
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
        
        @Override
        public void failed(final Throwable exc, final Object attachment) {
          exc.printStackTrace();
        }
      });
      while ((!server.isExitRequested())) {
        Thread.sleep(2000);
      }
    } catch (final Throwable _t) {
      if (_t instanceof Throwable) {
        final Throwable t = (Throwable)_t;
        t.printStackTrace();
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    } finally {
      if ((serverSocket != null)) {
        try {
          serverSocket.close();
        } catch (final Throwable _t_1) {
          if (_t_1 instanceof IOException) {
            final IOException e = (IOException)_t_1;
          } else {
            throw Exceptions.sneakyThrow(_t_1);
          }
        }
      }
    }
  }
}
