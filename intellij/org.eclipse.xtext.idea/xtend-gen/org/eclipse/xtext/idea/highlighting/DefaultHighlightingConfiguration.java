/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.highlighting;

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.CodeInsightColors;
import org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles;
import org.eclipse.xtext.idea.highlighting.IHighlightingConfiguration;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class DefaultHighlightingConfiguration implements IHighlightingConfiguration {
  @Override
  public void configure(final IHighlightingConfiguration.IHighlightingStyleAcceptor it) {
    it.addStyle(HighlightingStyles.KEYWORD_ID, "Keyword", DefaultLanguageHighlighterColors.KEYWORD);
    it.addStyle(HighlightingStyles.PUNCTUATION_ID, "Punctuation", DefaultLanguageHighlighterColors.DOT);
    it.addStyle(HighlightingStyles.COMMENT_ID, "Comment", DefaultLanguageHighlighterColors.LINE_COMMENT);
    it.addStyle(HighlightingStyles.STRING_ID, "String", DefaultLanguageHighlighterColors.STRING);
    it.addStyle(HighlightingStyles.NUMBER_ID, "Number", DefaultLanguageHighlighterColors.NUMBER);
    it.addStyle(HighlightingStyles.DEFAULT_ID, "Default", HighlighterColors.TEXT);
    it.addStyle(HighlightingStyles.INVALID_TOKEN_ID, "Error", CodeInsightColors.ERRORS_ATTRIBUTES);
    it.addStyle(HighlightingStyles.TASK_ID, "Todo", CodeInsightColors.TODO_DEFAULT_ATTRIBUTES);
  }
}
