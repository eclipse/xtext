/**
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.validation;

import com.google.inject.Inject;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.validation.IssueCodes;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class AnonymousClassValidationTest extends AbstractXtendTestCase {
  @Inject
  @Extension
  private ParseHelper<XtendFile> _parseHelper;

  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;

  @Test
  public void testBug447125() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def m() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("var String s = \'\'");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new D(s) {}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class D {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new(String s) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoIssues(this._parseHelper.parse(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void test_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def m() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("C.this.toString");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoIssues(this._parseHelper.parse(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void test_02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def m() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("C.super.toString");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoIssues(this._parseHelper.parse(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void test_03() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def m() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("String.this.toString");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertError(this._parseHelper.parse(_builder), XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.NO_ENCLOSING_INSTANCE_AVAILABLE, "No enclosing instance of the type String is accessible in scope");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void test_04() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def m() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("String.super.toString");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertError(this._parseHelper.parse(_builder), XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.NO_ENCLOSING_INSTANCE_AVAILABLE, "No enclosing instance of the type String is accessible in scope");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void test_05() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def m() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Object { def void m() { C.this.toString } }");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoIssues(this._parseHelper.parse(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void test_06() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def m() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Object { def void m() { C.super.toString } }");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoIssues(this._parseHelper.parse(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void test_07() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def m() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Object { def void m() { Object.this.toString } }");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertError(this._parseHelper.parse(_builder), XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.NO_ENCLOSING_INSTANCE_AVAILABLE, "No enclosing instance of the type Object is accessible in scope");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void test_08() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def m() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Object { def void m() { Object.super.toString } }");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertError(this._parseHelper.parse(_builder), XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.NO_ENCLOSING_INSTANCE_AVAILABLE, "No enclosing instance of the type Object is accessible in scope");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void test_09() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def m() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("var x = \'\'");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val f = new Runnable() {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("override run() { x.toString }");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertError(this._parseHelper.parse(_builder), XbasePackage.Literals.XFEATURE_CALL, IssueCodes.INVALID_MUTABLE_VARIABLE_ACCESS, "Cannot refer to the non-final variable x inside a local class");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void test_10() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def m() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val x = \'\'");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Runnable() {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("override run() { x.toString }");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoIssues(this._parseHelper.parse(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testBug436248_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Bar {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public val r = new Runnable() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("override run() {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("println(x)");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public val x = 1");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoIssues(this._parseHelper.parse(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testInvalidSuper() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Bar {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public val r = new Runnable() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("override run() {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("[| super.toString ].apply");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertError(this._parseHelper.parse(_builder), XbasePackage.Literals.XFEATURE_CALL, IssueCodes.INVALID_SUPER_CALL, "Cannot call super of an anonymous class from a lambda expression");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testExtensions_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Test {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def getRunnable() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("var extension Util u = null");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Runnable {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("override run() {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("sayHello");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("static class Util {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("def sayHello() {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("\'Hello\'");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertError(this._parseHelper.parse(_builder), XbasePackage.Literals.XFEATURE_CALL, IssueCodes.INVALID_MUTABLE_VARIABLE_ACCESS, "Cannot implicitly refer to the non-final variable u inside a local class");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testExtensions_02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Test {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("extension Util = null");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def getRunnable() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("var String it = null");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Runnable {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("override run() {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("sayHello");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("static class Util {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("def void sayHello(String s) {}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertError(this._parseHelper.parse(_builder), XbasePackage.Literals.XFEATURE_CALL, IssueCodes.INVALID_MUTABLE_VARIABLE_ACCESS, "Cannot implicitly refer to the non-final variable it inside a local class");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testExtensions_03() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static extension Util.*");
      _builder.newLine();
      _builder.append("class Test {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def getRunnable() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("var String it = null");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Runnable {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("override run() {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("sayHello");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class Util {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("static def void sayHello(String s) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertError(this._parseHelper.parse(_builder), XbasePackage.Literals.XFEATURE_CALL, IssueCodes.INVALID_MUTABLE_VARIABLE_ACCESS, "Cannot implicitly refer to the non-final variable it inside a local class");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
