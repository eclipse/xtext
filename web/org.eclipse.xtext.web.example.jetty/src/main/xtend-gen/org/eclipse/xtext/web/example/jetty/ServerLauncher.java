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
import org.eclipse.jetty.server.Server;
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
    try {
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
          it.setAttribute(WebInfConfiguration.CONTAINER_JAR_PATTERN, ".*org\\.eclipse\\.xtext\\.web.*");
        }
      };
      WebAppContext _doubleArrow = ObjectExtensions.<WebAppContext>operator_doubleArrow(_webAppContext, _function);
      server.setHandler(_doubleArrow);
      server.start();
      server.join();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
