/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typesystem

import com.google.inject.Inject
import java.util.List
import org.eclipse.xtext.xbase.XCastedExpression
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XFeatureCall
import org.eclipse.xtext.xbase.XNullLiteral
import org.eclipse.xtext.xbase.XNumberLiteral
import org.eclipse.xtext.xbase.XReturnExpression
import org.eclipse.xtext.xbase.junit.typesystem.PublicReentrantTypeResolver
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationState
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation
import org.eclipse.xtext.xbase.typesystem.computation.XbaseTypeComputer
import org.junit.After
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
abstract class AbstractExpectationTest extends AbstractXbaseTestCase {
	
	List<String> expectations
	List<ITypeExpectation> finalExpectations
	List<XExpression> expressions
	
	IResolvedTypes resolvedTypes
	XExpression rootExpression
	
	boolean pendingAssert = false;
	
	def ExpectationTestingTypeComputer getTypeComputer()
	def PublicReentrantTypeResolver getResolver()
	
	def expects(String input) {
		rootExpression = expression(input, false)
		resolver.initializeFrom(rootExpression)
		resolvedTypes = resolver.reentrantResolve(CancelIndicator.NullImpl)
		pendingAssert = true
		return this
	}
	
	def void clearData() {
		resolvedTypes = null
		expectations = newArrayList
		finalExpectations = newArrayList
		expressions = newArrayList
	}
	
	def types(String... names) {
		assertTrue(pendingAssert)
		pendingAssert = false
		assertEquals(expectations.toString, names.size, expectations.size)
		assertEquals(names.toSet, expectations.toSet)
		return this
	}
	
	def finalizedAs(String... names) {
		assertFalse(pendingAssert)
		assertEquals(finalExpectations.map[ expectedType?.simpleName ].toString, names.size, expectations.size)
		assertEquals(names.toSet, finalExpectations.map[ expectedType?.simpleName ].toSet)
		return this
	}
	
	def queriedAs(String... names) {
		pendingAssert = false
		val expectedTypes = expressions.map[ resolvedTypes.getExpectedType(it) ]
		assertEquals(expectedTypes.map[ simpleName ].toString, names.size, expectedTypes.size)
		assertEquals(names.toSet, expectedTypes.map[ simpleName ].toSet)
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
		clearData
	}
	
	@After
	def void tearDown() throws Exception {
		assertFalse(pendingAssert)
		pendingAssert = false
		expectations = null
		finalExpectations = null
		expressions = null
		resolvedTypes = null
		rootExpression = null
		typeComputer.test = null
		resolver.typeComputer = null
	}
	
	def void recordExpectation(XExpression expression, ITypeComputationState state) {
		finalExpectations += state.expectations
		expectations += state.expectations.map [ expectedType?.simpleName ]
		expressions += expression	
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
	def void testFeatureCallVarArgument_04() {
		typeComputer.predicate = [ it instanceof XReturnExpression ]
		"new foo.ClassWithGenericMethod().genericMethod(return null)".expects
			.types('Unbound[T]')
			.finalizedAs('Object')
	}
	
	@Test
	def void testForLoop_01() {
		"for(int x: null) {}".expects.types('int[] | Iterable<? extends Integer> | Integer[]').finalizedAs('int[] | Iterable<? extends Integer> | Integer[]')
	}
	
	@Test
	def void testForLoop_02() {
		"for(String x: null) {}".expects.types('Iterable<? extends String> | String[]').finalizedAs('Iterable<? extends String> | String[]')
	}
	
	@Test
	def void testForLoop_03() {
		"for(Integer x: null) {}".expects.types('Iterable<? extends Integer> | int[] | Integer[]').finalizedAs('Iterable<? extends Integer> | int[] | Integer[]')
	}
	
	@Test
	def void testUpperBound_01() {
		"(1 as Comparable<?>).compareTo(null)".expects.types('null').finalizedAs('null')
	}
	
	@Test
	def void testLowerBound_01() {
		"(1 as Comparable<? super CharSequence>).compareTo(null)".expects.types('CharSequence').finalizedAs('CharSequence')
	}
	
	@Test 
	def void testReturn_01() {
		"return null".expects.notVoid
	}
	
	@Test 
	def void testReturn_02() {
		"return { { null } }".expects.notVoid
	}
	
	@Test 
	def void testReturn_03() {
		"return if (true) { { null } }".expects.notVoid
	}
	
	@Test 
	def void testReturn_04() {
		"return if (true) { null '' }".expects.nothing
	}
	
	@Test
	def void testRawType_01() {
		"('' as Comparable).compareTo(null)".expects.types('Object')
	}
	
	@Test
	def void testInvocationOnPrimitive() {
		typeComputer.predicate = [ it instanceof XNumberLiteral ]
		"1L.intValue".expects
			.types(null as String)
			.finalizedAs(null as String)
			.queriedAs('Long')
	}
	
	@Test
	def void testImplicitReceiver() {
		typeComputer.predicate = [ false ]
		"{val it = 1L intValue}".expects
		val intValue = rootExpression.eAllContents.filter(typeof(XFeatureCall)).head
		expressions += intValue.implicitReceiver
		queriedAs('Long')
	}
	
	@Test
	def void testExtension() {
		typeComputer.predicate = [ it instanceof XCastedExpression ]
		"(null as String[]).size".expects
			.types(null as String)
			.finalizedAs(null as String)
			.queriedAs('List<String>')
	}
	
	@Test
	def void testImplicitFirstArgument() {
		typeComputer.predicate = [ false ]
		"{val it = null as String[] head}".expects
		val size = rootExpression.eAllContents.filter(typeof(XFeatureCall)).head
		expressions += size.implicitFirstArgument
		queriedAs('Iterable<String>')
	}
	
	@Test
	def void testBug379531_01() {
		typeComputer.predicate = [ it instanceof XCastedExpression ]
		"newArrayList('', '', null as String)".expects.types('Unbound[T]').finalizedAs('String')
	}
	
	@Test
	def void testBug379531_02() {
		typeComputer.predicate = [ it instanceof XCastedExpression ]
		"newArrayList('', '', null as CharSequence)".expects.types('Unbound[T]').finalizedAs('CharSequence')
	}
	
	@Test
	def void testBug379531_03() {
		"newArrayList('', '', null)".expects.types('Unbound[T]').finalizedAs('String')
	}
	
	@Test
	def void testExpectationFromTypeParameter_01() {
		"{ val Iterable<Number> iterable = newArrayList(null) }".expects.types('Unbound[T]', 'Unbound[T][]').finalizedAs('Number', 'Number[]')
	}
	
	@Test
	def void testExpectationFromTypeParameter_02() {
		"{ val Iterable<Iterable<Number>> iterable = newArrayList(newArrayList(null)) }".expects.types(
			'Unbound[T]', 'Unbound[T][]', 'Unbound[T]', 'Unbound[T][]').finalizedAs('Number', 'Number[]', 'Iterable<Number>', 'Iterable<Number>[]')
	}
	
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ExpectationTest extends AbstractExpectationTest {
	@Inject ExpectationTestingTypeComputer typeComputer
	
	@Inject PublicReentrantTypeResolver resolver
	
	override getTypeComputer() {
		typeComputer
	}
	
	override getResolver() {
		resolver
	}
	
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ExpectationTestingTypeComputer extends XbaseTypeComputer {
	
	@Accessors
	AbstractExpectationTest test
	
	@Accessors() (XExpression)=>boolean predicate = [ it instanceof XNullLiteral ]
	
	override computeTypes(XExpression expression, ITypeComputationState state) {
		if (predicate.apply(expression)) {
			test.recordExpectation(expression, state)
		}
		super.computeTypes(expression, state)
	}
	
}
