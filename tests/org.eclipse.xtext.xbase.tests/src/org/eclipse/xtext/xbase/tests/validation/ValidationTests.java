/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.validation;

import static org.eclipse.xtext.xbase.XbasePackage.Literals.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.junit.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.validation.XbaseJavaValidator;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ValidationTests extends AbstractXbaseTestCase {

	@Inject
	protected ValidationTestHelper helper;
	
	public void testFinalCast() throws Exception {
		XExpression expression = expression("'foo' as Cloneable");
		helper.assertError(expression, XCASTED_EXPRESSION, XbaseJavaValidator.INVALID_CAST, "sealed");
		expression = expression("'foo' as CharSequence");
		helper.assertNoError(expression, XbaseJavaValidator.INVALID_CAST);
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
	
	public void testThrowsInBlock() throws Exception {
		checkInnerExpressionInBlock("throw new Exception()", XTHROW_EXPRESSION);
	}
	
	protected void checkInnerExpressionInBlock(String innerExpression, EClass innerExpressionClass) throws Exception {
		XExpression validExpression = expression("{ " + innerExpression + " }");
		helper.assertNoError(validExpression, XbaseJavaValidator.INVALID_INNER_EXPRESSION);
		XExpression invalidExpression = expression("{ " + innerExpression + " " + innerExpression + " }");
		helper.assertError(invalidExpression, innerExpressionClass, XbaseJavaValidator.INVALID_INNER_EXPRESSION, "block", "last", "element");
	}
	
	public void testFeatureCallOnVoid() throws Exception {
		XExpression expression = expression("null.toString()");
		helper.assertError(expression, XMEMBER_FEATURE_CALL, XbaseJavaValidator.FEATURE_CALL_ON_VOID, "void", "feature", "access");
	}
	
	public void testNewAbstractClass() throws Exception {
		XExpression expression = expression("new testdata.AbstractClassWithPublicConstructor()");
		helper.assertError(expression, XCONSTRUCTOR_CALL, XbaseJavaValidator.ABSTRACT_CLASS_INSTANTIATION, "abstract", "instantiate", "class");
	}
	
	public void testCast_0() throws Exception {
		XExpression expression = expression("'foo' as String");
		helper.assertError(expression, XCASTED_EXPRESSION, XbaseJavaValidator.OBSOLETE_CAST, "cast", "obsolete");
		helper.assertNoError(expression, XbaseJavaValidator.INVALID_CAST);
	}

	public void testCast_1() throws Exception {
		XExpression expression = expression("'foo' as Cloneable");
		helper.assertError(expression, XCASTED_EXPRESSION, XbaseJavaValidator.INVALID_CAST, "sealed", "type");
		helper.assertNoError(expression, XbaseJavaValidator.OBSOLETE_CAST);
	}

	public void testCast_2() throws Exception {
		XExpression expression = expression("new Object() as String");
		helper.assertError(expression, XCASTED_EXPRESSION, XbaseJavaValidator.INVALID_CAST, "incompatible", "type");
		helper.assertNoError(expression, XbaseJavaValidator.OBSOLETE_CAST);
	}

	public void testInstanceOf_0() throws Exception {
		XExpression expression = expression("'foo' instanceof String");
		helper.assertError(expression, XINSTANCE_OF_EXPRESSION, XbaseJavaValidator.OBSOLETE_INSTANCEOF, "condition", "always", "true");
		helper.assertNoError(expression, XbaseJavaValidator.INVALID_INSTANCEOF);
	}

	public void testInstanceOf_1() throws Exception {
		XExpression expression = expression("'foo' instanceof Cloneable");
		helper.assertError(expression, XINSTANCE_OF_EXPRESSION, XbaseJavaValidator.INVALID_INSTANCEOF, "incompatible", "type");
		helper.assertNoError(expression, XbaseJavaValidator.OBSOLETE_INSTANCEOF);
	}

	public void testInstanceOf_2() throws Exception {
		XExpression expression = expression("new Object() instanceof String");
		helper.assertError(expression, XINSTANCE_OF_EXPRESSION, XbaseJavaValidator.INVALID_INSTANCEOF, "incompatible", "type");
		helper.assertNoError(expression, XbaseJavaValidator.OBSOLETE_INSTANCEOF);
	}
	
}
