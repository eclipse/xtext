/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.parser;

import org.eclipse.xtext.common.types.JvmLowerBound;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.xbase.XFunction;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xpression.XBinaryOperation;
import org.eclipse.xtext.xpression.XBlockExpression;
import org.eclipse.xtext.xpression.XBooleanLiteral;
import org.eclipse.xtext.xpression.XCasePart;
import org.eclipse.xtext.xpression.XCastedExpression;
import org.eclipse.xtext.xpression.XClosure;
import org.eclipse.xtext.xpression.XConstructorCall;
import org.eclipse.xtext.xpression.XFeatureCall;
import org.eclipse.xtext.xpression.XIfExpression;
import org.eclipse.xtext.xpression.XInstanceOfExpression;
import org.eclipse.xtext.xpression.XIntLiteral;
import org.eclipse.xtext.xpression.XRichString;
import org.eclipse.xtext.xpression.XRichStringLiteral;
import org.eclipse.xtext.xpression.XStringLiteral;
import org.eclipse.xtext.xpression.XSwitchExpression;
import org.eclipse.xtext.xpression.XTypeLiteral;
import org.eclipse.xtext.xpression.XUnaryOperation;
import org.eclipse.xtext.xpression.XVariableDeclaration;
import org.eclipse.xtext.xpression.XWhileExpression;
import org.eclipse.xtext.xtype.XFunctionTypeRef;

/**
 * @author Sven Efftinge
 *
 */
public class XbaseParserTest extends AbstractXbaseTestCase {

	public void testAddition_1() throws Exception {
		XBinaryOperation operation = (XBinaryOperation) expression("3 + 4");
		assertEquals(3, ((XIntLiteral) operation.getLeft()).getValue());
		assertEquals("+", operation.getOperator());
		assertEquals(4, ((XIntLiteral) operation.getRight()).getValue());
	}

	public void testAddition_2() throws Exception {
		XBinaryOperation operation = (XBinaryOperation) expression("foo + 'bar'");
		assertEquals("foo", ((XFeatureCall) operation.getLeft()).getName());
		assertEquals("+", operation.getOperator());
		assertEquals("bar", ((XStringLiteral) operation.getRight()).getValue());
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
		assertNull(closure.getParams().get(0).getType());
	}

	public void testClosure_3() throws Exception {
		XClosure closure = (XClosure) expression("String bar|'foo'");
		assertEquals("foo", ((XStringLiteral) closure.getExpression())
				.getValue());
		assertEquals("bar", closure.getParams().get(0).getName());
		assertEquals(1, closure.getParams().size());
		assertNotNull(closure.getParams().get(0).getType());
	}

	public void testClosure_4() throws Exception {
		XClosure closure = (XClosure) expression("foo, String bar|'foo'");
		assertEquals("foo", ((XStringLiteral) closure.getExpression())
				.getValue());
		assertEquals("foo", closure.getParams().get(0).getName());
		assertEquals("bar", closure.getParams().get(1).getName());
		assertEquals(2, closure.getParams().size());
		assertNull(closure.getParams().get(0).getType());
		assertNotNull(closure.getParams().get(1).getType());
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
		assertTrue(call.getTarget() instanceof XFeatureCall);
	}

	public void testFeatureCall_2() throws Exception {
		XFeatureCall call = (XFeatureCall) expression("'holla'.bar()");
		assertNotNull(call);
		assertEquals(0, call.getParams().size());
		assertTrue(call.getTarget() instanceof XStringLiteral);
	}

	public void testFeatureCall_3() throws Exception {
		XFeatureCall call = (XFeatureCall) expression("'holla'.bar(4)");
		assertNotNull(call);
		assertEquals(1, call.getParams().size());
		assertEquals(4, ((XIntLiteral) call.getParams().get(0)).getValue());
		assertTrue(call.getTarget() instanceof XStringLiteral);
	}

	public void testFeatureCall_4() throws Exception {
		XFeatureCall call = (XFeatureCall) expression("bar(0,1,2)");
		assertNotNull(call);
		assertEquals(3, call.getParams().size());
		for (int i = 0; i < 3; i++)
			assertEquals(i, ((XIntLiteral) call.getParams().get(i)).getValue());
		assertNull(call.getTarget());
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
		XBlockExpression be = (XBlockExpression) expression("{def foo = bar;bar;}");
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
		XBlockExpression be = (XBlockExpression) expression("{MyType foo = bar;bar;}");
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
		assertNull(cc.getInitializer());
		assertEquals(0, cc.getParams().size());
	}

	public void testConstructorCall_1() throws Exception {
		XConstructorCall cc = (XConstructorCall) expression("new Foo(0,1,2)");
		assertNotNull(cc.getType());
		assertNull(cc.getInitializer());
		assertEquals(3, cc.getParams().size());
		for (int i = 0; i < 3; i++)
			assertEquals(i, ((XIntLiteral) cc.getParams().get(i)).getValue());
	}

	public void testConstructorCall_2() throws Exception {
		XConstructorCall cc = (XConstructorCall) expression("new Foo(0,1,2) { this.foo = bar;}");
		assertNotNull(cc.getType());
		assertNotNull(cc.getInitializer());
		assertEquals(3, cc.getParams().size());
		for (int i = 0; i < 3; i++)
			assertEquals(i, ((XIntLiteral) cc.getParams().get(i)).getValue());
	}

	public void testRichString() throws Exception {
		XRichString rs = (XRichString) expression("\u00BBHallo \u00ABfoo\u00BB Welt!\u00AB");
		assertEquals(3, rs.getExpressions().size());
		assertTrue(rs.getExpressions().get(0) instanceof XRichStringLiteral);
		assertTrue(rs.getExpressions().get(1) instanceof XFeatureCall);
		assertTrue(rs.getExpressions().get(2) instanceof XRichStringLiteral);
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

	public void testFunction_0() throws Exception {
		XFunction func = function("foo() : bar;");
		assertEquals("foo", func.getName());
		assertTrue(func.getExpression() instanceof XFeatureCall);
		assertEquals(0, func.getDeclaredParams().size());
		assertNull(func.getReturnType());
		assertEquals(0, func.getTypeParams().size());
	}

	public void testFunction_1() throws Exception {
		XFunction func = function("String foo() : bar;");
		assertEquals("foo", func.getName());
		assertTrue(func.getExpression() instanceof XFeatureCall);
		assertEquals(0, func.getDeclaredParams().size());
		assertNotNull(func.getReturnType());
		assertEquals(0, func.getTypeParams().size());
	}

	public void testFunction_2() throws Exception {
		XFunction func = function("foo(String s) : bar;");
		assertEquals("foo", func.getName());
		assertTrue(func.getExpression() instanceof XFeatureCall);
		assertEquals(1, func.getDeclaredParams().size());
		assertEquals("s", func.getDeclaredParams().get(0).getName());
		assertNotNull(func.getDeclaredParams().get(0).getType());
		assertNull(func.getReturnType());
		assertEquals(0, func.getTypeParams().size());
	}

	public void testFunction_3() throws Exception {
		XFunction func = function("foo(String s, Integer i) : bar;");
		assertEquals("foo", func.getName());
		assertTrue(func.getExpression() instanceof XFeatureCall);
		assertEquals(2, func.getDeclaredParams().size());
		assertEquals("s", func.getDeclaredParams().get(0).getName());
		assertNotNull(func.getDeclaredParams().get(0).getType());
		assertEquals("i", func.getDeclaredParams().get(1).getName());
		assertNotNull(func.getDeclaredParams().get(1).getType());
		assertNull(func.getReturnType());
		assertEquals(0, func.getTypeParams().size());
	}

	public void testFunction_4() throws Exception {
		XFunction func = function("private foo() : bar;");
		assertEquals("foo", func.getName());
		assertTrue(func.getExpression() instanceof XFeatureCall);
		assertEquals(0, func.getDeclaredParams().size());
		assertNull(func.getReturnType());
		assertTrue(func.isPrivate());
		assertEquals(0, func.getTypeParams().size());
	}


	public void testTypeParams_1() throws Exception {
		XFunction func = function("<T> foo(T t) : bar;");
		assertEquals(1, func.getTypeParams().size());
		JvmTypeParameter tp = func.getTypeParams().get(0);
		assertEquals("T", tp.getName());
		assertEquals(0, tp.getConstraints().size());
	}

	public void testTypeParams_2() throws Exception {
		XFunction func = function("<T extends Bar> foo(T t) : bar;");
		assertEquals(1, func.getTypeParams().size());
		JvmTypeParameter tp = func.getTypeParams().get(0);
		assertEquals("T", tp.getName());
		assertEquals(1, tp.getConstraints().size());
		assertTrue(tp.getConstraints().get(0) instanceof JvmUpperBound);
	}

	public void testTypeParams_3() throws Exception {
		XFunction func = function("<T extends Foo & Bar> foo(T t) : bar;");
		assertEquals(1, func.getTypeParams().size());
		JvmTypeParameter tp = func.getTypeParams().get(0);
		assertEquals("T", tp.getName());
		assertEquals(2, tp.getConstraints().size());
		for (JvmTypeConstraint constraint : tp.getConstraints()) {
			assertTrue(constraint instanceof JvmUpperBound);
		}
	}

	public void testTypeParams_4() throws Exception {
		XFunction func = function("<T super Foo> foo(T t) : bar;");
		assertEquals(1, func.getTypeParams().size());
		JvmTypeParameter tp = func.getTypeParams().get(0);
		assertEquals("T", tp.getName());
		assertEquals(1, tp.getConstraints().size());
		assertTrue(tp.getConstraints().get(0) instanceof JvmLowerBound);
	}
	
	public void testFunctionTypeRef_0() throws Exception {
		XFunction func = function("=>Boolean foo() : |true;");
		XFunctionTypeRef type = (XFunctionTypeRef) func.getReturnType();
		assertNotNull(type.getReturnType());
		assertEquals(0,type.getParamTypes().size());
	}
	
	public void testFunctionTypeRef_1() throws Exception {
		XFunction func = function("(String)=>Boolean foo() : String s|s==null;");
		XFunctionTypeRef type = (XFunctionTypeRef) func.getReturnType();
		assertNotNull(type.getReturnType());
		assertEquals(1,type.getParamTypes().size());
		assertNotNull(type.getParamTypes().get(0));
	}
}
