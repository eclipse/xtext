/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.example.jetty

import com.google.inject.Guice
import com.google.inject.Provider
import java.util.List
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import javax.servlet.annotation.WebServlet
import org.eclipse.xtext.idea.example.entities.EntitiesRuntimeModule
import org.eclipse.xtext.idea.example.entities.EntitiesStandaloneSetup
import org.eclipse.xtext.util.Modules2
import org.eclipse.xtext.web.server.persistence.ResourceBaseProviderImpl
import org.eclipse.xtext.web.servlet.XtextServlet

@WebServlet(name = "Xtext Services", urlPatterns = "/xtext-service/*")
class MyXtextServlet extends XtextServlet {
	
	val List<ExecutorService> executorServices = newArrayList

	override init() {
		super.init()
		val Provider<ExecutorService> executorServiceProvider = [Executors.newCachedThreadPool => [executorServices += it]]
		val resourceBaseProvider = new ResourceBaseProviderImpl('./test-files')
		new StatemachineWebSetup(executorServiceProvider, resourceBaseProvider).createInjectorAndDoEMFRegistration
		new EntitiesStandaloneSetup {
			override createInjector() {
				val runtimeModule = new EntitiesRuntimeModule
				val webModule = new EntitiesWebModule(executorServiceProvider, resourceBaseProvider)
				return Guice.createInjector(Modules2.mixin(runtimeModule, webModule))
			}
		}.createInjectorAndDoEMFRegistration
	}
	
	override destroy() {
		executorServices.forEach[shutdown()]
		executorServices.clear()
		super.destroy()
	}

}