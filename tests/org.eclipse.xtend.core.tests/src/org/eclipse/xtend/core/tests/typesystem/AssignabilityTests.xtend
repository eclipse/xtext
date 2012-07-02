/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.typesystem

import com.google.inject.Inject
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations
import org.eclipse.xtext.xbase.lib.Pair
import org.eclipse.xtext.xbase.typesystem.references.AnyTypeReference
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference
import org.junit.Test

import static org.junit.Assert.*
import org.eclipse.xtext.xbase.typesystem.conformance.TypeConformanceComputationArgument

/**
 * @author Sebastian Zarnekow
 */
abstract class AbstractAssignabilityTest extends AbstractTestingTypeReferenceOwner {
	
	@Inject
	extension IXtendJvmAssociations
	
	def isAssignableFrom(Class<?> lhs, String rhs) {
		(lhs.canonicalName->null).isAssignableFrom(rhs, true)
	}
	
	def isAssignableFrom(Class<?> lhs, Class<?> rhs) {
		(lhs.canonicalName->null).isAssignableFrom(rhs.canonicalName, true)
	}
	
	def isAssignableFrom(String lhs, String rhs) {
		(lhs->null).isAssignableFrom(rhs, true)
	}
	
	def isAssignableFromAny(String lhs) {
		(lhs->null).isAssignableFrom(null, true)
	}
	
	def isAssignableFrom(String lhs, Class<?> rhs) {
		(lhs->null).isAssignableFrom(rhs.canonicalName, true)
	}
	
	def isNotAssignableFrom(Class<?> lhs, String rhs) {
		(lhs.canonicalName->null).isAssignableFrom(rhs, false)
	}
	
	def isNotAssignableFrom(String lhs, String rhs) {
		(lhs->null).isAssignableFrom(rhs, false)
	}
	
	def isNotAssignableFromAny(String lhs) {
		(lhs->null).isAssignableFrom(null, false)
	}
	
	def isAssignableFrom(Pair<String, String> lhsAndParams, String rhs) {
		lhsAndParams.isAssignableFrom(rhs, true)
	}
	
	def isNotAssignableFrom(Pair<String, String> lhsAndParams, String rhs) {
		lhsAndParams.isAssignableFrom(rhs, false)
	}
	
	def isAssignableFrom(Pair<String, String> lhsAndParams, String rhs, boolean expectation) {
		// TODO synthesize unique variable names as soon as the function should be validated
		val signature = '''def «IF !lhsAndParams.value.nullOrEmpty»<«lhsAndParams.value»> «ENDIF»void method(«lhsAndParams.key?:'Object'» lhs, «rhs?:'Object'» rhs) {}'''
		val function = function(signature.toString)
		val operation = function.directlyInferredOperation
		val lhsType = if (lhsAndParams.key != null) operation.parameters.head.parameterType.toLightweightReference else new AnyTypeReference(this)
		val rhsType = if (rhs != null) operation.parameters.last.parameterType.toLightweightReference else new AnyTypeReference(this)
		assertEquals(expectation, lhsType.testIsAssignable(rhsType))
		if (expectation) {
			for(superType: lhsType.allSuperTypes) {
				assertEquals(expectation, superType.testIsAssignable(rhsType))		
			}
		}
	}
	
	def boolean testIsAssignable(LightweightTypeReference lhs, LightweightTypeReference rhs) { 
		assertTrue(lhs.doIsAssignable(lhs))
		assertTrue(lhs.doIsAssignable(lhs.toTypeReference.toLightweightReference))
		assertTrue(rhs.doIsAssignable(rhs.toTypeReference.toLightweightReference))
		val boolean result = lhs.doIsAssignable(rhs)
		val wcRhs = new WildcardTypeReference(this)
		wcRhs.addUpperBound(rhs)
		assertEquals(result, lhs.doIsAssignable(wcRhs))
		return result
	}
	
	def boolean doIsAssignable(LightweightTypeReference lhs, LightweightTypeReference rhs) {
		return lhs.isAssignableFrom(rhs)
	}
	
	@Test 
	def void testPrimitiveConversion_00() {
		"long".isAssignableFrom("int")
		"Long".isNotAssignableFrom("int")
		"long".isAssignableFrom("Integer")
		"Long".isNotAssignableFrom("Integer")
	}
	
	@Test 
	def void testPrimitiveConversion_01() {
		"int".isNotAssignableFrom("long")
		"Integer".isNotAssignableFrom("long")
		"int".isNotAssignableFrom("Long")
		"Integer".isNotAssignableFrom("Long")
	}
	
	@Test 
	def void testPrimitiveConversion_02() {
		"long".isAssignableFrom("byte")
		"Long".isNotAssignableFrom("byte")
		"long".isAssignableFrom("Byte")
		"Long".isNotAssignableFrom("Byte")
	}
	
	@Test 
	def void testPrimitiveConversion_03() {
		"char".isAssignableFrom("byte")
		"Character".isNotAssignableFrom("byte")
		"char".isAssignableFrom("Byte")
		"Character".isNotAssignableFrom("Byte")
	}
	
	@Test 
	def void testPrimitiveConversion_04() {
		"int".isAssignableFrom("int")
		"Integer".isAssignableFrom("int")
		"int".isAssignableFrom("Integer")
		"Integer".isAssignableFrom("Integer")
	}
	
	@Test 
	def void testPrimitiveConversion_05() {
		"long".isNotAssignableFrom("float")
		"Long".isNotAssignableFrom("float")
		"long".isNotAssignableFrom("Float")
		"Long".isNotAssignableFrom("Float")
	}
	
	@Test 
	def void testPrimitiveConversion_06() {
		"double".isAssignableFrom("float")
		"Double".isNotAssignableFrom("float")
		"double".isAssignableFrom("Float")
		"Double".isNotAssignableFrom("Float")
	}
	
	@Test 
	def void testPrimitiveConversion_07() {
		"int".isAssignableFrom("Byte")
		"int".isAssignableFrom("Character")
	}
	
	@Test 
	def void testPrimitiveConversion_08() {
		"java.io.Serializable".isAssignableFrom("int")
		"Number".isAssignableFrom("int")
	}
	
	@Test
	def void testStringAndInteger() {
		"String".isNotAssignableFrom("Integer")
	}
	
	@Test
	def void testPrimitiveToObject() {
		"Object".isAssignableFrom("int")
		"Object".isAssignableFrom("long")
		"Object".isAssignableFrom("byte")
		"Object".isAssignableFrom("short")
		"Object".isAssignableFrom("float")
		"Object".isAssignableFrom("double")
		"Object".isAssignableFrom("char")
		"Object".isAssignableFrom("boolean")
	}
	
	@Test
	def void testWildcardLowerBound_01() {
		"java.util.List<? super Integer>".isNotAssignableFrom("Iterable<? super String>")
		"java.util.List<? super Integer>".isNotAssignableFrom("Iterable")
		"java.util.List".isNotAssignableFrom("Iterable<? super String>")
		"java.util.List".isNotAssignableFrom("Iterable")
	}
	
	@Test
	def void testVoid_01() {
		// TODO does not make any sense ... let's see for function types
		"void".isAssignableFrom("void")
	}
	
	@Test
	def void testVoid_02() {
		"int".isNotAssignableFrom("void")
		"void".isNotAssignableFrom("int")
	}
	
	@Test
	def void testVoid_03() {
		"Object".isNotAssignableFrom("void")
		"void".isNotAssignableFrom("Object")
	}
	
	@Test
	def void testVoid_04() {
		"Void".isNotAssignableFrom("void")
		"void".isNotAssignableFrom("Void")
	}
	
	@Test
	def void testArrayType_01() {
		"String[]".isAssignableFrom("String[]")
		"CharSequence[]".isAssignableFrom("String[]")
		"Comparable[]".isAssignableFrom("String[]")
		"Comparable<String>[]".isAssignableFrom("String[]")
		"Comparable<? extends CharSequence>[]".isAssignableFrom("String[]")
	}
	
	@Test
	def void testArrayType_02() {
		"String[]".isNotAssignableFrom("CharSequence[]")
		"String[][]".isNotAssignableFrom("String[]")
		"String[]".isNotAssignableFrom("String[][]")
	}
	
	@Test
	def void testArrayType_03() {
		"Object[]".isAssignableFrom("CharSequence[]")
		"Object[]".isAssignableFrom("String[][]")
	}
	
	@Test
	def void testArrayType_04() {
		"Object".isAssignableFrom("CharSequence[]")
		"Cloneable".isAssignableFrom("CharSequence[]")
		"java.io.Serializable".isAssignableFrom("CharSequence[]")
	}
	
	@Test
	def void testPrimitiveArrayType_01() {
		"double[]".isNotAssignableFrom("int[]")
		"int[]".isNotAssignableFrom("double[]")
	}
	
	@Test
	def void testPrimitiveArrayType_02() {
		"Object".isAssignableFrom("int[]")
		"Cloneable".isAssignableFrom("double[]")
		"java.io.Serializable".isAssignableFrom("double[]")
	}
	
	@Test
	def void testAnyToArray() {
		"int[]".isAssignableFromAny()
		"Object[]".isAssignableFromAny()
	}
	
	@Test
	def void testAnyToVoid() {
		"void".isNotAssignableFromAny()
	}
	
	@Test
	def void testAnyToType() {
		"Void".isAssignableFromAny()
		"Object".isAssignableFromAny()
		"int".isNotAssignableFromAny()
	}
	
	@Test
	def void testAnyToTypeParam() {
		("T"->"T").isAssignableFrom(null, true)
	}
	
	@Test
	def void testArrayToAny() {
		isNotAssignableFrom(null as String, "int[]")
		isNotAssignableFrom(null as String, "Object[]")
	}
	
	@Test
	def void testVoidToAny() {
		isNotAssignableFrom(null as String, "void")
	}
	
	@Test
	def void testTypeToAny() {
		isNotAssignableFrom(null as String, "Void")
		isNotAssignableFrom(null as String, "Object")
		isNotAssignableFrom(null as String, "int")
	}
	
	@Test
	def void testAnyToAny() {
		isAssignableFromAny(null)
	}
	
	@Test
	def void testCharSequenceAndList_01() {
		"CharSequence".isNotAssignableFrom("java.util.List<? super String>")
		"java.util.List<? super String>".isNotAssignableFrom("CharSequence")
	}
	
	@Test
	def void testTypeParameter_01() {
		("T"->"T").isAssignableFrom("T")
		("T[]"->"T").isAssignableFrom("T[]")
		("T"->"T").isNotAssignableFrom("T[]")
		("T[]"->"T").isNotAssignableFrom("T")
	}
	
	@Test
	def void testTypeParameter_02() {	
		("CharSequence"->"T extends CharSequence").isAssignableFrom("T")
	}
	
	@Test
	def void testTypeParameter_03() {
		("Iterable<?>"->"T extends CharSequence").isAssignableFrom("Iterable<T>")
	}
	
	@Test
	def void testTypeParameter_04() {
		("Iterable<? extends CharSequence>"->"T extends CharSequence").isAssignableFrom("Iterable<T>")
	}
	
	@Test
	def void testTypeParameter_05() {
		("Object"->"T").isAssignableFrom("T")
	}
	
	@Test
	def void testTypeParameter_06() {
		// is invalid parameter bound but should be assignable anyway 
		("String[]"->"T extends String[]").isAssignableFrom("T")
	}
	
	@Test
	def void testTypeParameter_07() {
		("String[]"->"T extends String").isAssignableFrom("T[]")
	}
	
	@Test
	def void testTypeParameter_08()
	
	@Test
	def void testTwoTypeParameters_01() {
		("T"->"T, V extends T").isAssignableFrom("V")
		("T[]"->"T, V extends T").isAssignableFrom("V[]")
		("T"->"T, V extends T").isNotAssignableFrom("V[]")
		("T[]"->"T, V extends T").isNotAssignableFrom("V")
		("T[]"->"T, V extends T[]").isAssignableFrom("V")
	}
	
	@Test
	def void testTwoTypeParameters_02()
	
	@Test
	def void testTwoTypeParameters_03()
	
	@Test
	def void testTwoTypeParameters_04() {
		("T"->"T, V").isNotAssignableFrom("V")
		("V"->"T, V").isNotAssignableFrom("T")
	}
	
	@Test
	def void testTwoTypeParameters_05() {
		("T"->"T extends CharSequence, V extends String").isNotAssignableFrom("V")
		("V"->"T extends CharSequence, V extends String").isNotAssignableFrom("T")
	}
	
	@Test
	def void testBug343089_01() {
		("Number"->"T extends Number").isAssignableFrom("T")
		("T"->"T extends Number").isNotAssignableFrom("Number")
	}
	
	@Test
	def void testBug343089_02() {
		("java.io.Serializable"->"T extends Number").isAssignableFrom("T")
	}
	
	@Test
	def void testBug343089_03() {
		("java.io.Serializable"->"T extends Number").isAssignableFrom("T")
	}
	
	@Test
	def void testBug343089_04() {
		("T"->"T").isNotAssignableFrom("Object")
		("T"->"T").isNotAssignableFrom("String")
		("T"->"T").isNotAssignableFrom("Object[]")
		("T"->"T").isNotAssignableFrom("int")
	}
	
}

/**
 * @author Sebastian Zarnekow
 */
class AssignabilityTest extends AbstractAssignabilityTest {
	
	@Test 
	def void testPrimitiveConversion_09() {
		"Comparable".isAssignableFrom("int")
		"Comparable<Integer>".isAssignableFrom("int")
		"Comparable<? extends Number>".isAssignableFrom("int")
		"Comparable<Number>".isNotAssignableFrom("int")
	}
	
	@Test
	def void testWildcardWithDefaultUpper() {
		"Iterable<? extends Object>".isAssignableFrom("java.util.List<?>")
		"Iterable".isAssignableFrom("java.util.List<?>")
		"Iterable<? extends Object>".isAssignableFrom("java.util.List")
		"Iterable".isAssignableFrom("java.util.List")
	}

	@Test
	def void testWildcardLowerBound_02() {
		"java.util.List<? super Integer>".isNotAssignableFrom("java.util.List<? super String>")
		"java.util.List".isAssignableFrom("java.util.List<? super String>")
		"java.util.List<? super Integer>".isAssignableFrom("java.util.List")
	}
	
	@Test
	def void testLeftIsRawType_01() {
		"java.util.Collection".isAssignableFrom("java.util.List<? super String>")
	}
		
	@Test
	def void testLeftIsRawType_02() {
		"java.util.Collection".isAssignableFrom("java.util.List<? extends String>")
	}
		
	@Test
	def void testLeftIsRawType_03() {
		"java.util.Collection".isAssignableFrom("java.util.List<String>")
	}
	
	@Test
	def void testRightIsRawType_01() {
		"java.util.Collection<? super String>".isAssignableFrom("java.util.List")
	}
		
	@Test
	def void testRightIsRawType_02() {
		"java.util.Collection<? extends String>".isAssignableFrom("java.util.List")
	}
		
	@Test
	def void testRightIsRawType_03() {
		"java.util.Collection<String>".isAssignableFrom("java.util.List")
	}
	
	@Test
	def void testInterfaceConformsToObject_01() {
		"Object".isAssignableFrom("CharSequence")
	}
	
	@Test
	def void testInterfaceConformsToObject_02() {
		"Object".isAssignableFrom("Iterable<CharSequence>")
	}

	@Test
	def void testLowerBoundTypeParameter() {
		"java.util.List<? super String>".isAssignableFrom("java.util.List<? super CharSequence>")
		"java.util.List<? super CharSequence>".isNotAssignableFrom("java.util.List<? super String>")
	}
	
	@Test
	def void testLowerBoundTypeParameterAndInvariant_01() {
		"Iterable<? super String>".isAssignableFrom("java.util.List<CharSequence>")
		"Iterable<? super CharSequence>".isNotAssignableFrom("java.util.List<? super String>")
	}
	
	@Test
	def void testLowerBoundTypeParameterAndInvariant_02() {
		"Iterable<? super String>".isAssignableFrom("Iterable<CharSequence>")
		"Iterable<? super CharSequence>".isNotAssignableFrom("Iterable<? super String>")
	}
	
	@Test
	def void testLowerBoundAndUpperBound_01() {
		"Iterable<? super CharSequence>".isNotAssignableFrom("Iterable<? extends String>")
		"Iterable<? extends CharSequence>".isNotAssignableFrom("Iterable<? super String>")
	}
	
	@Test
	def void testWildcardAndInvariant_01() {
		"Iterable<?>".isAssignableFrom("Iterable<String>")
		"Iterable<? extends Object>".isAssignableFrom("Iterable<String>")
	}
	
	@Test
	def void testWildcardAndUpperBound_01() {
		"Iterable<?>".isAssignableFrom("Iterable<? extends String>")
		"Iterable<? extends Object>".isAssignableFrom("Iterable<? extends String>")
	}
	
	@Test
	def void testWildcardAndLowerBound_01() {
		"Iterable<?>".isAssignableFrom("Iterable<? super String>")
		"Iterable<? extends Object>".isAssignableFrom("Iterable<? super String>")
	}
	
	@Test
	def void testBoundTypeParameter_01() {
		"Iterable<CharSequence>".isAssignableFrom("org.eclipse.xtend.core.tests.typesystem.CharIterable")
		"org.eclipse.xtend.core.tests.typesystem.CharIterable".isNotAssignableFrom("Iterable<Character>")
	}
	
	@Test
	def void testBoundTypeParameter_02() {
		"Iterable<Object>".isAssignableFrom("org.eclipse.xtend.core.tests.typesystem.CharIterable")
		"org.eclipse.xtend.core.tests.typesystem.CharIterable".isNotAssignableFrom("Iterable<Object>")
	}
	
	@Test
	def void testUpperBoundTypeParameter() {
		"java.util.List<? extends String>".isNotAssignableFrom("java.util.List<? extends CharSequence>")
		"java.util.List<? extends CharSequence>".isAssignableFrom("java.util.List<? extends String>")
	}
	
	@Test
	def void testUpperBoundTypeParameter_02() {
		"java.util.List<? extends CharSequence>".isAssignableFrom("java.util.List<? extends String>")
	}
	
	@Test
	def void testInvariantTypeParameter_01() {
		"java.util.Collection<String>".isNotAssignableFrom("java.util.List<CharSequence>")
		"java.util.Collection<String>".isAssignableFrom("java.util.List<String>")
		"java.util.Collection<CharSequence>".isNotAssignableFrom("java.util.List<String>")
	}
	
	@Test
	def void testInvariantTypeParameter_02() {
		"java.util.Map<? extends CharSequence, ? extends Number>".isAssignableFrom("java.util.Map<? extends String, ? extends Integer>")
		"java.util.Map<? extends CharSequence, ? extends Number>".isAssignableFrom("java.util.Map<String, Integer>")
	}
	
	@Test
	def void testInvariantTypeParameter_03() {
		"Iterable<Iterable<String>>".isNotAssignableFrom("Iterable<Iterable<CharSequence>>")
		"Iterable<Iterable<CharSequence>>".isNotAssignableFrom("Iterable<Iterable<String>>")
	}	
	
	@Test
	override void testTypeParameter_08() {
		("Iterable<T>"->"T extends CharSequence").isNotAssignableFrom("org.eclipse.xtend.core.tests.typesystem.CharIterable<String>")
		("Iterable<T>"->"T extends CharSequence").isNotAssignableFrom("org.eclipse.xtend.core.tests.typesystem.CharIterable<CharSequence>")
		("Iterable<T>"->"T extends CharSequence").isNotAssignableFrom("org.eclipse.xtend.core.tests.typesystem.CharIterable<? extends CharSequence>")
		("Iterable<? extends T>"->"T extends CharSequence").isNotAssignableFrom("org.eclipse.xtend.core.tests.typesystem.CharIterable<String>")
		("Iterable<? extends T>"->"T extends CharSequence").isNotAssignableFrom("org.eclipse.xtend.core.tests.typesystem.CharIterable<CharSequence>")
		("Iterable<? extends T>"->"T extends CharSequence").isNotAssignableFrom("org.eclipse.xtend.core.tests.typesystem.CharIterable<? extends CharSequence>")
		("Iterable<T>"->"T extends CharSequence").isAssignableFrom("org.eclipse.xtend.core.tests.typesystem.CharIterable")
		("Iterable<T>"->"T extends Number").isAssignableFrom("org.eclipse.xtend.core.tests.typesystem.CharIterable")
	}
	
	@Test
	override testTwoTypeParameters_02() {
		("Iterable<T>"->"T, V extends T").isNotAssignableFrom("Iterable<V>")
		("Iterable<? extends T>"->"T, V extends T").isAssignableFrom("Iterable<V>")
		("Iterable<? extends T>"->"T, V extends T").isAssignableFrom("Iterable<? extends V>")
	}
	
	@Test
	override testTwoTypeParameters_03() {
		("Iterable<? super V>"->"T, V extends T").isAssignableFrom("Iterable<? super T>")
		("Iterable<? super T>"->"T, V extends T").isNotAssignableFrom("Iterable<? super V>")
	}
}

/**
 * @author Sebastian Zarnekow
 */
class RawAssignabilityTest extends AbstractAssignabilityTest {
	
	override boolean doIsAssignable(LightweightTypeReference lhs, LightweightTypeReference rhs) {
		return lhs.isAssignableFrom(rhs, new TypeConformanceComputationArgument(true, false, true))
	}
	
	@Test 
	def void testPrimitiveConversion_09() {
		"Comparable".isAssignableFrom("int")
		"Comparable<Integer>".isAssignableFrom("int")
		"Comparable<? extends Number>".isAssignableFrom("int")
		"Comparable<Number>".isAssignableFrom("int")
	}
	
	@Test
	def void testWildcardWithDefaultUpper() {
		"Iterable<? extends Object>".isAssignableFrom("java.util.List<?>")
	}

	@Test
	def void testWildcardLowerBound_02() {
		"java.util.List<? super Integer>".isAssignableFrom("java.util.List<? super String>")
	}
	
	@Test
	def void testLeftIsRawType_01() {
		"java.util.Collection".isAssignableFrom("java.util.List<? super String>")
	}
		
	@Test
	def void testLeftIsRawType_02() {
		"java.util.Collection".isAssignableFrom("java.util.List<? extends String>")
	}
		
	@Test
	def void testLeftIsRawType_03() {
		"java.util.Collection".isAssignableFrom("java.util.List<String>")
	}
	
	@Test
	def void testRightIsRawType_01() {
		"java.util.Collection<? super String>".isAssignableFrom("java.util.List")
	}
		
	@Test
	def void testRightIsRawType_02() {
		"java.util.Collection<? extends String>".isAssignableFrom("java.util.List")
	}
		
	@Test
	def void testRightIsRawType_03() {
		"java.util.Collection<String>".isAssignableFrom("java.util.List")
	}
	
	@Test
	def void testInterfaceConformsToObject_01() {
		"Object".isAssignableFrom("CharSequence")
	}
	
	@Test
	def void testInterfaceConformsToObject_02() {
		"Object".isAssignableFrom("Iterable<CharSequence>")
	}
	
	@Test
	def void testLowerBoundTypeParameter() {
		"java.util.List<? super String>".isAssignableFrom("java.util.List<? super CharSequence>")
		"java.util.List<? super CharSequence>".isAssignableFrom("java.util.List<? super String>")
	}
	
	@Test
	def void testLowerBoundTypeParameterAndInvariant_01() {
		"Iterable<? super String>".isAssignableFrom("java.util.List<CharSequence>")
		"Iterable<? super CharSequence>".isAssignableFrom("java.util.List<? super String>")
	}
	
	@Test
	def void testLowerBoundTypeParameterAndInvariant_02() {
		"Iterable<? super String>".isAssignableFrom("Iterable<CharSequence>")
		"Iterable<? super CharSequence>".isAssignableFrom("Iterable<? super String>")
	}
	
	@Test
	def void testLowerBoundAndUpperBound_01() {
		"Iterable<? super CharSequence>".isAssignableFrom("Iterable<? extends String>")
		"Iterable<? extends CharSequence>".isAssignableFrom("Iterable<? super String>")
	}
	
	@Test
	def void testWildcardAndInvariant_01() {
		"Iterable<?>".isAssignableFrom("Iterable<String>")
		"Iterable<? extends Object>".isAssignableFrom("Iterable<String>")
	}
	
	@Test
	def void testWildcardAndUpperBound_01() {
		"Iterable<?>".isAssignableFrom("Iterable<? extends String>")
		"Iterable<? extends Object>".isAssignableFrom("Iterable<? extends String>")
	}
	
	@Test
	def void testWildcardAndLowerBound_01() {
		"Iterable<?>".isAssignableFrom("Iterable<? super String>")
		"Iterable<? extends Object>".isAssignableFrom("Iterable<? super String>")
	}
	
	@Test
	def void testBoundTypeParameter_01() {
		"Iterable<CharSequence>".isAssignableFrom("org.eclipse.xtend.core.tests.typesystem.CharIterable")
		"org.eclipse.xtend.core.tests.typesystem.CharIterable".isNotAssignableFrom("Iterable<Character>")
	}
	
	@Test
	def void testBoundTypeParameter_02() {
		"Iterable<Object>".isAssignableFrom("org.eclipse.xtend.core.tests.typesystem.CharIterable")
		"org.eclipse.xtend.core.tests.typesystem.CharIterable".isNotAssignableFrom("Iterable<Object>")
	}
	
	@Test
	def void testUpperBoundTypeParameter() {
		"java.util.List<? extends String>".isAssignableFrom("java.util.List<? extends CharSequence>")
		"java.util.List<? extends CharSequence>".isAssignableFrom("java.util.List<? extends String>")
	}
	
	@Test
	def void testUpperBoundTypeParameter_02() {
		"java.util.List<? extends CharSequence>".isAssignableFrom("java.util.List<? extends String>")
	}
	
	@Test
	def void testInvariantTypeParameter_01() {
		"java.util.Collection<String>".isAssignableFrom("java.util.List<CharSequence>")
		"java.util.Collection<String>".isAssignableFrom("java.util.List<String>")
		"java.util.Collection<CharSequence>".isAssignableFrom("java.util.List<String>")
	}
	
	@Test
	def void testInvariantTypeParameter_02() {
		"java.util.Map<? extends CharSequence, ? extends Number>".isAssignableFrom("java.util.Map<? extends String, ? extends Integer>")
		"java.util.Map<? extends CharSequence, ? extends Number>".isAssignableFrom("java.util.Map<String, Integer>")
	}
	
	@Test
	def void testInvariantTypeParameter_03() {
		"Iterable<Iterable<String>>".isAssignableFrom("Iterable<Iterable<CharSequence>>")
		"Iterable<Iterable<CharSequence>>".isAssignableFrom("Iterable<Iterable<String>>")
	}
	
	@Test
	override void testTypeParameter_08() {
		("Iterable<T>"->"T extends CharSequence").isAssignableFrom("org.eclipse.xtend.core.tests.typesystem.CharIterable<String>")
		("Iterable<T>"->"T extends CharSequence").isAssignableFrom("org.eclipse.xtend.core.tests.typesystem.CharIterable<CharSequence>")
		("Iterable<T>"->"T extends CharSequence").isAssignableFrom("org.eclipse.xtend.core.tests.typesystem.CharIterable<? extends CharSequence>")
		("Iterable<? extends T>"->"T extends CharSequence").isAssignableFrom("org.eclipse.xtend.core.tests.typesystem.CharIterable<String>")
		("Iterable<? extends T>"->"T extends CharSequence").isAssignableFrom("org.eclipse.xtend.core.tests.typesystem.CharIterable<CharSequence>")
		("Iterable<? extends T>"->"T extends CharSequence").isAssignableFrom("org.eclipse.xtend.core.tests.typesystem.CharIterable<? extends CharSequence>")
		("Iterable<T>"->"T extends CharSequence").isAssignableFrom("org.eclipse.xtend.core.tests.typesystem.CharIterable")
		("Iterable<T>"->"T extends Number").isAssignableFrom("org.eclipse.xtend.core.tests.typesystem.CharIterable")
	}
	
	@Test
	override testTwoTypeParameters_02() {
		("Iterable<T>"->"T, V extends T").isAssignableFrom("Iterable<V>")
		("Iterable<? extends T>"->"T, V extends T").isAssignableFrom("Iterable<V>")
		("Iterable<? extends T>"->"T, V extends T").isAssignableFrom("Iterable<? extends V>")
	}
	
	@Test
	override testTwoTypeParameters_03() {
		("Iterable<? super V>"->"T, V extends T").isAssignableFrom("Iterable<? super T>")
		("Iterable<? super T>"->"T, V extends T").isAssignableFrom("Iterable<? super V>")
	}
}

/* 
	
	
	
	protected void assertCommonSuperType(Class<?> expected, Class<?> ...types) {
		List<JvmTypeReference> refs = Lists.newArrayList();
		for (int i = 0; i < types.length; i++) {
			Class<?> class1 = types[i];
			refs.add(ref(class1));
		}
		assertCommonSuperType(expected.getCanonicalName(), refs);
	}
	
	protected void assertCommonSuperType(String expected, JvmTypeReference... types) {
		assertCommonSuperType(expected, Arrays.asList(types));
	}
	
	protected void assertCommonSuperType(String expected, List<JvmTypeReference> refs) {
		JvmTypeReference type = getComputer().getCommonSuperType(refs);
		assertEquals(expected, type.getIdentifier());
	}
	
	@Test public void testCommonSuperType_0() throws Exception {
		assertCommonSuperType(
				"java.io.Serializable & java.lang.CharSequence",
				ref(String.class),
				ref(StringBuilder.class));
	}
	

	@Test public void testCommonSuperType_1() throws Exception {
		assertCommonSuperType(
				CharSequence.class,
				String.class,
				StringBuilder.class,
				CharSequence.class
				);
	}
	
	@Test public void testCommonSuperType_2() throws Exception {
		assertCommonSuperType(Object.class,
				String.class,
				StringBuilder.class,
				CharSequence.class,
				Object.class
		);
	}
	
	@Test public void testCommonSuperType_3() throws Exception {
		assertCommonSuperType(String.class,
				String.class,
				String.class
		);
	}
	
	@Test public void testCommonSuperType_4() throws Exception {
		assertCommonSuperType(String.class,
				String.class
		);
	}
	
	@Test public void testCommonSuperType_5() throws Exception {
		assertCommonSuperType(
				Serializable.class,
				String.class,
				StringBuilder.class,
				Serializable.class);
	}
	
	@Test public void testCommonSuperType_6() throws Exception {
		assertCommonSuperType(
				"java.io.Serializable & java.lang.CharSequence", // like testCommonSuperType_6 but different order
				ref(StringBuilder.class),
				ref(String.class));
	}
	
	@Test public void testCommonSuperType_7() throws Exception {
		assertCommonSuperType(
				"java.lang.Appendable & java.lang.CharSequence",
				ref(StringBuilder.class),
				ref(CharBuffer.class));
	}
	
	@Test public void testCommonSuperType_8() throws Exception {
		assertCommonSuperType(
				"java.util.Collection<java.lang.String>",
				ref(Set.class, ref(String.class)),
				ref(List.class, ref(String.class)));
	}
	
	@Test public void testCommonSuperType_9() throws Exception {
		assertCommonSuperType(
				"java.util.Collection", // one rawtype given - expect raw type
				ref(Set.class, ref(String.class)),
				ref(List.class));
	}
	
	@Test public void testCommonSuperType_10() throws Exception {
		assertCommonSuperType(
				"java.util.Collection<? extends java.lang.CharSequence>",
				ref(Set.class, ref(String.class)),
				ref(List.class, ref(CharSequence.class)));
	}
	
	@Test public void testCommonSuperType_11() throws Exception {
		assertCommonSuperType(
				"java.lang.Comparable<? extends java.lang.Object> & java.io.Serializable",
				ref(String.class),
				ref(Integer.class));
	}
	
	@Test public void testCommonSuperType_12() throws Exception {
		assertCommonSuperType(
				"java.lang.Number & java.lang.Comparable<? extends java.lang.Object>",
				ref(Double.class),
				ref(Integer.class));
	}
	
	@Test public void testCommonSuperType_13() throws Exception {
		assertCommonSuperType(
				"java.lang.AbstractStringBuilder & java.io.Serializable",
				ref(StringBuilder.class),
				ref(StringBuffer.class));
	}
	
	@Test public void testCommonSuperType_14() throws Exception {
		assertCommonSuperType(
				"java.lang.CharSequence & java.io.Serializable",
				multiRef(ref(CharSequence.class), ref(Serializable.class)),
				multiRef(ref(CharSequence.class), ref(Serializable.class)));
	}
	
	@Test public void testCommonSuperType_15() throws Exception {
		assertCommonSuperType(
				"java.io.Serializable & java.lang.CharSequence",
				multiRef(ref(Serializable.class), ref(CharSequence.class)),
				multiRef(ref(CharSequence.class), ref(Serializable.class)));
	}
	
	@Test public void testCommonSuperType_16() throws Exception {
		assertCommonSuperType(
				"java.io.Serializable & java.lang.CharSequence",
				multiRef(ref(Serializable.class), ref(CharSequence.class), ref(Comparable.class)),
				multiRef(ref(Serializable.class), ref(CharSequence.class)));
	}
	
	@Test public void testCommonSuperType_17() throws Exception {
		assertCommonSuperType(
				"java.lang.CharSequence & java.io.Serializable",
				multiRef(ref(Serializable.class), ref(CharSequence.class), ref(Comparable.class)),
				multiRef(ref(CharSequence.class), ref(Serializable.class)));
	}
	
	@Test public void testCommonSuperType_18() throws Exception {
		assertCommonSuperType(
				"java.io.Serializable & java.lang.CharSequence",
				multiRef(ref(Serializable.class), ref(CharSequence.class)),
				multiRef(ref(Serializable.class), ref(CharSequence.class), ref(Comparable.class)));
	}
	
	@Test public void testCommonSuperType_19() throws Exception {
		assertCommonSuperType(
				"java.lang.CharSequence & java.io.Serializable",
				multiRef(ref(CharSequence.class), ref(Serializable.class)),
				multiRef(ref(Serializable.class), ref(CharSequence.class), ref(Comparable.class)));
	}
	
	@Test public void testCommonSuperType_20() throws Exception {
		assertCommonSuperType(
				"java.lang.Object",
				multiRef(ref(Serializable.class), ref(CharSequence.class)),
				multiRef(ref(Comparable.class), ref(Appendable.class)));
	}
	
	@Test public void testCommonSuperType_21() throws Exception {
		assertCommonSuperType(
				"java.lang.Object",
				multiRef(ref(Serializable.class), ref(CharSequence.class)),
				ref(CharSequence.class),
				ref(Serializable.class));
	}
	
	@Test public void testCommonSuperType_22() throws Exception {
		assertCommonSuperType(
				"java.lang.CharSequence",
				multiRef(ref(Serializable.class), ref(CharSequence.class)),
				ref(CharSequence.class));
	}
	
	@Test public void testCommonSuperType_23() throws Exception {
		assertCommonSuperType(
				"java.io.Serializable & java.lang.CharSequence",
				multiRef(ref(Serializable.class), ref(CharSequence.class)),
				any());
	}
	
	@Test public void testCommonSuperType_24() throws Exception {
		assertCommonSuperType(
				"null",
				any(),
				any());
	}
	
	@Test public void testCommonSuperType_25() throws Exception {
		assertCommonSuperType(
				"java.lang.CharSequence",
				ref(CharSequence.class),
				ref(String.class),
				any());
	}
	
	@Test public void testCommonSuperType_26() throws Exception {
		assertCommonSuperType(
				"java.util.Collection<? extends java.lang.AbstractStringBuilder & java.io.Serializable>",
				ref(List.class, ref(StringBuffer.class)),
				ref(Set.class, ref(StringBuilder.class)));
	}
	
	@Test public void testCommonSuperType_27() throws Exception {
		assertCommonSuperType(
				"java.lang.Iterable", // one raw type - super type should be raw type
				ref(Collection.class, ref(String.class)),
				ref(RawIterable.class));
	}
	
	@Test public void testCommonSuperType_28() throws Exception {
//		Integer[] i = null;
//		Double[] d = null;
//		List<Comparable<? extends Number>[]> list = ImmutableList.<Comparable<? extends Number>[]>of(i, d);
//		List<Comparable<? extends Comparable<? extends Object>>[]> list2 = ImmutableList.<Comparable<? extends Comparable<? extends Object>>[]>of(i, d);
		assertCommonSuperType(
				"java.lang.Number[] & java.lang.Comparable<? extends java.lang.Object>[]",
				array(ref(Double.class),1),
				array(ref(Integer.class),1));
	}
	
	@Test public void testCommonSuperType_29() throws Exception {
		assertCommonSuperType(
				"java.io.Serializable & java.lang.Cloneable",
				array(ref(double.class),1),
				array(ref(int.class),1));
	}
	
	@Test public void testCommonSuperType_30() throws Exception {
		assertCommonSuperType(
				"java.io.Serializable & java.lang.Cloneable",
				array(ref(int.class),2),
				array(ref(int.class),1));
	}
	
	@Test public void testCommonSuperType_31() throws Exception {
		assertCommonSuperType(
				"java.lang.Object[]",
				array(ref(CharSequence.class),2),
				array(ref(CharSequence.class),1));
	}
	
	@Test public void testCommonSuperType_32() throws Exception {
		assertCommonSuperType(
				"java.lang.Number[]",
				array(ref(Number.class),1),
				array(ref(Integer.class),1),
				array(ref(Double.class),1));
	}
	
	@Test public void testCommonSuperType_33() throws Exception {
		assertCommonSuperType(
				"java.lang.Number[][][] & java.lang.Comparable<? extends java.lang.Object>[][][]",
				array(ref(Double.class),3),
				array(ref(Integer.class),3));
	}
	
	@Test public void testCommonSuperType_34() throws Exception {
		assertCommonSuperType(
				"java.io.Serializable[]",
				array(ref(Number.class),2),
				array(ref(Number.class),1));
	}
	
	@Test public void testCommonSuperType_35() throws Exception {
		assertCommonSuperType(
				"java.lang.Comparable<? extends java.lang.Object> & java.io.Serializable",
				ref(String.class),
				ref(int.class));
	}
	
	@Test
	public void testCommonSuperType_36() throws Exception {
		assertCommonSuperType(
				"java.util.AbstractList<java.lang.String> & java.io.Serializable & java.lang.Cloneable",
				ref(LinkedList.class, ref(String.class)),
				ref(ArrayList.class, ref(String.class)));
	}
	@Test
	public void testCommonSuperType_37() throws Exception {
		assertCommonSuperType(
				"java.util.AbstractList<java.lang.String> & java.io.Serializable & java.lang.Cloneable",
				ref(LinkedList.class, ref(String.class)),
				ref(ArrayList.class, ref(String.class)));
	}
	
	@Test public void testBug343100_01() throws Exception {
		assertCommonSuperType(
				"java.lang.Class<? extends java.lang.Object>",
				ref(Class.class, ref(Void.class)),
				ref(Class.class, ref(String.class)),
				any());
	}
	
	@Test public void testBug343100_02() throws Exception {
		assertCommonSuperType(
				"java.util.Collection<? extends java.lang.Object>",
				ref(Collection.class, ref(Void.class)),
				ref(List.class, ref(String.class)));
	}
	
	public TypeConformanceComputer getComputer() {
		return computer;
	}

*/

