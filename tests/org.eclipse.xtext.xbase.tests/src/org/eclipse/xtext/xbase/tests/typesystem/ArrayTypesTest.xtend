/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
	
	protected def LightweightTypeReference toTypeReference(String reference) {
		val expression = '''null as «reference»'''
		val castExpression = expression.expression as XCastedExpression
		val resolvedTypes = typeResolver.resolveTypes(castExpression)
		return resolvedTypes.getActualType(castExpression)
	}
}