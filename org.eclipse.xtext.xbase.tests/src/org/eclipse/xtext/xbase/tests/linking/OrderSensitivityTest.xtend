/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.linking

import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.XMemberFeatureCall
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase
import org.junit.Test

/**
 * @author Sebastian Zarnekow
 */
class OrderSensitivityTest extends AbstractXbaseTestCase {
	
	@Test
	def void testOverloadedMethods_01() {
		doTestOverloadedAndExpect("testdata.ordersensitivity.CaseA", "overloaded(chars, strings)", "overloaded(java.util.Collection,java.lang.Iterable)")
	}
	
	@Test
	def void testOverloadedMethods_02() {
		doTestOverloadedAndExpect("testdata.ordersensitivity.CaseB", "overloaded(chars, strings)", "overloaded(java.util.Collection,java.lang.Iterable)")
	}
	
	@Test
	def void testOverloadedMethods_03() {
		doTestOverloadedAndExpect("testdata.ordersensitivity.CaseA", "overloaded(strings, chars)", "overloaded(java.lang.Iterable,java.util.Collection)")
	}
	
	@Test
	def void testOverloadedMethods_04() {
		doTestOverloadedAndExpect("testdata.ordersensitivity.CaseB", "overloaded(strings, chars)", "overloaded(java.lang.Iterable,java.util.Collection)")
	}
	
	@Test
	def void testOverloadedClosureMethods_01() {
		doTestClosureMethodAndExpect("testdata.ordersensitivity.CaseC", "'hello'", "RunnerWithResult")
	}
	
	@Test
	def void testOverloadedClosureMethods_02() {
		doTestClosureMethodAndExpect("testdata.ordersensitivity.CaseD", "'hello'", "RunnerWithResult")
	}
	
	@Test
	def void testOverloadedClosureMethods_03() {
		doTestClosureMethodAndExpect("testdata.ordersensitivity.CaseC", "System::out.println()", "Runner")
	}
	
	@Test
	def void testOverloadedClosureMethods_04() {
		doTestClosureMethodAndExpect("testdata.ordersensitivity.CaseD", "System::out.println()", "Runner")
	}
	
	def protected void doTestOverloadedAndExpect(String declarator, String invocation, String expectation) {
		val block = expression('''
			{
				var java.util.List<CharSequence> chars = null
				var java.util.List<String> strings = null
				var «declarator» receiver = null
				receiver.«invocation»
			}
		''') as XBlockExpression
		val featureCall = block.expressions.last as XAbstractFeatureCall
		val feature = featureCall.feature
		assertNotNull('feature is not null', feature)
		assertFalse('feature is resolved', feature.eIsProxy)
		assertEquals('''«declarator».«expectation»'''.toString, feature.identifier)
	}
	
	def protected void doTestClosureMethodAndExpect(String declarator, String expression, String expectation) {
		val featureCall = expression('''new «declarator»().run [| «expression» ]''') as XMemberFeatureCall
		val feature = featureCall.feature
		assertNotNull('feature is not null', feature)
		assertFalse('feature is resolved', feature.eIsProxy)
		assertEquals('''«declarator».run(«declarator»$«expectation»)'''.toString, feature.identifier)
		
	}
}


