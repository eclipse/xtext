/**
 * Copyright (c) 2016, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.java.tests;

import com.google.inject.Injector;
import org.eclipse.xtext.java.JavaSourceLanguageSetup;
import org.eclipse.xtext.testing.IInjectorProvider;
import org.eclipse.xtext.testing.IRegistryConfigurator;

public class JavaInjectorProvider implements IInjectorProvider, IRegistryConfigurator {
	private final JavaSourceLanguageSetup setup = new JavaSourceLanguageSetup();

	private Injector injector;

	@Override
	public Injector getInjector() {
		if (injector == null) {
			injector = setup.createInjector();
		}
		return injector;
	}

	@Override
	public void restoreRegistry() {
	}

	@Override
	public void setupRegistry() {
		setup.register(getInjector(), "txt");
		setup.register(getInjector(), "java");
	}
}
