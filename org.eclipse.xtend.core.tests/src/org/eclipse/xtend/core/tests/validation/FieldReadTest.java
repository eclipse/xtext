/*******************************************************************************
 * Copyright (c) 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.validation;

import static org.eclipse.xtend.core.validation.IssueCodes.*;

import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;

import com.google.inject.Inject;

/** Test the read accesses to local variables and fields.
*
* @author Stephane Galland - Initial contribution and API
* @since 2.14
* @see "https://github.com/eclipse/xtext-extras/pull/232"
*/
public class FieldReadTest extends AbstractXtendTestCase {

	@Inject
	protected ValidationTestHelper helper;

	@Test
	public void test000() throws Exception {
		XtendClass clazz = clazz(
				  "class C1 {"
				+ "  val int f = 1"
				+ "}");
		helper.assertWarning(clazz,
				XtendPackage.eINSTANCE.getXtendField(),
				UNUSED_PRIVATE_MEMBER,
				"field C1.f");
	}

	@Test
	public void test001() throws Exception {
		XtendClass clazz = clazz(
				  "class C1 {"
				+ "  var int f = 1"
				+ "}");
		helper.assertWarning(clazz,
				XtendPackage.eINSTANCE.getXtendField(),
				UNUSED_PRIVATE_MEMBER,
				"field C1.f");
	}

	@Test
	public void test002() throws Exception {
		XtendClass clazz = clazz(
				  "class C1 {"
				+ "  var int f = 1"
				+ "  def void fct() {"
				+ "    f = 2"
				+ "  }"
				+ "}");
		helper.assertWarning(clazz,
				XtendPackage.eINSTANCE.getXtendField(),
				UNUSED_PRIVATE_MEMBER,
				"field C1.f");
	}

	@Test
	public void test003() throws Exception {
		XtendClass clazz = clazz(
				  "class C1 {"
				+ "  var int f = 1"
				+ "  def int fct() {"
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
				+ "  var int f = 1"
				+ "  def void fct() {"
				+ "    f = f + 1"
				+ "  }"
				+ "}");
		helper.assertNoIssues(clazz);
	}

	@Test
	public void test005() throws Exception {
		XtendClass clazz = clazz(
				  "class C1 {"
				+ "  var int f = 1"
				+ "  def void fct() {"
				+ "    this.f = 2"
				+ "  }"
				+ "}");
		helper.assertWarning(clazz,
				XtendPackage.eINSTANCE.getXtendField(),
				UNUSED_PRIVATE_MEMBER,
				"field C1.f");
	}

	@Test
	public void test006() throws Exception {
		XtendClass clazz = clazz(
				  "class C1 {"
				+ "  var int f = 1"
				+ "  def int fct() {"
				+ "    var x = this.f"
				+ "    return x"
				+ "  }"
				+ "}");
		helper.assertNoIssues(clazz);
	}

	@Test
	public void test007() throws Exception {
		XtendClass clazz = clazz(
				  "class C1 {"
				+ "  var int f = 1"
				+ "  def void fct() {"
				+ "    this.f = this.f + 1"
				+ "  }"
				+ "}");
		helper.assertNoIssues(clazz);
	}

	@Test
	public void test008() throws Exception {
		XtendClass clazz = clazz(
				  "class C1 {"
				+ "  var int f = 1"
				+ "  def void fct() {"
				+ "    fct2(this.f)"
				+ "  }"
				+ "  def void fct2(int p) {"
				+ "  }"
				+ "}");
		helper.assertNoIssues(clazz);
	}

	@Test
	public void test009() throws Exception {
		XtendClass clazz = clazz(
				  "class C1 {"
				+ "  var int f = 1"
				+ "  def void fct() {"
				+ "    for (i : 1..f) { }"
				+ "  }"
				+ "}");
		helper.assertNoIssues(clazz);
	}

	@Test
	public void test010() throws Exception {
		XtendClass clazz = clazz(
				  "class C1 {"
				+ "  var C11 x"
				+ "  def C11 fct() {"
				+ "    return this.x"
				+ "  }"
				+ "  static class C11 {"
				+ "    var int f = 1"
				+ "  }"
				+ "}");
		helper.assertWarning(clazz,
				XtendPackage.eINSTANCE.getXtendField(),
				UNUSED_PRIVATE_MEMBER,
				"field C11.f");
	}

	@Test
	public void test011() throws Exception {
		XtendClass clazz = clazz(
				  "class C1 {"
				+ "  var C11 x"
				+ "  def void fct() {"
				+ "    this.x.f = 4"
				+ "  }"
				+ "  static class C11 {"
				+ "    var int f = 1"
				+ "  }"
				+ "}");
		helper.assertWarning(clazz,
				XtendPackage.eINSTANCE.getXtendField(),
				UNUSED_PRIVATE_MEMBER,
				"field C11.f");
	}

	@Test
	public void test012() throws Exception {
		XtendClass clazz = clazz(
				  "class C1 {"
				+ "  var C11 x"
				+ "  def int fct() {"
				+ "    return this.x.f"
				+ "  }"
				+ "  static class C11 {"
				+ "    var int f = 1"
				+ "  }"
				+ "}");
		helper.assertNoIssues(clazz);
	}

	@Test
	public void test013() throws Exception {
		XtendClass clazz = clazz(
				  "class C1 {"
				+ "  var C11 x"
				+ "  def int fct() {"
				+ "    this.x.f = (this.x.f ** 3) as int"
				+ "  }"
				+ "  static class C11 {"
				+ "    var int f = 1"
				+ "  }"
				+ "}");
		helper.assertNoIssues(clazz);
	}

	@Test
	public void test014() throws Exception {
		XtendClass clazz = clazz(
				  "class C1 {"
				+ "  var C11 x"
				+ "  def int fct(int p) {"
				+ "    if (this.x !== null) {"
				+ "      switch (p) {"
				+ "      case 1 : { return this.x.f }"
				+ "      default: { }"
				+ "      }"
				+ "    }"
				+ "    return 0"
				+ "  }"
				+ "  static class C11 {"
				+ "    var int f = 1"
				+ "  }"
				+ "}");
		helper.assertNoIssues(clazz);
	}

	@Test
	public void test015() throws Exception {
		XtendClass clazz = clazz(
				  "class C1 {"
				+ "  def int fct() {"
				+ "    return xx().f"
				+ "  }"
				+ "  def C11 xx() {"
				+ "    null"
				+ "  }"
				+ "  static class C11 {"
				+ "    var int f = 1"
				+ "  }"
				+ "}");
		helper.assertNoIssues(clazz);
	}

	@Test
	public void test016() throws Exception {
		XtendClass clazz = clazz(
				  "class C1 {"
				+ "  def int fct(String x) {"
				+ "    return (x + 35).f"
				+ "  }"
				+ "  def C11 operator_plus(String a, int b) {"
				+ "    null"
				+ "  }"
				+ "  static class C11 {"
				+ "    var int f = 1"
				+ "  }"
				+ "}");
		helper.assertNoIssues(clazz);
	}

	@Test
	public void test017() throws Exception {
		XtendClass clazz = clazz(
				  "class C1 {"
				+ "  protected val int f = 1"
				+ "}");
		helper.assertNoIssues(clazz);
	}

	@Test
	public void test018() throws Exception {
		XtendClass clazz = clazz(
				  "class C1 {"
				+ "  protected var int f = 1"
				+ "}");
		helper.assertNoIssues(clazz);
	}

	@Test
	public void test019() throws Exception {
		XtendClass clazz = clazz(
				  "class C1 {"
				+ "  protected var int f = 1"
				+ "  def void fct() {"
				+ "    f = 2"
				+ "  }"
				+ "}");
		helper.assertNoIssues(clazz);
	}

	@Test
	public void test020() throws Exception {
		XtendClass clazz = clazz(
				  "class C1 {"
				+ "  protected var int f = 1"
				+ "  def int fct() {"
				+ "    var x = f"
				+ "    return x"
				+ "  }"
				+ "}");
		helper.assertNoIssues(clazz);
	}

	@Test
	public void test021() throws Exception {
		XtendClass clazz = clazz(
				  "class C1 {"
				+ "  protected var int f = 1"
				+ "  def void fct() {"
				+ "    f = f + 1"
				+ "  }"
				+ "}");
		helper.assertNoIssues(clazz);
	}

	@Test
	public void test022() throws Exception {
		XtendClass clazz = clazz(
				  "class C1 {"
				+ "  protected var int f = 1"
				+ "  def void fct() {"
				+ "    this.f = 2"
				+ "  }"
				+ "}");
		helper.assertNoIssues(clazz);
	}

	@Test
	public void test023() throws Exception {
		XtendClass clazz = clazz(
				  "class C1 {"
				+ "  protected var int f = 1"
				+ "  def int fct() {"
				+ "    var x = this.f"
				+ "    return x"
				+ "  }"
				+ "}");
		helper.assertNoIssues(clazz);
	}

	@Test
	public void test024() throws Exception {
		XtendClass clazz = clazz(
				  "class C1 {"
				+ "  protected var int f = 1"
				+ "  def void fct() {"
				+ "    this.f = this.f + 1"
				+ "  }"
				+ "}");
		helper.assertNoIssues(clazz);
	}

	@Test
	public void test025() throws Exception {
		XtendClass clazz = clazz(
				  "class C1 {"
				+ "  protected var int f = 1"
				+ "  def void fct() {"
				+ "    fct2(this.f)"
				+ "  }"
				+ "  def void fct2(int p) {"
				+ "  }"
				+ "}");
		helper.assertNoIssues(clazz);
	}

	@Test
	public void test026() throws Exception {
		XtendClass clazz = clazz(
				  "class C1 {"
				+ "  protected var int f = 1"
				+ "  def void fct() {"
				+ "    for (i : 1..f) { }"
				+ "  }"
				+ "}");
		helper.assertNoIssues(clazz);
	}

	@Test
	public void test027() throws Exception {
		XtendClass clazz = clazz(
				  "class C1 {"
				+ "  var C11 x"
				+ "  def C11 fct() {"
				+ "    return this.x"
				+ "  }"
				+ "  static class C11 {"
				+ "    protected var int f = 1"
				+ "  }"
				+ "}");
		helper.assertNoIssues(clazz);
	}

	@Test
	public void test028() throws Exception {
		XtendClass clazz = clazz(
				  "class C1 {"
				+ "  var C11 x"
				+ "  def void fct() {"
				+ "    this.x.f = 4"
				+ "  }"
				+ "  static class C11 {"
				+ "    protected var int f = 1"
				+ "  }"
				+ "}");
		helper.assertNoIssues(clazz);
	}

	@Test
	public void test029() throws Exception {
		XtendClass clazz = clazz(
				  "class C1 {"
				+ "  var C11 x"
				+ "  def int fct() {"
				+ "    return this.x.f"
				+ "  }"
				+ "  static class C11 {"
				+ "    protected var int f = 1"
				+ "  }"
				+ "}");
		helper.assertNoIssues(clazz);
	}

	@Test
	public void test0130() throws Exception {
		XtendClass clazz = clazz(
				  "class C1 {"
				+ "  var C11 x"
				+ "  def int fct() {"
				+ "    this.x.f = (this.x.f ** 3) as int"
				+ "  }"
				+ "  static class C11 {"
				+ "    protected var int f = 1"
				+ "  }"
				+ "}");
		helper.assertNoIssues(clazz);
	}

	@Test
	public void test031() throws Exception {
		XtendClass clazz = clazz(
				  "class C1 {"
				+ "  var C11 x"
				+ "  def int fct(int p) {"
				+ "    if (this.x !== null) {"
				+ "      switch (p) {"
				+ "      case 1 : { return this.x.f }"
				+ "      default: { }"
				+ "      }"
				+ "    }"
				+ "    return 0"
				+ "  }"
				+ "  static class C11 {"
				+ "    protected var int f = 1"
				+ "  }"
				+ "}");
		helper.assertNoIssues(clazz);
	}

	@Test
	public void test032() throws Exception {
		XtendClass clazz = clazz(
				  "class C1 {"
				+ "  def int fct() {"
				+ "    return xx().f"
				+ "  }"
				+ "  def C11 xx() {"
				+ "    null"
				+ "  }"
				+ "  static class C11 {"
				+ "    protected var int f = 1"
				+ "  }"
				+ "}");
		helper.assertNoIssues(clazz);
	}

	@Test
	public void test033() throws Exception {
		XtendClass clazz = clazz(
				  "class C1 {"
				+ "  def int fct(String x) {"
				+ "    return (x + 35).f"
				+ "  }"
				+ "  def C11 operator_plus(String a, int b) {"
				+ "    null"
				+ "  }"
				+ "  static class C11 {"
				+ "    protected var int f = 1"
				+ "  }"
				+ "}");
		helper.assertNoIssues(clazz);
	}

}