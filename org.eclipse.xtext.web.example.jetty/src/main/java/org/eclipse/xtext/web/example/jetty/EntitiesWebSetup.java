/*******************************************************************************
 * Copyright (c) 2015, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.example.jetty;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.web.example.entities.EntitiesRuntimeModule;
import org.eclipse.xtext.web.example.entities.EntitiesStandaloneSetup;
import org.eclipse.xtext.web.example.entities.ide.EntitiesIdeModule;
import org.eclipse.xtext.web.server.persistence.IResourceBaseProvider;

/**
 * Initialization support for running Xtext languages in web applications.
 */
public class EntitiesWebSetup extends EntitiesStandaloneSetup {

	private final IResourceBaseProvider resourceBaseProvider;

	public EntitiesWebSetup(IResourceBaseProvider resourceBaseProvider) {
		this.resourceBaseProvider = resourceBaseProvider;
	}

	@Override
	public Injector createInjector() {
		EntitiesWebModule webModule = new EntitiesWebModule(this.resourceBaseProvider);
		EntitiesRuntimeModule runtimeModule = new EntitiesRuntimeModule();
		EntitiesIdeModule ideModule = new EntitiesIdeModule();
		return Guice.createInjector(Modules2.mixin(runtimeModule, ideModule, webModule));
	}

}
