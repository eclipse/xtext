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
import org.eclipse.xtext.xbase.XBlockExpression;
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
	
	public void testNoReturnInCreateFunctions() throws Exception {
		XtendFunction function = function("create if (true) return 'foo' else 'bar' foo() { }");
		helper.assertError(function, XbasePackage.Literals.XRETURN_EXPRESSION, INVALID_EARLY_EXIT);
	}
	
	public void testNoReturnInCreateFunctions_00() throws Exception {
		XtendFunction function = function("create [|if (true) return 'foo' else 'bar'] foo() { }");
		helper.assertNoErrors(function);
	}
	
	public void testNoReturnInCreateFunctions_01() throws Exception {
		XtendFunction function = function("create 'foo' foo() { return 'bar' }");
		helper.assertError(function, XbasePackage.Literals.XSTRING_LITERAL, INCOMPATIBLE_TYPES);
	}
	
	public void testNoReturnInCreateFunctions_02() throws Exception {
		XtendFunction function = function("create 'foo' foo() { return }");
		helper.assertNoErrors(function);
	}
	
	public void testNoReturnInCreateFunctions_03() throws Exception {
		XtendFunction function = function("create 'foo' foo() { [|return 'foo'].apply() }");
		helper.assertNoErrors(function);
	}
	
	public void testNoReturnInCreateFunctions_04() throws Exception {
		XtendFunction function = function("create 'foo' foo() { if (true) 'foo'+'bar' else return 'baz' }");
		helper.assertError(function, XbasePackage.Literals.XSTRING_LITERAL, INCOMPATIBLE_TYPES);
	}

	public void testReturnTypeCompatibility_00() throws Exception {
		XtendFunction function = function("void foo(int bar) { }");
		helper.assertNoErrors(function);
	}

	public void testReturnTypeCompatibility_01() throws Exception {
		XtendFunction function = function("String foo(int bar) { return 42 }");
		helper.assertError(function, XbasePackage.Literals.XINT_LITERAL, INCOMPATIBLE_TYPES, "String", "int");
	}

	public void testReturnTypeCompatibility_02() throws Exception {
		XtendFunction function = function("Object foo(int bar) { return 42 }");
		helper.assertNoErrors(function);
	}

	public void testReturnTypeCompatibility_03() throws Exception {
		XtendFunction function = function("String foo(int bar) { " + " if (true) {"
				+ "  return if (false) 42 else new Object()" + " }" + "}");
		helper.assertError(function, XbasePackage.Literals.XIF_EXPRESSION, INCOMPATIBLE_TYPES, "String", "Object");
	}

	public void testReturnTypeCompatibility_04() throws Exception {
		XtendClass clazz = clazz("class Foo implements test.SomeInterface { foo() { 1 } }");
		helper.assertError(clazz.getMembers().get(0), XbasePackage.Literals.XBLOCK_EXPRESSION, INCOMPATIBLE_RETURN_TYPE);
		helper.assertError(clazz.getMembers().get(0), Xtend2Package.Literals.XTEND_FUNCTION, MISSING_OVERRIDE);
	}

	public void testReturnTypeCompatibility_05() throws Exception {
		XtendClass clazz = clazz("class Foo implements test.SomeInterface { override foo() { true } }");
		helper.assertNoErrors(clazz.getMembers().get(0));
	}
	
	public void testReturnTypeCompatibility_06() throws Exception {
		XtendClass clazz = clazz("class Foo { dispatch void a(String x) {} dispatch a(Object x) {return null} }");
		helper.assertError(clazz.getMembers().get(1), Xtend2Package.Literals.XTEND_FUNCTION, INCOMPATIBLE_RETURN_TYPE);
	}

	public void testAssignmentToFunctionParameter() throws Exception {
		XtendFunction function = function("void foo(int bar) { bar=7 }");
		helper.assertError(function, XbasePackage.Literals.XASSIGNMENT, ASSIGNMENT_TO_FINAL, "Assignment", "final",
				"parameter");
	}

	public void testClassExtendsInterface() throws Exception {
		XtendClass clazz = clazz("class Foo extends Cloneable {}");
		helper.assertError(clazz, Xtend2Package.Literals.XTEND_CLASS, CLASS_EXPECTED, "Superclass");
	}

	public void testClassImplementsClass() throws Exception {
		XtendClass clazz = clazz("class Foo implements Object {}");
		helper.assertError(clazz, Xtend2Package.Literals.XTEND_CLASS, INTERFACE_EXPECTED, "Implemented", "interface");
	}

	public void testCaseFunctionNoParameters() throws Exception {
		XtendFunction function = function("dispatch foo() { null }");
		helper.assertError(function, Xtend2Package.Literals.XTEND_FUNCTION, IssueCodes.CASE_FUNC_WITHOUT_PARAMS);
	}

	public void testCaseFunctionWithTypeParams() throws Exception {
		XtendFunction function = function("dispatch <T> foo(T s) { null }");
		helper.assertError(function, Xtend2Package.Literals.XTEND_FUNCTION, IssueCodes.CASE_FUNC_WITH_TYPE_PARAMS);
	}

	public void testSingleCaseFunction() throws Exception {
		XtendFunction function = function("dispatch foo(String s) { null }");
		helper.assertWarning(function, Xtend2Package.Literals.XTEND_FUNCTION, IssueCodes.SINGLE_CASE_FUNCTION);
	}

	public void testDuplicateCaseFunction() throws Exception {
		XtendFunction function = function("dispatch foo(Integer s) { null } dispatch foo(int s) { null }");
		helper.assertError(function, Xtend2Package.Literals.XTEND_FUNCTION, IssueCodes.DUPLICATE_METHOD, "dispatch");
	}

	public void testInaccessibleMethod() throws Exception {
		XtendClass xtendClass = clazz("class Foo extends test.SuperClass { foo() { privateMethod() }}");
		helper.assertError(((XBlockExpression) ((XtendFunction) xtendClass.getMembers().get(0)).getExpression())
				.getExpressions().get(0), XbasePackage.Literals.XABSTRACT_FEATURE_CALL, FEATURE_NOT_VISIBLE, "Feature",
				"not", "visible");
	}

	public void testInaccessibleMethod2() throws Exception {
		XtendClass xtendClass = clazz("class Foo { foo() { val o = new Object() o.clone() }}");
		helper.assertError(((XBlockExpression) ((XtendFunction) xtendClass.getMembers().get(0)).getExpression())
				.getExpressions().get(1), XbasePackage.Literals.XABSTRACT_FEATURE_CALL, FEATURE_NOT_VISIBLE, "Feature",
				"not", "visible");
	}

	public void testDuplicateParameter() throws Exception {
		XtendFunction function = function("foo(int x, int x) {null}");
		helper.assertError(function, Xtend2Package.Literals.XTEND_FUNCTION, DUPLICATE_PARAMETER_NAME, "duplicate", "name");
	}
}
