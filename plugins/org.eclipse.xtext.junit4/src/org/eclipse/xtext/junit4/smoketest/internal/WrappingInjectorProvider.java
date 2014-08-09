/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.junit4.smoketest.internal;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.logging.Logger;

import org.eclipse.xtext.junit4.IInjectorProvider;
import org.eclipse.xtext.junit4.IRegistryConfigurator;
import org.eclipse.xtext.parser.IParser;

import com.google.common.annotations.Beta;
import com.google.inject.Binder;
import com.google.inject.Binding;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Module;
import com.google.inject.util.Modules;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Beta
public class WrappingInjectorProvider implements IInjectorProvider, IRegistryConfigurator {

	private final IInjectorProvider delegate;
	private final Injector injector;

	public WrappingInjectorProvider(IInjectorProvider delegate) {
		this.delegate = delegate;
		this.injector = createInjector();
	}
	
	protected Injector createInjector() {
		Injector delegateInjector = delegate.getInjector();
		final Map<Key<?>, Binding<?>> bindings = delegateInjector.getBindings();
		Injector injector = Guice.createInjector(Modules.override(new Module() {
			public void configure(Binder binder) {
				for(Binding<?> binding: bindings.values()) {
					Type typeLiteral = binding.getKey().getTypeLiteral().getType();
					if (!Injector.class.equals(typeLiteral) && !Logger.class.equals(typeLiteral)) {
						binding.applyTo(binder);
					}
				}
			}
		}).with(new Module() {
			public void configure(Binder binder) {
				binder.bind(IParser.class).toInstance(new TestDataProvider());
			}
		}));
		return injector;
	}
	
	public IInjectorProvider getDelegate() {
		return delegate;
	}

	public void setupRegistry() {
		if (delegate instanceof IRegistryConfigurator) {
			((IRegistryConfigurator) delegate).setupRegistry();
		}
	}

	public void restoreRegistry() {
		if (delegate instanceof IRegistryConfigurator) {
			((IRegistryConfigurator) delegate).restoreRegistry();
		}
	}

	public Injector getInjector() {
		return injector;
	}
}