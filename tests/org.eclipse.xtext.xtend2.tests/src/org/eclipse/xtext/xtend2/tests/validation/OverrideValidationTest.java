/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.tests.validation;

import static org.eclipse.xtext.xtend2.validation.IssueCodes.*;
import static org.eclipse.xtext.xbase.validation.IssueCodes.*;
import static org.eclipse.xtext.xtend2.xtend2.Xtend2Package.Literals.*;

import org.eclipse.xtext.junit.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xtend2.tests.AbstractXtend2TestCase;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class OverrideValidationTest extends AbstractXtend2TestCase {

	@Inject
	private ValidationTestHelper helper;
	
	//TODO override declarations in interfaces

	public void testDuplicateMethod_0() throws Exception {
		XtendClass xtendClass = clazz("class Foo { def bar(int x) {true} def bar(int x) {false} }");
		helper.assertError(xtendClass.getMembers().get(0), XTEND_FUNCTION, DUPLICATE_METHOD, "duplicate");
	}

	public void testDuplicateMethod_1() throws Exception {
		XtendClass xtendClass = clazz("class Foo { def bar(String x) {true} def bar(int x) {false} }");
		helper.assertNoError(xtendClass, DUPLICATE_METHOD);
	}

	public void testDuplicateMethod_2() throws Exception {
		XtendClass xtendClass = clazz("class Foo { def bar(String x) {true} def bar(String x, int x) {false} }");
		helper.assertNoError(xtendClass, DUPLICATE_METHOD);
	}
	
	public void testDuplicateMethod_3() throws Exception {
		XtendClass xtendClass = clazz("class Foo { def bar(java.util.List<String> x) {true} def bar(java.util.List<Integer> x) {false} }");
		helper.assertError(xtendClass.getMembers().get(0), XTEND_FUNCTION, DUPLICATE_METHOD, "erasure", "List)", "List<String");
		helper.assertError(xtendClass.getMembers().get(1), XTEND_FUNCTION, DUPLICATE_METHOD, "erasure", "List)", "List<Integer");
	}

	public void testObsoleteOverride_0() throws Exception {
		XtendClass xtendClass = clazz("class Foo { override bar() {true} }");
		helper.assertError(xtendClass.getMembers().get(0), XTEND_FUNCTION, OBSOLETE_OVERRIDE);
	}

	public void testObsoleteOverride_1() throws Exception {
		XtendClass xtendClass = clazz("class Foo extends test.SuperClass { override bar() {true} }");
		helper.assertError(xtendClass.getMembers().get(0), XTEND_FUNCTION, OBSOLETE_OVERRIDE);
	}

	public void testObsoleteOverride_2() throws Exception {
		XtendClass xtendClass = clazz("class Foo extends test.SuperClass { override privateMethod() {true}}");
		helper.assertError(xtendClass.getMembers().get(0), XTEND_FUNCTION, OBSOLETE_OVERRIDE);
	}

	public void testMissingOverride_0() throws Exception {
		XtendClass xtendClass = clazz("class Foo extends test.SuperClass { def string() {null} }");
		helper.assertError(xtendClass.getMembers().get(0), XTEND_FUNCTION, MISSING_OVERRIDE);
	}

	public void testMissingOverride_1() throws Exception {
		XtendClass xtendClass = clazz("class Foo extends test.SuperClass { def string(int i) { null} }");
		helper.assertNoError(xtendClass.getMembers().get(0), MISSING_OVERRIDE);
	}

	public void testMissingOverride_2() throws Exception {
		XtendClass xtendClass = clazz("class Foo extends test.SuperClass { def string(String s) {null} }");
		helper.assertError(xtendClass.getMembers().get(0), XTEND_FUNCTION, MISSING_OVERRIDE);
	}

	public void testMissingOverride_3() throws Exception {
		XtendClass xtendClass = clazz("class Foo extends test.SuperClass { def object(String s) {null} }");
		helper.assertNoError(xtendClass.getMembers().get(0), MISSING_OVERRIDE);
	}

	public void testMissingOverride_4() throws Exception {
		XtendClass xtendClass = clazz("class Foo implements test.SomeInterface { def foo() { true } }");
		helper.assertError(xtendClass.getMembers().get(0), XTEND_FUNCTION, MISSING_OVERRIDE);
	}
	
	public void testMissingOverride_5() throws Exception {
		XtendClass xtendClass = clazz("class Foo { def boolean equals(Object x) { return true } }");
		helper.assertError(xtendClass.getMembers().get(0), XTEND_FUNCTION, MISSING_OVERRIDE);
	}

	public void testIncompatibleReturnType_0() throws Exception {
		XtendClass xtendClass = clazz("class Foo extends test.SuperClass { override Boolean string() {true} }");
		helper.assertError(xtendClass.getMembers().get(0), XTEND_FUNCTION, INCOMPATIBLE_RETURN_TYPE);
	}

	public void testIncompatibleReturnType_1() throws Exception {
		XtendClass xtendClass = clazz("class Foo extends test.SuperClass { override String object() {''} }");
		helper.assertNoError(xtendClass.getMembers().get(0), INCOMPATIBLE_RETURN_TYPE);
	}
	
	public void testIncompatibleReturnType_2() throws Exception {
		XtendClass xtendClass = clazz("class Foo implements test.SomeInterface { def foo() {} }");
		helper.assertError(xtendClass.getMembers().get(0), XbasePackage.Literals.XBLOCK_EXPRESSION, INCOMPATIBLE_RETURN_TYPE);
	}

	public void testIncompatibleGenericReturnType_0() throws Exception {
		XtendClass xtendClass = clazz("class Foo extends test.SuperClass { override java.util.ArrayList<String> returnsListString() {} }");
		helper.assertNoError(xtendClass.getMembers().get(0), INCOMPATIBLE_RETURN_TYPE);
	}

	public void testIncompatibleGenericReturnType_1() throws Exception {
		XtendClass xtendClass = clazz("class Foo extends test.SuperClass { override java.util.List<Object> returnsListString() {} }");
		helper.assertError(xtendClass.getMembers().get(0), XTEND_FUNCTION, INCOMPATIBLE_RETURN_TYPE);
	}

	public void testIncompatibleGenericReturnType_2() throws Exception {
		XtendClass xtendClass = clazz("class Foo extends test.SuperClass { override java.util.ArrayList<String> returnsListExtendsObject() {} }");
		helper.assertNoError(xtendClass.getMembers().get(0), INCOMPATIBLE_RETURN_TYPE);
	}
	
	public void testOverrideVoidFunction() throws Exception {
		XtendClass xtendClass = clazz("class Foo extends test.SuperClass { override voidFunction() {''} }");
		helper.assertNoError(xtendClass.getMembers().get(0), INCOMPATIBLE_RETURN_TYPE);
	}

	public void testOverrideVoidFunction_1() throws Exception {
		XtendClass xtendClass = clazz("class Foo extends test.SuperClass { override String voidFunction() {''} }");
		helper.assertError(xtendClass.getMembers().get(0), XTEND_FUNCTION, INCOMPATIBLE_RETURN_TYPE);
	}
	
	public void testOverrideWithTypeParameter() throws Exception {
		XtendClass xtendClass = clazz("class Foo extends test.GenericClass { override java.util.List<String> foo() {newArrayList} }");
		helper.assertNoError(xtendClass.getMembers().get(0), INCOMPATIBLE_RETURN_TYPE);
	}
	
	public void testOverrideWithTypeParameter_1() throws Exception {
		XtendClass xtendClass = clazz("class Foo extends test.GenericClass<String> { override java.util.List<String> foo() {newArrayList} }");
		helper.assertNoError(xtendClass.getMembers().get(0), INCOMPATIBLE_RETURN_TYPE);
	}

	public void testOverrideWithTypeParameter_2() throws Exception {
		XtendClass xtendClass = clazz("class Foo<S> extends test.GenericClass<S> { override java.util.List<S> foo() {null} }");
		helper.assertNoError(xtendClass.getMembers().get(0), INCOMPATIBLE_RETURN_TYPE);
	}

	public void testClassMustBeAbstract() throws Exception {
		XtendClass xtendClass = clazz("class Foo<S> implements Comparable<S> { }");
		helper.assertError(xtendClass, XTEND_CLASS, CLASS_MUST_BE_ABSTRACT, "abstract", "not", "implement");
	}
	
	public void testOverrideFinalClass() throws Exception {
		XtendClass xtendClass = clazz("class Foo extends String { }");
		helper.assertError(xtendClass, XTEND_CLASS, OVERRIDDEN_FINAL, "override", "final");		
	}
	
	public void testOverrideFinalMethod() throws Exception {
		XtendClass xtendClass = clazz("class Foo extends test.ClassWithFinalMembers { def foo() {} }");
		helper.assertError(xtendClass.getMembers().get(0), XTEND_FUNCTION, OVERRIDDEN_FINAL, "override", "final");		
	}
	
}
