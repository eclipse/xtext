/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.junit.evaluation;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newHashMap;
import static com.google.common.collect.Sets.newHashSet;
import static com.google.common.collect.Sets.newTreeSet;
import static java.util.Collections.emptyList;

import java.io.IOException;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.testing.TemporaryFolder;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;

import testdata.CloseException;
import testdata.ExceptionSubclass;
import testdata.OuterClass;
import testdata.TryBodyException;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Sven Efftinge
 */
public abstract class AbstractXbaseEvaluationTest extends Assert {
	
	@Rule
	@Inject public TemporaryFolder temporaryFolder = new TemporaryFolder();
	
	@Test public void testReservedWordEnum() throws Exception {
		assertEvaluatesTo(Boolean.TRUE, "typeof(java.lang.annotation.RetentionPolicy).enum");
	}
	
	@Test public void testReservedWordEnum_02() throws Exception {
		assertEvaluatesTo(Boolean.TRUE, "java.lang.annotation.RetentionPolicy.enum");
	}
	
	@Test public void testReservedWordEnum_03() throws Exception {
		assertEvaluatesTo(RetentionPolicy.SOURCE, "java.lang.annotation.RetentionPolicy.SOURCE");
	}
	
	@Test public void testReservedWordInterface() throws Exception {
		assertEvaluatesTo(Boolean.TRUE, "typeof(Iterable).interface");
	}
	
	@Test public void testReservedWordInterface_02() throws Exception {
		assertEvaluatesTo(Boolean.TRUE, "Iterable.interface");
	}
	
	@Test public void testReservedWordAnnotation() throws Exception {
		assertEvaluatesTo(Boolean.TRUE, "typeof(Override).annotation");
	}
	
	@Test public void testReservedWordClass() throws Exception {
		assertEvaluatesTo(Class.class, "typeof(Override).class");
	}
	
	@Test public void testDoubleSwitch() throws Exception {
		assertEvaluatesTo("foo","{ val x = 'foo' switch x.length { case 2 : 'bla'.toString } switch x.length { case 3 : 'foo'.toString } }");
	}

	@Test public void testIntLiteral_0() throws Exception {
		assertEvaluatesTo(1, "1");
	}

	@Test public void testIntLiteral_2() throws Exception {
		assertEvaluatesTo(0x17, "0x17");
	}
	
	@Test public void testIntLiteral_2a() throws Exception {
		assertEvaluatesTo(0x17, "0X17");
	}
	
	@Test public void testIntLiteral_4() throws Exception {
		assertEvaluatesTo(123456789, "123_456_789");
	}
	
	@Test public void testIntLiteral_5() throws Exception {
		assertEvaluatesTo(0xffffeeee, "0xffff_eeee");
	}
	
	@Test public void testLongLiteral_0() throws Exception {
		assertEvaluatesTo(1l, "1l");
	}

	@Test public void testLongLiteral_2() throws Exception {
		assertEvaluatesTo(0x17l, "0x17#L");
	}
	
	@Test public void testLongLiteral_4() throws Exception {
		assertEvaluatesTo(123456789123456789L, "123_456_789_123_456_789L");
	}
	
	@Test public void testLongLiteral_5() throws Exception {
		assertEvaluatesTo(0xffffeeeeddddccccl, "0xffff_eeee_dddd_cccc#L");
	}
	
	@Test public void testFloatLiteral_0() throws Exception {
		assertEvaluatesTo(1f, "1f");
	}

	@Test public void testFloatLiteral_1() throws Exception {
		assertEvaluatesTo(17f, "017f");
	}
	
	@Test public void testFloatLiteral_2() throws Exception {
		assertEvaluatesTo(1.0f, "1.0f");
	}
	
	@Test public void testFloatLiteral_3() throws Exception {
		assertEvaluatesTo(1.0e-10f, "1.0e-10f");
	}
	
	@Test public void testFloatLiteral_4() throws Exception {
		assertEvaluatesTo(1.0e+10f, "1.0e+10f");
	}
	
	@Test public void testFloatLiteral_5() throws Exception {
		assertEvaluatesTo(1.0E10f, "1.0E10f");
	}
	
	@Test public void testFloatLiteral_6() throws Exception {
		assertEvaluatesTo(1E10f, "1E10f");
	}
	
	@Test public void testDoubleLiteral_0() throws Exception {
		assertEvaluatesTo(1d, "1d");
	}

	@Test public void testDoubleLiteral_2() throws Exception {
		assertEvaluatesTo(1.0, "1.0");
	}
	
	@Test public void testDoubleLiteral_3() throws Exception {
		assertEvaluatesTo(1.0e-10, "1.0e-10");
	}
	
	@Test public void testDoubleLiteral_4() throws Exception {
		assertEvaluatesTo(1.0E+10, "1.0E+10");
	}
	
	@Test public void testDoubleLiteral_5() throws Exception {
		assertEvaluatesTo(1.0E10, "1.0E10");
	}

	@Test public void testDoubleLiteral_6() throws Exception {
		assertEvaluatesTo(1e10, "1e10");
	}

	@Test public void testDoubleLiteral_7() throws Exception {
		assertEvaluatesTo(1.0d, "1.0d");
	}
	
	@Test public void testDoubleLiteral_8() throws Exception {
		assertEvaluatesTo(1.0e-10d, "1.0e-10d");
	}
	
	@Test public void testDoubleLiteral_9() throws Exception {
		assertEvaluatesTo(1.0E+10d, "1.0E+10d");
	}
	
	@Test public void testDoubleLiteral_10() throws Exception {
		assertEvaluatesTo(1.0E10d, "1.0E10d");
	}

	@Test public void testDoubleLiteral_11() throws Exception {
		assertEvaluatesTo(1e10d, "1e10d");
	}

	@Test public void testDoubleLiteral_12() throws Exception {
		assertEvaluatesTo(1.123456789e10d, "1.123_456_789e1_0d");
	}

	@Test public void testDoubleLiteral_13() throws Exception {
		assertEvaluatesTo(123456789d, "123_456_789d");
	}

	@Test public void testBigInteger_0() throws Exception {
		assertEvaluatesTo(new BigInteger("1"), "1bi");
	}

	@Test public void testBigInteger_1() throws Exception {
		assertEvaluatesTo(new BigInteger("12345678901234567890123456789012345678901234567890"), 
				"1234567890_12345678901234567890_1234567890_1234567890_Bi");
	}

	@Test public void testBigInteger_3() throws Exception {
		assertEvaluatesTo(new BigInteger("77", 16), "0x77#bI");
	}
	
	@Test public void testBigInteger_4() throws Exception {
		assertEvaluatesTo(new BigInteger("1000000"), "10e+5bI");
	}
	
	@Test public void testBigInteger_5() throws Exception {
		assertEvaluatesTo(new BigDecimal("10e+12345").toBigInteger(), "10e+12345bI");
	}
	
	@Test public void testBigInteger_6() throws Exception {
		assertEvaluatesTo(new BigInteger("beefbeefbeefbeefbeef", 16), "0xbeef_beef_beef_beef_beef#BI");
	}

	@Test public void testBigDecimal_0() throws Exception {
		assertEvaluatesTo(new BigDecimal("1.0"), "1.0bd");
	}

	@Test public void testBigDecimal_1() throws Exception {
		assertEvaluatesTo(new BigDecimal("1.0e500"), "1.0e500Bd");
	}

	@Test public void testBigDecimal_2() throws Exception {
		assertEvaluatesTo(new BigDecimal("123456789012345678901234567890.123456789012345678901234567890"), 
				"1234567890_1234567890_1234567890.1234567890_1234567890_1234567890bD");
	}

	@Test public void testBigDecimal_3() throws Exception {
		assertEvaluatesTo(new BigDecimal("1e500"), "1e500BD");
	}

	@Test public void testBug372408() throws Exception {
		assertEvaluatesTo(new BigInteger("0"), "0BI");
		assertEvaluatesTo(0l, "0l");
	}
	
	@Test public void testImplicitOneArgClosure() throws Exception {
		assertEvaluatesTo("foo","[it].apply('foo')");
	}
	
	@Ignore("To be implemented later")
	@Test public void testImplicitOneArgClosure_01() throws Exception {
		assertEvaluatesTo(3,"[length].apply('foo')");
	}
	
	@Test public void testImplicitOneArgClosure_02() throws Exception {
		assertEvaluatesTo(newArrayList("a","bb","ccc"), "newArrayList('bb','a','ccc').sortBy([length])");
	}
	
	@Test public void testBug362725() throws Exception {
		assertEvaluatesTo(Boolean.TRUE, "{ val =>int closure = null closure == null }");
	}
	
	@Test public void testBuilderSyntax_01() throws Exception {
		assertEvaluatesTo(newArrayList("a","bb","ccc"), "newArrayList('a','bb','ccc').sortBy [length]");
	}
	
	@Test public void testBuilderSyntax_02() throws Exception {
		assertEvaluatesTo(newArrayList("a","bb","ccc"), "newArrayList('a','bb','ccc').sortBy [it.length]");
	}
	
	@Test public void testBuilderSyntax_03() throws Exception {
		assertEvaluatesTo(newArrayList("a","bb","ccc"), "newArrayList('a','bb','ccc').sortBy [x | x.length]");
	}
	
	@Test public void testBuilderSyntax_04() throws Exception {
		assertEvaluatesTo(newArrayList(), "<String>newArrayList.sortBy [length]");
	}
	
	@Test public void testNestedClosures_01() throws Exception {
		String expr = 
				"{ " +
				" val x = 'foo' " +
				" [String s | x + [ String s1 | s1 + s + x].apply(s) ].apply(x)" +
				"}";
		assertEvaluatesTo("foofoofoofoo", expr);
	}
	
	@Test public void testNestedClosures_02() throws Exception {
		String expr = 
				"{ " +
				" val x = 'foo' " +
				" [ s | x + [ s1 | s1 + s + x].apply(s) ].apply(x)" +
				"}";
		assertEvaluatesTo("foofoofoofoo", expr);
	}
	
	@Test public void testEscapeCharacter() throws Exception {
		String expr = "'foo'.^class";
		assertEvaluatesTo(String.class, expr);
	}
	
	@Test public void testShortCircuitBooleanExpression_00() throws Exception {
		String expr = "true || {if (true) throw new NullPointerException() else false}";
		assertEvaluatesTo(true, expr);
	}
	
	@Test public void testShortCircuitBooleanExpression_01() throws Exception {
		String expr = "false && {if (true) throw new NullPointerException() else false}";
		assertEvaluatesTo(false, expr);
	}
	
	@Test public void testShortCircuitBooleanExpression_02() throws Exception {
		String expr = "true || {if (true) throw new NullPointerException else false}";
		assertEvaluatesTo(true, expr);
	}
	
	@Test public void testShortCircuitBooleanExpression_03() throws Exception {
		String expr = 
				"{ val i = newArrayList(false,true).iterator" +
				"  if (i.next && i.next)" +
				"    throw new NullPointerException()" +
				"  else" +
				"    i.next" +
				"}";
		assertEvaluatesTo(true, expr);
	}
	
	@Test public void testShortCircuitBooleanExpression_04() throws Exception {
		String expr = 
				"{ val i = newArrayList(true,false).iterator" +
				"  if (i.next || i.next)" +
				"     i.next" +
				"}";
		assertEvaluatesTo(false, expr);
	}
	
	@Test public void testShortCircuitBooleanExpression_05() throws Exception {
		String expr = 
				"{ " +
				"  val i = newArrayList(true, true, true).iterator" +
				"  if (i.next && i.next && i.next)" +
				"     i.hasNext" +
				"}";
		assertEvaluatesTo(false, expr);
	}
	
	@Test public void testShortCircuitBooleanExpression_06() throws Exception {
		String expr = 
				"{ " +
				"  val i = newArrayList(false, true).iterator" +
				"  if (i.next && i.next || i.next)" +
				"     i.hasNext" +
				"}";
		assertEvaluatesTo(false, expr);
	}
	
	@Test public void testReferenceInnerClasses_01() throws Exception {
		assertEvaluatesTo(OuterClass.InnerClass.SINGLETON, "testdata::OuterClass$InnerClass::SINGLETON");
	}
	
	@Test public void testReferenceInnerClasses_02() throws Exception {
		assertEvaluatesTo("FOO", "[testdata.OuterClass$InnerClass param| param.toUpperCase('foo')].apply(new testdata.OuterClass$InnerClass())");
	}
	
	@Test public void testReferenceInnerClasses_03() throws Exception {
		assertEvaluatesTo(null, "{for (x : newArrayList(new testdata.OuterClass$InnerClass())) { x.toString } null}");
	}
	
	@Test public void testReferenceInnerClasses_04() throws Exception {
		assertEvaluatesTo("FOO", "[testdata.OuterClass$InnerClass param| param.toUpperCase('foo')].apply(new testdata.OuterClass$InnerClass)");
	}
	
	@Test public void testReferenceInnerClasses_05() throws Exception {
		assertEvaluatesTo(OuterClass.InnerClass.SINGLETON, "testdata::OuterClass::InnerClass::SINGLETON");
	}
	
	@Test public void testReferenceInnerClasses_06() throws Exception {
		assertEvaluatesTo("FOO", "[testdata.OuterClass.InnerClass param| param.toUpperCase('foo')].apply(new testdata.OuterClass.InnerClass())");
	}
	
	@Test public void testReferenceInnerClasses_07() throws Exception {
		assertEvaluatesTo(null, "{for (x : newArrayList(new testdata.OuterClass.InnerClass())) { x.toString } null}");
	}
	
	@Test public void testReferenceInnerClasses_08() throws Exception {
		assertEvaluatesTo("FOO", "[testdata.OuterClass.InnerClass param| param.toUpperCase('foo')].apply(new testdata.OuterClass.InnerClass)");
	}
	
	@Test public void testReferenceInnerClasses_09() throws Exception {
		assertEvaluatesTo(OuterClass.InnerClass.SINGLETON, "testdata.OuterClass$InnerClass::SINGLETON");
	}
	
	@Test public void testReferenceInnerClasses_10() throws Exception {
		assertEvaluatesTo(OuterClass.InnerClass.SINGLETON, "testdata.OuterClass.InnerClass::SINGLETON");
	}
	
	/*
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=341642
	 */
	@Test public void testBug341642() throws Exception {
		assertEvaluatesTo("a", "newArrayList('a', 'b', 'c').filter(a|a == 'a' || a == 'b').iterator.next");
	}
	
	@Test public void testBug341775() throws Exception {
		assertEvaluatesTo(Boolean.FALSE, "'a'.charAt(0) == 'a'");
		assertEvaluatesTo(Boolean.TRUE, "'a'.charAt(0) == 'a'.charAt(0)");
		assertEvaluatesTo(Boolean.TRUE, "'a' == 'a'");
	}
	
	@Test public void testCurrying_01() throws Exception {
		assertEvaluatesTo("123456", "[String p1, String p2, String p3, String p4, String p5, String p6| p1+p2+p3+p4+p5+p6].curry('1').curry('2').curry('3').curry('4').curry('5').curry('6').apply()");
	}
	
	@Test public void testCurrying_02() throws Exception {
		assertEvaluatesTo("1", "[String p1| p1].curry('1').apply()");
	}
	
	@Test public void testCurrying_03() throws Exception {
		assertEvaluatesTo("12", "[String p1, String p2| p1 + p2].curry('1').curry('2').apply()");
	}
	
	@Test public void testCurrying_04() throws Exception {
		assertEvaluatesTo(newArrayList("1","2","3","4","5","6"), 
				"{\n" +
				"  val result = <String>newArrayList\n" +
				"  var (String,String,String,String,String,String)=>void proc = [ p1, p2, p3, p4, p5, p6 |\n" +
				"      result.add(p1)\n" +
				"      result.add(p2)\n" +
				"      result.add(p3)\n" +
				"      result.add(p4)\n" +
				"      result.add(p5)\n" +
				"      result.add(p6)\n" +
				"  ]" +
				"  proc.curry('1').curry('2').curry('3').curry('4').curry('5').curry('6').apply()\n" +
				"  result\n" +
				"}");
	}
	
	@Test public void testCurrying_05() throws Exception {
		assertEvaluatesTo(newArrayList("1","2"), 
				"{\n" +
						"  val result = <String>newArrayList\n" +
						"  var (String,String)=>void proc = [ p1, p2 |\n" +
						"      result.add(p1)\n" +
						"      result.add(p2)\n" +
						"  ]" +
						"  proc.curry('1').curry('2').apply()\n" +
						"  result\n" +
				"}");
	}
	
	@Test public void testCurrying_06() throws Exception {
		assertEvaluatesTo(newArrayList("1","2","3","4","5","6"), 
				"{\n" +
				"  val result = <String>newArrayList\n" +
				"  val (String,String,String,String,String,String)=>void proc6 = [ p1, p2, p3, p4, p5, p6 |\n" +
				"      result.add(p1)\n" +
				"      result.add(p2)\n" +
				"      result.add(p3)\n" +
				"      result.add(p4)\n" +
				"      result.add(p5)\n" +
				"      result.add(p6)\n" +
				"  ]\n" +
				"  val (String,String,String,String,String)=>void proc5 = proc6.curry('1')\n" +
				"  val (String,String,String,String)=>void proc4 = proc5.curry('2')\n" +
				"  val (String,String,String)=>void proc3 = proc4.curry('3')\n" +
				"  val (String,String)=>void proc2 = proc3.curry('4')\n" +
				"  val (String)=>void proc1 = proc2.curry('5')\n" +
				"  val =>void proc0 = proc1.curry('6')\n" +
				"  proc0.apply()\n" +
				"  result\n" +
				"}");
	}
	
	/*
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=341550
	 */
	@Test public void testBug341550() throws Exception {
		assertEvaluatesTo(emptyList(),"switch emptyList() { case emptyList() : emptyList() }");
	}
	
	@Test public void testGenerics_00() throws Exception {
		assertEvaluatesTo("", "try {typeof(String).newInstance} catch(Exception e) {}");
	}
	
	@Test public void testGenerics_00_b() throws Exception {
		assertEvaluatesTo("", "try {String.newInstance} catch(Exception e) {}");
	}
	
	@Test public void testGenerics_01() throws Exception {
		assertEvaluatesTo("y",
				"{" +
				" val x = newArrayList('y',23,true)" +
				" return x.head" +
				"}");
	}

	@Test public void testGenerics_02() throws Exception {
		assertEvaluatesTo(Boolean.TRUE,
				"new java.util.ArrayList<Object>().addAll(typeof(String).declaredFields)");
	}
	
	@Test public void testGenerics_02_b() throws Exception {
		assertEvaluatesTo(Boolean.TRUE,
				"new java.util.ArrayList<Object>().addAll(String.declaredFields)");
	}
	
	@Test public void testGenerics_03() throws Exception {
		assertEvaluatesTo("y",
				"{" +
				" val x = <Object>newArrayList('y',23,true)" +
				" return x.head" +
				"}");
	}

	@Test public void testGenerics_04() throws Exception {
		assertEvaluatesTo(Boolean.TRUE,
				"new java.util.ArrayList<Object>.addAll(typeof(String).declaredFields)");
	}
	
	@Test public void testGenerics_04_b() throws Exception {
		assertEvaluatesTo(Boolean.TRUE,
				"new java.util.ArrayList<Object>.addAll(String.declaredFields)");
	}

	@Test public void testGenerics_05() throws Exception {
		assertEvaluatesTo("y",
				"{" +
				" val x = newArrayList('y',23,true)" +
				" x.head" +
				"}");
	}
	
	@Test public void testGenerics_06() throws Exception {
		assertEvaluatesTo("y",
				"{" +
				" val x = <Object>newArrayList('y',23,true)" +
				" x.head" +
				"}");
	}
	
	@Test public void testGenerics_07() throws Exception {
		assertEvaluatesTo(Integer.valueOf(23),
				"{" +
						" val x = newArrayList(23, 23d)" +
						" x.head" +
				"}");
	}
	
	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=341246
	 */
	@Test public void testUnreferencedConstructorInBlock_01() throws Exception {
		assertEvaluatesTo(false, "{ new String() false}");
	}
	
	@Test public void testUnreferencedConstructorInBlock_02() throws Exception {
		assertEvaluatesTo(false, "{ new String false}");
	}
	
	@Test public void testStaticFeatureCall_01() throws Exception {
		assertEvaluatesTo("false", "String::valueOf(false)");
	}
	
	@Test public void testStaticFeatureCall_02() throws Exception {
		assertEvaluatesTo(Boolean.FALSE, "Boolean::FALSE");
	}
	
	@Test public void testStaticFeatureCall_03() throws Exception {
		assertEvaluatesTo("false", "String.valueOf(false)");
	}
	
	@Test public void testStaticFeatureCall_04() throws Exception {
		assertEvaluatesTo(Boolean.FALSE, "Boolean.FALSE");
	}
	
	@Test public void testStaticFeatureCall_05() throws Exception {
		assertEvaluatesTo("false", "java.lang.String.valueOf(false)");
	}
	
	@Test public void testPrimitiveConversion_01() throws Exception {
		assertEvaluatesTo("2","'ab'.length.toString");
	}
	
	@Test public void testPrimitiveConversion_02() throws Exception {
		assertEvaluatesTo("123","123.toString");
	}
	
	@Test public void testPrimitiveConversion_03() throws Exception {
		assertEvaluatesTo("123","return 123.toString");
	}
	
	@Test public void testPrimitiveConversion_04() throws Exception {
		assertEvaluatesTo("123","123L.intValue.toString");
	}
	
	@Test public void testReturnExpression_01() throws Exception {
		assertEvaluatesTo(Boolean.TRUE, "return true");
	}
	
	@Test public void testReturnExpression_02() throws Exception {
		assertEvaluatesTo("xx", "return if ('x'=='x') 'xx'");
	}
	
	@Test public void testReturnExpression_03() throws Exception {
		assertEvaluatesTo(null, "return if ('x'!='x') 'xx'");
	}
	
	@Test public void testReturnExpression_04() throws Exception {
		assertEvaluatesTo(null, "return null");
	}
	
	@Test public void testReturnExpression_05() throws Exception {
		assertEvaluatesTo("yy", "if ('x'!='x') return 'xx' else return 'yy'");
		assertEvaluatesTo("xx", "if ('x'=='x') return 'xx' else return 'yy'");
	}
	
	@Test public void testReturnExpression_06() throws Exception {
		assertEvaluatesTo(null, 
				"{" +
				" val closure = [Integer i| return i]" +
				" for (x : 1..100) " +
				"    closure.apply(x)" +
				" return null" +
				"}");
	}
	
	@Ignore("Wrong type")
	@Test public void testReturnExpression_07() throws Exception {
		assertEvaluatesTo(null, "return if (true) while(false) ('foo'+'bar').length else null");
		assertEvaluatesTo(null, "return if (false) while(false) ('foo'+'bar').length else null");
	}
	
	@Ignore("Wrong type")
	@Test public void testReturnExpression_08() throws Exception {
		assertEvaluatesTo(null, "return if (true) while(false) ('foo'+'bar').length else 'zonk'");
		assertEvaluatesTo("zonk", "return if (false) while(false) ('foo'+'bar').length else 'zonk'");
	}
	
	@Test public void testReturnExpression_09() throws Exception {
		assertEvaluatesTo(null, "{ return null }");
	}
	
	@Test public void testReturnExpression_10() throws Exception {
		assertEvaluatesTo(null, "{ { println }; null }");
	}

	@Test public void testUnaryOperator_00() throws Exception {
		assertEvaluatesTo(new Integer(-19),"-19");
	}
	
	@Test public void testUnaryOperator_01() throws Exception {
		assertEvaluatesTo(false,"!true");
	}
	
	@Test public void testUnaryOperator_02() throws Exception {
		assertEvaluatesTo("-1","(-1).toString()");
	}
	
	@Test public void testUnaryOperator_03() throws Exception {
		assertEvaluatesTo(1,"- -1");
	}
	
	@Test public void testUnaryOperator_04() throws Exception {
		assertEvaluatesTo(true,"!!true");
	}
	
	@Test public void testUpToOperator() throws Exception {
		assertEvaluatesTo(new Integer(9),"(9..13).iterator().next()");
	}
	
	@Test public void testExclusiveRangeOperator_0() throws Exception {
		assertEvaluatesTo("0,1,2,3", "(0..<4).join(',')");
	}
	
	@Test public void testExclusiveRangeOperator_1() throws Exception {
		assertEvaluatesTo("3,2,1,0", "(4>..0).join(',')");
	}
	
	@Test public void testExclusiveRangeOperator_2() throws Exception {
		assertEvaluatesTo("", "(0..<0).join(',')");
	}
	
	@Test public void testExclusiveRangeOperator_3() throws Exception {
		assertEvaluatesTo("", "(0>..0).join(',')");
	}
	
	@Test public void testExclusiveRangeOperator_4() throws Exception {
		assertEvaluatesTo("", "(0..<-1).join(',')");
	}
	
	@Test public void testExclusiveRangeOperator_5() throws Exception {
		assertEvaluatesTo("", "(-1>..0).join(',')");
	}
	
	@Test public void testElvisOperator() throws Exception {
		assertEvaluatesTo("foo","null as String?:'foo'");
	}
	
	@Test public void testElvisOperator_01() throws Exception {
		assertEvaluatesTo("bar","'bar' ?: 'foo'");
	}
	
	@Test public void testElvisOperator_02() throws Exception {
		assertEvaluatesTo(null,"null ?: null");
	}
	
	@Test public void testElvisOperator_03() throws Exception {
		assertEvaluatesTo(null,"null as String ?: null as String");
	}
	
	@Test public void testElvisOperator_04() throws Exception {
		assertEvaluatesTo("foo","{var foo='foo' val x=foo?:{foo='bar' foo} foo}");
	}
	
	@Test public void testElvisOperator_05() throws Exception {
		assertEvaluatesTo("bar","{var String foo=null val x=foo?:{foo='bar' foo} foo}");
	}
	
	@Test public void testStringConcatenation_00() throws Exception {
		assertEvaluatesTo("foobar", "'foo'+ ('bar' as Object)");
	}
	@Test public void testStringConcatenation_01() throws Exception {
		assertEvaluatesTo("foo3", "'foo'+3");
	}
	@Test public void testStringConcatenation_2() throws Exception {
		assertEvaluatesTo("footrue", "'foo'+true");
	}
	
	@Test public void testStringConcatenation_3() throws Exception {
		assertEvaluatesTo("42footrue", "42 +'foo'+true");
	}
	
	@Test public void testStringConcatenation_4() throws Exception {
		assertEvaluatesTo("truefootrue", "true + 'foo'+true");
	}
	
	@Test public void testAddOnIntegers() throws Exception {
		assertEvaluatesTo(new Integer(3), "1+2");
	}

	@Test public void testSubtractionOnIntegers() throws Exception {
		assertEvaluatesTo(new Integer(1), "2-1");
	}

	@Test public void testMultiplicationOnIntegers() throws Exception {
		assertEvaluatesTo(new Integer(42), "6*7");
	}

	@Test public void testDivisionOnIntegers_01() throws Exception {
		assertEvaluatesTo(new Integer(2), "6/3");
	}

	@Test public void testDivisionOnIntegers_02() throws Exception {
		assertEvaluatesTo(new Integer(2), "7/3");
	}

	@Test public void testModuloOnIntegers() throws Exception {
		assertEvaluatesTo(new Integer(1), "7%3");
	}

	@Test public void testPowerOnIntegers() throws Exception {
		assertEvaluatesTo(new Double(8), "2**3");
	}

	@Test public void testLessThanOnIntegers_01() throws Exception {
		assertEvaluatesTo(new Boolean(true), "3<4");
	}

	@Test public void testLessThanOnIntegers_02() throws Exception {
		assertEvaluatesTo(new Boolean(false), "4<3");
	}

	@Test public void testGreaterThanOnIntegers_01() throws Exception {
		assertEvaluatesTo(new Boolean(true), "4>3");
	}

	@Test public void testGreaterThanOnIntegers_02() throws Exception {
		assertEvaluatesTo(new Boolean(false), "3>4");
	}

	@Test public void testLessEqualsThanOnIntegers_01() throws Exception {
		assertEvaluatesTo(new Boolean(true), "3<=3");
	}

	@Test public void testLessEqualsThanOnIntegers_02() throws Exception {
		assertEvaluatesTo(new Boolean(true), "3<=4");
	}

	@Test public void testLessEqualsThanOnIntegers_03() throws Exception {
		assertEvaluatesTo(new Boolean(false), "4<=3");
	}

	@Test public void testGreaterEqualsThanOnIntegers_01() throws Exception {
		assertEvaluatesTo(new Boolean(true), "3>=3");
	}

	@Test public void testGreaterEqualsThanOnIntegers_02() throws Exception {
		assertEvaluatesTo(new Boolean(true), "4>=3");
	}

	@Test public void testGreaterEqualsThanOnIntegers_03() throws Exception {
		assertEvaluatesTo(new Boolean(false), "3>=4");
	}

	@Test public void testOrOnBooleans_01() throws Exception {
		assertEvaluatesTo(new Boolean(true), "true||false");
	}

	@Test public void testOrOnBooleans_02() throws Exception {
		assertEvaluatesTo(new Boolean(true), "false||true");
	}

	@Test public void testOrOnBooleans_03() throws Exception {
		assertEvaluatesTo(new Boolean(true), "true||true");
	}

	@Test public void testOrOnBooleans_04() throws Exception {
		assertEvaluatesTo(new Boolean(false), "false||false");
	}

	@Test public void testAndOnBooleans_01() throws Exception {
		assertEvaluatesTo(new Boolean(true), "true&&true");
	}

	@Test public void testAndOnBooleans_02() throws Exception {
		assertEvaluatesTo(new Boolean(false), "false&&true");
	}

	@Test public void testAndOnBooleans_03() throws Exception {
		assertEvaluatesTo(new Boolean(false), "true&&false");
	}

	@Test public void testAndOnBooleans_04() throws Exception {
		assertEvaluatesTo(new Boolean(false), "false&&false");
	}

	@Test public void testNull() throws Exception {
		assertEvaluatesTo(null, "null");
	}
	
	@Test public void testNullBlockResult_01() throws Exception {
		assertEvaluatesTo(null, "{ null; }");
	}
	
	@Test public void testNullBlockResult_02() throws Exception {
		assertEvaluatesTo(null, "{ 'literal'.length; null; }");
	}
	
	@Test public void testBlock_01() throws Exception {
		assertEvaluatesTo(Boolean.TRUE, 
				"{\n" + 
				"  val (Integer, Double, Boolean) => void fun1 = null\n" + 
				"  val (byte[], Object) => double[] fun2 = null\n" + 
				"  val test = newArrayList.map[1 -> org::eclipse::xtext::xbase::lib::Pair::of(fun1, fun2)]\n" + 
				"  val test2 = newArrayList.map[2 -> org::eclipse::xtext::xbase::lib::Pair::of(fun1, fun2)]\n" + 
				"  val test3 = com::google::common::collect::Iterables::concat(test, test2).toMap[key].entrySet.map[value].toList\n" +
				"  test3 != null" + 
				"}");
	}
	
	@Test public void testBlock_02() throws Exception {
		assertEvaluatesTo("Length: 3", 
				"{\n" + 
				"  val map = newHashMap\n" + 
				"  map.put(1, 'abc')\n" + 
				"  val x = map.get(1)\n" + 
				"  'Length: ' + x.length" + 
				"}");
	}
	
	@Test public void testSynchronizedBlock_01() throws Exception {
		assertEvaluatesTo(Boolean.TRUE, 
				"synchronized(new Object) {\n" + 
				"  val (Integer, Double, Boolean) => void fun1 = null\n" + 
				"  val (byte[], Object) => double[] fun2 = null\n" + 
				"  val test = newArrayList.map[1 -> org::eclipse::xtext::xbase::lib::Pair::of(fun1, fun2)]\n" + 
				"  val test2 = newArrayList.map[2 -> org::eclipse::xtext::xbase::lib::Pair::of(fun1, fun2)]\n" + 
				"  val test3 = com::google::common::collect::Iterables::concat(test, test2).toMap[key].entrySet.map[value].toList\n" +
				"  test3 != null" + 
				"}");
	}
	
	@Test public void testSynchronizedBlock_02() throws Exception {
		assertEvaluatesTo("Length: 3", 
				"synchronized(new Object) {\n" + 
				"  val map = newHashMap\n" + 
				"  map.put(1, 'abc')\n" + 
				"  val x = map.get(1)\n" + 
				"  'Length: ' + x.length" + 
				"}");
	}
	
	@Test public void testSynchronizedBlock_03() throws Exception {
		assertEvaluatesTo("foo", 
				"{\n" +
				"  val list = <String>newArrayList\n" +
				"  val ()=>int x = [|{ list += 'foo'; 1 }]\n" +
				"  synchronized(x.apply) {\n" + 
				"   list.head\n" + 
				"  }\n" +
				"}\n");
	}
	
	@Test public void testStringLiteral_01() throws Exception {
		assertEvaluatesTo("", "''");
	}
	
	@Test public void testStringLiteral_02() throws Exception {
		assertEvaluatesTo("literal", "'literal'");
	}
	
	@Test public void testStringLiteral_03() throws Exception {
		assertEvaluatesTo("lite\r\nr\\al", "'lite\r\nr\\\\al'");
	}
	
	@Test public void testStringLiteral_04() throws Exception {
		assertEvaluatesTo('\n', "{ val char x = '\n' x}");
	}
	@Test public void testStringLiteral_05() throws Exception {
		assertEvaluatesTo(' ', "{ val char x = ' ' x}");
	}
	@Test public void testStringLiteral_06() throws Exception {
		assertEvaluatesTo('«', "{ val char x = '«' x}");
	}
	
	@Test public void testStringLiteral_07() throws Exception {
		assertEvaluatesTo('«', "{ val Character x = '«' x}");
	}
	
	@Test public void testBooleanLiteral_01() throws Exception {
		assertEvaluatesTo(Boolean.TRUE, "true");
	}
	
	@Test public void testBooleanLiteral_02() throws Exception {
		assertEvaluatesTo(Boolean.FALSE, "false");
	}
	
	@Test public void testIntLiteral_01() throws Exception {
		assertEvaluatesTo(53, "53");
	}
	
	@Test public void testIntLiteral_02() throws Exception {
		assertEvaluatesTo(0, "0");
	}
	
	@Test public void testTypeLiteral_01() throws Exception {
		assertEvaluatesTo(Void.class, "typeof(Void)");
	}

	@Test public void testTypeLiteral_02() throws Exception {
		assertEvaluatesTo(void.class, "typeof(void)");
	}
	
	@Test public void testTypeLiteral_03() throws Exception {
		assertEvaluatesTo(String[].class, "typeof(String[])");
	}
	
	@Test public void testTypeLiteral_04() throws Exception {
		assertEvaluatesTo(int[][].class, "typeof(int[][])");
	}
	
	@Test public void testTypeLiteral_05() throws Exception {
		assertEvaluatesTo(Void.class, "Void");
	}

	@Test public void testTypeLiteral_06() throws Exception {
		assertEvaluatesTo(void.class, "void");
	}
	
	@Test public void testTypeLiteral_07() throws Exception {
		assertEvaluatesTo(void.class, "void");
	}
	
	@Test public void testTypeLiteral_08() throws Exception {
		assertEvaluatesTo(Map.Entry.class, "typeof(java.util.Map$Entry)");
	}
	
	@Test public void testTypeLiteral_09() throws Exception {
		assertEvaluatesTo(Map.Entry.class, "typeof(java.util.Map.Entry)");
	}
	
	@Test public void testTypeLiteral_10() throws Exception {
		assertEvaluatesTo(Map.Entry.class, "java.util.Map$Entry");
	}
	
	@Test public void testTypeLiteral_11() throws Exception {
		assertEvaluatesTo(Map.Entry.class, "java.util.Map.Entry");
	}

	
	@Test public void testIdentityEquals_0() throws Exception {
		assertEvaluatesTo(true, "1===1");
	}
	
	@Test public void testIdentityEquals_1() throws Exception {
		assertEvaluatesTo(false, "new Object===new Object");
	}
	
	@Test public void testIdentityEquals_2() throws Exception {
		assertEvaluatesTo(true, "130L===130L");
	}
	
	@Test public void testIdentityNotEquals_0() throws Exception {
		assertEvaluatesTo(false, "130L!==130L");
	}
	
	@Test public void testSpaceship_0() throws Exception {
		assertEvaluatesTo(1, "2<=>1");
	}
	
	@Test public void testSpaceship_1() throws Exception {
		assertEvaluatesTo(-1, "1<=>2");
	}
	
	@Test public void testSpaceship_2() throws Exception {
		assertEvaluatesTo(0, "'bar'<=>'bar'");
	}
	
	@Test public void testIfExpression_00() throws Exception {
		assertEvaluatesTo(null, "if (0==1) 'literal'");
	}
	
	@Test public void testIfExpression_01() throws Exception {
		assertEvaluatesTo(null, "if (false) 'literal'");
	}
	
	@Test public void testIfExpression_02() throws Exception {
		assertEvaluatesTo("literal", "if (true) 'literal'");
	}
	
	@Test public void testIfExpression_03() throws Exception {
		assertEvaluatesTo("then", "if (true) 'then' else 'else'");
	}
	
	@Test public void testIfExpression_04() throws Exception {
		assertEvaluatesTo("else", "if (false) 'then' else 'else'");
	}
	
	@Test public void testIfExpression_05() throws Exception {
		assertEvaluatesTo(null, "if (false) return 'fail'");
	}
	
	/**
	 * @since 2.5
	 */
	@Test public void testIfExpression_06() throws Exception {
		// this is compiled without expectation thus nothing is inserted during type compilation
		// e.g. the if expression has type 'void' but the compiler / interpreter returns 'void' since
		// the evaluation expects a hardcoded 'Object'
		assertEvaluatesTo(null, 
				"if (false) return 1");
	}
	
	/**
	 * @since 2.5
	 */
	@Test public void testIfExpression_07() throws Exception {
		assertEvaluatesTo(null, 
				"if (false) return 1L");
	}
	
	/**
	 * @since 2.5
	 */
	@Test public void testIfExpression_08() throws Exception {
		assertEvaluatesTo(Integer.valueOf(0), 
				"if (false) 1");
	}
	
	/**
	 * @since 2.5
	 */
	@Test public void testIfExpression_09() throws Exception {
		assertEvaluatesTo(Long.valueOf(0), 
				"if (false) 1L");
	}
	
	@Test public void testBug342021_01() throws Exception {
		assertEvaluatesTo(Boolean.FALSE, 
				"{\n" +
				"  val Iterable<Object> branch = \n" + 
				"  if (true) \n" + 
				"    [|<Object>newArrayList().iterator]\n" + 
				"  else\n" + 
				"    newArrayList('a').toArray\n" +
				"  branch.iterator.hasNext\n" +
				"}");
	}
	
	@Test public void testBug342021_02() throws Exception {
		assertEvaluatesTo(Boolean.FALSE, 
				"{\n" +
				"  val Iterable<Object> branch = \n" + 
				"  if (true) \n" + 
				"    { [|<Object>newArrayList().iterator] }\n" + 
				"  else\n" + 
				"    { ''.toString { newArrayList('a').toArray } }\n" +
				"  branch.iterator.hasNext\n" +
				"}");
	}
	
	@Test public void testBug342021_03() throws Exception {
		assertEvaluatesTo(Boolean.TRUE, 
				"{\n" +
				"  val Iterable<Object> branch = \n" + 
				"  switch '' as Object {\n" + 
				"    Boolean: [|<Object>newArrayList().iterator]\n" + 
				"    String: newArrayList('a').toArray\n" +
				"  }\n" +
				"  branch.iterator.hasNext\n" +
				"}");
	}
	
	@Test public void testIfExpression_withThrowExpression_00() throws Exception {
		assertEvaluatesWithException(NullPointerException.class, "if (false) throw new NullPointerException() else throw new NullPointerException()");
	}
	
	@Test public void testIfExpression_withThrowExpression_01() throws Exception {
		assertEvaluatesWithException(NullPointerException.class, "if (false) 'then' else throw new NullPointerException()");
	}
	
	@Test public void testIfExpression_withThrowExpression_02() throws Exception {
		assertEvaluatesTo("then", "if (true) 'then' else throw new NullPointerException()");
	}
	
	@Test public void testIfExpression_withThrowExpression_03() throws Exception {
		assertEvaluatesWithException(NullPointerException.class, "if (false) 'then' else throw new NullPointerException");
	}
	
	/**
	 * @since 2.18
	 */
	@Test @Ignore public void testTernaryIf_1() throws Exception {
		assertEvaluatesTo(Integer.valueOf(20),
				"{ var number = (false)? new Double('-10') : new Integer('20') number.intValue }");
	}

	/**
	 * @since 2.18
	 */
	@Test @Ignore public void testTernaryIf_2() throws Exception {
		assertEvaluatesTo(Integer.valueOf(10),
				"{ var number = (true)? new Integer('10') : new Integer('20') number.intValue }");
	}

	/**
	 * @since 2.18
	 */
	@Test @Ignore public void testTernaryIf_3() throws Exception {
		assertEvaluatesTo(Integer.valueOf(3),
				"{ var number = (true)? (true)? new Integer('3') : new Integer('4') : new Integer('5') number.intValue }");
	}

	/**
	 * @since 2.18
	 */
	@Test @Ignore public void testTernaryIf_4() throws Exception {
		assertEvaluatesTo(Integer.valueOf(4),
				"{ var number = (true)? (!true)? new Integer('3') : new Integer('4') : new Integer('5') number.intValue }");
	}

	/**
	 * @since 2.18
	 */
	@Test @Ignore public void testTernaryIf_5() throws Exception {
		assertEvaluatesTo(Integer.valueOf(5),
				"{ var number = (!true)? (true)? new Integer('3') : new Integer('4') : new Integer('5') number.intValue }");
	}

	/**
	 * @since 2.18
	 */
	@Test @Ignore public void testTernaryIf_6() throws Exception {
		assertEvaluatesTo(Integer.valueOf(6),
				"{ var number = (!true)? new Integer('3') : (true)? new Integer('6') : new Integer('7') number.intValue }");
	}

	/**
	 * @since 2.18
	 */
	@Test @Ignore public void testTernaryIf_7() throws Exception {
		assertEvaluatesTo(Integer.valueOf(7),
				"{ var number = if (true) {(!true)? new Integer('3') : new Integer('7')} else new Integer('5') number.intValue }");
	}
	
	@Test public void testVariableDeclaration_01() throws Exception {
		assertEvaluatesTo("literal", "{var x = 'literal' x = x}");
	}
	
	@Test public void testVariableDeclaration_03() throws Exception {
		assertEvaluatesTo("literal", "{var String x x = 'literal' x}");
	}
	
	@Test public void testVariableDeclaration_04() throws Exception {
		assertEvaluatesTo("literal", "{var String x; x = 'literal'}");
	}
	
	@Test public void testVariableDeclaration_06() throws Exception {
		assertEvaluatesTo(Short.valueOf((short)0), "{var short s s}");
	}
	
	@Test public void testVariableDeclaration_07() throws Exception {
		assertEvaluatesTo(Character.valueOf((char)0), "{var char c c}");
	}
	
	@Test public void testVariableDeclaration_08() throws Exception {
		assertEvaluatesTo(Integer.valueOf(42), "{var int i i = 42 i}");
	}
	
	@Test public void testVariableDeclaration_09() throws Exception {
		assertEvaluatesTo(Boolean.FALSE, "{var boolean b b}");
	}
	
	@Test public void testVariableDeclaration_10() throws Exception {
		assertEvaluatesTo(Boolean.TRUE, "{var boolean b b = true b}");
	}
	
	@Test public void testVariableDeclaration_11() throws Exception {
		assertEvaluatesTo("FOO", "{var b = 'foo'.toUpperCase b}");
	}
	
	@Test public void testFeatureCall_01() throws Exception {
		assertEvaluatesTo("literal", "{var x = 'literal' x}");
	}
	
	@Test public void testFeatureCall_02() throws Exception {
		assertEvaluatesTo(new Character('a'), "'a'.toCharArray.iterator.next");
	}
	
	@Test public void testFeatureCall_03() throws Exception {
		assertEvaluatesTo(newArrayList(
				new Character('a'), 
				new Character('b'),
				new Character('c')), "{ var java.util.List<Character> x = ('abc'.toCharArray as Iterable<Character>).toList() x }");
	}
	
	@Test public void testFeatureCall_03_2() throws Exception {
		assertEvaluatesTo(newArrayList(
				new Character('a'), 
				new Character('b'),
				new Character('c')), "{ var java.util.List<Character> x = 'abc'.toCharArray x }");
	}
	
	@Test public void testFeatureCall_04() throws Exception {
		assertEvaluatesTo(new Integer("literal".length()), "{ var x = 'literal' x.length }");
	}
	
	@Test public void testConstructorCall_00() throws Exception {
		assertEvaluatesTo("", "new String()");
	}
	
	@Test public void testConstructorCall_01() throws Exception {
		assertEvaluatesTo("", "new String");
	}
	
	@Test public void testConstructorCall_02() throws Exception {
		assertEvaluatesTo("foobar", "new String('foobar')");
	}
	
	@Test public void testConstructorCall_04() throws Exception {
		assertEvaluatesTo("", "new java.lang.String");
	}
	
	@Test public void testConstructorCall_05() throws Exception {
		assertEvaluatesTo("twoArgs:12", 
				"new testdata.ClosureClient2(|'1') [|'2'].value");
	}
	
	@Test public void testConstructorCall_06() throws Exception {
		assertEvaluatesTo("varArgs:1", 
				"new testdata.ClosureClient2(|'1').value");
	}
	
	@Test public void testConstructorCall_07() throws Exception {
		assertEvaluatesTo("varArgs:1", 
				"new testdata.ClosureClient2 [|'1'].value");
	}
	
	@Test public void testConstructorCall_08() throws Exception {
		assertEvaluatesTo("varArgs:", 
				"(new testdata.ClosureClient2).value");
	}
	
	@Test public void testConstructorCall_09() throws Exception {
		assertEvaluatesTo("varArgs:", 
				"{new testdata.ClosureClient2}.value");
	}
	
	@Test public void testConstructorCall_10() throws Exception {
		assertEvaluatesTo("varArgs:123", 
				"new testdata.ClosureClient2([|'1'],[|'2']) [|'3'].value");
	}
	
	@Test public void testConstructorCall_11() throws Exception {
		assertEvaluatesTo("varArgs:", 
				"(((((new testdata.ClosureClient2))).value))");
	}
	
	@Test public void testConstructorCall_12() throws Exception {
		assertEvaluatesTo(Boolean.TRUE, 
				"{ new testdata.a.SameSimpleName new testdata.b.SameSimpleName } instanceof testdata.b.SameSimpleName");
	}
	
	@Test public void testConstructorCall_13() throws Exception {
		assertEvaluatesTo(Boolean.TRUE, 
				"{ var res = new testdata.a.SameSimpleName new testdata.b.SameSimpleName res } instanceof testdata.a.SameSimpleName");
	}
	
	@Test public void testAssignment_01() throws Exception {
		assertEvaluatesTo("newValue", "{var x = 'literal' x = 'newValue'}");
	}

	@Test public void testAssignment_02() throws Exception {
		assertEvaluatesTo("literal", 
				"{" +
				"  var x = new testdata.Properties1()" +
				"  x.prop1 = 'literal'" +
				"  x.prop1" +
				"}");
	}
	
	@Test public void testAssignment_03() throws Exception {
		assertEvaluatesTo("literal", 
				"{" +
				"  var x = new testdata.Properties1()" +
				"  x.prop2 = 'literal'" +
				"  x.prop2" +
				"}");
	}
	
	@Test public void testAssignment_04() throws Exception {
		assertEvaluatesTo("Integer: 1", 
				"{" +
				"  var x = new testdata.Properties1()" +
				"  x.prop2 = 1" +
				"  x.prop2" +
				"}");
	}
	
	@Test public void testAssignment_05() throws Exception {
		assertEvaluatesTo("literal", 
				"{" +
				"  var x = new testdata.Properties1()" +
				"  x.prop2 = 'literal'" +
				"  x.prop2" +
				"}");
	}
	
	@Test public void testAssignment_06() throws Exception {
		assertEvaluatesTo("Integer: 1", 
				"{" +
				"  var x = new testdata.Properties1()" +
				"  x.prop2 = 1" +
				"  x.prop2" +
				"}");
	}
	
	@Test public void testAssignment_07() throws Exception {
		assertEvaluatesTo(null, 
				"{" +
				"  var x = new testdata.Properties1()" +
				"  x.prop2 = 'literal'" +
				"  null" +
				"}");
	}
	
	@Test public void testAssignment_08() throws Exception {
		assertEvaluatesTo(null, 
				"{" +
				"  var x = new testdata.Properties1()" +
				"  x.prop2 = 1" +
				"  null" +
				"}");
	}
	
	@Test public void testAssignment_09() throws Exception {
		assertEvaluatesTo("Integer: 1", 
				"{" +
				"  var x = new testdata.Properties1()" +
				"  x.prop3 = 1" +
				"}");
	}
	
	@Test public void testAssignment_10() throws Exception {
		assertEvaluatesTo("literal", 
				"{" +
				"  var x = new testdata.Properties1()" +
				"  x.prop1 = 'literal'" +
				"}");
	}
	
	@Test public void testAssignment_11() throws Exception {
		assertEvaluatesTo("literal", 
				"{" +
				"  var list = new testdata.GenericType1<String>()" +
				"  list += 'literal'" +
				"  list.get()" +
				"}");
	}
	
	@Test public void testAssignment_12() throws Exception {
		assertEvaluatesTo(Boolean.TRUE, 
				"{" +
				"  var list = new testdata.GenericType1<String>()" +
				"  list += 'literal'" +
				"}");
	}
	
	@Test public void testAssignment_13() throws Exception {
		assertEvaluatesTo("literal", 
				"{" +
				"  var x = new testdata.Properties2()" +
				"  x.prop2 = 'literal'" +
				"  x.prop2" +
				"}");
	}
	
	@Test public void testAssignment_14() throws Exception {
		assertEvaluatesTo("literal", 
				"{" +
				"  var x = new testdata.Properties1" +
				"  x.prop1 = 'literal'" +
				"  x.prop1" +
				"}");
	}
	
	@Test public void testAssignment_15() throws Exception {
		assertEvaluatesTo("literal", 
				"{" +
				"  var list = new testdata.GenericType1<String>" +
				"  list += 'literal'" +
				"  list.get()" +
				"}");
	}
	
	@Test public void testAssignment_16() throws Exception {
		assertEvaluatesTo("literal", 
				"{" +
				"  var it = new testdata.Properties1()" +
				"  prop1 = 'literal'" +
				"  prop1" +
				"}");
	}
	
	@Test public void testAssignment_17() throws Exception {
		assertEvaluatesTo("literal", 
				"{" +
				"  var it = new testdata.Properties1()" +
				"  prop2 = 'literal'" +
				"  prop2" +
				"}");
	}
	
	@Test public void testAssignment_18() throws Exception {
		assertEvaluatesTo("Integer: 1", 
				"{" +
				"  var it = new testdata.Properties1()" +
				"  prop2 = 1" +
				"  prop2" +
				"}");
	}
	
	@Test public void testAssignment_19() throws Exception {
		assertEvaluatesTo("literal", 
				"{" +
				"  var it = new testdata.Properties1()" +
				"  prop2 = 'literal'" +
				"  prop2" +
				"}");
	}
	
	@Test public void testAssignment_20() throws Exception {
		assertEvaluatesTo("Integer: 1", 
				"{" +
				"  var it = new testdata.Properties1()" +
				"  prop2 = 1" +
				"  prop2" +
				"}");
	}
	
	@Test public void testAssignment_21() throws Exception {
		assertEvaluatesTo(null, 
				"{" +
				"  var it = new testdata.Properties1()" +
				"  prop2 = 'literal'" +
				"  null" +
				"}");
	}
	
	@Test public void testAssignment_22() throws Exception {
		assertEvaluatesTo(null, 
				"{" +
				"  var it = new testdata.Properties1()" +
				"  prop2 = 1" +
				"  null" +
				"}");
	}
	
	@Test public void testAssignment_23() throws Exception {
		assertEvaluatesTo("Integer: 1", 
				"{" +
				"  var it = new testdata.Properties1()" +
				"  prop3 = 1" +
				"}");
	}
	
	@Test public void testAssignment_24() throws Exception {
		assertEvaluatesTo("literal", 
				"{" +
				"  var it = new testdata.Properties1()" +
				"  prop1 = 'literal'" +
				"}");
	}
	
	@Test public void testAssignment_25() throws Exception {
		assertEvaluatesTo("literal", 
				"{" +
				"  var it = new testdata.GenericType1<String>()" +
				"  it += 'literal'" +
				"  get()" +
				"}");
	}
	
	@Test public void testAssignment_26() throws Exception {
		assertEvaluatesTo(Boolean.TRUE, 
				"{" +
				"  var it = new testdata.GenericType1<String>()" +
				"  it += 'literal'" +
				"}");
	}
	
	@Test public void testAssignment_27() throws Exception {
		assertEvaluatesTo("literal", 
				"{" +
				"  var it = new testdata.Properties2()" +
				"  prop2 = 'literal'" +
				"  prop2" +
				"}");
	}
	
	@Test public void testAssignment_28() throws Exception {
		assertEvaluatesTo("literal", 
				"{" +
				"  var it = new testdata.Properties1" +
				"  prop1 = 'literal'" +
				"  prop1" +
				"}");
	}
	
	@Test public void testAssignment_29() throws Exception {
		assertEvaluatesTo("literal", 
				"{" +
				"  var it = new testdata.GenericType1<String>" +
				"  it += 'literal'" +
				"  get()" +
				"}");
	}
	
	@Test public void testAssignment_30() throws Exception {
		assertEvaluatesTo(Integer.valueOf(0), 
				"{" +
				"  var client = new testdata.CoercionClient" +
				"  client.comparator = [ s1, s2 | s1.compareTo(s2) ]" +
				"  client.compare('', '')" +
				"}");
	}
	
	@Test public void testAssignment_31() throws Exception {
		assertEvaluatesTo(Integer.valueOf(0), 
				"{" +
				"  var it = new testdata.CoercionClient" +
				"  comparator = [ s1, s2 | s1.compareTo(s2) ]" +
				"  compare('', '')" +
				"}");
	}
	
	@Test public void testAssignment_32() throws Exception {
		assertEvaluatesTo(Integer.valueOf(1), 
				"{" +
				"  var client = new testdata.CoercionClient" +
				"  client.array = newArrayList(1)" +
				"  client.array.head" +
				"}");
	}
	
	@Test public void testAssignment_33() throws Exception {
		assertEvaluatesTo(Integer.valueOf(1), 
				"{" +
				"  var it = new testdata.CoercionClient" +
				"  array = newArrayList(1)" +
				"  array.head" +
				"}");
	}
	
	@Test public void testAssignment_34() throws Exception {
		assertEvaluatesTo("a", 
				"{" +
				"  var client = new testdata.CoercionClient" +
				"  client.varArgArray = newArrayList('a')" +
				"  client.array.head" +
				"}");
	}
	
	@Test public void testAssignment_35() throws Exception {
		assertEvaluatesTo("a", 
				"{" +
				"  var it = new testdata.CoercionClient" +
				"  varArgArray = newArrayList('a')" +
				"  array.head" +
				"}");
	}
	
	@Test public void testAssignment_36() throws Exception {
		assertEvaluatesTo(Integer.valueOf(0), 
				"{" +
				"  var client = new testdata.CoercionClient" +
				"  client.comparatorField = [ s1, s2 | s1.compareTo(s2) ]" +
				"  client.compare('', '')" +
				"}");
	}
	
	@Test public void testAssignment_37() throws Exception {
		assertEvaluatesTo(Integer.valueOf(0), 
				"{" +
				"  var it = new testdata.CoercionClient" +
				"  comparatorField = [ s1, s2 | s1.compareTo(s2) ]" +
				"  compare('', '')" +
				"}");
	}
	
	@Test public void testAssignment_38() throws Exception {
		assertEvaluatesTo(Integer.valueOf(0), 
				"{" +
				"  var java.util.Comparator<String> c = null" +
				"  c = [ s1, s2 | s1.compareTo(s2) ]" +
				"  c.compare('', '')" +
				"}");
	}
	
	@Test public void testAssignment_39() throws Exception {
		assertEvaluatesTo(newArrayList("bar"), 
				"{"
				+ "  val list = newArrayList('foo','bar')"
				+ "  list -= 'foo'"
				+ "  list"
				+ "}");
	}
	
	@Test public void testAssignment_40() throws Exception {
		assertEvaluatesTo(emptyList(), 
				"{"
				+ "  val list = newArrayList('foo','bar')"
				+ "  list -= #['foo', 'bar']"
				+ "  list"
				+ "}");
	}
	
	@Test public void testAssignmentInBlock_01() throws Exception {
		assertEvaluatesTo("newValue", "{var x = 'literal' { x = 'newValue' } x }");
	}
	
	@Test public void testThrowInBlock() throws Exception {
		assertEvaluatesWithException(NullPointerException.class, "{ throw new NullPointerException() }");
	}
	
	@Test public void testThrowInBlock_01() throws Exception {
		assertEvaluatesWithException(NullPointerException.class, "{ 42.toString() throw new NullPointerException() }");
	}
	
	@Test public void testThrowInBlock_02() throws Exception {
		assertEvaluatesWithException(NullPointerException.class, "{ throw new NullPointerException }");
	}
	
	@Test public void testForLoop_01() throws Exception {
		assertEvaluatesTo(new Character('c'), 
				"{\n" +
				"  var Character result = null\n" +
				"  for(x: 'abc'.toCharArray) result = x\n" +
				"  result" +
				"}");
	}
	
	@Test public void testForLoop_02() throws Exception {
		assertEvaluatesTo(new Character('a'), 
				"{\n" +
				"  var Character result = null\n" +
				"  for(x: 'aba'.toCharArray) if (result == null) result = x\n" +
				"  result" +
				"}");
	}

	@Test public void testForLoop_03() throws Exception {
		assertEvaluatesWithException(ClassCastException.class, "{for(x: 'abc' as Object as java.util.List<Character>) x.hashCode() null}");
	}
	
	@Test public void testForLoop_04() throws Exception {
		assertEvaluatesTo("foobar", 
				"{ " +
				" val list = new java.util.ArrayList<String>()" +
				" list += 'bar'" +
				" var result = 'foo'" +
				" for( e : list) result = result + e" +
				" result" +
				"}");
	}
	
	@Test public void testForLoop_05() throws Exception {
		assertEvaluatesTo("foobar", 
				"{ " +
				" val list = new java.util.ArrayList<String>" +
				" list += 'bar'" +
				" var result = 'foo'" +
				" for( e : list) result = result + e" +
				" result" +
				"}");
	}
	
	@Test public void testForLoop_06() throws Exception {
		String expr = 
			    "{\n" + 
				"   val list = newArrayList('foo','bar','baz')\n" + 
				"   for (x : list.reverse) {\n" + 
				"	  x.toUpperCase\n" + 
				"   }\n" +
				"   null" + 
				"}";
		assertEvaluatesTo(null, expr);
	}
	
	@Test public void testForLoop_07() throws Exception {
		String expr = 
			    "{\n" + 
				"   val list = newArrayList('foo','bar','baz')\n" + 
				"   for (String x : list.reverse) {\n" + 
				"	  x.toUpperCase\n" + 
				"   }\n" +
				"   null" + 
				"}";
		assertEvaluatesTo(null, expr);
	}
	
	@Test public void testForLoop_08() throws Exception {
		assertEvaluatesTo(new Character('c'), 
				"{\n" +
				"  var Character result = null\n" +
				"  for(char x: 'abc'.toCharArray) result = x\n" +
				"  result" +
				"}");
	}
	
	@Test public void testForLoop_09() throws Exception {
		assertEvaluatesTo(new Character('a'), 
				"{\n" +
				"  var Character result = null\n" +
				"  for(char x: 'abc'.toCharArray) if (result == null) result = x\n" +
				"  result" +
				"}");
	}
	
	@Test public void testForLoop_10() throws Exception {
		assertEvaluatesTo(new Character('c'), 
				"{\n" +
				"  var char result\n" +
				"  for(Character x: 'abc'.toCharArray) result = x\n" +
				"  result" +
				"}");
	}
	
	@Test public void testForLoop_11() throws Exception {
		assertEvaluatesTo(Integer.valueOf(1+2+3+4+5+6+7+8+9+10), 
				"{\n" +
				"  var int result\n" +
				"  for(int i: 1..10) result = result + i\n" +
				"  result" +
				"}");
	}
	
	@Test public void testForLoop_12() throws Exception {
		assertEvaluatesTo("foobar", 
				"{\n" +
				" val java.util.List list = new java.util.ArrayList<String>" +
				" list += 'bar'" +
				" var result = 'foo'" +
				" for( e : list) result = result + e" +
				" result" +
				"}");
	}
	
	@Test public void testForLoop_13() throws Exception {
		assertEvaluatesTo("foobar", 
				"{\n" +
				" val java.util.List list = new java.util.ArrayList<String>" +
				" list += 'bar'" +
				" var result = 'foo'" +
				" for(Object e : list) result = result + e" +
				" result" +
				"}");
	}
	
	@Test public void testForLoop_14() throws Exception {
		assertEvaluatesTo(new Character('c'), 
				"{\n" +
				"  var Character result = null\n" +
				"  for(char x: 'abc'.toCharArray.toList) result = x\n" +
				"  result" +
				"}");
	}
	
	@Test public void testForLoop_15() throws Exception {
		assertEvaluatesTo(new Character('a'), 
				"{\n" +
				"  var Character result = null\n" +
				"  for(x: 'abc'.toCharArray.toList) if (result == null) result = x\n" +
				"  result" +
				"}");
	}
	
	@Test public void testForLoop_16() throws Exception {
		assertEvaluatesTo(new Character('a'), 
				"{\n" +
				"  var Character result = null\n" +
				"  for(int i: 'abc'.toCharArray) if (result == null) result = i as char\n" +
				"  result" +
				"}");
	}
	
	@Test public void testFunctionConversion_00() throws Exception {
		assertEvaluatesTo("foo",
				"([|newArrayList('foo').iterator] as Iterable<String>).iterator.next");
	}
	
	@Test public void testWhileLoop_01() throws Exception {
		assertEvaluatesTo("newValue", 
				"{\n" +
				"  var value = 'oldValue'\n" +
				"  var condition = true\n" +
				"  while(condition) { value = 'newValue' condition=false }" +
				"  value" +
				"}");
	}
	
	@Test public void testWhileLoop_02() throws Exception {
		assertEvaluatesTo("oldValue", 
				"{\n" +
				"  var value = 'oldValue'\n" +
				"  var condition = false\n" +
				"  while(condition) { value = 'newValue' condition=false }" +
				"  value" +
				"}");
	}
	
	@Test public void testWhileLoop_03() throws Exception {
		assertEvaluatesTo("startfoo", 
				"{\n" +
				"  var value = 'start'\n" +
				"  while(value.length<6) " +
				"     value = value + 'foo'" +
				"  value" +
				"}");
	}
	
	/**
	 * @since 2.5
	 */
	@Test public void testWhileLoop_04() throws Exception {
		assertEvaluatesTo("hello", "{ val CharSequence x = new StringBuilder; while (x instanceof Appendable) { x.append('hello') return x.toString } x.toString }");
	}
	
	@Test public void testDoWhileLoop_01() throws Exception {
		assertEvaluatesTo("newValue", 
				"{\n" +
				"  var value = 'oldValue'\n" +
				"  var condition = true\n" +
				"  do {" +
				"	 value ='newValue'" +
				"    condition = false" +
				"  } while(condition)" +
				"  value" +
				"}");
	}
	
	@Test public void testDoWhileLoop_02() throws Exception {
		assertEvaluatesTo("newValue", 
				"{\n" +
				"  var value = 'oldValue'\n" +
				"  var condition = false\n" +
				"  do {" +
				"	 value = 'newValue'" +
				"  } while(condition)" +
				"  value" +
				"}");
	}
	
	/**
	 * @since 2.6
	 */
	@Test public void testXBasicForLoopExpression_01() throws Exception {
		assertEvaluatesTo("newValue", 
				"{\n" +
				"  var result = 'oldValue'\n"+
				"  for (var condition = true; condition; condition = false) {\n" +
				"    result = 'newValue'\n" +
				"  }\n" +
				"  result\n" + 
				"}");
	}
	
	/**
	 * @since 2.6
	 */
	@Test public void testXBasicForLoopExpression_02() throws Exception {
		assertEvaluatesTo("oldValue", 
				"{\n" +
				"  var result = 'oldValue'\n"+
				"  for (var condition = false; condition; condition = false) {\n" +
				"    result = 'newValue'\n" +
				"  }\n" +
				"  result\n" + 
				"}");
	}
	
	/**
	 * @since 2.6
	 */
	@Test public void testXBasicForLoopExpression_03() throws Exception {
		assertEvaluatesTo("foo", 
				"{\n" +
				"  val value = 'foo'\n" +
				"  for (var i = 0; i < 10; i = i + 1) {\n" +
				"    if (i == 3) {\n" +
				"      return value\n" +
				"    }\n" +
				"  }\n" +
				"  'bar'\n" + 
				"}");
	}
	
	/**
	 * @since 2.6
	 */
	@Test public void testXBasicForLoopExpression_03_1() throws Exception {
		assertEvaluatesTo("foo", 
				"{\n" +
				"  var String value\n" +
				"  var int i\n" +
				"  for (value = 'foo', i = 0; i < 10; i = i + 1) {\n" +
				"    if (i == 3) {\n" +
				"      return value\n" +
				"    }\n" +
				"  }\n" +
				"  'bar'\n" + 
				"}");
	}
	
	/**
	 * @since 2.6
	 */
	@Test public void testXBasicForLoopExpression_04() throws Exception {
		assertEvaluatesTo("hello", 
				"{\n" +
				"  for (val CharSequence x = new StringBuilder; x instanceof Appendable; x.append('hello')) {\n" +
				"    if (x.length != 0) {\n" +
				"      return x.toString\n" +
				"    }\n" +
				"  }\n" +
				"  'bar'\n" +
				"}");
	}
	
	/**
	 * @since 2.6
	 */
	@Test public void testXBasicForLoopExpression_05() throws Exception {
		assertEvaluatesTo("hello", 
				"{\n" +
				"  for (val Appendable x = new StringBuilder; x instanceof CharSequence; x.append('hello')) {\n" +
				"    if (x.length != 0) {\n" +
				"      return x.toString\n" +
				"    }\n" +
				"  }\n" +
				"  'bar'\n" +
				"}");
	}
	
	/**
	 * @since 2.6
	 */
	@Test public void testXBasicForLoopExpression_06() throws Exception {
		assertEvaluatesTo(Integer.valueOf(1+2+3+4+5+6+7+8+9+10), 
				"{\n" +
				"  var int result\n"+
				"  for (var i = 1; i <= 10; i = i + 1) {\n" +
				"    result = result + i\n" +
				"  }\n" + 
				"  result\n" + 
				"}");
	}
	
	/**
	 * @since 2.6
	 */
	@Test public void testXBasicForLoopExpression_07() throws Exception {
		assertEvaluatesTo(Integer.valueOf(1+2+3+4+5+6+7+8+9+10), 
				"{\n" +
				"  var int result\n"+
				"  for (var i = 1; i <= 10; result = result + i, i = i + 1) {}\n" +
				"  result\n" + 
				"}");
	}
	
	/**
	 * @since 2.6
	 */
	@Test public void testXBasicForLoopExpression_08() throws Exception {
		assertEvaluatesTo("foobar", 
				"{\n" +
				"  val list = new java.util.ArrayList<String>\n" +
				"  list += 'bar'\n" +
				"  var result = 'foo'\n" +
				"  for (var i = 0; i < list.size; i = i + 1) {\n" +
				"    result = result + list.get(i)\n" +
				"  }\n" + 
				"  result\n" + 
				"}");
	}
	
	/**
	 * @since 2.6
	 */
	@Test public void testXBasicForLoopExpression_09() throws Exception {
		assertEvaluatesTo("foobar", 
				"{\n" +
				"  val list = new java.util.ArrayList<String>\n" +
				"  list += 'bar'\n" +
				"  var result = 'foo'\n" +
				"  for (var i = 0; i < list.size; result = result + list.get(i), i = i + 1) {}\n" +
				"  result\n" + 
				"}");
	}
	
	/**
	 * @since 2.6
	 */
	@Test public void testXBasicForLoopExpression_10() throws Exception {
		assertEvaluatesTo(new Character('c'), 
				"{\n" +
				"  var Character result = null\n" +
				"  val abc = 'abc'.toCharArray\n" +
				"  for (var i = 0; i < abc.size; i = i + 1) {\n" +
				"    result = abc.get(i)\n" +
				"  }\n" + 
				"  result\n" + 
				"}");
	}
	
	/**
	 * @since 2.6
	 */
	@Test public void testXBasicForLoopExpression_11() throws Exception {
		assertEvaluatesTo(new Character('c'), 
				"{\n" +
				"  var Character result = null\n" +
				"  val abc = 'abc'.toCharArray\n" +
				"  for (var i = 0; i < abc.size; result = abc.get(i), i = i + 1) {}\n" +
				"  result\n" + 
				"}");
	}
	
	/**
	 * @since 2.6
	 */
	@Test public void testXBasicForLoopExpression_12() throws Exception {
		assertEvaluatesTo(new Character('a'), 
				"{\n" +
				"  var Character result = null\n" +
				"  val abc = 'abc'.toCharArray\n" +
				"  for (var i = 0; i < abc.size; i = i + 1) {\n" +
				"    if (result == null) {\n" +
				"      result = abc.get(i)\n" +
				"    }\n" +
				"  }\n" + 
				"  result\n" + 
				"}");
	}
	
	/**
	 * @since 2.6
	 */
	@Test public void testXBasicForLoopExpression_13() throws Exception {
		assertEvaluatesTo(new Character('a'), 
				"{\n" +
				"  var Character result = null\n" +
				"  val abc = 'abc'.toCharArray\n" +
				"  for (var i = 0; i < abc.size; if (result == null) { result = abc.get(i) }, i = i + 1) {}\n" + 
				"  result\n" + 
				"}");
	}
	
	/**
	 * @since 2.6
	 */
	@Test public void testXBasicForLoopExpression_14() throws Exception {
		assertEvaluatesTo(Boolean.TRUE, 
				"{\n" +
				"  var condition = true\n" + 
				"  for (;condition;) { return true }\n" +
				"  false\n" +
				"}");
	}
	
	/**
	 * @since 2.6
	 */
	@Test public void testXBasicForLoopExpression_15() throws Exception {
		assertEvaluatesTo(8, 
				"{\n" +
				"  for (var i = 0; i < 10; i = i + 1) { if (i == 8) { return i } };\n" +
				"  -1\n" +
				"}");
	}
	
	/**
	 * @since 2.6
	 */
	@Test public void testXBasicForLoopExpression_16() throws Exception {
		assertEvaluatesTo(8, 
				"{\n" +
				"  for (var i = 0; i < 10; i += 1) { if (i == 8) { return i } };\n" +
				"  -1\n" +
				"}");
	}
	
	@Test public void testMemberFeatureCall_01() throws Exception {
		assertEvaluatesTo("LITERAL", "'literal'.toUpperCase()");
	}
	
	@Test public void testMemberFeatureCall_02() throws Exception {
		assertEvaluatesTo("literal", "'literal'.toUpperCase().toLowerCase()");
	}
	
	@Test public void testMemberFeatureCall_03() throws Exception {
		assertEvaluatesTo("source", "new java.util.EventObject('source').source");
	}
	
	@Test public void testMemberFeatureCall_04() throws Exception {
		assertEvaluatesTo("literal", 
				"{" +
				"  var fieldAccess = new testdata.FieldAccess()" +
				"  fieldAccess.stringField = 'literal'" +
				"}");
	}
	
	@Test public void testMemberFeatureCall_05() throws Exception {
		assertEvaluatesTo("literal", 
				"{" +
				"  var fieldAccess = new testdata.FieldAccess()" +
				"  fieldAccess.stringField = 'literal'" +
				"  fieldAccess.stringField" +
				"}");
	}
	
	@Test public void testMemberFeatureCall_06() throws Exception {
		assertEvaluatesTo(null, 
				"{" +
				"  var fieldAccess = new testdata.FieldAccess()" +
				"  fieldAccess.stringField" +
				"}");
	}
	
	@Test public void testMemberFeatureCall_07() throws Exception {
		assertEvaluatesTo("finalField", 
				"new testdata.FieldAccess().finalField");
	}
	
	@Test public void testNullSafeOperator_01() throws Exception {
		assertEvaluatesWithException(NullPointerException.class, "(null as Object).toString()");
		assertEvaluatesWithException(NullPointerException.class, "(null as Object)?.toString().toString()");
	}
	
	@Test public void testNullSafeOperator_02() throws Exception {
		assertEvaluatesTo(null, "(null as Object)?.toString()");
		assertEvaluatesTo(null, "(null as Object)?.toString()?.toString()");
	}
	
	/**
	 * @since 2.3
	 */
	@Test public void testNullSafeFieldAccess_0() throws Exception {
		assertEvaluatesWithException(NullPointerException.class, "new testdata.FieldAccess().stringField.toUpperCase");
	}

	/**
	 * @since 2.3
	 */
	@Test public void testNullSafeFieldAccess_1() throws Exception {
		assertEvaluatesTo(null, "new testdata.FieldAccess()?.stringField?.toUpperCase");
	}
	
	@Test public void testNullSafeFieldAccess_2() throws Exception {
		assertEvaluatesTo(null, "new testdata.FieldAccess?.stringField?.toUpperCase");
	}
	
	@Ignore("TODO see https://bugs.eclipse.org/bugs/show_bug.cgi?id=341048")
	@Test public void testSpreadOperator_01() throws Exception {
		assertEvaluatesWithException(NullPointerException.class, "(null as java.util.List<Object>)*.toString()");
		assertEvaluatesWithException(ClassCastException.class, "(new Object() as java.util.List<Object>)*.toString()");
	}
	
	@Ignore("TODO see https://bugs.eclipse.org/bugs/show_bug.cgi?id=341048")
	@Test public void testSpreadOperator_02() throws Exception {
		assertEvaluatesTo(newArrayList(
				"A", "B", "C"), "('abc'.toCharArray as Iterable<Character>)*.toString*.toUpperCase");
	}
	
	@Test public void testSwitchExpression_01() throws Exception {
		assertEvaluatesTo(null, "switch 'x' { case false: 'literal' }");
	}
	
	@Test public void testSwitchExpression_02() throws Exception {
		assertEvaluatesTo("literal", "switch 'x' { case 'x': 'literal' }");
	}
	
	@Test public void testSwitchExpression_03() throws Exception {
		assertEvaluatesTo("literal", "switch 'x' { case 'y': 'foo' default : 'literal' }");
	}
	
	@Test public void testSwitchExpression_04() throws Exception {
		assertEvaluatesTo("x", "switch x:'x' { case x.length==3 : 'xxx' default : 'x' }");
	}
	
	@Test public void testSwitchExpression_05() throws Exception {
		assertEvaluatesTo(null, "switch new Object() { String : 'literal' }");
	}
	
	@Test public void testSwitchExpression_06() throws Exception {
		assertEvaluatesTo("literal", "switch new Object() { Object : 'literal' }");
	}
	
	@Test public void testSwitchExpression_07() throws Exception {
		assertEvaluatesTo("literal", "switch new Object() { case false: null default: 'literal' }");
	}
	
	@Test public void testSwitchExpression_08() throws Exception {
		assertEvaluatesTo("literal", "switch x : new Object() { case false: null case x!=null: 'literal' }");
	}
	
	@Test public void testSwitchExpression_09() throws Exception {
		assertEvaluatesTo(4, "switch 'foo' { case 'foo': 4 String: 3 }");
	}
	
	@Test public void testSwitchExpression_10() throws Exception {
		assertEvaluatesTo(3, "switch 'foo' as Object { Boolean case 'foo': 4 String: 3 }");
	}
	
	@Test public void testSwitchExpression_11() throws Exception {
		assertEvaluatesTo(3, "switch new java.util.ArrayList<String>() { java.util.Set<String> : 5 java.util.List<String>: 3 }");
	}
	
	@Test public void testSwitchExpression_12() throws Exception {
		assertEvaluatesTo("bar", "switch 'foo' { case 'bar' : return 'foo' default : 'bar' }");
	}
	
	@Test public void testSwitchExpression_13() throws Exception {
		assertEvaluatesTo("bar", "switch 'foo' { case 'bar' : 'foo' default : return 'bar' }");
	}
	
	@Test public void testSwitchExpression_14() throws Exception {
		assertEvaluatesTo("bar", "{ val _string = 'foo' switch _string { String : 'bar' default : 'foo'} }");
	}
	
	@Test public void testSwitchExpression_15() throws Exception {
		assertEvaluatesTo("bar", "switch x : 'foo' { String : switch x { String : 'bar' default : 'other' } default : 'foo'}");
	}
	
	/**
	 * @since 2.3
	 */
	@Test public void testSwitchExpression_16() throws Exception {
		assertEvaluatesTo("bar", "switch 'foo'.toCharArray { char[]: 'bar' default: 'foo' }");
	}
	
	@Test public void testSwitchExpression_17() throws Exception {
		assertEvaluatesTo("literal", "switch new Object { Object : 'literal' }");
	}
	
	@Test public void testSwitchExpression_18() throws Exception {
		assertEvaluatesTo("literal", "switch (x : new Object) { Object : 'literal' }");
	}
	
	@Test public void testSwitchExpression_19() throws Exception {
		assertEvaluatesTo("foo", "switch (x : 'foo' as Object) { String : x }");
	}
	
	@Test public void testSwitchExpression_20() throws Exception {
		assertEvaluatesTo("success", 
				"{ val Class<?> it = typeof(String) switch x : newInstance { String case x.length==0 : 'success'}}");
	}
	
	@Test public void testSwitchExpression_21() throws Exception {
		assertEvaluatesTo(42, "switch 'foo' { case 'bar': return 1 default: return 42 }");
	}
	
	@Test public void testSwitchExpression_22() throws Exception {
		assertEvaluatesTo(42, "switch 'foo' { case 'bar': 1 default: return 42 }");
	}
	
	@Test public void testSwitchExpression_23() throws Exception {
		assertEvaluatesTo(42, "switch 'foo' { case 'bar': return 1 default: 42 }");
	}
	
	@Test public void testSwitchExpression_24() throws Exception {
		assertEvaluatesTo(Character.valueOf('b'), 
				"{\n" + 
				"    val Comparable<?> c = 'abc'\n" + 
				"    switch c {\n" + 
				"        CharSequence: switch(c) {\n" + 
				"             java.io.Serializable: {\n" + 
				"                 c.charAt(1)\n" + 
				"             }\n" + 
				"         }\n" + 
				"    }\n" + 
				"}");
	}
	
	@Test public void testSwitchExpression_25() throws Exception {
		assertEvaluatesTo(0, 
				"{ val Object o = '' switch x : o { String : x.length }}");
	}
	
	/**
	 * @since 2.5
	 */
	@Test public void testSwitchExpression_26() throws Exception {
		assertEvaluatesTo(Boolean.TRUE, 
				"{ val policy = java.lang.annotation.RetentionPolicy.SOURCE switch policy { case SOURCE: true } }");
	}
	
	/**
	 * @since 2.5
	 */
	@Test public void testSwitchExpression_27() throws Exception {
		assertEvaluatesTo(Boolean.FALSE, 
				"{ val Object policy = java.lang.annotation.RetentionPolicy.SOURCE switch policy { java.lang.annotation.RetentionPolicy case CLASS: true } }");
	}
	
	/**
	 * @since 2.5
	 */
	@Test public void testSwitchExpression_28() throws Exception {
		assertEvaluatesTo(6, 
				"switch it : 'abcdef' as Object { String : length }");
	}
	
	/**
	 * @since 2.5
	 */
	@Test public void testSwitchExpression_29() throws Exception {
		assertEvaluatesTo("a", 
				"{ var Object o = ''\n" +
				"  switch o { String : o = 'a' }\n" +
				"  o\n" +
				"}");
	}
	
	/**
	 * @since 2.5
	 */
	@Test public void testSwitchExpression_30() throws Exception {
		assertEvaluatesTo("Abcdef", 
				"switch it : 'abcdef' as Object { String : toFirstUpper }");
	}
	
	/**
	 * @since 2.5
	 */
	@Test public void testSwitchExpression_31() throws Exception {
		assertEvaluatesTo(1, 
				"{ val int[] myArray = #[1,2] switch it : myArray as Object { int[] : it.get(0) default : 42 }}");
	}
	
	/**
	 * @since 2.5
	 */
	@Test public void testSwitchExpression_32() throws Exception {
		assertEvaluatesTo(1, 
				"{ val int[][] myArray = #[#[1,2]] switch it : myArray as Object { int[][] : it.get(0).get(0) default : 42 }}");
	}
	
	@Test public void testSwitchExpression_33() throws Exception {
		assertEvaluatesTo(1, 
				"{ switch x : 0 { case 0: 1 " +
								"case 1, case 2: 2 " +
								"case 3, default: 3 } }");
	}
	
	@Test public void testSwitchExpression_34() throws Exception {
		assertEvaluatesTo(2, 
				"{ switch x : 1 { case 0: 1 " +
								"case 1, case 2: 2 " +
								"case 3, default: 3 } }");
	}
	
	@Test public void testSwitchExpression_35() throws Exception {
		assertEvaluatesTo(2, 
				"{ switch x : 2 { case 0: 1 " +
								"case 1, case 2: 2 " +
								"case 3, default: 3 } }");
	}
	
	@Test public void testSwitchExpression_36() throws Exception {
		assertEvaluatesTo(3, 
				"{ switch x : 3 { case 0: 1 " +
								"case 1, case 2: 2 " +
								"case 3, default: 3 } }");
	}
	
	@Test public void testSwitchExpression_37() throws Exception {
		assertEvaluatesTo(3,
				"{ switch x : 4 { case 0: 1 " +
								"case 1, case 2: 2 " +
								"case 3, default: 3 } }");
	}

	@Test public void testSwitchExpression_38() throws Exception {
		assertEvaluatesTo(1, 
				"{ switch x : 'a' { case 'a': 1 " +
									"case 'b', case 'c': 2 " +
									"case 'd', default: 3 " +
				"} }");
	}
	
	@Test public void testSwitchExpression_39() throws Exception {
		assertEvaluatesTo(2, 
				"{ switch x : 'b' { case 'a': 1 " +
									"case 'b', case 'c': 2 " +
									"case 'd', default: 3 " +
				"} }");
	}
	
	@Test public void testSwitchExpression_40() throws Exception {
		assertEvaluatesTo(2, 
				"{ switch x : 'c' { case 'a': 1 " +
									"case 'b', case 'c': 2 " +
									"case 'd', default: 3 " +
				"} }");
	}
	
	@Test public void testSwitchExpression_41() throws Exception {
		assertEvaluatesTo(3, 
				"{ switch x : 'd' { case 'a': 1 " +
									"case 'b', case 'c': 2 " +
									"case 'd', default: 3 " +
				"} }");
	}
	
	@Test public void testSwitchExpression_42() throws Exception {
		assertEvaluatesTo(3, 
				"{ switch x : 'e' { case 'a': 1 " +
									"case 'b', case 'c': 2 " +
									"case 'd', default: 3 " +
				"} }");
	}
	
	@Test public void testSwitchExpression_44() throws Exception {
		assertEvaluatesTo(0, 
				"{ switch x : 'lalala' as Object { String, Integer case 1: 0 " +
												"Integer, default: 1 } }");
	}
	
	@Test public void testSwitchExpression_45() throws Exception {
		assertEvaluatesTo(1, 
				"{ switch x : Integer.valueOf(2) as Object { String, Integer case 1: 0 " +
												"Integer, default: 1 } }");
	}
	
	@Test public void testSwitchExpression_46() throws Exception {
		assertEvaluatesTo(null, "{ switch 1 { } }");
	}
	
	@Test public void testSwitchExpression_47() throws Exception {
		assertEvaluatesTo(null, "{ switch 1 { default: { } } }");
	}
	
	@Test public void testSwitchExpression_48() throws Exception {
		assertEvaluatesTo(null, "{ switch Object { } }");
	}
	
	@Test public void testSwitchExpression_49() throws Exception {
		assertEvaluatesTo(null, "{ switch Object { default: { } } }");
	}
	
	@Test public void testSwitchExpression_50() throws Exception {
		assertEvaluatesTo(null, "{ switch Thread.State.NEW { } }");
	}
	
	@Test public void testSwitchExpression_51() throws Exception {
		assertEvaluatesTo(null, "{ switch Thread.State.NEW { default: { } } }");
	}
	
	@Test public void testSwitchExpression_52() throws Exception {
		assertEvaluatesTo(null, "{ switch Object x : Thread.State.NEW { default: { } } }");
	}
	
	@Test public void testSwitchExpression_53() throws Exception {
		assertEvaluatesTo(null, "{ switch Thread.State x\n : Thread.State.NEW { default: { } } }");
	}
	
	@Test public void testSwitchExpression_54() throws Exception {
		assertEvaluatesTo(null, "{ switch (Object x : Thread.State.NEW) { default: { } } }");
	}
	
	@Test public void testSwitchExpression_55() throws Exception {
		assertEvaluatesTo(null, "{ switch (Thread.State x : Thread.State.NEW) { default: { } } }");
	}

	@Test public void testSwitchExpressionOverEnum() throws Exception {
		assertEvaluatesTo(1, 
				"{\n" +
					"val java.lang.Thread.State x = null\n" +
					"var result = 1\n" +
					"switch x { case NEW: { result = 2 } }\n" +
					"result\n" +
				" }");
	}
	
	@Test public void testSwitchExpressionOverEnum_2() throws Exception {
		assertEvaluatesTo(2, 
				"{\n" +
					"val java.lang.Thread.State x = Thread.State.NEW\n" +
					"var result = 1\n" +
					"switch x { case NEW: { result = 2 } }\n" +
					"result\n" +
				" }");
	}
	
	@Test public void testSwitchExpressionOverEnum_3() throws Exception {
		assertEvaluatesTo(2, 
				"{\n" +
					"val java.lang.Thread.State x = null\n" +
					"var result = 1\n" +
					"switch x { case NEW: { result = 3 } default: { result = 2 } }\n" +
					"result\n" +
				" }");
	}
	
	@Test public void testSwitchExpressionOverEnum_4() throws Exception {
		assertEvaluatesTo(3, 
				"{\n" +
					"val java.lang.Thread.State x = Thread.State.NEW\n" +
					"var result = 1\n" +
					"switch x { case NEW: { result = 3 } default: { result = 2 } }\n" +
					"result\n" +
				" }");
	}
	
	@Test public void testSwitchExpressionOverEnum_5() throws Exception {
		assertEvaluatesTo(2, 
				"{\n" +
					"val java.lang.Thread.State x = Thread.State.RUNNABLE\n" +
					"var result = 1\n" +
					"switch x { case NEW: { result = 3 } default: { result = 2 } }\n" +
					"result\n" +
				" }");
	}
	
	@Test public void testSwitchExpressionOverEnum_6() throws Exception {
		assertEvaluatesTo(null, 
				"{\n" + 
				"  val Enum<?> e = null\n" + 
				"  switch(e) {\n" + 
				"    java.lang.^annotation.RetentionPolicy: e.toString\n" + 
				"    java.lang.^annotation.ElementType: e.toString\n" + 
				"  }\n" + 
				"}");
	}
	
	@Test public void testSwitchExpressionOverInteger() throws Exception {
		assertEvaluatesTo(1, 
				"{\n" +
					"val Integer x = null\n" +
					"var result = 1\n" +
					"switch x { case 3: { result = 2 } }\n" +
					"result\n" +
				" }");
	}
	
	@Test public void testSwitchExpressionOveInteger_2() throws Exception {
		assertEvaluatesTo(2, 
				"{\n" +
					"val Integer x = Integer.valueOf('3')\n" +
					"var result = 1\n" +
					"switch x { case 3: { result = 2 } }\n" +
					"result\n" +
				" }");
	}
	
	@Test public void testSwitchExpressionOverInteger_3() throws Exception {
		assertEvaluatesTo(2, 
				"{\n" +
					"val Integer x = null\n" +
					"var result = 1\n" +
					"switch x { case 3: { result = 3 } default: { result = 2 } }\n" +
					"result\n" +
				" }");
	}
	
	@Test public void testSwitchExpressionOveInteger_4() throws Exception {
		assertEvaluatesTo(3, 
				"{\n" +
					"val Integer x = Integer.valueOf('3')\n" +
					"var result = 1\n" +
					"switch x { case 3: { result = 3 } default: { result = 2 } }\n" +
					"result\n" +
				" }");
	}
	
	@Test public void testSwitchExpressionOveInteger_5() throws Exception {
		assertEvaluatesTo(2, 
				"{\n" +
					"val Integer x = Integer.valueOf('4')\n" +
					"var result = 1\n" +
					"switch x { case 3: { result = 3 } default: { result = 2 } }\n" +
					"result\n" +
				" }");
	}
	
	@Test public void testSwitchExpressionOveInteger_6() throws Exception {
		assertEvaluatesTo("bar", 
				"{\n" +
					"val Integer x = Integer.valueOf('4')\n" +
					"switch x { case 3: { 'foo' } default: if ('x'.length == 1) { 'bar' } }\n" +
				" }");
	}
	
	@Test public void testCastedExpression_01() throws Exception {
		assertEvaluatesTo("literal", "'literal' as String");
	}
	
	@Test public void testCastedExpression_02() throws Exception {
		assertEvaluatesWithException(ClassCastException.class, "'literal' as Object as Integer");
	}
	
	@Test public void testCastedExpression_03() throws Exception {
		assertEvaluatesTo(null, "null as Integer");
	}
	
	@Test public void testCastedExpression_05() throws Exception {
		assertEvaluatesTo("MyString", "(if (true) { 'MyString' } else { throw new Exception() }) as String");
	}
	
	@Test public void testCastedExpression_06() throws Exception {
		assertEvaluatesTo("MyString", "(try { 'MyString' } finally { 'bla'.length }) as String");
	}
	
	@Test public void testCastedExpression_07() throws Exception {
		assertEvaluatesTo("MyString", "(try { 'MyString' } catch (Exception e) { throw e }) as String");
	}
	
	@Test public void testTryCatch_01() throws Exception {
		assertEvaluatesTo("caught", "try { 'literal' as Object as Boolean } catch(ClassCastException e) {'caught'}");
	}
	
	@Test public void testTryCatch_02() throws Exception {
		assertEvaluatesTo("literal", "try { 'literal' as String } catch(ClassCastException e) {'caught'}");
	}
	
	@Test public void testTryCatch_03() throws Exception {
		assertEvaluatesTo("ClassCastException", "try { 'literal' as Object as Boolean } catch(ClassCastException e) {e.getClass().getSimpleName()}");
	}
	
	@Test public void testTryCatch_04() throws Exception {
		assertEvaluatesWithException(NullPointerException.class, "try { 'literal' as Object as Boolean } catch(ClassCastException e) throw new NullPointerException()");
	}
	
	@Test public void testTryCatch_05() throws Exception {
		assertEvaluatesWithException(NullPointerException.class, 
				"try 'literal' as Object as Boolean" +
				"  catch(ClassCastException e) throw new NullPointerException()" +
				"  catch(NullPointerException e) 'dont catch subsequent exceptions'");
	}
	
	@Test public void testTryCatch_06() throws Exception {
		assertEvaluatesWithException(NullPointerException.class, 
				"try 'literal' as Object as Boolean" +
				"  catch(ClassCastException e) throw new NullPointerException" +
				"  catch(NullPointerException e) 'dont catch subsequent exceptions'");
	}
	
	@Test public void testTryCatch_WithThrows() throws Exception {
		assertEvaluatesWithException(NullPointerException.class, 
				"try throw new NullPointerException()" +
				"  catch(ClassCastException e) throw new NullPointerException()" +
				"  catch(NullPointerException e) throw new NullPointerException()");
	}
	
	@Test public void testTryCatch_WithThrows_01() throws Exception {
		assertEvaluatesTo("x", 
				"try throw new NullPointerException()" +
				"  catch(ClassCastException e) throw new NullPointerException()" +
				"  catch(NullPointerException e) 'x'");
	}
	
	@Test public void testTryCatch_WithThrows_02() throws Exception {
		assertEvaluatesTo("foo", 
				"try 'foo'" +
				"  catch(ClassCastException e) throw new NullPointerException()" +
				"  catch(NullPointerException e) 'x'");
	}
	
	@Test public void testTryFinally_01() throws Exception {
		assertEvaluatesTo("literal", "try 'literal' finally 'finally'.toString");
	}
	
	@Test public void testTryFinally_02() throws Exception {
		assertEvaluatesTo("finally", "{ var x = 'foo' try x = 'literal' finally x = 'finally' x }");
	}
	
	@Test public void testTryFinally_03() throws Exception {
		assertEvaluatesTo("[finally, lambda]", "val l = newArrayList; l.add([| try {return 'lambda'} finally l.add('finally')].apply()) l.toString");
	}
	
	/**
	 * @since 2.18
	 */
	@Test @Ignore public void testTryWithoutResources() throws Exception {
		assertEvaluatesTo("Test",
				"try {\n" +
				"	val a = new java.io.StringReader(\"Test\");" +
				"	val b = com.google.common.io.CharStreams.toString(a);" +
				"	return b;" +
				"} catch (java.io.IOException e) { throw e }");
	}
	
	/**
	 * @since 2.18
	 */
	@Test @Ignore public void testTryWithResources_easy() throws Exception {
		assertEvaluatesTo("Test", "try (val a = new java.io.StringReader(\"Test\")) { "
				+ "com.google.common.io.CharStreams.toString(a) }");
	}

	/**
	 * @since 2.18
	 */
	@Test @Ignore public void testTryWithResources_lambda() throws Exception {
		String result = "[body, close]";
		assertEvaluatesTo(result,
				"val myList = newArrayList; try (val someCloseable = [ myList.add('close') ]) { myList.add('body') } myList.toString");
	}
	
	/**
	 * @since 2.18
	 */
	@Test @Ignore public void testTryWithResources_2Resources() throws Exception {
		assertEvaluatesTo("Test",
				"try (val sr = new java.io.StringReader(\"Test\");" + " val buffy = new java.io.BufferedReader(sr)) {"
						+ " return buffy.readLine }");
	}

	/**
	 * @since 2.18
	 */
	@Test @Ignore public void testTryWithResources_2NestedResources() throws Exception {
		assertEvaluatesTo("Test", "try (val buffy = new java.io.BufferedReader(new java.io.StringReader(\"Test\"))) {"
				+ " return buffy.readLine }");
	}

	/**
	 * @since 2.18
	 */
	@Test @Ignore public void testTryWithResources_2DiffResources() throws Exception {
		assertEvaluatesTo("Test",
				"try (var c = if (true) new java.io.StringReader(\"Test\") else new java.util.Formatter()){\n" + 
						"	if (c instanceof java.io.StringReader)\n" + 
						"		com.google.common.io.CharStreams.toString(c as java.io.StringReader)\n" + 
				"}");
	}

	/**
	 * @since 2.18
	 */
	@Test @Ignore public void testTryWithResources_if1() throws Exception {
		assertEvaluatesTo("Test1", "try (val a = new java.io.StringReader(if (true) \"Test1\" else \"Test2\")) {"
				+ " com.google.common.io.CharStreams.toString(a)" + "}");
	}

	/**
	 * @since 2.18
	 */
	@Test @Ignore public void testTryWithResources_if2() throws Exception {
		assertEvaluatesTo("Test1",
				"try (val a = if (true) new java.io.StringReader(\"Test1\") else new java.io.StringReader(\"Test2\")) {"
						+ " com.google.common.io.CharStreams.toString(a)"
						+ "} ");
	}
	
	/**
	 * @since 2.18
	 */
	@Test @Ignore public void testTryWithResources_userClass() throws Exception {
		assertEvaluatesTo(true,
				"try (val c = new testdata.IntrospectableClosable()) {\n" + 
				"		return c.isOpen"+
				"}\n");
	}
	
	/**
	 * @since 2.18
	 */
	@Test @Ignore public void testTryWithResources_isClosed1() throws Exception {
		assertEvaluatesWithException(IOException.class,
				"var java.io.StringReader result\n" +
				"try(var c = new java.io.StringReader(\"Test\"))\n" + 
				"	result = c\n" +
				"return result.read");
	}
	
	/**
	 * @since 2.18
	 */
	@Test @Ignore public void testTryWithResources_isClosed2() throws Exception {
		assertEvaluatesTo(false,
				"var testdata.IntrospectableClosable result\n" + 
				"try(val c = new testdata.IntrospectableClosable())\n" + 
				"	result = c\n" + 
				"return result.isOpen");
	}
	
	/**
	 * @since 2.18
	 */
	@Test @Ignore public void testTryWithResources_userClassExceptionOnConstructor() throws Exception {
		assertEvaluatesWithException(Exception.class,
				"try(val c = new testdata.IntrospectableClosableExceptionsConstructor)\n" + 
				"	return c.isOpen\n");
	}
	
	/**
	 * @since 2.18
	 */
	@Test @Ignore public void testTryWithResources_userClassExceptionOnClose() throws Exception {
		assertEvaluatesWithException(CloseException.class,
				"try(val c = new testdata.IntrospectableClosableExceptionsClose)\n" + 
				"	return c.isOpen\n");
	}
	
	/**
	 * @since 2.18
	 */
	@Test @Ignore public void testTryWithResources_userClassExceptionOnCloseStillCallEveryClose1() throws Exception {
		assertEvaluatesTo("exceptionWasThrown: true;a closed: true;b closed: true",
				"var testdata.IntrospectableClosableExceptionsClose closableA\n" +
				"var testdata.IntrospectableClosable closableB\n" +
				"var exceptionWasThrown = false\n" +
				"try {\n" + 
				"  try(var a = new testdata.IntrospectableClosableExceptionsClose;\n" + 
				"		var b = new testdata.IntrospectableClosable) {\n" + 
				"    closableA = a\n" +
				"    closableB = b\n" +
				"  }\n" +
				"} catch(Exception e) {\n" +
				"    exceptionWasThrown = true\n"+
				"}\n" +
				"return \"exceptionWasThrown: \" + exceptionWasThrown + \";a closed: \" + !closableA.isOpen() + \";b closed: \" + !closableB.isOpen()"
				);
	}
	
	/**
	 * @since 2.18
	 */
	@Test @Ignore public void testTryWithResources_userClassExceptionOnCloseStillCallEveryClose2() throws Exception {
		assertEvaluatesTo("exceptionWasThrown: true;a closed: true;b closed: true",
				"var testdata.IntrospectableClosableExceptionsClose closableA\n" +
				"var testdata.IntrospectableClosable closableB\n" +
				"var exceptionWasThrown = false\n" +
				"try {\n" + 
				"  try(var b = new testdata.IntrospectableClosable;\n" + 
				"		var a = new testdata.IntrospectableClosableExceptionsClose) {\n" + 
				"    closableA = a\n" +
				"    closableB = b\n" +
				"  }\n" +
				"} catch(Exception e) {\n" +
				"    exceptionWasThrown = true\n"+
				"}\n" +
				"return \"exceptionWasThrown: \" + exceptionWasThrown + \";a closed: \" + !closableA.isOpen() + \";b closed: \" + !closableB.isOpen()"
				);
	}
	
	/**
	 * @since 2.18
	 */
	@Test @Ignore public void testTryWithResources_userClassExceptionOnCloseStillCallEveryClose3() throws Exception {
		assertEvaluatesTo("exceptionWasThrown: true;a closed: true;b closed: true",
				"var testdata.IntrospectableClosableExceptionsClose closableA\n" +
				"var testdata.IntrospectableClosableExceptionsClose closableB\n" +
				"var exceptionWasThrown = false\n" +
				"try {\n" + 
				"  try(var a = new testdata.IntrospectableClosableExceptionsClose;\n" + 
				"		var b = new testdata.IntrospectableClosableExceptionsClose) {\n" + 
				"    closableA = a\n" +
				"    closableB = b\n" +
				"  }\n" +
				"} catch(Exception e) {\n" +
				"    exceptionWasThrown = true\n"+
				"}\n" +
				"return \"exceptionWasThrown: \" + exceptionWasThrown + \";a closed: \" + !closableA.isOpen() + \";b closed: \" + !closableB.isOpen()"
				);
	}
	
	/**
	 * @since 2.18
	 */
	@Test @Ignore public void testTryWithResources_finally() throws Exception {
		assertEvaluatesTo("[new, body, finally, close]",
				"var testdata.ClosableWithList result\n" + 
				"try (var a = new testdata.ClosableWithList()){\n" + 
				"	a.add(\"body\")\n" + 
				"	result = a\n" + 
				"} finally {\n" + 
				"	result.add(\"finally\")\n" + 
				"}\n" + 
				"return result.printList");
	}
	
	/**
	 * @since 2.18
	 */
	@Test @Ignore public void testTryWithResources_catch() throws Exception {
		assertEvaluatesTo("[new, catch, close]",
				"val java.util.List<String> result = newArrayList\n" + 
				"try (val a = new testdata.ClosableWithList(result);\n" + 
				"		var b = new testdata.ClosableWithListExceptionOnConstr) {\n" + 
				"	result.add(\"body\")\n" + 
				"} catch (java.lang.InstantiationException e) {\n" + 
				"	result.add(\"catch\")\n" + 
				"}\n" + 
				"return result.toString");
	}
	
	/**
	 * @since 2.18
	 */
	@Test @Ignore public void testTryWithResources_catchFinally() throws Exception {
		assertEvaluatesTo("[new, body, catch b, finally, close]",
				"var testdata.ClosableWithList result\n" + 
				"try (var a = new testdata.ClosableWithList();\n" + 
				"		var b = new testdata.ClosableWithListExceptionOnAdd()) {\n" + 
				"	a.add(\"body\")\n" + 
				"	result = a\n" + 
				"	b.addExc\n" + 
				"} catch (testdata.TryBodyException e) {\n" + 
				"	result.add(\"catch b\")\n" + 
				"} finally {\n" + 
				"	result.add(\"finally\")\n" + 
				"}\n" + 
				"return result.printList");
	}
	
	/**
	 * @since 2.18
	 */
	@Test @Ignore public void testTryWithResources_ExceptionInBody() throws Exception {
		assertEvaluatesWithException(TryBodyException.class,
				"try (var a = new testdata.ClosableWithListExceptionOnAdd()) {\n" + 
				"	a.add(\"body\")\n" + 
				"	a.addExc\n" + 
				"}");
	}
	
	/**
	 * @since 2.18
	 */
	@Test @Ignore public void testTryWithResources_2Resources_ExceptionInBody() throws Exception {
		assertEvaluatesWithException(TryBodyException.class,
				"var testdata.ClosableWithList result\n" + 
				"try (var a = new testdata.ClosableWithList();\n" + 
				"		var b = new testdata.ClosableWithListExceptionOnAdd()) {\n" + 
				"	a.add(\"body\")\n" + 
				"	result = a\n" + 
				"	b.addExc\n" + 
				"}\n" + 
				"return result.printList");
	}
	
	/**
	 * @since 2.18
	 */
	@Test @Ignore public void testTryWithResources_2Resources_ExceptionOnClose() throws Exception {
		assertEvaluatesWithException(CloseException.class,
				"var testdata.IntrospectableClosable result\n" + 
				"try (var a = new testdata.IntrospectableClosable; var b = new testdata.IntrospectableClosableExceptionsClose) {\n" + 
				"	result = a\n" + 
				"}\n" + 
				"return result.isOpen");
	}
	
	/**
	 * @since 2.18
	 */
	@Test @Ignore public void testTryWithResources_2ResourcesCatch_01() throws Exception {
		assertEvaluatesTo("[new, catch, close]", //b.add would invoke NullPointerExcpt, but InstExc came first and is caught
				"var java.util.List<String> result = newArrayList\n" + 
				"try (var a = new testdata.ClosableWithList(result);\n" + 
				"		var b = new testdata.ClosableWithListExceptionOnConstr) {\n" + 
				"	a.add(\"body\")\n" + 
				"	b.add(\"body\")\n" + 
				"}\n" + 
				"catch (java.lang.InstantiationException e) {\n" + 
				"	result.add(\"catch\")\n" + 
				"}\n" + 
				"return result.toString");
	}
	
	/**
	 * @since 2.18
	 */
	@Test @Ignore public void testTryWithResources_2ResourcesCatch_02() throws Exception {
		assertEvaluatesWithException(InstantiationException.class, //b.add would invoke NullPointerExcpt, but InstExc came first and is caught
				"var java.util.List<String> result\n" + 
				"try (var a = new testdata.ClosableWithList;\n" + 
				"		var b = new testdata.ClosableWithListExceptionOnConstr) {\n" + 
				"	a.add(\"body\")\n" + 
				"	b.add(\"body\")\n" + 
				"}\n");
	}
	
	@Test public void testConstructor_01() throws Exception {
		assertEvaluatesTo(Boolean.TRUE, "new java.io.StringReader('literal').markSupported");
	}
	
	@Test public void testConstructor_02() throws Exception {
		assertEvaluatesTo(new Character('a'), "new Character('abc'.charAt(0))");
	}
	
	@Test public void testConstructor_03() throws Exception {
		assertEvaluatesTo("source", "new java.util.EventObject('source').getSource");
	}
	
	@Test public void testConstructor_04() throws Exception {
		assertEvaluatesTo(new Stack<Object>(), "new java.util.Stack()");
	}
	
	@Test public void testConstructor_05() throws Exception {
		assertEvaluatesTo(Collections.emptyList(), "new java.util.ArrayList(newArrayList)");
	}
	
	@Test public void testConstructor_06() throws Exception {
		assertEvaluatesTo(Collections.singletonList("a"), "new java.util.ArrayList(newArrayList('a'))");
	}
	
	@Test public void testThrowExpression_01() throws Exception {
		assertEvaluatesWithException(ExceptionSubclass.class, "throw new testdata.ExceptionSubclass()");
	}
	
	@Test public void testThrowExpression_02() throws Exception {
		assertEvaluatesWithException(ClassCastException.class, "throw (new Object() as RuntimeException)");
	}
	
	@Test public void testThrowExpression_03() throws Exception {
		assertEvaluatesWithException(NullPointerException.class, "throw null");
	}
	
	@Test public void testThrowExpression_04() throws Exception {
		assertEvaluatesWithException(NullPointerException.class, "throw new NullPointerException()");
	}
	
	@Test public void testThrowExpression_05() throws Exception {
		assertEvaluatesWithException(RuntimeException.class, "if ('foo'=='bar') 'foobar' else throw new RuntimeException()");
	}
	
	@Test public void testThrowExpression_06() throws Exception {
		assertEvaluatesWithException(ClassCastException.class, "throw (new Object as RuntimeException)");
	}
	
	@Test public void testInstanceOf_01() throws Exception {
		assertEvaluatesTo(Boolean.TRUE, "'literal' instanceof String");
	}
	
	@Test public void testInstanceOf_02() throws Exception {
		assertEvaluatesTo(Boolean.TRUE, "'literal' instanceof CharSequence");
	}
	
	@Test public void testInstanceOf_03() throws Exception {
		assertEvaluatesTo(Boolean.FALSE, "'literal' as Object instanceof Boolean");
	}
	
	@Test public void testInstanceOf_04() throws Exception {
		assertEvaluatesTo(Boolean.FALSE, "null instanceof Boolean");
	}
	
	/**
	 * @since 2.3
	 */
	@Test public void testInstanceOf_05() throws Exception {
		assertEvaluatesTo(Boolean.FALSE, "[|'foo'] instanceof com.google.common.base.Supplier");
		assertEvaluatesTo(Boolean.TRUE, "[|'foo'] instanceof org.eclipse.xtext.xbase.lib.Functions$Function0");
	}
	
	/**
	 * @since 2.3
	 */
	@Test public void testInstanceOf_06() throws Exception {
		assertEvaluatesTo(Boolean.FALSE, "newArrayList('foo','bar') as Object instanceof Object[]");
		assertEvaluatesTo(Boolean.TRUE, "newArrayList('foo','bar') as String[] instanceof Object[]");
	}
	
	/**
	 * @since 2.4
	 */
	@Test public void testInstanceOf_07() throws Exception {
		assertEvaluatesTo(Boolean.FALSE, "[|'foo'] instanceof com.google.common.base.Supplier<?>");
		assertEvaluatesTo(Boolean.TRUE, "[|'foo'] instanceof org.eclipse.xtext.xbase.lib.Functions$Function0<?>");
	}
	
	/**
	 * @since 2.4
	 */
	@Test public void testInstanceOf_08() throws Exception {
		assertEvaluatesTo(Boolean.FALSE, "null instanceof java.util.List<?>");
	}
	
	/**
	 * @since 2.4
	 */
	@Test public void testInstanceOf_09() throws Exception {
		assertEvaluatesTo(Boolean.TRUE, "[|'foo'] instanceof org.eclipse.xtext.xbase.lib.Functions.Function0");
	}
	
	/**
	 * @since 2.4
	 */
	@Test public void testInstanceOf_10() throws Exception {
		assertEvaluatesTo(Boolean.TRUE, "[|'foo'] instanceof org.eclipse.xtext.xbase.lib.Functions.Function0<?>");
	}
	
	/**
	 * @since 2.5
	 */
	@Test public void testInstanceOf_11() throws Exception {
		assertEvaluatesTo("hello", "{ val CharSequence x = new StringBuilder; (if (x instanceof Appendable) x.append('hello')).toString }");
	}
	
	/**
	 * @since 2.5
	 */
	@Test public void testInstanceOf_12() throws Exception {
		assertEvaluatesTo("el", "{ val Object x = 'hello' if (x instanceof CharSequence) x.subSequence(1,3) }");
	}
	
	/**
	 * @since 2.5
	 */
	@Test public void testInstanceOf_13() throws Exception {
		assertEvaluatesTo("0", "{ val CharSequence x = new StringBuilder; (if (x instanceof Appendable) x.append(x.length().toString())).toString }");
	}
	
	/**
	 * @since 2.5
	 */
	@Test public void testInstanceOf_14() throws Exception {
		assertEvaluatesTo("0", "{ val Object x = new StringBuilder; if (x instanceof Appendable) if (x instanceof CharSequence) x.append(x.length().toString()) x.toString }");
	}
	
	@Test public void testClosure_01() throws Exception {
		assertEvaluatesTo("literal", "new testdata.ClosureClient().invoke0(|'literal')");
	}
	
	@Test public void testClosure_02() throws Exception {
		assertEvaluatesTo("literal", 
				"{" +
				"  val result = 'literal'" +
				"  new testdata.ClosureClient().invoke0(|result)" +
				"}");
	}
	
	@Test public void testClosure_03() throws Exception {
		assertEvaluatesTo("literal", 
				"{" +
				"  var closure = [|'literal']" +
				"  new testdata.ClosureClient().invoke0(closure)" +
				"}");
	}
	
	@Test public void testClosure_05() throws Exception {
		assertEvaluatesTo("LITERAL", 
				"new testdata.ClosureClient().invoke1([String s|s.toUpperCase], 'literal')");
	}
	
	@Test public void testClosure_06() throws Exception {
		assertEvaluatesTo("LITERAL", 
				"new testdata.ClosureClient().invoke2(" +
				"[Void p1, String s|s.toUpperCase], null, 'literal')");
	}
	
	@Test public void testClosure_06_1() throws Exception {
		assertEvaluatesTo("LITERAL", 
				"new testdata.ClosureClient().invoke2(" +
				"[p1, s|s.toUpperCase], null, 'literal')");
	}
	
	@Test public void testClosure_07() throws Exception {
		assertEvaluatesTo("literal", 
				"{" +
				"  val func = [|'literal']" +
				"  new testdata.ClosureClient().useProvider(func)" +
				"}");
	}
	
	@Test public void testClosure_07_01() throws Exception {
		assertEvaluatesTo("literal", 
				"new testdata.ClosureClient().useProvider(|'literal')");
	}
	
	@Test public void testClosure_07_02() throws Exception {
		assertEvaluatesWithException(NullPointerException.class, 
				"new testdata.ClosureClient().useProvider(null as =>String[])");
	}
	
	@Test public void testClosure_07_03() throws Exception {
		assertEvaluatesWithException(NullPointerException.class, 
				"new testdata.ClosureClient().useSupplier(null as =>Iterable<? extends String[]>[])");
	}
	
	@Test public void testClosure_07_04() throws Exception {
		assertEvaluatesWithException(NullPointerException.class, 
				"new testdata.ClosureClient().invoke0(null as =>String[])");
	}
	
	@Test public void testClosure_08() throws Exception {
		assertEvaluatesTo("literal", 
				"new testdata.ClosureClient().useSupplier(|'literal')");
	}
	
	@Test public void testClosure_09() throws Exception {
		assertEvaluatesTo("LITERAL", 
		"new testdata.ClosureClient().useGoogleCollectFunction([String s|s.toUpperCase], 'literal')");
	}
	
	@Test public void testClosure_09_2() throws Exception {
		assertEvaluatesTo("LITERAL", 
		"new testdata.ClosureClient().useGoogleCollectFunction2([String s|s.toUpperCase], 'literal')");
	}
	
	@Test public void testClosure_10() throws Exception {
		assertEvaluatesTo("LITERAL", 
		"new testdata.ClosureClient().useGoogleCollectFunction([s|s.toUpperCase], 'literal')");
	}
	
	@Test public void testClosure_10_2() throws Exception {
		assertEvaluatesTo("LITERAL", 
		"new testdata.ClosureClient().useGoogleCollectFunction2([s|s.toUpperCase], 'literal')");
	}
	
	@Test public void testClosure_11() throws Exception {
		assertEvaluatesTo(Boolean.TRUE, 
		"new testdata.ClosureClient().useGoogleCollectPredicate([String s|'literal'.equals(s)], 'literal')");
	}
	
	@Test public void testClosure_11_2() throws Exception {
		assertEvaluatesTo(Boolean.TRUE, 
		"new testdata.ClosureClient().useGoogleCollectPredicate2([String s|'literal'.equals(s)], 'literal')");
	}
	
	@Test public void testClosure_12() throws Exception {
		assertEvaluatesTo(Boolean.TRUE, 
		"new testdata.ClosureClient().useGoogleCollectPredicate([s|'literal'.equals(s)], 'literal')");
	}
	
	@Test public void testClosure_12_2() throws Exception {
		assertEvaluatesTo(Boolean.TRUE, 
		"new testdata.ClosureClient().useGoogleCollectPredicate2([s|'literal'.equals(s)], 'literal')");
	}
	
	@Test public void testClosure_13() throws Exception {
		assertEvaluatesTo(Boolean.FALSE, 
				"new testdata.ClosureClient().useGoogleCollectPredicate([s|'literal'.equals(s)], 'false')");
	}
	
	@Test public void testClosure_13_2() throws Exception {
		assertEvaluatesTo(Boolean.FALSE, 
		"new testdata.ClosureClient().useGoogleCollectPredicate2([s|'literal'.equals(s)], 'false')");
	}
	
	@Test public void testClosure_14() throws Exception {
		assertEvaluatesTo("literal", 
				"{" +
				"  var client = new testdata.ClosureClient()" +
				"  var fun = client.getIdentityFunction" +
				"  client.useGoogleCollectFunction(fun, 'literal')" +
				"}");
	}
	
	@Test public void testClosure_14_2() throws Exception {
		assertEvaluatesTo("literal", 
				"{" +
				"  var client = new testdata.ClosureClient()" +
				"  var fun = client.getIdentityFunction" +
				"  client.useGoogleCollectFunction2(fun, 'literal')" +
				"}");
	}
	
	@Test public void testClosure_15() throws Exception {
		assertEvaluatesTo(Collections.singletonList("literal"), 
				"{" +
				"  val result = newArrayList" +
				"  val =>void runMe = [|result.add('literal')]" +
				"  new testdata.ClosureClient().useRunnable(runMe)" +
				"  result" +
				"}");
	}
	
	@Test public void testClosure_16() throws Exception {
		assertEvaluatesTo(Collections.singletonList("literal"), 
				"{" +
				"  val result = newArrayList" +
				"  new testdata.ClosureClient().useRunnable(|result.add('literal'))" +
				"  result" +
				"}");
	}
	
	@Test public void testClosure_17() throws Exception {
		assertEvaluatesTo(Collections.singletonList("literal"), 
				"{" +
				"  val result = newArrayList" +
				"  val client = new testdata.ClosureClient()" +
				"  val runnable = client.asRunnable(|result.add('literal'))" +
				"  client.useRunnable(runnable)" +
				"  result" +
				"}");
	}
	
	@Test public void testClosure_18() throws Exception {
		assertEvaluatesTo(Collections.singletonList("literal"), 
				"{" +
				"  val result = newArrayList" +
				"  val client = new testdata.ClosureClient()" +
				"  val procedure = client.asProcedure(|result.add('literal'))" +
				"  client.useRunnable(procedure)" +
				"  result" +
				"}");
	}
	
	@Test public void testClosure_19() throws Exception {
		assertEvaluatesTo("twoArgs:12", 
				"{" +
				"  val client = new testdata.ClosureClient()" +
				"  client.concatStrings(|'1') [|'2']" +
				"}");
	}
	
	@Test public void testClosure_20() throws Exception {
		assertEvaluatesTo("varArgs:1", 
				"{" +
				"  val client = new testdata.ClosureClient()" +
				"  client.concatStrings(|'1')" +
				"}");
	}
	
	@Test public void testClosure_21() throws Exception {
		assertEvaluatesTo("varArgs:1", 
				"{" +
				"  val client = new testdata.ClosureClient()" +
				"  client.concatStrings [|'1']" +
				"}");
	}
	
	@Test public void testClosure_22() throws Exception {
		assertEvaluatesTo("varArgs:", 
				"{" +
				"  val client = new testdata.ClosureClient()" +
				"  client.concatStrings" +
				"}");
	}
	
	@Test public void testClosure_23() throws Exception {
		assertEvaluatesTo("varArgs:123", 
				"{" +
				"  val client = new testdata.ClosureClient()" +
				"  client.concatStrings([|'1'],[|'2']) [|'3']" +
				"}");
	}
	
	@Test public void testClosure_24() throws Exception {
		assertEvaluatesTo("twoArgs:12", 
				"{" +
				"  val it = new testdata.ClosureClient()" +
				"  concatStrings(|'1') [|'2']" +
				"}");
	}
	
	@Test public void testClosure_25() throws Exception {
		assertEvaluatesTo("varArgs:1", 
				"{" +
				"  val it = new testdata.ClosureClient()" +
				"  concatStrings(|'1')" +
				"}");
	}
	
	@Test public void testClosure_26() throws Exception {
		assertEvaluatesTo("varArgs:1", 
				"{" +
				"  val it = new testdata.ClosureClient()" +
				"  concatStrings [|'1']" +
				"}");
	}
	
	@Test public void testClosure_27() throws Exception {
		assertEvaluatesTo("varArgs:", 
				"{" +
				"  val it = new testdata.ClosureClient()" +
				"  concatStrings" +
				"}");
	}
	
	@Test public void testClosure_28() throws Exception {
		assertEvaluatesTo("varArgs:123", 
				"{" +
				"  val it = new testdata.ClosureClient()" +
				"  concatStrings([|'1'],[|'2']) [|'3']" +
				"}");
	}
	
	@Test public void testClosure_29() throws Exception {
		assertEvaluatesTo("done", 
				"{" +
				"  val (CharSequence)=>void proc = [s|]\n" +
				"  val client = new testdata.ClosureClient\n" +
				"  client.useProcedureForCharSequence(proc)" +
				"}");
	}
	
	@Test public void testClosure_30() throws Exception {
		assertEvaluatesTo("Foo", 
				"{" +
					"  new testdata.InterfaceASubClient().getClassName [| 'Foo' ]" +
				"}");
	}

	@Test public void testClosure_31() throws Exception {
		assertEvaluatesTo(Integer.valueOf(15), 
				"{ val (int)=>int fun = [ if (it == 0) 0 else self.apply(it - 1) + it ] fun.apply(5) }");
	}
	
	@Test public void testClosure_32() throws Exception {
		assertEvaluatesTo("fooinner", 
				"{ val (String)=>String fun = [ val (String)=>String nestedFun = [if (it.endsWith('inner')) it else self.apply(it+'inner')] nestedFun.apply(it)] fun.apply('foo') }");
	}
	
	/*
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=391758 
	 */
	@Test public void testClosure_33() throws Exception {
		assertEvaluatesTo(newArrayList("foo"), 
				"{ val (java.util.List<String>,String)=>java.util.List<String> functionReturningList = [a, b| a += b return a ] "
				+ "#['foo'].fold(newArrayList, functionReturningList) }");
	}
	
	/**
	 * @since 2.5
	 */
	@Test public void testClosure_34() throws Exception {
		assertEvaluatesTo("hello", "{ val (Object)=>String x = [ if (it instanceof String) return it ] x.apply('hello') }");
	}
	
	/**
	 * @since 2.7
	 */
	@Test public void testClosure_35() throws Exception {
		assertEvaluatesTo(newArrayList("foo"), 
				"{ val (java.util.List<String>,String)=>java.util.List<String> functionReturningList = [$0 += $1 return $0 ] "
						+ "#['foo'].fold(newArrayList, functionReturningList) }");
	}
	
	/**
	 * @since 2.7
	 */
	@Test public void testClosure_36() throws Exception {
		assertEvaluatesTo(Collections.singletonList("literal"), 
				"{" +
				"  val result = newArrayList" +
				"  val =>void runMe = [result.add('literal')]" +
				"  new testdata.ClosureClient().useRunnable(runMe)" +
				"  result" +
				"}");
	}
	
	/**
	 * @since 2.7
	 */
	@Test public void testClosure_37() throws Exception {
		assertEvaluatesTo("LITERAL", 
				"new testdata.ClosureClient().invoke2(" +
				"[$1.toUpperCase], null, 'literal')");
	}
	
	@Test public void testExceptionOnClosure() throws Exception {
		assertEvaluatesWithException(java.beans.PropertyVetoException.class, 
				"{ val java.beans.VetoableChangeListener x = [ throw new java.beans.PropertyVetoException('', it) ] x.vetoableChange(null) true }");
	}
	
	/**
	 * @since 2.3
	 */
	@Test public void testClosureConversion_01() throws Exception {
		assertEvaluatesTo(newArrayList("bar","foo"), 
				"{" +
						"  val client = new testdata.ClosureClient()" +
						"  val com.google.inject.Provider<String> provider = [|'foo']" +
						"  val com.google.common.base.Supplier<String> supplier = [|'bar']" +
						"  newArrayList(client.useProvider(supplier as =>String), client.useSupplier(provider as =>String))" +
				"}");
	}
	
	@Test public void testArrayConversion_01() throws Exception {
		assertEvaluatesTo("LITERAL", 
				"{" +
				"  var client = new testdata.ArrayClient()" +
				"  var stringArray = client.toStringArray('literal', 'other')" +
				"  client.inplaceToUpperCase(stringArray)" +
				"  stringArray.iterator.next()" +
				"}");
	}
	
	@Test public void testArrayConversion_02() throws Exception {
		assertEvaluatesTo("OTHER", 
				"{" +
				"  var client = new testdata.ArrayClient()" +
				"  var stringArray = client.toStringArray('literal', 'other')" +
				"  client.inplaceToUpperCase(stringArray)" +
				"  var iter = (stringArray as Iterable<String>).iterator" +
				"  iter.next" +
				"  iter.next" +
				"}");
	}
	
	@Test public void testArrayConversion_03() throws Exception {
		assertEvaluatesTo(new Integer(42), 
				"{" +
				"  var client = new testdata.ArrayClient()" +
				"  var intArray = client.toIntArray(32, 7)" +
				"  client.inplaceAdd10(intArray)" +
				"  var iter = (intArray as java.util.List<Integer>).iterator" +
				"  iter.next" +
				"}");
	}
	
	@Test public void testArrayConversion_04() throws Exception {
		assertEvaluatesTo(new Integer(17), 
				"{" +
				"  var client = new testdata.ArrayClient()" +
				"  var intArray = client.toIntArray(32, 7)" +
				"  client.inplaceAdd10(intArray)" +
				"  var iter = (intArray as Iterable<Integer>).iterator" +
				"  iter.next" +
				"  iter.next" +
				"}");
	}
	
	@Test public void testArrayConversion_05() throws Exception {
		assertEvaluatesTo("literal", 
				"{" +
				"  var client = new testdata.ArrayClient()" +
				"  var stringArray = client.toStringArray('literal', 'other')" +
				"  client.inplaceSwap(stringArray)" +
				"  var iter = (stringArray as java.util.List<String>).iterator" +
				"  iter.next" +
				"  iter.next" +
				"}");
	}
	
	@Test public void testArrayConversion_06() throws Exception {
		assertEvaluatesTo(newArrayList("b", "c"), 
				"{" +
				"  var a = 'a,b,c'.split(',')\n" + 
				"  a = a.tail" +
				"  a.toList" +
				"}");
	}
	
	@Test public void testArrayConversion_07() throws Exception {
		assertEvaluatesTo(newArrayList(2, 3), 
				"{" +
				"  var int[] result = newArrayList(1, 2, 3)\n" + 
				"  result = result.tail" +
				"  result.toList" +
				"}");
	}
	
	@Test public void testArrayConversion_08() throws Exception {
		assertEvaluatesTo(newArrayList("c", "b"), 
				"{" +
				"  var a = 'b,c'.split(',')\n" + 
				"  new testdata.ArrayClient().swap(a).toList" +
				"}");
	}
	
	@Test public void testArrayConversion_09() throws Exception {
		assertEvaluatesTo(newArrayList("c", "b"), 
				"new testdata.ArrayClient().swap('b,c'.split(',')).toList");
	}
	
	@Test public void testArrayConversion_10() throws Exception {
		assertEvaluatesTo(newArrayList("c", "b"), 
				"{" +
				"  var a = 'a,b,c'.split(',')\n" + 
				"  a = a.tail" +
				"  a = new testdata.ArrayClient().swap(a)" +
				"  a.toList" +
				"}");
	}
	
	@Test public void testArrays_01() throws Exception {
		assertEvaluatesTo(42, 
				"{" +
				"  var Integer[] a = newArrayOfSize(42)" + 
				"  a.length" +
				"}");
	}
	
	@Test public void testArrays_02() throws Exception {
		assertEvaluatesTo(38, 
				"{" +
				"  var a = newArrayOfSize(42)" + 
				"  a.set(40, 4)" + 
				"  a.length - a.get(40)" +
				"}");
 	}
	
	
	@Test public void testArrays_03() throws Exception {
		assertEvaluatesTo('x', 
				"{" +
				"  var a = newCharArrayOfSize(42)" + 
				"  a.set(40, 'x')" + 
				"  a.get(40)" +
				"}");
	}
	
	@Test public void testArrays_04() throws Exception {
		assertEvaluatesTo("foo", 
				"{" +
						"  var java.util.List<String>[] a = newArrayOfSize(42)" + 
						"  a.set(40, #['foo'])" + 
						"  a.get(40).head" +
				"}");
	}
	
	@Test public void testConstructorVarArgs_01() throws Exception {
		assertEvaluatesTo(Boolean.TRUE, "new testdata.ClassWithVarArgs().defaultConstructor");
	}
	
	@Test public void testConstructorVarArgs_02() throws Exception {
		assertEvaluatesTo(Boolean.TRUE, "new testdata.ClassWithVarArgs(1).varArgConstructor");
	}
	
	@Test public void testConstructorVarArgs_03() throws Exception {
		assertEvaluatesTo(Boolean.TRUE, "new testdata.ClassWithVarArgs(1, '').varArgConstructor");
	}
	
	@Test public void testConstructorVarArgs_04() throws Exception {
		assertEvaluatesTo(Boolean.FALSE, "new testdata.ClassWithVarArgs(1, '', '').varArgConstructor");
	}
	
	@Test public void testConstructorVarArgs_05() throws Exception {
		assertEvaluatesTo(Boolean.TRUE, "new testdata.ClassWithVarArgs(1, '', '', '').varArgConstructor");
	}
	
	@Test public void testMethodVarArgs_01() throws Exception {
		assertEvaluatesTo(Collections.emptyList(), "new testdata.ClassWithVarArgs().stringsToList()");
	}
	
	@Test public void testMethodVarArgs_02() throws Exception {
		assertEvaluatesTo(Collections.singletonList("s1"), "new testdata.ClassWithVarArgs().stringsToList('s1')");
	}
	
	@Test public void testMethodVarArgs_03() throws Exception {
		assertEvaluatesTo(newArrayList("foo", "s1", "s2"), "new testdata.ClassWithVarArgs().stringsToList('s1', 's2')");
	}
	
	@Test public void testMethodVarArgs_04() throws Exception {
		assertEvaluatesTo(newArrayList("s1", "s2", "s3"), "new testdata.ClassWithVarArgs().stringsToList('s1', 's2', 's3')");
	}
	
	@Test public void testMethodVarArgs_05() throws Exception {
		assertEvaluatesTo(Collections.emptyList(), "{ var x = new testdata.ClassWithVarArgs() x.stringsToList() }");
	}
	
	@Test public void testMethodVarArgs_06() throws Exception {
		assertEvaluatesTo(Collections.singletonList("s1"), "{ var x = new testdata.ClassWithVarArgs() x.stringsToList('s1') }");
	}
	
	@Test public void testMethodVarArgs_07() throws Exception {
		assertEvaluatesTo(newArrayList("foo", "s1", "s2"), "{ var x = new testdata.ClassWithVarArgs() x.stringsToList('s1', 's2') }");
	}
	
	@Test public void testMethodVarArgs_08() throws Exception {
		assertEvaluatesTo(newArrayList("s1", "s2", "s3"), "{ var x = new testdata.ClassWithVarArgs() x.stringsToList('s1', 's2', 's3') }");
	}
	
	@Test public void testMethodVarArgs_09() throws Exception {
		assertEvaluatesTo(newArrayList("s1"), "{ var x = new testdata.ClassWithVarArgs() x.stringsToList2('s1') }");
	}
	@Test public void testMethodVarArgs_10() throws Exception {
		assertEvaluatesTo(newArrayList("s1", "s2"), "{ var x = new testdata.ClassWithVarArgs() x.stringsToList2('s1', 's2') }");
	}
	@Test public void testMethodVarArgs_11() throws Exception {
		assertEvaluatesTo(newArrayList("s1", "s2", "s3"), "{ var x = new testdata.ClassWithVarArgs() x.stringsToList2('s1', 's2', 's3') }");
	}
	
	@Test public void testMethodVarArgs_12() throws Exception {
		assertEvaluatesTo("logInfo(a)", "new testdata.ClassWithVarArgs().logInfo('a')");
	}
	
	@Test public void testMethodVarArgs_13() throws Exception {
		assertEvaluatesTo("logInfo(a, args...)", "new testdata.ClassWithVarArgs().logInfo('a', 'b')");
	}
	
	@Test public void testMethodVarArgs_14() throws Exception {
		assertEvaluatesTo("logInfo2(a)", "new testdata.ClassWithVarArgs().logInfo2('a')");
	}
	
	@Test public void testMethodVarArgs_15() throws Exception {
		assertEvaluatesTo("logInfo2(a, b)", "new testdata.ClassWithVarArgs().logInfo2('a', 'b')");
	}
	
	@Test public void testMethodVarArgs_16() throws Exception {
		assertEvaluatesTo("logInfo2(a, b, c)", "new testdata.ClassWithVarArgs().logInfo2('a', 'b', 'c')");
	}
	
	@Test public void testMethodVarArgs_17() throws Exception {
		assertEvaluatesTo("logInfo2(a, args...)", "new testdata.ClassWithVarArgs().logInfo2('a', 'b', 'c', 'd')");
	}
	
	@Test public void testMethodVarArgs_18() throws Exception {
		assertEvaluatesTo(newArrayList("s1", "s2", "s3"), "new testdata.ClassWithVarArgs().stringsToList(#['s1', 's2', 's3'])");
	}
	
	@Test public void testMethodVarArgs_19() throws Exception {
		assertEvaluatesTo(newArrayList("s1", "s2", "s3"), "new testdata.ClassWithVarArgs().stringsToList2('s1', #['s2', 's3'])");
	}
	
	@Test public void testMethodVarArgs_20() throws Exception {
		assertEvaluatesTo("logInfo2(foo, args...)", "new testdata.ClassWithVarArgs().logInfo2('foo',#['s1', 's2', 's3'])");
	}
	
	@Test public void testMethodVarArgs_21() throws Exception {
		assertEvaluatesTo("logInfo2(foo, args...)", "new testdata.ClassWithVarArgs().logInfo2('foo', 's1', 's2', 's3')");
	}
	
	@Test public void testAssignmentVarArgs_01() throws Exception {
		assertEvaluatesTo(Collections.emptyList(), "{ var x = new testdata.ClassWithVarArgs x.values = #[] x.values }");
	}
	
	@Test public void testAssignmentVarArgs_02() throws Exception {
		assertEvaluatesTo(null, "{ var x = new testdata.ClassWithVarArgs x.values = null x.values }");
	}
	
	@Test public void testAssignmentVarArgs_03() throws Exception {
		assertEvaluatesTo(newArrayList("s1"), "{ var x = new testdata.ClassWithVarArgs x.values = 's1' x.values }");
	}
	
	@Test public void testAssignmentVarArgs_04() throws Exception {
		assertEvaluatesTo(newArrayList("s1", "s2"), "{ var x = new testdata.ClassWithVarArgs x.values = #['s1', 's2'] x.values }");
	}
	
	@Test public void testAssignmentVarArgs_05() throws Exception {
		assertEvaluatesTo(newArrayList("s1", "s2", "s3"), "{ var x = new testdata.ClassWithVarArgs x.values = #['s1', 's2', 's3'] x.values }");
	}
	
	@Test public void testIterableExtension_01() throws Exception {
		assertEvaluatesTo(null, "new java.util.ArrayList<String>().findFirst(String e|e.length==0)");
	}
	
	@Test public void testIterableExtension_02() throws Exception {
		assertEvaluatesTo(null, "new java.util.ArrayList<String>().findFirst(e|e.length==0)");
	}
	
	@Test public void testIterableExtension_03() throws Exception {
		assertEvaluatesTo(Integer.valueOf(12), "newArrayList(1, 2, 3, 4, 5, 6).filter(i|i%2==0).reduce(a,b|a+b)");
	}
	
	@Test public void testIterableExtension_04() throws Exception {
		assertEvaluatesTo(newArrayList(2, 3, 2, 3, 4), "newArrayList('a','aa','b','aa','abc').map(s|s.length+1).toList()");
	}
	
	@Test public void testIterableExtension_05() throws Exception {
		assertEvaluatesTo(Integer.valueOf(2 + 3 + 2 + 3 + 4), "newArrayList('a','aa','b','aa','abc').map(s|s.length + 1).reduce(a,b|a+b)");
	}
	
	@Test public void testIterableExtension_06() throws Exception {
		assertEvaluatesTo(Integer.valueOf(5), "newArrayList('a','aa','b','aa','abc').map(s|s.length + 1).take(4).toSet().reduce(a,b|a+b)");
	}
	
	@Test public void testIterableExtension_07() throws Exception {
		assertEvaluatesTo(newArrayList("a", "b", "c"), "newArrayList('a','b', 'c', 'd', 'e').take(3).toList()");
	}
	
	@Test public void testIterableExtension_08() throws Exception {
		assertEvaluatesTo(newArrayList("d", "e"), "newArrayList('a', 'b', 'c', 'd', 'e').drop(3).toList()");
	}
	
	@Test public void testIterableExtension_09() throws Exception {
		assertEvaluatesTo(Boolean.TRUE, "(null as Iterable<String>).isNullOrEmpty()");
		assertEvaluatesTo(Boolean.TRUE, "newArrayList().isNullOrEmpty()");
		assertEvaluatesTo(Boolean.FALSE, "newHashSet('a').isNullOrEmpty()");
	}
	
	@Test public void testIterableExtension_10() throws Exception {
		assertEvaluatesTo("seed 12345", "newArrayList(1, 2, 3, 4, 5).fold('seed ', [s, i|s+i.toString])");
	}
	
	@Test public void testIterableExtension_11() throws Exception {
		assertEvaluatesTo("seed", "<Integer>newArrayList().fold('seed', [s, i|s+i.toString])");
	}
	
	@Test public void testIterableExtension_12() throws Exception {
		assertEvaluatesTo(newArrayList("a","b"), 
				"{\n" +
				"  val result = <String>newArrayList\n" +
				"  newArrayList('a','b').forEach [ result += it ]\n" +
				"  result\n" +
				"}");
	}
	
	@Test public void testIterableExtension_13() throws Exception {
		assertEvaluatesTo(null, "new java.util.ArrayList<String>.findFirst(String e|e.length==0)");
	}
	
	@Test public void testIterableExtension_14() throws Exception {
		assertEvaluatesTo("seed", "<Integer>newArrayList.fold('seed', [s, i|s+i.toString])");
	}
	
	@Test public void testMapExtension_01() throws Exception {
		assertEvaluatesTo(newArrayList("a->b","c->d","a->b","c->d","a->b","c->d"), 
				"{\n" +
				"  val result = <String>newArrayList\n" +
				"  newLinkedHashMap('a'->'b', 'c'->'d').forEach(k, v| result.add(k + '->' + v))\n" +
				"  newLinkedHashMap('a'->'b', 'c'->'d').forEach[k, v| result.add(k + '->' + v)]\n" +
				"  newLinkedHashMap('a'->'b', 'c'->'d').forEach() [k, v| result.add(k + '->' + v)]\n" +
				"  result\n" +
				"}");
	}
	
	@Test public void testMapExtension_02() throws Exception {
		assertEvaluatesTo(Boolean.FALSE, 
				"newLinkedHashMap('a'->'b', 'c'->'d').filter(k, v| k != 'a').containsKey('a')");
	}
	
	@Test public void testMapExtension_03() throws Exception {
		assertEvaluatesTo("B", 
				"newLinkedHashMap('a'->'b', 'c'->'d').mapValues[ toUpperCase ].get('a')");
	}
	
	@Test public void testMapExtension_04() throws Exception {
		assertEvaluatesTo("B", 
				"newLinkedHashMap('a'->'b', 'c'->'d').mapValues() [ toUpperCase ].get('a')");
	}
	
	@Test public void testMapExtension_05() throws Exception {
		assertEvaluatesTo(newArrayList("a->b","c->d","a->b","c->d","a->b","c->d"), 
				"{\n" +
				"  val result = <String>newArrayList\n" +
				"  val it = newLinkedHashMap('a'->'b', 'c'->'d')" +
				"  forEach(k, v| result.add(k + '->' + v))\n" +
				"  forEach() [k, v| result.add(k + '->' + v)]\n" +
				"  forEach [k, v| result.add(k + '->' + v)]\n" +
				"  result\n" +
				"}");
	}
	
	@Test public void testMapExtension_06() throws Exception {
		assertEvaluatesTo(Boolean.FALSE, 
				"{ val it = newLinkedHashMap('a'->'b', 'c'->'d') filter(k, v| k != 'a').containsKey('a') }");
	}
	
	@Test public void testMapExtension_07() throws Exception {
		assertEvaluatesTo("B", 
				"{ val it = newLinkedHashMap('a'->'b', 'c'->'d') mapValues[ toUpperCase ].get('a') }");
	}
	
	@Test public void testMapExtension_08() throws Exception {
		assertEvaluatesTo("B", 
				"{ val it = newLinkedHashMap('a'->'b', 'c'->'d') mapValues() [ toUpperCase ].get('a') }");
	}
	
	@Test public void testTypeInference() throws Exception {
		assertEvaluatesTo(9, 
				"newArrayList('foo','bar','baz','booze').sortBy[length].take(3).fold(0)[a, b| a + b.length]");
	}
	
	@Test public void testMapValuesExtension() throws Exception {
		assertEvaluatesTo("B", 
				"{ val it = newLinkedHashMap(1->'b', 2->'d') " +
				"if ('D' != it.mapValues[ toUpperCase ].get(2)) {\n" +
				"	throw new RuntimeException" +
				"} " +
				"return it.mapValues[ toUpperCase ].get(1)}");
	}
	
	@Test public void testReduceWithPlusOperator() throws Exception {
		assertEvaluatesTo( 55 , 
				"(1..10).map[it].reduce[ a, b | a + b]");
	}
	
	@Test public void testMapConstruction_00() throws Exception {
		assertEvaluatesTo("vier", "newHashMap(3->'drei',4->'vier').get(4)");
	}
	
	@Test public void testMapConstruction_01() throws Exception {
		assertEvaluatesTo("vier", "newHashMap(3->'drei',4->'vier').entrySet.findFirst(e|e.key==4).value");
	}
	
	@Test public void testStaticMethod_01() throws Exception {
		assertEvaluatesTo(newTreeSet(), "newTreeSet(String left, String right|left.compareTo(right))");
	}
	
	@Test public void testStaticMethod_02() throws Exception {
		assertEvaluatesTo(newHashSet("a"), "newTreeSet([left, right|left.compareTo(right)], 'a')");
	}
	
	@Test public void testCollectionExtensions_01() throws Exception {
		assertEvaluatesTo(Boolean.TRUE, "{ var x = newArrayList('') var result = x.unmodifiableView() x.clear() result.empty }");
//		assertEvaluatesWithException(UnsupportedOperationException.class, "newArrayList('').unmodifiableView().clear()");
		assertEvaluatesWithException(UnsupportedOperationException.class, "{ newArrayList('').unmodifiableView().clear() null }");
	}
	
	@Test public void testCollectionExtensions_02() throws Exception {
		assertEvaluatesTo(Boolean.TRUE, "{ var x = newHashSet('') var result = x.unmodifiableView() x.clear() result.empty }");
//		assertEvaluatesWithException(UnsupportedOperationException.class, "newHashSet('').unmodifiableView().clear()");
		assertEvaluatesWithException(UnsupportedOperationException.class, "{ newHashSet('').unmodifiableView().clear null }");
	}
	
	@Test public void testCollectionExtensions_03() throws Exception {
		assertEvaluatesTo(Boolean.TRUE, "newArrayList().unmodifiableView() instanceof java.util.List");
		assertEvaluatesTo(Boolean.TRUE, "newHashSet().unmodifiableView() instanceof java.util.Set");
		assertEvaluatesTo(Boolean.TRUE, "newLinkedHashSet().unmodifiableView() instanceof java.util.Set");
		assertEvaluatesTo(Boolean.TRUE, "newTreeSet(String a, String b|a.compareTo(b)).unmodifiableView() instanceof java.util.SortedSet");
		assertEvaluatesTo(Boolean.TRUE, "newHashMap().unmodifiableView() instanceof java.util.Map");
		assertEvaluatesTo(Boolean.TRUE, "newLinkedHashMap().unmodifiableView() instanceof java.util.Map");
		assertEvaluatesTo(Boolean.TRUE, "newTreeMap(String a, String b|a.compareTo(b)).unmodifiableView() instanceof java.util.SortedMap");
	}
	
	@Test public void testCollectionExtensions_04() throws Exception {
		assertEvaluatesTo(Boolean.FALSE, "(newArrayList() as java.util.Collection<Object>).unmodifiableView() instanceof java.util.List");
		assertEvaluatesTo(Boolean.TRUE, "(newArrayList() as java.util.Collection<Object>).unmodifiableView() instanceof java.util.Collection");
		assertEvaluatesTo(Boolean.FALSE, "(newHashSet() as java.util.Collection<Object>).unmodifiableView() instanceof java.util.Set");
		assertEvaluatesTo(Boolean.TRUE, "(newHashSet() as java.util.Collection<Object>).unmodifiableView() instanceof java.util.Collection");
	}
	
	@Test public void testCollectionExtensions_05() throws Exception {
		assertEvaluatesTo(Collections.singletonList("foo"), "{ var x = newArrayList('foo') var result = x.immutableCopy() x.clear() result  }");
		assertEvaluatesWithException(UnsupportedOperationException.class, "{ newArrayList('').immutableCopy().clear() null }");
	}
	
	@Test public void testCollectionExtensions_06() throws Exception {
		assertEvaluatesTo(Collections.singleton("foo"), "{ var x = newHashSet('foo') var result = x.immutableCopy() x.clear() result }");
		assertEvaluatesWithException(UnsupportedOperationException.class, "{ newHashSet('').immutableCopy().clear null }");
	}
	
	@Test public void testCollectionExtensions_07() throws Exception {
		assertEvaluatesTo(newArrayList("a", "b", "c"), "{ var x = newArrayList() x.addAll('a', 'b', 'c') x }");
		assertEvaluatesTo(Boolean.FALSE, "newHashSet('a', 'b', 'c').addAll('a', 'b', 'c')");
	}
	
	@Test public void testCollectionExtensions_08() throws Exception {
		assertEvaluatesTo("a", "{ var x = <String[]>newArrayList('a,b'.split(',')) x.head.head }");
	}
	
	@Test public void testCollectionExtensions_09() throws Exception {
		assertEvaluatesTo("a", "{ var x = <Iterable<String>>newArrayList('a,b'.split(',')) x.head.head }");
	}
	
	@Test public void testCollectionExtensions_10() throws Exception {
		assertEvaluatesTo("a", "{ var x = <Iterable<String>>newArrayList('a,b'.split(',')).flatten x.head }");
	}
	
	@Test public void testListExtensions_01() throws Exception {
		assertEvaluatesTo(newArrayList("a", "b", "c"), "newArrayList('c', 'a', 'b').sortInplace()");
		assertEvaluatesTo(newArrayList("a", "b", "c"), "newArrayList('c', 'a', 'b').sort()");
		assertEvaluatesTo("b", "{ var l = newArrayList('c', 'a', 'b', 'd') l.sortInplace() l.get(1) }");
		assertEvaluatesTo("a", "{ var l = newArrayList('c', 'a', 'b', 'd') l.sort() l.get(1) }");
	}
	
	@Test public void testListExtensions_02() throws Exception {
		assertEvaluatesTo(newArrayList("a", "b", "c"), "(newArrayList('c', 'a', 'b') as Iterable<String>).sort(a,b|a.compareTo(b))");
		assertEvaluatesTo(newArrayList("a", "b", "c"), "newArrayList('c', 'a', 'b').sortInplace(a,b|a.compareTo(b))");
		assertEvaluatesTo(newArrayList("c", "b", "a"), "(newArrayList('c', 'a', 'b') as Iterable<String>).sort(a,b|b.compareTo(a))");
		assertEvaluatesTo(newArrayList("c", "b", "a"), "newArrayList('c', 'a', 'b').sortInplace(a,b|b.compareTo(a))");
		assertEvaluatesTo("a", "{ var l = newArrayList('c', 'a', 'b', 'd') (l as Iterable<String>).sort(a,b|a.compareTo(b)) l.get(1) }");
		assertEvaluatesTo("b", "{ var l = newArrayList('c', 'a', 'b', 'd') l.sortInplace(a,b|a.compareTo(b)) l.get(1) }");
	}
	
	@Test public void testListExtensions_03() throws Exception {
		assertEvaluatesTo(newArrayList("aaa", "bb", "c"), "newArrayList('c', 'aaa', 'bb').sortBy(s|-s.length)");
		assertEvaluatesTo(newArrayList("aaa", "bb", "c"), "newArrayList('c', 'aaa', 'bb').sortInplaceBy(s|-s.length)");
		assertEvaluatesTo(newArrayList("c", "bb", "aaa"), "newArrayList('c', 'aaa', 'bb').sortBy(s|s.length)");
		assertEvaluatesTo(newArrayList("c", "bb", "aaa"), "newArrayList('c', 'aaa', 'bb').sortInplaceBy(s|s.length)");
		assertEvaluatesTo("a", "{ var l = newArrayList('c', 'a', 'b', 'd') l.sortBy(a|a) l.get(1) }");
		assertEvaluatesTo("b", "{ var l = newArrayList('c', 'a', 'b', 'd') l.sortInplaceBy(a|a) l.get(1) }");
	}
	
	@Test public void testMemberCallOnMultiType_01() throws Exception {
		assertEvaluatesTo("ClassB", "(if (false) new testdata.ClassA() else new testdata.ClassB()).getClassName()");
		assertEvaluatesTo("CLASSB", "(if (false) new testdata.ClassA() else new testdata.ClassB()).getUpperCaseClassName()");
		assertEvaluatesTo("ClassA", "(if (true) new testdata.ClassA() else new testdata.ClassB()).getClassName()");
		assertEvaluatesTo("CLASSA", "(if (true) new testdata.ClassA() else new testdata.ClassB()).getUpperCaseClassName()");
	}
	
	@Test public void testMemberCallOnMultiType_02() throws Exception {
		assertEvaluatesTo(Integer.valueOf(20), "(if (false) new Double('-20') else new Integer('20')).intValue");
		assertEvaluatesTo(Integer.valueOf(-20), "(if (true) new Double('-20') else new Integer('20')).intValue");
	}
	
	@Test public void testMemberCallOnMultiType_03() throws Exception {
		assertEvaluatesTo(
				Integer.valueOf(20), 
				"newArrayList('20').map(s|if (false) new Double(s) else new Integer(s)).head.intValue");
	}
	
	@Test public void testMemberCallOnMultiType_04() throws Exception {
		assertEvaluatesTo(
				Integer.valueOf(20), 
				"newArrayList(if (false) new Double('-20') else new Integer('20')).map(v|v.intValue).head");
	}
	
	@Test public void testMemberCallOnMultiType_05() throws Exception {
		assertEvaluatesTo(Integer.valueOf(20), "{ var number = if (false) new Double('-10') else new Integer('20') number.intValue}");
	}
	
	@Test public void testMemberCallOnMultiType_06() throws Exception {
		assertEvaluatesTo(Integer.valueOf(20), "{ var x = if (false) new Double('-10') else new Integer('20') x.intValue }");
	}
	
	@Ignore("This is actually not conformant except if generics are ignored")
	@Test public void testMemberCallOnMultiType_07() throws Exception {
		assertEvaluatesTo(Boolean.TRUE, "(if (false) new Double('-20') else new Integer('10')) >= 0");
	}
	
	@Ignore("This is actually not conformant except if generics are ignored")
	@Test public void testMemberCallOnMultiType_08() throws Exception {
		assertEvaluatesTo(Boolean.FALSE, "(if (false) new Double('-20') else new Integer('10')) < 0");
	}
	
	@Test public void testMemberCallOnMultiType_09() throws Exception {
		assertEvaluatesTo(
				Integer.valueOf(20), 
				"{ val Object o = newArrayList(if (false) new Double('-20') else new Integer('20')).map(v|v.intValue).head o }");
	}
	
	@Test public void testBug343144_01() throws Exception {
		for (int i = 0; i < 1; i++) {
		assertEvaluatesTo(Integer.valueOf(3), 
			"{" +
			"newArrayList('ab', 'abc').fold(0 as Integer, [max, s | Math::max(s.length, max)]);" +
			"newArrayList('ab', 'abc').fold(0 as Integer, [max, s | Math::max(s.length, max)]);" +
			"newArrayList('ab', 'abc').fold(0 as Integer, [max, s | Math::max(s.length, max)]);" +
			"newArrayList('ab', 'abc').fold(0 as Integer, [max, s | Math::max(s.length, max)]);" +
			"newArrayList('ab', 'abc').fold(0 as Integer, [max, s | Math::max(s.length, max)]);" +
			"newArrayList('ab', 'abc').fold(0 as Integer, [max, s | Math::max(s.length, max)]);" +
			"newArrayList('ab', 'abc').fold(0 as Integer, [max, s | Math::max(s.length, max)]);" +
			"newArrayList('ab', 'abc').fold(0 as Integer, [max, s | Math::max(s.length, max)]);" +
			"newArrayList('ab', 'abc').fold(0 as Integer, [max, s | Math::max(s.length, max)]);" +
			"newArrayList('ab', 'abc').fold(0 as Integer, [max, s | Math::max(s.length, max)]);" +
			"newArrayList('ab', 'abc').fold(0 as Integer, [max, s | Math::max(s.length, max)]);" +
			"newArrayList('ab', 'abc').fold(0 as Integer, [max, s | Math::max(s.length, max)]);" +
			"newArrayList('ab', 'abc').fold(0 as Integer, [max, s | Math::max(s.length, max)]);" +
			"newArrayList('ab', 'abc').fold(0 as Integer, [max, s | Math::max(s.length, max)]);" +
			"newArrayList('ab', 'abc').fold(0 as Integer, [max, s | Math::max(s.length, max)]);" +
			"newArrayList('ab', 'abc').fold(0 as Integer, [max, s | Math::max(s.length, max)]);" +
			"newArrayList('ab', 'abc').fold(0 as Integer, [max, s | Math::max(s.length, max)]);" +
			"newArrayList('ab', 'abc').fold(0 as Integer, [max, s | Math::max(s.length, max)]);" +
			"newArrayList('ab', 'abc').fold(0 as Integer, [max, s | Math::max(s.length, max)]);" +
			"newArrayList('ab', 'abc').fold(0 as Integer, [max, s | Math::max(s.length, max)]);" +
			"}"
		);
		}
	}
	
	@Test public void testBug343144_02() throws Exception {
		assertEvaluatesTo(Integer.valueOf(3), 
			"newArrayList('ab', 'abc').fold(0, [Integer max, s | Math::max(s.length, max)])");
	}
	
	@Test public void testBug343144_03() throws Exception {
		assertEvaluatesTo(Integer.valueOf(3), 
			"newArrayList('ab', 'abc').fold(0, [max, s | Math::max(s.length, max)])");
	}
	
	@Test public void testBug343144_04() throws Exception {
		assertEvaluatesTo(Integer.valueOf(3), 
			"{ val Integer i = 0 newArrayList('ab', 'abc').fold(i, [max, s | Math::max(s.length, max)]) }");
	}
	
	@Test public void testBug343144_05() throws Exception {
		assertEvaluatesTo(Integer.valueOf(3), 
			"{ val int i = 0 newArrayList('ab', 'abc').fold(i, [max, s | Math::max(s.length, max)]) }");
	}
	
	@Test public void testBug343144_06() throws Exception {
		assertEvaluatesTo(Integer.valueOf(3), 
			"{ val i = 0 newArrayList('ab', 'abc').fold(i, [max, s | Math::max(s.length, max)]) }");
	}
	
	@Test public void testBug343144_long_01() throws Exception {
		assertEvaluatesTo(Long.valueOf(3), 
			"newArrayList('ab', 'abc').fold(0.longValue, [max, s | Math::max(s.length, max)])");
	}
	
	@Test public void testBug343144_long_02() throws Exception {
		assertEvaluatesTo(Long.valueOf(3), 
			"newArrayList('ab', 'abc').fold(0.longValue, [Long max, s | Math::max(s.length, max)])");
	}
	
	@Test public void testBug343144_long_03() throws Exception {
		assertEvaluatesTo(Long.valueOf(3), 
			"newArrayList('ab', 'abc').fold(0.longValue, [max, s | Math::max(s.length, max as Long)])");
	}
	
	@Test public void testBug343144_long_04() throws Exception {
		assertEvaluatesTo(Long.valueOf(3), 
			"{ val Long i = 0.longValue newArrayList('ab', 'abc').fold(i, [max, s | Math::max(s.length, max)]) }");
	}
	
	@Test public void testBug343144_long_05() throws Exception {
		assertEvaluatesTo(Long.valueOf(3), 
			"{ val long i = 0.longValue newArrayList('ab', 'abc').fold(i, [max, s | Math::max(s.length, max)]) }");
	}
	
	@Test public void testBug343144_long_06() throws Exception {
		assertEvaluatesTo(Long.valueOf(3), 
			"{ val i = 0.longValue as Long newArrayList('ab', 'abc').fold(i, [max, s | Math::max(s.length, max)]) }");
	}
	
	@Test public void testBug343144_float_01() throws Exception {
		assertEvaluatesTo(Float.valueOf(3), 
			"newArrayList('ab', 'abc').fold(0.floatValue, [max, s | Math::max(s.length, max)])");
	}
	
	@Test public void testBug343144_float_02() throws Exception {
		assertEvaluatesTo(Float.valueOf(3), 
			"newArrayList('ab', 'abc').fold(0.floatValue, [Float max, s | Math::max(s.length, max)])");
	}
	
	@Test public void testBug343144_float_03() throws Exception {
		assertEvaluatesTo(Float.valueOf(3), 
			"newArrayList('ab', 'abc').fold(0.floatValue, [max, s | Math::max(s.length, max as Float)])");
	}
	
	@Test public void testBug343144_float_04() throws Exception {
		assertEvaluatesTo(Float.valueOf(3), 
			"{ val Float i = 0.floatValue newArrayList('ab', 'abc').fold(i, [max, s | Math::max(s.length, max)]) }");
	}
	
	@Test public void testBug343144_float_05() throws Exception {
		assertEvaluatesTo(Float.valueOf(3), 
			"{ val float i = 0.floatValue newArrayList('ab', 'abc').fold(i, [max, s | Math::max(s.length, max)]) }");
	}
	
	@Test public void testBug343144_float_06() throws Exception {
		assertEvaluatesTo(Float.valueOf(3), 
			"{ val i = 0.floatValue as Float newArrayList('ab', 'abc').fold(i, [max, s | Math::max(s.length, max)]) }");
	}
	
	@Test public void testBug342434_01() throws Exception {
		assertEvaluatesTo("baz", 
			"{\n" + 
			"    val x = newArrayList('foo','bar','baz').toArray\n" + 
			"    val arrayAccess = new testdata.ArrayClient2<Object>(x)\n" + 
			"    arrayAccess.set(1,arrayAccess.get(0))\n" + 
			"    return arrayAccess.get(2)\n" + 
			"}");
	}
	
	@Test public void testBug342434_02() throws Exception {
		assertEvaluatesTo("baz", 
			"{\n" + 
			"    val x = newArrayList('foo','bar','baz').toArray\n" + 
			"    val arrayAccess = new testdata.ArrayClient2(x)\n" + 
			"    arrayAccess.set(1,arrayAccess.get(0))\n" + 
			"    return arrayAccess.get(2)\n" + 
			"}");
	}
	
	@Test public void testBug342434_03() throws Exception {
		assertEvaluatesTo("foo", 
			"{\n" + 
			"    val x = new testdata.GenericType1('foo')\n" + 
			"    val testdata.GenericType1<String> y = x\n" + 
			"    y.get\n" + 
			"}");
	}
	
	@Test public void testBug342434_04() throws Exception {
		assertEvaluatesTo("foo", 
			"{\n" + 
			"    val testdata.GenericType1<String> x = new testdata.GenericType1()\n" + 
			"    x.set('foo')\n" + 
			"    x.get\n" + 
			"}");
	}
	
	@Test public void testBug342434_05() throws Exception {
		assertEvaluatesTo("baz", 
			"{\n" + 
			"    val x = newArrayList('foo','bar','baz').toArray\n" + 
			"    val arrayAccess = testdata::ArrayClient2::access(x)\n" + 
			"    arrayAccess.set(1,arrayAccess.get(0))\n" + 
			"    return arrayAccess.get(2)\n" + 
			"}");
	}

	@Test public void testBug342434_06() throws Exception {
		assertEvaluatesTo("baz", 
			"{\n" + 
			"    val x = newArrayList('foo','bar','baz').toArray\n" + 
			"    val arrayAccess = new testdata.ArrayClient2<Object>(x)\n" + 
			"    arrayAccess.set(1,arrayAccess.get(0))\n" + 
			"    arrayAccess.get(2)\n" + 
			"}");
	}
	
	@Test public void testBug342434_07() throws Exception {
		assertEvaluatesTo("baz", 
			"{\n" + 
			"    val x = newArrayList('foo','bar','baz').toArray\n" + 
			"    val arrayAccess = new testdata.ArrayClient2(x)\n" + 
			"    arrayAccess.set(1,arrayAccess.get(0))\n" + 
			"    arrayAccess.get(2)\n" + 
			"}");
	}

	@Test public void testBug342434_08() throws Exception {
		assertEvaluatesTo("baz", 
			"{\n" + 
			"    val x = newArrayList('foo','bar','baz').toArray\n" + 
			"    val arrayAccess = testdata::ArrayClient2::access(x)\n" + 
			"    arrayAccess.set(1,arrayAccess.get(0))\n" + 
			"    arrayAccess.get(2)\n" + 
			"}");
	}
	
	@Test public void testBug349762_01() throws Exception {
		assertEvaluatesTo(Boolean.TRUE, 
			"try {\n" + 
			"    throw new NullPointerException()\n" +
			"} catch(Exception e) {\n" +
			"    [Exception e2 | e==e2].apply(e)\n" + 
			"}");
	}
	
	@Test public void testBug349762_02() throws Exception {
		assertEvaluatesTo("a", 
				"switch s: 'abc' as CharSequence {\n" +
				"  String: [Integer a, Integer b| s.substring(a, b)].apply(0, 1)\n" +
				"}");
	}
	
	@Test public void testBug347175() throws Exception {
		assertEvaluatesTo(Boolean.FALSE, "(null as Boolean)?.booleanValue()");
		assertEvaluatesTo(Byte.valueOf((byte)0), "(null as Byte)?.byteValue()");
		assertEvaluatesTo(Character.valueOf((char)0), "(null as Character)?.charValue()");
		assertEvaluatesTo(Short.valueOf((short)0), "(null as Short)?.shortValue()");
		assertEvaluatesTo(Integer.valueOf(0), "(null as Integer)?.intValue()");
		assertEvaluatesTo(Long.valueOf(0l), "(null as Long)?.longValue()");
		assertEvaluatesTo(Float.valueOf(0f), "(null as Float)?.floatValue()");
		assertEvaluatesTo(Double.valueOf(0.), "(null as Double)?.doubleValue()");
	}
	
	@Test public void test351809() throws Exception {
		assertEvaluatesTo(Boolean.FALSE, 
				"{\n" +
				"  val l = new java.util.ArrayList<String>()\n" + 
				"  new java.util.ArrayList<CharSequence>() += l\n" +
				"}");
	}
	
	@Test public void test351809_02() throws Exception {
		assertEvaluatesTo(Boolean.FALSE, 
				"{\n" +
				"  val l = new java.util.ArrayList<String>\n" + 
				"  new java.util.ArrayList<CharSequence> += l\n" +
				"}");
	}
	
	@Test public void testFilterArrays_01() throws Exception {
		assertEvaluatesTo(newArrayList("a"), 
				"{\n" +
				"  val filtered = new testdata.ArrayClient().toStringArray('a', 'c').filter(e|e < 'c')" +
				"  filtered.toList\n" +
				"}");
	}
	
	@Test public void testFilterArrays_02() throws Exception {
		assertEvaluatesTo("result", 
				"{\n" +
				"  for(s: new testdata.ArrayClient().toStringArray('a', 'b').filter(e|e!=null))" +
				"    s.toUpperCase\n" +
				"  'result'" +
				"}");
	}
	
	@Test public void testBug370302() throws Exception {
		assertEvaluatesTo(3,
				"{\n" +
				"  val strings = newHashSet('foobar', 'bar', 'longer')\n" +
				"  val (String)=>int length = [s | s.length]\n" +
				"  val (int,int)=>int min = [i,j | if (i < j) i else j]\n" +
				"  strings.map(length).reduce(min)\n" +
				"}");
	}
	
	@Test public void testBooleanArithmetics() throws Exception {
		assertEvaluatesTo(false ^ (false || true) && true, "false.xor(false || true) && true");
	}
	
	@Test public void testIntegerArithmetics() throws Exception {
		assertEvaluatesTo(-1+2*3/4%5, "-1+2*3/4%5"); 
	}
	
	@Test public void testIntegerBitOperations() throws Exception {
		assertEvaluatesTo(~(1 | 2 & 3), "1.bitwiseOr(2).bitwiseAnd(3).bitwiseNot()");
	}
	
	@Test public void testIntegerShiftOperations_01() throws Exception {
		assertEvaluatesTo(2 >> 1, "2 >> 1");
	}
	@Test public void testIntegerShiftOperations_02() throws Exception {
		assertEvaluatesTo(-2 >>> 1, " -2 >>> 1");
	}
	@Test public void testIntegerShiftOperations_03() throws Exception {
		assertEvaluatesTo(2 << 1, "2 << 1");
	}

	@Test public void testLongShiftOperations_01() throws Exception {
		assertEvaluatesTo(2l >> 1, "2l >> 1");
	}
	@Test public void testLongShiftOperations_02() throws Exception {
		assertEvaluatesTo(-2l >>> 1, " -2l >>> 1");
	}
	@Test public void testLongShiftOperations_03() throws Exception {
		assertEvaluatesTo(2l << 1, "2l << 1");
	}
	
	protected void assertIntegerAssignOperations(Integer expectedResult, String xbaseCode) throws Exception {
		assertEvaluatesTo(expectedResult, xbaseCode);
	}
	
	@Test public void testIntegerAssignOperations_01() throws Exception {
		int i = 2;
		assertIntegerAssignOperations(i += 3, 
				"{\n" +
				"	var i = 2\n" +
				"	i += 3\n" +
				"	i" +
				"}");
	}
	
	@Test public void testIntegerAssignOperations_02() throws Exception {
		int i = 2;
		assertIntegerAssignOperations(i *= 3, 
				"{\n" +
				"	var i = 2\n" +
				"	i *= 3\n" +
				"	i" +
				"}");
	}
	
	@Test public void testIntegerAssignOperations_03() throws Exception {
		int i = 2;
		assertIntegerAssignOperations(i += i *= 2, 
				"{\n" +
				"	var i = 2\n" +
				"	i += i *= 2\n" +
				"	i" +
				"}");
	}
	
	@Test public void testIntegerAssignOperations_04() throws Exception {
		int i = 2;
		assertIntegerAssignOperations(i *= i += 2, 
				"{\n" +
				"	var i = 2\n" +
				"	i *= i += 2\n" +
				"	i" +
				"}");
	}
	
	@Test public void testIntegerAssignOperations_05() throws Exception {
		int i = 2;
		assertIntegerAssignOperations(i += (3 + (i *= 2)), 
				"{\n" +
				"	var i = 2\n" +
				"	i += (3 + (i *= 2))\n" +
				"	i" +
				"}");
	}
	
	@Test public void testIntegerAssignOperations_06() throws Exception {
		int i = 2;
		assertIntegerAssignOperations(i *= (3 + (i += 2)), 
				"{\n" +
				"	var i = 2\n" +
				"	i *= (3 + (i += 2))\n" +
				"	i" +
				"}");
	}
	
	@Test public void testIntegerAssignOperations_07() throws Exception {
		int i = 10;
		assertIntegerAssignOperations(i *= i %= i -= 2, 
				"{\n" +
				"	var i = 10\n" +
				"	i *= i %= i -= 2\n" +
				"	i" +
				"}");
	}

	@Test public void testIntegerAssignOperations_08() throws Exception {
		int i = 10;
		assertIntegerAssignOperations(i *= i /= i -= 2, 
				"{\n" +
				"	var i = 10\n" +
				"	i *= i /= i -= 2\n" +
				"	i" +
				"}");
	}

	@Test public void testBigIntegerBitOperations() throws Exception {
		assertEvaluatesTo(new BigInteger("1").or(new BigInteger("2")).and(new BigInteger("3")).not(), 
				"1BI.or(2BI).and(3BI).not()"); 
	}

	@Test public void testBigIntegerArithmetics() throws Exception {
		BigInteger x = new BigInteger("2");
		assertEvaluatesTo(x.negate().add(x.multiply(x).divide(x).mod(x)), 
				"{ val x=2BI; -x+x*x/x%x }"); 
	}

	@Test public void testDoubleArithmetics() throws Exception {
		assertEvaluatesTo(-(2.+2.*2./2.), "-(2d+2d*2d/2d)"); 
	}
	
	@Test public void testBigDecimalArithmetics() throws Exception {
		BigDecimal x = new BigDecimal("2");
		assertEvaluatesTo(x.negate().add(x.multiply(x).divide(x)), 
				"-2bd+2bd*2bd/2bd"); 
	}
	
	@Test public void testBigDecimalDivide() throws Exception {
		BigDecimal x = new BigDecimal("1");
		BigDecimal y = new BigDecimal("3");
		assertEvaluatesTo(x.divide(y, MathContext.DECIMAL128), 
				"1BD/3BD"); 
	}
	
	@Test
	public void testWithOperator() throws Exception {
		assertEvaluatesTo("foobar", "(new StringBuilder => [ append('foo') it => [foo | foo.append('bar')] ]).toString");
	}
	
	@Test
	public void testItAssignment() throws Exception {
		assertEvaluatesTo(42l, "(new java.util.Date() => [ time = 42l ]).time");
	}
	
	@Test
	public void testItAssignment_1() throws Exception {
		assertEvaluatesTo(42l, "{val it = new java.util.Date(); time = 42l; time }");
	}
	
	@Test public void testIteratorExtensions() throws Exception {
		assertEvaluatesTo("Foo", "newArrayList('Foo').iterator.toIterable.iterator.next");
	}
	
	@Test public void testExceptionInClosure_01() throws Exception {
		assertEvaluatesWithException(IOException.class, 
				"{val ()=>void proc = [| throw new java.io.IOException()] proc.apply return null}");
	}
	
	@Test public void testExceptionInClosure_02() throws Exception {
		assertEvaluatesWithException(IOException.class, 
				"{ newArrayList('foo').forEach( s | throw new java.io.IOException() ) return null }");
	}
	
	@Test public void testExceptionInClosure_03() throws Exception {
		assertEvaluatesWithException(IOException.class, 
				"{val ()=>void proc = [| throw new java.io.IOException] proc.apply return null}");
	}
	
	@Test public void testExceptionInClosure_04() throws Exception {
		assertEvaluatesWithException(IOException.class, 
				"{ newArrayList('foo').forEach( s | throw new java.io.IOException ) return null }");
	}
	
	@Test public void testTryCatch_07() throws Exception {
		assertEvaluatesTo("", 
				"try new String() " +
				"  catch(java.io.IOException e) 'foo'" +
				"  catch(Exception e) 'bar'");
	}
	
	@Test public void testTryCatch_08() throws Exception {
		assertEvaluatesTo("", 
				"try new String " +
				"  catch(java.io.IOException e) 'foo'" +
				"  catch(Exception e) 'bar'");
	}
	
	@Test public void testTryCatch_09() throws Exception {
		assertEvaluatesTo("foo", 
				"try { 'foo' }" +
						"  catch(RuntimeException e) { e.printStackTrace() null }");
	}
	
	@Test 
	public void testListLiteral_0() throws Exception {
		assertEvaluatesTo(newArrayList(), "#[]");
	}
	
	@Test 
	public void testListLiteral_1() throws Exception {
		assertEvaluatesTo(newArrayList("Foo", "Bar"), "#['Foo', 'Bar']");
	}
	
	@Test 
	public void testListLiteral_2() throws Exception {
		assertEvaluatesTo(newArrayList(1, "Foo", true), "#[1, 'Foo', true]");
	}
		
	@Test 
	public void testListLiteral_3() throws Exception {
		assertEvaluatesToArray(new String[] {"Foo"}, "{ val String[] x = #['Foo']  x }");
	}
		
	@Test 
	// @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=403357
	public void testListLiteral_4() throws Exception {
		assertEvaluatesTo(newArrayList((Object)null), "#[null]");
	}
		
	@Test 
	// @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=403357
	public void testListLiteral_5() throws Exception {
		assertEvaluatesTo(newArrayList(null, ""), "#[null, '']");
	}
	
	@Test 
	public void testListLiteral_6() throws Exception {
		assertEvaluatesTo("", "{ val char[] c = #[] String.valueOf(c) }");
	}
		
	@Test 
	public void testSetLiteral_0() throws Exception {
		assertEvaluatesTo(newHashSet(), "#{}");
	}
	
	@Test 
	public void testSetLiteral_1() throws Exception {
		assertEvaluatesTo(newHashSet("Foo", "Bar"), "#{'Foo', 'Bar'}");
	}

	@Test 
	public void testSetLiteral_2() throws Exception {
		assertEvaluatesTo(newHashSet(1, "Foo", true), "#{1, 'Foo', true}");
	}
	
	@Test 
	public void testSetLiteral_3() throws Exception {
		assertEvaluatesToArray(new String[] {"Foo"}, "{ val String[] x = #{'Foo'}  x}");
	}
	
	@Test 
	// @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=403357
	public void testSetLiteral_4() throws Exception {
		assertEvaluatesTo(newHashSet((Object) null), "#{null}");
	}
		
	@Test 
	// @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=403357
	public void testSetLiteral_5() throws Exception {
		assertEvaluatesTo(newHashSet(null, ""), "#{null, ''}");
	}
		
	@SuppressWarnings("unchecked")
	@Test 
	public void testSetLiteral_6() throws Exception {
		assertEvaluatesTo(newHashSet(Pair.of("foo", "bar")), "{ val java.util.Set x = #{'foo' -> 'bar'} x }");
	}
	
	@Test 
	public void testMapLiteral_0() throws Exception {
		assertEvaluatesTo(ImmutableMap.builder().put("foo", "bar").build(), "#{'foo' -> 'bar'}");
	}
	
	@Test 
	public void testMapLiteral_1() throws Exception {
		assertEvaluatesTo(Collections.emptyMap(), "{val java.util.Map x = #{} x}");
	}
	
	@Test 
	public void testMapLiteral_2() throws Exception {
		assertEvaluatesTo(ImmutableMap.builder().put("foo", 1).put("bar", true).build(), "#{'foo'->1, 'bar'->true}");
	}
	
	@Test 
	// @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=403357
	public void testMapLiteral_3() throws Exception {
		HashMap<String, Object> map = newHashMap();
		map.put("foo", null);
		assertEvaluatesTo(map, "#{'foo'->null}");
	}
	
	@Test 
	// @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=403357
	public void testMapLiteral_4() throws Exception {
		HashMap<Object, String> map = newHashMap();
		map.put(null, "foo");
		assertEvaluatesTo(map, "#{null->'foo'}");
	}
	
	@Test 
	// @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=403357
	public void testMapLiteral_5() throws Exception {
		HashMap<Object, Object> map = newHashMap();
		map.put(null, null);
		assertEvaluatesTo(map, "#{null->null}");
	}
	
	@Test
	// @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=412642
	public void testMapLiteral_6() throws Exception {
		HashMap<Object, Object> map = newHashMap();
		map.put("Apple", new Integer(1));
		assertEvaluatesTo(map, "{\n" +
									"val pair = 'Apple' -> 1\n" +
									"#{pair}\n" +
								"} ");
	}

	@Test
	// @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=412642
	public void testMapLiteral_7() throws Exception {
		HashMap<Object, Object> map = newHashMap();
		map.put("Apple", new Integer(1));
		assertEvaluatesTo(map, "{\n" +
									"#{ if (true) 'Apple' -> 1 else 'Banana' -> 2 }" +
								"} ");
	}
	
	@Test
	public void testIncrementOnByte() throws Exception {
		byte i = 2;
		i++;
		assertEvaluatesTo(i, 
				"{\n" +
					"var i = 2 as byte\n" +
					"i++\n" +
					"i" +
				"}");
	}
	
	@Test
	public void testIncrementOnByte_2() throws Exception {
		byte i = 2;
		assertEvaluatesTo(i++, 
				"{\n" +
					"var i = 2 as byte\n" +
					"i++\n" +
				"}");
	}
	
	@Test
	public void testIncrementOnByte_3() throws Exception {
		byte i = 2;
		assertEvaluatesTo(i++ + i, 
				"{\n" +
					"var i = 2 as byte\n" +
					"i++ + i\n" +
				"}");
	}
	
	@Test
	public void testIncrementOnByte_4() throws Exception {
		byte i = 2;
		assertEvaluatesTo(i++, 
				"{\n" +
					"var Byte i = 2 as byte\n" +
					"i++\n" +
				"}");
	}
	
	@Test
	public void testDecrementOnByte() throws Exception {
		byte i = 2;
		i--;
		assertEvaluatesTo(i, 
				"{\n" +
					"var i = 2 as byte\n" +
					"i--\n" +
					"i" +
				"}");
	}
	
	@Test
	public void testDecrementOnByte_2() throws Exception {
		byte i = 2;
		assertEvaluatesTo(i--, 
				"{\n" +
					"var i = 2 as byte\n" +
					"i--\n" +
				"}");
	}
	
	@Test
	public void testDecrementOnByte_3() throws Exception {
		byte i = 2;
		assertEvaluatesTo(i-- - i, 
				"{\n" +
					"var i = 2 as byte\n" +
					"i-- - i\n" +
				"}");
	}
	
	@Test
	public void testDecrementOnByte_4() throws Exception {
		byte i = 2;
		i--;
		assertEvaluatesTo(i, 
				"{\n" +
					"var Byte i = 2 as byte\n" +
					"i--\n" +
					"i" +
				"}");
	}
	
	@Test
	public void testIncrementOnCharacter() throws Exception {
		char i = 2;
		i++;
		assertEvaluatesTo(i, 
				"{\n" +
					"var i = 2 as char\n" +
					"i++\n" +
					"i" +
				"}");
	}
	
	@Test
	public void testIncrementOnCharacter_2() throws Exception {
		char i = 2;
		assertEvaluatesTo(i++, 
				"{\n" +
					"var i = 2 as char\n" +
					"i++\n" +
				"}");
	}
	
	@Test
	public void testIncrementOnCharacter_3() throws Exception {
		char i = 2;
		assertEvaluatesTo(i++ + i, 
				"{\n" +
					"var i = 2 as char\n" +
					"i++ + i\n" +
				"}");
	}
	
	@Test
	public void testIncrementOnCharacter_4() throws Exception {
		char i = 2;
		i++;
		assertEvaluatesTo(i, 
				"{\n" +
					"var Character i = 2 as char\n" +
					"i++\n" +
					"i" +
				"}");
	}
	
	@Test
	public void testDecrementOnCharacter() throws Exception {
		char i = 2;
		i--;
		assertEvaluatesTo(i, 
				"{\n" +
					"var i = 2 as char\n" +
					"i--\n" +
					"i" +
				"}");
	}
	
	@Test
	public void testDecrementOnCharacter_2() throws Exception {
		char i = 2;
		assertEvaluatesTo(i--, 
				"{\n" +
					"var i = 2 as char\n" +
					"i--\n" +
				"}");
	}
	
	@Test
	public void testDecrementOnCharacter_3() throws Exception {
		char i = 2;
		assertEvaluatesTo(i-- - i, 
				"{\n" +
					"var i = 2 as char\n" +
					"i-- - i\n" +
				"}");
	}
	
	@Test
	public void testDecrementOnCharacter_4() throws Exception {
		char i = 2;
		i--;
		assertEvaluatesTo(i, 
				"{\n" +
					"var Character i = 2 as char\n" +
					"i--\n" +
					"i" +
				"}");
	}
	
	@Test
	public void testIncrementOnShort() throws Exception {
		short i = 2;
		i++;
		assertEvaluatesTo(i, 
				"{\n" +
					"var i = 2 as short\n" +
					"i++\n" +
					"i" +
				"}");
	}
	
	@Test
	public void testIncrementOnShort_2() throws Exception {
		short i = 2;
		assertEvaluatesTo(i++, 
				"{\n" +
					"var i = 2 as short\n" +
					"i++\n" +
				"}");
	}
	
	@Test
	public void testIncrementOnShort_3() throws Exception {
		short i = 2;
		assertEvaluatesTo(i++ + i, 
				"{\n" +
					"var i = 2 as short\n" +
					"i++ + i\n" +
				"}");
	}
	
	@Test
	public void testIncrementOnShort_4() throws Exception {
		short i = 2;
		i++;
		assertEvaluatesTo(i, 
				"{\n" +
					"var Short i = 2 as short\n" +
					"i++\n" +
					"i" +
				"}");
	}
	
	@Test
	public void testDecrementOnShort() throws Exception {
		short i = 2;
		i--;
		assertEvaluatesTo(i, 
				"{\n" +
					"var i = 2 as short\n" +
					"i--\n" +
					"i" +
				"}");
	}
	
	@Test
	public void testDecrementOnShort_2() throws Exception {
		short i = 2;
		assertEvaluatesTo(i--, 
				"{\n" +
					"var i = 2 as short\n" +
					"i--\n" +
				"}");
	}
	
	@Test
	public void testDecrementOnShort_3() throws Exception {
		short i = 2;
		assertEvaluatesTo(i-- - i, 
				"{\n" +
					"var i = 2 as short\n" +
					"i-- - i\n" +
				"}");
	}
	
	@Test
	public void testDecrementOnShort_4() throws Exception {
		short i = 2;
		i--;
		assertEvaluatesTo(i, 
				"{\n" +
					"var Short i = 2 as short\n" +
					"i--\n" +
					"i" +
				"}");
	}
	
	@Test
	public void testIncrementOnInteger() throws Exception {
		int i = 2;
		i++;
		assertEvaluatesTo(i, 
				"{\n" +
					"var i = 2\n" +
					"i++\n" +
					"i" +
				"}");
	}
	
	@Test
	public void testIncrementOnInteger_2() throws Exception {
		int i = 2;
		assertEvaluatesTo(i++, 
				"{\n" +
					"var i = 2\n" +
					"i++\n" +
				"}");
	}
	
	@Test
	public void testIncrementOnInteger_3() throws Exception {
		int i = 2;
		assertEvaluatesTo(i++ + i, 
				"{\n" +
					"var i = 2\n" +
					"i++ + i\n" +
				"}");
	}
	
	@Test
	public void testIncrementOnInteger_4() throws Exception {
		int i = 2;
		i++;
		assertEvaluatesTo(i, 
				"{\n" +
					"var Integer i = 2\n" +
					"i++\n" +
					"i" +
				"}");
	}
	
	@Test
	public void testDecrementOnInteger() throws Exception {
		int i = 2;
		i--;
		assertEvaluatesTo(i, 
				"{\n" +
					"var i = 2\n" +
					"i--\n" +
					"i" +
				"}");
	}
	
	@Test
	public void testDecrementOnInteger_2() throws Exception {
		int i = 2;
		assertEvaluatesTo(i--, 
				"{\n" +
					"var i = 2\n" +
					"i--\n" +
				"}");
	}
	
	@Test
	public void testDecrementOnInteger_3() throws Exception {
		int i = 2;
		assertEvaluatesTo(i-- - i, 
				"{\n" +
					"var i = 2\n" +
					"i-- - i\n" +
				"}");
	}
	
	@Test
	public void testDecrementOnInteger_4() throws Exception {
		int i = 2;
		i--;
		assertEvaluatesTo(i, 
				"{\n" +
					"var Integer i = 2\n" +
					"i--\n" +
					"i" +
				"}");
	}
	
	@Test
	public void testIncrementOnLong() throws Exception {
		long i = 2;
		i++;
		assertEvaluatesTo(i, 
				"{\n" +
					"var i = 2 as long\n" +
					"i++\n" +
					"i" +
				"}");
	}
	
	@Test
	public void testIncrementOnLong_2() throws Exception {
		long i = 2;
		assertEvaluatesTo(i++, 
				"{\n" +
					"var i = 2 as long\n" +
					"i++\n" +
				"}");
	}
	
	@Test
	public void testIncrementOnLong_3() throws Exception {
		long i = 2;
		assertEvaluatesTo(i++ + i, 
				"{\n" +
					"var i = 2 as long\n" +
					"i++ + i\n" +
				"}");
	}
	
	@Test
	public void testIncrementOnLong_4() throws Exception {
		long i = 2;
		i++;
		assertEvaluatesTo(i, 
				"{\n" +
					"var Long i = 2 as long\n" +
					"i++\n" +
					"i" +
				"}");
	}
	
	@Test
	public void testDecrementOnLong() throws Exception {
		long i = 2;
		i--;
		assertEvaluatesTo(i, 
				"{\n" +
					"var i = 2 as long\n" +
					"i--\n" +
					"i" +
				"}");
	}
	
	@Test
	public void testDecrementOnLong_2() throws Exception {
		long i = 2;
		assertEvaluatesTo(i--, 
				"{\n" +
					"var i = 2 as long\n" +
					"i--\n" +
				"}");
	}
	
	@Test
	public void testDecrementOnLong_3() throws Exception {
		long i = 2;
		assertEvaluatesTo(i-- - i, 
				"{\n" +
					"var i = 2 as long\n" +
					"i-- - i\n" +
				"}");
	}
	
	@Test
	public void testDecrementOnLong_4() throws Exception {
		long i = 2;
		i--;
		assertEvaluatesTo(i, 
				"{\n" +
					"var Long i = 2 as long\n" +
					"i--\n" +
					"i" +
				"}");
	}
	
	@Test
	public void testIncrementOnFloat() throws Exception {
		float i = 2;
		i++;
		assertEvaluatesTo(i, 
				"{\n" +
					"var i = 2 as float\n" +
					"i++\n" +
					"i" +
				"}");
	}
	
	@Test
	public void testIncrementOnFloat_2() throws Exception {
		float i = 2;
		assertEvaluatesTo(i++, 
				"{\n" +
					"var i = 2 as float\n" +
					"i++\n" +
				"}");
	}
	
	@Test
	public void testIncrementOnFloat_3() throws Exception {
		float i = 2;
		assertEvaluatesTo(i++ + i, 
				"{\n" +
					"var i = 2 as float\n" +
					"i++ + i\n" +
				"}");
	}
	
	@Test
	public void testIncrementOnFloat_4() throws Exception {
		float i = 2;
		i++;
		assertEvaluatesTo(i, 
				"{\n" +
					"var Float i = 2 as float\n" +
					"i++\n" +
					"i" +
				"}");
	}
	
	@Test
	public void testDecrementOnFloat() throws Exception {
		float i = 2;
		i--;
		assertEvaluatesTo(i, 
				"{\n" +
					"var i = 2 as float\n" +
					"i--\n" +
					"i" +
				"}");
	}
	
	@Test
	public void testDecrementOnFloat_2() throws Exception {
		float i = 2;
		assertEvaluatesTo(i--, 
				"{\n" +
					"var i = 2 as float\n" +
					"i--\n" +
				"}");
	}
	
	@Test
	public void testDecrementOnFloat_3() throws Exception {
		float i = 2;
		assertEvaluatesTo(i-- - i, 
				"{\n" +
					"var i = 2 as float\n" +
					"i-- - i\n" +
				"}");
	}
	
	@Test
	public void testDecrementOnFloat_4() throws Exception {
		float i = 2;
		i--;
		assertEvaluatesTo(i, 
				"{\n" +
					"var Float i = 2 as float\n" +
					"i--\n" +
					"i" +
				"}");
	}
	
	@Test
	public void testIncrementOnDouble() throws Exception {
		double i = 2;
		i++;
		assertEvaluatesTo(i, 
				"{\n" +
					"var i = 2 as double\n" +
					"i++\n" +
					"i" +
				"}");
	}
	
	@Test
	public void testIncrementOnDouble_2() throws Exception {
		double i = 2;
		assertEvaluatesTo(i++, 
				"{\n" +
					"var i = 2 as double\n" +
					"i++\n" +
				"}");
	}
	
	@Test
	public void testIncrementOnDouble_3() throws Exception {
		double i = 2;
		assertEvaluatesTo(i++ + i, 
				"{\n" +
					"var i = 2 as double\n" +
					"i++ + i\n" +
				"}");
	}
	
	@Test
	public void testIncrementOnDouble_4() throws Exception {
		double i = 2;
		i++;
		assertEvaluatesTo(i, 
				"{\n" +
					"var Double i = 2 as double\n" +
					"i++\n" +
					"i" +
				"}");
	}
	
	@Test
	public void testDecrementOnDouble() throws Exception {
		double i = 2;
		i--;
		assertEvaluatesTo(i, 
				"{\n" +
					"var i = 2 as double\n" +
					"i--\n" +
					"i" +
				"}");
	}
	
	@Test
	public void testDecrementOnDouble_2() throws Exception {
		double i = 2;
		assertEvaluatesTo(i--, 
				"{\n" +
					"var i = 2 as double\n" +
					"i--\n" +
				"}");
	}
	
	@Test
	public void testDecrementOnDouble_3() throws Exception {
		double i = 2;
		assertEvaluatesTo(i-- - i, 
				"{\n" +
					"var i = 2 as double\n" +
					"i-- - i\n" +
				"}");
	}
	
	@Test
	public void testDecrementOnDouble_4() throws Exception {
		double i = 2;
		i--;
		assertEvaluatesTo(i, 
				"{\n" +
					"var Double i = 2 as double\n" +
					"i--\n" +
					"i" +
				"}");
	}
	
	@Test
	public void testBug466974_01() throws Exception {
		int i = 0;
		int a = i = i + 1;
		int b = i == 1 ? 1 : 2;
		int result = Math.max(a, b);
		assertEvaluatesTo(result, 
				"{\n" +
					"var i = 0\n" +
					"val result = Math.max(i = i + 1, if (i == 1) { 1 } else { 2 })\n" +
					"result" +
				"}");
	}
	
	@Test
	public void testBug466974_02() throws Exception {
		int i = 0;
		Integer a = i = i + 1;
		Integer b = i == 1 ? 1 : 2;
		int result = a.compareTo(b);
		assertEvaluatesTo(result, 
				"{\n" +
					"var i = 0\n" +
					"val result = {i = i + 1}.compareTo(if (i == 1) { 1 } else { 2 })\n" +
					"result" +
				"}");
	}
	
	@Test
	public void testBug466974_03() throws Exception {
		int i = 0;
		Integer a = i = i + 1;
		Integer b = i == 1 ? i = i + 1 : -1;
		int result = Math.max(a, b);
		assertEvaluatesTo(result, 
				"{\n" +
					"var i = 0\n" +
					"val result = Math.max({i = i + 1}, if (i == 1) { i = i + 1 } else { -1 })\n" +
					"result" +
				"}");
	}
	
	@Test
	public void testBug466974_04() throws Exception {
		int i = 0;
		boolean a = (i = i + 1) == 1;
		boolean b = false; 
		if (i == 1) {
			b = true;
		}
		boolean result = a && b;
		assertEvaluatesTo(result, 
				"{\n" +
					"var i = 0\n" +
					"val result = (i = i + 1) == 1 && if(i == 1) true else false\n" +
					"result" +
				"}");
	}
	
	@Test
	public void testBug466974_05() throws Exception {
		int i = 0;
		boolean a = (i = i + 1) != 1;
		boolean b = false; 
		if (i == 1) {
			b = true;
		} 
		boolean result = a || b;
		assertEvaluatesTo(result, 
				"{\n" +
					"var i = 0\n" +
					"val result = (i = i + 1) != 1 || if(i == 1) true else false\n" +
					"result" +
				"}");
	}
	
	protected void assertEvaluatesTo(Object object, String string) throws Exception {
		Object result = invokeXbaseExpression(string);
		assertEquals(object, result);
	}

	protected void assertEvaluatesToArray(Object[] object, String string) throws Exception {
		Object result = invokeXbaseExpression(string);
		assertTrue(result.getClass().isArray());
		assertArrayEquals(object, (Object[])result);
	}

	protected void assertEvaluatesWithException(Class<? extends Throwable> class1, String string) throws Exception {
		try {
			invokeXbaseExpression(string);
		} catch (InvocationTargetException e) {
			Throwable cause = e.getCause();
			assertTrue(cause.getClass().toString(), class1.isInstance(cause));
		}
	}
	
	@Test 
	public void testNullSaveLazyEvaluation1() throws Exception {
		assertEvaluatesTo(0, "{ var x = 0; (null as String)?.substring(x = 1); return x; }");
	}
	
	@Test 
	public void testNullSaveLazyEvaluation2() throws Exception {
		assertEvaluatesTo(0, "{ val x = <String>newArrayList; var c = [|x += 'x';1]; (null as String)?.substring(c.apply); return x.size; }");
	}
	
	/**
	 * @param expression the input that should be executed 
	 */
	protected Object invokeXbaseExpression(String expression) throws Exception {
		throw new UnsupportedOperationException("Override and implement me!");
	}
}
