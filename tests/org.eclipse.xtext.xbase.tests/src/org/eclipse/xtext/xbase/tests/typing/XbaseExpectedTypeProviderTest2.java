/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typing;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.tests.typesystem.XbaseNewTypeSystemInjectorProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(XbaseNewTypeSystemInjectorProvider.class)
public class XbaseExpectedTypeProviderTest2 extends XbaseExpectedTypeProviderTest {

	@Override
	@Test public void testLowerBoundIsNotVoid() throws Exception {
		XMemberFeatureCall fc = (XMemberFeatureCall) expression("new foo.ClassWithGenericMethod().genericMethod(return null)");
		assertExpected("java.lang.Object", fc.getExplicitArguments().get(1));
	}
	
	@Override
	@Test public void testForLoopExpression_0() throws Exception {
		XForLoopExpression loop = (XForLoopExpression) expression("for (java.lang.String x : null) null");

		assertExpected("java.lang.Iterable<? extends java.lang.String> | String[]", loop.getForExpression());
		assertExpected(null, loop.getEachExpression());
	}

	@Override
	@Test public void testForLoopExpression_1() throws Exception {
		XForLoopExpression loop = (XForLoopExpression) expression("for (x : null) null");
		assertExpected("java.lang.Iterable<? extends java.lang.Object> | Object[] | int[] | double[] | byte[] | long[] | short[] | float[] | boolean[]", loop.getForExpression());
		assertExpected(null, loop.getEachExpression());
	}
	
}
