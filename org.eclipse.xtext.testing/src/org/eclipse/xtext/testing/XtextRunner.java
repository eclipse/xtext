/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.testing;

import org.eclipse.xtext.testing.internal.InjectorProviders;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;

import com.google.inject.Injector;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class XtextRunner extends BlockJUnit4ClassRunner {
	public XtextRunner(Class<?> klass) throws InitializationError {
		super(klass);
	}

	@Override
	protected Object createTest() throws Exception {
		Object object = super.createTest();
		IInjectorProvider injectorProvider = getOrCreateInjectorProvider();
		if (injectorProvider != null) {
			Injector injector = injectorProvider.getInjector();
			if (injector != null)
				injector.injectMembers(object);
		}
		return object;
	}

	@Override
	protected Statement methodBlock(FrameworkMethod method) {
		IInjectorProvider injectorProvider = getOrCreateInjectorProvider();
		if (injectorProvider instanceof IRegistryConfigurator) {
			final IRegistryConfigurator registryConfigurator = (IRegistryConfigurator) injectorProvider;
			registryConfigurator.setupRegistry();
			final Statement methodBlock = superMethodBlock(method);
			return new Statement() {
				@Override
				public void evaluate() throws Throwable {
					try {
						methodBlock.evaluate();
					} finally {
						registryConfigurator.restoreRegistry();
					}
				}
			};
		}else{
			return superMethodBlock(method);
		}
	}

	/**
	 * @since 2.7
	 */
	protected Statement superMethodBlock(FrameworkMethod method) {
		return super.methodBlock(method);
	}

	protected IInjectorProvider getOrCreateInjectorProvider() {
		return InjectorProviders.getOrCreateInjectorProvider(getTestClass());
	}

	protected IInjectorProvider getInjectorProvider() {
		return InjectorProviders.getInjectorProvider(getTestClass());
	}

	protected IInjectorProvider createInjectorProvider() {
		return InjectorProviders.createInjectorProvider(getTestClass());
	}

}
