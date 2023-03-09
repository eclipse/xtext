/**
 * Copyright (c) 2013, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ArrayTypesTest extends AbstractXbaseTestCase {
	@Inject
	private IBatchTypeResolver typeResolver;

	@Test
	public void testTryConvertToArray_01() throws Exception {
		LightweightTypeReference typeReference = toTypeReference("Iterable<?>");
		ArrayTypeReference arrayType = typeReference.tryConvertToArray();
		assertEquals("Object[]", arrayType.getSimpleName());
	}

	@Test
	public void testTryConvertToArray_02() throws Exception {
		LightweightTypeReference typeReference = toTypeReference("Iterable<? extends String>");
		ArrayTypeReference arrayType = typeReference.tryConvertToArray();
		assertEquals("String[]", arrayType.getSimpleName());
	}

	@Test
	public void testTryConvertToArray_03() throws Exception {
		LightweightTypeReference typeReference = toTypeReference("java.util.Collection");
		ArrayTypeReference arrayType = typeReference.tryConvertToArray();
		assertEquals("Object[]", arrayType.getSimpleName());
	}

	@Test
	public void testTryConvertToArray_04() throws Exception {
		LightweightTypeReference typeReference = toTypeReference(
				"org.eclipse.xtext.xbase.tests.typesystem.ClosureTypeComputerUnitTest.StringIterable");
		ArrayTypeReference arrayType = typeReference.tryConvertToArray();
		assertEquals("String[]", arrayType.getSimpleName());
	}

	@Test
	public void testTryConvertToArray_05() throws Exception {
		LightweightTypeReference typeReference = toTypeReference(
				"org.eclipse.xtext.xbase.tests.typesystem.ClosureTypeComputerUnitTest.CharSequenceIterable");
		ArrayTypeReference arrayType = typeReference.tryConvertToArray();
		// intuitively one would assume CharSequence[] but Object[] fulfills the raw type contract of Java
		assertEquals("Object[]", arrayType.getSimpleName());
	}

	@Test
	public void testTryConvertToArray_06() throws Exception {
		LightweightTypeReference typeReference = toTypeReference(
				"org.eclipse.xtext.xbase.tests.typesystem.ClosureTypeComputerUnitTest.CharSequenceIterable<StringBuffer>");
		ArrayTypeReference arrayType = typeReference.tryConvertToArray();
		assertEquals("StringBuffer[]", arrayType.getSimpleName());
	}

	@Test
	public void testTryConvertToArray_07() throws Exception {
		LightweightTypeReference typeReference = toTypeReference(
				"org.eclipse.xtext.xbase.tests.typesystem.ClosureTypeComputerUnitTest.StrangeIterable");
		ArrayTypeReference arrayType = typeReference.tryConvertToArray();
		assertEquals("Object[]", arrayType.getSimpleName());
	}

	@Test
	public void testTryConvertToArray_08() throws Exception {
		LightweightTypeReference typeReference = toTypeReference(
				"org.eclipse.xtext.xbase.tests.typesystem.ClosureTypeComputerUnitTest.StrangeIterable<String>");
		ArrayTypeReference arrayType = typeReference.tryConvertToArray();
		assertEquals("Object[]", arrayType.getSimpleName());
	}

	@Test
	public void testTryConvertToArray_09() throws Exception {
		LightweightTypeReference typeReference = toTypeReference(
				"org.eclipse.xtext.xbase.tests.typesystem.ClosureTypeComputerUnitTest.StrangeStringIterable");
		ArrayTypeReference arrayType = typeReference.tryConvertToArray();
		// intuitively one would assume String[] but Object[] fulfills the raw type contract of Java
		assertEquals("Object[]", arrayType.getSimpleName());
	}

	@Test
	public void testTryConvertToArray_10() throws Exception {
		LightweightTypeReference typeReference = toTypeReference(
				"org.eclipse.xtext.xbase.tests.typesystem.ClosureTypeComputerUnitTest.StrangeStringIterable<Integer>");
		ArrayTypeReference arrayType = typeReference.tryConvertToArray();
		assertEquals("String[]", arrayType.getSimpleName());
	}

	@Test
	public void testTryConvertToArray_11() throws Exception {
		LightweightTypeReference typeReference = toTypeReference(
				"org.eclipse.xtext.xbase.tests.typesystem.ClosureTypeComputerUnitTest.IterableContainer<String>.Iter");
		ArrayTypeReference arrayType = typeReference.tryConvertToArray();
		assertEquals("String[]", arrayType.getSimpleName());
	}

	protected LightweightTypeReference toTypeReference(String reference) throws Exception {
		String expression = "null as " + reference;
		XCastedExpression castExpression = (XCastedExpression) expression(expression);
		IResolvedTypes resolvedTypes = typeResolver.resolveTypes(castExpression);
		return resolvedTypes.getActualType(castExpression);
	}
}
