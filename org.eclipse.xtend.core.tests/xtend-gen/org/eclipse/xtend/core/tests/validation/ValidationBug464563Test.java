/**
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
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
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class ValidationBug464563Test extends AbstractXtendTestCase {
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;
  
  @Inject
  @Extension
  private ParseHelper<XtendFile> _parseHelper;
  
  @Test
  public void testJvmOperation_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypackage");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import java.util.List");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def Unknown foo(Unknown2 arg0, List<Unknown3> arg1) throws Unknown4 {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void bar() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("foo(null, null) ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertError(file, 
        XbasePackage.Literals.XFEATURE_CALL, 
        IssueCodes.REFER_INVALID_TYPES, 
        "The method foo(Unknown2, List<Unknown3>) from the type Foo refers to the missing type Unknown");
      this._validationTestHelper.assertNoErrors(file, 
        XbasePackage.Literals.XFEATURE_CALL, 
        IssueCodes.REFER_INVALID_TYPES, 
        "The method foo(Unknown2, List<Unknown3>) from the type Foo refers to the missing type Unknown2");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testJvmOperation_02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypackage");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import java.util.List");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def Object foo(Unknown2 arg0, List<Unknown3> arg1) throws Unknown4 {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void bar() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("foo(null, null) ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertError(file, 
        XbasePackage.Literals.XFEATURE_CALL, 
        IssueCodes.REFER_INVALID_TYPES, 
        "The method foo(Unknown2, List<Unknown3>) from the type Foo refers to the missing type Unknown2");
      this._validationTestHelper.assertNoErrors(file, 
        XbasePackage.Literals.XFEATURE_CALL, 
        IssueCodes.REFER_INVALID_TYPES, 
        "The method foo(Unknown2, List<Unknown3>) from the type Foo refers to the missing type Unknown3");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testJvmOperation_03() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypackage");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import java.util.List");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def Object foo(Object arg0, List<Unknown3> arg1) throws Unknown4 {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void bar() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("foo(null, null) ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertError(file, 
        XbasePackage.Literals.XFEATURE_CALL, 
        IssueCodes.REFER_INVALID_TYPES, 
        "The method foo(Object, List<Unknown3>) from the type Foo refers to the missing type Unknown3");
      this._validationTestHelper.assertNoErrors(file, 
        XbasePackage.Literals.XFEATURE_CALL, 
        IssueCodes.REFER_INVALID_TYPES, 
        "The method foo(Object, List<Unknown3>) from the type Foo refers to the missing type Unknown4");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testJvmOperation_04() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypackage");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import java.util.List");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def Object foo(Object arg0, List<Object> arg1) throws Unknown4 {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void bar() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("foo(null, null) ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertError(file, 
        XbasePackage.Literals.XFEATURE_CALL, 
        IssueCodes.REFER_INVALID_TYPES, 
        "The method foo(Object, List<Object>) from the type Foo refers to the missing type Unknown4");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testJvmOperation_05() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypackage");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import java.util.List");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void foo(List<Unknown[]> arg0) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void bar() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("foo(notify)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertError(file, 
        XbasePackage.Literals.XFEATURE_CALL, 
        IssueCodes.REFER_INVALID_TYPES, 
        "The method foo(List<Unknown[]>) from the type Foo refers to the missing type Unknown");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testJvmOperation_06() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypackage");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import java.util.List");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void foo(List<? extends Unknown> arg0) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void bar() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("foo(notify)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertError(file, 
        XbasePackage.Literals.XFEATURE_CALL, 
        IssueCodes.REFER_INVALID_TYPES, 
        "The method foo(List<? extends Unknown>) from the type Foo refers to the missing type Unknown");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testJvmOperation_07() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypackage");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import java.util.List");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void foo(List<? super Unknown> arg0) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void bar() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("foo(notify) ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertError(file, 
        XbasePackage.Literals.XFEATURE_CALL, 
        IssueCodes.REFER_INVALID_TYPES, 
        "The method foo(List<? super Unknown>) from the type Foo refers to the missing type Unknown");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testJvmOperation_08() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypackage");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import java.util.List");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def <T extends Unknown & Unknown2> void foo(List<T> arg0) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void bar() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("foo(notify)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertError(file, 
        XbasePackage.Literals.XFEATURE_CALL, 
        IssueCodes.REFER_INVALID_TYPES, 
        "The method foo(List<T>) from the type Foo refers to the missing type Unknown");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testJvmOperation_09() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypackage");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def <T extends Unknown & Unknown2> void foo(T arg0) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void bar() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("foo(notify) ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertError(file, 
        XbasePackage.Literals.XFEATURE_CALL, 
        IssueCodes.REFER_INVALID_TYPES, 
        "The method foo(T) from the type Foo refers to the missing type Unknown");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testJvmOperation_10() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypackage");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void foo(void arg0) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void bar() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("foo(notify) ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertError(file, 
        XbasePackage.Literals.XFEATURE_CALL, 
        IssueCodes.REFER_INVALID_TYPES, 
        "The method foo(void) from the type Foo has an illegal argument type");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testJvmOperation_11() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypackage");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void foo(Unknown<?> arg0) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void bar() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("foo(notify) ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertError(file, 
        XbasePackage.Literals.XFEATURE_CALL, 
        IssueCodes.REFER_INVALID_TYPES, 
        "The method foo(Unknown) from the type Foo refers to the missing type Unknown");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testJvmConstructor_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypackage");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import java.util.List");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new (Unknown arg0, List<Unknown2> arg1) throws Unknown3 {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void bar() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Foo(null, null) ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertError(file, 
        XbasePackage.Literals.XCONSTRUCTOR_CALL, 
        IssueCodes.REFER_INVALID_TYPES, 
        "The constructor Foo(Unknown, List<Unknown2>) refers to the missing type Unknown");
      this._validationTestHelper.assertNoErrors(file, 
        XbasePackage.Literals.XCONSTRUCTOR_CALL, 
        IssueCodes.REFER_INVALID_TYPES, 
        "The constructor Foo(Unknown, List<Unknown2>) refers to the missing type Unknown2");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testJvmConstructor_02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypackage");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import java.util.List");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new (Object arg0, List<Unknown2> arg1) throws Unknown3 {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void bar() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Foo(null, null) ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertError(file, 
        XbasePackage.Literals.XCONSTRUCTOR_CALL, 
        IssueCodes.REFER_INVALID_TYPES, 
        "The constructor Foo(Object, List<Unknown2>) refers to the missing type Unknown2");
      this._validationTestHelper.assertNoErrors(file, 
        XbasePackage.Literals.XCONSTRUCTOR_CALL, 
        IssueCodes.REFER_INVALID_TYPES, 
        "The constructor Foo(Object, List<Unknown2>) refers to the missing type Unknown3");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testJvmConstructor_03() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypackage");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import java.util.List");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new (Object arg0, List<Object> arg1) throws Unknown3 {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void bar() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Foo(null, null) ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertError(file, 
        XbasePackage.Literals.XCONSTRUCTOR_CALL, 
        IssueCodes.REFER_INVALID_TYPES, 
        "The constructor Foo(Object, List<Object>) refers to the missing type Unknown3");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testJvmConstructor_04() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypackage");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import java.util.List");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new (List<Unknown[]> arg0) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void bar() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Foo(notify)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertError(file, 
        XbasePackage.Literals.XCONSTRUCTOR_CALL, 
        IssueCodes.REFER_INVALID_TYPES, 
        "The constructor Foo(List<Unknown[]>) refers to the missing type Unknown");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testJvmConstructor_05() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypackage");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import java.util.List");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new (List<? extends Unknown> arg0) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void bar() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Foo(notify)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertError(file, 
        XbasePackage.Literals.XCONSTRUCTOR_CALL, 
        IssueCodes.REFER_INVALID_TYPES, 
        "The constructor Foo(List<? extends Unknown>) refers to the missing type Unknown");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testJvmConstructor_06() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypackage");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import java.util.List");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new (List<? super Unknown> arg0) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void bar() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Foo(notify)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertError(file, 
        XbasePackage.Literals.XCONSTRUCTOR_CALL, 
        IssueCodes.REFER_INVALID_TYPES, 
        "The constructor Foo(List<? super Unknown>) refers to the missing type Unknown");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testJvmConstructor_07() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypackage");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import java.util.List");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new <T extends Unknown & Unknown2> (List<T> arg0) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void bar() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Foo(notify)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertError(file, 
        XbasePackage.Literals.XCONSTRUCTOR_CALL, 
        IssueCodes.REFER_INVALID_TYPES, 
        "The constructor Foo(List<T>) refers to the missing type Unknown");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testJvmConstructor_08() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypackage");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new <T extends Unknown & Unknown2> (T arg0) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void bar() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Foo(notify)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertError(file, 
        XbasePackage.Literals.XCONSTRUCTOR_CALL, 
        IssueCodes.REFER_INVALID_TYPES, 
        "The constructor Foo(T) refers to the missing type Unknown");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testJvmConstructor_09() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypackage");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new(void arg0) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void bar() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Foo(notify)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertError(file, 
        XbasePackage.Literals.XCONSTRUCTOR_CALL, 
        IssueCodes.REFER_INVALID_TYPES, 
        "The constructor Foo(void) has an illegal argument type");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testJvmConstructor_10() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypackage");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new (Unknown<?> arg0) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void bar() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Foo(notify)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertError(file, 
        XbasePackage.Literals.XCONSTRUCTOR_CALL, 
        IssueCodes.REFER_INVALID_TYPES, 
        "The constructor Foo(Unknown) refers to the missing type Unknown");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testJvmField_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypackage");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import java.util.List");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("List<Unknown[]> myField");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void bar() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("myField = notify");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertError(file, 
        XbasePackage.Literals.XASSIGNMENT, 
        IssueCodes.REFER_INVALID_TYPES, 
        "The field Foo.myField refers to the missing type Unknown");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testJvmField_02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypackage");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import java.util.List");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("List<? extends Unknown> myField");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void bar() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("myField = notify");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertError(file, 
        XbasePackage.Literals.XASSIGNMENT, 
        IssueCodes.REFER_INVALID_TYPES, 
        "The field Foo.myField refers to the missing type Unknown");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testJvmField_03() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypackage");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import java.util.List");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("List<? super Unknown> myField");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void bar() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("myField = notify");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertError(file, 
        XbasePackage.Literals.XASSIGNMENT, 
        IssueCodes.REFER_INVALID_TYPES, 
        "The field Foo.myField refers to the missing type Unknown");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testJvmField_04() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypackage");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("void myField");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void bar() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("myField = notify");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertError(file, 
        XbasePackage.Literals.XASSIGNMENT, 
        IssueCodes.REFER_INVALID_TYPES, 
        "The field Foo.myField has an illegal argument type");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testJvmField_05() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypackage");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Unknown<?> myField");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void bar() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("myField = notify");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertError(file, 
        XbasePackage.Literals.XASSIGNMENT, 
        IssueCodes.REFER_INVALID_TYPES, 
        "The field Foo.myField refers to the missing type Unknown");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
