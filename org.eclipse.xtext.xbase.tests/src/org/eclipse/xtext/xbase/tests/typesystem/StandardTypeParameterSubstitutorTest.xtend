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
import org.eclipse.xtext.xbase.typesystem.util.DeclaratorTypeArgumentCollector
import org.eclipse.xtext.xbase.typesystem.util.StandardTypeParameterSubstitutor
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class StandardTypeParameterSubstitutorTest extends AbstractXbaseTestCase {
	
	@Inject
	IBatchTypeResolver typeResolver
	
	@Test
	def void testArrayOfWildcard() {
		val substituted = '?'.substituteInArrayContext()
		assertEquals('Object[]', substituted.simpleName)
	}
	
	@Test
	def void testArrayOfWildcardString() {
		val substituted = '? extends String'.substituteInArrayContext()
		assertEquals('String[]', substituted.simpleName)
	}
	
	@Test
	def void testArrayOfWildcardSuperString() {
		val substituted = '? super String'.substituteInArrayContext()
		assertEquals('Object[]', substituted.simpleName)
	}

	protected def substituteInArrayContext(String componentType) {
		val typeReference = '''Iterable<«componentType»>'''.toTypeReference
		val collector = new DeclaratorTypeArgumentCollector();
		val mapping = collector.getTypeParameterMapping(typeReference);
		assertEquals(1, mapping.size)
		val typeParameter = mapping.keySet.head
		val boundArgument = mapping.get(typeParameter)
		assertEquals(componentType, boundArgument.typeReference.simpleName)
		val owner = typeReference.owner
		val originalArray = owner.newArrayTypeReference(owner.newParameterizedTypeReference(typeParameter))
		assertEquals('T[]', originalArray.simpleName)
		val substitutedArray = new StandardTypeParameterSubstitutor(mapping, typeReference.owner).substitute(originalArray)
		return substitutedArray
	}
	
	protected def LightweightTypeReference toTypeReference(CharSequence reference) {
		val expression = '''null as «reference»'''
		val castExpression = expression.expression as XCastedExpression
		val resolvedTypes = typeResolver.resolveTypes(castExpression)
		return resolvedTypes.getActualType(castExpression)
	}
}

