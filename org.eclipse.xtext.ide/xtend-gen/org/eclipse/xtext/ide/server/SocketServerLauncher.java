/**
 * Copyright (c) 2019 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.server;

import com.google.common.base.Objects;
import com.google.inject.Guice;
import com.google.inject.Injector;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.Channels;
import org.apache.log4j.Logger;
import org.eclipse.lsp4j.jsonrpc.Launcher;
import org.eclipse.lsp4j.services.LanguageClient;
import org.eclipse.xtext.ide.server.LanguageServerImpl;
import org.eclipse.xtext.ide.server.ServerModule;
import org.eclipse.xtext.util.internal.Log;
import org.eclipse.xtext.xbase.lib.ArrayExtensions;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * Allows to launch a language server vie a server socket.
 * 
 * Useful for debugging live language servers.
 * 
 * @author Jan K&ouml;hnlein - Initial contribution and API
 * @since 2.18
 */
@Log
@SuppressWarnings("all")
public class SocketServerLauncher {
  public static final String HOST = "-host";
  
  public static final String PORT = "-port";
  
  public static final String TRACE = "-trace";
  
  public static final String NO_VALIDATE = "-noValidate";
  
  public static final int DEFAULT_PORT = 5008;
  
  public static final String DEFAULT_HOST = "0.0.0.0";
  
  public static void main(final String[] args) {
    new SocketServerLauncher().launch(args);
  }
  
  public void launch(final String[] args) {
    try {
      final Injector injector = Guice.createInjector(this.getServerModule());
      final AsynchronousServerSocketChannel serverSocket = AsynchronousServerSocketChannel.open().bind(this.getSocketAddress(args));
      InetSocketAddress _socketAddress = this.getSocketAddress(args);
      String _plus = ("Started server socket at " + _socketAddress);
      SocketServerLauncher.LOG.info(_plus);
      while (true) {
        {
          final AsynchronousSocketChannel socketChannel = serverSocket.accept().get();
          final InputStream in = Channels.newInputStream(socketChannel);
          final OutputStream out = Channels.newOutputStream(socketChannel);
          final PrintWriter trace = this.getTrace(args);
          final boolean validate = this.shouldValidate(args);
          final LanguageServerImpl languageServer = injector.<LanguageServerImpl>getInstance(LanguageServerImpl.class);
          SocketAddress _remoteAddress = socketChannel.getRemoteAddress();
          String _plus_1 = ("Starting Xtext Language Server for client " + _remoteAddress);
          SocketServerLauncher.LOG.info(_plus_1);
          final Launcher<LanguageClient> launcher = Launcher.<LanguageClient>createLauncher(languageServer, LanguageClient.class, in, out, validate, trace);
          languageServer.connect(launcher.getRemoteProxy());
          launcher.startListening();
          SocketServerLauncher.LOG.info("Xtext Language Server has been started.");
        }
      }
    } catch (final Throwable _t) {
      if (_t instanceof Throwable) {
        final Throwable throwable = (Throwable)_t;
        throwable.printStackTrace();
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  protected com.google.inject.Module getServerModule() {
    return new ServerModule();
  }
  
  protected PrintWriter getTrace(final String... args) {
    PrintWriter _xifexpression = null;
    boolean _contains = ArrayExtensions.contains(args, SocketServerLauncher.TRACE);
    if (_contains) {
      _xifexpression = new PrintWriter(System.out);
    }
    return _xifexpression;
  }
  
  protected boolean shouldValidate(final String... args) {
    boolean _contains = ArrayExtensions.contains(args, SocketServerLauncher.NO_VALIDATE);
    return (!_contains);
  }
  
  protected InetSocketAddress getSocketAddress(final String... args) {
    String _host = this.getHost(args);
    int _port = this.getPort(args);
    return new InetSocketAddress(_host, _port);
  }
  
  protected String getHost(final String... args) {
    String _elvis = null;
    String _value = this.getValue(args, SocketServerLauncher.HOST);
    if (_value != null) {
      _elvis = _value;
    } else {
      _elvis = SocketServerLauncher.DEFAULT_HOST;
    }
    return _elvis;
  }
  
  protected int getPort(final String... args) {
    Integer _elvis = null;
    Integer _integer = Integer.getInteger(this.getValue(args, SocketServerLauncher.PORT));
    if (_integer != null) {
      _elvis = _integer;
    } else {
      _elvis = Integer.valueOf(SocketServerLauncher.DEFAULT_PORT);
    }
    return (int) _elvis;
  }
  
  protected String getValue(final String[] args, final String argName) {
    for (int i = 0; (i < (args.length - 1)); i++) {
      String _get = args[i];
      boolean _equals = Objects.equal(_get, argName);
      if (_equals) {
        return args[(i + 1)];
      }
    }
    return null;
  }
  
  private static final Logger LOG = Logger.getLogger(SocketServerLauncher.class);
}
