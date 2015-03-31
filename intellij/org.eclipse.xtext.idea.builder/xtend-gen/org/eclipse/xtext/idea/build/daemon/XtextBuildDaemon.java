/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.build.daemon;

import com.google.common.base.Objects;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Category;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.TTCCLayout;
import org.eclipse.xtext.builder.standalone.LanguageAccess;
import org.eclipse.xtext.idea.build.daemon.BuildDaemonModule;
import org.eclipse.xtext.idea.build.daemon.IdeaStandaloneBuilder;
import org.eclipse.xtext.idea.build.daemon.Protocol;
import org.eclipse.xtext.idea.build.daemon.XtextBuildParameters;
import org.eclipse.xtext.idea.build.daemon.XtextBuildResultCollector;
import org.eclipse.xtext.idea.build.daemon.XtextLanguages;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtextBuildDaemon {
  public static class Arguments {
    private int port;
  }
  
  public static class Server {
    @Inject
    private Provider<XtextBuildDaemon.Worker> workerProvider;
    
    public void run(final XtextBuildDaemon.Arguments arguments) {
      try {
        ServerSocket serverSocket = null;
        try {
          XtextBuildDaemon.LOG.info((("Starting xtext build daemon at port " + Integer.valueOf(arguments.port)) + "..."));
          InetAddress _byName = InetAddress.getByName("127.0.0.1");
          ServerSocket _serverSocket = new ServerSocket(arguments.port, 0, _byName);
          serverSocket = _serverSocket;
          serverSocket.setSoTimeout(5000);
          boolean receivedRequests = false;
          XtextBuildDaemon.LOG.info("... success");
          boolean shutdown = false;
          while ((!shutdown)) {
            {
              XtextBuildDaemon.LOG.info("Accepting connections...");
              try {
                final Socket socket = serverSocket.accept();
                receivedRequests = true;
                XtextBuildDaemon.Worker _get = this.workerProvider.get();
                boolean _serve = _get.serve(socket);
                shutdown = _serve;
              } catch (final Throwable _t) {
                if (_t instanceof SocketTimeoutException) {
                  final SocketTimeoutException exc = (SocketTimeoutException)_t;
                  if ((!receivedRequests)) {
                    int _soTimeout = serverSocket.getSoTimeout();
                    String _plus = ("No requests within " + Integer.valueOf(_soTimeout));
                    String _plus_1 = (_plus + "ms.");
                    XtextBuildDaemon.LOG.info(_plus_1);
                    shutdown = true;
                  }
                } else {
                  throw Exceptions.sneakyThrow(_t);
                }
              }
            }
          }
        } catch (final Throwable _t) {
          if (_t instanceof Exception) {
            final Exception exc = (Exception)_t;
            XtextBuildDaemon.LOG.error("Error during build", exc);
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
        XtextBuildDaemon.LOG.info("Shutting down");
        if (serverSocket!=null) {
          serverSocket.close();
        }
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    }
  }
  
  public static class Worker {
    @Inject
    private IdeaStandaloneBuilder standaloneBuilder;
    
    @Inject
    private XtextBuildResultCollector resultCollector;
    
    public boolean serve(final Socket socket) {
      try {
        InputStream _inputStream = socket.getInputStream();
        final ObjectInputStream input = new ObjectInputStream(_inputStream);
        final Object msg = input.readObject();
        OutputStream _outputStream = socket.getOutputStream();
        final ObjectOutputStream output = new ObjectOutputStream(_outputStream);
        boolean _matched = false;
        if (!_matched) {
          if (msg instanceof Protocol.StopServer) {
            _matched=true;
            XtextBuildDaemon.LOG.info("Received StopServer");
            return true;
          }
        }
        if (!_matched) {
          if (msg instanceof Protocol.BuildRequest) {
            _matched=true;
            XtextBuildDaemon.LOG.info("Received BuildRequest. Start build...");
            final Protocol.BuildResult buildResult = this.build(((Protocol.BuildRequest)msg), output);
            XtextBuildDaemon.LOG.info("...finished.");
            output.writeObject(buildResult);
            XtextBuildDaemon.LOG.info("Result sent.");
          }
        }
        return false;
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    }
    
    public Protocol.BuildResult build(final Protocol.BuildRequest request, final ObjectOutputStream output) {
      Protocol.BuildResult _xblockexpression = null;
      {
        this.resultCollector.setOutput(output);
        final Procedure1<IdeaStandaloneBuilder> _function = new Procedure1<IdeaStandaloneBuilder>() {
          @Override
          public void apply(final IdeaStandaloneBuilder it) {
            it.setFailOnValidationError(false);
            Map<String, LanguageAccess> _languageAccesses = XtextLanguages.getLanguageAccesses();
            it.setLanguages(_languageAccesses);
            XtextBuildParameters _xtextBuildParameters = new XtextBuildParameters(request);
            it.setBuildData(_xtextBuildParameters);
            it.setBuildResultCollector(Worker.this.resultCollector);
            it.launch();
          }
        };
        ObjectExtensions.<IdeaStandaloneBuilder>operator_doubleArrow(
          this.standaloneBuilder, _function);
        _xblockexpression = this.resultCollector.getBuildResult();
      }
      return _xblockexpression;
    }
  }
  
  private final static Logger LOG = Logger.getLogger(XtextBuildDaemon.class);
  
  public static void main(final String[] args) {
    try {
      Category _parent = XtextBuildDaemon.LOG.getParent();
      TTCCLayout _tTCCLayout = new TTCCLayout();
      FileAppender _fileAppender = new FileAppender(_tTCCLayout, "xtext_builder_daemon.log", true);
      _parent.addAppender(_fileAppender);
      XtextBuildDaemon.LOG.setLevel(Level.INFO);
      BuildDaemonModule _buildDaemonModule = new BuildDaemonModule();
      final Injector injector = Guice.createInjector(_buildDaemonModule);
      XtextBuildDaemon.Server _instance = injector.<XtextBuildDaemon.Server>getInstance(XtextBuildDaemon.Server.class);
      XtextBuildDaemon.Arguments _parse = XtextBuildDaemon.parse(args);
      _instance.run(_parse);
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception exc = (Exception)_t;
        String _message = exc.getMessage();
        String _plus = ("Error " + _message);
        System.err.println(_plus);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  private static XtextBuildDaemon.Arguments parse(final String... args) {
    final XtextBuildDaemon.Arguments arguments = new XtextBuildDaemon.Arguments();
    final Iterator<String> i = ((List<String>)Conversions.doWrapArray(args)).iterator();
    while (i.hasNext()) {
      {
        final String arg = i.next();
        boolean _matched = false;
        if (!_matched) {
          if (Objects.equal(arg, "-port")) {
            _matched=true;
            String _next = i.next();
            int _parseInt = Integer.parseInt(_next);
            arguments.port = _parseInt;
          }
        }
        if (!_matched) {
          throw new IllegalArgumentException((("Invalid argument \'" + arg) + "\'"));
        }
      }
    }
    if ((arguments.port == 0)) {
      throw new IllegalArgumentException("Port number must be set");
    }
    return arguments;
  }
}
