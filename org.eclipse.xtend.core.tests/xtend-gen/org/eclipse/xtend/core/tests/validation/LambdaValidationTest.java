/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.validation;

import com.google.inject.Inject;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.validation.IssueCodes;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class LambdaValidationTest extends AbstractXtendTestCase {
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;

  @Test
  public void testIncompatibleParameterType_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val I<Integer> f = [String k| 1]");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("interface I<T> {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def T m(int u);");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertError(this.file(_builder.toString()), XbasePackage.Literals.XCLOSURE, IssueCodes.INCOMPATIBLE_TYPES, "Type mismatch: cannot convert from (String)=>int to I<Integer>");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testIncompatibleParameterType_02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val I<Integer> f = [String k| 1]");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("interface I<T> {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def T m(T u);");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertError(this.file(_builder.toString()), XbasePackage.Literals.XNUMBER_LITERAL, IssueCodes.INCOMPATIBLE_TYPES, "Type mismatch: cannot convert from int to String");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testIncompatibleReturnType_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val I<Integer> f = [int k| \'\']");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("interface I<T> {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def T m(int u);");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertError(this.file(_builder.toString()), XbasePackage.Literals.XCLOSURE, IssueCodes.INCOMPATIBLE_TYPES, "Type mismatch: cannot convert from (int)=>String to I<Integer>");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testIncompatibleReturnType_02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val I<Integer> f = [int k| return \'\']");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("interface I<T> {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def T m(int u);");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertError(this.file(_builder.toString()), XbasePackage.Literals.XCLOSURE, IssueCodes.INCOMPATIBLE_TYPES, "Type mismatch: cannot convert from (int)=>String to I<Integer>");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testIncompatibleReturnType_03() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val I<Integer> f = [int k| \'\']");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("interface I<T> {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def T m(T u);");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertError(this.file(_builder.toString()), XbasePackage.Literals.XSTRING_LITERAL, IssueCodes.INCOMPATIBLE_TYPES, "Type mismatch: cannot convert from String to Integer");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testIncompatibleReturnType_04() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val I<Integer> f = [k| \'\']");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("interface I<T> {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def T m(int u);");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertError(this.file(_builder.toString()), XbasePackage.Literals.XCLOSURE, IssueCodes.INCOMPATIBLE_TYPES, "Type mismatch: cannot convert from (int)=>String to I<Integer>");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Ignore("TODO")
  @Test
  public void testIncompatibleBounds_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val I<Integer> f = [String k| return 1]");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("interface I<T extends Number> {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def <U extends Number> T m(U u);");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertError(this.file(_builder.toString()), XbasePackage.Literals.XCLOSURE, IssueCodes.INCOMPATIBLE_TYPES, "zonk");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
