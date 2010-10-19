/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.interpreter;

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
}
