/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typesystem

import com.google.inject.Inject
import org.eclipse.xtext.xbase.XCastedExpression
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ArrayTypesTest extends AbstractXbaseTestCase {
	
	@Inject
	IBatchTypeResolver typeResolver
	
	@Test
	def void testTryConvertToArray_01() {
		val typeReference = 'Iterable<?>'.toTypeReference
		val arrayType = typeReference.tryConvertToArray
		assertEquals('Object[]', arrayType.simpleName)
	}
	
	@Test
	def void testTryConvertToArray_02() {
		val typeReference = 'Iterable<? extends String>'.toTypeReference
		val arrayType = typeReference.tryConvertToArray
		assertEquals('String[]', arrayType.simpleName)
	}
	
	@Test
	def void testTryConvertToArray_03() {
		val typeReference = 'java.util.Collection'.toTypeReference
		val arrayType = typeReference.tryConvertToArray
		assertEquals('Object[]', arrayType.simpleName)
	}
	
	@Test
	def void testTryConvertToArray_04() {
		val typeReference = 'org.eclipse.xtext.xbase.tests.typesystem.ClosureTypeComputerUnitTest.StringIterable'.toTypeReference
		val arrayType = typeReference.tryConvertToArray
		assertEquals('String[]', arrayType.simpleName)
	}
	
	@Test
	def void testTryConvertToArray_05() {
		val typeReference = 'org.eclipse.xtext.xbase.tests.typesystem.ClosureTypeComputerUnitTest.CharSequenceIterable'.toTypeReference
		val arrayType = typeReference.tryConvertToArray
		// intuitively one would assume CharSequence[] but Object[] fulfills the raw type contract of Java
		assertEquals('Object[]', arrayType.simpleName)
	}
	
	@Test
	def void testTryConvertToArray_06() {
		val typeReference = 'org.eclipse.xtext.xbase.tests.typesystem.ClosureTypeComputerUnitTest.CharSequenceIterable<StringBuffer>'.toTypeReference
		val arrayType = typeReference.tryConvertToArray
		assertEquals('StringBuffer[]', arrayType.simpleName)
	}
	
	@Test
	def void testTryConvertToArray_07() {
		val typeReference = 'org.eclipse.xtext.xbase.tests.typesystem.ClosureTypeComputerUnitTest.StrangeIterable'.toTypeReference
		val arrayType = typeReference.tryConvertToArray
		assertEquals('Object[]', arrayType.simpleName)
	}
	
	@Test
	def void testTryConvertToArray_08() {
		val typeReference = 'org.eclipse.xtext.xbase.tests.typesystem.ClosureTypeComputerUnitTest.StrangeIterable<String>'.toTypeReference
		val arrayType = typeReference.tryConvertToArray
		assertEquals('Object[]', arrayType.simpleName)
	}
	
	@Test
	def void testTryConvertToArray_09() {
		val typeReference = 'org.eclipse.xtext.xbase.tests.typesystem.ClosureTypeComputerUnitTest.StrangeStringIterable'.toTypeReference
		val arrayType = typeReference.tryConvertToArray
		// intuitively one would assume String[] but Object[] fulfills the raw type contract of Java
		assertEquals('Object[]', arrayType.simpleName)
	}
	
	@Test
	def void testTryConvertToArray_10() {
		val typeReference = 'org.eclipse.xtext.xbase.tests.typesystem.ClosureTypeComputerUnitTest.StrangeStringIterable<Integer>'.toTypeReference
		val arrayType = typeReference.tryConvertToArray
		assertEquals('String[]', arrayType.simpleName)
	}
	
	@Test
	def void testTryConvertToArray_11() {
		val typeReference = 'org.eclipse.xtext.xbase.tests.typesystem.ClosureTypeComputerUnitTest.IterableContainer<String>.Iter'.toTypeReference
		val arrayType = typeReference.tryConvertToArray
		assertEquals('String[]', arrayType.simpleName)
	}
	
	protected def LightweightTypeReference toTypeReference(String reference) {
		val expression = '''null as «reference»'''
		val castExpression = expression.expression as XCastedExpression
		val resolvedTypes = typeResolver.resolveTypes(castExpression)
		return resolvedTypes.getActualType(castExpression)
	}
}