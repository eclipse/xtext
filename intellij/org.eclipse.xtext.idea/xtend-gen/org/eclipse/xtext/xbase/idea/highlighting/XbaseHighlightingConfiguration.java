/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.highlighting;

import com.intellij.ide.highlighter.JavaHighlightingColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.CodeInsightColors;
import org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles;
import org.eclipse.xtext.idea.highlighting.DefaultHighlightingConfiguration;
import org.eclipse.xtext.idea.highlighting.IHighlightingConfiguration;
import org.eclipse.xtext.xbase.ide.highlighting.XbaseHighlightingStyles;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class XbaseHighlightingConfiguration extends DefaultHighlightingConfiguration {
  @Override
  public void configure(final IHighlightingConfiguration.IHighlightingStyleAcceptor it) {
    it.addStyle(HighlightingStyles.KEYWORD_ID, "Keyword", JavaHighlightingColors.KEYWORD);
    it.addStyle(HighlightingStyles.PUNCTUATION_ID, "Punctuation", JavaHighlightingColors.DOT);
    it.addStyle(HighlightingStyles.COMMENT_ID, "Comment", JavaHighlightingColors.LINE_COMMENT);
    it.addStyle(HighlightingStyles.STRING_ID, "String", JavaHighlightingColors.STRING);
    it.addStyle(HighlightingStyles.NUMBER_ID, "Number", JavaHighlightingColors.NUMBER);
    it.addStyle(HighlightingStyles.DEFAULT_ID, "Default", HighlighterColors.TEXT);
    it.addStyle(HighlightingStyles.INVALID_TOKEN_ID, "Error", CodeInsightColors.ERRORS_ATTRIBUTES);
    it.addStyle(HighlightingStyles.TASK_ID, "Todo", CodeInsightColors.TODO_DEFAULT_ATTRIBUTES);
    it.addStyle(XbaseHighlightingStyles.INTERFACE, "Interfaces", JavaHighlightingColors.INTERFACE_NAME_ATTRIBUTES);
    it.addStyle(XbaseHighlightingStyles.ENUM, "Enums", JavaHighlightingColors.ENUM_NAME_ATTRIBUTES);
    it.addStyle(XbaseHighlightingStyles.CLASS, "Classes", JavaHighlightingColors.CLASS_NAME_ATTRIBUTES);
    it.addStyle(XbaseHighlightingStyles.ABSTRACT_CLASS, "Abstract classes", JavaHighlightingColors.ABSTRACT_CLASS_NAME_ATTRIBUTES);
    it.addStyle(XbaseHighlightingStyles.ANNOTATION, "Annotations", JavaHighlightingColors.ANNOTATION_NAME_ATTRIBUTES);
    it.addStyle(XbaseHighlightingStyles.FIELD, "Fields", JavaHighlightingColors.INSTANCE_FIELD_ATTRIBUTES);
    it.addStyle(XbaseHighlightingStyles.STATIC_FIELD, "Static fields", JavaHighlightingColors.STATIC_FIELD_ATTRIBUTES);
    it.addStyle(XbaseHighlightingStyles.STATIC_FINAL_FIELD, "Static final fields", JavaHighlightingColors.STATIC_FINAL_FIELD_ATTRIBUTES);
    it.addStyle(XbaseHighlightingStyles.METHOD, "Methods", JavaHighlightingColors.METHOD_DECLARATION_ATTRIBUTES);
    it.addStyle(XbaseHighlightingStyles.STATIC_METHOD_INVOCATION, "Static method invocations", JavaHighlightingColors.STATIC_METHOD_ATTRIBUTES);
    it.addStyle(XbaseHighlightingStyles.ABSTRACT_METHOD_INVOCATION, "Abstract method invocations", JavaHighlightingColors.ABSTRACT_METHOD_ATTRIBUTES);
    it.addStyle(XbaseHighlightingStyles.EXTENSION_METHOD_INVOCATION, "Extension method invocations", JavaHighlightingColors.LOCAL_VARIABLE_ATTRIBUTES);
    it.addStyle(XbaseHighlightingStyles.DEPRECATED_MEMBERS, "Deprecated members", CodeInsightColors.DEPRECATED_ATTRIBUTES);
    it.addStyle(XbaseHighlightingStyles.LOCAL_VARIABLE, "Local variables", JavaHighlightingColors.LOCAL_VARIABLE_ATTRIBUTES);
    it.addStyle(XbaseHighlightingStyles.LOCAL_VARIABLE_DECLARATION, "Local variable declarations", JavaHighlightingColors.LOCAL_VARIABLE_ATTRIBUTES);
    it.addStyle(XbaseHighlightingStyles.LOCAL_FINAL_VARIABLE, "Local final variables", JavaHighlightingColors.LOCAL_VARIABLE_ATTRIBUTES);
    it.addStyle(XbaseHighlightingStyles.LOCAL_FINAL_VARIABLE_DECLARATION, "Local final variable declarations", JavaHighlightingColors.LOCAL_VARIABLE_ATTRIBUTES);
    it.addStyle(XbaseHighlightingStyles.PARAMETER_VARIABLE, "Parameter variables", JavaHighlightingColors.PARAMETER_ATTRIBUTES);
    it.addStyle(XbaseHighlightingStyles.TYPE_VARIABLE, "Type variables", JavaHighlightingColors.TYPE_PARAMETER_NAME_ATTRIBUTES);
    it.addStyle(XbaseHighlightingStyles.TYPE_ARGUMENT, "Type arguments", HighlighterColors.TEXT);
  }
}
