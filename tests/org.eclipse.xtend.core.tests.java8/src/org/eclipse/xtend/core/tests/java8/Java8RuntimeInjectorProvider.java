/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.java8;

import org.eclipse.xtend.core.tests.RuntimeInjectorProvider;
import org.eclipse.xtend.core.tests.RuntimeTestSetup;
import org.eclipse.xtext.util.JavaVersion;
import org.eclipse.xtext.xbase.compiler.JavaVersionModule;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Miro Spoenemann - Initial contribution and API
 */
public class Java8RuntimeInjectorProvider extends RuntimeInjectorProvider {
	
	@Override
	protected Injector internalCreateInjector() {
		return new RuntimeTestSetup() {
			
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new XtendRuntimeTestModule() {
					@Override
					public ClassLoader bindClassLoaderToInstance() {
						return Java8RuntimeInjectorProvider.class.getClassLoader();
					}
				}, new JavaVersionModule(JavaVersion.JAVA8));
			}
			
		}.createInjectorAndDoEMFRegistration();
	}
	
}
