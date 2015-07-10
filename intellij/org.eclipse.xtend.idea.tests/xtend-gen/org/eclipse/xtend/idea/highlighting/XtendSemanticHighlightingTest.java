/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.highlighting;

import com.intellij.testFramework.HighlightTestInfo;
import org.eclipse.xtend.ide.common.highlighting.XtendHighlightingStyles;
import org.eclipse.xtend.idea.LightXtendTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles;
import org.eclipse.xtext.xbase.ide.highlighting.XbaseHighlightingStyles;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendSemanticHighlightingTest extends LightXtendTest {
  private final static String Q3 = "\'\'\'";
  
  private final static String GL = "«";
  
  private final static String GR = "»";
  
  protected void checkHighlight(final CharSequence text) {
    String _string = text.toString();
    this.myFixture.addFileToProject("Foo.xtend", _string);
    HighlightTestInfo _testFile = this.myFixture.testFile("Foo.xtend");
    final Procedure1<HighlightTestInfo> _function = new Procedure1<HighlightTestInfo>() {
      @Override
      public void apply(final HighlightTestInfo it) {
        it.checkSymbolNames();
        it.test();
      }
    };
    ObjectExtensions.<HighlightTestInfo>operator_doubleArrow(_testFile, _function);
  }
  
  protected CharSequence $(final String xtextStyle, final String text) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<symbolName descr=\"");
    _builder.append(xtextStyle, "");
    _builder.append("\">");
    _builder.append(text, "");
    _builder.append("</symbolName>");
    return _builder;
  }
  
  protected CharSequence white(final String whitespace) {
    return this.$(XtendHighlightingStyles.INSIGNIFICANT_TEMPLATE_TEXT, whitespace);
  }
  
  public void testPrimitiveTypeIsKeyword() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def ");
    CharSequence _$ = this.$(HighlightingStyles.KEYWORD_ID, "void");
    _builder.append(_$, "\t");
    _builder.append(" foo() {}");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    this.checkHighlight(_builder);
  }
  
  public void testThisIsKeyword() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {");
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _$ = this.$(HighlightingStyles.KEYWORD_ID, "this");
    _builder.append(_$, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.checkHighlight(_builder);
  }
  
  public void testItIsKeyword() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo(String ");
    CharSequence _$ = this.$(HighlightingStyles.KEYWORD_ID, "it");
    _builder.append(_$, "\t");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.checkHighlight(_builder);
  }
  
  public void testStaticField() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static val ");
    CharSequence _$ = this.$(XbaseHighlightingStyles.STATIC_FIELD, "foo");
    _builder.append(_$, "\t");
    _builder.append(" = true");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("def bar() { ");
    CharSequence _$_1 = this.$(XbaseHighlightingStyles.STATIC_FIELD, "foo");
    _builder.append(_$_1, "\t");
    _builder.append(" }");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    this.checkHighlight(_builder);
  }
  
  public void testStaticMethod() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static def foo() {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bar() { ");
    CharSequence _$ = this.$(XbaseHighlightingStyles.STATIC_METHOD_INVOCATION, "foo");
    _builder.append(_$, "\t");
    _builder.append(" }");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    this.checkHighlight(_builder);
  }
  
  public void testField() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val ");
    CharSequence _$ = this.$(XbaseHighlightingStyles.FIELD, "foo");
    _builder.append(_$, "\t");
    _builder.append(" = null");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    this.checkHighlight(_builder);
  }
  
  public void testAnnotation() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _$ = this.$(XbaseHighlightingStyles.ANNOTATION, "@");
    _builder.append(_$, "");
    CharSequence _$_1 = this.$(XbaseHighlightingStyles.ANNOTATION, "SuppressWarnings");
    _builder.append(_$_1, "");
    _builder.append("(\"all\")");
    _builder.newLineIfNotEmpty();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.checkHighlight(_builder);
  }
  
  public void testExtensionMethod() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo(String x) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bar() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("\'\'.");
    CharSequence _$ = this.$(XbaseHighlightingStyles.EXTENSION_METHOD_INVOCATION, "foo");
    _builder.append(_$, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.checkHighlight(_builder);
  }
  
  public void testRichText_0() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() ");
    CharSequence _white = this.white(XtendSemanticHighlightingTest.Q3);
    _builder.append(_white, "\t");
    _builder.newLineIfNotEmpty();
    CharSequence _white_1 = this.white("\t\t");
    _builder.append(_white_1, "");
    _builder.append("this is a template");
    CharSequence _$ = this.$(XtendHighlightingStyles.TEMPLATE_LINE_BREAK, "\n");
    _builder.append(_$, "");
    CharSequence _white_2 = this.white("\t");
    _builder.append(_white_2, "");
    CharSequence _white_3 = this.white(XtendSemanticHighlightingTest.Q3);
    _builder.append(_white_3, "");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    this.checkHighlight(_builder);
  }
  
  public void testRichText_1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() ");
    CharSequence _white = this.white(XtendSemanticHighlightingTest.Q3);
    _builder.append(_white, "\t");
    _builder.newLineIfNotEmpty();
    CharSequence _white_1 = this.white("\t\t");
    _builder.append(_white_1, "");
    _builder.append("this is not indented");
    CharSequence _$ = this.$(XtendHighlightingStyles.TEMPLATE_LINE_BREAK, "\n");
    _builder.append(_$, "");
    CharSequence _white_2 = this.white("\t\t");
    _builder.append(_white_2, "");
    _builder.append("\tthis is indented");
    CharSequence _$_1 = this.$(XtendHighlightingStyles.TEMPLATE_LINE_BREAK, "\n");
    _builder.append(_$_1, "");
    CharSequence _white_3 = this.white("\t\t");
    _builder.append(_white_3, "");
    _builder.append("this is not indented");
    CharSequence _$_2 = this.$(XtendHighlightingStyles.TEMPLATE_LINE_BREAK, "\n");
    _builder.append(_$_2, "");
    CharSequence _white_4 = this.white("\t");
    _builder.append(_white_4, "");
    CharSequence _white_5 = this.white(XtendSemanticHighlightingTest.Q3);
    _builder.append(_white_5, "");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    this.checkHighlight(_builder);
  }
  
  public void testRichText_2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo(String[] nums) ");
    CharSequence _white = this.white(XtendSemanticHighlightingTest.Q3);
    _builder.append(_white, "\t");
    _builder.newLineIfNotEmpty();
    CharSequence _white_1 = this.white("\t\t");
    _builder.append(_white_1, "");
    _builder.append("this is not indented");
    CharSequence _$ = this.$(XtendHighlightingStyles.TEMPLATE_LINE_BREAK, "\n");
    _builder.append(_$, "");
    CharSequence _white_2 = this.white("\t\t");
    _builder.append(_white_2, "");
    _builder.append(XtendSemanticHighlightingTest.GL, "");
    _builder.append("FOR i:nums");
    _builder.append(XtendSemanticHighlightingTest.GR, "");
    _builder.newLineIfNotEmpty();
    CharSequence _white_3 = this.white("\t\t");
    _builder.append(_white_3, "");
    CharSequence _white_4 = this.white("\t");
    _builder.append(_white_4, "");
    _builder.append("loop body");
    CharSequence _$_1 = this.$(XtendHighlightingStyles.TEMPLATE_LINE_BREAK, "\n");
    _builder.append(_$_1, "");
    CharSequence _white_5 = this.white("\t\t");
    _builder.append(_white_5, "");
    _builder.append(XtendSemanticHighlightingTest.GL, "");
    _builder.append("ENDFOR");
    _builder.append(XtendSemanticHighlightingTest.GR, "");
    _builder.newLineIfNotEmpty();
    CharSequence _white_6 = this.white("\t\t");
    _builder.append(_white_6, "");
    _builder.append("this is not indented");
    CharSequence _$_2 = this.$(XtendHighlightingStyles.TEMPLATE_LINE_BREAK, "\n");
    _builder.append(_$_2, "");
    CharSequence _white_7 = this.white("\t");
    _builder.append(_white_7, "");
    CharSequence _white_8 = this.white(XtendSemanticHighlightingTest.Q3);
    _builder.append(_white_8, "");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    this.checkHighlight(_builder);
  }
  
  public void testRichText_3() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo(String[] nums) ");
    CharSequence _white = this.white(XtendSemanticHighlightingTest.Q3);
    _builder.append(_white, "\t");
    _builder.newLineIfNotEmpty();
    CharSequence _white_1 = this.white("\t\t");
    _builder.append(_white_1, "");
    _builder.append("this is not indented");
    CharSequence _$ = this.$(XtendHighlightingStyles.TEMPLATE_LINE_BREAK, "\n");
    _builder.append(_$, "");
    CharSequence _white_2 = this.white("\t\t\t");
    _builder.append(_white_2, "");
    _builder.append(XtendSemanticHighlightingTest.GL, "");
    _builder.append("FOR i:nums");
    _builder.append(XtendSemanticHighlightingTest.GR, "");
    _builder.newLineIfNotEmpty();
    CharSequence _white_3 = this.white("\t\t");
    _builder.append(_white_3, "");
    _builder.append("\t");
    CharSequence _white_4 = this.white("\t");
    _builder.append(_white_4, "");
    _builder.append("loop body");
    CharSequence _$_1 = this.$(XtendHighlightingStyles.TEMPLATE_LINE_BREAK, "\n");
    _builder.append(_$_1, "");
    CharSequence _white_5 = this.white("\t\t\t");
    _builder.append(_white_5, "");
    _builder.append(XtendSemanticHighlightingTest.GL, "");
    _builder.append("ENDFOR");
    _builder.append(XtendSemanticHighlightingTest.GR, "");
    _builder.newLineIfNotEmpty();
    CharSequence _white_6 = this.white("\t\t");
    _builder.append(_white_6, "");
    _builder.append("this is not indented");
    CharSequence _$_2 = this.$(XtendHighlightingStyles.TEMPLATE_LINE_BREAK, "\n");
    _builder.append(_$_2, "");
    CharSequence _white_7 = this.white("\t");
    _builder.append(_white_7, "");
    CharSequence _white_8 = this.white(XtendSemanticHighlightingTest.Q3);
    _builder.append(_white_8, "");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    this.checkHighlight(_builder);
  }
  
  public void testRichText_4() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() ");
    CharSequence _white = this.white(XtendSemanticHighlightingTest.Q3);
    _builder.append(_white, "\t");
    _builder.newLineIfNotEmpty();
    CharSequence _white_1 = this.white("\t\t");
    _builder.append(_white_1, "");
    _builder.append("this is not indented");
    CharSequence _$ = this.$(XtendHighlightingStyles.TEMPLATE_LINE_BREAK, "\n");
    _builder.append(_$, "");
    CharSequence _$_1 = this.$(HighlightingStyles.COMMENT_ID, (((XtendSemanticHighlightingTest.GL + XtendSemanticHighlightingTest.GL) + XtendSemanticHighlightingTest.GL) + " a comment"));
    _builder.append(_$_1, "");
    _builder.newLineIfNotEmpty();
    CharSequence _white_2 = this.white("\t\t");
    _builder.append(_white_2, "");
    _builder.append("this is not indented");
    CharSequence _$_2 = this.$(XtendHighlightingStyles.TEMPLATE_LINE_BREAK, "\n");
    _builder.append(_$_2, "");
    CharSequence _white_3 = this.white("\t");
    _builder.append(_white_3, "");
    CharSequence _white_4 = this.white(XtendSemanticHighlightingTest.Q3);
    _builder.append(_white_4, "");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    this.checkHighlight(_builder);
  }
}
