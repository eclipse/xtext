/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.idea.highlighting

import com.intellij.ide.highlighter.JavaHighlightingColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.CodeInsightColors
import org.eclipse.xtext.idea.highlighting.DefaultHighlightingConfiguration

import static org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles.*
import static org.eclipse.xtext.xbase.ide.highlighting.XbaseHighlightingStyles.*

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class XbaseHighlightingConfiguration extends DefaultHighlightingConfiguration {
	
	override configure(IHighlightingStyleAcceptor it) {
		addStyle(KEYWORD_ID, "Keyword", JavaHighlightingColors.KEYWORD) 
		addStyle(PUNCTUATION_ID, "Punctuation", JavaHighlightingColors.DOT)
		addStyle(COMMENT_ID, "Comment", JavaHighlightingColors.LINE_COMMENT)
		addStyle(STRING_ID, "String", JavaHighlightingColors.STRING)
		addStyle(NUMBER_ID, "Number", JavaHighlightingColors.NUMBER)
		addStyle(DEFAULT_ID, "Default", HighlighterColors.TEXT)
		addStyle(INVALID_TOKEN_ID, "Error", CodeInsightColors.ERRORS_ATTRIBUTES)
		addStyle(TASK_ID, "Todo", CodeInsightColors.TODO_DEFAULT_ATTRIBUTES)

		addStyle(INTERFACE, "Interfaces", JavaHighlightingColors.INTERFACE_NAME_ATTRIBUTES)
		addStyle(ENUM, "Enums", JavaHighlightingColors.ENUM_NAME_ATTRIBUTES)
		addStyle(CLASS, "Classes", JavaHighlightingColors.CLASS_NAME_ATTRIBUTES)
		addStyle(ABSTRACT_CLASS, "Abstract classes", JavaHighlightingColors.ABSTRACT_CLASS_NAME_ATTRIBUTES)
		addStyle(ANNOTATION, "Annotations", JavaHighlightingColors.ANNOTATION_NAME_ATTRIBUTES)

		addStyle(FIELD, "Fields", JavaHighlightingColors.INSTANCE_FIELD_ATTRIBUTES)
		addStyle(STATIC_FIELD, "Static fields", JavaHighlightingColors.STATIC_FIELD_ATTRIBUTES)
		addStyle(STATIC_FINAL_FIELD, "Static final fields", JavaHighlightingColors.STATIC_FINAL_FIELD_ATTRIBUTES)

		addStyle(METHOD, "Methods", JavaHighlightingColors.METHOD_DECLARATION_ATTRIBUTES)
		addStyle(STATIC_METHOD_INVOCATION, "Static method invocations", JavaHighlightingColors.STATIC_METHOD_ATTRIBUTES)
		addStyle(ABSTRACT_METHOD_INVOCATION, "Abstract method invocations", JavaHighlightingColors.ABSTRACT_METHOD_ATTRIBUTES)
		addStyle(EXTENSION_METHOD_INVOCATION, "Extension method invocations", JavaHighlightingColors.LOCAL_VARIABLE_ATTRIBUTES)

		addStyle(DEPRECATED_MEMBERS, "Deprecated members", CodeInsightColors.DEPRECATED_ATTRIBUTES)
		
		addStyle(LOCAL_VARIABLE, "Local variables", JavaHighlightingColors.LOCAL_VARIABLE_ATTRIBUTES)
		addStyle(LOCAL_VARIABLE_DECLARATION, "Local variable declarations", JavaHighlightingColors.LOCAL_VARIABLE_ATTRIBUTES)
		addStyle(LOCAL_FINAL_VARIABLE, "Local final variables", JavaHighlightingColors.LOCAL_VARIABLE_ATTRIBUTES)
		addStyle(LOCAL_FINAL_VARIABLE_DECLARATION, "Local final variable declarations", JavaHighlightingColors.LOCAL_VARIABLE_ATTRIBUTES)
		
		addStyle(PARAMETER_VARIABLE, "Parameter variables", JavaHighlightingColors.PARAMETER_ATTRIBUTES)
		
		addStyle(TYPE_VARIABLE, "Type variables", JavaHighlightingColors.TYPE_PARAMETER_NAME_ATTRIBUTES)
		addStyle(TYPE_ARGUMENT, "Type arguments", HighlighterColors.TEXT)
	}
}