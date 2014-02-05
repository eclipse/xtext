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
 * @author Anton Kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class ValidationBug427432Test extends AbstractXtendTestCase {
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;
  
  @Inject
  @Extension
  private ParseHelper<XtendFile> _parseHelper;
  
  @Test
  public void finalInstanceField() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val x = 1");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("switch y : 1 {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("case x: 1");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("case x: 1");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XtendFile _parse = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertError(_parse, XbasePackage.Literals.XFEATURE_CALL, IssueCodes.DUPLICATE_CASE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void finalInstanceField_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val int x");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("x = 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("switch y : 1 {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("case x: 1");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("case x: 1");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XtendFile _parse = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void finalInstanceField_3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val int x = bar()");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("switch y : 1 {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("case x: 1");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("case x: 1");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XtendFile _parse = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void notFinalInstanceField() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var x = 1");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("switch y : 1 {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("case x: 1");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("case x: 1");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XtendFile _parse = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void finalStaticField() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("static val x = 1");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("switch y : 1 {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("case x: 1");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("case x: 1");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XtendFile _parse = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertError(_parse, XbasePackage.Literals.XFEATURE_CALL, IssueCodes.DUPLICATE_CASE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void finalStaticField_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.core.tests.validation.Bar");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("switch y : 1 {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("case Bar.STATIC_FINAL_WITH_CONSTANT_INITIALIZATION: 1");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("case Bar.STATIC_FINAL_WITH_CONSTANT_INITIALIZATION: 1");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XtendFile _parse = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertError(_parse, XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.DUPLICATE_CASE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void notFinalStaticField() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("static int x = 1");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("switch y : 1 {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("case x: 1");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("case x: 1");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XtendFile _parse = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void notFinalStaticField_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.core.tests.validation.Bar");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("switch y : 1 {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("case Bar.NOT_FINAL_STATIC_WITH_CONSTANT_INITIALIZATION: 1");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("case Bar.NOT_FINAL_STATIC_WITH_CONSTANT_INITIALIZATION: 1");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XtendFile _parse = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void finalStaticFieldWithNotConstantInitialization() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("static val x = bar");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("switch y : 1 {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("case x: 1");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("case x: 1");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("static def bar() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XtendFile _parse = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void finalStaticFieldWithNotConstantInitialization_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.core.tests.validation.Bar");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("switch y : 1 {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("case Bar.STATIC_FINAL_WITH_NOT_CONSTANT_INITIALIZATION: 1");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("case Bar.STATIC_FINAL_WITH_NOT_CONSTANT_INITIALIZATION: 1");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XtendFile _parse = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void finalStaticFieldWithoutInitialization() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.core.tests.validation.Bar");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("switch y : 1 {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("case Bar.STATIC_FINAL_WITHOUT_INITIALIZATION: 1");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("case Bar.STATIC_FINAL_WITHOUT_INITIALIZATION: 1");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XtendFile _parse = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void finalVariable() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val x = 1");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("switch y : 1 {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("case x: 1");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("case x: 1");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XtendFile _parse = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertError(_parse, XbasePackage.Literals.XFEATURE_CALL, IssueCodes.DUPLICATE_CASE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void finalVariableWithNotConstantInitialization() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val x = bar");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("switch y : 1 {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("case x: 1");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("case x: 1");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XtendFile _parse = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void notFinalVariable() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("var int x");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("switch y : 1 {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("case x: 1");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("case x: 1");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XtendFile _parse = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
