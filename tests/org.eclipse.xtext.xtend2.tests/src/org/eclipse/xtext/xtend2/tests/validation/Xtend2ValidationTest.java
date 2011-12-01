/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.tests.validation;

import static org.eclipse.xtext.ui.junit.util.IResourcesSetupUtil.*;
import static org.eclipse.xtext.xbase.validation.IssueCodes.*;
import static org.eclipse.xtext.xtend2.validation.IssueCodes.*;

import java.util.Iterator;

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
import org.eclipse.xtext.xtend2.xtend2.XtendConstructor;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;
import org.eclipse.xtext.xtend2.xtend2.XtendMember;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class Xtend2ValidationTest extends AbstractXtend2TestCase {

	@Inject
	private ValidationTestHelper helper;
	
	public void testFieldInitializerType_01() throws Exception {
		XtendClass clazz = clazz("class Z { String s = 1 }");
		helper.assertError(clazz, XbasePackage.Literals.XINT_LITERAL, org.eclipse.xtext.xbase.validation.IssueCodes.INCOMPATIBLE_RETURN_TYPE);
	}
	
	public void testFieldInitializerType_02() throws Exception {
		XtendClass clazz = clazz("class Z { String s = 1.toString }");
		helper.assertNoErrors(clazz);
	}
	
	public void testFieldInitializerType_03() throws Exception {
		XtendClass clazz = clazz("class Z { String s = return 1 }");
		helper.assertError(clazz, XbasePackage.Literals.XINT_LITERAL, org.eclipse.xtext.xbase.validation.IssueCodes.INCOMPATIBLE_TYPES);
	}
	
	public void testFieldInitializerType_04() throws Exception {
		XtendClass clazz = clazz("class Z { String s = return '' }");
		helper.assertNoErrors(clazz);
	}
	
	public void testForwardReferenceInFieldInitializer_01() throws Exception {
		XtendClass clazz = clazz("class Z { String s = s }");
		helper.assertError(clazz, XbasePackage.Literals.XFEATURE_CALL, org.eclipse.xtext.xbase.validation.IssueCodes.ILLEGAL_FORWARD_REFERENCE);
	}
	
	public void testForwardReferenceInFieldInitializer_02() throws Exception {
		XtendClass clazz = clazz("class Z { String s1 = newArrayList(s2 + '').toString String s2 = '' }");
		helper.assertError(clazz, XbasePackage.Literals.XFEATURE_CALL, org.eclipse.xtext.xbase.validation.IssueCodes.ILLEGAL_FORWARD_REFERENCE);
	}
	
	public void testForwardReferenceInFieldInitializer_03() throws Exception {
		XtendClass clazz = clazz("class Z { static String s = s }");
		helper.assertError(clazz, XbasePackage.Literals.XFEATURE_CALL, org.eclipse.xtext.xbase.validation.IssueCodes.ILLEGAL_FORWARD_REFERENCE);
	}
	
	public void testForwardReferenceInFieldInitializer_04() throws Exception {
		XtendClass clazz = clazz("class Z { static String s1 = s2 static String s2 = '' }");
		helper.assertError(clazz, XbasePackage.Literals.XFEATURE_CALL, org.eclipse.xtext.xbase.validation.IssueCodes.ILLEGAL_FORWARD_REFERENCE);
	}

	public void testForwardReferenceInFieldInitializer_05() throws Exception {
		XtendClass clazz = clazz("class Z { String s = '' }");
		helper.assertNoErrors(clazz);
	}
	
	public void testForwardReferenceInFieldInitializer_06() throws Exception {
		XtendClass clazz = clazz("class Z { String s1 = '' String s2 = s1 }");
		helper.assertNoErrors(clazz);
	}
	
	public void testForwardReferenceInFieldInitializer_07() throws Exception {
		XtendClass clazz = clazz("class Z { static String s = '' }");
		helper.assertNoErrors(clazz);
	}
	
	public void testForwardReferenceInFieldInitializer_08() throws Exception {
		XtendClass clazz = clazz("class Z { static String s1 = '' static String s2 = s1 }");
		helper.assertNoErrors(clazz);
	}
	
	public void testCircularConstructor_01() throws Exception {
		XtendClass clazz = clazz("class Z { new() { this() }}");
		helper.assertError(clazz, XbasePackage.Literals.XFEATURE_CALL, org.eclipse.xtext.xbase.validation.IssueCodes.CIRCULAR_CONSTRUCTOR_INVOCATION);
	}
	
	public void testCircularConstructor_02() throws Exception {
		XtendClass clazz = clazz("class Z { new() { this(1) } new(int a) { this() } }");
		helper.assertError(clazz.getMembers().get(0), XbasePackage.Literals.XFEATURE_CALL, org.eclipse.xtext.xbase.validation.IssueCodes.CIRCULAR_CONSTRUCTOR_INVOCATION);
		helper.assertError(clazz.getMembers().get(1), XbasePackage.Literals.XFEATURE_CALL, org.eclipse.xtext.xbase.validation.IssueCodes.CIRCULAR_CONSTRUCTOR_INVOCATION);
	}
	
	public void testCircularConstructor_03() throws Exception {
		XtendClass clazz = clazz("class Z { new() { this(1) } new(int a) { super() } }");
		helper.assertNoErrors(clazz);
	}
	
	public void testConstructorCallIsFirst_01() throws Exception {
		XtendClass clazz = clazz("class Z { new() { super() } new(int a) { this() } }");
		helper.assertNoErrors(clazz);
	}
	
	public void testConstructorCallIsFirst_02() throws Exception {
		XtendClass clazz = clazz("class Z { new() { { this() } }}");
		helper.assertError(clazz, XbasePackage.Literals.XFEATURE_CALL, org.eclipse.xtext.xbase.validation.IssueCodes.INVALID_CONSTRUCTOR_INVOCATION);
	}
	
	public void testConstructorCallIsFirst_03() throws Exception {
		XtendClass clazz = clazz("class Z { new() { if (true) super() } }");
		helper.assertError(clazz, XbasePackage.Literals.XFEATURE_CALL, org.eclipse.xtext.xbase.validation.IssueCodes.INVALID_CONSTRUCTOR_INVOCATION);
	}
	
	public void testConstructorArgumentIsValid_01() throws Exception {
		XtendClass clazz = clazz("class Z { new() { this(1) } new(int i) {} }");
		helper.assertNoErrors(clazz);
	}
	
	public void testConstructorArgumentIsValid_02() throws Exception {
		XtendClass clazz = clazz("class Z { static int j new() { this(j) } new(int i) {} }");
		helper.assertNoErrors(clazz);
	}
	
	public void testConstructorArgumentIsValid_03() throws Exception {
		XtendClass clazz = clazz("class Z { int j new() { this(j) } new(int i) {} }");
		helper.assertError(clazz.getMembers().get(1), XbasePackage.Literals.XFEATURE_CALL, org.eclipse.xtext.xbase.validation.IssueCodes.INVALID_CONSTRUCTOR_ARGUMENT);
	}
	
	public void testConstructorArgumentIsValid_04() throws Exception {
		XtendClass clazz = clazz("class Z { new() { this(z()) } new(Object o) {} def z() { null } }");
		helper.assertError(clazz.getMembers().get(0), XbasePackage.Literals.XFEATURE_CALL, org.eclipse.xtext.xbase.validation.IssueCodes.INVALID_CONSTRUCTOR_ARGUMENT);
	}
	
	public void testConstructorArgumentIsValid_05() throws Exception {
		XtendClass clazz = clazz("class Z { new() { this(null as Object) } new(Object o) {} }");
		helper.assertNoErrors(clazz);
	}
	
	public void testConstructorArgumentIsValid_06() throws Exception {
		XtendClass clazz = clazz("class Z { new(Object o) { this(o as String) } new(String o) {} }");
		helper.assertNoErrors(clazz);
	}
	
	public void testConstructorArgumentIsValid_07() throws Exception {
		XtendClass clazz = clazz("class Z { new() { this(z()) } new(Object o) {} def static z() { null } }");
		helper.assertNoErrors(clazz);
	}
	
	public void testConstructorArgumentIsValid_08() throws Exception {
		XtendClass clazz = clazz("class Z { new() { this(z() as String) } new(Object o) {} def static z() { null } }");
		helper.assertNoErrors(clazz);
	}
	
	public void testConstructorArgumentIsValid_09() throws Exception {
		XtendClass clazz = clazz("class Z { new() { this(z() as String) } new(Object o) {} def z() { null } }");
		helper.assertError(clazz.getMembers().get(0), XbasePackage.Literals.XFEATURE_CALL, org.eclipse.xtext.xbase.validation.IssueCodes.INVALID_CONSTRUCTOR_ARGUMENT);
	}
	
	public void testConstructorArgumentIsValid_10() throws Exception {
		XtendClass clazz = clazz("class Z { new() { this(z().toString + '') } new(Object o) {} def static z() { null } }");
		helper.assertNoErrors(clazz);
	}
	
	public void testConstructorArgumentIsValid_11() throws Exception {
		XtendClass clazz = clazz("class Z { new() { this(z().toString + '') } new(Object o) {} def z() { null } }");
		helper.assertError(clazz.getMembers().get(0), XbasePackage.Literals.XFEATURE_CALL, org.eclipse.xtext.xbase.validation.IssueCodes.INVALID_CONSTRUCTOR_ARGUMENT);
	}
	
	public void testConstructorDuplicate() throws Exception {
		XtendClass clazz = clazz("class K { new(Object o) {} new(Object o) {} }");
		helper.assertError(clazz, Xtend2Package.Literals.XTEND_CONSTRUCTOR, IssueCodes.DUPLICATE_METHOD);
		helper.assertError(clazz, Xtend2Package.Literals.XTEND_CONSTRUCTOR, IssueCodes.DUPLICATE_METHOD);
	}
	
	public void testConstructorDuplicateErasure() throws Exception {
		XtendClass clazz = clazz("class K { new(List<Object> o) {} new(List<String> o) {} }");
		helper.assertError(clazz, Xtend2Package.Literals.XTEND_CONSTRUCTOR, IssueCodes.DUPLICATE_METHOD);
		helper.assertError(clazz, Xtend2Package.Literals.XTEND_CONSTRUCTOR, IssueCodes.DUPLICATE_METHOD);
	}

	public void testMissingConstructor() throws Exception {
		XtendClass clazz = clazz("class K extends test.NoDefaultConstructor {}");
		helper.assertError(clazz, Xtend2Package.Literals.XTEND_CLASS, IssueCodes.MISSING_CONSTRUCTOR);
	}
	
	public void testMissingSuperConstructorCall() throws Exception {
		XtendClass clazz = clazz("class K extends test.NoDefaultConstructor { new() {} }");
		helper.assertError(clazz, Xtend2Package.Literals.XTEND_CONSTRUCTOR, IssueCodes.MUST_INVOKE_SUPER_CONSTRUCTOR);
	}
	
	public void testSuperConstructorCall() throws Exception {
		XtendClass clazz = clazz("class K extends test.NoDefaultConstructor { new() { super('') } }");
		helper.assertNoErrors(clazz);
	}
	
	public void testReturnStatement() throws Exception {
		XtendClass clazz = clazz("class Z { def void foo() { return 'holla' }}");
		helper.assertError(clazz, XbasePackage.Literals.XRETURN_EXPRESSION, org.eclipse.xtext.xbase.validation.IssueCodes.INVALID_RETURN);
	}
	
	public void testReturnStatement1() throws Exception {
		XtendClass clazz = clazz("class Z { def Object foo() { return }}");
		helper.assertError(clazz, XbasePackage.Literals.XRETURN_EXPRESSION, org.eclipse.xtext.xbase.validation.IssueCodes.INVALID_RETURN);
	}
	
	public void testBug_357230() throws Exception {
		XtendClass clazz = clazz(
				"package x class Z {" +
				"  def dispatch _foo(Object x, boolean b) {}\n" +
				"  def dispatch _foo(String x, boolean b) {}\n" +
				"}\n");
		helper.assertError(clazz, Xtend2Package.Literals.XTEND_FUNCTION, IssueCodes.DISPATCH_FUNC_NAME_STARTS_WITH_UNDERSCORE);
	}
	
	public void testAnnotationTarget_00() throws Exception {
		XtendClass clazz = clazz("@testdata.Annotation2('foo') class X { }");
		helper.assertError(clazz, XAnnotationsPackage.Literals.XANNOTATION, IssueCodes.ANNOTATION_WRONG_TARGET, "@Annotation2");
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
		XtendClass clazz = clazz("class X { def foo(String this) { } }");
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
	
	public void testCreateMayNotBeStatic() throws Exception {
		XtendFunction function = function("def static create new Object() newObject() { }");
		helper.assertError(function, Xtend2Package.Literals.XTEND_FUNCTION, INVALID_USE_OF_STATIC, "not", "static");
	}
	
	public void testCreateExpressionMayNotReturnVoid_01() throws Exception {
		XtendFunction function = function("def create result: while(true){} illegal() { }");
		helper.assertError(function, Xtend2Package.Literals.XTEND_FUNCTION, INVALID_USE_OF_TYPE, "void", "create", "function", "illegal");
	}
	
	public void testCreateExpressionMayNotReturnVoid_02() throws Exception {
		XtendFunction function = function("def String create result: while(true){} illegal() { }");
		helper.assertError(function, XbasePackage.Literals.XWHILE_EXPRESSION, INCOMPATIBLE_RETURN_TYPE, "implicit", "return", "type", "void", "String");
	}

	public void testCreateExpressionMayNotReturnVoid_03() throws Exception {
		XtendFunction function = function("override create result: while(true){} toString() { }");
		helper.assertError(function, XbasePackage.Literals.XWHILE_EXPRESSION, INCOMPATIBLE_RETURN_TYPE, "implicit", "return", "type", "void", "String");
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
		XtendFunction function = function(
				  "def String foo(int bar) { " 
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
	
	public void testReturnTypeCompatibility_07() throws Exception {
		XtendClass clazz = clazz(
				"class Foo { " +
				"  def void a() {" +
				"    val closure = [Integer i| return i]\n" + 
				"    for (x : 1..100) closure.apply(x)" +
				"  }" +
				"}");
		helper.assertNoErrors(clazz);
	}
	
	public void testReturnTypeCompatibility_08() throws Exception {
		XtendClass clazz = clazz(
				"class Foo { " +
				"  def void a() {" +
				"    val closure = [Integer i| i]\n" + 
				"    for (x : 1..100) closure.apply(x)" +
				"  }" +
				"}");
		helper.assertNoErrors(clazz);
	}
	
	public void testReturnTypeCompatibility_09() throws Exception {
		XtendClass clazz = clazz(
				"class Foo { " +
				"  def void a() {" +
				"    val (Integer)=>Integer closure = [Integer i| return i]\n" + 
				"    for (x : 1..100) closure.apply(x)" +
				"  }" +
				"}");
		helper.assertNoErrors(clazz);
	}

	public void testReturnTypeCompatibility_10() throws Exception {
		XtendClass clazz = clazz(
				"class Foo { " +
				"  def a() {" +
				"    val closure = [Integer i| return i]\n" + 
				"    for (x : 1..100) closure.apply(x)" +
				"  }" +
				"}");
		helper.assertNoErrors(clazz);
	}
	
	public void testReturnTypeCompatibility_11() throws Exception {
		XtendClass clazz = clazz(
				"class Foo { " +
				"  def a() {" +
				"    val closure = [Integer i| i]\n" + 
				"    for (x : 1..100) closure.apply(x)" +
				"  }" +
				"}");
		helper.assertNoErrors(clazz);
	}
	
	public void testReturnTypeCompatibility_12() throws Exception {
		XtendClass clazz = clazz(
				"class Foo { " +
				"  def a() {" +
				"    val (Integer)=>Integer closure = [Integer i| return i]\n" + 
				"    for (x : 1..100) closure.apply(x)" +
				"  }" +
				"}");
		helper.assertNoErrors(clazz);
	}
	
	public void testThrowsClauseCompatibility_00() throws Exception {
		XtendClass clazz = clazz(
				"class Foo {" +
				"  def foo() {" +
				"    throw new Exception()" +
				"  }" +
				"}");
		helper.assertNoError(clazz, UNHANDLED_EXCEPTION);
//		helper.assertError(clazz, XbasePackage.Literals.XBLOCK_EXPRESSION, UNHANDLED_EXCEPTION, "unhandled", "exception");
	}
	
	public void testThrowsClauseCompatibility_01() throws Exception {
		XtendClass clazz = clazz(
				"class Foo {" +
				"  def foo() {" +
				"    throw new RuntimeException()" +
				"  }" +
				"}");
		helper.assertNoError(clazz, UNHANDLED_EXCEPTION);
	}
	
	public void testThrowsClauseCompatibility_02() throws Exception {
		XtendClass clazz = clazz(
				"class Foo {" +
				"  def foo() throws RuntimeException {" +
				"    throw new Exception()" +
				"  }" +
				"}");
		helper.assertNoError(clazz, UNHANDLED_EXCEPTION);
//		helper.assertError(clazz, XbasePackage.Literals.XBLOCK_EXPRESSION, UNHANDLED_EXCEPTION, "unhandled", "exception");
	}
	
	public void testThrowsClauseCompatibility_03() throws Exception {
		XtendClass clazz = clazz(
				"class Foo {" +
				"  def foo() throws Exception {" +
				"    throw new NoSuchFieldException()" +
				"  }" +
				"}");
		helper.assertNoError(clazz, UNHANDLED_EXCEPTION);
	}
	
	public void testThrowsClauseCompatibility_04() throws Exception {
		XtendClass clazz = clazz(
				"class Foo {" +
				"  def foo() {" +
				"    try {" +
				"      throw new NoSuchFieldException()" +
				"    } catch(NoSuchFieldException e) {" +
				"    }" +
				"  }" +
				"}");
		helper.assertNoError(clazz, UNHANDLED_EXCEPTION);
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
	
	public void testClassExtendsItself() throws Exception {
		XtendClass clazz = clazz("class Foo extends Foo {}");
		helper.assertError(clazz, Xtend2Package.Literals.XTEND_CLASS, CYCLIC_INHERITANCE, "hierarchy", "cycles");
	}
	
	public void testInheritanceCycle() throws Exception {
		Iterator<XtendFile> iter = files(false, 
				 "package test class Foo extends Bar {}"
				,"package test class Bar extends Baz {}"
				,"package test class Baz extends Foo {}").iterator();
		waitForAutoBuild();
		helper.assertError(iter.next(), Xtend2Package.Literals.XTEND_CLASS, CYCLIC_INHERITANCE, "hierarchy", "cycles");
		helper.assertError(iter.next(), Xtend2Package.Literals.XTEND_CLASS, CYCLIC_INHERITANCE, "hierarchy", "cycles");
		helper.assertError(iter.next(), Xtend2Package.Literals.XTEND_CLASS, CYCLIC_INHERITANCE, "hierarchy", "cycles");
	}
	
	public void testInheritanceCycle_1() throws Exception {
		Iterator<XtendFile> iter = files(false, 
				 "package test class Foo extends Bar {}"
				,"package test class Bar extends Foo {}").iterator();
		waitForAutoBuild();
		helper.assertError(iter.next(), Xtend2Package.Literals.XTEND_CLASS, CYCLIC_INHERITANCE, "hierarchy", "cycles");
		helper.assertError(iter.next(), Xtend2Package.Literals.XTEND_CLASS, CYCLIC_INHERITANCE, "hierarchy", "cycles");
	}
	
	public void testIgnoreInterfacesInCycleDetection() throws Exception {
		files(true, 
				 "package test class Foo extends Bar {}"
				,"package test class Bar extends Baz implements java.io.Serializable {}"
				,"package test class Baz implements java.io.Serializable {}");
	}

	public void testDuplicateFieldName() throws Exception {
		XtendClass clazz = clazz("class Foo { int foo String foo double foo }");
		for(XtendMember member: clazz.getMembers())
			helper.assertError(member, Xtend2Package.Literals.XTEND_FIELD, DUPLICATE_FIELD, "foo", "duplicate");
	}
	
	public void testDuplicateAnonymousExtension() throws Exception {
		XtendClass clazz = clazz("import com.google.inject.Inject class Foo { @Inject extension String @Inject extension String }");
		for(XtendMember member: clazz.getMembers())
			helper.assertError(member, Xtend2Package.Literals.XTEND_FIELD, DUPLICATE_FIELD, "duplicate", "same", "type");
	}
	
	public void testCaseFunctionNoParameters() throws Exception {
		XtendFunction function = function("def dispatch foo() { null }");
		helper.assertError(function, Xtend2Package.Literals.XTEND_FUNCTION, IssueCodes.DISPATCH_FUNC_WITHOUT_PARAMS);
	}

	public void testCaseFunctionWithTypeParams() throws Exception {
		XtendFunction function = function("def dispatch <T> foo(T s) { null }");
		helper.assertError(function, Xtend2Package.Literals.XTEND_FUNCTION, IssueCodes.DISPATCH_FUNC_WITH_TYPE_PARAMS);
	}

	public void testSingleCaseFunction() throws Exception {
		XtendFunction function = function("def dispatch foo(String s) { null }");
		helper.assertWarning(function, Xtend2Package.Literals.XTEND_FUNCTION, IssueCodes.SINGLE_DISPATCH_FUNCTION);
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
	
	public void testInaccessibleStaticMethod() throws Exception {
		XtendClass xtendClass = clazz("class Foo extends test.SuperClass { def foo() { privateStaticMethod() }}");
		helper.assertError(((XBlockExpression) ((XtendFunction) xtendClass.getMembers().get(0)).getExpression())
				.getExpressions().get(0), XbasePackage.Literals.XABSTRACT_FEATURE_CALL, FEATURE_NOT_VISIBLE, "Feature",
				"not", "visible");
	}

	//TODO fails since Object is explicitly extended.
//	public void testInaccessibleMethod2() throws Exception {
//		XtendClass xtendClass = clazz("class Foo { def foo() { val o = new Object() o.clone() }}");
//		helper.assertError(((XBlockExpression) ((XtendFunction) xtendClass.getMembers().get(0)).getExpression())
//				.getExpressions().get(1), XbasePackage.Literals.XABSTRACT_FEATURE_CALL, FEATURE_NOT_VISIBLE, "Feature",
//				"not", "visible");
//	}

	public void testDuplicateParameter() throws Exception {
		XtendFunction function = function("def foo(int x, int x) {null}");
		helper.assertError(function, Xtend2Package.Literals.XTEND_FUNCTION, DUPLICATE_PARAMETER_NAME, "duplicate", "x");
	}
	
	public void testDuplicateConstructorParameter() throws Exception {
		XtendConstructor constructor = constructor("new(int x, int x) {null}");
		helper.assertError(constructor, Xtend2Package.Literals.XTEND_CONSTRUCTOR, DUPLICATE_PARAMETER_NAME, "duplicate", "x");
	}
	
	public void testDuplicateParameter_CreateExtension_01() throws Exception {
		XtendFunction function = function("def create newArrayList foo(int it) {}");
		helper.assertError(function, Xtend2Package.Literals.CREATE_EXTENSION_INFO, DUPLICATE_PARAMETER_NAME, "duplicate", "implicit", "it");
		helper.assertError(function, Xtend2Package.Literals.XTEND_FUNCTION, DUPLICATE_PARAMETER_NAME, "duplicate", "it");
	}
	
	public void testDuplicateParameter_CreateExtension_02() throws Exception {
		XtendFunction function = function("def create result: newArrayList foo(int result) {}");
		helper.assertError(function, Xtend2Package.Literals.CREATE_EXTENSION_INFO, DUPLICATE_PARAMETER_NAME, "duplicate", "result");
		helper.assertError(function, Xtend2Package.Literals.XTEND_FUNCTION, DUPLICATE_PARAMETER_NAME, "duplicate", "result");
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
	
	public void testBug343088_01() throws Exception {
		XtendFunction function = function(
				"def <T extends Integer> (T,T)=>T addFunction() {\n" + 
				"    [T a,T b|a+(b as Integer)]\n" + 
				"}");
		helper.assertError(function, XbasePackage.Literals.XBLOCK_EXPRESSION, INCOMPATIBLE_RETURN_TYPE, "(T, T)=>T", "(T, T)=>int");
	}
	
	public void testBug343088_02() throws Exception {
		XtendFunction function = function(
				"def <T extends Integer> (T,T)=>T addFunction() {\n" + 
				"    [T a,T b|a+b]\n" + 
				"}");
		helper.assertError(function, XbasePackage.Literals.XBLOCK_EXPRESSION, INCOMPATIBLE_RETURN_TYPE, "(T, T)=>T", "(T, T)=>int");
	}
	
	public void testBug343088_03() throws Exception {
		XtendFunction function = function(
				"def <T extends Integer> (T,T)=>T addFunction() {\n" + 
				"    [T a,T b|(a+b) as T]\n" + 
				"}");
		helper.assertNoErrors(function);
	}
	
	public void testDispatchFunctionVisibility() throws Exception {
		XtendClass xtendClass = clazz("class Foo { def dispatch foo(String bar) {} def public dispatch foo(Object bar) {}}");
		helper.assertError(xtendClass.getMembers().get(0), Xtend2Package.Literals.XTEND_FUNCTION, DISPATCH_FUNCTIONS_WITH_DIFFERENT_VISIBILITY, 
				"local", "must", "same", "visibility");
	}
	
	public void testDispatchFunctionStatic1() throws Exception {
		XtendClass xtendClass = clazz("class Foo { def dispatch foo(String bar) {} def static dispatch foo(Object bar) {}}");
		helper.assertError(xtendClass.getMembers().get(0), Xtend2Package.Literals.XTEND_FUNCTION, DISPATCH_FUNCTIONS_MIXED_STATIC_AND_NON_STATIC, 
				"Static", "non-static", "not", "mixed");
	}
	
	public void testDispatchFunctionStatic2() throws Exception {
		Iterator<XtendFile> iter = files(false, 
				 "package test class Bar extends XXX { def dispatch foo(Boolean bar) {} def static dispatch foo(Double bar) {} }"
				,"package test class XXX { def static dispatch foo(String bar) {} def static dispatch foo(Float bar) {}}").iterator();
		waitForAutoBuild();
		helper.assertError(iter.next(), Xtend2Package.Literals.XTEND_FUNCTION, DISPATCH_FUNCTIONS_STATIC_EXPECTED, "must", "be", "static");
	}
	
	public void testDispatchFunctionStatic3() throws Exception {
		Iterator<XtendFile> iter = files(false, 
				"package test class Bar extends XXX { def dispatch foo(Boolean bar) {} def static dispatch foo(Double bar) {} }"
				,"package test class XXX { def dispatch foo(String bar) {} def dispatch foo(Float bar) {}}").iterator();
		waitForAutoBuild();
		helper.assertError(iter.next(), Xtend2Package.Literals.XTEND_FUNCTION, DISPATCH_FUNCTIONS_NON_STATIC_EXPECTED, "must", "not", "be", "static");
	}
	
//	public void testBug343096() throws Exception {
//		XtendFunction function = function(
//				"def <T> test() {\n" + 
//				"  [T t|switch t {\n" + 
//				"    case t:test\n" + 
//				"  }]\n" + 
//				"}");
//		helper.assertNoErrors(function);
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
	
	public void testImportUnused() throws Exception {
		XtendClass clazz = clazz("import java.util.List class X {}");
		helper.assertWarning(clazz.eContainer(), Xtend2Package.Literals.XTEND_IMPORT, IMPORT_UNUSED);
	}
	
	public void testImportUnused_1() throws Exception {
		XtendClass clazz = clazz("import java.util.List class X { private java.util.List sb }");
		helper.assertWarning(clazz.eContainer(), Xtend2Package.Literals.XTEND_IMPORT, IMPORT_UNUSED);
	}
	
	public void testImportUnused_2() throws Exception {
		XtendClass clazz = clazz("import java.util.List class X { private List sb def foo(){sb}}");
		helper.assertNoIssues(clazz.eContainer());
	}
	
	public void testImportUnused_3() throws Exception {
		XtendClass clazz = clazz("import java.util.Map$Entry class X { private Entry sb def foo(){sb}}");
		helper.assertNoIssues(clazz.eContainer());
	}
	
	public void testImportUnused_4() throws Exception {
		XtendClass clazz = clazz("import java.util.Map class X { private Map$Entry sb def foo(){sb}}");
		helper.assertNoIssues(clazz.eContainer());
	}
	
	public void testImportUnused_5() throws Exception {
		XtendClass clazz = clazz("import java.util.Map$Entry class X { private Map$Entry sb def foo(){sb}}");
		helper.assertNoIssues(clazz.eContainer());
	}
	
	public void testImportDuplicate() throws Exception {
		XtendClass clazz = clazz("import java.util.List import java.util.List class X { private List sb def foo(){sb}}");
		helper.assertWarning(clazz.eContainer(), Xtend2Package.Literals.XTEND_IMPORT, IMPORT_DUPLICATE);
	}
	
	public void testImportWildcard() throws Exception {
		XtendClass clazz = clazz("import java.util.* import java.util.List class X { private List sb def foo(){sb}}");
		helper.assertWarning(clazz.eContainer(), Xtend2Package.Literals.XTEND_IMPORT, IMPORT_WILDCARD_DEPRECATED);
	}
	
	public void testPrivateUnusedField() throws Exception {
		XtendClass clazz = clazz("import java.util.List class X { private List sb }");
		helper.assertWarning(clazz.eContainer(), Xtend2Package.Literals.XTEND_FIELD,FIELD_LOCALLY_NEVER_READ , "not");
	}
	
	public void testUnusedField() throws Exception {
		XtendClass clazz = clazz("import java.util.List class X { protected List foo public List bar}");
		helper.assertNoIssues(clazz.eContainer());
	}
	
	public void testUnusedFunction() throws Exception {
		XtendClass clazz = clazz("class X { def private foo(String a, Integer b) }");
		helper.assertWarning(clazz, Xtend2Package.Literals.XTEND_FUNCTION, FUNCTION_LOCALLY_NEVER_USED, "method","foo(String, Integer)","never", "used");
	}
	
	public void testUsedFunction() throws Exception {
		XtendClass clazz = clazz("class X { def private foo() def bar(){foo}}");
		helper.assertNoIssues(clazz.eContainer());
	}
	
	public void testUnusedDispatchFunction() throws Exception {
		XtendClass clazz = clazz("class X { def private dispatch foo(String a) def private dispatch foo(Integer a) }");
		helper.assertWarning(clazz, Xtend2Package.Literals.XTEND_FUNCTION, FUNCTION_LOCALLY_NEVER_USED, "method", "foo(Comparable<?>","never", "used");
	}
	
	public void testUsedDispatchFunction() throws Exception {
		XtendClass clazz = clazz("class X { def private dispatch foo(String a) def private dispatch foo(Integer a) def bar(){foo(42)}}");
		helper.assertNoIssues(clazz.eContainer());
	}
	
	public void testUsedMemberOfExtensionField() throws Exception {
		XtendClass clazz = clazz("class X { extension java.util.Collection def foo(){ add('42') }}");
		helper.assertNoIssues(clazz.eContainer());
	}
	
	public void testUnusedMemberOfExtensionField() throws Exception {
		XtendClass clazz = clazz("class X { extension java.util.Collection def foo(){  }}");
		helper.assertWarning(clazz, Xtend2Package.Literals.XTEND_FIELD,FIELD_LOCALLY_NEVER_READ , "not");
	}
	
	public void testUsedMemberOfExtensionFieldWithName() throws Exception {
		XtendClass clazz = clazz("class X { extension java.util.Collection bar def foo(){ add('42') }}");
		helper.assertNoIssues(clazz.eContainer());
	}
	
	public void testUsedMemberOfExtensionFieldWithName_2() throws Exception {
		XtendClass clazz = clazz("class X { extension java.util.Collection bar def foo(){ bar.add('42') }}");
		helper.assertNoIssues(clazz.eContainer());
	}
	
	public void testUnusedMemberOfExtensionFieldWithName() throws Exception {
		XtendClass clazz = clazz("class X { extension java.util.Collection bar def foo(){  }}");
		helper.assertWarning(clazz, Xtend2Package.Literals.XTEND_FIELD, FIELD_LOCALLY_NEVER_READ , "not");
	}
	
	public void testUnusedMemberOfExtensionField_No_False_Positive() throws Exception {
		XtendClass clazz = clazz("class X { extension java.util.Collection foo def bar(){  newArrayList.add('42') }}");
		helper.assertWarning(clazz, Xtend2Package.Literals.XTEND_FIELD,FIELD_LOCALLY_NEVER_READ , "not");
	}
	
	public void testConstructorThrownExceptionsOfTypeThrowable() throws Exception {
		XtendClass clazz = clazz("class X { new () throws Integer { }}");
		helper.assertError(clazz, Xtend2Package.Literals.XTEND_CONSTRUCTOR, EXCEPTION_NOT_THROWABLE, "No", "can", "subclass", "Throwable");
	}
	
	public void testFunctionThrownExceptionsOfTypeThrowable() throws Exception {
		XtendClass clazz = clazz("class X { def foo() throws Integer { } }");
		helper.assertError(clazz, Xtend2Package.Literals.XTEND_FUNCTION, EXCEPTION_NOT_THROWABLE, "No", "can", "subclass", "Throwable");
	}
	
	public void testExceptionsDeclaredTwiceOnConstructor() throws Exception {
		XtendClass clazz = clazz("import java.io.IOException class X { new () throws IOException, IOException { }}");
		helper.assertError(clazz, Xtend2Package.Literals.XTEND_CONSTRUCTOR, EXCEPTION_DECLARED_TWICE, "Exception", "declared", "twice");
	}
	
	public void testExceptionsNotDeclaredTwiceOnConstructor() throws Exception {
		XtendClass clazz = clazz("import java.io.IOException class X { new () throws IOException, NullPointerException { }}");
		helper.assertNoIssues(clazz);
	}
	
	public void testExceptionsDeclaredTwiceOnFunction() throws Exception {
		XtendClass clazz = clazz("import java.io.IOException class X {def foo() throws IOException, IOException { }}");
		helper.assertError(clazz, Xtend2Package.Literals.XTEND_FUNCTION, EXCEPTION_DECLARED_TWICE, "Exception", "declared", "twice");
	}
	
	public void testExceptionsNotDeclaredTwiceOnFunction() throws Exception {
		XtendClass clazz = clazz("import java.io.IOException class X {def foo() throws IOException, NullPointerException { }}");
		helper.assertNoIssues(clazz);
	}
}
