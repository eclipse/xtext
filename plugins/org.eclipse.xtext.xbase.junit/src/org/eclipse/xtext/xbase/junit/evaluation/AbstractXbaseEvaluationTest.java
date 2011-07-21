/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.junit.evaluation;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Stack;

import junit.framework.TestCase;

import org.junit.Test;

import testdata.ExceptionSubclass;
import testdata.OuterClass;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import static java.util.Collections.*;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Sven Efftinge
 */
public abstract class AbstractXbaseEvaluationTest extends TestCase {

	@Test public void testNestedClosures() throws Exception {
		String expr = 
				"{ " +
				" val x = 'foo' " +
				" [String s | x + [ String s1 | s1 + s + x].apply(s) ].apply(x)" +
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
	
	@Test public void testShortCircuitBooleanExpression_03() throws Exception {
		String expr = "{ val i = newArrayList(false,true).iterator" +
				"  if (i.next && i.next)" +
				"    throw new NullPointerException()" +
				"  else" +
				"    i.next" +
				"}";
		assertEvaluatesTo(true, expr);
	}
	
	@Test public void testShortCircuitBooleanExpression_04() throws Exception {
		String expr = "{ val i = newArrayList(true,false).iterator" +
		"  if (i.next || i.next)" +
		"     i.next" +
		"}";
		assertEvaluatesTo(false, expr);
	}
	
	@Test public void testForLoop() throws Exception {
		String expr = 
			    "{\n" + 
				"   val list = newArrayList('foo','bar','baz')\n" + 
				"   for (x : list.reverse) {\n" + 
				"	  x.toUpperCase\n" + 
				"   }\nnull" + 
				"}";
		assertEvaluatesTo(null, expr);
	}
	
	@Test public void testReferenceInnerClasses() throws Exception {
		assertEvaluatesTo(OuterClass.InnerClass.SINGLETON, "testdata::OuterClass$InnerClass::SINGLETON");
	}
	
	@Test public void testReferenceInnerClasses_00() throws Exception {
		assertEvaluatesTo("FOO", "[testdata.OuterClass$InnerClass param| param.toUpperCase('foo')].apply(new testdata.OuterClass$InnerClass())");
	}
	
	@Test public void testReferenceInnerClasses_01() throws Exception {
		assertEvaluatesTo(null, "{for (x : newArrayList(new testdata.OuterClass$InnerClass())) { x.toString } null}");
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
	
	/*
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=341550
	 */
	@Test public void testBug341550() throws Exception {
		assertEvaluatesTo(emptyList(),"switch emptyList() { case emptyList() : emptyList() }");
	}
	
	@Test public void testGenerics_00() throws Exception {
		assertEvaluatesTo("", "try {typeof(String).newInstance} catch(Exception e) {}");
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
	
	@Test public void testGenerics_03() throws Exception {
		assertEvaluatesTo("y",
				"{" +
				" val x = <Object>newArrayList('y',23,true)" +
				" return x.head" +
				"}");
	}
	
	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=341246
	 */
	@Test public void testUnreferencedConstructorInBlock() throws Exception {
		assertEvaluatesTo(false, "{ new String() false}");
	}
	
	@Test public void testStaticFeatureCall_01() throws Exception {
		assertEvaluatesTo("false", "String::valueOf(false)");
	}
	
	@Test public void testStaticFeatureCall_02() throws Exception {
		assertEvaluatesTo(Boolean.FALSE, "Boolean::FALSE");
	}
	
	@Test public void testPrimitiveConversion() throws Exception {
		assertEvaluatesTo("2","'ab'.length.toString");
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

	@Test public void testUnaryOperator_00() throws Exception {
		assertEvaluatesTo(new Integer(-19),"-19");
	}
	
	@Test public void testUnaryOperator_01() throws Exception {
		assertEvaluatesTo(false,"!true");
	}
	
	@Test public void testUnaryOperator_02() throws Exception {
		assertEvaluatesTo("-1","(-1).toString()");
	}
	
	@Test public void testUpToOperator() throws Exception {
		assertEvaluatesTo(new Integer(9),"(9..13).iterator().next()");
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
		assertEvaluatesTo(new Integer(8), "2**3");
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
	
	@Test public void testStringLiteral_01() throws Exception {
		assertEvaluatesTo("", "''");
	}
	
	@Test public void testStringLiteral_02() throws Exception {
		assertEvaluatesTo("literal", "'literal'");
	}
	
	@Test public void testStringLiteral_03() throws Exception {
		assertEvaluatesTo("lite\r\nr\\al", "'lite\r\nr\\\\al'");
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
		assertEvaluatesTo(Void.TYPE, "typeof(void)");
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
	
	@Test public void testIfExpression_withThrowExpression_00() throws Exception {
		assertEvaluatesWithException(NullPointerException.class, "if (false) throw new NullPointerException() else throw new NullPointerException()");
	}
	
	@Test public void testIfExpression_withThrowExpression_01() throws Exception {
		assertEvaluatesWithException(NullPointerException.class, "if (false) 'then' else throw new NullPointerException()");
	}
	
	@Test public void testIfExpression_withThrowExpression_02() throws Exception {
		assertEvaluatesTo("then", "if (true) 'then' else throw new NullPointerException()");
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
	
	@Test public void testFeatureCall_01() throws Exception {
		assertEvaluatesTo("literal", "{var x = 'literal' x}");
	}
	
	@Test public void testFeatureCall_02() throws Exception {
		assertEvaluatesTo(new Character('a'), "'a'.toCharArray.iterator.next");
	}
	
	@Test public void testFeatureCall_03() throws Exception {
		assertEvaluatesTo(Lists.newArrayList(
				new Character('a'), 
				new Character('b'),
				new Character('c')), "{ var java.util.List<Character> x = ('abc'.toCharArray as Iterable<Character>).toList() x }");
	}
	
	@Test public void testFeatureCall_03_2() throws Exception {
		assertEvaluatesTo(Lists.newArrayList(
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
	
	@Test public void testConstructorCall_02() throws Exception {
		assertEvaluatesTo("foobar", "new String('foobar')");
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
	
	@Test public void testAssignmentInBlock_01() throws Exception {
		assertEvaluatesTo("newValue", "{var x = 'literal' { x = 'newValue' } x }");
	}
	
	@Test public void testThrowInBlock() throws Exception {
		assertEvaluatesWithException(NullPointerException.class, "{ throw new NullPointerException() }");
	}
	
	@Test public void testThrowInBlock_01() throws Exception {
		assertEvaluatesWithException(NullPointerException.class, "{ 42.toString() throw new NullPointerException() }");
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
		assertEvaluatesWithException(ClassCastException.class, "{for(x: 'abc' as Object as java.util.List<Character>) null null}");
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
	
//	TODO see https://bugs.eclipse.org/bugs/show_bug.cgi?id=341048
//	@Test public void testSpreadOperator_01() throws Exception {
//		assertEvaluatesWithException(NullPointerException.class, "(null as java.util.List<Object>)*.toString()");
//		assertEvaluatesWithException(ClassCastException.class, "(new Object() as java.util.List<Object>)*.toString()");
//	}
//	
//	@Test public void testSpreadOperator_02() throws Exception {
//		assertEvaluatesTo(Lists.newArrayList(
//				"A", "B", "C"), "('abc'.toCharArray as Iterable<Character>)*.toString*.toUpperCase");
//	}
	
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
		assertEvaluatesTo(3, "switch new java.util.ArrayList<String>() { java.util.Set<String> : 5 java.util.List<Object>: 3 }");
	}
	
	@Test public void testSwitchExpression_12() throws Exception {
		assertEvaluatesTo("bar", "switch 'foo' { case 'bar' : return 'foo' default : 'bar' }");
	}
	
	@Test public void testSwitchExpression_13() throws Exception {
		assertEvaluatesTo("bar", "switch 'foo' { case 'bar' : 'foo' default : return 'bar' }");
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
		assertEvaluatesTo("finally", "{ var x = 'foo' try 'literal' finally x = 'finally' x }");
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
		assertEvaluatesTo(Lists.newArrayList("foo", "s1", "s2"), "new testdata.ClassWithVarArgs().stringsToList('s1', 's2')");
	}
	
	@Test public void testMethodVarArgs_04() throws Exception {
		assertEvaluatesTo(Lists.newArrayList("s1", "s2", "s3"), "new testdata.ClassWithVarArgs().stringsToList('s1', 's2', 's3')");
	}
	
	@Test public void testMethodVarArgs_05() throws Exception {
		assertEvaluatesTo(Collections.emptyList(), "{ var x = new testdata.ClassWithVarArgs() x.stringsToList() }");
	}
	
	@Test public void testMethodVarArgs_06() throws Exception {
		assertEvaluatesTo(Collections.singletonList("s1"), "{ var x = new testdata.ClassWithVarArgs() x.stringsToList('s1') }");
	}
	
	@Test public void testMethodVarArgs_07() throws Exception {
		assertEvaluatesTo(Lists.newArrayList("foo", "s1", "s2"), "{ var x = new testdata.ClassWithVarArgs() x.stringsToList('s1', 's2') }");
	}
	
	@Test public void testMethodVarArgs_08() throws Exception {
		assertEvaluatesTo(Lists.newArrayList("s1", "s2", "s3"), "{ var x = new testdata.ClassWithVarArgs() x.stringsToList('s1', 's2', 's3') }");
	}
	
	@Test public void testMethodVarArgs_09() throws Exception {
		assertEvaluatesTo(Lists.newArrayList("s1"), "{ var x = new testdata.ClassWithVarArgs() x.stringsToList2('s1') }");
	}
	@Test public void testMethodVarArgs_10() throws Exception {
		assertEvaluatesTo(Lists.newArrayList("s1", "s2"), "{ var x = new testdata.ClassWithVarArgs() x.stringsToList2('s1', 's2') }");
	}
	@Test public void testMethodVarArgs_11() throws Exception {
		assertEvaluatesTo(Lists.newArrayList("s1", "s2", "s3"), "{ var x = new testdata.ClassWithVarArgs() x.stringsToList2('s1', 's2', 's3') }");
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
		assertEvaluatesTo(Lists.newArrayList(2, 3, 2, 3, 4), "newArrayList('a','aa','b','aa','abc').map(s|s.length+1).toList()");
	}
	
	@Test public void testIterableExtension_05() throws Exception {
		assertEvaluatesTo(Integer.valueOf(2 + 3 + 2 + 3 + 4), "newArrayList('a','aa','b','aa','abc').map(s|s.length + 1).reduce(a,b|a+b)");
	}
	
	@Test public void testIterableExtension_06() throws Exception {
		assertEvaluatesTo(Integer.valueOf(5), "newArrayList('a','aa','b','aa','abc').map(s|s.length + 1).take(4).toSet().reduce(a,b|a+b)");
	}
	
	@Test public void testIterableExtension_07() throws Exception {
		assertEvaluatesTo(Lists.newArrayList("a", "b", "c"), "newArrayList('a','b', 'c', 'd', 'e').take(3).toList()");
	}
	
	@Test public void testIterableExtension_08() throws Exception {
		assertEvaluatesTo(Lists.newArrayList("d", "e"), "newArrayList('a', 'b', 'c', 'd', 'e').drop(3).toList()");
	}
	
	@Test public void testIterableExtension_09() throws Exception {
		assertEvaluatesTo(Boolean.TRUE, "(null as Iterable<String>).isNullOrEmpty()");
		assertEvaluatesTo(Boolean.TRUE, "newArrayList().isNullOrEmpty()");
		assertEvaluatesTo(Boolean.FALSE, "newHashSet('a').isNullOrEmpty()");
	}
	
	@Test public void testIterableExtension_10() throws Exception {
		assertEvaluatesTo("seed 12345", "newArrayList(1, 2, 3, 4, 5).fold('seed ', [s, i|s+i.toString])");
	}
	
	@Test public void testMapConstruction_00() throws Exception {
		assertEvaluatesTo("vier", "newHashMap(3->'drei',4->'vier').get(4)");
	}
	
	@Test public void testMapConstruction_01() throws Exception {
		assertEvaluatesTo("vier", "newHashMap(3->'drei',4->'vier').entrySet.findFirst(e|e.key==4).value");
	}
	
	@Test public void testStaticMethod_01() throws Exception {
		assertEvaluatesTo(Sets.newTreeSet(), "newTreeSet(String left, String right|left.compareTo(right))");
	}
	
	@Test public void testStaticMethod_02() throws Exception {
		assertEvaluatesTo(Sets.newHashSet("a"), "newTreeSet([left, right|left.compareTo(right)], 'a')");
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
		assertEvaluatesTo(Lists.newArrayList("a", "b", "c"), "{ var x = newArrayList() x.addAll('a', 'b', 'c') x }");
		assertEvaluatesTo(Boolean.FALSE, "newHashSet('a', 'b', 'c').addAll('a', 'b', 'c')");
	}
	
	@Test public void testListExtensions_01() throws Exception {
		assertEvaluatesTo(Lists.newArrayList("a", "b", "c"), "newArrayList('c', 'a', 'b').sortInplace()");
		assertEvaluatesTo(Lists.newArrayList("a", "b", "c"), "newArrayList('c', 'a', 'b').sort()");
		assertEvaluatesTo("b", "{ var l = newArrayList('c', 'a', 'b', 'd') l.sortInplace() l.get(1) }");
		assertEvaluatesTo("a", "{ var l = newArrayList('c', 'a', 'b', 'd') l.sort() l.get(1) }");
	}
	
	@Test public void testListExtensions_02() throws Exception {
		assertEvaluatesTo(Lists.newArrayList("a", "b", "c"), "newArrayList('c', 'a', 'b').sort(a,b|a.compareTo(b))");
		assertEvaluatesTo(Lists.newArrayList("a", "b", "c"), "newArrayList('c', 'a', 'b').sortInplace(a,b|a.compareTo(b))");
		assertEvaluatesTo(Lists.newArrayList("c", "b", "a"), "newArrayList('c', 'a', 'b').sort(a,b|b.compareTo(a))");
		assertEvaluatesTo(Lists.newArrayList("c", "b", "a"), "newArrayList('c', 'a', 'b').sortInplace(a,b|b.compareTo(a))");
		assertEvaluatesTo("a", "{ var l = newArrayList('c', 'a', 'b', 'd') l.sort(a,b|a.compareTo(b)) l.get(1) }");
		assertEvaluatesTo("b", "{ var l = newArrayList('c', 'a', 'b', 'd') l.sortInplace(a,b|a.compareTo(b)) l.get(1) }");
	}
	
	@Test public void testListExtensions_03() throws Exception {
		assertEvaluatesTo(Lists.newArrayList("aaa", "bb", "c"), "newArrayList('c', 'aaa', 'bb').sortBy(s|-s.length)");
		assertEvaluatesTo(Lists.newArrayList("aaa", "bb", "c"), "newArrayList('c', 'aaa', 'bb').sortInplaceBy(s|-s.length)");
		assertEvaluatesTo(Lists.newArrayList("c", "bb", "aaa"), "newArrayList('c', 'aaa', 'bb').sortBy(s|s.length)");
		assertEvaluatesTo(Lists.newArrayList("c", "bb", "aaa"), "newArrayList('c', 'aaa', 'bb').sortInplaceBy(s|s.length)");
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
	
	@Test public void testMemberCallOnMultiType_07() throws Exception {
		assertEvaluatesTo(Boolean.TRUE, "(if (false) new Double('-20') else new Integer('10')) >= 0");
	}
	
	@Test public void testMemberCallOnMultiType_08() throws Exception {
		assertEvaluatesTo(Boolean.FALSE, "(if (false) new Double('-20') else new Integer('10')) < 0");
	}
	
	@Test public void testBug343144_01() throws Exception {
		assertEvaluatesTo(Integer.valueOf(3), 
			"newArrayList('ab', 'abc').fold(0 as Integer, [max, s | Math::max(s.length, max)])");
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
		assertEvaluatesTo(Boolean.FALSE, "{\n" +
			"  val l = new java.util.ArrayList<String>()\n" + 
			"  new java.util.ArrayList<CharSequence>() += l\n" +
			"}");
	}
	
	protected void assertEvaluatesTo(Object object, String string) throws Exception {
		assertEquals(object, invokeXbaseExpression(string));
	}

	protected void assertEvaluatesWithException(Class<? extends Throwable> class1, String string) throws Exception {
		try {
			invokeXbaseExpression(string);
		} catch (InvocationTargetException e) {
			assertTrue(e.getClass().toString(), class1.isInstance(e.getCause()));
		}
	}
	
	protected Object invokeXbaseExpression(String expression) throws Exception {
		throw new UnsupportedOperationException("Override and implement me!");
	}
}
