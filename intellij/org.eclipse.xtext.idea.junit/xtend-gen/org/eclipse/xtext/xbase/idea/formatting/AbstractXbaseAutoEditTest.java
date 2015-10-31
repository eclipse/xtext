/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.formatting;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.idea.tests.AbstractAutoEditTest;

@SuppressWarnings("all")
public abstract class AbstractXbaseAutoEditTest extends AbstractAutoEditTest {
  public AbstractXbaseAutoEditTest(final LanguageFileType fileType) {
    super(fileType);
  }
  
  public void test_if_then_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 0");
    _builder.newLine();
    _builder.append("if (x == 1)|");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var x = 0");
    _builder_1.newLine();
    _builder_1.append("if (x == 1)");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_if_then_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 0");
    _builder.newLine();
    _builder.append("if (x == 1) |return true");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var x = 0");
    _builder_1.newLine();
    _builder_1.append("if (x == 1) ");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|return true");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_if_then_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 0");
    _builder.newLine();
    _builder.append("if (x == 1) {|}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var x = 0");
    _builder_1.newLine();
    _builder_1.append("if (x == 1) {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_if_then_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 0");
    _builder.newLine();
    _builder.append("if (x == 1) {|return true}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var x = 0");
    _builder_1.newLine();
    _builder_1.append("if (x == 1) {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|return true}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_if_then_05() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 0");
    _builder.newLine();
    _builder.append("if (x == 1)| {return true}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var x = 0");
    _builder_1.newLine();
    _builder_1.append("if (x == 1)");
    _builder_1.newLine();
    _builder_1.append("|{return true}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_if_then_06() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 0");
    _builder.newLine();
    _builder.append("|if (x == 1) {return true}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var x = 0");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("|if (x == 1) {return true}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_if_then_07() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 0|");
    _builder.newLine();
    _builder.append("if (x == 1) {return true}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var x = 0");
    _builder_1.newLine();
    _builder_1.append("|");
    _builder_1.newLine();
    _builder_1.append("if (x == 1) {return true}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_if_else_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 0");
    _builder.newLine();
    _builder.append("if (x == 1)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return true");
    _builder.newLine();
    _builder.append("else|");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var x = 0");
    _builder_1.newLine();
    _builder_1.append("if (x == 1)");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("return true");
    _builder_1.newLine();
    _builder_1.append("else");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_if_else_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 0");
    _builder.newLine();
    _builder.append("if (x == 1)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return true");
    _builder.newLine();
    _builder.append("else {|}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var x = 0");
    _builder_1.newLine();
    _builder_1.append("if (x == 1)");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("return true");
    _builder_1.newLine();
    _builder_1.append("else {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_if_else_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 0");
    _builder.newLine();
    _builder.append("if (x == 1)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return true");
    _builder.newLine();
    _builder.append("else |return false");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var x = 0");
    _builder_1.newLine();
    _builder_1.append("if (x == 1)");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("return true");
    _builder_1.newLine();
    _builder_1.append("else ");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|return false");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_if_else_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 0");
    _builder.newLine();
    _builder.append("if (x == 1)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return true");
    _builder.newLine();
    _builder.append("else {|return false}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var x = 0");
    _builder_1.newLine();
    _builder_1.append("if (x == 1)");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("return true");
    _builder_1.newLine();
    _builder_1.append("else {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|return false}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_if_else_05() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 0");
    _builder.newLine();
    _builder.append("if (x == 1)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return true");
    _builder.newLine();
    _builder.append("else| {return false}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var x = 0");
    _builder_1.newLine();
    _builder_1.append("if (x == 1)");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("return true");
    _builder_1.newLine();
    _builder_1.append("else");
    _builder_1.newLine();
    _builder_1.append("|{return false}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_if_else_06() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 0");
    _builder.newLine();
    _builder.append("if (x == 1)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return true");
    _builder.newLine();
    _builder.append("|else {return false}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var x = 0");
    _builder_1.newLine();
    _builder_1.append("if (x == 1)");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("return true");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("|else {return false}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_if_else_07() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 0");
    _builder.newLine();
    _builder.append("if (x == 1)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return true|");
    _builder.newLine();
    _builder.append("else {return false}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var x = 0");
    _builder_1.newLine();
    _builder_1.append("if (x == 1)");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("return true");
    _builder_1.newLine();
    _builder_1.append("|");
    _builder_1.newLine();
    _builder_1.append("else {return false}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_switch_default_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 0");
    _builder.newLine();
    _builder.append("switch x {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("default:|");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var x = 0");
    _builder_1.newLine();
    _builder_1.append("switch x {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("default:");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("|");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_switch_default_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 0");
    _builder.newLine();
    _builder.append("switch x {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("default|:");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var x = 0");
    _builder_1.newLine();
    _builder_1.append("switch x {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("default");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|:");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_switch_default_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 0");
    _builder.newLine();
    _builder.append("switch x {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("default| :");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var x = 0");
    _builder_1.newLine();
    _builder_1.append("switch x {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("default");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|:");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_switch_default_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 0");
    _builder.newLine();
    _builder.append("switch x {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("default |:");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var x = 0");
    _builder_1.newLine();
    _builder_1.append("switch x {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("default ");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|:");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_switch_default_05() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 0");
    _builder.newLine();
    _builder.append("switch x {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("default:|return true");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var x = 0");
    _builder_1.newLine();
    _builder_1.append("switch x {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("default:");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("|return true");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_switch_default_06() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 0");
    _builder.newLine();
    _builder.append("switch x {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("|default:return true");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var x = 0");
    _builder_1.newLine();
    _builder_1.append("switch x {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|default:return true");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_switch_default_07() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 0");
    _builder.newLine();
    _builder.append("switch x {|");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("default:return true");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var x = 0");
    _builder_1.newLine();
    _builder_1.append("switch x {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("default:return true");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_switch_case_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 0");
    _builder.newLine();
    _builder.append("switch x {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("case 1:|");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var x = 0");
    _builder_1.newLine();
    _builder_1.append("switch x {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("case 1:");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("|");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_switch_case_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 0");
    _builder.newLine();
    _builder.append("switch x {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("case 1:|return true");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var x = 0");
    _builder_1.newLine();
    _builder_1.append("switch x {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("case 1:");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("|return true");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_switch_case_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 0");
    _builder.newLine();
    _builder.append("switch x {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("case 1: {|return true}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var x = 0");
    _builder_1.newLine();
    _builder_1.append("switch x {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("case 1: {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("|return true}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_switch_case_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 0");
    _builder.newLine();
    _builder.append("switch x {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("case 1: {|}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var x = 0");
    _builder_1.newLine();
    _builder_1.append("switch x {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("case 1: {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("|");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_switch_case_05() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 0");
    _builder.newLine();
    _builder.append("switch x {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("case| 1: {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var x = 0");
    _builder_1.newLine();
    _builder_1.append("switch x {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("case");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|1: {}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_switch_case_06() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 0");
    _builder.newLine();
    _builder.append("switch x {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("|case 1: {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var x = 0");
    _builder_1.newLine();
    _builder_1.append("switch x {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|case 1: {}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_switch_case_07() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 0");
    _builder.newLine();
    _builder.append("switch x {|");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("case 1: {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var x = 0");
    _builder_1.newLine();
    _builder_1.append("switch x {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("case 1: {}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_for_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var values = <String>newArrayList");
    _builder.newLine();
    _builder.append("for (value : values)|");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var values = <String>newArrayList");
    _builder_1.newLine();
    _builder_1.append("for (value : values)");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_for_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var values = <String>newArrayList");
    _builder.newLine();
    _builder.append("var result = 0");
    _builder.newLine();
    _builder.append("for (value : values)|result += value.length");
    _builder.newLine();
    _builder.append("result");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var values = <String>newArrayList");
    _builder_1.newLine();
    _builder_1.append("var result = 0");
    _builder_1.newLine();
    _builder_1.append("for (value : values)");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|result += value.length");
    _builder_1.newLine();
    _builder_1.append("result");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_for_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var values = <String>newArrayList");
    _builder.newLine();
    _builder.append("var result = 0");
    _builder.newLine();
    _builder.append("for (value : values) {|result += value.length}");
    _builder.newLine();
    _builder.append("result");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var values = <String>newArrayList");
    _builder_1.newLine();
    _builder_1.append("var result = 0");
    _builder_1.newLine();
    _builder_1.append("for (value : values) {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|result += value.length}");
    _builder_1.newLine();
    _builder_1.append("result");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_for_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var values = <String>newArrayList");
    _builder.newLine();
    _builder.append("var result = 0");
    _builder.newLine();
    _builder.append("for| (value : values) {result += value.length}");
    _builder.newLine();
    _builder.append("result");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var values = <String>newArrayList");
    _builder_1.newLine();
    _builder_1.append("var result = 0");
    _builder_1.newLine();
    _builder_1.append("for");
    _builder_1.newLine();
    _builder_1.append("|(value : values) {result += value.length}");
    _builder_1.newLine();
    _builder_1.append("result");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_for_05() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var values = <String>newArrayList");
    _builder.newLine();
    _builder.append("var result = 0");
    _builder.newLine();
    _builder.append("|for (value : values) {result += value.length}");
    _builder.newLine();
    _builder.append("result");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var values = <String>newArrayList");
    _builder_1.newLine();
    _builder_1.append("var result = 0");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("|for (value : values) {result += value.length}");
    _builder_1.newLine();
    _builder_1.append("result");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_for_06() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var values = <String>newArrayList");
    _builder.newLine();
    _builder.append("var result = 0|");
    _builder.newLine();
    _builder.append("for (value : values) {result += value.length}");
    _builder.newLine();
    _builder.append("result");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var values = <String>newArrayList");
    _builder_1.newLine();
    _builder_1.append("var result = 0");
    _builder_1.newLine();
    _builder_1.append("|");
    _builder_1.newLine();
    _builder_1.append("for (value : values) {result += value.length}");
    _builder_1.newLine();
    _builder_1.append("result");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_basic_for_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("for (;;)|");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("for (;;)");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_basic_for_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("for (var i = 0;;) |i++");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("for (var i = 0;;) ");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|i++");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_basic_for_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("for (var i = 0;;) {|i++}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("for (var i = 0;;) {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|i++}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_basic_for_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("for (var i = 0;;)| {i++}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("for (var i = 0;;)");
    _builder_1.newLine();
    _builder_1.append("|{i++}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_basic_for_05() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("println(\'Hello World\')");
    _builder.newLine();
    _builder.append("|for (var i = 0;;) {i++}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("println(\'Hello World\')");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("|for (var i = 0;;) {i++}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_basic_for_06() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("println(\'Hello World\')|");
    _builder.newLine();
    _builder.append("for (var i = 0;;) {i++}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("println(\'Hello World\')");
    _builder_1.newLine();
    _builder_1.append("|");
    _builder_1.newLine();
    _builder_1.append("for (var i = 0;;) {i++}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_while_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var i = 0");
    _builder.newLine();
    _builder.append("while (i < 10)|");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var i = 0");
    _builder_1.newLine();
    _builder_1.append("while (i < 10)");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_while_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var i = 0");
    _builder.newLine();
    _builder.append("while (i < 10)|i++");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var i = 0");
    _builder_1.newLine();
    _builder_1.append("while (i < 10)");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|i++");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_while_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var i = 0");
    _builder.newLine();
    _builder.append("|while (i < 10)i++");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var i = 0");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("|while (i < 10)i++");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_while_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var i = 0|");
    _builder.newLine();
    _builder.append("while (i < 10)i++");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var i = 0");
    _builder_1.newLine();
    _builder_1.append("|");
    _builder_1.newLine();
    _builder_1.append("while (i < 10)i++");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_do_while_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var i = 0");
    _builder.newLine();
    _builder.append("do|");
    _builder.newLine();
    _builder.append("while (i < 10)");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var i = 0");
    _builder_1.newLine();
    _builder_1.append("do");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|");
    _builder_1.newLine();
    _builder_1.append("while (i < 10)");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_do_while_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var i = 0");
    _builder.newLine();
    _builder.append("do |i++");
    _builder.newLine();
    _builder.append("while (i < 10)");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var i = 0");
    _builder_1.newLine();
    _builder_1.append("do ");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|i++");
    _builder_1.newLine();
    _builder_1.append("while (i < 10)");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_do_while_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var i = 0");
    _builder.newLine();
    _builder.append("do {|i++}");
    _builder.newLine();
    _builder.append("while (i < 10)");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var i = 0");
    _builder_1.newLine();
    _builder_1.append("do {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|i++}");
    _builder_1.newLine();
    _builder_1.append("while (i < 10)");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_do_while_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var i = 0");
    _builder.newLine();
    _builder.append("|do {i++}");
    _builder.newLine();
    _builder.append("while (i < 10)");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var i = 0");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("|do {i++}");
    _builder_1.newLine();
    _builder_1.append("while (i < 10)");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_do_while_05() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var i = 0|");
    _builder.newLine();
    _builder.append("do {i++}");
    _builder.newLine();
    _builder.append("while (i < 10)");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var i = 0");
    _builder_1.newLine();
    _builder_1.append("|");
    _builder_1.newLine();
    _builder_1.append("do {i++}");
    _builder_1.newLine();
    _builder_1.append("while (i < 10)");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_var_declaration_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var i = |");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var i = ");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_var_declaration_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var i = {|}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var i = {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_var_declaration_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var i = |1");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var i = ");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|1");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_var_declaration_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var i = {|1}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var i = {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|1}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_var_declaration_05() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("println(\'Hello World\')");
    _builder.newLine();
    _builder.append("|var i = {1}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("println(\'Hello World\')");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("|var i = {1}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_var_declaration_06() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("println(\'Hello World\')|");
    _builder.newLine();
    _builder.append("var i = {1}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("println(\'Hello World\')");
    _builder_1.newLine();
    _builder_1.append("|");
    _builder_1.newLine();
    _builder_1.append("var i = {1}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_throw_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("throw |");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("throw ");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_throw_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("throw {|}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("throw {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_throw_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("throw |new java.lang.IllegalStateException");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("throw ");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|new java.lang.IllegalStateException");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_throw_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("throw {|new java.lang.IllegalStateException}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("throw {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|new java.lang.IllegalStateException}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_throw_05() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("throw| {new java.lang.IllegalStateException}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("throw");
    _builder_1.newLine();
    _builder_1.append("|{new java.lang.IllegalStateException}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_throw_06() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("println(\'Hello World\')");
    _builder.newLine();
    _builder.append("|throw {new java.lang.IllegalStateException}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("println(\'Hello World\')");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("|throw {new java.lang.IllegalStateException}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_throw_07() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("println(\'Hello World\')|");
    _builder.newLine();
    _builder.append("throw {new java.lang.IllegalStateException}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("println(\'Hello World\')");
    _builder_1.newLine();
    _builder_1.append("|");
    _builder_1.newLine();
    _builder_1.append("throw {new java.lang.IllegalStateException}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_return_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("return |");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("return ");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_return_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("return {|}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("return {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_return_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("return |1");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("return ");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|1");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_return_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("return {|1}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("return {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|1}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_return_05() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("println(\'Hello World\')|");
    _builder.newLine();
    _builder.append("return");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("println(\'Hello World\')");
    _builder_1.newLine();
    _builder_1.append("|");
    _builder_1.newLine();
    _builder_1.append("return");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_return_06() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("println(\'Hello World\')");
    _builder.newLine();
    _builder.append("|return");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("println(\'Hello World\')");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("|return");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_try_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("try|");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("try");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_try_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("try {|}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("try {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_try_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("try |return 1");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("try ");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|return 1");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_try_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("try {|return 1}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("try {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|return 1}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_try_05() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("try| {return 1}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("try");
    _builder_1.newLine();
    _builder_1.append("|{return 1}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_try_06() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("println(\'Hello World\')");
    _builder.newLine();
    _builder.append("|try {return 1}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("println(\'Hello World\')");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("|try {return 1}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_try_07() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("println(\'Hello World\')|");
    _builder.newLine();
    _builder.append("try {return 1}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("println(\'Hello World\')");
    _builder_1.newLine();
    _builder_1.append("|");
    _builder_1.newLine();
    _builder_1.append("try {return 1}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_catch_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("try");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return 1");
    _builder.newLine();
    _builder.append("catch (Exception e)|");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("try");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("return 1");
    _builder_1.newLine();
    _builder_1.append("catch (Exception e)");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_catch_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("try");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return 1");
    _builder.newLine();
    _builder.append("catch (Exception e) {|}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("try");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("return 1");
    _builder_1.newLine();
    _builder_1.append("catch (Exception e) {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_catch_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("try");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return 1");
    _builder.newLine();
    _builder.append("catch (Exception e)|return 2");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("try");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("return 1");
    _builder_1.newLine();
    _builder_1.append("catch (Exception e)");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|return 2");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_catch_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("try");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return 1");
    _builder.newLine();
    _builder.append("catch (Exception e) {|return 2}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("try");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("return 1");
    _builder_1.newLine();
    _builder_1.append("catch (Exception e) {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|return 2}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_catch_05() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("try");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return 1");
    _builder.newLine();
    _builder.append("catch| (Exception e) {return 2}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("try");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("return 1");
    _builder_1.newLine();
    _builder_1.append("catch");
    _builder_1.newLine();
    _builder_1.append("|(Exception e) {return 2}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_catch_06() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("try");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return 1");
    _builder.newLine();
    _builder.append("|catch (Exception e) {return 2}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("try");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("return 1");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("|catch (Exception e) {return 2}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_catch_07() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("try");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return 1|");
    _builder.newLine();
    _builder.append("catch (Exception e) {return 2}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("try");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("return 1");
    _builder_1.newLine();
    _builder_1.append("|");
    _builder_1.newLine();
    _builder_1.append("catch (Exception e) {return 2}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_finally_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("try");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return 1");
    _builder.newLine();
    _builder.append("finally|");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("try");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("return 1");
    _builder_1.newLine();
    _builder_1.append("finally");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_finally_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("try");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return 1");
    _builder.newLine();
    _builder.append("finally {|}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("try");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("return 1");
    _builder_1.newLine();
    _builder_1.append("finally {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_finally_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var i = 1");
    _builder.newLine();
    _builder.append("try");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return 1");
    _builder.newLine();
    _builder.append("finally |i = 1");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var i = 1");
    _builder_1.newLine();
    _builder_1.append("try");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("return 1");
    _builder_1.newLine();
    _builder_1.append("finally ");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|i = 1");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_finally_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var i = 1");
    _builder.newLine();
    _builder.append("try");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return 1");
    _builder.newLine();
    _builder.append("finally {|i = 1}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var i = 1");
    _builder_1.newLine();
    _builder_1.append("try");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("return 1");
    _builder_1.newLine();
    _builder_1.append("finally {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|i = 1}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_finally_05() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var i = 1");
    _builder.newLine();
    _builder.append("try");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return 1");
    _builder.newLine();
    _builder.append("finally| {i = 1}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var i = 1");
    _builder_1.newLine();
    _builder_1.append("try");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("return 1");
    _builder_1.newLine();
    _builder_1.append("finally");
    _builder_1.newLine();
    _builder_1.append("|{i = 1}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_finally_06() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var i = 1");
    _builder.newLine();
    _builder.append("try");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return 1");
    _builder.newLine();
    _builder.append("|finally {i = 1}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var i = 1");
    _builder_1.newLine();
    _builder_1.append("try");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("return 1");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("|finally {i = 1}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_finally_07() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var i = 1");
    _builder.newLine();
    _builder.append("try");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return 1|");
    _builder.newLine();
    _builder.append("finally {i = 1}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var i = 1");
    _builder_1.newLine();
    _builder_1.append("try");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("return 1");
    _builder_1.newLine();
    _builder_1.append("|");
    _builder_1.newLine();
    _builder_1.append("finally {i = 1}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_synchronized_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val lock = new Object");
    _builder.newLine();
    _builder.append("synchronized(lock)|");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("val lock = new Object");
    _builder_1.newLine();
    _builder_1.append("synchronized(lock)");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_synchronized_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val lock = new Object");
    _builder.newLine();
    _builder.append("synchronized(lock) {|}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("val lock = new Object");
    _builder_1.newLine();
    _builder_1.append("synchronized(lock) {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_synchronized_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val lock = new Object");
    _builder.newLine();
    _builder.append("synchronized(lock) |return true");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("val lock = new Object");
    _builder_1.newLine();
    _builder_1.append("synchronized(lock) ");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|return true");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_synchronized_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val lock = new Object");
    _builder.newLine();
    _builder.append("synchronized(lock) {|return true}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("val lock = new Object");
    _builder_1.newLine();
    _builder_1.append("synchronized(lock) {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|return true}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_synchronized_05() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val lock = new Object");
    _builder.newLine();
    _builder.append("synchronized(lock)| {return true}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("val lock = new Object");
    _builder_1.newLine();
    _builder_1.append("synchronized(lock)");
    _builder_1.newLine();
    _builder_1.append("|{return true}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_synchronized_06() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val lock = new Object");
    _builder.newLine();
    _builder.append("|synchronized(lock) {return true}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("val lock = new Object");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("|synchronized(lock) {return true}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void test_synchronized_07() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val lock = new Object|");
    _builder.newLine();
    _builder.append("synchronized(lock) {return true}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("val lock = new Object");
    _builder_1.newLine();
    _builder_1.append("|");
    _builder_1.newLine();
    _builder_1.append("synchronized(lock) {return true}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
}
