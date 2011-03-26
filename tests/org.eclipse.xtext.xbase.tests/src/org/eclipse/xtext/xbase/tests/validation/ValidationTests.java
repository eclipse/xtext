/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.validation;

import static org.eclipse.xtext.xbase.XbasePackage.Literals.*;
import static org.eclipse.xtext.xbase.validation.IssueCodes.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.junit.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ValidationTests extends AbstractXbaseTestCase {

	@Inject
	protected ValidationTestHelper helper;

	public void testFinalCast() throws Exception {
		XExpression expression = expression("'foo' as Cloneable");
		helper.assertError(expression, XCASTED_EXPRESSION, INVALID_CAST, "sealed");
		expression = expression("'foo' as CharSequence");
		helper.assertNoError(expression, INVALID_CAST);
	}
	
	public void testClosureWithModeThanSixParams() throws Exception {
		XExpression expression = expression("[int a1,int a2,int a3,int a4,int a5,int a6,int a7|null]");
		helper.assertError(expression, XCLOSURE, TOO_MANY_PARAMS_IN_CLOSURE);
		expression = expression("[int a1,int a2,int a3,int a4,int a5,int a6|null]");
		helper.assertNoError(expression, TOO_MANY_PARAMS_IN_CLOSURE);
	}

	public void testStringLiteralInBlock() throws Exception {
		checkInnerExpressionInBlock("'foo'", XSTRING_LITERAL);
	}

	public void testNullLiteralInBlock() throws Exception {
		checkInnerExpressionInBlock("null", XNULL_LITERAL);
	}

	public void testBooleanLiteralInBlock() throws Exception {
		checkInnerExpressionInBlock("true", XBOOLEAN_LITERAL);
	}

	public void testTypeLiteralInBlock() throws Exception {
		checkInnerExpressionInBlock("typeof (String)", XTYPE_LITERAL);
	}

	public void testClosureInBlock() throws Exception {
		checkInnerExpressionInBlock("[a|a]", XCLOSURE);
	}

	public void testThrowsInBlock_01() throws Exception {
		XExpression block = expression("{ throw new Exception() }");
		helper.assertNoErrors(block);
	}
	
	public void testThrowsInBlock_02() throws Exception {
		XExpression block = expression("{ throw new Exception() new Object()}");
		helper.assertError(block, XbasePackage.Literals.XCONSTRUCTOR_CALL, UNREACHABLE_CODE, "unreachable", "expression");
	}
	
	public void testThrowsInBlock_03() throws Exception {
		XExpression block = expression("{ if (true) throw new Exception() new Object()}");
		helper.assertNoErrors(block);
	}
	
	public void testThrowsInBlock_04() throws Exception {
		XExpression block = expression("{ if (true) throw new Exception() else throw new Exception() new Object()}");
		helper.assertError(block, XbasePackage.Literals.XCONSTRUCTOR_CALL, UNREACHABLE_CODE, "unreachable", "expression");
	}

	protected void checkInnerExpressionInBlock(String innerExpression, EClass innerExpressionClass) throws Exception {
		XExpression validExpression = expression("{ " + innerExpression + " }");
		helper.assertNoError(validExpression, INVALID_INNER_EXPRESSION);
		XExpression invalidExpression = expression("{ " + innerExpression + " " + innerExpression + " }");
		helper.assertError(invalidExpression, innerExpressionClass, INVALID_INNER_EXPRESSION, "block", "last",
				"element");
	}
	
	public void testInvalidEarlyExit_01() throws Exception {
		XExpression expression = expression("try {} finally throw new Exception()");
		helper.assertError(expression, XbasePackage.Literals.XTHROW_EXPRESSION, INVALID_EARLY_EXIT, "early", "return", "context");
	}
	
	public void testInvalidEarlyExit_02() throws Exception {
		XExpression expression = expression("if (throw new Exception()) {}");
		helper.assertError(expression, XbasePackage.Literals.XTHROW_EXPRESSION, INVALID_EARLY_EXIT, "early", "return", "context");
	}
	
	public void testInvalidEarlyExit_03() throws Exception {
		XExpression expression = expression("try {} finally return null");
		helper.assertError(expression, XbasePackage.Literals.XRETURN_EXPRESSION, INVALID_EARLY_EXIT, "early", "return", "context");
	}
	
	public void testInvalidEarlyExit_04() throws Exception {
		XExpression expression = expression("if (return 1) {}");
		helper.assertError(expression, XbasePackage.Literals.XRETURN_EXPRESSION, INVALID_EARLY_EXIT, "early", "return", "context");
	}
	
	public void testInvalidEarlyExit_05() throws Exception {
		XExpression expression = expression("if (true) return 1 else throw new Exception()");
		helper.assertNoErrors(expression);
	}
	
	public void testUnreachableCode_00() throws Exception {
		XExpression expression = expression(
				"{" +
				"	for (e : new java.util.ArrayList<String>()) " +
				"      throw new Exception() " +
				"   null" +
				"}");
		helper.assertNoErrors(expression);
	}
	
	public void testUnreachableCode_01() throws Exception {
		XExpression expression = expression(
				"{" +
				"	while (false) " +
				"      throw new Exception() " +
				"   null" +
		"}");
		helper.assertNoErrors(expression);
	}
	
	public void testUnreachableCode_02() throws Exception {
		XExpression expression = expression(
				"{" +
				"	do " +
				"      throw new Exception() " +
				"   while (false)" +
				"   null" +
		"}");
		helper.assertError(((XBlockExpression)expression).getExpressions().get(1), XbasePackage.Literals.XNULL_LITERAL, UNREACHABLE_CODE);
	}

	public void testFeatureCallOnVoid() throws Exception {
		XExpression expression = expression("null.toString()");
		helper.assertError(expression, XMEMBER_FEATURE_CALL, FEATURE_CALL_ON_VOID, "void", "feature", "access");
	}

	public void testNewAbstractClass() throws Exception {
		XExpression expression = expression("new testdata.AbstractClassWithPublicConstructor()");
		helper.assertError(expression, XCONSTRUCTOR_CALL, ABSTRACT_CLASS_INSTANTIATION, "abstract", "instantiate",
				"class");
	}

//	public void testCast_0() throws Exception {
//		XExpression expression = expression("'foo' as String");
//		helper.assertWarning(expression, XCASTED_EXPRESSION, OBSOLETE_CAST, "cast", "obsolete");
//		helper.assertNoError(expression, INVALID_CAST);
//	}

	public void testCast_1() throws Exception {
		XExpression expression = expression("'foo' as Cloneable");
		helper.assertError(expression, XCASTED_EXPRESSION, INVALID_CAST, "sealed", "type");
		helper.assertNoError(expression, OBSOLETE_CAST);
	}

	public void testCast_2() throws Exception {
		XExpression expression = expression("new String() as Boolean");
		helper.assertError(expression, XCASTED_EXPRESSION, INVALID_CAST, "Cannot", "cast");
		helper.assertNoError(expression, OBSOLETE_CAST);
	}

	public void testInstanceOf_0() throws Exception {
		XExpression expression = expression("'foo' instanceof String");
		helper.assertWarning(expression, XINSTANCE_OF_EXPRESSION, OBSOLETE_INSTANCEOF, "already", "java.lang.String");
		helper.assertNoError(expression, INVALID_INSTANCEOF);
	}

	public void testInstanceOf_1() throws Exception {
		XExpression expression = expression("'foo' instanceof Cloneable");
		helper.assertError(expression, XINSTANCE_OF_EXPRESSION, INVALID_INSTANCEOF, "incompatible", "type");
		helper.assertNoError(expression, OBSOLETE_INSTANCEOF);
	}

	public void testInstanceOf_2() throws Exception {
		XExpression expression = expression("new String() instanceof Boolean");
		helper.assertError(expression, XINSTANCE_OF_EXPRESSION, INVALID_INSTANCEOF, "incompatible", "type");
		helper.assertNoError(expression, OBSOLETE_INSTANCEOF);
	}

}
