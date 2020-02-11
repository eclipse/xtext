/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.service;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.eclipse.xtext.util.ReflectionUtil;

import com.google.inject.binder.LinkedBindingBuilder;

public class ProviderModule extends MethodBasedModule {

	public ProviderModule(Method method, Object owner) {
		super(method, owner);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void bindToInstance(LinkedBindingBuilder<Object> bind, Object instance) {
		if (instance != null) // provider may not be null
			bind.toProvider((com.google.inject.Provider<? extends Object>) instance);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void bindToClass(LinkedBindingBuilder<Object> bind, Class<?> value) {
		bind.toProvider((Class<? extends javax.inject.Provider<?>>) value);
	}

	@Override
	public Type getKeyType() {
		Type keyType = super.getKeyType();
		if (!isInstanceOf(keyType, com.google.inject.Provider.class)) {
			if (isInstanceOf(keyType, javax.inject.Provider.class)) {
				if (!isClassBinding())
					throw new IllegalStateException("The method "+getMethod().getName()+" returns javax.inject.Provider, but this kind of binding is allowed only for com.google.inject.Provider.");
			} else {
				throw new IllegalStateException("The method "+getMethod().getName()+" is expected to return a Class<? extends Provider<Something>> or directly Provider<Something>.");
			}
		}
		return getFirstTypeParameter((ParameterizedType) keyType);
	}

	protected boolean isInstanceOf(Type keyType, Class<?> class1) {
		return class1.isAssignableFrom(ReflectionUtil.getRawType(keyType));
	}
}