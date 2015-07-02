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
import com.intellij.openapi.util.TextRange;
import junit.framework.TestCase;
import org.eclipse.xtend.idea.LightXtendTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.internal.LineDelimiters;

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
    _builder_1.append("\t");
    _builder_1.append(XtendAutoEditTest.CARET, "\t");
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
    _builder_1.append("\t\t");
    _builder_1.append(XtendAutoEditTest.CARET, "\t\t");
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
  
  public void testGuillemets() {
  }
  
  private void newLine() {
    this.myFixture.type("\n");
  }
  
  private void assertEditor(final String editorState) {
    String _replace = editorState.replace(XtendAutoEditTest.CARET, "|");
    final String expectedState = LineDelimiters.toUnix(_replace);
    String _xblockexpression = null;
    {
      Editor _editor = this.myFixture.getEditor();
      CaretModel _caretModel = _editor.getCaretModel();
      Caret _primaryCaret = _caretModel.getPrimaryCaret();
      final int caretOffset = _primaryCaret.getOffset();
      Editor _editor_1 = this.myFixture.getEditor();
      final Document document = _editor_1.getDocument();
      Editor _editor_2 = this.myFixture.getEditor();
      Document _document = _editor_2.getDocument();
      TextRange _textRange = new TextRange(0, caretOffset);
      final String beforeCaret = _document.getText(_textRange);
      Editor _editor_3 = this.myFixture.getEditor();
      Document _document_1 = _editor_3.getDocument();
      int _textLength = document.getTextLength();
      TextRange _textRange_1 = new TextRange(caretOffset, _textLength);
      final String afterCaret = _document_1.getText(_textRange_1);
      _xblockexpression = ((beforeCaret + "|") + afterCaret);
    }
    final String actualState = _xblockexpression;
    TestCase.assertEquals(expectedState, actualState);
  }
}
