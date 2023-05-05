/**
 * Copyright (c) 2018, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.validation;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.validation.IssueCodes;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class JUnitMethodReturnTypeValidationTest extends AbstractXtendTestCase {
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;

  @Inject
  @Extension
  private ParseHelper<XtendFile> _parseHelper;

  @Test
  public void test001() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def test() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasNoValidationIssue(_builder);
  }

  @Test
  public void test002() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def int test() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasNoValidationIssue(_builder);
  }

  @Test
  public void test003() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.junit.Test");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Test def void test() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasNoValidationIssue(_builder);
  }

  @Test
  public void test004() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.junit.Test");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Test def test() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasNoValidationIssue(_builder);
  }

  @Test
  public void test005() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.junit.Before");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Before def void before() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasNoValidationIssue(_builder);
  }

  @Test
  public void test006() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.junit.Before");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Before def before() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasNoValidationIssue(_builder);
  }

  @Test
  public void test007() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.junit.After");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@After def void after() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasNoValidationIssue(_builder);
  }

  @Test
  public void test008() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.junit.After");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@After def after() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasNoValidationIssue(_builder);
  }

  @Test
  public void test009() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.junit.BeforeClass");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@BeforeClass def static void beforeClass() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasNoValidationIssue(_builder);
  }

  @Test
  public void test010() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.junit.BeforeClass");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@BeforeClass def static beforeClass() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasNoValidationIssue(_builder);
  }

  @Test
  public void test011() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.junit.AfterClass");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@AfterClass def static void afterClass() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasNoValidationIssue(_builder);
  }

  @Test
  public void test012() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.junit.AfterClass");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@AfterClass def static afterClass() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasNoValidationIssue(_builder);
  }

  @Test
  public void test013() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.junit.Test");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Test def int test() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasOneValidationIssue(_builder, "JUnit method test() must be void but is int.");
  }

  @Test
  public void test014() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.junit.Test");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Test def m() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasOneValidationIssue(_builder, "JUnit method m() must be void but is int.");
  }

  @Test
  public void test015() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.junit.Test");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Test def Object test() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("\"foo\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasOneValidationIssue(_builder, "JUnit method test() must be void but is Object.");
  }

  @Test
  public void test016() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.junit.Test");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Test def test() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasOneValidationIssue(_builder, "JUnit method test() must be void but is Object.");
  }

  @Test
  public void test017() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.junit.Before");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Before def int before() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasOneValidationIssue(_builder, "JUnit method before() must be void but is int.");
  }

  @Test
  public void test018() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.junit.Before");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Before def before() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasOneValidationIssue(_builder, "JUnit method before() must be void but is int.");
  }

  @Test
  public void test019() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.junit.Before");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Before def Object before() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("\"foo\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasOneValidationIssue(_builder, "JUnit method before() must be void but is Object.");
  }

  @Test
  public void test020() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.junit.Before");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Before def before() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasOneValidationIssue(_builder, "JUnit method before() must be void but is Object.");
  }

  @Test
  public void test021() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.junit.After");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@After def int after() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasOneValidationIssue(_builder, "JUnit method after() must be void but is int.");
  }

  @Test
  public void test022() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.junit.After");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@After def after() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasOneValidationIssue(_builder, "JUnit method after() must be void but is int.");
  }

  @Test
  public void test023() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.junit.After");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@After def Object after() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("\"foo\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasOneValidationIssue(_builder, "JUnit method after() must be void but is Object.");
  }

  @Test
  public void test024() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.junit.After");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@After def after() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasOneValidationIssue(_builder, "JUnit method after() must be void but is Object.");
  }

  @Test
  public void test025() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.junit.BeforeClass");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@BeforeClass def static int beforeClass() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasOneValidationIssue(_builder, "JUnit method beforeClass() must be void but is int.");
  }

  @Test
  public void test026() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.junit.BeforeClass");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@BeforeClass def static beforeClass() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasOneValidationIssue(_builder, "JUnit method beforeClass() must be void but is int.");
  }

  @Test
  public void test027() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.junit.BeforeClass");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@BeforeClass def static Object beforeClass() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("\"foo\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasOneValidationIssue(_builder, "JUnit method beforeClass() must be void but is Object.");
  }

  @Test
  public void test028() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.junit.BeforeClass");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@BeforeClass def static beforeClass() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasOneValidationIssue(_builder, "JUnit method beforeClass() must be void but is Object.");
  }

  @Test
  public void test029() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.junit.AfterClass");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@AfterClass def static int afterClass() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasOneValidationIssue(_builder, "JUnit method afterClass() must be void but is int.");
  }

  @Test
  public void test030() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.junit.AfterClass");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@AfterClass def static afterClass() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasOneValidationIssue(_builder, "JUnit method afterClass() must be void but is int.");
  }

  @Test
  public void test031() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.junit.AfterClass");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@AfterClass def static Object afterClass() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("\"foo\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasOneValidationIssue(_builder, "JUnit method afterClass() must be void but is Object.");
  }

  @Test
  public void test032() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.junit.AfterClass");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@AfterClass def static afterClass() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasOneValidationIssue(_builder, "JUnit method afterClass() must be void but is Object.");
  }

  @Test
  public void test033() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.junit.Test");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Test def test() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("foo");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasOneValidationIssue(_builder, XbasePackage.Literals.XFEATURE_CALL, Diagnostic.LINKING_DIAGNOSTIC, "The method or field foo is undefined");
  }

  private void hasNoValidationIssue(final CharSequence it) {
    this.assertNumberOfValidationIssues(it, 0);
  }

  private void hasOneValidationIssue(final CharSequence it, final String message) {
    this.hasOneValidationIssue(it, XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.INVALID_RETURN_TYPE_IN_CASE_OF_JUNIT_ANNOTATION, message);
  }

  private void hasOneValidationIssue(final CharSequence it, final EClass objectType, final String issueCode, final String message) {
    this._validationTestHelper.assertError(this.assertNumberOfValidationIssues(it, 1), objectType, issueCode, message);
  }

  private XtendFile assertNumberOfValidationIssues(final CharSequence it, final int expectedNumberOfIssues) {
    try {
      XtendFile _xblockexpression = null;
      {
        final XtendFile xtendFile = this._parseHelper.parse(it);
        Assert.assertEquals(expectedNumberOfIssues, this._validationTestHelper.validate(xtendFile).size());
        _xblockexpression = xtendFile;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
