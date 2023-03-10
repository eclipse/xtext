/*******************************************************************************
 * Copyright (c) 2015, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.web.example.entities.ide;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.web.example.entities.EntitiesRuntimeModule;
import org.eclipse.xtext.web.example.entities.EntitiesStandaloneSetup;

/**
 * Initialization support for running Xtext languages as language servers.
 */
public class EntitiesIdeSetup extends EntitiesStandaloneSetup {

	@Override
	public Injector createInjector() {
		return Guice.createInjector(Modules2.mixin(new EntitiesRuntimeModule(), new EntitiesIdeModule()));
	}
	
}
