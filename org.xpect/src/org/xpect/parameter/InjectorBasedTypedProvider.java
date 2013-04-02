/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.parameter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Map;

import javax.inject.Inject;

import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class InjectorBasedTypedProvider implements IParameterProvider {
	final private Injector injector;
	final private Method method;
	final private int paramIndex;

	public InjectorBasedTypedProvider(Injector injector, Method method, int paramIndex) {
		super();
		this.injector = injector;
		this.method = method;
		this.paramIndex = paramIndex;
	}

	public boolean canProvide(Class<?> expectedType) {
		return get(expectedType, null) != null;
	}

	protected Annotation findAnnotation() {
		for (Annotation a : method.getParameterAnnotations()[paramIndex])
			if (a.annotationType() != Inject.class)
				return a;
		return null;
	}

	@SuppressWarnings("unchecked")
	public <T> T get(Class<T> expectedType, Map<Class<? extends Annotation>, IParameterProvider> context) {
		TypeLiteral<?> classType = TypeLiteral.get(method.getDeclaringClass());
		TypeLiteral<?> paramType = classType.getParameterTypes(method).get(paramIndex);
		Annotation annotation = findAnnotation();
		Key<?> key = annotation == null ? Key.get(paramType) : Key.get(paramType, annotation);
		Object obj = injector.getInstance(key);
		if (expectedType.isInstance(obj))
			return (T) obj;
		return null;
	}

	public Injector getInjector() {
		return injector;
	}

	public Method getMethod() {
		return method;
	}

	public int getParamIndex() {
		return paramIndex;
	}
}