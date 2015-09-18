/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.example.jetty;

import java.net.InetSocketAddress;
import org.eclipse.jetty.annotations.AnnotationConfiguration;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.util.log.Slf4jLog;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.MetaInfConfiguration;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.webapp.WebInfConfiguration;
import org.eclipse.jetty.webapp.WebXmlConfiguration;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class ServerLauncher {
  public static void main(final String[] args) {
    InetSocketAddress _inetSocketAddress = new InetSocketAddress("localhost", 8080);
    final Server server = new Server(_inetSocketAddress);
    HandlerList _handlerList = new HandlerList();
    final Procedure1<HandlerList> _function = new Procedure1<HandlerList>() {
      @Override
      public void apply(final HandlerList it) {
        ResourceHandler _resourceHandler = new ResourceHandler();
        final Procedure1<ResourceHandler> _function = new Procedure1<ResourceHandler>() {
          @Override
          public void apply(final ResourceHandler it) {
            it.setResourceBase("src/main/webapp");
            it.setWelcomeFiles(new String[] { "index.html" });
          }
        };
        ResourceHandler _doubleArrow = ObjectExtensions.<ResourceHandler>operator_doubleArrow(_resourceHandler, _function);
        ResourceHandler _resourceHandler_1 = new ResourceHandler();
        final Procedure1<ResourceHandler> _function_1 = new Procedure1<ResourceHandler>() {
          @Override
          public void apply(final ResourceHandler it) {
            it.setResourceBase("../org.eclipse.xtext.web/src/main/css");
          }
        };
        ResourceHandler _doubleArrow_1 = ObjectExtensions.<ResourceHandler>operator_doubleArrow(_resourceHandler_1, _function_1);
        WebAppContext _webAppContext = new WebAppContext();
        final Procedure1<WebAppContext> _function_2 = new Procedure1<WebAppContext>() {
          @Override
          public void apply(final WebAppContext it) {
            it.setResourceBase("../org.eclipse.xtext.web/src/main/js");
            it.setContextPath("/");
            AnnotationConfiguration _annotationConfiguration = new AnnotationConfiguration();
            WebXmlConfiguration _webXmlConfiguration = new WebXmlConfiguration();
            WebInfConfiguration _webInfConfiguration = new WebInfConfiguration();
            MetaInfConfiguration _metaInfConfiguration = new MetaInfConfiguration();
            it.setConfigurations(new Configuration[] { _annotationConfiguration, _webXmlConfiguration, _webInfConfiguration, _metaInfConfiguration });
            it.setAttribute(WebInfConfiguration.CONTAINER_JAR_PATTERN, 
              ".*/org\\.eclipse\\.xtext\\.web.*,.*/org.webjars.*");
          }
        };
        WebAppContext _doubleArrow_2 = ObjectExtensions.<WebAppContext>operator_doubleArrow(_webAppContext, _function_2);
        it.setHandlers(new Handler[] { _doubleArrow, _doubleArrow_1, _doubleArrow_2 });
      }
    };
    HandlerList _doubleArrow = ObjectExtensions.<HandlerList>operator_doubleArrow(_handlerList, _function);
    server.setHandler(_doubleArrow);
    String _name = ServerLauncher.class.getName();
    final Slf4jLog log = new Slf4jLog(_name);
    try {
      server.start();
      log.info("Press enter to stop the server...");
      final Runnable _function_1 = new Runnable() {
        @Override
        public void run() {
          try {
            final int key = System.in.read();
            server.stop();
            if ((key == (-1))) {
              log.warn("The standard input stream is empty.");
            }
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
      Thread _thread = new Thread(_function_1);
      _thread.start();
      server.join();
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception exception = (Exception)_t;
        String _message = exception.getMessage();
        log.warn(_message);
        System.exit(1);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
}
