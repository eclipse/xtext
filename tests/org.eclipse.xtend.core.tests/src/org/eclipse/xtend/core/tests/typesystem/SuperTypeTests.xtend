/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.typesystem

import com.google.inject.Inject
import java.io.Serializable
import java.util.Collection
import java.util.Collections
import java.util.List
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference
import org.junit.Ignore
import org.junit.Test

/**
 * @author Sebastian Zarnekow
 */
abstract class AbstractSuperTypesTest extends AbstractTestingTypeReferenceOwner {
	
	@Inject
	extension IXtendJvmAssociations
	
	def assertSuperTypes(Class<?> type, String... superTypes) {
		(type.canonicalName->null).assertSuperTypes(superTypes)
	}
	
	def assertSuperTypes(String type, String... superTypes) {
		(type->null).assertSuperTypes(superTypes)
	}
	
	def assertSuperTypes(Pair<String, String> type, String... superTypes) {
		// TODO synthesize unique variable names as soon as the function should be validated
		val signature = '''def «IF !type.value.nullOrEmpty»<«type.value»> «ENDIF»void method(«type.key» type) {}'''
		val function = function(signature.toString)
		val operation = function.directlyInferredOperation
		val subtype = operation.parameters.head.parameterType.toLightweightTypeReference
		assertEquals(superTypes.toList, subtype.collectSuperTypes.map[ simpleName ].toList)
	}
	
	def Iterable<LightweightTypeReference> collectSuperTypes(LightweightTypeReference reference)
	
	@Test
	def void testObject() {
		"Object".assertSuperTypes()
	}
	
	@Test
	def void testSerializable() {
		typeof(Serializable).assertSuperTypes("Object")
	}
	
	@Test
	def void testString()
	
	@Test
	def void testCollections() {
		typeof(Collections).assertSuperTypes("Object")
	}
	
	@Test
	def void testRawCollection()
	
	@Test
	def void testStringCollection()
	
	@Test
	def void testStringArray()
	
	@Test
	def void testObjectArray()
	
	@Test
	def void testPrimitiveArray()
	
	@Test
	def void testRawList()
	
	@Test
	def void testStringList()
	
	@Test
	def void testStringArrayArrayList()
	
	@Test
	def void testTypeParameters()
	
	@Test
	def void testTypeParameterArray()
	
	@Test
	def void testDependentTypeParameters()
	
	@Test
	def void testDependentTypeParametersWithBounds()
	
	@Test
	def void testTypeParametersWithoutUpperBound() {
		("T"->"T").assertSuperTypes("Object")
	}
	
	@Test
	def void testParameterizedInnerTypes_01()
	
	@Test
	def void testParameterizedInnerTypes_02()
	
	@Test
	def void testParameterizedInnerTypes_03()
	
	@Test
	def void testParameterizedInnerTypes_04()
}

/**
 * @author Sebastian Zarnekow
 */
class SuperTypesTest extends AbstractSuperTypesTest {
	
	override collectSuperTypes(LightweightTypeReference reference) {
		reference.superTypes
	}
	
	@Test
	override void testString() {
		typeof(String).assertSuperTypes("Serializable", "Comparable<String>", "CharSequence")
	}
	
	@Test
	override void testRawCollection() {
		typeof(Collection).assertSuperTypes("Iterable")
	}
	
	@Test
	override void testStringCollection() {
		"java.util.Collection<String>".assertSuperTypes("Iterable<String>")
	}
	
	@Test
	override void testStringArray() {
		"String[]".assertSuperTypes("Serializable[]", "Comparable<String>[]", "CharSequence[]")
	}
	
	@Test
	override void testObjectArray() {
		"Object[]".assertSuperTypes("Cloneable", "Serializable")
	}
	
	@Test
	override void testPrimitiveArray() {
		"int[]".assertSuperTypes("Cloneable", "Serializable")
	}
	
	@Test
	override void testRawList() {
		typeof(List).assertSuperTypes("Collection")
	}
	
	@Test
	override void testStringList() {
		"java.util.List<String>".assertSuperTypes("Collection<String>")
	}
	
	@Test
	override void testStringArrayArrayList() {
		"java.util.ArrayList<? extends String[]>".assertSuperTypes(
			"AbstractList<? extends String[]>", 
			"List<? extends String[]>",
			"RandomAccess",
			"Cloneable",
			"Serializable" )
	}
	
	@Test
	override testTypeParameters() {
		("T"->"T extends CharSequence").assertSuperTypes("CharSequence")
	}
	
	@Test
	override testTypeParameterArray() {
		("T"->"T extends CharSequence[]").assertSuperTypes("CharSequence[]")
	}
	
	@Test
	override testDependentTypeParameters() {
		("T"->"V, T extends V").assertSuperTypes("V")
	}
	
	@Test
	override testDependentTypeParametersWithBounds() {
		("T"->"V extends CharSequence, T extends V").assertSuperTypes("V")
	}
	
	@Test
	override testParameterizedInnerTypes_01() {
		"test.InnerClasses.SubString<Number>.SubInner<CharSequence>".assertSuperTypes("Super<String>$Inner<CharSequence>")
	}
	
	@Test
	override testParameterizedInnerTypes_02() {
		"test.InnerClasses.Sub<Number>.SubInner2<CharSequence>".assertSuperTypes("Super<Number>$Inner<Number>")
	}
	
	@Test
	@Ignore("https://bugs.eclipse.org/bugs/show_bug.cgi?id=442013")
	override testParameterizedInnerTypes_03() {
		"test.InnerClasses.Sub3.Inner2<Number>".assertSuperTypes("Super3<String>$Inner<Number>")
	}
	
	@Test
	override testParameterizedInnerTypes_04() {
		"test.InnerClasses.Sub4<Number>.Inner3<CharSequence>".assertSuperTypes("Super3<String>$Inner2<Number>")
	}
	
}

/**
 * @author Sebastian Zarnekow
 */
class AllSuperTypesTest extends AbstractSuperTypesTest {
	
	override collectSuperTypes(LightweightTypeReference reference) {
		reference.allSuperTypes
	}
	
	@Test
	override void testString() {
		typeof(String).assertSuperTypes("Serializable", "Comparable<String>", "CharSequence", "Object")
	}
	
	@Test
	override void testRawCollection() {
		typeof(Collection).assertSuperTypes("Iterable", "Object")
	}
	
	@Test
	override void testStringCollection() {
		"java.util.Collection<String>".assertSuperTypes("Iterable<String>", "Object")
	}
	
	@Test
	override void testStringArray() {
		"String[]".assertSuperTypes("Serializable[]", "Comparable<String>[]", "CharSequence[]", "Object[]", "Cloneable", "Serializable", "Object")
	}
	
	@Test
	override void testObjectArray() {
		"Object[]".assertSuperTypes("Cloneable", "Serializable", "Object")
	}
	
	@Test
	override void testPrimitiveArray() {
		"int[]".assertSuperTypes("Cloneable", "Serializable", "Object")
	}
	
	@Test
	override void testRawList() {
		typeof(List).assertSuperTypes("Collection", "Iterable", "Object")
	}
	
	@Test
	override void testStringList() {
		"java.util.List<String>".assertSuperTypes("Collection<String>", "Iterable<String>", "Object")
	}
	
	@Test
	override void testStringArrayArrayList() {
		"java.util.ArrayList<? extends String[]>".assertSuperTypes(
			"AbstractList<? extends String[]>", 
			"RandomAccess",
			"Cloneable",
			"Serializable",
			"AbstractCollection<? extends String[]>", 
			"List<? extends String[]>",
			"Collection<? extends String[]>",
			"Iterable<? extends String[]>",
			"Object")
	}
	
	@Test
	override testTypeParameters() {
		("T"->"T extends CharSequence").assertSuperTypes("CharSequence", "Object")
	}
	
	@Test
	override testDependentTypeParameters() {
		("T"->"V, T extends V").assertSuperTypes("V", "Object")
	}
	
	@Test
	override testDependentTypeParametersWithBounds() {
		("T"->"V extends CharSequence, T extends V").assertSuperTypes("V", "CharSequence", "Object")
	}

	@Test
	override testTypeParameterArray() {
		("T"->"T extends Object[]").assertSuperTypes("Object[]", "Cloneable", "Serializable", "Object")
	}
	
	@Test
	override testParameterizedInnerTypes_01() {
		"test.InnerClasses.SubString<Number>.SubInner<CharSequence>".assertSuperTypes("Super<String>$Inner<CharSequence>", "Object")
	}
	
	@Test
	override testParameterizedInnerTypes_02() {
		"test.InnerClasses.Sub<Number>.SubInner2<CharSequence>".assertSuperTypes("Super<Number>$Inner<Number>", "Object")
	}
	
	@Test
	@Ignore("https://bugs.eclipse.org/bugs/show_bug.cgi?id=442013")
	override testParameterizedInnerTypes_03() {
		"test.InnerClasses.Sub3.Inner2<Number>".assertSuperTypes("Super3<String>$Inner<Number>")
	}
	
	@Test
	override testParameterizedInnerTypes_04() {
		"test.InnerClasses.Sub4<Number>.Inner3<CharSequence>".assertSuperTypes("Super3<String>$Inner2<Number>", "Super3<String>$Inner<Number>", "Object")
	}
}
