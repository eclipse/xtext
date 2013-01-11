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
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(XbaseNewTypeSystemInjectorProvider.class)
public class XbaseExpectedTypeProviderTest2 extends XbaseExpectedTypeProviderTest {

	@Ignore("TODO fix me")
	@Override
	@Test public void testLowerBoundIsNotVoid() throws Exception {
		XMemberFeatureCall fc = (XMemberFeatureCall) expression("new foo.ClassWithGenericMethod().genericMethod(return null)");
		assertExpected("java.lang.Object", fc.getExplicitArguments().get(1));
	}
	
	@Ignore("TODO investigate")
	@Override
	@Test
	public void testTypeParamInference_02() throws Exception {
		super.testTypeParamInference_02();
	}
	@Ignore("TODO investigate")
	@Override
	@Test
	public void testTypeParamInference_03() throws Exception {
		super.testTypeParamInference_02();
	}
	@Ignore("TODO investigate")
	@Override
	@Test
	public void testTypeParamInference_07() throws Exception {
		super.testTypeParamInference_02();
	}
	@Ignore("TODO investigate")
	@Override
	@Test
	public void testTypeParamInference_08() throws Exception {
		super.testTypeParamInference_02();
	}
	
	@Override
	@Test public void testForLoopExpression_1() throws Exception {
		XForLoopExpression loop = (XForLoopExpression) expression("for (x : null) null");
		assertExpected("java.lang.Iterable<? extends java.lang.Object>", loop.getForExpression());
		assertExpected(null, loop.getEachExpression());
	}
	
	@Override
	@Test public void testForLoopExpression_0() throws Exception {
		XForLoopExpression loop = (XForLoopExpression) expression("for (java.lang.String x : null) null");
		// if the type is null, we use a simple expectation, error is 'null' is not allowed, anyways
		assertExpected("java.lang.Iterable<? extends java.lang.String>", loop.getForExpression());
		assertExpected(null, loop.getEachExpression());
	}
	
	// testForLoopExpression_2_*:
	// if the type is not compatible, we keep our expectation to improve the error message
	@Test public void testForLoopExpression_2_a() throws Exception {
		XForLoopExpression loop = (XForLoopExpression) expression("for (java.lang.String x : new Object) null");
		assertExpected("java.lang.Iterable<? extends java.lang.String> | java.lang.String[]", loop.getForExpression());
	}
	@Test public void testForLoopExpression_2_b() throws Exception {
		XForLoopExpression loop = (XForLoopExpression) expression("for (int x : new Object) null");
		assertExpected("int[] | java.lang.Iterable<? extends java.lang.Integer> | java.lang.Integer[]", loop.getForExpression());
	}
	@Test public void testForLoopExpression_2_c() throws Exception {
		XForLoopExpression loop = (XForLoopExpression) expression("for (double x : null as Iterable<? super Integer>) null");
		assertExpected("double[] | java.lang.Iterable<? extends java.lang.Double> | java.lang.Double[]", loop.getForExpression());
	}

	// testForLoopExpression_3_*:
	// if the type is compatible, we use that one as expectation
	@Test public void testForLoopExpression_3_a() throws Exception {
		XForLoopExpression loop = (XForLoopExpression) expression("for (java.lang.String x : null as String[]) null");
		assertExpected("java.lang.String[]", loop.getForExpression());
	}
	@Test public void testForLoopExpression_3_b() throws Exception {
		XForLoopExpression loop = (XForLoopExpression) expression("for (int x : 1..2) null");
		assertExpected("org.eclipse.xtext.xbase.lib.IntegerRange", loop.getForExpression());
	}
	@Test public void testForLoopExpression_3_c() throws Exception {
		XForLoopExpression loop = (XForLoopExpression) expression("for (x : 1..2) null");
		assertExpected("org.eclipse.xtext.xbase.lib.IntegerRange", loop.getForExpression());
	}
	@Test public void testForLoopExpression_3_d() throws Exception {
		XForLoopExpression loop = (XForLoopExpression) expression("for (Integer x : 1..2) null");
		assertExpected("org.eclipse.xtext.xbase.lib.IntegerRange", loop.getForExpression());
	}
	@Test public void testForLoopExpression_3_e() throws Exception {
		XForLoopExpression loop = (XForLoopExpression) expression("for (Integer x : null as int[]) null");
		assertExpected("int[]", loop.getForExpression());
	}
	@Test public void testForLoopExpression_3_f() throws Exception {
		XForLoopExpression loop = (XForLoopExpression) expression("for (java.lang.String x : null as Iterable<String>) null");
		assertExpected("java.lang.Iterable<java.lang.String>", loop.getForExpression());
	}
	@Test public void testForLoopExpression_3_g() throws Exception {
		XForLoopExpression loop = (XForLoopExpression) expression("for (java.lang.String x : null as Iterable<? extends String>) null");
		assertExpected("java.lang.Iterable<? extends java.lang.String>", loop.getForExpression());
	}
	@Test public void testForLoopExpression_3_h() throws Exception {
		XForLoopExpression loop = (XForLoopExpression) expression("for (Object x : null as Iterable<? super Integer>) null");
		assertExpected("java.lang.Iterable<? extends java.lang.Object & super java.lang.Integer>", loop.getForExpression());
	}
	
	// testForLoopExpression_4_*:
	// if the expected component type is compatible, the expectation of the for expression is refined to 
	// to what it actually is
	@Test public void testForLoopExpression_4_a() throws Exception {
		XForLoopExpression loop = (XForLoopExpression) expression("for (Object x : null as double[]) null");
		assertExpected("double[]", loop.getForExpression());
	}
	@Test public void testForLoopExpression_4_b() throws Exception {
		XForLoopExpression loop = (XForLoopExpression) expression("for (double x : null as int[]) null");
		assertExpected("int[]", loop.getForExpression());
	}
	@Test public void testForLoopExpression_4_c() throws Exception {
		XForLoopExpression loop = (XForLoopExpression) expression("for (double x : null as Integer[]) null");
		assertExpected("java.lang.Integer[]", loop.getForExpression());
	}
	@Test public void testForLoopExpression_4_d() throws Exception {
		XForLoopExpression loop = (XForLoopExpression) expression("for (double x : null as Iterable<Integer>) null");
		assertExpected("java.lang.Iterable<java.lang.Integer>", loop.getForExpression());
	}
	@Test public void testForLoopExpression_4_e() throws Exception {
		XForLoopExpression loop = (XForLoopExpression) expression("for (double x : null as Iterable<? extends Integer>) null");
		assertExpected("java.lang.Iterable<? extends java.lang.Integer>", loop.getForExpression());
	}
	
	
}
