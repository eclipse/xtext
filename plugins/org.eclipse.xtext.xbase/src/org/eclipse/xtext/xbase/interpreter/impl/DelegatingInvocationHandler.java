/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.interpreter.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;

import org.eclipse.xtext.xbase.lib.Functions;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DelegatingInvocationHandler extends AbstractClosureInvocationHandler {

	private final Object receiver;
	private Method method;

	public DelegatingInvocationHandler(Object receiver, Class<?> interfaceType) {
		this.receiver = receiver;
		this.method = findMethod(interfaceType);
	}
	
	protected Method findMethod(Class<?> interfaceType) {
		for(Method m: interfaceType.getMethods()) {
			if ("apply".equals(m.getName())) {
				return m;
			}
		}
		throw new IllegalStateException("receiver does not expose a method 'apply'");
	}

	@Override
	protected Object doInvoke(Method method, Object[] args) throws Throwable {
		try {
			if (!Functions.FunctionX.class.equals(method.getDeclaringClass()))
				return this.method.invoke(receiver, args);
			return this.method.invoke(receiver, new Object[] { args });
		} catch (InvocationTargetException e) {
			throw e.getTargetException();
		} catch (Exception e) {
			throw new DelegationFailedException(e);
		}
	}
	
	public static class DelegationFailedException extends UndeclaredThrowableException {

		private static final long serialVersionUID = 1L;

		public DelegationFailedException(Throwable undeclaredThrowable) {
			super(undeclaredThrowable);
		}
		
	}
	
}
