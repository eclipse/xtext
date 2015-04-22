/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.example.jetty

import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.InetSocketAddress
import org.eclipse.jetty.server.Server
import org.eclipse.jetty.server.handler.DefaultHandler
import org.eclipse.jetty.server.handler.HandlerList
import org.eclipse.jetty.server.handler.ResourceHandler
import org.eclipse.jetty.servlet.ServletContextHandler
import org.eclipse.jetty.servlet.ServletHolder

class ServerLauncher {
	
	def static void main(String[] args) {
		try {
			val launcher = new ServerLauncher
			val server = launcher.createServer
		    server.start()
		    
		    new Thread[
		    	val reader = new BufferedReader(new InputStreamReader(System.in))
		    	var line = reader.readLine
		    	while (launcher.processCommand(line)) {
		    		line = reader.readLine
	    		}
		    ].start
		    server.join()
		} catch (Exception exception) {
			exception.printStackTrace
			System.exit(1)
		}
	}
	
	Server server
	
	def createServer() {
		server = new Server(new InetSocketAddress('localhost', 8080))
	
		val mainResourceHandler = new ResourceHandler => [
			resourceBase = 'src/main/webapp'
			welcomeFiles = #["index.html"]
			directoriesListed = false
		]
	
		val xtextResourceHandler = new ResourceHandler => [
			resourceBase = '../org.eclipse.xtext.web/src/main/webapp'
			directoriesListed = false
		]
		
		val contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS) => [
			contextPath = "/"
			addServlet(new ServletHolder(new MyXtextServlet), "/xtext-service/*")
		]
		
		val handlers = new HandlerList => [
			setHandlers(newArrayList(mainResourceHandler, xtextResourceHandler, contextHandler, new DefaultHandler))
		]
		server.setHandler(handlers)
		return server
	}
	
	private def processCommand(String command) {
		switch (command) {
			case 'quit': {
				server.stop
				return false
			}
			default: {
				System.err.println('-- unknown command')
			}
		}
		return true
	}
	
}