/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.interpreter;

import java.util.Collections;
import java.util.Stack;

import com.google.inject.internal.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XbaseInterpreterTest extends AbstractXbaseInterpreterTest {

	public void testNull() {
		assertEvaluatesTo(null, "null");
	}
	
	public void testNullBlockResult_01() {
		assertEvaluatesTo(null, "{ null; }");
	}
	
	public void testNullBlockResult_02() {
		assertEvaluatesTo(null, "{ 'literal'; null; }");
	}
	
	public void testStringLiteral_01() {
		assertEvaluatesTo("", "''");
	}
	
	public void testStringLiteral_02() {
		assertEvaluatesTo("literal", "'literal'");
	}
	
	public void testBooleanLiteral_01() {
		assertEvaluatesTo(Boolean.TRUE, "true");
	}
	
	public void testBooleanLiteral_02() {
		assertEvaluatesTo(Boolean.FALSE, "false");
	}
	
	public void testIntLiteral_01() {
		assertEvaluatesTo(53, "53");
	}
	
	public void testIntLiteral_02() {
		assertEvaluatesTo(0, "0");
	}
	
	public void testTypeLiteral_01() {
		assertEvaluatesTo(Void.class, "java.lang.Void.class");
	}
	
	public void testTypeLiteral_02() {
		assertEvaluatesTo(Void.TYPE, "void.class");
	}
	
	public void testIfExpression_01() {
		assertEvaluatesTo(null, "if (false) 'literal'");
	}
	
	public void testIfExpression_02() {
		assertEvaluatesTo("literal", "if (true) 'literal'");
	}
	
	public void testIfExpression_03() {
		assertEvaluatesTo("then", "if (true) 'then' else 'else'");
	}
	
	public void testIfExpression_04() {
		assertEvaluatesTo("else", "if (false) 'then' else 'else'");
	}
	
	public void testVariableDeclaration_01() {
		assertEvaluatesTo("literal", "{val x = 'literal'}");
	}
	
	public void testFeatureCall_01() {
		assertEvaluatesTo("literal", "{var x = 'literal' x}");
	}
	
	public void testFeatureCall_02() {
		assertEvaluatesTo(Collections.singletonList(new Character('a')), "'a'.toCharArray");
	}
	
	public void testFeatureCall_03() {
		assertEvaluatesTo(Lists.newArrayList(
				new Character('a'), 
				new Character('b'),
				new Character('c')), "'abc'.toCharArray");
	}
	
	public void testAssignment_01() {
		assertEvaluatesTo("newValue", "{var x = 'literal' x = 'newValue'}");
	}
	
	public void testAssignmentInBlock_01() {
		assertEvaluatesTo("newValue", "{var x = 'literal' { x = 'newValue' } x }");
	}
	
	public void testForLoop_01() {
		assertEvaluatesTo(new Character('c'), 
				"{\n" +
				"  var java.lang.Character result = null\n" +
				"  for(x: 'abc'.toCharArray) result = x\n" +
				"  result" +
				"}");
	}
	
//	public void testForLoop_02() {
//		assertEvaluatesTo(new Character('b'), 
//				"{\n" +
//				"  var java.lang.Character result = null\n" +
//				"  for(x: 'aba'.toCharArray) if (result == null) result = x\n" +
//				"  result" +
//				"}");
//	}

	public void testWhileLoop_01() {
		assertEvaluatesTo("newValue", 
				"{\n" +
				"  var value = 'oldValue'\n" +
				"  var condition = true\n" +
				"  while(condition) { value = 'newValue' condition=false }" +
				"  value" +
				"}");
	}
	
	public void testWhileLoop_02() {
		assertEvaluatesTo("oldValue", 
				"{\n" +
				"  var value = 'oldValue'\n" +
				"  var condition = false\n" +
				"  while(condition) { value = 'newValue' condition=false }" +
				"  value" +
				"}");
	}
	
	public void testDoWhileLoop_01() {
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
	
	public void testDoWhileLoop_02() {
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
	
	public void testMemberFeatureCall_01() {
		assertEvaluatesTo("LITERAL", "'literal'.toUpperCase()");
	}
	
	public void testMemberFeatureCall_02() {
		assertEvaluatesTo("literal", "'literal'.toUpperCase().toLowerCase()");
	}
	
	public void testSwitchExpression_01() {
		assertEvaluatesTo(null, "switch true { case false: 'literal'; }");
	}
	
	public void testSwitchExpression_02() {
		assertEvaluatesTo("literal", "switch false { case false: 'literal'; }");
	}
	
	public void testSwitchExpression_03() {
		assertEvaluatesTo(Boolean.FALSE, "{ var this = true switch false { case true: this; } }");
	}
	
	public void testSwitchExpression_04() {
		assertEvaluatesTo(Boolean.TRUE, "{ var this = false switch true { case true: this; } }");
	}
	
	public void testSwitchExpression_05() {
		assertEvaluatesTo(null, "switch true { java.lang.String : 'literal'; }");
	}
	
	public void testSwitchExpression_06() {
		assertEvaluatesTo("literal", "switch true { java.lang.Boolean : 'literal'; }");
	}
	
	public void testSwitchExpression_07() {
		assertEvaluatesTo("literal", "switch true { case false: null; default: 'literal'; }");
	}
	
	public void testSwitchExpression_08() {
		assertEvaluatesTo("literal", "switch true { case false: null; case true: 'literal'; }");
	}
	
	public void testSwitchExpression_09() {
		assertEvaluatesTo(Integer.valueOf(4), "switch 'foo' { case 'foo': 4; java.lang.String: 3; }");
	}
	
	public void testSwitchExpression_10() {
		assertEvaluatesTo(Integer.valueOf(3), "switch 'foo' { java.lang.Boolean case 'foo': 4; java.lang.String: 3; }");
	}
	
	public void testCastedExpression_01() {
		assertEvaluatesTo("literal", "(java.lang.String) 'literal'");
	}
	
	public void testCastedExpression_02() {
		assertEvaluatesWithException(ClassCastException.class, "(java.lang.Integer) 'literal'");
	}
	
	public void testTryCatch_01() {
		assertEvaluatesTo("caught", "try { (java.lang.Boolean) 'literal' } catch(java.lang.ClassCastException e) {'caught'}");
	}
	
	public void testTryCatch_02() {
		assertEvaluatesTo("literal", "try { (java.lang.String) 'literal' } catch(java.lang.ClassCastException e) {'caught'}");
	}
	
	public void testTryCatch_03() {
		assertEvaluatesTo("ClassCastException", "try { (java.lang.Boolean) 'literal' } catch(java.lang.ClassCastException e) {e.getClass().getSimpleName()}");
	}
	
	public void testTryCatch_04() {
		assertEvaluatesWithException(NullPointerException.class, "try { (java.lang.Boolean) 'literal' } catch(java.lang.ClassCastException e) e == null");
	}
	
	public void testTryCatch_05() {
		assertEvaluatesWithException(NullPointerException.class, 
				"try (java.lang.Boolean) 'literal' " +
				"  catch(java.lang.ClassCastException e) e == null // throw new NullPointerException()" +
				"  catch(java.lang.NullPointerException e) 'dont catch subsequent exceptions'");
	}
	
	public void testTryFinally_01() {
		assertEvaluatesTo("literal", "try 'literal' finally 'finally'");
	}
	
	public void testTryFinally_02() {
		assertEvaluatesTo("finally", "{ var x = 'foo' try 'literal' finally x = 'finally' x }");
	}
	
	public void testConstructor_01() {
		assertEvaluatesTo(Boolean.TRUE, "new java.io.StringReader('literal').markSupported");
	}
	
	public void testConstructor_02() {
		assertEvaluatesTo(new Character('a'), "new java.lang.Character('abc'.charAt(0))");
	}
	
	public void testConstructor_03() {
		assertEvaluatesTo("source", "new java.util.EventObject('source').getSource");
	}
	
	public void testConstructor_04() {
		assertEvaluatesTo(new Stack<Object>(), "new java.util.Stack()");
	}
}
