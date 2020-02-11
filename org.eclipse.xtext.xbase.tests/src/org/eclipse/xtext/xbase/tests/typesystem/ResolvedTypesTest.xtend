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
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.common.types.TypesFactory
import org.eclipse.xtext.xbase.XbaseFactory
import org.eclipse.xtext.xbase.junit.typesystem.PublicReentrantTypeResolver
import org.eclipse.xtext.xbase.junit.typesystem.PublicResolvedTypes
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase
import org.junit.Before
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ResolvedTypesTest extends AbstractXbaseTestCase {
	
	@Inject 
	@Accessors
	PublicReentrantTypeResolver resolver
	
	TypesFactory typesFactory = TypesFactory::eINSTANCE
	
	XbaseFactory xbaseFactory = XbaseFactory::eINSTANCE
	
	@Accessors
	PublicResolvedTypes testMe
	
	@Before
	def void initResolvedTypes() {
		val expression = expression('null')
		resolver.initializeFrom(expression)
		testMe = new PublicResolvedTypes(resolver)
	}
	
	@Test
	def void testDiagnostics() {
		assertEquals(emptyList as Object, testMe.queuedDiagnostics)
	}
	
	@Test
	def void testActualTypeArguments() {
		assertTrue(testMe.getActualTypeArguments(null).empty)
	}
	
	@Test
	def void testCreateAndGetUnboundTypeParameter() {
		val unbound = testMe.createUnboundTypeReference(xbaseFactory.createXFeatureCall, typesFactory.createJvmTypeParameter)
		assertSame(unbound, testMe.getUnboundTypeReference(unbound.getHandle))
	}
	
	@Test(expected=typeof(IllegalStateException))
	def void testTryGetUnknownUnboundTypeParameter() {
		testMe.getUnboundTypeReference('unknown handle')
	}
}
