/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.typesystem

import com.google.inject.Inject
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.XClosure
import org.eclipse.xtext.xbase.XFeatureCall
import org.eclipse.xtext.xbase.XNumberLiteral
import org.eclipse.xtext.xbase.typesystem.arguments.IFeatureCallArguments
import org.eclipse.xtext.xbase.typesystem.arguments.ReorderedFeatureCallArguments
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ReorderedFeatureCallArgumentsTest extends AbstractTestingTypeReferenceOwner {
	
	@Inject extension IXtendJvmAssociations
	@Inject TestableExpressionArgumentFactory factory
	
	@Test
	def void test_01() {
		val arguments = 'String s, int i'.toArgumentsWithoutReceiver('[], 1')
		assertEquals(2, arguments.argumentCount)
		assertTrue(arguments.hasUnprocessedArguments)
		val firstSlot = arguments.nextUnprocessedArgumentSlot
		assertFalse(firstSlot.varArg)
		assertFalse(firstSlot.superfluous)
		assertTrue(firstSlot.argumentExpression instanceof XNumberLiteral)
		assertEquals("int", firstSlot.declaredType.simpleName)
		assertFalse(arguments.isProcessed(0))
		firstSlot.markProcessed
		assertTrue(arguments.isProcessed(0))
		assertTrue(arguments.hasUnprocessedArguments)
		val secondSlot = arguments.nextUnprocessedArgumentSlot
		assertFalse(secondSlot.varArg)
		assertFalse(secondSlot.superfluous)
		assertTrue(secondSlot.argumentExpression instanceof XClosure)
		assertEquals("String", secondSlot.declaredType.simpleName)
		assertFalse(arguments.isProcessed(1))
		secondSlot.markProcessed
		assertTrue(arguments.isProcessed(1))
		assertFalse(arguments.hasUnprocessedArguments)
	}
	
	@Test
	def void test_02() {
		val arguments = 'String s, int i'.toArgumentsWithReceiver('[], 1')
		assertEquals(3, arguments.argumentCount)
		assertTrue(arguments.hasUnprocessedArguments)
		val firstSlot = arguments.nextUnprocessedArgumentSlot
		assertFalse(firstSlot.varArg)
		assertFalse(firstSlot.superfluous)
		assertTrue(firstSlot.argumentExpression instanceof XNumberLiteral)
		assertEquals("int", firstSlot.declaredType.simpleName)
		assertTrue(arguments.isProcessed(0))
		assertFalse(arguments.isProcessed(1))
		firstSlot.markProcessed
		assertTrue(arguments.isProcessed(1))
		assertTrue(arguments.hasUnprocessedArguments)
		val secondSlot = arguments.nextUnprocessedArgumentSlot
		assertFalse(secondSlot.varArg)
		assertFalse(secondSlot.superfluous)
		assertTrue(secondSlot.argumentExpression instanceof XClosure)
		assertEquals("String", secondSlot.declaredType.simpleName)
		assertFalse(arguments.isProcessed(2))
		secondSlot.markProcessed
		assertTrue(arguments.isProcessed(2))
		assertFalse(arguments.hasUnprocessedArguments)
	}
	
	@Test
	def void test_03() {
		val arguments = 'String s, int i'.toArgumentsWithoutReceiver('[], 1')
		arguments.withIndizes(1, 0)
	}
	
	@Test
	def void test_04() {
		val arguments = 'String s, int i, int j, int k, int l, int m'.toArgumentsWithoutReceiver('[], 1, [], 1, []')
		arguments.withIndizes(1, 3, 0, 2, 4)
	}
	
	@Test
	def void test_05() {
		val arguments = 'String s, int i, int j, int k'.toArgumentsWithoutReceiver('[], 1, [], 1, [], 1')
		arguments.withIndizes(1, 3, 0, 2, 4, 5)
	}
	
	@Test
	def void test_06() {
		val arguments = 'String s, int i, int j'.toArgumentsWithoutReceiver('[], 1, [], 1, [], 1')
		arguments.withIndizes(1, 0, 2, 3, 4, 5)
	}
	
	@Test
	def void test_07() {
		val arguments = 'String s, int i, long j, boolean k, float l, double m'.toArgumentsWithoutReceiver('[], 1, [], 1, []')
		arguments.withTypes("int", "boolean", "String", "long", "float")
	}
	
	@Test
	def void test_08() {
		val arguments = 'String s, int i, long j, boolean k'.toArgumentsWithoutReceiver('[], 1, [], 1, [], 1')
		arguments.withTypes("int", "boolean", "String", "long", null, null)
	}
	
	@Test
	def void test_09() {
		val arguments = 'String s, int i, long j'.toArgumentsWithoutReceiver('[], 1, [], 1, [], 1')
		arguments.withTypes("int", "String", "long", null, null, null)
	}
	
	@Test
	def void testBug457779_01() {
		val arguments = 'String s, int i'.toArgumentsWithReceiver('[], 1')
		val first = arguments.getArgument(0)
		assertNull(first)
		val firstType = arguments.getDeclaredTypeForLambda(0)
		assertNull(firstType)
		
		val third = arguments.getArgument(1)
		assertTrue(third instanceof XNumberLiteral)
		val thirdType = arguments.getDeclaredTypeForLambda(1)
		assertEquals('int', thirdType.simpleName)

		val second = arguments.getArgument(2)
		assertTrue(second instanceof XClosure)
		val secondType = arguments.getDeclaredTypeForLambda(2)
		assertEquals('String', secondType.simpleName)
		
		try {
			arguments.getArgument(3)
			fail("Expected exception")
		} catch(IndexOutOfBoundsException expected) {}
		try {
			arguments.getDeclaredTypeForLambda(3)
			fail("Expected exception")
		} catch(IndexOutOfBoundsException expected) {}
	}
	
	@Test
	def void testBug457779_02() {
		val arguments = 'String s, int i'.toArgumentsWithoutReceiver('[], 1')
		
		val second = arguments.getArgument(0)
		assertTrue(second instanceof XNumberLiteral)
		val secondType = arguments.getDeclaredTypeForLambda(0)
		assertEquals('int', secondType.simpleName)
		
		val first = arguments.getArgument(1)
		assertTrue(first instanceof XClosure)
		val firstType = arguments.getDeclaredTypeForLambda(1)
		assertEquals('String', firstType.simpleName)
		
		try {
			arguments.getArgument(2)
			fail("Expected exception")
		} catch(IndexOutOfBoundsException expected) {}
		try {
			arguments.getDeclaredTypeForLambda(2)
			fail("Expected exception")
		} catch(IndexOutOfBoundsException expected) {}
	}
	
	protected def void withIndizes(IFeatureCallArguments arguments, int... indexes) {
		for (it : indexes) {
			assertTrue(arguments.hasUnprocessedArguments)
			val slot = arguments.nextUnprocessedArgumentSlot
			val expression = slot.argumentExpression
			val featureCall = expression.eContainer as XFeatureCall
			assertEquals(it, featureCall.featureCallArguments.indexOf(expression))
			slot.markProcessed
		}
		assertFalse(arguments.hasUnprocessedArguments)
	}
	
	protected def void withTypes(IFeatureCallArguments arguments, String... types) {
		for (it : types) {
			assertTrue(arguments.hasUnprocessedArguments)
			val slot = arguments.nextUnprocessedArgumentSlot
			assertEquals(it === null, slot.superfluous)
			if (it !== null)
				assertEquals(it, slot.declaredType.simpleName)
			slot.markProcessed
		}
		assertFalse(arguments.hasUnprocessedArguments)
	}
	
	protected def toArgumentsWithoutReceiver(String signature, String invocation) {
		toArguments(signature, invocation, false)
	}
	
	protected def toArgumentsWithReceiver(String signature, String invocation) {
		toArguments(signature, invocation, true)
	}
	
	protected def toArguments(String signature, String invocation, boolean receiver) {
		val String functionString = '''
			def void m(«signature») {
				m(«invocation»)
			}
		'''
		val function = function(functionString)
		val body = function.expression as XBlockExpression
		val featureCall = body.expressions.head as XFeatureCall
		val arguments = featureCall.featureCallArguments
		val operation = function.directlyInferredOperation
		val result = factory.createStandardArguments(arguments, operation.parameters, receiver, owner)
		assertTrue(result.class == ReorderedFeatureCallArguments)
		return result
	}
	
}
