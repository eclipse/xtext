/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.validation;

import static org.eclipse.xtend.core.validation.IssueCodes.*;
import static org.eclipse.xtend.core.xtend.XtendPackage.Literals.*;

import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.validation.IssueCodes;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.preferences.IPreferenceValuesProvider.SingletonPreferenceValuesProvider;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Stefan Oehme - Initial contribution and API
 */
public class CodeStyleValidationTest extends AbstractXtendTestCase {

	@Inject
	protected ValidationTestHelper helper;
	
	private MapBasedPreferenceValues preferences;
	
	@Inject
	public void setPreferences(SingletonPreferenceValuesProvider prefProvider) {
		preferences = prefProvider.getPreferenceValues(null);
	}
	
	@Before
	public void setSeverity() {
		preferences.put(IssueCodes.API_TYPE_INFERENCE, "error");
	}
	
	@After
	public void clearPreferences() {
		preferences.clear();
	}
	
	@Test public void testInferedApiMethod01() throws Exception {
		XtendFunction function = function("def m() { \"foo\" }");
		helper.assertError(function, XTEND_FUNCTION, API_TYPE_INFERENCE);
	}
	
	@Test public void testInferedApiMethod02() throws Exception {
		XtendFile file = file("class A {"
				+ "protected def m() { \"foo\" }"
				+ "}");
		helper.assertError(file, XTEND_FUNCTION, API_TYPE_INFERENCE);
	}
	
	@Test public void testInferedApiMethod03() throws Exception {
		XtendFile file = file("final class A {"
				+ "protected def m() { \"foo\" }"
				+ "}");
		helper.assertNoIssues(file);
	}
	@Test public void testInferedApiMethod04() throws Exception {
		XtendFile file = file("package class A {"
				+ "protected def m() { \"foo\" }"
				+ "}");
		helper.assertNoIssues(file);
	}
	
	@Test public void testInferedApiMethod05() throws Exception {
		XtendFunction function = function("private def m() { \"foo\" }");
		helper.assertNoIssue(function, XTEND_FUNCTION, API_TYPE_INFERENCE);
	}

	@Test public void testInferedApiMethod06() throws Exception {
		XtendFile file = file("class A {"
				+ "protected class B {"
				+ "protected def m() { \"foo\" }"
				+ "}"
				+ "}");
		helper.assertError(file, XTEND_FUNCTION, API_TYPE_INFERENCE);
	}
	
	@Test public void testInferedApiField01() throws Exception {
		XtendField field = field("public val f = \"foo\" ");
		helper.assertError(field, XTEND_FIELD, API_TYPE_INFERENCE);
	}
	
	@Test public void testInferedApiField02() throws Exception {
		XtendFile file = file("class A {"
				+ "protected val f = \"foo\" "
				+ "}");
		helper.assertError(file, XTEND_FIELD, API_TYPE_INFERENCE);
	}
	
	@Test public void testInferedApiField03() throws Exception {
		XtendFile file = file("final class A {"
				+ "protected val f = \"foo\" "
				+ "}");
		helper.assertNoIssues(file);
	}
	
	@Test public void testInferedApiField04() throws Exception {
		XtendFile file = file("package class A {"
				+ "protected val f = \"foo\" "
				+ "}");
		helper.assertNoIssues(file);
	}
	
	@Test public void testInferedApiField05() throws Exception {
		XtendField field = field("val f = \"foo\" ");
		helper.assertNoIssue(field, XTEND_FIELD, API_TYPE_INFERENCE);
	}

	@Test public void testInferedApiField06() throws Exception {
		XtendFile file = file("class A {"
				+ "protected class B {"
				+ "protected val f = \"foo\" "
				+ "}"
				+ "}");
		helper.assertError(file, XTEND_FIELD, API_TYPE_INFERENCE);
	}
	
	@Test public void testInferedApiField07() throws Exception {
		XtendField field = field("public val f");
		helper.assertNoIssue(field, XTEND_FIELD, API_TYPE_INFERENCE);
	}
	
	@Test public void testNoImplicitReturnForVoidMethods() throws Exception {
		preferences.put(IssueCodes.IMPLICIT_RETURN, "error");
		XtendFunction method = function("def m() {println(1)}");
		helper.assertNoIssue(method, XTEND_FUNCTION, IMPLICIT_RETURN);
	}
	
	@Test public void testNoImplicitReturnForVoidMethods2() throws Exception {
		preferences.put(IssueCodes.IMPLICIT_RETURN, "error");
		XtendFunction method = function("def void m(int x) {this.x = x}");
		helper.assertNoIssue(method, XTEND_FUNCTION, IMPLICIT_RETURN);
	}
}
