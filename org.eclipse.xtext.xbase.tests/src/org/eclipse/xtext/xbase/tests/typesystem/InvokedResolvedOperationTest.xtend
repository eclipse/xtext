/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typesystem

import com.google.inject.Inject
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase
import org.eclipse.xtext.xbase.typesystem.^override.InvokedResolvedOperation
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class InvokedResolvedOperationTest extends AbstractXbaseTestCase {
	
	@Inject
	InvokedResolvedOperation.Provider invokedOperationProvider
	
	def InvokedResolvedOperation toOperation(String expression) {
		val featureCall = expression.expression as XAbstractFeatureCall
		return invokedOperationProvider.resolve(featureCall)
	}
	
	@Test
	def void testIteratorOfObject() {
		val operation = 'newArrayList.iterator'.toOperation
		assertEquals('Iterator<Object>', operation.resolvedReturnType.simpleName)
		assertEquals('ArrayList<Object>', operation.contextType.simpleName)
		assertEquals('iterator()', operation.simpleSignature)
	}
	
	@Test
	def void testStaticMethod() {
		val operation = 'newArrayList'.toOperation
		assertEquals('ArrayList<Object>', operation.resolvedReturnType.simpleName)
		assertEquals('newArrayList(Object[])', operation.simpleSignature)
	}
	
	@Test
	def void testToArray_01() {
		val operation = 'newArrayList.toArray'.toOperation
		assertEquals('Object[]', operation.resolvedReturnType.simpleName)
		assertEquals('toArray()', operation.simpleSignature)
	}
	
	@Test
	def void testToArray_02() {
		val operation = '<String>newArrayList.toArray'.toOperation
		assertEquals('Object[]', operation.resolvedReturnType.simpleName)
		assertEquals('toArray()', operation.simpleSignature)
	}
	
	@Test
	def void testToArrayWithParam_01() {
		val operation = 'newArrayList.toArray(null as String[])'.toOperation
		assertEquals('String[]', operation.resolvedReturnType.simpleName)
		assertEquals('toArray(String[])', operation.simpleSignature)
	}
	
	@Test
	def void testToArrayWithParam_02() {
		val operation = 'newArrayList.<CharSequence>toArray(null as String[])'.toOperation
		assertEquals('CharSequence[]', operation.resolvedReturnType.simpleName)
		assertEquals('toArray(CharSequence[])', operation.simpleSignature)
	}
	
	@Test
	def void testArrayListOfStringIteratesStrings() {
		val operation = 'newArrayList("").iterator'.toOperation
		assertEquals('Iterator<String>', operation.resolvedReturnType.simpleName)
		assertEquals('ArrayList<String>', operation.contextType.simpleName)
		assertEquals('iterator()', operation.simpleSignature)
	}
	
	@Test
	def void testTypeArguments_01() {
		val operation = '(null as overrides.AbstractForCharSequence).method'.toOperation
		assertEquals('CharSequence', operation.resolvedReturnType.simpleName)
		assertEquals('V, K', operation.resolvedTypeParameters.join(', ') [simpleName])
		assertEquals('CharSequence, CharSequence', operation.resolvedTypeArguments.join(', ') [simpleName])
		assertEquals('method(Class<? extends CharSequence>)', operation.simpleSignature)
	}
	
	@Test
	def void testTypeArguments_02() {
		val operation = 'newArrayList(1, 1d)'.toOperation
		assertEquals('ArrayList<Number & Comparable<?>>', operation.resolvedReturnType.simpleName)
		assertEquals('Number & Comparable<?>', operation.resolvedTypeArguments.join(', ') [simpleName])
		assertEquals('newArrayList(Number & Comparable<?>[])', operation.simpleSignature)
	}
	
	@Test
	def void testTypeArguments_03() {
		val operation = '(newArrayList() as Iterable<? extends String>).toList'.toOperation
		assertEquals('List<? extends String>', operation.resolvedReturnType.simpleName)
		assertEquals('? extends String', operation.resolvedTypeArguments.join(', ') [simpleName])
		assertEquals('toList(Iterable<? extends String>)', operation.simpleSignature)
	}
	
	@Test
	def void testExplicitTypeArguments() {
		val operation = '(null as overrides.AbstractForCharSequence).<String, StringBuilder>method'.toOperation
		assertEquals('String', operation.resolvedReturnType.simpleName)
		assertEquals('V, K', operation.resolvedTypeParameters.join(', ') [simpleName])
		assertEquals('String, StringBuilder', operation.resolvedTypeArguments.join(', ') [simpleName])
		assertEquals('method(Class<? extends String>)', operation.simpleSignature)
	}
	
}