/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
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
import org.eclipse.xtext.xbase.validation.IssueCodes;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class ValidationBug409602Test extends AbstractXtendTestCase {
  @Inject
  private ValidationTestHelper helper;
  
  @Inject
  private ParseHelper<XtendFile> parser;
  
  @Test
  public void test_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def m() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("if (\"\" == null) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("return");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.parser.parse(_builder);
      this.helper.assertError(file, XbasePackage.Literals.XNUMBER_LITERAL, IssueCodes.INVALID_INNER_EXPRESSION);
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
      _builder.append("def int m() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("if (\"\" == null) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("return");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.parser.parse(_builder);
      this.helper.assertError(file, XbasePackage.Literals.XRETURN_EXPRESSION, IssueCodes.INVALID_RETURN);
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
      _builder.append("def void m() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("if (\"\" == null) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("return");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.parser.parse(_builder);
      this.helper.assertError(file, XbasePackage.Literals.XNUMBER_LITERAL, IssueCodes.INVALID_INNER_EXPRESSION);
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
      _builder.append("def m() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("[|");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("if (\"\" == null) {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("return");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("1");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("]");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.parser.parse(_builder);
      this.helper.assertError(file, XbasePackage.Literals.XNUMBER_LITERAL, IssueCodes.INVALID_INNER_EXPRESSION);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test_05() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def m() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val ()=>int res = [|");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("if (\"\" == null) {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("return");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("1");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("]");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return res");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.parser.parse(_builder);
      this.helper.assertError(file, XbasePackage.Literals.XRETURN_EXPRESSION, IssueCodes.INVALID_RETURN);
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
      _builder.append("def m() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val ()=>void res = [|");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("if (\"\" == null) {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("return");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("1");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("]");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return res");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.parser.parse(_builder);
      this.helper.assertError(file, XbasePackage.Literals.XNUMBER_LITERAL, IssueCodes.INVALID_INNER_EXPRESSION);
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
      _builder.append("def int m() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("if (\"\" == null) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("return");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("return 1");
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
      this.helper.assertError(file, XbasePackage.Literals.XRETURN_EXPRESSION, IssueCodes.INVALID_RETURN);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test_08() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def m() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("if (\"\" == null) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("return");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("return 1");
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
      this.helper.assertError(file, XbasePackage.Literals.XRETURN_EXPRESSION, IssueCodes.INVALID_RETURN, "Void functions cannot return a value.");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test_09() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void m() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("if (\"\" == null) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("return");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("return 1");
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
      this.helper.assertError(file, XbasePackage.Literals.XRETURN_EXPRESSION, IssueCodes.INVALID_RETURN, "Void functions cannot return a value.");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test_10() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def int m() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("if (\"\" == null) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("return 1");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("return");
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
      this.helper.assertError(file, XbasePackage.Literals.XRETURN_EXPRESSION, IssueCodes.INVALID_RETURN);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test_11() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def m() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("if (\"\" == null) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("return 1");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("return");
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
      this.helper.assertError(file, XbasePackage.Literals.XRETURN_EXPRESSION, IssueCodes.INVALID_RETURN, "Void functions cannot return a value.");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test_12() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void m() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("if (\"\" == null) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("return 1");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("return");
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
      this.helper.assertError(file, XbasePackage.Literals.XRETURN_EXPRESSION, IssueCodes.INVALID_RETURN, "Void functions cannot return a value.");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test_13() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def m() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val ()=>int res = [|");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("if (\"\" == null) {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("return");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("return 1");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("]");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("res");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.parser.parse(_builder);
      this.helper.assertError(file, XbasePackage.Literals.XRETURN_EXPRESSION, IssueCodes.INVALID_RETURN);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test_14() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def m() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("[|");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("if (\"\" == null) {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("return");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("return 1");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("]");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.parser.parse(_builder);
      this.helper.assertError(file, XbasePackage.Literals.XRETURN_EXPRESSION, IssueCodes.INVALID_RETURN, "Void functions cannot return a value.");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test_15() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void m() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val ()=>void res = [|");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("if (\"\" == null) {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("return");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("return 1");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("]");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.parser.parse(_builder);
      this.helper.assertError(file, XbasePackage.Literals.XRETURN_EXPRESSION, IssueCodes.INVALID_RETURN, "Void functions cannot return a value.");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test_16() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def m() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val ()=>int res = [|");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("if (\"\" == null) {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("return 1");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("return");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("]");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("res");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.parser.parse(_builder);
      this.helper.assertError(file, XbasePackage.Literals.XRETURN_EXPRESSION, IssueCodes.INVALID_RETURN);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test_17() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def m() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("[|");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("if (\"\" == null) {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("return 1");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("return");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("]");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.parser.parse(_builder);
      this.helper.assertError(file, XbasePackage.Literals.XRETURN_EXPRESSION, IssueCodes.INVALID_RETURN, "Void functions cannot return a value.");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test_18() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def m() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val ()=>void res = [|");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("if (\"\" == null) {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("return 1");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("return");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("]");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("res");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.parser.parse(_builder);
      this.helper.assertError(file, XbasePackage.Literals.XRETURN_EXPRESSION, IssueCodes.INVALID_RETURN, "Void functions cannot return a value.");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
