/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.validation;

import static org.eclipse.xtend.core.xtend.XtendPackage.Literals.*;
import static org.eclipse.xtext.xbase.XbasePackage.Literals.*;
import static org.eclipse.xtext.xbase.validation.IssueCodes.*;

import org.eclipse.xtend.core.tests.NewTypeSystemRuntimeInjectorProvider;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.preferences.IPreferenceValuesProvider;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(NewTypeSystemRuntimeInjectorProvider.class)
public class XtendValidationTest2 extends XtendValidationTest {
	
	private MapBasedPreferenceValues preferences;
	
	/**
	 * we assume a
	 * {@link org.eclipse.xtext.preferences.IPreferenceValuesProvider.SingletonPreferenceValuesProvider}
	 * is bound.
	 */
	@Inject
	public void setPreferences(IPreferenceValuesProvider prefProvider) {
		preferences = (MapBasedPreferenceValues) prefProvider.getPreferenceValues(null);
	}
	
	@Before
	public void setUp() {
		preferences.clear();
	}

	@Override
	@Test
	public void testInaccessibleMethod2() throws Exception {
		super.testInaccessibleMethod2();
	}
	
	@Test
	public void testInaccessibleMethod3() throws Exception {
		XtendClass xtendClass = clazz("class Foo { def foo() { val o = new Object() clone() }}");
		helper.assertNoErrors(xtendClass);
	}
	
	@Test
	public void testInaccessibleMethod4() throws Exception {
		XtendClass xtendClass = clazz("class Foo { def foo() { val o = new Object() this.clone super.clone }}");
		helper.assertNoErrors(xtendClass);
	}
	
	@Test
	public void testInaccessibleMethod5() throws Exception {
		XtendClass xtendClass = clazz("package java.lang class Foo { def foo() { val o = new Object() o.clone }}");
		helper.assertNoErrors(xtendClass);
	}
	
	@Override
	@Test 
	public void testBug343096() throws Exception {
		XtendFunction function = function(
				"def <T> test() {\n" + 
				"  [T t|switch t {\n" + 
				"    case t:test\n" + 
				"  }]\n" + 
				"}");
		helper.assertNoErrors(function);
		helper.assertWarning(function, XTEND_FUNCTION, TOO_LITTLE_TYPE_INFORMATION, "recursive", "'Object'");
	}
	
	@Override
	@Test public void testShadowingVariableNames_00() throws Exception {
		XtendClass clazz = clazz("class X { def foo() { val this = 'foo' } }");
		helper.assertError(clazz, XVARIABLE_DECLARATION, VARIABLE_NAME_DISALLOWED);
	}
	
	@Override
	@Test public void testShadowingVariableNames_01() throws Exception {
		XtendClass clazz = clazz("class X { def foo() { val ^super = 'foo' } }");
		helper.assertError(clazz, XVARIABLE_DECLARATION, VARIABLE_NAME_DISALLOWED);
	}
	
	@Override
	@Test public void testShadowingVariableNames_03() throws Exception {
		XtendClass clazz = clazz("class X { def foo(String this) { } }");
		helper.assertError(clazz, XTEND_PARAMETER, VARIABLE_NAME_DISALLOWED);
	}
	
	@Override
	@Test public void testRichStringIfPredicate() throws Exception {
		assertNoConformanceError("'''«IF Boolean::FALSE»«ENDIF»'''");
		assertNoConformanceError("'''«IF true»«ENDIF»'''");
		assertNoConformanceError("'''«IF 1 == 1»«ENDIF»'''");
		assertConformanceError("'''«IF 1»«ENDIF»'''", XNUMBER_LITERAL, "int", "boolean", "Boolean");
	}
	
	@Override
	@Test public void testRichStringForLoop() throws Exception {
		assertNoConformanceError("'''«FOR i: 1..10»«ENDFOR»'''");
		assertNoConformanceError("'''«FOR i: 1..10 BEFORE 'a' SEPARATOR 1 AFTER true»«ENDFOR»'''");
		assertConformanceError(
				"'''«FOR i: 1..10 BEFORE while(true) null SEPARATOR 'b' AFTER 'c'»«ENDFOR»'''", 
				XWHILE_EXPRESSION, "Unexpected type primitive void");
		assertConformanceError(
				"'''«FOR i: 1..10 BEFORE 'a' SEPARATOR while(true) null AFTER 'c'»«ENDFOR»'''", 
				XWHILE_EXPRESSION, "Unexpected type primitive void");
		assertConformanceError(
				"'''«FOR i: 1..10 BEFORE 'a' SEPARATOR null AFTER while(true) null»«ENDFOR»'''", 
				XWHILE_EXPRESSION, "Unexpected type primitive void");
	}
	
	@Override
	@Test public void testBug386659() throws Exception {
    	XtendFile file  = file(
    			"class foo {\n" +
    			"  def <T> T genericMethod(T t) {\n" +
    			"    return t\n" +
    			"  }\n" +
    			"  def test() {\n" +
    			"    genericMethod(return null)" +
    			"  }\n" +
    			"}");
    	helper.assertError(file, XFEATURE_CALL, UNREACHABLE_CODE);
    }
	
	@Test public void testBug386659_02() throws Exception {
    	XtendFile file  = file(
    			"class foo {\n" +
    			"  def <T> T genericMethod(T t, int i) {\n" +
    			"    return t\n" +
    			"  }\n" +
    			"  def Object test() {\n" +
    			"    genericMethod(return null, 1)" +
    			"  }\n" +
    			"}");
    	helper.assertError(file, XNUMBER_LITERAL, UNREACHABLE_CODE);
    }
	
	@Test
	public void testExceptionInMethod() throws Exception {
		preferences.put(UNHANDLED_EXCEPTION, "error");
		XtendFile file = file("class foo { def bar() { throw new Exception() }}");
		helper.assertError(file, XTHROW_EXPRESSION, UNHANDLED_EXCEPTION);
	}
	
	@Test
	public void testExceptionInMethod_1() throws Exception {
		preferences.put(UNHANDLED_EXCEPTION, "error");
		XtendFile file = file("class foo { def bar() throws Exception { throw new Exception() }}");
		helper.assertNoError(file, UNHANDLED_EXCEPTION);
	}
	
	@Test
	public void testExceptionInMethod_2() throws Exception {
		preferences.put(UNHANDLED_EXCEPTION, "error");
		XtendFile file = file("class foo { def bar() throws RuntimeException, Exception { throw new Exception() }}");
		helper.assertNoError(file, UNHANDLED_EXCEPTION);
	}
	
	@Test
	public void testExceptionInConstructor() throws Exception {
		preferences.put(UNHANDLED_EXCEPTION, "error");
		XtendFile file = file("class foo { new() { throw new Exception() }}");
		helper.assertError(file, XTHROW_EXPRESSION, UNHANDLED_EXCEPTION);
	}
	
	@Test
	public void testExceptionInConstructor_1() throws Exception {
		preferences.put(UNHANDLED_EXCEPTION, "error");
		XtendFile file = file("class foo { new() throws Exception { throw new Exception() }}");
		helper.assertNoError(file, UNHANDLED_EXCEPTION);
	}
	
	@Test
	public void testExceptionInConstructor_2() throws Exception {
		preferences.put(UNHANDLED_EXCEPTION, "error");
		XtendFile file = file("class foo { new() throws RuntimeException, Exception { throw new Exception() }}");
		helper.assertNoError(file, UNHANDLED_EXCEPTION);
	}

	@Test
	public void testExceptionInMethodIgnored() throws Exception {
		XtendFile file = file("class foo { def bar() { throw new Exception() }}");
		helper.assertNoError(file, UNHANDLED_EXCEPTION);
	}
	
}
