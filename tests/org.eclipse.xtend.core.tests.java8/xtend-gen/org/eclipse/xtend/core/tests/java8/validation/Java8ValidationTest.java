/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.java8.validation;

import com.google.inject.Inject;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.tests.java8.Java8RuntimeInjectorProvider;
import org.eclipse.xtend.core.validation.IssueCodes;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Test;

/**
 * @author Miro Spoenemann - Initial contribution and API
 */
@InjectWith(Java8RuntimeInjectorProvider.class)
@SuppressWarnings("all")
public class Java8ValidationTest extends AbstractXtendTestCase {
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;
  
  @Test
  public void testInheritedDefaultMethod() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("interface A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void foo() { }");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class C implements A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar() { foo }");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XtendFile _file = this.file(_builder.toString());
      this._validationTestHelper.assertNoErrors(_file);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testConflictingDefaultMethods01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("interface A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void foo() { }");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("interface B {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void foo() { }");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class C implements A, B { }");
      _builder.newLine();
      XtendFile _file = this.file(_builder.toString());
      this._validationTestHelper.assertError(_file, XtendPackage.Literals.XTEND_CLASS, IssueCodes.CONFLICTING_DEFAULT_METHODS, 
        "The type C inherits the conflicting non-abstract methods foo() from A and foo() from B.");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testConflictingDefaultMethods02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("interface A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void foo() { }");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("interface B {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void foo() { }");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("interface C extends A, B  { }");
      _builder.newLine();
      XtendFile _file = this.file(_builder.toString());
      this._validationTestHelper.assertError(_file, XtendPackage.Literals.XTEND_INTERFACE, IssueCodes.CONFLICTING_DEFAULT_METHODS, 
        "The type C inherits the conflicting non-abstract methods foo() from A and foo() from B.");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testConflictingDefaultMethods03() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("interface A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void foo() { }");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("interface B {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void foo()");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class C implements A, B { }");
      _builder.newLine();
      XtendFile _file = this.file(_builder.toString());
      this._validationTestHelper.assertError(_file, XtendPackage.Literals.XTEND_CLASS, IssueCodes.CONFLICTING_DEFAULT_METHODS, 
        "The non-abstract method foo() inherited from A conflicts with the method foo() inherited from B.");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testConflictingDefaultMethods04() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("interface A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void foo() { }");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("interface B {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void foo()");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("interface C extends A, B  { }");
      _builder.newLine();
      XtendFile _file = this.file(_builder.toString());
      this._validationTestHelper.assertError(_file, XtendPackage.Literals.XTEND_INTERFACE, IssueCodes.CONFLICTING_DEFAULT_METHODS, 
        "The non-abstract method foo() inherited from A conflicts with the method foo() inherited from B.");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testConflictingDefaultMethods05() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("interface A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def int foo(java.util.List<String> list) { 0 }");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("interface B {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def double foo(java.util.List<Class<?>> list) { 0 }");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class C implements A, B { }");
      _builder.newLine();
      XtendFile _file = this.file(_builder.toString());
      this._validationTestHelper.assertError(_file, XtendPackage.Literals.XTEND_CLASS, IssueCodes.CONFLICTING_DEFAULT_METHODS, 
        "The type C inherits the conflicting non-abstract methods foo(List<String>) from A and foo(List<Class<?>>) from B.");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testConflictingDefaultMethods06() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("interface A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def int foo(java.util.List<String> list) { 0 }");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("interface B {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def double foo(java.util.List<Class<?>> list) { 0 }");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("interface C extends A, B  { }");
      _builder.newLine();
      XtendFile _file = this.file(_builder.toString());
      this._validationTestHelper.assertError(_file, XtendPackage.Literals.XTEND_INTERFACE, IssueCodes.CONFLICTING_DEFAULT_METHODS, 
        "The type C inherits the conflicting non-abstract methods foo(List<String>) from A and foo(List<Class<?>>) from B.");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
