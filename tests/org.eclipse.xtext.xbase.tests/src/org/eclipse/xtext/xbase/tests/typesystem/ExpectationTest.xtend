/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typesystem

import com.google.inject.Inject
import java.util.List
import org.eclipse.xtext.xbase.XNullLiteral
import org.eclipse.xtext.xbase.junit.typesystem.PublicReentrantTypeResolver
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationState
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation
import org.eclipse.xtext.xbase.typesystem.computation.XbaseTypeComputer
import org.junit.After
import org.junit.Ignore
import org.junit.Test
import org.junit.Before
import org.junit.runner.RunWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.InjectWith

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(typeof(XtextRunner))
@InjectWith(typeof(XbaseNewTypeSystemInjectorProvider))
class ExpectationTest extends AbstractXbaseTestCase {
	
	@Inject PublicReentrantTypeResolver resolver
	
	@Inject ExpectationTestingTypeComputer typeComputer
	
	List<String> expectations
	List<ITypeExpectation> finalExpectations
	
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
		assertEquals(expectations.toString, names.size, expectations.size)
		assertEquals(names.toSet as Object, expectations.toSet)
		return this
	}
	
	def finalizedAs(String... names) {
		assertFalse(pendingAssert)
		assertEquals(finalExpectations.map[ expectedType?.simpleName ].toString, names.size, expectations.size)
		assertEquals(names.toSet as Object, finalExpectations.map[ expectedType?.simpleName ].toSet)
		return this
	}
	
	def nothing() {
		assertTrue(pendingAssert)
		pendingAssert = false
		assertEquals(1, finalExpectations.size)
		val expectation = finalExpectations.head
		assertTrue(expectation.isNoTypeExpectation)
		assertTrue(expectation.isVoidTypeAllowed)
		assertNull(expectation.getExpectedType)
		return this
	}
	
	def notVoid() {
		assertTrue(pendingAssert)
		pendingAssert = false
		assertEquals(1, finalExpectations.size)
		val expectation = finalExpectations.head
		assertFalse(expectation.isNoTypeExpectation)
		assertFalse(expectation.isVoidTypeAllowed)
		assertNull(expectation.getExpectedType)
		return this
	}
	
	@Before
	def void setUp() throws Exception {
		typeComputer.test = this
		pendingAssert = false
		resolver.typeComputer = typeComputer
		expectations = newArrayList
		finalExpectations = newArrayList
	}
	
	@After
	def void tearDown() throws Exception {
		assertFalse(pendingAssert)
		pendingAssert = false
		expectations = null
		finalExpectations = null
		typeComputer.test = null
		resolver.typeComputer = null
	}
	
	def void recordExpectation(ITypeComputationState state) {
		finalExpectations += state.expectations
		expectations += state.expectations.map [ expectedType?.simpleName ]	
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
	def void testAssignment_01() {
		"{ val String s = null }".expects.types('String')
	}
	
	@Test
	def void testAssignment_02() {
		"{ val String s; s = null }".expects.types('String')
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
		"newArrayList.<String>findFirst(null)".expects
			.types('Function1<? super String, Boolean>')
			.finalizedAs('Function1<? super String, Boolean>')
	}
	
	@Test
	def void testFeatureCallArgument_03() {
		"newArrayList.findFirst(null)".expects
			.types('Function1<? super Unbound[T], Boolean>')
			.finalizedAs('Function1<? super Object, Boolean>')
	}
	
	@Test
	def void testFeatureCallArgument_04() {
		"<String>newArrayList.findFirst(null)".expects
			.types('Function1<? super Unbound[T], Boolean>')
			.finalizedAs('Function1<? super String, Boolean>')
	}
	
	@Test
	def void testFeatureCallArgument_05() {
		"newArrayList('').findFirst(null)".expects
			.types('Function1<? super Unbound[T], Boolean>')
			.finalizedAs('Function1<? super String, Boolean>')
	}
	
	@Test
	def void testFeatureCallArgument_06() {
		"{
			val (Iterable<CharSequence>)=>void f
			f.apply(null)
		}".expects
			.types('Iterable<CharSequence>')
			.finalizedAs('Iterable<CharSequence>')
	}
	
	@Test
	@Ignore("TODO null type is bound differently")
	def void testExtensionReceiver_01() {
		"null.isNullOrEmpty()".expects.types('String', 'Iterable<Unbound[T]>')
	}
	
	@Test
	def void testFeatureCallVarArgument_01() {
		"newArrayList(null)".expects.types('Unbound[T]', 'Unbound[T][]').finalizedAs("Object", "Object[]")
	}
	
	@Test
	def void testFeatureCallVarArgument_02() {
		"newArrayList(null, '')".expects.types('Unbound[T]').finalizedAs("String")
	}
	
	@Test
	def void testFeatureCallVarArgument_03() {
		"{ val Iterable<String> iterable = newArrayList(null) }".expects
			.types('Unbound[T][]', 'Unbound[T]')
			.finalizedAs('String[]', 'String')
	}
	
	@Test
	def void testForLoop_01() {
		"for(int x: null) {}".expects.types('int[]').finalizedAs('int[]')
	}
	
	@Test
	def void testUpperBound_01() {
		"(1 as Comparable<?>).compareTo(null)".expects.types('null').finalizedAs('null')
	}
	
	@Test
	def void testLowerBound_01() {
		"(1 as Comparable<? super CharSequence>).compareTo(null)".expects.types('CharSequence').finalizedAs('CharSequence')
	}
}

class ExpectationTestingTypeComputer extends XbaseTypeComputer {
	
	@Property
	ExpectationTest test
	
	override protected _computeTypes(XNullLiteral object, ITypeComputationState state) {
		test.recordExpectation(state)
		super._computeTypes(object, state)
	}
	
}
