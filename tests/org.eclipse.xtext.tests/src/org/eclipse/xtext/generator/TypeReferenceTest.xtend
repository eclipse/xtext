/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator

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

	@Test(expected = IllegalArgumentException)
	def void tesIllegalPackageNameWithEmptySegment() {
		new TypeReference("org..example", "MyType")
	}
	
	@Test(expected = IllegalArgumentException)
	def void tesIllegalPackageNameWithUnderscore() {
		"org.7z.MyType".typeRef
	}
	
	@Test
	def void testPackageNameWithUnderscoreAtStart() {
		val ref = "org._7z.MyType".typeRef
		assertEquals("MyType", ref.simpleName)
		assertEquals("org._7z", ref.packageName)
	}

	@Test
	def void testPackageNameWithUnderscoreAtEnd() {
		val ref = "org.z_.MyType".typeRef
		assertEquals("MyType", ref.simpleName)
		assertEquals("org.z_", ref.packageName)
	}

	@Test
	def void testPackageNameWithUnderscoreInTheMiddle() {
		val ref = "org.z_x.example.MyType".typeRef
		assertEquals("MyType", ref.simpleName)
		assertEquals("org.z_x.example", ref.packageName)
	}

	@Test(expected = IllegalArgumentException)
	def void tesIllegalPackageNameWithJavaKeyword() {
		"org.null.example.MyType".typeRef
	}

	@Test
	def void testPackageNameWithDollar() {
		val ref = "org.$$$.example.MyType".typeRef
		assertEquals("MyType", ref.simpleName)
		assertEquals("org.$$$.example", ref.packageName)
	}
	
	@Test(expected = IllegalArgumentException)
	def void tesIllegalPackageNameWithIllegalChar() {
		"org.exa*mple.MyType".typeRef
	}

	@Test
	def void testNamesInUnicode() {
		val ref = "\u0440\u0444.\u043F\u0440\u0438\u043C\u0435\u0440.\u0422\u0435\u0441\u0442\u043E\u0432\u044B\u0439\u041A\u043B\u0430\u0441\u0441".typeRef
		assertEquals("\u0422\u0435\u0441\u0442\u043E\u0432\u044B\u0439\u041A\u043B\u0430\u0441\u0441", ref.simpleName)
		assertEquals("\u0440\u0444.\u043F\u0440\u0438\u043C\u0435\u0440", ref.packageName)
	}
	
	@Test
	def void testClassNameWithUnderscoreInTheMiddle() {
		val ref = "org.example.My_Type".typeRef
		assertEquals("My_Type", ref.simpleName)
		assertEquals("org.example", ref.packageName)
	}

	@Test
	def void testClassNameWithUnderscoreAtTheStart() {
		val ref = "org.example._MyType".typeRef
		assertEquals("_MyType", ref.simpleName)
		assertEquals("org.example", ref.packageName)
	}

	@Test
	def void testClassNameWithUnderscoreAtTheEnd() {
		val ref = "org.example.MyType_".typeRef
		assertEquals("MyType_", ref.simpleName)
		assertEquals("org.example", ref.packageName)
	}

	@Test
	def void testClassNameWithDollar() {
		val ref = "org.example.$My$Type$".typeRef
		assertEquals("$My$Type$", ref.simpleName)
		assertEquals("org.example", ref.packageName)
	}

	@Test(expected = IllegalArgumentException)
	def void tesIllegalClassNameWithIllegalChar() {
		"org.example.My&Type".typeRef
	}

	@Test(expected = IllegalArgumentException)
	def void testIllegalNames() {
		new TypeReference(".", ".")
	}

	@Test(expected = IllegalArgumentException)
	def void tesIllegalClassName() {
		new TypeReference("org.example", ".")
	}

	@Test(expected = IllegalArgumentException)
	def void tesIllegalClassEmptyName() {
		new TypeReference("org.example", "")
	}
	
	@Test(expected = IllegalArgumentException)
	def void tesIllegalClassName2() {
		new TypeReference("org.example", "ABC.")
	}

	@Test(expected = IllegalArgumentException)
	def void tesIllegalClassName3() {
		new TypeReference("org.example", ".ABC")
	}
}