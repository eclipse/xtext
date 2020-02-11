/*******************************************************************************
 * Copyright (c) 2012, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
