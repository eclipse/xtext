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
import org.eclipse.xtext.web.example.statemachine.StatemachineRuntimeModule
import org.eclipse.xtext.web.example.statemachine.StatemachineStandaloneSetup
import org.eclipse.xtext.web.server.persistence.ResourceBaseProviderImpl
import org.eclipse.xtext.web.servlet.XtextServlet
import org.eclipse.xtext.xbase.ide.DefaultXbaseIdeModule

@WebServlet(name = "Xtext Services", urlPatterns = "/xtext-service/*")
class MyXtextServlet extends XtextServlet {
	
	val List<ExecutorService> executorServices = newArrayList

	override init() {
		super.init()
		val Provider<ExecutorService> executorServiceProvider = [Executors.newCachedThreadPool => [executorServices += it]]
		val resourceBaseProvider = new ResourceBaseProviderImpl('./test-files')
		new StatemachineStandaloneSetup {
			override createInjector() {
				val runtimeModule = new StatemachineRuntimeModule
				val webModule = new StatemachineWebModule(executorServiceProvider)
				webModule.resourceBaseProvider = resourceBaseProvider
				return Guice.createInjector(Modules2.mixin(runtimeModule, webModule))
			}
		}.createInjectorAndDoEMFRegistration
		new EntitiesStandaloneSetup {
			override createInjector() {
				val runtimeModule = new EntitiesRuntimeModule
				val ideModule = new DefaultXbaseIdeModule
				val webModule = new EntitiesWebModule(executorServiceProvider)
				webModule.resourceBaseProvider = resourceBaseProvider
				return Guice.createInjector(Modules2.mixin(runtimeModule, ideModule, webModule))
			}
		}.createInjectorAndDoEMFRegistration
	}
	
	override destroy() {
		executorServices.forEach[shutdown()]
		executorServices.clear()
		super.destroy()
	}

}