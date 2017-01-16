/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.caliper.tests.typesystem.newImpl

import org.junit.Ignore
import org.junit.Test

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
	def void testNestedWildcard_01() {
		"java.util.List<java.util.List<?>>".isNotAssignableFrom("java.util.List<java.util.List<? extends CharSequence>>")
		"java.util.Collection<java.util.List<?>>".isNotAssignableFrom("java.util.List<java.util.List<? extends CharSequence>>")
		"java.util.Collection<java.util.List<? extends CharSequence>>".isAssignableFrom("java.util.List<java.util.List<? extends CharSequence>>")
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
	def void testArrayType_05() {
		"Iterable<?>[]".isAssignableFrom("Iterable<?>[]")
		"Iterable<?>[]".isAssignableFrom("Iterable<? extends CharSequence>[]")
		"Iterable<?>[]".isAssignableFrom("Iterable[]")
		"Iterable[]".isAssignableFrom("Iterable<?>[]")
		"Iterable[]".isAssignableFrom("Iterable<? extends CharSequence>[]")
		("Iterable<?>[]"->"T").isAssignableFrom("Iterable<? extends T>[]")
		("Iterable<?>[]"->"T extends Iterable<?>").isAssignableFrom("T[]")
	}
	
	@Test
	def void testArrayType_06() {
		"Iterable<Iterable<?>>".isAssignableFrom("Iterable<?>[]")
		("Iterable<T>"->"T extends Iterable<?>").isAssignableFrom("T[]")
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
	
	@Ignore("Substitutions are not applied recursively according to JLS - see ticket 395002")
	@Test
	def void testBug395002_02() {
		("$<? extends $<?, A>, ?>".selfBound->"A extends $<?,A>".selfBound).isAssignableFrom("$<?, A>".selfBound)
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
	
	@Test
	def void testInnerClasses_01() {
		"test.InnerClasses.Super<Number>.Inner<Number>".isAssignableFrom("test.InnerClasses.Super<Number>.Inner<Number>")
		"test.InnerClasses.Super<Number>.Inner<Number>".isAssignableFrom("test.InnerClasses.Super<Number>.SubInner<Number>")
		"test.InnerClasses.Super<Number>.Inner<Number>".isAssignableFrom("test.InnerClasses.Sub<Number>.Inner<Number>")
		"test.InnerClasses.Sub<Number>.Inner<Number>".isAssignableFrom("test.InnerClasses.Super<Number>.Inner<Number>")
		"test.InnerClasses.Super<Number>.Inner<Number>".isAssignableFrom("test.InnerClasses.Sub<Number>.SubInner<Number>")
		"test.InnerClasses.Sub<Number>.Inner<Number>".isAssignableFrom("test.InnerClasses.Super<Number>.SubInner<Number>")
	}
	
	@Test
	def void testInnerClasses_02() {
		"test.InnerClasses.SubString<Number>.Inner<Number>".isAssignableFrom("test.InnerClasses.Super<String>.Inner<Number>")
		"test.InnerClasses.Super<String>.Inner<Number>".isAssignableFrom("test.InnerClasses.SubString<Number>.Inner<Number>")
	}

	@Test
	def void testInnerClasses_03() {
		"test.InnerClasses.SubString<Number>.Inner<Number>".isNotAssignableFrom("test.InnerClasses.Super<String>.Inner<Integer>")
		"test.InnerClasses.Super<String>.Inner<Integer>".isNotAssignableFrom("test.InnerClasses.SubString<Number>.Inner<Number>")
	}
	
	@Test
	def void testInnerClasses_04() {
		"test.InnerClasses.SubString<Number>.Inner<? extends Number>".isAssignableFrom("test.InnerClasses.Super<String>.Inner<Integer>")
		"test.InnerClasses.Super<String>.Inner<Integer>".isNotAssignableFrom("test.InnerClasses.SubString<Number>.Inner<? extends Number>")
	}
	
	@Test
	def void testInnerClasses_05() {
		"test.InnerClasses.SubString<String>.Inner<Number>".isAssignableFrom("test.InnerClasses.Super<String>.Inner<Number>")
		"test.InnerClasses.Super<String>.Inner<Number>".isAssignableFrom("test.InnerClasses.SubString<String>.Inner<Number>")
	}
	
	@Test
	def void testInnerClasses_06() {
		"test.InnerClasses.SubString<Number>.Inner<Number>".isAssignableFrom("test.InnerClasses.SubString<String>.Inner<Number>")
		"test.InnerClasses.SubString<String>.Inner<Number>".isAssignableFrom("test.InnerClasses.SubString<Number>.Inner<Number>")
	}
	
	@Test
	def void testInnerClasses_07() {
		"test.InnerClasses.Super<Number>.Inner<Number>".isNotAssignableFrom("test.InnerClasses.Super<String>.Inner<Number>")
		"test.InnerClasses.Super<String>.Inner<Number>".isNotAssignableFrom("test.InnerClasses.Super<Number>.Inner<Number>")
	}
	
	@Test
	def void testInnerClasses_08() {
		"test.InnerClasses.Super<String>.Inner<String>".isAssignableFrom("test.InnerClasses.Super<String>.SubInner<String>")
		"test.InnerClasses.Super<String>.SubInner<String>".isNotAssignableFrom("test.InnerClasses.Super<String>.Inner<String>")
	}
	
	@Test
	def void testInnerClasses_09() {
		"test.InnerClasses.Sub<String>.Inner<String>".isAssignableFrom("test.InnerClasses.Sub<String>.SubInner<String>")
		"test.InnerClasses.Sub<String>.SubInner<String>".isNotAssignableFrom("test.InnerClasses.Sub<String>.Inner<String>")
	}
	
	@Test
	def void testInnerClasses_10() {
		"test.InnerClasses.Sub<String>.Inner<String>".isAssignableFrom("test.InnerClasses.Super<String>.Inner<String>")
		"test.InnerClasses.Super<String>.Inner<String>".isAssignableFrom("test.InnerClasses.Sub<String>.Inner<String>")
	}
	
	@Test
	def void testInnerClasses_11() {
		"test.InnerClasses.Super<String>.Inner<String>".isAssignableFrom("test.InnerClasses.Sub<String>.SubInner2<Number>")
		"test.InnerClasses.Super<String>.Inner<String>".isNotAssignableFrom("test.InnerClasses.Sub<Number>.SubInner2<Number>")
	}
	
	@Test
	def void testInnerClasses_12() {
		"test.InnerClasses.Super<String>.Inner<String>".isAssignableFrom("test.InnerClasses.Sub<String>.SubInner2<Number>")
		"test.InnerClasses.Super<String>.Inner<String>".isNotAssignableFrom("test.InnerClasses.Sub<Number>.SubInner2<Number>")
		"test.InnerClasses.Super<String>.Inner<Number>".isNotAssignableFrom("test.InnerClasses.Sub<Number>.SubInner2<Number>")
	}
	
	@Test
	def void testInnerClasses_13() {
		"test.InnerClasses.Super<String>.Inner<Number>".isAssignableFrom("test.InnerClasses.Sub<String>.SubInner<Number>")
		"test.InnerClasses.Super<String>.SubInner<Number>".isNotAssignableFrom("test.InnerClasses.Sub<String>.SubInner2<Number>")
		"test.InnerClasses.Super<String>.Inner<String>".isNotAssignableFrom("test.InnerClasses.Sub<Number>.SubInner<Number>")
	}
	
	@Test
	def void testInnerClasses_14() {
		"test.InnerClasses.Super2<String>.Inner<String>".isAssignableFrom("test.InnerClasses.Sub2.SubInner")
		"test.InnerClasses.Sub2.Inner<String>".isAssignableFrom("test.InnerClasses.Sub2.SubInner")
		"test.InnerClasses.Sub2.Inner<? extends CharSequence>".isAssignableFrom("test.InnerClasses.Sub2.SubInner")
		"test.InnerClasses.Sub2.SubInner".isNotAssignableFrom("test.InnerClasses.Super2<String>.Inner<String>")
		"test.InnerClasses.Sub2.SubInner".isNotAssignableFrom("test.InnerClasses.Sub2.Inner<String>")
	}
	
	@Test
	def void testInnerClasses_15() {
		"test.InnerClasses.Super3<String>.Inner<Number>".isAssignableFrom("test.InnerClasses.Sub5<Number>")
		"test.InnerClasses.Super3<String>.Inner<String>".isNotAssignableFrom("test.InnerClasses.Sub5<Number>")
		"test.InnerClasses.Super3<Number>.Inner<Number>".isNotAssignableFrom("test.InnerClasses.Sub5<Number>")
	}
}