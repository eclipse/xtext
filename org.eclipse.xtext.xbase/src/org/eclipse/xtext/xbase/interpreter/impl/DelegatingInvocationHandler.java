/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.interpreter.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;

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
			return this.method.invoke(receiver, args);
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
