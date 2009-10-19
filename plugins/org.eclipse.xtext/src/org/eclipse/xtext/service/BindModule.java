/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.service;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;

import com.google.inject.Binder;
import com.google.inject.Scopes;
import com.google.inject.binder.AnnotatedBindingBuilder;

public class BindModule extends MethodBasedModule {

	private static Logger LOGGER = Logger.getLogger(BindModule.class);
	
	public BindModule(Method method, Object owner) {
		super(method, owner);
	}
	
	@SuppressWarnings("unchecked")
	public void configure(Binder binder) {
		Class<?> key = getReturnTypeGenericParam(Class.class, getMethod());
		if (key != null) {
			Class<?> value = (Class<?>) invokeMethod();
			if (LOGGER.isTraceEnabled())
				LOGGER.trace("Adding binding from " + key.getName() + " to " + value.getName()
						+ ". Declaring Method was '" + getMethod().toGenericString() + "' in Module "
						+ this.getClass().getName());
			if (value != null && !Void.class.equals(value)) {
				AnnotatedBindingBuilder<Object> bindingBuilder = binder.bind((Class<Object>)key);
				if (!key.equals(value)) {
					bindingBuilder.to(value);
				}
				if (isEager(getMethod())) {
					bindingBuilder.asEagerSingleton();
				} else if (isSingleton(getMethod())) {
					bindingBuilder.in(Scopes.SINGLETON);
				}
			}
		} else {
			Object instance = invokeMethod();
			if (LOGGER.isTraceEnabled())
				LOGGER.trace(
						"Adding binding from " + getMethod().getReturnType().getName() + 
						" to instance " + instance.toString()
						+ ". Declaring Method was '" + getMethod().toGenericString() + "' in Module "
						+ this.getClass().getName());
			binder.bind((Class<Object>)getMethod().getReturnType()).toInstance(instance);
		}
	}
	
	protected boolean isConfigured(Class<?> from, Object to) {
		Class<?> key = getReturnTypeGenericParam(Class.class, getMethod());
		if (key == null)
			key = getMethod().getReturnType();
		if (key != null) {
			Object value = invokeMethod();
			return from.equals(key) && (to != null && to.equals(value) || to == value);
		}
		return false;
	}

	@Override
	protected boolean isConfigured(Class<?> from, Object to, boolean singleton, boolean eagerSingleton,
			boolean provider) {
		if (provider)
			return false;
		if (isEager(getMethod()) != eagerSingleton)
			return false;
		if (isSingleton(getMethod()) != singleton)
			return false;
		return isConfigured(from, to);
	}
}