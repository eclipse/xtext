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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.junit.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;
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
	
	public void testAnnotationTarget_00() throws Exception {
		XtendClass clazz = clazz("@testdata.Annotation2('foo') class X { }");
		helper.assertError(clazz, XAnnotationsPackage.Literals.XANNOTATION, IssueCodes.ANNOTATION_WRONG_TARGET);
	}
	
	public void testAnnotationTarget_01() throws Exception {
		XtendClass clazz = clazz("class X { @testdata.Annotation2('foo')  String foo }");
		helper.assertNoErrors(clazz);
	}
	
	public void testAnnotationTarget_02() throws Exception {
		XtendClass clazz = clazz("class X { @testdata.Annotation2('foo') def String foo() }");
		helper.assertError(clazz, XAnnotationsPackage.Literals.XANNOTATION, IssueCodes.ANNOTATION_WRONG_TARGET);
	}
	
	public void testAnnotationTarget_03() throws Exception {
		XtendClass clazz = clazz("class X {  def String foo(@testdata.Annotation2('foo') String bar) }");
		helper.assertError(clazz, XAnnotationsPackage.Literals.XANNOTATION, IssueCodes.ANNOTATION_WRONG_TARGET);
	}
	
	public void testShadowingVariableNames_00() throws Exception {
		XtendClass clazz = clazz("class X { def foo() { val this = 'foo' } }");
		helper.assertError(clazz, XbasePackage.Literals.XVARIABLE_DECLARATION, VARIABLE_NAME_SHADOWING);
	}
	
	public void testShadowingVariableNames_01() throws Exception {
		XtendClass clazz = clazz("class X { def foo() { val ^super = 'foo' } }");
		helper.assertError(clazz, XbasePackage.Literals.XVARIABLE_DECLARATION, VARIABLE_NAME_SHADOWING);
	}
	
	public void testShadowingVariableNames_03() throws Exception {
		XtendClass clazz = clazz("class X { def foo(String x, String this) { } }");
		helper.assertError(clazz, Xtend2Package.Literals.XTEND_PARAMETER, VARIABLE_NAME_SHADOWING);
	}
	
	public void testShadowingVariableNames_04() throws Exception {
		XtendClass clazz = clazz("class X { def foo(String x) ''' «val x = 'foo'» «x» ''' }");
		helper.assertError(clazz, XbasePackage.Literals.XVARIABLE_DECLARATION, VARIABLE_NAME_SHADOWING);
	}
	
	public void testShadowingVariableNames_05() throws Exception {
		XtendClass clazz = clazz("class X { def foo() ''' «val x = 'foo'» «val x = 'bar'» ''' }");
		helper.assertError(clazz, XbasePackage.Literals.XVARIABLE_DECLARATION, VARIABLE_NAME_SHADOWING);
	}
	
	public void testVoidInDependency() throws Exception {
		XtendClass clazz = clazz("class X { @Inject void v }");
		helper.assertError(clazz, TypesPackage.Literals.JVM_TYPE_REFERENCE, INVALID_USE_OF_TYPE);
	}
	
	public void testVoidInReturn() throws Exception {
		XtendFunction function = function("def void foo() { }");
		helper.assertNoError(function, INVALID_USE_OF_TYPE);
	}
	
	public void testParameterTypeMayNotBeVoid() throws Exception {
		XtendFunction function = function("def void foo(void myParam) { }");
		helper.assertError(function, TypesPackage.Literals.JVM_TYPE_REFERENCE, INVALID_USE_OF_TYPE);
	}
	
	public void testCreateMayNotReturnVoid() throws Exception {
		XtendFunction function = function("def void create result: new Object() newObject() { }");
		helper.assertError(function, TypesPackage.Literals.JVM_TYPE_REFERENCE, INVALID_USE_OF_TYPE, "void", "create", "newObject");
	}
	
	public void testCreateExpressionMayNotReturnVoid_01() throws Exception {
		XtendFunction function = function("def create result: while(true){} illegal() { }");
		helper.assertError(function, Xtend2Package.Literals.XTEND_FUNCTION, INVALID_USE_OF_TYPE, "void", "create", "function", "illegal");
	}
	
	public void testCreateExpressionMayNotReturnVoid_02() throws Exception {
		XtendFunction function = function("def String create result: while(true){} illegal() { }");
		helper.assertError(function, XbasePackage.Literals.XWHILE_EXPRESSION, INCOMPATIBLE_TYPES, "void", "String");
	}

	public void testCreateExpressionMayNotReturnVoid_03() throws Exception {
		XtendFunction function = function("override create result: while(true){} toString() { }");
		helper.assertError(function, XbasePackage.Literals.XWHILE_EXPRESSION, INCOMPATIBLE_TYPES, "void", "String");
	}
	
	public void testNoReturnInCreateFunctions() throws Exception {
		XtendFunction function = function("def create result: if (true) return 'foo' else 'bar' foo() { }");
		helper.assertError(function, XbasePackage.Literals.XRETURN_EXPRESSION, INVALID_EARLY_EXIT);
	}
	
	public void testNoReturnInCreateFunctions_00() throws Exception {
		XtendFunction function = function("def create result: [|if (true) return 'foo' else 'bar'] foo() { }");
		helper.assertNoErrors(function);
	}
	
	public void testNoReturnInCreateFunctions_01() throws Exception {
		XtendFunction function = function("def create result:'foo' foo() { return 'bar' }");
		helper.assertError(function, XbasePackage.Literals.XSTRING_LITERAL, INCOMPATIBLE_TYPES);
	}
	
	public void testNoReturnInCreateFunctions_02() throws Exception {
		XtendFunction function = function("def create result:'foo' foo() { return }");
		helper.assertNoErrors(function);
	}
	
	public void testNoReturnInCreateFunctions_03() throws Exception {
		XtendFunction function = function("def create result:'foo' foo() { [|return 'foo'].apply() }");
		helper.assertNoErrors(function);
	}
	
	public void testNoReturnInCreateFunctions_04() throws Exception {
		XtendFunction function = function("def create result:'foo' foo() { if (true) 'foo'+'bar' else return 'baz' }");
		helper.assertError(function, XbasePackage.Literals.XSTRING_LITERAL, INCOMPATIBLE_TYPES);
	}

	public void testReturnTypeCompatibility_00() throws Exception {
		XtendFunction function = function("def void foo(int bar) { }");
		helper.assertNoErrors(function);
	}

	public void testReturnTypeCompatibility_01() throws Exception {
		XtendFunction function = function("def String foo(int bar) { return 42 }");
		helper.assertError(function, XbasePackage.Literals.XINT_LITERAL, INCOMPATIBLE_TYPES, "String", "int");
	}

	public void testReturnTypeCompatibility_02() throws Exception {
		XtendFunction function = function("def Object foo(int bar) { return 42 }");
		helper.assertNoErrors(function);
	}

	public void testReturnTypeCompatibility_03() throws Exception {
		XtendFunction function = function("def String foo(int bar) { " 
				+ " if (true) {"
				+ "  return if (false) 42 else new Object()" 
				+ " }" 
				+ "}");
		helper.assertError(function, XbasePackage.Literals.XIF_EXPRESSION, INCOMPATIBLE_TYPES, "String", "Object");
	}

	public void testReturnTypeCompatibility_04() throws Exception {
		XtendClass clazz = clazz("class Foo implements test.SomeInterface { def foo() { 1 } }");
		helper.assertError(clazz.getMembers().get(0), Xtend2Package.Literals.XTEND_FUNCTION, MISSING_OVERRIDE);
	}

	public void testReturnTypeCompatibility_05() throws Exception {
		XtendClass clazz = clazz("class Foo implements test.SomeInterface { override foo() { true } }");
		helper.assertNoErrors(clazz.getMembers().get(0));
	}
	
	public void testReturnTypeCompatibility_06() throws Exception {
		XtendClass clazz = clazz("class Foo { def dispatch void a(String x) {} def dispatch a(Object x) {return null} }");
		helper.assertError(clazz.getMembers().get(1), Xtend2Package.Literals.XTEND_FUNCTION, INCOMPATIBLE_RETURN_TYPE);
	}

	public void testAssignmentToFunctionParameter() throws Exception {
		XtendFunction function = function("def void foo(int bar) { bar = 7 }");
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
		XtendFunction function = function("def dispatch foo() { null }");
		helper.assertError(function, Xtend2Package.Literals.XTEND_FUNCTION, IssueCodes.CASE_FUNC_WITHOUT_PARAMS);
	}

	public void testCaseFunctionWithTypeParams() throws Exception {
		XtendFunction function = function("def dispatch <T> foo(T s) { null }");
		helper.assertError(function, Xtend2Package.Literals.XTEND_FUNCTION, IssueCodes.CASE_FUNC_WITH_TYPE_PARAMS);
	}

	public void testSingleCaseFunction() throws Exception {
		XtendFunction function = function("def dispatch foo(String s) { null }");
		helper.assertWarning(function, Xtend2Package.Literals.XTEND_FUNCTION, IssueCodes.SINGLE_CASE_FUNCTION);
	}

	public void testDuplicateCaseFunction() throws Exception {
		XtendFunction function = function("def dispatch foo(Integer s) { null } def dispatch foo(int s) { null }");
		helper.assertError(function, Xtend2Package.Literals.XTEND_FUNCTION, IssueCodes.DUPLICATE_METHOD, "dispatch");
	}

	public void testInaccessibleMethod() throws Exception {
		XtendClass xtendClass = clazz("class Foo extends test.SuperClass { def foo() { privateMethod() }}");
		helper.assertError(((XBlockExpression) ((XtendFunction) xtendClass.getMembers().get(0)).getExpression())
				.getExpressions().get(0), XbasePackage.Literals.XABSTRACT_FEATURE_CALL, FEATURE_NOT_VISIBLE, "Feature",
				"not", "visible");
	}

	public void testInaccessibleMethod2() throws Exception {
		XtendClass xtendClass = clazz("class Foo { def foo() { val o = new Object() o.clone() }}");
		helper.assertError(((XBlockExpression) ((XtendFunction) xtendClass.getMembers().get(0)).getExpression())
				.getExpressions().get(1), XbasePackage.Literals.XABSTRACT_FEATURE_CALL, FEATURE_NOT_VISIBLE, "Feature",
				"not", "visible");
	}

	public void testDuplicateParameter() throws Exception {
		XtendFunction function = function("def foo(int x, int x) {null}");
		helper.assertError(function, Xtend2Package.Literals.XTEND_FUNCTION, DUPLICATE_PARAMETER_NAME, "duplicate", "name");
	}
	
	public void testRichStringIfPredicate() throws Exception {
		assertNoConformanceError("'''«IF Boolean::FALSE»«ENDIF»'''");
		assertNoConformanceError("'''«IF true»«ENDIF»'''");
		assertNoConformanceError("'''«IF 1 == 1»«ENDIF»'''");
		assertConformanceError("'''«IF 1»«ENDIF»'''", XbasePackage.Literals.XINT_LITERAL, "int",
				"boolean", "java.lang.Boolean");
	}
	
	public void testRichStringForLoop() throws Exception {
		assertNoConformanceError("'''«FOR i: 1..10»«ENDFOR»'''");
		assertNoConformanceError("'''«FOR i: 1..10 BEFORE 'a' SEPARATOR 1 AFTER true»«ENDFOR»'''");
		assertConformanceError(
				"'''«FOR i: 1..10 BEFORE while(true) null SEPARATOR 'b' AFTER 'c'»«ENDFOR»'''", 
				XbasePackage.Literals.XWHILE_EXPRESSION, "void",
				"java.lang.Object");
		assertConformanceError(
				"'''«FOR i: 1..10 BEFORE 'a' SEPARATOR while(true) null AFTER 'c'»«ENDFOR»'''", 
				XbasePackage.Literals.XWHILE_EXPRESSION, "void",
				"java.lang.Object");
		assertConformanceError(
				"'''«FOR i: 1..10 BEFORE 'a' SEPARATOR null AFTER while(true) null»«ENDFOR»'''", 
				XbasePackage.Literals.XWHILE_EXPRESSION, "void",
				"java.lang.Object");
	}
	
	public void testBug343089_01() throws Exception {
		XtendFunction function = function(
				"def <T extends Integer> noCastRequired() {\n" + 
				 "  [T a,T b|a+b]\n" + 
				 "}");
		helper.assertNoErrors(function);
	}
	
	// TODO: Fix these cases
//	public void testBug343088_01() throws Exception {
//		XtendFunction function = function(
//				"def <T extends Integer> (T,T)=>T addFunction() {\n" + 
//				"    [T a,T b|a+(b as Integer)]\n" + 
//				"}");
//		assertIncompatibleReturnType(..)
//	}
//	
//	public void testBug343088_02() throws Exception {
//		XtendFunction function = function(
//				"def <T extends Integer> (T,T)=>T addFunction() {\n" + 
//				"    [T a,T b|a+b] as \n" + 
//				"}");
//		assertIncompatibleReturnType(..)
//	}


	protected void assertConformanceError(String body, EClass objectType, String... messageParts)
			throws Exception {
		final XtendFunction function = function("def foo() " + body);
		helper.assertError(function, objectType, INCOMPATIBLE_TYPES, messageParts);
	}

	protected void assertCastError(String body, EClass objectType, String... messageParts) throws Exception {
		final XtendFunction function = function("def foo() " + body);
		helper.assertError(function, objectType, INVALID_CAST, messageParts);
	}

	protected void assertNoConformanceError(String body) throws Exception {
		final XtendFunction function = function("def foo() " + body);
		helper.assertNoError(function, INCOMPATIBLE_TYPES);
	}
}
