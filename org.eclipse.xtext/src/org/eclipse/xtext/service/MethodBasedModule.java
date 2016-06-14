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
import java.lang.reflect.WildcardType;

import org.apache.log4j.Logger;

import com.google.inject.Binder;
import com.google.inject.Key;
import com.google.inject.Module;
import com.google.inject.Scopes;
import com.google.inject.binder.LinkedBindingBuilder;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Sven Efftinge
 */
public abstract class MethodBasedModule implements Module {
	private static Logger LOGGER = Logger.getLogger(BindModule.class);
	private final Method method;
	private final Object owner;

	protected MethodBasedModule(Method method, Object owner) {
		this.method = method;
		this.owner = owner;
	}
	
	public Method getMethod() {
		return method;
	}

	public Object getOwner() {
		return owner;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public void configure(Binder binder) {
		Type key = getKeyType();
		if (isClassBinding()) {
			Class<?> value = (Class<?>) invokeMethod();
			if (value != null && !Void.class.equals(value)) {
				if (LOGGER.isTraceEnabled()) {
					LOGGER.trace("Adding binding from " + key + " to " + value.getName()
							+ ". Declaring Method was '" + getMethod().toGenericString() + "' in Module "
							+ this.getClass().getName());
				}
				LinkedBindingBuilder<Object> bind = binder.bind((Key<Object>)Key.get(key));
				if (!key.equals(value)) {
					bindToClass(bind, value);
				}
				if (isEager()) {
					bind.asEagerSingleton();
				} else if (isSingleton()) {
					bind.in(Scopes.SINGLETON);
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
			LinkedBindingBuilder<Object> bind = binder.bind((Key<Object>)Key.get(key));
			bindToInstance(bind, instance);
		}
	}

	protected void bindToClass(LinkedBindingBuilder<Object> bind, Class<?> value) {
		bind.to(value);
	}

	protected void bindToInstance(LinkedBindingBuilder<Object> bind, Object instance) {
		bind.toInstance(instance);
	}
	
	protected boolean isSame(Type typeA, Type typeB) {
		return typeA.equals(typeB);
	}
	
	public Type getKeyType() {
		Type genericReturnType = getMethod().getGenericReturnType();
		if (isClassBinding()) {
			Type type = genericReturnType;
			if (!(type instanceof ParameterizedType)) {
				throw throwIllegalReturnTypeDeclaration(getMethod());
			}
			return getFirstTypeParameter((ParameterizedType) type);
		} else {
			return genericReturnType;
		}
	}

	protected Type getFirstTypeParameter(ParameterizedType type) {
		Type firstParam = type.getActualTypeArguments()[0];
		if (firstParam instanceof WildcardType) {
			return ((WildcardType)firstParam).getUpperBounds()[0];
		}
		return firstParam;
	}

	protected IllegalStateException throwIllegalReturnTypeDeclaration(Method method) {
		return new IllegalStateException("return type of "+method.getName()+" should be declared with wildcard and upperbound (i.e. Class<? extends IScopeProvider>)");
	}
	
	public boolean isClassBinding() {
		return Class.class.equals(getMethod().getReturnType());
	}

	public boolean isEager() {
		SingletonBinding binding = getMethod().getAnnotation(SingletonBinding.class);
		if (binding != null) {
			return binding.eager();
		}
		return false;
	}

	public boolean isSingleton() {
		return getMethod().getAnnotation(SingletonBinding.class) != null;
	}
	
	public Object invokeMethod(Object... parameters) {
		try {
			getMethod().setAccessible(true);
			return getMethod().invoke(owner, parameters);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
