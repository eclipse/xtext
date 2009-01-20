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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.service.Inject;
import org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider;

/**
 * Default implementation of the {@link IContentAssistInvocationHandler}
 *  reflectively calling Java methods on the {@link AbstractProposalProvider} to
 * perform content assist for assignments.
 * 
 * @author Jan Köhnlein - Initial contribution and API
 */
public class DefaultContentAssistMethodInvoker implements IContentAssistInvocationHandler {

	private static final Map<String, Method> methodLookupMap = new HashMap<String, Method>();

	@Inject
	private IProposalProvider proposalProvider;

	public List<? extends ICompletionProposal> invoke(String methodName, java.util.List<Class<?>> parameterTypes,
			java.util.List<?> parameterValues) {
		Method method = findMethod(proposalProvider.getClass(), methodName, parameterTypes.toArray(new Class[] {}));
		if (method == null) {
			return null;
		}
		List<? extends ICompletionProposal> assignmentProposalList = invokeMethod(method, proposalProvider,
				parameterValues.toArray(new Object[] {}));
		return assignmentProposalList;
	}

	private final Method findMethod(Class<?> clazz, String name, Class<?>... paramTypes) {
		Assert.isNotNull(clazz, "Class must not be null");
		Assert.isNotNull(name, "Method name must not be null");
		Method result = methodLookupMap.get(name);
		Class<?> searchType = clazz;
		while (!Object.class.equals(searchType) && searchType != null && null == result) {
			Method[] methods = (searchType.isInterface() ? searchType.getMethods() : searchType.getDeclaredMethods());
			for (int i = 0; i < methods.length; i++) {
				Method method = methods[i];
				if (name.equals(method.getName())
						&& (paramTypes == null || equalOrAssignableTypes(method.getParameterTypes(), paramTypes))) {
					if (result == null
							|| equalOrAssignableTypes(result.getParameterTypes(), method.getParameterTypes())) {
						result = method;
						methodLookupMap.put(name, method);
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
			return (List<ICompletionProposal>) method.invoke(target, args);
		}
		catch (Exception ex) {
			handleReflectionException(ex);
		}
		throw new IllegalStateException("huh?");
	}

	private void handleReflectionException(Exception ex) {
		if (ex instanceof NoSuchMethodException) {
			throw new IllegalStateException("Method not found: " + ex.getMessage());
		}
		if (ex instanceof IllegalAccessException) {
			throw new IllegalStateException("Could not access method: " + ex.getMessage());
		}
		if (ex instanceof InvocationTargetException) {
			rethrowRuntimeException(((InvocationTargetException) ex).getTargetException());
		}
		if (ex instanceof RuntimeException) {
			throw (RuntimeException) ex;
		}
		handleUnexpectedException(ex);
	}

	private void handleUnexpectedException(Throwable ex) {
		IllegalStateException isex = new IllegalStateException("Unexpected exception thrown");
		isex.initCause(ex);
		throw isex;
	}

	private final void rethrowRuntimeException(Throwable ex) {
		if (ex instanceof RuntimeException) {
			throw (RuntimeException) ex;
		}
		if (ex instanceof Error) {
			throw (Error) ex;
		}
		handleUnexpectedException(ex);
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
