/*******************************************************************************
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests;

import org.eclipse.xtext.common.types.access.CachingClasspathTypeProviderFactory;
import org.eclipse.xtext.common.types.access.ClasspathTypeProviderFactory;
import org.eclipse.xtext.testing.GlobalRegistries;
import org.eclipse.xtext.testing.GlobalRegistries.GlobalStateMemento;
import org.eclipse.xtext.testing.IInjectorProvider;
import org.eclipse.xtext.testing.IRegistryConfigurator;
import org.eclipse.xtext.resource.SynchronizedXtextResourceSet;
import org.eclipse.xtext.xbase.annotations.XbaseWithAnnotationsRuntimeModule;
import org.eclipse.xtext.xbase.annotations.XbaseWithAnnotationsStandaloneSetup;
import org.eclipse.xtext.xbase.junit.SynchronizedXtextResourceSetProvider;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Provider;

/**
 * A test injector provider for XbaseWithAnnotations. 
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XbaseWithAnnotationsInjectorProvider implements IInjectorProvider, IRegistryConfigurator {

	protected GlobalStateMemento stateBeforeInjectorCreation;
	protected GlobalStateMemento stateAfterInjectorCreation;
	protected Injector injector;

	static {
		GlobalRegistries.initializeDefaults();
	}

	@Override
	public Injector getInjector() {
		if (injector == null) {
			stateBeforeInjectorCreation = GlobalRegistries.makeCopyOfGlobalState();
			this.injector = internalCreateInjector();
			stateAfterInjectorCreation = GlobalRegistries.makeCopyOfGlobalState();
		}
		return injector;
	}

	protected Injector internalCreateInjector() {
		return new XbaseWithAnnotationsTestStandaloneSetup().createInjectorAndDoEMFRegistration();
	}

	@Override
	public void restoreRegistry() {
		stateBeforeInjectorCreation.restoreGlobalState();
	}

	@Override
	public void setupRegistry() {
		getInjector();
		stateAfterInjectorCreation.restoreGlobalState();
	}

	public static class XbaseWithAnnotationsTestStandaloneSetup extends XbaseWithAnnotationsStandaloneSetup {

		@Override
		public Injector createInjector() {
			return Guice.createInjector(new XbaseWithAnnotationsTestRuntimeModule());
		}
	}

	public static class XbaseWithAnnotationsTestRuntimeModule extends XbaseWithAnnotationsRuntimeModule {
		@Override
		public ClassLoader bindClassLoaderToInstance() {
			return XbaseWithAnnotationsTestRuntimeModule.class.getClassLoader();
		}
		
		public Class<? extends ClasspathTypeProviderFactory> bindClasspathTypeProviderFactory() {
			return CachingClasspathTypeProviderFactory.class;
		}

		public Class<? extends Provider<SynchronizedXtextResourceSet>> provideSynchronizedResourceSet() {
			return SynchronizedXtextResourceSetProvider.class;
		}
	}
	
}
