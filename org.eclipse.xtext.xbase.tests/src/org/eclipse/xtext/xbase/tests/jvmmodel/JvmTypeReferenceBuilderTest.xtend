/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.jvmmodel

import com.google.inject.Inject
import com.google.inject.Provider
import java.util.List
import org.eclipse.xtext.common.types.JvmLowerBound
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference
import org.eclipse.xtext.common.types.JvmUpperBound
import org.eclipse.xtext.common.types.JvmWildcardTypeReference
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.xbase.jvmmodel.JvmTypeReferenceBuilder
import org.junit.Before
import org.junit.Test
import org.eclipse.xtext.common.types.JvmUnknownTypeReference

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class JvmTypeReferenceBuilderTest extends AbstractJvmModelTest {
	
	@Inject JvmTypeReferenceBuilder.Factory typeReferenceBuilderFactory
	@Inject Provider<XtextResourceSet> resourceSetProvider
	
	extension JvmTypeReferenceBuilder typeReferenceBuilder
	
	@Before def void setUp() {
		typeReferenceBuilder = typeReferenceBuilderFactory.create(resourceSetProvider.get)
	}
	
	@Test def void testTypeRef_01() {
		val stringType = typeReferenceBuilder.typeRef(String)
		assertEquals("java.lang.String", stringType.identifier)
	}
	
	@Test def void testTypeRef_02() {
		val type = typeReferenceBuilder.typeRef(List) as JvmParameterizedTypeReference
		assertEquals("java.util.List", type.identifier)
		assertTrue(type.arguments.isEmpty)
	}
	
	@Test def void testTypeRef_03() {
		try {
			typeRef(List, typeRef(String), typeRef(String))
			fail();	
		} catch (IllegalArgumentException e) {
		}
	}
	
	@Test def void testTypeRef_04() {
		try {
			typeRef(typeof(List[]), typeRef(String))
			fail();	
		} catch (IllegalArgumentException e) {
		}
	}
	
	@Test def void testTypeRef_05() {
		val typeRef = typeRef("hubble.Fubble", typeRef(String))
		assertTrue(typeRef instanceof JvmUnknownTypeReference)
		assertEquals('hubble.Fubble', typeRef.qualifiedName)
	}
	
	@Test def void testWildcard_01() {
		assertEquals("java.lang.Object", (wildcard as JvmWildcardTypeReference).constraints.head.typeReference.identifier)
	}
	
	@Test def void testWildcard_02() {
		val constraints = (wildcardExtends(typeRef(CharSequence)) as JvmWildcardTypeReference).constraints
		assertEquals(1, constraints.size)
		assertEquals("java.lang.CharSequence", (constraints).filter(JvmUpperBound).head.typeReference.identifier)
	}
	
	@Test def void testWildcard_03() {
		val constraints = (wildcardSuper(typeRef(CharSequence)) as JvmWildcardTypeReference).constraints
		assertEquals(2, constraints.size)
		assertEquals("java.lang.CharSequence", (constraints).filter(JvmLowerBound).head.typeReference.identifier)
	}
	
}