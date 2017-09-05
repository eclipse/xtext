/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.purexbase.test;

import org.eclipse.xtext.purexbase.PureXbaseStandaloneSetup;
import org.eclipse.xtext.purexbase.tests.PureXbaseInjectorProvider;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class RuntimeInjectorProvider extends PureXbaseInjectorProvider {

	@Override
	protected Injector internalCreateInjector() {
		return new PureXbaseStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new org.eclipse.xtext.purexbase.PureXbaseRuntimeModule() {
					@Override
					public ClassLoader bindClassLoaderToInstance() {
						return RuntimeInjectorProvider.class.getClassLoader();
					}
				});
			}
		}.createInjectorAndDoEMFRegistration();
	}
	
}
