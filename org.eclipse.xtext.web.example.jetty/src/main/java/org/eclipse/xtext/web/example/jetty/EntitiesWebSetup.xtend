/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.example.jetty

import com.google.inject.Guice
import com.google.inject.Injector
import com.google.inject.Provider
import java.util.concurrent.ExecutorService
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.util.Modules2
import org.eclipse.xtext.web.example.entities.EntitiesRuntimeModule
import org.eclipse.xtext.web.example.entities.EntitiesStandaloneSetup
import org.eclipse.xtext.web.example.entities.ide.EntitiesIdeModule
import org.eclipse.xtext.web.server.persistence.IResourceBaseProvider

/**
 * Initialization support for running Xtext languages in web applications.
 */
@FinalFieldsConstructor
class EntitiesWebSetup extends EntitiesStandaloneSetup {
	
	val Provider<ExecutorService> executorServiceProvider;
	val IResourceBaseProvider resourceBaseProvider
	
	override Injector createInjector() {
		val runtimeModule = new EntitiesRuntimeModule()
		val ideModule = new EntitiesIdeModule(executorServiceProvider)
		val webModule = new EntitiesWebModule(executorServiceProvider, resourceBaseProvider)
		return Guice.createInjector(Modules2.mixin(runtimeModule, ideModule, webModule))
	}
	
}
