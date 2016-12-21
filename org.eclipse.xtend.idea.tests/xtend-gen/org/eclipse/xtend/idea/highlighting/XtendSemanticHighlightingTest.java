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
    final Procedure1<HighlightTestInfo> _function = (HighlightTestInfo it) -> {
      it.checkSymbolNames();
      it.test();
    };
    ObjectExtensions.<HighlightTestInfo>operator_doubleArrow(_testFile, _function);
  }
  
  protected CharSequence $(final String xtextStyle, final CharSequence text) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<symbolName descr=\"");
    _builder.append(xtextStyle);
    _builder.append("\">");
    _builder.append(text);
    _builder.append("</symbolName>");
    return _builder;
  }
  
  protected CharSequence white(final String whitespace) {
    return this.$(XtendHighlightingStyles.INSIGNIFICANT_TEMPLATE_TEXT, whitespace);
  }
  
  public void testPrimitiveTypeIsKeyword() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class ");
    CharSequence _$ = this.$(XbaseHighlightingStyles.CLASS, "Foo");
    _builder.append(_$);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("def ");
    CharSequence _$_1 = this.$(HighlightingStyles.KEYWORD_ID, "void");
    _builder.append(_$_1, "\t");
    _builder.append(" ");
    CharSequence _$_2 = this.$(XbaseHighlightingStyles.METHOD, "foo");
    _builder.append(_$_2, "\t");
    _builder.append("() {}");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    this.checkHighlight(_builder);
  }
  
  public void testThisIsKeyword() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class ");
    CharSequence _$ = this.$(XbaseHighlightingStyles.CLASS, "Foo");
    _builder.append(_$);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("def ");
    CharSequence _$_1 = this.$(XbaseHighlightingStyles.METHOD, "foo");
    _builder.append(_$_1, "\t");
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    CharSequence _$_2 = this.$(HighlightingStyles.KEYWORD_ID, "this");
    _builder.append(_$_2, "\t\t");
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
    _builder.append("class ");
    CharSequence _$ = this.$(XbaseHighlightingStyles.CLASS, "Foo");
    _builder.append(_$);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("def ");
    CharSequence _$_1 = this.$(XbaseHighlightingStyles.METHOD, "foo");
    _builder.append(_$_1, "\t");
    _builder.append("(");
    CharSequence _$_2 = this.$(XbaseHighlightingStyles.CLASS, "String");
    _builder.append(_$_2, "\t");
    _builder.append(" ");
    CharSequence _$_3 = this.$(HighlightingStyles.KEYWORD_ID, "it");
    _builder.append(_$_3, "\t");
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
    _builder.append("class ");
    CharSequence _$ = this.$(XbaseHighlightingStyles.CLASS, "Foo");
    _builder.append(_$);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("static val ");
    CharSequence _$_1 = this.$(XbaseHighlightingStyles.STATIC_FINAL_FIELD, "foo");
    CharSequence _$_2 = this.$(XbaseHighlightingStyles.STATIC_FIELD, _$_1);
    CharSequence _$_3 = this.$(XbaseHighlightingStyles.FIELD, _$_2);
    _builder.append(_$_3, "\t");
    _builder.append(" = true");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("def ");
    CharSequence _$_4 = this.$(XbaseHighlightingStyles.METHOD, "bar");
    _builder.append(_$_4, "\t");
    _builder.append("() { ");
    CharSequence _$_5 = this.$(XbaseHighlightingStyles.STATIC_FINAL_FIELD, "foo");
    CharSequence _$_6 = this.$(XbaseHighlightingStyles.STATIC_FIELD, _$_5);
    CharSequence _$_7 = this.$(XbaseHighlightingStyles.FIELD, _$_6);
    _builder.append(_$_7, "\t");
    _builder.append(" }");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    this.checkHighlight(_builder);
  }
  
  public void testStaticMethod() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class ");
    CharSequence _$ = this.$(XbaseHighlightingStyles.CLASS, "Foo");
    _builder.append(_$);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("static def ");
    CharSequence _$_1 = this.$(XbaseHighlightingStyles.METHOD, "foo");
    _builder.append(_$_1, "\t");
    _builder.append("() {}");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("def ");
    CharSequence _$_2 = this.$(XbaseHighlightingStyles.METHOD, "bar");
    _builder.append(_$_2, "\t");
    _builder.append("() { ");
    CharSequence _$_3 = this.$(XbaseHighlightingStyles.STATIC_METHOD_INVOCATION, "foo");
    CharSequence _$_4 = this.$(XbaseHighlightingStyles.METHOD, _$_3);
    _builder.append(_$_4, "\t");
    _builder.append(" }");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    this.checkHighlight(_builder);
  }
  
  public void testField() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class ");
    CharSequence _$ = this.$(XbaseHighlightingStyles.CLASS, "Foo");
    _builder.append(_$);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("val ");
    CharSequence _$_1 = this.$(XbaseHighlightingStyles.FIELD, "foo");
    _builder.append(_$_1, "\t");
    _builder.append(" = null");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    this.checkHighlight(_builder);
  }
  
  public void testAnnotation() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _$ = this.$(XbaseHighlightingStyles.ANNOTATION, "@");
    _builder.append(_$);
    CharSequence _$_1 = this.$(XbaseHighlightingStyles.ANNOTATION, "SuppressWarnings");
    _builder.append(_$_1);
    _builder.append("(\"all\")");
    _builder.newLineIfNotEmpty();
    _builder.append("class ");
    CharSequence _$_2 = this.$(XbaseHighlightingStyles.CLASS, "Foo");
    _builder.append(_$_2);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    this.checkHighlight(_builder);
  }
  
  public void testExtensionMethod() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class ");
    CharSequence _$ = this.$(XbaseHighlightingStyles.CLASS, "Foo");
    _builder.append(_$);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("def ");
    CharSequence _$_1 = this.$(XbaseHighlightingStyles.METHOD, "foo");
    _builder.append(_$_1, "\t");
    _builder.append("(");
    CharSequence _$_2 = this.$(XbaseHighlightingStyles.CLASS, "String");
    _builder.append(_$_2, "\t");
    _builder.append(" ");
    CharSequence _$_3 = this.$(XbaseHighlightingStyles.PARAMETER_VARIABLE, "x");
    _builder.append(_$_3, "\t");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def ");
    CharSequence _$_4 = this.$(XbaseHighlightingStyles.METHOD, "bar");
    _builder.append(_$_4, "\t");
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("\'\'.");
    CharSequence _$_5 = this.$(XbaseHighlightingStyles.METHOD, "foo");
    CharSequence _$_6 = this.$(XbaseHighlightingStyles.EXTENSION_METHOD_INVOCATION, _$_5);
    _builder.append(_$_6, "\t\t");
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
    _builder.append("class ");
    CharSequence _$ = this.$(XbaseHighlightingStyles.CLASS, "Foo");
    _builder.append(_$);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("def ");
    CharSequence _$_1 = this.$(XbaseHighlightingStyles.METHOD, "foo");
    _builder.append(_$_1, "\t");
    _builder.append("() ");
    CharSequence _white = this.white(XtendSemanticHighlightingTest.Q3);
    _builder.append(_white, "\t");
    CharSequence _$_2 = this.$(XtendHighlightingStyles.INSIGNIFICANT_TEMPLATE_TEXT, XtendSemanticHighlightingTest.NL);
    _builder.append(_$_2, "\t");
    CharSequence _white_1 = this.white("\t\t");
    _builder.append(_white_1, "\t");
    _builder.append("this is a template");
    CharSequence _$_3 = this.$(XtendHighlightingStyles.SEMANTIC_LINE_BREAK, XtendSemanticHighlightingTest.NL);
    _builder.append(_$_3, "\t");
    CharSequence _white_2 = this.white("\t");
    _builder.append(_white_2, "\t");
    CharSequence _white_3 = this.white(XtendSemanticHighlightingTest.Q3);
    _builder.append(_white_3, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    this.checkHighlight(_builder);
  }
  
  public void testRichText_1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class ");
    CharSequence _$ = this.$(XbaseHighlightingStyles.CLASS, "Foo");
    _builder.append(_$);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("def ");
    CharSequence _$_1 = this.$(XbaseHighlightingStyles.METHOD, "foo");
    _builder.append(_$_1, "\t");
    _builder.append("() ");
    CharSequence _white = this.white(XtendSemanticHighlightingTest.Q3);
    _builder.append(_white, "\t");
    CharSequence _$_2 = this.$(XtendHighlightingStyles.INSIGNIFICANT_TEMPLATE_TEXT, XtendSemanticHighlightingTest.NL);
    _builder.append(_$_2, "\t");
    CharSequence _white_1 = this.white("\t\t");
    _builder.append(_white_1, "\t");
    _builder.append("this is not indented");
    CharSequence _$_3 = this.$(XtendHighlightingStyles.SEMANTIC_LINE_BREAK, XtendSemanticHighlightingTest.NL);
    _builder.append(_$_3, "\t");
    CharSequence _white_2 = this.white("\t\t");
    _builder.append(_white_2, "\t");
    _builder.append("\tthis is indented");
    CharSequence _$_4 = this.$(XtendHighlightingStyles.SEMANTIC_LINE_BREAK, XtendSemanticHighlightingTest.NL);
    _builder.append(_$_4, "\t");
    CharSequence _white_3 = this.white("\t\t");
    _builder.append(_white_3, "\t");
    _builder.append("this is not indented");
    CharSequence _$_5 = this.$(XtendHighlightingStyles.SEMANTIC_LINE_BREAK, XtendSemanticHighlightingTest.NL);
    _builder.append(_$_5, "\t");
    CharSequence _white_4 = this.white("\t");
    _builder.append(_white_4, "\t");
    CharSequence _white_5 = this.white(XtendSemanticHighlightingTest.Q3);
    _builder.append(_white_5, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    this.checkHighlight(_builder);
  }
  
  public void ignoreRichText_2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class ");
    CharSequence _$ = this.$(XbaseHighlightingStyles.CLASS, "Foo");
    _builder.append(_$);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("def ");
    CharSequence _$_1 = this.$(XbaseHighlightingStyles.METHOD, "foo");
    _builder.append(_$_1, "\t");
    _builder.append("(");
    CharSequence _$_2 = this.$(XbaseHighlightingStyles.CLASS, "String");
    _builder.append(_$_2, "\t");
    _builder.append("[] ");
    CharSequence _$_3 = this.$(XbaseHighlightingStyles.PARAMETER_VARIABLE, "nums");
    _builder.append(_$_3, "\t");
    _builder.append(") ");
    CharSequence _white = this.white(XtendSemanticHighlightingTest.Q3);
    _builder.append(_white, "\t");
    CharSequence _$_4 = this.$(XtendHighlightingStyles.INSIGNIFICANT_TEMPLATE_TEXT, XtendSemanticHighlightingTest.NL);
    _builder.append(_$_4, "\t");
    CharSequence _white_1 = this.white("\t\t");
    _builder.append(_white_1, "\t");
    _builder.append("this is not indented");
    CharSequence _$_5 = this.$(XtendHighlightingStyles.SEMANTIC_LINE_BREAK, XtendSemanticHighlightingTest.NL);
    _builder.append(_$_5, "\t");
    CharSequence _white_2 = this.white("\t\t");
    _builder.append(_white_2, "\t");
    _builder.append(XtendSemanticHighlightingTest.GL, "\t");
    _builder.append("FOR ");
    CharSequence _$_6 = this.$(XbaseHighlightingStyles.LOCAL_VARIABLE_DECLARATION, "i");
    CharSequence _$_7 = this.$(XbaseHighlightingStyles.LOCAL_FINAL_VARIABLE_DECLARATION, _$_6);
    _builder.append(_$_7, "\t");
    _builder.append(":");
    CharSequence _$_8 = this.$(XbaseHighlightingStyles.PARAMETER_VARIABLE, "nums");
    _builder.append(_$_8, "\t");
    _builder.append(XtendSemanticHighlightingTest.GR, "\t");
    CharSequence _$_9 = this.$(XtendHighlightingStyles.INSIGNIFICANT_TEMPLATE_TEXT, XtendSemanticHighlightingTest.NL);
    _builder.append(_$_9, "\t");
    CharSequence _white_3 = this.white("\t\t");
    _builder.append(_white_3, "\t");
    CharSequence _white_4 = this.white("\t");
    _builder.append(_white_4, "\t");
    _builder.append("loop body");
    CharSequence _$_10 = this.$(XtendHighlightingStyles.SEMANTIC_LINE_BREAK, XtendSemanticHighlightingTest.NL);
    _builder.append(_$_10, "\t");
    CharSequence _white_5 = this.white("\t\t");
    _builder.append(_white_5, "\t");
    _builder.append(XtendSemanticHighlightingTest.GL, "\t");
    _builder.append("ENDFOR");
    _builder.append(XtendSemanticHighlightingTest.GR, "\t");
    CharSequence _$_11 = this.$(XtendHighlightingStyles.INSIGNIFICANT_TEMPLATE_TEXT, XtendSemanticHighlightingTest.NL);
    _builder.append(_$_11, "\t");
    CharSequence _white_6 = this.white("\t\t");
    _builder.append(_white_6, "\t");
    _builder.append("this is not indented");
    CharSequence _$_12 = this.$(XtendHighlightingStyles.SEMANTIC_LINE_BREAK, XtendSemanticHighlightingTest.NL);
    _builder.append(_$_12, "\t");
    CharSequence _white_7 = this.white("\t");
    _builder.append(_white_7, "\t");
    CharSequence _white_8 = this.white(XtendSemanticHighlightingTest.Q3);
    _builder.append(_white_8, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    this.checkHighlight(_builder);
  }
  
  public void ignoreRichText_3() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class ");
    CharSequence _$ = this.$(XbaseHighlightingStyles.CLASS, "Foo");
    _builder.append(_$);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("def ");
    CharSequence _$_1 = this.$(XbaseHighlightingStyles.METHOD, "foo");
    _builder.append(_$_1, "\t");
    _builder.append("(");
    CharSequence _$_2 = this.$(XbaseHighlightingStyles.CLASS, "String");
    _builder.append(_$_2, "\t");
    _builder.append("[] ");
    CharSequence _$_3 = this.$(XbaseHighlightingStyles.PARAMETER_VARIABLE, "nums");
    _builder.append(_$_3, "\t");
    _builder.append(") ");
    CharSequence _white = this.white(XtendSemanticHighlightingTest.Q3);
    _builder.append(_white, "\t");
    CharSequence _$_4 = this.$(XtendHighlightingStyles.INSIGNIFICANT_TEMPLATE_TEXT, XtendSemanticHighlightingTest.NL);
    _builder.append(_$_4, "\t");
    CharSequence _white_1 = this.white("\t\t");
    _builder.append(_white_1, "\t");
    _builder.append("this is not indented");
    CharSequence _$_5 = this.$(XtendHighlightingStyles.SEMANTIC_LINE_BREAK, XtendSemanticHighlightingTest.NL);
    _builder.append(_$_5, "\t");
    CharSequence _white_2 = this.white("\t\t\t");
    _builder.append(_white_2, "\t");
    _builder.append(XtendSemanticHighlightingTest.GL, "\t");
    _builder.append("FOR ");
    CharSequence _$_6 = this.$(XbaseHighlightingStyles.LOCAL_VARIABLE_DECLARATION, "i");
    CharSequence _$_7 = this.$(XbaseHighlightingStyles.LOCAL_FINAL_VARIABLE_DECLARATION, _$_6);
    _builder.append(_$_7, "\t");
    _builder.append(":");
    CharSequence _$_8 = this.$(XbaseHighlightingStyles.PARAMETER_VARIABLE, "nums");
    _builder.append(_$_8, "\t");
    _builder.append(XtendSemanticHighlightingTest.GR, "\t");
    CharSequence _$_9 = this.$(XtendHighlightingStyles.INSIGNIFICANT_TEMPLATE_TEXT, XtendSemanticHighlightingTest.NL);
    _builder.append(_$_9, "\t");
    CharSequence _white_3 = this.white("\t\t");
    _builder.append(_white_3, "\t");
    _builder.append("\t");
    CharSequence _white_4 = this.white("\t");
    _builder.append(_white_4, "\t");
    _builder.append("loop body");
    CharSequence _$_10 = this.$(XtendHighlightingStyles.SEMANTIC_LINE_BREAK, XtendSemanticHighlightingTest.NL);
    _builder.append(_$_10, "\t");
    CharSequence _white_5 = this.white("\t\t\t");
    _builder.append(_white_5, "\t");
    _builder.append(XtendSemanticHighlightingTest.GL, "\t");
    _builder.append("ENDFOR");
    _builder.append(XtendSemanticHighlightingTest.GR, "\t");
    CharSequence _$_11 = this.$(XtendHighlightingStyles.INSIGNIFICANT_TEMPLATE_TEXT, XtendSemanticHighlightingTest.NL);
    _builder.append(_$_11, "\t");
    CharSequence _white_6 = this.white("\t\t");
    _builder.append(_white_6, "\t");
    _builder.append("this is not indented");
    CharSequence _$_12 = this.$(XtendHighlightingStyles.SEMANTIC_LINE_BREAK, XtendSemanticHighlightingTest.NL);
    _builder.append(_$_12, "\t");
    CharSequence _white_7 = this.white("\t");
    _builder.append(_white_7, "\t");
    CharSequence _white_8 = this.white(XtendSemanticHighlightingTest.Q3);
    _builder.append(_white_8, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    this.checkHighlight(_builder);
  }
  
  public void ignoreRichText_4() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class ");
    CharSequence _$ = this.$(XbaseHighlightingStyles.CLASS, "Foo");
    _builder.append(_$);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("def ");
    CharSequence _$_1 = this.$(XbaseHighlightingStyles.METHOD, "foo");
    _builder.append(_$_1, "\t");
    _builder.append("() ");
    CharSequence _white = this.white(XtendSemanticHighlightingTest.Q3);
    _builder.append(_white, "\t");
    CharSequence _$_2 = this.$(XtendHighlightingStyles.INSIGNIFICANT_TEMPLATE_TEXT, XtendSemanticHighlightingTest.NL);
    _builder.append(_$_2, "\t");
    CharSequence _white_1 = this.white("\t\t");
    _builder.append(_white_1, "\t");
    _builder.append("this is not indented");
    CharSequence _$_3 = this.$(XtendHighlightingStyles.SEMANTIC_LINE_BREAK, XtendSemanticHighlightingTest.NL);
    _builder.append(_$_3, "\t");
    CharSequence _$_4 = this.$(HighlightingStyles.COMMENT_ID, (((XtendSemanticHighlightingTest.GL + XtendSemanticHighlightingTest.GL) + XtendSemanticHighlightingTest.GL) + " a comment"));
    _builder.append(_$_4, "\t");
    _builder.newLineIfNotEmpty();
    CharSequence _white_2 = this.white("\t\t");
    _builder.append(_white_2);
    _builder.append("this is not indented");
    CharSequence _$_5 = this.$(XtendHighlightingStyles.SEMANTIC_LINE_BREAK, XtendSemanticHighlightingTest.NL);
    _builder.append(_$_5);
    CharSequence _white_3 = this.white("\t");
    _builder.append(_white_3);
    CharSequence _white_4 = this.white(XtendSemanticHighlightingTest.Q3);
    _builder.append(_white_4);
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    this.checkHighlight(_builder);
  }
}
