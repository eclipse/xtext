/**
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.linking;

import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Iterables;

/**
 * @author Sebastian Zarnekow
 */
public class OrderSensitivityTest extends AbstractXbaseTestCase {
	@Test
	public void testOverloadedMethods_01() throws Exception {
		doTestOverloadedAndExpect("testdata.ordersensitivity.CaseA", "overloaded(chars, strings)",
				"overloaded(java.util.Collection,java.lang.Iterable)");
	}

	@Test
	public void testOverloadedMethods_02() throws Exception {
		doTestOverloadedAndExpect("testdata.ordersensitivity.CaseB", "overloaded(chars, strings)",
				"overloaded(java.util.Collection,java.lang.Iterable)");
	}

	@Test
	public void testOverloadedMethods_03() throws Exception {
		doTestOverloadedAndExpect("testdata.ordersensitivity.CaseA", "overloaded(strings, chars)",
				"overloaded(java.lang.Iterable,java.util.Collection)");
	}

	@Test
	public void testOverloadedMethods_04() throws Exception {
		doTestOverloadedAndExpect("testdata.ordersensitivity.CaseB", "overloaded(strings, chars)",
				"overloaded(java.lang.Iterable,java.util.Collection)");
	}

	@Test
	public void testOverloadedClosureMethods_01() throws Exception {
		doTestClosureMethodAndExpect("testdata.ordersensitivity.CaseC", "\'hello\'", "RunnerWithResult");
	}

	@Test
	public void testOverloadedClosureMethods_02() throws Exception {
		doTestClosureMethodAndExpect("testdata.ordersensitivity.CaseD", "\'hello\'", "RunnerWithResult");
	}

	@Test
	public void testOverloadedClosureMethods_03() throws Exception {
		doTestClosureMethodAndExpect("testdata.ordersensitivity.CaseC", "System::out.println()", "Runner");
	}

	@Test
	public void testOverloadedClosureMethods_04() throws Exception {
		doTestClosureMethodAndExpect("testdata.ordersensitivity.CaseD", "System::out.println()", "Runner");
	}

	protected void doTestOverloadedAndExpect(String declarator, String invocation, String expectation) throws Exception {
		String model =
		// @formatter:off
		"{\n" +
		"	var java.util.List<CharSequence> chars = null\n" +
		"	var java.util.List<String> strings = null\n" +
		"	var " + declarator + " receiver = null\n" +
		"	receiver." + invocation + "\n" +
		"}";
		// @formatter:on
		XBlockExpression block = (XBlockExpression) expression(model);
		XAbstractFeatureCall featureCall = ((XAbstractFeatureCall) Iterables.getLast(block.getExpressions()));
		JvmIdentifiableElement feature = featureCall.getFeature();
		Assert.assertNotNull("feature is not null", feature);
		Assert.assertFalse("feature is resolved", feature.eIsProxy());
		Assert.assertEquals(declarator + "." + expectation, feature.getIdentifier());
	}

	protected void doTestClosureMethodAndExpect(String declarator, String expression, String expectation)
			throws Exception {
		XMemberFeatureCall featureCall = (XMemberFeatureCall) expression("new " + declarator + "().run [| " + expression + " ]");
		JvmIdentifiableElement feature = featureCall.getFeature();
		Assert.assertNotNull("feature is not null", feature);
		Assert.assertFalse("feature is resolved", feature.eIsProxy());
		Assert.assertEquals(declarator + ".run(" + declarator + "$" + expectation + ")", feature.getIdentifier());
	}
}
