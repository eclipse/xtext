/*******************************************************************************
 * Copyright (c) 2010, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist.ide;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.eclipse.xtext.ui.tests.editor.contentassist.Bug304681TestLanguageRuntimeModule;
import org.eclipse.xtext.ui.tests.editor.contentassist.Bug304681TestLanguageStandaloneSetup;
import org.eclipse.xtext.util.Modules2;

/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
public class Bug304681TestLanguageIdeSetup extends Bug304681TestLanguageStandaloneSetup {

	@Override
	public Injector createInjector() {
		return Guice.createInjector(Modules2.mixin(new Bug304681TestLanguageRuntimeModule(), new Bug304681TestLanguageIdeModule()));
	}
}
