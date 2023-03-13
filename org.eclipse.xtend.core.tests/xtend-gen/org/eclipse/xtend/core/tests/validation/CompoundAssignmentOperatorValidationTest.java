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
 * @author Anton Kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class CompoundAssignmentOperatorValidationTest extends AbstractXtendTestCase {
  @Inject
  @Extension
  private ParseHelper<XtendFile> _parseHelper;

  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;

  @Test
  public void test_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static extension compound.IntCompoundExtensions.*");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("var i = 2");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("i += i *= 2");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoIssues(this._parseHelper.parse(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void test_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static extension compound.IntCompoundExtensions.*");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val i = 2");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("i *= 2");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertError(this._parseHelper.parse(_builder), XbasePackage.Literals.XABSTRACT_FEATURE_CALL, IssueCodes.ASSIGNMENT_TO_FINAL);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void test_3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static extension compound.IntCompoundExtensions.*");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo(int i) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("i *= 2");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertError(this._parseHelper.parse(_builder), XbasePackage.Literals.XABSTRACT_FEATURE_CALL, IssueCodes.ASSIGNMENT_TO_FINAL);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void test_4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static extension compound.IntCompoundExtensions.*");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val i = 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("i *= 2");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertError(this._parseHelper.parse(_builder), XbasePackage.Literals.XABSTRACT_FEATURE_CALL, IssueCodes.ASSIGNMENT_TO_FINAL);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void test_5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static extension compound.IntCompoundExtensions.*");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val i = 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("i *= 2");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertError(this._parseHelper.parse(_builder), XbasePackage.Literals.XABSTRACT_FEATURE_CALL, IssueCodes.ASSIGNMENT_TO_FINAL);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void test_6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static extension compound.IntCompoundExtensions.*");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var i = 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("i *= 2");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoErrors(this._parseHelper.parse(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void test_7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static extension compound.IntCompoundExtensions.*");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("(1 + 2) *= 2");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertError(this._parseHelper.parse(_builder), XbasePackage.Literals.XBINARY_OPERATION, IssueCodes.ASSIGNMENT_TO_NO_VARIABLE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void test_8() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static extension compound.IntCompoundExtensions.*");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("foo() *= 2");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def int foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("0");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertError(this._parseHelper.parse(_builder), XbasePackage.Literals.XFEATURE_CALL, IssueCodes.ASSIGNMENT_TO_NO_VARIABLE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void test_9() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static extension compound.IntCompoundExtensions.*");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("var foo = new Foo");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("foo += new Foo");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def operator_plus(Foo other) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("other");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoErrors(this._parseHelper.parse(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void test_10() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static extension compound.IntCompoundExtensions.*");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("var foo = new Foo");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("foo += new Foo");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def operator_plus(Foo one, Foo another) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("another");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoErrors(this._parseHelper.parse(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void test_11() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static extension compound.IntCompoundExtensions.*");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("var foo = new Foo");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("foo += 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def operator_plus(int i) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("this");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoErrors(this._parseHelper.parse(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
