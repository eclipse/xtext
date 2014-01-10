/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.validation;

import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.validation.IssueCodes;
import org.junit.Test;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XbaseValidationTest extends AbstractXbaseTestCase {
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;
  
  @Test
  public void testDuplicateCases_int() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("switch x : 1 {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("case 1: 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("case 1: 1");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertError(_expression, XbasePackage.Literals.XNUMBER_LITERAL, IssueCodes.DUPLICATE_CASE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDuplicateCases_int_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("switch x : 1 {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("case 1: 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("case 2: 2");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertNoErrors(_expression);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDuplicateCases_int_3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val int a = 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val char b = 1 as char");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val byte c = 1 as byte");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val short d = 1 as short");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("switch x : 1 {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("case a: 1");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("case b: 1");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("case c: 1");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("case d: 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertError(_expression, XbasePackage.Literals.XFEATURE_CALL, IssueCodes.DUPLICATE_CASE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDuplicateCases_int_4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val int a = 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val char b = 2 as char");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val byte c = 3 as byte");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val short d = 4 as short");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("switch x : 1 {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("case a: 1");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("case b: 2");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("case c: 3");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("case d: 4");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertNoErrors(_expression);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDuplicateCases_int_5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("switch x : 1 {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("case 1: 1");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("case [|1].apply: 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertNoErrors(_expression);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDuplicateCases_enum() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("switch x : Thread.State.NEW {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("case NEW: 1");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("case NEW: 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertError(_expression, XbasePackage.Literals.XFEATURE_CALL, IssueCodes.DUPLICATE_CASE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDuplicateCases_enum_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("switch x : Thread.State.NEW {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("case NEW: 1");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("case Thread.State.NEW: 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertError(_expression, XbasePackage.Literals.XFEATURE_CALL, IssueCodes.DUPLICATE_CASE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDuplicateCases_enum_3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val state = Thread.State.NEW");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("switch x : Thread.State.NEW {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("case NEW: 1");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("case state: 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertNoErrors(_expression);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDuplicateCases_enum_4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("switch x : Thread.State.NEW {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("case NEW: 1");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("case RUNNABLE: 2");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertNoErrors(_expression);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDuplicateCases_double() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("switch x : 1d {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("case 1: 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("case 1: 1");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertNoErrors(_expression);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDuplicateCases_string() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("switch x : \'lalala\' {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("case \'A\': 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("case \'A\': 1");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertNoErrors(_expression);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDuplicateCases_object() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("switch x : new Object {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("case \'A\': 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("case \'A\': 1");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertNoErrors(_expression);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
