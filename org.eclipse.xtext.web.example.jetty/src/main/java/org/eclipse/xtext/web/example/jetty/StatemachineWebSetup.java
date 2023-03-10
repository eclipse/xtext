/*******************************************************************************
 * Copyright (c) 2015, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.web.example.jetty;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.web.example.statemachine.StatemachineRuntimeModule;
import org.eclipse.xtext.web.example.statemachine.StatemachineStandaloneSetup;
import org.eclipse.xtext.web.example.statemachine.ide.StatemachineIdeModule;
import org.eclipse.xtext.web.server.persistence.IResourceBaseProvider;

/**
 * Initialization support for running Xtext languages in web applications.
 */
public class StatemachineWebSetup extends StatemachineStandaloneSetup {

	private IResourceBaseProvider resourceBaseProvider;

	public StatemachineWebSetup(IResourceBaseProvider resourceBaseProvider) {
		this.resourceBaseProvider = resourceBaseProvider;
	}

	@Override
	public Injector createInjector() {
		StatemachineWebModule webModule = new StatemachineWebModule(this.resourceBaseProvider);
		StatemachineRuntimeModule runtimeModule = new StatemachineRuntimeModule();
		StatemachineIdeModule ideModule = new StatemachineIdeModule();
		return Guice.createInjector(Modules2.mixin(runtimeModule, ideModule, webModule));
	}

}
