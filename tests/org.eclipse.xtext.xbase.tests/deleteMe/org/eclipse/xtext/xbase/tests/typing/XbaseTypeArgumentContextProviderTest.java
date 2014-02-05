/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typing;

import org.eclipse.xtext.common.types.tests.ClasspathBasedModule;
import org.eclipse.xtext.common.types.util.TypeArgumentContextProvider;
import org.eclipse.xtext.common.types.util.TypeArgumentContextProviderTest;
import org.eclipse.xtext.xbase.typing.XbaseTypeArgumentContextProvider;
import org.eclipse.xtext.xtype.XtypeFactory;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("deprecation")
public class XbaseTypeArgumentContextProviderTest extends TypeArgumentContextProviderTest {

	@Override
	protected Injector createInjector() {
		Injector injector = Guice.createInjector(new ClasspathBasedModule() {
			@Override
			public ClassLoader bindClassloader() {
				return XbaseTypeArgumentContextProviderTest.class.getClassLoader();
			}
			@SuppressWarnings("unused")
			public Class<? extends TypeArgumentContextProvider> bindTypeArgumentContextProvider() {
				return XbaseTypeArgumentContextProvider.class;
			}
			@SuppressWarnings("unused")
			public XtypeFactory bindXtypeFactory() {
				return XtypeFactory.eINSTANCE;
			}
		});
		return injector;
	}
	
}
