/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.tests;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.LinkedList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xtext.ecoreInference.ErrorAcceptor;
import org.eclipse.xtext.xtext.ecoreInference.TransformationErrorCode;
import org.junit.Assert;

import com.google.common.collect.Lists;

public class TestErrorAcceptor extends Assert implements ErrorAcceptor {
	public static final String ANY_STRING = "ANY_STRING";
	public static final EObject ANY_EOBJECT = (EObject) Proxy.newProxyInstance(
			TestErrorAcceptor.class.getClassLoader(), new Class[] { EObject.class }, new InvocationHandler() {

				@Override
				public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
					return "toString".equals(method.getName()) ? "ANY_EOBJECT" : null;
				}
			});

	LinkedList<Triple<TransformationErrorCode, String, EObject>> flugschreiber = Lists.newLinkedList();
	private boolean write = true;

	@Override
	public void acceptError(TransformationErrorCode errorCode, String message, EObject element) {
		Triple<TransformationErrorCode, String, EObject> create = Tuples.create(errorCode, message, element);
		//		System.out.println((write ? "Write>" : "Read>") + " errorCode: " + (errorCode != null ? errorCode : "")
		//				+ ", message: " + (message != null ? message : "") + ", element: " + (element != null ? element : ""));
		if (write) {
			flugschreiber.push(create);
		} else {
			Triple<TransformationErrorCode, String, EObject> pop = flugschreiber.removeLast();
			assertNotNull("Queue is empty", pop);
			boolean equals = compareTriple(pop, create);
			assertTrue("Verified", equals);
		}
	}

	private boolean compareTriple(Triple<TransformationErrorCode, String, EObject> one,
			Triple<TransformationErrorCode, String, EObject> other) {
		if (one.equals(other))
			return true;
		if (other == null)
			return false;
		if (other == one)
			return true;

		TransformationErrorCode first = one.getFirst();
		boolean isFirstEqual = ((first == null) ? other.getFirst() == null : first.equals(other.getFirst()));
		if (!isFirstEqual)
			return false;

		String second = one.getSecond();
		boolean isSecondEqual = second == ANY_STRING
				|| ((second == null) ? other.getSecond() == null : second.equals(other.getSecond()));
		if (!isSecondEqual)
			return false;

		EObject third = one.getThird();
		boolean isThirdEqual = third == ANY_EOBJECT
				|| (third == null ? other.getThird() == null : one.getThird().equals(other.getThird()));
		return isThirdEqual;
	}

	public void replay() {
		//		System.out.println("replay");
		write = false;
	}

	public void verify() {
		//		System.out.println("verify");
		assertTrue("Verified", flugschreiber.isEmpty());
	}
}