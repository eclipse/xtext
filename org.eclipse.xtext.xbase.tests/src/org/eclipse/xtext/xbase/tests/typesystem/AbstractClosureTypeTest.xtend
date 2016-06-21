/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typesystem

import java.util.Set
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.xbase.XClosure
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Test
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import java.util.List
import org.junit.Ignore

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
abstract class AbstractClosureTypeTest extends AbstractXbaseTestCase {
	
	def List<Object> resolvesClosuresTo(String expression, String... types)
	
	def void withEquivalents(List<Object> references, String... type)
	
	static Set<String> seenExpressions
	
	@BeforeClass
	def static void createSeenExpressionsSet() {
		seenExpressions = newHashSet
	}
	
	@AfterClass
	def static void discardSeenExpressions() {
		seenExpressions = null
	}
	
	def protected findClosures(CharSequence expression) {
		val expressionAsString = expression.toString
			.replace('ClosureTypeResolutionTestData', 'org.eclipse.xtext.xbase.tests.typesystem.ClosureTypeResolutionTestData')
			.replace('$$', 'org::eclipse::xtext::xbase::lib::')
		val xExpression = expression(expressionAsString, false)
		val Closures = EcoreUtil2::eAll(xExpression).filter(typeof(XClosure)).toList
		return Closures.sortBy [ NodeModelUtils::findActualNodeFor(it).offset ]
	}
	
	override protected expression(CharSequence expression, boolean resolve) throws Exception {
		val string = expression.toString
		if (!seenExpressions.add(string)) {
			fail("Duplicate expression under test: " + expression)
		}
		super.expression(expression, resolve)
	}
	
	@Test def void testVariableDeclaration_01() throws Exception {
		"{ var com.google.inject.Provider<CharSequence> p = [ new StringBuilder ] }".resolvesClosuresTo("()=>StringBuilder").withEquivalents("Provider<CharSequence>")
	}
	
	@Test def void testVariableDeclaration_02() throws Exception {
		"{ var com.google.inject.Provider<? extends CharSequence> p = [ new StringBuilder ] }".resolvesClosuresTo("()=>StringBuilder").withEquivalents("Provider<CharSequence>")
	}
	
	@Test def void testVariableDeclaration_03() throws Exception {
		"{ var com.google.inject.Provider<? super CharSequence> p = [ new StringBuilder ] }".resolvesClosuresTo("()=>StringBuilder").withEquivalents("Provider<CharSequence>")
	}
	
	@Test def void testSpecializedSubInterface_01() throws Exception {
		"closures::Client::invokeSubIntf [ length.toString ]".resolvesClosuresTo("(CharSequence)=>String").withEquivalents("SubIntf")
	}
	
	@Test def void testSpecializedSubInterface_02() throws Exception {
		"closures::Client::invokeIntf [ it ]".resolvesClosuresTo("(Object)=>Object").withEquivalents("Intf<Object>")
	}
	
	@Test def void testSpecializedSubInterface_03() throws Exception {
		"closures::Client::invokeIntf [ String it | it ]".resolvesClosuresTo("(String)=>String").withEquivalents("Intf<String>")
	}
	
	@Test def void testSpecializedSubInterface_04() throws Exception {
		"closures::Client::<String>invokeIntf [ it ]".resolvesClosuresTo("(String)=>String").withEquivalents("Intf<String>")
	}
	
	@Test def void testSpecializedSubInterface_05() throws Exception {
		"closures::Client::invokeConstrainedIntf [ it ]".resolvesClosuresTo("(CharSequence)=>CharSequence").withEquivalents("Intf<CharSequence>")
	}
	
	@Test def void testSpecializedSubInterface_06() throws Exception {
		"closures::Client::invokeParameterizedSubIntf [ it ]".resolvesClosuresTo("(CharSequence)=>CharSequence").withEquivalents("ParameterizedSubIntf<CharSequence>")
	}
	
	@Test def void testSpecializedSubInterface_07() throws Exception {
		"closures::Client::invokeConcreteParameterizedSubIntf [ it ]".resolvesClosuresTo("(String)=>String").withEquivalents("ParameterizedSubIntf<String>")
	}
	
	@Test def void testIfExpression_01() throws Exception {
		"if (true) [|''] else [|'']".resolvesClosuresTo("()=>String", "()=>String").withEquivalents("Function0<String>", "Function0<String>")
	}
	
	@Test def void testIfExpression_02() throws Exception {
		"if (true) [|''] else [|null as CharSequence]".resolvesClosuresTo("()=>String", "()=>CharSequence").withEquivalents("Function0<String>", "Function0<CharSequence>")
	}
	
	@Test def void testIfExpression_03() throws Exception {
		"if (true) [|null as Appendable] else [|null as CharSequence]".resolvesClosuresTo("()=>Appendable", "()=>CharSequence").withEquivalents("Function0<Appendable>", "Function0<CharSequence>")
	}
	
	@Test def void testIfExpression_04() throws Exception {
		"if (true) [ CharSequence c |''] else [ String s |'']".resolvesClosuresTo("(CharSequence)=>String", "(String)=>String").withEquivalents("Function1<CharSequence, String>", "Function1<String, String>")
	}
	
	@Test def void testIfExpression_05() throws Exception {
		"if (true) [new StringBuilder()] else [new StringBuffer()]".resolvesClosuresTo("(Object)=>StringBuilder", "(Object)=>StringBuffer")
			.withEquivalents("Function1<Object, StringBuilder>", "Function1<Object, StringBuffer>")
	}
	
	@Test def void testIfExpression_06() throws Exception {
		"(if (true) [new StringBuilder()] else [new StringBuffer()]).apply('')".resolvesClosuresTo("(String)=>StringBuilder", "(String)=>StringBuffer")
			.withEquivalents("Function1<String, StringBuilder>", "Function1<String, StringBuffer>")
	}
	
	@Test def void testIfExpression_07() throws Exception {
		"(if (true) [CharSequence c | new StringBuilder()] else [new StringBuffer()])"
			.resolvesClosuresTo("(CharSequence)=>StringBuilder", "(CharSequence)=>StringBuffer")
			.withEquivalents("Function1<CharSequence, StringBuilder>", "Function1<CharSequence, StringBuffer>")
	}
	
	@Test def void testIfExpression_08() throws Exception {
		"(if (true) [CharSequence c | new StringBuilder()] else [new StringBuffer()]).apply('')"
			.resolvesClosuresTo("(CharSequence)=>StringBuilder", "(CharSequence)=>StringBuffer")
			.withEquivalents("Function1<CharSequence, StringBuilder>", "Function1<CharSequence, StringBuffer>")
	}

	@Test def void testIfExpression_09() throws Exception {
		"(if (true) [new StringBuilder()] else [CharSequence c | new StringBuffer()])"
			.resolvesClosuresTo("(CharSequence)=>StringBuilder", "(CharSequence)=>StringBuffer")
			.withEquivalents("Function1<CharSequence, StringBuilder>", "Function1<CharSequence, StringBuffer>")
	}
	
	@Test def void testIfExpression_10() throws Exception {
		"(if (true) [new StringBuilder()] else [CharSequence c | new StringBuffer()]).apply('')"
			.resolvesClosuresTo("(CharSequence)=>StringBuilder", "(CharSequence)=>StringBuffer")
			.withEquivalents("Function1<CharSequence, StringBuilder>", "Function1<CharSequence, StringBuffer>")
	}
	
	@Test def void testIfExpression_11() throws Exception {
		"(if (true) [Appendable a |new StringBuilder()] else [CharSequence c | new StringBuffer()])"
			.resolvesClosuresTo("(Appendable)=>StringBuilder", "(CharSequence)=>StringBuffer")
			.withEquivalents("Function1<Appendable, StringBuilder>", "Function1<CharSequence, StringBuffer>")
	}
	
	@Test def void testIfExpression_12() throws Exception {
		"{ var java.io.FileFilter filter = (if (true) [true] else [false])"
			.resolvesClosuresTo("(File)=>boolean", "(File)=>boolean")
			.withEquivalents("FileFilter", "FileFilter")
	}
	
	@Test def void testIfExpression_13() throws Exception {
		"if (true) [| return ''] else [| return '']".resolvesClosuresTo("()=>String", "()=>String").withEquivalents("Function0<String>", "Function0<String>")
	}
	
	@Test def void testIfExpression_14() throws Exception {
		"if (true) [| return ''] else [| return null as CharSequence]".resolvesClosuresTo("()=>String", "()=>CharSequence").withEquivalents("Function0<String>", "Function0<CharSequence>")
	}
	
	@Test def void testIfExpression_15() throws Exception {
		"if (true) [| return null as Appendable] else [| return null as CharSequence]".resolvesClosuresTo("()=>Appendable", "()=>CharSequence").withEquivalents("Function0<Appendable>", "Function0<CharSequence>")
	}
	
	@Test def void testIfExpression_16() throws Exception {
		"if (true) [ CharSequence c | return ''] else [ String s | return '']".resolvesClosuresTo("(CharSequence)=>String", "(String)=>String").withEquivalents("Function1<CharSequence, String>", "Function1<String, String>")
	}
	
	@Test def void testIfExpression_17() throws Exception {
		"if (true) [return new StringBuilder()] else [return new StringBuffer()]".resolvesClosuresTo("(Object)=>StringBuilder", "(Object)=>StringBuffer")
			.withEquivalents("Function1<Object, StringBuilder>", "Function1<Object, StringBuffer>")
	}
	
	@Test def void testIfExpression_18() throws Exception {
		"(if (true) [return new StringBuilder()] else [return new StringBuffer()]).apply('')".resolvesClosuresTo("(String)=>StringBuilder", "(String)=>StringBuffer")
			.withEquivalents("Function1<String, StringBuilder>", "Function1<String, StringBuffer>")
	}
	
	@Test def void testIfExpression_19() throws Exception {
		"(if (true) [CharSequence c | return new StringBuilder()] else [return new StringBuffer()])"
			.resolvesClosuresTo("(CharSequence)=>StringBuilder", "(CharSequence)=>StringBuffer")
			.withEquivalents("Function1<CharSequence, StringBuilder>", "Function1<CharSequence, StringBuffer>")
	}
	
	@Test def void testIfExpression_20() throws Exception {
		"(if (true) [CharSequence c | return new StringBuilder()] else [return new StringBuffer()]).apply('')"
			.resolvesClosuresTo("(CharSequence)=>StringBuilder", "(CharSequence)=>StringBuffer")
			.withEquivalents("Function1<CharSequence, StringBuilder>", "Function1<CharSequence, StringBuffer>")
	}

	@Test def void testIfExpression_21() throws Exception {
		"(if (true) [return new StringBuilder()] else [CharSequence c | return new StringBuffer()])"
			.resolvesClosuresTo("(CharSequence)=>StringBuilder", "(CharSequence)=>StringBuffer")
			.withEquivalents("Function1<CharSequence, StringBuilder>", "Function1<CharSequence, StringBuffer>")
	}
	
	@Test def void testIfExpression_22() throws Exception {
		"(if (true) [return new StringBuilder()] else [CharSequence c | return new StringBuffer()]).apply('')"
			.resolvesClosuresTo("(CharSequence)=>StringBuilder", "(CharSequence)=>StringBuffer")
			.withEquivalents("Function1<CharSequence, StringBuilder>", "Function1<CharSequence, StringBuffer>")
	}
	
	@Test def void testIfExpression_23() throws Exception {
		"(if (true) [Appendable a | return new StringBuilder()] else [CharSequence c | return new StringBuffer()])"
			.resolvesClosuresTo("(Appendable)=>StringBuilder", "(CharSequence)=>StringBuffer")
			.withEquivalents("Function1<Appendable, StringBuilder>", "Function1<CharSequence, StringBuffer>")
	}
	
	@Test def void testIfExpression_24() throws Exception {
		"{ var java.io.FileFilter filter = (if (true) [return true] else [return false])"
			.resolvesClosuresTo("(File)=>boolean", "(File)=>boolean")
			.withEquivalents("FileFilter", "FileFilter")
	}
	
	@Test def void testIfExpression_25() throws Exception {
		"{ 
			val Iterable<Object> branch = 
			  if (true) 
			    [|<Object>newArrayList().iterator]
			  else
			    newArrayList('a').toArray
		}"
			.resolvesClosuresTo("()=>Iterator<Object>")
			.withEquivalents("Iterable<Object>")
	}
	
	@Test def void testSwitchExpression_01() throws Exception {
		"switch null {
            case null : [Object it | it]
            case null : [Integer it | it]
        }".resolvesClosuresTo("(Object)=>Object", "(Integer)=>Integer")
		  .withEquivalents("Function1<Object, Object>", "Function1<Integer, Integer>")
	}
	
	@Test def void testNumberLiteralInClosure_01() throws Exception {
		"newArrayList().map[42]".resolvesClosuresTo("(Object)=>int").withEquivalents("Function1<Object, Integer>")
	}
	
	@Test def void testNumberLiteralInClosure_02() throws Exception {
		"newArrayList().map[return 42]".resolvesClosuresTo("(Object)=>int").withEquivalents("Function1<Object, Integer>")
	}
	
	@Test def void testOverloadedOperators_01() throws Exception {
		"(0..Math::sqrt(1l).intValue).filter[ i | 1l % i == 0 ].isEmpty"
			.resolvesClosuresTo("(Integer)=>boolean")
			.withEquivalents("Function1<Integer, Boolean>")
	}
	
	@Test def void testOverloadedOperators_02() throws Exception {
		"(1..2).map[ toString ].reduce[ i1, i2| i1 + i2 ]"
			.resolvesClosuresTo("(Integer)=>String", "(String, String)=>String")
			.withEquivalents("Function1<Integer, String>", "Function2<String, String, String>")
	}
	
	@Test def void testOverloadedOperators_03() throws Exception {
		"(1..2).map[ toString.length ].reduce[ i1, i2| i1 + i2 ]"
			.resolvesClosuresTo("(Integer)=>int", "(Integer, Integer)=>int")
			.withEquivalents("Function1<Integer, Integer>", "Function2<Integer, Integer, Integer>")
	}
	
	@Test def void testOverloadedOperators_04() throws Exception {
		"(1..2).map[ new java.math.BigInteger(toString) ].reduce[ i1, i2| i1 + i2 ]"
			.resolvesClosuresTo("(Integer)=>BigInteger", "(BigInteger, BigInteger)=>BigInteger")
			.withEquivalents("Function1<Integer, BigInteger>", "Function2<BigInteger, BigInteger, BigInteger>")
	}
	
	@Ignore("i1 and i2 should become T -> Object thus + maps to String + Object")
	@Test def void testOverloadedOperators_05() throws Exception {
		"(1..2).map[ new java.math.BigInteger(toString) ].reduce[ i1, i2 | i1.toString + i2 ]"
			.resolvesClosuresTo("(Integer)=>BigInteger", "(Object, Object)=>String")
			.withEquivalents("Function1<Integer, BigInteger>", "Function2<Object, Object, String>")
	}
	
	@Ignore("i1 and i2 should become T -> Object thus + maps to Object + String")
	@Test def void testOverloadedOperators_06() throws Exception {
		"(1..2).map[ new java.math.BigInteger(toString) ].reduce[ i1, i2| i1 + String::valueOf(i2) ]"
			.resolvesClosuresTo("(Integer)=>BigInteger", "(Object, Object)=>String")
			.withEquivalents("Function1<Integer, BigInteger>", "Function2<Object, Object, String>")
	}
	
	@Test def void testOverloadedOperators_07() throws Exception {
		"(1..2).map[ new java.math.BigInteger(toString) ].map[ i | i.toString + i ]"
			.resolvesClosuresTo("(Integer)=>BigInteger", "(BigInteger)=>String")
			.withEquivalents("Function1<Integer, BigInteger>", "Function1<BigInteger, String>")
	}
	
	@Test def void testOverloadedOperators_08() throws Exception {
		"(1..2).map[ new java.math.BigInteger(toString) ].map[ i | i + String::valueOf(i) ]"
			.resolvesClosuresTo("(Integer)=>BigInteger", "(BigInteger)=>String")
			.withEquivalents("Function1<Integer, BigInteger>", "Function1<BigInteger, String>")
	}
	
	@Test def void testOverloadedOperators_09() throws Exception {
		"(0..Math::sqrt(1l).intValue).filter[ i | 1l % i == 0 ].empty"
			.resolvesClosuresTo("(Integer)=>boolean")
			.withEquivalents("Function1<Integer, Boolean>")
	}
	
	@Test def void testOverloadedOperators_10() throws Exception {
		"(0..Math::sqrt(1l).intValue).filter[ i | return 1l % i == 0 ].isEmpty"
			.resolvesClosuresTo("(Integer)=>boolean")
			.withEquivalents("Function1<Integer, Boolean>")
	}
	
	@Test def void testOverloadedOperators_11() throws Exception {
		"(1..2).map[ toString ].reduce[ i1, i2| return i1 + i2 ]"
			.resolvesClosuresTo("(Integer)=>String", "(String, String)=>String")
			.withEquivalents("Function1<Integer, String>", "Function2<String, String, String>")
	}
	
	@Test def void testOverloadedOperators_12() throws Exception {
		"(1..2).map[ toString.length ].reduce[ i1, i2| return i1 + i2 ]"
			.resolvesClosuresTo("(Integer)=>int", "(Integer, Integer)=>int")
			.withEquivalents("Function1<Integer, Integer>", "Function2<Integer, Integer, Integer>")
	}
	
	@Test def void testOverloadedOperators_13() throws Exception {
		"(1..2).map[ new java.math.BigInteger(toString) ].reduce[ i1, i2| return i1 + i2 ]"
			.resolvesClosuresTo("(Integer)=>BigInteger", "(BigInteger, BigInteger)=>BigInteger")
			.withEquivalents("Function1<Integer, BigInteger>", "Function2<BigInteger, BigInteger, BigInteger>")
	}
	
	@Test def void testOverloadedOperators_14() throws Exception {
		"(0..Math::sqrt(1l).intValue).filter[ i | if (true) return 1l % i == 0 ].isEmpty"
			.resolvesClosuresTo("(Integer)=>boolean")
			.withEquivalents("Function1<Integer, Boolean>")
	}
	
	@Test def void testOverloadedOperators_15() throws Exception {
		"(1..2).map[ if (true) toString ].reduce[ i1, i2| if (true) return i1 + i2 ]"
			.resolvesClosuresTo("(Integer)=>String", "(String, String)=>String")
			.withEquivalents("Function1<Integer, String>", "Function2<String, String, String>")
	}
	
	@Test def void testOverloadedOperators_16() throws Exception {
		"(1..2).map[ if (true) toString.length ].reduce[ i1, i2| if (true) return i1 + i2 ]"
			.resolvesClosuresTo("(Integer)=>int", "(Integer, Integer)=>int")
			.withEquivalents("Function1<Integer, Integer>", "Function2<Integer, Integer, Integer>")
	}
	
	@Test def void testOverloadedOperators_17() throws Exception {
		"(1..2).map[ new java.math.BigInteger(toString) ].reduce[ i1, i2| if (true) return i1 + i2 ]"
			.resolvesClosuresTo("(Integer)=>BigInteger", "(BigInteger, BigInteger)=>BigInteger")
			.withEquivalents("Function1<Integer, BigInteger>", "Function2<BigInteger, BigInteger, BigInteger>")
	}
	
	@Test def void testOverloadedOperators_18() throws Exception {
		"(0..Math::sqrt(1l).intValue).filter[ i | if (true) return 1l % i == 0 else return null ].isEmpty"
			.resolvesClosuresTo("(Integer)=>Boolean")
			.withEquivalents("Function1<Integer, Boolean>")
	}
	
	@Test def void testOverloadedOperators_19() throws Exception {
		"(1..2).map[ if (true) toString.length ].reduce[ i1, i2| if (true) return i1 + i2 else return 1 ]"
			.resolvesClosuresTo("(Integer)=>int", "(Integer, Integer)=>int")
			.withEquivalents("Function1<Integer, Integer>", "Function2<Integer, Integer, Integer>")
	}
	
	@Test def void testOverloadedOperators_20() throws Exception {
		"(1..2).map[ if (true) toString.length ].reduce[ i1, i2| if (true) return i1 + i2 else return null ]"
			.resolvesClosuresTo("(Integer)=>int", "(Integer, Integer)=>Integer")
			.withEquivalents("Function1<Integer, Integer>", "Function2<Integer, Integer, Integer>")
	}
	
	@Test def void testOverloadedOperators_21() throws Exception {
		"(1..2).map[ return toString ].reduce[ i1, i2| return i1 + i2 ]"
			.resolvesClosuresTo("(Integer)=>String", "(String, String)=>String")
			.withEquivalents("Function1<Integer, String>", "Function2<String, String, String>")
	}
	
	@Test def void testOverloadedOperators_22() throws Exception {
		"(1..2).map[ return toString.length ].reduce[ i1, i2| return i1 + i2 ]"
			.resolvesClosuresTo("(Integer)=>int", "(Integer, Integer)=>int")
			.withEquivalents("Function1<Integer, Integer>", "Function2<Integer, Integer, Integer>")
	}
	
	@Test def void testOverloadedOperators_23() throws Exception {
		"(1..2).map[ return new java.math.BigInteger(toString) ].reduce[ i1, i2| return i1 + i2 ]"
			.resolvesClosuresTo("(Integer)=>BigInteger", "(BigInteger, BigInteger)=>BigInteger")
			.withEquivalents("Function1<Integer, BigInteger>", "Function2<BigInteger, BigInteger, BigInteger>")
	}
	
	@Ignore("i1 and i2 should become T -> Object thus + maps to String + Object")
	@Test def void testOverloadedOperators_24() throws Exception {
		"(1..2).map[ return new java.math.BigInteger(toString) ].reduce[ i1, i2 | return i1.toString + i2 ]"
			.resolvesClosuresTo("(Integer)=>BigInteger", "(Object, Object)=>String")
			.withEquivalents("Function1<Integer, BigInteger>", "Function2<Object, Object, String>")
	}
	
	@Ignore("i1 and i2 should become T -> Object thus + maps to Object + String")
	@Test def void testOverloadedOperators_25() throws Exception {
		"(1..2).map[ return new java.math.BigInteger(toString) ].reduce[ i1, i2| return i1 + String::valueOf(i2) ]"
			.resolvesClosuresTo("(Integer)=>BigInteger", "(Object, Object)=>String")
			.withEquivalents("Function1<Integer, BigInteger>", "Function2<Object, Object, String>")
	}
	
	@Test def void testOverloadedOperators_26() throws Exception {
		"(1..2).map[ return new java.math.BigInteger(toString) ].map[ i | return i.toString + i ]"
			.resolvesClosuresTo("(Integer)=>BigInteger", "(BigInteger)=>String")
			.withEquivalents("Function1<Integer, BigInteger>", "Function1<BigInteger, String>")
	}
	
	@Test def void testOverloadedOperators_27() throws Exception {
		"(1..2).map[ return new java.math.BigInteger(toString) ].map[ i | return i + String::valueOf(i) ]"
			.resolvesClosuresTo("(Integer)=>BigInteger", "(BigInteger)=>String")
			.withEquivalents("Function1<Integer, BigInteger>", "Function1<BigInteger, String>")
	}
	
	@Test def void testOverloadedOperators_28() throws Exception {
		"(0..Math::sqrt(1l).intValue).filter[ i | return 1l % i == 0 ].empty"
			.resolvesClosuresTo("(Integer)=>boolean")
			.withEquivalents("Function1<Integer, Boolean>")
	}
	
	@Test def void testOverloadedOperators_29() throws Exception {
		"(1..2).map[ return if (true) toString ].reduce[ i1, i2| if (true) return i1 + i2 ]"
			.resolvesClosuresTo("(Integer)=>String", "(String, String)=>String")
			.withEquivalents("Function1<Integer, String>", "Function2<String, String, String>")
	}
	
	@Test def void testOverloadedOperators_30() throws Exception {
		"(1..2).map[ return if (true) toString.length ].reduce[ i1, i2| if (true) return i1 + i2 ]"
			.resolvesClosuresTo("(Integer)=>int", "(Integer, Integer)=>int")
			.withEquivalents("Function1<Integer, Integer>", "Function2<Integer, Integer, Integer>")
	}
	
	@Test def void testOverloadedOperators_31() throws Exception {
		"(1..2).map[ return new java.math.BigInteger(toString) ].reduce[ i1, i2| if (true) return i1 + i2 ]"
			.resolvesClosuresTo("(Integer)=>BigInteger", "(BigInteger, BigInteger)=>BigInteger")
			.withEquivalents("Function1<Integer, BigInteger>", "Function2<BigInteger, BigInteger, BigInteger>")
	}
	
	@Test def void testOverloadedOperators_32() throws Exception {
		"(1..2).map[ return if (true) toString.length ].reduce[ i1, i2| if (true) return i1 + i2 else return 1 ]"
			.resolvesClosuresTo("(Integer)=>int", "(Integer, Integer)=>int")
			.withEquivalents("Function1<Integer, Integer>", "Function2<Integer, Integer, Integer>")
	}
	
	@Test def void testOverloadedOperators_33() throws Exception {
		"(1..2).map[ return if (true) toString.length ].reduce[ i1, i2| if (true) return i1 + i2 else return null ]"
			.resolvesClosuresTo("(Integer)=>int", "(Integer, Integer)=>Integer")
			.withEquivalents("Function1<Integer, Integer>", "Function2<Integer, Integer, Integer>")
	}
	
	@Test def void testOverloadedOperators_34() throws Exception {
		"(1..2).map[ if (true) return toString.length ].reduce[ i1, i2| if (true) return i1 + i2 else return 1 ]"
			.resolvesClosuresTo("(Integer)=>int", "(Integer, Integer)=>int")
			.withEquivalents("Function1<Integer, Integer>", "Function2<Integer, Integer, Integer>")
	}
	
	@Test def void testOverloadedOperators_35() throws Exception {
		"(1..2).map[ if (true) return toString.length ].reduce[ i1, i2| if (true) return i1 + i2 else return null ]"
			.resolvesClosuresTo("(Integer)=>int", "(Integer, Integer)=>Integer")
			.withEquivalents("Function1<Integer, Integer>", "Function2<Integer, Integer, Integer>")
	}
	
	@Test def void testOverloadedOperators_36() throws Exception {
		"(1..2).map[ if (true) return toString ].reduce[ i1, i2| if (true) return i1 + i2 ]"
			.resolvesClosuresTo("(Integer)=>String", "(String, String)=>String")
			.withEquivalents("Function1<Integer, String>", "Function2<String, String, String>")
	}
	
	@Test def void testOverloadedOperators_37() throws Exception {
		"(1..2).map[ if (true) return toString.length ].reduce[ i1, i2| if (true) return i1 + i2 ]"
			.resolvesClosuresTo("(Integer)=>int", "(Integer, Integer)=>int")
			.withEquivalents("Function1<Integer, Integer>", "Function2<Integer, Integer, Integer>")
	}

	@Test def void testMethodTypeParamInference_00() throws Exception {
		"new java.util.ArrayList<String>().findFirst(e | true)"
			.resolvesClosuresTo("(String)=>boolean")
			.withEquivalents("Function1<String, Boolean>")
	}
	
	@Test def void testMethodTypeParamInference_01() throws Exception {
		"new java.util.ArrayList<String>().findFirst(e|e == 'foo')"
			.resolvesClosuresTo("(String)=>boolean")
			.withEquivalents("Function1<String, Boolean>")
	}
	
	@Test def void testMethodTypeParamInference_02() throws Exception {
		"new java.util.ArrayList<String>().<String>findFirst(e|e == 'foo')"
			.resolvesClosuresTo("(String)=>boolean")
			.withEquivalents("Function1<String, Boolean>")
	}
	
	@Test def void testMethodTypeParamInference_03() throws Exception {
		"new java.util.ArrayList<String>().findFirst(Object e|e == 'foo')"
			.resolvesClosuresTo("(Object)=>boolean")
			.withEquivalents("Function1<Object, Boolean>")
	}
	
	@Test def void testMethodTypeParamInference_04() throws Exception {
		"$$IterableExtensions::findFirst(new java.util.ArrayList<String>) [e | true]"
			.resolvesClosuresTo("(String)=>boolean")
			.withEquivalents("Function1<String, Boolean>")
	}
	
	@Test def void testMethodTypeParamInference_05() throws Exception {
		"$$IterableExtensions::findFirst(new java.util.ArrayList<String>) [e|e == 'foo']"
			.resolvesClosuresTo("(String)=>boolean")
			.withEquivalents("Function1<String, Boolean>")
	}
	
	@Test def void testMethodTypeParamInference_06() throws Exception {
		"$$IterableExtensions::<String>findFirst(new java.util.ArrayList<String>) [e|e == 'foo']"
			.resolvesClosuresTo("(String)=>boolean")
			.withEquivalents("Function1<String, Boolean>")
	}
	
	@Test def void testMethodTypeParamInference_07() throws Exception {
		"$$IterableExtensions::<String>findFirst(new java.util.ArrayList<String>) [Object e|e == 'foo']"
			.resolvesClosuresTo("(Object)=>boolean")
			.withEquivalents("Function1<Object, Boolean>")
	}
	
	@Test def void testMethodTypeParamInference_08() throws Exception {
		"new java.util.ArrayList<String>().findFirst(e | return true)"
			.resolvesClosuresTo("(String)=>boolean")
			.withEquivalents("Function1<String, Boolean>")
	}
	
	@Test def void testMethodTypeParamInference_09() throws Exception {
		"new java.util.ArrayList<String>().findFirst(e| return e == 'foo')"
			.resolvesClosuresTo("(String)=>boolean")
			.withEquivalents("Function1<String, Boolean>")
	}
	
	@Test def void testMethodTypeParamInference_10() throws Exception {
		"new java.util.ArrayList<String>().<String>findFirst(e| return e == 'foo')"
			.resolvesClosuresTo("(String)=>boolean")
			.withEquivalents("Function1<String, Boolean>")
	}
	
	@Test def void testMethodTypeParamInference_11() throws Exception {
		"new java.util.ArrayList<String>().findFirst(Object e| return e == 'foo')"
			.resolvesClosuresTo("(Object)=>boolean")
			.withEquivalents("Function1<Object, Boolean>")
	}
	
	@Test def void testMethodTypeParamInference_12() throws Exception {
		"$$IterableExtensions::findFirst(new java.util.ArrayList<String>) [e | return true]"
			.resolvesClosuresTo("(String)=>boolean")
			.withEquivalents("Function1<String, Boolean>")
	}
	
	@Test def void testMethodTypeParamInference_13() throws Exception {
		"$$IterableExtensions::findFirst(new java.util.ArrayList<String>) [e| return e == 'foo']"
			.resolvesClosuresTo("(String)=>boolean")
			.withEquivalents("Function1<String, Boolean>")
	}
	
	@Test def void testMethodTypeParamInference_14() throws Exception {
		"$$IterableExtensions::<String>findFirst(new java.util.ArrayList<String>) [e| return e == 'foo']"
			.resolvesClosuresTo("(String)=>boolean")
			.withEquivalents("Function1<String, Boolean>")
	}
	
	@Test def void testMethodTypeParamInference_15() throws Exception {
		"$$IterableExtensions::<String>findFirst(new java.util.ArrayList<String>) [Object e| return e == 'foo']"
			.resolvesClosuresTo("(Object)=>boolean")
			.withEquivalents("Function1<Object, Boolean>")
	}
	
	@Test def void testTypeForVoidClosure_01() throws Exception {
		"newArrayList('foo','bar').forEach []".resolvesClosuresTo("(String)=>void").withEquivalents("Consumer<String>")
	}
	
	@Test def void testTypeForVoidClosure_02() throws Exception {
		"newArrayList('foo','bar').forEach [ return ]".resolvesClosuresTo("(String)=>void").withEquivalents("Consumer<String>")
	}

	@Test def void testClosure_00() throws Exception {
		"[|'literal'].apply()".resolvesClosuresTo("()=>String").withEquivalents("Function0<String>")
	}
	
	@Test def void testClosure_01() throws Exception {
		"{ var Closure = [|'literal']
		  new testdata.ClosureClient().invoke0(Closure)	}".resolvesClosuresTo("()=>String").withEquivalents("Function0<String>")
	}
	
	@Test
	def void testClosure_02() throws Exception {
		("{\n" + 
		"  var java.util.List<? super String> list = null;\n" + 
		"  list.map(e|e)\n" +
		"}").resolvesClosuresTo("(Object)=>Object").withEquivalents("Function1<Object, Object>")
	}

	@Test
	def void testClosure_03() throws Exception {
		("{\n" + 
		"  var java.util.List<? super String> list = null;\n" + 
		"  list.map(e|false)\n" +
		"}").resolvesClosuresTo("(Object)=>boolean").withEquivalents("Function1<Object, Boolean>")
	}

	@Test def void testClosure_04() throws Exception {
		"{ 
			val mapper = [ x | x ]
			newArrayList(1).map(mapper)
		}".resolvesClosuresTo("(Integer)=>Integer").withEquivalents("Function1<Integer, Integer>")
	}
	
	@Test def void testClosure_05() throws Exception {
		"{ 
			val mapper = [ x | x ]
			newArrayList(1).map(mapper).head
		}".resolvesClosuresTo("(Integer)=>Integer").withEquivalents("Function1<Integer, Integer>")
	}
	
	@Test def void testClosure_06() throws Exception {
		"{ 
			val mapper = [ x | x ]
			newArrayList(1).map(mapper).findFirst [ true ]
		}".resolvesClosuresTo("(Integer)=>Integer", "(Integer)=>boolean")
		  .withEquivalents("Function1<Integer, Integer>", "Function1<Integer, Boolean>")
	}
	
	@Ignore("TODO deferred Closure body typing")
	@Test def void testClosure_07() throws Exception {
		"{ 
			val mapper = [ x | x.charAt(0) ]
			newArrayList('').map(mapper)
		}".resolvesClosuresTo("Function1<String, Character>").withEquivalents("Function1<String, Character>")
	}
	
	@Test def void testClosure_08() throws Exception {
		"{ 
			val fun = [ x | x ]
			val String s = fun.apply(null)
			fun
		}".resolvesClosuresTo("(String)=>String").withEquivalents("Function1<String, String>")
	}
	
	@Test def void testClosure_09() throws Exception {
		"{ 
			val fun = [ x | x ]
			val java.util.List<String> list = newArrayList(fun.apply(null))
			fun
		}".resolvesClosuresTo("(String[])=>String[]").withEquivalents("Function1<String[], String[]>")
	}
	
	@Test def void testClosure_09_2() throws Exception {
		"{ 
			val fun = [ x | x ]
			val java.util.List<String> list = newArrayList(fun.apply(null), fun.apply(null))
			fun
		}".resolvesClosuresTo("(String)=>String").withEquivalents("Function1<String, String>")
	}
	
	@Test def void testClosure_10() throws Exception {
		"{ 
			val fun = [ x | x ]
			val java.util.List<String> list = newArrayList.map(fun)
			fun
		}".resolvesClosuresTo("(String)=>String").withEquivalents("Function1<String, String>")
	}
	
	@Test def void testClosure_11() throws Exception {
		"{ 
			val fun = [ x | x ]
			val java.util.Set<String> list = newArrayList.map(fun)
			fun
		}".resolvesClosuresTo("(String)=>String").withEquivalents("Function1<String, String>")
	}
	
	@Test def void testClosure_12() throws Exception {
		"{ 
			val fun = [ x | x ]
			val java.util.ArrayList<String> list = newArrayList.map(fun)
			fun
		}".resolvesClosuresTo("(String)=>String").withEquivalents("Function1<String, String>")
	}
	
	@Test def void testClosure_13() throws Exception {
		"{ 
			val fun = [ x | x ]
			val Iterable<String> list = newArrayList.map(fun)
			fun
		}".resolvesClosuresTo("(String)=>String").withEquivalents("Function1<String, String>")
	}
	
	@Test def void testClosure_14() throws Exception {
		"{ 
			val fun = [ x | x ]
			val list = newArrayList.map(fun)
			val Iterable<String> iter = list
			fun
		}".resolvesClosuresTo("(String)=>String").withEquivalents("Function1<String, String>")
	}
	
	@Test def void testClosure_15() throws Exception {
		"{ 
			val fun = [ x | x ]
			val java.util.List<String> list = $$ListExtensions::map(newArrayList, fun)
			fun
		}".resolvesClosuresTo("(String)=>String").withEquivalents("Function1<String, String>")
	}
	
	@Test def void testClosure_16() throws Exception {
		"{ 
			val fun = [ x | x ]
			val java.util.Set<String> list = $$ListExtensions::map(newArrayList, fun)
			fun
		}".resolvesClosuresTo("(String)=>String").withEquivalents("Function1<String, String>")
	}
	
	@Test def void testClosure_17() throws Exception {
		"{ 
			val fun = [ x | x ]
			val java.util.ArrayList<String> list = $$ListExtensions::map(newArrayList, fun)
			fun
		}".resolvesClosuresTo("(String)=>String").withEquivalents("Function1<String, String>")
	}
	
	@Test def void testClosure_18() throws Exception {
		"{ 
			val fun = [ x | x ]
			val Iterable<String> list = $$ListExtensions::map(newArrayList, fun)
			fun
		}".resolvesClosuresTo("(String)=>String").withEquivalents("Function1<String, String>")
	}
	
	@Test def void testClosure_19() throws Exception {
		"{ 
			val fun = [ x | x ]
			val list = $$ListExtensions::map(newArrayList, fun)
			val Iterable<String> iter = list
			fun
		}".resolvesClosuresTo("(String)=>String").withEquivalents("Function1<String, String>")
	}
	
	@Test def void testClosure_20() throws Exception {
		"{ 
			val mapper = [ x | x ]
			$$ListExtensions::map(newArrayList(1), mapper)
		}".resolvesClosuresTo("(Integer)=>Integer").withEquivalents("Function1<Integer, Integer>")
	}
	
	@Test def void testClosure_21() throws Exception {
		"[|].apply()".resolvesClosuresTo("()=>Object").withEquivalents("Function0<Object>")
	}
	
	@Test def void testClosure_22() throws Exception {
		"[].apply()".resolvesClosuresTo("(Object)=>Object").withEquivalents("Function1<Object, Object>")
	}
	
	@Test def void testClosure_23() throws Exception {
		"$$ListExtensions::map(null as java.util.List<? super String>) [e|e]"
			.resolvesClosuresTo("(Object)=>Object")
			.withEquivalents("Function1<Object, Object>")
	}
	
	@Test def void testClosure_24() throws Exception {
		("{\n" + 
		"  var java.util.List<? super String> list = null;\n" + 
		"  $$ListExtensions::map(list) [e|e]\n" +
		"}").resolvesClosuresTo("(Object)=>Object").withEquivalents("Function1<Object, Object>")
	}
	
	@Test def void testClosure_25() throws Exception {
		"[|'literal']".resolvesClosuresTo("()=>String").withEquivalents("Function0<String>")
	}
	
	@Test def void testClosure_26() throws Exception {
		"{
			val list = newArrayList('')
			java::util::Collections::sort(list) [ s1, s2 | s1.compareTo(s2) ]
			list
		}".resolvesClosuresTo("(String, String)=>int").withEquivalents("Comparator<String>")
	}
	
	@Test def void testClosure_27() throws Exception {
		'(null as Iterable<? super String>).map(e|e)'.resolvesClosuresTo("(Object)=>Object").withEquivalents("Function1<Object, Object>")
	}
	
	@Test def void testClosure_28() throws Exception {
		"[| return 'literal'].apply()".resolvesClosuresTo("()=>String").withEquivalents("Function0<String>")
	}
	
	@Test def void testClosure_29() throws Exception {
		"{ var Closure = [| return 'literal']
		  new testdata.ClosureClient().invoke0(Closure)	}".resolvesClosuresTo("()=>String").withEquivalents("Function0<String>")
	}
	
	@Test
	def void testClosure_30() throws Exception {
		("{\n" + 
		"  var java.util.List<? super String> list = null;\n" + 
		"  list.map(e| return e)\n" +
		"}").resolvesClosuresTo("(Object)=>Object").withEquivalents("Function1<Object, Object>")
	}

	@Test
	def void testClosure_31() throws Exception {
		("{\n" + 
		"  var java.util.List<? super String> list = null;\n" + 
		"  list.map(e| return false)\n" +
		"}").resolvesClosuresTo("(Object)=>boolean").withEquivalents("Function1<Object, Boolean>")
	}

	@Test def void testClosure_32() throws Exception {
		"{ 
			val mapper = [ x | return x ]
			newArrayList(1).map(mapper)
		}".resolvesClosuresTo("(Integer)=>Integer").withEquivalents("Function1<Integer, Integer>")
	}
	
	@Test def void testClosure_33() throws Exception {
		"{ 
			val mapper = [ x | return x ]
			newArrayList(1).map(mapper).head
		}".resolvesClosuresTo("(Integer)=>Integer").withEquivalents("Function1<Integer, Integer>")
	}
	
	@Test def void testClosure_34() throws Exception {
		"{ 
			val mapper = [ x | return x ]
			newArrayList(1).map(mapper).findFirst [ true ]
		}".resolvesClosuresTo("(Integer)=>Integer", "(Integer)=>boolean")
		  .withEquivalents("Function1<Integer, Integer>", "Function1<Integer, Boolean>")
	}
	
	@Ignore("TODO deferred Closure body typing")
	@Test def void testClosure_35() throws Exception {
		"{ 
			val mapper = [ x | return x.charAt(0) ]
			newArrayList('').map(mapper)
		}".resolvesClosuresTo("Function1<String, Character>").withEquivalents("Function1<String, Character>")
	}
	
	@Test def void testClosure_36() throws Exception {
		"{ 
			val fun = [ x | return x ]
			val String s = fun.apply(null)
			fun
		}".resolvesClosuresTo("(String)=>String").withEquivalents("Function1<String, String>")
	}
	
	@Test def void testClosure_37() throws Exception {
		"{ 
			val fun = [ x | return x ]
			val java.util.List<String> list = newArrayList(fun.apply(null))
			fun
		}".resolvesClosuresTo("(String[])=>String[]").withEquivalents("Function1<String[], String[]>")
	}
	
	@Test def void testClosure_37_02() throws Exception {
		"{ 
			val fun = [ x | return x ]
			val java.util.List<String> list = newArrayList(fun.apply(null), fun.apply(null))
			fun
		}".resolvesClosuresTo("(String)=>String").withEquivalents("Function1<String, String>")
	}
	
	@Test def void testClosure_38() throws Exception {
		"{ 
			val fun = [ x | return x ]
			val java.util.List<String> list = newArrayList.map(fun)
			fun
		}".resolvesClosuresTo("(String)=>String").withEquivalents("Function1<String, String>")
	}
	
	@Test def void testClosure_39() throws Exception {
		"{ 
			val fun = [ x | return x ]
			val java.util.Set<String> list = newArrayList.map(fun)
			fun
		}".resolvesClosuresTo("(String)=>String").withEquivalents("Function1<String, String>")
	}
	
	@Test def void testClosure_40() throws Exception {
		"{ 
			val fun = [ x | return x ]
			val java.util.ArrayList<String> list = newArrayList.map(fun)
			fun
		}".resolvesClosuresTo("(String)=>String").withEquivalents("Function1<String, String>")
	}
	
	@Test def void testClosure_41() throws Exception {
		"{ 
			val fun = [ x | return x ]
			val Iterable<String> list = newArrayList.map(fun)
			fun
		}".resolvesClosuresTo("(String)=>String").withEquivalents("Function1<String, String>")
	}
	
	@Test def void testClosure_42() throws Exception {
		"{ 
			val fun = [ x | return x ]
			val list = newArrayList.map(fun)
			val Iterable<String> iter = list
			fun
		}".resolvesClosuresTo("(String)=>String").withEquivalents("Function1<String, String>")
	}
	
	@Test def void testClosure_43() throws Exception {
		"{ 
			val fun = [ x | return x ]
			val java.util.List<String> list = $$ListExtensions::map(newArrayList, fun)
			fun
		}".resolvesClosuresTo("(String)=>String").withEquivalents("Function1<String, String>")
	}
	
	@Test def void testClosure_44() throws Exception {
		"{ 
			val fun = [ x | return x ]
			val java.util.Set<String> list = $$ListExtensions::map(newArrayList, fun)
			fun
		}".resolvesClosuresTo("(String)=>String").withEquivalents("Function1<String, String>")
	}
	
	@Test def void testClosure_45() throws Exception {
		"{ 
			val fun = [ x | return x ]
			val java.util.ArrayList<String> list = $$ListExtensions::map(newArrayList, fun)
			fun
		}".resolvesClosuresTo("(String)=>String").withEquivalents("Function1<String, String>")
	}
	
	@Test def void testClosure_46() throws Exception {
		"{ 
			val fun = [ x | return x ]
			val Iterable<String> list = $$ListExtensions::map(newArrayList, fun)
			fun
		}".resolvesClosuresTo("(String)=>String").withEquivalents("Function1<String, String>")
	}
	
	@Test def void testClosure_47() throws Exception {
		"{ 
			val fun = [ x | return x ]
			val list = $$ListExtensions::map(newArrayList, fun)
			val Iterable<String> iter = list
			fun
		}".resolvesClosuresTo("(String)=>String").withEquivalents("Function1<String, String>")
	}
	
	@Test def void testClosure_48() throws Exception {
		"{ 
			val mapper = [ x | return x ]
			$$ListExtensions::map(newArrayList(1), mapper)
		}".resolvesClosuresTo("(Integer)=>Integer").withEquivalents("Function1<Integer, Integer>")
	}
	
	@Test def void testClosure_49() throws Exception {
		"[| return null].apply()".resolvesClosuresTo("()=>Object").withEquivalents("Function0<Object>")
	}
	
	@Test def void testClosure_50() throws Exception {
		"[return null].apply()".resolvesClosuresTo("(Object)=>Object").withEquivalents("Function1<Object, Object>")
	}
	
	@Test def void testClosure_51() throws Exception {
		"[| return ].apply()".resolvesClosuresTo("()=>void").withEquivalents("Procedure0")
	}
	
	@Test def void testClosure_52() throws Exception {
		"[return].apply()".resolvesClosuresTo("(Object)=>void").withEquivalents("Procedure1<Object>")
	}
	
	@Test def void testClosure_54() throws Exception {
		"$$ListExtensions::map(null as java.util.List<? super String>) [e| return e]"
			.resolvesClosuresTo("(Object)=>Object")
			.withEquivalents("Function1<Object, Object>")
	}
	
	@Test def void testClosure_55() throws Exception {
		("{\n" + 
		"  var java.util.List<? super String> list = null;\n" + 
		"  $$ListExtensions::map(list) [e| return e]\n" +
		"}").resolvesClosuresTo("(Object)=>Object").withEquivalents("Function1<Object, Object>")
	}
	
	@Test def void testClosure_56() throws Exception {
		"[| return 'literal']".resolvesClosuresTo("()=>String").withEquivalents("Function0<String>")
	}
	
	@Test def void testClosure_57() throws Exception {
		"{
			val list = newArrayList('')
			java::util::Collections::sort(list) [ s1, s2 | return s1.compareTo(s2) ]
			list
		}".resolvesClosuresTo("(String, String)=>int").withEquivalents("Comparator<String>")
	}
	
	@Test def void testClosure_58() throws Exception {
		'(null as Iterable<? super String>).map(e| return e)'.resolvesClosuresTo("(Object)=>Object").withEquivalents("Function1<Object, Object>")
	}
	
	@Test def void testClosure_59() throws Exception {
		'{ 
			val java.util.List<CharSequence> res = null
			val Iterable<? extends Object> obj = null
			res += obj.map[""]
		}'.resolvesClosuresTo("(Object)=>String").withEquivalents("Function1<Object, String>")
	}
	
	@Test def void testClosure_60() throws Exception {
		'{ 
			val Iterable<? extends Object> obj = null
			val Iterable<CharSequence> res = obj.map[""]
		}'.resolvesClosuresTo("(Object)=>String").withEquivalents("Function1<Object, CharSequence>")
	}
	
	@Test def void testClosure_61() throws Exception {
		'{ 
			val java.util.List<? super CharSequence> res = null
			val Iterable<? extends Object> obj = null
			res += obj.map[""]
		}'.resolvesClosuresTo("(Object)=>String").withEquivalents("Function1<Object, String>")
	}
	
	@Test def void testEMap_01() throws Exception {
		"{ 
          val eMap = new org.eclipse.emf.common.util.BasicEMap<Integer, String>()
		  eMap.map[ getKey ].head
         }".resolvesClosuresTo("(Entry<Integer, String>)=>Integer").withEquivalents("Function1<Entry<Integer, String>, Integer>")
	}
	
	@Test def void testEMap_02() throws Exception {
		"{ 
          val eMap = new org.eclipse.emf.common.util.BasicEMap<Integer, String>()
		  eMap.map[ getValue ].head
         }".resolvesClosuresTo("(Entry<Integer, String>)=>String").withEquivalents("Function1<Entry<Integer, String>, String>")
	}
	
	@Test def void testEMap_03() throws Exception {
		"{ 
          val eMap = new org.eclipse.emf.common.util.BasicEMap<Integer, String>()
		  eMap.map[ it ].head
         }".resolvesClosuresTo("(Entry<Integer, String>)=>Entry<Integer, String>").withEquivalents("Function1<Entry<Integer, String>, Entry<Integer, String>>")
	}
	
	@Test def void testEMap_04() throws Exception {
		"{ 
          val org.eclipse.emf.common.util.BasicEMap<? extends Integer, String> eMap = null
		  eMap.map[ getKey ].head
         }".resolvesClosuresTo("(Entry<? extends Integer, String>)=>Integer").withEquivalents("Function1<Entry<? extends Integer, String>, Integer>")
	}
	
	@Test def void testEMap_05() throws Exception {
		"{ 
          val org.eclipse.emf.common.util.BasicEMap<? extends Integer, String> eMap = null
		  eMap.map[ getValue ].head
         }".resolvesClosuresTo("(Entry<? extends Integer, String>)=>String").withEquivalents("Function1<Entry<? extends Integer, String>, String>")
	}
	
	@Test def void testEMap_06() throws Exception {
		"{ 
          val org.eclipse.emf.common.util.BasicEMap<? extends Integer, String> eMap = null
		  eMap.map[ it ].head
         }".resolvesClosuresTo("(Entry<? extends Integer, String>)=>Entry<? extends Integer, String>").withEquivalents("Function1<Entry<? extends Integer, String>, Entry<? extends Integer, String>>")
	}
	
	@Test def void testEMap_07() throws Exception {
		"{ 
          val org.eclipse.emf.common.util.BasicEMap<Integer, ? extends String> eMap = null
		  eMap.map[ getKey ].head
         }".resolvesClosuresTo("(Entry<Integer, ? extends String>)=>Integer").withEquivalents("Function1<Entry<Integer, ? extends String>, Integer>")
	}
	
	@Test def void testEMap_08() throws Exception {
		"{ 
          val org.eclipse.emf.common.util.BasicEMap<Integer, ? extends String> eMap = null
		  eMap.map[ getValue ].head
         }".resolvesClosuresTo("(Entry<Integer, ? extends String>)=>String").withEquivalents("Function1<Entry<Integer, ? extends String>, String>")
	}
	
	@Test def void testEMap_09() throws Exception {
		"{ 
          val org.eclipse.emf.common.util.BasicEMap<Integer, ? extends String> eMap = null
		  eMap.map[ it ].head
         }".resolvesClosuresTo("(Entry<Integer, ? extends String>)=>Entry<Integer, ? extends String>").withEquivalents("Function1<Entry<Integer, ? extends String>, Entry<Integer, ? extends String>>")
	}
	
	@Test def void testEMap_10() throws Exception {
		"{ 
          val eMap = new org.eclipse.emf.common.util.BasicEMap<Integer, String>()
		  eMap.map[ return getKey ].head
         }".resolvesClosuresTo("(Entry<Integer, String>)=>Integer").withEquivalents("Function1<Entry<Integer, String>, Integer>")
	}
	
	@Test def void testEMap_11() throws Exception {
		"{ 
          val eMap = new org.eclipse.emf.common.util.BasicEMap<Integer, String>()
		  eMap.map[ return getValue ].head
         }".resolvesClosuresTo("(Entry<Integer, String>)=>String").withEquivalents("Function1<Entry<Integer, String>, String>")
	}
	
	@Test def void testEMap_12() throws Exception {
		"{ 
          val eMap = new org.eclipse.emf.common.util.BasicEMap<Integer, String>()
		  eMap.map[ return it ].head
         }".resolvesClosuresTo("(Entry<Integer, String>)=>Entry<Integer, String>").withEquivalents("Function1<Entry<Integer, String>, Entry<Integer, String>>")
	}
	
	@Test def void testEMap_13() throws Exception {
		"{ 
          val org.eclipse.emf.common.util.BasicEMap<? extends Integer, String> eMap = null
		  eMap.map[ return getKey ].head
         }".resolvesClosuresTo("(Entry<? extends Integer, String>)=>Integer").withEquivalents("Function1<Entry<? extends Integer, String>, Integer>")
	}
	
	@Test def void testEMap_14() throws Exception {
		"{ 
          val org.eclipse.emf.common.util.BasicEMap<? extends Integer, String> eMap = null
		  eMap.map[ return getValue ].head
         }".resolvesClosuresTo("(Entry<? extends Integer, String>)=>String").withEquivalents("Function1<Entry<? extends Integer, String>, String>")
	}
	
	@Test def void testEMap_15() throws Exception {
		"{ 
          val org.eclipse.emf.common.util.BasicEMap<? extends Integer, String> eMap = null
		  eMap.map[ return it ].head
         }".resolvesClosuresTo("(Entry<? extends Integer, String>)=>Entry<? extends Integer, String>").withEquivalents("Function1<Entry<? extends Integer, String>, Entry<? extends Integer, String>>")
	}
	
	@Test def void testEMap_16() throws Exception {
		"{ 
          val org.eclipse.emf.common.util.BasicEMap<Integer, ? extends String> eMap = null
		  eMap.map[ return getKey ].head
         }".resolvesClosuresTo("(Entry<Integer, ? extends String>)=>Integer").withEquivalents("Function1<Entry<Integer, ? extends String>, Integer>")
	}
	
	@Test def void testEMap_17() throws Exception {
		"{ 
          val org.eclipse.emf.common.util.BasicEMap<Integer, ? extends String> eMap = null
		  eMap.map[ return getValue ].head
         }".resolvesClosuresTo("(Entry<Integer, ? extends String>)=>String").withEquivalents("Function1<Entry<Integer, ? extends String>, String>")
	}
	
	@Test def void testEMap_18() throws Exception {
		"{ 
          val org.eclipse.emf.common.util.BasicEMap<Integer, ? extends String> eMap = null
		  eMap.map[ return it ].head
         }".resolvesClosuresTo("(Entry<Integer, ? extends String>)=>Entry<Integer, ? extends String>").withEquivalents("Function1<Entry<Integer, ? extends String>, Entry<Integer, ? extends String>>")
	}
	
	@Test def void testIncompatibleExpression_01() throws Exception {
		"new Thread [| return 'illegal' ]".resolvesClosuresTo("()=>void").withEquivalents("Runnable")
	}
	
	@Ignore("TODO implement this") // the lambda should have the right type but the 'it' should violate the return type contract
	@Test def void testIncompatibleExpression_02() throws Exception {
		"(null as Iterable<String>).filter [ it ]".resolvesClosuresTo("(String)=>Boolean").withEquivalents("Function1<String, Boolean>")
	}
	
	@Test def void testMemberFeatureCall_01() throws Exception {
		"(1..20).map[ toString.length ].reduce[ i1,  i2 | i1 + i2 ]"
			.resolvesClosuresTo("(Integer)=>int", "(Integer, Integer)=>int")
			.withEquivalents("Function1<Integer, Integer>", "Function2<Integer, Integer, Integer>")
	}
	
	@Test def void testMemberFeatureCall_02() throws Exception {
		"(1..20).map[ return toString.length ].reduce[ i1,  i2 | return i1 + i2 ]"
			.resolvesClosuresTo("(Integer)=>int", "(Integer, Integer)=>int")
			.withEquivalents("Function1<Integer, Integer>", "Function2<Integer, Integer, Integer>")
	}
	
	@Test def void testFeatureCall_001() throws Exception {
		"newArrayList('').map(s|s)"
			.resolvesClosuresTo("(String)=>String")
			.withEquivalents("Function1<String, String>")
	}
	
	@Test def void testFeatureCall_002() throws Exception {
		"newArrayList('').map [it|it]"
			.resolvesClosuresTo("(String)=>String")
			.withEquivalents("Function1<String, String>")
	}
	
	@Test def void testFeatureCall_003() throws Exception {
		"newArrayList('').map [it]"
			.resolvesClosuresTo("(String)=>String")
			.withEquivalents("Function1<String, String>")
	}
	
	@Test def void testFeatureCall_004() throws Exception {
		"(null as Iterable<String>).map(s|s)"
			.resolvesClosuresTo("(String)=>String")
			.withEquivalents("Function1<String, String>")
	}
	
	@Test def void testFeatureCall_005() throws Exception {
		"$$ListExtensions::map(newArrayList('')) [s|s]"
			.resolvesClosuresTo("(String)=>String")
			.withEquivalents("Function1<String, String>")
	}
	
	@Test def void testFeatureCall_006() throws Exception {
		"newArrayList('').map(s|s).head"
			.resolvesClosuresTo("(String)=>String")
			.withEquivalents("Function1<String, String>")
	}
	
	@Test def void testFeatureCall_007() throws Exception {
		"newArrayList('').map(s|s.toString).head"
			.resolvesClosuresTo("(String)=>String")
			.withEquivalents("Function1<String, String>")
	}
	
	@Test def void testFeatureCall_008() throws Exception {
		"newArrayList('').map(s|1)"
			.resolvesClosuresTo("(String)=>int")
			.withEquivalents("Function1<String, Integer>")
	}
	
	@Test def void testFeatureCall_009() throws Exception {
		"newArrayList('').map(s|1).head"
			.resolvesClosuresTo("(String)=>int")
			.withEquivalents("Function1<String, Integer>")
	}
	
	@Test def void testFeatureCall_010() throws Exception {
		"newArrayList('').map(s|s.length)"
			.resolvesClosuresTo("(String)=>int")
			.withEquivalents("Function1<String, Integer>")
	}
	
	@Test def void testFeatureCall_011() throws Exception {
		"<String>newArrayList.map(s|s.length)"
			.resolvesClosuresTo("(String)=>int")
			.withEquivalents("Function1<String, Integer>")
	}
	
	@Test def void testFeatureCall_012() throws Exception {
		"newArrayList('').map(s|s.length).head"
			.resolvesClosuresTo("(String)=>int")
			.withEquivalents("Function1<String, Integer>")
	}
	
	@Test def void testFeatureCall_013() throws Exception {
		"<String>newArrayList.map(s|s.length).head"
			.resolvesClosuresTo("(String)=>int")
			.withEquivalents("Function1<String, Integer>")
	}
	
	@Test def void testFeatureCall_014() throws Exception {
		"newArrayList('').map(s|s != null)"
			.resolvesClosuresTo("(String)=>boolean")
			.withEquivalents("Function1<String, Boolean>")
	}
	
	@Test def void testFeatureCall_015() throws Exception {
		"newArrayList('').map(s|s.length+1)"
			.resolvesClosuresTo("(String)=>int")
			.withEquivalents("Function1<String, Integer>")
	}
	
	@Test def void testFeatureCall_016() throws Exception {
		"newArrayList('').map(s|1).map(i|i+1)"
			.resolvesClosuresTo("(String)=>int", "(Integer)=>int")
			.withEquivalents("Function1<String, Integer>", "Function1<Integer, Integer>")
	}
	
	@Test def void testFeatureCall_017() throws Exception {
		"newArrayList('').map(s|1).toList()"
			.resolvesClosuresTo("(String)=>int")
			.withEquivalents("Function1<String, Integer>")
	}
	
	@Test def void testFeatureCall_018() throws Exception {
		"newArrayList('').map(s|1).toList().map(i|i)"
			.resolvesClosuresTo("(String)=>int", "(Integer)=>Integer")
			.withEquivalents("Function1<String, Integer>", "Function1<Integer, Integer>")
	}
	
	@Test def void testFeatureCall_019() throws Exception {
		"newArrayList('').map(s|1).toList().map(i|i+1)"
			.resolvesClosuresTo("(String)=>int", "(Integer)=>int")
			.withEquivalents("Function1<String, Integer>", "Function1<Integer, Integer>")
	}
	
	@Test def void testFeatureCall_020() throws Exception {
		"{ var it = newArrayList('').map(s|1).toList() it.map(i|i+1) }"
			.resolvesClosuresTo("(String)=>int", "(Integer)=>int")
			.withEquivalents("Function1<String, Integer>", "Function1<Integer, Integer>")
	}
	
	@Test def void testFeatureCall_021() throws Exception {
		"{ var it = newArrayList('').map(s|1).toList() map(i|i+1) }"
			.resolvesClosuresTo("(String)=>int", "(Integer)=>int")
			.withEquivalents("Function1<String, Integer>", "Function1<Integer, Integer>")
	}
	
	@Test def void testFeatureCall_022() throws Exception {
		"{ var it = newArrayList('').map(s|1).toList() it }"
			.resolvesClosuresTo("(String)=>int")
			.withEquivalents("Function1<String, Integer>")
	}
	
	@Test def void testFeatureCall_023() throws Exception {
		"{ var java.util.List<? extends Integer> it = null map(i|i+1) }"
			.resolvesClosuresTo("(Integer)=>int")
			.withEquivalents("Function1<Integer, Integer>")
	}
	
	@Test def void testFeatureCall_024() throws Exception {
		"{ var java.util.List<? extends Integer> it = null map(i|i) }"
			.resolvesClosuresTo("(Integer)=>Integer")
			.withEquivalents("Function1<Integer, Integer>")
	}
	
	@Test def void testFeatureCall_025() throws Exception {
		"newArrayList(newArrayList('').map(s|1))"
			.resolvesClosuresTo("(String)=>int")
			.withEquivalents("Function1<String, Integer>")
	}
	
	@Test def void testFeatureCall_026() throws Exception {
		"newArrayList(newArrayList('').map(s|1)).map(iterable|iterable.size())"
			.resolvesClosuresTo("(String)=>int", "(List<Integer>)=>int")
			.withEquivalents("Function1<String, Integer>", "Function1<List<Integer>, Integer>")
	}
	
	@Test def void testFeatureCall_027() throws Exception {
		"newArrayList(newArrayList('').map(s|1)).map(iterable|iterable.size()).map(e|e)"
			.resolvesClosuresTo("(String)=>int", "(List<Integer>)=>int", "(Integer)=>Integer")
			.withEquivalents("Function1<String, Integer>", "Function1<List<Integer>, Integer>", "Function1<Integer, Integer>")
	}
	
	@Test def void testFeatureCall_028() throws Exception {
		"newArrayList(newArrayList('').map(s|1).map(e|e)).map(iterable|iterable.size())"
			.resolvesClosuresTo("(String)=>int", "(Integer)=>Integer", "(List<Integer>)=>int")
			.withEquivalents("Function1<String, Integer>", "Function1<Integer, Integer>", "Function1<List<Integer>, Integer>")
	}
	
	@Test def void testFeatureCall_029() throws Exception {
		"newArrayList(newArrayList('').map(s|1).map(e|e)).map(iterable|iterable.size()).head"
			.resolvesClosuresTo("(String)=>int", "(Integer)=>Integer", "(List<Integer>)=>int")
			.withEquivalents("Function1<String, Integer>", "Function1<Integer, Integer>", "Function1<List<Integer>, Integer>")
	}
	
	@Test def void testFeatureCall_030() throws Exception {
		"newArrayList(newArrayList('')).map(iterable|iterable.size())"
			.resolvesClosuresTo("(ArrayList<String>)=>int")
			.withEquivalents("Function1<ArrayList<String>, Integer>")
	}
	
	@Test def void testFeatureCall_031() throws Exception {
		"newArrayList(newArrayList('')).map(iterable|iterable.size()).head"
			.resolvesClosuresTo("(ArrayList<String>)=>int")
			.withEquivalents("Function1<ArrayList<String>, Integer>")
	}
	
	@Test def void testFeatureCall_032() throws Exception {
		"newArrayList(newArrayList('')).map(iterable|iterable.size()).map(e|e)"
			.resolvesClosuresTo("(ArrayList<String>)=>int", "(Integer)=>Integer")
			.withEquivalents("Function1<ArrayList<String>, Integer>", "Function1<Integer, Integer>")
	}
	
	@Test def void testFeatureCall_033() throws Exception {
		"newArrayList(newArrayList('')).map(iterable|iterable.size()).map(e|e).head"
			.resolvesClosuresTo("(ArrayList<String>)=>int", "(Integer)=>Integer")
			.withEquivalents("Function1<ArrayList<String>, Integer>", "Function1<Integer, Integer>")
	}
	
	@Test def void testFeatureCall_034() throws Exception {
		"newArrayList('').map(s|1).map(i|1)"
			.resolvesClosuresTo("(String)=>int", "(Integer)=>int")
			.withEquivalents("Function1<String, Integer>", "Function1<Integer, Integer>")
	}
	
	@Test def void testFeatureCall_035() throws Exception {
		"newArrayList('').map(s|1).map(i|1).head"
			.resolvesClosuresTo("(String)=>int", "(Integer)=>int")
			.withEquivalents("Function1<String, Integer>", "Function1<Integer, Integer>")
	}
	
	@Test def void testFeatureCall_036() throws Exception {
		"newArrayList('').map(s|s.length).map(i|i)"
			.resolvesClosuresTo("(String)=>int", "(Integer)=>Integer")
			.withEquivalents("Function1<String, Integer>", "Function1<Integer, Integer>")
	}
	
	@Test def void testFeatureCall_037() throws Exception {
		"newArrayList('').map(s|s.length).map(i|i).head"
			.resolvesClosuresTo("(String)=>int", "(Integer)=>Integer")
			.withEquivalents("Function1<String, Integer>", "Function1<Integer, Integer>")
	}
	
	@Test def void testFeatureCall_038() throws Exception {
		"newArrayList('').map(s|s.length + 1 == 5).map(b|b)"
			.resolvesClosuresTo("(String)=>boolean", "(Boolean)=>Boolean")
			.withEquivalents("Function1<String, Boolean>", "Function1<Boolean, Boolean>")
	}
	
	@Test def void testFeatureCall_039() throws Exception {
		"newArrayList('').map(s|s.length + 1 == 5).map(b|b).head"
			.resolvesClosuresTo("(String)=>boolean", "(Boolean)=>Boolean")
			.withEquivalents("Function1<String, Boolean>", "Function1<Boolean, Boolean>")
	}
	
	@Test def void testFeatureCall_040() throws Exception {
		"newArrayList('').map(s|s.length + 1 == 5).map(b| { 'length'.length b })"
			.resolvesClosuresTo("(String)=>boolean", "(Boolean)=>Boolean")
			.withEquivalents("Function1<String, Boolean>", "Function1<Boolean, Boolean>")
	}
	
	@Test def void testFeatureCall_041() throws Exception {
		"newArrayList('').map(s|s.length + 1 == 5).map(b| { 'length'.length b }).head"
			.resolvesClosuresTo("(String)=>boolean", "(Boolean)=>Boolean")
			.withEquivalents("Function1<String, Boolean>", "Function1<Boolean, Boolean>")
	}
	
	@Test def void testFeatureCall_042() throws Exception {
		"newArrayList('').map(s|s.length + 1 == 5).map(Boolean b|!b)"
			.resolvesClosuresTo("(String)=>boolean", "(Boolean)=>boolean")
			.withEquivalents("Function1<String, Boolean>", "Function1<Boolean, Boolean>")
	}
	
	@Test def void testFeatureCall_043() throws Exception {
		"newArrayList('').map(s|s.length + 1 == 5).map(Boolean b|!b).head"
			.resolvesClosuresTo("(String)=>boolean", "(Boolean)=>boolean")
			.withEquivalents("Function1<String, Boolean>", "Function1<Boolean, Boolean>")
	}
	
	@Test def void testFeatureCall_044() throws Exception {
		"newArrayList('').map(s|s.length + 1 == 5).map(b| !!b )"
			.resolvesClosuresTo("(String)=>boolean", "(Boolean)=>boolean")
			.withEquivalents("Function1<String, Boolean>", "Function1<Boolean, Boolean>")
	}
	
	@Test def void testFeatureCall_045() throws Exception {
		"newArrayList('').map(s|s.length + 1 == 5).map(b| !!b ).head"
			.resolvesClosuresTo("(String)=>boolean", "(Boolean)=>boolean")
			.withEquivalents("Function1<String, Boolean>", "Function1<Boolean, Boolean>")
	}
	
	@Test def void testFeatureCall_046() throws Exception {
		"newArrayList('').map(s|s.length + 1 == 5).map(b| { !b } )"
			.resolvesClosuresTo("(String)=>boolean", "(Boolean)=>boolean")
			.withEquivalents("Function1<String, Boolean>", "Function1<Boolean, Boolean>")
	}
	
	@Test def void testFeatureCall_047() throws Exception {
		"newArrayList('').map(s|s.length + 1 == 5).map(b| { !b } ).head"
			.resolvesClosuresTo("(String)=>boolean", "(Boolean)=>boolean")
			.withEquivalents("Function1<String, Boolean>", "Function1<Boolean, Boolean>")
	}
	
	@Test def void testFeatureCall_048() throws Exception {
		"newArrayList('').map(s|s.length + 1 == 5).map(b| { b.operator_not } )"
			.resolvesClosuresTo("(String)=>boolean", "(Boolean)=>boolean")
			.withEquivalents("Function1<String, Boolean>", "Function1<Boolean, Boolean>")
	}
	
	@Test def void testFeatureCall_049() throws Exception {
		"newArrayList('').map(s|s.length + 1 == 5).map(b| { b.operator_not } ).head"
			.resolvesClosuresTo("(String)=>boolean", "(Boolean)=>boolean")
			.withEquivalents("Function1<String, Boolean>", "Function1<Boolean, Boolean>")
	}

	@Test def void testFeatureCall_050() throws Exception {
		("newArrayList('').map(s|" +
		"$$ObjectExtensions::operator_equals(" +
		"	$$IntegerExtensions::operator_plus(s.length,1), 5)" +
		").map(b| $$BooleanExtensions::operator_not(b) )")
			.resolvesClosuresTo("(String)=>boolean", "(Boolean)=>boolean")
			.withEquivalents("Function1<String, Boolean>", "Function1<Boolean, Boolean>")
	}
	
	@Test def void testFeatureCall_051() throws Exception {
		("newArrayList('').map(s|" +
		"$$ObjectExtensions::operator_equals(" +
		"	$$IntegerExtensions::operator_plus(s.length,1), 5)" +
		").map(b| $$BooleanExtensions::operator_not(b) ).head")
			.resolvesClosuresTo("(String)=>boolean", "(Boolean)=>boolean")
			.withEquivalents("Function1<String, Boolean>", "Function1<Boolean, Boolean>")
	}
	
	@Test def void testFeatureCall_052() throws Exception {
		"newArrayList('').map(s|s.length + 1 * 5).map(b| b / 5 )"
			.resolvesClosuresTo("(String)=>int", "(Integer)=>int")
			.withEquivalents("Function1<String, Integer>", "Function1<Integer, Integer>")
	}
	@Test def void testFeatureCall_053() throws Exception {
		"newArrayList('').map(s|s.length + 1 * 5).map(b| b / 5 ).head"
			.resolvesClosuresTo("(String)=>int", "(Integer)=>int")
			.withEquivalents("Function1<String, Integer>", "Function1<Integer, Integer>")
	}
	
	@Test def void testFeatureCall_054() throws Exception {
		"newArrayList('').map[ length + 1 * 5 ].map [ it / 5 ).head"
			.resolvesClosuresTo("(String)=>int", "(Integer)=>int")
			.withEquivalents("Function1<String, Integer>", "Function1<Integer, Integer>")
	}
	
	@Test def void testFeatureCall_055() throws Exception {
		"newArrayList('').map[ length + 1 * 5 - length + 1 * 5 ].map [ it / 5 + 1 / it ).head"
			.resolvesClosuresTo("(String)=>int", "(Integer)=>int")
			.withEquivalents("Function1<String, Integer>", "Function1<Integer, Integer>")
	}
	
	@Test def void testFeatureCall_056() throws Exception {
		"{ val list = newArrayList(if (false) new Double('-20') else new Integer('20')).map(v|v.intValue)
           val Object o = list.head 
           list
        }".resolvesClosuresTo("(Number & Comparable<?>)=>int")
          .withEquivalents("Function1<Number & Comparable<?>, Integer>")
	}
	
	@Test def void testFeatureCall_057() throws Exception {
		"{ val list = newArrayList(if (false) new Double('-20') else new Integer('20')).map(v|v.intValue)
           val Object o = list.head 
           list.head
        }".resolvesClosuresTo("(Number & Comparable<?>)=>int")
          .withEquivalents("Function1<Number & Comparable<?>, Integer>")
	}
	
	@Test def void testFeatureCall_058() throws Exception {
		"{ val list = $$ListExtensions::map(newArrayList(if (false) new Double('-20') else new Integer('20'))) [ v|v.intValue ]
           val Object o = list.head 
           list
        }".resolvesClosuresTo("(Number & Comparable<?>)=>int")
          .withEquivalents("Function1<Number & Comparable<?>, Integer>")
	}
	
	@Test def void testFeatureCall_059() throws Exception {
		"{ val list = $$ListExtensions::map(newArrayList(null as Integer)) [ v|v.intValue ]
           val Object o = list.head 
           list
        }".resolvesClosuresTo("(Integer)=>int")
          .withEquivalents("Function1<Integer, Integer>")
	}

	@Test def void testFeatureCall_060() throws Exception {
		"{ val list = newArrayList(null as Integer).map [ v|v.intValue ]
           val Object o = list.head 
           list
        }".resolvesClosuresTo("(Integer)=>int")
          .withEquivalents("Function1<Integer, Integer>")
	}
	
	@Test def void testFeatureCall_061() throws Exception {
		"{ val list = newArrayList(null as Integer).map [ v|v.intValue ]
           val Object o = list.head 
           list.findFirst [ intValue == 0 ]
        }".resolvesClosuresTo("(Integer)=>int", "(Integer)=>boolean")
          .withEquivalents("Function1<Integer, Integer>", "Function1<Integer, Boolean>")
	}
	
	@Test def void testFeatureCall_062() throws Exception {
		"{
			val list = newArrayList
			list.forEach[String s | s]
			list
		}".resolvesClosuresTo("(String)=>void").withEquivalents("Consumer<String>")
	}
	
	@Test def void testFeatureCall_063() throws Exception {
		"{
			val list = newArrayList
			list.findFirst[String s | true]
			list
		}".resolvesClosuresTo("(String)=>boolean").withEquivalents("Function1<String, Boolean>")
	}
	
	@Test def void testFeatureCall_064() throws Exception {
		"newArrayList.map[String s | s.substring(1,1) ]"
			.resolvesClosuresTo("(String)=>String")
			.withEquivalents("Function1<String, String>")
	}

	@Test def void testFeatureCall_065() throws Exception {
		"newArrayList.map[ s | s.toString ]"
			.resolvesClosuresTo("(Object)=>String")
			.withEquivalents("Function1<Object, String>")
	}
	
	@Test def void testFeatureCall_066() throws Exception {
		"{
			val list = newArrayList
			list.forEach[ s | s.toString ]
			list
		}".resolvesClosuresTo("(Object)=>void").withEquivalents("Consumer<Object>")
	}
	
	@Test def void testFeatureCall_067() throws Exception {
		"{ val list = newArrayList(new Double('-20'), new Integer('20')).map(v|v.intValue)
           val Object o = list.head 
           list
        }".resolvesClosuresTo("(Number & Comparable<?>)=>int")
          .withEquivalents("Function1<Number & Comparable<?>, Integer>")
	}
	
	@Test def void testFeatureCall_068() throws Exception {
		"{ val list = newArrayList(new Double('-20'), new Integer('20')).map(v|v.intValue)
           val Object o = list.head 
           list.head
        }".resolvesClosuresTo("(Number & Comparable<?>)=>int")
          .withEquivalents("Function1<Number & Comparable<?>, Integer>")
	}
	
	@Test def void testFeatureCall_069() throws Exception {
		"{ val list = $$ListExtensions::map(newArrayList(new Double('-20'), new Integer('20'))) [ v|v.intValue ]
           val Object o = list.head 
           list
        }".resolvesClosuresTo("(Number & Comparable<?>)=>int")
          .withEquivalents("Function1<Number & Comparable<?>, Integer>")
	}
	
	@Test def void testFeatureCall_070() throws Exception {
		"{ val list = $$ListExtensions::map(newArrayList(new Double('-20'), new Integer('20'))) [ v| return v.intValue ]
           val Object o = list.head 
           list
        }".resolvesClosuresTo("(Number & Comparable<?>)=>int")
          .withEquivalents("Function1<Number & Comparable<?>, Integer>")
	}
	
	@Test def void testFeatureCall_071() throws Exception {
		"newArrayList('').map(s| return s)"
			.resolvesClosuresTo("(String)=>String")
			.withEquivalents("Function1<String, String>")
	}
	
	@Test def void testFeatureCall_072() throws Exception {
		"newArrayList('').map [it| return it]"
			.resolvesClosuresTo("(String)=>String")
			.withEquivalents("Function1<String, String>")
	}
	
	@Test def void testFeatureCall_073() throws Exception {
		"newArrayList('').map [return it]"
			.resolvesClosuresTo("(String)=>String")
			.withEquivalents("Function1<String, String>")
	}
	
	@Test def void testFeatureCall_074() throws Exception {
		"(null as Iterable<String>).map(s| return s)"
			.resolvesClosuresTo("(String)=>String")
			.withEquivalents("Function1<String, String>")
	}
	
	@Test def void testFeatureCall_075() throws Exception {
		"$$ListExtensions::map(newArrayList('')) [s| return s]"
			.resolvesClosuresTo("(String)=>String")
			.withEquivalents("Function1<String, String>")
	}
	
	@Test def void testFeatureCall_076() throws Exception {
		"newArrayList('').map(s| return s).head"
			.resolvesClosuresTo("(String)=>String")
			.withEquivalents("Function1<String, String>")
	}
	
	@Test def void testFeatureCall_077() throws Exception {
		"newArrayList('').map(s| return s.toString).head"
			.resolvesClosuresTo("(String)=>String")
			.withEquivalents("Function1<String, String>")
	}
	
	@Test def void testFeatureCall_078() throws Exception {
		"newArrayList('').map(s| return 1)"
			.resolvesClosuresTo("(String)=>int")
			.withEquivalents("Function1<String, Integer>")
	}
	
	@Test def void testFeatureCall_079() throws Exception {
		"newArrayList('').map(s| return 1).head"
			.resolvesClosuresTo("(String)=>int")
			.withEquivalents("Function1<String, Integer>")
	}
	
	@Test def void testFeatureCall_080() throws Exception {
		"newArrayList('').map(s| return s.length)"
			.resolvesClosuresTo("(String)=>int")
			.withEquivalents("Function1<String, Integer>")
	}
	
	@Test def void testFeatureCall_081() throws Exception {
		"<String>newArrayList.map(s| return s.length)"
			.resolvesClosuresTo("(String)=>int")
			.withEquivalents("Function1<String, Integer>")
	}
	
	@Test def void testFeatureCall_082() throws Exception {
		"newArrayList('').map(s| return s.length).head"
			.resolvesClosuresTo("(String)=>int")
			.withEquivalents("Function1<String, Integer>")
	}
	
	@Test def void testFeatureCall_083() throws Exception {
		"<String>newArrayList.map(s| return s.length).head"
			.resolvesClosuresTo("(String)=>int")
			.withEquivalents("Function1<String, Integer>")
	}
	
	@Test def void testFeatureCall_084() throws Exception {
		"newArrayList('').map(s| return s != null)"
			.resolvesClosuresTo("(String)=>boolean")
			.withEquivalents("Function1<String, Boolean>")
	}
	
	@Test def void testFeatureCall_085() throws Exception {
		"newArrayList('').map(s| return s.length+1)"
			.resolvesClosuresTo("(String)=>int")
			.withEquivalents("Function1<String, Integer>")
	}
	
	@Test def void testFeatureCall_086() throws Exception {
		"newArrayList('').map(s| return 1).map(i| return i+1)"
			.resolvesClosuresTo("(String)=>int", "(Integer)=>int")
			.withEquivalents("Function1<String, Integer>", "Function1<Integer, Integer>")
	}
	
	@Test def void testFeatureCall_087() throws Exception {
		"newArrayList('').map(s| return 1).toList()"
			.resolvesClosuresTo("(String)=>int")
			.withEquivalents("Function1<String, Integer>")
	}
	
	@Test def void testFeatureCall_088() throws Exception {
		"newArrayList('').map(s| return 1).toList().map(i| return i)"
			.resolvesClosuresTo("(String)=>int", "(Integer)=>Integer")
			.withEquivalents("Function1<String, Integer>", "Function1<Integer, Integer>")
	}
	
	@Test def void testFeatureCall_089() throws Exception {
		"newArrayList('').map(s| return 1).toList().map(i| return i+1)"
			.resolvesClosuresTo("(String)=>int", "(Integer)=>int")
			.withEquivalents("Function1<String, Integer>", "Function1<Integer, Integer>")
	}
	
	@Test def void testFeatureCall_090() throws Exception {
		"{ var it = newArrayList('').map(s| return 1).toList() it.map(i| return i+1) }"
			.resolvesClosuresTo("(String)=>int", "(Integer)=>int")
			.withEquivalents("Function1<String, Integer>", "Function1<Integer, Integer>")
	}
	
	@Test def void testFeatureCall_091() throws Exception {
		"{ var it = newArrayList('').map(s| return 1).toList() map(i| return i+1) }"
			.resolvesClosuresTo("(String)=>int", "(Integer)=>int")
			.withEquivalents("Function1<String, Integer>", "Function1<Integer, Integer>")
	}
	
	@Test def void testFeatureCall_092() throws Exception {
		"{ var it = newArrayList('').map(s| return 1).toList() it }"
			.resolvesClosuresTo("(String)=>int")
			.withEquivalents("Function1<String, Integer>")
	}
	
	@Test def void testFeatureCall_093() throws Exception {
		"{ var java.util.List<? extends Integer> it = null map(i| return i+1) }"
			.resolvesClosuresTo("(Integer)=>int")
			.withEquivalents("Function1<Integer, Integer>")
	}
	
	@Test def void testFeatureCall_094() throws Exception {
		"{ var java.util.List<? extends Integer> it = null map(i| return i) }"
			.resolvesClosuresTo("(Integer)=>Integer")
			.withEquivalents("Function1<Integer, Integer>")
	}
	
	@Test def void testFeatureCall_095() throws Exception {
		"newArrayList(newArrayList('').map(s| return 1))"
			.resolvesClosuresTo("(String)=>int")
			.withEquivalents("Function1<String, Integer>")
	}
	
	@Test def void testFeatureCall_096() throws Exception {
		"newArrayList(newArrayList('').map(s| return 1)).map(iterable| return iterable.size())"
			.resolvesClosuresTo("(String)=>int", "(List<Integer>)=>int")
			.withEquivalents("Function1<String, Integer>", "Function1<List<Integer>, Integer>")
	}
	
	@Test def void testFeatureCall_097() throws Exception {
		"newArrayList(newArrayList('').map(s| return 1)).map(iterable| return iterable.size()).map(e| return e)"
			.resolvesClosuresTo("(String)=>int", "(List<Integer>)=>int", "(Integer)=>Integer")
			.withEquivalents("Function1<String, Integer>", "Function1<List<Integer>, Integer>", "Function1<Integer, Integer>")
	}
	
	@Test def void testFeatureCall_098() throws Exception {
		"newArrayList(newArrayList('').map(s| return 1).map(e| return e)).map(iterable| return iterable.size())"
			.resolvesClosuresTo("(String)=>int", "(Integer)=>Integer", "(List<Integer>)=>int")
			.withEquivalents("Function1<String, Integer>", "Function1<Integer, Integer>", "Function1<List<Integer>, Integer>")
	}
	
	@Test def void testFeatureCall_099() throws Exception {
		"newArrayList(newArrayList('').map(s| return 1).map(e| return e)).map(iterable| return iterable.size()).head"
			.resolvesClosuresTo("(String)=>int", "(Integer)=>Integer", "(List<Integer>)=>int")
			.withEquivalents("Function1<String, Integer>", "Function1<Integer, Integer>", "Function1<List<Integer>, Integer>")
	}
	
	@Test def void testFeatureCall_100() throws Exception {
		"newArrayList(newArrayList('')).map(iterable| return iterable.size())"
			.resolvesClosuresTo("(ArrayList<String>)=>int")
			.withEquivalents("Function1<ArrayList<String>, Integer>")
	}
	
	@Test def void testFeatureCall_101() throws Exception {
		"newArrayList(newArrayList('')).map(iterable| return iterable.size()).head"
			.resolvesClosuresTo("(ArrayList<String>)=>int")
			.withEquivalents("Function1<ArrayList<String>, Integer>")
	}
	
	@Test def void testFeatureCall_102() throws Exception {
		"newArrayList(newArrayList('')).map(iterable| return iterable.size()).map(e| return e)"
			.resolvesClosuresTo("(ArrayList<String>)=>int", "(Integer)=>Integer")
			.withEquivalents("Function1<ArrayList<String>, Integer>", "Function1<Integer, Integer>")
	}
	
	@Test def void testFeatureCall_103() throws Exception {
		"newArrayList(newArrayList('')).map(iterable| return iterable.size()).map(e| return e).head"
			.resolvesClosuresTo("(ArrayList<String>)=>int", "(Integer)=>Integer")
			.withEquivalents("Function1<ArrayList<String>, Integer>", "Function1<Integer, Integer>")
	}
	
	@Test def void testFeatureCall_104() throws Exception {
		"newArrayList('').map(s| return 1).map(i| return 1)"
			.resolvesClosuresTo("(String)=>int", "(Integer)=>int")
			.withEquivalents("Function1<String, Integer>", "Function1<Integer, Integer>")
	}
	
	@Test def void testFeatureCall_105() throws Exception {
		"newArrayList('').map(s| return 1).map(i| return 1).head"
			.resolvesClosuresTo("(String)=>int", "(Integer)=>int")
			.withEquivalents("Function1<String, Integer>", "Function1<Integer, Integer>")
	}
	
	@Test def void testFeatureCall_106() throws Exception {
		"newArrayList('').map(s| return s.length).map(i| return i)"
			.resolvesClosuresTo("(String)=>int", "(Integer)=>Integer")
			.withEquivalents("Function1<String, Integer>", "Function1<Integer, Integer>")
	}
	
	@Test def void testFeatureCall_107() throws Exception {
		"newArrayList('').map(s| return s.length).map(i| return i).head"
			.resolvesClosuresTo("(String)=>int", "(Integer)=>Integer")
			.withEquivalents("Function1<String, Integer>", "Function1<Integer, Integer>")
	}
	
	@Test def void testFeatureCall_108() throws Exception {
		"newArrayList('').map(s| return s.length + 1 == 5).map(b| return b)"
			.resolvesClosuresTo("(String)=>boolean", "(Boolean)=>Boolean")
			.withEquivalents("Function1<String, Boolean>", "Function1<Boolean, Boolean>")
	}
	
	@Test def void testFeatureCall_109() throws Exception {
		"newArrayList('').map(s| return s.length + 1 == 5).map(b| return b).head"
			.resolvesClosuresTo("(String)=>boolean", "(Boolean)=>Boolean")
			.withEquivalents("Function1<String, Boolean>", "Function1<Boolean, Boolean>")
	}
	
	@Test def void testFeatureCall_110() throws Exception {
		"newArrayList('').map(s| return s.length + 1 == 5).map(b| return { 'length'.length b })"
			.resolvesClosuresTo("(String)=>boolean", "(Boolean)=>Boolean")
			.withEquivalents("Function1<String, Boolean>", "Function1<Boolean, Boolean>")
	}
	
	@Test def void testFeatureCall_111() throws Exception {
		"newArrayList('').map(s| return s.length + 1 == 5).map(b| return { 'length'.length b }).head"
			.resolvesClosuresTo("(String)=>boolean", "(Boolean)=>Boolean")
			.withEquivalents("Function1<String, Boolean>", "Function1<Boolean, Boolean>")
	}
	
	@Test def void testFeatureCall_112() throws Exception {
		"newArrayList('').map(s| return s.length + 1 == 5).map(Boolean b| return !b)"
			.resolvesClosuresTo("(String)=>boolean", "(Boolean)=>boolean")
			.withEquivalents("Function1<String, Boolean>", "Function1<Boolean, Boolean>")
	}
	
	@Test def void testFeatureCall_113() throws Exception {
		"newArrayList('').map(s| return s.length + 1 == 5).map(Boolean b| return !b).head"
			.resolvesClosuresTo("(String)=>boolean", "(Boolean)=>boolean")
			.withEquivalents("Function1<String, Boolean>", "Function1<Boolean, Boolean>")
	}
	
	@Test def void testFeatureCall_114() throws Exception {
		"newArrayList('').map(s| return s.length + 1 == 5).map(b| return !!b )"
			.resolvesClosuresTo("(String)=>boolean", "(Boolean)=>boolean")
			.withEquivalents("Function1<String, Boolean>", "Function1<Boolean, Boolean>")
	}
	
	@Test def void testFeatureCall_115() throws Exception {
		"newArrayList('').map(s| return s.length + 1 == 5).map(b| return !!b ).head"
			.resolvesClosuresTo("(String)=>boolean", "(Boolean)=>boolean")
			.withEquivalents("Function1<String, Boolean>", "Function1<Boolean, Boolean>")
	}
	
	@Test def void testFeatureCall_116() throws Exception {
		"newArrayList('').map(s| return s.length + 1 == 5).map(b| return { !b } )"
			.resolvesClosuresTo("(String)=>boolean", "(Boolean)=>boolean")
			.withEquivalents("Function1<String, Boolean>", "Function1<Boolean, Boolean>")
	}
	
	@Test def void testFeatureCall_117() throws Exception {
		"newArrayList('').map(s| return s.length + 1 == 5).map(b| { return !b } ).head"
			.resolvesClosuresTo("(String)=>boolean", "(Boolean)=>boolean")
			.withEquivalents("Function1<String, Boolean>", "Function1<Boolean, Boolean>")
	}
	
	@Test def void testFeatureCall_118() throws Exception {
		"newArrayList('').map(s| return s.length + 1 == 5).map(b| return { b.operator_not } )"
			.resolvesClosuresTo("(String)=>boolean", "(Boolean)=>boolean")
			.withEquivalents("Function1<String, Boolean>", "Function1<Boolean, Boolean>")
	}
	
	@Test def void testFeatureCall_119() throws Exception {
		"newArrayList('').map(s| return s.length + 1 == 5).map(b| return { b.operator_not } ).head"
			.resolvesClosuresTo("(String)=>boolean", "(Boolean)=>boolean")
			.withEquivalents("Function1<String, Boolean>", "Function1<Boolean, Boolean>")
	}

	@Test def void testFeatureCall_120() throws Exception {
		("newArrayList('').map(s|" +
		"return $$ObjectExtensions::operator_equals(" +
		"	$$IntegerExtensions::operator_plus(s.length,1), 5)" +
		").map(b| return $$BooleanExtensions::operator_not(b) )")
			.resolvesClosuresTo("(String)=>boolean", "(Boolean)=>boolean")
			.withEquivalents("Function1<String, Boolean>", "Function1<Boolean, Boolean>")
	}
	
	@Test def void testFeatureCall_121() throws Exception {
		("newArrayList('').map(s|" +
		"return $$ObjectExtensions::operator_equals(" +
		"	$$IntegerExtensions::operator_plus(s.length,1), 5)" +
		").map(b| return $$BooleanExtensions::operator_not(b) ).head")
			.resolvesClosuresTo("(String)=>boolean", "(Boolean)=>boolean")
			.withEquivalents("Function1<String, Boolean>", "Function1<Boolean, Boolean>")
	}
	
	@Test def void testFeatureCall_122() throws Exception {
		"newArrayList('').map(s| return s.length + 1 * 5).map(b| return b / 5 )"
			.resolvesClosuresTo("(String)=>int", "(Integer)=>int")
			.withEquivalents("Function1<String, Integer>", "Function1<Integer, Integer>")
	}
	@Test def void testFeatureCall_123() throws Exception {
		"newArrayList('').map(s| return s.length + 1 * 5).map(b| return b / 5 ).head"
			.resolvesClosuresTo("(String)=>int", "(Integer)=>int")
			.withEquivalents("Function1<String, Integer>", "Function1<Integer, Integer>")
	}
	
	@Test def void testFeatureCall_124() throws Exception {
		"newArrayList('').map[ return length + 1 * 5 ].map [ return it / 5 ).head"
			.resolvesClosuresTo("(String)=>int", "(Integer)=>int")
			.withEquivalents("Function1<String, Integer>", "Function1<Integer, Integer>")
	}
	
	@Test def void testFeatureCall_125() throws Exception {
		"newArrayList('').map[ return length + 1 * 5 - length + 1 * 5 ].map [ return it / 5 + 1 / it ).head"
			.resolvesClosuresTo("(String)=>int", "(Integer)=>int")
			.withEquivalents("Function1<String, Integer>", "Function1<Integer, Integer>")
	}
	
	@Test def void testFeatureCall_126() throws Exception {
		"{ val list = newArrayList(if (false) new Double('-20') else new Integer('20')).map(v| return v.intValue)
           val Object o = list.head 
           list
        }".resolvesClosuresTo("(Number & Comparable<?>)=>int")
          .withEquivalents("Function1<Number & Comparable<?>, Integer>")
	}
	
	@Test def void testFeatureCall_127() throws Exception {
		"{ val list = newArrayList(if (false) new Double('-20') else new Integer('20')).map(v| return v.intValue)
           val Object o = list.head 
           list.head
        }".resolvesClosuresTo("(Number & Comparable<?>)=>int")
          .withEquivalents("Function1<Number & Comparable<?>, Integer>")
	}
	
	@Test def void testFeatureCall_128() throws Exception {
		"{ val list = $$ListExtensions::map(newArrayList(if (false) new Double('-20') else new Integer('20'))) [ v| return v.intValue ]
           val Object o = list.head 
           list
        }".resolvesClosuresTo("(Number & Comparable<?>)=>int")
          .withEquivalents("Function1<Number & Comparable<?>, Integer>")
	}
	
	@Test def void testFeatureCall_129() throws Exception {
		"{ val list = $$ListExtensions::map(newArrayList(null as Integer)) [ v| return v.intValue ]
           val Object o = list.head 
           list
        }".resolvesClosuresTo("(Integer)=>int")
          .withEquivalents("Function1<Integer, Integer>")
	}

	@Test def void testFeatureCall_130() throws Exception {
		"{ val list = newArrayList(null as Integer).map [ v| return v.intValue ]
           val Object o = list.head 
           list
        }".resolvesClosuresTo("(Integer)=>int")
          .withEquivalents("Function1<Integer, Integer>")
	}
	
	@Test def void testFeatureCall_131() throws Exception {
		"{ val list = newArrayList(null as Integer).map [ v| return v.intValue ]
           val Object o = list.head 
           list.findFirst [return intValue == 0 ]
        }".resolvesClosuresTo("(Integer)=>int", "(Integer)=>boolean")
          .withEquivalents("Function1<Integer, Integer>", "Function1<Integer, Boolean>")
	}
	
	@Test def void testFeatureCall_132() throws Exception {
		"{
			val list = newArrayList
			list.forEach[String s | return s]
			list
		}".resolvesClosuresTo("(String)=>void").withEquivalents("Procedure1<String>")
	}
	
	@Test def void testFeatureCall_133() throws Exception {
		"{
			val list = newArrayList
			list.findFirst[String s | return true]
			list
		}".resolvesClosuresTo("(String)=>boolean").withEquivalents("Function1<String, Boolean>")
	}
	
	@Test def void testFeatureCall_134() throws Exception {
		"newArrayList.map[String s | return s.substring(1,1) ]"
			.resolvesClosuresTo("(String)=>String")
			.withEquivalents("Function1<String, String>")
	}

	@Test def void testFeatureCall_135() throws Exception {
		"newArrayList.map[ s | return s.toString ]"
			.resolvesClosuresTo("(Object)=>String")
			.withEquivalents("Function1<Object, String>")
	}
	
	@Test def void testFeatureCall_136() throws Exception {
		"{
			val list = newArrayList
			list.forEach[ s | return s.toString ]
			list
		}".resolvesClosuresTo("(Object)=>void").withEquivalents("Procedure1<Object>")
	}
	
	@Test def void testFeatureCall_137() throws Exception {
		"{ val list = newArrayList(new Double('-20'), new Integer('20')).map(v| return v.intValue)
           val Object o = list.head 
           list
        }".resolvesClosuresTo("(Number & Comparable<?>)=>int")
          .withEquivalents("Function1<Number & Comparable<?>, Integer>")
	}
	
	@Test def void testFeatureCall_138() throws Exception {
		"{ val list = newArrayList(new Double('-20'), new Integer('20')).map(v| return v.intValue)
           val Object o = list.head 
           list.head
        }".resolvesClosuresTo("(Number & Comparable<?>)=>int")
          .withEquivalents("Function1<Number & Comparable<?>, Integer>")
	}
	
	@Test def void testFeatureCall_Bug342134_00() throws Exception {
		"(null as java.util.List<String>).map(e| return newArrayList(e)).flatten"
			.resolvesClosuresTo("(String)=>ArrayList<String>")
			.withEquivalents("Function1<String, ArrayList<String>>")
	}
	
	@Test def void testFeatureCall_Bug342134_01() throws Exception {
		"(null as java.util.List<String>).map(e|newArrayList(e)).flatten.head"
			.resolvesClosuresTo("(String)=>ArrayList<String>")
			.withEquivalents("Function1<String, ArrayList<String>>")
	}
	
	@Test def void testFeatureCall_Bug342134_02() throws Exception {
		"newArrayList('').map(e| return newArrayList(e)).flatten"
			.resolvesClosuresTo("(String)=>ArrayList<String>")
			.withEquivalents("Function1<String, ArrayList<String>>")
	}
	
	@Test def void testFeatureCall_Bug342134_03() throws Exception {
		"newArrayList('').map(e| return newArrayList(e)).flatten.head"
			.resolvesClosuresTo("(String)=>ArrayList<String>")
			.withEquivalents("Function1<String, ArrayList<String>>")
	}
	
	@Test def void testFeatureCall_Bug342134_04() throws Exception {
		"newArrayList('').map(e| return newArrayList(e))"
			.resolvesClosuresTo("(String)=>ArrayList<String>")
			.withEquivalents("Function1<String, ArrayList<String>>")
	}
	
	@Test def void testFeatureCall_Bug342134_05() throws Exception {
		"newArrayList('').map(e| return newArrayList(e)).head"
			.resolvesClosuresTo("(String)=>ArrayList<String>")
			.withEquivalents("Function1<String, ArrayList<String>>")
	}
	
	@Test def void testFeatureCall_Bug342134_06() throws Exception {
		"<String>newArrayList.map(e| return newArrayList(e)).flatten"
			.resolvesClosuresTo("(String)=>ArrayList<String>")
			.withEquivalents("Function1<String, ArrayList<String>>")
	}
	
	@Test def void testFeatureCall_Bug342134_07() throws Exception {
		"newArrayList('').map(e| return <String>newArrayList(e)).flatten"
			.resolvesClosuresTo("(String)=>ArrayList<String>")
			.withEquivalents("Function1<String, ArrayList<String>>")
	}
	
	@Test def void testFeatureCall_Bug342134_08() throws Exception {
		"newArrayList.map(String e| return <String>newArrayList(e)).flatten"
			.resolvesClosuresTo("(String)=>ArrayList<String>")
			.withEquivalents("Function1<String, ArrayList<String>>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_01() throws Exception {
		"{
			val list = newArrayList
			val fun = [String s| s]
			list.map(fun)
			list
		}".resolvesClosuresTo("(String)=>String").withEquivalents("Function1<String, String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_02() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.map[String s| s]
			list
		}".resolvesClosuresTo("(String)=>String").withEquivalents("Function1<String, String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_03() throws Exception {
		"{
			val list = newArrayList
			list.map[String s| s]
			list
		}".resolvesClosuresTo("(String)=>String").withEquivalents("Function1<String, String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_04() throws Exception {
		"{
			val list = newArrayList
			$$IterableExtensions::map(list, [String s| s])
			list
		}".resolvesClosuresTo("(String)=>String").withEquivalents("Function1<String, String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_05() throws Exception {
		"{
			val list = newArrayList
			val fun = [String s| s]
			$$IterableExtensions::map(list, fun)
			list
		}".resolvesClosuresTo("(String)=>String").withEquivalents("Function1<String, String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_06() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.map(println([String s| println(s)]))
			list
		}".resolvesClosuresTo("(String)=>String").withEquivalents("Function1<String, String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_07() throws Exception {
		"{
			val list = newArrayList
			val fun = [String s| return s]
			list.map(fun)
			list
		}".resolvesClosuresTo("(String)=>String").withEquivalents("Function1<String, String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_08() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.map[String s| return s]
			list
		}".resolvesClosuresTo("(String)=>String").withEquivalents("Function1<String, String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_09() throws Exception {
		"{
			val list = newArrayList
			list.map[String s| return s]
			list
		}".resolvesClosuresTo("(String)=>String").withEquivalents("Function1<String, String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_10() throws Exception {
		"{
			val list = newArrayList
			$$IterableExtensions::map(list, [String s| return s])
			list
		}".resolvesClosuresTo("(String)=>String").withEquivalents("Function1<String, String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_11() throws Exception {
		"{
			val list = newArrayList
			val fun = [String s| return s]
			$$IterableExtensions::map(list, fun)
			list
		}".resolvesClosuresTo("(String)=>String").withEquivalents("Function1<String, String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_12() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.map(println([String s| return println(s)]))
			list
		}".resolvesClosuresTo("(String)=>String").withEquivalents("Function1<String, String>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_13() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.<String, Object>map[s| s.toString]
			list
		}".resolvesClosuresTo("(String)=>String") // TODO .withEquivalents("Function1<String, String>")
	}	

	@Test def void testDeferredTypeArgumentResolution_14() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.<String, Object>map[s| s.charAt(1) ]
			list
		}".resolvesClosuresTo("(String)=>char") // TODO .withEquivalents("Function1<String, Character>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_15() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.<String, CharSequence>map[s| s]
			list
		}".resolvesClosuresTo("(String)=>String").withEquivalents("Function1<String, CharSequence>")
	}
	
	@Test def void testDeferredTypeArgumentResolution_16() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.<String, Object>map[s| s]
			list
		}".resolvesClosuresTo("(String)=>String").withEquivalents("Function1<String, Object>")
	}

	@Test def void testClosureWithReturnExpression_01() throws Exception {
		"[ | if (true) return '' else return new StringBuilder ]"
			.resolvesClosuresTo("()=>Serializable & CharSequence")
			.withEquivalents("Function0<Serializable & CharSequence>")
	}
	
	@Test def void testClosureWithReturnExpression_02() throws Exception {
		"[ | if (true) '' else return new StringBuilder ]"
			.resolvesClosuresTo("()=>Serializable & CharSequence")
			.withEquivalents("Function0<Serializable & CharSequence>")
	}
	
	@Test def void testClosureWithReturnExpression_03() throws Exception {
		"[ | if (true) return '' else new StringBuilder ]"
			.resolvesClosuresTo("()=>Serializable & CharSequence")
			.withEquivalents("Function0<Serializable & CharSequence>")
	}
	
	@Test def void testClosureWithReturnExpression_04() throws Exception {
		"[ | if (true) '' else new StringBuilder ]"
			.resolvesClosuresTo("()=>Serializable & CharSequence")
			.withEquivalents("Function0<Serializable & CharSequence>")
	}

	@Test def void testClosureWithReturnExpression_05() throws Exception {
		"[ int i1, int i2| if (true) return i1 else return null ].apply(1, 1)"
			.resolvesClosuresTo("(int, int)=>Integer")
			.withEquivalents("Function2<Integer, Integer, Integer>")
	}
	
	@Test def void testAbstractIterator_01() throws Exception {
		"{ var com.google.common.collect.AbstractIterator<String> iter = [| return self.endOfData ] }"
			.resolvesClosuresTo("()=>String")
			.withEquivalents("AbstractIterator<String>")
	}
	
	@Test def void testAbstractIterator_02() throws Exception {
		"{ 
			var com.google.common.collect.AbstractIterator<java.util.Iterator<String>> iter = [|
				if (true) {
					val com.google.common.collect.AbstractIterator<String> result = [|
						return self.endOfData
					]
					return result
				}
				return self.endOfData
			]
		}"
			.resolvesClosuresTo("()=>Iterator<String>", "()=>String")
			.withEquivalents("AbstractIterator<Iterator<String>>", "AbstractIterator<String>")
	}
}
