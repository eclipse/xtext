/*******************************************************************************
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.web.example.jetty;

import java.net.InetSocketAddress;
import org.eclipse.jetty.annotations.AnnotationConfiguration;
import org.eclipse.jetty.rewrite.handler.RewriteHandler;
import org.eclipse.jetty.rewrite.handler.RewriteRegexRule;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.MetaInfConfiguration;
import org.eclipse.jetty.webapp.WebAppConfiguration;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.webapp.WebInfConfiguration;
import org.eclipse.jetty.webapp.WebXmlConfiguration;

public class ServerLauncher {

	private static final Logger LOG = LoggerFactory.getLogger(ServerLauncher.class);
	
	public static void main(String[] args) {
		Server server = new Server(new InetSocketAddress("localhost", 8080));
		RewriteHandler rewriteHandler = new RewriteHandler();
		server.setHandler(rewriteHandler);
		RewriteRegexRule rule = new RewriteRegexRule();
		rule.setRegex("/xtext/@xtext-version-placeholder@/(.*)");
		rule.setReplacement("/xtext/$1");
		rule.setTerminating(false);
		rewriteHandler.addRule(rule);
		HandlerList handlerList = new HandlerList();
		ResourceHandler resourceHandler1 = new ResourceHandler();
		resourceHandler1.setResourceBase("src/main/webapp");
		resourceHandler1.setWelcomeFiles(new String[] { "index.html" });
		ResourceHandler resourceHandler2 = new ResourceHandler();
		resourceHandler2.setResourceBase("../org.eclipse.xtext.web/src/main/css");
		WebAppContext webAppContext = new WebAppContext();
		webAppContext.setResourceBase("../org.eclipse.xtext.web/src/main/js");
		webAppContext.setContextPath("/");
		webAppContext.setConfigurations(new Configuration[] { new AnnotationConfiguration(), new WebXmlConfiguration(),
				new WebInfConfiguration(), new MetaInfConfiguration(), new WebAppConfiguration() });
		webAppContext.setAttribute(MetaInfConfiguration.CONTAINER_JAR_PATTERN,
				".*/org\\.eclipse\\.xtext\\.web.*,.*/org.webjars.*");

		handlerList.setHandlers(new Handler[] { resourceHandler1, resourceHandler2, webAppContext });
		rewriteHandler.setHandler(handlerList);
		try {
			server.start();
			LOG.info("Server started " + server.getURI() + "...");
			new Thread() {

				public void run() {
					try {
						LOG.info("Press enter to stop the server...");
						int key = System.in.read();
						if (key != -1) {
							server.stop();
						} else {
							LOG.warn(
									"Console input is not available. In order to stop the server, you need to cancel process manually.");
						}
					} catch (Exception e) {
						LOG.warn(e.getMessage());
					}
				}
			}.start();
			server.join();
		} catch (Exception exception) {
			LOG.warn(exception.getMessage());
			System.exit(1);
		}
	}

}
