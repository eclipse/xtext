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
import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.linking.impl.XtextLinkingDiagnostic;
import org.eclipse.xtext.resource.XtextSyntaxDiagnostic;
import org.eclipse.xtext.testing.smoketest.IgnoredBySmokeTest;
import org.eclipse.xtext.util.JavaRuntimeVersion;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.google.common.collect.Iterables;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractTypeResolverTest<Reference extends Object> extends AbstractXbaseTestCase {
	public abstract Reference resolvesTo(String expression, String type) throws Exception;

	public abstract void isFunctionAndEquivalentTo(Reference reference, String type);

	private static Set<String> seenExpressions;

	@BeforeClass
	public static void createSeenExpressionsSet() {
		seenExpressions = new HashSet<>();
	}

	@AfterClass
	public static void discardSeenExpressions() {
		seenExpressions = null;
	}

	@Override
	protected XExpression expression(CharSequence expression, boolean resolve) throws Exception {
		String string = expression.toString().replace("$$", "org::eclipse::xtext::xbase::lib::");
		if (!seenExpressions.add(string)) {
			this.handleDuplicateExpression(expression);
			return null;
		}
		return super.expression(string, resolve);
	}

	public Iterable<Resource.Diagnostic> getLinkingAndSyntaxErrors(Resource resource) {
		return Iterables.filter(resource.getErrors(), it -> it instanceof XtextSyntaxDiagnostic || it instanceof XtextLinkingDiagnostic);
	}

	protected void handleDuplicateExpression(CharSequence expression) {
		Assert.fail("Duplicate expression under test: " + expression);
	}

	@Test
	public void testRawType_01() throws Exception {
		resolvesTo("{ val java.util.Set set = newHashSet() set }", "Set");
	}

	@Test
	public void testRawType_02() throws Exception {
		resolvesTo("{ val java.util.Set set = newHashSet set.head }", "Object");
	}

	@Test
	public void testRawType_03() throws Exception {
		resolvesTo("(null as java.util.Set<java.util.Set>).head", "Set");
	}

	@Test
	public void testRawType_04() throws Exception {
		resolvesTo("{ val java.util.Set<java.util.Set> set = newHashSet set }", "Set<Set>");
	}

	@Test
	public void testAssignment_01() throws Exception {
		resolvesTo("new testdata.FieldAccess().stringField = null", "String");
	}

	@Test
	public void testAssignment_02() throws Exception {
		resolvesTo("new testdata.FieldAccess().stringField = new Object", "String");
	}

	@Test
	public void testAssignment_03() throws Exception {
		resolvesTo("new testdata.FieldAccess().stringField = ''", "String");
	}

	@Test
	public void testAssignment_04() throws Exception {
		resolvesTo(
				"{\n" +
				"	var Comparable<Object> it = null\n" +
				"	switch it {\n" +
				"		CharSequence: { it.length it = null }\n" +
				"	}\n" +
				"}",
				"Comparable<Object>");
	}

	@Test
	public void testAssignment_05() throws Exception {
		resolvesTo(
				"{\n" +
				"	val Comparable<Object> it = null\n" +
				"	switch it {\n" +
				"		CharSequence: it = null\n" +
				"	}\n" +
				"}",
				"Comparable<Object> & CharSequence");
	}

	@Test
	public void testAssignment_06() throws Exception {
		resolvesTo(
				"{\n" +
				"	var Comparable<Object> it = null\n" +
				"	switch it {\n" +
				"		CharSequence: { it = null it }\n" +
				"	}\n" +
				"}",
				"Comparable<Object>");
	}

	@Test
	public void testReassignedTypeDiscarded_01() throws Exception {
		resolvesTo(
				"{\n" +
				"	var Comparable<Object> it = null\n" +
				"	switch it {\n" +
				"		CharSequence: it\n" +
				"	}\n" +
				"	it\n" +
				"}",
				"Comparable<Object>");
	}

	@Test
	public void testNullLiteral() throws Exception {
		resolvesTo("null", "null");
	}

	@Test
	public void testTypeLiteral() throws Exception {
		resolvesTo("typeof(String)", "Class<String>");
	}

	@Test
	public void testTypeLiteral_1() throws Exception {
		resolvesTo("typeof(String[])", "Class<String[]>");
	}

	@Test
	public void testTypeLiteral_2() throws Exception {
		resolvesTo("typeof(void)", "Class<Void>");
	}

	@Test
	public void testTypeLiteral_3() throws Exception {
		resolvesTo("typeof(int)", "Class<Integer>");
	}

	@Test
	public void testTypeLiteral_4() throws Exception {
		resolvesTo("typeof(int[])", "Class<int[]>");
	}

	@Test
	public void testTypeLiteral_5() throws Exception {
		resolvesTo("typeof(int[]).superclass", "Class<? super int[]>");
	}

	@Test
	public void testTypeLiteral_6() throws Exception {
		resolvesTo("String", "Class<String>");
	}

	@Test
	public void testTypeLiteral_7() throws Exception {
		resolvesTo("void", "Class<Void>");
	}

	@Test
	public void testTypeLiteral_8() throws Exception {
		resolvesTo("int", "Class<Integer>");
	}

	@Test
	public void testTypeLiteral_9() throws Exception {
		resolvesTo("java.lang.String", "Class<String>");
	}

	@Test
	public void testBooleanLiteral() throws Exception {
		resolvesTo("true", "boolean");
		resolvesTo("false", "boolean");
	}

	@Test
	public void testBooleanLiteral_02() throws Exception {
		resolvesTo("return true", "void");
	}

	@Test
	public void testStringLiteral_01() throws Exception {
		resolvesTo("'foo'", "String");
		resolvesTo("\"foo\"", "String");
	}

	@Test
	public void testStringLiteral_02() throws Exception {
		resolvesTo("''", "String");
	}

	@Test
	public void testStringLiteral_03() throws Exception {
		resolvesTo("'1'", "String");
	}

	@Test
	public void testStringLiteral_04() throws Exception {
		resolvesTo("newArrayList('1')", "ArrayList<String>");
	}

	@Test
	public void testStringLiteral_05() throws Exception {
		if (JavaRuntimeVersion.isJava15OrLater()) {
			resolvesTo("newArrayList(null as Character, '1')", "ArrayList<Serializable & Comparable<?> & Constable>");
		} else {
			resolvesTo("newArrayList(null as Character, '1')", "ArrayList<Serializable & Comparable<?>>");
		}
	}

	@Test
	public void testStringLiteral_06() throws Exception {
		if (JavaRuntimeVersion.isJava15OrLater()) {
			resolvesTo("newArrayList(null as Character, '11')", "ArrayList<Serializable & Comparable<?> & Constable>");
		} else {
			resolvesTo("newArrayList(null as Character, '11')", "ArrayList<Serializable & Comparable<?>>");
		}
	}

	@Test
	public void testNumberLiteral_0() throws Exception {
		resolvesTo("3", "int");
	}

	@Test
	public void testNumberLiteral_1() throws Exception {
		resolvesTo("0x42", "int");
	}

	@Test
	public void testNumberLiteral_2() throws Exception {
		resolvesTo("1L", "long");
	}

	@Test
	public void testNumberLiteral_3() throws Exception {
		resolvesTo("0x42#l", "long");
	}

	@Test
	public void testNumberLiteral_4() throws Exception {
		resolvesTo("1f", "float");
	}

	@Test
	public void testNumberLiteral_5() throws Exception {
		resolvesTo("1.0f", "float");
	}

	@Test
	public void testNumberLiteral_6() throws Exception {
		resolvesTo("1.0E10f", "float");
	}

	@Test
	public void testNumberLiteral_7() throws Exception {
		resolvesTo("1.0e-10f", "float");
	}

	@Test
	public void testNumberLiteral_8() throws Exception {
		resolvesTo("1.0E+10f", "float");
	}

	@Test
	public void testNumberLiteral_9() throws Exception {
		resolvesTo("1.0", "double");
	}

	@Test
	public void testNumberLiteral_10() throws Exception {
		resolvesTo("1.0E10", "double");
	}

	@Test
	public void testNumberLiteral_11() throws Exception {
		resolvesTo("1.0e-10", "double");
	}

	@Test
	public void testNumberLiteral_12() throws Exception {
		resolvesTo("1.0E+10", "double");
	}

	@Test
	public void testNumberLiteral_13() throws Exception {
		resolvesTo("1.0d", "double");
	}

	@Test
	public void testNumberLiteral_14() throws Exception {
		resolvesTo("1.0E10d", "double");
	}

	@Test
	public void testNumberLiteral_15() throws Exception {
		resolvesTo("1.0e-10d", "double");
	}

	@Test
	public void testNumberLiteral_16() throws Exception {
		resolvesTo("1.0E+10d", "double");
	}

	@Test
	public void testNumberLiteral_17() throws Exception {
		resolvesTo("1234567890123456789012345678901234567890bi", "BigInteger");
	}

	@Test
	public void testNumberLiteral_17a() throws Exception {
		resolvesTo("0x1234567890123456789012345678901234567890#bi", "BigInteger");
	}

	@Test
	public void testNumberLiteral_18() throws Exception {
		resolvesTo("1.0bD", "BigDecimal");
	}

	@Test
	public void testNumberLiteral_19() throws Exception {
		resolvesTo("1.0E10Bd", "BigDecimal");
	}

	@Test
	public void testNumberLiteral_20() throws Exception {
		resolvesTo("1.0e-10bd", "BigDecimal");
	}

	@Test
	public void testNumberLiteral_21() throws Exception {
		resolvesTo("1.0E+10BD", "BigDecimal");
	}

	@Test
	public void testNumberLiteral_22() throws Exception {
		resolvesTo("1E+10BD", "BigDecimal");
	}

	@Test
	public void testNumberLiteral_23() throws Exception {
		resolvesTo("1E-10", "double");
	}

	@Test
	public void testNumberLiteral_24() throws Exception {
		resolvesTo("1E10f", "float");
	}

	@Test
	public void testNumberLiteral_25() throws Exception {
		resolvesTo("1bi.toString", "String");
	}

	@Test
	public void testNumberLiteralInClosure_01() throws Exception {
		resolvesTo("newArrayList().map[42]", "List<Integer>");
	}

	@Test
	public void testListLiteral_00() throws Exception {
		resolvesTo("#[]", "List<Object>");
	}

	@Test
	public void testListLiteral_01() throws Exception {
		resolvesTo("#['foo']", "List<String>");
	}

	@Test
	public void testListLiteral_02() throws Exception {
		resolvesTo("#['foo', null, 'bar']", "List<String>");
	}

	@Test
	public void testListLiteral_03() throws Exception {
		resolvesTo("#[null]", "List<Object>");
	}

	@Test
	public void testListLiteral_04() throws Exception {
		resolvesTo("#[1, 2, 3]", "List<Integer>");
	}

	@Test
	public void testListLiteral_05() throws Exception {
		if (JavaRuntimeVersion.isJava12OrLater()) {
			resolvesTo("#[1, 2.0, 3]", "List<? extends Number & Comparable<?> & Constable & ConstantDesc>");
		} else {
			resolvesTo("#[1, 2.0, 3]", "List<? extends Number & Comparable<?>>");
		}
	}

	@Test
	public void testListLiteral_06() throws Exception {
		resolvesTo("{ val java.util.List<Number> foo = #[1, 2.0, 3bi] foo }", "List<Number>");
	}

	@Test
	public void testListLiteral_07() throws Exception {
		resolvesTo("{ val java.util.List<CharSequence> foo = #['foo', 'bar'] foo }", "List<CharSequence>");
	}

	@Test
	public void testListLiteral_08() throws Exception {
		resolvesTo("{ val String[] foo = #['foo', 'bar'] foo }", "String[]");
	}

	@Test
	public void testListLiteral_09() throws Exception {
		resolvesTo("{ val x = #[] val String[] y = x x }", "List<String>");
	}

	@Test
	public void testListLiteral_10() throws Exception {
		resolvesTo("{ val x = #[null] val String[] y = x x }", "List<String>");
	}

	@Test
	public void testListLiteral_11() throws Exception {
		resolvesTo("{ val x = #[] val Iterable<String> y = x x }", "List<String>");
	}

	@Test
	public void testListLiteral_12() throws Exception {
		resolvesTo("{ val x = #[null] val java.util.Set<String> y = x x }", "List<String>");
	}

	@Test
	public void testListLiteral_13() throws Exception {
		resolvesTo("#[#['foo'], #{}]", "List<? extends Collection<String>>");
	}

	@Test
	public void testListLiteral_14() throws Exception {
		resolvesTo("newArrayList(#['foo'], #{})", "ArrayList<Collection<String>>");
	}

	@Test
	public void testSetLiteral_00() throws Exception {
		resolvesTo("#{}", "Set<Object>");
	}

	@Test
	public void testSetLiteral_01() throws Exception {
		resolvesTo("#{'foo'}", "Set<String>");
	}

	@Test
	public void testSetLiteral_02() throws Exception {
		resolvesTo("#{'foo', null, 'bar'}", "Set<String>");
	}

	@Test
	public void testSetLiteral_03() throws Exception {
		resolvesTo("#{null}", "Set<Object>");
	}

	@Test
	public void testSetLiteral_04() throws Exception {
		resolvesTo("#{1, 2 ,3}", "Set<Integer>");
	}

	@Test
	public void testSetLiteral_05() throws Exception {
		if (JavaRuntimeVersion.isJava12OrLater()) {
			resolvesTo("#{1, 2.0 ,3}", "Set<? extends Number & Comparable<?> & Constable & ConstantDesc>");
		} else {
			resolvesTo("#{1, 2.0 ,3}", "Set<? extends Number & Comparable<?>>");
		}
	}

	@Test
	public void testSetLiteral_06() throws Exception {
		resolvesTo("{ val java.util.Set<Number> foo = #{1, 2.0, 3bi} foo }", "Set<Number>");
	}

	@Test
	public void testSetLiteral_07() throws Exception {
		resolvesTo("{ val java.util.Set<CharSequence> foo = #{'foo', 'bar'} foo }", "Set<CharSequence>");
	}

	@Test
	public void testSetLiteral_08() throws Exception {
		resolvesTo("#{'foo' -> 'bar'}", "Map<String, String>");
	}

	@Test
	public void testSetLiteral_09() throws Exception {
		resolvesTo("#{'foo' -> true, 'bar' -> false}", "Map<String, Boolean>");
	}

	@Test
	public void testSetLiteral_10() throws Exception {
		resolvesTo("#{'foo'-> new Exception('ohoh'),'bar'->new Error('ohohoh')}", "Map<String, Throwable>");
	}

	@Test
	public void testSetLiteral_11() throws Exception {
		resolvesTo("{ val java.util.Map<String,String> x = #{} x }", "Map<String, String>");
	}

	@Test
	public void testSetLiteral_12() throws Exception {
		resolvesTo("{ val java.util.Set<org.eclipse.xtext.xbase.lib.Pair<String,Object>> foo = #{'foo'->'bar'} foo }",
				"Set<Pair<String, Object>>");
	}

	@Test
	public void testOverloadedVarArgs_01() throws Exception {
		resolvesTo("testdata::OverloadedMethods::overloadedVarArgs(null, null)", "long");
	}

	@Test
	public void testOverloadedVarArgs_02() throws Exception {
		resolvesTo("testdata::OverloadedMethods::overloadedVarArgs()", "int");
	}

	@Test
	public void testOverloadedVarArgs_03() throws Exception {
		resolvesTo("testdata::OverloadedMethods::overloadedVarArgs('', '')", "long");
	}

	@Test
	public void testOverloadedVarArgs_04() throws Exception {
		resolvesTo("testdata::OverloadedMethods::overloadedVarArgs(new Object, new Object, new Object)", "int");
	}

	@Test
	public void testOverloadedTypeParameters_01() throws Exception {
		resolvesTo("testdata::OverloadedMethods::<String>overloadedTypeParameters(null)", "int");
	}

	@Test
	public void testOverloadedTypeParameters_02() throws Exception {
		resolvesTo("testdata::OverloadedMethods::<String, String>overloadedTypeParameters(null)", "long");
	}

	@Test
	public void testOverloadedMethods_01() throws Exception {
		resolvesTo(
				"{\n" +
				"	var java.util.List<CharSequence> list = null\n" +
				"	var Object o = null\n" +
				"	org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloaded(list, o)\n" +
				"}",
				"int");
	}

	@Test
	public void testOverloadedMethods_02() throws Exception {
		resolvesTo(
				"{\n" +
				"	var java.util.List<CharSequence> list = null\n" +
				"	var String s = null\n" +
				"	org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloaded(list, s)\n" +
				"}",
				"long");
	}

	@Test
	public void testOverloadedMethods_03() throws Exception {
		resolvesTo(
				"{\n" +
				"	var java.util.List<? extends CharSequence> list = null\n" +
				"	var Object o = null\n" +
				"	org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloaded(list, o)\n" +
				"}",
				"int");
	}

	@Test
	public void testOverloadedMethods_04() throws Exception {
		resolvesTo(
				"{\n" +
				"	var java.util.List<? extends CharSequence> list = null\n" +
				"	var String s = null\n" +
				"	org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloaded(list, s)\n" +
				"}",
				"int");
	}

	@Test
	public void testOverloadedMethods_05() throws Exception {
		resolvesTo(
				"{\n" +
				"	var java.util.List<CharSequence> list = null\n" +
				"	org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloaded(list, null)\n" +
				"}",
				"long");
	}

	@Test
	public void testOverloadedMethods_06() throws Exception {
		resolvesTo(
				"{\n" +
				"	var java.util.List<? extends CharSequence> list = null\n" +
				"	org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloaded(list, null)\n" +
				"}",
				"int");
	}

	@Test
	public void testOverloadedMethods_07() throws Exception {
		resolvesTo(
				"{\n" +
				"	var java.util.List<CharSequence> list = null\n" +
				"	var Object o = null\n" +
				"	org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloadedWithTypeParam(list, o)\n" +
				"}",
				"int");
	}

	@Test
	public void testOverloadedMethods_08() throws Exception {
		resolvesTo(
				"{\n" +
				"	var java.util.List<CharSequence> list = null\n" +
				"	var String s = null\n" +
				"	org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloadedWithTypeParam(list, s)\n" +
				"}",
				"long");
	}

	@Test
	public void testOverloadedMethods_09() throws Exception {
		resolvesTo(
				"{\n" +
				"	var java.util.List<? extends CharSequence> list = null\n" +
				"	var Object o = null\n" +
				"	org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloadedWithTypeParam(list, o)\n" +
				"}",
				"int");
	}

	@Test
	public void testOverloadedMethods_10() throws Exception {
		resolvesTo(
				"{\n" +
				"	var java.util.List<? extends CharSequence> list = null\n" +
				"	var String s = null\n" +
				"	org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloadedWithTypeParam(list, s)\n" +
				"}",
				"long");
	}

	@Test
	public void testOverloadedMethods_11() throws Exception {
		resolvesTo(
				"{\n" +
				"	var java.util.List<CharSequence> list = null\n" +
				"	org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloadedWithTypeParam(list, null)\n" +
				"}",
				"long");
	}

	@Test
	public void testOverloadedMethods_12() throws Exception {
		resolvesTo(
				"{\n" +
				"	var java.util.List<? extends CharSequence> list = null\n" +
				"	org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloadedWithTypeParam(list, null)\n" +
				"}",
				"long");
	}

	@Test
	public void testBoxing_01() throws Exception {
		resolvesTo("1.toString", "String");
	}

	@Test
	public void testOverloadedOperators_01() throws Exception {
		resolvesTo("1 + 1", "int");
	}

	@Test
	public void testOverloadedOperators_02() throws Exception {
		resolvesTo("1L + 1", "long");
	}

	@Test
	public void testOverloadedOperators_03() throws Exception {
		resolvesTo("1 + 1L", "long");
	}

	@Test
	public void testOverloadedOperators_04() throws Exception {
		resolvesTo("'' + ''", "String");
	}

	@Test
	public void testOverloadedOperators_05() throws Exception {
		resolvesTo("'' + 1", "String");
	}

	@Test
	public void testOverloadedOperators_06() throws Exception {
		resolvesTo("1 + ''", "String");
	}

	@Test
	public void testOverloadedOperators_07() throws Exception {
		resolvesTo("(0..Math::sqrt(1l).intValue).filter[ i | 1l % i == 0 ].isEmpty", "boolean");
	}

	@Test
	public void testOverloadedOperators_08() throws Exception {
		resolvesTo("(1..2).map[ toString ].reduce[ i1, i2| i1 + i2 ]", "String");
	}

	@Test
	public void testOverloadedOperators_09() throws Exception {
		resolvesTo("(1..2).map[ toString.length ].reduce[ i1, i2| i1 + i2 ]", "Integer");
	}

	@Test
	public void testOverloadedOperators_10() throws Exception {
		resolvesTo("(1..2).map[ new java.math.BigInteger(toString) ].reduce[ i1, i2| i1 + i2 ]", "BigInteger");
	}

	@Test
	public void testOverloadedOperators_11() throws Exception {
		resolvesTo("(1..2).map[ new java.math.BigInteger(toString) ].reduce[ i1, i2 | i1.toString + i2 ]", "Comparable<?> & Serializable");
	}

	@Test
	public void testOverloadedOperators_12() throws Exception {
		resolvesTo(
				"{\n" +
				"	val i = 1bi\n" +
				"	val s = ''\n" +
				"	s + i\n" +
				"}", "String");
	}

	@Test
	public void testOverloadedOperators_13() throws Exception {
		resolvesTo("(1..2).map[ new java.math.BigInteger(toString) ].reduce[ i1, i2| i1 + String::valueOf(i2) ]", "Comparable<?> & Serializable");
	}

	@Test
	public void testOverloadedOperators_14() throws Exception {
		resolvesTo(
				"{\n" +
				"	val i = 1bi\n" +
				"	val s = ''\n" +
				"	i + s\n" +
				"}", "String");
	}

	@Test
	public void testOverloadedOperators_15() throws Exception {
		resolvesTo("(1..2).map[ new java.math.BigInteger(toString) ].map[ i | i.toString + i ]", "Iterable<String>");
	}

	@Test
	public void testOverloadedOperators_16() throws Exception {
		resolvesTo("(1..2).map[ new java.math.BigInteger(toString) ].map[ i | i + String::valueOf(i) ]", "Iterable<String>");
	}

	@Test
	public void testOverloadedOperators_17() throws Exception {
		resolvesTo("(0..Math::sqrt(1l).intValue).filter[ i | 1l % i == 0 ].empty", "boolean");
	}

	@Test
	public void testOverloadedOperators_18() throws Exception {
		resolvesTo("'a' + 1", "String");
	}

	@Test
	public void testOverloadedOperators_19() throws Exception {
		resolvesTo("'aa' + 1", "String");
	}

	@Test
	public void testOverloadedOperators_20() throws Exception {
		resolvesTo("(null as Iterable<StringBuilder>) + (null as Iterable<StringBuffer>) + (null as Iterable<String>)",
				"Iterable<Serializable & Comparable<?> & CharSequence>");
	}

	@Test
	public void testCastExpression() throws Exception {
		resolvesTo("null as String", "String");
		resolvesTo("null as Boolean", "Boolean");
	}

	@Test
	public void testCastExpression_02() throws Exception {
		resolvesTo("(null as Iterable<String[]>)", "Iterable<String[]>");
	}

	@Test
	public void testThrowExpression() throws Exception {
		resolvesTo("throw new Exception()", "void");
	}

	@Test
	public void testTryCatchFinallyExpression_00() throws Exception {
		resolvesTo("try 'foo' catch (Exception e) 'bar'", "String");
	}

	@Test
	public void testTryCatchFinallyExpression_01() throws Exception {
		resolvesTo("try 'foo' catch (Exception e) 'bar' catch(RuntimeException e) 'baz'", "String");
	}

	@Test
	public void testTryCatchFinallyExpression_02() throws Exception {
		resolvesTo("try 'foo' catch (Exception e) 'bar' catch(RuntimeException e) 'baz' finally true", "String");
	}

	@Test
	public void testTryCatchFinallyExpression_03() throws Exception {
		if (JavaRuntimeVersion.isJava15OrLater()) {
			resolvesTo("try { 'literal' as Object as Boolean } catch(ClassCastException e) 'caught'", "Serializable & Comparable<?> & Constable");
		} else {
			resolvesTo("try { 'literal' as Object as Boolean } catch(ClassCastException e) 'caught'", "Serializable & Comparable<?>");
		}
	}

	@Test
	public void testTryCatchFinallyExpression_04() throws Exception {
		if (JavaRuntimeVersion.isJava15OrLater()) {
			resolvesTo("try { 'literal' as Object as Boolean } catch(ClassCastException e) {'caught'}", "Serializable & Comparable<?> & Constable");
		} else {
			resolvesTo("try { 'literal' as Object as Boolean } catch(ClassCastException e) {'caught'}", "Serializable & Comparable<?>");
		}
	}

	@Test
	public void testTryCatchFinallyExpression_05() throws Exception {
		if (JavaRuntimeVersion.isJava15OrLater()) {
			resolvesTo(
					"try 'literal' as Object as Boolean\n" +
							"  catch(NullPointerException e) 'second thing is thrown'		  \n" +
							"  catch(ClassCastException e) throw new NullPointerException()\n",
					"Serializable & Comparable<?> & Constable");
		} else {
			resolvesTo(
					"try 'literal' as Object as Boolean\n" +
							"  catch(NullPointerException e) 'second thing is thrown'		  \n" +
							"  catch(ClassCastException e) throw new NullPointerException()\n",
					"Serializable & Comparable<?>");
		}
	}

	@Test
	public void testTryCatchFinallyExpression_06() throws Exception {
		if (JavaRuntimeVersion.isJava15OrLater()) {
			resolvesTo(
					"try 'literal' as Object as Boolean\n" +
							"  catch(ClassCastException e) throw new NullPointerException()\n" +
							"  catch(NullPointerException e) 'dont catch subsequent exceptions'",
					"Serializable & Comparable<?> & Constable");
		} else {
			resolvesTo(
					"try 'literal' as Object as Boolean\n" +
							"  catch(ClassCastException e) throw new NullPointerException()\n" +
							"  catch(NullPointerException e) 'dont catch subsequent exceptions'",
					"Serializable & Comparable<?>");
		}
	}

	@Test
	public void testTryCatchFinallyExpression_07() throws Exception {
		resolvesTo(
				"try 'literal' as Object as Boolean\n" +
				"  catch(ClassCastException e) null as Number\n" +
				"  catch(NullPointerException e) 'dont catch subsequent exceptions'",
				"Serializable");
	}

	@Test
	public void testTryCatchFinallyExpression_08() throws Exception {
		resolvesTo("try return 'foo' catch (Exception e) return 'bar'", "void");
	}

	@Test
	public void testTryCatchFinallyExpression_09() throws Exception {
		resolvesTo("try return 'foo' catch (Exception e) return 'bar' catch(RuntimeException e) return 'baz'", "void");
	}

	@Test
	public void testTryCatchFinallyExpression_10() throws Exception {
		resolvesTo("try return 'foo' catch (Exception e) return 'bar' catch(RuntimeException e) return 'baz' finally true", "void");
	}

	@Test
	public void testTryCatchFinallyExpression_11() throws Exception {
		resolvesTo("try { return 'literal' as Object as Boolean } catch(ClassCastException e) return 'caught'", "void");
	}

	@Test
	public void testTryCatchFinallyExpression_12() throws Exception {
		resolvesTo("try { return 'literal' as Object as Boolean } catch(ClassCastException e) {return 'caught'}", "void");
	}

	@Test
	public void testTryCatchFinallyExpression_13() throws Exception {
		resolvesTo(
				"try return 'literal' as Object as Boolean\n" +
				"  catch(NullPointerException e) return 'second thing is thrown'		  \n" +
				"  catch(ClassCastException e) throw new NullPointerException()\n",
				"void");
	}

	@Test
	public void testTryCatchFinallyExpression_14() throws Exception {
		resolvesTo(
				"try return 'literal' as Object as Boolean\n" +
				"  catch(ClassCastException e) throw new NullPointerException()\n" +
				"  catch(NullPointerException e) return 'dont catch subsequent exceptions'",
				"void");
	}

	@Test
	public void testTryCatchFinallyExpression_15() throws Exception {
		resolvesTo(
				"try return 'literal' as Object as Boolean\n" +
				"  catch(ClassCastException e) return null as Number\n" +
				"  catch(NullPointerException e) return 'dont catch subsequent exceptions'",
				"void");
	}

	@Test
	public void testTryCatchFinallyExpression_16() throws Exception {
		resolvesTo("try return 'foo' catch (Exception e) 'bar'", "String");
	}

	@Test
	public void testTryCatchFinallyExpression_17() throws Exception {
		resolvesTo("try return 'foo' catch (Exception e) 'bar' catch(RuntimeException e) 'baz'", "String");
	}

	@Test
	public void testTryCatchFinallyExpression_18() throws Exception {
		resolvesTo("try return 'foo' catch (Exception e) 'bar' catch(RuntimeException e) 'baz' finally true", "String");
	}

	@Test
	public void testTryCatchFinallyExpression_19() throws Exception {
		resolvesTo("try { return 'literal' as Object as Boolean } catch(ClassCastException e) 'caught'", "String");
	}

	@Test
	public void testTryCatchFinallyExpression_20() throws Exception {
		resolvesTo("try { return 'literal' as Object as Boolean } catch(ClassCastException e) {'caught'}", "String");
	}

	@Test
	public void testTryCatchFinallyExpression_21() throws Exception {
		resolvesTo(
				"try return 'literal' as Object as Boolean\n" +
				"  catch(NullPointerException e) 'second thing is thrown'		  \n" +
				"  catch(ClassCastException e) throw new NullPointerException()\n",
				"String");
	}

	@Test
	public void testTryCatchFinallyExpression_22() throws Exception {
		resolvesTo(
				"try return 'literal' as Object as Boolean\n" +
				"  catch(ClassCastException e) throw new NullPointerException()\n" +
				"  catch(NullPointerException e) 'dont catch subsequent exceptions'",
				"String");
	}

	@Test
	public void testTryCatchFinallyExpression_23() throws Exception {
		resolvesTo(
				"try return 'literal' as Object as Boolean\n" +
				"  catch(ClassCastException e) null as Number\n" +
				"  catch(NullPointerException e) 'dont catch subsequent exceptions'",
				"Serializable");
	}

	@Test
	public void testTryCatchFinallyExpression_24() throws Exception {
		resolvesTo("try 'foo' catch (Exception e) return 'bar'", "String");
	}

	@Test
	public void testTryCatchFinallyExpression_25() throws Exception {
		resolvesTo("try 1 catch (Exception e) return 'bar' catch(RuntimeException e) return 'baz'", "int");
	}

	@Test
	public void testTryCatchFinallyExpression_26() throws Exception {
		resolvesTo("try 'foo' catch (Exception e) 'bar' catch(RuntimeException e) return 1 finally true", "String");
	}

	@Test
	public void testTryCatchFinallyExpression_27() throws Exception {
		resolvesTo("try { 'literal' as Object as Boolean } catch(ClassCastException e) return 'caught'", "Boolean");
	}

	@Test
	public void testTryCatchFinallyExpression_28() throws Exception {
		resolvesTo("try { 'literal' as Object as Boolean } catch(ClassCastException e) {return 'caught'}", "Boolean");
	}

	@Test
	public void testTryCatchFinallyExpression_29() throws Exception {
		resolvesTo(
				"try 'literal' as Object as Boolean\n" +
				"  catch(NullPointerException e) return 'second thing is thrown'		  \n" +
				"  catch(ClassCastException e) throw new NullPointerException()\n",
				"Boolean");
	}

	@Test
	public void testTryCatchFinallyExpression_30() throws Exception {
		resolvesTo(
				"try 'literal' as Object as Boolean\n" +
				"  catch(ClassCastException e) throw new NullPointerException()\n" +
				"  catch(NullPointerException e) return 'dont catch subsequent exceptions'",
				"Boolean");
	}

	@Test
	public void testTryCatchFinallyExpression_31() throws Exception {
		resolvesTo(
				"try 'literal' as Object as Boolean\n" +
				"  catch(ClassCastException e) return null as Number\n" +
				"  catch(NullPointerException e) return 'dont catch subsequent exceptions'",
				"Boolean");
	}

	@Test
	public void testForExpression_01() throws Exception {
		resolvesTo("for(String x : new java.util.ArrayList<String>()) x.length", "void");
		resolvesTo("for(String x : newArrayList('foo')) x.length", "void");
		resolvesTo("for(String x : <String>newArrayList()) x.length", "void");
	}

	@Test
	public void testForExpression_02() throws Exception {
		resolvesTo("for(x : new java.util.ArrayList<String>()) x.length", "void");
		resolvesTo("for(x : <String>newArrayList()) x.length", "void");
		resolvesTo("for(x : newArrayList('foo')) x.length", "void");
	}

	@Test
	public void testForExpression_03() throws Exception {
		resolvesTo("for(String x : null as String[]) x.length", "void");
	}

	@Test
	public void testForExpression_04() throws Exception {
		resolvesTo("for(x : null as String[]) x.length", "void");
	}

	@Test
	public void testForExpression_05() throws Exception {
		resolvesTo("for(String x : new java.util.ArrayList<String>()) return x.length", "void");
		resolvesTo("for(String x : newArrayList('foo')) return x.length", "void");
		resolvesTo("for(String x : <String>newArrayList()) return x.length", "void");
	}

	@Test
	public void testForExpression_06() throws Exception {
		resolvesTo("for(x : new java.util.ArrayList<String>()) return x.length", "void");
		resolvesTo("for(x : <String>newArrayList()) return x.length", "void");
		resolvesTo("for(x : newArrayList('foo')) return x.length", "void");
	}

	@Test
	public void testForExpression_07() throws Exception {
		resolvesTo("for(String x : null as String[]) return x.length", "void");
	}

	@Test
	public void testForExpression_08() throws Exception {
		resolvesTo("for(x : null as String[]) return x.length", "void");
	}

	@Test
	public void testForExpression_09() throws Exception {
		resolvesTo("for(x : null as String[]) return", "void");
	}

	@Test
	public void testWhileExpression_01() throws Exception {
		resolvesTo("while(true) ''.length", "void");
	}

	@Test
	public void testWhileExpression_02() throws Exception {
		resolvesTo("while(true) return ''.length", "void");
	}

	@Test
	public void testImplicitImportPrintln_01() throws Exception {
		resolvesTo("println(null)", "Object");
	}

	@Test
	public void testImplicitImportPrintln_02() throws Exception {
		resolvesTo("<String>println(null)", "String");
	}

	@Test
	public void testImplicitImportEmptyList() throws Exception {
		resolvesTo("<String>emptyList", "List<String>");
		resolvesTo("emptyList", "List<Object>");
	}

	@Test
	public void testElvisWithEmptyListInLamdba() throws Exception {
		resolvesTo(
				"[ String s |\n" +
				"	val result = <Integer>newArrayList\n" +
				"	val (String)=>Iterable<Integer> fun = []\n" +
				"	result += fun.apply(s) ?: emptyList\n" +
				"	result\n" +
				"]",
				"(String)=>ArrayList<Integer>");
	}

	@Test
	public void testMethodTypeParamInference_00() throws Exception {
		resolvesTo("new java.util.ArrayList<String>().findFirst(e | true)", "String");
	}

	@Test
	public void testMethodTypeParamInference_01() throws Exception {
		resolvesTo("new java.util.ArrayList<String>().findFirst(e|e == 'foo')", "String");
	}

	@Test
	public void testMethodTypeParamInference_02() throws Exception {
		resolvesTo("new java.util.ArrayList<String>().<String>findFirst(e|e == 'foo')", "String");
	}

	@Test
	public void testMethodTypeParamInference_03() throws Exception {
		resolvesTo("$$IterableExtensions::findFirst(new java.util.ArrayList<String>) [e | true]", "String");
	}

	@Test
	public void testMethodTypeParamInference_04() throws Exception {
		resolvesTo("$$IterableExtensions::findFirst(new java.util.ArrayList<String>) [e|e == 'foo']", "String");
	}

	@Test
	public void testMethodTypeParamInference_05() throws Exception {
		resolvesTo("$$IterableExtensions::<String>findFirst(new java.util.ArrayList<String>) [e|e == 'foo']", "String");
	}

	@Test
	public void testInstanceof() throws Exception {
		resolvesTo("null instanceof String", "boolean");
	}

	@Test
	public void testTypeForVoidClosure_01() throws Exception {
		resolvesTo("newArrayList('foo','bar').forEach []", "void");
	}

	@Test
	public void testTypeForVoidClosure_02() throws Exception {
		this.isFunctionAndEquivalentTo(resolvesTo("[ return ]", "(Object)=>void"), "Procedure1<Object>");
	}

	@Test
	public void testTypeForVoidClosure_03() throws Exception {
		this.isFunctionAndEquivalentTo(resolvesTo("[| return ]", "()=>void"), "Procedure0");
	}

	@Test
	public void testTypeForVoidClosure_04() throws Exception {
		this.isFunctionAndEquivalentTo(resolvesTo("[a, b| return ]", "(Object, Object)=>void"), "Procedure2<Object, Object>");
	}

	@Test
	public void testTypeForVoidClosure_05() throws Exception {
		this.isFunctionAndEquivalentTo(resolvesTo("[ System::out.println ]", "(Object)=>void"), "Procedure1<Object>");
	}

	@Test
	public void testTypeForVoidClosure_06() throws Exception {
		this.isFunctionAndEquivalentTo(resolvesTo("[| System::out.println ]", "()=>void"), "Procedure0");
	}

	@Test
	public void testTypeForVoidClosure_07() throws Exception {
		this.isFunctionAndEquivalentTo(resolvesTo("[a, b| System::out.println ]", "(Object, Object)=>void"), "Procedure2<Object, Object>");
	}

	@Test
	public void testTypeForEmptyClosure_01() throws Exception {
		this.isFunctionAndEquivalentTo(resolvesTo("[]", "(Object)=>Object"), "Function1<Object, Object>");
	}

	@Test
	public void testTypeForEmptyClosure_02() throws Exception {
		this.isFunctionAndEquivalentTo(resolvesTo("[|]", "()=>Object"), "Function0<Object>");
	}

	@Test
	public void testTypeForEmptyClosure_03() throws Exception {
		this.isFunctionAndEquivalentTo(resolvesTo("[a, b|]", "(Object, Object)=>Object"), "Function2<Object, Object, Object>");
	}

	@Test
	public void testFeatureCallWithArrayToIterableConversion_01() throws Exception {
		resolvesTo("'foo'.toCharArray.iterator", "Iterator<Character>");
	}

	@Test
	public void testFeatureCallWithArrayToIterableConversion_02() throws Exception {
		resolvesTo("(null as String[]).head", "String");
	}

	@Test
	public void testFeatureCallWithArrayToIterableConversion_03() throws Exception {
		resolvesTo("(null as String[]).map[ it ]", "List<String>");
	}

	@Test
	public void testFeatureCallWithArrayToIterableConversion_04() throws Exception {
		resolvesTo("(null as String[][]).head", "String[]");
	}

	@Test
	public void testFeatureCallWithArrayToIterableConversion_05() throws Exception {
		resolvesTo("{ var x = <String[]>newArrayList('a,b'.split(',')) x }", "ArrayList<String[]>");
	}

	@Test
	public void testFeatureCallWithArrayToIterableConversion_06() throws Exception {
		resolvesTo("{ var x = <String[]>newArrayList('a,b'.split(',')) x.head }", "String[]");
	}

	@Test
	public void testFeatureCallWithArrayToIterableConversion_07() throws Exception {
		resolvesTo("{ var x = <String[]>newArrayList('a,b'.split(',')) x.head.head }", "String");
	}

	@Test
	public void testFeatureCallWithArrayToIterableConversion_08() throws Exception {
		resolvesTo("{ var x = <Iterable<String>>newArrayList('a,b'.split(',')) x }", "ArrayList<Iterable<String>>");
	}

	@Test
	public void testFeatureCallWithArrayToIterableConversion_09() throws Exception {
		resolvesTo("{ var x = <Iterable<String>>newArrayList('a,b'.split(',')) x.head }", "Iterable<String>");
	}

	@Test
	public void testFeatureCallWithArrayToIterableConversion_10() throws Exception {
		resolvesTo("{ var x = <Iterable<String>>newArrayList('a,b'.split(',')) x.head.head }", "String");
	}

	@Test
	public void testReturnExpression_00() throws Exception {
		resolvesTo("return", "void");
	}

	@Test
	public void testReturnExpression_01() throws Exception {
		resolvesTo("return 'foo'", "void");
	}

	@Test
	public void testReturnExpression_02() throws Exception {
		resolvesTo("return try { if (true) 'foo' else 'bar' } finally { String::valueOf('zonk') }", "void");
	}

	@Test
	public void testReturnExpression_03() throws Exception {
		resolvesTo("{ val c = [ int i | return i ] c.apply(1) return null }", "void");
	}

	@Test
	public void testReturnExpression_04() throws Exception {
		resolvesTo("{ val c = [ int i | i ] c.apply(1) return null }", "void");
	}

	@Test
	public void testReturnExpression_05() throws Exception {
		resolvesTo("{ var closure = [| return 'literal'] closure.apply }", "String");
	}

	@Test
	public void testReturnExpression_06() throws Exception {
		resolvesTo("{ var closure = [| return 'literal'] return closure.apply }", "void");
	}

	@Test
	public void testReturnExpression_07() throws Exception {
		resolvesTo("[| return 'literal'].apply", "String");
	}

	@Test
	public void testReturnExpression_08() throws Exception {
		resolvesTo("return [| return 'literal'].apply", "void");
	}

	@Test
	public void testReturnExpression_09() throws Exception {
		this.isFunctionAndEquivalentTo(resolvesTo("[| return 'literal']", "()=>String"), "Function0<String>");
	}

	@Test
	public void testReturnExpression_10() throws Exception {
		resolvesTo("return if (true) while(false) ('foo'+'bar').length", "void");
	}

	@Test
	public void testClosure_00() throws Exception {
		resolvesTo("[|'literal'].apply()", "String");
	}

	@Test
	public void testClosure_01() throws Exception {
		resolvesTo("{ var closure = [|'literal']\n" +
				"  new testdata.ClosureClient().invoke0(closure)	}", "String");
	}

	@Test
	public void testClosure_02() throws Exception {
		this.isFunctionAndEquivalentTo(resolvesTo("[String x| true]", "(String)=>boolean"), "Function1<String, Boolean>");
	}

	@Test
	public void testClosure_03() throws Exception {
		resolvesTo(
				"{\n" +
				"  var java.util.List<? super String> list = null;\n" +
				"  list.map(e|e)\n" +
				"}", "List<Object>");
	}

	@Test
	public void testClosure_04() throws Exception {
		resolvesTo(
				"{\n" +
				"  var java.util.List<? super String> list = null;\n" +
				"  list.map(e|false)\n" +
				"}", "List<Boolean>");
	}

	@Test
	public void testClosure_05() throws Exception {
		this.isFunctionAndEquivalentTo(resolvesTo("[x| true]", "(Object)=>boolean"), "Function1<Object, Boolean>");
	}

	@Test
	public void testClosure_06() throws Exception {
		this.isFunctionAndEquivalentTo(resolvesTo("[x| null]", "(Object)=>Object"), "Function1<Object, Object>");
	}

	@Test
	public void testClosure_07() throws Exception {
		this.isFunctionAndEquivalentTo(resolvesTo("[String x, String y| x + y ]", "(String, String)=>String"),
				"Function2<String, String, String>");
	}

	@Test
	public void testClosure_08() throws Exception {
		this.isFunctionAndEquivalentTo(resolvesTo("[x| x]", "(Object)=>Object"), "Function1<Object, Object>");
	}

	@Test
	public void testClosure_09() throws Exception {
		this.isFunctionAndEquivalentTo(resolvesTo("[String x, String y| x.substring(y.length)]", "(String, String)=>String"),
				"Function2<String, String, String>");
	}

	@Test
	public void testClosure_10() throws Exception {
		this.isFunctionAndEquivalentTo(resolvesTo("[ x | x.toString x ]", "(Object)=>Object"), "Function1<Object, Object>");
	}

	@Test
	public void testClosure_11() throws Exception {
		this.isFunctionAndEquivalentTo(resolvesTo("[Object x| x]", "(Object)=>Object"), "Function1<Object, Object>");
	}

	@Test
	public void testClosure_12() throws Exception {
		this.isFunctionAndEquivalentTo(resolvesTo("[Object x| x.toString x ]", "(Object)=>Object"), "Function1<Object, Object>");
	}

	@Test
	public void testClosure_13() throws Exception {
		resolvesTo("{ \n" +
				"	val mapper = [ x | x ]\n" +
				"	newArrayList(1).map(mapper)\n" +
				"}", "List<Integer>");
	}

	@Test
	public void testClosure_13a() throws Exception {
		resolvesTo("{ \n" +
				"	val mapper = [ x | x ]\n" +
				"	newArrayList(1).map(mapper).head\n" +
				"}", "Integer");
	}

	@Test
	public void testClosure_13b() throws Exception {
		resolvesTo("{ \n" +
				"	val mapper = [ x | x ]\n" +
				"	newArrayList(1).map(mapper).findFirst [ true ]\n" +
				"}", "Integer");
	}

	@Ignore("TODO deferred closure body typing")
	@Test
	public void testClosure_14() throws Exception {
		resolvesTo("{ \n" +
				"	val mapper = [ x | x.charAt(0) ]\n" +
				"	newArrayList('').map(mapper)\n" +
				"}", "List<Character>");
	}

	@Test
	public void testClosure_15() throws Exception {
		this.isFunctionAndEquivalentTo(
				resolvesTo("{ \n" +
				"	val fun = [ x | x ]\n" +
				"	val String s = fun.apply(null)\n" +
				"	fun\n" +
				"}", "(String)=>String"),
				"Function1<String, String>");
	}

	@Test
	public void testClosure_16() throws Exception {
		this.isFunctionAndEquivalentTo(
				resolvesTo("{ \n" +
				"	val fun = [ x | x ]\n" +
				"	val java.util.List<String> list = newArrayList(fun.apply(null))\n" +
				"	fun\n" +
				"}",
						"(String[])=>String[]"),
				"Function1<String[], String[]>");
	}

	@Test
	public void testClosure_16_02() throws Exception {
		this.isFunctionAndEquivalentTo(resolvesTo(
				"{ \n" +
				"	val fun = [ x | x ]\n" +
				"	val java.util.List<String> list = newArrayList(fun.apply(null), fun.apply(null))\n" +
				"	fun\n" +
				"}",
				"(String)=>String"), "Function1<String, String>");
	}

	@Test
	public void testClosure_17() throws Exception {
		this.isFunctionAndEquivalentTo(
				resolvesTo("{ \n" +
				"	val fun = [ x | x ]\n" +
				"	val java.util.List<String> list = newArrayList.map(fun)\n" +
				"	fun\n" +
				"}",
						"(String)=>String"),
				"Function1<String, String>");
	}

	@Test
	public void testClosure_18() throws Exception {
		this.isFunctionAndEquivalentTo(
				resolvesTo("{ \n" +
				"	val fun = [ x | x ]\n" +
				"	val java.util.Set<String> list = newArrayList.map(fun)\n" +
				"	fun\n" +
				"}",
						"(String)=>String"),
				"Function1<String, String>");
	}

	@Test
	public void testClosure_19() throws Exception {
		this.isFunctionAndEquivalentTo(
				resolvesTo("{ \n" +
				"	val fun = [ x | x ]\n" +
				"	val java.util.ArrayList<String> list = newArrayList.map(fun)\n" +
				"	fun\n" +
				"}",
						"(String)=>String"),
				"Function1<String, String>");
	}

	@Test
	public void testClosure_20() throws Exception {
		this.isFunctionAndEquivalentTo(this
				.resolvesTo("{ \n" +
				"	val fun = [ x | x ]\n" +
				"	val Iterable<String> list = newArrayList.map(fun)\n" +
				"	fun\n" +
				"}", "(String)=>String"),
				"Function1<String, String>");
	}

	@Test
	public void testClosure_21() throws Exception {
		this.isFunctionAndEquivalentTo(
				resolvesTo("{ \n" +
				"	val fun = [ x | x ]\n" +
				"	val list = newArrayList.map(fun)\n" +
				"	val Iterable<String> iter = list\n" +
				"	fun\n" +
				"}",
						"(String)=>String"),
				"Function1<String, String>");
	}

	@Test
	public void testClosure_22() throws Exception {
		this.isFunctionAndEquivalentTo(resolvesTo(
				"{ \n" +
				"	val fun = [ x | x ]\n" +
				"	val java.util.List<String> list = $$ListExtensions::map(newArrayList, fun)\n" +
				"	fun\n" +
				"}",
				"(String)=>String"), "Function1<String, String>");
	}

	@Test
	public void testClosure_23() throws Exception {
		this.isFunctionAndEquivalentTo(resolvesTo(
				"{ \n" +
				"	val fun = [ x | x ]\n" +
				"	val java.util.Set<String> list = $$ListExtensions::map(newArrayList, fun)\n" +
				"	fun\n" +
				"}",
				"(String)=>String"), "Function1<String, String>");
	}

	@Test
	public void testClosure_24() throws Exception {
		this.isFunctionAndEquivalentTo(resolvesTo(
				"{ \n" +
				"	val fun = [ x | x ]\n" +
				"	val java.util.ArrayList<String> list = $$ListExtensions::map(newArrayList, fun)\n" +
				"	fun\n" +
				"}",
				"(String)=>String"), "Function1<String, String>");
	}

	@Test
	public void testClosure_25() throws Exception {
		this.isFunctionAndEquivalentTo(
				resolvesTo("{ \n" +
				"	val fun = [ x | x ]\n" +
				"	val Iterable<String> list = $$ListExtensions::map(newArrayList, fun)\n" +
				"	fun\n" +
				"}",
						"(String)=>String"),
				"Function1<String, String>");
	}

	@Test
	public void testClosure_26() throws Exception {
		this.isFunctionAndEquivalentTo(resolvesTo(
				"{ \n" +
				"	val fun = [ x | x ]\n" +
				"	val list = $$ListExtensions::map(newArrayList, fun)\n" +
				"	val Iterable<String> iter = list\n" +
				"	fun\n" +
				"}",
				"(String)=>String"), "Function1<String, String>");
	}

	@Test
	public void testClosure_27() throws Exception {
		resolvesTo("{ \n" +
				"	val mapper = [ x | x ]\n" +
				"	$$ListExtensions::map(newArrayList(1), mapper)\n" +
				"}", "List<Integer>");
	}

	@Test
	public void testClosure_28() throws Exception {
		resolvesTo("[|].apply()", "Object");
	}

	@Test
	public void testClosure_29() throws Exception {
		resolvesTo("[].apply()", "Object");
		resolvesTo("[].apply('')", "Object");
		resolvesTo("[].apply('', '')", "Object");
	}

	@Test
	public void testClosure_30() throws Exception {
		resolvesTo("$$ListExtensions::map(null as java.util.List<? super String>) [e|e]", "List<Object>");
	}

	@Test
	public void testClosure_31() throws Exception {
		resolvesTo(
				"{\n" +
				"  var java.util.List<? super String> list = null;\n" +
				"  $$ListExtensions::map(list) [e|e]\n" +
				"}",
				"List<Object>");
	}

	@Ignore("TODO deferred closure body typing")
	@Test
	public void testClosure_32() throws Exception {
		resolvesTo("[ x, i | x.charAt(i) ].apply('', 0)", "Character");
	}

	@Test
	public void testClosure_33() throws Exception {
		this.isFunctionAndEquivalentTo(resolvesTo("[ String it | val bytes = new String bytes ]", "(String)=>String"),
				"Function1<String, String>");
	}

	@Test
	public void testNewTreeSet_01() throws Exception {
		resolvesTo("new java.util.TreeSet(newArrayList(''))", "TreeSet<String>");
	}

	@Test
	public void testNewTreeSet_02() throws Exception {
		resolvesTo("newTreeSet[a, b|0]", "TreeSet<Object>");
	}

	@Test
	public void testNewTreeSet_03() throws Exception {
		resolvesTo("newTreeSet([a, b|0], 'a', 'b')", "TreeSet<String>");
	}

	@Test
	public void testNewTreeSet_04() throws Exception {
		resolvesTo("newTreeSet([a, b|a.length.compareTo(b.length)], 'a', 'b')", "TreeSet<String>");
	}

	@Test
	public void testNewTreeSet_05() throws Exception {
		resolvesTo("newTreeSet([a, b|a.toString.compareTo(b.toString)], 'a', 'b')", "TreeSet<String>");
	}

	@Test
	public void testTypeArgs_01() throws Exception {
		resolvesTo("new java.util.ArrayList<String>() += 'foo'", "boolean");
	}

	@Test
	public void testJEP101Example_01() throws Exception {
		resolvesTo("foo::JEP101List::cons(42, foo::JEP101List::nil())", "JEP101List<Integer>");
	}

	@Test
	public void testIfExpression_01() throws Exception {
		resolvesTo("if (true) 'foo' else null", "String");
		resolvesTo("if (true) 'foo' else 'bar'", "String");
		resolvesTo("if (true) 'foo'", "String");
	}

	@Test
	public void testIfExpression_02() throws Exception {
		resolvesTo("if (true) new StringBuilder() else new StringBuffer()", "AbstractStringBuilder & Serializable & Comparable<?>");
	}

	@Test
	public void testIfExpression_03() throws Exception {
		resolvesTo("if (true) return 'foo'", "void");
	}

	@Test
	public void testIfExpression_04() throws Exception {
		resolvesTo("if (true) return '' else new StringBuilder", "StringBuilder");
	}

	@Test
	public void testIfExpression_05() throws Exception {
		this.isFunctionAndEquivalentTo(resolvesTo("if (true) [|''] else [|'']", "()=>String"), "Function0<String>");
	}

	@Test
	public void testIfExpression_06() throws Exception {
		this.isFunctionAndEquivalentTo(resolvesTo("if (true) [|''] else [|null as CharSequence]", "()=>CharSequence"),
				"Function0<CharSequence>");
	}

	@Test
	public void testIfExpression_07() throws Exception {
		this.isFunctionAndEquivalentTo(resolvesTo("if (true) [|null as Appendable] else [|null as CharSequence]", "()=>Object"),
				"Function0<?>");
	}

	@Test
	public void testIfExpression_08() throws Exception {
		this.isFunctionAndEquivalentTo(resolvesTo("if (true) [ CharSequence c |''] else [ String s |'']", "(String)=>String"),
				"Function1<String, String>");
	}

	@Test
	public void testIfExpression_09() throws Exception {
		this.isFunctionAndEquivalentTo(
				resolvesTo("if (true) [new StringBuilder()] else [new StringBuffer()]",
						"(Object)=>AbstractStringBuilder & Serializable & Comparable<?>"),
				"Function1<Object, ? extends AbstractStringBuilder & Serializable & Comparable<?>>");
	}

	@Test
	public void testIfExpression_10() throws Exception {
		resolvesTo("if (true) null as java.util.List<String> else null as String[]", "Object");
	}

	@Test
	public void testIfExpression_11() throws Exception {
		resolvesTo("(if (true) [new StringBuilder()] else [new StringBuffer()]).apply('')",
				"AbstractStringBuilder & Serializable & Comparable<?>");
	}

	@Test
	public void testIfExpression_12() throws Exception {
		resolvesTo("if (true) newArrayList else <String>newHashSet", "AbstractCollection<String> & Serializable & Cloneable");
	}

	@Test
	public void testIfExpression_13() throws Exception {
		resolvesTo("if (true) <StringBuffer>newArrayList else <String>newHashSet",
				"AbstractCollection<? extends Serializable & Comparable<?> & CharSequence> & Serializable & Cloneable");
	}

	@Test
	public void testIfExpression_14() throws Exception {
		resolvesTo("if (true) newArrayList else newHashSet", "AbstractCollection<Object> & Serializable & Cloneable");
	}

	@Test
	public void testIfExpression_15() throws Exception {
		resolvesTo("if (true) null else null", "null");
	}

	@Test
	public void testIfExpression_16() throws Exception {
		resolvesTo("if (true) return 1 else 0", "int");
	}

	@Test
	public void testIfExpression_17() throws Exception {
		resolvesTo("if (true) return 1", "void");
	}

	@Test
	public void testIfExpression_18() throws Exception {
		resolvesTo("if (true) return", "void");
	}

	@Test
	public void testIfExpression_19() throws Exception {
		resolvesTo("if (true) return else null", "null");
	}

	@Test
	public void testIfExpression_20() throws Exception {
		resolvesTo("if (true) return else return", "void");
	}

	@Test
	public void testIfExpression_21() throws Exception {
		resolvesTo("{ val x = if (true) null else null x }", "null");
	}

	@Test
	public void testIfExpression_22() throws Exception {
		resolvesTo("{ val x = if (true) return 1 else 0 x }", "int");
	}

	@Test
	public void testIfExpression_23() throws Exception {
		resolvesTo("{ val x = if (true) return 1 x }", "null");
	}

	@Test
	public void testIfExpression_24() throws Exception {
		resolvesTo("{ val x = if (true) return; x }", "null");
	}

	@Test
	public void testIfExpression_25() throws Exception {
		resolvesTo("{ val x = if (true) return else null x }", "null");
	}

	@Test
	public void testIfExpression_26() throws Exception {
		resolvesTo("if (true) for(i: 1..2) i.toString else ''", "String");
	}

	@Test
	public void testIfExpression_27() throws Exception {
		resolvesTo("if (true) while(false) ('foo'+'bar').length", "void");
	}

	@Test
	public void testIfExpression_28() throws Exception {
		resolvesTo("if (true) return '' else 1", "int");
	}

	@Test
	public void testIfExpression_29() throws Exception {
		resolvesTo("if (true) while(true) ''.toString else while(true) ''.toString", "void");
	}

	@Test
	public void testIfExpression_30() throws Exception {
		resolvesTo("if (true) null as int[] else null as Integer[]", "Serializable & Cloneable");
	}

	@Test
	public void testIfExpression_31() throws Exception {
		resolvesTo("if (true) null as int[] else null as Iterable<Integer>", "Object");
	}

	@Test
	public void testIfExpression_32() throws Exception {
		resolvesTo("if (true) while(false) ''.toString else 'myString'", "String");
	}

	@Test
	public void testIfExpression_33() throws Exception {
		resolvesTo("if(true) #{'f'} else emptySet", "Set<String>");
	}

	@Test
	public void testIfExpression_34() throws Exception {
		resolvesTo("if(true) true else Boolean.TRUE", "Boolean");
	}

	@Test
	public void testSwitchExpression() throws Exception {
		resolvesTo("switch true { case true : 's' case false : 'foo' default: 'bar'}", "String");
		resolvesTo("switch true { case true : 's' case false : new Object() default: 'bar'}", "Object");
	}

	@Test
	public void testSwitchExpression_1() throws Exception {
		resolvesTo("switch true { case true : return 's' default: null}", "null");
	}

	@Test
	public void testSwitchExpression_2() throws Exception {
		resolvesTo("switch null {\n" +
				"  Object : return null \n" +
				"}", "void");
	}

	@Test
	public void testSwitchExpression_3() throws Exception {
		resolvesTo(
				"{\n" +
				"	val Object c = null\n" +
				"	switch c {\n" +
				"	            CharSequence: 1\n" +
				"	    	}\n" +
				"}", "int");
	}

	@Test
	public void testSwitchExpression_4() throws Exception {
		resolvesTo(
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
				"char");
	}

	@Test
	public void testSwitchExpression_5() throws Exception {
		resolvesTo(
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
				"Appendable");
	}

	@Test
	public void testSwitchExpression_6() throws Exception {
		resolvesTo(
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
				"int");
	}

	@Test
	public void testSwitchExpression_7() throws Exception {
		resolvesTo(
				"{\n" +
				"	val Comparable<Object> it = null\n" +
				"	switch it {\n" +
				"	            CharSequence: switch(it) {\n" +
				"                    Appendable: {\n" +
				"                        charAt(1)\n" +
				"                    }\n" +
				"                }\n" +
				"        	}\n" +
				"}",
				"char");
	}

	@Test
	public void testSwitchExpression_8() throws Exception {
		resolvesTo(
				"{\n" +
				"	val Comparable<Object> it = null\n" +
				"	switch it {\n" +
				"	            CharSequence: switch(it) {\n" +
				"                    Appendable: {\n" +
				"                        append(null)\n" +
				"                    }\n" +
				"                }\n" +
				"        	}\n" +
				"}",
				"Appendable");
	}

	@Test
	public void testSwitchExpression_9() throws Exception {
		resolvesTo(
				"{\n" +
				"	val Comparable<Object> it = null\n" +
				"	switch it {\n" +
				"	            CharSequence: switch(it) {\n" +
				"                    Appendable: {\n" +
				"                        compareTo(null)\n" +
				"                    }\n" +
				"                }\n" +
				"        	}\n" +
				"}",
				"int");
	}

	@Test
	public void testSwitchExpression_10() throws Exception {
		this.isFunctionAndEquivalentTo(
				resolvesTo("switch null {\n" +
				"            case null : [Object it | it]\n" +
				"            case null : [Integer it | it]\n" +
				"        }",
						"(Integer)=>Object"),
				"Function1<? super Integer, ?>");
	}

	@Test
	public void testSwitchExpression_11() throws Exception {
		resolvesTo("switch null {\n" +
				"  Object : return \n" +
				"}", "void");
	}

	@Test
	public void testSwitchExpression_12() throws Exception {
		resolvesTo("switch null {\n" +
				"  Object : return\n" +
				"  default: return\n" +
				"}", "void");
	}

	@Test
	public void testTypeGuardedCase_0() throws Exception {
		resolvesTo("switch s: new Object() { String: s StringBuffer: s}", "Serializable & Comparable<?> & CharSequence");
	}

	@Test
	public void testTypeGuardedCase_1() throws Exception {
		resolvesTo("switch s: '' as CharSequence { Cloneable: s String: s }", "CharSequence");
	}

	@Test
	public void testTypeGuardedCase_2() throws Exception {
		resolvesTo(
				"{\n" +
				"	val java.util.Iterator<CharSequence> it = null\n" +
				"	switch next {\n" +
				"	            String: next\n" +
				"        	}\n" +
				"}",
				"CharSequence");
	}

	@Test
	public void testTypeGuardedCase_3() throws Exception {
		resolvesTo("switch s: new Object() { String, StringBuffer: s}", "Serializable & Comparable<?> & CharSequence");
	}

	@Test
	public void testTypeGuardedCase_4() throws Exception {
		resolvesTo("switch s: '' as CharSequence { Cloneable, String: s }", "CharSequence");
	}

	@Test
	public void testSwitchExpression_Bug343100() throws Exception {
		resolvesTo("switch 'a' {\n" +
				"  case null: typeof(String) \n" +
				"  case 'a': typeof(Void)\n" +
				"}", "Class<?>");
	}

	@Test
	public void testBlockExpression_01() throws Exception {
		resolvesTo("{}", "null");
		resolvesTo("{null}", "null");
		resolvesTo("{''.toString 4}", "int");
		resolvesTo("{''.toString true}", "boolean");
	}

	@Test
	public void testBlockExpression_02() throws Exception {
		resolvesTo("{val s = '' s}", "String");
	}

	@IgnoredBySmokeTest("Do not run smoke test with 1000s of nested expressions")
	@Test
	public void testBlockExpression_03() throws Exception {
		String input = "{ val s1 = ''\n";
		int max = 1000;
		for (Integer i : new IntegerRange(1, max)) {
			input = input + " val s" + (i.intValue() + 1) + " = s" + i + "\n";
		}
		input = input + " s" + (max + 1) + "}";
		resolvesTo(input, "String");
	}

	@Test
	public void testBlockExpression_04() throws Exception {
		resolvesTo("{val Object s = '' s}", "Object");
	}

	@Test
	public void testBlockExpression_05() throws Exception {
		resolvesTo("{val Object s = ''}", "void");
	}

	@Test
	public void testBlockExpression_06() throws Exception {
		resolvesTo("{val Object s = '' s.notify}", "void");
	}

	@Test
	public void testBlockExpression_07() throws Exception {
		resolvesTo(
				"{\n" +
				"            val (Integer, Double, Boolean) => void fun1 = null\n" +
				"            val (byte[], Object) => double[] fun2 = null\n" +
				"            val test = newArrayList.map[1 -> org::eclipse::xtext::xbase::lib::Pair::of(fun1, fun2)]\n" +
				"            val test2 = newArrayList.map[2 -> org::eclipse::xtext::xbase::lib::Pair::of(fun1, fun2)]\n" +
				"            val test3 = com::google::common::collect::Iterables::concat(test, test2).toMap[key].entrySet.map[value].toList\n" +
				"            test3\n" +
				"        }",
				"List<Pair<Integer, Pair<(Integer, Double, Boolean)=>void, (byte[], Object)=>double[]>>>");
	}

	@Test
	public void testBlockExpression_08() throws Exception {
		resolvesTo(
				"{\n" +
				"            val (Integer, Double, Boolean) => void fun1 = null\n" +
				"            val (byte[], Object) => double[] fun2 = null\n" +
				"            val test = newArrayList.map[1 -> org::eclipse::xtext::xbase::lib::Pair::of(fun1, fun2)]\n" +
				"            val test2 = newArrayList.map[2 -> org::eclipse::xtext::xbase::lib::Pair::of(fun1, fun2)]\n" +
				"            val test3 = com::google::common::collect::Iterables::concat(test, test2).toMap[key].entrySet.map[value].toList\n" +
				"            test3.head.value.value.apply(null, null).last\n" +
				"        }",
				"Double");
	}

	@Test
	public void testBlockExpression_09() throws Exception {
		resolvesTo("{val Object x = if (false) return; x }", "Object");
	}

	@Test
	public void testBlockExpression_10() throws Exception {
		resolvesTo("{ ( if (true) {val Object x = if (false) return; x } ) }", "Object");
	}

	@Test
	public void testBlockExpression_11() throws Exception {
		resolvesTo("{ ( if (true) {val Object x = if (false) return; x } ) {val Object x = if (false) return; x } }", "Object");
	}

	@Test
	public void testBlockExpression_12() throws Exception {
		resolvesTo("{ ( if (true) if (true) return else null ) { if (true) return else null } }", "null");
	}

	@Test
	public void testEntrySet_01() throws Exception {
		resolvesTo("(null as java.util.Map<? extends String,? extends String>).entrySet",
				"Set<? extends Entry<? extends String, ? extends String>>");
	}

	@Test
	public void testEntrySet_02() throws Exception {
		resolvesTo("(null as java.util.Map<String, String>).entrySet", "Set<Entry<String, String>>");
	}

	@Test
	public void testEntrySet_03() throws Exception {
		resolvesTo("(null as java.util.Map<Iterable<? extends String>, Iterable<? extends String>>).entrySet",
				"Set<Entry<Iterable<? extends String>, Iterable<? extends String>>>");
	}

	@Test
	public void testEMap_01() throws Exception {
		resolvesTo(
				"{ \n" +
				"          val eMap = new org.eclipse.emf.common.util.BasicEMap<Integer, String>()\n" +
				"  eMap.map[ getKey ].head\n" +
				"         }",
				"Integer");
	}

	@Test
	public void testEMap_02() throws Exception {
		resolvesTo(
				"{ \n" +
				"          val eMap = new org.eclipse.emf.common.util.BasicEMap<Integer, String>()\n" +
				"  eMap.map[ getValue ].head\n" +
				"         }",
				"String");
	}

	@Test
	public void testEMap_03() throws Exception {
		resolvesTo(
				"{ \n" +
				"          val eMap = new org.eclipse.emf.common.util.BasicEMap<Integer, String>()\n" +
				"  eMap.map[ it ].head\n" +
				"         }",
				"Entry<Integer, String>");
	}

	@Test
	public void testEMap_04() throws Exception {
		resolvesTo("{ \n" +
				"          val eMap = new org.eclipse.emf.common.util.BasicEMap<Integer, String>()\n" +
				"  eMap.map\n" +
				"         }",
				"Map<Integer, String>");
	}

	@Test
	public void testEMap_05() throws Exception {
		resolvesTo(
				"{ \n" +
				"          val org.eclipse.emf.common.util.BasicEMap<? extends Integer, String> eMap = null\n" +
				"  eMap.map[ key ].head\n" +
				"         }",
				"Integer");
	}

	@Test
	public void testEMap_06() throws Exception {
		resolvesTo(
				"{ \n" +
				"          val org.eclipse.emf.common.util.BasicEMap<? extends Integer, String> eMap = null\n" +
				"  eMap.map[ value ].head\n" +
				"         }",
				"String");
	}

	@Test
	public void testEMap_07() throws Exception {
		resolvesTo(
				"{ \n" +
				"          val org.eclipse.emf.common.util.BasicEMap<? extends Integer, String> eMap = null\n" +
				"  eMap.map[ it ].head\n" +
				"         }",
				"Entry<? extends Integer, String>");
	}

	@Test
	public void testEMap_08() throws Exception {
		resolvesTo("{ \n" +
				"          val org.eclipse.emf.common.util.BasicEMap<? extends Integer, String> eMap = null\n" +
				"  eMap.map\n" +
				"         }",
				"Map<? extends Integer, String>");
	}

	@Test
	public void testEMap_09() throws Exception {
		resolvesTo(
				"{ \n" +
				"          val org.eclipse.emf.common.util.BasicEMap<? super Integer, String> eMap = null\n" +
				"  eMap.map[ key ].head\n" +
				"         }",
				"Object");
	}

	@Test
	public void testEMap_10() throws Exception {
		resolvesTo(
				"{ \n" +
				"          val org.eclipse.emf.common.util.BasicEMap<? super Integer, String> eMap = null\n" +
				"  eMap.map[ value ].head\n" +
				"         }",
				"String");
	}

	@Test
	public void testEMap_11() throws Exception {
		resolvesTo(
				"{ \n" +
				"          val org.eclipse.emf.common.util.BasicEMap<? super Integer, String> eMap = null\n" +
				"  eMap.map[ it ].head\n" +
				"         }",
				"Entry<? super Integer, String>");
	}

	@Test
	public void testEMap_12() throws Exception {
		resolvesTo("{ \n" +
				"          val org.eclipse.emf.common.util.BasicEMap<? super Integer, String> eMap = null\n" +
				"  eMap.map\n" +
				"         }",
				"Map<? super Integer, String>");
	}

	@Test
	public void testConstructorCall_01() throws Exception {
		resolvesTo("new java.util.ArrayList<String>()", "ArrayList<String>");
		resolvesTo("new java.util.HashMap<String,Boolean>", "HashMap<String, Boolean>");
		resolvesTo("new java.util.ArrayList()", "ArrayList<Object>");
	}

	@Test
	public void testConstructorCall_02() throws Exception {
		resolvesTo("new java.util.ArrayList<? extends String>()", "ArrayList<String>");
		resolvesTo("new java.util.HashMap<? extends String, ? extends Boolean>", "HashMap<String, Boolean>");
	}

	@Test
	public void testConstructorCall_03() throws Exception {
		resolvesTo("new java.util.ArrayList<? super String>()", "ArrayList<String>");
		resolvesTo("new java.util.HashMap<? super String,Boolean>", "HashMap<String, Boolean>");
	}

	@Test
	public void testBrokenConstructorCall_01() throws Exception {
		resolvesTo("new Iterable<String>()", "Iterable<String>");
	}

	@Test
	public void testBrokenConstructorCall_02() throws Exception {
		resolvesTo("new java.util.Map<String>()", "Map<String, Object>");
	}

	@Test
	public void testConstructorTypeInference_01() throws Exception {
		resolvesTo("new testdata.GenericType1('')", "GenericType1<String>");
	}

	@Test
	public void testConstructorTypeInference_02() throws Exception {
		resolvesTo("<java.util.List<String>>newArrayList().add(new java.util.ArrayList())", "boolean");
	}

	@Test
	public void testConstructorTypeInference_03() throws Exception {
		resolvesTo("<java.util.List<String>>newArrayList().add(0, new java.util.ArrayList())", "void");
	}

	@Test
	public void testConstructorTypeInference_04() throws Exception {
		resolvesTo("newArrayList.add(new java.util.ArrayList())", "boolean");
	}

	@Test
	public void testConstructorTypeInference_05() throws Exception {
		resolvesTo("new testdata.GenericType2", "GenericType2<Number>");
	}

	@Test
	public void testConstructorTypeInference_06() throws Exception {
		resolvesTo("new testdata.GenericType2(0)", "GenericType2<Integer>");
	}

	@Test
	public void testConstructorTypeInference_07() throws Exception {
		resolvesTo("new testdata.GenericType2(0, 1)", "GenericType2<Integer>");
	}

	@Test
	public void testConstructorTypeInference_08() throws Exception {
		if (JavaRuntimeVersion.isJava12OrLater()) {
			resolvesTo("new testdata.GenericType2(new Integer(0), new Integer(0).doubleValue)",
					"GenericType2<Number & Comparable<?> & Constable & ConstantDesc>");
		} else {
			resolvesTo("new testdata.GenericType2(new Integer(0), new Integer(0).doubleValue)", "GenericType2<Number & Comparable<?>>");
		}
	}

	@Test
	public void testConstructorTypeInference_09() throws Exception {
		resolvesTo("<Iterable<String>>newArrayList().add(new java.util.LinkedList)", "boolean");
	}

	@Test
	public void testConstructorTypeInference_10() throws Exception {
		resolvesTo("<Iterable<String>>newArrayList().add(null)", "boolean");
	}

	@Test
	public void testConstructorTypeInference_11() throws Exception {
		resolvesTo("<java.util.Map<Iterable<String>, Iterable<Integer>>>newArrayList().head", "Map<Iterable<String>, Iterable<Integer>>");
	}

	@Test
	public void testClassNewInstance() throws Exception {
		resolvesTo("typeof(String).newInstance", "String");
	}

	@Test
	public void testClassGetSuperclass_01() throws Exception {
		resolvesTo("typeof(String).superclass", "Class<? super String>");
	}

	@Test
	public void testClassGetSuperclass_02() throws Exception {
		resolvesTo("typeof(String).superclass.superclass", "Class<? super String>");
	}

	@Test
	public void testClassGetSuperclass_03() throws Exception {
		resolvesTo("{ var c = Class::forName('') c.superclass }", "Class<?>");
	}

	@Test
	public void testClassGetSuperclass_04() throws Exception {
		resolvesTo("{ var c = Class::forName('') println(c.superclass) }", "Class<?>");
	}

	@Test
	public void testVarArgs_01() throws Exception {
		if (JavaRuntimeVersion.isJava12OrLater()) {
			resolvesTo("newArrayList(new Double('-20'), new Integer('20'))",
					"ArrayList<Number & Comparable<?> & Constable & ConstantDesc>");
		} else {
			resolvesTo("newArrayList(new Double('-20'), new Integer('20'))", "ArrayList<Number & Comparable<?>>");
		}
	}

	@Test
	public void testVarArgs_02() throws Exception {
		if (JavaRuntimeVersion.isJava12OrLater()) {
			resolvesTo("newArrayList(if (true) new Double('-20') else new Integer('20'))",
					"ArrayList<Number & Comparable<?> & Constable & ConstantDesc>");
		} else {
			resolvesTo("newArrayList(if (true) new Double('-20') else new Integer('20'))", "ArrayList<Number & Comparable<?>>");
		}
	}

	@Test
	public void testVarArgs_03() throws Exception {
		if (JavaRuntimeVersion.isJava12OrLater()) {
			resolvesTo("newArrayList(if (true) new Double('-20') else new Integer('20'), new Integer('29'))",
					"ArrayList<Number & Comparable<?> & Constable & ConstantDesc>");
		} else {
			resolvesTo("newArrayList(if (true) new Double('-20') else new Integer('20'), new Integer('29'))",
					"ArrayList<Number & Comparable<?>>");
		}
	}

	@Test
	public void testVarArgs_04() throws Exception {
		if (JavaRuntimeVersion.isJava12OrLater()) {
			resolvesTo("newArrayList(if (true) new Double('-20') else new Integer('20'), new Double('29'))",
					"ArrayList<Number & Comparable<?> & Constable & ConstantDesc>");
		} else {
			resolvesTo("newArrayList(if (true) new Double('-20') else new Integer('20'), new Double('29'))",
					"ArrayList<Number & Comparable<?>>");
		}
	}

	@Test
	public void testVarArgs_05() throws Exception {
		if (JavaRuntimeVersion.isJava12OrLater()) {
			resolvesTo("newArrayList(if (true) new Double('-20') else new Integer('20'), new Integer('29'), new Double('29'))",
					"ArrayList<Number & Comparable<?> & Constable & ConstantDesc>");
		} else {
			resolvesTo("newArrayList(if (true) new Double('-20') else new Integer('20'), new Integer('29'), new Double('29'))",
					"ArrayList<Number & Comparable<?>>");
		}
	}

	@Test
	public void testVarArgs_06() throws Exception {
		if (JavaRuntimeVersion.isJava12OrLater()) {
			resolvesTo("java::util::Arrays::asList(1, 3d, '4')", "List<Comparable<?> & Constable & ConstantDesc & Serializable>");
		} else {
			resolvesTo("java::util::Arrays::asList(1, 3d, '4')", "List<Comparable<?> & Serializable>");
		}
	}

	@Test
	public void testVarArgs_07() throws Exception {
		resolvesTo("newArrayList(null as Integer[], null as int[], null as Iterable<Integer>)", "ArrayList<Object>");
	}

	@Test
	public void testVarArgs_08() throws Exception {
		resolvesTo("newArrayList(null as Integer[], null as int[])", "ArrayList<Serializable & Cloneable>");
	}

	@Test
	public void testFeatureCall_01() throws Exception {
		resolvesTo("'foo'.length", "int");
	}

	@Test
	public void testFeatureCall_02() throws Exception {
		resolvesTo("'foo'.getBytes()", "byte[]");
		resolvesTo("new java.util.ArrayList<String>().get(23)", "String");
	}

	@Test
	public void testFeatureCall_03() throws Exception {
		resolvesTo("new testdata.ClassWithVarArgs().toList()", "List<Object>");
		resolvesTo("new testdata.ClassWithVarArgs().toList('')", "List<String>");
		resolvesTo("new testdata.ClassWithVarArgs().toList('', '')", "List<String>");
	}

	@Test
	public void testFeatureCall_03_a() throws Exception {
		resolvesTo("new testdata.ClassWithVarArgs().toList(null as String[])", "List<String>");
	}

	@Test
	public void testFeatureCall_03_b() throws Exception {
		resolvesTo("new testdata.ClassWithVarArgs().toList(null as int[])", "List<int[]>");
	}

	@Test
	public void testMemberFeatureCall_01() throws Exception {
		resolvesTo("'x'.length", "int");
	}

	@Test
	public void testMemberFeatureCall_02() throws Exception {
		resolvesTo("(1..20).map[ toString.length ].reduce[ i1,  i2 | i1 + i2 ]", "Integer");
	}

	@Test
	public void testMemberFeatureCall_03() throws Exception {
		resolvesTo("newArrayList('').get(0)", "String");
		resolvesTo("<String>newArrayList().get(0)", "String");
	}

	@Test
	public void testMemberFeatureCall_04() throws Exception {
		resolvesTo("''.^class", "Class<? extends String>");
	}

	@Test
	public void testMemberFeatureCall_05() throws Exception {
		if (JavaRuntimeVersion.isJava12OrLater()) {
		} else {
		}
		resolvesTo("''.^class.superclass", "Class<?>");
	}

	@Test
	public void testFeatureCall_04() throws Exception {
		if (JavaRuntimeVersion.isJava12OrLater()) {
			resolvesTo("new testdata.ClassWithVarArgs().toList('', 1)", "List<Comparable<?> & Constable & ConstantDesc & Serializable>");
		} else {
			resolvesTo("new testdata.ClassWithVarArgs().toList('', 1)", "List<Comparable<?> & Serializable>");
		}
	}

	@Test
	public void testFeatureCall_05() throws Exception {
		if (JavaRuntimeVersion.isJava12OrLater()) {
			resolvesTo("new testdata.ClassWithVarArgs().toNumberList()", "List<Number>");
			resolvesTo("new testdata.ClassWithVarArgs().toNumberList(0)", "List<Integer>");
			resolvesTo("new testdata.ClassWithVarArgs().toNumberList(0, 1)", "List<Integer>");
			resolvesTo("new testdata.ClassWithVarArgs().toNumberList(new Integer(0), new Integer(0).doubleValue)",
					"List<Number & Comparable<?> & Constable & ConstantDesc>");
		} else {
			resolvesTo("new testdata.ClassWithVarArgs().toNumberList()", "List<Number>");
			resolvesTo("new testdata.ClassWithVarArgs().toNumberList(0)", "List<Integer>");
			resolvesTo("new testdata.ClassWithVarArgs().toNumberList(0, 1)", "List<Integer>");
			resolvesTo("new testdata.ClassWithVarArgs().toNumberList(new Integer(0), new Integer(0).doubleValue)",
					"List<Number & Comparable<?>>");
		}
	}

	@Test
	public void testFeatureCall_05_b() throws Exception {
		resolvesTo("new testdata.ClassWithVarArgs().toNumberList(null as Float[])", "List<Float>");
	}

	@Test
	public void testFeatureCall_06() throws Exception {
		resolvesTo("newArrayList('').map(s|s)", "List<String>");
	}

	@Test
	public void testFeatureCall_06a() throws Exception {
		resolvesTo("newArrayList('').map [it|it]", "List<String>");
	}

	@Test
	public void testFeatureCall_06b() throws Exception {
		resolvesTo("newArrayList('').map [it]", "List<String>");
	}

	@Test
	public void testFeatureCall_06c() throws Exception {
		resolvesTo("(null as Iterable<String>).map(s|s)", "Iterable<String>");
	}

	@Test
	public void testFeatureCall_06_00() throws Exception {
		resolvesTo("$$ListExtensions::map(newArrayList('')) [s|s]", "List<String>");
	}

	@Test
	public void testFeatureCall_06_01() throws Exception {
		resolvesTo("newArrayList('').map(s|s).head", "String");
	}

	@Test
	public void testFeatureCall_06_02() throws Exception {
		resolvesTo("newArrayList('').map(s|s.toString).head", "String");
	}

	@Test
	public void testFeatureCall_06_03() throws Exception {
		resolvesTo("newArrayList('').map(s|1)", "List<Integer>");
	}

	@Test
	public void testFeatureCall_06_04() throws Exception {
		resolvesTo("newArrayList('').map(s|1).head", "Integer");
	}

	@Test
	public void testFeatureCall_07() throws Exception {
		resolvesTo("newArrayList('').map(s|s.length)", "List<Integer>");
	}

	@Test
	public void testFeatureCall_07_01() throws Exception {
		resolvesTo("<String>newArrayList.map(s|s.length)", "List<Integer>");
	}

	@Test
	public void testFeatureCall_07_02() throws Exception {
		resolvesTo("newArrayList('').map(s|s.length).head", "Integer");
	}

	@Test
	public void testFeatureCall_07_03() throws Exception {
		resolvesTo("<String>newArrayList.map(s|s.length).head", "Integer");
	}

	@Test
	public void testFeatureCall_08() throws Exception {
		resolvesTo("newArrayList('').map(s|s !== null)", "List<Boolean>");
	}

	@Test
	public void testFeatureCall_09() throws Exception {
		resolvesTo("newArrayList('').map(s|s.length+1)", "List<Integer>");
	}

	@Test
	public void testFeatureCall_10() throws Exception {
		resolvesTo("newArrayList('').map(s|1).map(i|i+1)", "List<Integer>");
	}

	@Test
	public void testFeatureCall_11() throws Exception {
		resolvesTo("newArrayList('').map(s|1).toList()", "List<Integer>");
	}

	@Test
	public void testFeatureCall_12() throws Exception {
		resolvesTo("newArrayList('').map(s|1).toList().map(i|i)", "List<Integer>");
	}

	@Test
	public void testFeatureCall_13() throws Exception {
		resolvesTo("newArrayList('').map(s|1).toList().map(i|i+1)", "List<Integer>");
	}

	@Test
	public void testFeatureCall_13_2() throws Exception {
		resolvesTo("{ var it = newArrayList('').map(s|1).toList() it.map(i|i+1) }", "List<Integer>");
	}

	@Test
	public void testFeatureCall_13_3() throws Exception {
		resolvesTo("{ var it = newArrayList('').map(s|1).toList() map(i|i+1) }", "List<Integer>");
	}

	@Test
	public void testFeatureCall_13_4() throws Exception {
		resolvesTo("{ var it = newArrayList('').map(s|1).toList() it }", "List<Integer>");
	}

	@Test
	public void testFeatureCall_13_5() throws Exception {
		resolvesTo("{ var java.util.List<? extends Integer> it = null map(i|i+1) }", "List<Integer>");
	}

	@Test
	public void testFeatureCall_13_6() throws Exception {
		resolvesTo("{ var java.util.List<? extends Integer> it = null map(i|i) }", "List<Integer>");
	}

	@Test
	public void testFeatureCall_14() throws Exception {
		resolvesTo("newArrayList(newArrayList('').map(s|1))", "ArrayList<List<Integer>>");
	}

	@Test
	public void testFeatureCall_15() throws Exception {
		resolvesTo("newArrayList(newArrayList('').map(s|1)).map(iterable|iterable.size())", "List<Integer>");
	}

	@Test
	public void testFeatureCall_15_a() throws Exception {
		resolvesTo("newArrayList(newArrayList('').map(s|1)).map(iterable|iterable.size()).map(e|e)", "List<Integer>");
	}

	@Test
	public void testFeatureCall_15_b() throws Exception {
		resolvesTo("newArrayList(newArrayList('').map(s|1)).map(iterable|iterable.size()).map(e|e).map(e|e)", "List<Integer>");
	}

	@Test
	public void testFeatureCall_15_c() throws Exception {
		resolvesTo("newArrayList(newArrayList('').map(s|1)).map(iterable|iterable.size()).map(e|e).map(e|e).map(e|e)", "List<Integer>");
	}

	@Test
	public void testFeatureCall_15_d() throws Exception {
		resolvesTo("newArrayList(newArrayList('').map(s|1)).map(iterable|iterable.size()).map(e|e).map(e|e).map(e|e).map(e|e)",
				"List<Integer>");
	}

	@Test
	public void testFeatureCall_15_d_2() throws Exception {
		resolvesTo("newArrayList(newArrayList('').map(s|1)).map(iterable|iterable.size()).map(e|e).map(e|e).map(e|e).map(e|e).head",
				"Integer");
	}

	@Test
	public void testFeatureCall_15_e() throws Exception {
		resolvesTo("newArrayList(newArrayList('').map(s|1).map(e|e)).map(iterable|iterable.size())", "List<Integer>");
	}

	@Test
	public void testFeatureCall_15_e_2() throws Exception {
		resolvesTo("newArrayList(newArrayList('').map(s|1).map(e|e)).map(iterable|iterable.size()).head", "Integer");
	}

	@Test
	public void testFeatureCall_15_f() throws Exception {
		resolvesTo("newArrayList(newArrayList('').map(s|1).map(e|e).map(e|e)).map(iterable|iterable.size())", "List<Integer>");
	}

	@Test
	public void testFeatureCall_15_f_2() throws Exception {
		resolvesTo("newArrayList(newArrayList('').map(s|1).map(e|e).map(e|e)).map(iterable|iterable.size()).head", "Integer");
	}

	@Test
	public void testFeatureCall_15_g() throws Exception {
		resolvesTo("newArrayList(newArrayList('').map(s|1).map(e|e).map(e|e).map(e|e)).map(iterable|iterable.size())", "List<Integer>");
	}

	@Test
	public void testFeatureCall_15_g_2() throws Exception {
		resolvesTo("newArrayList(newArrayList('').map(s|1).map(e|e).map(e|e).map(e|e)).map(iterable|iterable.size()).head", "Integer");
	}

	@Test
	public void testFeatureCall_15_h() throws Exception {
		resolvesTo("newArrayList(newArrayList('').map(s|1).map(e|e).map(e|e).map(e|e).map(e|e)).map(iterable|iterable.size())",
				"List<Integer>");
	}

	@Test
	public void testFeatureCall_15_h_2() throws Exception {
		resolvesTo("newArrayList(newArrayList('').map(s|1).map(e|e).map(e|e).map(e|e).map(e|e)).map(iterable|iterable.size()).head",
				"Integer");
	}

	@Test
	public void testFeatureCall_15_i() throws Exception {
		resolvesTo(
				"newArrayList(newArrayList('').map(s|1).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)).map(e|e).map(iterable|iterable.size())",
				"List<Integer>");
	}

	@Test
	public void testFeatureCall_15_i_2() throws Exception {
		resolvesTo(
				"newArrayList(newArrayList('').map(s|1).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)).map(e|e).map(iterable|iterable.size()).head",
				"Integer");
	}

	@Test
	public void testFeatureCall_15_i_3() throws Exception {
		resolvesTo("newArrayList(newArrayList('').map(s|1).map(e|e)).map(iterable|iterable.size()).map(e|e)", "List<Integer>");
	}

	@Test
	public void testFeatureCall_15_i_4() throws Exception {
		resolvesTo("newArrayList(newArrayList('').map(s|1).map(e|e)).map(iterable|iterable.size()).map(e|e).head", "Integer");
	}

	@Test
	public void testFeatureCall_15_j() throws Exception {
		resolvesTo("newArrayList(newArrayList('').map(s|1).map(e|e).map(e|e)).map(iterable|iterable.size()).map(e|e).map(e|e)",
				"List<Integer>");
	}

	@Test
	public void testFeatureCall_15_j_2() throws Exception {
		resolvesTo("newArrayList(newArrayList('').map(s|1).map(e|e).map(e|e)).map(iterable|iterable.size()).map(e|e).map(e|e).head",
				"Integer");
	}

	@Test
	public void testFeatureCall_15_k() throws Exception {
		resolvesTo(
				"newArrayList(newArrayList('').map(s|1).map(e|e).map(e|e).map(e|e)).map(iterable|iterable.size()).map(e|e).map(e|e).map(e|e)",
				"List<Integer>");
	}

	@Test
	public void testFeatureCall_15_k_2() throws Exception {
		resolvesTo(
				"newArrayList(newArrayList('').map(s|1).map(e|e).map(e|e).map(e|e)).map(iterable|iterable.size()).map(e|e).map(e|e).map(e|e).head",
				"Integer");
	}

	@Test
	public void testFeatureCall_15_l() throws Exception {
		resolvesTo(
				"newArrayList(newArrayList('').map(s|1).map(e|e).map(e|e).map(e|e).map(e|e)).map(iterable|iterable.size()).map(e|e).map(e|e).map(e|e).map(e|e)",
				"List<Integer>");
	}

	@Test
	public void testFeatureCall_15_l_2() throws Exception {
		resolvesTo(
				"newArrayList(newArrayList('').map(s|1).map(e|e).map(e|e).map(e|e).map(e|e)).map(iterable|iterable.size()).map(e|e).map(e|e).map(e|e).map(e|e).head",
				"Integer");
	}

	@IgnoredBySmokeTest("Pointless since the scenario is pretty much the same as above")
	@Test
	public void testFeatureCall_15_m() throws Exception {
		resolvesTo(
				"newArrayList(newArrayList('').map(String s|1).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)\n" +
				".map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)\n" +
				".map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)\n" +
				".map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)\n" +
				".map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)\n" +
				".map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)\n" +
				".map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)\n" +
				").map(iterable|iterable.size()).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)\n" +
				".map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)\n" +
				".map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)\n" +
				".map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)\n" +
				".map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)\n" +
				".map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)\n" +
				".map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)\n" +
				".map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).head",
				"Integer");
	}

	@IgnoredBySmokeTest("Pointless since the scenario is pretty much the same as above")
	@Test
	public void testFeatureCall_15_n() throws Exception {
		resolvesTo(
				"newArrayList(newArrayList('').map(s|1).map(e|e).map(e|e).map(e|e).map(e|e)\n" +
				".map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n" +
				".map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n" +
				".map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n" +
				".map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n" +
				".map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n" +
				".map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n" +
				".map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n" +
				".map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n" +
				".map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n" +
				".map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n" +
				".map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n" +
				".map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n" +
				".map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n" +
				".map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n" +
				".map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n" +
				".map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n" +
				".map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n" +
				".map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n" +
				".map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n" +
				".map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n" +
				").map(iterable|iterable.size()).map(e|e).map(e|e).map(e|e).map(e|e)\n" +
				".map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n" +
				".map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n" +
				".map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n" +
				".map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n" +
				".map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n" +
				".map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n" +
				".map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n" +
				".map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n" +
				".map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n" +
				".map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n" +
				".map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n" +
				".map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n" +
				".map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n" +
				".map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n" +
				".map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n" +
				".map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n" +
				".map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n" +
				".map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n" +
				".map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n" +
				".map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n" +
				".map(e|e).map(e|e).map(e|e).map(e|e).head",
				"Integer");
	}

	@Test
	public void testFeatureCall_15_n_1() throws Exception {
		resolvesTo(
				"newArrayList(newArrayList('').map(s|1).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n" +
				".map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n" +
				".map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n" +
				".map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n" +
				".map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n" +
				".map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n" +
				".map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n" +
				".map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n" +
				".map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n" +
				".map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n" +
				".map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n" +
				".map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n" +
				".map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n" +
				".map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n" +
				".map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n" +
				".map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n" +
				".map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n" +
				".map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n" +
				".map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n" +
				".map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n" +
				".map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n" +
				").map(iterable|iterable.size()).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n" +
				".map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n" +
				".map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n" +
				".map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n" +
				".map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n" +
				".map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n" +
				".map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n" +
				".map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n" +
				".map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n" +
				".map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n" +
				".map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n" +
				".map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n" +
				".map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n" +
				".map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n" +
				".map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n" +
				".map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n" +
				".map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n" +
				".map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n" +
				".map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n" +
				".map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n" +
				".map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n" +
				".map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).head",
				"Integer");
	}

	@Test
	public void testFeatureCall_15_n_2() throws Exception {
		resolvesTo(
				"newArrayList(newArrayList('').map(s|1).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n" +
				".map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n" +
				".map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n" +
				".map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n" +
				".map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n" +
				".map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n" +
				".map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n" +
				".map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n" +
				".map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n" +
				".map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n" +
				".map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n" +
				".map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n" +
				".map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n" +
				".map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n" +
				".map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n" +
				".map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n" +
				".map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n" +
				".map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n" +
				".map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n" +
				".map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n" +
				".map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n" +
				").map(iterable|iterable.size()).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n" +
				".map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n" +
				".map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n" +
				".map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n" +
				".map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n" +
				".map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n" +
				".map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n" +
				".map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n" +
				".map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n" +
				".map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n" +
				".map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n" +
				".map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n" +
				".map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n" +
				".map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n" +
				".map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n" +
				".map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n" +
				".map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n" +
				".map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n" +
				".map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n" +
				".map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n" +
				".map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n" +
				".map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).head",
				"Integer");
	}

	@Test
	public void testFeatureCall_15_o() throws Exception {
		resolvesTo("newArrayList(newArrayList('')).map(iterable|iterable.size())", "List<Integer>");
	}

	@Test
	public void testFeatureCall_15_o_2() throws Exception {
		resolvesTo("newArrayList(newArrayList('')).map(iterable|iterable.size()).head", "Integer");
	}

	@Test
	public void testFeatureCall_15_p() throws Exception {
		resolvesTo("newArrayList(newArrayList('')).map(iterable|iterable.size()).map(e|e)", "List<Integer>");
	}

	@Test
	public void testFeatureCall_15_p_2() throws Exception {
		resolvesTo("newArrayList(newArrayList('')).map(iterable|iterable.size()).map(e|e).head", "Integer");
	}

	@Test
	public void testFeatureCall_16_a() throws Exception {
		resolvesTo("newArrayList('').map(s|1).map(i|1)", "List<Integer>");
	}

	@Test
	public void testFeatureCall_16_b() throws Exception {
		resolvesTo("newArrayList('').map(s|1).map(i|1).head", "Integer");
	}

	@Test
	public void testFeatureCall_17_a() throws Exception {
		resolvesTo("newArrayList('').map(s|s.length).map(i|i)", "List<Integer>");
	}

	@Test
	public void testFeatureCall_17_b() throws Exception {
		resolvesTo("newArrayList('').map(s|s.length).map(i|i).head", "Integer");
	}

	@Test
	public void testFeatureCall_18_a() throws Exception {
		resolvesTo("newArrayList('').map(s|s.length + 1 == 5).map(b|b)", "List<Boolean>");
	}

	@Test
	public void testFeatureCall_18_b() throws Exception {
		resolvesTo("newArrayList('').map(s|s.length + 1 == 5).map(b|b).head", "Boolean");
	}

	@Test
	public void testFeatureCall_19_a() throws Exception {
		resolvesTo("newArrayList('').map(s|s.length + 1 == 5).map(b| { 'length'.length b })", "List<Boolean>");
	}

	@Test
	public void testFeatureCall_19_b() throws Exception {
		resolvesTo("newArrayList('').map(s|s.length + 1 == 5).map(b| { 'length'.length b }).head", "Boolean");
	}

	@Test
	public void testFeatureCall_20_a() throws Exception {
		resolvesTo("newArrayList('').map(s|s.length + 1 == 5).map(Boolean b|!b)", "List<Boolean>");
	}

	@Test
	public void testFeatureCall_20_b() throws Exception {
		resolvesTo("newArrayList('').map(s|s.length + 1 == 5).map(Boolean b|!b).head", "Boolean");
	}

	@Test
	public void testFeatureCall_21_a() throws Exception {
		resolvesTo("newArrayList('').map(s|s.length + 1 == 5).map(b| ! b )", "List<Boolean>");
	}

	@Test
	public void testFeatureCall_21_b() throws Exception {
		resolvesTo("newArrayList('').map(s|s.length + 1 == 5).map(b| ! b ).head", "Boolean");
	}

	@Test
	public void testFeatureCall_22_a() throws Exception {
		resolvesTo("newArrayList('').map(s|s.length + 1 == 5).map(b| { !b } )", "List<Boolean>");
	}

	@Test
	public void testFeatureCall_22_b() throws Exception {
		resolvesTo("newArrayList('').map(s|s.length + 1 == 5).map(b| { !b } ).head", "Boolean");
	}

	@Test
	public void testFeatureCall_23_a() throws Exception {
		resolvesTo("newArrayList('').map(s|s.length + 1 == 5).map(b| { b.operator_not } )", "List<Boolean>");
	}

	@Test
	public void testFeatureCall_23_b() throws Exception {
		resolvesTo("newArrayList('').map(s|s.length + 1 == 5).map(b| { b.operator_not } ).head", "Boolean");
	}

	@Test
	public void testFeatureCall_24_a() throws Exception {
		resolvesTo("newArrayList('').map(s|" + "$$ObjectExtensions::operator_equals("
				+ "	$$IntegerExtensions::operator_plus(s.length,1), 5)" + ").map(b| $$BooleanExtensions::operator_not(b) )",
				"List<Boolean>");
	}

	@Test
	public void testFeatureCall_24_b() throws Exception {
		resolvesTo("newArrayList('').map(s|" + "$$ObjectExtensions::operator_equals("
				+ "	$$IntegerExtensions::operator_plus(s.length,1), 5)" + ").map(b| $$BooleanExtensions::operator_not(b) ).head",
				"Boolean");
	}

	@Test
	public void testFeatureCall_25_a() throws Exception {
		resolvesTo("newArrayList('').map(s|s.length + 1 * 5).map(b| b / 5 )", "List<Integer>");
	}

	@IgnoredBySmokeTest("Same as testFeatureCall_25_a")
	@Test
	public void testFeatureCall_25_b() throws Exception {
		resolvesTo("newArrayList('').map(s|s.length + 1 * 5).map(b| b / 5 ).head", "Integer");
	}

	@IgnoredBySmokeTest("Same as testFeatureCall_25_a")
	@Test
	public void testFeatureCall_25_c() throws Exception {
		resolvesTo("newArrayList('').map[ length + 1 * 5 ].map [ it / 5 ].head", "Integer");
	}

	@IgnoredBySmokeTest("Same as testFeatureCall_25_a")
	@Test
	public void testFeatureCall_25_d() throws Exception {
		resolvesTo("newArrayList('').map[ length + 1 * 5 - length + 1 * 5 ].map [ it / 5 + 1 / it ].head", "Integer");
	}

	@Test
	public void testFeatureCall_26() throws Exception {
		resolvesTo(
				"{ val list = newArrayList(if (false) new Double('-20') else new Integer('20')).map(v|v.intValue)\n" +
				"           val Object o = list.head \n" +
				"           list\n" +
				"        }",
				"List<Integer>");
	}

	@Test
	public void testFeatureCall_26a() throws Exception {
		resolvesTo(
				"{ val list = newArrayList(if (false) new Double('-20') else new Integer('20')).map(v|v.intValue)\n" +
				"           val Object o = list.head \n" +
				"           list.head\n" +
				"        }",
				"Integer");
	}

	@Test
	public void testFeatureCall_26b() throws Exception {
		resolvesTo(
				"{ val list = newArrayList(if (false) new Double('-20') else new Integer('20')).map(v|v.compareTo(null))\n" +
				"           val Object o = list.head \n" +
				"           list.head\n" +
				"        }",
				"Integer");
	}

	@Test
	public void testFeatureCall_27() throws Exception {
		resolvesTo(
				"{ val list = $$ListExtensions::map(newArrayList(if (false) new Double('-20') else new Integer('20'))) [ v|v.intValue ]\n" +
				"           val Object o = list.head \n" +
				"           list\n" +
				"        }",
				"List<Integer>");
	}

	@Test
	public void testFeatureCall_28() throws Exception {
		resolvesTo(
				"{ val list = $$ListExtensions::map(newArrayList(null as Integer)) [ v|v.intValue ]\n" +
				"           val Object o = list.head \n" +
				"           list\n" +
				"        }",
				"List<Integer>");
	}

	@Test
	public void testFeatureCall_30() throws Exception {
		resolvesTo(
				"{ val list = newArrayList(null as Integer).map [ v|v.intValue ]\n" +
				"           val Object o = list.head \n" +
				"           list\n" +
				"        }",
				"List<Integer>");
	}

	@Test
	public void testFeatureCall_31() throws Exception {
		resolvesTo(
				"{ val list = newArrayList(null as Integer).map [ v|v.intValue ]\n" +
				"           val Object o = list.head \n" +
				"           list.findFirst [ intValue == 0 ]\n" +
				"        }",
				"Integer");
	}

	@Test
	public void testFeatureCall_32() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	list.forEach[String s | s]\n" +
				"	list\n" +
				"}", "ArrayList<String>");
	}

	@Test
	public void testFeatureCall_33() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	list.findFirst[String s | true]\n" +
				"	list\n" +
				"}", "ArrayList<String>");
	}

	@Test
	public void testFeatureCall_34() throws Exception {
		resolvesTo("newArrayList.map[String s | s.substring(1,1) ]", "List<String>");
	}

	@Test
	public void testFeatureCall_35() throws Exception {
		resolvesTo("newArrayList.map[ s | s.toString ]", "List<String>");
	}

	@Test
	public void testFeatureCall_36() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	list.forEach[ s | s.toString ]\n" +
				"	list\n" +
				"}", "ArrayList<Object>");
	}

	@Test
	public void testFeatureCall_37() throws Exception {
		resolvesTo("java::util::Arrays::asList('', '', '').map(s | s.length()).fold(0) [ l, r | if (l > r) l else r]", "Integer");
	}

	@Test
	public void testFeatureCall_38() throws Exception {
		resolvesTo("(null as Iterable<Integer>).fold(0) [ l, r | if (l > r) l else r]", "Integer");
	}

	@Test
	public void testFeatureCall_39() throws Exception {
		resolvesTo("new testdata.ArrayClient().toStringArray('a', 'b').filter(e|e!=null)", "Iterable<String>");
	}

	@Test
	public void testFeatureCall_40() throws Exception {
		resolvesTo("new testdata.ArrayClient().toStringArray('a', 'b').map[ it ]", "List<String>");
	}

	@Test
	public void testFeatureCall_41() throws Exception {
		resolvesTo("new testdata.ArrayClient().toStringArray('a', 'b')", "String[]");
	}

	@Test
	public void testFeatureCall_42() throws Exception {
		resolvesTo("new testdata.ArrayClient().toStringArray('a', 'b').head", "String");
	}

	@Test
	public void testFeatureCall_43_a() throws Exception {
		resolvesTo(
				"{\n"
				+ "  var a = 0\n"
				+ "  var b = 0\n"
				+ "  var c = 0\n"
				+ "  a - (c*(Double.valueOf(10**(b-1)).intValue))\n"
				+ "}",
				"int");
	}
	
	@IgnoredBySmokeTest("Almost the same as testFeatureCall_43_a")
	@Test
	public void testFeatureCall_43_b() throws Exception {
		resolvesTo(
				"{\n"
				+ "  var a = 0\n"
				+ "  var b = 0\n"
				+ "  var c = 0\n"
				+ "  a - ((c*(Double.valueOf(10**(b-1)).intValue)) + (a - (c*(Double.valueOf(10**(b-1)).intValue))))\n"
				+ "}",
				"int");
	}
	
	@IgnoredBySmokeTest("Almost the same as testFeatureCall_43_a")
	@Test
	public void testFeatureCall_43_c() throws Exception {
		resolvesTo(
				"{\n"
				+ "  var a = 0\n"
				+ "  var b = 0\n"
				+ "  var c = 0\n"
				+ "  a - (((c*(Double.valueOf(10**(b-1)).intValue)) + (a - (c*(Double.valueOf(10**(b-1)).intValue)))) + (a - ((c*(Double.valueOf(10**(b-1)).intValue)) + (a - (c*(Double.valueOf(10**(b-1)).intValue))))))\n"
				+ "}",
				"int");
	}
	
	@Test
	public void testFeatureCall_44_a() throws Exception {
		resolvesTo(
				"{\n"
				+ "    val mu = 0.0\n"
				+ "    val beta = 0.0\n"
				+ "    val double L = 0.0\n"
				+ "    val int a = 0\n"
				+ "    val int b = 0\n"
				+ "    val double lambda = 0.0\n"
				+ "    val double sa = 0.0\n"
				+ "    val double sb = 0.0\n"
				+ "    mu * (sa + lambda * (sb - sa) - 0.5 * mu * (a + lambda * (b - a)))\n"
				+ "}",
				"double");
	}
	
	@IgnoredBySmokeTest("Almost the same as testFeatureCall_44_a")
	@Test
	public void testFeatureCall_44_b() throws Exception {
		resolvesTo(
				"{\n"
				+ "    val mu = 0.0\n"
				+ "    val beta = 0.0\n"
				+ "    val double L = 0.0\n"
				+ "    val int a = 0\n"
				+ "    val int b = 0\n"
				+ "    val double lambda = 0.0\n"
				+ "    val double sa = 0.0\n"
				+ "    val double sb = 0.0\n"
				+ "    mu * ((sa + lambda * (sb - sa) - 0.5 * mu * (a + lambda * (b - a))) + (mu * (sa + lambda * (sb - sa) - 0.5 * mu * (a + lambda * (b - a)))))\n"
				+ "}",
				"double");
	}
	
	@Test
	public void testToList_01() throws Exception {
		resolvesTo(
				"{ val Iterable<? extends String> iter = null org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::fixedToList(iter) }",
				"List<? extends String>");
	}

	@Test
	public void testToList_02() throws Exception {
		resolvesTo(
				"{ val Iterable<? super String> iter = null org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::fixedToList(iter) }",
				"List<? super String>");
	}

	@Test
	public void testToList_03() throws Exception {
		resolvesTo(
				"{ val Iterable<String> iter = null org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::fixedToList(iter) }",
				"List<String>");
	}

	@Test
	public void testToList_04() throws Exception {
		resolvesTo(
				"{ val Iterable<? extends String> iter = null org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::brokenToList(iter) }",
				"List<String>");
	}

	@Test
	public void testToList_05() throws Exception {
		resolvesTo(
				"{ val Iterable<? super String> iter = null org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::brokenToList(iter) }",
				"List<Object>");
	}

	@Test
	public void testToList_06() throws Exception {
		resolvesTo(
				"{ val Iterable<String> iter = null org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::brokenToList(iter) }",
				"List<String>");
	}

	@Test
	public void testToList_07() throws Exception {
		resolvesTo(
				"{ val Iterable<? extends String> iter = null org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::brokenToList2(iter) }",
				"List<String>");
	}

	@Test
	public void testToList_08() throws Exception {
		resolvesTo(
				"{ val Iterable<? super String> iter = null org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::brokenToList2(iter) }",
				"List<String>");
	}

	@Test
	public void testToList_09() throws Exception {
		resolvesTo(
				"{ val Iterable<String> iter = null org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::brokenToList2(iter) }",
				"List<String>");
	}

	@Test
	public void testFeatureCall_Bug342134_00() throws Exception {
		resolvesTo("(null as java.util.List<String>).map(e|newArrayList(e)).flatten", "Iterable<String>");
	}

	@Test
	public void testFeatureCall_Bug342134_01() throws Exception {
		resolvesTo("(null as java.util.List<String>).map(e|newArrayList(e)).flatten.head", "String");
	}

	@Test
	public void testFeatureCall_Bug342134_02() throws Exception {
		resolvesTo("newArrayList('').map(e|newArrayList(e)).flatten", "Iterable<String>");
	}

	@Test
	public void testFeatureCall_Bug342134_03() throws Exception {
		resolvesTo("newArrayList('').map(e|newArrayList(e)).flatten.head", "String");
	}

	@Test
	public void testFeatureCall_Bug342134_04() throws Exception {
		resolvesTo("newArrayList('').map(e|newArrayList(e))", "List<ArrayList<String>>");
	}

	@Test
	public void testFeatureCall_Bug342134_05() throws Exception {
		resolvesTo("newArrayList('').map(e|newArrayList(e)).head", "ArrayList<String>");
	}

	@Test
	public void testFeatureCall_Bug342134_06() throws Exception {
		resolvesTo("<String>newArrayList.map(e|newArrayList(e)).flatten", "Iterable<String>");
	}

	@Test
	public void testFeatureCall_Bug342134_07() throws Exception {
		resolvesTo("newArrayList('').map(e|<String>newArrayList(e)).flatten", "Iterable<String>");
	}

	@Test
	public void testFeatureCall_Bug342134_08() throws Exception {
		resolvesTo("newArrayList.map(String e|<String>newArrayList(e)).flatten", "Iterable<String>");
	}

	@Test
	public void testFeatureCall_Bug342134_09() throws Exception {
		resolvesTo("newArrayList(newArrayList('')).flatten", "Iterable<String>");
	}

	@Test
	public void testFeatureCall_Bug342134_10() throws Exception {
		resolvesTo("<java.util.List<String>>newArrayList().flatten", "Iterable<String>");
	}

	@Test
	public void testBug_389512() throws Exception {
		resolvesTo(
				"{\n" +
				"	val Object it = null\n" +
				"	^class.declaredFields.toMap[name].mapValues[get(it)]\n" +
				"}", "Map<String, Object>");
	}

	@Test
	public void testBug_391758() throws Exception {
		resolvesTo(
				"{\n" +
				"	val iterable = newArrayList\n" +
				"	iterable.fold(newArrayList) [ list , elem | null as java.util.List<String> ]\n" +
				"}",
				"List<String>");
	}

	@Test
	public void testBug_381466_01() throws Exception {
		resolvesTo(
				"{\n" +
				"            val map = com::google::common::collect::HashMultimap::create\n" +
				"            val com.google.common.collect.HashMultimap<String, Integer> stringToInts = null\n" +
				"            stringToInts.putAll(map)\n" +
				"            map\n" +
				"        }",
				"HashMultimap<String, Integer>");
	}

	@Test
	public void testBug_381466_02() throws Exception {
		resolvesTo(
				"{\n" +
				"            val map = com::google::common::collect::HashMultimap::create\n" +
				"            val java.util.Map<String, java.util.Collection<Integer>> stringToInts = null\n" +
				"            stringToInts.putAll(map.asMap)\n" +
				"            map\n" +
				"        }",
				"HashMultimap<String, Integer>");
	}

	@Test
	public void testBug_381466_03() throws Exception {
		resolvesTo(
				"{\n" +
				"            val map = com::google::common::collect::HashMultimap::create\n" +
				"            val java.util.Map<String, Iterable<Integer>> stringToInts = null\n" +
				"            stringToInts.putAll(map.asMap)\n" +
				"            map\n" +
				"        }",
				"HashMultimap<String, Integer>");
	}

	@Test
	public void testBug_381466_04() throws Exception {
		resolvesTo(
				"{\n" +
				"            val map = com::google::common::collect::HashMultimap::create\n" +
				"            val stringToInts = newHashMap\n" +
				"            stringToInts.keySet.addAll(map.asMap.keySet)\n" +
				"            stringToInts.values.add(map.values.head)\n" +
				"            stringToInts.put('', 1)\n" +
				"            map\n" +
				"        }",
				"HashMultimap<String, Integer>");
	}

	@Test
	public void testBounds_01() throws Exception {
		resolvesTo("{ var java.util.List<Integer> list = null list.get(0) }", "Integer");
	}

	@Test
	public void testBounds_02() throws Exception {
		resolvesTo("{ var java.util.List<? extends Integer> list = null list.get(0) }", "Integer");
	}

	@Test
	public void testBounds_03() throws Exception {
		resolvesTo("{ var java.util.List<? super Integer> list = null list.get(0) }", "Object");
	}

	@Test
	public void testBounds_04() throws Exception {
		resolvesTo("{ var java.util.List<Integer> list = null list.subList(0, 1) }", "List<Integer>");
	}

	@Test
	public void testBounds_05() throws Exception {
		resolvesTo("{ var java.util.List<? extends Integer> list = null list.subList(0, 1) }", "List<? extends Integer>");
	}

	@Test
	public void testBounds_06() throws Exception {
		resolvesTo("{ var java.util.List<? super Integer> list = null list.subList(0, 1) }", "List<? super Integer>");
	}

	@Test
	public void testBounds_07() throws Exception {
		resolvesTo("{ var java.util.List<Integer> list = null list.last }", "Integer");
	}

	@Test
	public void testBounds_08() throws Exception {
		resolvesTo("{ var java.util.List<? extends Integer> list = null list.last }", "Integer");
	}

	@Test
	public void testBounds_09() throws Exception {
		resolvesTo("{ var java.util.List<? super Integer> list = null list.last }", "Object");
	}

	@Test
	public void testBounds_10() throws Exception {
		resolvesTo("{ var java.util.List<Iterable<Integer>> list = null list.last }", "Iterable<Integer>");
	}

	@Test
	public void testBounds_11() throws Exception {
		resolvesTo("{ var java.util.List<Iterable<Integer>> list = null list.last.last }", "Integer");
	}

	@Test
	public void testBounds_12() throws Exception {
		resolvesTo("{ var java.util.List<? extends Iterable<Integer>> list = null list.last }", "Iterable<Integer>");
	}

	@Test
	public void testBounds_13() throws Exception {
		resolvesTo("{ var java.util.List<? extends Iterable<Integer>> list = null list.last.last }", "Integer");
	}

	@Test
	public void testBounds_14() throws Exception {
		resolvesTo("{ var java.util.List<Iterable<? extends Integer>> list = null list.last }", "Iterable<? extends Integer>");
	}

	@Test
	public void testBounds_15() throws Exception {
		resolvesTo("{ var java.util.List<Iterable<? extends Integer>> list = null list.last.last }", "Integer");
	}

	@Test
	public void testBounds_16() throws Exception {
		resolvesTo("{ var java.util.List<? extends Iterable<? extends Integer>> list = null list.last }", "Iterable<? extends Integer>");
	}

	@Test
	public void testBounds_17() throws Exception {
		resolvesTo("{ var java.util.List<? extends Iterable<? extends Integer>> list = null list.last.last }", "Integer");
	}

	@Test
	public void testBounds_18() throws Exception {
		resolvesTo("{ var java.util.List<Iterable<? super Integer>> list = null list.last }", "Iterable<? super Integer>");
	}

	@Test
	public void testBounds_19() throws Exception {
		resolvesTo("{ var java.util.List<Iterable<? super Integer>> list = null list.last.last }", "Object");
	}

	@Test
	public void testBounds_20() throws Exception {
		resolvesTo("{ var java.util.List<? extends Iterable<? super Integer>> list = null list.last }", "Iterable<? super Integer>");
	}

	@Test
	public void testBounds_21() throws Exception {
		resolvesTo("{ var java.util.List<? extends Iterable<? super Integer>> list = null list.last.last }", "Object");
	}

	@Test
	public void testBounds_22() throws Exception {
		resolvesTo("(null as com.google.inject.Provider<? extends String>).get", "String");
	}

	@Test
	public void testBounds_23() throws Exception {
		resolvesTo("(null as com.google.inject.Provider<? extends Iterable<String>[]>).get", "Iterable<String>[]");
	}

	@Test
	public void testBounds_24() throws Exception {
		resolvesTo("new testdata.ClosureClient().useProvider(null as com.google.inject.Provider<? extends Iterable<String>[]>)",
				"Iterable<String>[]");
	}

	@Test
	public void testBounds_25() throws Exception {
		resolvesTo("new testdata.ClosureClient().useProvider(null as com.google.inject.Provider<? extends String>)", "String");
	}

	@Test
	public void testBounds_26() throws Exception {
		resolvesTo("new testdata.ClosureClient().useProvider(null as =>Iterable<String>[])", "Iterable<String>[]");
	}

	@Test
	public void testBounds_27() throws Exception {
		resolvesTo("new testdata.ClosureClient().useProvider(null as =>String)", "String");
	}

	@Test
	public void testImplicitReceiverBounds_01() throws Exception {
		resolvesTo("{ var java.util.List<Integer> it = null get(0) }", "Integer");
	}

	@Test
	public void testImplicitReceiverBounds_02() throws Exception {
		resolvesTo("{ var java.util.List<? extends Integer> it = null get(0) }", "Integer");
	}

	@Test
	public void testImplicitReceiverBounds_03() throws Exception {
		resolvesTo("{ var java.util.List<? super Integer> it = null get(0) }", "Object");
	}

	@Test
	public void testImplicitReceiverBounds_04() throws Exception {
		resolvesTo("{ var java.util.List<Integer> it = null subList(0, 1) }", "List<Integer>");
	}

	@Test
	public void testImplicitReceiverBounds_05() throws Exception {
		resolvesTo("{ var java.util.List<? extends Integer> it = null subList(0, 1) }", "List<? extends Integer>");
	}

	@Test
	public void testImplicitReceiverBounds_06() throws Exception {
		resolvesTo("{ var java.util.List<? super Integer> it = null subList(0, 1) }", "List<? super Integer>");
	}

	@Test
	public void testImplicitReceiverBounds_07() throws Exception {
		resolvesTo("{ var java.util.List<Integer> it = null last }", "Integer");
	}

	@Test
	public void testImplicitReceiverBounds_08() throws Exception {
		resolvesTo("{ var java.util.List<? extends Integer> it = null last }", "Integer");
	}

	@Test
	public void testImplicitReceiverBounds_09() throws Exception {
		resolvesTo("{ var java.util.List<? super Integer> it = null last }", "Object");
	}

	@Test
	public void testPropertyAccess_01() throws Exception {
		resolvesTo("{ var java.util.List<Integer> it = null empty }", "boolean");
	}

	@Test
	public void testPropertyAccess_02() throws Exception {
		resolvesTo("{ var java.util.List<Integer> list = null list.empty }", "boolean");
	}

	@Test
	public void testPropertyAccess_03() throws Exception {
		resolvesTo("{ var Iterable<Integer> iterable = null iterable.empty }", "boolean");
	}

	@Test
	public void testPropertyAccess_04() throws Exception {
		resolvesTo("{ var Iterable<Integer> it = null empty }", "boolean");
	}

	@Test
	public void testPropertyAccess_05() throws Exception {
		resolvesTo("{ var Iterable<Integer> iterable = null iterable.class }", "Class<? extends Iterable>");
	}

	@Test
	public void testPropertyAccess_06() throws Exception {
		resolvesTo("{ var Iterable<Integer> it = null class }", "Class<? extends Iterable>");
	}

	@Test
	public void testReceiverIsPartiallyResolved_01() throws Exception {
		resolvesTo("newArrayList.get(0)", "Object");
	}

	@Test
	public void testReceiverIsPartiallyResolved_02() throws Exception {
		resolvesTo("newArrayList.toString", "String");
	}

	@Test
	public void testTypeByTransitiveExpectation_01() throws Exception {
		resolvesTo("newArrayList.flatten.toList.flatten.head", "Object");
	}

	@Test
	public void testTypeByTransitiveExpectation_02() throws Exception {
		resolvesTo("newArrayList.subList(1,1).subList(1,1).head", "Object");
	}

	@Test
	public void testTypeByTransitiveExpectation_03() throws Exception {
		resolvesTo("newArrayList.flatten.toList.<Number>flatten.head", "Number");
	}

	@Test
	public void testTypeByTransitiveExpectation_04() throws Exception {
		resolvesTo("newArrayList.<java.util.Set<Number>>flatten.toList.flatten.head", "Number");
	}

	@Test
	public void testTypeByTransitiveExpectation_05() throws Exception {
		resolvesTo("newArrayList.flatten.<java.util.Set<Number>>toList.flatten.head", "Number");
	}

	@Test
	public void testTypeByTransitiveExpectation_06() throws Exception {
		resolvesTo("newArrayList.flatten.toList.flatten.<Number>head", "Number");
	}

	@Test
	public void testDeferredTypeArgumentResolution_001() throws Exception {
		resolvesTo("newArrayList", "ArrayList<Object>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_002() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	val String s = list.get(0)\n" +
				"	list\n" +
				"}", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_003() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	val String s = list.head\n" +
				"	list\n" +
				"}", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_004() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	list.add('')\n" +
				"	list\n" +
				"}", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_005() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	$$CollectionExtensions::addAll(list, null as java.util.ArrayList<String>)\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_006() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	$$CollectionExtensions::addAll(list, '', '')\n" +
				"	list\n" +
				"}", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_007() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	list.addAll(null as java.util.ArrayList<String>)\n" +
				"	list\n" +
				"}", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_008() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	$$CollectionExtensions::addAll(list, null as java.util.ArrayList<String>)\n" +
				"	list.head\n" +
				"}",
				"String");
	}

	@Test
	public void testDeferredTypeArgumentResolution_009() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	list.addAll(newHashSet(''))\n" +
				"	list\n" +
				"}", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_010() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	list.addAll(null as java.util.Collection<String>)\n" +
				"	list\n" +
				"}", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_011() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	list.addAll('', '', '')\n" +
				"	list\n" +
				"}", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_012() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	val secondList = newArrayList\n" +
				"	list.add('')\n" +
				"	list.addAll(secondList)\n" +
				"	secondList\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_013() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	val secondList = newArrayList\n" +
				"	list.addAll(secondList)\n" +
				"	list.add('')\n" +
				"	secondList\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_014() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	val Iterable<String> sublist = list.subList(1, 1)\n" +
				"	list\n" +
				"}", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_015() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	val java.util.Set<String> sublist = list.subList(1, 1)\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_016() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	val java.util.Iterator<String> sublist = list.subList(1, 1).iterator\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_017() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	for(String s: list.subList(1, 1)) {}\n" +
				"	list\n" +
				"}", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_018() throws Exception {
		if (JavaRuntimeVersion.isJava12OrLater()) {
			resolvesTo(
				"{\n" +
				"val list = newArrayList\n" +
				"list.add(new Integer(0))\n" +
				"list.add(new Integer(0).doubleValue)\n" +
				"list\n" +
				"}",
					"ArrayList<Number & Comparable<?> & Constable & ConstantDesc>");
		} else {
			resolvesTo(
				"{\n" +
				"val list = newArrayList\n" +
				"list.add(new Integer(0))\n" +
				"list.add(new Integer(0).doubleValue)\n" +
				"list\n" +
				"}",
					"ArrayList<Number & Comparable<?>>");
		}
	}

	@Test
	public void testDeferredTypeArgumentResolution_019() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	list.add(new Integer(0))\n" +
				"	list.get(0).toString\n" +
				"	list.add(new Integer(0).doubleValue)\n" +
				"	list\n" +
				"}",
				"ArrayList<Integer>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_020() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	val second = newArrayList\n" +
				"	list.add(second.get(0))\n" +
				"	list.add('')\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_021() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	val second = newArrayList\n" +
				"	list.add(second.get(0))\n" +
				"	list.add('')\n" +
				"	second\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_022() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	val second = newArrayList\n" +
				"	list.add(second.head)\n" +
				"	list.add('')\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_023() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	val second = newArrayList\n" +
				"	list.add(second.head)\n" +
				"	list.add('')\n" +
				"	second\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_024() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	val second = newArrayList\n" +
				"	list.add('')\n" +
				"	list.add(second.get(0))\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_025() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	val second = newArrayList\n" +
				"	list.add('')\n" +
				"	list.add(second.get(0))\n" +
				"	second\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_026() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	val second = newArrayList\n" +
				"	list.add('')\n" +
				"	list.add(second.head)\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_027() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	val second = newArrayList\n" +
				"	list.add('')\n" +
				"	list.add(second.head)\n" +
				"	second\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_028() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	val second = newArrayList\n" +
				"	list.add(second.get(0))\n" +
				"	second.add('')\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_029() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	val second = newArrayList\n" +
				"	list.add(second.get(0))\n" +
				"	second.add('')\n" +
				"	second\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_030() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	val second = newArrayList\n" +
				"	list.add(second.head)\n" +
				"	second.add('')\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_031() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	val second = newArrayList\n" +
				"	list.add(second.head)\n" +
				"	second.add('')\n" +
				"	second\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_032() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	val second = newArrayList\n" +
				"	second.add('')\n" +
				"	list.add(second.get(0))\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_033() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	val second = newArrayList\n" +
				"	second.add('')\n" +
				"	list.add(second.get(0))\n" +
				"	second\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_034() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	val second = newArrayList\n" +
				"	second.add('')\n" +
				"	list.add(second.head)\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_035() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	val second = newArrayList\n" +
				"	second.add('')\n" +
				"	list.add(second.head)\n" +
				"	second\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_036() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList(newArrayList)\n" +
				"	val Iterable<String> s = list.head\n" +
				"	list.head\n" +
				"}", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_037() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList(newArrayList)\n" +
				"	val Iterable<String> s = list.flatten\n" +
				"	list.head\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_038() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList(newHashSet)\n" +
				"	val String s = list.flatten.head\n" +
				"	list.head\n" +
				"}", "HashSet<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_039() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList(newArrayList)\n" +
				"	val String s = list.flatten.head\n" +
				"	list.head\n" +
				"}", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_040() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	val second = newArrayList(newArrayList)\n" +
				"	val String s = second.flatten.head\n" +
				"	list.add(second.head)\n" +
				"	list.head\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_041() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	list.addAll('')\n" +
				"	list\n" +
				"}", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_042() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	val secondList = newArrayList\n" +
				"	list.addAll('')\n" +
				"	list.addAll(secondList)\n" +
				"	secondList\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_043() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	val secondList = newArrayList\n" +
				"	list.addAll(secondList)\n" +
				"	list.addAll('')\n" +
				"	secondList\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_044() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	list.addAll('', '', '')\n" +
				"	list.head\n" +
				"}", "String");
	}

	@Test
	public void testDeferredTypeArgumentResolution_045() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	val secondList = newArrayList\n" +
				"	list.addAll('', '', '')\n" +
				"	list.addAll(secondList)\n" +
				"	secondList\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_046() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	val secondList = newArrayList\n" +
				"	list.addAll(secondList)\n" +
				"	list.addAll('', '', '')\n" +
				"	secondList\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_047() throws Exception {
		resolvesTo("println(newArrayList)", "ArrayList<Object>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_048() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	val String s = println(list.get(0))\n" +
				"	list\n" +
				"}", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_049() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	val String s = println(println(list).head)\n" +
				"	list\n" +
				"}", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_050() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	println(list).add('')\n" +
				"	list\n" +
				"}", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_051() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	$$CollectionExtensions::addAll(println(list), null as java.util.ArrayList<String>)\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_052() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	$$CollectionExtensions::addAll(println(list), println(''), println(''))\n" +
				"	list.head\n" +
				"}",
				"String");
	}

	@Test
	public void testDeferredTypeArgumentResolution_053() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	println(list).addAll(null as java.util.ArrayList<String>)\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_054() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	println(list).addAll(println(newArrayList('')))\n" +
				"	println(list)\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_055() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = println(newArrayList)\n" +
				"	println(list).addAll(println(newHashSet('')))\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_056() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = println(newArrayList)\n" +
				"	println(list).addAll(null as java.util.Collection<String>)\n" +
				"	println(list)\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_057() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	println(list).addAll('', '', '')\n" +
				"	list\n" +
				"}", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_058() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = println(newArrayList)\n" +
				"	val secondList = println(newArrayList)\n" +
				"	println(list).add('')\n" +
				"	println(list).addAll(println(secondList))\n" +
				"	secondList\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_059() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = println(newArrayList)\n" +
				"	val secondList = println(newArrayList)\n" +
				"	println(list).addAll(println(secondList))\n" +
				"	println(list).add('')\n" +
				"	println(secondList)\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_060() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	val Iterable<String> sublist = println(println(list).subList(1, 1))\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_061() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	val java.util.Set<String> sublist = println(println(list).subList(1, 1))\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_062() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	val java.util.Iterator<String> sublist = println(println(println(list).subList(1, 1)).iterator)\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_063() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = println(newArrayList)\n" +
				"	for(String s: println(list.subList(1, 1))) {}\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_064() throws Exception {
		if (JavaRuntimeVersion.isJava12OrLater()) {
			resolvesTo(
					"{\n" +
				"val list = newArrayList\n" +
				"list.add(println(new Integer(0)))\n" +
				"list.add(println(new Integer(0).doubleValue))\n" +
				"list\n" +
				"	}",
					"ArrayList<Number & Comparable<?> & Constable & ConstantDesc>");
		} else {
			resolvesTo(
					"{\n" +
				"val list = newArrayList\n" +
				"list.add(println(new Integer(0)))\n" +
				"list.add(println(new Integer(0).doubleValue))\n" +
				"list\n" +
				"	}",
					"ArrayList<Number & Comparable<?>>");
		}
	}

	@Test
	public void testDeferredTypeArgumentResolution_065() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	list.add(println(new Integer(0)))\n" +
				"	println(list.get(0)).toString\n" +
				"	list.add(println(new Integer(0).doubleValue))\n" +
				"	list\n" +
				"}",
				"ArrayList<Integer>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_066() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	val second = newArrayList\n" +
				"	println(list).add(println(second.get(0)))\n" +
				"	println(list).add('')\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_067() throws Exception {
		resolvesTo("new java.util.ArrayList", "ArrayList<Object>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_068() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val String s = list.get(0)\n" +
				"	list\n" +
				"}", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_069() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val String s = list.head\n" +
				"	list\n" +
				"}", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_070() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.add('')\n" +
				"	list\n" +
				"}", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_071() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	$$CollectionExtensions::addAll(list, null as java.util.ArrayList<String>)\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_072() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	$$CollectionExtensions::addAll(list, '', '')\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_073() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.addAll(null as java.util.ArrayList<String>)\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_074() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.addAll(new java.util.ArrayList<String>)\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_075() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.addAll(newHashSet(''))\n" +
				"	list\n" +
				"}", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_076() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.addAll(null as java.util.Collection<String>)\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_077() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.addAll('', '', '')\n" +
				"	list.head\n" +
				"}", "String");
	}

	@Test
	public void testDeferredTypeArgumentResolution_078() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val secondList = new java.util.ArrayList\n" +
				"	list.add('')\n" +
				"	list.addAll(secondList)\n" +
				"	secondList\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_079() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val secondList = new java.util.ArrayList\n" +
				"	list.addAll(secondList)\n" +
				"	list.add('')\n" +
				"	secondList\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_080() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val Iterable<String> sublist = list.subList(1, 1)\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_081() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val java.util.Set<String> sublist = list.subList(1, 1)\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_082() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val java.util.Iterator<String> sublist = list.subList(1, 1).iterator\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_083() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	for(String s: list.subList(1, 1)) {}\n" +
				"	list\n" +
				"}", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_084() throws Exception {
		if (JavaRuntimeVersion.isJava12OrLater()) {
			resolvesTo(
				"{\n" +
				"val list = new java.util.ArrayList\n" +
				"list.add(new Integer(0))\n" +
				"list.add(new Integer(0).doubleValue)\n" +
				"list\n" +
				"	}",
					"ArrayList<Number & Comparable<?> & Constable & ConstantDesc>");
		} else {
			resolvesTo(
				"{\n" +
				"val list = new java.util.ArrayList\n" +
				"list.add(new Integer(0))\n" +
				"list.add(new Integer(0).doubleValue)\n" +
				"list\n" +
				"	}",
					"ArrayList<Number & Comparable<?>>");
		}
	}

	@Test
	public void testDeferredTypeArgumentResolution_085() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.add(new Integer(0))\n" +
				"	list.get(0).toString\n" +
				"	list.add(new Integer(0).doubleValue)\n" +
				"	list\n" +
				"}",
				"ArrayList<Integer>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_086() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val second = new java.util.ArrayList\n" +
				"	list.add(second.get(0))\n" +
				"	list.add('')\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_087() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val second = new java.util.ArrayList\n" +
				"	list.add(second.get(0))\n" +
				"	list.add('')\n" +
				"	second\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_088() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val second = new java.util.ArrayList\n" +
				"	list.add(second.head)\n" +
				"	list.add('')\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_089() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val second = new java.util.ArrayList\n" +
				"	list.add(second.head)\n" +
				"	list.add('')\n" +
				"	second\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_090() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val second = new java.util.ArrayList\n" +
				"	list.add('')\n" +
				"	list.add(second.get(0))\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_091() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val second = new java.util.ArrayList\n" +
				"	list.add('')\n" +
				"	list.add(second.get(0))\n" +
				"	second\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_092() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val second = new java.util.ArrayList\n" +
				"	list.add('')\n" +
				"	list.add(second.head)\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_093() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val second = new java.util.ArrayList\n" +
				"	list.add('')\n" +
				"	list.add(second.head)\n" +
				"	second\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_094() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val second = new java.util.ArrayList\n" +
				"	list.add(second.get(0))\n" +
				"	second.add('')\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_095() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val second = new java.util.ArrayList\n" +
				"	list.add(second.get(0))\n" +
				"	second.add('')\n" +
				"	second\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_096() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val second = new java.util.ArrayList\n" +
				"	list.add(second.head)\n" +
				"	second.add('')\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_097() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val second = new java.util.ArrayList\n" +
				"	list.add(second.head)\n" +
				"	second.add('')\n" +
				"	second\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_098() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val second = new java.util.ArrayList\n" +
				"	second.add('')\n" +
				"	list.add(second.get(0))\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_099() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val second = new java.util.ArrayList\n" +
				"	second.add('')\n" +
				"	list.add(second.get(0))\n" +
				"	second\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_100() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val second = new java.util.ArrayList\n" +
				"	second.add('')\n" +
				"	list.add(second.head)\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_101() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val second = new java.util.ArrayList\n" +
				"	second.add('')\n" +
				"	list.add(second.head)\n" +
				"	second\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_102() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.add(new java.util.HashSet)\n" +
				"	val Iterable<String> s = list.head\n" +
				"	list.head\n" +
				"}",
				"HashSet<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_103() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.add(new java.util.ArrayList)\n" +
				"	val Iterable<String> s = list.flatten\n" +
				"	list.head\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_104() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.add(newHashSet)\n" +
				"	val String s = list.flatten.head\n" +
				"	list.head\n" +
				"}",
				"HashSet<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_105() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.add(new java.util.ArrayList)\n" +
				"	val String s = list.flatten.head\n" +
				"	list.head\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_106() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val second = new java.util.ArrayList\n" +
				"	second.add(new java.util.ArrayList)\n" +
				"	val String s = second.flatten.head\n" +
				"	list.add(second.head)\n" +
				"	list.head\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_107() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.addAll('')\n" +
				"	list\n" +
				"}", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_108() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val secondList = new java.util.ArrayList\n" +
				"	list.addAll('')\n" +
				"	list.addAll(secondList)\n" +
				"	secondList\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_109() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val secondList = new java.util.ArrayList\n" +
				"	list.addAll(secondList)\n" +
				"	list.addAll('')\n" +
				"	secondList\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_110() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.addAll('', '', '')\n" +
				"	list\n" +
				"}", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_111() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val secondList = new java.util.ArrayList\n" +
				"	list.addAll('', '', '')\n" +
				"	list.addAll(secondList)\n" +
				"	secondList\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_112() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val secondList = new java.util.ArrayList\n" +
				"	list.addAll(secondList)\n" +
				"	list.addAll('', '', '')\n" +
				"	secondList\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_113() throws Exception {
		resolvesTo("println(new java.util.ArrayList)", "ArrayList<Object>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_114() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val String s = println(list.get(0))\n" +
				"	list\n" +
				"}", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_115() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val String s = println(println(list).head)\n" +
				"	list\n" +
				"}", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_116() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	println(list).add('')\n" +
				"	list\n" +
				"}", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_117() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	$$CollectionExtensions::addAll(println(list), null as java.util.ArrayList<String>)\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_118() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	$$CollectionExtensions::addAll(println(list), println(''), println(''))\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_119() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	println(list).addAll(null as java.util.ArrayList<String>)\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_120() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	println(list).addAll(println(new java.util.ArrayList<String>))\n" +
				"	println(list)\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_121() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = println(new java.util.ArrayList)\n" +
				"	println(list).addAll(println(newHashSet('')))\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_122() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = println(new java.util.ArrayList)\n" +
				"	println(list).addAll(null as java.util.Collection<String>)\n" +
				"	println(list)\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_123() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	println(list).addAll('', '', '')\n" +
				"	list\n" +
				"}", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_124() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = println(new java.util.ArrayList)\n" +
				"	val secondList = println(new java.util.ArrayList)\n" +
				"	println(list).add('')\n" +
				"	println(list).addAll(println(secondList))\n" +
				"	secondList\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_125() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = println(new java.util.ArrayList)\n" +
				"	val secondList = println(new java.util.ArrayList)\n" +
				"	println(list).addAll(println(secondList))\n" +
				"	println(list).add('')\n" +
				"	println(secondList)\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_126() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val Iterable<String> sublist = println(println(list).subList(1, 1))\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_127() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val java.util.Set<String> sublist = println(println(list).subList(1, 1))\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_128() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val java.util.Iterator<String> sublist = println(println(println(list).subList(1, 1)).iterator)\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_129() throws Exception {
		resolvesTo(
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
			resolvesTo(
					"{\n" +
				"val list = new java.util.ArrayList\n" +
				"list.add(println(new Integer(0)))\n" +
				"list.add(println(new Integer(0).doubleValue))\n" +
				"list\n" +
				"	}",
					"ArrayList<Number & Comparable<?> & Constable & ConstantDesc>");
		} else {
			resolvesTo(
					"{\n" +
				"val list = new java.util.ArrayList\n" +
				"list.add(println(new Integer(0)))\n" +
				"list.add(println(new Integer(0).doubleValue))\n" +
				"list\n" +
				"	}",
					"ArrayList<Number & Comparable<?>>");
		}
	}

	@Test
	public void testDeferredTypeArgumentResolution_131() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.add(println(new Integer(0)))\n" +
				"	println(list.get(0)).toString\n" +
				"	list.add(println(new Integer(0).doubleValue))\n" +
				"	list\n" +
				"}",
				"ArrayList<Integer>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_132() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val second = new java.util.ArrayList\n" +
				"	println(list).add(println(second.get(0)))\n" +
				"	println(list).add('')\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_133() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	val fun = [String s| s]\n" +
				"	list.map(fun)\n" +
				"	list\n" +
				"}", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_134() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.map[String s| s]\n" +
				"	list\n" +
				"}", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_135() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	list.add(newArrayList)\n" +
				"	val Iterable<String> s = list.head\n" +
				"	list.head\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_136() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.add(new java.util.ArrayList)\n" +
				"	val Iterable<String> s = list.head\n" +
				"	list.head\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_137() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	$$CollectionExtensions::<String>addAll(println(list), null, null)\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_138() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	$$CollectionExtensions::<String>addAll(list, null, null)\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_139() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	$$CollectionExtensions::<String>addAll(println(list), '', '')\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_140() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	$$CollectionExtensions::addAll(println(list), println(''), println(''))\n" +
				"	println(list)\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_141() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	$$CollectionExtensions::addAll(list, println(''), println(''))\n" +
				"	println(list).head\n" +
				"}",
				"String");
	}

	@Test
	public void testDeferredTypeArgumentResolution_142() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	$$CollectionExtensions::addAll(println(list), println(''), println(''))\n" +
				"	println(println(println(list)).head)\n" +
				"}",
				"String");
	}

	@Test
	public void testDeferredTypeArgumentResolution_143() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.add(new java.util.ArrayList)\n" +
				"	val Iterable<String> s = $$IterableExtensions::head(list)\n" +
				"	list.head\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_144() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.add(new java.util.ArrayList)\n" +
				"	val Iterable<String> s = list.head.head\n" +
				"	list.head\n" +
				"}",
				"ArrayList<Iterable<String>>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_145() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.add(new java.util.ArrayList)\n" +
				"	val Iterable<String> s = list.head.flatten.head\n" +
				"	list.head\n" +
				"}",
				"ArrayList<Iterable<? extends Iterable<String>>>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_146() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.add(new java.util.ArrayList)\n" +
				"	val String s = list.head.head\n" +
				"	list.head\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_147() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.add(new java.util.ArrayList)\n" +
				"	val String s = list.head.flatten.head\n" +
				"	list.head\n" +
				"}",
				"ArrayList<Iterable<? extends String>>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_148() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.add(new java.util.ArrayList)\n" +
				"	val Iterable<String> s = $$IterableExtensions::flatten(list)\n" +
				"	list.head\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_149() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.add(newHashSet)\n" +
				"	val String s = $$IterableExtensions::flatten(list).head\n" +
				"	list.head\n" +
				"}",
				"HashSet<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_150() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.add(new java.util.ArrayList)\n" +
				"	val String s = $$IterableExtensions::flatten(list).head\n" +
				"	list.head\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_151() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	val second = new java.util.ArrayList\n" +
				"	second.add(new java.util.ArrayList)\n" +
				"	val String s = $$IterableExtensions::flatten(second).head\n" +
				"	list.add(second.head)\n" +
				"	list.head\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_152() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	list.map[String s| s]\n" +
				"	list\n" +
				"}", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_153() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	$$IterableExtensions::map(list, [String s| s])\n" +
				"	list\n" +
				"}", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_154() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	val fun = [String s| s]\n" +
				"	$$IterableExtensions::map(list, fun)\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_155() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.map(println([String s| println(s)]))\n" +
				"	list\n" +
				"}", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_156() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	list.addAll(null as java.util.ArrayList<String>)\n" +
				"	list.head\n" +
				"}", "String");
	}

	@Test
	public void testDeferredTypeArgumentResolution_157() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	list.addAll(newArrayList(''))\n" +
				"	list\n" +
				"}", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_158() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	list.addAll(null as String[])\n" +
				"	list\n" +
				"}", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_159() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	val secondList = newArrayList\n" +
				"	list.addAll(null as String[])\n" +
				"	list.addAll(secondList)\n" +
				"	secondList\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_160() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	val secondList = newArrayList\n" +
				"	list.addAll(secondList)\n" +
				"	list.addAll(null as String[])\n" +
				"	secondList\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_161() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	for(s: list) {\n" +
				"val String x = s\n" +
				"x.toString\n" +
				"	}\n" +
				"	list\n" +
				"}", "ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_162() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	for(s: newArrayList) {\n" +
				"list.add(s)\n" +
				"val String x = s\n" +
				"x.toString\n" +
				"	}\n" +
				"	list\n" +
				"}",
				"ArrayList<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_163() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	val literal = #{}\n" +
				"	list.addAll(literal)\n" +
				"	for(s: newArrayList) {\n" +
				"list.add(s)\n" +
				"val String x = s\n" +
				"x.toString\n" +
				"	}\n" +
				"	literal\n" +
				"}",
				"Set<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_164() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	val literal = #{}\n" +
				"	list += literal\n" +
				"	for(s: newArrayList) {\n" +
				"list.add(s)\n" +
				"val String x = s\n" +
				"x.toString\n" +
				"	}\n" +
				"	literal\n" +
				"}",
				"Set<String>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_165() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	val literal = #{}\n" +
				"	list.add(literal.flatten.head)\n" +
				"	for(s: newArrayList) {\n" +
				"list.add(s)\n" +
				"val String x = s\n" +
				"x.toString\n" +
				"	}\n" +
				"	literal\n" +
				"}",
				"Set<Iterable<? extends String>>");
	}

	@Ignore("+= resolves the type parameter since Integer is a resolved type")
	@Test
	public void testDeferredTypeArgumentResolution_166() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	list += 1\n" +
				"	list += 1.0\n" +
				"	list\n" +
				"}", "ArrayList<Number & Comparable<?>>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_167() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.add(new java.util.ArrayList)\n" +
				"	val java.util.Iterator<String> s = list.head.flatten.head\n" +
				"	list.head\n" +
				"}",
				"ArrayList<Iterable<? extends Iterator<String>>>");
	}

	@Test
	public void testDeferredTypeArgumentResolution_168() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	list.addAll(1, null as String[])\n" +
				"	list\n" +
				"}", "ArrayList<String>");
	}

	@Test
	public void testRecursiveTypeArgumentResolution_01() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	list.addAll(list)\n" +
				"	list\n" +
				"}", "ArrayList<Object>");
	}

	@Test
	public void testRecursiveTypeArgumentResolution_02() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	list.add(list.head)\n" +
				"	list\n" +
				"}", "ArrayList<Object>");
	}

	@Test
	public void testRecursiveTypeArgumentResolution_03() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	list.addAll(list)\n" +
				"	list.add('')\n" +
				"	list\n" +
				"}", "ArrayList<String>");
	}

	@Test
	public void testRecursiveTypeArgumentResolution_04() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = newArrayList\n" +
				"	list.add(list.head)\n" +
				"	list.add('')\n" +
				"	list\n" +
				"}", "ArrayList<String>");
	}

	@Test
	public void testRecursiveTypeArgumentResolution_05() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.addAll(list)\n" +
				"	list\n" +
				"}", "ArrayList<Object>");
	}

	@Test
	public void testRecursiveTypeArgumentResolution_06() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.add(list.head)\n" +
				"	list\n" +
				"}", "ArrayList<Object>");
	}

	@Test
	public void testRecursiveTypeArgumentResolution_07() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.addAll(list)\n" +
				"	list.add('')\n" +
				"	list\n" +
				"}", "ArrayList<String>");
	}

	@Test
	public void testRecursiveTypeArgumentResolution_08() throws Exception {
		resolvesTo(
				"{\n" +
				"	val list = new java.util.ArrayList\n" +
				"	list.add(list.head)\n" +
				"	list.add('')\n" +
				"	list\n" +
				"}", "ArrayList<String>");
	}

	@Test
	public void testFeatureCallWithOperatorOverloading_2() throws Exception {
		resolvesTo("new java.util.ArrayList<Byte>() += 'x'.getBytes().iterator.next", "boolean");
	}

	@Test
	public void testFeatureCallWithOperatorOverloading_3() throws Exception {
		resolvesTo("new java.util.ArrayList<Byte>() += null", "boolean");
	}

	@Test
	public void testFeatureCallWithOperatorOverloading_4() throws Exception {
		resolvesTo("new java.util.ArrayList<Byte>() += newArrayList('x'.getBytes().iterator.next)", "boolean");
	}

	@Test
	public void testFeatureCallWithOperatorOverloading_5() throws Exception {
		resolvesTo("new java.util.ArrayList<Byte>() += 'x'.getBytes()", "boolean");
	}

	@Test
	public void testFeatureCallOnIt() throws Exception {
		resolvesTo("{ val it = 'foo'; length == 3;}", "boolean");
	}

	@Test
	public void testStaticMethods_01() throws Exception {
		resolvesTo("newArrayList('')", "ArrayList<String>");
	}

	@Test
	public void testStaticMethods_02() throws Exception {
		resolvesTo("newArrayList('', '')", "ArrayList<String>");
	}

	@Test
	public void testStaticMethods_03() throws Exception {
		resolvesTo("newArrayList(newHashSet(''))", "ArrayList<HashSet<String>>");
	}

	@Test
	public void testStaticMethods_04() throws Exception {
		resolvesTo("newArrayList()", "ArrayList<Object>");
	}

	@Test
	public void testStaticMethods_05() throws Exception {
		resolvesTo("newHashMap()", "HashMap<Object, Object>");
	}

	@Test
	public void testStaticMethods_06() throws Exception {
		resolvesTo("String::CASE_INSENSITIVE_ORDER", "Comparator<String>");
	}
}
