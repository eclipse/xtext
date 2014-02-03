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
import org.eclipse.xtext.common.types.TypesPackage;
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
  
  @Test
  public void testUnreachableCase() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("switch x : new Exception {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Exception: 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("java.io.IOException: 2");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("java.io.FileNotFoundException: 3");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertError(_expression, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.UNREACHABLE_CASE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testUnreachableCase_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("switch x : new Exception {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("java.io.IOException: 2");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Exception: 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("java.io.FileNotFoundException: 3");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertError(_expression, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.UNREACHABLE_CASE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testUnreachableCase_3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("switch x : new Exception {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("java.io.IOException: 2");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("java.io.FileNotFoundException: 3");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Exception: 1");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertError(_expression, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.UNREACHABLE_CASE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testUnreachableCase_4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("switch x : new Exception {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("java.io.FileNotFoundException: 3");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("java.io.IOException: 2");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Exception: 1");
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
  public void testUnreachableCase_5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("switch x : new Exception {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Exception case true: 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("java.io.IOException case false: 2");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("java.io.FileNotFoundException: 3");
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
  public void testUnreachableCatchClause() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("try {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("} catch (Exception e) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("} catch (java.io.IOException e) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("} catch (java.io.FileNotFoundException e) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertError(_expression, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.UNREACHABLE_CATCH_BLOCK);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testUnreachableCatchClause_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("try {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("} catch (java.io.IOException e) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("} catch (Exception e) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("} catch (java.io.FileNotFoundException e) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertError(_expression, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.UNREACHABLE_CATCH_BLOCK);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testUnreachableCatchClause_3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("try {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("} catch (java.io.IOException e) {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("} catch (java.io.FileNotFoundException e) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("} catch (Exception e) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertError(_expression, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.UNREACHABLE_CATCH_BLOCK);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testUnreachableCatchClause_4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("try {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("} catch (java.io.FileNotFoundException e) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("} catch (java.io.IOException e) {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("} catch (Exception e) {");
      _builder.newLine();
      _builder.append("\t");
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
  public void testUnreachableInstanceOf() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val x = new Object");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("if (x instanceof Exception) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("} else if (x instanceof java.io.IOException) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("2");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("} else if (x instanceof java.io.FileNotFoundException) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("3");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertError(_expression, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.UNREACHABLE_IF_BLOCK);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testUnreachableInstanceOf_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val x = new Object");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("if (x instanceof java.io.IOException) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("2");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("} else if (x instanceof Exception) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("} else if (x instanceof java.io.FileNotFoundException) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("3");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertError(_expression, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.UNREACHABLE_IF_BLOCK);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testUnreachableInstanceOf_3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val x = new Object");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("if (x instanceof java.io.IOException) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("2");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("} else if (x instanceof java.io.FileNotFoundException) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("3");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("} else if (x instanceof Exception) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertError(_expression, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.UNREACHABLE_IF_BLOCK);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testUnreachableInstanceOf_4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val x = new Object");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("if (x instanceof java.io.FileNotFoundException) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("3");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("} else if (x instanceof java.io.IOException) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("2");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("} else if (x instanceof Exception) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("1");
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
  public void testUnreachableInstanceOf_5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val x = new Object");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("if (x instanceof Exception && true) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("} else if (x instanceof java.io.IOException && false) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("2");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("} else if (x instanceof java.io.FileNotFoundException) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("3");
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
  public void testUnreachableInstanceOf_6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val x = new Object");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("if (x instanceof java.util.List) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("} else if (x instanceof int[]) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("2");
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
  public void testUnreachableInstanceOf_7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val x = new Object");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val y = new Object");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("if (x instanceof java.io.IOException) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("} else if (y instanceof java.io.FileNotFoundException) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("2");
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
  public void testUnreachableInstanceOf_8() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val x = new Object");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val y = new Object");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("if (x instanceof java.io.IOException) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("} else if (y instanceof java.io.IOException) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("2");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("} else if (x instanceof java.io.FileNotFoundException) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("3");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("} else if (y instanceof java.io.FileNotFoundException) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("4");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertError(_expression, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.UNREACHABLE_IF_BLOCK);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIncompleteCasesOnEnum() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("switch x : org.eclipse.xtext.xbase.tests.validation.Color.RED {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("case RED: {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("1");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertWarning(_expression, XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.INCOMPLETE_CASES_ON_ENUM);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIncompleteCasesOnEnum_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("switch x : org.eclipse.xtext.xbase.tests.validation.Color.RED {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("case RED: {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("1");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("case GREEN: {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("1");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("case BLUE: {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("1");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertNoIssues(_expression);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIncompleteCasesOnEnum_3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val y = 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("switch x : org.eclipse.xtext.xbase.tests.validation.Color.RED {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("case RED: {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("1");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("case y == 2: {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("2");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertNoIssues(_expression);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIncompleteCasesOnEnum_4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("switch x : org.eclipse.xtext.xbase.tests.validation.Color.RED {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("case RED: {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("1");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("default: {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("2");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertNoIssues(_expression);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
