/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.editorActions

import com.google.inject.Inject
import com.intellij.psi.tree.TokenSet
import org.eclipse.xtext.idea.editorActions.DefaultAutoEditHandler
import org.eclipse.xtext.idea.parser.TokenTypeProvider

import static org.eclipse.xtend.core.idea.parser.antlr.internal.PsiInternalXtendParser.*

/**
 * @author kosyakov - Initial contribution and API
 */
class XtendAutoEditHandler extends DefaultAutoEditHandler {
	
	TokenSet slCommentTokens

	TokenSet stringLiteralTokens

	@Inject
	def void setRichStringLiteralTokens(TokenTypeProvider tokenTypeProvider) {
		val richStringLiteralTokens = TokenSet.create(
			tokenTypeProvider.getIElementType(RULE_RICH_TEXT),
			tokenTypeProvider.getIElementType(RULE_RICH_TEXT_START),
			tokenTypeProvider.getIElementType(RULE_RICH_TEXT_END),
			tokenTypeProvider.getIElementType(RULE_RICH_TEXT_INBETWEEN),
			tokenTypeProvider.getIElementType(RULE_COMMENT_RICH_TEXT_END),
			tokenTypeProvider.getIElementType(RULE_COMMENT_RICH_TEXT_INBETWEEN)
		)
		stringLiteralTokens = TokenSet.orSet(tokenTypeProvider.stringLiteralTokens, richStringLiteralTokens)
		
		slCommentTokens = TokenSet.create(
			tokenTypeProvider.getIElementType(RULE_SL_COMMENT)
		)
	}
	
	override protected getSingleLineCommentTokens() {
		slCommentTokens
	}

	override protected getStringLiteralTokens() {
		stringLiteralTokens
	}

}