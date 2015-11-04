/**
 * Copyright (c) 2010-2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.web;

import java.net.InetSocketAddress;
import java.net.URI;
import org.eclipse.jetty.annotations.AnnotationConfiguration;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.log.Slf4jLog;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.MetaInfConfiguration;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.webapp.WebInfConfiguration;
import org.eclipse.jetty.webapp.WebXmlConfiguration;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * This program starts an HTTP server for testing the web integration of your DSL.
 * Just execute it and point a web browser to http://localhost:8080/
 */
@SuppressWarnings("all")
public class ServerLauncher {
  public static void main(final String[] args) {
    InetSocketAddress _inetSocketAddress = new InetSocketAddress("localhost", 8080);
    final Server server = new Server(_inetSocketAddress);
    WebAppContext _webAppContext = new WebAppContext();
    final Procedure1<WebAppContext> _function = new Procedure1<WebAppContext>() {
      @Override
      public void apply(final WebAppContext it) {
        it.setResourceBase("src/main/webapp");
        it.setWelcomeFiles(new String[] { "index.html" });
        it.setContextPath("/");
        AnnotationConfiguration _annotationConfiguration = new AnnotationConfiguration();
        WebXmlConfiguration _webXmlConfiguration = new WebXmlConfiguration();
        WebInfConfiguration _webInfConfiguration = new WebInfConfiguration();
        MetaInfConfiguration _metaInfConfiguration = new MetaInfConfiguration();
        it.setConfigurations(new Configuration[] { _annotationConfiguration, _webXmlConfiguration, _webInfConfiguration, _metaInfConfiguration });
        it.setAttribute(WebInfConfiguration.CONTAINER_JAR_PATTERN, ".*/org\\.eclipse\\.xtend\\.web/.*,.*/org\\.eclipse\\.xtext\\.web.*,.*/org\\.webjars.*");
      }
    };
    WebAppContext _doubleArrow = ObjectExtensions.<WebAppContext>operator_doubleArrow(_webAppContext, _function);
    server.setHandler(_doubleArrow);
    String _name = ServerLauncher.class.getName();
    final Slf4jLog log = new Slf4jLog(_name);
    try {
      server.start();
      URI _uRI = server.getURI();
      String _plus = ("Server started " + _uRI);
      String _plus_1 = (_plus + "...");
      log.info(_plus_1);
      final Runnable _function_1 = new Runnable() {
        @Override
        public void run() {
          try {
            log.info("Press enter to stop the server...");
            final int key = System.in.read();
            if ((key != (-1))) {
              server.stop();
            } else {
              log.warn("Console input is not available. In order to stop the server, you need to cancel process manually.");
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
