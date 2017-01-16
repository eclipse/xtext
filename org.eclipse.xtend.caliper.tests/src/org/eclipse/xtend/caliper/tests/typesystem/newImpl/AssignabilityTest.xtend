/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.caliper.tests.typesystem.newImpl

import java.util.Map
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceFlags
import org.eclipse.xtext.xbase.typesystem.conformance.TypeConformanceComputationArgument
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference
import org.junit.Test

/**
 * @author Sebastian Zarnekow
 */
abstract class AssignabilityTest extends CommonAssignabilityTest {
	
	override doIsAssignable(LightweightTypeReference lhs, LightweightTypeReference rhs) {
		val result = lhs.internalIsAssignableFrom(rhs, new TypeConformanceComputationArgument(false, false, true, true, false, true))
		assertTrue(result.bitwiseAnd(ConformanceFlags.RAW_TYPE) == 0)
		return result.bitwiseAnd(ConformanceFlags.SUCCESS) != 0;
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
		("()=>long").isAssignableFrom("$Function0<? extends java.lang.Integer>")
		("()=>int").isNotAssignableFrom("$Function0<? extends java.lang.Long>")
		("$Function0<? extends java.lang.Long>").isNotAssignableFrom("$Function0<? extends java.lang.Integer>")
		("$Function0<? extends java.lang.Integer>").isNotAssignableFrom("$Function0<? extends java.lang.Long>")
		("$Function0<? extends java.lang.Long>").isNotAssignableFrom("()=>int")
		("$Function0<? extends java.lang.Integer>").isNotAssignableFrom("()=>long")
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

interface StrangeIterable<T> extends Iterable {}
interface StringIntMap extends Map<String, Integer> {}
