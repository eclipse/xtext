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

import org.eclipse.xtext.junit.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class FeatureCallValidationTest extends AbstractXbaseTestCase {

	@Inject
	protected ValidationTestHelper helper;

	public void testConstructorCall_0() throws Exception {
		XExpression expression = expression("new testdata.Constructors()");
		helper.assertError(expression, XCONSTRUCTOR_CALL, INVALID_NUMBER_OF_ARGUMENTS);
	}

	public void testConstructorCall_1() throws Exception {
		XExpression expression = expression("new testdata.Constructors(1)");
		helper.assertError(expression, XCONSTRUCTOR_CALL, INVALID_ARGUMENT_TYPES);
	}

	public void testConstructorCall_2() throws Exception {
		XExpression expression = expression("new testdata.Constructors('foo', 'bar')");
		helper.assertError(expression, XCONSTRUCTOR_CALL, INVALID_NUMBER_OF_ARGUMENTS);
	}

	// TODO: constructor type arguments

	public void testBinaryOperation_0() throws Exception {
		XExpression expression = expression("1 + 'foo'");
		helper.assertError(expression, XSTRING_LITERAL, INCOMPATIBLE_TYPES);
	}

	public void testAssignment_0() throws Exception {
		XExpression expression = expression("new testdata.Properties1().prop3 = 'foo'");
		helper.assertError(expression, XSTRING_LITERAL, INCOMPATIBLE_TYPES);
	}

	public void testAssignmentToFinalField() throws Exception {
		XExpression expression = expression("new testdata.FieldAccess().finalField = 'foo'");
		helper.assertError(expression, XASSIGNMENT, ASSIGNMENT_TARGET_IS_NOT_WRITEABLE);
	}

	public void testAssignmentToStaticField() throws Exception {
		XExpression expression = expression("new testdata.FieldAccess().staticField = 'foo'");
		helper.assertError(expression, XASSIGNMENT, INSTANCE_ACCESS_TO_STATIC_MEMBER);
	}

	public void testField_0() throws Exception {
		XExpression expression = expression("new testdata.FieldAccess().finalField()");
		helper.assertError(expression, XMEMBER_FEATURE_CALL, FIELD_ACCESS_WITH_PARENTHESES);
	}

	public void testField_1() throws Exception {
		XExpression expression = expression("new testdata.FieldAccess().finalField('foo')");
		helper.assertError(expression, XMEMBER_FEATURE_CALL, INVALID_NUMBER_OF_ARGUMENTS);
	}

	public void testField_2() throws Exception {
		XExpression expression = expression("new testdata.FieldAccess().staticField");
		helper.assertError(expression, XMEMBER_FEATURE_CALL, INSTANCE_ACCESS_TO_STATIC_MEMBER);
	}

	public void testField_3() throws Exception {
		XExpression expression = expression("{ var this = new testdata.FieldAccess() staticField }");
		helper.assertError(((XBlockExpression) expression).getExpressions().get(1), XFEATURE_CALL,
				INSTANCE_ACCESS_TO_STATIC_MEMBER);
	}

	public void testField_4() throws Exception {
		XExpression expression = expression("{ var this = new testdata.FieldAccess() finalField() }");
		helper.assertError(((XBlockExpression) expression).getExpressions().get(1), XFEATURE_CALL,
				FIELD_ACCESS_WITH_PARENTHESES);
	}

	public void testOperationMemberFeatureCall_0() throws Exception {
		XExpression expression = expression("new testdata.Methods().staticMethod()");
		helper.assertError(expression, XMEMBER_FEATURE_CALL, INSTANCE_ACCESS_TO_STATIC_MEMBER);
	}

	public void testOperationMemberFeatureCall_1() throws Exception {
		XExpression expression = expression("new testdata.Methods().method()");
		helper.assertError(expression, XMEMBER_FEATURE_CALL, INVALID_NUMBER_OF_ARGUMENTS);
	}

	public void testOperationMemberFeatureCall_2() throws Exception {
		XExpression expression = expression("new testdata.Methods().method('foo', 'bar')");
		helper.assertError(expression, XMEMBER_FEATURE_CALL, INVALID_NUMBER_OF_ARGUMENTS);
	}

	public void testOperationMemberFeatureCall_3() throws Exception {
		XExpression expression = expression("new testdata.Methods().method('foo')");
		helper.assertError(expression, XSTRING_LITERAL, INCOMPATIBLE_TYPES);
	}

	public void testOperationMemberFeatureCall_4() throws Exception {
		XExpression expression = expression("new testdata.Methods().sugarMethod");
		helper.assertNoError(expression, METHOD_ACCESS_WITHOUT_PARENTHESES);
	}

	public void testOperationMemberFeatureCall_5() throws Exception {
		XExpression expression = expression("new testdata.Methods().sugarMethod()");
		helper.assertNoError(expression, METHOD_ACCESS_WITHOUT_PARENTHESES);
	}

	public void testOperationFeatureCall_0() throws Exception {
		XExpression expression = expression("{ var this = new testdata.Methods() staticMethod() }");
		helper.assertNoError(((XBlockExpression) expression).getExpressions().get(1), INSTANCE_ACCESS_TO_STATIC_MEMBER);
	}

	public void testOperationFeatureCall_1() throws Exception {
		XExpression expression = expression("{ var this = new testdata.Methods() method() }");
		helper.assertError(((XBlockExpression) expression).getExpressions().get(1), XFEATURE_CALL,
				INVALID_NUMBER_OF_ARGUMENTS);
	}

	public void testOperationFeatureCall_2() throws Exception {
		XExpression expression = expression("{ var this = new testdata.Methods() method('foo', 'bar') }");
		helper.assertError(((XBlockExpression) expression).getExpressions().get(1), XFEATURE_CALL,
				INVALID_NUMBER_OF_ARGUMENTS);
	}

	public void testOperationFeatureCall_3() throws Exception {
		XExpression expression = expression("{ var this = new testdata.Methods() method('foo') }");
		helper.assertError(((XBlockExpression) expression).getExpressions().get(1), XSTRING_LITERAL,
				INCOMPATIBLE_TYPES);
	}

	public void testOperationFeatureCall_4() throws Exception {
		XExpression expression = expression("{ var this = new testdata.Methods() sugarMethod }");
		helper.assertNoError(((XBlockExpression) expression).getExpressions().get(1), METHOD_ACCESS_WITHOUT_PARENTHESES);
	}
	
	public void testOperationFeatureCall_5() throws Exception {
		XExpression expression = expression("{ var o = new Object() o.clone() }");
		helper.assertError(((XBlockExpression) expression).getExpressions().get(1), XABSTRACT_FEATURE_CALL, FEATURE_NOT_VISIBLE);
	}
	
	public void testStaticFeatureAccess_0() throws Exception {
		XExpression expression = expression("String::valueOf('')");
		helper.assertNoErrors(expression);
	}
	
	public void testStaticFeatureAccess_1() throws Exception {
		XExpression expression = expression("String::hashCode()");
		helper.assertError(expression, XABSTRACT_FEATURE_CALL, STATIC_ACCESS_TO_INSTANCE_MEMBER);
	}
	
	public void testStaticFeatureAccess_2() throws Exception {
		XExpression expression = expression("''.valueOf('')");
		helper.assertError(expression, XABSTRACT_FEATURE_CALL, INSTANCE_ACCESS_TO_STATIC_MEMBER);
	}
	
	public void testNullSafeOnPrimitiveReveiver() throws Exception {
		XExpression expression = expression("1?.toString()");
		helper.assertError(expression, XABSTRACT_FEATURE_CALL, NULL_SAFE_FEATURE_CALL_ON_PRIMITIVE);
	}
	
	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=350934
	 */
	public void testBug_350934_01() throws Exception {
		XExpression expression = expression("'3'>3");
		helper.assertError(expression, XINT_LITERAL, INCOMPATIBLE_TYPES);
	}
	
	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=350934
	 */
	public void testBug_350934_02() throws Exception {
		XExpression expression = expression("'true'<false");
		helper.assertError(expression, XBOOLEAN_LITERAL, INCOMPATIBLE_TYPES);
	}
	
	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=350934
	 */
	public void testBug_350934_03() throws Exception {
		XExpression expression = expression("true>=0"); 
		helper.assertError(expression, XINT_LITERAL, INCOMPATIBLE_TYPES);
	}
}
