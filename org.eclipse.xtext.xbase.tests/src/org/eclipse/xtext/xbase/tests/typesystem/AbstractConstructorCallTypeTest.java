/**
 * Copyright (c) 2012, 2021 itemis AG (http://www.itemis.eu) and others.
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
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
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
public abstract class AbstractConstructorCallTypeTest extends AbstractXbaseTestCase {
	public abstract void resolvesConstructorCallsTo(String expression, String... types) throws Exception;

	private static Set<String> seenExpressions;

	@BeforeClass
	public static void createSeenExpressionsSet() {
		seenExpressions = new HashSet<>();
	}

	@AfterClass
	public static void discardSeenExpressions() {
		seenExpressions = null;
	}

	protected List<XConstructorCall> findConstructorCalls(CharSequence expression) throws Exception {
		XExpression xExpression = expression(expression, false);
		Assert.assertTrue(xExpression.eResource().getErrors().isEmpty());
		List<XConstructorCall> closures = IteratorExtensions
				.toList(Iterators.filter(EcoreUtil2.eAll(xExpression), XConstructorCall.class));
		return IterableExtensions.sortBy(closures, (Function1<XConstructorCall, Integer>) (XConstructorCall it) -> {
			return Iterables.getFirst(NodeModelUtils.findNodesForFeature(it, XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR), null)
					.getOffset();
		});
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
	public void testAssignment_01() throws Exception {
		resolvesConstructorCallsTo("new testdata.FieldAccess().stringField = null", "FieldAccess");
	}

	@Test
	public void testAssignment_02() throws Exception {
		resolvesConstructorCallsTo("new testdata.FieldAccess().stringField = new Object", "FieldAccess", "Object");
	}

	@Test
	public void testAssignment_03() throws Exception {
		resolvesConstructorCallsTo("new testdata.FieldAccess().stringField = ''", "FieldAccess");
	}

	@Test
	public void testOverloadedOperators_10() throws Exception {
		resolvesConstructorCallsTo("(1..2).map[ new java.math.BigInteger(toString) ].reduce[ i1, i2| i1 + i2 ]", "BigInteger");
	}

	@Test
	public void testOverloadedOperators_15() throws Exception {
		resolvesConstructorCallsTo("(1..2).map[ new java.math.BigInteger(toString) ].map[ i | i.toString + i ]", "BigInteger");
	}

	@Test
	public void testOverloadedOperators_16() throws Exception {
		resolvesConstructorCallsTo("(1..2).map[ new java.math.BigInteger(toString) ].map[ i | i + String::valueOf(i) ]", "BigInteger");
	}

	@Test
	public void testThrowExpression() throws Exception {
		resolvesConstructorCallsTo("throw new Exception()", "Exception");
	}

	@Test
	public void testMethodTypeParamInference_00() throws Exception {
		resolvesConstructorCallsTo("new java.util.ArrayList<String>().findFirst(e | true)", "ArrayList<String>");
	}

	@Test
	public void testMethodTypeParamInference_01() throws Exception {
		resolvesConstructorCallsTo("new java.util.ArrayList<String>().findFirst(e|e == 'foo')", "ArrayList<String>");
	}

	@Test
	public void testMethodTypeParamInference_02() throws Exception {
		resolvesConstructorCallsTo("new java.util.ArrayList<String>().<String>findFirst(e|e == 'foo')", "ArrayList<String>");
	}

	@Test
	public void testMethodTypeParamInference_03() throws Exception {
		resolvesConstructorCallsTo("$$IterableExtensions::findFirst(new java.util.ArrayList<String>) [e | true]", "ArrayList<String>");
	}

	@Test
	public void testMethodTypeParamInference_04() throws Exception {
		resolvesConstructorCallsTo("$$IterableExtensions::findFirst(new java.util.ArrayList<String>) [e|e == 'foo']",
				"ArrayList<String>");
	}

	@Test
	public void testMethodTypeParamInference_05() throws Exception {
		resolvesConstructorCallsTo("$$IterableExtensions::<String>findFirst(new java.util.ArrayList<String>) [e|e == 'foo']",
				"ArrayList<String>");
	}

	@Test
	public void testClosure_01() throws Exception {
		resolvesConstructorCallsTo("{ var closure = [|'literal']\n" +
				"" +
				"  new testdata.ClosureClient().invoke0(closure)	}", "ClosureClient");
	}

	@Test
	public void testTypeArgs() throws Exception {
		resolvesConstructorCallsTo("new java.util.ArrayList<String>() += 'foo'", "ArrayList<String>");
	}

	@Test
	public void testIfExpression_02() throws Exception {
		resolvesConstructorCallsTo("if (true) new StringBuilder() else new StringBuffer()", "StringBuilder", "StringBuffer");
	}

	@Test
	public void testTypeGuardedCase_0() throws Exception {
		resolvesConstructorCallsTo("switch s: new Object() { String: s StringBuffer: s}", "Object");
	}

	@Test
	public void testEMap_01() throws Exception {
		resolvesConstructorCallsTo(
				"{ \n" +
				"	val eMap = new org.eclipse.emf.common.util.BasicEMap<Integer, String>()\n" +
				"	eMap.map[ getKey ].head\n" +
				"}",
				"BasicEMap<Integer, String>");
	}

	@Test
	public void testEMap_02() throws Exception {
		resolvesConstructorCallsTo(
				"{ \n" +
				"	val eMap = new org.eclipse.emf.common.util.BasicEMap<Integer, String>()\n" +
				"	eMap.map[ getValue ].head\n" +
				"}",
				"BasicEMap<Integer, String>");
	}

	@Test
	public void testEMap_03() throws Exception {
		resolvesConstructorCallsTo(
				"{ \n" +
				"	val eMap = new org.eclipse.emf.common.util.BasicEMap<Integer, String>()\n" +
				"	eMap.map[ it ].head\n" +
				"}",
				"BasicEMap<Integer, String>");
	}

	@Test
	public void testEMap_04() throws Exception {
		resolvesConstructorCallsTo(
				"{ \n" +
				"	val eMap = new org.eclipse.emf.common.util.BasicEMap<Integer, String>()\n" +
				"	eMap.map\n" +
				"}",
				"BasicEMap<Integer, String>");
	}

	@Test
	public void testConstructorTypeParameters_01() throws Exception {
		resolvesConstructorCallsTo("new java.util.ArrayList<? extends String>()", "ArrayList<String>");
	}

	@Test
	public void testConstructorTypeParameters_02() throws Exception {
		resolvesConstructorCallsTo("new java.util.ArrayList<? super String>()", "ArrayList<String>");
	}

	@Test
	public void testConstructorTypeParameters_03() throws Exception {
		resolvesConstructorCallsTo("new java.util.ArrayList<? super Iterable<? super String>>()", "ArrayList<Iterable<? super String>>");
	}

	@Test
	public void testConstructorTypeParameters_04() throws Exception {
		resolvesConstructorCallsTo("new java.util.ArrayList<? extends Iterable<? extends String>>()",
				"ArrayList<Iterable<? extends String>>");
	}

	@Test
	public void testConstructorTypeParameters_05() throws Exception {
		resolvesConstructorCallsTo("new constructorTypeParameters.KeyValue(null, '')", "KeyValue");
	}

	@Test
	public void testConstructorTypeParameters_06() throws Exception {
		resolvesConstructorCallsTo("new constructorTypeParameters.KeyValue(new constructorTypeParameters.WritableValue, '')", "KeyValue",
				"WritableValue<String>");
	}

	@Test
	public void testConstructorTypeParameters_07() throws Exception {
		resolvesConstructorCallsTo("new constructorTypeParameters.KeyValue(new constructorTypeParameters.WritableDoubleValue, 1.0)",
				"KeyValue", "WritableDoubleValue");
	}

	@Test
	public void testConstructorTypeParameters_08() throws Exception {
		resolvesConstructorCallsTo("new constructorTypeParameters.KeyValue(new constructorTypeParameters.WritableValue, 1.0)", "KeyValue",
				"WritableValue<Double>");
	}

	@Test
	public void testConstructorTypeInference_01() throws Exception {
		resolvesConstructorCallsTo("{ var Iterable<? extends String> it = new java.util.ArrayList() }", "ArrayList<String>");
	}

	@Test
	public void testConstructorTypeInference_02() throws Exception {
		resolvesConstructorCallsTo("<java.util.List<String>>newArrayList().add(new java.util.ArrayList())", "ArrayList<String>");
	}

	@Test
	public void testConstructorTypeInference_03() throws Exception {
		resolvesConstructorCallsTo("<java.util.List<String>>newArrayList().add(0, new java.util.ArrayList())", "ArrayList<String>");
	}

	@Test
	public void testConstructorTypeInference_04() throws Exception {
		resolvesConstructorCallsTo("newArrayList.add(new java.util.ArrayList())", "ArrayList<Object>");
	}

	@Test
	public void testConstructorTypeInference_05() throws Exception {
		resolvesConstructorCallsTo("{ var Iterable<? super String> it = new java.util.ArrayList() }", "ArrayList<String>");
	}

	@Test
	public void testConstructorTypeInference_06() throws Exception {
		resolvesConstructorCallsTo("{ var Iterable<? extends String> it = { var x = new java.util.ArrayList() x } }", "ArrayList<String>");
	}

	@Test
	public void testConstructorTypeInference_07() throws Exception {
		resolvesConstructorCallsTo("{ var Iterable<? extends String> it = { var x = new java.util.ArrayList() var y = x y } }",
				"ArrayList<String>");
	}

	@Test
	public void testConstructorTypeInference_08() throws Exception {
		if (JavaRuntimeVersion.isJava12OrLater()) {
			resolvesConstructorCallsTo("new testdata.GenericType2(new Integer(0), new Integer(0).doubleValue)",
					"GenericType2<Number & Comparable<?> & Constable & ConstantDesc>", "Integer", "Integer");
		} else {
			resolvesConstructorCallsTo("new testdata.GenericType2(new Integer(0), new Integer(0).doubleValue)",
					"GenericType2<Number & Comparable<?>>", "Integer", "Integer");
		}
	}

	@Test
	public void testConstructorTypeInference_09() throws Exception {
		resolvesConstructorCallsTo("<Iterable<String>>newArrayList().add(new java.util.LinkedList)", "LinkedList<String>");
	}

	@Test
	public void testConstructorTypeInference_10() throws Exception {
		resolvesConstructorCallsTo("{ var Iterable<? extends Iterable<? super String>> it = new java.util.ArrayList() }",
				"ArrayList<Iterable<? super String>>");
	}

	@Test
	public void testConstructorTypeInference_11() throws Exception {
		resolvesConstructorCallsTo("{ var Iterable<? super Iterable<? super String>> it = new java.util.ArrayList() }",
				"ArrayList<Iterable<? super String>>");
	}

	@Test
	public void testConstructorTypeInference_12() throws Exception {
		resolvesConstructorCallsTo("{ var java.util.Map<? super String, ? super String> it = new java.util.HashMap }",
				"HashMap<String, String>");
	}

	@Test
	public void testVarArgs_01() throws Exception {
		resolvesConstructorCallsTo("newArrayList(new Double('-20'), new Integer('20'))", "Double", "Integer");
	}

	@Test
	public void testVarArgs_02() throws Exception {
		resolvesConstructorCallsTo("newArrayList(if (true) new Double('-20') else new Integer('20'))", "Double", "Integer");
	}

	@Test
	public void testVarArgs_03() throws Exception {
		resolvesConstructorCallsTo("newArrayList(if (true) new Double('-20') else new Integer('20'), new Integer('29'))", "Double",
				"Integer", "Integer");
	}

	@Test
	public void testVarArgs_04() throws Exception {
		resolvesConstructorCallsTo("newArrayList(if (true) new Double('-20') else new Integer('20'), new Double('29'))", "Double",
				"Integer", "Double");
	}

	@Test
	public void testVarArgs_05() throws Exception {
		resolvesConstructorCallsTo(
				"newArrayList(if (true) new Double('-20') else new Integer('20'), new Integer('29'), new Double('29'))", "Double",
				"Integer", "Integer", "Double");
	}

	@Test
	public void testFeatureCall_03() throws Exception {
		resolvesConstructorCallsTo("new testdata.ClassWithVarArgs().toList()", "ClassWithVarArgs");
		resolvesConstructorCallsTo("new testdata.ClassWithVarArgs().toList('')", "ClassWithVarArgs");
		resolvesConstructorCallsTo("new testdata.ClassWithVarArgs().toList('', '')", "ClassWithVarArgs");
	}

	@Test
	public void testFeatureCall_03_a() throws Exception {
		resolvesConstructorCallsTo("new testdata.ClassWithVarArgs().toList(null as String[])", "ClassWithVarArgs");
	}

	@Test
	public void testFeatureCall_03_b() throws Exception {
		resolvesConstructorCallsTo("new testdata.ClassWithVarArgs().toList(null as int[])", "ClassWithVarArgs");
	}

	@Test
	public void testFeatureCall_04() throws Exception {
		resolvesConstructorCallsTo("new testdata.ClassWithVarArgs().toList('', 1)", "ClassWithVarArgs");
	}

	@Test
	public void testFeatureCall_05() throws Exception {
		resolvesConstructorCallsTo("new testdata.ClassWithVarArgs().toNumberList()", "ClassWithVarArgs");
		resolvesConstructorCallsTo("new testdata.ClassWithVarArgs().toNumberList(0)", "ClassWithVarArgs");
		resolvesConstructorCallsTo("new testdata.ClassWithVarArgs().toNumberList(0, 1)", "ClassWithVarArgs");
		resolvesConstructorCallsTo("new testdata.ClassWithVarArgs().toNumberList(new Integer(0), new Integer(0).doubleValue)",
				"ClassWithVarArgs", "Integer", "Integer");
	}

	@Test
	public void testFeatureCall_05_b() throws Exception {
		resolvesConstructorCallsTo("new testdata.ClassWithVarArgs().toNumberList(null as Float[])", "ClassWithVarArgs");
	}

	@Test
	public void testFeatureCall_26() throws Exception {
		resolvesConstructorCallsTo(
				"{ val list = newArrayList(if (false) new Double('-20') else new Integer('20')).map(v|v.intValue)\n" +
				"           val Object o = list.head \n" +
				"           list\n" +
				"        }",
				"Double", "Integer");
	}

	@Test
	public void testFeatureCall_26a() throws Exception {
		resolvesConstructorCallsTo(
				"{ val list = newArrayList(if (false) new Double('-20') else new Integer('20')).map(v|v.intValue)\n" +
				"           val Object o = list.head \n" +
				"           list.head\n" +
				"        }",
				"Double", "Integer");
	}

	@Test
	public void testFeatureCall_27() throws Exception {
		resolvesConstructorCallsTo(
				"{ val list = $$ListExtensions::map(newArrayList(if (false) new Double('-20') else new Integer('20'))) [ v|v.intValue ]\n" +
				"           val Object o = list.head \n" +
				"           list\n" +
				"        }",
				"Double", "Integer");
	}

	@Test
	public void testDependentTypeArgumentResolution_01() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	var Iterable<CharSequence> from = null\n" +
				"	org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::copyIntoList(from, new java.util.ArrayList)\n" +
				"}",
				"ArrayList<CharSequence>");
	}

	@Test
	public void testDependentTypeArgumentResolution_02() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	var Iterable<? extends CharSequence> from = null\n" +
				"	org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::copyIntoList(from, new java.util.ArrayList)\n" +
				"}",
				"ArrayList<CharSequence>");
	}

	@Test
	public void testDependentTypeArgumentResolution_03() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::copyIntoList(null, new java.util.ArrayList)\n" +
				"}",
				"ArrayList<Object>");
	}

	@Test
	public void testDependentTypeArgumentResolution_04() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::<String>copyIntoList(null, new java.util.ArrayList)\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDependentTypeArgumentResolution_05() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	var Iterable<? super CharSequence> from = null\n" +
				"	org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::copyIntoList(from, new java.util.ArrayList)\n" +
				"}",
				"ArrayList<Object>");
	}

	@Test
	public void testDependentTypeArgumentResolution_06() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	var Iterable<StringBuilder> from = null\n" +
				"	org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::constrainedCopyIntoList(from, new java.util.ArrayList)\n" +
				"}",
				"ArrayList<StringBuilder>");
	}

	@Test
	public void testDependentTypeArgumentResolution_07() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	var Iterable<? extends StringBuilder> from = null\n" +
				"	org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::constrainedCopyIntoList(from, new java.util.ArrayList)\n" +
				"}",
				"ArrayList<StringBuilder>");
	}

	@Test
	public void testDependentTypeArgumentResolution_08() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::constrainedCopyIntoList(null, new java.util.ArrayList)\n" +
				"}",
				"ArrayList<Serializable>");
	}

	@Test
	public void testDependentTypeArgumentResolution_09() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::<String>constrainedCopyIntoList(null, new java.util.ArrayList)\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDependentTypeArgumentResolution_10() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	var Iterable<? super StringBuilder> from = null\n" +
				"	org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::constrainedCopyIntoList(from, new java.util.ArrayList)\n" +
				"}",
				"ArrayList<Object>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_064() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	list.add(println(new Integer(0)))\n" +
				"	list.add(println(new Integer(0).doubleValue))\n" +
				"	list\n" +
				"}",
				"Integer", "Integer");
	}

	@Test
	public void testDeferredTypeArgumentResolution_065() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	list.add(println(new Integer(0)))\n" +
				"	println(list.get(0)).toString\n" +
				"	list.add(println(new Integer(0).doubleValue))\n" +
				"	list\n" +
				"}",
				"Integer", "Integer");
	}

	@Test
	public void testDeferredTypeArgumentResolution_068() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val String s = list.get(0)\n" +
				"	list\n" +
				"}", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_069() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val String s = list.head\n" +
				"	list\n" +
				"}", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_070() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.add('')\n" +
				"	list\n" +
				"}", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_071() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	$$CollectionExtensions::addAll(list, null as java.util.ArrayList<String>)\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_072() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	$$CollectionExtensions::addAll(list, '', '')\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_073() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.addAll(null as java.util.ArrayList<String>)\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_074() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.addAll(new java.util.ArrayList<String>)\n" +
				"	list\n" +
				"}",
				"ArrayList<String>", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_075() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.addAll(newHashSet(''))\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_076() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.addAll(null as java.util.Collection<String>)\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_077() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.addAll('', '', '')\n" +
				"	list.head\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_078() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val secondList = new java.util.ArrayList\n" +
				"	list.add('')\n" +
				"	list.addAll(secondList)\n" +
				"	secondList\n" +
				"}",
				"ArrayList<String>", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_079() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val secondList = new java.util.ArrayList\n" +
				"	list.addAll(secondList)\n" +
				"	list.add('')\n" +
				"	secondList\n" +
				"}",
				"ArrayList<String>", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_080() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val Iterable<String> sublist = list.subList(1, 1)\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_081() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val java.util.Set<String> sublist = list.subList(1, 1)\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_082() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val java.util.Iterator<String> sublist = list.subList(1, 1).iterator\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_083() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	for(String s: list.subList(1, 1)) {}\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_084() throws Exception {
		if (JavaRuntimeVersion.isJava12OrLater()) {
			resolvesConstructorCallsTo(
				"{\n" +
				"val list = new java.util.ArrayList\n" +
				"list.add(new Integer(0))\n" +
				"list.add(new Integer(0).doubleValue)\n" +
				"list\n" +
				"	}",
					"ArrayList<Number & Comparable<?> & Constable & ConstantDesc>", "Integer", "Integer");
		} else {
			resolvesConstructorCallsTo(
				"{\n" +
				"val list = new java.util.ArrayList\n" +
				"list.add(new Integer(0))\n" +
				"list.add(new Integer(0).doubleValue)\n" +
				"list\n" +
				"	}",
					"ArrayList<Number & Comparable<?>>", "Integer", "Integer");
		}
	}

	@Test
	public void testDeferredTypeArgumentResolution_085() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.add(new Integer(0))\n" +
				"	list.get(0).toString\n" +
				"	list.add(new Integer(0).doubleValue)\n" +
				"	list\n" +
				"}",
				"ArrayList<Integer>", "Integer", "Integer");
	}

	@Test
	public void testDeferredTypeArgumentResolution_086() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val second = new java.util.ArrayList\n" +
				"	list.add(second.get(0))\n" +
				"	list.add('')\n" +
				"	list\n" +
				"}",
				"ArrayList<String>", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_087() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val second = new java.util.ArrayList\n" +
				"	list.add(second.get(0))\n" +
				"	list.add('')\n" +
				"	second\n" +
				"}",
				"ArrayList<String>", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_088() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val second = new java.util.ArrayList\n" +
				"	list.add(second.head)\n" +
				"	list.add('')\n" +
				"	list\n" +
				"}",
				"ArrayList<String>", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_089() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val second = new java.util.ArrayList\n" +
				"	list.add(second.head)\n" +
				"	list.add('')\n" +
				"	second\n" +
				"}",
				"ArrayList<String>", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_090() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val second = new java.util.ArrayList\n" +
				"	list.add('')\n" +
				"	list.add(second.get(0))\n" +
				"	list\n" +
				"}",
				"ArrayList<String>", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_091() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val second = new java.util.ArrayList\n" +
				"	list.add('')\n" +
				"	list.add(second.get(0))\n" +
				"	second\n" +
				"}",
				"ArrayList<String>", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_092() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val second = new java.util.ArrayList\n" +
				"	list.add('')\n" +
				"	list.add(second.head)\n" +
				"	list\n" +
				"}",
				"ArrayList<String>", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_093() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val second = new java.util.ArrayList\n" +
				"	list.add('')\n" +
				"	list.add(second.head)\n" +
				"	second\n" +
				"}",
				"ArrayList<String>", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_094() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val second = new java.util.ArrayList\n" +
				"	list.add(second.get(0))\n" +
				"	second.add('')\n" +
				"	list\n" +
				"}",
				"ArrayList<String>", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_095() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val second = new java.util.ArrayList\n" +
				"	list.add(second.get(0))\n" +
				"	second.add('')\n" +
				"	second\n" +
				"}",
				"ArrayList<String>", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_096() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val second = new java.util.ArrayList\n" +
				"	list.add(second.head)\n" +
				"	second.add('')\n" +
				"	list\n" +
				"}",
				"ArrayList<String>", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_097() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val second = new java.util.ArrayList\n" +
				"	list.add(second.head)\n" +
				"	second.add('')\n" +
				"	second\n" +
				"}",
				"ArrayList<String>", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_098() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val second = new java.util.ArrayList\n" +
				"	second.add('')\n" +
				"	list.add(second.get(0))\n" +
				"	list\n" +
				"}",
				"ArrayList<String>", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_099() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val second = new java.util.ArrayList\n" +
				"	second.add('')\n" +
				"	list.add(second.get(0))\n" +
				"	second\n" +
				"}",
				"ArrayList<String>", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_100() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val second = new java.util.ArrayList\n" +
				"	second.add('')\n" +
				"	list.add(second.head)\n" +
				"	list\n" +
				"}",
				"ArrayList<String>", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_101() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val second = new java.util.ArrayList\n" +
				"	second.add('')\n" +
				"	list.add(second.head)\n" +
				"	second\n" +
				"}",
				"ArrayList<String>", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_102() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.add(new java.util.HashSet)\n" +
				"	val Iterable<String> s = list.head\n" +
				"	list.head\n" +
				"}",
				"ArrayList<HashSet<String>>", "HashSet<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_103() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.add(new java.util.ArrayList)\n" +
				"	val Iterable<String> s = list.flatten\n" +
				"	list.head\n" +
				"}",
				"ArrayList<ArrayList<String>>", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_104() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.add(newHashSet)\n" +
				"	val String s = list.flatten.head\n" +
				"	list.head\n" +
				"}",
				"ArrayList<HashSet<String>>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_105() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.add(new java.util.ArrayList)\n" +
				"	val String s = list.flatten.head\n" +
				"	list.head\n" +
				"}",
				"ArrayList<ArrayList<String>>", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_106() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val second = new java.util.ArrayList\n" +
				"	second.add(new java.util.ArrayList)\n" +
				"	val String s = second.flatten.head\n" +
				"	list.add(second.head)\n" +
				"	list.head\n" +
				"}",
				"ArrayList<ArrayList<String>>", "ArrayList<ArrayList<String>>", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_107() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.addAll('')\n" +
				"	list\n" +
				"}", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_108() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val secondList = new java.util.ArrayList\n" +
				"	list.addAll('')\n" +
				"	list.addAll(secondList)\n" +
				"	secondList\n" +
				"}",
				"ArrayList<String>", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_109() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val secondList = new java.util.ArrayList\n" +
				"	list.addAll(secondList)\n" +
				"	list.addAll('')\n" +
				"	secondList\n" +
				"}",
				"ArrayList<String>", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_110() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.addAll('', '', '')\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_111() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val secondList = new java.util.ArrayList\n" +
				"	list.addAll('', '', '')\n" +
				"	list.addAll(secondList)\n" +
				"	secondList\n" +
				"}",
				"ArrayList<String>", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_112() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val secondList = new java.util.ArrayList\n" +
				"	list.addAll(secondList)\n" +
				"	list.addAll('', '', '')\n" +
				"	secondList\n" +
				"}",
				"ArrayList<String>", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_113() throws Exception {
		resolvesConstructorCallsTo("println(new java.util.ArrayList)", "ArrayList<Object>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_114() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val String s = println(list.get(0))\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_115() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val String s = println(println(list).head)\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_116() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	println(list).add('')\n" +
				"	list\n" +
				"}", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_117() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	$$CollectionExtensions::addAll(println(list), null as java.util.ArrayList<String>)\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_118() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	$$CollectionExtensions::addAll(println(list), println(''), println(''))\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_119() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	println(list).addAll(null as java.util.ArrayList<String>)\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_120() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	println(list).addAll(println(new java.util.ArrayList<String>))\n" +
				"	println(list)\n" +
				"}",
				"ArrayList<String>", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_121() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = println(new java.util.ArrayList)\n" +
				"	println(list).addAll(println(newHashSet('')))\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_122() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = println(new java.util.ArrayList)\n" +
				"	println(list).addAll(null as java.util.Collection<String>)\n" +
				"	println(list)\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_123() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	println(list).addAll('', '', '')\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_124() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = println(new java.util.ArrayList)\n" +
				"	val secondList = println(new java.util.ArrayList)\n" +
				"	println(list).add('')\n" +
				"	println(list).addAll(println(secondList))\n" +
				"	secondList\n" +
				"}",
				"ArrayList<String>", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_125() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = println(new java.util.ArrayList)\n" +
				"	val secondList = println(new java.util.ArrayList)\n" +
				"	println(list).addAll(println(secondList))\n" +
				"	println(list).add('')\n" +
				"	println(secondList)\n" +
				"}",
				"ArrayList<String>", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_126() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val Iterable<String> sublist = println(println(list).subList(1, 1))\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_127() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val java.util.Set<String> sublist = println(println(list).subList(1, 1))\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_128() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val java.util.Iterator<String> sublist = println(println(println(list).subList(1, 1)).iterator)\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_129() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = println(new java.util.ArrayList)\n" +
				"	for(String s: println(list.subList(1, 1))) {}\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_130() throws Exception {
		if (JavaRuntimeVersion.isJava12OrLater()) {
			resolvesConstructorCallsTo(
					"{\n" +
				"val list = new java.util.ArrayList\n" +
				"list.add(println(new Integer(0)))\n" +
				"list.add(println(new Integer(0).doubleValue))\n" +
				"list\n" +
				"	}",
					"ArrayList<Number & Comparable<?> & Constable & ConstantDesc>", "Integer", "Integer");
		} else {
			resolvesConstructorCallsTo(
					"{\n" +
				"val list = new java.util.ArrayList\n" +
				"list.add(println(new Integer(0)))\n" +
				"list.add(println(new Integer(0).doubleValue))\n" +
				"list\n" +
				"	}",
					"ArrayList<Number & Comparable<?>>", "Integer", "Integer");
		}
	}

	@Test
	public void testDeferredTypeArgumentResolution_131() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.add(println(new Integer(0)))\n" +
				"	println(list.get(0)).toString\n" +
				"	list.add(println(new Integer(0).doubleValue))\n" +
				"	list\n" +
				"}",
				"ArrayList<Integer>", "Integer", "Integer");
	}

	@Test
	public void testDeferredTypeArgumentResolution_132() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val second = new java.util.ArrayList\n" +
				"	println(list).add(println(second.get(0)))\n" +
				"	println(list).add('')\n" +
				"	list\n" +
				"}",
				"ArrayList<String>", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_134() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.map[String s| s]\n" +
				"	list\n" +
				"}", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_136() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.add(new java.util.ArrayList)\n" +
				"	val Iterable<String> s = list.head\n" +
				"	list.head\n" +
				"}",
				"ArrayList<ArrayList<String>>", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_143() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.add(new java.util.ArrayList)\n" +
				"	val Iterable<String> s = $$IterableExtensions::head(list)\n" +
				"	list.head\n" +
				"}",
				"ArrayList<ArrayList<String>>", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_144() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.add(new java.util.ArrayList)\n" +
				"	val Iterable<String> s = list.head.head\n" +
				"	list.head\n" +
				"}",
				"ArrayList<ArrayList<Iterable<String>>>", "ArrayList<Iterable<String>>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_145() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.add(new java.util.ArrayList)\n" +
				"	val Iterable<String> s = list.head.flatten.head\n" +
				"	list.head\n" +
				"}",
				"ArrayList<ArrayList<Iterable<? extends Iterable<String>>>>", "ArrayList<Iterable<? extends Iterable<String>>>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_146() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.add(new java.util.ArrayList)\n" +
				"	val String s = list.head.head\n" +
				"	list.head\n" +
				"}",
				"ArrayList<ArrayList<String>>", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_147() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.add(new java.util.ArrayList)\n" +
				"	val String s = list.head.flatten.head\n" +
				"	list.head\n" +
				"}",
				"ArrayList<ArrayList<Iterable<? extends String>>>", "ArrayList<Iterable<? extends String>>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_148() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.add(new java.util.ArrayList)\n" +
				"	val Iterable<String> s = $$IterableExtensions::flatten(list)\n" +
				"	list.head\n" +
				"}",
				"ArrayList<ArrayList<String>>", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_149() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.add(newHashSet)\n" +
				"	val String s = $$IterableExtensions::flatten(list).head\n" +
				"	list.head\n" +
				"}",
				"ArrayList<HashSet<String>>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_150() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.add(new java.util.ArrayList)\n" +
				"	val String s = $$IterableExtensions::flatten(list).head\n" +
				"	list.head\n" +
				"}",
				"ArrayList<ArrayList<String>>", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_151() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val second = new java.util.ArrayList\n" +
				"	second.add(new java.util.ArrayList)\n" +
				"	val String s = $$IterableExtensions::flatten(second).head\n" +
				"	list.add(second.head)\n" +
				"	list.head\n" +
				"}",
				"ArrayList<ArrayList<String>>", "ArrayList<ArrayList<String>>", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_155() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.map(println([String s| println(s)]))\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testRecursiveTypeArgumentResolution_05() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.addAll(list)\n" +
				"	list\n" +
				"}", "ArrayList<Object>");
	}

	@Test
	public void testRecursiveTypeArgumentResolution_06() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.add(list.head)\n" +
				"	list\n" +
				"}", "ArrayList<Object>");
	}

	@Test
	public void testRecursiveTypeArgumentResolution_07() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.addAll(list)\n" +
				"	list.add('')\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testRecursiveTypeArgumentResolution_08() throws Exception {
		resolvesConstructorCallsTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.add(list.head)\n" +
				"	list.add('')\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testFeatureCallWithOperatorOverloading_2() throws Exception {
		resolvesConstructorCallsTo("new java.util.ArrayList<Byte>() += 'x'.getBytes().iterator.next", "ArrayList<Byte>");
	}

	@Test
	public void testFeatureCallWithOperatorOverloading_3() throws Exception {
		resolvesConstructorCallsTo("new java.util.ArrayList<Byte>() += null", "ArrayList<Byte>");
	}

	@Test
	public void testFeatureCallWithOperatorOverloading_4() throws Exception {
		resolvesConstructorCallsTo("new java.util.ArrayList<Byte>() += newArrayList('x'.getBytes().iterator.next)", "ArrayList<Byte>");
	}

	@Test
	public void testFeatureCallWithOperatorOverloading_5() throws Exception {
		resolvesConstructorCallsTo("new java.util.ArrayList<Byte>() += 'x'.getBytes()", "ArrayList<Byte>");
	}
}
