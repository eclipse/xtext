/**
 * Copyright (c) 2012, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.JavaRuntimeVersion;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractIdentifiableTypeTest extends AbstractXbaseTestCase {
	public abstract void resolvesIdentifiablesTo(String expression, String... types) throws Exception;

	private static Set<String> seenExpressions;

	@BeforeClass
	public static void createSeenExpressionsSet() {
		AbstractIdentifiableTypeTest.seenExpressions = CollectionLiterals.<String> newHashSet();
	}

	@AfterClass
	public static void discardSeenExpressions() {
		AbstractIdentifiableTypeTest.seenExpressions = null;
	}

	protected List<JvmIdentifiableElement> findIdentifiables(XExpression expression) {
		Iterator<List<? extends EObject>> objects = IteratorExtensions.map(EcoreUtil2.eAll(expression), (EObject it) -> {
			if (it instanceof XClosure) {
				return ((XClosure) it).getImplicitFormalParameters();
			} else {
				return Lists.newArrayList(it);
			}
		});
		List<JvmIdentifiableElement> identifiables = IterableExtensions.toList(Iterables.filter(IterableExtensions.filter(
				IterableExtensions.toSet(Iterables.concat(IteratorExtensions.<List<? extends EObject>> toIterable(objects))),
				(EObject it) -> {
					if (it == null) {
						return false;
					} else {
						if (it instanceof XVariableDeclaration) {
							return true;
						} else if (it instanceof JvmFormalParameter) {
							return true;
						} else {
							return false;
						}
					}
				}), JvmIdentifiableElement.class));
		return IterableExtensions.sortBy(identifiables, (JvmIdentifiableElement it) -> {
			ICompositeNode node = NodeModelUtils.findActualNodeFor(it);
			if (node != null) {
				return node.getOffset();
			} else {
				return NodeModelUtils.findActualNodeFor(it.eContainer()).getOffset();
			}
		});
	}

	@Override
	protected XExpression expression(CharSequence expression, boolean resolve) throws Exception {
		String string = expression.toString();
		if (!AbstractIdentifiableTypeTest.seenExpressions.add(string)) {
			Assert.fail("Duplicate expression under test: " + expression);
		}
		return super.expression(expression, resolve);
	}

	@Test
	public void testIfExpression_01() throws Exception {
		resolvesIdentifiablesTo("{ val x = if (true) while(false) ('foo'+'bar').length }", "null");
	}

	@Test
	public void testIfExpression_02() throws Exception {
		resolvesIdentifiablesTo("{ val Object x = if (true) while(false) ('foo'+'bar').length }", "Object");
	}

	@Test
	public void testOverloadedMethods_01() throws Exception {
		resolvesIdentifiablesTo(
				"{\n" +
				"	var java.util.List<CharSequence> list = null\n" +
				"	var Object o = null\n" +
				"	org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloaded(list, o)\n" +
				"}",
				"List<CharSequence>", "Object");
	}

	@Test
	public void testOverloadedMethods_02() throws Exception {
		resolvesIdentifiablesTo(
				"{\n" +
				"	var java.util.List<CharSequence> list = null\n" +
				"	var String s = null\n" +
				"	org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloaded(list, s)\n" +
				"}",
				"List<CharSequence>", "String");
	}

	@Test
	public void testOverloadedMethods_03() throws Exception {
		resolvesIdentifiablesTo(
				"{\n" +
				"	var java.util.List<? extends CharSequence> list = null\n" +
				"	var Object o = null\n" +
				"	org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloaded(list, o)\n" +
				"}",
				"List<? extends CharSequence>", "Object");
	}

	@Test
	public void testOverloadedMethods_04() throws Exception {
		resolvesIdentifiablesTo(
				"{\n" +
				"	var java.util.List<? extends CharSequence> list = null\n" +
				"	var String s = null\n" +
				"	org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloaded(list, s)\n" +
				"}",
				"List<? extends CharSequence>", "String");
	}

	@Test
	public void testOverloadedOperators_05() throws Exception {
		resolvesIdentifiablesTo("(0..Math::sqrt(1l).intValue).filter[ int it | 1l % it == 0 ].isEmpty", "int");
	}

	@Test
	public void testOverloadedOperators_06() throws Exception {
		resolvesIdentifiablesTo("(0..Math::sqrt(1l).intValue).filter[ 1l % it == 0 ].isEmpty", "Integer");
	}

	@Test
	public void testOverloadedOperators_07() throws Exception {
		resolvesIdentifiablesTo("(0..Math::sqrt(1l).intValue).filter[ i | 1l % i == 0 ].isEmpty", "Integer");
	}

	@Test
	public void testOverloadedOperators_08() throws Exception {
		resolvesIdentifiablesTo("(1..2).map[ toString ].reduce[ i1, i2| i1 + i2 ]", "Integer", "String", "String");
	}

	@Test
	public void testOverloadedOperators_09() throws Exception {
		resolvesIdentifiablesTo("(1..2).map[ toString.length ].reduce[ i1, i2| i1 + i2 ]", "Integer", "Integer", "Integer");
	}

	@Test
	public void testOverloadedOperators_10() throws Exception {
		resolvesIdentifiablesTo("(1..2).map[ new java.math.BigInteger(toString) ].reduce[ i1, i2| i1 + i2 ]", "Integer", "BigInteger",
				"BigInteger");
	}

	@Ignore("i1 and i2 should become T -> Object thus + maps to String + Object")
	@Test
	public void testOverloadedOperators_11() throws Exception {
		resolvesIdentifiablesTo("(1..2).map[ new java.math.BigInteger(toString) ].reduce[ i1, i2 | i1.toString + i2 ]", "Integer", "Object",
				"Object");
	}

	@Test
	public void testOverloadedOperators_12() throws Exception {
		resolvesIdentifiablesTo(
				"{\n" +
				"	val i = 1bi\n" +
				"	val s = ''\n" +
				"	s + i\n" +
				"}", "BigInteger", "String");
	}

	@Ignore("i1 and i2 should become T -> Object thus + maps to Object + String")
	@Test
	public void testOverloadedOperators_13() throws Exception {
		resolvesIdentifiablesTo("(1..2).map[ new java.math.BigInteger(toString) ].reduce[ i1, i2| i1 + String::valueOf(i2) ]", "Integer",
				"Object", "Object");
	}

	@Test
	public void testOverloadedOperators_15() throws Exception {
		resolvesIdentifiablesTo("(1..2).map[ new java.math.BigInteger(toString) ].map[ i | i.toString + i ]", "Integer", "BigInteger");
	}

	@Test
	public void testOverloadedOperators_16() throws Exception {
		resolvesIdentifiablesTo("(1..2).map[ new java.math.BigInteger(toString) ].map[ it + String::valueOf(it) ]", "Integer",
				"BigInteger");
	}

	@Test
	public void testOverloadedOperators_17() throws Exception {
		resolvesIdentifiablesTo("(0..Math::sqrt(1l).intValue).filter[ i | 1l % i == 0 ].empty", "Integer");
	}

	@Test
	public void testTryCatchFinallyExpression_0() throws Exception {
		resolvesIdentifiablesTo("try 'foo' catch (Exception e) 'bar'", "Exception");
	}

	@Test
	public void testTryCatchFinallyExpression_1() throws Exception {
		resolvesIdentifiablesTo("try 'foo' catch (Exception e) 'bar' catch(RuntimeException e) 'baz'", "Exception",
				"RuntimeException");
	}

	@Test
	public void testTryCatchFinallyExpression_2() throws Exception {
		resolvesIdentifiablesTo("try 'foo' catch (Exception e) 'bar' catch(RuntimeException e) 'baz' finally true", "Exception",
				"RuntimeException");
	}

	@Test
	public void testArrayVariable_01() throws Exception {
		resolvesIdentifiablesTo("{ var a = 'a,b,c'.split(',') }", "String[]");
	}

	@Test
	public void testForExpression_01() throws Exception {
		resolvesIdentifiablesTo("for(String x : new java.util.ArrayList<String>()) x.length", "String");
		resolvesIdentifiablesTo("for(String x : newArrayList('foo')) x.length", "String");
		resolvesIdentifiablesTo("for(String x : <String>newArrayList()) x.length", "String");
	}

	@Test
	public void testForExpression_02() throws Exception {
		resolvesIdentifiablesTo("for(x : new java.util.ArrayList<String>()) x.length", "String");
		resolvesIdentifiablesTo("for(x : <String>newArrayList()) x.length", "String");
		resolvesIdentifiablesTo("for(x : newArrayList('foo')) x.length", "String");
	}

	@Test
	public void testForExpression_03() throws Exception {
		resolvesIdentifiablesTo("for(String x : null as String[][]) x.length", "String");
	}

	@Test
	public void testForExpression_04() throws Exception {
		resolvesIdentifiablesTo("for(x : null as String[][]) x.size", "String[]");
	}

	@Test
	public void testForExpression_05() throws Exception {
		resolvesIdentifiablesTo("for(x : null as java.util.Set) x.toString", "Object");
	}

	@Test
	public void testForExpression_06() throws Exception {
		resolvesIdentifiablesTo("for(x : null as Iterable<String>?:emptyList) x.toString", "String");
	}

	@Test
	public void testMethodTypeParamInference_00() throws Exception {
		resolvesIdentifiablesTo("new java.util.ArrayList<String>().findFirst(e | true)", "String");
	}

	@Test
	public void testMethodTypeParamInference_01() throws Exception {
		resolvesIdentifiablesTo("new java.util.ArrayList<String>().findFirst(e|e == 'foo')", "String");
	}

	@Test
	public void testMethodTypeParamInference_02() throws Exception {
		resolvesIdentifiablesTo("new java.util.ArrayList<String>().<String>findFirst(e|e == 'foo')", "String");
	}

	@Test
	public void testMethodTypeParamInference_03() throws Exception {
		resolvesIdentifiablesTo("$$IterableExtensions::findFirst(new java.util.ArrayList<String>) [e | true]", "String");
	}

	@Test
	public void testMethodTypeParamInference_04() throws Exception {
		resolvesIdentifiablesTo("$$IterableExtensions::findFirst(new java.util.ArrayList<String>) [e|e == 'foo']", "String");
	}

	@Test
	public void testMethodTypeParamInference_05() throws Exception {
		resolvesIdentifiablesTo("$$IterableExtensions::<String>findFirst(new java.util.ArrayList<String>) [e|e == 'foo']", "String");
	}

	@Test
	public void testClosure_01() throws Exception {
		resolvesIdentifiablesTo("{ var closure = [|'literal']\n" +
				"  new testdata.ClosureClient().invoke0(closure)	}\n" +
				"", "()=>String");
	}

	@Test
	public void testClosure_02() throws Exception {
		resolvesIdentifiablesTo("[String x| true]", "String");
	}

	@Test
	public void testClosure_03() throws Exception {
		resolvesIdentifiablesTo(
				"{\n" +
				"  var java.util.List<? super String> list = null;\n" +
				"  list.map(e|e)\n" +
				"}",
				"List<? super String>", "Object");
	}

	@Test
	public void testClosure_04() throws Exception {
		resolvesIdentifiablesTo(
				"{\n" +
				"  var java.util.List<? super String> list = null;\n" +
				"  list.map(e|false)\n" +
				"}",
				"List<? super String>", "Object");
	}

	@Test
	public void testClosure_05() throws Exception {
		resolvesIdentifiablesTo("[x| true]", "Object");
	}

	@Test
	public void testClosure_07() throws Exception {
		resolvesIdentifiablesTo("[String x, String y| x + y ]", "String", "String");
	}

	@Test
	public void testClosure_08() throws Exception {
		resolvesIdentifiablesTo("[x| x]", "Object");
	}

	@Test
	public void testClosure_11() throws Exception {
		resolvesIdentifiablesTo("[Object x| x]", "Object");
	}

	@Test
	public void testClosure_13() throws Exception {
		resolvesIdentifiablesTo("{ \n" +
				"	val mapper = [ x | x ]\n" +
				"	newArrayList(1).map(mapper)\n" +
				"}", "(Integer)=>Integer", "Integer");
	}

	@Test
	public void testClosure_13b() throws Exception {
		resolvesIdentifiablesTo("{ \n" +
				"	val mapper = [ x | x ]\n" +
				"	newArrayList(1).map(mapper).findFirst [ true ]\n" +
				"}", "(Integer)=>Integer",
				"Integer", "Integer");
	}

	@Ignore("TODO deferred closure body typing")
	@Test
	public void testClosure_14() throws Exception {
		resolvesIdentifiablesTo("{ \n" +
				"	val mapper = [ x | x.charAt(0) ]\n" +
				"	newArrayList('').map(mapper)\n" +
				"}", "(String)=>char", "String");
	}

	@Test
	public void testClosure_15() throws Exception {
		resolvesIdentifiablesTo("{ \n" +
				"	val fun = [ x | x ]\n" +
				"	val String s = fun.apply(null)\n" +
				"	fun\n" +
				"}", "(String)=>String", "String",
				"String");
	}

	@Test
	public void testClosure_16() throws Exception {
		resolvesIdentifiablesTo("{ \n" +
				"	val fun = [ x | x ]\n" +
				"	val java.util.List<String> list = newArrayList(fun.apply(null))\n" +
				"	fun\n" +
				"}",
				"(String[])=>String[]", "String[]", "List<String>");
	}

	@Test
	public void testClosure_17() throws Exception {
		resolvesIdentifiablesTo("{ \n" +
				"	val fun = [ x | x ]\n" +
				"	val java.util.List<String> list = newArrayList.map(fun)\n" +
				"	fun\n" +
				"}",
				"(String)=>String", "String", "List<String>");
	}

	@Test
	public void testClosure_21() throws Exception {
		resolvesIdentifiablesTo(
				"{ \n" +
				"	val fun = [ x | x ]\n" +
				"	val list = newArrayList.map(fun)\n" +
				"	val Iterable<String> iter = list\n" +
				"	fun\n" +
				"}",
				"(String)=>String", "String", "List<String>", "Iterable<String>");
	}

	@Test
	public void testClosure_22() throws Exception {
		resolvesIdentifiablesTo(
				"{ \n" +
				"	val fun = [ x | x ]\n" +
				"	val java.util.List<String> list = $$ListExtensions::map(newArrayList, fun)\n" +
				"	fun\n" +
				"}",
				"(String)=>String", "String", "List<String>");
	}

	@Test
	public void testClosure_26() throws Exception {
		resolvesIdentifiablesTo(
				"{ \n" +
				"	val fun = [ x | x ]\n" +
				"	val list = $$ListExtensions::map(newArrayList, fun)\n" +
				"	val Iterable<String> iter = list\n" +
				"	fun\n" +
				"}",
				"(String)=>String", "String", "List<String>", "Iterable<String>");
	}

	@Test
	public void testClosure_27() throws Exception {
		resolvesIdentifiablesTo("{ \n" +
				"	val mapper = [ x | x ]\n" +
				"	$$ListExtensions::map(newArrayList(1), mapper)\n" +
				"}", "(Integer)=>Integer",
				"Integer");
	}

	@Test
	public void testClosure_30() throws Exception {
		resolvesIdentifiablesTo("$$ListExtensions::map(null as java.util.List<? super String>) [e|e]", "Object");
	}

	@Test
	public void testClosure_31() throws Exception {
		resolvesIdentifiablesTo(
				"{\n" +
				"  var java.util.List<? super String> list = null;\n" +
				"  $$ListExtensions::map(list) [e|e]\n" +
				"}",
				"List<? super String>", "Object");
	}

	@Test
	public void testSwitchExpression_3() throws Exception {
		resolvesIdentifiablesTo(
				"{\n" +
				"	val Object c = null\n" +
				"	switch c {\n" +
				"        CharSequence: 1\n" +
				"	}\n" +
				"}", "Object");
	}

	@Test
	public void testSwitchExpression_4() throws Exception {
		resolvesIdentifiablesTo(
				"{\n" +
				"	val Comparable<Object> c = null\n" +
				"	switch c {\n" +
				"        CharSequence: switch(c) {\n" +
				"            Appendable: {\n" +
				"                c.charAt(1)\n" +
				"            }\n" +
				"        }\n" +
				"	}\n" +
				"}",
				"Comparable<Object>");
	}

	@Test
	public void testSwitchExpression_5() throws Exception {
		resolvesIdentifiablesTo(
				"{\n" +
				"	val Comparable<Object> c = null\n" +
				"	switch c {\n" +
				"        CharSequence: switch(c) {\n" +
				"            Appendable: {\n" +
				"                c.append(null)\n" +
				"            }\n" +
				"        }\n" +
				"	}\n" +
				"}",
				"Comparable<Object>");
	}

	@Test
	public void testSwitchExpression_6() throws Exception {
		resolvesIdentifiablesTo(
				"{\n" +
				"	val Comparable<Object> c = null\n" +
				"	switch c {\n" +
				"        CharSequence: switch(c) {\n" +
				"            Appendable: {\n" +
				"                c.compareTo(null)\n" +
				"            }\n" +
				"        }\n" +
				"	}\n" +
				"}",
				"Comparable<Object>");
	}

	@Test
	public void testTypeGuardedCase_0() throws Exception {
		resolvesIdentifiablesTo("switch s: new Object() { String: s StringBuffer: s}", "Object");
	}

	@Test
	public void testTypeGuardedCase_1() throws Exception {
		resolvesIdentifiablesTo("switch s: '' as CharSequence { Cloneable: s String: s }", "CharSequence");
	}

	@Test
	public void testBlockExpression_02() throws Exception {
		resolvesIdentifiablesTo("{val s = '' s}", "String");
	}

	@Test
	public void testBlockExpression_04() throws Exception {
		resolvesIdentifiablesTo("{val Object s = '' s}", "Object");
	}

	@Test
	public void testEMap_01() throws Exception {
		resolvesIdentifiablesTo(
				"{ \n" +
				"  val eMap = new org.eclipse.emf.common.util.BasicEMap<Integer, String>()\n" +
				"  eMap.map[ getKey ].head\n" +
				" }",
				"BasicEMap<Integer, String>", "Entry<Integer, String>");
	}

	@Test
	public void testEMap_05() throws Exception {
		resolvesIdentifiablesTo(
				"{ \n" +
				"  val org.eclipse.emf.common.util.BasicEMap<? extends Integer, String> eMap = null\n" +
				"  eMap.map[ key ].head\n" +
				"}\n" +
				"",
				"BasicEMap<? extends Integer, String>", "Entry<? extends Integer, String>");
	}

	@Test
	public void testEMap_09() throws Exception {
		resolvesIdentifiablesTo(
				"{ \n" +
				"  val org.eclipse.emf.common.util.BasicEMap<? super Integer, String> eMap = null\n" +
				"  eMap.map[ key ].head\n" +
				" }",
				"BasicEMap<? super Integer, String>", "Entry<? super Integer, String>");
	}

	@Test
	public void testMemberFeatureCall_02() throws Exception {
		resolvesIdentifiablesTo("(1..20).map[ toString.length ].reduce[ i1,  i2 | i1 + i2 ]", "Integer", "Integer", "Integer");
	}

	@Test
	public void testFeatureCall_06() throws Exception {
		resolvesIdentifiablesTo("newArrayList('').map(s|s)", "String");
	}

	@Test
	public void testFeatureCall_06a() throws Exception {
		resolvesIdentifiablesTo("newArrayList('').map [it|it]", "String");
	}

	@Test
	public void testFeatureCall_06b() throws Exception {
		resolvesIdentifiablesTo("newArrayList('').map [it]", "String");
	}

	@Test
	public void testFeatureCall_06c() throws Exception {
		resolvesIdentifiablesTo("(null as Iterable<String>).map(s|s)", "String");
	}

	@Test
	public void testFeatureCall_06_00() throws Exception {
		resolvesIdentifiablesTo("$$ListExtensions::map(newArrayList('')) [s|s]", "String");
	}

	@Test
	public void testFeatureCall_06_01() throws Exception {
		resolvesIdentifiablesTo("newArrayList('').map(s|s).head", "String");
	}

	@Test
	public void testFeatureCall_06_02() throws Exception {
		resolvesIdentifiablesTo("newArrayList('').map(s|s.toString).head", "String");
	}

	@Test
	public void testFeatureCall_06_03() throws Exception {
		resolvesIdentifiablesTo("newArrayList('').map(s|1)", "String");
	}

	@Test
	public void testFeatureCall_07() throws Exception {
		resolvesIdentifiablesTo("newArrayList('').map(s|s.length)", "String");
	}

	@Test
	public void testFeatureCall_07_01() throws Exception {
		resolvesIdentifiablesTo("<String>newArrayList.map[ length ]", "String");
	}

	@Test
	public void testFeatureCall_10() throws Exception {
		resolvesIdentifiablesTo("newArrayList('').map(s|1).map(i|i+1)", "String", "Integer");
	}

	@Test
	public void testFeatureCall_12() throws Exception {
		resolvesIdentifiablesTo("newArrayList('').map(s|1).toList().map(i|i)", "String", "Integer");
	}

	@Test
	public void testFeatureCall_13_2() throws Exception {
		resolvesIdentifiablesTo("{ var it = newArrayList('').map(s|1).toList() it.map(i|i+1) }", "List<Integer>", "String", "Integer");
	}

	@Test
	public void testFeatureCall_13_3() throws Exception {
		resolvesIdentifiablesTo("{ var it = newArrayList('').map(s|1).toList() map(i|i+1) }", "List<Integer>", "String", "Integer");
	}

	@Test
	public void testFeatureCall_13_5() throws Exception {
		resolvesIdentifiablesTo("{ var java.util.List<? extends Integer> it = null map(i|i+1) }", "List<? extends Integer>", "Integer");
	}

	@Test
	public void testFeatureCall_13_6() throws Exception {
		resolvesIdentifiablesTo("{ var java.util.List<? extends Integer> it = null map(i|i) }", "List<? extends Integer>", "Integer");
	}

	@Test
	public void testFeatureCall_14() throws Exception {
		resolvesIdentifiablesTo("newArrayList(newArrayList('').map(s|1))", "String");
	}

	@Test
	public void testFeatureCall_15() throws Exception {
		resolvesIdentifiablesTo("newArrayList(newArrayList('').map(s|1)).map(iterable|iterable.size())", "String", "List<Integer>");
	}

	@Test
	public void testFeatureCall_15_a() throws Exception {
		resolvesIdentifiablesTo("newArrayList(newArrayList('').map(s|1)).map(iterable|iterable.size()).map(e|e)", "String",
				"List<Integer>", "Integer");
	}

	@Test
	public void testFeatureCall_15_b() throws Exception {
		resolvesIdentifiablesTo("newArrayList(newArrayList('').map(s|1)).map(iterable|iterable.size()).map(e|e).map(e|e)", "String",
				"List<Integer>", "Integer", "Integer");
	}

	@Test
	public void testFeatureCall_15_e() throws Exception {
		resolvesIdentifiablesTo("newArrayList(newArrayList('').map(s|1).map(e|e)).map(iterable|iterable.size())", "String", "Integer",
				"List<Integer>");
	}

	@Test
	public void testFeatureCall_15_e_2() throws Exception {
		resolvesIdentifiablesTo("newArrayList(newArrayList('')).map(iterable|iterable.size())", "ArrayList<String>");
	}

	@Test
	public void testFeatureCall_15_f() throws Exception {
		resolvesIdentifiablesTo("newArrayList(newArrayList('').map(s|1).map(e|e).map(e|e)).map(iterable|iterable.size())", "String",
				"Integer", "Integer", "List<Integer>");
	}

	@Test
	public void testFeatureCall_15_i_3() throws Exception {
		resolvesIdentifiablesTo("newArrayList(newArrayList('').map(s|1).map(e|e)).map(iterable|iterable.size()).map(e|e)", "String",
				"Integer", "List<Integer>", "Integer");
	}

	@Test
	public void testFeatureCall_15_p() throws Exception {
		resolvesIdentifiablesTo("newArrayList(newArrayList('')).map(iterable|iterable.size()).map(e|e)", "ArrayList<String>", "Integer");
	}

	@Test
	public void testFeatureCall_16_a() throws Exception {
		resolvesIdentifiablesTo("newArrayList('').map(s|1).map(i|1)", "String", "Integer");
	}

	@Test
	public void testFeatureCall_18_a() throws Exception {
		resolvesIdentifiablesTo("newArrayList('').map(s|s.length + 1 == 5).map(b|b)", "String", "Boolean");
	}

	@Test
	public void testFeatureCall_20_a() throws Exception {
		resolvesIdentifiablesTo("newArrayList('').map(s|s.length + 1 == 5).map(boolean b|!b)", "String", "boolean");
	}

	@Test
	public void testFeatureCall_24_a() throws Exception {
		resolvesIdentifiablesTo(
				"newArrayList('').map(s|$$ObjectExtensions::operator_equals("
						+ "	$$IntegerExtensions::operator_plus(s.length,1), 5)).map(b| $$BooleanExtensions::operator_not(b) )",
				"String", "Boolean");
	}

	@Test
	public void testFeatureCall_25_a() throws Exception {
		resolvesIdentifiablesTo("newArrayList('').map(s|s.length + 1 * 5).map(b| b / 5 )", "String", "Integer");
	}

	@Test
	public void testFeatureCall_25_c() throws Exception {
		resolvesIdentifiablesTo("newArrayList('').map[ length + 1 * 5 ].map [ it / 5 ].head", "String", "Integer");
	}

	@Test
	public void testFeatureCall_26() throws Exception {
		if (JavaRuntimeVersion.isJava12OrLater()) {
			resolvesIdentifiablesTo(
					"{ val list = newArrayList(if (false) new Double('-20') else new Integer('20')).map(v|v.intValue)\n" +
				"   val Object o = list.head \n" +
				"   list\n" +
				"}",
					"List<Integer>", "Number & Comparable<?> & Constable & ConstantDesc", "Object");
		} else {
			resolvesIdentifiablesTo(
					"{ val list = newArrayList(if (false) new Double('-20') else new Integer('20')).map(v|v.intValue)\n" +
				"   val Object o = list.head \n" +
				"   list\n" +
				"}",
					"List<Integer>", "Number & Comparable<?>", "Object");
		}
	}

	@Test
	public void testFeatureCall_27() throws Exception {
		if (JavaRuntimeVersion.isJava12OrLater()) {
			resolvesIdentifiablesTo(
					"{ val list = $$ListExtensions::map(newArrayList(if (false) new Double('-20') else new Integer('20'))) [ v|v.intValue ]\n" +
				"   val Object o = list.head \n" +
				"   list\n" +
				"}",
					"List<Integer>", "Number & Comparable<?> & Constable & ConstantDesc", "Object");
		} else {
			resolvesIdentifiablesTo(
					"{ val list = $$ListExtensions::map(newArrayList(if (false) new Double('-20') else new Integer('20'))) [ v|v.intValue ]\n" +
				"   val Object o = list.head \n" +
				"   list\n" +
				"}",
					"List<Integer>", "Number & Comparable<?>", "Object");
		}
	}

	@Test
	public void testFeatureCall_28() throws Exception {
		resolvesIdentifiablesTo("{ val list = $$ListExtensions::map(newArrayList(null as Integer)) [ v|v.intValue ] }", "List<Integer>",
				"Integer");
	}

	@Test
	public void testFeatureCall_30() throws Exception {
		resolvesIdentifiablesTo("{ val list = newArrayList(null as Integer).map [ v|v.intValue ]\n" +
				"   val o = list.head \n" +
				"   list\n" +
				"}",
				"List<Integer>", "Integer", "Integer");
	}

	@Test
	public void testFeatureCall_31() throws Exception {
		resolvesIdentifiablesTo("{ val list = newArrayList(null as Integer).map [ v|v.intValue ]\n" +
				"   list.findFirst [ intValue == 0 ]\n" +
				"}",
				"List<Integer>", "Integer", "Integer");
	}

	@Test
	public void testFeatureCall_32() throws Exception {
		resolvesIdentifiablesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	list.forEach[String s | s]\n" +
				"	list\n" +
				"}", "ArrayList<String>", "String");
	}

	@Test
	public void testFeatureCall_34() throws Exception {
		resolvesIdentifiablesTo("newArrayList.map[String s | s.substring(1,1) ]", "String");
	}

	@Test
	public void testFeatureCall_35() throws Exception {
		resolvesIdentifiablesTo("newArrayList.map[ s | s.toString ]", "Object");
	}

	@Test
	public void testFeatureCall_36() throws Exception {
		resolvesIdentifiablesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	list.forEach[ s | s.toString ]\n" +
				"	list\n" +
				"}", "ArrayList<Object>", "Object");
	}

	@Test
	public void testFeatureCall_Bug342134_00() throws Exception {
		resolvesIdentifiablesTo("(null as java.util.List<String>).map(e|newArrayList(e)).flatten", "String");
	}

	@Test
	public void testFeatureCall_Bug342134_01() throws Exception {
		resolvesIdentifiablesTo("(null as java.util.List<String>).map(CharSequence e|newArrayList(e)).flatten", "CharSequence");
	}

	@Test
	public void testFeatureCall_Bug342134_02() throws Exception {
		resolvesIdentifiablesTo("newArrayList('').map(e|newArrayList(e)).flatten", "String");
	}

	@Test
	public void testFeatureCall_Bug342134_04() throws Exception {
		resolvesIdentifiablesTo("newArrayList('').map(e|newArrayList(e))", "String");
	}

	@Test
	public void testFeatureCall_Bug342134_06() throws Exception {
		resolvesIdentifiablesTo("<String>newArrayList.map(e|newArrayList(e)).flatten", "String");
	}

	@Ignore("TODO this should work")
	@Test
	public void testBug_391758() throws Exception {
		resolvesIdentifiablesTo(
				"{\n" +
				"	val iterable = newArrayList\n" +
				"	iterable.fold(newArrayList) [ list , elem | null as java.util.List<String> ]\n" +
				"}",
				"ArrayList<Object>", "List<String>", "Object");
	}

	@Test
	public void testDeferredTypeArgumentResolution_002() throws Exception {
		resolvesIdentifiablesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	val String s = list.get(0)\n" +
				"	list\n" +
				"}", "ArrayList<String>", "String");
	}

	@Test
	public void testDeferredTypeArgumentResolution_012() throws Exception {
		resolvesIdentifiablesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	val secondList = newArrayList\n" +
				"	list.add('')\n" +
				"	list.addAll(secondList)\n" +
				"	secondList\n" +
				"}",
				"ArrayList<String>", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_016() throws Exception {
		resolvesIdentifiablesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	val java.util.Iterator<String> sublist = list.subList(1, 1).iterator\n" +
				"	list\n" +
				"}",
				"ArrayList<String>", "Iterator<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_036() throws Exception {
		resolvesIdentifiablesTo(
				"{\n" +
				"	val list = newArrayList(newArrayList)\n" +
				"	val Iterable<String> s = list.head\n" +
				"	list.head\n" +
				"}",
				"ArrayList<ArrayList<String>>", "Iterable<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_037() throws Exception {
		resolvesIdentifiablesTo(
				"{\n" +
				"	val list = newArrayList(newArrayList)\n" +
				"	val Iterable<String> s = list.flatten\n" +
				"	list.head\n" +
				"}",
				"ArrayList<ArrayList<String>>", "Iterable<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_038() throws Exception {
		resolvesIdentifiablesTo(
				"{\n" +
				"	val list = newArrayList(newHashSet)\n" +
				"	val String s = list.flatten.head\n" +
				"	list.head\n" +
				"}",
				"ArrayList<HashSet<String>>", "String");
	}

	@Test
	public void testDeferredTypeArgumentResolution_040() throws Exception {
		resolvesIdentifiablesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	val second = newArrayList(newArrayList)\n" +
				"	val String s = second.flatten.head\n" +
				"	list.add(second.head)\n" +
				"	list.head\n" +
				"}",
				"ArrayList<ArrayList<String>>", "ArrayList<ArrayList<String>>", "String");
	}

	@Test
	public void testDeferredTypeArgumentResolution_042() throws Exception {
		resolvesIdentifiablesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	val secondList = newArrayList\n" +
				"	list.addAll('')\n" +
				"	list.addAll(secondList)\n" +
				"	secondList\n" +
				"}",
				"ArrayList<String>", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_061() throws Exception {
		resolvesIdentifiablesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	val java.util.Set<String> sublist = println(println(list).subList(1, 1))\n" +
				"	list\n" +
				"}",
				"ArrayList<String>", "Set<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_062() throws Exception {
		resolvesIdentifiablesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	val java.util.Iterator<String> sublist = println(println(println(list).subList(1, 1)).iterator)\n" +
				"	list\n" +
				"}",
				"ArrayList<String>", "Iterator<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_102() throws Exception {
		resolvesIdentifiablesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.add(new java.util.HashSet)\n" +
				"	val Iterable<String> s = list.head\n" +
				"	list.head\n" +
				"}",
				"ArrayList<HashSet<String>>", "Iterable<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_106() throws Exception {
		resolvesIdentifiablesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val second = new java.util.ArrayList\n" +
				"	second.add(new java.util.ArrayList)\n" +
				"	val String s = second.flatten.head\n" +
				"	list.add(second.head)\n" +
				"	list.head\n" +
				"}",
				"ArrayList<ArrayList<String>>", "ArrayList<ArrayList<String>>", "String");
	}

	@Test
	public void testDeferredTypeArgumentResolution_133() throws Exception {
		resolvesIdentifiablesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	val fun = [String s| s]\n" +
				"	list.map(fun)\n" +
				"	list\n" +
				"}", "ArrayList<String>",
				"(String)=>String", "String");
	}

	@Test
	public void testDeferredTypeArgumentResolution_134() throws Exception {
		resolvesIdentifiablesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.map[String s| s]\n" +
				"	list\n" +
				"}", "ArrayList<String>",
				"String");
	}

	@Test
	public void testDeferredTypeArgumentResolution_135() throws Exception {
		resolvesIdentifiablesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.<String, Object>map[s| s]\n" +
				"	list\n" +
				"}", "ArrayList<String>",
				"String");
	}

	@Test
	public void testDeferredTypeArgumentResolution_136() throws Exception {
		resolvesIdentifiablesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.<String, Object>map[s| s.toString]\n" +
				"	list\n" +
				"}",
				"ArrayList<String>", "String");
	}

	@Test
	public void testDeferredTypeArgumentResolution_137() throws Exception {
		resolvesIdentifiablesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.<String, Object>map[s| s.charAt(1) ]\n" +
				"	list\n" +
				"}",
				"ArrayList<String>", "String");
	}

	@Test
	public void testDeferredTypeArgumentResolution_138() throws Exception {
		resolvesIdentifiablesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.<String, CharSequence>map[s| s]\n" +
				"	list\n" +
				"}",
				"ArrayList<String>", "String");
	}
}
