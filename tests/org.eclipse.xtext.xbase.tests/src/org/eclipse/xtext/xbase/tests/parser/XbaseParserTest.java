/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.parser;

import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XInstanceOfExpression;
import org.eclipse.xtext.xbase.XIntLiteral;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.XUnaryOperation;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XWhileExpression;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;

/**
 * @author Sven Efftinge
 *
 */
public class XbaseParserTest extends AbstractXbaseTestCase {
	
	public void testAssignment_RightAssociativity() throws Exception {
		XBinaryOperation ass = (XBinaryOperation) expression("foo = bar += baz");
		assertEquals(2,ass.getParams().size());
		assertEquals("=", ass.getFeatureName());
		assertEquals("foo", ((XFeatureCall)ass.getParams().get(0)).getFeatureName());
		ass = (XBinaryOperation) ass.getParams().get(1);
		assertEquals(2,ass.getParams().size());
		assertEquals("+=", ass.getFeatureName());
		assertEquals("bar", ((XFeatureCall)ass.getParams().get(0)).getFeatureName());
		assertEquals("baz", ((XFeatureCall)ass.getParams().get(1)).getFeatureName());
	}
	
	public void testOrAndAndPrecedence() throws Exception {
		XBinaryOperation or = (XBinaryOperation) expression("foo && bar || baz");
		assertEquals(2,or.getParams().size());
		assertEquals("||", or.getFeatureName());
		assertEquals("baz", ((XFeatureCall)or.getParams().get(1)).getFeatureName());
		XBinaryOperation and = (XBinaryOperation) or.getParams().get(0);
		assertEquals(2,and.getParams().size());
		assertEquals("&&", and.getFeatureName());
		assertEquals("foo", ((XFeatureCall)and.getParams().get(0)).getFeatureName());
		assertEquals("bar", ((XFeatureCall)and.getParams().get(1)).getFeatureName());
	}

	public void testAddition_1() throws Exception {
		XBinaryOperation operation = (XBinaryOperation) expression("3 + 4");
		assertEquals(3, ((XIntLiteral) operation.getParams().get(0)).getValue());
		assertEquals(4, ((XIntLiteral) operation.getParams().get(1)).getValue());
	}

	public void testAddition_2() throws Exception {
		XBinaryOperation operation = (XBinaryOperation) expression("foo + 'bar'");
		assertEquals("foo", ((XFeatureCall) operation.getParams().get(0)).getFeatureName());
		assertEquals("bar", ((XStringLiteral) operation.getParams().get(1)).getValue());
	}

	public void testStringLiteral() throws Exception {
		XStringLiteral literal = (XStringLiteral) expression("'bar'");
		assertEquals("bar", literal.getValue());
	}

	public void testBooleanLiteral() throws Exception {
		XBooleanLiteral literal = (XBooleanLiteral) expression("true");
		assertTrue(literal.isIsTrue());
		literal = (XBooleanLiteral) expression("false");
		assertFalse(literal.isIsTrue());
	}

	public void testClosure_1() throws Exception {
		XClosure closure = (XClosure) expression("|'foo'");
		assertEquals("foo", ((XStringLiteral) closure.getExpression())
				.getValue());
	}

	public void testClosure_2() throws Exception {
		XClosure closure = (XClosure) expression("bar|'foo'");
		assertEquals("foo", ((XStringLiteral) closure.getExpression())
				.getValue());
		assertEquals("bar", closure.getParams().get(0).getName());
		assertNull(closure.getParams().get(0).getParameterType());
	}

	public void testClosure_3() throws Exception {
		XClosure closure = (XClosure) expression("String bar|'foo'");
		assertEquals("foo", ((XStringLiteral) closure.getExpression())
				.getValue());
		assertEquals("bar", closure.getParams().get(0).getName());
		assertEquals(1, closure.getParams().size());
		assertNotNull(closure.getParams().get(0).getParameterType());
	}

	public void testClosure_4() throws Exception {
		XClosure closure = (XClosure) expression("foo, String bar|'foo'");
		assertEquals("foo", ((XStringLiteral) closure.getExpression())
				.getValue());
		assertEquals("foo", closure.getParams().get(0).getName());
		assertEquals("bar", closure.getParams().get(1).getName());
		assertEquals(2, closure.getParams().size());
		assertNull(closure.getParams().get(0).getParameterType());
		assertNotNull(closure.getParams().get(1).getParameterType());
	}

	public void testCastedExpression() throws Exception {
		XCastedExpression cast = (XCastedExpression) expression("(Foo)bar");
		assertTrue(cast.getTarget() instanceof XFeatureCall);
		assertNotNull(cast.getType());
	}

	public void testCastedExpression_1() throws Exception {
		XFeatureCall call = (XFeatureCall) expression("(Foo)");
		assertNotNull(call);
	}

	public void testUnaryOperation() throws Exception {
		XUnaryOperation call = (XUnaryOperation) expression("-(Foo)");
		assertNotNull(call);
	}

	public void testFeatureCall_0() throws Exception {
		XFeatureCall call = (XFeatureCall) expression("foo");
		assertNotNull(call);
	}

	public void testFeatureCall_1() throws Exception {
		XFeatureCall call = (XFeatureCall) expression("foo.bar");
		assertNotNull(call);
		assertTrue(call.getParams().get(0) instanceof XFeatureCall);
	}

	public void testFeatureCall_2() throws Exception {
		XFeatureCall call = (XFeatureCall) expression("'holla'.bar()");
		assertNotNull(call);
		assertEquals(1, call.getParams().size());
		assertTrue(call.getParams().get(0) instanceof XStringLiteral);
	}

	public void testFeatureCall_3() throws Exception {
		XFeatureCall call = (XFeatureCall) expression("'holla'.bar(4)");
		assertNotNull(call);
		assertEquals(2, call.getParams().size());
		assertEquals(4, ((XIntLiteral) call.getParams().get(1)).getValue());
		assertTrue(call.getParams().get(0) instanceof XStringLiteral);
	}

	public void testFeatureCall_4() throws Exception {
		XFeatureCall call = (XFeatureCall) expression("bar(0,1,2)");
		assertNotNull(call);
		assertEquals(3, call.getParams().size());
		for (int i = 0; i < 3; i++)
			assertEquals(i, ((XIntLiteral) call.getParams().get(i)).getValue());
	}

	public void testIf_0() throws Exception {
		XIfExpression ie = (XIfExpression) expression("if (true) false");
		assertTrue(((XBooleanLiteral) ie.getIf()).isIsTrue());
		assertFalse(((XBooleanLiteral) ie.getThen()).isIsTrue());
		assertNull(ie.getElse());
	}

	public void testIf_1() throws Exception {
		XIfExpression ie = (XIfExpression) expression("if (true) false else bar");
		assertTrue(((XBooleanLiteral) ie.getIf()).isIsTrue());
		assertFalse(((XBooleanLiteral) ie.getThen()).isIsTrue());
		assertTrue(ie.getElse() instanceof XFeatureCall);
	}

	public void testSwitch_0() throws Exception {
		XSwitchExpression se = (XSwitchExpression) expression("switch { case 1==0 : '1' }");
		assertNull(se.getDefault());
		assertEquals(1, se.getCases().size());
		assertNull(se.getSwitch());
		XCasePart casePart = se.getCases().get(0);
		assertTrue(casePart.getCase() instanceof XBinaryOperation);
		assertTrue(casePart.getThen() instanceof XStringLiteral);
	}

	public void testSwitch_1() throws Exception {
		XSwitchExpression se = (XSwitchExpression) expression("switch number{case 1:'1'case 2:'2'default:'3'}");
		assertTrue(se.getDefault() instanceof XStringLiteral);
		assertEquals(2, se.getCases().size());
		assertTrue(se.getSwitch() instanceof XFeatureCall);

		XCasePart case1 = se.getCases().get(0);
		assertEquals(1, ((XIntLiteral) case1.getCase()).getValue());
		assertTrue(case1.getThen() instanceof XStringLiteral);

		XCasePart case2 = se.getCases().get(1);
		assertEquals(2, ((XIntLiteral) case2.getCase()).getValue());
		assertTrue(case2.getThen() instanceof XStringLiteral);
	}

	public void testBlockExpression_0() throws Exception {
		XBlockExpression be = (XBlockExpression) expression("{foo;}");
		assertEquals(1, be.getExpressions().size());
		assertTrue(be.getExpressions().get(0) instanceof XFeatureCall);
	}

	public void testBlockExpression_1() throws Exception {
		XBlockExpression be = (XBlockExpression) expression("{foo;bar;}");
		assertEquals(2, be.getExpressions().size());
		assertTrue(be.getExpressions().get(0) instanceof XFeatureCall);
		assertTrue(be.getExpressions().get(1) instanceof XFeatureCall);
	}

	public void testBlockExpression_withVariableDeclaration_0()
			throws Exception {
		XBlockExpression be = (XBlockExpression) expression("{val foo = bar;bar;}");
		assertEquals(2, be.getExpressions().size());
		XVariableDeclaration vd = (XVariableDeclaration) be.getExpressions().get(
				0);
		assertEquals("foo", vd.getName());
		assertTrue(vd.getRight() instanceof XFeatureCall);
		assertNull(vd.getType());
		assertTrue(be.getExpressions().get(1) instanceof XFeatureCall);
	}

	public void testBlockExpression_withVariableDeclaration_1()
			throws Exception {
		XBlockExpression be = (XBlockExpression) expression("{var MyType foo = bar;bar;}");
		assertEquals(2, be.getExpressions().size());
		XVariableDeclaration vd = (XVariableDeclaration) be.getExpressions().get(
				0);
		assertEquals("foo", vd.getName());
		assertTrue(vd.getRight() instanceof XFeatureCall);
		assertNotNull(vd.getType());
		assertTrue(be.getExpressions().get(1) instanceof XFeatureCall);
	}

	public void testConstructorCall_0() throws Exception {
		XConstructorCall cc = (XConstructorCall) expression("new Foo");
		assertNotNull(cc.getType());
		assertEquals(0, cc.getParams().size());
	}

	public void testConstructorCall_1() throws Exception {
		XConstructorCall cc = (XConstructorCall) expression("new Foo(0,1,2)");
		assertNotNull(cc.getType());
		assertEquals(3, cc.getParams().size());
		for (int i = 0; i < 3; i++)
			assertEquals(i, ((XIntLiteral) cc.getParams().get(i)).getValue());
	}

	public void testConstructorCall_2() throws Exception {
		XConstructorCall cc = (XConstructorCall) expression("new Foo<String>(0,1,2)");
		assertNotNull(cc.getType());
		assertEquals(3, cc.getParams().size());
		for (int i = 0; i < 3; i++)
			assertEquals(i, ((XIntLiteral) cc.getParams().get(i)).getValue());
	}

	public void testWhileExpression() throws Exception {
		XWhileExpression expression = (XWhileExpression) expression("while (true) 'foo'");
		assertTrue(expression.getPredicate() instanceof XBooleanLiteral);
		assertTrue(expression.getBody() instanceof XStringLiteral);
	}
	
	public void testTypeLiteral() throws Exception {
		XTypeLiteral expression = (XTypeLiteral) expression("java.lang.String.class");
		assertEquals("java.lang.String",expression.getType().getCanonicalName());
	}
	
	public void testInstanceOf() throws Exception {
		XInstanceOfExpression expression = (XInstanceOfExpression) expression("true instanceof java.lang.Boolean");
		assertEquals("java.lang.Boolean",expression.getType().getCanonicalName());
		assertTrue(expression.getExpression() instanceof XBooleanLiteral);
	}

}
