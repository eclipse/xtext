/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.formatting;

import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiFile;
import com.intellij.psi.codeStyle.CodeStyleManager;
import junit.framework.Assert;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.idea.tests.LightToolingTest;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public abstract class AbstractXbaseAdjustLineIndentTest extends LightToolingTest {
  public AbstractXbaseAdjustLineIndentTest(final LanguageFileType fileType) {
    super(fileType);
  }
  
  public void testXIfExpression_then_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 0");
    _builder.newLine();
    _builder.append("if (x == 1)");
    _builder.newLine();
    _builder.append("return true");
    _builder.newLine();
    _builder.append("return false");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var x = 0");
    _builder_1.newLine();
    _builder_1.append("if (x == 1)");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("return true");
    _builder_1.newLine();
    _builder_1.append("return false");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXIfExpression_then_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 0");
    _builder.newLine();
    _builder.append("if (x == 1) {");
    _builder.newLine();
    _builder.append("return true");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("return false");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var x = 0");
    _builder_1.newLine();
    _builder_1.append("if (x == 1) {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("return true");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("return false");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXIfExpression_then_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 0");
    _builder.newLine();
    _builder.append("if (x == 1) return true");
    _builder.newLine();
    _builder.append("return false");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var x = 0");
    _builder_1.newLine();
    _builder_1.append("if (x == 1) return true");
    _builder_1.newLine();
    _builder_1.append("return false");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXIfExpression_then_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 0");
    _builder.newLine();
    _builder.append("if (x == 1) { return true }");
    _builder.newLine();
    _builder.append("return false");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var x = 0");
    _builder_1.newLine();
    _builder_1.append("if (x == 1) { return true }");
    _builder_1.newLine();
    _builder_1.append("return false");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXIfExpression_else_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 0");
    _builder.newLine();
    _builder.append("if (x == 1)");
    _builder.newLine();
    _builder.append("return true");
    _builder.newLine();
    _builder.append("else");
    _builder.newLine();
    _builder.append("return false");
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
    _builder_1.append("return false");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXIfExpression_else_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 0");
    _builder.newLine();
    _builder.append("if (x == 1)");
    _builder.newLine();
    _builder.append("return true");
    _builder.newLine();
    _builder.append("else {");
    _builder.newLine();
    _builder.append("return false");
    _builder.newLine();
    _builder.append("}");
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
    _builder_1.append("return false");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXIfExpression_else_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 0");
    _builder.newLine();
    _builder.append("if (x == 1)");
    _builder.newLine();
    _builder.append("return true");
    _builder.newLine();
    _builder.append("else return false");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var x = 0");
    _builder_1.newLine();
    _builder_1.append("if (x == 1)");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("return true");
    _builder_1.newLine();
    _builder_1.append("else return false");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXIfExpression_else_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 0");
    _builder.newLine();
    _builder.append("if (x == 1)");
    _builder.newLine();
    _builder.append("return true");
    _builder.newLine();
    _builder.append("else { return false }");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var x = 0");
    _builder_1.newLine();
    _builder_1.append("if (x == 1)");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("return true");
    _builder_1.newLine();
    _builder_1.append("else { return false }");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXIfExpression_else_if_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 0");
    _builder.newLine();
    _builder.append("if (x == 1)");
    _builder.newLine();
    _builder.append("return true");
    _builder.newLine();
    _builder.append("else if (x == 2)");
    _builder.newLine();
    _builder.append("return false");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var x = 0");
    _builder_1.newLine();
    _builder_1.append("if (x == 1)");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("return true");
    _builder_1.newLine();
    _builder_1.append("else if (x == 2)");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("return false");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXIfExpression_else_if_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 0");
    _builder.newLine();
    _builder.append("if (x == 1)");
    _builder.newLine();
    _builder.append("return true");
    _builder.newLine();
    _builder.append("else if (x == 2) {");
    _builder.newLine();
    _builder.append("return false");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var x = 0");
    _builder_1.newLine();
    _builder_1.append("if (x == 1)");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("return true");
    _builder_1.newLine();
    _builder_1.append("else if (x == 2) {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("return false");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXIfExpression_else_if_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 0");
    _builder.newLine();
    _builder.append("if (x == 1)");
    _builder.newLine();
    _builder.append("return true");
    _builder.newLine();
    _builder.append("else if (x == 2) return false");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var x = 0");
    _builder_1.newLine();
    _builder_1.append("if (x == 1)");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("return true");
    _builder_1.newLine();
    _builder_1.append("else if (x == 2) return false");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXIfExpression_else_if_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 0");
    _builder.newLine();
    _builder.append("if (x == 1)");
    _builder.newLine();
    _builder.append("return true");
    _builder.newLine();
    _builder.append("else if (x == 2) { return false }");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var x = 0");
    _builder_1.newLine();
    _builder_1.append("if (x == 1)");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("return true");
    _builder_1.newLine();
    _builder_1.append("else if (x == 2) { return false }");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXIfExpression_if_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 0");
    _builder.newLine();
    _builder.append("if (x == 1");
    _builder.newLine();
    _builder.append(")");
    _builder.newLine();
    _builder.append("return true");
    _builder.newLine();
    _builder.append("return false");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var x = 0");
    _builder_1.newLine();
    _builder_1.append("if (x == 1");
    _builder_1.newLine();
    _builder_1.append(")");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("return true");
    _builder_1.newLine();
    _builder_1.append("return false");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXIfExpression_if_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 0");
    _builder.newLine();
    _builder.append("if (");
    _builder.newLine();
    _builder.append("x == 1");
    _builder.newLine();
    _builder.append(")");
    _builder.newLine();
    _builder.append("return true");
    _builder.newLine();
    _builder.append("return false");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var x = 0");
    _builder_1.newLine();
    _builder_1.append("if (");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("x == 1");
    _builder_1.newLine();
    _builder_1.append(")");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("return true");
    _builder_1.newLine();
    _builder_1.append("return false");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXOrExpression_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 0");
    _builder.newLine();
    _builder.append("x == 1 || x == 2 || x == 3 || x == 4");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var x = 0");
    _builder_1.newLine();
    _builder_1.append("x == 1 || x == 2 || x == 3 || x == 4");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXOrExpression_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 0");
    _builder.newLine();
    _builder.append("x == 1 ||");
    _builder.newLine();
    _builder.append("x == 2 ||");
    _builder.newLine();
    _builder.append("x == 3 ||");
    _builder.newLine();
    _builder.append("x == 4");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var x = 0");
    _builder_1.newLine();
    _builder_1.append("x == 1 ||");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("x == 2 ||");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("x == 3 ||");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("x == 4");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXOrExpression_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 0");
    _builder.newLine();
    _builder.append("x == 1");
    _builder.newLine();
    _builder.append("|| x == 2");
    _builder.newLine();
    _builder.append("|| x == 3");
    _builder.newLine();
    _builder.append("|| x == 4");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var x = 0");
    _builder_1.newLine();
    _builder_1.append("x == 1");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("|| x == 2");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("|| x == 3");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("|| x == 4");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXOrExpression_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 0");
    _builder.newLine();
    _builder.append("x == 1");
    _builder.newLine();
    _builder.append("||");
    _builder.newLine();
    _builder.append("x == 2");
    _builder.newLine();
    _builder.append("||");
    _builder.newLine();
    _builder.append("x == 3");
    _builder.newLine();
    _builder.append("||");
    _builder.newLine();
    _builder.append("x == 4");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var x = 0");
    _builder_1.newLine();
    _builder_1.append("x == 1");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("||");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("x == 2");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("||");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("x == 3");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("||");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("x == 4");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXAndExpression_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 0");
    _builder.newLine();
    _builder.append("x == 1 && x == 2 && x == 3 && x == 4");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var x = 0");
    _builder_1.newLine();
    _builder_1.append("x == 1 && x == 2 && x == 3 && x == 4");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXAndExpression_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 0");
    _builder.newLine();
    _builder.append("x == 1 &&");
    _builder.newLine();
    _builder.append("x == 2 &&");
    _builder.newLine();
    _builder.append("x == 3 &&");
    _builder.newLine();
    _builder.append("x == 4");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var x = 0");
    _builder_1.newLine();
    _builder_1.append("x == 1 &&");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("x == 2 &&");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("x == 3 &&");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("x == 4");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXAndExpression_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 0");
    _builder.newLine();
    _builder.append("x == 1");
    _builder.newLine();
    _builder.append("&& x == 2");
    _builder.newLine();
    _builder.append("&& x == 3");
    _builder.newLine();
    _builder.append("&& x == 4");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var x = 0");
    _builder_1.newLine();
    _builder_1.append("x == 1");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("&& x == 2");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("&& x == 3");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("&& x == 4");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXAndExpression_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 0");
    _builder.newLine();
    _builder.append("x == 1");
    _builder.newLine();
    _builder.append("&&");
    _builder.newLine();
    _builder.append("x == 2");
    _builder.newLine();
    _builder.append("&&");
    _builder.newLine();
    _builder.append("x == 3");
    _builder.newLine();
    _builder.append("&&");
    _builder.newLine();
    _builder.append("x == 4");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var x = 0");
    _builder_1.newLine();
    _builder_1.append("x == 1");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("&&");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("x == 2");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("&&");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("x == 3");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("&&");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("x == 4");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXEqualityExpression_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var a = 1; var b = 2; var c = 3; var d = 4");
    _builder.newLine();
    _builder.append("a == b == c == d");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var a = 1; var b = 2; var c = 3; var d = 4");
    _builder_1.newLine();
    _builder_1.append("a == b == c == d");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXEqualityExpression_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var a = 1; var b = 2; var c = 3; var d = 4");
    _builder.newLine();
    _builder.append("a");
    _builder.newLine();
    _builder.append("==");
    _builder.newLine();
    _builder.append("b");
    _builder.newLine();
    _builder.append("==");
    _builder.newLine();
    _builder.append("c");
    _builder.newLine();
    _builder.append("==");
    _builder.newLine();
    _builder.append("d");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var a = 1; var b = 2; var c = 3; var d = 4");
    _builder_1.newLine();
    _builder_1.append("a");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("==");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("b");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("==");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("c");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("==");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("d");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXEqualityExpression_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var a = 1; var b = 2; var c = 3; var d = 4");
    _builder.newLine();
    _builder.append("a");
    _builder.newLine();
    _builder.append("== b");
    _builder.newLine();
    _builder.append("== c");
    _builder.newLine();
    _builder.append("== d");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var a = 1; var b = 2; var c = 3; var d = 4");
    _builder_1.newLine();
    _builder_1.append("a");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("== b");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("== c");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("== d");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXInstanceOfExpression_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var object = new Object");
    _builder.newLine();
    _builder.append("object instanceof java.lang.String");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var object = new Object");
    _builder_1.newLine();
    _builder_1.append("object instanceof java.lang.String");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXInstanceOfExpression_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var object = new Object");
    _builder.newLine();
    _builder.append("object");
    _builder.newLine();
    _builder.append("instanceof");
    _builder.newLine();
    _builder.append("java.lang.String");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var object = new Object");
    _builder_1.newLine();
    _builder_1.append("object");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("instanceof");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("java.lang.String");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXInstanceOfExpression_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var object = new Object");
    _builder.newLine();
    _builder.append("object");
    _builder.newLine();
    _builder.append("instanceof java.lang.String");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var object = new Object");
    _builder_1.newLine();
    _builder_1.append("object");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("instanceof java.lang.String");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXRelationalExpression_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var a = 1; var b = 2");
    _builder.newLine();
    _builder.append("a > b");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var a = 1; var b = 2");
    _builder_1.newLine();
    _builder_1.append("a > b");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXRelationalExpression_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var a = 1; var b = 2");
    _builder.newLine();
    _builder.append("a");
    _builder.newLine();
    _builder.append(">");
    _builder.newLine();
    _builder.append("b");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var a = 1; var b = 2");
    _builder_1.newLine();
    _builder_1.append("a");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append(">");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("b");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXRelationalExpression_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var a = 1; var b = 2");
    _builder.newLine();
    _builder.append("a");
    _builder.newLine();
    _builder.append("> b");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var a = 1; var b = 2");
    _builder_1.newLine();
    _builder_1.append("a");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("> b");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXOtherOperatorExpression_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var object = new Object");
    _builder.newLine();
    _builder.append("object.toString ?: \'null\'");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var object = new Object");
    _builder_1.newLine();
    _builder_1.append("object.toString ?: \'null\'");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXOtherOperatorExpression_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var object = new Object");
    _builder.newLine();
    _builder.append("object.toString");
    _builder.newLine();
    _builder.append("?:");
    _builder.newLine();
    _builder.append("\'null\'");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var object = new Object");
    _builder_1.newLine();
    _builder_1.append("object.toString");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("?:");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("\'null\'");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXOtherOperatorExpression_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var object = new Object");
    _builder.newLine();
    _builder.append("object.toString");
    _builder.newLine();
    _builder.append("?: \'null\'");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var object = new Object");
    _builder_1.newLine();
    _builder_1.append("object.toString");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("?: \'null\'");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXAdditiveExpression_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var a = 1; var b = 2; var c = 3");
    _builder.newLine();
    _builder.append("a + b + c");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var a = 1; var b = 2; var c = 3");
    _builder_1.newLine();
    _builder_1.append("a + b + c");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXAdditiveExpression_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var a = 1; var b = 2; var c = 3");
    _builder.newLine();
    _builder.append("a");
    _builder.newLine();
    _builder.append("+");
    _builder.newLine();
    _builder.append("b");
    _builder.newLine();
    _builder.append("+");
    _builder.newLine();
    _builder.append("c");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var a = 1; var b = 2; var c = 3");
    _builder_1.newLine();
    _builder_1.append("a");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("+");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("b");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("+");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("c");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXAdditiveExpression_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var a = 1; var b = 2; var c = 3");
    _builder.newLine();
    _builder.append("a");
    _builder.newLine();
    _builder.append("+ b");
    _builder.newLine();
    _builder.append("+ c");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var a = 1; var b = 2; var c = 3");
    _builder_1.newLine();
    _builder_1.append("a");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("+ b");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("+ c");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXMultiplicativeExpression_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var a = 1; var b = 2; var c = 3");
    _builder.newLine();
    _builder.append("a * b * c");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var a = 1; var b = 2; var c = 3");
    _builder_1.newLine();
    _builder_1.append("a * b * c");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXMultiplicativeExpression_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var a = 1; var b = 2; var c = 3");
    _builder.newLine();
    _builder.append("a");
    _builder.newLine();
    _builder.append("*");
    _builder.newLine();
    _builder.append("b");
    _builder.newLine();
    _builder.append("*");
    _builder.newLine();
    _builder.append("c");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var a = 1; var b = 2; var c = 3");
    _builder_1.newLine();
    _builder_1.append("a");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("*");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("b");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("*");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("c");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXMultiplicativeExpression_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var a = 1; var b = 2; var c = 3");
    _builder.newLine();
    _builder.append("a");
    _builder.newLine();
    _builder.append("* b");
    _builder.newLine();
    _builder.append("* c");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var a = 1; var b = 2; var c = 3");
    _builder_1.newLine();
    _builder_1.append("a");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("* b");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("* c");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXUnaryOperation_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var a = 1;");
    _builder.newLine();
    _builder.append("-a");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var a = 1;");
    _builder_1.newLine();
    _builder_1.append("-a");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXUnaryOperation_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var a = 1;");
    _builder.newLine();
    _builder.append("-");
    _builder.newLine();
    _builder.append("a");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var a = 1;");
    _builder_1.newLine();
    _builder_1.append("-");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("a");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXCastedExpression_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var object = new Object");
    _builder.newLine();
    _builder.append("object as java.util.List<java.lang.String>");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var object = new Object");
    _builder_1.newLine();
    _builder_1.append("object as java.util.List<java.lang.String>");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXCastedExpression_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var object = new Object");
    _builder.newLine();
    _builder.append("object");
    _builder.newLine();
    _builder.append("as");
    _builder.newLine();
    _builder.append("java.util.List<java.lang.String>");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var object = new Object");
    _builder_1.newLine();
    _builder_1.append("object");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("as");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("java.util.List<java.lang.String>");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXCastedExpression_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var object = new Object");
    _builder.newLine();
    _builder.append("object");
    _builder.newLine();
    _builder.append("as java.util.List<java.lang.String>");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var object = new Object");
    _builder_1.newLine();
    _builder_1.append("object");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("as java.util.List<java.lang.String>");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXPostfixOperation_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var a = 1");
    _builder.newLine();
    _builder.append("a++");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var a = 1");
    _builder_1.newLine();
    _builder_1.append("a++");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXPostfixOperation_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var a = 1");
    _builder.newLine();
    _builder.append("a");
    _builder.newLine();
    _builder.append("++");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var a = 1");
    _builder_1.newLine();
    _builder_1.append("a");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("++");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXAssignment_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var a = 1");
    _builder.newLine();
    _builder.append("a = 3");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var a = 1");
    _builder_1.newLine();
    _builder_1.append("a = 3");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXAssignment_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var a = 1");
    _builder.newLine();
    _builder.append("a");
    _builder.newLine();
    _builder.append("=");
    _builder.newLine();
    _builder.append("3");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var a = 1");
    _builder_1.newLine();
    _builder_1.append("a");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("=");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("3");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXAssignment_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var a = 1");
    _builder.newLine();
    _builder.append("a += 3");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var a = 1");
    _builder_1.newLine();
    _builder_1.append("a += 3");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXAssignment_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var a = 1");
    _builder.newLine();
    _builder.append("a");
    _builder.newLine();
    _builder.append("+=");
    _builder.newLine();
    _builder.append("3");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var a = 1");
    _builder_1.newLine();
    _builder_1.append("a");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("+=");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("3");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXMemberFeatureCall_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var values = <String>newArrayList");
    _builder.newLine();
    _builder.append("values.head");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var values = <String>newArrayList");
    _builder_1.newLine();
    _builder_1.append("values.head");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXMemberFeatureCall_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var values = <String>newArrayList");
    _builder.newLine();
    _builder.append("values");
    _builder.newLine();
    _builder.append(".");
    _builder.newLine();
    _builder.append("head");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var values = <String>newArrayList");
    _builder_1.newLine();
    _builder_1.append("values");
    _builder_1.newLine();
    _builder_1.append(".");
    _builder_1.newLine();
    _builder_1.append("head");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXMemberFeatureCall_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var values = <String>newArrayList");
    _builder.newLine();
    _builder.append("values.get(0)");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var values = <String>newArrayList");
    _builder_1.newLine();
    _builder_1.append("values.get(0)");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXMemberFeatureCall_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var values = <String>newArrayList");
    _builder.newLine();
    _builder.append("values.get(");
    _builder.newLine();
    _builder.append("0");
    _builder.newLine();
    _builder.append(")");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var values = <String>newArrayList");
    _builder_1.newLine();
    _builder_1.append("values.get(");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("0");
    _builder_1.newLine();
    _builder_1.append(")");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXMemberFeatureCall_05() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var values = <String>newArrayList");
    _builder.newLine();
    _builder.append("values");
    _builder.newLine();
    _builder.append(".");
    _builder.newLine();
    _builder.append("get");
    _builder.newLine();
    _builder.append("(");
    _builder.newLine();
    _builder.append("0");
    _builder.newLine();
    _builder.append(")");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var values = <String>newArrayList");
    _builder_1.newLine();
    _builder_1.append("values");
    _builder_1.newLine();
    _builder_1.append(".");
    _builder_1.newLine();
    _builder_1.append("get");
    _builder_1.newLine();
    _builder_1.append("(");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("0");
    _builder_1.newLine();
    _builder_1.append(")");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXMemberFeatureCall_06() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var values = <String>newArrayList");
    _builder.newLine();
    _builder.append("values");
    _builder.newLine();
    _builder.append(".");
    _builder.newLine();
    _builder.append("get(");
    _builder.newLine();
    _builder.append("0");
    _builder.newLine();
    _builder.append(")");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var values = <String>newArrayList");
    _builder_1.newLine();
    _builder_1.append("values");
    _builder_1.newLine();
    _builder_1.append(".");
    _builder_1.newLine();
    _builder_1.append("get(");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("0");
    _builder_1.newLine();
    _builder_1.append(")");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXClosure_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var values = <String>newArrayList");
    _builder.newLine();
    _builder.append("values.map[value|value.length]");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var values = <String>newArrayList");
    _builder_1.newLine();
    _builder_1.append("values.map[value|value.length]");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXClosure_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var values = <String>newArrayList");
    _builder.newLine();
    _builder.append("values.map[value|");
    _builder.newLine();
    _builder.append("value.length");
    _builder.newLine();
    _builder.append("]");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var values = <String>newArrayList");
    _builder_1.newLine();
    _builder_1.append("values.map[value|");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("value.length");
    _builder_1.newLine();
    _builder_1.append("]");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXClosure_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var values = <String>newArrayList");
    _builder.newLine();
    _builder.append("values");
    _builder.newLine();
    _builder.append(".");
    _builder.newLine();
    _builder.append("map");
    _builder.newLine();
    _builder.append("[");
    _builder.newLine();
    _builder.append("value");
    _builder.newLine();
    _builder.append("|");
    _builder.newLine();
    _builder.append("value.length");
    _builder.newLine();
    _builder.append("]");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var values = <String>newArrayList");
    _builder_1.newLine();
    _builder_1.append("values");
    _builder_1.newLine();
    _builder_1.append(".");
    _builder_1.newLine();
    _builder_1.append("map");
    _builder_1.newLine();
    _builder_1.append("[");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("value");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("value.length");
    _builder_1.newLine();
    _builder_1.append("]");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXClosure_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var values = <String>newArrayList");
    _builder.newLine();
    _builder.append("values");
    _builder.newLine();
    _builder.append(".");
    _builder.newLine();
    _builder.append("map[value|");
    _builder.newLine();
    _builder.append("value.length");
    _builder.newLine();
    _builder.append("]");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var values = <String>newArrayList");
    _builder_1.newLine();
    _builder_1.append("values");
    _builder_1.newLine();
    _builder_1.append(".");
    _builder_1.newLine();
    _builder_1.append("map[value|");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("value.length");
    _builder_1.newLine();
    _builder_1.append("]");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXClosure_05() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var values = <String>newArrayList");
    _builder.newLine();
    _builder.append("values.map[length]");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var values = <String>newArrayList");
    _builder_1.newLine();
    _builder_1.append("values.map[length]");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXClosure_06() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var values = <String>newArrayList");
    _builder.newLine();
    _builder.append("values.map[");
    _builder.newLine();
    _builder.append("length");
    _builder.newLine();
    _builder.append("]");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var values = <String>newArrayList");
    _builder_1.newLine();
    _builder_1.append("values.map[");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("length");
    _builder_1.newLine();
    _builder_1.append("]");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXClosure_07() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var values = <String>newArrayList");
    _builder.newLine();
    _builder.append("values");
    _builder.newLine();
    _builder.append(".");
    _builder.newLine();
    _builder.append("map");
    _builder.newLine();
    _builder.append("[");
    _builder.newLine();
    _builder.append("length");
    _builder.newLine();
    _builder.append("]");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var values = <String>newArrayList");
    _builder_1.newLine();
    _builder_1.append("values");
    _builder_1.newLine();
    _builder_1.append(".");
    _builder_1.newLine();
    _builder_1.append("map");
    _builder_1.newLine();
    _builder_1.append("[");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("length");
    _builder_1.newLine();
    _builder_1.append("]");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXClosure_08() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var values = <String>newArrayList");
    _builder.newLine();
    _builder.append("values");
    _builder.newLine();
    _builder.append(".");
    _builder.newLine();
    _builder.append("map[");
    _builder.newLine();
    _builder.append("length");
    _builder.newLine();
    _builder.append("]");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var values = <String>newArrayList");
    _builder_1.newLine();
    _builder_1.append("values");
    _builder_1.newLine();
    _builder_1.append(".");
    _builder_1.newLine();
    _builder_1.append("map[");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("length");
    _builder_1.newLine();
    _builder_1.append("]");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXShortClosure_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var values = <String>newArrayList");
    _builder.newLine();
    _builder.append("values.map(value|value.length)");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var values = <String>newArrayList");
    _builder_1.newLine();
    _builder_1.append("values.map(value|value.length)");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXShortClosure_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var values = <String>newArrayList");
    _builder.newLine();
    _builder.append("values.map(value|");
    _builder.newLine();
    _builder.append("value.length");
    _builder.newLine();
    _builder.append(")");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var values = <String>newArrayList");
    _builder_1.newLine();
    _builder_1.append("values.map(value|");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("value.length");
    _builder_1.newLine();
    _builder_1.append(")");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXShortClosure_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var values = <String>newArrayList");
    _builder.newLine();
    _builder.append("values");
    _builder.newLine();
    _builder.append(".");
    _builder.newLine();
    _builder.append("map");
    _builder.newLine();
    _builder.append("(");
    _builder.newLine();
    _builder.append("value");
    _builder.newLine();
    _builder.append("|");
    _builder.newLine();
    _builder.append("value.length");
    _builder.newLine();
    _builder.append(")");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var values = <String>newArrayList");
    _builder_1.newLine();
    _builder_1.append("values");
    _builder_1.newLine();
    _builder_1.append(".");
    _builder_1.newLine();
    _builder_1.append("map");
    _builder_1.newLine();
    _builder_1.append("(");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("value");
    _builder_1.newLine();
    _builder_1.append("\t\t\t\t");
    _builder_1.append("|");
    _builder_1.newLine();
    _builder_1.append("\t\t\t\t");
    _builder_1.append("value.length");
    _builder_1.newLine();
    _builder_1.append(")");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXShortClosure_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var values = <String>newArrayList");
    _builder.newLine();
    _builder.append("values");
    _builder.newLine();
    _builder.append(".");
    _builder.newLine();
    _builder.append("map(value|");
    _builder.newLine();
    _builder.append("value.length");
    _builder.newLine();
    _builder.append(")");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var values = <String>newArrayList");
    _builder_1.newLine();
    _builder_1.append("values");
    _builder_1.newLine();
    _builder_1.append(".");
    _builder_1.newLine();
    _builder_1.append("map(value|");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("value.length");
    _builder_1.newLine();
    _builder_1.append(")");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXSetLiteral_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("# {1, 2, 3, 4}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("# {1, 2, 3, 4}");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXSetLiteral_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("1 + 2");
    _builder.newLine();
    _builder.append(",");
    _builder.newLine();
    _builder.append("3 + 4");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("#");
    _builder_1.newLine();
    _builder_1.append("{");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("1 + 2");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append(",");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("3 + 4");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXListLiteral_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("# [1, 2, 3, 4]");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("# [1, 2, 3, 4]");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXListLiteral_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#");
    _builder.newLine();
    _builder.append("[");
    _builder.newLine();
    _builder.append("1 + 2");
    _builder.newLine();
    _builder.append(",");
    _builder.newLine();
    _builder.append("3 + 4");
    _builder.newLine();
    _builder.append("]");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("#");
    _builder_1.newLine();
    _builder_1.append("[");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("1 + 2");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append(",");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("3 + 4");
    _builder_1.newLine();
    _builder_1.append("]");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXSwitchExpression_default_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var object = new Object");
    _builder.newLine();
    _builder.append("switch object {");
    _builder.newLine();
    _builder.append("default:");
    _builder.newLine();
    _builder.append("return true");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var object = new Object");
    _builder_1.newLine();
    _builder_1.append("switch object {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("default:");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("return true");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXSwitchExpression_default_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var object = new Object");
    _builder.newLine();
    _builder.append("switch object {");
    _builder.newLine();
    _builder.append("default: return true");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var object = new Object");
    _builder_1.newLine();
    _builder_1.append("switch object {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("default: return true");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXSwitchExpression_default_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var object = new Object");
    _builder.newLine();
    _builder.append("switch object {");
    _builder.newLine();
    _builder.append("default: {");
    _builder.newLine();
    _builder.append("return true");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var object = new Object");
    _builder_1.newLine();
    _builder_1.append("switch object {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("default: {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("return true");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXSwitchExpression_default_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var object = new Object");
    _builder.newLine();
    _builder.append("switch object {");
    _builder.newLine();
    _builder.append("default: { return true }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var object = new Object");
    _builder_1.newLine();
    _builder_1.append("switch object {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("default: { return true }");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXSwitchExpression_case_then_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 1");
    _builder.newLine();
    _builder.append("switch x {");
    _builder.newLine();
    _builder.append("case 1:");
    _builder.newLine();
    _builder.append("return true");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var x = 1");
    _builder_1.newLine();
    _builder_1.append("switch x {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("case 1:");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("return true");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXSwitchExpression_case_then_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 1");
    _builder.newLine();
    _builder.append("switch x {");
    _builder.newLine();
    _builder.append("case 1: return true");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var x = 1");
    _builder_1.newLine();
    _builder_1.append("switch x {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("case 1: return true");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXSwitchExpression_case_then_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 1");
    _builder.newLine();
    _builder.append("switch x {");
    _builder.newLine();
    _builder.append("case 1: {");
    _builder.newLine();
    _builder.append("return true");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var x = 1");
    _builder_1.newLine();
    _builder_1.append("switch x {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("case 1: {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("return true");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXSwitchExpression_case_then_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 1");
    _builder.newLine();
    _builder.append("switch x {");
    _builder.newLine();
    _builder.append("case 1: { return true }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var x = 1");
    _builder_1.newLine();
    _builder_1.append("switch x {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("case 1: { return true }");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXSwitchExpression_switch_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 1");
    _builder.newLine();
    _builder.append("switch");
    _builder.newLine();
    _builder.append("x");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("default: return true");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var x = 1");
    _builder_1.newLine();
    _builder_1.append("switch");
    _builder_1.newLine();
    _builder_1.append("x");
    _builder_1.newLine();
    _builder_1.append("{");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("default: return true");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXSwitchExpression_switch_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 1");
    _builder.newLine();
    _builder.append("switch");
    _builder.newLine();
    _builder.append("(");
    _builder.newLine();
    _builder.append("x");
    _builder.newLine();
    _builder.append(")");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("default: return true");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var x = 1");
    _builder_1.newLine();
    _builder_1.append("switch");
    _builder_1.newLine();
    _builder_1.append("(");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("x");
    _builder_1.newLine();
    _builder_1.append(")");
    _builder_1.newLine();
    _builder_1.append("{");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("default: return true");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXSwitchExpression_switch_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 1");
    _builder.newLine();
    _builder.append("switch");
    _builder.newLine();
    _builder.append("(");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("x");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append(")");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("default: return true");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var x = 1");
    _builder_1.newLine();
    _builder_1.append("switch");
    _builder_1.newLine();
    _builder_1.append("(");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("{");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("x");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append(")");
    _builder_1.newLine();
    _builder_1.append("{");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("default: return true");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXSwitchExpression_switch_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = 1");
    _builder.newLine();
    _builder.append("switch");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("x");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("default: return true");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var x = 1");
    _builder_1.newLine();
    _builder_1.append("switch");
    _builder_1.newLine();
    _builder_1.append("{");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("x");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("{");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("default: return true");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXSwitchExpression_declareParam_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("switch");
    _builder.newLine();
    _builder.append("x");
    _builder.newLine();
    _builder.append(":");
    _builder.newLine();
    _builder.append("1");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("default: return x + 2");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("switch");
    _builder_1.newLine();
    _builder_1.append("x");
    _builder_1.newLine();
    _builder_1.append(":");
    _builder_1.newLine();
    _builder_1.append("1");
    _builder_1.newLine();
    _builder_1.append("{");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("default: return x + 2");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXSwitchExpression_declaredParam_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("switch");
    _builder.newLine();
    _builder.append("(");
    _builder.newLine();
    _builder.append("x");
    _builder.newLine();
    _builder.append(":");
    _builder.newLine();
    _builder.append("1");
    _builder.newLine();
    _builder.append(")");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("default: return x + 2");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("switch");
    _builder_1.newLine();
    _builder_1.append("(");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("x");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append(":");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("1");
    _builder_1.newLine();
    _builder_1.append(")");
    _builder_1.newLine();
    _builder_1.append("{");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("default: return x + 2");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXSwitchExpression_declareParam_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("switch");
    _builder.newLine();
    _builder.append("(");
    _builder.newLine();
    _builder.append("x");
    _builder.newLine();
    _builder.append(":");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("1");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append(")");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("default: return x + 2");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("switch");
    _builder_1.newLine();
    _builder_1.append("(");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("x");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append(":");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("{");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("1");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append(")");
    _builder_1.newLine();
    _builder_1.append("{");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("default: return x + 2");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXSwitchExpression_declaredParam_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("switch");
    _builder.newLine();
    _builder.append("x");
    _builder.newLine();
    _builder.append(":");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("1");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("default: return x + 2");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("switch");
    _builder_1.newLine();
    _builder_1.append("x");
    _builder_1.newLine();
    _builder_1.append(":");
    _builder_1.newLine();
    _builder_1.append("{");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("1");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("{");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("default: return x + 2");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXForLoopExpression_00() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val values = <String>newArrayList");
    _builder.newLine();
    _builder.append("var result = 0");
    _builder.newLine();
    _builder.append("for");
    _builder.newLine();
    _builder.append("(");
    _builder.newLine();
    _builder.append("String");
    _builder.newLine();
    _builder.append("value");
    _builder.newLine();
    _builder.append(":");
    _builder.newLine();
    _builder.append("values");
    _builder.newLine();
    _builder.append(") {");
    _builder.newLine();
    _builder.append("result");
    _builder.newLine();
    _builder.append("+=");
    _builder.newLine();
    _builder.append("value.length");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("result");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("val values = <String>newArrayList");
    _builder_1.newLine();
    _builder_1.append("var result = 0");
    _builder_1.newLine();
    _builder_1.append("for");
    _builder_1.newLine();
    _builder_1.append("(");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("String");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("value");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append(":");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("values");
    _builder_1.newLine();
    _builder_1.append(") {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("result");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("+=");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("value.length");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("result");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXForLoopExpression_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val values = <String>newArrayList");
    _builder.newLine();
    _builder.append("var result = 0");
    _builder.newLine();
    _builder.append("for");
    _builder.newLine();
    _builder.append("(");
    _builder.newLine();
    _builder.append("String");
    _builder.newLine();
    _builder.append("value");
    _builder.newLine();
    _builder.append(":");
    _builder.newLine();
    _builder.append("values");
    _builder.newLine();
    _builder.append(")");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("result");
    _builder.newLine();
    _builder.append("+=");
    _builder.newLine();
    _builder.append("value.length");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("result");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("val values = <String>newArrayList");
    _builder_1.newLine();
    _builder_1.append("var result = 0");
    _builder_1.newLine();
    _builder_1.append("for");
    _builder_1.newLine();
    _builder_1.append("(");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("String");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("value");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append(":");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("values");
    _builder_1.newLine();
    _builder_1.append(")");
    _builder_1.newLine();
    _builder_1.append("{");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("result");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("+=");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("value.length");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("result");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXForLoopExpression_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val values = <String>newArrayList");
    _builder.newLine();
    _builder.append("var result = 0");
    _builder.newLine();
    _builder.append("for (value : values) {");
    _builder.newLine();
    _builder.append("result += value.length");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("result");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("val values = <String>newArrayList");
    _builder_1.newLine();
    _builder_1.append("var result = 0");
    _builder_1.newLine();
    _builder_1.append("for (value : values) {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("result += value.length");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("result");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXForLoopExpression_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val values = <String>newArrayList");
    _builder.newLine();
    _builder.append("var result = 0");
    _builder.newLine();
    _builder.append("for");
    _builder.newLine();
    _builder.append("(");
    _builder.newLine();
    _builder.append("String");
    _builder.newLine();
    _builder.append("value");
    _builder.newLine();
    _builder.append(":");
    _builder.newLine();
    _builder.append("values");
    _builder.newLine();
    _builder.append(")");
    _builder.newLine();
    _builder.append("result");
    _builder.newLine();
    _builder.append("+=");
    _builder.newLine();
    _builder.append("value.length");
    _builder.newLine();
    _builder.append("result");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("val values = <String>newArrayList");
    _builder_1.newLine();
    _builder_1.append("var result = 0");
    _builder_1.newLine();
    _builder_1.append("for");
    _builder_1.newLine();
    _builder_1.append("(");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("String");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("value");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append(":");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("values");
    _builder_1.newLine();
    _builder_1.append(")");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("result");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("+=");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("value.length");
    _builder_1.newLine();
    _builder_1.append("result");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXForLoopExpression_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val values = <String>newArrayList");
    _builder.newLine();
    _builder.append("var result = 0");
    _builder.newLine();
    _builder.append("for (value : values)");
    _builder.newLine();
    _builder.append("result += value.length");
    _builder.newLine();
    _builder.append("result");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("val values = <String>newArrayList");
    _builder_1.newLine();
    _builder_1.append("var result = 0");
    _builder_1.newLine();
    _builder_1.append("for (value : values)");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("result += value.length");
    _builder_1.newLine();
    _builder_1.append("result");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXBasicForLoopExpression_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var result = 0");
    _builder.newLine();
    _builder.append("for (var i = 1; i < 10; i++) {");
    _builder.newLine();
    _builder.append("result += i");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("result");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var result = 0");
    _builder_1.newLine();
    _builder_1.append("for (var i = 1; i < 10; i++) {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("result += i");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("result");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXBasicForLoopExpression_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var result = 0");
    _builder.newLine();
    _builder.append("for (var i = 1; i < 10; i++)");
    _builder.newLine();
    _builder.append("result += i");
    _builder.newLine();
    _builder.append("result");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var result = 0");
    _builder_1.newLine();
    _builder_1.append("for (var i = 1; i < 10; i++)");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("result += i");
    _builder_1.newLine();
    _builder_1.append("result");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXBasicForLoopExpression_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var result = 0");
    _builder.newLine();
    _builder.append("for (");
    _builder.newLine();
    _builder.append("var i = 1;");
    _builder.newLine();
    _builder.append("i < 10;");
    _builder.newLine();
    _builder.append("i++");
    _builder.newLine();
    _builder.append(") {");
    _builder.newLine();
    _builder.append("result += i");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("result");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var result = 0");
    _builder_1.newLine();
    _builder_1.append("for (");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("var i = 1;");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("i < 10;");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("i++");
    _builder_1.newLine();
    _builder_1.append(") {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("result += i");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("result");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXBasicForLoopExpression_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var result = 0");
    _builder.newLine();
    _builder.append("for (");
    _builder.newLine();
    _builder.append("var i = 1;");
    _builder.newLine();
    _builder.append("i < 10;");
    _builder.newLine();
    _builder.append("i++");
    _builder.newLine();
    _builder.append(")");
    _builder.newLine();
    _builder.append("result += i");
    _builder.newLine();
    _builder.append("result");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var result = 0");
    _builder_1.newLine();
    _builder_1.append("for (");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("var i = 1;");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("i < 10;");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("i++");
    _builder_1.newLine();
    _builder_1.append(")");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("result += i");
    _builder_1.newLine();
    _builder_1.append("result");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXBasicForLoopExpression_05() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var result = 0");
    _builder.newLine();
    _builder.append("for (");
    _builder.newLine();
    _builder.append("var i = 1;");
    _builder.newLine();
    _builder.append("i < 10;");
    _builder.newLine();
    _builder.append("i++");
    _builder.newLine();
    _builder.append(")");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("result += i");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("result");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var result = 0");
    _builder_1.newLine();
    _builder_1.append("for (");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("var i = 1;");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("i < 10;");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("i++");
    _builder_1.newLine();
    _builder_1.append(")");
    _builder_1.newLine();
    _builder_1.append("{");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("result += i");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("result");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXWhileExpression_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var i = 0");
    _builder.newLine();
    _builder.append("while (i < 10)");
    _builder.newLine();
    _builder.append("i++");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var i = 0");
    _builder_1.newLine();
    _builder_1.append("while (i < 10)");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("i++");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXWhileExpression_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var i = 0");
    _builder.newLine();
    _builder.append("while (i < 10) i++");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var i = 0");
    _builder_1.newLine();
    _builder_1.append("while (i < 10) i++");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXWhileExpression_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var i = 0");
    _builder.newLine();
    _builder.append("while (i < 10) { i++ }");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var i = 0");
    _builder_1.newLine();
    _builder_1.append("while (i < 10) { i++ }");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXWhileExpression_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var i = 0");
    _builder.newLine();
    _builder.append("while (i < 10) {");
    _builder.newLine();
    _builder.append("i++");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var i = 0");
    _builder_1.newLine();
    _builder_1.append("while (i < 10) {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("i++");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXWhileExpression_05() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var i = 0");
    _builder.newLine();
    _builder.append("while (i < 10)");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("i++");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var i = 0");
    _builder_1.newLine();
    _builder_1.append("while (i < 10)");
    _builder_1.newLine();
    _builder_1.append("{");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("i++");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXDoWhileExpression_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var i = 0");
    _builder.newLine();
    _builder.append("do");
    _builder.newLine();
    _builder.append("i++");
    _builder.newLine();
    _builder.append("while (i < 10)");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var i = 0");
    _builder_1.newLine();
    _builder_1.append("do");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("i++");
    _builder_1.newLine();
    _builder_1.append("while (i < 10)");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXDoWhileExpression_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var i = 0");
    _builder.newLine();
    _builder.append("do i++");
    _builder.newLine();
    _builder.append("while (i < 10)");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var i = 0");
    _builder_1.newLine();
    _builder_1.append("do i++");
    _builder_1.newLine();
    _builder_1.append("while (i < 10)");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXDoWhileExpression_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var i = 0");
    _builder.newLine();
    _builder.append("do { i++ }");
    _builder.newLine();
    _builder.append("while (i < 10)");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var i = 0");
    _builder_1.newLine();
    _builder_1.append("do { i++ }");
    _builder_1.newLine();
    _builder_1.append("while (i < 10)");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXDoWhileExpression_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var i = 0");
    _builder.newLine();
    _builder.append("do {");
    _builder.newLine();
    _builder.append("i++");
    _builder.newLine();
    _builder.append("} while (i < 10)");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var i = 0");
    _builder_1.newLine();
    _builder_1.append("do {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("i++");
    _builder_1.newLine();
    _builder_1.append("} while (i < 10)");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXDoWhileExpression_05() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var i = 0");
    _builder.newLine();
    _builder.append("do");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("i++");
    _builder.newLine();
    _builder.append("} while (i < 10)");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var i = 0");
    _builder_1.newLine();
    _builder_1.append("do");
    _builder_1.newLine();
    _builder_1.append("{");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("i++");
    _builder_1.newLine();
    _builder_1.append("} while (i < 10)");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXDoWhileExpression_06() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var i = 0");
    _builder.newLine();
    _builder.append("do");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("i++");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("while (i < 10)");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var i = 0");
    _builder_1.newLine();
    _builder_1.append("do");
    _builder_1.newLine();
    _builder_1.append("{");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("i++");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("while (i < 10)");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXVariableDeclaration_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val i = 1");
    _builder.newLine();
    _builder.append("return i");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("val i = 1");
    _builder_1.newLine();
    _builder_1.append("return i");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXVariableDeclaration_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val i =");
    _builder.newLine();
    _builder.append("1");
    _builder.newLine();
    _builder.append("return i");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("val i =");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("1");
    _builder_1.newLine();
    _builder_1.append("return i");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXVariableDeclaration_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val i = {");
    _builder.newLine();
    _builder.append("1");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("return i");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("val i = {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("1");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("return i");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXVariableDeclaration_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val i =");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("1");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("return i");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("val i =");
    _builder_1.newLine();
    _builder_1.append("{");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("1");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("return i");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXTypeLiteral_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("typeof(java.lang.String)");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("typeof(java.lang.String)");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXTypeLiteral_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("typeof");
    _builder.newLine();
    _builder.append("(java.lang.String)");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("typeof");
    _builder_1.newLine();
    _builder_1.append("(java.lang.String)");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXTypeLiteral_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("typeof");
    _builder.newLine();
    _builder.append("(");
    _builder.newLine();
    _builder.append("java.lang.String)");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("typeof");
    _builder_1.newLine();
    _builder_1.append("(");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("java.lang.String)");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXTypeLiteral_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("typeof");
    _builder.newLine();
    _builder.append("(");
    _builder.newLine();
    _builder.append("java.lang.String");
    _builder.newLine();
    _builder.append(")");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("typeof");
    _builder_1.newLine();
    _builder_1.append("(");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("java.lang.String");
    _builder_1.newLine();
    _builder_1.append(")");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXThrowExpression_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("throw new java.lang.IllegalStateException");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("throw new java.lang.IllegalStateException");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXThrowExpression_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("throw");
    _builder.newLine();
    _builder.append("new java.lang.IllegalStateException");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("throw");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("new java.lang.IllegalStateException");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXThrowExpression_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("throw {");
    _builder.newLine();
    _builder.append("new java.lang.IllegalStateException");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("throw {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("new java.lang.IllegalStateException");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXThrowExpression_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("throw");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("new java.lang.IllegalStateException");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("throw");
    _builder_1.newLine();
    _builder_1.append("{");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("new java.lang.IllegalStateException");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXReturnExpression_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("return 1");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("return 1");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXReturnExpression_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("return");
    _builder.newLine();
    _builder.append("1");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("return");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("1");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXReturnExpression_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("return {");
    _builder.newLine();
    _builder.append("1");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("return {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("1");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXReturnExpression_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("return");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("1");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("return");
    _builder_1.newLine();
    _builder_1.append("{");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("1");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXTryCatchFinallyExpression_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var b = false");
    _builder.newLine();
    _builder.append("try return 1");
    _builder.newLine();
    _builder.append("catch (java.lang.IllegalStateException e) return 2");
    _builder.newLine();
    _builder.append("catch (java.lang.Exception e) return 3");
    _builder.newLine();
    _builder.append("finally b = true");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var b = false");
    _builder_1.newLine();
    _builder_1.append("try return 1");
    _builder_1.newLine();
    _builder_1.append("catch (java.lang.IllegalStateException e) return 2");
    _builder_1.newLine();
    _builder_1.append("catch (java.lang.Exception e) return 3");
    _builder_1.newLine();
    _builder_1.append("finally b = true");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXTryCatchFinallyExpression_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var b = false");
    _builder.newLine();
    _builder.append("try ");
    _builder.newLine();
    _builder.append("return 1");
    _builder.newLine();
    _builder.append("catch (java.lang.IllegalStateException e)");
    _builder.newLine();
    _builder.append("return 2");
    _builder.newLine();
    _builder.append("catch (java.lang.Exception e)");
    _builder.newLine();
    _builder.append("return 3");
    _builder.newLine();
    _builder.append("finally");
    _builder.newLine();
    _builder.append("b = true");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var b = false");
    _builder_1.newLine();
    _builder_1.append("try");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("return 1");
    _builder_1.newLine();
    _builder_1.append("catch (java.lang.IllegalStateException e)");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("return 2");
    _builder_1.newLine();
    _builder_1.append("catch (java.lang.Exception e)");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("return 3");
    _builder_1.newLine();
    _builder_1.append("finally");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("b = true");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXTryCatchFinallyExpression_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var b = false");
    _builder.newLine();
    _builder.append("try {");
    _builder.newLine();
    _builder.append("return 1");
    _builder.newLine();
    _builder.append("} catch (java.lang.IllegalStateException e) {");
    _builder.newLine();
    _builder.append("return 2");
    _builder.newLine();
    _builder.append("} catch (java.lang.Exception e) {");
    _builder.newLine();
    _builder.append("return 3");
    _builder.newLine();
    _builder.append("} finally {");
    _builder.newLine();
    _builder.append("b = true");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var b = false");
    _builder_1.newLine();
    _builder_1.append("try {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("return 1");
    _builder_1.newLine();
    _builder_1.append("} catch (java.lang.IllegalStateException e) {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("return 2");
    _builder_1.newLine();
    _builder_1.append("} catch (java.lang.Exception e) {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("return 3");
    _builder_1.newLine();
    _builder_1.append("} finally {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("b = true");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXTryCatchFinallyExpression_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var b = false");
    _builder.newLine();
    _builder.append("try");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("return 1");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("catch (java.lang.IllegalStateException e)");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("return 2");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("catch (java.lang.Exception e)");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("return 3");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("finally");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("b = true");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var b = false");
    _builder_1.newLine();
    _builder_1.append("try");
    _builder_1.newLine();
    _builder_1.append("{");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("return 1");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("catch (java.lang.IllegalStateException e)");
    _builder_1.newLine();
    _builder_1.append("{");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("return 2");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("catch (java.lang.Exception e)");
    _builder_1.newLine();
    _builder_1.append("{");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("return 3");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("finally");
    _builder_1.newLine();
    _builder_1.append("{");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("b = true");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXSynchronizedExpression_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var lock = new Object");
    _builder.newLine();
    _builder.append("synchronized (lock) return 1");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var lock = new Object");
    _builder_1.newLine();
    _builder_1.append("synchronized (lock) return 1");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXSynchronizedExpression_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var lock = new Object");
    _builder.newLine();
    _builder.append("synchronized (lock)");
    _builder.newLine();
    _builder.append("return 1");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var lock = new Object");
    _builder_1.newLine();
    _builder_1.append("synchronized (lock)");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("return 1");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXSynchronizedExpression_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var lock = new Object");
    _builder.newLine();
    _builder.append("synchronized (lock) {");
    _builder.newLine();
    _builder.append("return 1");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var lock = new Object");
    _builder_1.newLine();
    _builder_1.append("synchronized (lock) {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("return 1");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXSynchronizedExpression_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var lock = new Object");
    _builder.newLine();
    _builder.append("synchronized (lock)");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("return 1");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var lock = new Object");
    _builder_1.newLine();
    _builder_1.append("synchronized (lock)");
    _builder_1.newLine();
    _builder_1.append("{");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("return 1");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXSynchronizedExpression_05() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var lock = new Object");
    _builder.newLine();
    _builder.append("synchronized (");
    _builder.newLine();
    _builder.append("lock)");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("return 1");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var lock = new Object");
    _builder_1.newLine();
    _builder_1.append("synchronized (");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("lock)");
    _builder_1.newLine();
    _builder_1.append("{");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("return 1");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  public void testXSynchronizedExpression_06() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var lock = new Object");
    _builder.newLine();
    _builder.append("synchronized");
    _builder.newLine();
    _builder.append("(");
    _builder.newLine();
    _builder.append("lock");
    _builder.newLine();
    _builder.append(")");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("return 1");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var lock = new Object");
    _builder_1.newLine();
    _builder_1.append("synchronized");
    _builder_1.newLine();
    _builder_1.append("(");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("lock");
    _builder_1.newLine();
    _builder_1.append(")");
    _builder_1.newLine();
    _builder_1.append("{");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("return 1");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAdjustLineIndent(_builder, _builder_1.toString());
  }
  
  protected void assertAdjustLineIndent(final CharSequence model, final String expectedAdjustedModel) {
    String _string = model.toString();
    final PsiFile file = this.configureByText(_string);
    this.myFixture.checkHighlighting();
    Project _project = this.getProject();
    Runnable _adjustLineIndent = this.adjustLineIndent(file);
    WriteCommandAction.runWriteCommandAction(_project, _adjustLineIndent);
    String _dumpFormattingModel = this.dumpFormattingModel();
    Editor _editor = this.myFixture.getEditor();
    Document _document = _editor.getDocument();
    String _text = _document.getText();
    Assert.assertEquals(_dumpFormattingModel, expectedAdjustedModel, _text);
  }
  
  protected Runnable adjustLineIndent(final PsiFile file) {
    final Runnable _function = () -> {
      Project _project = this.getProject();
      CodeStyleManager _instance = CodeStyleManager.getInstance(_project);
      TextRange _textRange = file.getTextRange();
      _instance.adjustLineIndent(file, _textRange);
    };
    return _function;
  }
}
