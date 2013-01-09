/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.dispatch;

import org.eclipse.xtend.core.tests.NewTypeSystemRuntimeInjectorProvider;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.util.Tuples;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("deprecation")
@RunWith(XtextRunner.class)
@InjectWith(NewTypeSystemRuntimeInjectorProvider.class)
public class DispatchingSupportTest2 extends DispatchingSupportTest {

	@Override
	@Test public void testIgnoreVoidInParameterTypeInferrence_03() throws Exception {
		XtendClass clazz = clazz("class X {\n" +
			" def dispatch foo(String n, Void v) {null}" +
			" def dispatch foo(Integer i, Void v) {null}" +
			"}");
		JvmOperation dispatchMethod = dispatchingSupport.findSyntheticDispatchMethod(clazz, Tuples.create("foo", 2));
		JvmFormalParameter firstParameter = dispatchMethod.getParameters().get(0);
		assertEquals("java.lang.Object", firstParameter.getParameterType().getIdentifier());
		JvmFormalParameter secondParameter = dispatchMethod.getParameters().get(1);
		assertEquals("java.lang.Object", secondParameter.getParameterType().getIdentifier());
	}
	
}
