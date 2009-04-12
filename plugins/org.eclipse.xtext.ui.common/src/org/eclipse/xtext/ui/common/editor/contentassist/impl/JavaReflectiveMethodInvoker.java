/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.contentassist.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;

/**
 * Calls methods on a target object or collection reflectively. Caches resolved methods in a map.
 *
 * @author Jan K&ouml;hnlein - Initial contribution and API
 * @author Michael Clay
 *
 */
public class JavaReflectiveMethodInvoker {

	private final Map<Triple<? extends Class<?>,String, ? extends Class<?>>, Method> methodLookupMap = new HashMap<Triple<? extends Class<?>,String, ? extends Class<?>>, Method>();

	private final Object target;

	public JavaReflectiveMethodInvoker(Object target) {
		this.target = target;
	}

	public Object invoke(String methodName, java.util.List<Class<?>> parameterTypes, java.util.List<?> parameterValues) {
		Object invocationResult = null;
		if (target instanceof Collection<?>) {
			for (Iterator<?> iterator = ((Collection<?>)target).iterator(); null == invocationResult && iterator.hasNext();) {
				invocationResult = doInvoke(iterator.next(),methodName, parameterTypes, parameterValues);
			}
		} else {
			invocationResult = doInvoke(target,methodName, parameterTypes, parameterValues);
		} 
		return invocationResult;
	}

	private Object doInvoke(Object invocationTarget,String methodName, java.util.List<Class<?>> parameterTypes, java.util.List<?> parameterValues) {
		Method method = findMethod(invocationTarget.getClass(), methodName, parameterTypes.toArray(new Class[] {}));
		if (method == null) {
			return null;
		}
		return invokeMethod(method, invocationTarget, parameterValues.toArray(new Object[] {}));
	}

	private final Method findMethod(Class<?> clazz, String name, Class<?>... paramTypes) {
		Assert.isNotNull(clazz, "Class must not be null");
		Assert.isNotNull(name, "Method name must not be null");
		Triple<? extends Class<?>,String, ? extends Class<?>>  methodKey = Tuples.create(clazz,name, (paramTypes == null || paramTypes.length == 0) ? null
				: paramTypes[0]);
		Method result = methodLookupMap.get(methodKey);
		if (result != null)
			return result;
		Class<?> searchType = clazz;
		while (!Object.class.equals(searchType) && searchType != null) {
			Method[] methods = (searchType.isInterface() ? searchType.getMethods() : searchType.getDeclaredMethods());
			for (int i = 0; i < methods.length; i++) {
				Method method = methods[i];
				if (name.equals(method.getName())
						&& (paramTypes == null || equalOrAssignableTypes(method.getParameterTypes(), paramTypes))) {
					if (result == null || equalOrAssignableTypes(result.getParameterTypes(), method.getParameterTypes())) {
						result = method;
						methodLookupMap.put(methodKey, method);
					}
				}
			}
			searchType = searchType.getSuperclass();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	private final List<ICompletionProposal> invokeMethod(Method method, Object target, Object... args) {
		try {
			method.setAccessible(true);
			return (List<ICompletionProposal>) method.invoke(target, args);
		}
		catch (IllegalArgumentException e) {
			throw new IllegalStateException("Illegal argument exception: " + e.getMessage(), e);
		}
		catch (IllegalAccessException e) {
			throw new IllegalStateException("Could not access method: " + e.getMessage(), e);
		}
		catch (InvocationTargetException e) {
			Throwable targetEx = e.getTargetException();
			if (targetEx instanceof RuntimeException)
				throw (RuntimeException) targetEx;
			if (targetEx instanceof Error)
				throw (Error)targetEx;
			throw new IllegalStateException("Unexpected exception thrown", targetEx);
		}
	}

	private boolean equalOrAssignableTypes(Class<?>[] a, Class<?>[] a2) {
		if (a == a2) {
			return true;
		}
		if (a == null || a2 == null) {
			return false;
		}
		int length = a.length;
		if (a2.length != length) {
			return false;
		}
		for (int i = 0; i < length; i++) {
			Class<?> o1 = a[i];
			Class<?> o2 = a2[i];

			if (!(o1 == null ? o2 == null : o1.equals(o2) || o1.isAssignableFrom(o2))) {
				return false;
			}
		}
		return true;
	}
}