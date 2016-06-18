/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import java.util.HashSet;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.linking.impl.XtextLinkingDiagnostic;
import org.eclipse.xtext.resource.XtextSyntaxDiagnostic;
import org.eclipse.xtext.testing.smoketest.IgnoredBySmokeTest;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public abstract class AbstractTypeResolverTest<Reference extends Object> extends AbstractXbaseTestCase {
  public abstract Reference resolvesTo(final String expression, final String type);
  
  public abstract void isFunctionAndEquivalentTo(final Reference reference, final String type);
  
  private static Set<String> seenExpressions;
  
  @BeforeClass
  public static void createSeenExpressionsSet() {
    HashSet<String> _newHashSet = CollectionLiterals.<String>newHashSet();
    AbstractTypeResolverTest.seenExpressions = _newHashSet;
  }
  
  @AfterClass
  public static void discardSeenExpressions() {
    AbstractTypeResolverTest.seenExpressions = null;
  }
  
  @Override
  protected XExpression expression(final CharSequence expression, final boolean resolve) throws Exception {
    XExpression _xblockexpression = null;
    {
      String _string = expression.toString();
      final String string = _string.replace("$$", "org::eclipse::xtext::xbase::lib::");
      boolean _add = AbstractTypeResolverTest.seenExpressions.add(string);
      boolean _not = (!_add);
      if (_not) {
        this.handleDuplicateExpression(expression);
        return null;
      }
      _xblockexpression = super.expression(string, resolve);
    }
    return _xblockexpression;
  }
  
  public Iterable<Resource.Diagnostic> getLinkingAndSyntaxErrors(final Resource resource) {
    EList<Resource.Diagnostic> _errors = resource.getErrors();
    final Function1<Resource.Diagnostic, Boolean> _function = (Resource.Diagnostic it) -> {
      return Boolean.valueOf(((it instanceof XtextSyntaxDiagnostic) || (it instanceof XtextLinkingDiagnostic)));
    };
    return IterableExtensions.<Resource.Diagnostic>filter(_errors, _function);
  }
  
  protected void handleDuplicateExpression(final CharSequence expression) {
    Assert.fail(("Duplicate expression under test: " + expression));
  }
  
  @Test
  public void testRawType_01() throws Exception {
    this.resolvesTo("{ val java.util.Set set = newHashSet() set }", "Set");
  }
  
  @Test
  public void testRawType_02() throws Exception {
    this.resolvesTo("{ val java.util.Set set = newHashSet set.head }", "Object");
  }
  
  @Test
  public void testRawType_03() throws Exception {
    this.resolvesTo("(null as java.util.Set<java.util.Set>).head", "Set");
  }
  
  @Test
  public void testRawType_04() throws Exception {
    this.resolvesTo("{ val java.util.Set<java.util.Set> set = newHashSet set }", "Set<Set>");
  }
  
  @Test
  public void testAssignment_01() throws Exception {
    this.resolvesTo("new testdata.FieldAccess().stringField = null", "String");
  }
  
  @Test
  public void testAssignment_02() throws Exception {
    this.resolvesTo("new testdata.FieldAccess().stringField = new Object", "String");
  }
  
  @Test
  public void testAssignment_03() throws Exception {
    this.resolvesTo("new testdata.FieldAccess().stringField = \'\'", "String");
  }
  
  @Test
  public void testAssignment_04() throws Exception {
    this.resolvesTo("{\n\t\t\tvar Comparable<Object> it = null\n\t\t\tswitch it {\n\t            CharSequence: { it.length it = null }\n        \t}\n\t\t}", "Comparable<Object>");
  }
  
  @Test
  public void testAssignment_05() throws Exception {
    this.resolvesTo("{\n\t\t\tval Comparable<Object> it = null\n\t\t\tswitch it {\n\t            CharSequence: it = null\n        \t}\n\t\t}", "Comparable<Object> & CharSequence");
  }
  
  @Test
  public void testAssignment_06() throws Exception {
    this.resolvesTo("{\n\t\t\tvar Comparable<Object> it = null\n\t\t\tswitch it {\n\t            CharSequence: { it = null it }\n        \t}\n\t\t}", "Comparable<Object>");
  }
  
  @Test
  public void testReassignedTypeDiscarded_01() throws Exception {
    this.resolvesTo("{\n\t\t\tvar Comparable<Object> it = null\n\t\t\tswitch it {\n\t            CharSequence: it\n        \t}\n\t\t\tit\n\t\t}", "Comparable<Object>");
  }
  
  @Test
  public void testNullLiteral() throws Exception {
    this.resolvesTo("null", "null");
  }
  
  @Test
  public void testTypeLiteral() throws Exception {
    this.resolvesTo("typeof(String)", "Class<String>");
  }
  
  @Test
  public void testTypeLiteral_1() throws Exception {
    this.resolvesTo("typeof(String[])", "Class<String[]>");
  }
  
  @Test
  public void testTypeLiteral_2() throws Exception {
    this.resolvesTo("typeof(void)", "Class<Void>");
  }
  
  @Test
  public void testTypeLiteral_3() throws Exception {
    this.resolvesTo("typeof(int)", "Class<Integer>");
  }
  
  @Test
  public void testTypeLiteral_4() throws Exception {
    this.resolvesTo("typeof(int[])", "Class<int[]>");
  }
  
  @Test
  public void testTypeLiteral_5() throws Exception {
    this.resolvesTo("typeof(int[]).superclass", "Class<? super int[]>");
  }
  
  @Test
  public void testTypeLiteral_6() throws Exception {
    this.resolvesTo("String", "Class<String>");
  }
  
  @Test
  public void testTypeLiteral_7() throws Exception {
    this.resolvesTo("void", "Class<Void>");
  }
  
  @Test
  public void testTypeLiteral_8() throws Exception {
    this.resolvesTo("int", "Class<Integer>");
  }
  
  @Test
  public void testTypeLiteral_9() throws Exception {
    this.resolvesTo("java.lang.String", "Class<String>");
  }
  
  @Test
  public void testBooleanLiteral() throws Exception {
    this.resolvesTo("true", "boolean");
    this.resolvesTo("false", "boolean");
  }
  
  @Test
  public void testBooleanLiteral_02() throws Exception {
    this.resolvesTo("return true", "void");
  }
  
  @Test
  public void testStringLiteral_01() throws Exception {
    this.resolvesTo("\'foo\'", "String");
    this.resolvesTo("\"foo\"", "String");
  }
  
  @Test
  public void testStringLiteral_02() throws Exception {
    this.resolvesTo("\'\'", "String");
  }
  
  @Test
  public void testStringLiteral_03() throws Exception {
    this.resolvesTo("\'1\'", "String");
  }
  
  @Test
  public void testStringLiteral_04() throws Exception {
    this.resolvesTo("newArrayList(\'1\')", "ArrayList<String>");
  }
  
  @Test
  public void testStringLiteral_05() throws Exception {
    this.resolvesTo("newArrayList(null as Character, \'1\')", "ArrayList<Serializable & Comparable<?>>");
  }
  
  @Test
  public void testStringLiteral_06() throws Exception {
    this.resolvesTo("newArrayList(null as Character, \'11\')", "ArrayList<Serializable & Comparable<?>>");
  }
  
  @Test
  public void testNumberLiteral_0() throws Exception {
    this.resolvesTo("3", "int");
  }
  
  @Test
  public void testNumberLiteral_1() throws Exception {
    this.resolvesTo("0x42", "int");
  }
  
  @Test
  public void testNumberLiteral_2() throws Exception {
    this.resolvesTo("1L", "long");
  }
  
  @Test
  public void testNumberLiteral_3() throws Exception {
    this.resolvesTo("0x42#l", "long");
  }
  
  @Test
  public void testNumberLiteral_4() throws Exception {
    this.resolvesTo("1f", "float");
  }
  
  @Test
  public void testNumberLiteral_5() throws Exception {
    this.resolvesTo("1.0f", "float");
  }
  
  @Test
  public void testNumberLiteral_6() throws Exception {
    this.resolvesTo("1.0E10f", "float");
  }
  
  @Test
  public void testNumberLiteral_7() throws Exception {
    this.resolvesTo("1.0e-10f", "float");
  }
  
  @Test
  public void testNumberLiteral_8() throws Exception {
    this.resolvesTo("1.0E+10f", "float");
  }
  
  @Test
  public void testNumberLiteral_9() throws Exception {
    this.resolvesTo("1.0", "double");
  }
  
  @Test
  public void testNumberLiteral_10() throws Exception {
    this.resolvesTo("1.0E10", "double");
  }
  
  @Test
  public void testNumberLiteral_11() throws Exception {
    this.resolvesTo("1.0e-10", "double");
  }
  
  @Test
  public void testNumberLiteral_12() throws Exception {
    this.resolvesTo("1.0E+10", "double");
  }
  
  @Test
  public void testNumberLiteral_13() throws Exception {
    this.resolvesTo("1.0d", "double");
  }
  
  @Test
  public void testNumberLiteral_14() throws Exception {
    this.resolvesTo("1.0E10d", "double");
  }
  
  @Test
  public void testNumberLiteral_15() throws Exception {
    this.resolvesTo("1.0e-10d", "double");
  }
  
  @Test
  public void testNumberLiteral_16() throws Exception {
    this.resolvesTo("1.0E+10d", "double");
  }
  
  @Test
  public void testNumberLiteral_17() throws Exception {
    this.resolvesTo("1234567890123456789012345678901234567890bi", "BigInteger");
  }
  
  @Test
  public void testNumberLiteral_17a() throws Exception {
    this.resolvesTo("0x1234567890123456789012345678901234567890#bi", "BigInteger");
  }
  
  @Test
  public void testNumberLiteral_18() throws Exception {
    this.resolvesTo("1.0bD", "BigDecimal");
  }
  
  @Test
  public void testNumberLiteral_19() throws Exception {
    this.resolvesTo("1.0E10Bd", "BigDecimal");
  }
  
  @Test
  public void testNumberLiteral_20() throws Exception {
    this.resolvesTo("1.0e-10bd", "BigDecimal");
  }
  
  @Test
  public void testNumberLiteral_21() throws Exception {
    this.resolvesTo("1.0E+10BD", "BigDecimal");
  }
  
  @Test
  public void testNumberLiteral_22() throws Exception {
    this.resolvesTo("1E+10BD", "BigDecimal");
  }
  
  @Test
  public void testNumberLiteral_23() throws Exception {
    this.resolvesTo("1E-10", "double");
  }
  
  @Test
  public void testNumberLiteral_24() throws Exception {
    this.resolvesTo("1E10f", "float");
  }
  
  @Test
  public void testNumberLiteral_25() throws Exception {
    this.resolvesTo("1bi.toString", "String");
  }
  
  @Test
  public void testNumberLiteralInClosure_01() throws Exception {
    this.resolvesTo("newArrayList().map[42]", "List<Integer>");
  }
  
  @Test
  public void testListLiteral_00() {
    this.resolvesTo("#[]", "List<Object>");
  }
  
  @Test
  public void testListLiteral_01() throws Exception {
    this.resolvesTo("#[\'foo\']", "List<String>");
  }
  
  @Test
  public void testListLiteral_02() throws Exception {
    this.resolvesTo("#[\'foo\', null, \'bar\']", "List<String>");
  }
  
  @Test
  public void testListLiteral_03() throws Exception {
    this.resolvesTo("#[null]", "List<Object>");
  }
  
  @Test
  public void testListLiteral_04() throws Exception {
    this.resolvesTo("#[1, 2, 3]", "List<Integer>");
  }
  
  @Test
  public void testListLiteral_05() throws Exception {
    this.resolvesTo("#[1, 2.0, 3]", "List<? extends Number & Comparable<?>>");
  }
  
  @Test
  public void testListLiteral_06() throws Exception {
    this.resolvesTo("{ val java.util.List<Number> foo = #[1, 2.0, 3bi] foo }", "List<Number>");
  }
  
  @Test
  public void testListLiteral_07() throws Exception {
    this.resolvesTo("{ val java.util.List<CharSequence> foo = #[\'foo\', \'bar\'] foo }", "List<CharSequence>");
  }
  
  @Test
  public void testListLiteral_08() throws Exception {
    this.resolvesTo("{ val String[] foo = #[\'foo\', \'bar\'] foo }", "String[]");
  }
  
  @Test
  public void testListLiteral_09() throws Exception {
    this.resolvesTo("{ val x = #[] val String[] y = x x }", "List<String>");
  }
  
  @Test
  public void testListLiteral_10() throws Exception {
    this.resolvesTo("{ val x = #[null] val String[] y = x x }", "List<String>");
  }
  
  @Test
  public void testListLiteral_11() throws Exception {
    this.resolvesTo("{ val x = #[] val Iterable<String> y = x x }", "List<String>");
  }
  
  @Test
  public void testListLiteral_12() throws Exception {
    this.resolvesTo("{ val x = #[null] val java.util.Set<String> y = x x }", "List<String>");
  }
  
  @Test
  public void testListLiteral_13() throws Exception {
    this.resolvesTo("#[#[\'foo\'], #{}]", "List<? extends Collection<String>>");
  }
  
  @Test
  public void testListLiteral_14() throws Exception {
    this.resolvesTo("newArrayList(#[\'foo\'], #{})", "ArrayList<Collection<String>>");
  }
  
  @Test
  public void testSetLiteral_00() {
    this.resolvesTo("#{}", "Set<Object>");
  }
  
  @Test
  public void testSetLiteral_01() throws Exception {
    this.resolvesTo("#{\'foo\'}", "Set<String>");
  }
  
  @Test
  public void testSetLiteral_02() throws Exception {
    this.resolvesTo("#{\'foo\', null, \'bar\'}", "Set<String>");
  }
  
  @Test
  public void testSetLiteral_03() throws Exception {
    this.resolvesTo("#{null}", "Set<Object>");
  }
  
  @Test
  public void testSetLiteral_04() throws Exception {
    this.resolvesTo("#{1, 2 ,3}", "Set<Integer>");
  }
  
  @Test
  public void testSetLiteral_05() throws Exception {
    this.resolvesTo("#{1, 2.0 ,3}", "Set<? extends Number & Comparable<?>>");
  }
  
  @Test
  public void testSetLiteral_06() throws Exception {
    this.resolvesTo("{ val java.util.Set<Number> foo = #{1, 2.0, 3bi} foo }", "Set<Number>");
  }
  
  @Test
  public void testSetLiteral_07() throws Exception {
    this.resolvesTo("{ val java.util.Set<CharSequence> foo = #{\'foo\', \'bar\'} foo }", "Set<CharSequence>");
  }
  
  @Test
  public void testSetLiteral_08() throws Exception {
    this.resolvesTo("#{\'foo\' -> \'bar\'}", "Map<String, String>");
  }
  
  @Test
  public void testSetLiteral_09() throws Exception {
    this.resolvesTo("#{\'foo\' -> true, \'bar\' -> false}", "Map<String, Boolean>");
  }
  
  @Test
  public void testSetLiteral_10() throws Exception {
    this.resolvesTo("#{\'foo\'-> new Exception(\'ohoh\'),\'bar\'->new Error(\'ohohoh\')}", "Map<String, Throwable>");
  }
  
  @Test
  public void testSetLiteral_11() throws Exception {
    this.resolvesTo("{ val java.util.Map<String,String> x = #{} x }", "Map<String, String>");
  }
  
  @Test
  public void testSetLiteral_12() throws Exception {
    this.resolvesTo("{ val java.util.Set<org.eclipse.xtext.xbase.lib.Pair<String,Object>> foo = #{\'foo\'->\'bar\'} foo }", "Set<Pair<String, Object>>");
  }
  
  @Test
  public void testOverloadedVarArgs_01() throws Exception {
    this.resolvesTo("testdata::OverloadedMethods::overloadedVarArgs(null, null)", "long");
  }
  
  @Test
  public void testOverloadedVarArgs_02() throws Exception {
    this.resolvesTo("testdata::OverloadedMethods::overloadedVarArgs()", "int");
  }
  
  @Test
  public void testOverloadedVarArgs_03() throws Exception {
    this.resolvesTo("testdata::OverloadedMethods::overloadedVarArgs(\'\', \'\')", "long");
  }
  
  @Test
  public void testOverloadedVarArgs_04() throws Exception {
    this.resolvesTo("testdata::OverloadedMethods::overloadedVarArgs(new Object, new Object, new Object)", "int");
  }
  
  @Test
  public void testOverloadedTypeParameters_01() throws Exception {
    this.resolvesTo("testdata::OverloadedMethods::<String>overloadedTypeParameters(null)", "int");
  }
  
  @Test
  public void testOverloadedTypeParameters_02() throws Exception {
    this.resolvesTo("testdata::OverloadedMethods::<String, String>overloadedTypeParameters(null)", "long");
  }
  
  @Test
  public void testOverloadedMethods_01() throws Exception {
    this.resolvesTo("{\n\t\t\tvar java.util.List<CharSequence> list = null\n\t\t\tvar Object o = null\n\t\t\torg::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloaded(list, o)\n\t\t}", "int");
  }
  
  @Test
  public void testOverloadedMethods_02() throws Exception {
    this.resolvesTo("{\n\t\t\tvar java.util.List<CharSequence> list = null\n\t\t\tvar String s = null\n\t\t\torg::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloaded(list, s)\n\t\t}", "long");
  }
  
  @Test
  public void testOverloadedMethods_03() throws Exception {
    this.resolvesTo("{\n\t\t\tvar java.util.List<? extends CharSequence> list = null\n\t\t\tvar Object o = null\n\t\t\torg::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloaded(list, o)\n\t\t}", "int");
  }
  
  @Test
  public void testOverloadedMethods_04() throws Exception {
    this.resolvesTo("{\n\t\t\tvar java.util.List<? extends CharSequence> list = null\n\t\t\tvar String s = null\n\t\t\torg::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloaded(list, s)\n\t\t}", "int");
  }
  
  @Test
  public void testOverloadedMethods_05() throws Exception {
    this.resolvesTo("{\n\t\t\tvar java.util.List<CharSequence> list = null\n\t\t\torg::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloaded(list, null)\n\t\t}", "long");
  }
  
  @Test
  public void testOverloadedMethods_06() throws Exception {
    this.resolvesTo("{\n\t\t\tvar java.util.List<? extends CharSequence> list = null\n\t\t\torg::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloaded(list, null)\n\t\t}", "int");
  }
  
  @Test
  public void testOverloadedMethods_07() throws Exception {
    this.resolvesTo("{\n\t\t\tvar java.util.List<CharSequence> list = null\n\t\t\tvar Object o = null\n\t\t\torg::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloadedWithTypeParam(list, o)\n\t\t}", "int");
  }
  
  @Test
  public void testOverloadedMethods_08() throws Exception {
    this.resolvesTo("{\n\t\t\tvar java.util.List<CharSequence> list = null\n\t\t\tvar String s = null\n\t\t\torg::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloadedWithTypeParam(list, s)\n\t\t}", "long");
  }
  
  @Test
  public void testOverloadedMethods_09() throws Exception {
    this.resolvesTo("{\n\t\t\tvar java.util.List<? extends CharSequence> list = null\n\t\t\tvar Object o = null\n\t\t\torg::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloadedWithTypeParam(list, o)\n\t\t}", "int");
  }
  
  @Test
  public void testOverloadedMethods_10() throws Exception {
    this.resolvesTo("{\n\t\t\tvar java.util.List<? extends CharSequence> list = null\n\t\t\tvar String s = null\n\t\t\torg::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloadedWithTypeParam(list, s)\n\t\t}", "long");
  }
  
  @Test
  public void testOverloadedMethods_11() throws Exception {
    this.resolvesTo("{\n\t\t\tvar java.util.List<CharSequence> list = null\n\t\t\torg::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloadedWithTypeParam(list, null)\n\t\t}", "long");
  }
  
  @Test
  public void testOverloadedMethods_12() throws Exception {
    this.resolvesTo("{\n\t\t\tvar java.util.List<? extends CharSequence> list = null\n\t\t\torg::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloadedWithTypeParam(list, null)\n\t\t}", "long");
  }
  
  @Test
  public void testBoxing_01() throws Exception {
    this.resolvesTo("1.toString", "String");
  }
  
  @Test
  public void testOverloadedOperators_01() throws Exception {
    this.resolvesTo("1 + 1", "int");
  }
  
  @Test
  public void testOverloadedOperators_02() throws Exception {
    this.resolvesTo("1L + 1", "long");
  }
  
  @Test
  public void testOverloadedOperators_03() throws Exception {
    this.resolvesTo("1 + 1L", "long");
  }
  
  @Test
  public void testOverloadedOperators_04() throws Exception {
    this.resolvesTo("\'\' + \'\'", "String");
  }
  
  @Test
  public void testOverloadedOperators_05() throws Exception {
    this.resolvesTo("\'\' + 1", "String");
  }
  
  @Test
  public void testOverloadedOperators_06() throws Exception {
    this.resolvesTo("1 + \'\'", "String");
  }
  
  @Test
  public void testOverloadedOperators_07() throws Exception {
    this.resolvesTo("(0..Math::sqrt(1l).intValue).filter[ i | 1l % i == 0 ].isEmpty", "boolean");
  }
  
  @Test
  public void testOverloadedOperators_08() throws Exception {
    this.resolvesTo("(1..2).map[ toString ].reduce[ i1, i2| i1 + i2 ]", "String");
  }
  
  @Test
  public void testOverloadedOperators_09() throws Exception {
    this.resolvesTo("(1..2).map[ toString.length ].reduce[ i1, i2| i1 + i2 ]", "Integer");
  }
  
  @Test
  public void testOverloadedOperators_10() throws Exception {
    this.resolvesTo("(1..2).map[ new java.math.BigInteger(toString) ].reduce[ i1, i2| i1 + i2 ]", "BigInteger");
  }
  
  @Ignore("i1 and i2 should become T -> Object thus + maps to String + Object")
  @Test
  public void testOverloadedOperators_11() throws Exception {
    this.resolvesTo("(1..2).map[ new java.math.BigInteger(toString) ].reduce[ i1, i2 | i1.toString + i2 ]", "String");
  }
  
  @Test
  public void testOverloadedOperators_12() throws Exception {
    this.resolvesTo("{\n\t\t\tval i = 1bi\n\t\t\tval s = \'\'\n\t\t\ts + i\n\t\t}", "String");
  }
  
  @Ignore("i1 and i2 should become T -> Object thus + maps to Object + String")
  @Test
  public void testOverloadedOperators_13() throws Exception {
    this.resolvesTo("(1..2).map[ new java.math.BigInteger(toString) ].reduce[ i1, i2| i1 + String::valueOf(i2) ]", "String");
  }
  
  @Test
  public void testOverloadedOperators_14() throws Exception {
    this.resolvesTo("{\n\t\t\tval i = 1bi\n\t\t\tval s = \'\'\n\t\t\ti + s\n\t\t}", "String");
  }
  
  @Test
  public void testOverloadedOperators_15() throws Exception {
    this.resolvesTo("(1..2).map[ new java.math.BigInteger(toString) ].map[ i | i.toString + i ]", "Iterable<String>");
  }
  
  @Test
  public void testOverloadedOperators_16() throws Exception {
    this.resolvesTo("(1..2).map[ new java.math.BigInteger(toString) ].map[ i | i + String::valueOf(i) ]", "Iterable<String>");
  }
  
  @Test
  public void testOverloadedOperators_17() throws Exception {
    this.resolvesTo("(0..Math::sqrt(1l).intValue).filter[ i | 1l % i == 0 ].empty", "boolean");
  }
  
  @Test
  public void testOverloadedOperators_18() throws Exception {
    this.resolvesTo("\'a\' + 1", "String");
  }
  
  @Test
  public void testOverloadedOperators_19() throws Exception {
    this.resolvesTo("\'aa\' + 1", "String");
  }
  
  @Test
  public void testOverloadedOperators_20() throws Exception {
    this.resolvesTo("(null as Iterable<StringBuilder>) + (null as Iterable<StringBuffer>) + (null as Iterable<String>)", "Iterable<Serializable & CharSequence>");
  }
  
  @Test
  public void testCastExpression() throws Exception {
    this.resolvesTo("null as String", "String");
    this.resolvesTo("null as Boolean", "Boolean");
  }
  
  @Test
  public void testCastExpression_02() throws Exception {
    this.resolvesTo("(null as Iterable<String[]>)", "Iterable<String[]>");
  }
  
  @Test
  public void testThrowExpression() throws Exception {
    this.resolvesTo("throw new Exception()", "void");
  }
  
  @Test
  public void testTryCatchFinallyExpression_00() throws Exception {
    this.resolvesTo("try \'foo\' catch (Exception e) \'bar\'", "String");
  }
  
  @Test
  public void testTryCatchFinallyExpression_01() throws Exception {
    this.resolvesTo("try \'foo\' catch (Exception e) \'bar\' catch(RuntimeException e) \'baz\'", "String");
  }
  
  @Test
  public void testTryCatchFinallyExpression_02() throws Exception {
    this.resolvesTo("try \'foo\' catch (Exception e) \'bar\' catch(RuntimeException e) \'baz\' finally true", "String");
  }
  
  @Test
  public void testTryCatchFinallyExpression_03() throws Exception {
    this.resolvesTo("try { \'literal\' as Object as Boolean } catch(ClassCastException e) \'caught\'", "Serializable & Comparable<?>");
  }
  
  @Test
  public void testTryCatchFinallyExpression_04() throws Exception {
    this.resolvesTo("try { \'literal\' as Object as Boolean } catch(ClassCastException e) {\'caught\'}", "Serializable & Comparable<?>");
  }
  
  @Test
  public void testTryCatchFinallyExpression_05() throws Exception {
    this.resolvesTo("try \'literal\' as Object as Boolean\n\t\t  catch(NullPointerException e) \'second thing is thrown\'\t\t  \n\t\t  catch(ClassCastException e) throw new NullPointerException()\n\t\t", "Serializable & Comparable<?>");
  }
  
  @Test
  public void testTryCatchFinallyExpression_06() throws Exception {
    this.resolvesTo("try \'literal\' as Object as Boolean\n\t\t  catch(ClassCastException e) throw new NullPointerException()\n\t\t  catch(NullPointerException e) \'dont catch subsequent exceptions\'", "Serializable & Comparable<?>");
  }
  
  @Test
  public void testTryCatchFinallyExpression_07() throws Exception {
    this.resolvesTo("try \'literal\' as Object as Boolean\n\t\t  catch(ClassCastException e) null as Number\n\t\t  catch(NullPointerException e) \'dont catch subsequent exceptions\'", "Serializable");
  }
  
  @Test
  public void testTryCatchFinallyExpression_08() throws Exception {
    this.resolvesTo("try return \'foo\' catch (Exception e) return \'bar\'", "void");
  }
  
  @Test
  public void testTryCatchFinallyExpression_09() throws Exception {
    this.resolvesTo("try return \'foo\' catch (Exception e) return \'bar\' catch(RuntimeException e) return \'baz\'", "void");
  }
  
  @Test
  public void testTryCatchFinallyExpression_10() throws Exception {
    this.resolvesTo("try return \'foo\' catch (Exception e) return \'bar\' catch(RuntimeException e) return \'baz\' finally true", "void");
  }
  
  @Test
  public void testTryCatchFinallyExpression_11() throws Exception {
    this.resolvesTo("try { return \'literal\' as Object as Boolean } catch(ClassCastException e) return \'caught\'", "void");
  }
  
  @Test
  public void testTryCatchFinallyExpression_12() throws Exception {
    this.resolvesTo("try { return \'literal\' as Object as Boolean } catch(ClassCastException e) {return \'caught\'}", "void");
  }
  
  @Test
  public void testTryCatchFinallyExpression_13() throws Exception {
    this.resolvesTo("try return \'literal\' as Object as Boolean\n\t\t  catch(NullPointerException e) return \'second thing is thrown\'\t\t  \n\t\t  catch(ClassCastException e) throw new NullPointerException()\n\t\t", "void");
  }
  
  @Test
  public void testTryCatchFinallyExpression_14() throws Exception {
    this.resolvesTo("try return \'literal\' as Object as Boolean\n\t\t  catch(ClassCastException e) throw new NullPointerException()\n\t\t  catch(NullPointerException e) return \'dont catch subsequent exceptions\'", "void");
  }
  
  @Test
  public void testTryCatchFinallyExpression_15() throws Exception {
    this.resolvesTo("try return \'literal\' as Object as Boolean\n\t\t  catch(ClassCastException e) return null as Number\n\t\t  catch(NullPointerException e) return \'dont catch subsequent exceptions\'", "void");
  }
  
  @Test
  public void testTryCatchFinallyExpression_16() throws Exception {
    this.resolvesTo("try return \'foo\' catch (Exception e) \'bar\'", "String");
  }
  
  @Test
  public void testTryCatchFinallyExpression_17() throws Exception {
    this.resolvesTo("try return \'foo\' catch (Exception e) \'bar\' catch(RuntimeException e) \'baz\'", "String");
  }
  
  @Test
  public void testTryCatchFinallyExpression_18() throws Exception {
    this.resolvesTo("try return \'foo\' catch (Exception e) \'bar\' catch(RuntimeException e) \'baz\' finally true", "String");
  }
  
  @Test
  public void testTryCatchFinallyExpression_19() throws Exception {
    this.resolvesTo("try { return \'literal\' as Object as Boolean } catch(ClassCastException e) \'caught\'", "String");
  }
  
  @Test
  public void testTryCatchFinallyExpression_20() throws Exception {
    this.resolvesTo("try { return \'literal\' as Object as Boolean } catch(ClassCastException e) {\'caught\'}", "String");
  }
  
  @Test
  public void testTryCatchFinallyExpression_21() throws Exception {
    this.resolvesTo("try return \'literal\' as Object as Boolean\n\t\t  catch(NullPointerException e) \'second thing is thrown\'\t\t  \n\t\t  catch(ClassCastException e) throw new NullPointerException()\n\t\t", "String");
  }
  
  @Test
  public void testTryCatchFinallyExpression_22() throws Exception {
    this.resolvesTo("try return \'literal\' as Object as Boolean\n\t\t  catch(ClassCastException e) throw new NullPointerException()\n\t\t  catch(NullPointerException e) \'dont catch subsequent exceptions\'", "String");
  }
  
  @Test
  public void testTryCatchFinallyExpression_23() throws Exception {
    this.resolvesTo("try return \'literal\' as Object as Boolean\n\t\t  catch(ClassCastException e) null as Number\n\t\t  catch(NullPointerException e) \'dont catch subsequent exceptions\'", "Serializable");
  }
  
  @Test
  public void testTryCatchFinallyExpression_24() throws Exception {
    this.resolvesTo("try \'foo\' catch (Exception e) return \'bar\'", "String");
  }
  
  @Test
  public void testTryCatchFinallyExpression_25() throws Exception {
    this.resolvesTo("try 1 catch (Exception e) return \'bar\' catch(RuntimeException e) return \'baz\'", "int");
  }
  
  @Test
  public void testTryCatchFinallyExpression_26() throws Exception {
    this.resolvesTo("try \'foo\' catch (Exception e) \'bar\' catch(RuntimeException e) return 1 finally true", "String");
  }
  
  @Test
  public void testTryCatchFinallyExpression_27() throws Exception {
    this.resolvesTo("try { \'literal\' as Object as Boolean } catch(ClassCastException e) return \'caught\'", "Boolean");
  }
  
  @Test
  public void testTryCatchFinallyExpression_28() throws Exception {
    this.resolvesTo("try { \'literal\' as Object as Boolean } catch(ClassCastException e) {return \'caught\'}", "Boolean");
  }
  
  @Test
  public void testTryCatchFinallyExpression_29() throws Exception {
    this.resolvesTo("try \'literal\' as Object as Boolean\n\t\t  catch(NullPointerException e) return \'second thing is thrown\'\t\t  \n\t\t  catch(ClassCastException e) throw new NullPointerException()\n\t\t", "Boolean");
  }
  
  @Test
  public void testTryCatchFinallyExpression_30() throws Exception {
    this.resolvesTo("try \'literal\' as Object as Boolean\n\t\t  catch(ClassCastException e) throw new NullPointerException()\n\t\t  catch(NullPointerException e) return \'dont catch subsequent exceptions\'", "Boolean");
  }
  
  @Test
  public void testTryCatchFinallyExpression_31() throws Exception {
    this.resolvesTo("try \'literal\' as Object as Boolean\n\t\t  catch(ClassCastException e) return null as Number\n\t\t  catch(NullPointerException e) return \'dont catch subsequent exceptions\'", "Boolean");
  }
  
  @Test
  public void testForExpression_01() throws Exception {
    this.resolvesTo("for(String x : new java.util.ArrayList<String>()) x.length", "void");
    this.resolvesTo("for(String x : newArrayList(\'foo\')) x.length", "void");
    this.resolvesTo("for(String x : <String>newArrayList()) x.length", "void");
  }
  
  @Test
  public void testForExpression_02() throws Exception {
    this.resolvesTo("for(x : new java.util.ArrayList<String>()) x.length", "void");
    this.resolvesTo("for(x : <String>newArrayList()) x.length", "void");
    this.resolvesTo("for(x : newArrayList(\'foo\')) x.length", "void");
  }
  
  @Test
  public void testForExpression_03() throws Exception {
    this.resolvesTo("for(String x : null as String[]) x.length", "void");
  }
  
  @Test
  public void testForExpression_04() throws Exception {
    this.resolvesTo("for(x : null as String[]) x.length", "void");
  }
  
  @Test
  public void testForExpression_05() throws Exception {
    this.resolvesTo("for(String x : new java.util.ArrayList<String>()) return x.length", "void");
    this.resolvesTo("for(String x : newArrayList(\'foo\')) return x.length", "void");
    this.resolvesTo("for(String x : <String>newArrayList()) return x.length", "void");
  }
  
  @Test
  public void testForExpression_06() throws Exception {
    this.resolvesTo("for(x : new java.util.ArrayList<String>()) return x.length", "void");
    this.resolvesTo("for(x : <String>newArrayList()) return x.length", "void");
    this.resolvesTo("for(x : newArrayList(\'foo\')) return x.length", "void");
  }
  
  @Test
  public void testForExpression_07() throws Exception {
    this.resolvesTo("for(String x : null as String[]) return x.length", "void");
  }
  
  @Test
  public void testForExpression_08() throws Exception {
    this.resolvesTo("for(x : null as String[]) return x.length", "void");
  }
  
  @Test
  public void testForExpression_09() throws Exception {
    this.resolvesTo("for(x : null as String[]) return", "void");
  }
  
  @Test
  public void testWhileExpression_01() throws Exception {
    this.resolvesTo("while(true) \'\'.length", "void");
  }
  
  @Test
  public void testWhileExpression_02() throws Exception {
    this.resolvesTo("while(true) return \'\'.length", "void");
  }
  
  @Test
  public void testImplicitImportPrintln_01() throws Exception {
    this.resolvesTo("println(null)", "Object");
  }
  
  @Test
  public void testImplicitImportPrintln_02() throws Exception {
    this.resolvesTo("<String>println(null)", "String");
  }
  
  @Test
  public void testImplicitImportEmptyList() throws Exception {
    this.resolvesTo("<String>emptyList", "List<String>");
    this.resolvesTo("emptyList", "List<Object>");
  }
  
  @Test
  public void testElvisWithEmptyListInLamdba() throws Exception {
    this.resolvesTo("[ String s |\n\t\t\tval result = <Integer>newArrayList\n\t\t\tval (String)=>Iterable<Integer> fun = []\n\t\t\tresult += fun.apply(s) ?: emptyList\n\t\t\tresult\n\t\t]", "(String)=>ArrayList<Integer>");
  }
  
  @Test
  public void testMethodTypeParamInference_00() throws Exception {
    this.resolvesTo("new java.util.ArrayList<String>().findFirst(e | true)", "String");
  }
  
  @Test
  public void testMethodTypeParamInference_01() throws Exception {
    this.resolvesTo("new java.util.ArrayList<String>().findFirst(e|e == \'foo\')", "String");
  }
  
  @Test
  public void testMethodTypeParamInference_02() throws Exception {
    this.resolvesTo("new java.util.ArrayList<String>().<String>findFirst(e|e == \'foo\')", "String");
  }
  
  @Test
  public void testMethodTypeParamInference_03() throws Exception {
    this.resolvesTo("$$IterableExtensions::findFirst(new java.util.ArrayList<String>) [e | true]", "String");
  }
  
  @Test
  public void testMethodTypeParamInference_04() throws Exception {
    this.resolvesTo("$$IterableExtensions::findFirst(new java.util.ArrayList<String>) [e|e == \'foo\']", "String");
  }
  
  @Test
  public void testMethodTypeParamInference_05() throws Exception {
    this.resolvesTo("$$IterableExtensions::<String>findFirst(new java.util.ArrayList<String>) [e|e == \'foo\']", "String");
  }
  
  @Test
  public void testInstanceof() throws Exception {
    this.resolvesTo("null instanceof String", "boolean");
  }
  
  @Test
  public void testTypeForVoidClosure_01() throws Exception {
    this.resolvesTo("newArrayList(\'foo\',\'bar\').forEach []", "void");
  }
  
  @Test
  public void testTypeForVoidClosure_02() throws Exception {
    Reference _resolvesTo = this.resolvesTo("[ return ]", "(Object)=>void");
    this.isFunctionAndEquivalentTo(_resolvesTo, "Procedure1<Object>");
  }
  
  @Test
  public void testTypeForVoidClosure_03() throws Exception {
    Reference _resolvesTo = this.resolvesTo("[| return ]", "()=>void");
    this.isFunctionAndEquivalentTo(_resolvesTo, "Procedure0");
  }
  
  @Test
  public void testTypeForVoidClosure_04() throws Exception {
    Reference _resolvesTo = this.resolvesTo("[a, b| return ]", "(Object, Object)=>void");
    this.isFunctionAndEquivalentTo(_resolvesTo, "Procedure2<Object, Object>");
  }
  
  @Test
  public void testTypeForVoidClosure_05() throws Exception {
    Reference _resolvesTo = this.resolvesTo("[ System::out.println ]", "(Object)=>void");
    this.isFunctionAndEquivalentTo(_resolvesTo, "Procedure1<Object>");
  }
  
  @Test
  public void testTypeForVoidClosure_06() throws Exception {
    Reference _resolvesTo = this.resolvesTo("[| System::out.println ]", "()=>void");
    this.isFunctionAndEquivalentTo(_resolvesTo, "Procedure0");
  }
  
  @Test
  public void testTypeForVoidClosure_07() throws Exception {
    Reference _resolvesTo = this.resolvesTo("[a, b| System::out.println ]", "(Object, Object)=>void");
    this.isFunctionAndEquivalentTo(_resolvesTo, "Procedure2<Object, Object>");
  }
  
  @Test
  public void testTypeForEmptyClosure_01() throws Exception {
    Reference _resolvesTo = this.resolvesTo("[]", "(Object)=>Object");
    this.isFunctionAndEquivalentTo(_resolvesTo, "Function1<Object, Object>");
  }
  
  @Test
  public void testTypeForEmptyClosure_02() throws Exception {
    Reference _resolvesTo = this.resolvesTo("[|]", "()=>Object");
    this.isFunctionAndEquivalentTo(_resolvesTo, "Function0<Object>");
  }
  
  @Test
  public void testTypeForEmptyClosure_03() throws Exception {
    Reference _resolvesTo = this.resolvesTo("[a, b|]", "(Object, Object)=>Object");
    this.isFunctionAndEquivalentTo(_resolvesTo, "Function2<Object, Object, Object>");
  }
  
  @Test
  public void testFeatureCallWithArrayToIterableConversion_01() throws Exception {
    this.resolvesTo("\'foo\'.toCharArray.iterator", "Iterator<Character>");
  }
  
  @Test
  public void testFeatureCallWithArrayToIterableConversion_02() throws Exception {
    this.resolvesTo("(null as String[]).head", "String");
  }
  
  @Test
  public void testFeatureCallWithArrayToIterableConversion_03() throws Exception {
    this.resolvesTo("(null as String[]).map[ it ]", "List<String>");
  }
  
  @Test
  public void testFeatureCallWithArrayToIterableConversion_04() throws Exception {
    this.resolvesTo("(null as String[][]).head", "String[]");
  }
  
  @Test
  public void testFeatureCallWithArrayToIterableConversion_05() throws Exception {
    this.resolvesTo("{ var x = <String[]>newArrayList(\'a,b\'.split(\',\')) x }", "ArrayList<String[]>");
  }
  
  @Test
  public void testFeatureCallWithArrayToIterableConversion_06() throws Exception {
    this.resolvesTo("{ var x = <String[]>newArrayList(\'a,b\'.split(\',\')) x.head }", "String[]");
  }
  
  @Test
  public void testFeatureCallWithArrayToIterableConversion_07() throws Exception {
    this.resolvesTo("{ var x = <String[]>newArrayList(\'a,b\'.split(\',\')) x.head.head }", "String");
  }
  
  @Test
  public void testFeatureCallWithArrayToIterableConversion_08() throws Exception {
    this.resolvesTo("{ var x = <Iterable<String>>newArrayList(\'a,b\'.split(\',\')) x }", "ArrayList<Iterable<String>>");
  }
  
  @Test
  public void testFeatureCallWithArrayToIterableConversion_09() throws Exception {
    this.resolvesTo("{ var x = <Iterable<String>>newArrayList(\'a,b\'.split(\',\')) x.head }", "Iterable<String>");
  }
  
  @Test
  public void testFeatureCallWithArrayToIterableConversion_10() throws Exception {
    this.resolvesTo("{ var x = <Iterable<String>>newArrayList(\'a,b\'.split(\',\')) x.head.head }", "String");
  }
  
  @Test
  public void testReturnExpression_00() throws Exception {
    this.resolvesTo("return", "void");
  }
  
  @Test
  public void testReturnExpression_01() throws Exception {
    this.resolvesTo("return \'foo\'", "void");
  }
  
  @Test
  public void testReturnExpression_02() throws Exception {
    this.resolvesTo("return try { if (true) \'foo\' else \'bar\' } finally { String::valueOf(\'zonk\') }", "void");
  }
  
  @Test
  public void testReturnExpression_03() throws Exception {
    this.resolvesTo("{ val c = [ int i | return i ] c.apply(1) return null }", "void");
  }
  
  @Test
  public void testReturnExpression_04() throws Exception {
    this.resolvesTo("{ val c = [ int i | i ] c.apply(1) return null }", "void");
  }
  
  @Test
  public void testReturnExpression_05() throws Exception {
    this.resolvesTo("{ var closure = [| return \'literal\'] closure.apply }", "String");
  }
  
  @Test
  public void testReturnExpression_06() throws Exception {
    this.resolvesTo("{ var closure = [| return \'literal\'] return closure.apply }", "void");
  }
  
  @Test
  public void testReturnExpression_07() throws Exception {
    this.resolvesTo("[| return \'literal\'].apply", "String");
  }
  
  @Test
  public void testReturnExpression_08() throws Exception {
    this.resolvesTo("return [| return \'literal\'].apply", "void");
  }
  
  @Test
  public void testReturnExpression_09() throws Exception {
    Reference _resolvesTo = this.resolvesTo("[| return \'literal\']", "()=>String");
    this.isFunctionAndEquivalentTo(_resolvesTo, "Function0<String>");
  }
  
  @Test
  public void testReturnExpression_10() throws Exception {
    this.resolvesTo("return if (true) while(false) (\'foo\'+\'bar\').length", "void");
  }
  
  @Test
  public void testClosure_00() throws Exception {
    this.resolvesTo("[|\'literal\'].apply()", "String");
  }
  
  @Test
  public void testClosure_01() throws Exception {
    this.resolvesTo("{ var closure = [|\'literal\']\n\t\t  new testdata.ClosureClient().invoke0(closure)\t}", "String");
  }
  
  @Test
  public void testClosure_02() throws Exception {
    Reference _resolvesTo = this.resolvesTo("[String x| true]", "(String)=>boolean");
    this.isFunctionAndEquivalentTo(_resolvesTo, "Function1<String, Boolean>");
  }
  
  @Test
  public void testClosure_03() throws Exception {
    this.resolvesTo(((("{\n" + 
      "  var java.util.List<? super String> list = null;\n") + 
      "  list.map(e|e)\n") + 
      "}"), "List<Object>");
  }
  
  @Test
  public void testClosure_04() throws Exception {
    this.resolvesTo(((("{\n" + 
      "  var java.util.List<? super String> list = null;\n") + 
      "  list.map(e|false)\n") + 
      "}"), "List<Boolean>");
  }
  
  @Test
  public void testClosure_05() throws Exception {
    Reference _resolvesTo = this.resolvesTo("[x| true]", "(Object)=>boolean");
    this.isFunctionAndEquivalentTo(_resolvesTo, "Function1<Object, Boolean>");
  }
  
  @Test
  public void testClosure_06() throws Exception {
    Reference _resolvesTo = this.resolvesTo("[x| null]", "(Object)=>Object");
    this.isFunctionAndEquivalentTo(_resolvesTo, "Function1<Object, Object>");
  }
  
  @Test
  public void testClosure_07() throws Exception {
    Reference _resolvesTo = this.resolvesTo("[String x, String y| x + y ]", "(String, String)=>String");
    this.isFunctionAndEquivalentTo(_resolvesTo, "Function2<String, String, String>");
  }
  
  @Test
  public void testClosure_08() throws Exception {
    Reference _resolvesTo = this.resolvesTo("[x| x]", "(Object)=>Object");
    this.isFunctionAndEquivalentTo(_resolvesTo, "Function1<Object, Object>");
  }
  
  @Test
  public void testClosure_09() throws Exception {
    Reference _resolvesTo = this.resolvesTo("[String x, String y| x.substring(y.length)]", "(String, String)=>String");
    this.isFunctionAndEquivalentTo(_resolvesTo, "Function2<String, String, String>");
  }
  
  @Test
  public void testClosure_10() throws Exception {
    Reference _resolvesTo = this.resolvesTo("[ x | x.toString x ]", "(Object)=>Object");
    this.isFunctionAndEquivalentTo(_resolvesTo, "Function1<Object, Object>");
  }
  
  @Test
  public void testClosure_11() throws Exception {
    Reference _resolvesTo = this.resolvesTo("[Object x| x]", "(Object)=>Object");
    this.isFunctionAndEquivalentTo(_resolvesTo, "Function1<Object, Object>");
  }
  
  @Test
  public void testClosure_12() throws Exception {
    Reference _resolvesTo = this.resolvesTo("[Object x| x.toString x ]", "(Object)=>Object");
    this.isFunctionAndEquivalentTo(_resolvesTo, "Function1<Object, Object>");
  }
  
  @Test
  public void testClosure_13() throws Exception {
    this.resolvesTo("{ \n\t\t\tval mapper = [ x | x ]\n\t\t\tnewArrayList(1).map(mapper)\n\t\t}", "List<Integer>");
  }
  
  @Test
  public void testClosure_13a() throws Exception {
    this.resolvesTo("{ \n\t\t\tval mapper = [ x | x ]\n\t\t\tnewArrayList(1).map(mapper).head\n\t\t}", "Integer");
  }
  
  @Test
  public void testClosure_13b() throws Exception {
    this.resolvesTo("{ \n\t\t\tval mapper = [ x | x ]\n\t\t\tnewArrayList(1).map(mapper).findFirst [ true ]\n\t\t}", "Integer");
  }
  
  @Ignore("TODO deferred closure body typing")
  @Test
  public void testClosure_14() throws Exception {
    this.resolvesTo("{ \n\t\t\tval mapper = [ x | x.charAt(0) ]\n\t\t\tnewArrayList(\'\').map(mapper)\n\t\t}", "List<Character>");
  }
  
  @Test
  public void testClosure_15() throws Exception {
    Reference _resolvesTo = this.resolvesTo("{ \n\t\t\tval fun = [ x | x ]\n\t\t\tval String s = fun.apply(null)\n\t\t\tfun\n\t\t}", "(String)=>String");
    this.isFunctionAndEquivalentTo(_resolvesTo, "Function1<String, String>");
  }
  
  @Test
  public void testClosure_16() throws Exception {
    Reference _resolvesTo = this.resolvesTo("{ \n\t\t\tval fun = [ x | x ]\n\t\t\tval java.util.List<String> list = newArrayList(fun.apply(null))\n\t\t\tfun\n\t\t}", "(String[])=>String[]");
    this.isFunctionAndEquivalentTo(_resolvesTo, "Function1<String[], String[]>");
  }
  
  @Test
  public void testClosure_16_02() throws Exception {
    Reference _resolvesTo = this.resolvesTo("{ \n\t\t\tval fun = [ x | x ]\n\t\t\tval java.util.List<String> list = newArrayList(fun.apply(null), fun.apply(null))\n\t\t\tfun\n\t\t}", "(String)=>String");
    this.isFunctionAndEquivalentTo(_resolvesTo, "Function1<String, String>");
  }
  
  @Test
  public void testClosure_17() throws Exception {
    Reference _resolvesTo = this.resolvesTo("{ \n\t\t\tval fun = [ x | x ]\n\t\t\tval java.util.List<String> list = newArrayList.map(fun)\n\t\t\tfun\n\t\t}", "(String)=>String");
    this.isFunctionAndEquivalentTo(_resolvesTo, "Function1<String, String>");
  }
  
  @Test
  public void testClosure_18() throws Exception {
    Reference _resolvesTo = this.resolvesTo("{ \n\t\t\tval fun = [ x | x ]\n\t\t\tval java.util.Set<String> list = newArrayList.map(fun)\n\t\t\tfun\n\t\t}", "(String)=>String");
    this.isFunctionAndEquivalentTo(_resolvesTo, "Function1<String, String>");
  }
  
  @Test
  public void testClosure_19() throws Exception {
    Reference _resolvesTo = this.resolvesTo("{ \n\t\t\tval fun = [ x | x ]\n\t\t\tval java.util.ArrayList<String> list = newArrayList.map(fun)\n\t\t\tfun\n\t\t}", "(String)=>String");
    this.isFunctionAndEquivalentTo(_resolvesTo, "Function1<String, String>");
  }
  
  @Test
  public void testClosure_20() throws Exception {
    Reference _resolvesTo = this.resolvesTo("{ \n\t\t\tval fun = [ x | x ]\n\t\t\tval Iterable<String> list = newArrayList.map(fun)\n\t\t\tfun\n\t\t}", "(String)=>String");
    this.isFunctionAndEquivalentTo(_resolvesTo, "Function1<String, String>");
  }
  
  @Test
  public void testClosure_21() throws Exception {
    Reference _resolvesTo = this.resolvesTo("{ \n\t\t\tval fun = [ x | x ]\n\t\t\tval list = newArrayList.map(fun)\n\t\t\tval Iterable<String> iter = list\n\t\t\tfun\n\t\t}", "(String)=>String");
    this.isFunctionAndEquivalentTo(_resolvesTo, "Function1<String, String>");
  }
  
  @Test
  public void testClosure_22() throws Exception {
    Reference _resolvesTo = this.resolvesTo("{ \n\t\t\tval fun = [ x | x ]\n\t\t\tval java.util.List<String> list = $$ListExtensions::map(newArrayList, fun)\n\t\t\tfun\n\t\t}", "(String)=>String");
    this.isFunctionAndEquivalentTo(_resolvesTo, "Function1<String, String>");
  }
  
  @Test
  public void testClosure_23() throws Exception {
    Reference _resolvesTo = this.resolvesTo("{ \n\t\t\tval fun = [ x | x ]\n\t\t\tval java.util.Set<String> list = $$ListExtensions::map(newArrayList, fun)\n\t\t\tfun\n\t\t}", "(String)=>String");
    this.isFunctionAndEquivalentTo(_resolvesTo, "Function1<String, String>");
  }
  
  @Test
  public void testClosure_24() throws Exception {
    Reference _resolvesTo = this.resolvesTo("{ \n\t\t\tval fun = [ x | x ]\n\t\t\tval java.util.ArrayList<String> list = $$ListExtensions::map(newArrayList, fun)\n\t\t\tfun\n\t\t}", "(String)=>String");
    this.isFunctionAndEquivalentTo(_resolvesTo, "Function1<String, String>");
  }
  
  @Test
  public void testClosure_25() throws Exception {
    Reference _resolvesTo = this.resolvesTo("{ \n\t\t\tval fun = [ x | x ]\n\t\t\tval Iterable<String> list = $$ListExtensions::map(newArrayList, fun)\n\t\t\tfun\n\t\t}", "(String)=>String");
    this.isFunctionAndEquivalentTo(_resolvesTo, "Function1<String, String>");
  }
  
  @Test
  public void testClosure_26() throws Exception {
    Reference _resolvesTo = this.resolvesTo("{ \n\t\t\tval fun = [ x | x ]\n\t\t\tval list = $$ListExtensions::map(newArrayList, fun)\n\t\t\tval Iterable<String> iter = list\n\t\t\tfun\n\t\t}", "(String)=>String");
    this.isFunctionAndEquivalentTo(_resolvesTo, "Function1<String, String>");
  }
  
  @Test
  public void testClosure_27() throws Exception {
    this.resolvesTo("{ \n\t\t\tval mapper = [ x | x ]\n\t\t\t$$ListExtensions::map(newArrayList(1), mapper)\n\t\t}", "List<Integer>");
  }
  
  @Test
  public void testClosure_28() throws Exception {
    this.resolvesTo("[|].apply()", "Object");
  }
  
  @Test
  public void testClosure_29() throws Exception {
    this.resolvesTo("[].apply()", "Object");
    this.resolvesTo("[].apply(\'\')", "Object");
    this.resolvesTo("[].apply(\'\', \'\')", "Object");
  }
  
  @Test
  public void testClosure_30() throws Exception {
    this.resolvesTo("$$ListExtensions::map(null as java.util.List<? super String>) [e|e]", "List<Object>");
  }
  
  @Test
  public void testClosure_31() throws Exception {
    this.resolvesTo(((("{\n" + 
      "  var java.util.List<? super String> list = null;\n") + 
      "  $$ListExtensions::map(list) [e|e]\n") + 
      "}"), "List<Object>");
  }
  
  @Ignore("TODO deferred closure body typing")
  @Test
  public void testClosure_32() throws Exception {
    this.resolvesTo("[ x, i | x.charAt(i) ].apply(\'\', 0)", "Character");
  }
  
  @Test
  public void testClosure_33() throws Exception {
    Reference _resolvesTo = this.resolvesTo("[ String it | val bytes = new String bytes ]", "(String)=>String");
    this.isFunctionAndEquivalentTo(_resolvesTo, "Function1<String, String>");
  }
  
  @Test
  public void testNewTreeSet_01() throws Exception {
    this.resolvesTo("new java.util.TreeSet(newArrayList(\'\'))", "TreeSet<String>");
  }
  
  @Test
  public void testNewTreeSet_02() throws Exception {
    this.resolvesTo("newTreeSet[a, b|0]", "TreeSet<Object>");
  }
  
  @Test
  public void testNewTreeSet_03() throws Exception {
    this.resolvesTo("newTreeSet([a, b|0], \'a\', \'b\')", "TreeSet<String>");
  }
  
  @Test
  public void testNewTreeSet_04() throws Exception {
    this.resolvesTo("newTreeSet([a, b|a.length.compareTo(b.length)], \'a\', \'b\')", "TreeSet<String>");
  }
  
  @Test
  public void testNewTreeSet_05() throws Exception {
    this.resolvesTo("newTreeSet([a, b|a.toString.compareTo(b.toString)], \'a\', \'b\')", "TreeSet<String>");
  }
  
  @Test
  public void testTypeArgs_01() throws Exception {
    this.resolvesTo("new java.util.ArrayList<String>() += \'foo\'", "boolean");
  }
  
  @Test
  public void testJEP101Example_01() throws Exception {
    this.resolvesTo("foo::JEP101List::cons(42, foo::JEP101List::nil())", "JEP101List<Integer>");
  }
  
  @Test
  public void testIfExpression_01() throws Exception {
    this.resolvesTo("if (true) \'foo\' else null", "String");
    this.resolvesTo("if (true) \'foo\' else \'bar\'", "String");
    this.resolvesTo("if (true) \'foo\'", "String");
  }
  
  @Test
  public void testIfExpression_02() throws Exception {
    this.resolvesTo("if (true) new StringBuilder() else new StringBuffer()", "AbstractStringBuilder & Serializable");
  }
  
  @Test
  public void testIfExpression_03() throws Exception {
    this.resolvesTo("if (true) return \'foo\'", "void");
  }
  
  @Test
  public void testIfExpression_04() throws Exception {
    this.resolvesTo("if (true) return \'\' else new StringBuilder", "StringBuilder");
  }
  
  @Test
  public void testIfExpression_05() throws Exception {
    Reference _resolvesTo = this.resolvesTo("if (true) [|\'\'] else [|\'\']", "()=>String");
    this.isFunctionAndEquivalentTo(_resolvesTo, "Function0<String>");
  }
  
  @Test
  public void testIfExpression_06() throws Exception {
    Reference _resolvesTo = this.resolvesTo("if (true) [|\'\'] else [|null as CharSequence]", "()=>CharSequence");
    this.isFunctionAndEquivalentTo(_resolvesTo, "Function0<CharSequence>");
  }
  
  @Test
  public void testIfExpression_07() throws Exception {
    Reference _resolvesTo = this.resolvesTo("if (true) [|null as Appendable] else [|null as CharSequence]", "()=>Object");
    this.isFunctionAndEquivalentTo(_resolvesTo, "Function0<?>");
  }
  
  @Test
  public void testIfExpression_08() throws Exception {
    Reference _resolvesTo = this.resolvesTo("if (true) [ CharSequence c |\'\'] else [ String s |\'\']", "(String)=>String");
    this.isFunctionAndEquivalentTo(_resolvesTo, "Function1<String, String>");
  }
  
  @Test
  public void testIfExpression_09() throws Exception {
    Reference _resolvesTo = this.resolvesTo("if (true) [new StringBuilder()] else [new StringBuffer()]", "(Object)=>AbstractStringBuilder & Serializable");
    this.isFunctionAndEquivalentTo(_resolvesTo, "Function1<Object, ? extends AbstractStringBuilder & Serializable>");
  }
  
  @Test
  public void testIfExpression_10() throws Exception {
    this.resolvesTo("if (true) null as java.util.List<String> else null as String[]", "Object");
  }
  
  @Test
  public void testIfExpression_11() throws Exception {
    this.resolvesTo("(if (true) [new StringBuilder()] else [new StringBuffer()]).apply(\'\')", "AbstractStringBuilder & Serializable");
  }
  
  @Test
  public void testIfExpression_12() throws Exception {
    this.resolvesTo("if (true) newArrayList else <String>newHashSet", "AbstractCollection<String> & Serializable & Cloneable");
  }
  
  @Test
  public void testIfExpression_13() throws Exception {
    this.resolvesTo("if (true) <StringBuffer>newArrayList else <String>newHashSet", "AbstractCollection<? extends Serializable & CharSequence> & Serializable & Cloneable");
  }
  
  @Test
  public void testIfExpression_14() throws Exception {
    this.resolvesTo("if (true) newArrayList else newHashSet", "AbstractCollection<Object> & Serializable & Cloneable");
  }
  
  @Test
  public void testIfExpression_15() throws Exception {
    this.resolvesTo("if (true) null else null", "null");
  }
  
  @Test
  public void testIfExpression_16() throws Exception {
    this.resolvesTo("if (true) return 1 else 0", "int");
  }
  
  @Test
  public void testIfExpression_17() throws Exception {
    this.resolvesTo("if (true) return 1", "void");
  }
  
  @Test
  public void testIfExpression_18() throws Exception {
    this.resolvesTo("if (true) return", "void");
  }
  
  @Test
  public void testIfExpression_19() throws Exception {
    this.resolvesTo("if (true) return else null", "null");
  }
  
  @Test
  public void testIfExpression_20() throws Exception {
    this.resolvesTo("if (true) return else return", "void");
  }
  
  @Test
  public void testIfExpression_21() throws Exception {
    this.resolvesTo("{ val x = if (true) null else null x }", "null");
  }
  
  @Test
  public void testIfExpression_22() throws Exception {
    this.resolvesTo("{ val x = if (true) return 1 else 0 x }", "int");
  }
  
  @Test
  public void testIfExpression_23() throws Exception {
    this.resolvesTo("{ val x = if (true) return 1 x }", "null");
  }
  
  @Test
  public void testIfExpression_24() throws Exception {
    this.resolvesTo("{ val x = if (true) return; x }", "null");
  }
  
  @Test
  public void testIfExpression_25() throws Exception {
    this.resolvesTo("{ val x = if (true) return else null x }", "null");
  }
  
  @Test
  public void testIfExpression_26() throws Exception {
    this.resolvesTo("if (true) for(i: 1..2) i.toString else \'\'", "String");
  }
  
  @Test
  public void testIfExpression_27() throws Exception {
    this.resolvesTo("if (true) while(false) (\'foo\'+\'bar\').length", "void");
  }
  
  @Test
  public void testIfExpression_28() throws Exception {
    this.resolvesTo("if (true) return \'\' else 1", "int");
  }
  
  @Test
  public void testIfExpression_29() throws Exception {
    this.resolvesTo("if (true) while(true) \'\'.toString else while(true) \'\'.toString", "void");
  }
  
  @Test
  public void testIfExpression_30() throws Exception {
    this.resolvesTo("if (true) null as int[] else null as Integer[]", "Serializable & Cloneable");
  }
  
  @Test
  public void testIfExpression_31() throws Exception {
    this.resolvesTo("if (true) null as int[] else null as Iterable<Integer>", "Object");
  }
  
  @Test
  public void testIfExpression_32() throws Exception {
    this.resolvesTo("if (true) while(false) \'\'.toString else \'myString\'", "String");
  }
  
  @Test
  public void testIfExpression_33() throws Exception {
    this.resolvesTo("if(true) #{\'f\'} else emptySet", "Set<String>");
  }
  
  @Test
  public void testIfExpression_34() throws Exception {
    this.resolvesTo("if(true) true else Boolean.TRUE", "Boolean");
  }
  
  @Test
  public void testSwitchExpression() throws Exception {
    this.resolvesTo("switch true { case true : \'s\' case false : \'foo\' default: \'bar\'}", "String");
    this.resolvesTo("switch true { case true : \'s\' case false : new Object() default: \'bar\'}", "Object");
  }
  
  @Test
  public void testSwitchExpression_1() throws Exception {
    this.resolvesTo("switch true { case true : return \'s\' default: null}", "null");
  }
  
  @Test
  public void testSwitchExpression_2() throws Exception {
    this.resolvesTo("switch null {\n\t\t  Object : return null \n\t\t}", "void");
  }
  
  @Test
  public void testSwitchExpression_3() throws Exception {
    this.resolvesTo("{\n\t\t\tval Object c = null\n\t\t\tswitch c {\n\t            CharSequence: 1\n\t    \t}\n\t\t}", "int");
  }
  
  @Test
  public void testSwitchExpression_4() throws Exception {
    this.resolvesTo("{\n\t\t\tval Comparable<Object> c = null\n\t\t\tswitch c {\n\t            CharSequence: switch(c) {\n                    Appendable: {\n                        c.charAt(1)\n                    }\n                }\n        \t}\n\t\t}", "char");
  }
  
  @Test
  public void testSwitchExpression_5() throws Exception {
    this.resolvesTo("{\n\t\t\tval Comparable<Object> c = null\n\t\t\tswitch c {\n\t            CharSequence: switch(c) {\n                    Appendable: {\n                        c.append(null)\n                    }\n                }\n        \t}\n\t\t}", "Appendable");
  }
  
  @Test
  public void testSwitchExpression_6() throws Exception {
    this.resolvesTo("{\n\t\t\tval Comparable<Object> c = null\n\t\t\tswitch c {\n\t            CharSequence: switch(c) {\n                    Appendable: {\n                        c.compareTo(null)\n                    }\n                }\n        \t}\n\t\t}", "int");
  }
  
  @Test
  public void testSwitchExpression_7() throws Exception {
    this.resolvesTo("{\n\t\t\tval Comparable<Object> it = null\n\t\t\tswitch it {\n\t            CharSequence: switch(it) {\n                    Appendable: {\n                        charAt(1)\n                    }\n                }\n        \t}\n\t\t}", "char");
  }
  
  @Test
  public void testSwitchExpression_8() throws Exception {
    this.resolvesTo("{\n\t\t\tval Comparable<Object> it = null\n\t\t\tswitch it {\n\t            CharSequence: switch(it) {\n                    Appendable: {\n                        append(null)\n                    }\n                }\n        \t}\n\t\t}", "Appendable");
  }
  
  @Test
  public void testSwitchExpression_9() throws Exception {
    this.resolvesTo("{\n\t\t\tval Comparable<Object> it = null\n\t\t\tswitch it {\n\t            CharSequence: switch(it) {\n                    Appendable: {\n                        compareTo(null)\n                    }\n                }\n        \t}\n\t\t}", "int");
  }
  
  @Test
  public void testSwitchExpression_10() throws Exception {
    Reference _resolvesTo = this.resolvesTo("switch null {\n            case null : [Object it | it]\n            case null : [Integer it | it]\n        }", "(Integer)=>Object");
    this.isFunctionAndEquivalentTo(_resolvesTo, "Function1<? super Integer, ?>");
  }
  
  @Test
  public void testSwitchExpression_11() throws Exception {
    this.resolvesTo("switch null {\n\t\t  Object : return \n\t\t}", "void");
  }
  
  @Test
  public void testSwitchExpression_12() throws Exception {
    this.resolvesTo("switch null {\n\t\t  Object : return\n\t\t  default: return\n\t\t}", "void");
  }
  
  @Test
  public void testTypeGuardedCase_0() throws Exception {
    this.resolvesTo("switch s: new Object() { String: s StringBuffer: s}", "Serializable & CharSequence");
  }
  
  @Test
  public void testTypeGuardedCase_1() throws Exception {
    this.resolvesTo("switch s: \'\' as CharSequence { Cloneable: s String: s }", "CharSequence");
  }
  
  @Test
  public void testTypeGuardedCase_2() throws Exception {
    this.resolvesTo("{\n\t\t\tval java.util.Iterator<CharSequence> it = null\n\t\t\tswitch next {\n\t            String: next\n        \t}\n\t\t}", "CharSequence");
  }
  
  @Test
  public void testTypeGuardedCase_3() throws Exception {
    this.resolvesTo("switch s: new Object() { String, StringBuffer: s}", "Serializable & CharSequence");
  }
  
  @Test
  public void testTypeGuardedCase_4() throws Exception {
    this.resolvesTo("switch s: \'\' as CharSequence { Cloneable, String: s }", "CharSequence");
  }
  
  @Test
  public void testSwitchExpression_Bug343100() throws Exception {
    this.resolvesTo("switch \'a\' {\n\t\t  case null: typeof(String) \n\t\t  case \'a\': typeof(Void)\n\t\t}", "Class<?>");
  }
  
  @Test
  public void testBlockExpression_01() throws Exception {
    this.resolvesTo("{}", "null");
    this.resolvesTo("{null}", "null");
    this.resolvesTo("{\'\'.toString 4}", "int");
    this.resolvesTo("{\'\'.toString true}", "boolean");
  }
  
  @Test
  public void testBlockExpression_02() throws Exception {
    this.resolvesTo("{val s = \'\' s}", "String");
  }
  
  @IgnoredBySmokeTest("Do not run smoke test with 1000s of nested expressions")
  @Test
  public void testBlockExpression_03() throws Exception {
    String input = "{ val s1 = \'\'\n";
    final int max = 1000;
    IntegerRange _upTo = new IntegerRange(1, max);
    for (final Integer i : _upTo) {
      input = (((((input + " val s") + Integer.valueOf(((i).intValue() + 1))) + " = s") + i) + "\n");
    }
    input = (((input + " s") + Integer.valueOf((max + 1))) + "}");
    this.resolvesTo(input, "String");
  }
  
  @Test
  public void testBlockExpression_04() throws Exception {
    this.resolvesTo("{val Object s = \'\' s}", "Object");
  }
  
  @Test
  public void testBlockExpression_05() throws Exception {
    this.resolvesTo("{val Object s = \'\'}", "void");
  }
  
  @Test
  public void testBlockExpression_06() throws Exception {
    this.resolvesTo("{val Object s = \'\' s.notify}", "void");
  }
  
  @Test
  public void testBlockExpression_07() throws Exception {
    this.resolvesTo("{\n            val (Integer, Double, Boolean) => void fun1 = null\n            val (byte[], Object) => double[] fun2 = null\n            val test = newArrayList.map[1 -> org::eclipse::xtext::xbase::lib::Pair::of(fun1, fun2)]\n            val test2 = newArrayList.map[2 -> org::eclipse::xtext::xbase::lib::Pair::of(fun1, fun2)]\n            val test3 = com::google::common::collect::Iterables::concat(test, test2).toMap[key].entrySet.map[value].toList\n            test3\n        }", "List<Pair<Integer, Pair<(Integer, Double, Boolean)=>void, (byte[], Object)=>double[]>>>");
  }
  
  @Test
  public void testBlockExpression_08() throws Exception {
    this.resolvesTo("{\n            val (Integer, Double, Boolean) => void fun1 = null\n            val (byte[], Object) => double[] fun2 = null\n            val test = newArrayList.map[1 -> org::eclipse::xtext::xbase::lib::Pair::of(fun1, fun2)]\n            val test2 = newArrayList.map[2 -> org::eclipse::xtext::xbase::lib::Pair::of(fun1, fun2)]\n            val test3 = com::google::common::collect::Iterables::concat(test, test2).toMap[key].entrySet.map[value].toList\n            test3.head.value.value.apply(null, null).last\n        }", "Double");
  }
  
  @Test
  public void testBlockExpression_09() throws Exception {
    this.resolvesTo("{val Object x = if (false) return; x }", "Object");
  }
  
  @Test
  public void testBlockExpression_10() throws Exception {
    this.resolvesTo("{ ( if (true) {val Object x = if (false) return; x } ) }", "Object");
  }
  
  @Test
  public void testBlockExpression_11() throws Exception {
    this.resolvesTo("{ ( if (true) {val Object x = if (false) return; x } ) {val Object x = if (false) return; x } }", "Object");
  }
  
  @Test
  public void testBlockExpression_12() throws Exception {
    this.resolvesTo("{ ( if (true) if (true) return else null ) { if (true) return else null } }", "null");
  }
  
  @Test
  public void testEntrySet_01() throws Exception {
    this.resolvesTo("(null as java.util.Map<? extends String,? extends String>).entrySet", "Set<? extends Entry<? extends String, ? extends String>>");
  }
  
  @Test
  public void testEntrySet_02() throws Exception {
    this.resolvesTo("(null as java.util.Map<String, String>).entrySet", "Set<Entry<String, String>>");
  }
  
  @Test
  public void testEntrySet_03() throws Exception {
    this.resolvesTo("(null as java.util.Map<Iterable<? extends String>, Iterable<? extends String>>).entrySet", "Set<Entry<Iterable<? extends String>, Iterable<? extends String>>>");
  }
  
  @Test
  public void testEMap_01() throws Exception {
    this.resolvesTo("{ \n          val eMap = new org.eclipse.emf.common.util.BasicEMap<Integer, String>()\n\t\t  eMap.map[ getKey ].head\n         }", "Integer");
  }
  
  @Test
  public void testEMap_02() throws Exception {
    this.resolvesTo("{ \n          val eMap = new org.eclipse.emf.common.util.BasicEMap<Integer, String>()\n\t\t  eMap.map[ getValue ].head\n         }", "String");
  }
  
  @Test
  public void testEMap_03() throws Exception {
    this.resolvesTo("{ \n          val eMap = new org.eclipse.emf.common.util.BasicEMap<Integer, String>()\n\t\t  eMap.map[ it ].head\n         }", "Entry<Integer, String>");
  }
  
  @Test
  public void testEMap_04() throws Exception {
    this.resolvesTo("{ \n          val eMap = new org.eclipse.emf.common.util.BasicEMap<Integer, String>()\n\t\t  eMap.map\n         }", "Map<Integer, String>");
  }
  
  @Test
  public void testEMap_05() throws Exception {
    this.resolvesTo("{ \n          val org.eclipse.emf.common.util.BasicEMap<? extends Integer, String> eMap = null\n\t\t  eMap.map[ key ].head\n         }", "Integer");
  }
  
  @Test
  public void testEMap_06() throws Exception {
    this.resolvesTo("{ \n          val org.eclipse.emf.common.util.BasicEMap<? extends Integer, String> eMap = null\n\t\t  eMap.map[ value ].head\n         }", "String");
  }
  
  @Test
  public void testEMap_07() throws Exception {
    this.resolvesTo("{ \n          val org.eclipse.emf.common.util.BasicEMap<? extends Integer, String> eMap = null\n\t\t  eMap.map[ it ].head\n         }", "Entry<? extends Integer, String>");
  }
  
  @Test
  public void testEMap_08() throws Exception {
    this.resolvesTo("{ \n          val org.eclipse.emf.common.util.BasicEMap<? extends Integer, String> eMap = null\n\t\t  eMap.map\n         }", "Map<? extends Integer, String>");
  }
  
  @Test
  public void testEMap_09() throws Exception {
    this.resolvesTo("{ \n          val org.eclipse.emf.common.util.BasicEMap<? super Integer, String> eMap = null\n\t\t  eMap.map[ key ].head\n         }", "Object");
  }
  
  @Test
  public void testEMap_10() throws Exception {
    this.resolvesTo("{ \n          val org.eclipse.emf.common.util.BasicEMap<? super Integer, String> eMap = null\n\t\t  eMap.map[ value ].head\n         }", "String");
  }
  
  @Test
  public void testEMap_11() throws Exception {
    this.resolvesTo("{ \n          val org.eclipse.emf.common.util.BasicEMap<? super Integer, String> eMap = null\n\t\t  eMap.map[ it ].head\n         }", "Entry<? super Integer, String>");
  }
  
  @Test
  public void testEMap_12() throws Exception {
    this.resolvesTo("{ \n          val org.eclipse.emf.common.util.BasicEMap<? super Integer, String> eMap = null\n\t\t  eMap.map\n         }", "Map<? super Integer, String>");
  }
  
  @Test
  public void testConstructorCall_01() throws Exception {
    this.resolvesTo("new java.util.ArrayList<String>()", "ArrayList<String>");
    this.resolvesTo("new java.util.HashMap<String,Boolean>", "HashMap<String, Boolean>");
    this.resolvesTo("new java.util.ArrayList()", "ArrayList<Object>");
  }
  
  @Test
  public void testConstructorCall_02() throws Exception {
    this.resolvesTo("new java.util.ArrayList<? extends String>()", "ArrayList<String>");
    this.resolvesTo("new java.util.HashMap<? extends String, ? extends Boolean>", "HashMap<String, Boolean>");
  }
  
  @Test
  public void testConstructorCall_03() throws Exception {
    this.resolvesTo("new java.util.ArrayList<? super String>()", "ArrayList<String>");
    this.resolvesTo("new java.util.HashMap<? super String,Boolean>", "HashMap<String, Boolean>");
  }
  
  @Test
  public void testBrokenConstructorCall_01() throws Exception {
    this.resolvesTo("new Iterable<String>()", "Iterable<String>");
  }
  
  @Test
  public void testBrokenConstructorCall_02() throws Exception {
    this.resolvesTo("new java.util.Map<String>()", "Map<String, Object>");
  }
  
  @Test
  public void testConstructorTypeInference_01() throws Exception {
    this.resolvesTo("new testdata.GenericType1(\'\')", "GenericType1<String>");
  }
  
  @Test
  public void testConstructorTypeInference_02() throws Exception {
    this.resolvesTo("<java.util.List<String>>newArrayList().add(new java.util.ArrayList())", "boolean");
  }
  
  @Test
  public void testConstructorTypeInference_03() throws Exception {
    this.resolvesTo("<java.util.List<String>>newArrayList().add(0, new java.util.ArrayList())", "void");
  }
  
  @Test
  public void testConstructorTypeInference_04() throws Exception {
    this.resolvesTo("newArrayList.add(new java.util.ArrayList())", "boolean");
  }
  
  @Test
  public void testConstructorTypeInference_05() throws Exception {
    this.resolvesTo("new testdata.GenericType2", "GenericType2<Number>");
  }
  
  @Test
  public void testConstructorTypeInference_06() throws Exception {
    this.resolvesTo("new testdata.GenericType2(0)", "GenericType2<Integer>");
  }
  
  @Test
  public void testConstructorTypeInference_07() throws Exception {
    this.resolvesTo("new testdata.GenericType2(0, 1)", "GenericType2<Integer>");
  }
  
  @Test
  public void testConstructorTypeInference_08() throws Exception {
    this.resolvesTo("new testdata.GenericType2(new Integer(0), new Integer(0).doubleValue)", "GenericType2<Number & Comparable<?>>");
  }
  
  @Test
  public void testConstructorTypeInference_09() throws Exception {
    this.resolvesTo("<Iterable<String>>newArrayList().add(new java.util.LinkedList)", "boolean");
  }
  
  @Test
  public void testConstructorTypeInference_10() throws Exception {
    this.resolvesTo("<Iterable<String>>newArrayList().add(null)", "boolean");
  }
  
  @Test
  public void testConstructorTypeInference_11() throws Exception {
    this.resolvesTo("<java.util.Map<Iterable<String>, Iterable<Integer>>>newArrayList().head", "Map<Iterable<String>, Iterable<Integer>>");
  }
  
  @Test
  public void testClassNewInstance() throws Exception {
    this.resolvesTo("typeof(String).newInstance", "String");
  }
  
  @Test
  public void testClassGetSuperclass_01() throws Exception {
    this.resolvesTo("typeof(String).superclass", "Class<? super String>");
  }
  
  @Test
  public void testClassGetSuperclass_02() throws Exception {
    this.resolvesTo("typeof(String).superclass.superclass", "Class<? super String>");
  }
  
  @Test
  public void testClassGetSuperclass_03() throws Exception {
    this.resolvesTo("{ var c = Class::forName(\'\') c.superclass }", "Class<?>");
  }
  
  @Test
  public void testClassGetSuperclass_04() throws Exception {
    this.resolvesTo("{ var c = Class::forName(\'\') println(c.superclass) }", "Class<?>");
  }
  
  @Test
  public void testVarArgs_01() throws Exception {
    this.resolvesTo("newArrayList(new Double(\'-20\'), new Integer(\'20\'))", "ArrayList<Number & Comparable<?>>");
  }
  
  @Test
  public void testVarArgs_02() throws Exception {
    this.resolvesTo("newArrayList(if (true) new Double(\'-20\') else new Integer(\'20\'))", "ArrayList<Number & Comparable<?>>");
  }
  
  @Test
  public void testVarArgs_03() throws Exception {
    this.resolvesTo("newArrayList(if (true) new Double(\'-20\') else new Integer(\'20\'), new Integer(\'29\'))", "ArrayList<Number & Comparable<?>>");
  }
  
  @Test
  public void testVarArgs_04() throws Exception {
    this.resolvesTo("newArrayList(if (true) new Double(\'-20\') else new Integer(\'20\'), new Double(\'29\'))", "ArrayList<Number & Comparable<?>>");
  }
  
  @Test
  public void testVarArgs_05() throws Exception {
    this.resolvesTo("newArrayList(if (true) new Double(\'-20\') else new Integer(\'20\'), new Integer(\'29\'), new Double(\'29\'))", "ArrayList<Number & Comparable<?>>");
  }
  
  @Test
  public void testVarArgs_06() throws Exception {
    this.resolvesTo("java::util::Arrays::asList(1, 3d, \'4\')", "List<Comparable<?> & Serializable>");
  }
  
  @Test
  public void testVarArgs_07() throws Exception {
    this.resolvesTo("newArrayList(null as Integer[], null as int[], null as Iterable<Integer>)", "ArrayList<Object>");
  }
  
  @Test
  public void testVarArgs_08() throws Exception {
    this.resolvesTo("newArrayList(null as Integer[], null as int[])", "ArrayList<Serializable & Cloneable>");
  }
  
  @Test
  public void testFeatureCall_01() throws Exception {
    this.resolvesTo("\'foo\'.length", "int");
  }
  
  @Test
  public void testFeatureCall_02() throws Exception {
    this.resolvesTo("\'foo\'.getBytes()", "byte[]");
    this.resolvesTo("new java.util.ArrayList<String>().get(23)", "String");
  }
  
  @Test
  public void testFeatureCall_03() throws Exception {
    this.resolvesTo("new testdata.ClassWithVarArgs().toList()", "List<Object>");
    this.resolvesTo("new testdata.ClassWithVarArgs().toList(\'\')", "List<String>");
    this.resolvesTo("new testdata.ClassWithVarArgs().toList(\'\', \'\')", "List<String>");
  }
  
  @Test
  public void testFeatureCall_03_a() throws Exception {
    this.resolvesTo("new testdata.ClassWithVarArgs().toList(null as String[])", "List<String>");
  }
  
  @Test
  public void testFeatureCall_03_b() throws Exception {
    this.resolvesTo("new testdata.ClassWithVarArgs().toList(null as int[])", "List<int[]>");
  }
  
  @Test
  public void testMemberFeatureCall_01() throws Exception {
    this.resolvesTo("\'x\'.length", "int");
  }
  
  @Test
  public void testMemberFeatureCall_02() throws Exception {
    this.resolvesTo("(1..20).map[ toString.length ].reduce[ i1,  i2 | i1 + i2 ]", "Integer");
  }
  
  @Test
  public void testMemberFeatureCall_03() throws Exception {
    this.resolvesTo("newArrayList(\'\').get(0)", "String");
    this.resolvesTo("<String>newArrayList().get(0)", "String");
  }
  
  @Test
  public void testMemberFeatureCall_04() throws Exception {
    this.resolvesTo("\'\'.^class", "Class<? extends String>");
  }
  
  @Test
  public void testMemberFeatureCall_05() throws Exception {
    this.resolvesTo("\'\'.^class.superclass", "Class<?>");
  }
  
  @Test
  public void testFeatureCall_04() throws Exception {
    this.resolvesTo("new testdata.ClassWithVarArgs().toList(\'\', 1)", "List<Comparable<?> & Serializable>");
  }
  
  @Test
  public void testFeatureCall_05() throws Exception {
    this.resolvesTo("new testdata.ClassWithVarArgs().toNumberList()", "List<Number>");
    this.resolvesTo("new testdata.ClassWithVarArgs().toNumberList(0)", "List<Integer>");
    this.resolvesTo("new testdata.ClassWithVarArgs().toNumberList(0, 1)", "List<Integer>");
    this.resolvesTo("new testdata.ClassWithVarArgs().toNumberList(new Integer(0), new Integer(0).doubleValue)", "List<Number & Comparable<?>>");
  }
  
  @Test
  public void testFeatureCall_05_b() throws Exception {
    this.resolvesTo("new testdata.ClassWithVarArgs().toNumberList(null as Float[])", "List<Float>");
  }
  
  @Test
  public void testFeatureCall_06() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(s|s)", "List<String>");
  }
  
  @Test
  public void testFeatureCall_06a() throws Exception {
    this.resolvesTo("newArrayList(\'\').map [it|it]", "List<String>");
  }
  
  @Test
  public void testFeatureCall_06b() throws Exception {
    this.resolvesTo("newArrayList(\'\').map [it]", "List<String>");
  }
  
  @Test
  public void testFeatureCall_06c() throws Exception {
    this.resolvesTo("(null as Iterable<String>).map(s|s)", "Iterable<String>");
  }
  
  @Test
  public void testFeatureCall_06_00() throws Exception {
    this.resolvesTo("$$ListExtensions::map(newArrayList(\'\')) [s|s]", "List<String>");
  }
  
  @Test
  public void testFeatureCall_06_01() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(s|s).head", "String");
  }
  
  @Test
  public void testFeatureCall_06_02() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(s|s.toString).head", "String");
  }
  
  @Test
  public void testFeatureCall_06_03() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(s|1)", "List<Integer>");
  }
  
  @Test
  public void testFeatureCall_06_04() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(s|1).head", "Integer");
  }
  
  @Test
  public void testFeatureCall_07() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(s|s.length)", "List<Integer>");
  }
  
  @Test
  public void testFeatureCall_07_01() throws Exception {
    this.resolvesTo("<String>newArrayList.map(s|s.length)", "List<Integer>");
  }
  
  @Test
  public void testFeatureCall_07_02() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(s|s.length).head", "Integer");
  }
  
  @Test
  public void testFeatureCall_07_03() throws Exception {
    this.resolvesTo("<String>newArrayList.map(s|s.length).head", "Integer");
  }
  
  @Test
  public void testFeatureCall_08() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(s|s != null)", "List<Boolean>");
  }
  
  @Test
  public void testFeatureCall_09() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(s|s.length+1)", "List<Integer>");
  }
  
  @Test
  public void testFeatureCall_10() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(s|1).map(i|i+1)", "List<Integer>");
  }
  
  @Test
  public void testFeatureCall_11() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(s|1).toList()", "List<Integer>");
  }
  
  @Test
  public void testFeatureCall_12() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(s|1).toList().map(i|i)", "List<Integer>");
  }
  
  @Test
  public void testFeatureCall_13() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(s|1).toList().map(i|i+1)", "List<Integer>");
  }
  
  @Test
  public void testFeatureCall_13_2() throws Exception {
    this.resolvesTo("{ var it = newArrayList(\'\').map(s|1).toList() it.map(i|i+1) }", "List<Integer>");
  }
  
  @Test
  public void testFeatureCall_13_3() throws Exception {
    this.resolvesTo("{ var it = newArrayList(\'\').map(s|1).toList() map(i|i+1) }", "List<Integer>");
  }
  
  @Test
  public void testFeatureCall_13_4() throws Exception {
    this.resolvesTo("{ var it = newArrayList(\'\').map(s|1).toList() it }", "List<Integer>");
  }
  
  @Test
  public void testFeatureCall_13_5() throws Exception {
    this.resolvesTo("{ var java.util.List<? extends Integer> it = null map(i|i+1) }", "List<Integer>");
  }
  
  @Test
  public void testFeatureCall_13_6() throws Exception {
    this.resolvesTo("{ var java.util.List<? extends Integer> it = null map(i|i) }", "List<Integer>");
  }
  
  @Test
  public void testFeatureCall_14() throws Exception {
    this.resolvesTo("newArrayList(newArrayList(\'\').map(s|1))", "ArrayList<List<Integer>>");
  }
  
  @Test
  public void testFeatureCall_15() throws Exception {
    this.resolvesTo("newArrayList(newArrayList(\'\').map(s|1)).map(iterable|iterable.size())", "List<Integer>");
  }
  
  @Test
  public void testFeatureCall_15_a() throws Exception {
    this.resolvesTo("newArrayList(newArrayList(\'\').map(s|1)).map(iterable|iterable.size()).map(e|e)", "List<Integer>");
  }
  
  @Test
  public void testFeatureCall_15_b() throws Exception {
    this.resolvesTo("newArrayList(newArrayList(\'\').map(s|1)).map(iterable|iterable.size()).map(e|e).map(e|e)", "List<Integer>");
  }
  
  @Test
  public void testFeatureCall_15_c() throws Exception {
    this.resolvesTo("newArrayList(newArrayList(\'\').map(s|1)).map(iterable|iterable.size()).map(e|e).map(e|e).map(e|e)", "List<Integer>");
  }
  
  @Test
  public void testFeatureCall_15_d() throws Exception {
    this.resolvesTo("newArrayList(newArrayList(\'\').map(s|1)).map(iterable|iterable.size()).map(e|e).map(e|e).map(e|e).map(e|e)", "List<Integer>");
  }
  
  @Test
  public void testFeatureCall_15_d_2() throws Exception {
    this.resolvesTo("newArrayList(newArrayList(\'\').map(s|1)).map(iterable|iterable.size()).map(e|e).map(e|e).map(e|e).map(e|e).head", "Integer");
  }
  
  @Test
  public void testFeatureCall_15_e() throws Exception {
    this.resolvesTo("newArrayList(newArrayList(\'\').map(s|1).map(e|e)).map(iterable|iterable.size())", "List<Integer>");
  }
  
  @Test
  public void testFeatureCall_15_e_2() throws Exception {
    this.resolvesTo("newArrayList(newArrayList(\'\').map(s|1).map(e|e)).map(iterable|iterable.size()).head", "Integer");
  }
  
  @Test
  public void testFeatureCall_15_f() throws Exception {
    this.resolvesTo("newArrayList(newArrayList(\'\').map(s|1).map(e|e).map(e|e)).map(iterable|iterable.size())", "List<Integer>");
  }
  
  @Test
  public void testFeatureCall_15_f_2() throws Exception {
    this.resolvesTo("newArrayList(newArrayList(\'\').map(s|1).map(e|e).map(e|e)).map(iterable|iterable.size()).head", "Integer");
  }
  
  @Test
  public void testFeatureCall_15_g() throws Exception {
    this.resolvesTo("newArrayList(newArrayList(\'\').map(s|1).map(e|e).map(e|e).map(e|e)).map(iterable|iterable.size())", "List<Integer>");
  }
  
  @Test
  public void testFeatureCall_15_g_2() throws Exception {
    this.resolvesTo("newArrayList(newArrayList(\'\').map(s|1).map(e|e).map(e|e).map(e|e)).map(iterable|iterable.size()).head", "Integer");
  }
  
  @Test
  public void testFeatureCall_15_h() throws Exception {
    this.resolvesTo("newArrayList(newArrayList(\'\').map(s|1).map(e|e).map(e|e).map(e|e).map(e|e)).map(iterable|iterable.size())", "List<Integer>");
  }
  
  @Test
  public void testFeatureCall_15_h_2() throws Exception {
    this.resolvesTo("newArrayList(newArrayList(\'\').map(s|1).map(e|e).map(e|e).map(e|e).map(e|e)).map(iterable|iterable.size()).head", "Integer");
  }
  
  @Test
  public void testFeatureCall_15_i() throws Exception {
    this.resolvesTo("newArrayList(newArrayList(\'\').map(s|1).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)).map(e|e).map(iterable|iterable.size())", "List<Integer>");
  }
  
  @Test
  public void testFeatureCall_15_i_2() throws Exception {
    this.resolvesTo("newArrayList(newArrayList(\'\').map(s|1).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)).map(e|e).map(iterable|iterable.size()).head", "Integer");
  }
  
  @Test
  public void testFeatureCall_15_i_3() throws Exception {
    this.resolvesTo("newArrayList(newArrayList(\'\').map(s|1).map(e|e)).map(iterable|iterable.size()).map(e|e)", "List<Integer>");
  }
  
  @Test
  public void testFeatureCall_15_i_4() throws Exception {
    this.resolvesTo("newArrayList(newArrayList(\'\').map(s|1).map(e|e)).map(iterable|iterable.size()).map(e|e).head", "Integer");
  }
  
  @Test
  public void testFeatureCall_15_j() throws Exception {
    this.resolvesTo("newArrayList(newArrayList(\'\').map(s|1).map(e|e).map(e|e)).map(iterable|iterable.size()).map(e|e).map(e|e)", "List<Integer>");
  }
  
  @Test
  public void testFeatureCall_15_j_2() throws Exception {
    this.resolvesTo("newArrayList(newArrayList(\'\').map(s|1).map(e|e).map(e|e)).map(iterable|iterable.size()).map(e|e).map(e|e).head", "Integer");
  }
  
  @Test
  public void testFeatureCall_15_k() throws Exception {
    this.resolvesTo("newArrayList(newArrayList(\'\').map(s|1).map(e|e).map(e|e).map(e|e)).map(iterable|iterable.size()).map(e|e).map(e|e).map(e|e)", "List<Integer>");
  }
  
  @Test
  public void testFeatureCall_15_k_2() throws Exception {
    this.resolvesTo("newArrayList(newArrayList(\'\').map(s|1).map(e|e).map(e|e).map(e|e)).map(iterable|iterable.size()).map(e|e).map(e|e).map(e|e).head", "Integer");
  }
  
  @Test
  public void testFeatureCall_15_l() throws Exception {
    this.resolvesTo("newArrayList(newArrayList(\'\').map(s|1).map(e|e).map(e|e).map(e|e).map(e|e)).map(iterable|iterable.size()).map(e|e).map(e|e).map(e|e).map(e|e)", "List<Integer>");
  }
  
  @Test
  public void testFeatureCall_15_l_2() throws Exception {
    this.resolvesTo("newArrayList(newArrayList(\'\').map(s|1).map(e|e).map(e|e).map(e|e).map(e|e)).map(iterable|iterable.size()).map(e|e).map(e|e).map(e|e).map(e|e).head", "Integer");
  }
  
  @IgnoredBySmokeTest("Pointless since the scenario is pretty much the same as above")
  @Test
  public void testFeatureCall_15_m() throws Exception {
    this.resolvesTo("newArrayList(newArrayList(\'\').map(String s|1).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)\n\t\t.map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)\n\t\t.map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)\n\t\t.map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)\n\t\t.map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)\n\t\t.map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)\n\t\t.map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)\n\t\t).map(iterable|iterable.size()).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)\n\t\t.map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)\n\t\t.map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)\n\t\t.map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)\n\t\t.map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)\n\t\t.map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)\n\t\t.map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)\n\t\t.map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).head", "Integer");
  }
  
  @Ignore("slightly too slow")
  @Test
  public void testFeatureCall_15_n() throws Exception {
    this.resolvesTo("newArrayList(newArrayList(\'\').map(s|1).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t).map(iterable|iterable.size()).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).head", "Integer");
  }
  
  @Ignore("too slow")
  @Test
  public void testFeatureCall_15_n_1() throws Exception {
    this.resolvesTo("newArrayList(newArrayList(\'\').map(s|1).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n\t\t.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n\t\t.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n\t\t.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n\t\t.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n\t\t.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n\t\t.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n\t\t.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n\t\t.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n\t\t.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n\t\t.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n\t\t.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n\t\t.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n\t\t.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n\t\t.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n\t\t.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n\t\t.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n\t\t.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n\t\t.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n\t\t.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n\t\t.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n\t\t).map(iterable|iterable.size()).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n\t\t.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n\t\t.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n\t\t.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n\t\t.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n\t\t.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n\t\t.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n\t\t.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n\t\t.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n\t\t.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n\t\t.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n\t\t.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n\t\t.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n\t\t.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n\t\t.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n\t\t.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n\t\t.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n\t\t.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n\t\t.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n\t\t.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n\t\t.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e)\n\t\t.map(e|e+e).map(e|e+e).map(e|e+e).map(e|e+e).head", "Integer");
  }
  
  @Ignore("way too slow")
  @Test
  public void testFeatureCall_15_n_2() throws Exception {
    this.resolvesTo("newArrayList(newArrayList(\'\').map(s|1).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n\t\t.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n\t\t.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n\t\t.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n\t\t.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n\t\t.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n\t\t.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n\t\t.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n\t\t.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n\t\t.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n\t\t.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n\t\t.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n\t\t.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n\t\t.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n\t\t.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n\t\t.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n\t\t.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n\t\t.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n\t\t.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n\t\t.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n\t\t.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n\t\t).map(iterable|iterable.size()).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n\t\t.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n\t\t.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n\t\t.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n\t\t.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n\t\t.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n\t\t.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n\t\t.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n\t\t.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n\t\t.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n\t\t.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n\t\t.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n\t\t.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n\t\t.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n\t\t.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n\t\t.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n\t\t.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n\t\t.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n\t\t.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n\t\t.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n\t\t.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e))\n\t\t.map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).map(e|(e+e)+(e+e)).head", "Integer");
  }
  
  @Test
  public void testFeatureCall_15_o() throws Exception {
    this.resolvesTo("newArrayList(newArrayList(\'\')).map(iterable|iterable.size())", "List<Integer>");
  }
  
  @Test
  public void testFeatureCall_15_o_2() throws Exception {
    this.resolvesTo("newArrayList(newArrayList(\'\')).map(iterable|iterable.size()).head", "Integer");
  }
  
  @Test
  public void testFeatureCall_15_p() throws Exception {
    this.resolvesTo("newArrayList(newArrayList(\'\')).map(iterable|iterable.size()).map(e|e)", "List<Integer>");
  }
  
  @Test
  public void testFeatureCall_15_p_2() throws Exception {
    this.resolvesTo("newArrayList(newArrayList(\'\')).map(iterable|iterable.size()).map(e|e).head", "Integer");
  }
  
  @Test
  public void testFeatureCall_16_a() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(s|1).map(i|1)", "List<Integer>");
  }
  
  @Test
  public void testFeatureCall_16_b() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(s|1).map(i|1).head", "Integer");
  }
  
  @Test
  public void testFeatureCall_17_a() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(s|s.length).map(i|i)", "List<Integer>");
  }
  
  @Test
  public void testFeatureCall_17_b() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(s|s.length).map(i|i).head", "Integer");
  }
  
  @Test
  public void testFeatureCall_18_a() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(s|s.length + 1 == 5).map(b|b)", "List<Boolean>");
  }
  
  @Test
  public void testFeatureCall_18_b() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(s|s.length + 1 == 5).map(b|b).head", "Boolean");
  }
  
  @Test
  public void testFeatureCall_19_a() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(s|s.length + 1 == 5).map(b| { \'length\'.length b })", "List<Boolean>");
  }
  
  @Test
  public void testFeatureCall_19_b() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(s|s.length + 1 == 5).map(b| { \'length\'.length b }).head", "Boolean");
  }
  
  @Test
  public void testFeatureCall_20_a() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(s|s.length + 1 == 5).map(Boolean b|!b)", "List<Boolean>");
  }
  
  @Test
  public void testFeatureCall_20_b() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(s|s.length + 1 == 5).map(Boolean b|!b).head", "Boolean");
  }
  
  @Test
  public void testFeatureCall_21_a() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(s|s.length + 1 == 5).map(b| ! b )", "List<Boolean>");
  }
  
  @Test
  public void testFeatureCall_21_b() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(s|s.length + 1 == 5).map(b| ! b ).head", "Boolean");
  }
  
  @Test
  public void testFeatureCall_22_a() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(s|s.length + 1 == 5).map(b| { !b } )", "List<Boolean>");
  }
  
  @Test
  public void testFeatureCall_22_b() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(s|s.length + 1 == 5).map(b| { !b } ).head", "Boolean");
  }
  
  @Test
  public void testFeatureCall_23_a() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(s|s.length + 1 == 5).map(b| { b.operator_not } )", "List<Boolean>");
  }
  
  @Test
  public void testFeatureCall_23_b() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(s|s.length + 1 == 5).map(b| { b.operator_not } ).head", "Boolean");
  }
  
  @Test
  public void testFeatureCall_24_a() throws Exception {
    this.resolvesTo(((("newArrayList(\'\').map(s|" + 
      "$$ObjectExtensions::operator_equals(") + 
      "\t$$IntegerExtensions::operator_plus(s.length,1), 5)") + 
      ").map(b| $$BooleanExtensions::operator_not(b) )"), "List<Boolean>");
  }
  
  @Test
  public void testFeatureCall_24_b() throws Exception {
    this.resolvesTo(((("newArrayList(\'\').map(s|" + 
      "$$ObjectExtensions::operator_equals(") + 
      "\t$$IntegerExtensions::operator_plus(s.length,1), 5)") + 
      ").map(b| $$BooleanExtensions::operator_not(b) ).head"), "Boolean");
  }
  
  @Test
  public void testFeatureCall_25_a() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(s|s.length + 1 * 5).map(b| b / 5 )", "List<Integer>");
  }
  
  @IgnoredBySmokeTest("Same as testFeatureCall_25_a")
  @Test
  public void testFeatureCall_25_b() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(s|s.length + 1 * 5).map(b| b / 5 ).head", "Integer");
  }
  
  @IgnoredBySmokeTest("Same as testFeatureCall_25_a")
  @Test
  public void testFeatureCall_25_c() throws Exception {
    this.resolvesTo("newArrayList(\'\').map[ length + 1 * 5 ].map [ it / 5 ].head", "Integer");
  }
  
  @IgnoredBySmokeTest("Same as testFeatureCall_25_a")
  @Test
  public void testFeatureCall_25_d() throws Exception {
    this.resolvesTo("newArrayList(\'\').map[ length + 1 * 5 - length + 1 * 5 ].map [ it / 5 + 1 / it ].head", "Integer");
  }
  
  @Test
  public void testFeatureCall_26() throws Exception {
    this.resolvesTo("{ val list = newArrayList(if (false) new Double(\'-20\') else new Integer(\'20\')).map(v|v.intValue)\n           val Object o = list.head \n           list\n        }", "List<Integer>");
  }
  
  @Test
  public void testFeatureCall_26a() throws Exception {
    this.resolvesTo("{ val list = newArrayList(if (false) new Double(\'-20\') else new Integer(\'20\')).map(v|v.intValue)\n           val Object o = list.head \n           list.head\n        }", "Integer");
  }
  
  @Test
  public void testFeatureCall_26b() throws Exception {
    this.resolvesTo("{ val list = newArrayList(if (false) new Double(\'-20\') else new Integer(\'20\')).map(v|v.compareTo(null))\n           val Object o = list.head \n           list.head\n        }", "Integer");
  }
  
  @Test
  public void testFeatureCall_27() throws Exception {
    this.resolvesTo("{ val list = $$ListExtensions::map(newArrayList(if (false) new Double(\'-20\') else new Integer(\'20\'))) [ v|v.intValue ]\n           val Object o = list.head \n           list\n        }", "List<Integer>");
  }
  
  @Test
  public void testFeatureCall_28() throws Exception {
    this.resolvesTo("{ val list = $$ListExtensions::map(newArrayList(null as Integer)) [ v|v.intValue ]\n           val Object o = list.head \n           list\n        }", "List<Integer>");
  }
  
  @Test
  public void testFeatureCall_30() throws Exception {
    this.resolvesTo("{ val list = newArrayList(null as Integer).map [ v|v.intValue ]\n           val Object o = list.head \n           list\n        }", "List<Integer>");
  }
  
  @Test
  public void testFeatureCall_31() throws Exception {
    this.resolvesTo("{ val list = newArrayList(null as Integer).map [ v|v.intValue ]\n           val Object o = list.head \n           list.findFirst [ intValue == 0 ]\n        }", "Integer");
  }
  
  @Test
  public void testFeatureCall_32() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tlist.forEach[String s | s]\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testFeatureCall_33() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tlist.findFirst[String s | true]\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testFeatureCall_34() throws Exception {
    this.resolvesTo("newArrayList.map[String s | s.substring(1,1) ]", "List<String>");
  }
  
  @Test
  public void testFeatureCall_35() throws Exception {
    this.resolvesTo("newArrayList.map[ s | s.toString ]", "List<String>");
  }
  
  @Test
  public void testFeatureCall_36() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tlist.forEach[ s | s.toString ]\n\t\t\tlist\n\t\t}", "ArrayList<Object>");
  }
  
  @Test
  public void testFeatureCall_37() throws Exception {
    this.resolvesTo("java::util::Arrays::asList(\'\', \'\', \'\').map(s | s.length()).fold(0) [ l, r | if (l > r) l else r]", "Integer");
  }
  
  @Test
  public void testFeatureCall_38() throws Exception {
    this.resolvesTo("(null as Iterable<Integer>).fold(0) [ l, r | if (l > r) l else r]", "Integer");
  }
  
  @Test
  public void testFeatureCall_39() throws Exception {
    this.resolvesTo("new testdata.ArrayClient().toStringArray(\'a\', \'b\').filter(e|e!=null)", "Iterable<String>");
  }
  
  @Test
  public void testFeatureCall_40() throws Exception {
    this.resolvesTo("new testdata.ArrayClient().toStringArray(\'a\', \'b\').map[ it ]", "List<String>");
  }
  
  @Test
  public void testFeatureCall_41() throws Exception {
    this.resolvesTo("new testdata.ArrayClient().toStringArray(\'a\', \'b\')", "String[]");
  }
  
  @Test
  public void testFeatureCall_42() throws Exception {
    this.resolvesTo("new testdata.ArrayClient().toStringArray(\'a\', \'b\').head", "String");
  }
  
  @Test
  public void testToList_01() throws Exception {
    this.resolvesTo("{ val Iterable<? extends String> iter = null org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::fixedToList(iter) }", "List<? extends String>");
  }
  
  @Test
  public void testToList_02() throws Exception {
    this.resolvesTo("{ val Iterable<? super String> iter = null org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::fixedToList(iter) }", "List<? super String>");
  }
  
  @Test
  public void testToList_03() throws Exception {
    this.resolvesTo("{ val Iterable<String> iter = null org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::fixedToList(iter) }", "List<String>");
  }
  
  @Test
  public void testToList_04() throws Exception {
    this.resolvesTo("{ val Iterable<? extends String> iter = null org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::brokenToList(iter) }", "List<String>");
  }
  
  @Test
  public void testToList_05() throws Exception {
    this.resolvesTo("{ val Iterable<? super String> iter = null org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::brokenToList(iter) }", "List<Object>");
  }
  
  @Test
  public void testToList_06() throws Exception {
    this.resolvesTo("{ val Iterable<String> iter = null org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::brokenToList(iter) }", "List<String>");
  }
  
  @Test
  public void testToList_07() throws Exception {
    this.resolvesTo("{ val Iterable<? extends String> iter = null org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::brokenToList2(iter) }", "List<String>");
  }
  
  @Test
  public void testToList_08() throws Exception {
    this.resolvesTo("{ val Iterable<? super String> iter = null org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::brokenToList2(iter) }", "List<String>");
  }
  
  @Test
  public void testToList_09() throws Exception {
    this.resolvesTo("{ val Iterable<String> iter = null org::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::brokenToList2(iter) }", "List<String>");
  }
  
  @Test
  public void testFeatureCall_Bug342134_00() throws Exception {
    this.resolvesTo("(null as java.util.List<String>).map(e|newArrayList(e)).flatten", "Iterable<String>");
  }
  
  @Test
  public void testFeatureCall_Bug342134_01() throws Exception {
    this.resolvesTo("(null as java.util.List<String>).map(e|newArrayList(e)).flatten.head", "String");
  }
  
  @Test
  public void testFeatureCall_Bug342134_02() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(e|newArrayList(e)).flatten", "Iterable<String>");
  }
  
  @Test
  public void testFeatureCall_Bug342134_03() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(e|newArrayList(e)).flatten.head", "String");
  }
  
  @Test
  public void testFeatureCall_Bug342134_04() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(e|newArrayList(e))", "List<ArrayList<String>>");
  }
  
  @Test
  public void testFeatureCall_Bug342134_05() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(e|newArrayList(e)).head", "ArrayList<String>");
  }
  
  @Test
  public void testFeatureCall_Bug342134_06() throws Exception {
    this.resolvesTo("<String>newArrayList.map(e|newArrayList(e)).flatten", "Iterable<String>");
  }
  
  @Test
  public void testFeatureCall_Bug342134_07() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(e|<String>newArrayList(e)).flatten", "Iterable<String>");
  }
  
  @Test
  public void testFeatureCall_Bug342134_08() throws Exception {
    this.resolvesTo("newArrayList.map(String e|<String>newArrayList(e)).flatten", "Iterable<String>");
  }
  
  @Test
  public void testFeatureCall_Bug342134_09() throws Exception {
    this.resolvesTo("newArrayList(newArrayList(\'\')).flatten", "Iterable<String>");
  }
  
  @Test
  public void testFeatureCall_Bug342134_10() throws Exception {
    this.resolvesTo("<java.util.List<String>>newArrayList().flatten", "Iterable<String>");
  }
  
  @Test
  public void testBug_389512() throws Exception {
    this.resolvesTo("{\n\t\t\tval Object it = null\n\t\t\t^class.declaredFields.toMap[name].mapValues[get(it)]\n\t\t}", "Map<String, Object>");
  }
  
  @Test
  public void testBug_391758() throws Exception {
    this.resolvesTo("{\n\t\t\tval iterable = newArrayList\n\t\t\titerable.fold(newArrayList) [ list , elem | null as java.util.List<String> ]\n\t\t}", "List<String>");
  }
  
  @Test
  public void testBug_381466_01() throws Exception {
    this.resolvesTo("{\n            val map = com::google::common::collect::HashMultimap::create\n            val com.google.common.collect.HashMultimap<String, Integer> stringToInts = null\n            stringToInts.putAll(map)\n            map\n        }", "HashMultimap<String, Integer>");
  }
  
  @Test
  public void testBug_381466_02() throws Exception {
    this.resolvesTo("{\n            val map = com::google::common::collect::HashMultimap::create\n            val java.util.Map<String, java.util.Collection<Integer>> stringToInts = null\n            stringToInts.putAll(map.asMap)\n            map\n        }", "HashMultimap<String, Integer>");
  }
  
  @Test
  public void testBug_381466_03() throws Exception {
    this.resolvesTo("{\n            val map = com::google::common::collect::HashMultimap::create\n            val java.util.Map<String, Iterable<Integer>> stringToInts = null\n            stringToInts.putAll(map.asMap)\n            map\n        }", "HashMultimap<String, Integer>");
  }
  
  @Test
  public void testBug_381466_04() throws Exception {
    this.resolvesTo("{\n            val map = com::google::common::collect::HashMultimap::create\n            val stringToInts = newHashMap\n            stringToInts.keySet.addAll(map.asMap.keySet)\n            stringToInts.values.add(map.values.head)\n            stringToInts.put(\'\', 1)\n            map\n        }", "HashMultimap<String, Integer>");
  }
  
  @Test
  public void testBounds_01() throws Exception {
    this.resolvesTo("{ var java.util.List<Integer> list = null list.get(0) }", "Integer");
  }
  
  @Test
  public void testBounds_02() throws Exception {
    this.resolvesTo("{ var java.util.List<? extends Integer> list = null list.get(0) }", "Integer");
  }
  
  @Test
  public void testBounds_03() throws Exception {
    this.resolvesTo("{ var java.util.List<? super Integer> list = null list.get(0) }", "Object");
  }
  
  @Test
  public void testBounds_04() throws Exception {
    this.resolvesTo("{ var java.util.List<Integer> list = null list.subList(0, 1) }", "List<Integer>");
  }
  
  @Test
  public void testBounds_05() throws Exception {
    this.resolvesTo("{ var java.util.List<? extends Integer> list = null list.subList(0, 1) }", "List<? extends Integer>");
  }
  
  @Test
  public void testBounds_06() throws Exception {
    this.resolvesTo("{ var java.util.List<? super Integer> list = null list.subList(0, 1) }", "List<? super Integer>");
  }
  
  @Test
  public void testBounds_07() throws Exception {
    this.resolvesTo("{ var java.util.List<Integer> list = null list.last }", "Integer");
  }
  
  @Test
  public void testBounds_08() throws Exception {
    this.resolvesTo("{ var java.util.List<? extends Integer> list = null list.last }", "Integer");
  }
  
  @Test
  public void testBounds_09() throws Exception {
    this.resolvesTo("{ var java.util.List<? super Integer> list = null list.last }", "Object");
  }
  
  @Test
  public void testBounds_10() throws Exception {
    this.resolvesTo("{ var java.util.List<Iterable<Integer>> list = null list.last }", "Iterable<Integer>");
  }
  
  @Test
  public void testBounds_11() throws Exception {
    this.resolvesTo("{ var java.util.List<Iterable<Integer>> list = null list.last.last }", "Integer");
  }
  
  @Test
  public void testBounds_12() throws Exception {
    this.resolvesTo("{ var java.util.List<? extends Iterable<Integer>> list = null list.last }", "Iterable<Integer>");
  }
  
  @Test
  public void testBounds_13() throws Exception {
    this.resolvesTo("{ var java.util.List<? extends Iterable<Integer>> list = null list.last.last }", "Integer");
  }
  
  @Test
  public void testBounds_14() throws Exception {
    this.resolvesTo("{ var java.util.List<Iterable<? extends Integer>> list = null list.last }", "Iterable<? extends Integer>");
  }
  
  @Test
  public void testBounds_15() throws Exception {
    this.resolvesTo("{ var java.util.List<Iterable<? extends Integer>> list = null list.last.last }", "Integer");
  }
  
  @Test
  public void testBounds_16() throws Exception {
    this.resolvesTo("{ var java.util.List<? extends Iterable<? extends Integer>> list = null list.last }", "Iterable<? extends Integer>");
  }
  
  @Test
  public void testBounds_17() throws Exception {
    this.resolvesTo("{ var java.util.List<? extends Iterable<? extends Integer>> list = null list.last.last }", "Integer");
  }
  
  @Test
  public void testBounds_18() throws Exception {
    this.resolvesTo("{ var java.util.List<Iterable<? super Integer>> list = null list.last }", "Iterable<? super Integer>");
  }
  
  @Test
  public void testBounds_19() throws Exception {
    this.resolvesTo("{ var java.util.List<Iterable<? super Integer>> list = null list.last.last }", "Object");
  }
  
  @Test
  public void testBounds_20() throws Exception {
    this.resolvesTo("{ var java.util.List<? extends Iterable<? super Integer>> list = null list.last }", "Iterable<? super Integer>");
  }
  
  @Test
  public void testBounds_21() throws Exception {
    this.resolvesTo("{ var java.util.List<? extends Iterable<? super Integer>> list = null list.last.last }", "Object");
  }
  
  @Test
  public void testBounds_22() throws Exception {
    this.resolvesTo("(null as com.google.inject.Provider<? extends String>).get", "String");
  }
  
  @Test
  public void testBounds_23() throws Exception {
    this.resolvesTo("(null as com.google.inject.Provider<? extends Iterable<String>[]>).get", "Iterable<String>[]");
  }
  
  @Test
  public void testBounds_24() throws Exception {
    this.resolvesTo("new testdata.ClosureClient().useProvider(null as com.google.inject.Provider<? extends Iterable<String>[]>)", "Iterable<String>[]");
  }
  
  @Test
  public void testBounds_25() throws Exception {
    this.resolvesTo("new testdata.ClosureClient().useProvider(null as com.google.inject.Provider<? extends String>)", "String");
  }
  
  @Test
  public void testBounds_26() throws Exception {
    this.resolvesTo("new testdata.ClosureClient().useProvider(null as =>Iterable<String>[])", "Iterable<String>[]");
  }
  
  @Test
  public void testBounds_27() throws Exception {
    this.resolvesTo("new testdata.ClosureClient().useProvider(null as =>String)", "String");
  }
  
  @Test
  public void testImplicitReceiverBounds_01() throws Exception {
    this.resolvesTo("{ var java.util.List<Integer> it = null get(0) }", "Integer");
  }
  
  @Test
  public void testImplicitReceiverBounds_02() throws Exception {
    this.resolvesTo("{ var java.util.List<? extends Integer> it = null get(0) }", "Integer");
  }
  
  @Test
  public void testImplicitReceiverBounds_03() throws Exception {
    this.resolvesTo("{ var java.util.List<? super Integer> it = null get(0) }", "Object");
  }
  
  @Test
  public void testImplicitReceiverBounds_04() throws Exception {
    this.resolvesTo("{ var java.util.List<Integer> it = null subList(0, 1) }", "List<Integer>");
  }
  
  @Test
  public void testImplicitReceiverBounds_05() throws Exception {
    this.resolvesTo("{ var java.util.List<? extends Integer> it = null subList(0, 1) }", "List<? extends Integer>");
  }
  
  @Test
  public void testImplicitReceiverBounds_06() throws Exception {
    this.resolvesTo("{ var java.util.List<? super Integer> it = null subList(0, 1) }", "List<? super Integer>");
  }
  
  @Test
  public void testImplicitReceiverBounds_07() throws Exception {
    this.resolvesTo("{ var java.util.List<Integer> it = null last }", "Integer");
  }
  
  @Test
  public void testImplicitReceiverBounds_08() throws Exception {
    this.resolvesTo("{ var java.util.List<? extends Integer> it = null last }", "Integer");
  }
  
  @Test
  public void testImplicitReceiverBounds_09() throws Exception {
    this.resolvesTo("{ var java.util.List<? super Integer> it = null last }", "Object");
  }
  
  @Test
  public void testPropertyAccess_01() throws Exception {
    this.resolvesTo("{ var java.util.List<Integer> it = null empty }", "boolean");
  }
  
  @Test
  public void testPropertyAccess_02() throws Exception {
    this.resolvesTo("{ var java.util.List<Integer> list = null list.empty }", "boolean");
  }
  
  @Test
  public void testPropertyAccess_03() throws Exception {
    this.resolvesTo("{ var Iterable<Integer> iterable = null iterable.empty }", "boolean");
  }
  
  @Test
  public void testPropertyAccess_04() throws Exception {
    this.resolvesTo("{ var Iterable<Integer> it = null empty }", "boolean");
  }
  
  @Test
  public void testPropertyAccess_05() throws Exception {
    this.resolvesTo("{ var Iterable<Integer> iterable = null iterable.class }", "Class<? extends Iterable>");
  }
  
  @Test
  public void testPropertyAccess_06() throws Exception {
    this.resolvesTo("{ var Iterable<Integer> it = null class }", "Class<? extends Iterable>");
  }
  
  @Test
  public void testReceiverIsPartiallyResolved_01() throws Exception {
    this.resolvesTo("newArrayList.get(0)", "Object");
  }
  
  @Test
  public void testReceiverIsPartiallyResolved_02() throws Exception {
    this.resolvesTo("newArrayList.toString", "String");
  }
  
  @Test
  public void testTypeByTransitiveExpectation_01() throws Exception {
    this.resolvesTo("newArrayList.flatten.toList.flatten.head", "Object");
  }
  
  @Test
  public void testTypeByTransitiveExpectation_02() throws Exception {
    this.resolvesTo("newArrayList.subList(1,1).subList(1,1).head", "Object");
  }
  
  @Test
  public void testTypeByTransitiveExpectation_03() throws Exception {
    this.resolvesTo("newArrayList.flatten.toList.<Number>flatten.head", "Number");
  }
  
  @Test
  public void testTypeByTransitiveExpectation_04() throws Exception {
    this.resolvesTo("newArrayList.<java.util.Set<Number>>flatten.toList.flatten.head", "Number");
  }
  
  @Test
  public void testTypeByTransitiveExpectation_05() throws Exception {
    this.resolvesTo("newArrayList.flatten.<java.util.Set<Number>>toList.flatten.head", "Number");
  }
  
  @Test
  public void testTypeByTransitiveExpectation_06() throws Exception {
    this.resolvesTo("newArrayList.flatten.toList.flatten.<Number>head", "Number");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_001() throws Exception {
    this.resolvesTo("newArrayList", "ArrayList<Object>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_002() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval String s = list.get(0)\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_003() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval String s = list.head\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_004() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tlist.add(\'\')\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_005() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\t$$CollectionExtensions::addAll(list, null as java.util.ArrayList<String>)\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_006() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\t$$CollectionExtensions::addAll(list, \'\', \'\')\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_007() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tlist.addAll(null as java.util.ArrayList<String>)\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_008() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\t$$CollectionExtensions::addAll(list, null as java.util.ArrayList<String>)\n\t\t\tlist.head\n\t\t}", "String");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_009() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tlist.addAll(newHashSet(\'\'))\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_010() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tlist.addAll(null as java.util.Collection<String>)\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_011() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tlist.addAll(\'\', \'\', \'\')\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_012() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval secondList = newArrayList\n\t\t\tlist.add(\'\')\n\t\t\tlist.addAll(secondList)\n\t\t\tsecondList\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_013() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval secondList = newArrayList\n\t\t\tlist.addAll(secondList)\n\t\t\tlist.add(\'\')\n\t\t\tsecondList\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_014() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval Iterable<String> sublist = list.subList(1, 1)\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_015() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval java.util.Set<String> sublist = list.subList(1, 1)\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_016() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval java.util.Iterator<String> sublist = list.subList(1, 1).iterator\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_017() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tfor(String s: list.subList(1, 1)) {}\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_018() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tlist.add(new Integer(0))\n\t\t\tlist.add(new Integer(0).doubleValue)\n\t\t\tlist\n\t\t}", "ArrayList<Number & Comparable<?>>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_019() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tlist.add(new Integer(0))\n\t\t\tlist.get(0).toString\n\t\t\tlist.add(new Integer(0).doubleValue)\n\t\t\tlist\n\t\t}", "ArrayList<Integer>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_020() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval second = newArrayList\n\t\t\tlist.add(second.get(0))\n\t\t\tlist.add(\'\')\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_021() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval second = newArrayList\n\t\t\tlist.add(second.get(0))\n\t\t\tlist.add(\'\')\n\t\t\tsecond\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_022() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval second = newArrayList\n\t\t\tlist.add(second.head)\n\t\t\tlist.add(\'\')\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_023() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval second = newArrayList\n\t\t\tlist.add(second.head)\n\t\t\tlist.add(\'\')\n\t\t\tsecond\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_024() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval second = newArrayList\n\t\t\tlist.add(\'\')\n\t\t\tlist.add(second.get(0))\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_025() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval second = newArrayList\n\t\t\tlist.add(\'\')\n\t\t\tlist.add(second.get(0))\n\t\t\tsecond\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_026() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval second = newArrayList\n\t\t\tlist.add(\'\')\n\t\t\tlist.add(second.head)\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_027() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval second = newArrayList\n\t\t\tlist.add(\'\')\n\t\t\tlist.add(second.head)\n\t\t\tsecond\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_028() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval second = newArrayList\n\t\t\tlist.add(second.get(0))\n\t\t\tsecond.add(\'\')\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_029() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval second = newArrayList\n\t\t\tlist.add(second.get(0))\n\t\t\tsecond.add(\'\')\n\t\t\tsecond\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_030() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval second = newArrayList\n\t\t\tlist.add(second.head)\n\t\t\tsecond.add(\'\')\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_031() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval second = newArrayList\n\t\t\tlist.add(second.head)\n\t\t\tsecond.add(\'\')\n\t\t\tsecond\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_032() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval second = newArrayList\n\t\t\tsecond.add(\'\')\n\t\t\tlist.add(second.get(0))\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_033() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval second = newArrayList\n\t\t\tsecond.add(\'\')\n\t\t\tlist.add(second.get(0))\n\t\t\tsecond\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_034() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval second = newArrayList\n\t\t\tsecond.add(\'\')\n\t\t\tlist.add(second.head)\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_035() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval second = newArrayList\n\t\t\tsecond.add(\'\')\n\t\t\tlist.add(second.head)\n\t\t\tsecond\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_036() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList(newArrayList)\n\t\t\tval Iterable<String> s = list.head\n\t\t\tlist.head\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_037() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList(newArrayList)\n\t\t\tval Iterable<String> s = list.flatten\n\t\t\tlist.head\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_038() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList(newHashSet)\n\t\t\tval String s = list.flatten.head\n\t\t\tlist.head\n\t\t}", "HashSet<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_039() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList(newArrayList)\n\t\t\tval String s = list.flatten.head\n\t\t\tlist.head\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_040() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval second = newArrayList(newArrayList)\n\t\t\tval String s = second.flatten.head\n\t\t\tlist.add(second.head)\n\t\t\tlist.head\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_041() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tlist.addAll(\'\')\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_042() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval secondList = newArrayList\n\t\t\tlist.addAll(\'\')\n\t\t\tlist.addAll(secondList)\n\t\t\tsecondList\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_043() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval secondList = newArrayList\n\t\t\tlist.addAll(secondList)\n\t\t\tlist.addAll(\'\')\n\t\t\tsecondList\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_044() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tlist.addAll(\'\', \'\', \'\')\n\t\t\tlist.head\n\t\t}", "String");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_045() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval secondList = newArrayList\n\t\t\tlist.addAll(\'\', \'\', \'\')\n\t\t\tlist.addAll(secondList)\n\t\t\tsecondList\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_046() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval secondList = newArrayList\n\t\t\tlist.addAll(secondList)\n\t\t\tlist.addAll(\'\', \'\', \'\')\n\t\t\tsecondList\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_047() throws Exception {
    this.resolvesTo("println(newArrayList)", "ArrayList<Object>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_048() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval String s = println(list.get(0))\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_049() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval String s = println(println(list).head)\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_050() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tprintln(list).add(\'\')\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_051() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\t$$CollectionExtensions::addAll(println(list), null as java.util.ArrayList<String>)\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_052() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\t$$CollectionExtensions::addAll(println(list), println(\'\'), println(\'\'))\n\t\t\tlist.head\n\t\t}", "String");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_053() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tprintln(list).addAll(null as java.util.ArrayList<String>)\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_054() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tprintln(list).addAll(println(newArrayList(\'\')))\n\t\t\tprintln(list)\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_055() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = println(newArrayList)\n\t\t\tprintln(list).addAll(println(newHashSet(\'\')))\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_056() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = println(newArrayList)\n\t\t\tprintln(list).addAll(null as java.util.Collection<String>)\n\t\t\tprintln(list)\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_057() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tprintln(list).addAll(\'\', \'\', \'\')\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_058() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = println(newArrayList)\n\t\t\tval secondList = println(newArrayList)\n\t\t\tprintln(list).add(\'\')\n\t\t\tprintln(list).addAll(println(secondList))\n\t\t\tsecondList\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_059() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = println(newArrayList)\n\t\t\tval secondList = println(newArrayList)\n\t\t\tprintln(list).addAll(println(secondList))\n\t\t\tprintln(list).add(\'\')\n\t\t\tprintln(secondList)\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_060() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval Iterable<String> sublist = println(println(list).subList(1, 1))\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_061() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval java.util.Set<String> sublist = println(println(list).subList(1, 1))\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_062() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval java.util.Iterator<String> sublist = println(println(println(list).subList(1, 1)).iterator)\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_063() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = println(newArrayList)\n\t\t\tfor(String s: println(list.subList(1, 1))) {}\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_064() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tlist.add(println(new Integer(0)))\n\t\t\tlist.add(println(new Integer(0).doubleValue))\n\t\t\tlist\n\t\t}", "ArrayList<Number & Comparable<?>>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_065() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tlist.add(println(new Integer(0)))\n\t\t\tprintln(list.get(0)).toString\n\t\t\tlist.add(println(new Integer(0).doubleValue))\n\t\t\tlist\n\t\t}", "ArrayList<Integer>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_066() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval second = newArrayList\n\t\t\tprintln(list).add(println(second.get(0)))\n\t\t\tprintln(list).add(\'\')\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_067() throws Exception {
    this.resolvesTo("new java.util.ArrayList", "ArrayList<Object>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_068() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval String s = list.get(0)\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_069() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval String s = list.head\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_070() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.add(\'\')\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_071() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\t$$CollectionExtensions::addAll(list, null as java.util.ArrayList<String>)\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_072() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\t$$CollectionExtensions::addAll(list, \'\', \'\')\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_073() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.addAll(null as java.util.ArrayList<String>)\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_074() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.addAll(new java.util.ArrayList<String>)\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_075() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.addAll(newHashSet(\'\'))\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_076() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.addAll(null as java.util.Collection<String>)\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_077() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.addAll(\'\', \'\', \'\')\n\t\t\tlist.head\n\t\t}", "String");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_078() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval secondList = new java.util.ArrayList\n\t\t\tlist.add(\'\')\n\t\t\tlist.addAll(secondList)\n\t\t\tsecondList\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_079() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval secondList = new java.util.ArrayList\n\t\t\tlist.addAll(secondList)\n\t\t\tlist.add(\'\')\n\t\t\tsecondList\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_080() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval Iterable<String> sublist = list.subList(1, 1)\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_081() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval java.util.Set<String> sublist = list.subList(1, 1)\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_082() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval java.util.Iterator<String> sublist = list.subList(1, 1).iterator\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_083() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tfor(String s: list.subList(1, 1)) {}\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_084() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.add(new Integer(0))\n\t\t\tlist.add(new Integer(0).doubleValue)\n\t\t\tlist\n\t\t}", "ArrayList<Number & Comparable<?>>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_085() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.add(new Integer(0))\n\t\t\tlist.get(0).toString\n\t\t\tlist.add(new Integer(0).doubleValue)\n\t\t\tlist\n\t\t}", "ArrayList<Integer>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_086() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval second = new java.util.ArrayList\n\t\t\tlist.add(second.get(0))\n\t\t\tlist.add(\'\')\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_087() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval second = new java.util.ArrayList\n\t\t\tlist.add(second.get(0))\n\t\t\tlist.add(\'\')\n\t\t\tsecond\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_088() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval second = new java.util.ArrayList\n\t\t\tlist.add(second.head)\n\t\t\tlist.add(\'\')\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_089() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval second = new java.util.ArrayList\n\t\t\tlist.add(second.head)\n\t\t\tlist.add(\'\')\n\t\t\tsecond\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_090() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval second = new java.util.ArrayList\n\t\t\tlist.add(\'\')\n\t\t\tlist.add(second.get(0))\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_091() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval second = new java.util.ArrayList\n\t\t\tlist.add(\'\')\n\t\t\tlist.add(second.get(0))\n\t\t\tsecond\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_092() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval second = new java.util.ArrayList\n\t\t\tlist.add(\'\')\n\t\t\tlist.add(second.head)\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_093() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval second = new java.util.ArrayList\n\t\t\tlist.add(\'\')\n\t\t\tlist.add(second.head)\n\t\t\tsecond\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_094() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval second = new java.util.ArrayList\n\t\t\tlist.add(second.get(0))\n\t\t\tsecond.add(\'\')\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_095() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval second = new java.util.ArrayList\n\t\t\tlist.add(second.get(0))\n\t\t\tsecond.add(\'\')\n\t\t\tsecond\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_096() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval second = new java.util.ArrayList\n\t\t\tlist.add(second.head)\n\t\t\tsecond.add(\'\')\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_097() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval second = new java.util.ArrayList\n\t\t\tlist.add(second.head)\n\t\t\tsecond.add(\'\')\n\t\t\tsecond\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_098() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval second = new java.util.ArrayList\n\t\t\tsecond.add(\'\')\n\t\t\tlist.add(second.get(0))\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_099() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval second = new java.util.ArrayList\n\t\t\tsecond.add(\'\')\n\t\t\tlist.add(second.get(0))\n\t\t\tsecond\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_100() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval second = new java.util.ArrayList\n\t\t\tsecond.add(\'\')\n\t\t\tlist.add(second.head)\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_101() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval second = new java.util.ArrayList\n\t\t\tsecond.add(\'\')\n\t\t\tlist.add(second.head)\n\t\t\tsecond\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_102() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.add(new java.util.HashSet)\n\t\t\tval Iterable<String> s = list.head\n\t\t\tlist.head\n\t\t}", "HashSet<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_103() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.add(new java.util.ArrayList)\n\t\t\tval Iterable<String> s = list.flatten\n\t\t\tlist.head\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_104() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.add(newHashSet)\n\t\t\tval String s = list.flatten.head\n\t\t\tlist.head\n\t\t}", "HashSet<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_105() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.add(new java.util.ArrayList)\n\t\t\tval String s = list.flatten.head\n\t\t\tlist.head\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_106() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval second = new java.util.ArrayList\n\t\t\tsecond.add(new java.util.ArrayList)\n\t\t\tval String s = second.flatten.head\n\t\t\tlist.add(second.head)\n\t\t\tlist.head\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_107() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.addAll(\'\')\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_108() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval secondList = new java.util.ArrayList\n\t\t\tlist.addAll(\'\')\n\t\t\tlist.addAll(secondList)\n\t\t\tsecondList\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_109() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval secondList = new java.util.ArrayList\n\t\t\tlist.addAll(secondList)\n\t\t\tlist.addAll(\'\')\n\t\t\tsecondList\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_110() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.addAll(\'\', \'\', \'\')\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_111() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval secondList = new java.util.ArrayList\n\t\t\tlist.addAll(\'\', \'\', \'\')\n\t\t\tlist.addAll(secondList)\n\t\t\tsecondList\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_112() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval secondList = new java.util.ArrayList\n\t\t\tlist.addAll(secondList)\n\t\t\tlist.addAll(\'\', \'\', \'\')\n\t\t\tsecondList\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_113() throws Exception {
    this.resolvesTo("println(new java.util.ArrayList)", "ArrayList<Object>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_114() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval String s = println(list.get(0))\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_115() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval String s = println(println(list).head)\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_116() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tprintln(list).add(\'\')\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_117() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\t$$CollectionExtensions::addAll(println(list), null as java.util.ArrayList<String>)\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_118() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\t$$CollectionExtensions::addAll(println(list), println(\'\'), println(\'\'))\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_119() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tprintln(list).addAll(null as java.util.ArrayList<String>)\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_120() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tprintln(list).addAll(println(new java.util.ArrayList<String>))\n\t\t\tprintln(list)\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_121() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = println(new java.util.ArrayList)\n\t\t\tprintln(list).addAll(println(newHashSet(\'\')))\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_122() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = println(new java.util.ArrayList)\n\t\t\tprintln(list).addAll(null as java.util.Collection<String>)\n\t\t\tprintln(list)\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_123() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tprintln(list).addAll(\'\', \'\', \'\')\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_124() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = println(new java.util.ArrayList)\n\t\t\tval secondList = println(new java.util.ArrayList)\n\t\t\tprintln(list).add(\'\')\n\t\t\tprintln(list).addAll(println(secondList))\n\t\t\tsecondList\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_125() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = println(new java.util.ArrayList)\n\t\t\tval secondList = println(new java.util.ArrayList)\n\t\t\tprintln(list).addAll(println(secondList))\n\t\t\tprintln(list).add(\'\')\n\t\t\tprintln(secondList)\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_126() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval Iterable<String> sublist = println(println(list).subList(1, 1))\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_127() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval java.util.Set<String> sublist = println(println(list).subList(1, 1))\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_128() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval java.util.Iterator<String> sublist = println(println(println(list).subList(1, 1)).iterator)\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_129() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = println(new java.util.ArrayList)\n\t\t\tfor(String s: println(list.subList(1, 1))) {}\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_130() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.add(println(new Integer(0)))\n\t\t\tlist.add(println(new Integer(0).doubleValue))\n\t\t\tlist\n\t\t}", "ArrayList<Number & Comparable<?>>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_131() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.add(println(new Integer(0)))\n\t\t\tprintln(list.get(0)).toString\n\t\t\tlist.add(println(new Integer(0).doubleValue))\n\t\t\tlist\n\t\t}", "ArrayList<Integer>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_132() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval second = new java.util.ArrayList\n\t\t\tprintln(list).add(println(second.get(0)))\n\t\t\tprintln(list).add(\'\')\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_133() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval fun = [String s| s]\n\t\t\tlist.map(fun)\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_134() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.map[String s| s]\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_135() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tlist.add(newArrayList)\n\t\t\tval Iterable<String> s = list.head\n\t\t\tlist.head\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_136() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.add(new java.util.ArrayList)\n\t\t\tval Iterable<String> s = list.head\n\t\t\tlist.head\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_137() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\t$$CollectionExtensions::<String>addAll(println(list), null, null)\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_138() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\t$$CollectionExtensions::<String>addAll(list, null, null)\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_139() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\t$$CollectionExtensions::<String>addAll(println(list), \'\', \'\')\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_140() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\t$$CollectionExtensions::addAll(println(list), println(\'\'), println(\'\'))\n\t\t\tprintln(list)\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_141() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\t$$CollectionExtensions::addAll(list, println(\'\'), println(\'\'))\n\t\t\tprintln(list).head\n\t\t}", "String");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_142() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\t$$CollectionExtensions::addAll(println(list), println(\'\'), println(\'\'))\n\t\t\tprintln(println(println(list)).head)\n\t\t}", "String");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_143() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.add(new java.util.ArrayList)\n\t\t\tval Iterable<String> s = $$IterableExtensions::head(list)\n\t\t\tlist.head\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_144() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.add(new java.util.ArrayList)\n\t\t\tval Iterable<String> s = list.head.head\n\t\t\tlist.head\n\t\t}", "ArrayList<Iterable<String>>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_145() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.add(new java.util.ArrayList)\n\t\t\tval Iterable<String> s = list.head.flatten.head\n\t\t\tlist.head\n\t\t}", "ArrayList<Iterable<? extends Iterable<String>>>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_146() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.add(new java.util.ArrayList)\n\t\t\tval String s = list.head.head\n\t\t\tlist.head\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_147() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.add(new java.util.ArrayList)\n\t\t\tval String s = list.head.flatten.head\n\t\t\tlist.head\n\t\t}", "ArrayList<Iterable<? extends String>>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_148() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.add(new java.util.ArrayList)\n\t\t\tval Iterable<String> s = $$IterableExtensions::flatten(list)\n\t\t\tlist.head\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_149() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.add(newHashSet)\n\t\t\tval String s = $$IterableExtensions::flatten(list).head\n\t\t\tlist.head\n\t\t}", "HashSet<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_150() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.add(new java.util.ArrayList)\n\t\t\tval String s = $$IterableExtensions::flatten(list).head\n\t\t\tlist.head\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_151() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval second = new java.util.ArrayList\n\t\t\tsecond.add(new java.util.ArrayList)\n\t\t\tval String s = $$IterableExtensions::flatten(second).head\n\t\t\tlist.add(second.head)\n\t\t\tlist.head\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_152() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tlist.map[String s| s]\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_153() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\t$$IterableExtensions::map(list, [String s| s])\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_154() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval fun = [String s| s]\n\t\t\t$$IterableExtensions::map(list, fun)\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_155() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.map(println([String s| println(s)]))\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_156() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tlist.addAll(null as java.util.ArrayList<String>)\n\t\t\tlist.head\n\t\t}", "String");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_157() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tlist.addAll(newArrayList(\'\'))\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_158() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tlist.addAll(null as String[])\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_159() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval secondList = newArrayList\n\t\t\tlist.addAll(null as String[])\n\t\t\tlist.addAll(secondList)\n\t\t\tsecondList\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_160() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval secondList = newArrayList\n\t\t\tlist.addAll(secondList)\n\t\t\tlist.addAll(null as String[])\n\t\t\tsecondList\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_161() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tfor(s: list) {\n\t\t\t\tval String x = s\n\t\t\t\tx.toString\n\t\t\t}\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_162() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tfor(s: newArrayList) {\n\t\t\t\tlist.add(s)\n\t\t\t\tval String x = s\n\t\t\t\tx.toString\n\t\t\t}\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_163() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval literal = #{}\n\t\t\tlist.addAll(literal)\n\t\t\tfor(s: newArrayList) {\n\t\t\t\tlist.add(s)\n\t\t\t\tval String x = s\n\t\t\t\tx.toString\n\t\t\t}\n\t\t\tliteral\n\t\t}", "Set<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_164() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval literal = #{}\n\t\t\tlist += literal\n\t\t\tfor(s: newArrayList) {\n\t\t\t\tlist.add(s)\n\t\t\t\tval String x = s\n\t\t\t\tx.toString\n\t\t\t}\n\t\t\tliteral\n\t\t}", "Set<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_165() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval literal = #{}\n\t\t\tlist.add(literal.flatten.head)\n\t\t\tfor(s: newArrayList) {\n\t\t\t\tlist.add(s)\n\t\t\t\tval String x = s\n\t\t\t\tx.toString\n\t\t\t}\n\t\t\tliteral\n\t\t}", "Set<Iterable<? extends String>>");
  }
  
  @Ignore("+= resolves the type parameter since Integer is a resolved type")
  @Test
  public void testDeferredTypeArgumentResolution_166() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tlist += 1\n\t\t\tlist += 1.0\n\t\t\tlist\n\t\t}", "ArrayList<Number & Comparable<?>>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_167() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.add(new java.util.ArrayList)\n\t\t\tval java.util.Iterator<String> s = list.head.flatten.head\n\t\t\tlist.head\n\t\t}", "ArrayList<Iterable<? extends Iterator<String>>>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_168() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tlist.addAll(1, null as String[])\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testRecursiveTypeArgumentResolution_01() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tlist.addAll(list)\n\t\t\tlist\n\t\t}", "ArrayList<Object>");
  }
  
  @Test
  public void testRecursiveTypeArgumentResolution_02() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tlist.add(list.head)\n\t\t\tlist\n\t\t}", "ArrayList<Object>");
  }
  
  @Test
  public void testRecursiveTypeArgumentResolution_03() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tlist.addAll(list)\n\t\t\tlist.add(\'\')\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testRecursiveTypeArgumentResolution_04() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tlist.add(list.head)\n\t\t\tlist.add(\'\')\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testRecursiveTypeArgumentResolution_05() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.addAll(list)\n\t\t\tlist\n\t\t}", "ArrayList<Object>");
  }
  
  @Test
  public void testRecursiveTypeArgumentResolution_06() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.add(list.head)\n\t\t\tlist\n\t\t}", "ArrayList<Object>");
  }
  
  @Test
  public void testRecursiveTypeArgumentResolution_07() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.addAll(list)\n\t\t\tlist.add(\'\')\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testRecursiveTypeArgumentResolution_08() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.add(list.head)\n\t\t\tlist.add(\'\')\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testFeatureCallWithOperatorOverloading_2() throws Exception {
    this.resolvesTo("new java.util.ArrayList<Byte>() += \'x\'.getBytes().iterator.next", "boolean");
  }
  
  @Test
  public void testFeatureCallWithOperatorOverloading_3() throws Exception {
    this.resolvesTo("new java.util.ArrayList<Byte>() += null", "boolean");
  }
  
  @Test
  public void testFeatureCallWithOperatorOverloading_4() throws Exception {
    this.resolvesTo("new java.util.ArrayList<Byte>() += newArrayList(\'x\'.getBytes().iterator.next)", "boolean");
  }
  
  @Test
  public void testFeatureCallWithOperatorOverloading_5() throws Exception {
    this.resolvesTo("new java.util.ArrayList<Byte>() += \'x\'.getBytes()", "boolean");
  }
  
  @Test
  public void testFeatureCallOnIt() throws Exception {
    this.resolvesTo("{ val it = \'foo\'; length == 3;}", "boolean");
  }
  
  @Test
  public void testStaticMethods_01() throws Exception {
    this.resolvesTo("newArrayList(\'\')", "ArrayList<String>");
  }
  
  @Test
  public void testStaticMethods_02() throws Exception {
    this.resolvesTo("newArrayList(\'\', \'\')", "ArrayList<String>");
  }
  
  @Test
  public void testStaticMethods_03() throws Exception {
    this.resolvesTo("newArrayList(newHashSet(\'\'))", "ArrayList<HashSet<String>>");
  }
  
  @Test
  public void testStaticMethods_04() throws Exception {
    this.resolvesTo("newArrayList()", "ArrayList<Object>");
  }
  
  @Test
  public void testStaticMethods_05() throws Exception {
    this.resolvesTo("newHashMap()", "HashMap<Object, Object>");
  }
  
  @Test
  public void testStaticMethods_06() throws Exception {
    this.resolvesTo("String::CASE_INSENSITIVE_ORDER", "Comparator<String>");
  }
}
