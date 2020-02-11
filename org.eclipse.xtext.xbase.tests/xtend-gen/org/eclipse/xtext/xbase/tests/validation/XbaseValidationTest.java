/**
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.validation;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
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
  public void testForwardReferenceToLocalVar() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{ val (int)=>int fun = [ fun.apply(it) ] }");
      _builder.newLine();
      this._validationTestHelper.assertError(this.expression(_builder), XbasePackage.Literals.XFEATURE_CALL, IssueCodes.ILLEGAL_FORWARD_REFERENCE, "The local variable fun may not have been initialized");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDuplicateCases_typeLiteral() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("switch x : String {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("case String: 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("case String: 1");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertError(this.expression(_builder), XbasePackage.Literals.XFEATURE_CALL, IssueCodes.DUPLICATE_CASE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDuplicateCases_typeLiteral_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("switch x : String {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("case String: 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("case typeof(String): 1");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      final Procedure1<XExpression> _function = (XExpression it) -> {
        this._validationTestHelper.assertError(it, XbasePackage.Literals.XTYPE_LITERAL, IssueCodes.DUPLICATE_CASE);
        this._validationTestHelper.assertError(it, XbasePackage.Literals.XFEATURE_CALL, IssueCodes.DUPLICATE_CASE);
      };
      ObjectExtensions.<XExpression>operator_doubleArrow(_expression, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDuplicateCases_typeLiteral_3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("switch x : String {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("case typeof(String): 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("case typeof(String): 1");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertError(this.expression(_builder), XbasePackage.Literals.XTYPE_LITERAL, IssueCodes.DUPLICATE_CASE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDuplicateCases_typeLiteral_4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("switch x : String {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("case typeof(Integer): 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("case typeof(String): 1");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoErrors(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDuplicateCases_typeLiteral_5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("switch x : String {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("case Integer: 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("case typeof(String): 1");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoErrors(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDuplicateCases_typeLiteral_6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("switch x : String {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("case Integer: 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("case String: 1");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoErrors(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDuplicateCases_typeLiteral_7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("switch x : String {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("case \'java.lang.String\': 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("case String: 1");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoErrors(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDuplicateCases_boolean() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("switch x : true {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("case false: 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("case false: 1");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoErrors(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
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
      this._validationTestHelper.assertError(this.expression(_builder), XbasePackage.Literals.XNUMBER_LITERAL, IssueCodes.DUPLICATE_CASE);
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
      this._validationTestHelper.assertNoErrors(this.expression(_builder));
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
      this._validationTestHelper.assertError(this.expression(_builder), XbasePackage.Literals.XFEATURE_CALL, IssueCodes.DUPLICATE_CASE);
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
      this._validationTestHelper.assertNoErrors(this.expression(_builder));
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
      this._validationTestHelper.assertNoErrors(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDuplicateCases_int_6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val Integer x = 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("switch x {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Integer case 1: 1");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Integer case 1: 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertError(this.expression(_builder), XbasePackage.Literals.XNUMBER_LITERAL, IssueCodes.DUPLICATE_CASE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDuplicateCases_int_7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val Integer x = 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("switch x {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Integer case 1: 1");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("case 1: 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertError(this.expression(_builder), XbasePackage.Literals.XNUMBER_LITERAL, IssueCodes.DUPLICATE_CASE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDuplicateCases_int_8() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("switch x : 1 {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("case x: \'\'");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("case x: \'1\'");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertError(this.expression(_builder), XbasePackage.Literals.XFEATURE_CALL, IssueCodes.DUPLICATE_CASE);
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
      this._validationTestHelper.assertError(this.expression(_builder), XbasePackage.Literals.XFEATURE_CALL, IssueCodes.DUPLICATE_CASE);
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
      this._validationTestHelper.assertError(this.expression(_builder), XbasePackage.Literals.XFEATURE_CALL, IssueCodes.DUPLICATE_CASE);
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
      this._validationTestHelper.assertNoErrors(this.expression(_builder));
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
      this._validationTestHelper.assertNoErrors(this.expression(_builder));
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
      this._validationTestHelper.assertError(this.expression(_builder), XbasePackage.Literals.XNUMBER_LITERAL, IssueCodes.DUPLICATE_CASE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDuplicateCases_double_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("switch x : 1.5d {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("case 1.5d: 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("case 1.5d: 1");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertError(this.expression(_builder), XbasePackage.Literals.XNUMBER_LITERAL, IssueCodes.DUPLICATE_CASE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDuplicateCases_double_3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("switch x : 1.5d {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("case 1.5d: 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("case 1.6d: 1");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoErrors(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDuplicateCases_number() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("switch x : 1 {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("case 1: 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("case 1l: 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("case 1f: 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("case 1d: 1");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoErrors(this.expression(_builder));
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
      this._validationTestHelper.assertError(this.expression(_builder), XbasePackage.Literals.XSTRING_LITERAL, IssueCodes.DUPLICATE_CASE);
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
      this._validationTestHelper.assertError(this.expression(_builder), XbasePackage.Literals.XSTRING_LITERAL, IssueCodes.DUPLICATE_CASE);
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
      this._validationTestHelper.assertError(this.expression(_builder), TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.UNREACHABLE_CASE);
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
      this._validationTestHelper.assertError(this.expression(_builder), TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.UNREACHABLE_CASE);
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
      this._validationTestHelper.assertError(this.expression(_builder), TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.UNREACHABLE_CASE);
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
      this._validationTestHelper.assertNoErrors(this.expression(_builder));
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
      this._validationTestHelper.assertNoErrors(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testUnreachableCase_6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("switch new java.util.ArrayList<String> {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("java.util.List<Integer>: \"list of integers\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("java.util.List<String>: \"list of strings\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("default: \"something else\"");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertError(this.expression(_builder), TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.UNREACHABLE_CASE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testUnreachableCase_7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("switch new java.util.ArrayList<String> {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("java.util.List<Integer>: \"list of integers\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("java.util.Set<String>: \"set of strings\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("default: \"something else\"");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoErrors(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testUnreachableCase_8() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("switch new java.util.ArrayList<String> {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("java.util.List: \"list of integers\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("java.util.List<String>: \"list of strings\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("default: \"something else\"");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertError(this.expression(_builder), TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.UNREACHABLE_CASE);
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
      this._validationTestHelper.assertError(this.expression(_builder), TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.UNREACHABLE_CATCH_BLOCK);
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
      this._validationTestHelper.assertError(this.expression(_builder), TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.UNREACHABLE_CATCH_BLOCK);
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
      this._validationTestHelper.assertError(this.expression(_builder), TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.UNREACHABLE_CATCH_BLOCK);
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
      this._validationTestHelper.assertNoErrors(this.expression(_builder));
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
      this._validationTestHelper.assertError(this.expression(_builder), TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.UNREACHABLE_IF_BLOCK);
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
      this._validationTestHelper.assertError(this.expression(_builder), TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.UNREACHABLE_IF_BLOCK);
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
      this._validationTestHelper.assertError(this.expression(_builder), TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.UNREACHABLE_IF_BLOCK);
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
      this._validationTestHelper.assertNoErrors(this.expression(_builder));
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
      this._validationTestHelper.assertNoErrors(this.expression(_builder));
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
      this._validationTestHelper.assertNoErrors(this.expression(_builder));
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
      this._validationTestHelper.assertNoErrors(this.expression(_builder));
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
      this._validationTestHelper.assertError(this.expression(_builder), TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.UNREACHABLE_IF_BLOCK);
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
      _builder.append("switch org.eclipse.xtext.xbase.tests.validation.Color.RED {");
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
      this._validationTestHelper.assertWarning(this.expression(_builder), XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.INCOMPLETE_CASES_ON_ENUM);
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
      _builder.append("switch org.eclipse.xtext.xbase.tests.validation.Color.RED {");
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
      this._validationTestHelper.assertNoIssues(this.expression(_builder));
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
      _builder.append("val y = Integer.valueOf(\"1\")");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("switch org.eclipse.xtext.xbase.tests.validation.Color.RED {");
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
      this._validationTestHelper.assertNoIssues(this.expression(_builder));
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
      _builder.append("switch org.eclipse.xtext.xbase.tests.validation.Color.RED {");
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
      this._validationTestHelper.assertNoIssues(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIncompleteCasesOnEnum_5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("switch org.eclipse.xtext.xbase.tests.validation.Color.RED {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertWarning(this.expression(_builder), XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.INCOMPLETE_CASES_ON_ENUM);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIncompleteCasesOnEnum_6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("switch org.eclipse.xtext.xbase.tests.validation.Color.RED {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("default: {");
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
      this._validationTestHelper.assertNoIssues(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIncompleteCasesOnEnum_7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("switch org.eclipse.xtext.xbase.tests.validation.Color x : org.eclipse.xtext.xbase.tests.validation.Color.RED {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertWarning(this.expression(_builder), XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.INCOMPLETE_CASES_ON_ENUM);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIncompleteCasesOnEnum_8() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("switch (org.eclipse.xtext.xbase.tests.validation.Color x : org.eclipse.xtext.xbase.tests.validation.Color.RED) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertWarning(this.expression(_builder), XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.INCOMPLETE_CASES_ON_ENUM);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIncompleteCasesOnEnum_9() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("switch Object x : org.eclipse.xtext.xbase.tests.validation.Color.RED {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoIssue(this.expression(_builder), XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.INCOMPLETE_CASES_ON_ENUM);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIncompleteCasesOnEnum_10() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("switch (Object x : org.eclipse.xtext.xbase.tests.validation.Color.RED) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoIssue(this.expression(_builder), XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.INCOMPLETE_CASES_ON_ENUM);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIncompleteCasesOnEnum_11() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val Enum<?> e = null");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("switch(e) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("java.lang.annotation.RetentionPolicy: e.toString");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("java.lang.annotation.ElementType: e.toString");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoIssues(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSwitchNoParameter() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("switch \"lalala\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XExpression block = this.expression(_builder);
      this._validationTestHelper.assertNoIssues(block);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSwitchDeclaredParameter() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("switch Object x : \"lalala\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XExpression block = this.expression(_builder);
      this._validationTestHelper.assertNoErrors(block);
      this._validationTestHelper.assertWarning(block, TypesPackage.Literals.JVM_FORMAL_PARAMETER, IssueCodes.UNUSED_LOCAL_VARIABLE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSwitchDeclaredParameter_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("switch String x : \"lalala\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XExpression block = this.expression(_builder);
      this._validationTestHelper.assertNoErrors(block);
      this._validationTestHelper.assertWarning(block, TypesPackage.Literals.JVM_FORMAL_PARAMETER, IssueCodes.UNUSED_LOCAL_VARIABLE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSwitchDeclaredParameter_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("switch Integer x : \"lalala\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XExpression block = this.expression(_builder);
      this._validationTestHelper.assertError(block, XbasePackage.Literals.XSTRING_LITERAL, IssueCodes.INCOMPATIBLE_TYPES);
      this._validationTestHelper.assertWarning(block, TypesPackage.Literals.JVM_FORMAL_PARAMETER, IssueCodes.UNUSED_LOCAL_VARIABLE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSwitchDeclaredParameter_3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("switch (Object x : \"lalala\") {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XExpression block = this.expression(_builder);
      this._validationTestHelper.assertNoErrors(block);
      this._validationTestHelper.assertWarning(block, TypesPackage.Literals.JVM_FORMAL_PARAMETER, IssueCodes.UNUSED_LOCAL_VARIABLE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSwitchDeclaredParameter_4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("switch (String x : \"lalala\") {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XExpression block = this.expression(_builder);
      this._validationTestHelper.assertNoErrors(block);
      this._validationTestHelper.assertWarning(block, TypesPackage.Literals.JVM_FORMAL_PARAMETER, IssueCodes.UNUSED_LOCAL_VARIABLE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSwitchDeclaredParameter_5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("switch (Integer x : \"lalala\") {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XExpression block = this.expression(_builder);
      this._validationTestHelper.assertError(block, XbasePackage.Literals.XSTRING_LITERAL, IssueCodes.INCOMPATIBLE_TYPES);
      this._validationTestHelper.assertWarning(block, TypesPackage.Literals.JVM_FORMAL_PARAMETER, IssueCodes.UNUSED_LOCAL_VARIABLE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBasicForLoop_InvalidInnerExpression() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("for(var condition = true; condition;) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoIssues(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBasicForLoop_UnusedVariable() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("for(var condition = true;;) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertWarning(this.expression(_builder), XbasePackage.Literals.XVARIABLE_DECLARATION, IssueCodes.UNUSED_LOCAL_VARIABLE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSynchronizedExpression_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("synchronized (1 + 2) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertError(this.expression(_builder), XbasePackage.Literals.XBINARY_OPERATION, IssueCodes.INCOMPATIBLE_TYPES);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSynchronizedExpression_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("synchronized (null) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertError(this.expression(_builder), XbasePackage.Literals.XNULL_LITERAL, IssueCodes.INCOMPATIBLE_TYPES);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSynchronizedExpression_3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val x = Integer.valueOf(1)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("synchronized (x) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoIssues(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSynchronizedExpression_4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val ()=>void x = [|]");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("synchronized (x.apply) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertError(this.expression(_builder), XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.INCOMPATIBLE_TYPES);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSynchronizedExpression_5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val ()=>int x = [|1]");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("synchronized (x.apply) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoIssues(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSynchronizedExpression_6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val ()=>Object x = [|new Object]");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("synchronized (x.apply) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoIssues(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSynchronizedExpression_7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val x = 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("synchronized (x) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertError(this.expression(_builder), XbasePackage.Literals.XFEATURE_CALL, IssueCodes.INCOMPATIBLE_TYPES);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSynchronizedExpression_8() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val int x = synchronized (new Object) new Object");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("x");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertError(this.expression(_builder), XbasePackage.Literals.XCONSTRUCTOR_CALL, IssueCodes.INCOMPATIBLE_TYPES);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSynchronizedExpression_9() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val int x = synchronized (new Object) 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("x");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoIssues(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSynchronizedExpression_10() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val x = synchronized (new Object) new Object");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("x");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoIssues(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSynchronizedExpression_11() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val foo = \"lalala\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("synchronized (foo) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("foo");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoIssues(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug415770_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val String str = \"\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val String[] array = null");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("str === array");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertError(this.expression(_builder), XbasePackage.Literals.XBINARY_OPERATION, IssueCodes.INVALID_OPERAND_TYPES);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug415770_02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val String str = \"\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val String[] array = null");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("str !== array");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertError(this.expression(_builder), XbasePackage.Literals.XBINARY_OPERATION, IssueCodes.INVALID_OPERAND_TYPES);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug415770_03() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val String str = \"\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val String[] array = null");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("array === str");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertError(this.expression(_builder), XbasePackage.Literals.XBINARY_OPERATION, IssueCodes.INVALID_OPERAND_TYPES);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug415770_04() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val String str = \"\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val String[] array = null");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("array !== str");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertError(this.expression(_builder), XbasePackage.Literals.XBINARY_OPERATION, IssueCodes.INVALID_OPERAND_TYPES);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug415770_05() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val String str = \"\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("str === \"SomeString\"");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoErrors(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug415770_06() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val String str = \"\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("str !== \"SomeString\"");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoErrors(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug415770_07() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val String[] array = null");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val String[] array2 = null");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("array === array2");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoErrors(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug415770_08() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val String[] array = null");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val String[] array2 = null");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("array !== array2");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoErrors(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug415770_09() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val String[] array = null");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("array !== null || array === null");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoErrors(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug415770_10() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val Cloneable c = null");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val String[] array = null");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("array !== c || array === c || c === array || c !== array");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoErrors(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug415770_11() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val java.io.Serializable s = null");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val String[] array = null");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("array !== s || array === s || s === array || s !== array");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoErrors(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug415770_12() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val Object o = null");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val String[] array = null");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("array !== o || array === o || o === array || o !== array");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoErrors(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testNullSafePrimitiveNumber() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val x = \"\"?.hashCode");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertWarning(this.expression(_builder), XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.NULL_SAFE_FEATURE_CALL_OF_PRIMITIVE_VALUED_FEATURE, "hashCode", "0");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testNullSafePrimitiveBoolean() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val x = \"\"?.equals(null)");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertWarning(this.expression(_builder), XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.NULL_SAFE_FEATURE_CALL_OF_PRIMITIVE_VALUED_FEATURE, "equals", "false");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug444972_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val java.lang.annotation.RetentionPolicy x = null");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val boolean b = switch x {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("case x.name == \"\": false");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("case SOURCE: true");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("println(b)");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertWarning(this.expression(_builder), XbasePackage.Literals.XSWITCH_EXPRESSION, IssueCodes.NULL_SAFE_FEATURE_CALL_OF_PRIMITIVE_VALUED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug444972_02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val java.lang.annotation.RetentionPolicy x = null");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val boolean b = switch x {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("case SOURCE,");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("case CLASS,");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("case RUNTIME: true");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("println(b)");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoIssues(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug458742_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val list = #[\"foo\"]");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("list?.add(\"bar\")");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("return false");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoIssues(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug458742_02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val list = #[\"foo\"]");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("list?.add(\"bar\")");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertWarning(this.expression(_builder), XbasePackage.Literals.XMEMBER_FEATURE_CALL, 
        IssueCodes.NULL_SAFE_FEATURE_CALL_OF_PRIMITIVE_VALUED_FEATURE, 
        "Null-safe call of primitive-valued feature");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug458742_03() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val list = #[\"foo\"]");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("val b = list?.add(\"bar\")");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("return b");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertWarning(this.expression(_builder), XbasePackage.Literals.XMEMBER_FEATURE_CALL, 
        IssueCodes.NULL_SAFE_FEATURE_CALL_OF_PRIMITIVE_VALUED_FEATURE, 
        "Null-safe call of primitive-valued feature");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testRedundantCases_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("switch i : 1 {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("case 1,");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertError(this.expression(_builder), XbasePackage.Literals.XCASE_PART, IssueCodes.REDUNDANT_CASE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testRedundantCases_02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("switch i : 1 {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("case 1,");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("case 2,");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertError(this.expression(_builder), XbasePackage.Literals.XCASE_PART, IssueCodes.REDUNDANT_CASE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testRedundantCases_03() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("switch i : 1 {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("case 1,");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("default: 1");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertWarning(this.expression(_builder), XbasePackage.Literals.XCASE_PART, IssueCodes.REDUNDANT_CASE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testRedundantCases_04() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("switch i : 1 {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("case 1,");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("case 2,");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("default: 1");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertWarning(this.expression(_builder), XbasePackage.Literals.XCASE_PART, IssueCodes.REDUNDANT_CASE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testRedundantCases_05() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("switch i : 1 {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("case 1,");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("case 2: 1");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoIssue(this.expression(_builder), XbasePackage.Literals.XCASE_PART, IssueCodes.REDUNDANT_CASE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSetLiteralTypeMismatchBug498779() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val java.util.Set<String> set = #[\"\"]");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertError(this.expression(_builder), XbasePackage.Literals.XLIST_LITERAL, IssueCodes.INCOMPATIBLE_TYPES);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testListLiteralTypeMismatchBug498779() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val java.util.List<String> list = #{\"\"}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertError(this.expression(_builder), XbasePackage.Literals.XSET_LITERAL, IssueCodes.INCOMPATIBLE_TYPES);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSetLiteralAssignedToCollectionBug498779() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val java.util.Collection<String> set = #{\"\"}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoErrors(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testListLiteralAssignedToCollectionBug498779() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val java.util.Collection<String> list = #[\"\"]");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoErrors(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testInvalidNestedReturnBug406762() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return return 0");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertNestedReturn(_builder, XbasePackage.Literals.XRETURN_EXPRESSION);
  }
  
  @Test
  public void testInvalidNestedReturnBug406762_1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return 0");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertInvalidReturnExpression(_builder, XbasePackage.Literals.XBLOCK_EXPRESSION);
  }
  
  @Test
  public void testInvalidNestedReturnBug406762_2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (true) return 0 else return 1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertInvalidReturnExpression(_builder, XbasePackage.Literals.XBLOCK_EXPRESSION);
  }
  
  @Test
  public void testInvalidNestedReturnBug406762_3() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (true) return 0 else return 1");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertInvalidReturnExpression(_builder, XbasePackage.Literals.XIF_EXPRESSION);
  }
  
  @Test
  public void testInvalidNestedReturnBug406762_4() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("throw return new RuntimeException()");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertInvalidReturnExpression(_builder, XbasePackage.Literals.XTHROW_EXPRESSION);
  }
  
  @Test
  public void testInvalidReturnInThrowBug406762() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("throw return new RuntimeException()");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertInvalidReturnInsideThrow(_builder);
  }
  
  @Test
  public void testInvalidReturnInThrowBug406762_1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("throw {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return new RuntimeException()");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertInvalidReturnInsideThrow(_builder);
  }
  
  @Test
  public void testInvalidReturnInThrowBug406762_2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("throw return");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertInvalidReturnInsideThrow(_builder);
  }
  
  @Test
  public void testInvalidReturnInThrowBug406762_3() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("throw {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertInvalidReturnInsideThrow(_builder);
  }
  
  @Test
  public void testInvalidReturnThrowBug406762() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return throw new RuntimeException()");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertInvalidReturnExpression(_builder, XbasePackage.Literals.XTHROW_EXPRESSION);
  }
  
  @Test
  public void testInvalidReturnThrowBug406762_1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val b = true");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return if (b) throw new RuntimeException() else throw new RuntimeException()");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertInvalidReturnExpression(_builder, XbasePackage.Literals.XIF_EXPRESSION);
  }
  
  @Test
  public void testValidReturnThrowBug406762() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val b = true");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("return if (b) throw new RuntimeException() else 42");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoErrors(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testValidReturnThrowBug406762_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val b = true");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("return if (b) 42 else throw new RuntimeException()");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoErrors(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test406762_ValidReturnInLambdaContainedInThrow() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("throw {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val foo = [|return \"foo\"]");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new Exception(foo.apply)");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoErrors(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test406762_ValidReturnInLambdaContainedInThrow_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("throw {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val ()=>Exception foo = [|return new Exception]");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("foo.apply");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoErrors(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testRangeLiteralInForLoopBug440006_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("for (int i : #[1..2]) {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertError(this.expression(_builder), XbasePackage.Literals.XBINARY_OPERATION, IssueCodes.INCOMPATIBLE_TYPES);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testRangeLiteralInForLoopBug440006_02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("for (Integer i : #[1..2]) {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertError(this.expression(_builder), XbasePackage.Literals.XBINARY_OPERATION, IssueCodes.INCOMPATIBLE_TYPES);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testRangeLiteralInForLoopBug440006_03() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("for (Number i : #[1..2]) {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertError(this.expression(_builder), XbasePackage.Literals.XBINARY_OPERATION, IssueCodes.INCOMPATIBLE_TYPES);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testRangeLiteralInForLoopBug440006_04() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("for (i : #[1..2]) {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoErrors(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testRangeLiteralInForLoopBug440006_05() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("for (IntegerRange i : #[1..2]) {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoErrors(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testRangeLiteralInForLoopBug440006_06() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("for (Iterable<Integer> i : #[1..2]) {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoErrors(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testRangeLiteralInForLoopBug440006_07() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("for (int i : #[1..2].flatten) {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoErrors(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testRangeLiteralInForLoopBug440006_01b() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("for (int i : #{1..2}) {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertError(this.expression(_builder), XbasePackage.Literals.XSET_LITERAL, IssueCodes.INCOMPATIBLE_TYPES);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testRangeLiteralInForLoopBug440006_02b() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("for (Integer i : #{1..2}) {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertError(this.expression(_builder), XbasePackage.Literals.XSET_LITERAL, IssueCodes.INCOMPATIBLE_TYPES);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testRangeLiteralInForLoopBug440006_03b() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("for (Number i : #{1..2}) {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertError(this.expression(_builder), XbasePackage.Literals.XSET_LITERAL, IssueCodes.INCOMPATIBLE_TYPES);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testRangeLiteralInForLoopBug440006_04b() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("for (i : #{1..2}) {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoErrors(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testRangeLiteralInForLoopBug440006_05b() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("for (IntegerRange i : #{1..2}) {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoErrors(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testRangeLiteralInForLoopBug440006_06b() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("for (Iterable<Integer> i : #{1..2}) {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoErrors(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testRangeLiteralInForLoopBug440006_07b() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("for (int i : #{1..2}.flatten) {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoErrors(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private void assertNestedReturn(final CharSequence input, final EClass objectType) {
    try {
      this._validationTestHelper.assertError(this.expression(input), objectType, 
        IssueCodes.INVALID_RETURN, 
        "Return cannot be nested.");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private void assertInvalidReturnInsideThrow(final CharSequence input) {
    try {
      this._validationTestHelper.assertError(this.expression(input), 
        XbasePackage.Literals.XRETURN_EXPRESSION, 
        IssueCodes.INVALID_RETURN, 
        "Invalid return inside throw.");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private void assertInvalidReturnExpression(final CharSequence input, final EClass objectType) {
    try {
      this._validationTestHelper.assertError(this.expression(input), objectType, 
        IssueCodes.INVALID_RETURN, 
        "Invalid return\'s expression.");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
