/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.typesystem

import com.google.inject.Inject
import java.util.NoSuchElementException
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.XBooleanLiteral
import org.eclipse.xtext.xbase.XFeatureCall
import org.eclipse.xtext.xbase.XNumberLiteral
import org.eclipse.xtext.xbase.XStringLiteral
import org.eclipse.xtext.xbase.typesystem.arguments.StandardFeatureCallArguments
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class StandardFeatureCallArgumentsTest extends AbstractTestingTypeReferenceOwner {
	
	@Inject extension IXtendJvmAssociations
	@Inject TestableExpressionArgumentFactory factory
	
	@Test
	def void test_01() {
		val arguments = ''.toArgumentsWithoutReceiver('')
		assertFalse(arguments.hasUnprocessedArguments)
		assertEquals(0, arguments.argumentCount)
	}
	
	@Test(expected = NoSuchElementException)
	def void test_02() {
		val arguments = ''.toArgumentsWithoutReceiver('')
		arguments.nextUnprocessedArgumentSlot
	}
	
	@Test
	def void test_03() {
		val arguments = 'String s'.toArgumentsWithoutReceiver('""')
		assertTrue(arguments.hasUnprocessedArguments)
		assertEquals(1, arguments.argumentCount)
		val singleSlot = arguments.nextUnprocessedArgumentSlot
		assertFalse(singleSlot.varArg)
		assertFalse(singleSlot.superfluous)
		assertTrue(singleSlot.argumentExpression instanceof XStringLiteral)
		assertEquals("String", singleSlot.declaredType.simpleName)
		singleSlot.markProcessed
		assertFalse(arguments.hasUnprocessedArguments)
	}
	
	@Test
	def void test_04() {
		val arguments = 'String s, int i'.toArgumentsWithoutReceiver('"", 1')
		assertEquals(2, arguments.argumentCount)
		assertTrue(arguments.hasUnprocessedArguments)
		val firstSlot = arguments.nextUnprocessedArgumentSlot
		assertFalse(firstSlot.varArg)
		assertFalse(firstSlot.superfluous)
		assertTrue(firstSlot.argumentExpression instanceof XStringLiteral)
		assertEquals("String", firstSlot.declaredType.simpleName)
		assertFalse(arguments.isProcessed(0))
		firstSlot.markProcessed
		assertTrue(arguments.isProcessed(0))
		assertTrue(arguments.hasUnprocessedArguments)
		val secondSlot = arguments.nextUnprocessedArgumentSlot
		assertFalse(secondSlot.varArg)
		assertFalse(secondSlot.superfluous)
		assertTrue(secondSlot.argumentExpression instanceof XNumberLiteral)
		assertEquals("int", secondSlot.declaredType.simpleName)
		assertFalse(arguments.isProcessed(1))
		secondSlot.markProcessed
		assertTrue(arguments.isProcessed(1))
		assertFalse(arguments.hasUnprocessedArguments)
	}
	
	@Test
	def void test_05() {
		val arguments = ''.toArgumentsWithReceiver('')
		assertFalse(arguments.hasUnprocessedArguments)
		assertEquals(1, arguments.argumentCount)
	}
	
	@Test(expected = NoSuchElementException)
	def void test_06() {
		val arguments = ''.toArgumentsWithReceiver('')
		arguments.nextUnprocessedArgumentSlot
	}
	
	@Test
	def void test_08() {
		val arguments = 'String s, int i'.toArgumentsWithReceiver('"", 1')
		assertEquals(3, arguments.argumentCount)
		assertTrue(arguments.hasUnprocessedArguments)
		val firstSlot = arguments.nextUnprocessedArgumentSlot
		assertFalse(firstSlot.varArg)
		assertFalse(firstSlot.superfluous)
		assertTrue(firstSlot.argumentExpression instanceof XStringLiteral)
		assertEquals("String", firstSlot.declaredType.simpleName)
		assertTrue(arguments.isProcessed(0))
		assertFalse(arguments.isProcessed(1))
		firstSlot.markProcessed
		assertTrue(arguments.isProcessed(1))
		assertTrue(arguments.hasUnprocessedArguments)
		val secondSlot = arguments.nextUnprocessedArgumentSlot
		assertFalse(secondSlot.varArg)
		assertFalse(secondSlot.superfluous)
		assertTrue(secondSlot.argumentExpression instanceof XNumberLiteral)
		assertEquals("int", secondSlot.declaredType.simpleName)
		assertFalse(arguments.isProcessed(2))
		secondSlot.markProcessed
		assertTrue(arguments.isProcessed(2))
		assertFalse(arguments.hasUnprocessedArguments)
	}
	
	@Test
	def void test_09() {
		val arguments = 'String s'.toArgumentsWithoutReceiver('"", 1')
		assertTrue(arguments.hasUnprocessedArguments)
		assertEquals(2, arguments.argumentCount)
		val valid = arguments.nextUnprocessedArgumentSlot
		assertFalse(valid.varArg)
		assertFalse(valid.superfluous)
		assertTrue(valid.argumentExpression instanceof XStringLiteral)
		assertEquals("String", valid.declaredType.simpleName)
		valid.markProcessed
		assertTrue(arguments.hasUnprocessedArguments)
		
		val superfluous = arguments.nextUnprocessedArgumentSlot
		assertFalse(superfluous.varArg)
		assertTrue(superfluous.superfluous)
		assertTrue(superfluous.argumentExpression instanceof XNumberLiteral)
		assertFalse(arguments.isProcessed(1))
		superfluous.markProcessed
		assertTrue(arguments.isProcessed(1))
		assertFalse(arguments.hasUnprocessedArguments)
	}
	
	@Test
	def void test_10() {
		val arguments = 'String s'.toArgumentsWithReceiver('"", 1')
		assertTrue(arguments.hasUnprocessedArguments)
		assertEquals(3, arguments.argumentCount)
		val valid = arguments.nextUnprocessedArgumentSlot
		assertFalse(valid.varArg)
		assertFalse(valid.superfluous)
		assertTrue(valid.argumentExpression instanceof XStringLiteral)
		valid.markProcessed
		assertTrue(arguments.hasUnprocessedArguments)
		assertTrue(arguments.isProcessed(1))
		
		val superfluous = arguments.nextUnprocessedArgumentSlot
		assertFalse(superfluous.varArg)
		assertTrue(superfluous.superfluous)
		assertTrue(superfluous.argumentExpression instanceof XNumberLiteral)
		assertFalse(arguments.isProcessed(2))
		superfluous.markProcessed
		assertTrue(arguments.isProcessed(2))
		assertFalse(arguments.hasUnprocessedArguments)
	}
	
	@Test
	def void test_11() {
		val arguments = 'String s'.toArgumentsWithoutReceiver('')
		assertFalse(arguments.hasUnprocessedArguments)
	}
	
	@Test
	def void test_12() {
		// no reordering
		'String s, int i'.toArgumentsWithoutReceiver('"", []')
		'String s, int i'.toArgumentsWithReceiver('"", [], []')
	}
	
	@Test
	def void test_13() {
		// no reordering
		'String s, int i'.toArgumentsWithoutReceiver('[]')
		'String s, int i'.toArgumentsWithReceiver('[], [], []')
	}
	
	@Test
	def void test_14() {
		// no reordering
		'String s, int i'.toArgumentsWithoutReceiver('[]')
		'String s, int i'.toArgumentsWithReceiver('[], [], 1')
		'String s'.toArgumentsWithReceiver('[], 1, 1')
	}
	
	@Test
	def void testBug457779_01() {
		val arguments = 'String s, int i'.toArgumentsWithReceiver('"", 1')
		val first = arguments.getArgument(0)
		assertNull(first)
		val firstType = arguments.getDeclaredTypeForLambda(0)
		assertNull(firstType)
		
		val second = arguments.getArgument(1)
		assertTrue(second instanceof XStringLiteral)
		val secondType = arguments.getDeclaredTypeForLambda(1)
		assertEquals('String', secondType.simpleName)
		
		val third = arguments.getArgument(2)
		assertTrue(third instanceof XNumberLiteral)
		val thirdType = arguments.getDeclaredTypeForLambda(2)
		assertEquals('int', thirdType.simpleName)
		
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
		val arguments = 'String s, int i'.toArgumentsWithoutReceiver('"", 1')
		
		val first = arguments.getArgument(0)
		assertTrue(first instanceof XStringLiteral)
		val firstType = arguments.getDeclaredTypeForLambda(0)
		assertEquals('String', firstType.simpleName)
		
		val second = arguments.getArgument(1)
		assertTrue(second instanceof XNumberLiteral)
		val secondType = arguments.getDeclaredTypeForLambda(1)
		assertEquals('int', secondType.simpleName)
		
		try {
			arguments.getArgument(2)
			fail("Expected exception")
		} catch(IndexOutOfBoundsException expected) {}
		try {
			arguments.getDeclaredTypeForLambda(2)
			fail("Expected exception")
		} catch(IndexOutOfBoundsException expected) {}
	}
	
	@Test
	def void testBug457779_03() {
		val arguments = 'String s, int i'.toArgumentsWithoutReceiver('"", 1, true')
		
		val first = arguments.getArgument(0)
		assertTrue(first instanceof XStringLiteral)
		val firstType = arguments.getDeclaredTypeForLambda(0)
		assertEquals('String', firstType.simpleName)
		
		val second = arguments.getArgument(1)
		assertTrue(second instanceof XNumberLiteral)
		val secondType = arguments.getDeclaredTypeForLambda(1)
		assertEquals('int', secondType.simpleName)
		
		val third = arguments.getArgument(2)
		assertTrue(third instanceof XBooleanLiteral)
		val thirdType = arguments.getDeclaredTypeForLambda(2)
		assertNull('int', thirdType)
		
		try {
			arguments.getArgument(3)
			fail("Expected exception")
		} catch(IndexOutOfBoundsException expected) {}
		try {
			arguments.getDeclaredTypeForLambda(3)
			fail("Expected exception")
		} catch(IndexOutOfBoundsException expected) {}
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
		assertTrue(result.class == StandardFeatureCallArguments)
		return result
	}
	
}