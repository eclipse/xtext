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
		checkLiteralsInBlock("'foo'", XSTRING_LITERAL);
	}
	
	public void testNullLiteralInBlock() throws Exception {
		checkLiteralsInBlock("null", XNULL_LITERAL);
	}
	
	public void testBooleanLiteralInBlock() throws Exception {
		checkLiteralsInBlock("true", XBOOLEAN_LITERAL);
	}
	
	public void testTypeLiteralInBlock() throws Exception {
		checkLiteralsInBlock("typeof (String)", XTYPE_LITERAL);
	}
	
	public void testClosureInBlock() throws Exception {
		checkLiteralsInBlock("[a|a]", XCLOSURE);
	}
	
	protected void checkLiteralsInBlock(String literalExpression, EClass literalClass) throws Exception {
		XExpression validExpression = expression("{ " + literalExpression + " }");
		helper.assertNoError(validExpression, XbaseJavaValidator.LITERAL_NOT_ALLOWED);
		XExpression invalidExpression = expression("{ " + literalExpression + " " + literalExpression + " }");
		helper.assertError(invalidExpression, literalClass, XbaseJavaValidator.LITERAL_NOT_ALLOWED, "block", "literal");
	}
	
	public void testFeatureCallOnVoid() throws Exception {
		XExpression expression = expression("null.toString()");
		helper.assertError(expression, XMEMBER_FEATURE_CALL, XbaseJavaValidator.FEATURE_CALL_ON_VOID, "void", "feature", "access");
	}
	
}
