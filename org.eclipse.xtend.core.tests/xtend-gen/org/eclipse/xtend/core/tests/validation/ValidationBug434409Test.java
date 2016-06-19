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
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.validation.IssueCodes;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class ValidationBug434409Test extends AbstractXtendTestCase {
  @Inject
  private ValidationTestHelper helper;
  
  @Inject
  private ParseHelper<XtendFile> parser;
  
  @Test
  public void test_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class UnreachableCode {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def m(Object x) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val y = if (x == \"bar\") {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("return \"asdf\"");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("return \"foo\"");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.parser.parse(_builder);
      this.helper.assertError(file, XtendPackage.Literals.XTEND_VARIABLE_DECLARATION, IssueCodes.UNREACHABLE_CODE, "Dead code: The variable y will never be assigned.");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test_02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class UnreachableCode {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def m(Object x) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val y = switch (x) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("String: throw new RuntimeException()");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("Integer: return \"foo\"");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("default: return \"bar\"");
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
      final XtendFile file = this.parser.parse(_builder);
      this.helper.assertError(file, XtendPackage.Literals.XTEND_VARIABLE_DECLARATION, IssueCodes.UNREACHABLE_CODE, "the var");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test_03() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class UnreachableCode {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def m(Object x) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val y = {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("return \"bar\"");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.parser.parse(_builder);
      this.helper.assertError(file, XtendPackage.Literals.XTEND_VARIABLE_DECLARATION, IssueCodes.UNREACHABLE_CODE, "the var");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test_04() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class UnreachableCode {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def m(Object x) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val y = try {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("return \"bar\"");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("} finally {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("// do nothing");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.parser.parse(_builder);
      this.helper.assertError(file, XtendPackage.Literals.XTEND_VARIABLE_DECLARATION, IssueCodes.UNREACHABLE_CODE, "the var");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test_05() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class UnreachableCode {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def m(Object x) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val y = try {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("// do nothing");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("} finally {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("// do nothing");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.parser.parse(_builder);
      this.helper.assertNoErrors(file);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test_06() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class UnreachableCode {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def m(Object x) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val Object y = if (x == \"bar\") {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("return \"asdf\"");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("return \"foo\"");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.parser.parse(_builder);
      this.helper.assertError(file, XtendPackage.Literals.XTEND_VARIABLE_DECLARATION, IssueCodes.UNREACHABLE_CODE, "Dead code: The variable y will never be assigned.");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test_07() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class UnreachableCode {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def m(Object x) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val y = try {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("// do nothing");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("\'a\'.substring(1)");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("return null;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("} catch(Exception e) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("return null;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.parser.parse(_builder);
      this.helper.assertError(file, XtendPackage.Literals.XTEND_VARIABLE_DECLARATION, IssueCodes.UNREACHABLE_CODE, "the var");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
