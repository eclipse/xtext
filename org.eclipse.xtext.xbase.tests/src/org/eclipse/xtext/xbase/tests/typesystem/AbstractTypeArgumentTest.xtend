/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typesystem

import java.util.Iterator
import java.util.Set
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XConstructorCall
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase
import org.junit.After
import org.junit.AfterClass
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Ignore
import org.junit.Test

import static org.eclipse.xtext.xbase.XbasePackage.Literals.*

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
abstract class AbstractTypeArgumentTest extends AbstractXbaseTestCase {
	
	def Iterator<XExpression> bindTypeArgumentsTo(String expression, String... typeArguments) {
		val expressions = expression.findExpressionWithTypeArguments
		return and(expressions.iterator, typeArguments)
	}
	
	def Iterator<XExpression> and(Iterator<XExpression> expressions, String... typeArguments) {
		assertTrue(expressions.hasNext)
		val expression = expressions.next
		expression.hasTypeArguments(typeArguments)
		return expressions
	}
	
	def void done(Iterator<XExpression> exhaustedIterator) {
		assertFalse(doneCalled)
		assertFalse(exhaustedIterator.hasNext)
		doneCalled = true
	}
	
	def protected void hasTypeArguments(XExpression expression, String... typeArguments)
	
	boolean doneCalled = false
	
	@Before
	def void resetDoneState() {
		doneCalled = false
	}
	
	@After
	def void checkDoneState() {
//		assertTrue("expected an invocation of 'done'", doneCalled)
	}
	
	static Set<String> seenExpressions
	
	@BeforeClass
	def static void createSeenExpressionsSet() {
		seenExpressions = newHashSet
	}
	
	@AfterClass
	def static void discardSeenExpressions() {
		seenExpressions = null
	}
	
	override protected expression(CharSequence expression, boolean resolve) throws Exception {
		val string = expression.toString.replace('$$', 'org::eclipse::xtext::xbase::lib::')
		if (!seenExpressions.add(string)) {
			fail("Duplicate expression under test: " + expression)
		}
		super.expression(string, resolve)
	}
	
	def protected void resolveTypes(XExpression expression)
	
	def protected findExpressionWithTypeArguments(CharSequence expression) {
		val xExpression = expression(expression, false)
		xExpression.resolveTypes
		val result = EcoreUtil2::eAll(xExpression).filter(typeof(XExpression)).filter [ it |
			switch(it) {
				XAbstractFeatureCall:
					!typeLiteral && !packageFragment && (!it.typeArguments.empty ||
					switch feature: it.feature {
						JvmTypeParameterDeclarator: !feature.typeParameters.empty
						default: false
					})
				XConstructorCall:
					!it.typeArguments.empty ||
					!(it.constructor.declaringType as JvmGenericType).typeParameters.empty
				default:
					false 
			}
		].toList
		return result.sortBy [
			val structuralFeature = switch(it) {
				XAbstractFeatureCall: XABSTRACT_FEATURE_CALL__FEATURE
				XConstructorCall: XCONSTRUCTOR_CALL__CONSTRUCTOR
			} 
			return NodeModelUtils::findNodesForFeature(it, structuralFeature).head.offset
		]
	}
	
	@Test def void testBug461923_01() throws Exception {
		"{ val Iterable<String> it = null com.google.common.collect.ImmutableList.builder.addAll(it).build }".bindTypeArgumentsTo("String").done
	}
	
	@Test def void testBug461923_02() throws Exception {
		"{ val Iterable<? extends String> it = null com.google.common.collect.ImmutableList.builder.addAll(it).build }".bindTypeArgumentsTo("String").done
	}
	
	@Test def void testBug461923_03() throws Exception {
		"{ val Iterable<? super String> it = null com.google.common.collect.ImmutableList.builder.addAll(it).build }".bindTypeArgumentsTo("Object").done
	}
	
	@Test def void testBug461923_04() throws Exception {
		"{ val Iterable<String> it = null com.google.common.collect.ImmutableList.builder.addAll(it.map[it]).build }".bindTypeArgumentsTo("String").and("String", "String").done
	}
	
	@Test def void testBug461923_05() throws Exception {
		"{ val Iterable<? extends String> it = null com.google.common.collect.ImmutableList.builder.addAll(it.map[it]).build }".bindTypeArgumentsTo("String").and("? extends String", "String").done
	}
	
	@Test def void testBug461923_06() throws Exception {
		"{ val Iterable<? super String> it = null com.google.common.collect.ImmutableList.builder.addAll(it.map[it]).build }".bindTypeArgumentsTo("Object").and("? super String", "Object").done
	}
	
	@Test def void testBug461923_07() throws Exception {
		"{ val Iterable<String> it = null com.google.common.collect.ImmutableList.builder.addAll(it.filter[true]).build }".bindTypeArgumentsTo("String").and("String").done
	}
	
	@Test def void testBug461923_08() throws Exception {
		"{ val Iterable<? extends String> it = null com.google.common.collect.ImmutableList.builder.addAll(it.filter[true]).build }".bindTypeArgumentsTo("String").and("? extends String").done
	}
	
	@Test def void testBug461923_09() throws Exception {
		"{ val Iterable<? super String> it = null com.google.common.collect.ImmutableList.builder.addAll(it.filter[true]).build }".bindTypeArgumentsTo("Object").and("? super String").done
	}
	
	@Test def void testBug461923_10() throws Exception {
		"{ val Iterable<String> it = null com.google.common.collect.ImmutableList.builder.addAll(it.filter[true]).addAll(it.filter[true]).build }".bindTypeArgumentsTo("String").and("String").and("String").done
	}
	
	@Test def void testBug461923_11() throws Exception {
		"{ val Iterable<? extends String> it = null com.google.common.collect.ImmutableList.builder.addAll(it.filter[true]).addAll(it.filter[true]).build }".bindTypeArgumentsTo("String").and("? extends String").and("? extends String").done
	}
	
	@Test def void testBug461923_12() throws Exception {
		"{ val Iterable<? super String> it = null com.google.common.collect.ImmutableList.builder.addAll(it.filter[true]).addAll(it.filter[true]).build }".bindTypeArgumentsTo("Object").and("? super String").and("? super String").done
	}
	
	@Test def void testBug461923_13() throws Exception {
		"{ val java.util.Set<String> it = null new java.util.ArrayList().addAll(it) }".bindTypeArgumentsTo("String").done
	}
	
	@Test def void testBug461923_14() throws Exception {
		"{ val java.util.Set<? extends String> it = null new java.util.ArrayList().addAll(it) }".bindTypeArgumentsTo("String").done
	}
	
	@Test def void testBug461923_15() throws Exception {
		"{ val java.util.Set<? super String> it = null new java.util.ArrayList().addAll(it) }".bindTypeArgumentsTo("Object").done
	}
	
	@Test def void testBug461923_16() throws Exception {
		"{ val java.util.List<String> it = null new java.util.ArrayList().addAll(it.subList(1,1)) }".bindTypeArgumentsTo("String").done
	}
	
	@Test def void testBug461923_17() throws Exception {
		"{ val java.util.List<? extends String> it = null new java.util.ArrayList().addAll(it.subList(1,1)) }".bindTypeArgumentsTo("String").done
	}
	
	@Test def void testBug461923_18() throws Exception {
		"{ val java.util.List<? super String> it = null new java.util.ArrayList().addAll(it.subList(1,1)) }".bindTypeArgumentsTo("Object").done
	}
	
	@Test def void testRawType_01() throws Exception {
		"{ val java.util.Set set = newHashSet() set }".bindTypeArgumentsTo("").done
	}
	
	@Test def void testRawType_02() throws Exception {
		"{ val java.util.Set set = newHashSet set.head }".bindTypeArgumentsTo("").and("").done
	}
	
	@Test def void testRawType_03() throws Exception {
		"(null as java.util.Set<java.util.Set>).head".bindTypeArgumentsTo("Set").done
	}
	
	@Test def void testRawType_04() throws Exception {
		"{ val java.util.Set<java.util.Set> set = newHashSet set.head }".bindTypeArgumentsTo("Set").and("Set").done
	}
	
	@Test def void testRawType_05() throws Exception {
		"{ val java.util.Set<java.util.Set> set = newHashSet(newHashSet) set.head }".bindTypeArgumentsTo("Set").and("").and("Set").done
	}
	
	@Test def void testNumberLiteralInClosure_01() throws Exception {
		"newArrayList().map[42]".bindTypeArgumentsTo("Object").and("Object", "Integer").done
	}
	
	@Test def void testOverloadedTypeParameters_01() throws Exception {
		"testdata::OverloadedMethods::<String>overloadedTypeParameters(null)".bindTypeArgumentsTo("String").done
	}
	
	@Test def void testOverloadedTypeParameters_02() throws Exception {
		"testdata::OverloadedMethods::<String, String>overloadedTypeParameters(null)".bindTypeArgumentsTo("String", "String").done
	}
	
	@Test def void testOverloadedMethods_07() throws Exception {
		"{
			var java.util.List<CharSequence> list = null
			var Object o = null
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloadedWithTypeParam(list, o)
		}".bindTypeArgumentsTo("CharSequence").done
	}
	
	@Test def void testOverloadedMethods_08() throws Exception {
		"{
			var java.util.List<CharSequence> list = null
			var String s = null
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloadedWithTypeParam(list, s)
		}".bindTypeArgumentsTo("CharSequence").done
	}
	
	@Test def void testOverloadedMethods_09() throws Exception {
		"{
			var java.util.List<? extends CharSequence> list = null
			var Object o = null
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloadedWithTypeParam(list, o)
		}".bindTypeArgumentsTo("CharSequence").done
	}
	
	@Test def void testOverloadedMethods_10() throws Exception {
		"{
			var java.util.List<? extends CharSequence> list = null
			var String s = null
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloadedWithTypeParam(list, s)
		}".bindTypeArgumentsTo("? extends CharSequence").done
	}
	
	@Test def void testOverloadedMethods_11() throws Exception {
		"{
			var java.util.List<CharSequence> list = null
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloadedWithTypeParam(list, null)
		}".bindTypeArgumentsTo("CharSequence").done
	}
	
	@Test def void testOverloadedMethods_12() throws Exception {
		"{
			var java.util.List<? extends CharSequence> list = null
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloadedWithTypeParam(list, null)
		}".bindTypeArgumentsTo("? extends CharSequence").done
	}
	
	@Test def void testOverloadedOperators_07() throws Exception {
		"(0..Math::sqrt(1l).intValue).filter[ i | 1l % i == 0 ].isEmpty".bindTypeArgumentsTo("Integer").done
	}
	
	@Test def void testOverloadedOperators_08() throws Exception {
		"(1..2).map[ toString ].reduce[ i1, i2| i1 + i2 ]".bindTypeArgumentsTo("Integer", "String").and("String").done
	}
	
	@Test def void testOverloadedOperators_09() throws Exception {
		"(1..2).map[ toString.length ].reduce[ i1, i2| i1 + i2 ]".bindTypeArgumentsTo("Integer", "Integer").and("Integer").done
	}
	
	@Test def void testOverloadedOperators_10() throws Exception {
		"(1..2).map[ new java.math.BigInteger(toString) ].reduce[ i1, i2| i1 + i2 ]".bindTypeArgumentsTo("Integer", "BigInteger").and("BigInteger").done
	}
	
	@Test def void testOverloadedOperators_15() throws Exception {
		"(1..2).map[ new java.math.BigInteger(toString) ].map[ i | i.toString + i ]".bindTypeArgumentsTo("Integer", "BigInteger").and("BigInteger", "String").done
	}
	
	@Test def void testOverloadedOperators_16() throws Exception {
		"(1..2).map[ new java.math.BigInteger(toString) ].map[ i | i + String::valueOf(i) ]".bindTypeArgumentsTo("Integer", "BigInteger").and("BigInteger", "String").done
	}
	
	@Test def void testOverloadedOperators_17() throws Exception {
		"(0..Math::sqrt(1l).intValue).filter[ i | 1l % i == 0 ].empty".bindTypeArgumentsTo("Integer").done
	}
	
	@Test def void testOverloadedOperators_20() throws Exception {
		"(null as Iterable<StringBuilder>) + (null as Iterable<StringBuffer>) + (null as Iterable<String>)"
			.bindTypeArgumentsTo("AbstractStringBuilder & Serializable").and("Serializable & CharSequence").done
	}

	@Test def void testForExpression_01() throws Exception {
		"for(String x : new java.util.ArrayList<String>()) x.length".bindTypeArgumentsTo("String").done
	}
	
	@Test def void testForExpression_02() throws Exception {
		"for(String x : newArrayList('foo')) x.length".bindTypeArgumentsTo("String").done
	}
	
	@Test def void testForExpression_03() throws Exception {
		"for(String x : <String>newArrayList()) x.length".bindTypeArgumentsTo("String").done
	}
	
	@Test def void testForExpression_04() throws Exception {
		"for(x : new java.util.ArrayList<String>()) x.length".bindTypeArgumentsTo("String").done
	}
	
	@Test def void testForExpression_05() throws Exception {
		"for(x : <String>newArrayList()) x.length".bindTypeArgumentsTo("String").done
	}
	
	@Test def void testForExpression_06() throws Exception {
		"for(x : newArrayList('foo')) x.length".bindTypeArgumentsTo("String").done
	}

	@Test def void testImplicitImportPrintln_01() throws Exception {
		"println(null)".bindTypeArgumentsTo("Object").done
	}
	
	@Test def void testImplicitImportPrintln_02() throws Exception {
		"<String>println(null)".bindTypeArgumentsTo("String").done
	}
	
	@Test def void testImplicitImportEmptyList_01() throws Exception {
		"<String>emptyList".bindTypeArgumentsTo("String").done
	}
	
	@Test def void testImplicitImportEmptyList_02() throws Exception {
		"emptyList".bindTypeArgumentsTo("Object").done
	}
	
	@Test def void testMethodTypeParamInference_00() throws Exception {
		"new java.util.ArrayList<String>().findFirst(e | true)".bindTypeArgumentsTo("String").and("String").done
	}
	
	@Test def void testMethodTypeParamInference_01() throws Exception {
		"new java.util.ArrayList<String>().findFirst(e|e == 'foo')".bindTypeArgumentsTo("String").and("String").done
	}
	
	@Test def void testMethodTypeParamInference_02() throws Exception {
		"new java.util.ArrayList<String>().<String>findFirst(e|e == 'foo')".bindTypeArgumentsTo("String").and("String").done
	}
	
	@Test def void testMethodTypeParamInference_03() throws Exception {
		"$$IterableExtensions::findFirst(new java.util.ArrayList<String>) [e | true]".bindTypeArgumentsTo("String").and("String").done
	}
	
	@Test def void testMethodTypeParamInference_04() throws Exception {
		"$$IterableExtensions::findFirst(new java.util.ArrayList<String>) [e|e == 'foo']".bindTypeArgumentsTo("String").and("String").done
	}
	
	@Test def void testMethodTypeParamInference_05() throws Exception {
		"$$IterableExtensions::<String>findFirst(new java.util.ArrayList<String>) [e|e == 'foo']".bindTypeArgumentsTo("String").and("String").done
	}
	
	@Test def void testMethodTypeParamInference_06() throws Exception {
		"(null as Iterable<? extends String>).findFirst(e | true)".bindTypeArgumentsTo("? extends String").done
	}
	
	@Test def void testMethodTypeParamInference_07() throws Exception {
		"(null as Iterable<? extends String>).map[e | true]".bindTypeArgumentsTo("? extends String", "Boolean").done
	}
	
	@Test def void testMethodTypeParamInference_08() throws Exception {
		"(null as Iterable<? super String>).findFirst(e | true)".bindTypeArgumentsTo("? super String").done
	}
	
	@Test def void testMethodTypeParamInference_09() throws Exception {
		"(null as Iterable<? super String>).map[e | true]".bindTypeArgumentsTo("? super String", "Boolean").done
	}
	
	@Test def void testMethodTypeParamInference_10() throws Exception {
		"(null as Iterable<? extends String>).findFirst(null)".bindTypeArgumentsTo("? extends String").done
	}
	
	@Test def void testMethodTypeParamInference_11() throws Exception {
		"(null as Iterable<? extends String>).map(null)".bindTypeArgumentsTo("? extends String", "Object").done
	}
	
	@Test def void testMethodTypeParamInference_12() throws Exception {
		"(null as Iterable<? super String>).findFirst(null)".bindTypeArgumentsTo("? super String").done
	}
	
	@Test def void testMethodTypeParamInference_13() throws Exception {
		"(null as Iterable<? super String>).map(null)".bindTypeArgumentsTo("? super String", "Object").done
	}
	
	@Test def void testMethodTypeParamInference_14() throws Exception {
		"(null as java.util.Collection<? super String>).addAll(null as Iterable<? extends String>)".bindTypeArgumentsTo("? super String").done
	}
	
	@Test def void testMethodTypeParamInference_15() throws Exception {
		"(null as java.util.Collection<? super String>).addAll(null as Iterable<String>)".bindTypeArgumentsTo("? super String").done
	}
	
	@Test def void testMethodTypeParamInference_16() throws Exception {
		"(null as java.util.Collection<String>).addAll(null as Iterable<? extends String>)".bindTypeArgumentsTo("String").done
	}
	
	@Test def void testMethodTypeParamInference_17() throws Exception {
		"(null as java.util.Collection<String>).addAll(null as Iterable<String>)".bindTypeArgumentsTo("String").done
	}
	
	@Test def void testMethodTypeParamInference_18() throws Exception {
		"testdata::OverloadedMethods::addAllSuperExtends(null as java.util.List<CharSequence>, null as java.util.List<String>)".bindTypeArgumentsTo("CharSequence").done
	}
	
	@Test def void testMethodTypeParamInference_19() throws Exception {
		"{
			val Iterable<String> expectation = testdata::OverloadedMethods::addAllSuperExtends2(null as java.util.List<CharSequence>, null as java.util.List<String>)
		}".bindTypeArgumentsTo("String").done
	}
	
	@Test def void testMethodTypeParamInference_20() throws Exception {
		"{
			val Iterable<CharSequence> expectation = testdata::OverloadedMethods::addAllSuperExtends2(null as java.util.List<CharSequence>, null as java.util.List<String>)
		}".bindTypeArgumentsTo("CharSequence").done
	}
	
	@Test def void testMethodTypeParamInference_21() throws Exception {
		"testdata::OverloadedMethods::<CharSequence>addAllSuperExtends(null as java.util.List<CharSequence>, null as java.util.List<String>)".bindTypeArgumentsTo("CharSequence").done
	}

	@Test def void testMethodTypeParamInference_22() throws Exception {
		"testdata::OverloadedMethods::<String>addAllSuperExtends(null as java.util.List<CharSequence>, null as java.util.List<String>)".bindTypeArgumentsTo("String").done
	}
	
	@Ignore("TODO subsequent usages of local vars should contribute to the expectation")
	@Test def void testMethodTypeParamInference_23() throws Exception {
		"{
			val actual = testdata::OverloadedMethods::addAllSuperExtends2(null as java.util.List<CharSequence>, null as java.util.List<String>)
			val Iterable<String> expectation = actual
		}".bindTypeArgumentsTo("String").done
	}
	
	@Test def void testMethodTypeParamInference_24() throws Exception {
		"{
			val actual = testdata::OverloadedMethods::addAllSuperExtends2(null as java.util.List<CharSequence>, null as java.util.List<String>)
			val Iterable<CharSequence> expectation = actual
		}".bindTypeArgumentsTo("CharSequence").done
	}
	
	@Test def void testMethodTypeParamInference_25() throws Exception {
		"{
			val Iterable<CharSequence> expectation = testdata::OverloadedMethods::addAllSuperExtends2(null as java.util.List<Object>, null as java.util.List<String>)
		}".bindTypeArgumentsTo("CharSequence").done
	}
	
	@Ignore("TODO")
	@Test def void testMethodTypeParamInference_26() throws Exception {
		"{
			val actual = testdata::OverloadedMethods::addAllSuperExtends2(null as java.util.List<Object>, null as java.util.List<String>)
			val Iterable<CharSequence> expectation = actual
		}".bindTypeArgumentsTo("CharSequence").done
	}
		
	@Test def void testTypeForVoidClosure() throws Exception {
		"newArrayList('foo','bar').forall []".bindTypeArgumentsTo("String").and("String").done
	}
	
	@Test def void testClosure_01() throws Exception {
		"{ var closure = [|'literal']
		  new testdata.ClosureClient().invoke0(closure)	}".bindTypeArgumentsTo("String").done
	}
	
	@Test
	def void testClosure_03() throws Exception {
		("{\n" + 
		"  var java.util.List<? super String> list = null;\n" + 
		"  list.map(e|e)\n" +
		"}").bindTypeArgumentsTo("? super String", "Object").done
	}

	@Test
	def void testClosure_04() throws Exception {
		("{\n" + 
		"  var java.util.List<? super String> list = null;\n" + 
		"  list.map(e|false)\n" +
		"}").bindTypeArgumentsTo("? super String", "Boolean").done
	}

	@Test
	def void testClosure_05() throws Exception {
		("{\n" + 
		"  val func = [|'literal']\n" + 
		"  new testdata.ClosureClient().useProvider(func)\n" +
		"}").bindTypeArgumentsTo("String").done
	}
	
	@Test 
	def void testClosure_06() throws Exception {
		"new testdata.ClosureClient().useProvider(null as com.google.inject.Provider<? extends Iterable<String>[]>)".bindTypeArgumentsTo("? extends Iterable<String>[]").done
	}
	
	@Test 
	def void testClosure_07() throws Exception {
		"new testdata.ClosureClient().useProvider(null as com.google.inject.Provider<? extends String>)".bindTypeArgumentsTo("? extends String").done
	}
	
	@Test 
	def void testClosure_08() throws Exception {
		// due to demand conversion we end up with Provider<String> whereas the argument type was Function0<? extends Iterable<String[]>
		"new testdata.ClosureClient().useProvider(null as =>Iterable<String>[])".bindTypeArgumentsTo("Iterable<String>[]").done
	}
	
	@Test 
	def void testClosure_09() throws Exception {
		// due to demand conversion we end up with Provider<String> whereas the argument type was Function0<? extends String>
		"new testdata.ClosureClient().useProvider(null as =>String)".bindTypeArgumentsTo("String").done
	}
	
	@Test 
	def void testClosure_10() throws Exception {
		"new testdata.ClosureClient().invoke0(null as =>String)".bindTypeArgumentsTo("? extends String").done
	}
	
	@Test def void testClosure_13() throws Exception {
		"{ 
			val mapper = [ x | x ]
			newArrayList(1).map(mapper)
		}".bindTypeArgumentsTo("Integer").and("Integer", "Integer").done
	}
	
	@Test def void testClosure_13a() throws Exception {
		"{ 
			val mapper = [ x | x ]
			newArrayList(1).map(mapper).head
		}".bindTypeArgumentsTo("Integer").and("Integer", "Integer").and("Integer").done
	}
	
	@Test def void testClosure_13b() throws Exception {
		"{ 
			val mapper = [ x | x ]
			newArrayList(1).map(mapper).findFirst [ true ]
		}".bindTypeArgumentsTo("Integer").and("Integer", "Integer").and("Integer").done
	}
	
	@Test def void testClosure_16() throws Exception {
		"{ 
			val fun = [ x | x ]
			val java.util.List<String> list = newArrayList(fun.apply(null))
			fun
		}".bindTypeArgumentsTo("String").done
	}
	
	@Test def void testClosure_17() throws Exception {
		"{ 
			val fun = [ x | x ]
			val java.util.List<String> list = newArrayList.map(fun)
			fun
		}".bindTypeArgumentsTo("String").and("String", "String").done
	}
	
	@Test def void testClosure_18() throws Exception {
		"{ 
			val fun = [ x | x ]
			val java.util.Set<String> list = newArrayList.map(fun)
			fun
		}".bindTypeArgumentsTo("String").and("String", "String").done
	}
	
	@Test def void testClosure_19() throws Exception {
		"{ 
			val fun = [ x | x ]
			val java.util.ArrayList<String> list = newArrayList.map(fun)
			fun
		}".bindTypeArgumentsTo("String").and("String", "String").done
	}
	
	@Test def void testClosure_20() throws Exception {
		"{ 
			val fun = [ x | x ]
			val Iterable<CharSequence> list = newArrayList.map(fun)
			fun
		}".bindTypeArgumentsTo("CharSequence").and("CharSequence", "CharSequence").done
	}
	
	@Test def void testClosure_21() throws Exception {
		"{ 
			val fun = [ x | x ]
			val list = newArrayList.map(fun)
			val Iterable<String> iter = list
			fun
		}".bindTypeArgumentsTo("String").and("String", "String").done
	}
	
	@Test def void testClosure_22() throws Exception {
		"{ 
			val fun = [ CharSequence x | x ]
			val java.util.List<String> list = $$ListExtensions::map(newArrayList, fun)
			fun
		}".bindTypeArgumentsTo("CharSequence", "String").and("CharSequence").done
	}
	
	@Test def void testClosure_23() throws Exception {
		"{ 
			val fun = [ Object x | x.toString ]
			val java.util.Set<String> list = $$ListExtensions::map(newArrayList, fun)
			fun
		}".bindTypeArgumentsTo("Object", "String").and("Object").done
	}
	
	@Test def void testClosure_24() throws Exception {
		"{ 
			val fun = [ x | x ]
			val java.util.ArrayList<String> list = $$ListExtensions::map(newArrayList, fun)
			fun
		}".bindTypeArgumentsTo("String", "String").and("String").done
	}
	
	@Test def void testClosure_25() throws Exception {
		"{ 
			val fun = [ x | x ]
			val Iterable<String> list = $$ListExtensions::map(newArrayList, fun)
			fun
		}".bindTypeArgumentsTo("String", "String").and("String").done
	}
	
	@Test def void testClosure_26() throws Exception {
		"{ 
			val fun = [ x | x ]
			val list = $$ListExtensions::map(newArrayList, fun)
			val Iterable<String> iter = list
			fun
		}".bindTypeArgumentsTo("String", "String").and("String").done
	}
	
	@Test def void testClosure_27() throws Exception {
		"{ 
			val mapper = [ x | x ]
			$$ListExtensions::map(newArrayList(1), mapper)
		}".bindTypeArgumentsTo("Integer", "Integer").and("Integer").done
	}
	
	@Test def void testTypeArgs() throws Exception {
		"new java.util.ArrayList<String>() += 'foo'".bindTypeArgumentsTo("String").and("String").done
	}
	
	@Test def void testEMap_01() throws Exception {
		"{ 
          val eMap = new org.eclipse.emf.common.util.BasicEMap<Integer, String>()
		  eMap.map[ getKey ].head
         }".bindTypeArgumentsTo("Integer", "String").and("Entry<Integer, String>", "Integer").and("Integer").done
	}
	
	@Test def void testEMap_02() throws Exception {
		"{ 
          val eMap = new org.eclipse.emf.common.util.BasicEMap<Integer, String>()
		  eMap.map[ getValue ].head
         }".bindTypeArgumentsTo("Integer", "String").and("Entry<Integer, String>", "String").and("String").done
	}
	
	@Test def void testEMap_03() throws Exception {
		"{ 
          val eMap = new org.eclipse.emf.common.util.BasicEMap<Integer, String>()
		  eMap.map[ it ].head
         }".bindTypeArgumentsTo("Integer", "String").and("Entry<Integer, String>", "Entry<Integer, String>").and("Entry<Integer, String>").done
	}
	
	@Test def void testEMap_04() throws Exception {
		"{ 
          val eMap = new org.eclipse.emf.common.util.BasicEMap<Integer, String>()
		  eMap.map
         }".bindTypeArgumentsTo("Integer", "String").done
	}
	
	@Test def void testEMap_05() throws Exception {
		"{ 
          val org.eclipse.emf.common.util.BasicEMap<? extends Integer, String> eMap = null
		  eMap.map[ key ].head
         }".bindTypeArgumentsTo("Entry<? extends Integer, String>", "Integer").and("Integer").done
	}
	
	@Test def void testEMap_06() throws Exception {
		"{ 
          val org.eclipse.emf.common.util.BasicEMap<? extends Integer, String> eMap = null
		  eMap.map[ value ].head
         }".bindTypeArgumentsTo("Entry<? extends Integer, String>", "String").and("String").done
	}
	
	@Test def void testEMap_07() throws Exception {
		"{ 
          val org.eclipse.emf.common.util.BasicEMap<? extends Integer, String> eMap = null
		  eMap.map[ it ].head
         }".bindTypeArgumentsTo("Entry<? extends Integer, String>", "Entry<? extends Integer, String>").and("Entry<? extends Integer, String>").done
	}
	
	@Test def void testEMap_09() throws Exception {
		"{ 
          val org.eclipse.emf.common.util.BasicEMap<? super Integer, String> eMap = null
		  eMap.map[ key ].head
         }".bindTypeArgumentsTo("Entry<? super Integer, String>", "Object").and("Object").done
	}
	
	@Test def void testEMap_10() throws Exception {
		"{ 
          val org.eclipse.emf.common.util.BasicEMap<? super Integer, String> eMap = null
		  eMap.map[ value ].head
         }".bindTypeArgumentsTo("Entry<? super Integer, String>", "String").and("String").done
	}
	
	@Test def void testEMap_11() throws Exception {
		"{ 
          val org.eclipse.emf.common.util.BasicEMap<? super Integer, String> eMap = null
		  eMap.map[ it ].head
         }".bindTypeArgumentsTo("Entry<? super Integer, String>", "Entry<? super Integer, String>").and("Entry<? super Integer, String>").done
	}
	
	@Test def void testConstructorCall_01() throws Exception {
		"new java.util.ArrayList<String>()".bindTypeArgumentsTo("String").done
	}
	
	@Test def void testConstructorCall_02() throws Exception {
		"new java.util.HashMap<String,Boolean>".bindTypeArgumentsTo("String", "Boolean").done
	}
	
	@Test def void testConstructorCall_03() throws Exception {
		"new java.util.ArrayList()".bindTypeArgumentsTo("Object").done
	}
	
	@Test def void testConstructorCall_04() throws Exception {
		"new java.util.ArrayList<? extends String>()".bindTypeArgumentsTo("String").done
	}
	
	@Test def void testConstructorCall_05() throws Exception {
		"new java.util.HashMap<? extends String, ? extends Boolean>".bindTypeArgumentsTo("String", "Boolean").done
	}
	
	@Test def void testConstructorCall_06() throws Exception {
		"new java.util.ArrayList<? super String>()".bindTypeArgumentsTo("String").done
	}
	
	@Test def void testConstructorCall_07() throws Exception {
		"new java.util.HashMap<? super String,Boolean>".bindTypeArgumentsTo("String", "Boolean").done
	}
	
	@Test def void testConstructorTypeParameters_01() throws Exception {
		"new constructorTypeParameters.KeyValue(new constructorTypeParameters.WritableValue, '')".bindTypeArgumentsTo("String").done
	}
	
	@Test def void testConstructorTypeParameters_02() throws Exception {
		"new constructorTypeParameters.KeyValue(new constructorTypeParameters.WritableValue, 1.0)".bindTypeArgumentsTo("Double").done
	}
	
	@Test def void testConstructorTypeInference_01() throws Exception {
		"new testdata.GenericType1('')".bindTypeArgumentsTo("String").done
	}
	
	@Test def void testConstructorTypeInference_02() throws Exception {
		"<java.util.List<String>>newArrayList().add(new java.util.ArrayList())".bindTypeArgumentsTo("List<String>").and("String").done
	}
	
	@Test def void testConstructorTypeInference_03() throws Exception {
		"<java.util.List<String>>newArrayList().add(0, new java.util.ArrayList())".bindTypeArgumentsTo("List<String>").and("String").done
	}
	
	@Test def void testConstructorTypeInference_04() throws Exception {
		"newArrayList.add(new java.util.ArrayList())".bindTypeArgumentsTo("ArrayList<Object>").and("Object").done
	}
	
	@Test def void testConstructorTypeInference_05() throws Exception {
		"new testdata.GenericType2".bindTypeArgumentsTo("Number").done
	}
	
	@Test def void testConstructorTypeInference_06() throws Exception {
		"new testdata.GenericType2(0)".bindTypeArgumentsTo("Integer").done
	}
	
	@Test def void testConstructorTypeInference_07() throws Exception {
		"new testdata.GenericType2(0, 1)".bindTypeArgumentsTo("Integer").done
	}
	
	@Test def void testConstructorTypeInference_08() throws Exception {
		"new testdata.GenericType2(new Integer(0), new Integer(0).doubleValue)".bindTypeArgumentsTo("Number & Comparable<?>").done
	}
	
	@Test def void testConstructorTypeInference_09() throws Exception {
		"<Iterable<String>>newArrayList().add(new java.util.LinkedList)".bindTypeArgumentsTo("Iterable<String>").and("String").done
	}
	
	@Test def void testConstructorTypeInference_10() throws Exception {
		"<Iterable<String>>newArrayList().add(null)".bindTypeArgumentsTo("Iterable<String>").done
	}
	
	@Test def void testConstructorTypeInference_11() throws Exception {
		"<java.util.Map<Iterable<String>, Iterable<Integer>>>newArrayList().head".bindTypeArgumentsTo("Map<Iterable<String>, Iterable<Integer>>").and("Map<Iterable<String>, Iterable<Integer>>").done
	}
	
	@Test def void testVarArgs_01() throws Exception {
		"newArrayList(new Double('-20'), new Integer('20'))".bindTypeArgumentsTo("Number & Comparable<?>").done
	}
	
	@Test def void testVarArgs_02() throws Exception {
		"newArrayList(if (true) new Double('-20') else new Integer('20'))".bindTypeArgumentsTo("Number & Comparable<?>").done
	}
	
	@Test def void testVarArgs_03() throws Exception {
		"newArrayList(if (true) new Double('-20') else new Integer('20'), new Integer('29'))".bindTypeArgumentsTo("Number & Comparable<?>").done
	}
	
	@Test def void testVarArgs_04() throws Exception {
		"newArrayList(if (true) new Double('-20') else new Integer('20'), new Double('29'))".bindTypeArgumentsTo("Number & Comparable<?>").done
	}
	
	@Test def void testVarArgs_05() throws Exception {
		"newArrayList(if (true) new Double('-20') else new Integer('20'), new Integer('29'), new Double('29'))".bindTypeArgumentsTo("Number & Comparable<?>").done
	}

	@Test def void testFeatureCall_01() throws Exception {
		"new java.util.ArrayList<String>().get(23)".bindTypeArgumentsTo("String").done
	}
	
	@Test def void testFeatureCall_02() throws Exception {
		"new testdata.ClassWithVarArgs().toList()".bindTypeArgumentsTo("Object").done
	}
	
	@Test def void testFeatureCall_03() throws Exception {
		"new testdata.ClassWithVarArgs().toList('')".bindTypeArgumentsTo("String").done
	}
	
	@Test def void testFeatureCall_04() throws Exception {
		"new testdata.ClassWithVarArgs().toList('', '')".bindTypeArgumentsTo("String").done
	}
	
	@Test def void testFeatureCall_05() throws Exception {
		"new testdata.ClassWithVarArgs().toList(null as String[])".bindTypeArgumentsTo("String").done
	}
	
	@Test def void testFeatureCall_06() throws Exception {
		"new testdata.ClassWithVarArgs().toList(null as int[])".bindTypeArgumentsTo("int[]").done
	}
	
	@Test def void testFeatureCall_07() throws Exception {
		"new testdata.ClassWithVarArgs().toList('', 1)".bindTypeArgumentsTo("Comparable<?> & Serializable").done
	}
	
	@Test def void testFeatureCall_08() throws Exception {
		"new testdata.ClassWithVarArgs().toNumberList()".bindTypeArgumentsTo("Number").done
	}
	
	@Test def void testFeatureCall_09() throws Exception {	
		"new testdata.ClassWithVarArgs().toNumberList(0)".bindTypeArgumentsTo("Integer").done
	}
	
	@Test def void testFeatureCall_10() throws Exception {
		"new testdata.ClassWithVarArgs().toNumberList(0, 1)".bindTypeArgumentsTo("Integer").done
	}
	
	@Test def void testFeatureCall_11() throws Exception {
		"new testdata.ClassWithVarArgs().toNumberList(new Integer(0), new Integer(0).doubleValue)".bindTypeArgumentsTo("Number & Comparable<?>").done
	}
	
	@Test def void testFeatureCall_12() throws Exception {
		"new testdata.ClassWithVarArgs().toNumberList(null as Float[])".bindTypeArgumentsTo("Float").done
	}
	
	@Test def void testFeatureCall_13() throws Exception {
		"newArrayList('').map(s|s)".bindTypeArgumentsTo("String").and("String", "String").done
	}
	
	@Test def void testFeatureCall_14() throws Exception {
		"newArrayList('').map [it|it]".bindTypeArgumentsTo("String").and("String", "String").done
	}
	
	@Test def void testFeatureCall_15() throws Exception {
		"newArrayList('').map [it]".bindTypeArgumentsTo("String").and("String", "String").done
	}
	
	@Test def void testFeatureCall_16() throws Exception {
		"(null as Iterable<String>).map(s|s)".bindTypeArgumentsTo("String", "String").done
	}
	
	@Test def void testFeatureCall_17() throws Exception {
		"$$ListExtensions::map(newArrayList('')) [s|s]".bindTypeArgumentsTo("String", "String").and("String").done
	}
	
	@Test def void testFeatureCall_18() throws Exception {
		"newArrayList('').map(s|s).head".bindTypeArgumentsTo("String").and("String", "String").and("String").done
	}
	
	@Test def void testFeatureCall_19() throws Exception {
		"newArrayList('').map(s|s.toString).head".bindTypeArgumentsTo("String").and("String", "String").and("String").done
	}
	
	@Test def void testFeatureCall_20() throws Exception {
		"newArrayList('').map(s|1)".bindTypeArgumentsTo("String").and("String", "Integer").done
	}
	
	@Test def void testFeatureCall_21() throws Exception {
		"newArrayList('').map(s|1).head".bindTypeArgumentsTo("String").and("String", "Integer").and("Integer").done
	}
	
	@Test def void testFeatureCall_22() throws Exception {
		"newArrayList('').map(s|s.length)".bindTypeArgumentsTo("String").and("String", "Integer").done
	}
	
	@Test def void testFeatureCall_23() throws Exception {
		"<String>newArrayList.map(s|s.length)".bindTypeArgumentsTo("String").and("String", "Integer").done
	}
	
	@Test def void testFeatureCall_24() throws Exception {
		"newArrayList('').map(s|s.length).head".bindTypeArgumentsTo("String").and("String", "Integer").and("Integer").done
	}
	
	@Test def void testFeatureCall_25() throws Exception {
		"<String>newArrayList.map(s|s.length).head".bindTypeArgumentsTo("String").and("String", "Integer").and("Integer").done
	}
	
	@Test def void testFeatureCall_26() throws Exception {
		"newArrayList('').map(s|s != null)".bindTypeArgumentsTo("String").and("String", "Boolean").done
	}
	
	@Test def void testFeatureCall_27() throws Exception {
		"newArrayList('').map(s|s.length+1)".bindTypeArgumentsTo("String").and("String", "Integer").done
	}
	
	@Test def void testFeatureCall_28() throws Exception {
		"newArrayList('').map(s|1).map(i|i+1)".bindTypeArgumentsTo("String").and("String", "Integer").and("Integer", "Integer").done
	}
	
	@Test def void testFeatureCall_29() throws Exception {
		"newArrayList('').map(s|1).toList()".bindTypeArgumentsTo("String").and("String", "Integer").and("Integer").done
	}
	
	@Test def void testFeatureCall_30() throws Exception {
		"newArrayList('').map(s|1).toList().map(i|i)".bindTypeArgumentsTo("String").and("String", "Integer").and("Integer").and("Integer", "Integer").done
	}
	
	@Test def void testFeatureCall_31() throws Exception {
		"newArrayList('').map(s|1).toList().map(i|i+1)".bindTypeArgumentsTo("String").and("String", "Integer").and("Integer").and("Integer", "Integer").done
	}
	
	@Test def void testFeatureCall_32() throws Exception {
		"{ var it = newArrayList('').map(s|1).toList() it.map(i|i+1) }".bindTypeArgumentsTo("String").and("String", "Integer").and("Integer").and("Integer", "Integer").done
	}
	
	@Test def void testFeatureCall_33() throws Exception {
		"{ var it = newArrayList('').map(s|1).toList() map(i|i+1) }".bindTypeArgumentsTo("String").and("String", "Integer").and("Integer").and("Integer", "Integer").done
	}
	
	@Test def void testFeatureCall_34() throws Exception {
		"{ var it = newArrayList('').map(s|1).toList() it }".bindTypeArgumentsTo("String").and("String", "Integer").and("Integer").done
	}
	
	@Test def void testFeatureCall_35() throws Exception {
		"{ var java.util.List<? extends Integer> it = null map(i|i+1) }".bindTypeArgumentsTo("? extends Integer", "Integer").done
	}
	
	@Test def void testFeatureCall_36() throws Exception {
		"{ var java.util.List<? extends Integer> it = null map(i|i) }".bindTypeArgumentsTo("? extends Integer", "Integer").done
	}
	
	@Test def void testFeatureCall_37() throws Exception {
		"newArrayList(newArrayList('').map(s|1))".bindTypeArgumentsTo("List<Integer>").and("String").and("String", "Integer").done
	}
	
	@Test def void testFeatureCall_38() throws Exception {
		"newArrayList(newArrayList('').map(s|1)).map(iterable|iterable.size())".bindTypeArgumentsTo("List<Integer>").and("String").and("String", "Integer").and("List<Integer>", "Integer").done	
	}
	
	@Test def void testFeatureCall_39() throws Exception {
		"newArrayList(newArrayList('')).map(iterable|iterable.size())".bindTypeArgumentsTo("ArrayList<String>").and("String").and("ArrayList<String>", "Integer").done
	}
	
	@Test def void testFeatureCall_40() throws Exception {
		"newArrayList(newArrayList('')).map(iterable|iterable.size()).head".bindTypeArgumentsTo("ArrayList<String>").and("String").and("ArrayList<String>", "Integer").and("Integer").done
	}
	
	@Test def void testFeatureCall_41() throws Exception {
		"newArrayList(newArrayList('')).map(iterable|iterable.size()).map(e|e)".bindTypeArgumentsTo("ArrayList<String>").and("String").and("ArrayList<String>", "Integer").and("Integer", "Integer").done
	}
	
	@Test def void testFeatureCall_42() throws Exception {
		"newArrayList('').map(s|1).map(i|1)".bindTypeArgumentsTo("String").and("String", "Integer").and("Integer", "Integer").done
	}
	
	@Test def void testFeatureCall_43() throws Exception {
		"newArrayList('').map(s|1).map(i|1).head".bindTypeArgumentsTo("String").and("String", "Integer").and("Integer", "Integer").and("Integer").done
	}
	
	@Test def void testFeatureCall_44() throws Exception {
		"newArrayList('').map(s|s.length).map(i|i)".bindTypeArgumentsTo("String").and("String", "Integer").and("Integer", "Integer").done
	}
	
	@Test def void testFeatureCall_45() throws Exception {
		"newArrayList('').map(s|s.length).map(i|i).head".bindTypeArgumentsTo("String").and("String", "Integer").and("Integer", "Integer").and("Integer").done
	}
	
	@Test def void testFeatureCall_46() throws Exception {
		"newArrayList('').map(s|s.length + 1 == 5).map(b|b)".bindTypeArgumentsTo("String").and("String", "Boolean").and("Boolean", "Boolean").done
	}
	@Test def void testFeatureCall_47() throws Exception {
		"newArrayList('').map(s|s.length + 1 == 5).map(b|b).head".bindTypeArgumentsTo("String").and("String", "Boolean").and("Boolean", "Boolean").and("Boolean").done
	}
	
	@Test def void testFeatureCall_48() throws Exception {
		"newArrayList('').map(s|s.length + 1 == 5).map(b| { 'length'.length b })".bindTypeArgumentsTo("String").and("String", "Boolean").and("Boolean", "Boolean").done
	}
	@Test def void testFeatureCall_49() throws Exception {
		"newArrayList('').map(s|s.length + 1 == 5).map(b| { 'length'.length b }).head".bindTypeArgumentsTo("String").and("String", "Boolean").and("Boolean", "Boolean").and("Boolean").done
	}
	
	@Test def void testFeatureCall_50() throws Exception {
		"newArrayList('').map(s|s.length + 1 == 5).map(Boolean b|!b)".bindTypeArgumentsTo("String").and("String", "Boolean").and("Boolean", "Boolean").done
	}
	@Test def void testFeatureCall_51() throws Exception {
		"newArrayList('').map(s|s.length + 1 == 5).map(Boolean b|!b).head".bindTypeArgumentsTo("String").and("String", "Boolean").and("Boolean", "Boolean").and("Boolean").done
	}
	
	@Test def void testFeatureCall_52() throws Exception {
		"newArrayList('').map(s|s.length + 1 == 5).map(b| ! b )".bindTypeArgumentsTo("String").and("String", "Boolean").and("Boolean", "Boolean").done
	}
	@Test def void testFeatureCall_53() throws Exception {
		"newArrayList('').map(s|s.length + 1 == 5).map(b| ! b ).head".bindTypeArgumentsTo("String").and("String", "Boolean").and("Boolean", "Boolean").and("Boolean").done
	}
	
	@Test def void testFeatureCall_54() throws Exception {
		"newArrayList('').map(s|s.length + 1 == 5).map(b| { !b } )".bindTypeArgumentsTo("String").and("String", "Boolean").and("Boolean", "Boolean").done
	}
	@Test def void testFeatureCall_55() throws Exception {
		"newArrayList('').map(s|s.length + 1 == 5).map(b| { !b } ).head".bindTypeArgumentsTo("String").and("String", "Boolean").and("Boolean", "Boolean").and("Boolean").done
	}
	
	@Test def void testFeatureCall_56() throws Exception {
		"newArrayList('').map(s|s.length + 1 == 5).map(b| { b.operator_not } )".bindTypeArgumentsTo("String").and("String", "Boolean").and("Boolean", "Boolean").done
	}
	@Test def void testFeatureCall_57() throws Exception {
		"newArrayList('').map(s|s.length + 1 == 5).map(b| { b.operator_not } ).head".bindTypeArgumentsTo("String").and("String", "Boolean").and("Boolean", "Boolean").and("Boolean").done
	}

	@Test def void testFeatureCall_58() throws Exception {
		("newArrayList('').map(s|" +
				"$$ObjectExtensions::operator_equals(" +
				"	$$IntegerExtensions::operator_plus(s.length,1), 5)" +
				").map(b| $$BooleanExtensions::operator_not(b) )").bindTypeArgumentsTo("String").and("String", "Boolean").and("Boolean", "Boolean").done
	}
	@Test def void testFeatureCall_59() throws Exception {
		("newArrayList('').map(s|" +
				"$$ObjectExtensions::operator_equals(" +
				"	$$IntegerExtensions::operator_plus(s.length,1), 5)" +
				").map(b| $$BooleanExtensions::operator_not(b) ).head").bindTypeArgumentsTo("String").and("String", "Boolean").and("Boolean", "Boolean").and("Boolean").done
	}
	
	@Test def void testFeatureCall_60() throws Exception {
		"newArrayList('').map(s|s.length + 1 * 5).map(b| b / 5 )".bindTypeArgumentsTo("String").and("String", "Integer").and("Integer", "Integer").done
	}
	@Test def void testFeatureCall_61() throws Exception {
		"newArrayList('').map(s|s.length + 1 * 5).map(b| b / 5 ).head".bindTypeArgumentsTo("String").and("String", "Integer").and("Integer", "Integer").and("Integer").done
	}
	
	@Test def void testFeatureCall_62() throws Exception {
		"newArrayList('').map[ length + 1 * 5 ].map [ it / 5 ].head".bindTypeArgumentsTo("String").and("String", "Integer").and("Integer", "Integer").and("Integer").done
	}
	
	@Test def void testFeatureCall_63() throws Exception {
		"newArrayList('').map[ length + 1 * 5 - length + 1 * 5 ].map [ it / 5 + 1 / it ).head".bindTypeArgumentsTo("String").and("String", "Integer").and("Integer", "Integer").and("Integer").done
	}
	
	@Test def void testFeatureCall_64() throws Exception {
		"{ val list = newArrayList(if (false) new Double('-20') else new Integer('20')).map(v|v.intValue)
           val Object o = list.head 
           list
        }".bindTypeArgumentsTo("Number & Comparable<?>").and("Number & Comparable<?>", "Integer").and("Integer").done
	}
	
	@Test def void testFeatureCall_65() throws Exception {
		"{ val list = newArrayList(if (false) new Double('-20') else new Integer('20')).map(v|v.intValue)
           val Object o = list.head 
           list.head
        }".bindTypeArgumentsTo("Number & Comparable<?>").and("Number & Comparable<?>", "Integer").and("Integer").and("Integer").done
	}
	
	@Test def void testFeatureCall_66() throws Exception {
		"{ val list = newArrayList(if (false) new Double('-20') else new Integer('20')).map(v|v.compareTo(null))
           val Object o = list.head 
           list.head
        }".bindTypeArgumentsTo("Number & Comparable<?>").and("Number & Comparable<?>", "Integer").and("Integer").and("Integer").done
	}
	
	@Test def void testFeatureCall_67() throws Exception {
		"{ val list = $$ListExtensions::map(newArrayList(if (false) new Double('-20') else new Integer('20'))) [ v|v.intValue ]
           val Object o = list.head 
           list
        }".bindTypeArgumentsTo("Number & Comparable<?>", "Integer").and("Number & Comparable<?>").and("Integer").done
	}
	
	@Test def void testFeatureCall_68() throws Exception {
		"{ val list = $$ListExtensions::map(newArrayList(null as Integer)) [ v|v.intValue ]
           val Object o = list.head 
           list
        }".bindTypeArgumentsTo("Integer", "Integer").and("Integer").and("Integer").done
	}

	@Test def void testFeatureCall_69() throws Exception {
		"{ val list = newArrayList(null as Integer).map [ v|v.intValue ]
           val Object o = list.head 
           list
        }".bindTypeArgumentsTo("Integer").and("Integer", "Integer").and("Integer").done
	}
	
	@Test def void testFeatureCall_70() throws Exception {
		"{ val list = newArrayList(null as Integer).map [ v|v.intValue ]
           val Object o = list.head 
           list.findFirst [ Number it | intValue == 0 ]
        }".bindTypeArgumentsTo("Integer").and("Integer", "Integer").and("Integer").and("Integer").done
	}
	
	@Test def void testFeatureCall_71() throws Exception {
		"{
			val list = newArrayList
			list.forall[String s | s.length > 0]
			list
		}".bindTypeArgumentsTo("String").and("String").done
	}
	
	@Test def void testFeatureCall_72() throws Exception {
		"{
			val list = newArrayList
			list.findFirst[String s | true]
			list
		}".bindTypeArgumentsTo("String").and("String").done
	}
	
	@Test def void testFeatureCall_73() throws Exception {
		"newArrayList.map[String s | s.substring(1,1) ]".bindTypeArgumentsTo("String").and("String", "String").done
	}

	@Test def void testFeatureCall_74() throws Exception {
		"newArrayList.map[ s | s.toString ]".bindTypeArgumentsTo("Object").and("Object", "String").done
	}
	
	@Test def void testFeatureCall_75() throws Exception {
		"{
			val list = newArrayList
			list.forall[ s | s.toString.length > 0 ]
			list
		}".bindTypeArgumentsTo("Object").and("Object").done
	}
	
	@Test def void testFeatureCall_76() throws Exception {
		"(1..20).map[ toString.length ].reduce[ i1,  i2 | i1 + i2 ]".bindTypeArgumentsTo("Integer", "Integer").and("Integer").done
	}
	
	@Test def void testFeatureCall_77() throws Exception {
		"newArrayList('').get(0)".bindTypeArgumentsTo("String").done
	}
	
	@Test def void testFeatureCall_78() throws Exception {
		"<String>newArrayList().get(0)".bindTypeArgumentsTo("String").done
	}
	
	@Test def void testFeatureCallWithExpectation_01() throws Exception {
		"{ val java.util.Set<java.util.Set<String>> set = newHashSet(newHashSet) set.head }".bindTypeArgumentsTo("Set<String>").and("String").and("Set<String>").done
	}
	
	@Test def void testFeatureCallWithExpectation_02() throws Exception {
		"{ val Iterable<CharSequence> set = newHashSet('') }".bindTypeArgumentsTo("CharSequence").done
	}
	
	@Test def void testFeatureCallWithExpectation_03() throws Exception {
		"{ val Iterable<CharSequence> set = newHashSet() }".bindTypeArgumentsTo("CharSequence").done
	}
	
	@Test def void testFeatureCallWithExpectation_04() throws Exception {
		"{ val java.util.List<CharSequence> set = newHashSet('') }".bindTypeArgumentsTo("CharSequence").done
	}
	
	@Test def void testFeatureCallWithExpectation_05() throws Exception {
		"{ val Iterable<? super CharSequence> set = newHashSet('') }".bindTypeArgumentsTo("CharSequence").done
	}
	
	@Test def void testFeatureCallWithExpectation_06() throws Exception {
		"{ val Iterable<? extends CharSequence> set = newHashSet('') }".bindTypeArgumentsTo("String").done
	}
	
	@Test def void testJEP101Example_01() throws Exception {
		"{ val foo.JEP101List<String> ls = foo::JEP101List::nil }".bindTypeArgumentsTo("String").done
	}
	@Test def void testJEP101Example_02() throws Exception {
		"foo::JEP101List::cons(42, foo::JEP101List::nil)".bindTypeArgumentsTo("Integer").and("Integer").done
	}
	@Test def void testJEP101Example_03() throws Exception {
		"{ val String s = foo::JEP101List::nil.head }".bindTypeArgumentsTo("String").done
	}
	
	@Test def void testToList_01() throws Exception {
		"{ val Iterable<? extends String> iter = null org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::fixedToList(iter) }".bindTypeArgumentsTo("? extends String").done
	}
	
	@Test def void testToList_02() throws Exception {
		"{ val Iterable<? super String> iter = null org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::fixedToList(iter) }".bindTypeArgumentsTo("? super String").done
	}
	
	@Test def void testToList_03() throws Exception {
		"{ val Iterable<String> iter = null org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::fixedToList(iter) }".bindTypeArgumentsTo("String").done
	}

	@Test def void testToList_04() throws Exception {
		"{ val Iterable<? extends String> iter = null org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::brokenToList(iter) }".bindTypeArgumentsTo("String").done
	}
	
	@Test def void testToList_05() throws Exception {
		"{ val Iterable<? super String> iter = null org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::brokenToList(iter) }".bindTypeArgumentsTo("Object").done
	}
	
	@Test def void testToList_06() throws Exception {
		"{ val Iterable<String> iter = null org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::brokenToList(iter) }".bindTypeArgumentsTo("String").done
	}
	
	@Test def void testToList_07() throws Exception {
		"{ val Iterable<? extends String> iter = null org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::brokenToList2(iter) }".bindTypeArgumentsTo("String").done
	}
	
	@Test def void testToList_08() throws Exception {
		"{ val Iterable<? super String> iter = null org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::brokenToList2(iter) }".bindTypeArgumentsTo("String").done
	}
	
	@Test def void testToList_09() throws Exception {
		"{ val Iterable<String> iter = null org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::brokenToList2(iter) }".bindTypeArgumentsTo("String").done
	}
	
	@Test def void testFeatureCall_Bug342134_00() throws Exception {
		"(null as java.util.List<String>).map(e|newArrayList(e)).flatten".bindTypeArgumentsTo("String", "ArrayList<String>").and("String").and("String").done
	}
	
	@Test def void testFeatureCall_Bug342134_01() throws Exception {
		"(null as java.util.List<String>).map(e|newArrayList(e)).flatten.head".bindTypeArgumentsTo("String", "ArrayList<String>").and("String").and("String").and("String").done
	}
	
	@Test def void testFeatureCall_Bug342134_02() throws Exception {
		"newArrayList('').map(e|newArrayList(e)).flatten".bindTypeArgumentsTo("String").and("String", "ArrayList<String>").and("String").and("String").done
	}
	
	@Test def void testFeatureCall_Bug342134_04() throws Exception {
		"newArrayList('').map(e|newArrayList(e))".bindTypeArgumentsTo("String").and("String", "ArrayList<String>").and("String").done
	}
	
	@Test def void testFeatureCall_Bug342134_05() throws Exception {
		"newArrayList('').map(e|newArrayList(e)).head".bindTypeArgumentsTo("String").and("String", "ArrayList<String>").and("String").and("ArrayList<String>").done
	}
	
	@Test def void testFeatureCall_Bug342134_06() throws Exception {
		"<String>newArrayList.map(e|newArrayList(e)).flatten".bindTypeArgumentsTo("String").and("String", "ArrayList<String>").and("String").and("String").done
	}
	
	@Test def void testFeatureCall_Bug342134_07() throws Exception {
		"newArrayList('').map(e|<CharSequence>newArrayList(e)).flatten".bindTypeArgumentsTo("String").and("String", "ArrayList<CharSequence>").and("CharSequence").and("CharSequence").done
	}
	
	@Test def void testFeatureCall_Bug342134_08() throws Exception {
		"newArrayList.map(String e|<String>newArrayList(e)).flatten".bindTypeArgumentsTo("String").and("String", "ArrayList<String>").and("String").and("String").done
	}
	
	@Test def void testFeatureCall_Bug342134_09() throws Exception {
		"newArrayList(newArrayList('')).flatten".bindTypeArgumentsTo("ArrayList<String>").and("String").and("String").done
	}
	
	@Test def void testFeatureCall_Bug342134_10() throws Exception {
		"<java.util.List<String>>newArrayList().flatten".bindTypeArgumentsTo("List<String>").and("String").done
	}
	
	// TODO fix the following case
	@Ignore("TODO this should work")
	@Test def void testBug_391758() throws Exception {
		"{
			val iterable = newArrayList
			iterable.fold(newArrayList) [ list , elem | null as java.util.List<String> ]
		}".bindTypeArgumentsTo("Object").and("Object", "List<String>").and("String").done
	}
	
	@Test def void testBounds_07() throws Exception {
		"{ var java.util.List<Integer> list = null list.last }".bindTypeArgumentsTo("Integer").done
	}
	
	@Test def void testBounds_08() throws Exception {
		"{ var java.util.List<? extends Integer> list = null list.last }".bindTypeArgumentsTo("? extends Integer").done
	}
	
	@Test def void testBounds_09() throws Exception {
		"{ var java.util.List<? super Integer> list = null list.last }".bindTypeArgumentsTo("? super Integer").done
	}
	
	@Test def void testBounds_10() throws Exception {
		"{ var java.util.List<Iterable<Integer>> list = null list.last }".bindTypeArgumentsTo("Iterable<Integer>").done
	}
	
	@Test def void testBounds_11() throws Exception {
		"{ var java.util.List<Iterable<Integer>> list = null list.last.last }".bindTypeArgumentsTo("Iterable<Integer>").and("Integer").done
	}
	
	@Test def void testBounds_12() throws Exception {
		"{ var java.util.List<? extends Iterable<Integer>> list = null list.last }".bindTypeArgumentsTo("? extends Iterable<Integer>").done
	}
	
	@Test def void testBounds_13() throws Exception {
		"{ var java.util.List<? extends Iterable<Integer>> list = null list.last.last }".bindTypeArgumentsTo("? extends Iterable<Integer>").and("Integer").done
	}
	
	@Test def void testBounds_14() throws Exception {
		"{ var java.util.List<Iterable<? extends Integer>> list = null list.last }".bindTypeArgumentsTo("Iterable<? extends Integer>").done
	}
	
	@Test def void testBounds_15() throws Exception {
		"{ var java.util.List<Iterable<? extends Integer>> list = null list.last.last }".bindTypeArgumentsTo("Iterable<? extends Integer>").and("? extends Integer").done
	}
	
	@Test def void testBounds_16() throws Exception {
		"{ var java.util.List<? extends Iterable<? extends Integer>> list = null list.last }".bindTypeArgumentsTo("? extends Iterable<? extends Integer>").done
	}
	
	@Test def void testBounds_17() throws Exception {
		"{ var java.util.List<? extends Iterable<? extends Integer>> list = null list.last.last }".bindTypeArgumentsTo("? extends Iterable<? extends Integer>").and("? extends Integer").done
	}
	
	@Test def void testBounds_18() throws Exception {
		"{ var java.util.List<Iterable<? super Integer>> list = null list.last }".bindTypeArgumentsTo("Iterable<? super Integer>").done
	}
	
	@Test def void testBounds_19() throws Exception {
		"{ var java.util.List<Iterable<? super Integer>> list = null list.last.last }".bindTypeArgumentsTo("Iterable<? super Integer>").and("? super Integer").done
	}
	
	@Test def void testBounds_20() throws Exception {
		"{ var java.util.List<? extends Iterable<? super Integer>> list = null list.last }".bindTypeArgumentsTo("? extends Iterable<? super Integer>").done
	}
	
	@Test def void testBounds_21() throws Exception {
		"{ var java.util.List<? extends Iterable<? super Integer>> list = null list.last.last }".bindTypeArgumentsTo("? extends Iterable<? super Integer>").and("? super Integer").done
	}
	
	@Test def void testImplicitReceiverBounds_07() throws Exception {
		"{ var java.util.List<Integer> it = null last }".bindTypeArgumentsTo("Integer").done
	}
	
	@Test def void testImplicitReceiverBounds_08() throws Exception {
		"{ var java.util.List<? extends Integer> it = null last }".bindTypeArgumentsTo("? extends Integer").done
	}
	
	@Test def void testImplicitReceiverBounds_09() throws Exception {
		"{ var java.util.List<? super Integer> it = null last }".bindTypeArgumentsTo("? super Integer").done
	}
	
	@Test def void testReceiverIsPartiallyResolved_01() throws Exception {
		"newArrayList.get(0)".bindTypeArgumentsTo("Object").done
	}
	
	@Test def void testReceiverIsPartiallyResolved_02() throws Exception {
		"newArrayList.toString".bindTypeArgumentsTo("Object").done
	}
	
	@Test def void testTypeByTransitiveExpectation_02() throws Exception {
		"newArrayList.subList(1,1).subList(1,1).head".bindTypeArgumentsTo("Object").and("Object").done
	}

	@Test def void testExpectationActualMismatch_01() throws Exception {
		"(null as java.util.ArrayList<Integer>).add(println(null as Double))".bindTypeArgumentsTo("Double").done
	}
	
	@Test def void testExpectationActualMismatch_02() throws Exception {
		"{
			val list = newArrayList
			list.add(null as Integer)
			list.get(0).toString
			list.add(println(null as Double))
		}".bindTypeArgumentsTo("Integer").and("Double").done
	}
	
	@Test def void testDependentTypeArgumentResolution_01() throws Exception {
		"{
			var Iterable<CharSequence> from = null
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::copyIntoList(from, newArrayList)
		}".bindTypeArgumentsTo("CharSequence").and("CharSequence").done
	}
	
	@Test def void testDependentTypeArgumentResolution_02() throws Exception {
		"{
			var Iterable<? extends CharSequence> from = null
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::copyIntoList(from, newArrayList)
		}".bindTypeArgumentsTo("? extends CharSequence").and("CharSequence").done
	}
	
	@Test def void testDependentTypeArgumentResolution_03() throws Exception {
		"{
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::copyIntoList(null, newArrayList)
		}".bindTypeArgumentsTo("Object").and("Object").done
	}
	
	@Test def void testDependentTypeArgumentResolution_04() throws Exception {
		"{
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::<String>copyIntoList(null, newArrayList)
		}".bindTypeArgumentsTo("String").and("String").done
	}
	
	@Test def void testDependentTypeArgumentResolution_05() throws Exception {
		"{
			var Iterable<? super CharSequence> from = null
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::copyIntoList(from, newArrayList)
		}".bindTypeArgumentsTo("? super CharSequence").and("Object").done
	}
	
	@Test def void testDependentTypeArgumentResolution_06() throws Exception {
		"{
			var Iterable<String> from = null
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::constrainedCopyIntoList(from, newArrayList)
		}".bindTypeArgumentsTo("String").and("String").done
	}
	
	@Test def void testDependentTypeArgumentResolution_07() throws Exception {
		"{
			var Iterable<? extends String> from = null
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::constrainedCopyIntoList(from, newArrayList)
		}".bindTypeArgumentsTo("? extends String").and("String").done
	}
	
	@Test def void testDependentTypeArgumentResolution_08() throws Exception {
		"{
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::constrainedCopyIntoList(null, newArrayList)
		}".bindTypeArgumentsTo("Serializable").and("Serializable").done
	}
	
	@Test def void testDependentTypeArgumentResolution_09() throws Exception {
		"{
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::<String>constrainedCopyIntoList(null, newArrayList)
		}".bindTypeArgumentsTo("String").and("String").done
	}
	
	@Test def void testDependentTypeArgumentResolution_10() throws Exception {
		"{
			var Iterable<? super String> from = null
			org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::constrainedCopyIntoList(from, newArrayList)
		}".bindTypeArgumentsTo("? super String").and("Object").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_001() throws Exception {
		"newArrayList".bindTypeArgumentsTo("Object").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_002() throws Exception {
		"{
			val list = newArrayList
			val String s = list.get(0)
			list
		}".bindTypeArgumentsTo("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_003() throws Exception {
		"{
			val list = newArrayList
			val String s = list.head
			list
		}".bindTypeArgumentsTo("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_004() throws Exception {
		"{
			val list = newArrayList
			list.add('')
			list
		}".bindTypeArgumentsTo("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_005() throws Exception {
		"{
			val list = newArrayList
			$$CollectionExtensions::addAll(list, null as java.util.ArrayList<String>)
			list
		}".bindTypeArgumentsTo("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_006() throws Exception {
		"{
			val list = newArrayList
			$$CollectionExtensions::addAll(list, '', '')
			list
		}".bindTypeArgumentsTo("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_007() throws Exception {
		"{
			val list = newArrayList
			list.addAll(null as java.util.ArrayList<String>)
			list
		}".bindTypeArgumentsTo("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_008() throws Exception {
		"{
			val list = newArrayList
			$$CollectionExtensions::addAll(list, null as java.util.ArrayList<String>)
			list.head
		}".bindTypeArgumentsTo("String").and("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_009() throws Exception {
		"{
			val list = newArrayList
			list.addAll(newHashSet(''))
			list
		}".bindTypeArgumentsTo("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_010() throws Exception {
		"{
			val list = newArrayList
			list.addAll(null as java.util.Collection<String>)
			list
		}".bindTypeArgumentsTo("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_011() throws Exception {
		"{
			val list = newArrayList
			list.addAll('', '', '')
			list
		}".bindTypeArgumentsTo("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_012() throws Exception {
		"{
			val list = newArrayList
			val secondList = newArrayList
			list.add('')
			list.addAll(secondList)
			secondList
		}".bindTypeArgumentsTo("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_013() throws Exception {
		"{
			val list = newArrayList
			val secondList = newArrayList
			list.addAll(secondList)
			list.add('')
			secondList
		}".bindTypeArgumentsTo("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_014() throws Exception {
		"{
			val list = newArrayList
			val Iterable<String> sublist = list.subList(1, 1)
			list
		}".bindTypeArgumentsTo("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_015() throws Exception {
		"{
			val list = newArrayList
			val java.util.Set<String> sublist = list.subList(1, 1)
			list
		}".bindTypeArgumentsTo("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_016() throws Exception {
		"{
			val list = newArrayList
			val java.util.Iterator<String> sublist = list.subList(1, 1).iterator
			list
		}".bindTypeArgumentsTo("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_017() throws Exception {
		"{
			val list = newArrayList
			for(String s: list.subList(1, 1)) {}
			list
		}".bindTypeArgumentsTo("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_018() throws Exception {
		"{
			val list = newArrayList
			list.add(new Integer(0))
			list.add(new Integer(0).doubleValue)
			list
		}".bindTypeArgumentsTo("Number & Comparable<?>").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_019() throws Exception {
		"{
			val list = newArrayList
			list.add(new Integer(0))
			list.get(0).toString
			list.add(new Integer(0).doubleValue)
			list
		}".bindTypeArgumentsTo("Integer").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_020() throws Exception {
		"{
			val list = newArrayList
			val second = newArrayList
			list.add(second.get(0))
			list.add('')
			list
		}".bindTypeArgumentsTo("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_021() throws Exception {
		"{
			val list = newArrayList
			val second = newArrayList
			list.add(second.get(0))
			list.add('')
			second
		}".bindTypeArgumentsTo("String").and("String").done
	}

	@Test def void testDeferredTypeArgumentResolution_022() throws Exception {
		"{
			val list = newArrayList
			val second = newArrayList
			list.add(second.head)
			list.add('')
			list
		}".bindTypeArgumentsTo("String").and("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_023() throws Exception {
		"{
			val list = newArrayList
			val second = newArrayList
			list.add(second.head)
			list.add('')
			second
		}".bindTypeArgumentsTo("String").and("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_024() throws Exception {
		"{
			val list = newArrayList
			val second = newArrayList
			list.add('')
			list.add(second.get(0))
			list
		}".bindTypeArgumentsTo("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_025() throws Exception {
		"{
			val list = newArrayList
			val second = newArrayList
			list.add('')
			list.add(second.get(0))
			second
		}".bindTypeArgumentsTo("String").and("String").done
	}

	@Test def void testDeferredTypeArgumentResolution_026() throws Exception {
		"{
			val list = newArrayList
			val second = newArrayList
			list.add('')
			list.add(second.head)
			list
		}".bindTypeArgumentsTo("String").and("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_027() throws Exception {
		"{
			val list = newArrayList
			val second = newArrayList
			list.add('')
			list.add(second.head)
			second
		}".bindTypeArgumentsTo("String").and("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_028() throws Exception {
		"{
			val list = newArrayList
			val second = newArrayList
			list.add(second.get(0))
			second.add('')
			list
		}".bindTypeArgumentsTo("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_029() throws Exception {
		"{
			val list = newArrayList
			val second = newArrayList
			list.add(second.get(0))
			second.add('')
			second
		}".bindTypeArgumentsTo("String").and("String").done
	}

	@Test def void testDeferredTypeArgumentResolution_030() throws Exception {
		"{
			val list = newArrayList
			val second = newArrayList
			list.add(second.head)
			second.add('')
			list
		}".bindTypeArgumentsTo("String").and("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_031() throws Exception {
		"{
			val list = newArrayList
			val second = newArrayList
			list.add(second.head)
			second.add('')
			second
		}".bindTypeArgumentsTo("String").and("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_032() throws Exception {
		"{
			val list = newArrayList
			val second = newArrayList
			second.add('')
			list.add(second.get(0))
			list
		}".bindTypeArgumentsTo("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_033() throws Exception {
		"{
			val list = newArrayList
			val second = newArrayList
			second.add('')
			list.add(second.get(0))
			second
		}".bindTypeArgumentsTo("String").and("String").done
	}

	@Test def void testDeferredTypeArgumentResolution_034() throws Exception {
		"{
			val list = newArrayList
			val second = newArrayList
			second.add('')
			list.add(second.head)
			list
		}".bindTypeArgumentsTo("String").and("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_035() throws Exception {
		"{
			val list = newArrayList
			val second = newArrayList
			second.add('')
			list.add(second.head)
			second
		}".bindTypeArgumentsTo("String").and("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_036() throws Exception {
		"{
			val list = newArrayList(newArrayList)
			val Iterable<String> s = list.head
			list.head
		}".bindTypeArgumentsTo("ArrayList<String>").and("String").and("ArrayList<String>").and("ArrayList<String>").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_037() throws Exception {
		"{
			val list = newArrayList(newArrayList)
			val Iterable<String> s = list.flatten
			list.head
		}".bindTypeArgumentsTo("ArrayList<String>").and("String").and("String").and("ArrayList<String>").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_041() throws Exception {
		"{
			val list = newArrayList
			list.addAll('')
			list
		}".bindTypeArgumentsTo("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_042() throws Exception {
		"{
			val list = newArrayList
			val secondList = newArrayList
			list.addAll('')
			list.addAll(secondList)
			secondList
		}".bindTypeArgumentsTo("String").and("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_043() throws Exception {
		"{
			val list = newArrayList
			val secondList = newArrayList
			list.addAll(secondList)
			list.addAll('')
			secondList
		}".bindTypeArgumentsTo("String").and("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_044() throws Exception {
		"{
			val list = newArrayList
			list.addAll('', '', '')
			list.head
		}".bindTypeArgumentsTo("String").and("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_045() throws Exception {
		"{
			val list = newArrayList
			val secondList = newArrayList
			list.addAll('', '', '')
			list.addAll(secondList)
			secondList
		}".bindTypeArgumentsTo("String").and("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_046() throws Exception {
		"{
			val list = newArrayList
			val secondList = newArrayList
			list.addAll(secondList)
			list.addAll('', '', '')
			secondList
		}".bindTypeArgumentsTo("String").and("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_047() throws Exception {
		"println(newArrayList)".bindTypeArgumentsTo("ArrayList<Object>").and("Object").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_048() throws Exception {
		"{
			val list = newArrayList
			val String s = println(list.get(0))
			list
		}".bindTypeArgumentsTo("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_049() throws Exception {
		"{
			val list = newArrayList
			val String s = println(println(list).head)
			list
		}".bindTypeArgumentsTo("String").and("String").and("ArrayList<String>").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_050() throws Exception {
		"{
			val list = newArrayList
			println(list).add('')
			list
		}".bindTypeArgumentsTo("String").and("ArrayList<String>").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_051() throws Exception {
		"{
			val list = newArrayList
			$$CollectionExtensions::addAll(println(list), null as java.util.ArrayList<String>)
			list
		}".bindTypeArgumentsTo("String").and("String").and("ArrayList<String>").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_053() throws Exception {
		"{
			val list = newArrayList
			println(list).addAll(null as java.util.ArrayList<String>)
			list
		}".bindTypeArgumentsTo("String").and("ArrayList<String>").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_057() throws Exception {
		"{
			val list = newArrayList
			println(list).addAll('', '', '')
			list
		}".bindTypeArgumentsTo("String").and("ArrayList<String>").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_060() throws Exception {
		"{
			val list = newArrayList
			val Iterable<String> sublist = println(println(list).subList(1, 1))
			list
		}".bindTypeArgumentsTo("String").and("List<String>").and("ArrayList<String>").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_061() throws Exception {
		"{
			val list = newArrayList
			val java.util.Set<String> sublist = println(println(list).subList(1, 1))
			list
		}".bindTypeArgumentsTo("String").and("List<String>").and("ArrayList<String>").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_062() throws Exception {
		"{
			val list = newArrayList
			val java.util.Iterator<String> sublist = println(println(println(list).subList(1, 1)).iterator)
			list
		}".bindTypeArgumentsTo("String").and("Iterator<String>").and("List<String>").and("ArrayList<String>").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_063() throws Exception {
		"{
			val list = println(newArrayList)
			for(String s: println(list.subList(1, 1))) {}
			list
		}".bindTypeArgumentsTo("ArrayList<String>").and("String").and("List<String>").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_064() throws Exception {
		"{
			val list = newArrayList
			list.add(println(new Integer(0)))
			list.add(println(new Integer(0).doubleValue))
			list
		}".bindTypeArgumentsTo("Number & Comparable<?>").and("Integer").and("Double").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_065() throws Exception {
		"{
			val list = newArrayList
			list.add(println(new Integer(0)))
			println(list.get(0)).toString
			list.add(println(new Integer(0).doubleValue))
			list
		}".bindTypeArgumentsTo("Integer").and("Integer").and("Integer").and("Double").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_067() throws Exception {
		"new java.util.ArrayList".bindTypeArgumentsTo("Object").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_068() throws Exception {
		"{
			val list = new java.util.ArrayList
			val String s = list.get(0)
			list
		}".bindTypeArgumentsTo("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_069() throws Exception {
		"{
			val list = new java.util.ArrayList
			val String s = list.head
			list
		}".bindTypeArgumentsTo("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_070() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.add('')
			list
		}".bindTypeArgumentsTo("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_071() throws Exception {
		"{
			val list = new java.util.ArrayList
			$$CollectionExtensions::addAll(list, null as java.util.ArrayList<String>)
			list
		}".bindTypeArgumentsTo("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_072() throws Exception {
		"{
			val list = new java.util.ArrayList
			$$CollectionExtensions::addAll(list, '', '')
			list
		}".bindTypeArgumentsTo("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_073() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.addAll(null as java.util.ArrayList<String>)
			list
		}".bindTypeArgumentsTo("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_074() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.addAll(new java.util.ArrayList<String>)
			list
		}".bindTypeArgumentsTo("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_075() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.addAll(newHashSet(''))
			list
		}".bindTypeArgumentsTo("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_076() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.addAll(null as java.util.Collection<String>)
			list
		}".bindTypeArgumentsTo("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_077() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.addAll('', '', '')
			list.head
		}".bindTypeArgumentsTo("String").and("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_078() throws Exception {
		"{
			val list = new java.util.ArrayList
			val secondList = new java.util.ArrayList
			list.add('')
			list.addAll(secondList)
			secondList
		}".bindTypeArgumentsTo("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_079() throws Exception {
		"{
			val list = new java.util.ArrayList
			val secondList = new java.util.ArrayList
			list.addAll(secondList)
			list.add('')
			secondList
		}".bindTypeArgumentsTo("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_080() throws Exception {
		"{
			val list = new java.util.ArrayList
			val Iterable<String> sublist = list.subList(1, 1)
			list
		}".bindTypeArgumentsTo("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_081() throws Exception {
		"{
			val list = new java.util.ArrayList
			val java.util.Set<String> sublist = list.subList(1, 1)
			list
		}".bindTypeArgumentsTo("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_082() throws Exception {
		"{
			val list = new java.util.ArrayList
			val java.util.Iterator<String> sublist = list.subList(1, 1).iterator
			list
		}".bindTypeArgumentsTo("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_083() throws Exception {
		"{
			val list = new java.util.ArrayList
			for(String s: list.subList(1, 1)) {}
			list
		}".bindTypeArgumentsTo("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_084() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.add(new Integer(0))
			list.add(new Integer(0).doubleValue)
			list
		}".bindTypeArgumentsTo("Number & Comparable<?>").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_085() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.add(new Integer(0))
			list.get(0).toString
			list.add(new Integer(0).doubleValue)
			list
		}".bindTypeArgumentsTo("Integer").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_086() throws Exception {
		"{
			val list = new java.util.ArrayList
			val second = new java.util.ArrayList
			list.add(second.get(0))
			list.add('')
			list
		}".bindTypeArgumentsTo("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_087() throws Exception {
		"{
			val list = new java.util.ArrayList
			val second = new java.util.ArrayList
			list.add(second.get(0))
			list.add('')
			second
		}".bindTypeArgumentsTo("String").and("String").done
	}

	@Test def void testDeferredTypeArgumentResolution_088() throws Exception {
		"{
			val list = new java.util.ArrayList
			val second = new java.util.ArrayList
			list.add(second.head)
			list.add('')
			list
		}".bindTypeArgumentsTo("String").and("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_089() throws Exception {
		"{
			val list = new java.util.ArrayList
			val second = new java.util.ArrayList
			list.add(second.head)
			list.add('')
			second
		}".bindTypeArgumentsTo("String").and("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_090() throws Exception {
		"{
			val list = new java.util.ArrayList
			val second = new java.util.ArrayList
			list.add('')
			list.add(second.get(0))
			list
		}".bindTypeArgumentsTo("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_091() throws Exception {
		"{
			val list = new java.util.ArrayList
			val second = new java.util.ArrayList
			list.add('')
			list.add(second.get(0))
			second
		}".bindTypeArgumentsTo("String").and("String").done
	}

	@Test def void testDeferredTypeArgumentResolution_092() throws Exception {
		"{
			val list = new java.util.ArrayList
			val second = new java.util.ArrayList
			list.add('')
			list.add(second.head)
			list
		}".bindTypeArgumentsTo("String").and("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_093() throws Exception {
		"{
			val list = new java.util.ArrayList
			val second = new java.util.ArrayList
			list.add('')
			list.add(second.head)
			second
		}".bindTypeArgumentsTo("String").and("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_094() throws Exception {
		"{
			val list = new java.util.ArrayList
			val second = new java.util.ArrayList
			list.add(second.get(0))
			second.add('')
			list
		}".bindTypeArgumentsTo("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_095() throws Exception {
		"{
			val list = new java.util.ArrayList
			val second = new java.util.ArrayList
			list.add(second.get(0))
			second.add('')
			second
		}".bindTypeArgumentsTo("String").and("String").done
	}

	@Test def void testDeferredTypeArgumentResolution_096() throws Exception {
		"{
			val list = new java.util.ArrayList
			val second = new java.util.ArrayList
			list.add(second.head)
			second.add('')
			list
		}".bindTypeArgumentsTo("String").and("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_097() throws Exception {
		"{
			val list = new java.util.ArrayList
			val second = new java.util.ArrayList
			list.add(second.head)
			second.add('')
			second
		}".bindTypeArgumentsTo("String").and("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_098() throws Exception {
		"{
			val list = new java.util.ArrayList
			val second = new java.util.ArrayList
			second.add('')
			list.add(second.get(0))
			list
		}".bindTypeArgumentsTo("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_099() throws Exception {
		"{
			val list = new java.util.ArrayList
			val second = new java.util.ArrayList
			second.add('')
			list.add(second.get(0))
			second
		}".bindTypeArgumentsTo("String").and("String").done
	}

	@Test def void testDeferredTypeArgumentResolution_100() throws Exception {
		"{
			val list = new java.util.ArrayList
			val second = new java.util.ArrayList
			second.add('')
			list.add(second.head)
			list
		}".bindTypeArgumentsTo("String").and("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_101() throws Exception {
		"{
			val list = new java.util.ArrayList
			val second = new java.util.ArrayList
			second.add('')
			list.add(second.head)
			second
		}".bindTypeArgumentsTo("String").and("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_102() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.add(new java.util.HashSet)
			val Iterable<String> s = list.head
			list.head
		}".bindTypeArgumentsTo("HashSet<String>").and("String").and("HashSet<String>").and("HashSet<String>").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_103() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.add(new java.util.ArrayList)
			val Iterable<String> s = list.flatten
			list.head
		}".bindTypeArgumentsTo("ArrayList<String>").and("String").and("String").and("ArrayList<String>").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_107() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.addAll('')
			list
		}".bindTypeArgumentsTo("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_108() throws Exception {
		"{
			val list = new java.util.ArrayList
			val secondList = new java.util.ArrayList
			list.addAll('')
			list.addAll(secondList)
			secondList
		}".bindTypeArgumentsTo("String").and("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_109() throws Exception {
		"{
			val list = new java.util.ArrayList
			val secondList = new java.util.ArrayList
			list.addAll(secondList)
			list.addAll('')
			secondList
		}".bindTypeArgumentsTo("String").and("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_110() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.addAll('', '', '')
			list
		}".bindTypeArgumentsTo("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_111() throws Exception {
		"{
			val list = new java.util.ArrayList
			val secondList = new java.util.ArrayList
			list.addAll('', '', '')
			list.addAll(secondList)
			secondList
		}".bindTypeArgumentsTo("String").and("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_112() throws Exception {
		"{
			val list = new java.util.ArrayList
			val secondList = new java.util.ArrayList
			list.addAll(secondList)
			list.addAll('', '', '')
			secondList
		}".bindTypeArgumentsTo("String").and("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_113() throws Exception {
		"println(new java.util.ArrayList)".bindTypeArgumentsTo("ArrayList<Object>").and("Object").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_114() throws Exception {
		"{
			val list = new java.util.ArrayList
			val String s = println(list.get(0))
			list
		}".bindTypeArgumentsTo("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_115() throws Exception {
		"{
			val list = new java.util.ArrayList
			val String s = println(println(list).head)
			list
		}".bindTypeArgumentsTo("String").and("String").and("ArrayList<String>").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_116() throws Exception {
		"{
			val list = new java.util.ArrayList
			println(list).add('')
			list
		}".bindTypeArgumentsTo("String").and("ArrayList<String>").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_117() throws Exception {
		"{
			val list = new java.util.ArrayList
			$$CollectionExtensions::addAll(println(list), null as java.util.ArrayList<String>)
			list
		}".bindTypeArgumentsTo("String").and("String").and("ArrayList<String>").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_118() throws Exception {
		"{
			val list = new java.util.ArrayList
			$$CollectionExtensions::addAll(println(list), println(''), println(''))
			list
		}".bindTypeArgumentsTo("String").and("String").and("ArrayList<String>").and("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_119() throws Exception {
		"{
			val list = new java.util.ArrayList
			println(list).addAll(null as java.util.ArrayList<String>)
			list
		}".bindTypeArgumentsTo("String").and("ArrayList<String>").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_123() throws Exception {
		"{
			val list = new java.util.ArrayList
			println(list).addAll('', '', '')
			list
		}".bindTypeArgumentsTo("String").and("ArrayList<String>").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_126() throws Exception {
		"{
			val list = new java.util.ArrayList
			val Iterable<String> sublist = println(println(list).subList(1, 1))
			list
		}".bindTypeArgumentsTo("String").and("List<String>").and("ArrayList<String>").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_127() throws Exception {
		"{
			val list = new java.util.ArrayList
			val java.util.Set<String> sublist = println(println(list).subList(1, 1))
			list
		}".bindTypeArgumentsTo("String").and("List<String>").and("ArrayList<String>").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_128() throws Exception {
		"{
			val list = new java.util.ArrayList
			val java.util.Iterator<String> sublist = println(println(println(list).subList(1, 1)).iterator)
			list
		}".bindTypeArgumentsTo("String").and("Iterator<String>").and("List<String>").and("ArrayList<String>").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_129() throws Exception {
		"{
			val list = println(new java.util.ArrayList)
			for(String s: println(list.subList(1, 1))) {}
			list
		}".bindTypeArgumentsTo("ArrayList<String>").and("String").and("List<String>").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_130() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.add(println(new Integer(0)))
			list.add(println(new Integer(0).doubleValue))
			list
		}".bindTypeArgumentsTo("Number & Comparable<?>").and("Integer").and("Double").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_131() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.add(println(new Integer(0)))
			println(list.get(0)).toString
			list.add(println(new Integer(0).doubleValue))
			list
		}".bindTypeArgumentsTo("Integer").and("Integer").and("Integer").and("Double").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_133() throws Exception {
		"{
			val list = newArrayList
			val fun = [String s| s]
			list.map(fun)
			list
		}".bindTypeArgumentsTo("String").and("String", "String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_134() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.map[String s| s]
			list
		}".bindTypeArgumentsTo("String").and("String", "String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_135() throws Exception {
		"{
			val list = newArrayList
			list.add(newArrayList)
			val Iterable<String> s = list.head
			list.head
		}".bindTypeArgumentsTo("ArrayList<String>").and("String").and("ArrayList<String>").and("ArrayList<String>").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_136() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.add(new java.util.ArrayList)
			val Iterable<String> s = list.head
			list.head
		}".bindTypeArgumentsTo("ArrayList<String>").and("String").and("ArrayList<String>").and("ArrayList<String>").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_137() throws Exception {
		"{
			val list = newArrayList
			$$CollectionExtensions::<String>addAll(println(list), null, null)
			list
		}".bindTypeArgumentsTo("String").and("String").and("ArrayList<String>").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_138() throws Exception {
		"{
			val list = newArrayList
			$$CollectionExtensions::<String>addAll(list, null, null)
			list
		}".bindTypeArgumentsTo("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_139() throws Exception {
		"{
			val list = newArrayList
			$$CollectionExtensions::<String>addAll(println(list), '', '')
			list
		}".bindTypeArgumentsTo("String").and("String").and("ArrayList<String>").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_143() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.add(new java.util.ArrayList)
			val Iterable<String> s = $$IterableExtensions::head(list)
			list.head
		}".bindTypeArgumentsTo("ArrayList<String>").and("String").and("ArrayList<String>").and("ArrayList<String>").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_148() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.add(new java.util.ArrayList)
			val Iterable<String> s = $$IterableExtensions::flatten(list)
			list.head
		}".bindTypeArgumentsTo("ArrayList<String>").and("String").and("String").and("ArrayList<String>").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_149() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.add(newHashSet)
			val String s = $$IterableExtensions::flatten(list).head
			list.head
		}".bindTypeArgumentsTo("HashSet<String>").and("String").and("String").and("String").and("HashSet<String>").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_150() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.add(new java.util.ArrayList)
			val String s = $$IterableExtensions::flatten(list).head
			list.head
		}".bindTypeArgumentsTo("ArrayList<String>").and("String").and("String").and("String").and("ArrayList<String>").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_152() throws Exception {
		"{
			val list = newArrayList
			list.map[String s| s]
			list
		}".bindTypeArgumentsTo("String").and("String", "String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_153() throws Exception {
		"{
			val list = newArrayList
			$$IterableExtensions::map(list, [String s| s])
			list
		}".bindTypeArgumentsTo("String").and("String", "String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_154() throws Exception {
		"{
			val list = newArrayList
			val fun = [String s| s]
			$$IterableExtensions::map(list, fun)
			list
		}".bindTypeArgumentsTo("String").and("String", "String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_155() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.map(println([String s| println(s)]))
			list
		}".bindTypeArgumentsTo("String").and("String", "String").and("(String)=>String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_156() throws Exception {
		"{
			val list = newArrayList
			list.addAll(null as java.util.ArrayList<String>)
			list.head
		}".bindTypeArgumentsTo("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_157() throws Exception {
		"{
			val list = newArrayList
			list.addAll(newArrayList(''))
			list
		}".bindTypeArgumentsTo("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_158() throws Exception {
		"{
			val list = newArrayList
			list.addAll(null as String[])
			list
		}".bindTypeArgumentsTo("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_159() throws Exception {
		"{
			val list = newArrayList
			val secondList = newArrayList
			list.addAll(null as String[])
			list.addAll(secondList)
			secondList
		}".bindTypeArgumentsTo("String").and("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_160() throws Exception {
		"{
			val list = newArrayList
			val secondList = newArrayList
			list.addAll(secondList)
			list.addAll(null as String[])
			secondList
		}".bindTypeArgumentsTo("String").and("String").and("String").done
	}
	
	@Test def void testDeferredTypeArgumentResolution_161() throws Exception {
		"{
			val list = newArrayList
			list.add(null as Integer)
			list.get(0)
			list.add(println(null as Double))
		}".bindTypeArgumentsTo("Number & Comparable<?>").and("Double").done
	}
	
	@Test def void testRecursiveTypeArgumentResolution_01() throws Exception {
		"{
			val list = newArrayList
			list.addAll(list)
			list
		}".bindTypeArgumentsTo("Object").done
	}
	
	@Test def void testRecursiveTypeArgumentResolution_02() throws Exception {
		"{
			val list = newArrayList
			list.add(list.head)
			list
		}".bindTypeArgumentsTo("Object").and("Object").done
	}
	
	@Test def void testRecursiveTypeArgumentResolution_03() throws Exception {
		"{
			val list = newArrayList
			list.addAll(list)
			list.add('')
			list
		}".bindTypeArgumentsTo("String").done
	}
	
	@Test def void testRecursiveTypeArgumentResolution_04() throws Exception {
		"{
			val list = newArrayList
			list.add(list.head)
			list.add('')
			list
		}".bindTypeArgumentsTo("String").and("String").done
	}
	
	@Test def void testRecursiveTypeArgumentResolution_05() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.addAll(list)
			list
		}".bindTypeArgumentsTo("Object").done
	}
	
	@Test def void testRecursiveTypeArgumentResolution_06() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.add(list.head)
			list
		}".bindTypeArgumentsTo("Object").and("Object").done
	}
	
	@Test def void testRecursiveTypeArgumentResolution_07() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.addAll(list)
			list.add('')
			list
		}".bindTypeArgumentsTo("String").done
	}
	
	@Test def void testRecursiveTypeArgumentResolution_08() throws Exception {
		"{
			val list = new java.util.ArrayList
			list.add(list.head)
			list.add('')
			list
		}".bindTypeArgumentsTo("String").and("String").done
	}
	
	@Test def void testFeatureCallWithOperatorOverloading_1() throws Exception {
		"{ 
			val java.util.List<? super CharSequence> list = null
			list += null as Iterable<CharSequence>
		}".bindTypeArgumentsTo("? super CharSequence").done
	}
	
	@Test def void testFeatureCallWithOperatorOverloading_2() throws Exception {
		"new java.util.ArrayList<Byte>() += 'x'.getBytes().iterator.next".bindTypeArgumentsTo("Byte").and("Byte").done
	}
	
	@Test def void testFeatureCallWithOperatorOverloading_3() throws Exception {
		"new java.util.ArrayList<Byte>() += null".bindTypeArgumentsTo("Byte").and("Byte").done
	}
	
	@Test def void testFeatureCallWithOperatorOverloading_4() throws Exception {
		"new java.util.ArrayList<Byte>() += newArrayList('x'.getBytes().iterator.next)".bindTypeArgumentsTo("Byte").and("Byte").and("Byte").done
	}
	
	@Test def void testFeatureCallWithOperatorOverloading_5() throws Exception {
		"new java.util.ArrayList<Byte>() += 'x'.getBytes()".bindTypeArgumentsTo("Byte").and("Byte").done
	}
	
	@Test def void testStaticMethods_01() throws Exception {
		"newArrayList('')".bindTypeArgumentsTo("String").done
	}
	
	@Test def void testStaticMethods_02() throws Exception {
		"newArrayList('', '')".bindTypeArgumentsTo("String").done
	}
	
	@Test def void testStaticMethods_03() throws Exception {
		"newArrayList(newHashSet(''))".bindTypeArgumentsTo("HashSet<String>").and("String").done
	}
	
	@Test def void testStaticMethods_04() throws Exception {
		"newArrayList()".bindTypeArgumentsTo("Object").done
	}
	
	@Test def void testStaticMethods_05() throws Exception {
		"newHashMap()".bindTypeArgumentsTo("Object", "Object").done
	}
	
	@Ignore("TODO fix me")
	@Test def void testJava8Inferrence_01() throws Exception {
		"{ val Iterable<Iterable<Number>> l = java.util.Collections.singleton(java.util.Collections.singleton(1)) }".bindTypeArgumentsTo("Iterable<Number>").and("Number").done
	}
	
}
