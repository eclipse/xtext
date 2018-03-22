/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.testing.extensions;

import static org.eclipse.xtext.util.Exceptions.throwUncheckedException;

import org.eclipse.xtext.testing.IInjectorProvider;
import org.eclipse.xtext.testing.IRegistryConfigurator;
import org.eclipse.xtext.testing.InjectWith;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.runners.model.TestClass;

import com.google.common.annotations.Beta;
import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.MutableClassToInstanceMap;
import com.google.inject.Injector;

/**
 * Use this extension together with {@link InjectWith} for JUnit 5 based Xtext
 * tests.
 * <p>
 * The extension retrieves an {@link Injector} to inject members in the instance
 * under test before best execution and resets registries after execution.
 * </p>
 * 
 * @author Karsten Thoms - Initial contribution and API
 * @since 2.14
 */
@Beta
public class InjectionExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {
	/**
	 * Maintains a map of injector provider types to their instance.
	 * <p>
	 * {@link #getOrCreateInjectorProvider(TestClass)} is used to obtain
	 * an valid injector provider in the context of a given {@link TestClass}.
	 * </p>
	 */
	private static ClassToInstanceMap<IInjectorProvider> injectorProviderClassCache = MutableClassToInstanceMap.create();

	@Override
	public void beforeTestExecution(ExtensionContext context) throws Exception {
		IInjectorProvider injectorProvider = getOrCreateInjectorProvider(context);
		if (injectorProvider instanceof IRegistryConfigurator) {
			final IRegistryConfigurator registryConfigurator = (IRegistryConfigurator) injectorProvider;
			registryConfigurator.setupRegistry();
		}
		if (injectorProvider != null) {
			Injector injector = injectorProvider.getInjector();
			if (injector != null)
				injector.injectMembers(context.getRequiredTestInstance());
		}
	}

	@Override
	public void afterTestExecution(ExtensionContext context) throws Exception {
		IInjectorProvider injectorProvider = getOrCreateInjectorProvider(context);
		if (injectorProvider instanceof IRegistryConfigurator) {
			final IRegistryConfigurator registryConfigurator = (IRegistryConfigurator) injectorProvider;
			registryConfigurator.restoreRegistry();
		}
	}


	private static IInjectorProvider getOrCreateInjectorProvider(ExtensionContext context) {
		InjectWith injectWith = context.getRequiredTestClass().getAnnotation(InjectWith.class);
		if (injectWith != null) {
			Class<? extends IInjectorProvider> klass = injectWith.value();
			IInjectorProvider injectorProvider = injectorProviderClassCache.get(klass);
			if (injectorProvider == null) {
				try {
					injectorProvider = klass.newInstance();
					injectorProviderClassCache.put(klass, injectorProvider);
				} catch (Exception e) {
					throwUncheckedException(e);
				}
			}
			return injectorProvider;
		}
		return null;
	}
}
