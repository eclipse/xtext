/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.autoedit;

import com.intellij.openapi.editor.Caret;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import junit.framework.TestCase;
import org.eclipse.xtend.idea.LightXtendTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.internal.LineDelimiters;
import org.junit.Ignore;

@SuppressWarnings("all")
public class XtendAutoEditTest extends LightXtendTest {
  private final static String CARET = "<caret>";
  
  public void testClassBraces() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.append(XtendAutoEditTest.CARET, "");
    this.configureByText(_builder.toString());
    this.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append(XtendAutoEditTest.CARET, "");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("}");
    this.assertEditor(_builder_1.toString());
  }
  
  public void testMethodParentheses() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bar");
    _builder.append(XtendAutoEditTest.CARET, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    this.configureByText(_builder.toString());
    this.myFixture.type("(");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def bar(");
    _builder_1.append(XtendAutoEditTest.CARET, "\t");
    _builder_1.append(")");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertEditor(_builder_1.toString());
  }
  
  public void testMethodBraces() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bar() {");
    _builder.append(XtendAutoEditTest.CARET, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    this.configureByText(_builder.toString());
    this.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def bar() {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append(XtendAutoEditTest.CARET, "\t");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertEditor(_builder_1.toString());
  }
  
  public void testFeatureCallParentheses() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bar() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("toString");
    _builder.append(XtendAutoEditTest.CARET, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.configureByText(_builder.toString());
    this.myFixture.type("(");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def bar() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("toString(");
    _builder_1.append(XtendAutoEditTest.CARET, "\t\t");
    _builder_1.append(")");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertEditor(_builder_1.toString());
  }
  
  public void testArrayBrackets() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bar(int");
    _builder.append(XtendAutoEditTest.CARET, "\t");
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    this.configureByText(_builder.toString());
    this.myFixture.type("[");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def bar(int[");
    _builder_1.append(XtendAutoEditTest.CARET, "\t");
    _builder_1.append("])");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertEditor(_builder_1.toString());
  }
  
  @Ignore("Does not work, TypedHandler:214 looks suspicious")
  public void testGuillemets() {
    this.configureByText("\n\t\t\tclass Foo {\n\t\t\t\tdef bar() {\n\t\t\t\t\t\'\'\'<caret>\'\'\'\n\t\t\t\t}\n\t\t\t}\n\t\t");
    this.myFixture.type("«");
    this.assertEditor("\n\t\t\tclass Foo {\n\t\t\t\tdef bar() {\n\t\t\t\t\t\'\'\'«<caret>»\'\'\'\n\t\t\t\t}\n\t\t\t}\n\t\t");
  }
  
  private void newLine() {
    this.myFixture.type("\n");
  }
  
  private void assertEditor(final String editorState) {
    final String normalized = LineDelimiters.toUnix(editorState);
    final int caretPosition = normalized.indexOf(XtendAutoEditTest.CARET);
    String text = normalized;
    if ((caretPosition != (-1))) {
      String _replace = normalized.replace(XtendAutoEditTest.CARET, "");
      text = _replace;
      Editor _editor = this.myFixture.getEditor();
      CaretModel _caretModel = _editor.getCaretModel();
      Caret _primaryCaret = _caretModel.getPrimaryCaret();
      int _offset = _primaryCaret.getOffset();
      TestCase.assertEquals(caretPosition, _offset);
    }
    Editor _editor_1 = this.myFixture.getEditor();
    Document _document = _editor_1.getDocument();
    String _text = _document.getText();
    TestCase.assertEquals(text, _text);
  }
}
