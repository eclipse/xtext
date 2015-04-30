/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.build.client;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;
import org.eclipse.xtext.idea.build.daemon.XtextBuildDaemon;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class DaemonConnector {
  private final static Logger LOG = Logger.getLogger(DaemonConnector.class);
  
  private final static String DAEMON_LOCK_FILE = ".xtext_build_daemon_port";
  
  private final static int DEFAULT_PORT = 8000;
  
  private boolean debug = false;
  
  public SocketChannel connect() {
    SocketChannel _xblockexpression = null;
    {
      final File portFile = new File(DaemonConnector.DAEMON_LOCK_FILE);
      try {
        boolean _exists = portFile.exists();
        if (_exists) {
          FileReader _fileReader = new FileReader(portFile);
          BufferedReader _bufferedReader = new BufferedReader(_fileReader);
          final String line = _bufferedReader.readLine();
          String _trim = line.trim();
          final int port = Integer.parseInt(_trim);
          SocketChannel socketChannel = SocketChannel.open();
          socketChannel.configureBlocking(true);
          InetAddress _byName = InetAddress.getByName("127.0.0.1");
          InetSocketAddress _inetSocketAddress = new InetSocketAddress(_byName, port);
          socketChannel.connect(_inetSocketAddress);
          return socketChannel;
        }
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
          final Exception exc = (Exception)_t;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      _xblockexpression = this.launch(portFile);
    }
    return _xblockexpression;
  }
  
  public SocketChannel launch(final File lockFile) {
    try {
      IntegerRange _upTo = new IntegerRange(DaemonConnector.DEFAULT_PORT, (DaemonConnector.DEFAULT_PORT + 10));
      for (final Integer port : _upTo) {
        {
          final RuntimeMXBean runtimeMxBean = ManagementFactory.getRuntimeMXBean();
          String _property = System.getProperty("java.home");
          String _plus = (_property + File.separator);
          String _plus_1 = (_plus + "bin");
          String _plus_2 = (_plus_1 + File.separator);
          final String java = (_plus_2 + "java");
          final LinkedHashSet<String> classpath = CollectionLiterals.<String>newLinkedHashSet();
          String _classPath = runtimeMxBean.getClassPath();
          String _quote = Pattern.quote(File.pathSeparator);
          String[] _split = _classPath.split(_quote);
          Iterables.<String>addAll(classpath, ((Iterable<? extends String>)Conversions.doWrapArray(_split)));
          Class<? extends DaemonConnector> _class = this.getClass();
          final ClassLoader classLoader = _class.getClassLoader();
          if ((classLoader instanceof URLClassLoader)) {
            URL[] _uRLs = ((URLClassLoader)classLoader).getURLs();
            final Procedure1<URL> _function = new Procedure1<URL>() {
              @Override
              public void apply(final URL it) {
                try {
                  String _protocol = it.getProtocol();
                  boolean _equals = Objects.equal(_protocol, "file");
                  if (_equals) {
                    URI _uRI = it.toURI();
                    File _file = new File(_uRI);
                    String _path = _file.getPath();
                    classpath.add(_path);
                  }
                } catch (Throwable _e) {
                  throw Exceptions.sneakyThrow(_e);
                }
              }
            };
            IterableExtensions.<URL>forEach(((Iterable<URL>)Conversions.doWrapArray(_uRLs)), _function);
          }
          final ArrayList<String> command = CollectionLiterals.<String>newArrayList();
          command.add(java);
          command.add("-cp");
          List<String> _list = IterableExtensions.<String>toList(classpath);
          List<String> _reverseView = ListExtensions.<String>reverseView(_list);
          String _join = IterableExtensions.join(_reverseView, File.pathSeparator);
          command.add(_join);
          List<String> _inputArguments = runtimeMxBean.getInputArguments();
          final Function1<String, Boolean> _function_1 = new Function1<String, Boolean>() {
            @Override
            public Boolean apply(final String it) {
              boolean _startsWith = it.startsWith("-agentlib");
              return Boolean.valueOf((!_startsWith));
            }
          };
          Iterable<String> _filter = IterableExtensions.<String>filter(_inputArguments, _function_1);
          Iterables.<String>addAll(command, _filter);
          if (this.debug) {
            command.add("-agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=5006");
          }
          String _canonicalName = XtextBuildDaemon.class.getCanonicalName();
          command.add(_canonicalName);
          command.add("-port");
          String _string = port.toString();
          command.add(_string);
          ProcessBuilder _processBuilder = new ProcessBuilder();
          ProcessBuilder _command = _processBuilder.command(command);
          final Process daemonProcess = _command.start();
          IntegerRange _upTo_1 = new IntegerRange(0, 200);
          for (final Integer i : _upTo_1) {
            try {
              SocketChannel socketChannel = SocketChannel.open();
              socketChannel.configureBlocking(true);
              InetAddress _byName = InetAddress.getByName("127.0.0.1");
              InetSocketAddress _inetSocketAddress = new InetSocketAddress(_byName, (port).intValue());
              socketChannel.connect(_inetSocketAddress);
              this.writeLockFile(lockFile, (port).intValue());
              return socketChannel;
            } catch (final Throwable _t) {
              if (_t instanceof ConnectException) {
                final ConnectException exc = (ConnectException)_t;
                Thread.sleep(100);
              } else {
                throw Exceptions.sneakyThrow(_t);
              }
            }
          }
          DaemonConnector.LOG.warn(("Failed to start daemon on port " + port));
          if (daemonProcess!=null) {
            daemonProcess.destroy();
          }
        }
      }
      return null;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void writeLockFile(final File lockFile, final int port) {
    try {
      FileWriter fileWriter = null;
      try {
        FileWriter _fileWriter = new FileWriter(lockFile);
        fileWriter = _fileWriter;
        String _string = Integer.valueOf(port).toString();
        fileWriter.write(_string);
        fileWriter.close();
      } catch (final Throwable _t) {
        if (_t instanceof IOException) {
          final IOException exc = (IOException)_t;
          DaemonConnector.LOG.error("Error wrting port file");
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      } finally {
        if (fileWriter!=null) {
          fileWriter.close();
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
