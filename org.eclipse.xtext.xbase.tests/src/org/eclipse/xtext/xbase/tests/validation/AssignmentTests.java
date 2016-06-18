/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.validation;

import static org.eclipse.xtext.xbase.validation.IssueCodes.*;

import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.Test;

import testdata.FieldAccess;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class AssignmentTests extends AbstractXbaseTestCase {

	@Inject
	protected ValidationTestHelper helper;

	@Test public void testAssignmentToVal() throws Exception {
		XExpression expression = expression("{ val x = true; x = false }", false);
		helper.assertError(expression, XbasePackage.Literals.XASSIGNMENT, ASSIGNMENT_TO_FINAL, "Assignment", "final",
				"variable");
	}

	@Test public void testAssignmentToParameter() throws Exception {
		XExpression expression = expression("[foo|foo=false]", false);
		helper.assertError(expression, XbasePackage.Literals.XASSIGNMENT, ASSIGNMENT_TO_FINAL, "Assignment", "final",
				"parameter");
	}

	@Test public void testAssignmentToCaughtException() throws Exception {
		XExpression expression = expression("try { true } catch(Exception e) { e=null }", false);
		helper.assertError(expression, XbasePackage.Literals.XASSIGNMENT, ASSIGNMENT_TO_FINAL, "Assignment", "final",
				"parameter");
	}

	@Test public void testAssignmentToForVariable() throws Exception {
		XExpression expression = expression("for(String foo: new java.util.ArrayList<String>()) foo=null", false);
		helper.assertError(expression, XbasePackage.Literals.XASSIGNMENT, ASSIGNMENT_TO_FINAL, "Assignment", "final",
				"parameter");
	}

	@Test public void testFinalFeatureAssignment() throws Exception {
		XExpression expression = expression("new " + FieldAccess.class.getCanonicalName() + "().finalField=0", false);
		helper.assertError(expression, XbasePackage.Literals.XASSIGNMENT, ASSIGNMENT_TO_FINAL);
	}

	@Test public void testValAssignmentWithoutTypeAndInitialization() throws Exception {
		XExpression expression = expression("{ val foo }", false);
		helper.assertError(expression, XbasePackage.Literals.XVARIABLE_DECLARATION, MISSING_INITIALIZATION,
				"initialized");
		helper.assertError(expression, XbasePackage.Literals.XVARIABLE_DECLARATION, MISSING_TYPE, "type", "derived");
	}

	@Test public void testValAssignmentWithoutInitialization() throws Exception {
		XExpression expression = expression("{ val String foo }", false);
		helper.assertError(expression, XbasePackage.Literals.XVARIABLE_DECLARATION, MISSING_INITIALIZATION,
				"initialized");
		helper.assertNoError(expression, MISSING_TYPE);
	}

	@Test public void testVarAssignmentWithoutTypeAndInitialization() throws Exception {
		XExpression expression = expression("{ var foo }", false);
		helper.assertNoError(expression, MISSING_INITIALIZATION);
		helper.assertError(expression, XbasePackage.Literals.XVARIABLE_DECLARATION, MISSING_TYPE, "type", "derived");
	}

	@Test public void testVarAssignmentDerivedVoidType() throws Exception {
		XExpression expression = expression("{ val foo = while(true) 'bar' }", false);
		helper.assertNoError(expression, MISSING_INITIALIZATION);
		helper.assertNoError(expression, MISSING_TYPE);
	}

}
