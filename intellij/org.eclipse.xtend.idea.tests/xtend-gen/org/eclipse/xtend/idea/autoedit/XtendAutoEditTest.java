/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.autoedit;

import com.intellij.openapi.module.Module;
import com.intellij.openapi.roots.ContentEntry;
import com.intellij.openapi.roots.ModifiableRootModel;
import org.eclipse.xtend.core.idea.lang.XtendFileType;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.idea.tests.LibraryUtil;
import org.eclipse.xtext.xbase.idea.formatting.AbstractXbaseAutoEditTest;

@SuppressWarnings("all")
public class XtendAutoEditTest extends AbstractXbaseAutoEditTest {
  public XtendAutoEditTest() {
    super(XtendFileType.INSTANCE);
  }
  
  @Override
  protected void configureModule(final Module module, final ModifiableRootModel model, final ContentEntry contentEntry) {
    LibraryUtil.addXtendLibrary(model);
  }
  
  public void testRichStringComment_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() \'");
    _builder.append("\'\'");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ллл", "\t\t");
    _builder.append(" lalala|");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("\'");
    _builder.append("\'\'");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo() \'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("ллл", "\t\t");
    _builder_1.append(" lalala");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t\t");
    _builder_1.append("|");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void testRichStringComment_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() \'");
    _builder.append("\'\'");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ллл", "\t\t");
    _builder.append(" lalala|");
    _builder.newLineIfNotEmpty();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo() \'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("ллл", "\t\t");
    _builder_1.append(" lalala");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t\t");
    _builder_1.append("|");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void testRichStringComment_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() \'");
    _builder.append("\'\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("л", "\t");
    _builder.append(" lalala|");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("\'");
    _builder.append("\'\'");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo() \'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("л", "\t");
    _builder_1.append(" lalala");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.append("|");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void testRichStringComment_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() \'");
    _builder.append("\'\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("л", "\t");
    _builder.append(" lalala|");
    _builder.newLineIfNotEmpty();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo() \'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("л", "\t");
    _builder_1.append(" lalala");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.append("|");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void testRichStringComment_05() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() \'");
    _builder.append("\'\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("лл", "\t");
    _builder.append(" lalala|");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("\'");
    _builder.append("\'\'");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo() \'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("лл", "\t");
    _builder_1.append(" lalala");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.append("|");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void testRichStringComment_06() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() \'");
    _builder.append("\'\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("лл", "\t");
    _builder.append(" lalala|");
    _builder.newLineIfNotEmpty();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo() \'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("лл", "\t");
    _builder_1.append(" lalala");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.append("|");
    _builder_1.newLine();
    this.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
  
  public void testClassBraces() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {|");
    this.configureByText(_builder.toString());
    this.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|");
    _builder_1.newLine();
    _builder_1.append("}");
    this.assertState(_builder_1.toString());
  }
  
  public void testMethodParentheses() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bar|");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.configureByText(_builder.toString());
    this.myFixture.type("(");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def bar(|)");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertState(_builder_1.toString());
  }
  
  public void testMethodBraces() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bar() {|");
    _builder.newLine();
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
    _builder_1.append("|");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertState(_builder_1.toString());
  }
  
  public void testFeatureCallParentheses() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bar() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("toString|");
    _builder.newLine();
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
    _builder_1.append("toString(|)");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertState(_builder_1.toString());
  }
  
  public void testArrayBrackets() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bar(int|)");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.configureByText(_builder.toString());
    this.myFixture.type("[");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def bar(int[|])");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertState(_builder_1.toString());
  }
  
  public void testGuillemets() {
    this.configureByText("\n\t\t\tclass Foo {\n\t\t\t\tdef bar() {\n\t\t\t\t\t\'\'\'|\'\'\'\n\t\t\t\t}\n\t\t\t}\n\t\t");
    this.myFixture.type("л");
    this.assertState("\n\t\t\tclass Foo {\n\t\t\t\tdef bar() {\n\t\t\t\t\t\'\'\'л|╗\'\'\'\n\t\t\t\t}\n\t\t\t}\n\t\t");
  }
  
  public void testEnterBetweenMethods_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}|");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bar() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.configureByText(_builder.toString());
    this.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo() {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def bar() {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertState(_builder_1.toString());
  }
  
  public void testEnterBetweenMethods_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("|");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bar() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.configureByText(_builder.toString());
    this.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo() {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def bar() {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertState(_builder_1.toString());
  }
  
  public void testEnterBetweenMethods_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("//lalala|");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bar() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.configureByText(_builder.toString());
    this.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo() {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("//lalala");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def bar() {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertState(_builder_1.toString());
  }
  
  public void testEnterBetweenMethods_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("|//lalala");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bar() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.configureByText(_builder.toString());
    this.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo() {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("|//lalala");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def bar() {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertState(_builder_1.toString());
  }
  
  @Override
  protected void assertAutoIndentOnNewLine(final CharSequence model, final CharSequence expectedModel) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(model, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo() {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append(expectedModel, "\t");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    super.assertAutoIndentOnNewLine(_builder, _builder_1);
  }
}
