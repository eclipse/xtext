/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.service;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.google.inject.Provider;
import com.google.inject.binder.LinkedBindingBuilder;
import com.google.inject.internal.MoreTypes;

public class ProviderModule extends MethodBasedModule {

	public ProviderModule(Method method, Object owner) {
		super(method, owner);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void bindToInstance(LinkedBindingBuilder<Object> bind, Object instance) {
		if (instance != null) // provider may not be null
			bind.toProvider((Provider<? extends Object>) instance);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void bindToClass(LinkedBindingBuilder<Object> bind, Class<?> value) {
		bind.toProvider((Class<? extends Provider<?>>)value);
	}

	@Override
	public Type getKeyType() {
		Type keyType = super.getKeyType();
		if (!(isInstanceOf(keyType, Provider.class)))
			throw new IllegalStateException("The method "+getMethod().getName()+" is expected to return a Class<? extends Provider<Something>> or directly Provider<Something>.");
		return getFirstTypeParameter((ParameterizedType) keyType);
	}

	protected boolean isInstanceOf(Type keyType, Class<?> class1) {
		return class1.isAssignableFrom(MoreTypes.getRawType(keyType));
	}
}