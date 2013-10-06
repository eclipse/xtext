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
import org.eclipse.xtend.core.tests.RuntimeInjectorProvider
import org.eclipse.xtext.common.types.TypesFactory
import org.eclipse.xtext.common.types.util.TypeConformanceComputer
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.xbase.lib.Pair
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint
import org.eclipse.xtext.xbase.typesystem.conformance.TypeConformanceComputationArgument
import org.eclipse.xtext.xbase.typesystem.references.AnyTypeReference
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.eclipse.xtext.xbase.typesystem.references.CompoundTypeReference
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference
import java.util.Map

/**
 * @author Sebastian Zarnekow
 */
abstract class AbstractAssignabilityTest extends AbstractTestingTypeReferenceOwner {
	
	@Inject
	extension IXtendJvmAssociations
	
	override getDeclaredTypeParameters() {
		emptyList
	}
	
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
		val signature = '''def «IF !lhsAndParams.value.nullOrEmpty»<«lhsAndParams.value»> «ENDIF»void method(«
			lhsAndParams.key.fixup» lhs, «
			rhs.fixup» rhs) {}'''
		val function = function(signature.toString)
		val operation = function.directlyInferredOperation
		val lhsType = if (lhsAndParams.key != null) operation.parameters.head.parameterType.toLightweightReference else new AnyTypeReference(this)
		val rhsType = if (rhs != null) operation.parameters.last.parameterType.toLightweightReference else new AnyTypeReference(this)
		assertEquals(lhsType.simpleName + " := " + rhsType.simpleName, expectation, lhsType.testIsAssignable(rhsType))
		if (expectation) {
			for(superType: lhsType.allSuperTypes) {
				if (superType.array == lhsType.array || lhsType.array == rhsType.array)
					assertEquals(superType.toString, expectation, superType.testIsAssignable(rhsType))		
			}
		}
	}
	
	def protected String fixup(String type) {
		type?.replace("$$Procedure", "org.eclipse.xtext.xbase.lib.Procedures.Procedure")
			?.replace("$Procedure", "org.eclipse.xtext.xbase.lib.Procedures$Procedure")
			?.replace("$Function<", "com.google.common.base.Function<")
			?.replace("$Predicate<", "com.google.common.base.Predicate<")
			?.replace("$$Function", "org.eclipse.xtext.xbase.lib.Functions.Function")
			?.replace("$Function", "org.eclipse.xtext.xbase.lib.Functions$Function")
			?:'Object'
	}
	
	def boolean testIsAssignable(LightweightTypeReference lhs, LightweightTypeReference rhs) { 
		assertTrue(lhs.doIsAssignable(lhs))
		assertTrue(lhs.doIsAssignable(lhs.toTypeReference.toLightweightReference))
		assertTrue(rhs.doIsAssignable(rhs.toTypeReference.toLightweightReference))
		val boolean result = lhs.doIsAssignable(rhs)
		if (!rhs.primitiveVoid) {
			val wcRhs = new WildcardTypeReference(this)
			wcRhs.addUpperBound(rhs.wrapperTypeIfPrimitive)
			assertEquals(result, lhs.doIsAssignable(wcRhs))
			val compoundRhs = new CompoundTypeReference(this, true)
			compoundRhs.addComponent(rhs)
			val object = rhs.owner.services.typeReferences.findDeclaredType(Object, rhs.owner.contextResourceSet)
			compoundRhs.addComponent(new ParameterizedTypeReference(rhs.owner, object))
			assertEquals(lhs + ' := ' + compoundRhs.toString, result, lhs.doIsAssignable(compoundRhs))
		}
		return result
	}
	
	def boolean doIsAssignable(LightweightTypeReference lhs, LightweightTypeReference rhs) {
		return lhs.isAssignableFrom(rhs)
	}
}

abstract class CommonAssignabilityTest extends AbstractAssignabilityTest {
	
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
	def void testIterableToArrayType_01() {
		"int[]".isAssignableFrom("Iterable<Integer>")
		"int[]".isAssignableFrom("Iterable<? extends Integer>")
	}
	
	@Test
	def void testIterableToArrayType_02() {
		"Integer[]".isAssignableFrom("Iterable<Integer>")
		"Integer[]".isAssignableFrom("Iterable<? extends Integer>")
	}
	
	@Test
	def void testIterableToArrayType_03() {
		("int[]"->"T extends Integer").isAssignableFrom("Iterable<T>")
		("int[]"->"T extends Integer").isAssignableFrom("Iterable<? extends T>")
	}
	
	@Test
	def void testIterableToArrayType_04() {
		("Integer[]"->"T extends Integer").isAssignableFrom("Iterable<T>")
		("Integer[]"->"T extends Integer").isAssignableFrom("Iterable<? extends T>")
	}
	
	@Test
	def void testListToArrayType_01() {
		"int[]".isAssignableFrom("java.util.List<Integer>")
		"int[]".isAssignableFrom("java.util.List<? extends Integer>")
		"int[]".isNotAssignableFrom("java.util.List<? super Integer>")
	}
	
	@Test
	def void testListToArrayType_02() {
		"Integer[]".isAssignableFrom("java.util.List<Integer>")
		"Integer[]".isAssignableFrom("java.util.List<? extends Integer>")
		"Object[]".isAssignableFrom("java.util.List<? super Integer>")
		"Integer[]".isNotAssignableFrom("java.util.List<? super Integer>")
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
		("String[]"->"T extends V, V extends String[]").isAssignableFrom("T")
	}
	
	@Test
	def void testTypeParameter_07() {
		("String[]"->"T extends String").isAssignableFrom("T[]")
	}
	
	@Test
	def void testTypeParameter_08()
	
	@Test
	def void testTypeParameter_09() {	
		("int"->"T extends Integer").isAssignableFrom("T")
	}
	
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
	
	@Test
	def void testFunctionTypes_01()
	
	@Test
	def void testFunctionTypes_02()
	
	@Test
	def void testFunctionTypes_03()

	@Test
	def void testFunctionTypes_04() {
		"(String)=>CharSequence".isNotAssignableFrom("()=>String")
		"()=>CharSequence".isNotAssignableFrom("(CharSequence)=>String")
		"(CharSequence)=>CharSequence".isNotAssignableFrom("(String, CharSequence)=>String")
	}
	
	@Test
	def void testFunctionTypes_05() {
		"(int, int)=>boolean".isAssignableFrom("(Integer, Integer)=>Boolean")
		"(Integer, Integer)=>Boolean".isAssignableFrom("(int, int)=>boolean")
	}
	
	@Test
	def void testFunctionTypes_06() {
		("(T)=>void"->"T extends Integer").isAssignableFrom("(Integer)=>void")
		("(T)=>int"->"T extends Integer").isAssignableFrom("(Integer)=>Integer")
		("(T)=>void"->"T extends Integer").isAssignableFrom("(int)=>void")
		("(T)=>Integer"->"T extends Integer").isAssignableFrom("(int)=>int")
	}
	
	@Test
	def void testFunctionTypes_07()
	
	@Test
	def void testFunctionTypes_08()
	
	@Test
	def void testFunctionTypes_09() {
		("java.util.ArrayList<$Function1<? super String, ? extends Boolean>>").isAssignableFrom("java.util.ArrayList<(String)=>boolean>")
		("java.util.ArrayList<(String)=>boolean>").isAssignableFrom("java.util.ArrayList<$Function1<? super String, ? extends Boolean>>")
	}
	
	@Test
	def void testFunctionTypes_10() {
		("java.util.ArrayList<$Function1<? super String, ? extends Boolean>>").isAssignableFrom("java.util.ArrayList<(String)=>Boolean>")
		("java.util.ArrayList<(String)=>Boolean>").isAssignableFrom("java.util.ArrayList<$Function1<? super String, ? extends Boolean>>")
	}
	
	@Test
	def void testFunctionTypes_11() {
		("java.util.ArrayList<$Function1<? super Integer, ? extends Boolean>>").isAssignableFrom("java.util.ArrayList<(int)=>boolean>")
		("java.util.ArrayList<(int)=>boolean>").isAssignableFrom("java.util.ArrayList<$Function1<? super Integer, ? extends Boolean>>")
	}
	
	@Test
	def void testFunctionTypes_12() {
		("java.util.ArrayList<(int)=>boolean>").isNotAssignableFrom("java.util.ArrayList<$Function1<? super Long, ? extends Boolean>>")
		("java.util.ArrayList<(int)=>boolean>").isNotAssignableFrom("java.util.ArrayList<(long)=>boolean>")
	}
	
	@Test
	def void testFunctionTypeAsParameterized_01()
	
	@Test
	def void testFunctionTypeAsParameterized_02()
	
	@Test
	def void testFunctionTypeAsParameterized_03()

	@Test
	def void testFunctionTypeAsParameterized_04() {
		"$Function1<String, CharSequence>".isNotAssignableFrom("()=>String")
		"$Function1<? super String, CharSequence>".isNotAssignableFrom("()=>String")
		"$Function1<? super String, ? extends CharSequence>".isNotAssignableFrom("()=>String")
		"$Function1<String, ? extends CharSequence>".isNotAssignableFrom("()=>String")
		"$Function0<CharSequence>".isNotAssignableFrom("(CharSequence)=>String")
		"$Function0<? extends CharSequence>".isNotAssignableFrom("(CharSequence)=>String")
		"$Function0<? super CharSequence>".isNotAssignableFrom("(CharSequence)=>String")
		"$Function1<CharSequence, CharSequence>".isNotAssignableFrom("(String, CharSequence)=>String")
		"$Function1<CharSequence, ? extends CharSequence>".isNotAssignableFrom("(String, CharSequence)=>String")
		"$Function1<? super CharSequence, CharSequence>".isNotAssignableFrom("(String, CharSequence)=>String")
		"$Function1<? super CharSequence, ? extends CharSequence>".isNotAssignableFrom("(String, CharSequence)=>String")
	}
	
	@Test
	def void testFunctionTypeAsParameterized_05() {
		"$Function2<Integer, Integer, Boolean>".isAssignableFrom("(Integer, Integer)=>Boolean")
		"$Function2<? super Integer, ? super Integer, Boolean>".isAssignableFrom("(Integer, Integer)=>Boolean")
		"$Function2<Integer, Integer, ? extends Boolean>".isAssignableFrom("(Integer, Integer)=>Boolean")
		"$Function2<? super Integer, ? super Integer, ? extends Boolean>".isAssignableFrom("(Integer, Integer)=>Boolean")
		"$Function2<Integer, Integer, Boolean>".isAssignableFrom("(int, int)=>boolean")
		"$Function2<? super Integer, ? super Integer, Boolean>".isAssignableFrom("(int, int)=>boolean")
		"$Function2<Integer, Integer, ? extends Boolean>".isAssignableFrom("(int, int)=>boolean")
		"$Function2<? super Integer, ? super Integer, ? extends Boolean>".isAssignableFrom("(int, int)=>boolean")
	}
	
	@Test
	def void testFunctionTypeAsParameterized_06() {
		("$Procedure1<T>"->"T extends Integer").isAssignableFrom("(Integer)=>void")
		("$Procedure1<? super T>"->"T extends Integer").isAssignableFrom("(Integer)=>void")
		("$Function1<T, Integer>"->"T extends Integer").isAssignableFrom("(Integer)=>Integer")
		("$Function1<? super T, Integer>"->"T extends Integer").isAssignableFrom("(Integer)=>Integer")
		("$Function1<T, ? extends Integer>"->"T extends Integer").isAssignableFrom("(Integer)=>Integer")
		("$Function1<? super T, ? extends Integer>"->"T extends Integer").isAssignableFrom("(Integer)=>Integer")
		("$Procedure1<T>"->"T extends Integer").isAssignableFrom("(int)=>void")
		("$Procedure1<? super T>"->"T extends Integer").isAssignableFrom("(int)=>void")
		("$Function1<T, Integer>"->"T extends Integer").isAssignableFrom("(int)=>int")
		("$Function1<? super T, Integer>"->"T extends Integer").isAssignableFrom("(int)=>int")
		("$Function1<T, ? extends Integer>"->"T extends Integer").isAssignableFrom("(int)=>int")
		("$Function1<? super T, ? extends Integer>"->"T extends Integer").isAssignableFrom("(int)=>int")
	}
	
	@Test
	def void testFunctionTypeAsParameterized_07()
	
	@Test
	def void testFunctionTypeAsParameterized_08()
	
	@Test
	def void testFunctionTypeAsParameterized_09()
	
	@Test
	def void testFunctionTypeAsParameterized_10()

	@Test
	def void testFunctionTypeAsParameterized_11() {
		"(String)=>CharSequence".isNotAssignableFrom("$Function0<String>")
		"(String)=>CharSequence".isNotAssignableFrom("$Function0<? extends String>")
		"(String)=>CharSequence".isNotAssignableFrom("$Function0<? super String>")
		"()=>CharSequence".isNotAssignableFrom("$Function1<CharSequence, String>")
		"()=>CharSequence".isNotAssignableFrom("$Function1<? super CharSequence, String>")
		"()=>CharSequence".isNotAssignableFrom("$Function1<CharSequence, ? extends String>")
		"()=>CharSequence".isNotAssignableFrom("$Function1<? super CharSequence, ? extends String>")
		"(CharSequence)=>CharSequence".isNotAssignableFrom("$Function2<String, CharSequence, String>")
		"(CharSequence)=>CharSequence".isNotAssignableFrom("$Function2<? super String, ? super CharSequence, String>")
		"(CharSequence)=>CharSequence".isNotAssignableFrom("$Function2<String, CharSequence, ? extends String>")
		"(CharSequence)=>CharSequence".isNotAssignableFrom("$Function2<? super String, ? super CharSequence, ? extends String>")
	}
	
	@Test
	def void testFunctionTypeAsParameterized_12() {
		"(int, int)=>boolean".isAssignableFrom("$Function2<Integer, Integer, Boolean>")
		"(int, int)=>boolean".isAssignableFrom("$Function2<? super Integer, ? super Integer, ? extends Boolean>")
		"(int, int)=>boolean".isAssignableFrom("$Function2<Integer, Integer, Boolean>")
		"(int, int)=>boolean".isAssignableFrom("$Function2<? super Integer, ? super Integer, ? extends Boolean>")
		"(Integer, Integer)=>Boolean".isAssignableFrom("$Function2<Integer, Integer, Boolean>")
		"(Integer, Integer)=>Boolean".isAssignableFrom("$Function2<? super Integer, ? super Integer, Boolean>")
		"(Integer, Integer)=>Boolean".isAssignableFrom("$Function2<Integer, Integer, ? extends Boolean>")
		"(Integer, Integer)=>Boolean".isAssignableFrom("$Function2<? super Integer, ? super Integer, ? extends Boolean>")
	}
	
	@Test
	def void testFunctionTypeAsParameterized_13() {
		("(T)=>void"->"T extends Integer").isAssignableFrom("$Procedure1<Integer>")
		("(T)=>void"->"T extends Integer").isAssignableFrom("$Procedure1<? super Integer>")
		("(T)=>int"->"T extends Integer").isAssignableFrom("$Function1<Integer, Integer>")
		("(T)=>int"->"T extends Integer").isAssignableFrom("$Function1<? super Integer, Integer>")
		("(T)=>int"->"T extends Integer").isAssignableFrom("$Function1<Integer, ? extends Integer>")
		("(T)=>int"->"T extends Integer").isAssignableFrom("$Function1<? super Integer, ? extends Integer>")
		("(T)=>Integer"->"T extends Integer").isAssignableFrom("$Function1<Integer, Integer>")
		("(T)=>Integer"->"T extends Integer").isAssignableFrom("$Function1<? super Integer, Integer>")
		("(T)=>Integer"->"T extends Integer").isAssignableFrom("$Function1<Integer, ? extends Integer>")
		("(T)=>Integer"->"T extends Integer").isAssignableFrom("$Function1<? super Integer, ? extends Integer>")
	}
	
	@Test
	def void testFunctionTypeAsParameterized_14()
	
	@Test
	def void testDemandConvertedFunctionType_01()
	
	@Test
	def void testDemandConvertedFunctionType_02() {
		"Runnable".isAssignableFrom("()=>void")
		"Runnable".isNotAssignableFrom("()=>String")
		"Runnable".isNotAssignableFrom("(String)=>void")
	}
	
	@Test
	def void testDemandConvertedFunctionType_03() {
		"Iterable<String>".isAssignableFrom("()=>java.util.Iterator<String>")
		"Iterable<? extends String>".isAssignableFrom("()=>java.util.Iterator<? extends String>")
		"Iterable<String>".isNotAssignableFrom("()=>void")
		"Iterable<String>".isNotAssignableFrom("(Number)=>java.util.Iterator<String>")
	}
	
	@Test
	def void testDemandConvertedFunctionType_04() {
		"$Function<String, CharSequence>".isNotAssignableFrom("()=>CharSequence")
		"Iterable<CharSequence>".isNotAssignableFrom("(CharSequence)=>String")
		"java.util.Comparator<CharSequence>".isNotAssignableFrom("(String)=>String")
	}
	
	@Test
	def void testDemandConvertedFunctionType_05()
	
	@Test
	def void testDemandConvertedFunctionType_06()
	
	@Test
	def void testDemandConvertedFunctionType_07() {
		"java.util.Comparator<Integer>".isAssignableFrom("(int, int)=>int")
		"java.util.Comparator<? super Integer>".isAssignableFrom("(Integer, Integer)=>int")
		"java.util.Comparator<Integer>".isAssignableFrom("(Number, Integer)=>Integer")
		"java.util.Comparator<? super Integer>".isAssignableFrom("(Integer, Number)=>Integer")
		"java.util.Comparator<Integer>".isAssignableFrom("(Number, Object)=>int")
	}
	
	@Test
	def void testDemandConvertedFunctionType_08() {
		"Comparable<String>".isNotAssignableFrom("$Function<String, Integer>")
		"Comparable<String>".isNotAssignableFrom("$Function<? super String, Integer>")
		"Comparable<String>".isNotAssignableFrom("$Function<String, ? extends Integer>")
		"Comparable<String>".isNotAssignableFrom("$Function<? super String, ? extends Integer>")
	}
	
	@Test
	def void testDemandConvertedFunctionType_09() {
		"Comparable<String>".isAssignableFrom("$Function1<String, Integer>")
		"Comparable<String>".isAssignableFrom("$Function1<? super String, Integer>")
		"Comparable<String>".isAssignableFrom("$Function1<String, ? extends Integer>")
		"Comparable<String>".isAssignableFrom("$Function1<? super String, ? extends Integer>")
	}
	
	@Test
	def void testDemandConvertedFunctionType_10() {
		"()=>void".isAssignableFrom("Runnable")
		"()=>String".isNotAssignableFrom("Runnable")
		"(String)=>void".isNotAssignableFrom("Runnable")
	}
	
	@Test
	def void testDemandConvertedFunctionType_11() {
		"()=>java.util.Iterator<String>".isAssignableFrom("Iterable<String>")
		"()=>java.util.Iterator<? extends String>".isAssignableFrom("Iterable<? extends String>")

		"()=>void".isNotAssignableFrom("Iterable<String>")
		"(Number)=>java.util.Iterator<String>".isNotAssignableFrom("Iterable<String>")
	}
	
	@Test
	def void testDemandConvertedFunctionType_12() {
		"()=>CharSequence".isNotAssignableFrom("$Function<String, CharSequence>")
		"(CharSequence)=>String".isNotAssignableFrom("Iterable<CharSequence>")
		"(String)=>String".isNotAssignableFrom("java.util.Comparator<CharSequence>")
	}
	
	@Test
	def void testDemandConvertedFunctionType_13() {
		"java.util.Comparator<? super String>".isAssignableFrom("(String, String)=>int")
		"java.util.Comparator<String>".isAssignableFrom("(CharSequence, CharSequence)=>int")
		"java.util.Comparator<? super String>".isAssignableFrom("(CharSequence, CharSequence)=>int")
	}
	
	@Test
	def void testBug395002_01() {
		("$<?, A>".selfBound->"A extends $<?,A>".selfBound).isAssignableFrom("A")
	}
	
	@Test
	def void testBug395002_02() {
		("$<? extends $<?, A>, ?>".selfBound->"A extends $<?,A>".selfBound).isAssignableFrom("$<?, A>")
	}
	
	@Ignore("Substitutions are not applied recursively according to JLS - see ticket 395002")
	@Test
	def void testBug395002_03() {
		("$<? extends $<?, A>, ?>".selfBound->"A extends $<?,A>".selfBound).isAssignableFrom("A")
	}
	
	def private selfBound(String typeName) {
		typeName.replace("$", "org.eclipse.xtend.core.tests.typesystem.ScenarioBug395002$SelfBound")
	}
	
	@Test
	def void testBug409847_01() {
		"java.lang.Class<? extends java.lang.Iterable<?>>".isNotAssignableFrom("java.lang.Class<java.util.ArrayList>")
		"java.lang.Class<? extends java.lang.Iterable<?>>".isAssignableFrom("java.lang.Class<java.util.ArrayList<java.lang.Integer>>")
		"java.lang.Class<? extends java.lang.Iterable>".isAssignableFrom("java.lang.Class<java.util.ArrayList>")
	}
	
	@Test
	def void testBug409847_02() {
		"java.lang.Class<java.util.ArrayList<?>>".isNotAssignableFrom("java.lang.Class<java.util.ArrayList>")
	}
	
	@Test
	def void testBug409847_03() {
		"java.lang.Class<java.util.ArrayList>".isNotAssignableFrom("java.lang.Class<java.util.ArrayList<?>>")
	}
	
	@Test
	def void testBug409847_04() {
		"java.lang.Iterable<? extends java.lang.Iterable<?>>".isNotAssignableFrom("java.util.ArrayList<java.util.ArrayList>")
		"java.lang.Iterable<? extends java.lang.Iterable<?>>".isAssignableFrom("java.util.ArrayList<java.util.ArrayList<java.lang.Integer>>")
		"java.lang.Iterable<? extends java.lang.Iterable>".isAssignableFrom("java.util.ArrayList<java.util.ArrayList>")
	}
	
	@Test
	def void testUncheckedConversion_01() {
		"java.lang.Iterable<?>".isAssignableFrom(StrangeIterable)
		"java.lang.Iterable<? super String>".isAssignableFrom(StrangeIterable)
		"java.lang.Iterable<? extends String>".isAssignableFrom(StrangeIterable)
		"java.lang.Iterable<String>".isAssignableFrom(StrangeIterable)
		"java.lang.Iterable".isAssignableFrom(StrangeIterable)
	}
	
	@Test
	def void testUncheckedConversion_02() {
		"java.lang.Iterable<?>".isAssignableFrom(strangeIterable('java.lang.Exception'))
		"java.lang.Iterable<? super String>".isAssignableFrom(strangeIterable('java.lang.Exception'))
		"java.lang.Iterable<? extends String>".isAssignableFrom(strangeIterable('java.lang.Exception'))
		"java.lang.Iterable<String>".isAssignableFrom(strangeIterable('java.lang.Exception'))
		"java.lang.Iterable".isAssignableFrom(strangeIterable('java.lang.Exception'))
	}
	
	@Test
	def void testCharArrayIsIterable() {
		"java.lang.Iterable<?>".isAssignableFrom("char[]")
		"java.lang.Iterable<? extends Character>".isAssignableFrom("char[]")
		"java.lang.Iterable<Character>".isAssignableFrom("char[]")
		"java.lang.Iterable<? super Character>".isAssignableFrom("char[]")
		"java.lang.Iterable".isAssignableFrom("char[]")
	}
	
	@Test
	def void testStringIsNotComparableInteger() {
		"java.lang.Comparable<? extends Integer>".isNotAssignableFrom("String")
		"java.lang.Comparable<Integer>".isNotAssignableFrom("String")
	}
	
	@Test
	def void testStringIsComparableString() {
		"java.lang.Comparable<? extends String>".isAssignableFrom("String")
		"java.lang.Comparable<String>".isAssignableFrom("String")
	}
	
	@Test
	def void testClassStringIntMapIsClassMap() {
		"java.lang.Class<? extends java.util.Map>".isAssignableFrom("java.lang.Class<org.eclipse.xtend.core.tests.typesystem.StringIntMap>")
		"java.lang.Class<? super java.util.Map>".isNotAssignableFrom("java.lang.Class<org.eclipse.xtend.core.tests.typesystem.StringIntMap>")
		"java.lang.Class<? super org.eclipse.xtend.core.tests.typesystem.StringIntMap>".isAssignableFrom("java.lang.Class<java.util.Map>")
	}
	
	@Test
	def void testClassMapIsClassMapStringInteger() {
		"java.lang.Class<? extends java.util.Map>".isAssignableFrom("java.lang.Class<? extends java.util.Map<String, Integer>>")
		"java.lang.Class<? extends java.util.Map>".isAssignableFrom("java.lang.Class<? extends java.util.Map<?, ?>>")
		"java.lang.Class<? super java.util.Map>".isNotAssignableFrom("java.lang.Class<? super java.util.Map<String, Integer>>")
		"java.lang.Class<? super java.util.Map>".isNotAssignableFrom("java.lang.Class<? super java.util.Map<?, ?>>")
		"java.lang.Class<? super java.util.Map<String, Integer>>".isAssignableFrom("java.lang.Class<? super java.util.Map>")
		"java.lang.Class<? super java.util.Map<?, ?>>".isAssignableFrom("java.lang.Class<? super java.util.Map>")
	}
	
	private def String strangeIterable(String typeParam) {
		'''org.eclipse.xtend.core.tests.typesystem.StrangeIterable<«typeParam»>'''
	}
}

/**
 * @author Sebastian Zarnekow
 */
class AssignabilityTest extends CommonAssignabilityTest {
	
	override doIsAssignable(LightweightTypeReference lhs, LightweightTypeReference rhs) {
		val result = lhs.internalIsAssignableFrom(rhs, new TypeConformanceComputationArgument(false, false, true, true, false, true))
		assertFalse(result.conformanceHints.toString(), result.conformanceHints.contains(ConformanceHint::RAW))
		return result.conformant
	}
	
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
	
	@Test
	override testFunctionTypes_01() {
		"(String)=>void".isAssignableFrom("(CharSequence)=>void")
		"(String)=>void".isAssignableFrom("(String)=>void")
		"(CharSequence)=>void".isNotAssignableFrom("(String)=>void")
	}
	
	@Test
	override testFunctionTypes_02() {
		"(String)=>String".isAssignableFrom("(CharSequence)=>String")
		"(String)=>String".isAssignableFrom("(String)=>String")
		"(CharSequence)=>String".isNotAssignableFrom("(String)=>String")
	}
	
	@Test
	override testFunctionTypes_03() {
		"(String)=>CharSequence".isAssignableFrom("(CharSequence)=>String")
		"(String)=>CharSequence".isAssignableFrom("(String)=>String")
		"(CharSequence)=>CharSequence".isNotAssignableFrom("(String)=>String")
	}
	
	@Test
	override testFunctionTypes_07() {
		("(T)=>T"->"T extends Integer").isNotAssignableFrom("(Integer)=>Integer")
		("(T)=>T"->"T extends Integer").isNotAssignableFrom("(int)=>int")
	}
	
	@Test
	override void testFunctionTypes_08() {
		("()=>long").isNotAssignableFrom("()=>int")
		("()=>int").isNotAssignableFrom("()=>long")
	}
	
	@Test
	override testFunctionTypeAsParameterized_01() {
		"$Procedure1<String>".isAssignableFrom("(CharSequence)=>void")
		"$Procedure1<? super String>".isAssignableFrom("(CharSequence)=>void")
		"$Procedure1<? extends String>".isNotAssignableFrom("(CharSequence)=>void")
		"$Procedure1<String>".isAssignableFrom("(String)=>void")
		"$Procedure1<? super String>".isAssignableFrom("(String)=>void")
		"$Procedure1<? extends String>".isNotAssignableFrom("(String)=>void")
		"$Procedure1<CharSequence>".isNotAssignableFrom("(String)=>void")
		"$Procedure1<? super CharSequence>".isNotAssignableFrom("(String)=>void")
		"$Procedure1<? extends CharSequence>".isNotAssignableFrom("(String)=>void")
	}
	
	@Test
	override testFunctionTypeAsParameterized_02() {
		"$Function1<String, String>".isAssignableFrom("(CharSequence)=>String")
		"$Function1<? super String, String>".isAssignableFrom("(CharSequence)=>String")
		"$Function1<String, ? extends String>".isAssignableFrom("(CharSequence)=>String")
		"$Function1<? super String, ? extends String>".isAssignableFrom("(CharSequence)=>String")
		"$Function1<String, String>".isAssignableFrom("(String)=>String")
		"$Function1<? super String, String>".isAssignableFrom("(String)=>String")
		"$Function1<String, ? extends String>".isAssignableFrom("(String)=>String")
		"$Function1<? super String, ? extends String>".isAssignableFrom("(String)=>String")
		"$Function1<CharSequence, String>".isNotAssignableFrom("(String)=>String")
		"$Function1<? super CharSequence, String>".isNotAssignableFrom("(String)=>String")
		"$Function1<CharSequence, ? extends String>".isNotAssignableFrom("(String)=>String")
		"$Function1<? super CharSequence, ? extends String>".isNotAssignableFrom("(String)=>String")
	}
	
	@Test
	override testFunctionTypeAsParameterized_03() {
		"$Function1<String, CharSequence>".isAssignableFrom("(CharSequence)=>String")
		"$Function1<? super String, CharSequence>".isAssignableFrom("(CharSequence)=>String")
		"$Function1<String, ? extends CharSequence>".isAssignableFrom("(CharSequence)=>String")
		"$Function1<? super String, ? extends CharSequence>".isAssignableFrom("(CharSequence)=>String")
		"$Function1<String, CharSequence>".isAssignableFrom("(String)=>String")
		"$Function1<? super String, CharSequence>".isAssignableFrom("(String)=>String")
		"$Function1<String, ? extends CharSequence>".isAssignableFrom("(String)=>String")
		"$Function1<? super String, ? extends CharSequence>".isAssignableFrom("(String)=>String")
		"$Function1<CharSequence, CharSequence>".isNotAssignableFrom("(String)=>String")
		"$Function1<? super CharSequence, CharSequence>".isNotAssignableFrom("(String)=>String")
		"$Function1<CharSequence, ? extends CharSequence>".isNotAssignableFrom("(String)=>String")
		"$Function1<? super CharSequence, ? extends CharSequence>".isNotAssignableFrom("(String)=>String")
	}
	
	@Test
	override testFunctionTypeAsParameterized_07() {
		("$Function1<T, T>"->"T extends Integer").isNotAssignableFrom("(Integer)=>Integer")
		("$Function1<? super T, T>"->"T extends Integer").isNotAssignableFrom("(Integer)=>Integer")
		("$Function1<T, ? extends T>"->"T extends Integer").isNotAssignableFrom("(Integer)=>Integer")
		("$Function1<? super T, ? extends T>"->"T extends Integer").isNotAssignableFrom("(Integer)=>Integer")
		("$Function1<T, T>"->"T extends Integer").isNotAssignableFrom("(int)=>int")
		("$Function1<? super T, T>"->"T extends Integer").isNotAssignableFrom("(int)=>int")
		("$Function1<T, ? extends T>"->"T extends Integer").isNotAssignableFrom("(int)=>int")
		("$Function1<? super T, ? extends T>"->"T extends Integer").isNotAssignableFrom("(int)=>int")
	}
	
	@Test
	override testFunctionTypeAsParameterized_08() {
		"(String)=>void".isAssignableFrom("$Procedure1<CharSequence>")
		"(String)=>void".isAssignableFrom("$Procedure1<? super CharSequence>")
		"(String)=>void".isAssignableFrom("$Procedure1<String>")
		"(String)=>void".isAssignableFrom("$Procedure1<? super String>")
		"(CharSequence)=>void".isNotAssignableFrom("$Procedure1<String>")
		"(CharSequence)=>void".isNotAssignableFrom("$Procedure1<? super String>")
	}
	
	@Test
	override testFunctionTypeAsParameterized_09() {
		"(String)=>String".isAssignableFrom("$Function1<CharSequence, String>")
		"(String)=>String".isAssignableFrom("$Function1<? super CharSequence, String>")
		"(String)=>String".isAssignableFrom("$Function1<CharSequence, ? extends String>")
		"(String)=>String".isAssignableFrom("$Function1<? super CharSequence, ? extends String>")
		"(String)=>String".isAssignableFrom("$Function1<String, String>")
		"(String)=>String".isAssignableFrom("$Function1<? super String, String>")
		"(String)=>String".isAssignableFrom("$Function1<String, ? extends String>")
		"(String)=>String".isAssignableFrom("$Function1<? super String, ? extends String>")
		"(CharSequence)=>String".isNotAssignableFrom("$Function1<String, String>")
		"(CharSequence)=>String".isNotAssignableFrom("$Function1<? super String, String>")
		"(CharSequence)=>String".isNotAssignableFrom("$Function1<String, ? extends String>")
		"(CharSequence)=>String".isNotAssignableFrom("$Function1<? super String, ? extends String>")
	}
	
	@Test
	override testFunctionTypeAsParameterized_10() {
		"(String)=>CharSequence".isAssignableFrom("$Function1<CharSequence, String>")
		"(String)=>CharSequence".isAssignableFrom("$Function1<? super CharSequence, String>")
		"(String)=>CharSequence".isAssignableFrom("$Function1<CharSequence, ? extends String>")
		"(String)=>CharSequence".isAssignableFrom("$Function1<? super CharSequence, ? extends String>")
		"(String)=>CharSequence".isAssignableFrom("$Function1<String, String>")
		"(String)=>CharSequence".isAssignableFrom("$Function1<? super String, String>")
		"(String)=>CharSequence".isAssignableFrom("$Function1<String, ? extends String>")
		"(String)=>CharSequence".isAssignableFrom("$Function1<? super String, ? extends String>")
		"(CharSequence)=>CharSequence".isNotAssignableFrom("$Function1<String, String>")
		"(CharSequence)=>CharSequence".isNotAssignableFrom("$Function1<? super String, String>")
		"(CharSequence)=>CharSequence".isNotAssignableFrom("$Function1<String, ? extends String>")
		"(CharSequence)=>CharSequence".isNotAssignableFrom("$Function1<? super String, ? extends String>")
	}
	
	@Test
	override testFunctionTypeAsParameterized_14() {
		("(T)=>T"->"T extends Integer").isNotAssignableFrom("$Function1<Integer, Integer>")
		("(T)=>T"->"T extends Integer").isNotAssignableFrom("$Function1<? super Integer, Integer>")
		("(T)=>T"->"T extends Integer").isNotAssignableFrom("$Function1<Integer, ? extends Integer>")
		("(T)=>T"->"T extends Integer").isNotAssignableFrom("$Function1<? super Integer, ? extends Integer>")
	}

	@Test
	override testDemandConvertedFunctionType_01() {
		"org.eclipse.xtext.util.IAcceptor<String>".isAssignableFrom("(CharSequence)=>void")
		"org.eclipse.xtext.util.IAcceptor<? super String>".isAssignableFrom("(CharSequence)=>void")
		"org.eclipse.xtext.util.IAcceptor<String>".isAssignableFrom("(Object)=>void")
		"org.eclipse.xtext.util.IAcceptor<? super String>".isAssignableFrom("(Object)=>void")
		"org.eclipse.xtext.util.IAcceptor<String>".isAssignableFrom("(String)=>void")
		"org.eclipse.xtext.util.IAcceptor<? super String>".isAssignableFrom("(String)=>void")
		"org.eclipse.xtext.util.IAcceptor<CharSequence>".isNotAssignableFrom("(String)=>void")
		"org.eclipse.xtext.util.IAcceptor<? super CharSequence>".isNotAssignableFrom("(String)=>void")
	}
	
	@Test
	override testDemandConvertedFunctionType_05() {
		"org.eclipse.xtext.util.IAcceptor<Integer>".isAssignableFrom("(int)=>void")
		"org.eclipse.xtext.util.IAcceptor<? super Integer>".isAssignableFrom("(int)=>void")
		"org.eclipse.xtext.util.IAcceptor<? extends Integer>".isNotAssignableFrom("(int)=>void")
		"org.eclipse.xtext.util.IAcceptor<Number>".isNotAssignableFrom("(int)=>void")
		"org.eclipse.xtext.util.IAcceptor<? extends Number>".isNotAssignableFrom("(int)=>void")
		"org.eclipse.xtext.util.IAcceptor<? super Number>".isNotAssignableFrom("(int)=>void")
	}
	
	@Test
	override testDemandConvertedFunctionType_06() {
		"Comparable<Integer>".isAssignableFrom("(int)=>int")
		"Comparable<? super Integer>".isAssignableFrom("(Integer)=>Integer")
		"Comparable<? super Integer>".isAssignableFrom("(Number)=>Integer")
		"Comparable<Integer>".isAssignableFrom("(int)=>int")
		"Comparable<? super Integer>".isAssignableFrom("(Integer)=>int")
		"Comparable<? super Integer>".isAssignableFrom("(Number)=>int")
		"Comparable<String>".isNotAssignableFrom("(int)=>int")
	}
	
}

/**
 * @author Sebastian Zarnekow
 */
@RunWith(typeof(XtextRunner))
@InjectWith(typeof(RuntimeInjectorProvider))
class OldAPIAssignabilityTest extends AssignabilityTest {
	
	@Inject
	extension IXtendJvmAssociations
	
	@Inject
	TypeConformanceComputer conformanceComputer
	
	override isAssignableFrom(Pair<String, String> lhsAndParams, String rhs, boolean expectation) {
		// TODO synthesize unique variable names as soon as the function should be validated
		val signature = '''def «IF !lhsAndParams.value.nullOrEmpty»<«lhsAndParams.value»> «ENDIF»void method(«
			lhsAndParams.key.fixup» lhs, «
			rhs.fixup» rhs) {}'''
		val function = function(signature.toString)
		val operation = function.directlyInferredOperation
		val lhsType = if (lhsAndParams.key != null) operation.parameters.head.parameterType else TypesFactory::eINSTANCE.createJvmAnyTypeReference
		val rhsType = if (rhs != null) operation.parameters.last.parameterType else TypesFactory::eINSTANCE.createJvmAnyTypeReference
		assertEquals(expectation, conformanceComputer.isConformant(lhsType, rhsType))
	}
	
}

/**
 * @author Sebastian Zarnekow
 */
class RawAssignabilityTest extends CommonAssignabilityTest {
	
	override boolean doIsAssignable(LightweightTypeReference lhs, LightweightTypeReference rhs) {
		val result = lhs.internalIsAssignableFrom(rhs, new TypeConformanceComputationArgument(true, false, true, true, false, true))
		assertTrue(result.conformanceHints.toString(), result.conformanceHints.contains(ConformanceHint::RAW))
		return result.conformant
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
	
	@Test
	override testFunctionTypes_01() {
		"(String)=>void".isAssignableFrom("(CharSequence)=>void")
		"(String)=>void".isAssignableFrom("(String)=>void")
		"(CharSequence)=>void".isAssignableFrom("(String)=>void")
	}
	
	@Test
	override testFunctionTypes_02() {
		"(String)=>String".isAssignableFrom("(CharSequence)=>String")
		"(String)=>String".isAssignableFrom("(String)=>String")
		"(CharSequence)=>String".isAssignableFrom("(String)=>String")
	}
	
	@Test
	override testFunctionTypes_03() {
		"(String)=>CharSequence".isAssignableFrom("(CharSequence)=>String")
		"(String)=>CharSequence".isAssignableFrom("(CharSequence)=>String")
		"(CharSequence)=>CharSequence".isAssignableFrom("(String)=>String")
	}
	
	@Test
	override testFunctionTypes_07() {
		("(T)=>T"->"T extends Integer").isAssignableFrom("(Integer)=>Integer")
		("(T)=>T"->"T extends Integer").isAssignableFrom("(int)=>int")
	}
	
	@Test
	override void testFunctionTypes_08() {
		("()=>long").isAssignableFrom("()=>int")
		("()=>int").isAssignableFrom("()=>long")
	}
	
	@Test
	override void testFunctionTypes_12() {
		("java.util.ArrayList<(int)=>boolean>").isAssignableFrom("java.util.ArrayList<$Function1<? super Long, ? extends Boolean>>")
		("java.util.ArrayList<(int)=>boolean>").isAssignableFrom("java.util.ArrayList<(long)=>boolean>")
	}
	
	@Test
	override testFunctionTypeAsParameterized_01() {
		"$Procedure1<String>".isAssignableFrom("(CharSequence)=>void")
		"$Procedure1<? super String>".isAssignableFrom("(CharSequence)=>void")
		"$Procedure1<? extends String>".isAssignableFrom("(CharSequence)=>void")
		"$Procedure1<String>".isAssignableFrom("(String)=>void")
		"$Procedure1<? super String>".isAssignableFrom("(String)=>void")
		"$Procedure1<? extends String>".isAssignableFrom("(String)=>void")
		"$Procedure1<CharSequence>".isAssignableFrom("(String)=>void")
		"$Procedure1<? super CharSequence>".isAssignableFrom("(String)=>void")
		"$Procedure1<? extends CharSequence>".isAssignableFrom("(String)=>void")
	}
	
	@Test
	override testFunctionTypeAsParameterized_02() {
		"$Function1<String, String>".isAssignableFrom("(CharSequence)=>String")
		"$Function1<? super String, String>".isAssignableFrom("(CharSequence)=>String")
		"$Function1<String, ? extends String>".isAssignableFrom("(CharSequence)=>String")
		"$Function1<? super String, ? extends String>".isAssignableFrom("(CharSequence)=>String")
		"$Function1<String, String>".isAssignableFrom("(String)=>String")
		"$Function1<? super String, String>".isAssignableFrom("(String)=>String")
		"$Function1<String, ? extends String>".isAssignableFrom("(String)=>String")
		"$Function1<? super String, ? extends String>".isAssignableFrom("(String)=>String")
		"$Function1<CharSequence, String>".isAssignableFrom("(String)=>String")
		"$Function1<? super CharSequence, String>".isAssignableFrom("(String)=>String")
		"$Function1<CharSequence, ? extends String>".isAssignableFrom("(String)=>String")
		"$Function1<? super CharSequence, ? extends String>".isAssignableFrom("(String)=>String")
	}
	
	@Test
	override testFunctionTypeAsParameterized_03() {
		"$Function1<String, CharSequence>".isAssignableFrom("(CharSequence)=>String")
		"$Function1<? super String, CharSequence>".isAssignableFrom("(CharSequence)=>String")
		"$Function1<String, ? extends CharSequence>".isAssignableFrom("(CharSequence)=>String")
		"$Function1<? super String, ? extends CharSequence>".isAssignableFrom("(CharSequence)=>String")
		"$Function1<String, CharSequence>".isAssignableFrom("(String)=>String")
		"$Function1<? super String, CharSequence>".isAssignableFrom("(String)=>String")
		"$Function1<String, ? extends CharSequence>".isAssignableFrom("(String)=>String")
		"$Function1<? super String, ? extends CharSequence>".isAssignableFrom("(String)=>String")
		"$Function1<CharSequence, CharSequence>".isAssignableFrom("(String)=>String")
		"$Function1<? super CharSequence, CharSequence>".isAssignableFrom("(String)=>String")
		"$Function1<CharSequence, ? extends CharSequence>".isAssignableFrom("(String)=>String")
		"$Function1<? super CharSequence, ? extends CharSequence>".isAssignableFrom("(String)=>String")
	}
	
	@Test
	override testFunctionTypeAsParameterized_07() {
		("$Function1<T, T>"->"T extends Integer").isAssignableFrom("(Integer)=>Integer")
		("$Function1<? super T, T>"->"T extends Integer").isAssignableFrom("(Integer)=>Integer")
		("$Function1<T, ? extends T>"->"T extends Integer").isAssignableFrom("(Integer)=>Integer")
		("$Function1<? super T, ? extends T>"->"T extends Integer").isAssignableFrom("(Integer)=>Integer")
		("$Function1<T, T>"->"T extends Integer").isAssignableFrom("(int)=>int")
		("$Function1<? super T, T>"->"T extends Integer").isAssignableFrom("(int)=>int")
		("$Function1<T, ? extends T>"->"T extends Integer").isAssignableFrom("(int)=>int")
		("$Function1<? super T, ? extends T>"->"T extends Integer").isAssignableFrom("(int)=>int")
	}

	@Test
	override testFunctionTypeAsParameterized_08() {
		"(String)=>void".isAssignableFrom("$Procedure1<CharSequence>")
		"(String)=>void".isAssignableFrom("$Procedure1<String>")
		"(CharSequence)=>void".isAssignableFrom("$Procedure1<String>")
	}
	
	@Test
	override testFunctionTypeAsParameterized_09() {
		"(String)=>String".isAssignableFrom("$Function1<CharSequence,String>")
		"(CharSequence)=>String".isAssignableFrom("$Function1<String, String>")
	}
	
	@Test
	override testFunctionTypeAsParameterized_10() {
		"(String)=>CharSequence".isAssignableFrom("$Function1<CharSequence, String>")
		"(String)=>CharSequence".isAssignableFrom("$Function1<CharSequence, String>")
		"(CharSequence)=>CharSequence".isAssignableFrom("$Function1<String, String>")
	}
	
	@Test
	override testFunctionTypeAsParameterized_14() {
		("(T)=>T"->"T extends Integer").isAssignableFrom("$Function1<Integer, Integer>")
	}

	@Test
	override testDemandConvertedFunctionType_01() {
		"org.eclipse.xtext.util.IAcceptor<String>".isAssignableFrom("(CharSequence)=>void")
		"org.eclipse.xtext.util.IAcceptor<? super String>".isAssignableFrom("(CharSequence)=>void")
		"org.eclipse.xtext.util.IAcceptor<String>".isAssignableFrom("(Object)=>void")
		"org.eclipse.xtext.util.IAcceptor<? super String>".isAssignableFrom("(Object)=>void")
		"org.eclipse.xtext.util.IAcceptor<String>".isAssignableFrom("(String)=>void")
		"org.eclipse.xtext.util.IAcceptor<? super String>".isAssignableFrom("(String)=>void")
		"org.eclipse.xtext.util.IAcceptor<CharSequence>".isAssignableFrom("(String)=>void")
		"org.eclipse.xtext.util.IAcceptor<? super CharSequence>".isAssignableFrom("(String)=>void")
	}
	
	@Test
	override testDemandConvertedFunctionType_05() {
		"org.eclipse.xtext.util.IAcceptor<Integer>".isAssignableFrom("(int)=>void")
		"org.eclipse.xtext.util.IAcceptor<? super Integer>".isAssignableFrom("(int)=>void")
		"org.eclipse.xtext.util.IAcceptor<? extends Integer>".isAssignableFrom("(int)=>void")
		"org.eclipse.xtext.util.IAcceptor<Number>".isAssignableFrom("(int)=>void")
		"org.eclipse.xtext.util.IAcceptor<? extends Number>".isAssignableFrom("(int)=>void")
		"org.eclipse.xtext.util.IAcceptor<? super Number>".isAssignableFrom("(int)=>void")
	}
	
	@Test
	override testDemandConvertedFunctionType_06() {
		"Comparable<Integer>".isAssignableFrom("(int)=>int")
		"Comparable<String>".isAssignableFrom("(int)=>int")
	}
	
	@Test
	override testBug409847_01() {
		"java.lang.Class<? extends java.lang.Iterable<?>>".isAssignableFrom("java.lang.Class<java.util.ArrayList>")
		"java.lang.Class<? extends java.lang.Iterable<?>>".isAssignableFrom("java.lang.Class<java.util.ArrayList<java.lang.Integer>>")
		"java.lang.Class<? extends java.lang.Iterable>".isAssignableFrom("java.lang.Class<java.util.ArrayList>")
	}
	
	@Test
	override testBug409847_02() {
		"java.lang.Class<java.util.ArrayList<?>>".isAssignableFrom("java.lang.Class<java.util.ArrayList>")
	}
	
	@Test
	override testBug409847_03() {
		"java.lang.Class<java.util.ArrayList>".isAssignableFrom("java.lang.Class<java.util.ArrayList<?>>")
	}

	@Test
	override testBug409847_04() {
		"java.lang.Iterable<? extends java.lang.Iterable<?>>".isAssignableFrom("java.util.ArrayList<java.util.ArrayList>")
		"java.lang.Iterable<? extends java.lang.Iterable<?>>".isAssignableFrom("java.util.ArrayList<java.util.ArrayList<java.lang.Integer>>")
		"java.lang.Iterable<? extends java.lang.Iterable>".isAssignableFrom("java.util.ArrayList<java.util.ArrayList>")
	}
	
	@Test
	override void testStringIsNotComparableInteger() {
		"java.lang.Comparable<? extends Integer>".isAssignableFrom("String")
		"java.lang.Comparable<Integer>".isAssignableFrom("String")
	}
	
	@Test
	override testClassStringIntMapIsClassMap() {
		"java.lang.Class<? extends java.util.Map>".isAssignableFrom("java.lang.Class<org.eclipse.xtend.core.tests.typesystem.StringIntMap>")
		"java.lang.Class<? super java.util.Map>".isAssignableFrom("java.lang.Class<org.eclipse.xtend.core.tests.typesystem.StringIntMap>")
		"java.lang.Class<? super org.eclipse.xtend.core.tests.typesystem.StringIntMap>".isAssignableFrom("java.lang.Class<java.util.Map>")
	}
	
	@Test
	override testClassMapIsClassMapStringInteger() {
		"java.lang.Class<? extends java.util.Map>".isAssignableFrom("java.lang.Class<? extends java.util.Map<String, Integer>>")
		"java.lang.Class<? extends java.util.Map>".isAssignableFrom("java.lang.Class<? extends java.util.Map<?, ?>>")
		"java.lang.Class<? super java.util.Map>".isAssignableFrom("java.lang.Class<? super java.util.Map<String, Integer>>")
		"java.lang.Class<? super java.util.Map>".isAssignableFrom("java.lang.Class<? super java.util.Map<?, ?>>")
		"java.lang.Class<? super java.util.Map<String, Integer>>".isAssignableFrom("java.lang.Class<? super java.util.Map>")
		"java.lang.Class<? super java.util.Map<?, ?>>".isAssignableFrom("java.lang.Class<? super java.util.Map>")
	}
	
}

@InjectWith(RuntimeInjectorProviderWithCustomSynonyms)
class AssignabilityWithCustomSynonymsTest extends AbstractAssignabilityTest {
	
	@Test 
	def void testBigIntegerIsBigDecimal() {
		"java.math.BigDecimal".isAssignableFrom("java.math.BigInteger")
	}
	
	@Test 
	def void testIterableBigIntegerIsNotIterableBigDecimal() {
		"Iterable<java.math.BigDecimal>".isNotAssignableFrom("Iterable<java.math.BigInteger>")
	}
	
}

interface StrangeIterable<T> extends Iterable {}
interface StringIntMap extends Map<String, Integer> {}