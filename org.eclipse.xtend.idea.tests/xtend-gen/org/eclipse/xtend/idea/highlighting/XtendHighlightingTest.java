/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.highlighting;

import org.eclipse.xtend.idea.LightXtendTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles;

@SuppressWarnings("all")
public class XtendHighlightingTest extends LightXtendTest {
  private final static String Q3 = "\'\'\'";
  
  private final static String GL = "«";
  
  private final static String GR = "»";
  
  public void testKeyWord() {
    this.configureByText("public");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("0-6:");
    _builder.append(HighlightingStyles.KEYWORD_ID);
    _builder.newLineIfNotEmpty();
    this.assertHighlights(_builder.toString());
  }
  
  public void testStringLiteral() {
    this.configureByText("\"Foo\"");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("0-5:");
    _builder.append(HighlightingStyles.STRING_ID);
    _builder.newLineIfNotEmpty();
    this.assertHighlights(_builder.toString());
  }
  
  public void testNumberLiteral() {
    this.configureByText("5");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("0-1:");
    _builder.append(HighlightingStyles.NUMBER_ID);
    _builder.newLineIfNotEmpty();
    this.assertHighlights(_builder.toString());
  }
  
  public void testSlComment() {
    this.configureByText("//comment");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("0-9:");
    _builder.append(HighlightingStyles.COMMENT_ID);
    _builder.newLineIfNotEmpty();
    this.assertHighlights(_builder.toString());
  }
  
  public void testMlComment() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/* ");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* comment");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    this.configureByText(_builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("0-18:");
    _builder_1.append(HighlightingStyles.COMMENT_ID);
    _builder_1.newLineIfNotEmpty();
    this.assertHighlights(_builder_1.toString());
  }
  
  public void testRichString_0() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() ");
    _builder.append(XtendHighlightingTest.Q3, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("this is a template");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(XtendHighlightingTest.Q3, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    this.configureByText(_builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("0-5:keyword");
    _builder_1.newLine();
    _builder_1.append("10-11:punctuation");
    _builder_1.newLine();
    _builder_1.append("13-16:keyword");
    _builder_1.newLine();
    _builder_1.append("20-21:punctuation");
    _builder_1.newLine();
    _builder_1.append("21-22:punctuation");
    _builder_1.newLine();
    _builder_1.append("23-52:xtend.richText");
    _builder_1.newLine();
    _builder_1.append("53-54:punctuation");
    _builder_1.newLine();
    this.assertHighlights(_builder_1.toString());
  }
  
  public void ignoreRichString_1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() ");
    _builder.append(XtendHighlightingTest.Q3, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("this is a ");
    _builder.append(XtendHighlightingTest.GL, "\t\t");
    _builder.append("\'foo\'");
    _builder.append(XtendHighlightingTest.GR, "\t\t");
    _builder.append(" template");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append(XtendHighlightingTest.Q3, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    this.configureByText(_builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("0-5:keyword");
    _builder_1.newLine();
    _builder_1.append("10-11:punctuation");
    _builder_1.newLine();
    _builder_1.append("13-16:keyword");
    _builder_1.newLine();
    _builder_1.append("20-21:punctuation");
    _builder_1.newLine();
    _builder_1.append("21-22:punctuation");
    _builder_1.newLine();
    _builder_1.append("23-39:xtend.richText");
    _builder_1.newLine();
    _builder_1.append("39-40:xtend.richText.delimiter");
    _builder_1.newLine();
    _builder_1.append("40-45:string");
    _builder_1.newLine();
    _builder_1.append("45-46:xtend.richText.delimiter");
    _builder_1.newLine();
    _builder_1.append("46-60:xtend.richText");
    _builder_1.newLine();
    _builder_1.append("61-62:punctuation");
    _builder_1.newLine();
    this.assertHighlights(_builder_1.toString());
  }
  
  public void ignoreRichString_2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() ");
    _builder.append(XtendHighlightingTest.Q3, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("this is a ");
    _builder.append(XtendHighlightingTest.GL, "\t\t");
    _builder.append("\'foo\'");
    _builder.append(XtendHighlightingTest.GR, "\t\t");
    _builder.append(" template");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("this is a ");
    _builder.append(XtendHighlightingTest.GL, "\t\t");
    _builder.append("\'bar\'");
    _builder.append(XtendHighlightingTest.GR, "\t\t");
    _builder.append(" template");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append(XtendHighlightingTest.Q3, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    this.configureByText(_builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("0-5:keyword");
    _builder_1.newLine();
    _builder_1.append("10-11:punctuation");
    _builder_1.newLine();
    _builder_1.append("13-16:keyword");
    _builder_1.newLine();
    _builder_1.append("20-21:punctuation");
    _builder_1.newLine();
    _builder_1.append("21-22:punctuation");
    _builder_1.newLine();
    _builder_1.append("23-39:xtend.richText");
    _builder_1.newLine();
    _builder_1.append("39-40:xtend.richText.delimiter");
    _builder_1.newLine();
    _builder_1.append("40-45:string");
    _builder_1.newLine();
    _builder_1.append("45-46:xtend.richText.delimiter");
    _builder_1.newLine();
    _builder_1.append("46-68:xtend.richText");
    _builder_1.newLine();
    _builder_1.append("68-69:xtend.richText.delimiter");
    _builder_1.newLine();
    _builder_1.append("69-74:string");
    _builder_1.newLine();
    _builder_1.append("74-75:xtend.richText.delimiter");
    _builder_1.newLine();
    _builder_1.append("75-89:xtend.richText");
    _builder_1.newLine();
    _builder_1.append("90-91:punctuation");
    _builder_1.newLine();
    this.assertHighlights(_builder_1.toString());
  }
  
  public void ignoreRichString_3() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() ");
    _builder.append(XtendHighlightingTest.Q3, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("this is a template");
    _builder.append(XtendHighlightingTest.GL, "\t\t");
    _builder.append(XtendHighlightingTest.GL, "\t\t");
    _builder.append(XtendHighlightingTest.GL, "\t\t");
    _builder.append(" comment");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append(XtendHighlightingTest.Q3, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    this.configureByText(_builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("0-5:keyword");
    _builder_1.newLine();
    _builder_1.append("10-11:punctuation");
    _builder_1.newLine();
    _builder_1.append("13-16:keyword");
    _builder_1.newLine();
    _builder_1.append("20-21:punctuation");
    _builder_1.newLine();
    _builder_1.append("21-22:punctuation");
    _builder_1.newLine();
    _builder_1.append("23-47:xtend.richText");
    _builder_1.newLine();
    _builder_1.append("47-50:xtend.richText.delimiter");
    _builder_1.newLine();
    _builder_1.append("64-65:punctuation");
    _builder_1.newLine();
    this.assertHighlights(_builder_1.toString());
  }
}
