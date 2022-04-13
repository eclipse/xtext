/**
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.validation;

import com.google.inject.Inject;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.validation.IssueCodes;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Test;

/**
 * @author Christian Dietrich - Initial contribution and API
 */
@SuppressWarnings("all")
public class ValidationIssue265Test extends AbstractXtendTestCase {
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;

  @Inject
  private ParseHelper<XtendFile> parser;

  @Test
  public void test_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def static native String doSomething()");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.parser.parse(_builder);
      this._validationTestHelper.assertNoIssues(file);
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
      _builder.append("def final native String doSomething()");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.parser.parse(_builder);
      this._validationTestHelper.assertNoIssues(file);
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
      _builder.append("def private native String doSomething()");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.parser.parse(_builder);
      this._validationTestHelper.assertNoErrors(file);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void test_04() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("abstract class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def static String doSomething()");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.parser.parse(_builder);
      this._validationTestHelper.assertError(file, XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void test_05() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("abstract class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def final String doSomething()");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.parser.parse(_builder);
      this._validationTestHelper.assertError(file, XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void test_06() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("abstract class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def private String doSomething()");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.parser.parse(_builder);
      this._validationTestHelper.assertError(file, XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
