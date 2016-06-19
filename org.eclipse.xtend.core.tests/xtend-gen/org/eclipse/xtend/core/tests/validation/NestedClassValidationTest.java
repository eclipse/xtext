/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.validation;

import com.google.inject.Inject;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.validation.IssueCodes;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class NestedClassValidationTest extends AbstractXtendTestCase {
  @Inject
  @Extension
  private ParseHelper<XtendFile> _parseHelper;
  
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;
  
  @Test
  public void test_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("static class D {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("def m() {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("D.this.toString");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XtendFile _parse = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoIssues(_parse);
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
      _builder.append("static class D {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("def m() {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("D.super.toString");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XtendFile _parse = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoIssues(_parse);
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
      _builder.append("static class D {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("def m() {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("C.this.toString");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XtendFile _parse = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertError(_parse, XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.NO_ENCLOSING_INSTANCE_AVAILABLE, "No enclosing instance of the type C is accessible in scope");
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
      _builder.append("static class D {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("def m() {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("C.super.toString");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XtendFile _parse = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertError(_parse, XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.NO_ENCLOSING_INSTANCE_AVAILABLE, "No enclosing instance of the type C is accessible in scope");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test_05() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("interface I {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("class D {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("def m() {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("I.this.toString");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XtendFile _parse = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertError(_parse, XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.NO_ENCLOSING_INSTANCE_AVAILABLE, "No enclosing instance of the type I is accessible in scope");
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
      _builder.append("static class D {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("def m(C c) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("c.m");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("private def void m() {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XtendFile _parse = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoIssues(_parse);
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
      _builder.append("static class D {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("private new() {}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("def m() {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("new C()");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("private new() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("d = null");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("D d = new D");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XtendFile _parse = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoIssues(_parse);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
