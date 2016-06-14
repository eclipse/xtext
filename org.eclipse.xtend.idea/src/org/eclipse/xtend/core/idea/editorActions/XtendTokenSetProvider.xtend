/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.editorActions

import com.google.inject.Inject
import com.google.inject.Singleton
import com.intellij.openapi.editor.ex.EditorEx
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet
import org.eclipse.xtend.core.idea.highlighting.XtendHighlightingLexer
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.idea.editorActions.DefaultTokenSetProvider
import org.eclipse.xtext.idea.parser.TokenTypeProvider

import static org.eclipse.xtend.core.idea.parser.antlr.internal.PsiInternalXtendParser.*

/**
 * @author kosyakov - Initial contribution and API
 */
@Singleton
class XtendTokenSetProvider extends DefaultTokenSetProvider {

	@Accessors
	val TokenSet richStringLiteralTokens
	
	@Accessors
	val TokenSet richStringCommentTokens

	@Inject
	new(TokenTypeProvider tokenTypeProvider) {
		richStringLiteralTokens = TokenSet.create(
			tokenTypeProvider.getIElementType(RULE_RICH_TEXT),
			tokenTypeProvider.getIElementType(RULE_RICH_TEXT_START),
			tokenTypeProvider.getIElementType(RULE_RICH_TEXT_END),
			tokenTypeProvider.getIElementType(RULE_RICH_TEXT_INBETWEEN),
			XtendHighlightingLexer.GUILLEMET_ELEMENT_TYPE
		)
		richStringCommentTokens = TokenSet.create(
			tokenTypeProvider.getIElementType(RULE_COMMENT_RICH_TEXT_INBETWEEN),
			tokenTypeProvider.getIElementType(RULE_COMMENT_RICH_TEXT_END)
		)
	}

	override getTokenSet(IElementType tokenType) {
		if (richStringLiteralTokens.contains(tokenType)) {
			return richStringLiteralTokens
		}
		if (richStringCommentTokens.contains(tokenType)) {
			return richStringCommentTokens
		}
		super.getTokenSet(tokenType)
	}

	override isStartOfLine(TokenSet tokenSet, EditorEx editor, int offset) {
		if (tokenSet == richStringLiteralTokens) {
			val text = editor.getBeginningOfLine(offset).trim
			text.empty || text.equals("'''")
		} else
			super.isStartOfLine(tokenSet, editor, offset)
	}

	override isEndOfLine(TokenSet tokenSet, EditorEx editor, int offset) {
		if (tokenSet == richStringLiteralTokens) {
			val text = editor.getEndOfLine(offset).trim
			text.empty || text.equals("'''")
		} else
			super.isEndOfLine(tokenSet, editor, offset)
	}

}