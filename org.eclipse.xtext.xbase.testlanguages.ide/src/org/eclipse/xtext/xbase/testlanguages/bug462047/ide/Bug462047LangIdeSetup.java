/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.testlanguages.bug462047.ide;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.xbase.testlanguages.bug462047.Bug462047LangRuntimeModule;
import org.eclipse.xtext.xbase.testlanguages.bug462047.Bug462047LangStandaloneSetup;

/**
 * Initialization support for running Xtext languages as language servers.
 */
public class Bug462047LangIdeSetup extends Bug462047LangStandaloneSetup {

	@Override
	public Injector createInjector() {
		return Guice.createInjector(Modules2.mixin(new Bug462047LangRuntimeModule(), new Bug462047LangIdeModule()));
	}
	
}
