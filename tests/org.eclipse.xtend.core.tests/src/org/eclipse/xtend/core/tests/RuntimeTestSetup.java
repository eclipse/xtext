/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtend.core.XtendRuntimeModule;
import org.eclipse.xtend.core.XtendStandaloneSetup;
import org.eclipse.xtend.core.scoping.XtendScopeProvider;
import org.eclipse.xtend.core.xtend.XtendFactory;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.access.CachingClasspathTypeProviderFactory;
import org.eclipse.xtext.common.types.access.ClasspathTypeProviderFactory;
import org.eclipse.xtext.preferences.IPreferenceValuesProvider;
import org.eclipse.xtext.preferences.IPreferenceValuesProvider.SingletonPreferenceValuesProvider;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("deprecation")
public class RuntimeTestSetup extends XtendStandaloneSetup {

	@Override
	public Injector createInjector() {
		return Guice.createInjector(new XtendRuntimeTestModule());
	}
	
	/**
	 * @author Sebastian Zarnekow - Initial contribution and API
	 */
	public static class XtendRuntimeTestModule extends XtendRuntimeModule {
		@Override
		public ClassLoader bindClassLoaderToInstance() {
			return RuntimeTestSetup.class.getClassLoader();
		}

		public XtendFactory bindFactory() {
			return XtendFactory.eINSTANCE;
		}

		public Class<? extends ClasspathTypeProviderFactory> bindClasspathTypeProviderFactory() {
			return CachingClasspathTypeProviderFactory.class;
		}

		public Class<? extends IPreferenceValuesProvider> bindIPreferenceValuesProvider() {
			return SingletonPreferenceValuesProvider.class;
		}

		@Override
		public Class<? extends IScopeProvider> bindIScopeProvider() {
			return DisabledXtendScopeProvider.class;
		}
	}

	public static class DisabledXtendScopeProvider extends XtendScopeProvider {
		@Deprecated
		@Override
		public IScope getScope(EObject context, EReference reference) {
			if (TypesPackage.Literals.JVM_TYPE == reference.getEReferenceType()) {
				return super.getScope(context, reference);
			}
			throw new UnsupportedOperationException();
		}
	}
}