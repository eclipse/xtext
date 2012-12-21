/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.linking

import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase
import org.eclipse.xtext.xbase.tests.typesystem.XbaseNewTypeSystemInjectorProvider
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author Sebastian Zarnekow
 */
abstract class AbstractOrderSensitivityTest extends AbstractXbaseTestCase {
	
	@Test
	def void testOverloadedMethods_01() {
		doTestAndExpect("testdata.ordersensitivity.CaseA", "overloaded(chars, strings)", "overloaded(java.util.Collection,java.lang.Iterable)")
	}
	
	@Test
	def void testOverloadedMethods_02() {
		doTestAndExpect("testdata.ordersensitivity.CaseB", "overloaded(chars, strings)", "overloaded(java.util.Collection,java.lang.Iterable)")
	}
	
	@Test
	def void testOverloadedMethods_03() {
		doTestAndExpect("testdata.ordersensitivity.CaseA", "overloaded(strings, chars)", "overloaded(java.lang.Iterable,java.util.Collection)")
	}
	
	@Test
	def void testOverloadedMethods_04() {
		doTestAndExpect("testdata.ordersensitivity.CaseB", "overloaded(strings, chars)", "overloaded(java.lang.Iterable,java.util.Collection)")
	}
	
	def protected void doTestAndExpect(String declarator, String invocation, String expectation) {
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
	
//	override protected expression(CharSequence string) throws Exception {
//		expression(string, true)
//	}
	
}

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(XbaseNewTypeSystemInjectorProvider))
class OrderSensitivityTest extends AbstractOrderSensitivityTest {
	
}

class OldOrderSensitivityTest extends AbstractOrderSensitivityTest {
	
}