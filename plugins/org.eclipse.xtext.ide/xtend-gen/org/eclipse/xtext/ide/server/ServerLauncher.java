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
import io.typefox.lsapi.services.json.LanguageServerProtocol;
import io.typefox.lsapi.services.json.LanguageServerToJsonAdapter;
import io.typefox.lsapi.services.json.MessageMethods;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.concurrent.atomic.AtomicBoolean;
import org.eclipse.xtext.ide.server.LanguageServerImpl;
import org.eclipse.xtext.ide.server.ServerModule;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class ServerLauncher {
  private static boolean IS_DEBUG = false;
  
  public static void main(final String[] args) {
    final Function1<String, Boolean> _function = new Function1<String, Boolean>() {
      @Override
      public Boolean apply(final String it) {
        return Boolean.valueOf(Objects.equal(it, "debug"));
      }
    };
    boolean _exists = IterableExtensions.<String>exists(((Iterable<String>)Conversions.doWrapArray(args)), _function);
    ServerLauncher.IS_DEBUG = _exists;
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
      this.redirectStandardStreams();
      System.err.println("Starting Xtext Language Server.");
      final LanguageServerToJsonAdapter messageAcceptor = new LanguageServerToJsonAdapter(this.languageServer) {
        @Override
        protected void _doAccept(final NotificationMessage message) {
          if (ServerLauncher.IS_DEBUG) {
            InputOutput.<NotificationMessage>println(message);
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
          if (ServerLauncher.IS_DEBUG) {
            InputOutput.<String>println(("response : " + resultValue));
          }
          super.sendResponse(responseId, resultValue);
        }
        
        @Override
        protected void sendNotification(final String methodId, final Object parameter) {
          if (ServerLauncher.IS_DEBUG) {
            InputOutput.<String>println(("id" + methodId));
            InputOutput.<String>println(("notification : " + parameter));
          }
          super.sendNotification(methodId, parameter);
        }
        
        @Override
        protected void sendResponseError(final String responseId, final String errorMessage, final int errorCode, final Object errorData) {
          if (ServerLauncher.IS_DEBUG) {
            InputOutput.<String>println(("id" + responseId));
            InputOutput.<String>println(("error : " + errorMessage));
          }
          super.sendResponseError(responseId, errorMessage, errorCode, errorData);
        }
      };
      LanguageServerProtocol _protocol = messageAcceptor.getProtocol();
      final Procedure2<String, Throwable> _function = new Procedure2<String, Throwable>() {
        @Override
        public void apply(final String p1, final Throwable p2) {
          p2.printStackTrace(System.err);
        }
      };
      _protocol.addErrorListener(_function);
      messageAcceptor.connect(stdin, stdout);
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
  
  public void redirectStandardStreams() {
    try {
      byte[] _newByteArrayOfSize = new byte[0];
      ByteArrayInputStream _byteArrayInputStream = new ByteArrayInputStream(_newByteArrayOfSize);
      System.setIn(_byteArrayInputStream);
      String _name = ServerLauncher.class.getName();
      String _plus = (_name + "-");
      long _currentTimeMillis = System.currentTimeMillis();
      final String id = (_plus + Long.valueOf(_currentTimeMillis));
      if (ServerLauncher.IS_DEBUG) {
        final FileOutputStream stdFileOut = new FileOutputStream((("out-" + id) + ".log"));
        PrintStream _printStream = new PrintStream(stdFileOut);
        System.setOut(_printStream);
        final FileOutputStream stdFileErr = new FileOutputStream((("error-" + id) + ".log"));
        PrintStream _printStream_1 = new PrintStream(stdFileErr);
        System.setErr(_printStream_1);
      } else {
        ByteArrayOutputStream _byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream _printStream_2 = new PrintStream(_byteArrayOutputStream);
        System.setOut(_printStream_2);
        ByteArrayOutputStream _byteArrayOutputStream_1 = new ByteArrayOutputStream();
        PrintStream _printStream_3 = new PrintStream(_byteArrayOutputStream_1);
        System.setErr(_printStream_3);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
