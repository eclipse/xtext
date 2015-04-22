/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.example.jetty;

import com.google.common.base.Objects;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.xtext.web.example.jetty.MyXtextServlet;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class ServerLauncher {
  public static void main(final String[] args) {
    try {
      final ServerLauncher launcher = new ServerLauncher();
      final Server server = launcher.createServer();
      server.start();
      final Runnable _function = new Runnable() {
        @Override
        public void run() {
          try {
            InputStreamReader _inputStreamReader = new InputStreamReader(System.in);
            final BufferedReader reader = new BufferedReader(_inputStreamReader);
            String line = reader.readLine();
            while (launcher.processCommand(line)) {
              String _readLine = reader.readLine();
              line = _readLine;
            }
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
      Thread _thread = new Thread(_function);
      _thread.start();
      server.join();
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception exception = (Exception)_t;
        exception.printStackTrace();
        System.exit(1);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  private Server server;
  
  public Server createServer() {
    InetSocketAddress _inetSocketAddress = new InetSocketAddress("localhost", 8080);
    Server _server = new Server(_inetSocketAddress);
    this.server = _server;
    ResourceHandler _resourceHandler = new ResourceHandler();
    final Procedure1<ResourceHandler> _function = new Procedure1<ResourceHandler>() {
      @Override
      public void apply(final ResourceHandler it) {
        it.setResourceBase("src/main/webapp");
        it.setWelcomeFiles(new String[] { "index.html" });
        it.setDirectoriesListed(false);
      }
    };
    final ResourceHandler mainResourceHandler = ObjectExtensions.<ResourceHandler>operator_doubleArrow(_resourceHandler, _function);
    ResourceHandler _resourceHandler_1 = new ResourceHandler();
    final Procedure1<ResourceHandler> _function_1 = new Procedure1<ResourceHandler>() {
      @Override
      public void apply(final ResourceHandler it) {
        it.setResourceBase("../org.eclipse.xtext.web/src/main/webapp");
        it.setDirectoriesListed(false);
      }
    };
    final ResourceHandler xtextResourceHandler = ObjectExtensions.<ResourceHandler>operator_doubleArrow(_resourceHandler_1, _function_1);
    ServletContextHandler _servletContextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
    final Procedure1<ServletContextHandler> _function_2 = new Procedure1<ServletContextHandler>() {
      @Override
      public void apply(final ServletContextHandler it) {
        it.setContextPath("/");
        MyXtextServlet _myXtextServlet = new MyXtextServlet();
        ServletHolder _servletHolder = new ServletHolder(_myXtextServlet);
        it.addServlet(_servletHolder, "/xtext-service/*");
      }
    };
    final ServletContextHandler contextHandler = ObjectExtensions.<ServletContextHandler>operator_doubleArrow(_servletContextHandler, _function_2);
    HandlerList _handlerList = new HandlerList();
    final Procedure1<HandlerList> _function_3 = new Procedure1<HandlerList>() {
      @Override
      public void apply(final HandlerList it) {
        DefaultHandler _defaultHandler = new DefaultHandler();
        ArrayList<Handler> _newArrayList = CollectionLiterals.<Handler>newArrayList(mainResourceHandler, xtextResourceHandler, contextHandler, _defaultHandler);
        it.setHandlers(((Handler[])Conversions.unwrapArray(_newArrayList, Handler.class)));
      }
    };
    final HandlerList handlers = ObjectExtensions.<HandlerList>operator_doubleArrow(_handlerList, _function_3);
    this.server.setHandler(handlers);
    return this.server;
  }
  
  private boolean processCommand(final String command) {
    try {
      boolean _matched = false;
      if (!_matched) {
        if (Objects.equal(command, "quit")) {
          _matched=true;
          this.server.stop();
          return false;
        }
      }
      System.err.println("-- unknown command");
      return true;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
