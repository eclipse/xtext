/**
 * Copyright (c) 2012, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.JavaRuntimeVersion;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractFeatureCallTypeTest extends AbstractXbaseTestCase {
	public abstract void resolvesFeatureCallsTo(String expression, String... types) throws Exception;

	private static Set<String> seenExpressions;

	@BeforeClass
	public static void createSeenExpressionsSet() {
		seenExpressions = new HashSet<>();
	}

	@AfterClass
	public static void discardSeenExpressions() {
		seenExpressions = null;
	}

	protected List<XAbstractFeatureCall> findFeatureCalls(CharSequence expression) throws Exception {
		XExpression xExpression = this.expression(expression, false);
		List<XAbstractFeatureCall> featureCalls = IteratorExtensions.toList(Iterators.filter(EcoreUtil2.eAll(xExpression), XAbstractFeatureCall.class));
		return IterableExtensions.sortBy(featureCalls, (XAbstractFeatureCall it) -> {
			return Iterables.getFirst(NodeModelUtils.findNodesForFeature(it, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE), null)
					.getOffset();
		});
	}

	protected Iterable<XAbstractFeatureCall> filterTypeLiteralsAndPackageFragments(Iterable<XAbstractFeatureCall> featureCalls) {
		return Iterables.filter(featureCalls, (XAbstractFeatureCall it) -> (!it.isPackageFragment() && !it.isTypeLiteral()));
	}

	@Override
	protected XExpression expression(CharSequence expression, boolean resolve) throws Exception {
		String string = expression.toString();
		if (!seenExpressions.add(string)) {
			Assert.fail("Duplicate expression under test: " + expression);
		}
		return super.expression(expression, resolve);
	}

	@Test
	public void testJEP101Example_01() throws Exception {
		resolvesFeatureCallsTo("{ val foo.JEP101List<String> ls = foo::JEP101List::nil }", "JEP101List<String>");
	}

	@Test
	public void testJEP101Example_02() throws Exception {
		resolvesFeatureCallsTo("foo::JEP101List::cons(42, foo::JEP101List::nil)", "JEP101List<Integer>", "JEP101List<Integer>");
	}

	@Test
	public void testJEP101Example_03() throws Exception {
		resolvesFeatureCallsTo("{ val String s = foo::JEP101List::nil.head }", "JEP101List<String>", "String");
	}

	@Test
	public void testElvisWithEmptyListInLambda() throws Exception {
		resolvesFeatureCallsTo(
				"[ String s |\n" +
				"	val result = <Integer>newArrayList\n" +
				"	val (String)=>Iterable<Integer> fun = []\n" +
				"	result += fun.apply(s) ?: emptyList\n" +
				"	result\n" +
				"]",
				"ArrayList<Integer>", "ArrayList<Integer>", "boolean", "(String)=>Iterable<Integer>", "Iterable<Integer>", "String",
				"Iterable<Integer>", "List<Integer>", "ArrayList<Integer>");
	}

	@Test
	public void testElvisWithEmptyList() throws Exception {
		resolvesFeatureCallsTo(
				"{ \n" +
				"	val java.util.List<Integer> list = null\n" +
				"	val fun = [| list ]\n" +
				"	list += fun.apply ?: emptyList\n" +
				"}",
				"List<Integer>", "List<Integer>", "boolean", "()=>List<Integer>", "List<Integer>", "List<Integer>", "List<Integer>");
	}

	@Test
	public void testRawType_01() throws Exception {
		resolvesFeatureCallsTo("{ val java.util.Set set = newHashSet() set }", "HashSet", "Set");
	}

	@Test
	public void testRawType_02() throws Exception {
		resolvesFeatureCallsTo("{ val java.util.Set set = newHashSet set.head }", "HashSet", "Set", "Object");
	}

	@Test
	public void testRawType_03() throws Exception {
		resolvesFeatureCallsTo("(null as java.util.Set<java.util.Set>).head", "Set");
	}

	@Test
	public void testRawType_04() throws Exception {
		resolvesFeatureCallsTo("{ val java.util.Set<java.util.Set> set = newHashSet set.head }", "HashSet<Set>", "Set<Set>", "Set");
	}

	@Test
	public void testRawType_05() throws Exception {
		resolvesFeatureCallsTo("{ val java.util.Set<java.util.Set> set = newHashSet(newHashSet) set.head }", "HashSet<Set>", "HashSet",
				"Set<Set>", "Set");
	}

	@Test
	public void testNumberLiteralInClosure_01() throws Exception {
		resolvesFeatureCallsTo("newArrayList().map[42]", "ArrayList<Object>", "List<Integer>");
	}

	@Test
	public void testOverloadedMethods_01() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	var java.util.List<CharSequence> list = null\n" +
				"	var Object o = null\n" +
				"	org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloaded(list, o)\n" +
				"}",
				"int", "List<CharSequence>", "Object");
	}

	@Test
	public void testOverloadedMethods_02() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	var java.util.List<CharSequence> list = null\n" +
				"	var String s = null\n" +
				"	org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloaded(list, s)\n" +
				"}",
				"long", "List<CharSequence>", "String");
	}

	@Test
	public void testOverloadedMethods_03() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	var java.util.List<? extends CharSequence> list = null\n" +
				"	var Object o = null\n" +
				"	org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloaded(list, o)\n" +
				"}",
				"int", "List<? extends CharSequence>", "Object");
	}

	@Test
	public void testOverloadedMethods_04() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	var java.util.List<? extends CharSequence> list = null\n" +
				"	var String s = null\n" +
				"	org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloaded(list, s)\n" +
				"}",
				"int", "List<? extends CharSequence>", "String");
	}

	@Test
	public void testOverloadedMethods_05() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	var java.util.List<CharSequence> list = null\n" +
				"	org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloaded(list, null)\n" +
				"}",
				"long", "List<CharSequence>");
	}

	@Test
	public void testOverloadedMethods_06() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	var java.util.List<? extends CharSequence> list = null\n" +
				"	org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloaded(list, null)\n" +
				"}",
				"int", "List<? extends CharSequence>");
	}

	@Test
	public void testOverloadedMethods_07() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	var java.util.List<CharSequence> list = null\n" +
				"	var Object o = null\n" +
				"	org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloadedWithTypeParam(list, o)\n" +
				"}",
				"int", "List<CharSequence>", "Object");
	}

	@Test
	public void testOverloadedMethods_08() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	var java.util.List<CharSequence> list = null\n" +
				"	var String s = null\n" +
				"	org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloadedWithTypeParam(list, s)\n" +
				"}",
				"long", "List<CharSequence>", "String");
	}

	@Test
	public void testOverloadedMethods_09() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	var java.util.List<? extends CharSequence> list = null\n" +
				"	var Object o = null\n" +
				"	org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloadedWithTypeParam(list, o)\n" +
				"}",
				"int", "List<? extends CharSequence>", "Object");
	}

	@Test
	public void testOverloadedMethods_10() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	var java.util.List<? extends CharSequence> list = null\n" +
				"	var String s = null\n" +
				"	org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloadedWithTypeParam(list, s)\n" +
				"}",
				"long", "List<? extends CharSequence>", "String");
	}

	@Test
	public void testOverloadedMethods_11() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	var java.util.List<CharSequence> list = null\n" +
				"	org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloadedWithTypeParam(list, null)\n" +
				"}",
				"long", "List<CharSequence>");
	}

	@Test
	public void testOverloadedMethods_12() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	var java.util.List<? extends CharSequence> list = null\n" +
				"	org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloadedWithTypeParam(list, null)\n" +
				"}",
				"long", "List<? extends CharSequence>");
	}

	@Test
	public void testOverloadedOperators_12() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	val i = 1bi\n" +
				"	val s = ''\n" +
				"	s + i\n" +
				"}", "String", "String", "BigInteger");
	}

	@Test
	public void testOverloadedOperators_14() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	val i = 1bi\n" +
				"	val s = ''\n" +
				"	i + s\n" +
				"}", "BigInteger", "String", "String");
	}

	@Test
	public void testForExpression_01() throws Exception {
		resolvesFeatureCallsTo("for(String x : new java.util.ArrayList<String>()) x.length", "String", "int");
		resolvesFeatureCallsTo("for(String x : newArrayList('foo')) x.length", "ArrayList<String>", "String", "int");
		resolvesFeatureCallsTo("for(String x : <String>newArrayList()) x.length", "ArrayList<String>", "String", "int");
	}

	@Test
	public void testForExpression_02() throws Exception {
		resolvesFeatureCallsTo("for(x : new java.util.ArrayList<String>()) x.length", "String", "int");
		resolvesFeatureCallsTo("for(x : <String>newArrayList()) x.length", "ArrayList<String>", "String", "int");
		resolvesFeatureCallsTo("for(x : newArrayList('foo')) x.length", "ArrayList<String>", "String", "int");
	}

	@Test
	public void testForExpression_03() throws Exception {
		resolvesFeatureCallsTo("for(String x : null as String[]) x.length", "String", "int");
	}

	@Test
	public void testForExpression_04() throws Exception {
		resolvesFeatureCallsTo("for(x : null as String[]) x.length", "String", "int");
	}

	@Test
	public void testBasicForExpression_01() throws Exception {
		resolvesFeatureCallsTo("for(val x = new Object; x instanceof String;) { val y = x }", "Object", "String");
	}

	@Test
	public void testBasicForExpression_02() throws Exception {
		resolvesFeatureCallsTo("for(val x = new Object; x instanceof String && true;) { val y = x }", "Object", "boolean", "Object");
	}

	@Test
	public void testBasicForExpression_03() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	var Object y = null\n" +
				"	for(var x = new Object; x instanceof String; y = x) { \n" +
				"		y = x\n" +
				"		x = new Object\n" +
				"	}\n" +
				"}\n" +
				""
						.toString(),
				"Object", "Object", "Object", "Object", "String", "Object");
	}

	@Test
	public void testMethodTypeParamInference_01() throws Exception {
		resolvesFeatureCallsTo("new java.util.ArrayList<String>().findFirst(e|e == 'foo')", "String", "String", "boolean");
	}

	@Test
	public void testMethodTypeParamInference_02() throws Exception {
		resolvesFeatureCallsTo("new java.util.ArrayList<String>().<String>findFirst(e|e == 'foo')", "String", "String", "boolean");
	}

	@Test
	public void testMethodTypeParamInference_04() throws Exception {
		resolvesFeatureCallsTo("$$IterableExtensions::findFirst(new java.util.ArrayList<String>) [e|e == 'foo']", "String", "String",
				"boolean");
	}

	@Test
	public void testMethodTypeParamInference_05() throws Exception {
		resolvesFeatureCallsTo("$$IterableExtensions::<String>findFirst(new java.util.ArrayList<String>) [e|e == 'foo']", "String",
				"String", "boolean");
	}

	@Test
	public void testTypeForVoidClosure() throws Exception {
		resolvesFeatureCallsTo("newArrayList('foo','bar').forEach []", "ArrayList<String>", "void");
	}

	@Test
	public void testFeatureCallWithArrayToIterableConversion() throws Exception {
		resolvesFeatureCallsTo("'foo'.toCharArray.iterator", "char[]", "Iterator<Character>");
	}

	@Test
	public void testArray_01() throws Exception {
		resolvesFeatureCallsTo("'a,b,c'.split(',').tail", "String[]", "Iterable<String>");
	}

	@Test
	public void testArray_02() throws Exception {
		resolvesFeatureCallsTo("new testdata.ArrayClient().swap('a,b,c'.split(','))", "String[]", "String[]");
	}

	@Test
	public void testArray_03() throws Exception {
		resolvesFeatureCallsTo("new testdata.ArrayClient().swap('a,b,c'.split(',').tail)", "String[]", "String[]", "Iterable<String>");
	}

	@Test
	public void testArray_04() throws Exception {
		resolvesFeatureCallsTo("new testdata.ArrayClient().swap(null)", "Object[]");
	}

	@Test
	public void testArray_05() throws Exception {
		resolvesFeatureCallsTo("new testdata.ArrayClient().swap(null as Integer[])", "Integer[]");
	}

	@Test
	public void testArray_06() throws Exception {
		resolvesFeatureCallsTo("{ val Integer[] x = new testdata.ArrayClient().swap(null) }", "Integer[]");
	}

	@Test
	public void testArray_07() throws Exception {
		resolvesFeatureCallsTo("{ val x = new testdata.ArrayClient().swap(null) val Integer[] y = x }", "Integer[]", "Integer[]");
	}

	@Test
	public void testArray_08() throws Exception {
		resolvesFeatureCallsTo("{ val x = new testdata.ArrayClient().swap(null) val Integer y = x.head }", "Integer[]", "Integer[]",
				"Integer");
	}

	@Test
	public void testArray_09() throws Exception {
		resolvesFeatureCallsTo("{ val x = new testdata.ArrayClient().swap(null) val Integer[] y = x.head }", "Integer[][]", "Integer[][]",
				"Integer[]");
	}

	@Test
	public void testReturnType_02() throws Exception {
		resolvesFeatureCallsTo("return try { if (true) 'foo' else 'bar' } finally { String::valueOf('zonk') }", "String");
	}

	@Test
	public void testClosure_01() throws Exception {
		resolvesFeatureCallsTo(
				"{ var closure = [|'literal']\n" +
				"  new testdata.ClosureClient().invoke0(closure)	}", "String",
				"()=>String");
	}

	@Test
	public void testClosure_02() throws Exception {
		resolvesFeatureCallsTo(
				"{ var com.google.common.collect.AbstractIterator<String> iter = [| return self.endOfData ] }",
				"AbstractIterator<String>", "String");
	}

	@Test
	public void testClosure_03() throws Exception {
		resolvesFeatureCallsTo("{\n" +
				"  var java.util.List<? super String> list = null;\n" +
				"  list.map(e|e)\n" +
				"}",
				"List<? super String>", "List<Object>", "Object");
	}

	@Test
	public void testClosure_04() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"  var java.util.List<? super String> list = null;\n" +
				"  list.map(e|false)\n" +
				"}",
				"List<? super String>", "List<Boolean>");
	}

	@Test
	public void testClosure_05() throws Exception {
		resolvesFeatureCallsTo(
				"{ \n" +
				"	var com.google.common.collect.AbstractIterator<java.util.Iterator<String>> iter = [|\n" +
				"		if (true) {\n" +
				"			val com.google.common.collect.AbstractIterator<String> result = [|\n" +
				"				return self.endOfData\n" +
				"			]\n" +
				"			return result\n" +
				"		}\n" +
				"		return self.endOfData\n" +
				"	]\n" +
				"}",
				"AbstractIterator<String>", "String", "AbstractIterator<String>", "AbstractIterator<Iterator<String>>", "Iterator<String>");
	}

	@Test
	public void testClosure_07() throws Exception {
		resolvesFeatureCallsTo("[String x, String y| x + y ]", "String", "String", "String");
	}

	@Test
	public void testClosure_08() throws Exception {
		resolvesFeatureCallsTo("[x| x]", "Object");
	}

	@Test
	public void testClosure_09() throws Exception {
		resolvesFeatureCallsTo("[String x, String y| x.substring(y.length)]", "String", "String", "String", "int");
	}

	@Test
	public void testClosure_10() throws Exception {
		resolvesFeatureCallsTo("[ x | x.toString x ]", "Object", "String", "Object");
	}

	@Test
	public void testClosure_11() throws Exception {
		resolvesFeatureCallsTo("[Object x| x]", "Object");
	}

	@Test
	public void testClosure_12() throws Exception {
		resolvesFeatureCallsTo("[Object x| x.toString x ]", "Object", "String", "Object");
	}

	@Test
	public void testClosure_13() throws Exception {
		resolvesFeatureCallsTo(
				"{ \n" +
				"	val mapper = [ x | x ]\n" +
				"	newArrayList(1).map(mapper)\n" +
				"}", "Integer",
				"ArrayList<Integer>", "List<Integer>", "(Integer)=>Integer");
	}

	@Test
	public void testClosure_15() throws Exception {
		resolvesFeatureCallsTo(
				"{ \n" +
				"	val fun = [ x | x ]\n" +
				"	val String s = fun.apply(null)\n" +
				"	fun\n" +
				"}", "String",
				"(String)=>String", "String", "(String)=>String");
	}

	@Test
	public void testClosure_27() throws Exception {
		resolvesFeatureCallsTo(
				"{ \n" +
				"	val mapper = [ x | x ]\n" +
				"	$$ListExtensions::map(newArrayList(1), mapper)\n" +
				"}", "Integer",
				"List<Integer>", "ArrayList<Integer>", "(Integer)=>Integer");
	}

	@Test
	public void testClosure_30() throws Exception {
		resolvesFeatureCallsTo("$$ListExtensions::map(null as java.util.List<? super String>) [e|e]", "List<Object>", "Object");
	}

	@Test
	public void testClosure_31() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"  var java.util.List<? super String> list = null;\n" +
				"  $$ListExtensions::map(list) [e|e]\n" +
				"}",
				"List<Object>", "List<? super String>", "Object");
	}

	@Test
	public void testClosure_59() throws Exception {
		resolvesFeatureCallsTo(
				"{ \n" +
				"	val java.util.List<CharSequence> res = null\n" +
				"	val Iterable<? extends Object> obj = null\n" +
				"	res += obj.map[\"\"]\n" +
				"}",
				"List<CharSequence>", "boolean", "Iterable<?>", "Iterable<String>");
	}

	@Test
	public void testIfExpression_01() throws Exception {
		resolvesFeatureCallsTo("if(true) #{'f'} else emptySet", "Set<String>");
	}

	@Test
	public void testIfExpression_02() throws Exception {
		resolvesFeatureCallsTo("if(true) emptySet else #{'f'}", "Set<String>");
	}

	@Test
	public void testIfExpression_03() throws Exception {
		resolvesFeatureCallsTo(
				"{ \n" +
				"	val Iterable<Object> branch = \n" +
				"	  if (true) \n" +
				"	    [|<Object>newArrayList().iterator]\n" +
				"	  else\n" +
				"	    newArrayList('a').toArray\n" +
				"}",
				"ArrayList<Object>", "Iterator<Object>", "ArrayList<String>", "Object[]");
	}

	@Test
	public void testSwitchExpression_3() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	val Object c = null\n" +
				"	switch c {\n" +
				"	            CharSequence: 1\n" +
				"	    	}\n" +
				"}", "Object");
	}

	@Test
	public void testSwitchExpression_4() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	val Comparable<Object> c = null\n" +
				"	switch c {\n" +
				"	            CharSequence: switch(c) {\n" +
				"                    Appendable: {\n" +
				"                        c.charAt(1)\n" +
				"                    }\n" +
				"                }\n" +
				"        	}\n" +
				"}",
				"Comparable<Object>", "Comparable<Object> & CharSequence", "Comparable<Object> & CharSequence & Appendable", "char");
	}

	@Test
	public void testSwitchExpression_5() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	val Comparable<Object> c = null\n" +
				"	switch c {\n" +
				"	            CharSequence: switch(c) {\n" +
				"                    Appendable: {\n" +
				"                        c.append(null)\n" +
				"                    }\n" +
				"                }\n" +
				"        	}\n" +
				"}",
				"Comparable<Object>", "Comparable<Object> & CharSequence", "Comparable<Object> & CharSequence & Appendable", "Appendable");
	}

	@Test
	public void testSwitchExpression_6() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	val Comparable<Object> c = null\n" +
				"	switch c {\n" +
				"	            CharSequence: switch(c) {\n" +
				"                    Appendable: {\n" +
				"                        c.compareTo(null)\n" +
				"                    }\n" +
				"                }\n" +
				"        	}\n" +
				"}",
				"Comparable<Object>", "Comparable<Object> & CharSequence", "Comparable<Object> & CharSequence & Appendable", "int");
	}

	@Test
	public void testSwitchExpression_7() throws Exception {
		resolvesFeatureCallsTo(
				"switch x : 'foo' as CharSequence {\n" +
				"	Comparable : x.compareTo('')\n" +
				"}",
				"CharSequence & Comparable", "int");
	}

	@Test
	public void testTypeGuardedCase_0() throws Exception {
		resolvesFeatureCallsTo("switch s: new Object() { String: s StringBuffer: s}", "String", "StringBuffer");
	}

	@Test
	public void testTypeGuardedCase_1() throws Exception {
		resolvesFeatureCallsTo("switch s: '' as CharSequence { Cloneable: s String: s }", "CharSequence & Cloneable", "String");
	}

	@Test
	public void testBlockExpression_02() throws Exception {
		resolvesFeatureCallsTo("{val s = '' s}", "String");
	}

	@Test
	public void testBlockExpression_04() throws Exception {
		resolvesFeatureCallsTo("{val Object s = '' s}", "Object");
	}

	@Test
	public void testEMap_01() throws Exception {
		resolvesFeatureCallsTo(
				"{ \n" +
				"	val eMap = new org.eclipse.emf.common.util.BasicEMap<Integer, String>()\n" +
				"	eMap.map[ getKey ].head\n" +
				"}",
				"BasicEMap<Integer, String>", "List<Integer>", "Integer", "Integer");
	}

	@Test
	public void testEMap_02() throws Exception {
		resolvesFeatureCallsTo(
				"{ \n" +
				"	val eMap = new org.eclipse.emf.common.util.BasicEMap<Integer, String>()\n" +
				"	eMap.map[ getValue ].head\n" +
				"}",
				"BasicEMap<Integer, String>", "List<String>", "String", "String");
	}

	@Test
	public void testEMap_03() throws Exception {
		resolvesFeatureCallsTo(
				"{ \n" +
				"	val eMap = new org.eclipse.emf.common.util.BasicEMap<Integer, String>()\n" +
				"	eMap.map[ it ].head\n" +
				"}",
				"BasicEMap<Integer, String>", "List<Entry<Integer, String>>", "Entry<Integer, String>", "Entry<Integer, String>");
	}

	@Test
	public void testEMap_04() throws Exception {
		resolvesFeatureCallsTo(
				"{ \n" +
				"	val eMap = new org.eclipse.emf.common.util.BasicEMap<Integer, String>()\n" +
				"	eMap.map\n" +
				"}",
				"BasicEMap<Integer, String>", "Map<Integer, String>");
	}

	@Test
	public void testEMap_05() throws Exception {
		resolvesFeatureCallsTo(
				"{ \n" +
				"	val org.eclipse.emf.common.util.BasicEMap<? extends Integer, String> eMap = null\n" +
				"	eMap.map[ key ].head\n" +
				"}",
				"BasicEMap<? extends Integer, String>", "List<Integer>", "Integer", "Integer");
	}

	@Test
	public void testEMap_06() throws Exception {
		resolvesFeatureCallsTo(
				"{ \n" +
				"	val org.eclipse.emf.common.util.BasicEMap<? extends Integer, String> eMap = null\n" +
				"	eMap.map[ value ].head\n" +
				"}",
				"BasicEMap<? extends Integer, String>", "List<String>", "String", "String");
	}

	@Test
	public void testEMap_07() throws Exception {
		resolvesFeatureCallsTo(
				"{ \n" +
				"	val org.eclipse.emf.common.util.BasicEMap<? extends Integer, String> eMap = null\n" +
				"	eMap.map[ it ].head\n" +
				"}",
				"BasicEMap<? extends Integer, String>", "List<Entry<? extends Integer, String>>", "Entry<? extends Integer, String>",
				"Entry<? extends Integer, String>");
	}

	@Test
	public void testEMap_08() throws Exception {
		resolvesFeatureCallsTo(
				"{ \n" +
				"	val org.eclipse.emf.common.util.BasicEMap<? extends Integer, String> eMap = null\n" +
				"	eMap.map\n" +
				"}",
				"BasicEMap<? extends Integer, String>", "Map<? extends Integer, String>");
	}

	@Test
	public void testEMap_09() throws Exception {
		resolvesFeatureCallsTo(
				"{ \n" +
				"	val org.eclipse.emf.common.util.BasicEMap<? super Integer, String> eMap = null\n" +
				"	eMap.map[ key ].head\n" +
				"}",
				"BasicEMap<? super Integer, String>", "List<Object>", "Object", "Object");
	}

	@Test
	public void testEMap_10() throws Exception {
		resolvesFeatureCallsTo(
				"{ \n" +
				"	val org.eclipse.emf.common.util.BasicEMap<? super Integer, String> eMap = null\n" +
				"	eMap.map[ value ].head\n" +
				"}",
				"BasicEMap<? super Integer, String>", "List<String>", "String", "String");
	}

	@Test
	public void testEMap_11() throws Exception {
		resolvesFeatureCallsTo(
				"{ \n" +
				"	val org.eclipse.emf.common.util.BasicEMap<? super Integer, String> eMap = null\n" +
				"	eMap.map[ it ].head\n" +
				"}",
				"BasicEMap<? super Integer, String>", "List<Entry<? super Integer, String>>", "Entry<? super Integer, String>",
				"Entry<? super Integer, String>");
	}

	@Test
	public void testEMap_12() throws Exception {
		resolvesFeatureCallsTo(
				"{ \n" +
				"	val org.eclipse.emf.common.util.BasicEMap<? super Integer, String> eMap = null\n" +
				"	eMap.map\n" +
				"}",
				"BasicEMap<? super Integer, String>", "Map<? super Integer, String>");
	}

	@Test
	public void testConstructorTypeInference_02() throws Exception {
		resolvesFeatureCallsTo("<java.util.List<String>>newArrayList().add(new java.util.ArrayList())", "ArrayList<List<String>>",
				"boolean");
	}

	@Test
	public void testConstructorTypeInference_03() throws Exception {
		resolvesFeatureCallsTo("<java.util.List<String>>newArrayList().add(0, new java.util.ArrayList())", "ArrayList<List<String>>",
				"void");
	}

	@Test
	public void testConstructorTypeInference_04() throws Exception {
		resolvesFeatureCallsTo("newArrayList.add(new java.util.ArrayList())", "ArrayList<ArrayList<Object>>", "boolean");
	}

	@Test
	public void testConstructorTypeInference_08() throws Exception {
		resolvesFeatureCallsTo("new testdata.GenericType2(new Integer(0), new Integer(0).doubleValue)", "double");
	}

	@Test
	public void testConstructorTypeInference_09() throws Exception {
		resolvesFeatureCallsTo("<Iterable<String>>newArrayList().add(new java.util.LinkedList)", "ArrayList<Iterable<String>>", "boolean");
	}

	@Test
	public void testConstructorTypeInference_10() throws Exception {
		resolvesFeatureCallsTo("<Iterable<String>>newArrayList().add(null)", "ArrayList<Iterable<String>>", "boolean");
	}

	@Test
	public void testConstructorTypeInference_11() throws Exception {
		resolvesFeatureCallsTo("<java.util.Map<Iterable<String>, Iterable<Integer>>>newArrayList().head",
				"ArrayList<Map<Iterable<String>, Iterable<Integer>>>", "Map<Iterable<String>, Iterable<Integer>>");
	}

	@Test
	public void testMemberFeatureCall_03() throws Exception {
		resolvesFeatureCallsTo("newArrayList('').get(0)", "ArrayList<String>", "String");
		resolvesFeatureCallsTo("<String>newArrayList().get(0)", "ArrayList<String>", "String");
	}

	@Test
	public void testFeatureCall_06() throws Exception {
		resolvesFeatureCallsTo("newArrayList('').map(s|s)", "ArrayList<String>", "List<String>", "String");
	}

	@Test
	public void testFeatureCall_06a() throws Exception {
		resolvesFeatureCallsTo("newArrayList('').map [it|it]", "ArrayList<String>", "List<String>", "String");
	}

	@Test
	public void testFeatureCall_06b() throws Exception {
		resolvesFeatureCallsTo("newArrayList('').map [it]", "ArrayList<String>", "List<String>", "String");
	}

	@Test
	public void testFeatureCall_06c() throws Exception {
		resolvesFeatureCallsTo("(null as Iterable<String>).map(s|s)", "Iterable<String>", "String");
	}

	@Test
	public void testFeatureCall_06_00() throws Exception {
		resolvesFeatureCallsTo("$$ListExtensions::map(newArrayList('')) [s|s]", "List<String>", "ArrayList<String>", "String");
	}

	@Test
	public void testFeatureCall_06_01() throws Exception {
		resolvesFeatureCallsTo("newArrayList('').map(s|s).head", "ArrayList<String>", "List<String>", "String", "String");
	}

	@Test
	public void testFeatureCall_06_03() throws Exception {
		resolvesFeatureCallsTo("newArrayList('').map(s|1)", "ArrayList<String>", "List<Integer>");
	}

	@Test
	public void testFeatureCall_06_04() throws Exception {
		resolvesFeatureCallsTo("newArrayList('').map(s|1).head", "ArrayList<String>", "List<Integer>", "Integer");
	}

	@Test
	public void testFeatureCall_07() throws Exception {
		resolvesFeatureCallsTo("newArrayList('').map(s|s.length)", "ArrayList<String>", "List<Integer>", "String", "int");
	}

	@Test
	public void testFeatureCall_07_01() throws Exception {
		resolvesFeatureCallsTo("<String>newArrayList.map(s|s.length)", "ArrayList<String>", "List<Integer>", "String", "int");
	}

	@Test
	public void testFeatureCall_08() throws Exception {
		resolvesFeatureCallsTo("newArrayList('').map(s|s !== null)", "ArrayList<String>", "List<Boolean>", "String", "boolean");
	}

	@Test
	public void testFeatureCall_11() throws Exception {
		resolvesFeatureCallsTo("newArrayList('').map(s|1).toList()", "ArrayList<String>", "List<Integer>", "List<Integer>");
	}

	@Test
	public void testFeatureCall_13_4() throws Exception {
		resolvesFeatureCallsTo("{ var it = newArrayList('').map(s|1).toList() it }", "ArrayList<String>", "List<Integer>",
				"List<Integer>", "List<Integer>");
	}

	@Test
	public void testFeatureCall_13_5() throws Exception {
		resolvesFeatureCallsTo("{ var java.util.List<? extends Integer> it = null map(i|i+1) }", "List<Integer>", "Integer", "int");
	}

	@Test
	public void testFeatureCall_13_6() throws Exception {
		resolvesFeatureCallsTo("{ var java.util.List<? extends Integer> it = null map(i|i) }", "List<Integer>", "Integer");
	}

	@Test
	public void testFeatureCall_14() throws Exception {
		resolvesFeatureCallsTo("newArrayList(newArrayList('').map(s|1))", "ArrayList<List<Integer>>", "ArrayList<String>",
				"List<Integer>");
	}

	@Test
	public void testFeatureCall_16_a() throws Exception {
		resolvesFeatureCallsTo("newArrayList('').map(s|1).map(i|1)", "ArrayList<String>", "List<Integer>", "List<Integer>");
	}

	@Test
	public void testFeatureCall_16_b() throws Exception {
		resolvesFeatureCallsTo("newArrayList('').map(s|1).map(i|1).head", "ArrayList<String>", "List<Integer>", "List<Integer>",
				"Integer");
	}

	@Test
	public void testFeatureCall_33() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	list.findFirst[String s | true]\n" +
				"	list\n" +
				"}",
				"ArrayList<String>", "ArrayList<String>", "String", "ArrayList<String>");
	}

	@Test
	public void testFeatureCall_34() throws Exception {
		resolvesFeatureCallsTo("newArrayList.map[String s | s.substring(1,1) ]", "ArrayList<String>", "List<String>", "String", "String");
	}

	@Test
	public void testFeatureCall_35() throws Exception {
		resolvesFeatureCallsTo("newArrayList.map[ s | s.toString ]", "ArrayList<Object>", "List<String>", "Object", "String");
	}

	@Test
	public void testFeatureCall_36() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	list.forEach[ s | s.toString ]\n" +
				"}", "ArrayList<Object>",
				"ArrayList<Object>", "void", "Object", "String");
	}

	@Test
	public void testToList_01() throws Exception {
		resolvesFeatureCallsTo(
				"{ val Iterable<? extends String> iter = null org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::fixedToList(iter) }",
				"List<? extends String>", "Iterable<? extends String>");
	}

	@Test
	public void testToList_02() throws Exception {
		resolvesFeatureCallsTo(
				"{ val Iterable<? super String> iter = null org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::fixedToList(iter) }",
				"List<? super String>", "Iterable<? super String>");
	}

	@Test
	public void testToList_03() throws Exception {
		resolvesFeatureCallsTo(
				"{ val Iterable<String> iter = null org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::fixedToList(iter) }",
				"List<String>", "Iterable<String>");
	}

	@Test
	public void testToList_04() throws Exception {
		resolvesFeatureCallsTo(
				"{ val Iterable<? extends String> iter = null org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::brokenToList(iter) }",
				"List<String>", "Iterable<? extends String>");
	}

	@Test
	public void testToList_05() throws Exception {
		resolvesFeatureCallsTo(
				"{ val Iterable<? super String> iter = null org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::brokenToList(iter) }",
				"List<Object>", "Iterable<? super String>");
	}

	@Test
	public void testToList_06() throws Exception {
		resolvesFeatureCallsTo(
				"{ val Iterable<String> iter = null org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::brokenToList(iter) }",
				"List<String>", "Iterable<String>");
	}

	@Test
	public void testToList_07() throws Exception {
		resolvesFeatureCallsTo(
				"{ val Iterable<? extends String> iter = null org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::brokenToList2(iter) }",
				"List<String>", "Iterable<? extends String>");
	}

	@Test
	public void testToList_08() throws Exception {
		resolvesFeatureCallsTo(
				"{ val Iterable<? super String> iter = null org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::brokenToList2(iter) }",
				"List<String>", "Iterable<? super String>");
	}

	@Test
	public void testToList_09() throws Exception {
		resolvesFeatureCallsTo(
				"{ val Iterable<String> iter = null org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::brokenToList2(iter) }",
				"List<String>", "Iterable<String>");
	}

	@Test
	public void testFeatureCall_Bug342134_00() throws Exception {
		resolvesFeatureCallsTo("(null as java.util.List<String>).map(e|newArrayList(e)).flatten", "List<ArrayList<String>>",
				"ArrayList<String>", "String", "Iterable<String>");
	}

	@Test
	public void testFeatureCall_Bug342134_04() throws Exception {
		resolvesFeatureCallsTo("newArrayList('').map(e|newArrayList(e))", "ArrayList<String>", "List<ArrayList<String>>",
				"ArrayList<String>", "String");
	}

	@Test
	public void testFeatureCall_Bug342134_09() throws Exception {
		resolvesFeatureCallsTo("newArrayList(newArrayList('')).flatten", "ArrayList<ArrayList<String>>", "ArrayList<String>",
				"Iterable<String>");
	}

	@Test
	public void testFeatureCall_Bug342134_10() throws Exception {
		resolvesFeatureCallsTo("<java.util.List<String>>newArrayList().flatten", "ArrayList<List<String>>", "Iterable<String>");
	}

	@Test
	public void testBug_389512() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	val CharSequence s = null\n" +
				"	s.^class.declaredFields.toMap[name].mapValues[get(s)]\n" +
				"}",
				"CharSequence", "Class<? extends CharSequence>", "Field[]", "Map<String, Field>", "String", "Map<String, Object>", "Object",
				"CharSequence");
	}

	@Test
	public void testBug_391758() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	val iterable = newArrayList\n" +
				"	iterable.fold(newArrayList) [ list , elem | null as java.util.List<String> ]\n" +
				"}",
				"ArrayList<Object>", "ArrayList<Object>", "List<String>", "ArrayList<String>");
	}

	@Test
	public void testBug_406425_01() throws Exception {
		resolvesFeatureCallsTo(
			"(null as StringBuilder) => [\n" +
			"	newArrayList(it, new Long(0))\n" +
			"]", "StringBuilder",
				"ArrayList<Comparable<?> & Serializable>", "StringBuilder");
	}

	@Test
	public void testBounds_01() throws Exception {
		resolvesFeatureCallsTo("{ var java.util.List<Integer> list = null list.get(0) }", "List<Integer>", "Integer");
	}

	@Test
	public void testBounds_02() throws Exception {
		resolvesFeatureCallsTo("{ var java.util.List<? extends Integer> list = null list.get(0) }", "List<? extends Integer>", "Integer");
	}

	@Test
	public void testBounds_03() throws Exception {
		resolvesFeatureCallsTo("{ var java.util.List<? super Integer> list = null list.get(0) }", "List<? super Integer>", "Object");
	}

	@Test
	public void testBounds_04() throws Exception {
		resolvesFeatureCallsTo("{ var java.util.List<Integer> list = null list.subList(0, 1) }", "List<Integer>", "List<Integer>");
	}

	@Test
	public void testBounds_05() throws Exception {
		resolvesFeatureCallsTo("{ var java.util.List<? extends Integer> list = null list.subList(0, 1) }", "List<? extends Integer>",
				"List<? extends Integer>");
	}

	@Test
	public void testBounds_06() throws Exception {
		resolvesFeatureCallsTo("{ var java.util.List<? super Integer> list = null list.subList(0, 1) }", "List<? super Integer>",
				"List<? super Integer>");
	}

	@Test
	public void testBounds_07() throws Exception {
		resolvesFeatureCallsTo("{ var java.util.List<Integer> list = null list.last }", "List<Integer>", "Integer");
	}

	@Test
	public void testBounds_08() throws Exception {
		resolvesFeatureCallsTo("{ var java.util.List<? extends Integer> list = null list.last }", "List<? extends Integer>", "Integer");
	}

	@Test
	public void testBounds_09() throws Exception {
		resolvesFeatureCallsTo("{ var java.util.List<? super Integer> list = null list.last }", "List<? super Integer>", "Object");
	}

	@Test
	public void testBounds_10() throws Exception {
		resolvesFeatureCallsTo("{ var java.util.List<Iterable<Integer>> list = null list.last }", "List<Iterable<Integer>>",
				"Iterable<Integer>");
	}

	@Test
	public void testBounds_11() throws Exception {
		resolvesFeatureCallsTo("{ var java.util.List<Iterable<Integer>> list = null list.last.last }", "List<Iterable<Integer>>",
				"Iterable<Integer>", "Integer");
	}

	@Test
	public void testBounds_12() throws Exception {
		resolvesFeatureCallsTo("{ var java.util.List<? extends Iterable<Integer>> list = null list.last }",
				"List<? extends Iterable<Integer>>", "Iterable<Integer>");
	}

	@Test
	public void testBounds_13() throws Exception {
		resolvesFeatureCallsTo("{ var java.util.List<? extends Iterable<Integer>> list = null list.last.last }",
				"List<? extends Iterable<Integer>>", "Iterable<Integer>", "Integer");
	}

	@Test
	public void testBounds_14() throws Exception {
		resolvesFeatureCallsTo("{ var java.util.List<Iterable<? extends Integer>> list = null list.last }",
				"List<Iterable<? extends Integer>>", "Iterable<? extends Integer>");
	}

	@Test
	public void testBounds_15() throws Exception {
		resolvesFeatureCallsTo("{ var java.util.List<Iterable<? extends Integer>> list = null list.last.last }",
				"List<Iterable<? extends Integer>>", "Iterable<? extends Integer>", "Integer");
	}

	@Test
	public void testBounds_16() throws Exception {
		resolvesFeatureCallsTo("{ var java.util.List<? extends Iterable<? extends Integer>> list = null list.last }",
				"List<? extends Iterable<? extends Integer>>", "Iterable<? extends Integer>");
	}

	@Test
	public void testBounds_17() throws Exception {
		resolvesFeatureCallsTo("{ var java.util.List<? extends Iterable<? extends Integer>> list = null list.last.last }",
				"List<? extends Iterable<? extends Integer>>", "Iterable<? extends Integer>", "Integer");
	}

	@Test
	public void testBounds_18() throws Exception {
		resolvesFeatureCallsTo("{ var java.util.List<Iterable<? super Integer>> list = null list.last }", "List<Iterable<? super Integer>>",
				"Iterable<? super Integer>");
	}

	@Test
	public void testBounds_19() throws Exception {
		resolvesFeatureCallsTo("{ var java.util.List<Iterable<? super Integer>> list = null list.last.last }",
				"List<Iterable<? super Integer>>", "Iterable<? super Integer>", "Object");
	}

	@Test
	public void testBounds_20() throws Exception {
		resolvesFeatureCallsTo("{ var java.util.List<? extends Iterable<? super Integer>> list = null list.last }",
				"List<? extends Iterable<? super Integer>>", "Iterable<? super Integer>");
	}

	@Test
	public void testBounds_21() throws Exception {
		resolvesFeatureCallsTo("{ var java.util.List<? extends Iterable<? super Integer>> list = null list.last.last }",
				"List<? extends Iterable<? super Integer>>", "Iterable<? super Integer>", "Object");
	}

	@Test
	public void testPropertyAccess_01() throws Exception {
		resolvesFeatureCallsTo("{ var java.util.List<Integer> it = null empty }", "boolean");
	}

	@Test
	public void testPropertyAccess_02() throws Exception {
		resolvesFeatureCallsTo("{ var java.util.List<Integer> list = null list.empty }", "List<Integer>", "boolean");
	}

	@Test
	public void testPropertyAccess_03() throws Exception {
		resolvesFeatureCallsTo("{ var Iterable<Integer> iterable = null iterable.empty }", "Iterable<Integer>", "boolean");
	}

	@Test
	public void testPropertyAccess_04() throws Exception {
		resolvesFeatureCallsTo("{ var Iterable<Integer> it = null empty }", "boolean");
	}

	@Test
	public void testPropertyAccess_05() throws Exception {
		resolvesFeatureCallsTo("{ var Iterable<Integer> iterable = null iterable.class }", "Iterable<Integer>",
				"Class<? extends Iterable>");
	}

	@Test
	public void testPropertyAccess_06() throws Exception {
		resolvesFeatureCallsTo("{ var Iterable<Integer> it = null class }", "Class<? extends Iterable>");
	}

	@Test
	public void testReceiverIsPartiallyResolved_01() throws Exception {
		resolvesFeatureCallsTo("newArrayList.get(0)", "ArrayList<Object>", "Object");
	}

	@Test
	public void testReceiverIsPartiallyResolved_02() throws Exception {
		resolvesFeatureCallsTo("newArrayList.toString", "ArrayList<Object>", "String");
	}

	@Test
	public void testTypeByTransitiveExpectation_02() throws Exception {
		resolvesFeatureCallsTo("newArrayList.subList(1,1).subList(1,1).head", "ArrayList<Object>", "List<Object>", "List<Object>",
				"Object");
	}

	@Test
	public void testDependentTypeArgumentResolution_01() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	var Iterable<CharSequence> from = null\n" +
				"	org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::copyIntoList(from, newArrayList)\n" +
				"}",
				"void", "Iterable<CharSequence>", "ArrayList<CharSequence>");
	}

	@Test
	public void testDependentTypeArgumentResolution_02() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	var Iterable<? extends CharSequence> from = null\n" +
				"	org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::copyIntoList(from, newArrayList)\n" +
				"}",
				"void", "Iterable<? extends CharSequence>", "ArrayList<CharSequence>");
	}

	@Test
	public void testDependentTypeArgumentResolution_03() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::copyIntoList(null, newArrayList)\n" +
				"}",
				"void", "ArrayList<Object>");
	}

	@Test
	public void testDependentTypeArgumentResolution_04() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::<String>copyIntoList(null, newArrayList)\n" +
				"}",
				"void", "ArrayList<String>");
	}

	@Test
	public void testDependentTypeArgumentResolution_05() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	var Iterable<? super CharSequence> from = null\n" +
				"	org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::copyIntoList(from, newArrayList)\n" +
				"}",
				"void", "Iterable<? super CharSequence>", "ArrayList<Object>");
	}

	@Test
	public void testDependentTypeArgumentResolution_06() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	var Iterable<StringBuffer> from = null\n" +
				"	org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::constrainedCopyIntoList(from, newArrayList)\n" +
				"}",
				"void", "Iterable<StringBuffer>", "ArrayList<StringBuffer>");
	}

	@Test
	public void testDependentTypeArgumentResolution_07() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	var Iterable<? extends StringBuffer> from = null\n" +
				"	org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::constrainedCopyIntoList(from, newArrayList)\n" +
				"}",
				"void", "Iterable<? extends StringBuffer>", "ArrayList<StringBuffer>");
	}

	@Test
	public void testDependentTypeArgumentResolution_08() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::constrainedCopyIntoList(null, newArrayList)\n" +
				"}",
				"void", "ArrayList<Serializable>");
	}

	@Test
	public void testDependentTypeArgumentResolution_09() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::<String>constrainedCopyIntoList(null, newArrayList)\n" +
				"}",
				"void", "ArrayList<String>");
	}

	@Test
	public void testDependentTypeArgumentResolution_10() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	var Iterable<? super StringBuffer> from = null\n" +
				"	org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::constrainedCopyIntoList(from, newArrayList)\n" +
				"}",
				"void", "Iterable<? super StringBuffer>", "ArrayList<Object>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_002() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	val String s = list.get(0)\n" +
				"	list\n" +
				"}", "ArrayList<String>",
				"ArrayList<String>", "String", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_003() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	val String s = list.head\n" +
				"	list\n" +
				"}", "ArrayList<String>",
				"ArrayList<String>", "String", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_004() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	list.add('')\n" +
				"	list\n" +
				"}", "ArrayList<String>",
				"ArrayList<String>", "boolean", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_005() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	$$CollectionExtensions::addAll(list, null as java.util.ArrayList<String>)\n" +
				"	list\n" +
				"}",
				"ArrayList<String>", "boolean", "ArrayList<String>", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_006() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	$$CollectionExtensions::addAll(list, '', '')\n" +
				"	list\n" +
				"}",
				"ArrayList<String>", "boolean", "ArrayList<String>", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_007() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	list.addAll(null as java.util.ArrayList<String>)\n" +
				"	list\n" +
				"}",
				"ArrayList<String>", "ArrayList<String>", "boolean", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_010() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	list.addAll(null as java.util.Collection<String>)\n" +
				"	list\n" +
				"}",
				"ArrayList<String>", "ArrayList<String>", "boolean", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_011() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	list.addAll('', '', '')\n" +
				"	list\n" +
				"}",
				"ArrayList<String>", "ArrayList<String>", "boolean", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_014() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	val Iterable<String> sublist = list.subList(1, 1)\n" +
				"	list\n" +
				"}",
				"ArrayList<String>", "ArrayList<String>", "List<String>", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_015() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	val java.util.Set<String> sublist = list.subList(1, 1)\n" +
				"	list\n" +
				"}",
				"ArrayList<String>", "ArrayList<String>", "List<String>", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_017() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	for(String s: list.subList(1, 1)) {}\n" +
				"	list\n" +
				"}",
				"ArrayList<String>", "ArrayList<String>", "List<String>", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_041() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	list.addAll('')\n" +
				"	list\n" +
				"}", "ArrayList<String>",
				"ArrayList<String>", "boolean", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_047() throws Exception {
		resolvesFeatureCallsTo("println(newArrayList)", "ArrayList<Object>", "ArrayList<Object>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_068() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val String s = list.get(0)\n" +
				"	list\n" +
				"}",
				"ArrayList<String>", "String", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_069() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val String s = list.head\n" +
				"	list\n" +
				"}",
				"ArrayList<String>", "String", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_070() throws Exception {
		resolvesFeatureCallsTo("{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.add('')\n" +
				"	list\n" +
				"}", "ArrayList<String>",
				"boolean", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_071() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	$$CollectionExtensions::addAll(list, null as java.util.ArrayList<String>)\n" +
				"	list\n" +
				"}",
				"boolean", "ArrayList<String>", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_072() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	$$CollectionExtensions::addAll(list, '', '')\n" +
				"	list\n" +
				"}",
				"boolean", "ArrayList<String>", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_073() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.addAll(null as java.util.ArrayList<String>)\n" +
				"	list\n" +
				"}",
				"ArrayList<String>", "boolean", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_074() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.addAll(new java.util.ArrayList<String>)\n" +
				"	list\n" +
				"}",
				"ArrayList<String>", "boolean", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_075() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.addAll(newHashSet(''))\n" +
				"	list\n" +
				"}",
				"ArrayList<String>", "boolean", "HashSet<String>", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_076() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.addAll(null as java.util.Collection<String>)\n" +
				"	list\n" +
				"}",
				"ArrayList<String>", "boolean", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_077() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.addAll('', '', '')\n" +
				"	list.head\n" +
				"}",
				"ArrayList<String>", "boolean", "ArrayList<String>", "String");
	}

	@Test
	public void testDeferredTypeArgumentResolution_080() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val Iterable<String> sublist = list.subList(1, 1)\n" +
				"	list\n" +
				"}",
				"ArrayList<String>", "List<String>", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_081() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val java.util.Set<String> sublist = list.subList(1, 1)\n" +
				"	list\n" +
				"}",
				"ArrayList<String>", "List<String>", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_082() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val java.util.Iterator<String> sublist = list.subList(1, 1).iterator\n" +
				"	list\n" +
				"}",
				"ArrayList<String>", "List<String>", "Iterator<String>", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_083() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	for(String s: list.subList(1, 1)) {}\n" +
				"	list\n" +
				"}",
				"ArrayList<String>", "List<String>", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_107() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.addAll('')\n" +
				"	list\n" +
				"}",
				"ArrayList<String>", "boolean", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_110() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.addAll('', '', '')\n" +
				"	list\n" +
				"}",
				"ArrayList<String>", "boolean", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_114() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val String s = println(list.get(0))\n" +
				"	list\n" +
				"}",
				"String", "ArrayList<String>", "String", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_116() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	println(list).add('')\n" +
				"	list\n" +
				"}",
				"ArrayList<String>", "ArrayList<String>", "boolean", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_117() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	$$CollectionExtensions::addAll(println(list), null as java.util.ArrayList<String>)\n" +
				"	list\n" +
				"}",
				"boolean", "ArrayList<String>", "ArrayList<String>", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_119() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	println(list).addAll(null as java.util.ArrayList<String>)\n" +
				"	list\n" +
				"}",
				"ArrayList<String>", "ArrayList<String>", "boolean", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_123() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	println(list).addAll('', '', '')\n" +
				"	list\n" +
				"}",
				"ArrayList<String>", "ArrayList<String>", "boolean", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_134() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.map[String s| s]\n" +
				"	list\n" +
				"}",
				"ArrayList<String>", "List<String>", "String", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_138() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	$$CollectionExtensions::<String>addAll(list, null, null)\n" +
				"	list\n" +
				"}",
				"ArrayList<String>", "boolean", "ArrayList<String>", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_158() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	list.addAll(null as String[])\n" +
				"	list\n" +
				"}",
				"ArrayList<String>", "ArrayList<String>", "boolean", "ArrayList<String>");
	}

	@Test
	public void testRecursiveTypeArgumentResolution_05() throws Exception {
		resolvesFeatureCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.addAll(list)\n" +
				"	list\n" +
				"}",
				"ArrayList<Object>", "boolean", "ArrayList<Object>", "ArrayList<Object>");
	}

	@Test
	public void testFeatureCallWithOperatorOverloading_2() throws Exception {
		resolvesFeatureCallsTo("new java.util.ArrayList<Byte>() += 'x'.getBytes().iterator.next", "boolean", "byte[]", "Iterator<Byte>",
				"Byte");
	}

	@Test
	public void testFeatureCallWithOperatorOverloading_3() throws Exception {
		resolvesFeatureCallsTo(
				"{ \n" +
				"	val java.util.List<? super CharSequence> list = null\n" +
				"	list += null as Iterable<CharSequence>\n" +
				"}",
				"List<? super CharSequence>", "boolean");
	}

	@Test
	public void testFeatureCallWithOperatorOverloading_5() throws Exception {
		resolvesFeatureCallsTo("new java.util.ArrayList<Byte>() += 'x'.getBytes()", "boolean", "byte[]");
	}

	@Test
	public void testFeatureCallWithOperatorOverloading_6() throws Exception {
		if (JavaRuntimeVersion.isJava12OrLater()) {
			resolvesFeatureCallsTo(
				"newHashMap( 5 -> '', '' -> 5 )",
					"HashMap<Comparable<?> & Constable & ConstantDesc & Serializable, Comparable<?> & Constable & ConstantDesc & Serializable>",
					"Pair<Integer, String>", "Pair<String, Integer>");
		} else {
			resolvesFeatureCallsTo(
				"newHashMap( 5 -> '', '' -> 5 )",
					"HashMap<Comparable<?> & Serializable, Comparable<?> & Serializable>", "Pair<Integer, String>",
					"Pair<String, Integer>");
		}
	}

	@Test
	public void testFeatureCallOnIt() throws Exception {
		resolvesFeatureCallsTo("{ val it = 'foo'; length == 3;}", "int", "boolean");
	}

	@Test
	public void testStaticMethods_03() throws Exception {
		resolvesFeatureCallsTo("newArrayList(newHashSet(''))", "ArrayList<HashSet<String>>", "HashSet<String>");
	}
}
