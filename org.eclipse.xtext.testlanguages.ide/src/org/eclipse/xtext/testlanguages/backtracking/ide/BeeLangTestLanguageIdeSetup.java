/*******************************************************************************
 * Copyright (c) 2010, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.testlanguages.backtracking.ide;

import org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguageRuntimeModule;
import org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguageStandaloneSetup;
import org.eclipse.xtext.util.Modules2;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
public class BeeLangTestLanguageIdeSetup extends BeeLangTestLanguageStandaloneSetup {

	@Override
	public Injector createInjector() {
		return Guice.createInjector(Modules2.mixin(new BeeLangTestLanguageRuntimeModule(), new BeeLangTestLanguageIdeModule()));
	}
}
