/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.editorActions

import com.google.inject.Inject
import com.intellij.openapi.editor.ex.EditorEx
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet
import org.eclipse.xtext.idea.editorActions.AutoEditString
import org.eclipse.xtext.idea.editorActions.DefaultAutoEditHandler
import org.eclipse.xtext.idea.parser.TokenTypeProvider

import static org.eclipse.xtend.core.idea.parser.antlr.internal.PsiInternalXtendParser.*
import org.eclipse.xtext.idea.editorActions.AutoEditMultiLineBlock

/**
 * @author kosyakov - Initial contribution and API
 */
class XtendAutoEditHandler extends DefaultAutoEditHandler {

	TokenSet slCommentTokens

	TokenSet richStringLiteralTokens

	override protected getQuotes() {
		#[
			new AutoEditRichString(richStringLiteralTokens),
			new AutoEditString('"'),
			new AutoEditString("'")
		]
	}

	@Inject
	def void setTokenTypeProvider(TokenTypeProvider tokenTypeProvider) {
		richStringLiteralTokens = TokenSet.create(
			tokenTypeProvider.getIElementType(RULE_RICH_TEXT),
			tokenTypeProvider.getIElementType(RULE_RICH_TEXT_START),
			tokenTypeProvider.getIElementType(RULE_RICH_TEXT_END),
			tokenTypeProvider.getIElementType(RULE_RICH_TEXT_INBETWEEN),
			tokenTypeProvider.getIElementType(RULE_COMMENT_RICH_TEXT_END),
			tokenTypeProvider.getIElementType(RULE_COMMENT_RICH_TEXT_INBETWEEN)
		)

		// TODO: should be done by default implementation
		slCommentTokens = TokenSet.create(
			tokenTypeProvider.getIElementType(RULE_SL_COMMENT)
		)
	}

	override protected getBlocks(TokenSet tokenSet) {
		if (tokenSet == richStringLiteralTokens) {
			return #[
				new AutoEditRichStringBlock('{', '}'),
				new AutoEditMultiLineBlock('«', '»') => [
					shouldDeleteClosing = true
					shouldInsertClosingTerminalBeforeDigit = true
					shouldInsertClosingTerminalBeforeSpecialCharacters = true
				]
			]
		}
		super.getBlocks(tokenSet)
	}

	override getTokenSet(IElementType tokenType) {
		if (richStringLiteralTokens.contains(tokenType)) {
			return richStringLiteralTokens
		}
		super.getTokenSet(tokenType)
	}

	// TODO: remove it
	override protected getSingleLineCommentTokens() {
		slCommentTokens
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