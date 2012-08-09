/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typing;

import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XDoWhileExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XWhileExpression;
import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.typing.ITypeProvider;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XbaseExpectedTypeProviderTest extends AbstractXbaseTestCase {

	@Test public void testAssignment() throws Exception {
		XAssignment assi = (XAssignment) ((XBlockExpression) expression("{ " + "  var  x = 'hello'" + "  x = null"
				+ "}")).getExpressions().get(1);
		assertExpected("java.lang.String", assi.getValue());
	}

	@Test public void testMemberFeatureCall() throws Exception {
		XMemberFeatureCall fc = (XMemberFeatureCall) expression("'foo'.charAt(null)");
		assertExpected("int", fc.getMemberCallArguments().get(0));
		assertExpected("java.lang.String", fc.getMemberCallTarget());
	}

	@Test public void testBinaryOperationCall_01() throws Exception {
		XBinaryOperation fc = (XBinaryOperation) expression("new java.util.ArrayList<String>() += ''");
		assertExpected("java.lang.String", fc.getRightOperand());
	}
	
	@Test public void testBinaryOperationCall_02() throws Exception {
		XBinaryOperation fc = (XBinaryOperation) expression("new java.util.ArrayList<CharSequence>() += emptyList()");
		assertExpected("java.lang.Iterable<? extends java.lang.CharSequence>", fc.getRightOperand());
	}
	
	@Test public void testLowerBoundIsNotVoid() throws Exception {
		XMemberFeatureCall fc = (XMemberFeatureCall) expression("new foo.ClassWithGenericMethod().genericMethod(return null)");
		assertExpected("T", fc.getExplicitArguments().get(1));
	}
	
	@Test public void testTypeParamInference_01_a() throws Exception {
		XMemberFeatureCall fc = (XMemberFeatureCall) expression("new testdata.ClosureClient().invoke1([e|e],'foo')");
		final XExpression closure = fc.getMemberCallArguments().get(0);
		assertExpected(Functions.class.getCanonicalName()+"$Function1<java.lang.String, java.lang.String>", closure);
	}
	
	@Test public void testTypeParamInference_01_b() throws Exception {
		XMemberFeatureCall fc = (XMemberFeatureCall) expression("new testdata.ClosureClient().invoke1WithExtends([e|e],'foo')");
		final XExpression closure = fc.getMemberCallArguments().get(0);
		assertExpected(Functions.class.getCanonicalName()+"$Function1<java.lang.String, ? extends java.lang.String>", closure);
	}
	
	@Test public void testTypeParamInference_01_c() throws Exception {
		XMemberFeatureCall fc = (XMemberFeatureCall) expression("new testdata.ClosureClient().invoke1WithSuper([e|e],'foo')");
		final XExpression closure = fc.getMemberCallArguments().get(0);
		assertExpected(Functions.class.getCanonicalName()+"$Function1<? extends java.lang.Object & super java.lang.String, java.lang.String>", closure);
	}
	
	@Test public void testTypeParamInference_01_d() throws Exception {
		XMemberFeatureCall fc = (XMemberFeatureCall) expression("new testdata.ClosureClient().invoke1WithSuperAndExtends([e|e],'foo')");
		final XExpression closure = fc.getMemberCallArguments().get(0);
		assertExpected(Functions.class.getCanonicalName()+"$Function1<? extends java.lang.Object & super java.lang.String, ? extends java.lang.String>", closure);
	}
	
	@Test public void testTypeParamInference_02() throws Exception {
		XMemberFeatureCall fc = (XMemberFeatureCall) expression("new testdata.ClosureClient().invoke1([e|e.length],'foo')");
		final XExpression closure = fc.getMemberCallArguments().get(0);
		assertExpected(Functions.class.getCanonicalName()+"$Function1<java.lang.String, java.lang.Integer>", closure);
	}
	
	@Test public void testTypeParamInference_03() throws Exception {
		XMemberFeatureCall fc = (XMemberFeatureCall) expression("new testdata.ClosureClient().invoke1([e|null],'foo')");
		final XExpression closure = fc.getMemberCallArguments().get(0);
//		assertExpected(Functions.class.getCanonicalName()+"$Function1<java.lang.String,null>", closure);
		assertExpected(Functions.class.getCanonicalName()+"$Function1<java.lang.String, T>", closure);
	}
	
	@Test public void testTypeParamInference_04() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ var Integer i = new testdata.ClosureClient().invoke1([e|null],'foo') }");
		XVariableDeclaration var = (XVariableDeclaration) block.getExpressions().get(0);
		XMemberFeatureCall fc = (XMemberFeatureCall) var.getRight();
		final XExpression closure = fc.getMemberCallArguments().get(0);
		assertExpected(Functions.class.getCanonicalName()+"$Function1<java.lang.String, java.lang.Integer>", closure);
	}
	
	@Test public void testTypeParamInference_05() throws Exception {
		XMemberFeatureCall fc = (XMemberFeatureCall) expression("new testdata.ClosureClient().<CharSequence, Number>invoke1([e|null],'foo')");
		final XExpression closure = fc.getMemberCallArguments().get(0);
		assertExpected(Functions.class.getCanonicalName()+"$Function1<java.lang.CharSequence, java.lang.Number>", closure);
	}
	
	@Test public void testTypeParamInference_06() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ var this = new testdata.ClosureClient() invoke1([e|e],'foo') }");
		XFeatureCall fc = (XFeatureCall) block.getExpressions().get(1);
		final XExpression closure = fc.getFeatureCallArguments().get(0);
		assertExpected(Functions.class.getCanonicalName()+"$Function1<java.lang.String, java.lang.String>", closure);
	}
	
	@Test public void testTypeParamInference_07() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ var this = new testdata.ClosureClient() invoke1([e|e.length],'foo') }");
		XFeatureCall fc = (XFeatureCall) block.getExpressions().get(1);
		final XExpression closure = fc.getFeatureCallArguments().get(0);
		assertExpected(Functions.class.getCanonicalName()+"$Function1<java.lang.String, java.lang.Integer>", closure);
	}
	
	@Test public void testTypeParamInference_08() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ var this = new testdata.ClosureClient() invoke1([e|null],'foo') }");
		XFeatureCall fc = (XFeatureCall) block.getExpressions().get(1);
		final XExpression closure = fc.getFeatureCallArguments().get(0);
		assertExpected(Functions.class.getCanonicalName()+"$Function1<java.lang.String, T>", closure);
//		assertExpected(Functions.class.getCanonicalName()+"$Function1<java.lang.String,null>", closure);
	}
	
	@Test public void testTypeParamInference_09() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ var this = new testdata.ClosureClient() var Integer i = invoke1([e|null],'foo') }");
		XVariableDeclaration var = (XVariableDeclaration) block.getExpressions().get(1);
		XFeatureCall fc = (XFeatureCall) var.getRight();
		final XExpression closure = fc.getFeatureCallArguments().get(0);
		assertExpected(Functions.class.getCanonicalName()+"$Function1<java.lang.String, java.lang.Integer>", closure);
	}
	
	@Test public void testTypeParamInference_10() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ var this = new testdata.ClosureClient(); <CharSequence, Number>invoke1([e|null],'foo') }");
		XFeatureCall fc = (XFeatureCall) block.getExpressions().get(1);
		final XExpression closure = fc.getFeatureCallArguments().get(0);
		assertExpected(Functions.class.getCanonicalName()+"$Function1<java.lang.CharSequence, java.lang.Number>", closure);
	}
	
	@Test public void testVariableDeclaration_0() throws Exception {
		XVariableDeclaration decl = (XVariableDeclaration) ((XBlockExpression) expression("{ " + "  var  x = 'hello'"
				+ "  null" + "}")).getExpressions().get(0);
		assertExpected(null, decl.getRight());
	}

	@Test public void testVariableDeclaration_1() throws Exception {
		XVariableDeclaration decl = (XVariableDeclaration) ((XBlockExpression) expression("{ "
				+ "  var  java.lang.String x = null" + "  null" + "}")).getExpressions().get(0);
		assertExpected("java.lang.String", decl.getRight());
	}

	@Test public void testConstructorCall_00() throws Exception {
		XConstructorCall decl = (XConstructorCall) expression("new java.lang.String('foo')");
		assertExpected("java.lang.String", decl.getArguments().get(0));
	}
	
	@Test public void testConstructorCall_01() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ var java.util.List<String> list = new java.util.ArrayList() }");
		XVariableDeclaration variableDeclaration = (XVariableDeclaration) block.getExpressions().get(0);
		XConstructorCall constructorCall = (XConstructorCall) variableDeclaration.getRight();
		assertExpected("java.util.List<java.lang.String>", constructorCall);
	}

	@Test public void testBlockExpression() throws Exception {
		XBlockExpression target = (XBlockExpression) expressionWithExpectedType("{ true.toString false.toString null }", "Boolean");
		assertExpected(null, target.getExpressions().get(0));
		assertExpected(null, target.getExpressions().get(1));
		assertExpected("java.lang.Boolean", target.getExpressions().get(2));
	}

	@Test public void testIfExpression() throws Exception {
		XIfExpression target = (XIfExpression) expressionWithExpectedType("if (null) null else null", "String");

		assertExpected("boolean", target.getIf()); // if (null) is invalid thus we expect the primitive boolean
		assertExpected("java.lang.String", target.getThen());
		assertExpected("java.lang.String", target.getElse());
	}

	@Test public void testForLoopExpression_0() throws Exception {
		XForLoopExpression loop = (XForLoopExpression) expression("for (java.lang.String x : null) null");

		assertExpected(null, loop.getForExpression());
		assertExpected(null, loop.getEachExpression());
	}

	@Test public void testForLoopExpression_1() throws Exception {
		XForLoopExpression loop = (XForLoopExpression) expression("for (x : null) null");
		assertExpected(null, loop.getForExpression());
		assertExpected(null, loop.getEachExpression());
	}

	@Test public void testWhileExpression_0() throws Exception {
		XWhileExpression exp = (XWhileExpression) expression("while (null) null");

		assertExpected("boolean", exp.getPredicate()); // while (null) is invalid thus we expect the primitive boolean
		assertExpected(null, exp.getBody());
	}

	@Test public void testWhileExpression_1() throws Exception {
		XDoWhileExpression exp = (XDoWhileExpression) expression("do null while (null)");

		assertExpected("boolean", exp.getPredicate()); // while (null) is invalid thus we expect the primitive boolean
		assertExpected(null, exp.getBody());
	}

	@Test public void testTryCatchExpression() throws Exception {
		XTryCatchFinallyExpression exp = (XTryCatchFinallyExpression)  
				expressionWithExpectedType("try null catch (java.lang.Throwable t) null finally null", "String");

		assertExpected("java.lang.String", exp.getExpression());
		for (XCatchClause cc : exp.getCatchClauses()) {
			assertExpected("java.lang.String", cc.getExpression());
		}
		assertExpected(null, exp.getFinallyExpression());
	}
	
	@Test public void testThrowExpression() throws Exception {
		XThrowExpression exp = (XThrowExpression) expression("throw null");
		assertExpected("java.lang.Throwable", exp.getExpression());
	}
	
	@Test public void testSwitchExpression_0() throws Exception {
		XSwitchExpression exp = (XSwitchExpression) expressionWithExpectedType(
				"switch null {" +
				"  java.lang.Boolean case null : null" +
				"  default : null" +
				"}", "String");
		assertExpected(null,exp.getSwitch());
		for (XCasePart cp : exp.getCases()) {
			assertExpected(null, cp.getCase());
			assertExpected("java.lang.String", cp.getThen());
		}
		assertExpected("java.lang.String", exp.getDefault());
	}
	
	@Test public void testSwitchExpression_1() throws Exception {
		XSwitchExpression exp = (XSwitchExpression) expressionWithExpectedType(
				"switch true {" +
				"  java.lang.Boolean case null : null" +
				"  default : null" +
				"}", "String");
		for (XCasePart cp : exp.getCases()) {
			assertExpected(null, cp.getCase());
			assertExpected("java.lang.String", cp.getThen());
		}
		assertExpected("java.lang.String", exp.getDefault());
	}
	
	@Test public void testCastedExpression() throws Exception {
		XCastedExpression expression = (XCastedExpression) expression("null as String");
		assertExpected(null, expression.getTarget());
	}

	protected void assertExpected(String expectedExpectedType, XExpression obj) {
		JvmTypeReference reference = get(ITypeProvider.class).getExpectedType(obj);
		if (reference == null)
			assertNull("expected " + expectedExpectedType + " for " + obj + " but was null", expectedExpectedType);
		else
			assertEquals("expression yielded unexpected type: " + obj, expectedExpectedType, reference.getIdentifier());
	}
	
	protected XExpression expressionWithExpectedType(String expression, String expectedType) throws Exception {
		XBlockExpression blockExpression = (XBlockExpression) expression("{ var " + expectedType + " foo = " + expression + " }");
		XVariableDeclaration variableDeclaration = (XVariableDeclaration) blockExpression.getExpressions().get(0);
		return variableDeclaration.getRight();
	}
}
