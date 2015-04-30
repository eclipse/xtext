/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.example.jetty

import com.google.inject.Guice
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import javax.servlet.annotation.WebServlet
import org.eclipse.xtext.idea.example.entities.EntitiesRuntimeModule
import org.eclipse.xtext.idea.example.entities.EntitiesStandaloneSetup
import org.eclipse.xtext.web.server.persistence.ResourceBaseProviderImpl
import org.eclipse.xtext.web.servlet.XtextServlet

@WebServlet(name = "Xtext Services", urlPatterns = "/xtext-service/*")
class MyXtextServlet extends XtextServlet {
	
	ExecutorService executorService

	override init() {
		super.init()
		executorService = Executors.newCachedThreadPool
		new EntitiesStandaloneSetup {
			override createInjector() {
				val runtimeModule = new EntitiesRuntimeModule
				val webModule = new EntitiesWebModule(executorService, new ResourceBaseProviderImpl('./test-files'))
				return Guice.createInjector(runtimeModule, webModule)
			}
		}.createInjectorAndDoEMFRegistration
	}
	
	override destroy() {
		if (executorService !== null)
			executorService.shutdown()
		executorService = null
		super.destroy()
	}

}