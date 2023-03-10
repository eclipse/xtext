/*******************************************************************************
 * Copyright (c) 2010, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.ecore2xtext.ide;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.xtext.ui.ecore2xtext.Ecore2XtextTestRuntimeModule;
import org.eclipse.xtext.xtext.ui.ecore2xtext.Ecore2XtextTestStandaloneSetup;

/**
 * Initialization support for running Xtext languages as language servers.
 */
public class Ecore2XtextTestIdeSetup extends Ecore2XtextTestStandaloneSetup {

	@Override
	public Injector createInjector() {
		return Guice.createInjector(Modules2.mixin(new Ecore2XtextTestRuntimeModule(), new Ecore2XtextTestIdeModule()));
	}
	
}
