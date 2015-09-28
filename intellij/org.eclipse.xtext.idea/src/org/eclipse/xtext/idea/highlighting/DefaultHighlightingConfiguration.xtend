/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.highlighting

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.CodeInsightColors

import static org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles.*
import com.intellij.openapi.editor.HighlighterColors

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class DefaultHighlightingConfiguration implements IHighlightingConfiguration {

	override void configure(IHighlightingStyleAcceptor it) {
		addStyle(KEYWORD_ID, "Keyword", DefaultLanguageHighlighterColors.KEYWORD) 
		addStyle(PUNCTUATION_ID, "Punctuation", DefaultLanguageHighlighterColors.DOT)
		addStyle(COMMENT_ID, "Comment", DefaultLanguageHighlighterColors.LINE_COMMENT)
		addStyle(STRING_ID, "String", DefaultLanguageHighlighterColors.STRING)
		addStyle(NUMBER_ID, "Number", DefaultLanguageHighlighterColors.NUMBER)
		addStyle(DEFAULT_ID, "Default",  HighlighterColors.TEXT)
		addStyle(INVALID_TOKEN_ID, "Error", CodeInsightColors.ERRORS_ATTRIBUTES)
		addStyle(TASK_ID, "Todo", CodeInsightColors.TODO_DEFAULT_ATTRIBUTES)
	}
}