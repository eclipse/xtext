/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typesystem

import com.google.inject.Inject
import com.google.inject.Singleton
import java.util.List
import org.eclipse.xtend.lib.Property
import org.eclipse.xtext.xbase.XNullLiteral
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase
import org.eclipse.xtext.xbase.typesystem.computation.XbaseTypeComputer
import org.junit.After
import org.junit.Ignore
import org.junit.Test
import org.eclipse.xtext.xbase.junit.typesystem.PublicReentrantTypeResolver
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationState
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation

import static org.junit.Assert.*

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ExpectationTest extends AbstractXbaseTestCase {
	
	@Inject PublicReentrantTypeResolver resolver
	
	@Inject ExpectationTestingTypeComputer typeComputer
	
	List<ITypeExpectation> expectations
	
	boolean pendingAssert = false;
	
	def expects(String input) {
		val expression = expression(input, false)
		resolver.initializeFrom(expression)
		resolver.reentrantResolve
		pendingAssert = true
		return this
	}
	
	def types(String... names) {
		assertTrue(pendingAssert)
		pendingAssert = false
		assertEquals(expectations.map[getExpectedType?.simpleName].toString, names.size, expectations.size)
		assertEquals(names.toSet as Object, expectations.map[getExpectedType?.simpleName].toSet)
		return this
	}
	
	def nothing() {
		assertTrue(pendingAssert)
		pendingAssert = false
		assertEquals(1, expectations.size)
		val expectation = expectations.head
		assertTrue(expectation.isNoTypeExpectation)
		assertTrue(expectation.isVoidTypeAllowed)
		assertNull(expectation.getExpectedType)
		return this
	}
	
	def notVoid() {
		assertTrue(pendingAssert)
		pendingAssert = false
		assertEquals(1, expectations.size)
		val expectation = expectations.head
		assertFalse(expectation.isNoTypeExpectation)
		assertFalse(expectation.isVoidTypeAllowed)
		assertNull(expectation.getExpectedType)
		return this
	}
	
	override setUp() throws Exception {
		super.setUp()
		typeComputer.test = this
		pendingAssert = false
		resolver.typeComputer = typeComputer
		expectations = newArrayList
	}
	
	@After
	def void tearDown() throws Exception {
		assertFalse(pendingAssert)
		pendingAssert = false
		expectations = null
		typeComputer.test = null
		resolver.typeComputer = null
	}
	
	def void recordExpectation(ITypeComputationState state) {
		expectations += state.getImmediateExpectations	
	}

	@Test
	def void testIfCondition() {
		"if (null) true".expects.types('boolean')
	}
	
	@Test
	def void testNotLastExpressionInBlock() {
		"{ null true }".expects.nothing
	}
	
	@Test
	def void testSwitchValue() {
		"switch null case true: true".expects.notVoid
	}
	
	@Test
	def void testAssignment() {
		"{ val String s = null }".expects.types('String')
	}
	
	@Test
	def void testTransitiveAssignment() {
		"{ val StringBuilder s = if (true) null }".expects.types('StringBuilder')
	}
	
	@Test
	def void testFeatureCallArgument_01() {
		"''.substring(null)".expects.types('int')
	}
	
	@Test
	def void testFeatureCallArgument_02() {
		"newArrayList.<String>findFirst(null)".expects.types('Function1<? super String, Boolean>')
	}
	
	@Test
	def void testFeatureCallArgument_03() {
		"newArrayList.findFirst(null)".expects.types('Function1<? super Unbound[T], Boolean>')
	}
	
	@Test
	def void testFeatureCallArgument_04() {
		"<String>newArrayList.findFirst(null)".expects.types('Function1<? super String, Boolean>')
	}
	
	@Test
	def void testFeatureCallArgument_05() {
		"newArrayList('').findFirst(null)".expects.types('Function1<? super String, Boolean>')
	}
	
	@Test
	@Ignore("TODO null type is bound differently")
	def void testExtensionReceiver_01() {
		"null.isNullOrEmpty()".expects.types('String')
	}
	
	@Test
	@Ignore("TODO Add synonyms to expectation, resolve")
	def void testFeatureCallVarArgument_01() {
		"newArrayList(null)".expects.types('unbound/T')
	}
	
	@Test
	def void testFeatureCallVarArgument_02() {
		"newArrayList(null, '')".expects.types('String')
	}
	
	@Test
	@Ignore("TODO Propagate expectation")
	def void testFeatureCallVarArgument_03() {
		"{ val Iterable<String> iterable = newArrayList(null) }".expects.types('String[]', 'String')
	}
	
	@Test
	@Ignore("TODO Add synonyms to expectation")
	def void testForLoop_01() {
		"for(int x: null) {}".expects.types('int[]', 'Iterable<Integer>')
	}
}

@Singleton
class ExpectationTestingTypeComputer extends XbaseTypeComputer {
	
	@Property
	ExpectationTest test
	
	override protected _computeTypes(XNullLiteral object, ITypeComputationState state) {
		test.recordExpectation(state)
		super._computeTypes(object, state)
	}
	
}
