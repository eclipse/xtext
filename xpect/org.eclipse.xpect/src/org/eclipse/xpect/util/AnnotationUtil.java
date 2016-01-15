/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xpect.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class AnnotationUtil {

	@SuppressWarnings("unchecked")
	public static <T> T newInstance(Class<T> type, Class<?> declarator, Annotation annotation) throws IllegalAccessException {
		if (declarator != null)
			try {
				Constructor<?> c = type.getDeclaredConstructor(declarator.getClass(), annotation.annotationType());
				c.setAccessible(true);
				if (c != null)
					return (T) c.newInstance(declarator, annotation);
			} catch (SecurityException e) {
			} catch (NoSuchMethodException e) {
			} catch (InstantiationException e) {
			} catch (InvocationTargetException e) {
				throw new RuntimeException(e);
			}
		try {
			Constructor<?> c = type.getConstructor(annotation.annotationType());
			if (c != null)
				return (T) c.newInstance(annotation);
		} catch (SecurityException e) {
		} catch (NoSuchMethodException e) {
		} catch (InstantiationException e) {
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		}
		try {
			Constructor<?> c = type.getConstructor();
			if (c != null)
				return (T) c.newInstance();
		} catch (SecurityException e) {
		} catch (NoSuchMethodException e) {
		} catch (InstantiationException e) {
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		}
		return null;
	}

	public static <T> List<T> newInstancesViaMetaAnnotation(Class<?> declarator, Class<? extends Annotation> metaAnnotationClass, Class<T> expected) {
		List<T> result = Lists.newArrayList();
		for (Annotation annotation : declarator.getAnnotations()) {
			Annotation metaAnnotation = annotation.annotationType().getAnnotation(metaAnnotationClass);
			T r = newInstanceViaAnnotation(declarator, metaAnnotation, expected, annotation);
			if (r != null)
				result.add(r);
		}
		return result;
	}

	public static <T> List<T> newInstancesViaMetaAnnotation(Method declarator, Class<? extends Annotation> metaAnnotationClass, Class<T> expected) {
		List<T> result = Lists.newArrayList();
		for (Annotation annotation : declarator.getAnnotations()) {
			Annotation metaAnnotation = annotation.annotationType().getAnnotation(metaAnnotationClass);
			T r = newInstanceViaAnnotation(null, metaAnnotation, expected, annotation);
			if (r != null)
				result.add(r);
		}
		return result;
	}

	public static <T> List<T> newInstancesViaMetaAnnotation(Method declarator, int paramIndex, Class<? extends Annotation> metaAnnotationClass, Class<T> expected) {
		List<T> result = Lists.newArrayList();
		Annotation[][] annotations = declarator.getParameterAnnotations();
		if (paramIndex >= 0 && paramIndex < annotations.length)
			for (Annotation annotation : annotations[paramIndex]) {
				Annotation metaAnnotation = annotation.annotationType().getAnnotation(metaAnnotationClass);
				T r = newInstanceViaAnnotation(null, metaAnnotation, expected, annotation);
				if (r != null)
					result.add(r);
			}
		return result;
	}

	@SuppressWarnings("unchecked")
	public static <T> T newInstanceViaAnnotation(Class<?> declarator, Annotation annotation, Class<T> expected, Annotation parameter) {
		if (annotation != null)
			for (Method f : annotation.annotationType().getDeclaredMethods())
				if (f.getReturnType() == Class.class) {
					try {
						Object objtype = f.invoke(annotation);
						if (objtype instanceof Class<?> && expected.isAssignableFrom((Class<?>) objtype)) {
							T result = newInstance((Class<T>) objtype, declarator, parameter);
							if (result != null)
								return result;
						}
					} catch (IllegalArgumentException e) {
					} catch (IllegalAccessException e) {
					} catch (InvocationTargetException e) {
						throw new RuntimeException(e);
					}
				}
		return null;
	}

	public static <T> T newInstanceViaAnnotation(Class<?> declarator, Class<? extends Annotation> AnnotationClass, Class<T> expected) {
		Annotation annotation = declarator.getAnnotation(AnnotationClass);
		return newInstanceViaAnnotation(declarator, annotation, expected, annotation);
	}

	public static <T> T newInstanceViaMetaAnnotation(Class<?> declarator, Class<? extends Annotation> metaAnnotationClass, Class<T> expected) {
		for (Annotation annotation : declarator.getAnnotations()) {
			Annotation metaAnnotation = annotation.annotationType().getAnnotation(metaAnnotationClass);
			T r = newInstanceViaAnnotation(declarator, metaAnnotation, expected, annotation);
			if (r != null)
				return r;
		}
		return null;
	}

	public static <T extends Annotation> T newInstanceWithDefaults(Class<T> annotationType) {
		Object proxy = Proxy.newProxyInstance(annotationType.getClassLoader(), new Class<?>[] { annotationType }, new InvocationHandler() {
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				return method.getDefaultValue();
			}
		});
		return annotationType.cast(proxy);
	}
}
