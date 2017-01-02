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
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field myFixture is undefined"
      + "\nThe method or field myFixture is undefined"
      + "\nThe method or field checkSymbolNames is undefined"
      + "\nThe method or field test is undefined"
      + "\naddFileToProject cannot be resolved"
      + "\ntestFile cannot be resolved"
      + "\n=> cannot be resolved");
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
  
  protected Object white(final String whitespace) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field INSIGNIFICANT_TEMPLATE_TEXT is undefined"
      + "\n$ cannot be resolved");
  }
  
  public void testPrimitiveTypeIsKeyword() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field CLASS is undefined"
      + "\nThe method or field KEYWORD_ID is undefined"
      + "\nThe method or field METHOD is undefined"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved");
  }
  
  public void testThisIsKeyword() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field CLASS is undefined"
      + "\nThe method or field METHOD is undefined"
      + "\nThe method or field KEYWORD_ID is undefined"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved");
  }
  
  public void testItIsKeyword() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field CLASS is undefined"
      + "\nThe method or field METHOD is undefined"
      + "\nThe method or field CLASS is undefined"
      + "\nThe method or field KEYWORD_ID is undefined"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved");
  }
  
  public void testStaticField() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field CLASS is undefined"
      + "\nThe method or field FIELD is undefined"
      + "\nThe method or field STATIC_FIELD is undefined"
      + "\nThe method or field STATIC_FINAL_FIELD is undefined"
      + "\nThe method or field METHOD is undefined"
      + "\nThe method or field FIELD is undefined"
      + "\nThe method or field STATIC_FIELD is undefined"
      + "\nThe method or field STATIC_FINAL_FIELD is undefined"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved");
  }
  
  public void testStaticMethod() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field CLASS is undefined"
      + "\nThe method or field METHOD is undefined"
      + "\nThe method or field METHOD is undefined"
      + "\nThe method or field METHOD is undefined"
      + "\nThe method or field STATIC_METHOD_INVOCATION is undefined"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved");
  }
  
  public void testField() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field CLASS is undefined"
      + "\nThe method or field FIELD is undefined"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved");
  }
  
  public void testAnnotation() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field ANNOTATION is undefined"
      + "\nThe method or field ANNOTATION is undefined"
      + "\nThe method or field CLASS is undefined"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved");
  }
  
  public void testExtensionMethod() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field CLASS is undefined"
      + "\nThe method or field METHOD is undefined"
      + "\nThe method or field CLASS is undefined"
      + "\nThe method or field PARAMETER_VARIABLE is undefined"
      + "\nThe method or field METHOD is undefined"
      + "\nThe method or field EXTENSION_METHOD_INVOCATION is undefined"
      + "\nThe method or field METHOD is undefined"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved");
  }
  
  public void testRichText_0() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field CLASS is undefined"
      + "\nThe method or field METHOD is undefined"
      + "\nThe method or field INSIGNIFICANT_TEMPLATE_TEXT is undefined"
      + "\nThe method or field SEMANTIC_LINE_BREAK is undefined"
      + "\nThe method white(String) from the type XtendSemanticHighlightingTest refers to the missing type Object"
      + "\nThe method white(String) from the type XtendSemanticHighlightingTest refers to the missing type Object"
      + "\nThe method white(String) from the type XtendSemanticHighlightingTest refers to the missing type Object"
      + "\nThe method white(String) from the type XtendSemanticHighlightingTest refers to the missing type Object"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved");
  }
  
  public void testRichText_1() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field CLASS is undefined"
      + "\nThe method or field METHOD is undefined"
      + "\nThe method or field INSIGNIFICANT_TEMPLATE_TEXT is undefined"
      + "\nThe method or field SEMANTIC_LINE_BREAK is undefined"
      + "\nThe method or field SEMANTIC_LINE_BREAK is undefined"
      + "\nThe method or field SEMANTIC_LINE_BREAK is undefined"
      + "\nThe method white(String) from the type XtendSemanticHighlightingTest refers to the missing type Object"
      + "\nThe method white(String) from the type XtendSemanticHighlightingTest refers to the missing type Object"
      + "\nThe method white(String) from the type XtendSemanticHighlightingTest refers to the missing type Object"
      + "\nThe method white(String) from the type XtendSemanticHighlightingTest refers to the missing type Object"
      + "\nThe method white(String) from the type XtendSemanticHighlightingTest refers to the missing type Object"
      + "\nThe method white(String) from the type XtendSemanticHighlightingTest refers to the missing type Object"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved");
  }
  
  public void ignoreRichText_2() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field CLASS is undefined"
      + "\nThe method or field METHOD is undefined"
      + "\nThe method or field CLASS is undefined"
      + "\nThe method or field PARAMETER_VARIABLE is undefined"
      + "\nThe method or field INSIGNIFICANT_TEMPLATE_TEXT is undefined"
      + "\nThe method or field SEMANTIC_LINE_BREAK is undefined"
      + "\nThe method or field LOCAL_FINAL_VARIABLE_DECLARATION is undefined"
      + "\nThe method or field LOCAL_VARIABLE_DECLARATION is undefined"
      + "\nThe method or field PARAMETER_VARIABLE is undefined"
      + "\nThe method or field INSIGNIFICANT_TEMPLATE_TEXT is undefined"
      + "\nThe method or field SEMANTIC_LINE_BREAK is undefined"
      + "\nThe method or field INSIGNIFICANT_TEMPLATE_TEXT is undefined"
      + "\nThe method or field SEMANTIC_LINE_BREAK is undefined"
      + "\nThe method white(String) from the type XtendSemanticHighlightingTest refers to the missing type Object"
      + "\nThe method white(String) from the type XtendSemanticHighlightingTest refers to the missing type Object"
      + "\nThe method white(String) from the type XtendSemanticHighlightingTest refers to the missing type Object"
      + "\nThe method white(String) from the type XtendSemanticHighlightingTest refers to the missing type Object"
      + "\nThe method white(String) from the type XtendSemanticHighlightingTest refers to the missing type Object"
      + "\nThe method white(String) from the type XtendSemanticHighlightingTest refers to the missing type Object"
      + "\nThe method white(String) from the type XtendSemanticHighlightingTest refers to the missing type Object"
      + "\nThe method white(String) from the type XtendSemanticHighlightingTest refers to the missing type Object"
      + "\nThe method white(String) from the type XtendSemanticHighlightingTest refers to the missing type Object"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved");
  }
  
  public void ignoreRichText_3() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field CLASS is undefined"
      + "\nThe method or field METHOD is undefined"
      + "\nThe method or field CLASS is undefined"
      + "\nThe method or field PARAMETER_VARIABLE is undefined"
      + "\nThe method or field INSIGNIFICANT_TEMPLATE_TEXT is undefined"
      + "\nThe method or field SEMANTIC_LINE_BREAK is undefined"
      + "\nThe method or field LOCAL_FINAL_VARIABLE_DECLARATION is undefined"
      + "\nThe method or field LOCAL_VARIABLE_DECLARATION is undefined"
      + "\nThe method or field PARAMETER_VARIABLE is undefined"
      + "\nThe method or field INSIGNIFICANT_TEMPLATE_TEXT is undefined"
      + "\nThe method or field SEMANTIC_LINE_BREAK is undefined"
      + "\nThe method or field INSIGNIFICANT_TEMPLATE_TEXT is undefined"
      + "\nThe method or field SEMANTIC_LINE_BREAK is undefined"
      + "\nThe method white(String) from the type XtendSemanticHighlightingTest refers to the missing type Object"
      + "\nThe method white(String) from the type XtendSemanticHighlightingTest refers to the missing type Object"
      + "\nThe method white(String) from the type XtendSemanticHighlightingTest refers to the missing type Object"
      + "\nThe method white(String) from the type XtendSemanticHighlightingTest refers to the missing type Object"
      + "\nThe method white(String) from the type XtendSemanticHighlightingTest refers to the missing type Object"
      + "\nThe method white(String) from the type XtendSemanticHighlightingTest refers to the missing type Object"
      + "\nThe method white(String) from the type XtendSemanticHighlightingTest refers to the missing type Object"
      + "\nThe method white(String) from the type XtendSemanticHighlightingTest refers to the missing type Object"
      + "\nThe method white(String) from the type XtendSemanticHighlightingTest refers to the missing type Object"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved");
  }
  
  public void ignoreRichText_4() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field CLASS is undefined"
      + "\nThe method or field METHOD is undefined"
      + "\nThe method or field INSIGNIFICANT_TEMPLATE_TEXT is undefined"
      + "\nThe method or field SEMANTIC_LINE_BREAK is undefined"
      + "\nThe method or field COMMENT_ID is undefined"
      + "\n+ cannot be resolved."
      + "\nThe method or field SEMANTIC_LINE_BREAK is undefined"
      + "\nThe method white(String) from the type XtendSemanticHighlightingTest refers to the missing type Object"
      + "\nThe method white(String) from the type XtendSemanticHighlightingTest refers to the missing type Object"
      + "\nThe method white(String) from the type XtendSemanticHighlightingTest refers to the missing type Object"
      + "\nThe method white(String) from the type XtendSemanticHighlightingTest refers to the missing type Object"
      + "\nThe method white(String) from the type XtendSemanticHighlightingTest refers to the missing type Object"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved"
      + "\n$ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n$ cannot be resolved");
  }
}
