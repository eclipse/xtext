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
  
  private final static String NL = "§";
  
  protected void checkHighlight(final CharSequence text) {
    String _string = text.toString();
    String _replace = _string.replace(XtendSemanticHighlightingTest.NL, "\n");
    this.myFixture.addFileToProject("Foo.xtend", _replace);
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
  
  protected String $(final String xtextStyle, final String text) {
    return (((("<symbolName descr=\"" + xtextStyle) + "\">") + text) + "</symbolName>");
  }
  
  protected String white(final String whitespace) {
    return this.$(XtendHighlightingStyles.INSIGNIFICANT_TEMPLATE_TEXT, whitespace);
  }
  
  public void testPrimitiveTypeIsKeyword() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def ");
    String _$ = this.$(HighlightingStyles.KEYWORD_ID, "void");
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
    String _$ = this.$(HighlightingStyles.KEYWORD_ID, "this");
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
    String _$ = this.$(HighlightingStyles.KEYWORD_ID, "it");
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
    String _$ = this.$(XbaseHighlightingStyles.STATIC_FIELD, "foo");
    _builder.append(_$, "\t");
    _builder.append(" = true");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("def bar() { ");
    String _$_1 = this.$(XbaseHighlightingStyles.STATIC_FIELD, "foo");
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
    String _$ = this.$(XbaseHighlightingStyles.STATIC_METHOD_INVOCATION, "foo");
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
    String _$ = this.$(XbaseHighlightingStyles.FIELD, "foo");
    _builder.append(_$, "\t");
    _builder.append(" = null");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    this.checkHighlight(_builder);
  }
  
  public void testAnnotation() {
    StringConcatenation _builder = new StringConcatenation();
    String _$ = this.$(XbaseHighlightingStyles.ANNOTATION, "@");
    _builder.append(_$, "");
    String _$_1 = this.$(XbaseHighlightingStyles.ANNOTATION, "SuppressWarnings");
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
    String _$ = this.$(XbaseHighlightingStyles.EXTENSION_METHOD_INVOCATION, "foo");
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
    String _white = this.white(XtendSemanticHighlightingTest.Q3);
    _builder.append(_white, "\t");
    String _$ = this.$(XtendHighlightingStyles.INSIGNIFICANT_TEMPLATE_TEXT, XtendSemanticHighlightingTest.NL);
    _builder.append(_$, "\t");
    String _white_1 = this.white("\t\t");
    _builder.append(_white_1, "\t");
    _builder.append("this is a template");
    String _$_1 = this.$(XtendHighlightingStyles.SEMANTIC_LINE_BREAK, XtendSemanticHighlightingTest.NL);
    _builder.append(_$_1, "\t");
    String _white_2 = this.white("\t");
    _builder.append(_white_2, "\t");
    String _white_3 = this.white(XtendSemanticHighlightingTest.Q3);
    _builder.append(_white_3, "\t");
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
    String _white = this.white(XtendSemanticHighlightingTest.Q3);
    _builder.append(_white, "\t");
    String _$ = this.$(XtendHighlightingStyles.INSIGNIFICANT_TEMPLATE_TEXT, XtendSemanticHighlightingTest.NL);
    _builder.append(_$, "\t");
    String _white_1 = this.white("\t\t");
    _builder.append(_white_1, "\t");
    _builder.append("this is not indented");
    String _$_1 = this.$(XtendHighlightingStyles.SEMANTIC_LINE_BREAK, XtendSemanticHighlightingTest.NL);
    _builder.append(_$_1, "\t");
    String _white_2 = this.white("\t\t");
    _builder.append(_white_2, "\t");
    _builder.append("\tthis is indented");
    String _$_2 = this.$(XtendHighlightingStyles.SEMANTIC_LINE_BREAK, XtendSemanticHighlightingTest.NL);
    _builder.append(_$_2, "\t");
    String _white_3 = this.white("\t\t");
    _builder.append(_white_3, "\t");
    _builder.append("this is not indented");
    String _$_3 = this.$(XtendHighlightingStyles.SEMANTIC_LINE_BREAK, XtendSemanticHighlightingTest.NL);
    _builder.append(_$_3, "\t");
    String _white_4 = this.white("\t");
    _builder.append(_white_4, "\t");
    String _white_5 = this.white(XtendSemanticHighlightingTest.Q3);
    _builder.append(_white_5, "\t");
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
    String _white = this.white(XtendSemanticHighlightingTest.Q3);
    _builder.append(_white, "\t");
    String _$ = this.$(XtendHighlightingStyles.INSIGNIFICANT_TEMPLATE_TEXT, XtendSemanticHighlightingTest.NL);
    _builder.append(_$, "\t");
    String _white_1 = this.white("\t\t");
    _builder.append(_white_1, "\t");
    _builder.append("this is not indented");
    String _$_1 = this.$(XtendHighlightingStyles.SEMANTIC_LINE_BREAK, XtendSemanticHighlightingTest.NL);
    _builder.append(_$_1, "\t");
    String _white_2 = this.white("\t\t");
    _builder.append(_white_2, "\t");
    _builder.append(XtendSemanticHighlightingTest.GL, "\t");
    _builder.append("FOR i:nums");
    _builder.append(XtendSemanticHighlightingTest.GR, "\t");
    String _$_2 = this.$(XtendHighlightingStyles.INSIGNIFICANT_TEMPLATE_TEXT, XtendSemanticHighlightingTest.NL);
    _builder.append(_$_2, "\t");
    String _white_3 = this.white("\t\t");
    _builder.append(_white_3, "\t");
    String _white_4 = this.white("\t");
    _builder.append(_white_4, "\t");
    _builder.append("loop body");
    String _$_3 = this.$(XtendHighlightingStyles.SEMANTIC_LINE_BREAK, XtendSemanticHighlightingTest.NL);
    _builder.append(_$_3, "\t");
    String _white_5 = this.white("\t\t");
    _builder.append(_white_5, "\t");
    _builder.append(XtendSemanticHighlightingTest.GL, "\t");
    _builder.append("ENDFOR");
    _builder.append(XtendSemanticHighlightingTest.GR, "\t");
    String _$_4 = this.$(XtendHighlightingStyles.INSIGNIFICANT_TEMPLATE_TEXT, XtendSemanticHighlightingTest.NL);
    _builder.append(_$_4, "\t");
    String _white_6 = this.white("\t\t");
    _builder.append(_white_6, "\t");
    _builder.append("this is not indented");
    String _$_5 = this.$(XtendHighlightingStyles.SEMANTIC_LINE_BREAK, XtendSemanticHighlightingTest.NL);
    _builder.append(_$_5, "\t");
    String _white_7 = this.white("\t");
    _builder.append(_white_7, "\t");
    String _white_8 = this.white(XtendSemanticHighlightingTest.Q3);
    _builder.append(_white_8, "\t");
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
    String _white = this.white(XtendSemanticHighlightingTest.Q3);
    _builder.append(_white, "\t");
    String _$ = this.$(XtendHighlightingStyles.INSIGNIFICANT_TEMPLATE_TEXT, XtendSemanticHighlightingTest.NL);
    _builder.append(_$, "\t");
    String _white_1 = this.white("\t\t");
    _builder.append(_white_1, "\t");
    _builder.append("this is not indented");
    String _$_1 = this.$(XtendHighlightingStyles.SEMANTIC_LINE_BREAK, XtendSemanticHighlightingTest.NL);
    _builder.append(_$_1, "\t");
    String _white_2 = this.white("\t\t\t");
    _builder.append(_white_2, "\t");
    _builder.append(XtendSemanticHighlightingTest.GL, "\t");
    _builder.append("FOR i:nums");
    _builder.append(XtendSemanticHighlightingTest.GR, "\t");
    String _$_2 = this.$(XtendHighlightingStyles.INSIGNIFICANT_TEMPLATE_TEXT, XtendSemanticHighlightingTest.NL);
    _builder.append(_$_2, "\t");
    String _white_3 = this.white("\t\t");
    _builder.append(_white_3, "\t");
    _builder.append("\t");
    String _white_4 = this.white("\t");
    _builder.append(_white_4, "\t");
    _builder.append("loop body");
    String _$_3 = this.$(XtendHighlightingStyles.SEMANTIC_LINE_BREAK, XtendSemanticHighlightingTest.NL);
    _builder.append(_$_3, "\t");
    String _white_5 = this.white("\t\t\t");
    _builder.append(_white_5, "\t");
    _builder.append(XtendSemanticHighlightingTest.GL, "\t");
    _builder.append("ENDFOR");
    _builder.append(XtendSemanticHighlightingTest.GR, "\t");
    String _$_4 = this.$(XtendHighlightingStyles.INSIGNIFICANT_TEMPLATE_TEXT, XtendSemanticHighlightingTest.NL);
    _builder.append(_$_4, "\t");
    String _white_6 = this.white("\t\t");
    _builder.append(_white_6, "\t");
    _builder.append("this is not indented");
    String _$_5 = this.$(XtendHighlightingStyles.SEMANTIC_LINE_BREAK, XtendSemanticHighlightingTest.NL);
    _builder.append(_$_5, "\t");
    String _white_7 = this.white("\t");
    _builder.append(_white_7, "\t");
    String _white_8 = this.white(XtendSemanticHighlightingTest.Q3);
    _builder.append(_white_8, "\t");
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
    String _white = this.white(XtendSemanticHighlightingTest.Q3);
    _builder.append(_white, "\t");
    String _$ = this.$(XtendHighlightingStyles.INSIGNIFICANT_TEMPLATE_TEXT, XtendSemanticHighlightingTest.NL);
    _builder.append(_$, "\t");
    String _white_1 = this.white("\t\t");
    _builder.append(_white_1, "\t");
    _builder.append("this is not indented");
    String _$_1 = this.$(XtendHighlightingStyles.SEMANTIC_LINE_BREAK, XtendSemanticHighlightingTest.NL);
    _builder.append(_$_1, "\t");
    String _$_2 = this.$(HighlightingStyles.COMMENT_ID, (((XtendSemanticHighlightingTest.GL + XtendSemanticHighlightingTest.GL) + XtendSemanticHighlightingTest.GL) + " a comment"));
    _builder.append(_$_2, "\t");
    _builder.newLineIfNotEmpty();
    String _white_2 = this.white("\t\t");
    _builder.append(_white_2, "");
    _builder.append("this is not indented");
    String _$_3 = this.$(XtendHighlightingStyles.SEMANTIC_LINE_BREAK, XtendSemanticHighlightingTest.NL);
    _builder.append(_$_3, "");
    String _white_3 = this.white("\t");
    _builder.append(_white_3, "");
    String _white_4 = this.white(XtendSemanticHighlightingTest.Q3);
    _builder.append(_white_4, "");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    this.checkHighlight(_builder);
  }
}
