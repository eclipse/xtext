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

import com.google.inject.Module;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class MethodBasedModule implements Module {

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
	
	protected boolean isConfigured(Class<?> from, Object to, boolean singleton, boolean eagerSingleton, boolean provider) {
		return false;
	}
	
	protected final Class<?> getReturnTypeGenericParam(Class<?> expectedRawType, Method method) {
		Type type = getReturnTypeGenericParamAsType(expectedRawType, method);
		if (type != null)
			return getClassType(type);
		return null;
	}
	
	protected final Class<?> getReturnTypeGenericParam(Class<?> expectedRawType, Type type) {
		Class<?> providerClass = getClassType(type);
		if (expectedRawType.isAssignableFrom(providerClass)) {
			Type actualType = null;
			if (type instanceof WildcardType) {
				Type upperBound = ((WildcardType) type).getUpperBounds()[0];
				if (upperBound instanceof ParameterizedType) {
					Type[] typeArguments = ((ParameterizedType) upperBound).getActualTypeArguments();
					actualType = typeArguments[0];
				} else {
 					actualType = upperBound;
				}
			} else {
				Type[] typeArguments = ((ParameterizedType) type).getActualTypeArguments();
				actualType = typeArguments[0];
			}
			Class<?> key = getClassType(actualType);
			return key;
		}
		return null;
	}
	
	protected final Type getReturnTypeGenericParamAsType(Class<?> expectedRawType, Method method) {
		if (method.getReturnType().equals(expectedRawType)) {
			Type returnType = method.getGenericReturnType();
			if (returnType instanceof ParameterizedType) {
				Type[] arguments = ((ParameterizedType) returnType).getActualTypeArguments();
				return arguments[0];
			}
			return null;
		}
		return null;
	}
	
	protected Class<?> getClassType(Type type) {
		if (type instanceof WildcardType) {
			Type upperBound = ((WildcardType) type).getUpperBounds()[0];
			if (upperBound instanceof Class<?>)
				return (Class<?>) upperBound;
			if (upperBound instanceof ParameterizedType) {
				Type rawType = ((ParameterizedType) upperBound).getRawType();
				if (rawType instanceof Class<?>)
					return (Class<?>) rawType;
			}
		} else if (type instanceof Class<?>)
			return (Class<?>) type;
		return null;
	}
	
	protected boolean isEager(Method method) {
		SingletonBinding binding = method.getAnnotation(SingletonBinding.class);
		if (binding != null) {
			return binding.eager();
		}
		return false;
	}

	protected boolean isSingleton(Method method) {
		return method.getAnnotation(SingletonBinding.class) != null;
	}
	
	public Object invokeMethod(Object... parameters) {
		try {
			method.setAccessible(true);
			return method.invoke(owner, parameters);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
