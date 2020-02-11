/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator

import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.xtext.xtext.generator.model.TypeReference
import org.junit.Test

import static org.junit.Assert.*

import static extension org.eclipse.xtext.xtext.generator.model.TypeReference.*

class TypeReferenceTest {
	
	/*
	 * See https://bugs.eclipse.org/bugs/show_bug.cgi?id=480196
	 */
	@Test
	def void testDefaultPackage() {
		val ref = "EString".typeRef
		assertEquals("", ref.packageName)
		assertEquals("EString", ref.simpleName)
	}
	
	@Test
	def void testUnderscopresAnd$() {
		val ref = "E_$tring".typeRef
		assertEquals("", ref.packageName)
		assertEquals("E_$tring", ref.simpleName)
	}
	
	@Test
	def void testUnderscopresAnd$02() {
		val ref = "$.$._$.E_$tring".typeRef
		assertEquals("$.$._$", ref.packageName)
		assertEquals("E_$tring", ref.simpleName)
	}
	
	@Test
	def void testPackageName() {
		val ref = "org.example.MyType".typeRef
		assertEquals("MyType", ref.simpleName)
		assertEquals("org.example", ref.packageName)
	}
	
	@Test
	def void testParametrizedType() {
		val ref = "java.util.List".typeRef("String".typeRef)
		assertEquals("List", ref.simpleName)
		assertEquals("java.util", ref.packageName)
		assertEquals("String", ref.typeArguments.head.simpleName)
	}
	
	@Test(expected = IllegalArgumentException)
	def void testWrongNestedTypeUsage() {
		"java.util.Map.Entry".typeRef
	}
	
	@Test
	def void testNestedType() {
		val ref = new TypeReference("java.util", "Map.Entry")
		assertEquals("java.util", ref.packageName)
		assertEquals("Entry", ref.simpleName)
		assertEquals(#["Map", "Entry"], ref.simpleNames)
	}
	
	@Test
	def void testLowerCaseNestedType() {
		val ref = new TypeReference("java.util", "Map.entry")
		assertEquals("java.util", ref.packageName)
		assertEquals("entry", ref.simpleName)
		assertEquals(#["Map", "entry"], ref.simpleNames)
	}
	
	@Test
	@Deprecated
	def void testGuessTypeRef() {
		val ref = TypeReference.guessTypeRef("java.util.Map.Entry")
		assertEquals("java.util", ref.packageName)
		assertEquals("Entry", ref.simpleName)
		assertEquals(#["Map", "Entry"], ref.simpleNames)
	}
	
	@Test(expected=IllegalArgumentException)
	def void testIllegalTypeRef() {
		TypeReference.typeRef("java.util.Map.Entry")
	}
	
	@Test
	def void testJavaPath() {
		val ref = "org.example.MyType".typeRef
		assertEquals("org/example/MyType.java", ref.javaPath)
	}
	
	@Test
	def void testXtendPath() {
		val ref = "org.example.MyType".typeRef
		assertEquals("org/example/MyType.xtend", ref.xtendPath)
	}
	
	@Test
	def void testEObject() {
		val rs = new ResourceSetImpl
		val ref = new TypeReference(EcorePackage.Literals.EOBJECT, rs)
		assertEquals("org.eclipse.emf.ecore.EObject", ref.name)
	}
	
	@Test
	def void testBug508810() {
		val rs = new ResourceSetImpl
		val ref = new TypeReference(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, rs)
		assertEquals("java.util.Map.Entry", ref.name)
	}
}
