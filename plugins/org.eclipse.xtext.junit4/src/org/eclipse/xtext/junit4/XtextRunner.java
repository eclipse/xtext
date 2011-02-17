/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.junit4;

import java.util.Map;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;

import com.google.common.collect.Maps;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class XtextRunner extends BlockJUnit4ClassRunner {
	private static Map<Class<?>, IInjectorProvider> injectorProviderClassCache = Maps.newHashMap();

	public XtextRunner(Class<?> klass) throws InitializationError {
		super(klass);
	}

	@Override
	protected Object createTest() throws Exception {
		Object object = super.createTest();
		IInjectorProvider injectorProvider = getOrCreateInjectorProvider();
		if (injectorProvider != null && injectorProvider.getInjector() != null) {
			injectorProvider.getInjector().injectMembers(object);
		}
		return object;
	}

	@Override
	protected Statement methodBlock(FrameworkMethod method) {
		final Statement methodBlock = super.methodBlock(method);
		if (getInjectorProvider() instanceof IRegistryConfigurator) {
			return new Statement() {
				@Override
				public void evaluate() throws Throwable {
					IRegistryConfigurator registryConfigurator = (IRegistryConfigurator) getInjectorProvider();
					registryConfigurator.setupRegistry();
					try {
						methodBlock.evaluate();
					} finally {
						registryConfigurator.restoreRegistry();
					}
				}
			};
		}
		return methodBlock;
	}

	protected IInjectorProvider getOrCreateInjectorProvider() throws Exception {
		IInjectorProvider injectorProvider = getInjectorProvider();
		if (injectorProvider == null) {
			injectorProvider = createInjectorProvider();
			injectorProviderClassCache.put(getTestClass().getJavaClass(), injectorProvider);
		}
		return injectorProvider;
	}

	protected IInjectorProvider getInjectorProvider() {
		return injectorProviderClassCache.get(getTestClass().getJavaClass());
	}

	protected IInjectorProvider createInjectorProvider() throws Exception {
		IInjectorProvider injectorProvider = null;
		InjectWith injectWith = getTestClass().getJavaClass().getAnnotation(InjectWith.class);
		if (injectWith != null) {
			injectorProvider = injectWith.value().newInstance();
		}
		return injectorProvider;
	}

}
