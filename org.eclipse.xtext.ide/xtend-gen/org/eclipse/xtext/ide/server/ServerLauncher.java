/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server;

import com.google.common.base.Objects;
import com.google.common.io.ByteStreams;
import com.google.inject.Guice;
import com.google.inject.Inject;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.concurrent.Future;
import org.eclipse.lsp4j.jsonrpc.Launcher;
import org.eclipse.lsp4j.services.LanguageClient;
import org.eclipse.xtext.ide.server.LanguageServerImpl;
import org.eclipse.xtext.ide.server.ServerModule;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.11
 */
@SuppressWarnings("all")
public class ServerLauncher {
  public final static String OPTION_PREFIX = "-Dorg.eclipse.xtext.ide.server.";
  
  public final static String LOG_STANDARD_STREAMS = (ServerLauncher.OPTION_PREFIX + "logStandardStreams");
  
  public static void main(final String[] args) {
    final InputStream stdin = System.in;
    final PrintStream stdout = System.out;
    ServerLauncher.redirectStandardStreams(args);
    ServerModule _serverModule = new ServerModule();
    final ServerLauncher launcher = Guice.createInjector(_serverModule).<ServerLauncher>getInstance(ServerLauncher.class);
    launcher.start(stdin, stdout);
  }
  
  @Inject
  private LanguageServerImpl languageServer;
  
  public void start(final InputStream in, final OutputStream out) {
    try {
      InputOutput.<String>println("Starting Xtext Language Server.");
      PrintWriter _printWriter = new PrintWriter(System.out);
      final Launcher<LanguageClient> launcher = Launcher.<LanguageClient>createLauncher(this.languageServer, LanguageClient.class, in, out, true, _printWriter);
      this.languageServer.connect(launcher.getRemoteProxy());
      final Future<?> future = launcher.startListening();
      InputOutput.<String>println("started.");
      while ((!future.isDone())) {
        Thread.sleep(10_000l);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static void redirectStandardStreams(final String[] args) {
    ServerLauncher.redirectStandardStreams(ServerLauncher.class.getName(), args);
  }
  
  public static void redirectStandardStreams(final String prefix, final String[] args) {
    boolean _shouldLogStandardStreams = ServerLauncher.shouldLogStandardStreams(args);
    if (_shouldLogStandardStreams) {
      ServerLauncher.logStandardStreams(prefix);
    } else {
      ServerLauncher.silentStandardStreams();
    }
  }
  
  public static boolean shouldLogStandardStreams(final String[] args) {
    final Function1<String, Boolean> _function = (String it) -> {
      return Boolean.valueOf(ServerLauncher.shouldLogStandardStreams(it));
    };
    return IterableExtensions.<String>exists(((Iterable<String>)Conversions.doWrapArray(args)), _function);
  }
  
  public static boolean shouldLogStandardStreams(final String arg) {
    return (Objects.equal(arg, ServerLauncher.LOG_STANDARD_STREAMS) || Objects.equal(arg, "debug"));
  }
  
  public static void logStandardStreams(final String prefix) {
    try {
      final FileOutputStream stdFileOut = new FileOutputStream((prefix + "-debug.log"));
      final FileOutputStream stdFileErr = new FileOutputStream((prefix + "-error.log"));
      ServerLauncher.redirectStandardStreams(stdFileOut, stdFileErr);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static void silentStandardStreams() {
    ServerLauncher.redirectStandardStreams(ServerLauncher.silentOut(), ServerLauncher.silentOut());
  }
  
  public static void redirectStandardStreams(final OutputStream out, final OutputStream err) {
    ServerLauncher.redirectStandardStreams(ServerLauncher.silentIn(), out, err);
  }
  
  public static void redirectStandardStreams(final InputStream in, final OutputStream out, final OutputStream err) {
    System.setIn(in);
    PrintStream _printStream = new PrintStream(out);
    System.setOut(_printStream);
    PrintStream _printStream_1 = new PrintStream(err);
    System.setErr(_printStream_1);
  }
  
  public static OutputStream silentOut() {
    return ByteStreams.nullOutputStream();
  }
  
  public static InputStream silentIn() {
    byte[] _newByteArrayOfSize = new byte[0];
    return new ByteArrayInputStream(_newByteArrayOfSize);
  }
}
