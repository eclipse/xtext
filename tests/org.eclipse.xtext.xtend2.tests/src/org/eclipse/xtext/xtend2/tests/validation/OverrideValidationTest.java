/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.tests.validation;

import static org.eclipse.xtext.xtend2.validation.IssueCodes.*;
import static org.eclipse.xtext.xtend2.xtend2.Xtend2Package.Literals.*;

import org.eclipse.xtext.junit.validation.ValidationTestHelper;
import org.eclipse.xtext.xtend2.tests.AbstractXtend2TestCase;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class OverrideValidationTest extends AbstractXtend2TestCase {

	@Inject
	private ValidationTestHelper helper;

	public void testDuplicateMethod_0() throws Exception {
		XtendClass xtendClass = clazz("class Foo { bar(int x) {true} bar(int x) {false} }");
		helper.assertError(xtendClass.getMembers().get(0), XTEND_FUNCTION, DUPLICATE_METHOD, "duplicate");
	}

	public void testDuplicateMethod_1() throws Exception {
		XtendClass xtendClass = clazz("class Foo { bar(String x) {true} bar(int x) {false} }");
		helper.assertNoError(xtendClass, DUPLICATE_METHOD);
	}

	public void testDuplicateMethod_2() throws Exception {
		XtendClass xtendClass = clazz("class Foo { bar(String x) {true} bar(String x, int x) {false} }");
		helper.assertNoError(xtendClass, DUPLICATE_METHOD);
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
		XtendClass xtendClass = clazz("class Foo extends test.SuperClass { string() {null} }");
		helper.assertError(xtendClass.getMembers().get(0), XTEND_FUNCTION, MISSING_OVERRIDE);
	}

	public void testMissingOverride_1() throws Exception {
		XtendClass xtendClass = clazz("class Foo extends test.SuperClass { string(int i) { null} }");
		helper.assertNoError(xtendClass.getMembers().get(0), MISSING_OVERRIDE);
	}

	public void testMissingOverride_2() throws Exception {
		XtendClass xtendClass = clazz("class Foo extends test.SuperClass { string(String s) {null} }");
		helper.assertError(xtendClass.getMembers().get(0), XTEND_FUNCTION, MISSING_OVERRIDE);
	}

	public void testMissingOverride_3() throws Exception {
		XtendClass xtendClass = clazz("class Foo extends test.SuperClass { object(String s) {null} }");
		helper.assertNoError(xtendClass.getMembers().get(0), MISSING_OVERRIDE);
	}

	public void testIncompatibleReturnType_0() throws Exception {
		XtendClass xtendClass = clazz("class Foo extends test.SuperClass { override Boolean string() {true} }");
		helper.assertError(xtendClass.getMembers().get(0), XTEND_FUNCTION, INCOMPATIBLE_RETURN_TYPE);
	}

	public void testIncompatibleReturnType_1() throws Exception {
		XtendClass xtendClass = clazz("class Foo extends test.SuperClass { override String object() {''} }");
		helper.assertNoError(xtendClass.getMembers().get(0), INCOMPATIBLE_RETURN_TYPE);
	}

	public void testIncompatibleGenericReturnType_0() throws Exception {
		XtendClass xtendClass = clazz("class Foo extends test.SuperClass { override java.util.ArrayList<String> returnsListString() {''} }");
		helper.assertNoError(xtendClass.getMembers().get(0), INCOMPATIBLE_RETURN_TYPE);
	}

	public void testIncompatibleGenericReturnType_1() throws Exception {
		XtendClass xtendClass = clazz("class Foo extends test.SuperClass { override java.util.List<Object> returnsListString() {''} }");
		helper.assertError(xtendClass.getMembers().get(0), XTEND_FUNCTION, INCOMPATIBLE_RETURN_TYPE);
	}

	public void testIncompatibleGenericReturnType_2() throws Exception {
		XtendClass xtendClass = clazz("class Foo extends test.SuperClass { override java.util.ArrayList<String> returnsListExtendsObject() {''} }");
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
		helper.assertError(xtendClass.getMembers().get(0), XTEND_FUNCTION, INCOMPATIBLE_RETURN_TYPE);
	}

	public void testOverrideWithTypeParameter_1() throws Exception {
		XtendClass xtendClass = clazz("class Foo extends test.GenericClass<String> { override java.util.List<String> foo() {newArrayList} }");
		helper.assertNoError(xtendClass.getMembers().get(0), INCOMPATIBLE_RETURN_TYPE);
	}

	public void testOverrideWithTypeParameter_2() throws Exception {
		XtendClass xtendClass = clazz("class Foo<S> extends test.GenericClass<S> { override java.util.List<S> foo() {null} }");
		helper.assertNoError(xtendClass.getMembers().get(0), INCOMPATIBLE_RETURN_TYPE);
	}

}
