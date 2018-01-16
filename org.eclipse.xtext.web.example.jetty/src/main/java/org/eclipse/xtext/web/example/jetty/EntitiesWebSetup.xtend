/*******************************************************************************
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.example.jetty

import com.google.inject.Guice
import com.google.inject.Injector
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
	
	val IResourceBaseProvider resourceBaseProvider
	
	override Injector createInjector() {
		val webModule = new EntitiesWebModule(resourceBaseProvider)
		return Guice.createInjector(Modules2.mixin(new EntitiesRuntimeModule, new EntitiesIdeModule, webModule))
	}
	
}
