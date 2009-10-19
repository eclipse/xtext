/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.service;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

import org.apache.log4j.Logger;

import com.google.inject.Binder;
import com.google.inject.Provider;
import com.google.inject.Scopes;
import com.google.inject.binder.AnnotatedBindingBuilder;

public class ProviderModule extends MethodBasedModule {

	private static Logger LOGGER = Logger.getLogger(BindModule.class);
	
	public ProviderModule(Method method, Object owner) {
		super(method, owner);
	}

	@SuppressWarnings("unchecked")
	public void configure(Binder binder) {
		Type providerType = getReturnTypeGenericParamAsType(Class.class, getMethod());
		if (providerType != null) {
			Class<?> key = getReturnTypeGenericParam(Provider.class, providerType);
			if (key != null) {
				Class<? extends Provider<?>> providerClass = (Class<? extends Provider<?>>) invokeMethod();
				if (LOGGER.isTraceEnabled())
					LOGGER.trace("Adding binding from " + key.getName() + " to " + providerClass.getName()
							+ ". Declaring Method was '" + getMethod().toGenericString() + "' in Module "
							+ this.getClass().getName());
				if (providerClass != null && !Void.class.equals(providerClass)) {
					AnnotatedBindingBuilder<Object> bind = binder.bind((Class<Object>) key);
					if (!key.equals(providerClass)) {
						bind.toProvider(providerClass);
					}
					if (isEager(getMethod())) {
						bind.asEagerSingleton();
					} else if (isSingleton(getMethod())) {
						bind.in(Scopes.SINGLETON);
					}
				}
			}
		} else {
			Class<?> key = getReturnTypeGenericParam(Provider.class, getMethod());
			if (key != null) {
				Object object = invokeMethod();
				if (object instanceof Provider<?>) {
					binder.bind((Class<Object>)key).toProvider((Provider<? extends Object>)object);
				}
			}
		}
	}
	
	protected boolean isConfigured(Class<?> from, Object to) {
		Type providerType = getReturnTypeGenericParamAsType(Class.class, getMethod());
		if (providerType != null) {
			Class<?> key = getReturnTypeGenericParam(Provider.class, providerType);
			if (key != null) {
				Object value = invokeMethod();
				return from.equals(key) && ((to == null && value == null) || to != null && to.equals(value));
			}
		} else {
			Class<?> key = (Class<?>) getReturnTypeGenericParamAsType(Provider.class, getMethod());
			if (key != null) {
				Object value = invokeMethod();
				return from.equals(key) && ((to == null && value == null) || to != null && to.equals(value));
			}
		}
		return false;
	}
	
	@Override
	protected boolean isConfigured(Class<?> from, Object to, boolean singleton, boolean eagerSingleton,
			boolean provider) {
		if (!provider)
			return false;
		if (isEager(getMethod()) != eagerSingleton)
			return false;
		if (isSingleton(getMethod()) != singleton)
			return false;
		return isConfigured(from, to);
	}

}