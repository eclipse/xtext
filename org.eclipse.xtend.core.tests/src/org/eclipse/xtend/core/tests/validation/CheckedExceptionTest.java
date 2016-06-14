/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.validation;

import static org.eclipse.xtext.xbase.XbasePackage.Literals.*;
import static org.eclipse.xtext.xbase.validation.IssueCodes.*;

import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.validation.IssueCodes;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.preferences.IPreferenceValuesProvider.SingletonPreferenceValuesProvider;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.xbase.XbasePackage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 * @author Sebastian Zarnekow - Include feature calls in exception analysis
 */
public class CheckedExceptionTest extends AbstractXtendTestCase {

	@Inject
	protected ValidationTestHelper helper;
	
	protected MapBasedPreferenceValues preferences;
	
	@Inject
	public void setPreferences(SingletonPreferenceValuesProvider prefProvider) {
		preferences = prefProvider.getPreferenceValues(null);
	}
	
	@Before
	public void setSeverity() {
		preferences.put(UNHANDLED_EXCEPTION, "error");
	}
	
	@After
	public void clearPreferences() {
		preferences.clear();
	}
	
	@Test public void testExceptionInMethod() throws Exception {
		XtendFile file = file("class foo { def bar() { throw new Exception() }}");
		helper.assertError(file, XTHROW_EXPRESSION, UNHANDLED_EXCEPTION, "Unhandled exception type Exception");
	}
	
	@Test public void testExceptionInMethod_1() throws Exception {
		XtendFile file = file("class foo { def bar() throws Exception { throw new Exception() }}");
		helper.assertNoError(file, UNHANDLED_EXCEPTION);
	}
	
	@Test public void testExceptionInMethod_2() throws Exception {
		XtendFile file = file("class foo { def bar() throws RuntimeException, Exception { throw new Exception() }}");
		helper.assertNoError(file, UNHANDLED_EXCEPTION);
	}
	
	@Test public void testExceptionInConstructor() throws Exception {
		XtendFile file = file("class foo { new() { throw new Exception() }}");
		helper.assertError(file, XTHROW_EXPRESSION, UNHANDLED_EXCEPTION);
	}
	
	@Test public void testExceptionInConstructor_1() throws Exception {
		XtendFile file = file("class foo { new() throws Exception { throw new Exception() }}");
		helper.assertNoError(file, UNHANDLED_EXCEPTION);
	}
	
	@Test public void testExceptionInConstructor_2() throws Exception {
		XtendFile file = file("class foo { new() throws RuntimeException, Exception { throw new Exception() }}");
		helper.assertNoError(file, UNHANDLED_EXCEPTION);
	}
	
	@Test public void testExceptionInConstructor_3() throws Exception {
		XtendFile file = file("class foo { new() { throw new Error() }}");
		helper.assertNoError(file, UNHANDLED_EXCEPTION);
	}
	
	@Test public void testFeatureCall_01() throws Exception {
		XtendFile file = file("class C { def void m() {} def void n() { m() } }");
		helper.assertNoErrors(file);
	}
	
	@Test public void testFeatureCall_02() throws Exception {
		XtendFile file = file("class C { def void m() throws RuntimeException {} def void n() { m() } }");
		helper.assertNoErrors(file);
	}
	
	@Test public void testFeatureCall_03() throws Exception {
		XtendFile file = file("class C { def void m() throws String {} def void n() { m() } }");
		helper.assertNoError(file, UNHANDLED_EXCEPTION);
		helper.assertError(file, XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.EXCEPTION_NOT_THROWABLE,
				"No exception of type String can be thrown; an exception type must be a subclass of Throwable");
	}
	
	@Test public void testFeatureCall_04() throws Exception {
		XtendFile file = file("class C { def void m() throws DoesNotExist {} def void n() { m() } }");
		helper.assertNoError(file, UNHANDLED_EXCEPTION);
		helper.assertNoError(file, IssueCodes.EXCEPTION_NOT_THROWABLE);
	}
	
	@Test public void testFeatureCall_05() throws Exception {
		XtendFile file = file("class C { def void m() throws java.io.IOException {} def void n() { m() } }");
		helper.assertError(file, XbasePackage.Literals.XFEATURE_CALL, UNHANDLED_EXCEPTION, "Unhandled exception type IOException");
	}
	
	@Test public void testFeatureCall_06() throws Exception {
		XtendFile file = file("class C { def void m() throws java.io.IOException, java.net.URISyntaxException {} def void n() { m() } }");
		helper.assertError(file, XbasePackage.Literals.XFEATURE_CALL, UNHANDLED_EXCEPTION, "Unhandled exception types IOException and URISyntaxException");
	}
	
	@Test public void testFeatureCall_07() throws Exception {
		XtendFile file = file("class C { def void m() throws java.io.IOException, java.net.URISyntaxException, java.rmi.RemoteException {} def void n() { m() } }");
		helper.assertError(file, XbasePackage.Literals.XFEATURE_CALL, UNHANDLED_EXCEPTION, "Unhandled exception types IOException, URISyntaxException and RemoteException");
	}
	
	@Test public void testFeatureCall_08() throws Exception {
		XtendFile file = file("class C { def void m() throws java.io.IOException, java.net.URISyntaxException {} def void n() { try { m() } catch(java.net.URISyntaxException e) {} } }");
		helper.assertError(file, XbasePackage.Literals.XFEATURE_CALL, UNHANDLED_EXCEPTION, "Unhandled exception type IOException");
	}
	
	@Test public void testFeatureCall_09() throws Exception {
		XtendFile file = file("class C { def void m() throws Error {} def void n() { m() } }");
		helper.assertNoError(file, UNHANDLED_EXCEPTION);
	}
	
	@Test public void testGenericFeatureCall_01() throws Exception {
		XtendFile file = file("class C { def <E extends RuntimeException> void m() throws E {} def void n() { m() } }");
		helper.assertNoErrors(file);
	}
	
	@Test public void testGenericFeatureCall_02() throws Exception {
		XtendFile file = file("class C { def <E extends String> void m() throws E {} def void n() { m() } }");
		helper.assertNoError(file, UNHANDLED_EXCEPTION);
		helper.assertError(file, XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.EXCEPTION_NOT_THROWABLE,
				"No exception of type E can be thrown; an exception type must be a subclass of Throwable");
	}
	
	@Test public void testGenericFeatureCall_03() throws Exception {
		XtendFile file = file("class C { def <E extends DoesNotExist> void m() throws E {} def void n() { m() } }");
		helper.assertNoError(file, UNHANDLED_EXCEPTION);
		helper.assertError(file, XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.EXCEPTION_NOT_THROWABLE,
				"No exception of type E can be thrown; an exception type must be a subclass of Throwable");
	}
	
	@Test public void testGenericFeatureCall_04() throws Exception {
		XtendFile file = file("class C { def <E extends java.io.IOException> void m() throws E {} def void n() { m() } }");
		helper.assertError(file, XbasePackage.Literals.XFEATURE_CALL, UNHANDLED_EXCEPTION, "Unhandled exception type IOException");
	}
	
	@Test public void testGenericFeatureCall_05() throws Exception {
		XtendFile file = file("class C { def <E extends java.io.IOException> void m() throws E {} def void n() { <java.io.FileNotFoundException>m() } }");
		helper.assertError(file, XbasePackage.Literals.XFEATURE_CALL, UNHANDLED_EXCEPTION, "Unhandled exception type FileNotFoundException");
	}
	
	@Test public void testGenericFeatureCall_06() throws Exception {
		XtendFile file = file("class C { def <E extends Exception> void m(Class<E> c) throws E {} def void n() { m(typeof(RuntimeException)) } }");
		helper.assertNoError(file, UNHANDLED_EXCEPTION);
	}
	
	@Test public void testGenericFeatureCall_07() throws Exception {
		XtendFile file = file("class C { def <E extends Exception> void m(Class<E> c) throws E {} def void n() { m(typeof(java.io.IOException)) } }");
		helper.assertError(file, XbasePackage.Literals.XFEATURE_CALL, UNHANDLED_EXCEPTION, "Unhandled exception type IOException");
	}
	
	@Test public void testGenericFeatureCall_08() throws Exception {
		XtendFile file = file(
				"class C { " +
				"  def <E extends Exception> void m(Class<? extends E> c1, Class<? extends E> c2) throws E {}" +
				"  def void n() { m(typeof(java.io.FileNotFoundException), typeof(java.io.CharConversionException)) } " +
				"}");
		helper.assertError(file, XbasePackage.Literals.XFEATURE_CALL, UNHANDLED_EXCEPTION, "Unhandled exception type IOException");
	}
	
	@Test public void testGenericFeatureCall_09() throws Exception {
		XtendFile file = file(
				"class C { " +
				"  def <E extends Exception> E m() throws E {}" +
				"  def java.io.FileNotFoundException n() { return m } " +
				"}");
		helper.assertError(file, XbasePackage.Literals.XFEATURE_CALL, UNHANDLED_EXCEPTION, "Unhandled exception type FileNotFoundException");
	}
	
	@Test public void testGenericFeatureCall_10() throws Exception {
		XtendFile file = file(
				"class C { " +
				"  def <E extends Exception> E m() throws E {}" +
				"  def java.io.FileNotFoundException n() { m } " +
				"}");
		helper.assertError(file, XbasePackage.Literals.XFEATURE_CALL, UNHANDLED_EXCEPTION, "Unhandled exception type FileNotFoundException");
	}

	@Test public void testGenericFeatureCall_11() throws Exception {
		XtendFile file = file(
				"class C { " +
				"  def <E extends Exception> void m(Class<? extends E> c1, Class<? extends E> c2) throws E {}" +
				"  def void n() throws java.io.IOException { m(typeof(java.io.FileNotFoundException), typeof(java.io.CharConversionException)) } " +
				"}");
		helper.assertNoError(file, UNHANDLED_EXCEPTION);
	}
	
	@Test public void testGenericFeatureCall_12() throws Exception {
		XtendFile file = file(
				"class C { " +
				"  def <E extends Error> E m() throws E {}" +
				"  def java.io.FileNotFoundException n() { m } " +
				"}");
		helper.assertNoError(file, UNHANDLED_EXCEPTION);
	}
	
	@Test public void testDelegateConstructorCall_01() throws Exception {
		XtendFile file = file("class C { new() throws RuntimeException {} new(int i) { this() } }");
		helper.assertNoErrors(file);
	}
	
	@Test public void testDelegateConstructorCall_02() throws Exception {
		XtendFile file = file("class C { new() throws Exception {} new(int i) { this() } }");
		helper.assertError(file, XbasePackage.Literals.XFEATURE_CALL, UNHANDLED_EXCEPTION, "Unhandled exception type Exception");
	}
	
	@Test public void testDelegateGenericConstructorCall_01() throws Exception {
		XtendFile file = file("class C<X extends RuntimeException> { new() throws X {} new(int i) { this() } }");
		helper.assertNoErrors(file);
	}
	
	@Test public void testDelegateGenericConstructorCall_02() throws Exception {
		XtendFile file = file("class C<X extends Exception> { new() throws X {} new(int i) { this() } }");
		helper.assertError(file, XbasePackage.Literals.XFEATURE_CALL, UNHANDLED_EXCEPTION, "Unhandled exception type X");
	}
	
	@Test public void testConstructorCall_01() throws Exception {
		XtendFile file = file("class C { new() throws RuntimeException {} def void m() { new C } }");
		helper.assertNoErrors(file);
	}
	
	@Test public void testConstructorCall_02() throws Exception {
		XtendFile file = file("class C { new() throws Exception {} def void m() { new C } }");
		helper.assertError(file, XbasePackage.Literals.XCONSTRUCTOR_CALL, UNHANDLED_EXCEPTION, "Unhandled exception type Exception");
	}
	
	@Test public void testGenericConstructorCall_01() throws Exception {
		XtendFile file = file("class C<X extends RuntimeException> { new() throws X {} def void m() { new C } }");
		helper.assertNoErrors(file);
	}
	
	@Test public void testGenericConstructorCall_02() throws Exception {
		XtendFile file = file("class C<X extends Exception> { new() throws X {} def m() { new C } }");
		helper.assertError(file, XbasePackage.Literals.XCONSTRUCTOR_CALL, UNHANDLED_EXCEPTION, "Unhandled exception type Exception");
	}
	
	@Test public void testGenericConstructorCall_03() throws Exception {
		XtendFile file = file("class C<X extends java.io.IOException> { new() throws X {} def void m() { new C } }");
		helper.assertError(file, XbasePackage.Literals.XCONSTRUCTOR_CALL, UNHANDLED_EXCEPTION, "Unhandled exception type IOException");
	}
	
}
