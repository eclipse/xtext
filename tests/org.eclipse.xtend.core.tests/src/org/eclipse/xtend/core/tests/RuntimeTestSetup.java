/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests;

import org.eclipse.xtend.core.XtendRuntimeModule;
import org.eclipse.xtend.core.XtendStandaloneSetup;
import org.eclipse.xtend.core.xtend.XtendFactory;
import org.eclipse.xtext.common.types.access.CachingClasspathTypeProviderFactory;
import org.eclipse.xtext.common.types.access.ClasspathTypeProviderFactory;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RuntimeTestSetup extends XtendStandaloneSetup {

	@Override
	public Injector createInjector() {
		return Guice.createInjector(new XtendRuntimeModule() {
			@Override
			public ClassLoader bindClassLoaderToInstance() {
				return RuntimeTestSetup.class.getClassLoader();
			}

			@SuppressWarnings("unused")
			public XtendFactory bindFactory() {
				return XtendFactory.eINSTANCE;
			}
			
			@SuppressWarnings("unused")
			public Class<? extends ClasspathTypeProviderFactory> bindClasspathTypeProviderFactory() {
				return CachingClasspathTypeProviderFactory.class;
			}
		});
	}
}