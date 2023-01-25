/*******************************************************************************
 * Copyright (c) 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.validation;

import static org.eclipse.xtext.xbase.validation.IssueCodes.*;

import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XbasePackage;
import org.junit.Test;

import com.google.inject.Inject;

/** Test the write accesses to local variables and fields.
*
* @author Stephane Galland - Initial contribution and API
* @since 2.14
* @see "https://github.com/eclipse/xtext-extras/pull/232"
*/
public class VariableReadTest extends AbstractXtendTestCase {
	@Inject
	protected ValidationTestHelper helper;

	@Test
	public void test000() throws Exception {
		XtendClass clazz = clazz(
				  "class C1 {"
				+ "  def int fct() {"
				+ "    val f = 1"
				+ "    1"
				+ "  }"
				+ "}");
		helper.assertWarning(clazz,
				XbasePackage.eINSTANCE.getXVariableDeclaration(),
				UNUSED_LOCAL_VARIABLE,
				"variable f");
	}

	@Test
	public void test001() throws Exception {
		XtendClass clazz = clazz(
				  "class C1 {"
				+ "  def int fct() {"
				+ "    var f = 1"
				+ "    1"
				+ "  }"
				+ "}");
		helper.assertWarning(clazz,
				XbasePackage.eINSTANCE.getXVariableDeclaration(),
				UNUSED_LOCAL_VARIABLE,
				"variable f");
	}

	@Test
	public void test002() throws Exception {
		XtendClass clazz = clazz(
				  "class C1 {"
				+ "  def void fct() {"
				+ "    var int f"
				+ "    f = 2"
				+ "  }"
				+ "}");
		helper.assertWarning(clazz,
				XbasePackage.eINSTANCE.getXVariableDeclaration(),
				UNUSED_LOCAL_VARIABLE,
				"variable f");
	}

	@Test
	public void test003() throws Exception {
		XtendClass clazz = clazz(
				  "class C1 {"
				+ "  def int fct() {"
				+ "    var f = 1"
				+ "    var x = f"
				+ "    return x"
				+ "  }"
				+ "}");
		helper.assertNoIssues(clazz);
	}

	@Test
	public void test004() throws Exception {
		XtendClass clazz = clazz(
				  "class C1 {"
				+ "  def void fct() {"
				+ "    var f = 1"
				+ "    f = f + 1"
				+ "  }"
				+ "}");
		helper.assertNoIssues(clazz);
	}

	@Test
	public void test005() throws Exception {
		XtendClass clazz = clazz(
				  "class C1 {"
				+ "  def void fct() {"
				+ "    var f = 1"
				+ "    fct2(f)"
				+ "  }"
				+ "  def void fct2(int p) {"
				+ "  }"
				+ "}");
		helper.assertNoIssues(clazz);
	}

	@Test
	public void test006() throws Exception {
		XtendClass clazz = clazz(
				  "class C1 {"
				+ "  def void fct() {"
				+ "    var f = 1"
				+ "    for (i : 1..f) { }"
				+ "  }"
				+ "}");
		helper.assertNoIssues(clazz);
	}

}