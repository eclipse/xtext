/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server;

import com.google.common.base.Objects;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import io.typefox.lsapi.NotificationMessage;
import io.typefox.lsapi.json.LanguageServerToJsonAdapter;
import io.typefox.lsapi.json.MessageMethods;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.log4j.Logger;
import org.eclipse.xtext.ide.server.LanguageServerImpl;
import org.eclipse.xtext.ide.server.ServerModule;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class ServerLauncher {
  private final Logger LOG = Logger.getLogger(ServerLauncher.class);
  
  public static void main(final String[] args) {
    ServerModule _serverModule = new ServerModule();
    Injector _createInjector = Guice.createInjector(_serverModule);
    final ServerLauncher launcher = _createInjector.<ServerLauncher>getInstance(ServerLauncher.class);
    launcher.start();
  }
  
  @Inject
  private LanguageServerImpl languageServer;
  
  private final AtomicBoolean hasExitNotification = new AtomicBoolean(false);
  
  public void start() {
    try {
      final InputStream stdin = System.in;
      final PrintStream stdout = System.out;
      byte[] _newByteArrayOfSize = new byte[0];
      ByteArrayInputStream _byteArrayInputStream = new ByteArrayInputStream(_newByteArrayOfSize);
      System.setIn(_byteArrayInputStream);
      FileOutputStream _fileOutputStream = new FileOutputStream("out.log");
      PrintStream _printStream = new PrintStream(_fileOutputStream);
      System.setOut(_printStream);
      System.err.println("Starting Xtext Language Server.");
      final LanguageServerToJsonAdapter messageAcceptor = new LanguageServerToJsonAdapter(this.languageServer) {
        @Override
        protected void _doAccept(final NotificationMessage message) {
          boolean _isDebugEnabled = ServerLauncher.this.LOG.isDebugEnabled();
          if (_isDebugEnabled) {
            ServerLauncher.this.LOG.debug(message);
          }
          String _method = message.getMethod();
          boolean _equals = Objects.equal(_method, MessageMethods.EXIT);
          if (_equals) {
            ServerLauncher.this.hasExitNotification.set(true);
          }
          super._doAccept(message);
        }
        
        @Override
        protected void sendResponse(final String responseId, final Object resultValue) {
          boolean _isDebugEnabled = ServerLauncher.this.LOG.isDebugEnabled();
          if (_isDebugEnabled) {
            ServerLauncher.this.LOG.debug(("response : " + resultValue));
          }
          super.sendResponse(responseId, resultValue);
        }
        
        @Override
        protected void sendNotification(final String methodId, final Object parameter) {
          boolean _isDebugEnabled = ServerLauncher.this.LOG.isDebugEnabled();
          if (_isDebugEnabled) {
            ServerLauncher.this.LOG.debug(("id" + methodId));
            ServerLauncher.this.LOG.debug(("notification : " + parameter));
          }
          super.sendNotification(methodId, parameter);
        }
        
        @Override
        protected void sendResponseError(final String responseId, final String errorMessage, final int errorCode, final Object errorData) {
          boolean _isDebugEnabled = ServerLauncher.this.LOG.isDebugEnabled();
          if (_isDebugEnabled) {
            ServerLauncher.this.LOG.debug(("id" + responseId));
            ServerLauncher.this.LOG.debug(("error : " + errorMessage));
          }
          super.sendResponseError(responseId, errorMessage, errorCode, errorData);
        }
      };
      messageAcceptor.connect(stdin, stdout);
      messageAcceptor.start();
      System.err.println("started.");
      messageAcceptor.join();
      while ((!this.hasExitNotification.get())) {
        Thread.sleep(10000l);
      }
      System.err.println("Exit notification received. Good Bye!");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
