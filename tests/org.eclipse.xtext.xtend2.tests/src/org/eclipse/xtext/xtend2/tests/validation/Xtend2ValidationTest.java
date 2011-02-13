/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.tests.validation;

import static org.eclipse.xtext.xbase.validation.IssueCodes.*;
import static org.eclipse.xtext.xtend2.validation.IssueCodes.*;

import org.eclipse.xtext.junit.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xtend2.tests.AbstractXtend2TestCase;
import org.eclipse.xtext.xtend2.validation.IssueCodes;
import org.eclipse.xtext.xtend2.xtend2.Xtend2Package;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class Xtend2ValidationTest extends AbstractXtend2TestCase {

	@Inject
	private ValidationTestHelper helper;

	public void testAssignmentToFunctionParameter() throws Exception {
		XtendFunction function = function("void foo(int bar) bar=7");
		helper.assertError(function, XbasePackage.Literals.XASSIGNMENT, ASSIGNMENT_TO_FINAL,
				"Assignment", "final", "parameter");
	}

	public void testClassExtendsInterface() throws Exception {
		XtendClass clazz = clazz("class Foo extends Cloneable {}");
		helper.assertError(clazz, Xtend2Package.Literals.XTEND_CLASS, CLASS_EXPECTED, "Superclass");
	}

	public void testClassImplementsClass() throws Exception {
		XtendClass clazz = clazz("class Foo implements Object {}");
		helper.assertError(clazz, Xtend2Package.Literals.XTEND_CLASS, INTERFACE_EXPECTED,
				"Implemented", "interface");
	}
	
	public void testCaseFunctionNoParameters() throws Exception {
		XtendFunction function = function("case foo() null");
		helper.assertError(function, Xtend2Package.Literals.XTEND_FUNCTION, IssueCodes.CASE_FUNC_WITHOUT_PARAMS);
	}
	
	public void testCaseFunctionWithTypeParams() throws Exception {
		XtendFunction function = function("case <T> foo(T s) null");
		helper.assertError(function, Xtend2Package.Literals.XTEND_FUNCTION, IssueCodes.CASE_FUNC_WITH_TYPE_PARAMS);
	}
	
	public void testSingleCaseFunction() throws Exception {
		XtendFunction function = function("case foo(String s) null");
		helper.assertWarning(function, Xtend2Package.Literals.XTEND_FUNCTION, IssueCodes.SINGLE_CASE_FUNCTION);
	}
	
	public void testDuplicateCaseFunction() throws Exception {
		XtendFunction function = function("case foo(Integer s) null case foo(int s) null");
		helper.assertError(function, Xtend2Package.Literals.XTEND_FUNCTION, IssueCodes.DUPLICATE_METHOD, "case");
	}
}
