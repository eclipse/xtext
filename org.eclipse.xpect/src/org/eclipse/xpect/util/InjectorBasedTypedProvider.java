package org.eclipse.xpect.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import javax.inject.Inject;


import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;

public class InjectorBasedTypedProvider implements ITypedProvider {
	final private Injector injector;
	final private Method method;
	final private int paramIndex;

	public InjectorBasedTypedProvider(Injector injector, Method method, int paramIndex) {
		super();
		this.injector = injector;
		this.method = method;
		this.paramIndex = paramIndex;
	}

	@Override
	public boolean canProvide(Class<?> expectedType) {
		return get(expectedType) != null;
	}

	protected Annotation findAnnotation() {
		for (Annotation a : method.getParameterAnnotations()[paramIndex])
			if (a.annotationType() != Inject.class)
				return a;
		return null;
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> T get(Class<T> expectedType) {
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