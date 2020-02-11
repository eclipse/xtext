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
import java.lang.annotation.RetentionPolicy
import java.util.List
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase
import org.junit.After
import org.junit.Test
import org.junit.Before

/**
 * @author Sebastian Zarnekow
 */
abstract class AbstractTypeParameterSubstitutorTest extends AbstractXbaseTestCase {
	
	@Inject TypeReferences typeReferences
	
	XtextResourceSet resourceSet
	
	@Before
	def void createResourceSet() {
		resourceSet = get(typeof(XtextResourceSet));
	}
	
	@After def void tearDown() {
		resourceSet = null
	}
	
	def String resolve(JvmTypeReference declaration, JvmTypeReference reference)
	
	@Test def void testResolve_01() {
		val declaration = typeReferences.getTypeForName(typeof(TypeResolutionTestData$NestedList), resourceSet)
		val resolveMe = declaration
		val resolved = declaration.resolve(resolveMe)
		assertEquals("NestedList<T>", resolved)
	}
	
	@Test def void testResolve_02() {
		val declaration = typeReferences.getTypeForName(typeof(TypeResolutionTestData$NestedList), resourceSet)
		val resolveMe = typeReferences.getTypeForName(typeof(List), resourceSet)
		val resolved = declaration.resolve(resolveMe)
		assertEquals("List<List<T>>", resolved)
	}
	
	@Test def void testResolve_03() {
		val declaration = typeReferences.getTypeForName(typeof(TypeResolutionTestData$NestedList), resourceSet)
		val resolveMe = typeReferences.getTypeForName(typeof(Iterable), resourceSet)
		val resolved = declaration.resolve(resolveMe)
		assertEquals("Iterable<List<T>>", resolved)
	}
	
	@Test def void testResolve_04() {
		val declaration = typeReferences.getTypeForName(typeof(TypeResolutionTestData$NestedList), resourceSet)
		val resolveMe = typeReferences.getTypeForName(typeof(Iterable), resourceSet)
		val resolved = declaration.resolve(resolveMe)
		assertEquals("Iterable<List<T>>", resolved)
	}
	
	@Test def void testResolve_05() {
		val declaration = typeReferences.getTypeForName(typeof(RetentionPolicy), resourceSet)
		val resolveMe = typeReferences.getTypeForName(typeof(Enum), resourceSet)
		val resolved = declaration.resolve(resolveMe)
		assertEquals("Enum<RetentionPolicy>", resolved)
	}
	
}