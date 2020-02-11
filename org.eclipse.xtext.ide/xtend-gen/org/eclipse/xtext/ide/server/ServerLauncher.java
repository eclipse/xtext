/**
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
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
import org.eclipse.xtext.ide.server.LaunchArgs;
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
  public static final String LOG = "-log";
  
  public static final String TRACE = "-trace";
  
  public static final String NO_VALIDATE = "-noValidate";
  
  public static void main(final String[] args) {
    String _name = ServerLauncher.class.getName();
    ServerModule _serverModule = new ServerModule();
    ServerLauncher.launch(_name, args, _serverModule);
  }
  
  public static void launch(final String prefix, final String[] args, final com.google.inject.Module... modules) {
    final LaunchArgs launchArgs = ServerLauncher.createLaunchArgs(prefix, args);
    final ServerLauncher launcher = Guice.createInjector(modules).<ServerLauncher>getInstance(ServerLauncher.class);
    launcher.start(launchArgs);
  }
  
  @Inject
  private LanguageServerImpl languageServer;
  
  public void start(final LaunchArgs it) {
    try {
      InputOutput.<String>println("Xtext Language Server is starting.");
      final Launcher<LanguageClient> launcher = Launcher.<LanguageClient>createLauncher(this.languageServer, LanguageClient.class, it.getIn(), it.getOut(), it.isValidate(), it.getTrace());
      this.languageServer.connect(launcher.getRemoteProxy());
      final Future<Void> future = launcher.startListening();
      InputOutput.<String>println("Xtext Language Server has been started.");
      while ((!future.isDone())) {
        Thread.sleep(10_000l);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static LaunchArgs createLaunchArgs(final String prefix, final String[] args) {
    final LaunchArgs launchArgs = new LaunchArgs();
    launchArgs.setIn(System.in);
    launchArgs.setOut(System.out);
    ServerLauncher.redirectStandardStreams(prefix, args);
    launchArgs.setTrace(ServerLauncher.getTrace(args));
    launchArgs.setValidate(ServerLauncher.shouldValidate(args));
    return launchArgs;
  }
  
  public static PrintWriter getTrace(final String[] args) {
    boolean _shouldTrace = ServerLauncher.shouldTrace(args);
    if (_shouldTrace) {
      return ServerLauncher.createTrace();
    }
    return null;
  }
  
  public static PrintWriter createTrace() {
    return new PrintWriter(System.out);
  }
  
  public static void redirectStandardStreams(final String prefix, final String[] args) {
    boolean _shouldLogStandardStreams = ServerLauncher.shouldLogStandardStreams(args);
    if (_shouldLogStandardStreams) {
      ServerLauncher.logStandardStreams(prefix);
    } else {
      ServerLauncher.silentStandardStreams();
    }
  }
  
  public static boolean shouldValidate(final String[] args) {
    boolean _testArg = ServerLauncher.testArg(args, ServerLauncher.NO_VALIDATE);
    return (!_testArg);
  }
  
  public static boolean shouldTrace(final String[] args) {
    return ServerLauncher.testArg(args, ServerLauncher.TRACE);
  }
  
  public static boolean shouldLogStandardStreams(final String[] args) {
    return ServerLauncher.testArg(args, ServerLauncher.LOG, "debug");
  }
  
  public static boolean testArg(final String[] args, final String... values) {
    final Function1<String, Boolean> _function = (String arg) -> {
      return Boolean.valueOf(ServerLauncher.testArg(arg, values));
    };
    return IterableExtensions.<String>exists(((Iterable<String>)Conversions.doWrapArray(args)), _function);
  }
  
  public static boolean testArg(final String arg, final String... values) {
    final Function1<String, Boolean> _function = (String value) -> {
      return Boolean.valueOf(Objects.equal(value, arg));
    };
    return IterableExtensions.<String>exists(((Iterable<String>)Conversions.doWrapArray(values)), _function);
  }
  
  public static void logStandardStreams(final String prefix) {
    try {
      final FileOutputStream stdFileOut = new FileOutputStream((prefix + "-debug.log"));
      ServerLauncher.redirectStandardStreams(stdFileOut);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static void silentStandardStreams() {
    ServerLauncher.redirectStandardStreams(ServerLauncher.silentOut());
  }
  
  public static void redirectStandardStreams(final OutputStream out) {
    ServerLauncher.redirectStandardStreams(ServerLauncher.silentIn(), out);
  }
  
  public static void redirectStandardStreams(final InputStream in, final OutputStream out) {
    System.setIn(in);
    PrintStream _printStream = new PrintStream(out);
    System.setOut(_printStream);
  }
  
  public static OutputStream silentOut() {
    return ByteStreams.nullOutputStream();
  }
  
  public static InputStream silentIn() {
    byte[] _newByteArrayOfSize = new byte[0];
    return new ByteArrayInputStream(_newByteArrayOfSize);
  }
}
