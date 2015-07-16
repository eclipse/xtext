/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.formatting

import com.google.inject.Inject
import com.intellij.lang.CodeDocumentationAwareCommenter
import com.intellij.psi.PsiComment
import com.intellij.psi.tree.IElementType
import org.eclipse.xtext.idea.parser.TokenTypeProvider
import org.eclipse.xtext.parser.antlr.ITokenDefProvider

/**
 * @author kosyakov - Initial contribution and API
 */
class DefaultCommenter implements CodeDocumentationAwareCommenter {

	IElementType mlCommentTokenType

	IElementType slCommentTokenType

	@Inject
	def void setTokenTypes(TokenTypeProvider tokenTypeProvider, ITokenDefProvider tokenDefProvider) {
		mlCommentTokenType = 'RULE_ML_COMMENT'.getTokenType(tokenTypeProvider, tokenDefProvider)
		slCommentTokenType = 'RULE_SL_COMMENT'.getTokenType(tokenTypeProvider, tokenDefProvider)
	}

	protected def getTokenType(
		String tokenName,
		extension TokenTypeProvider tokenTypeProvider,
		extension ITokenDefProvider tokenDefProvider
	) {
		val mlCommentEntry = tokenDefMap.entrySet.findFirst[value == tokenName]
		if (mlCommentEntry != null)
			mlCommentEntry.key.getIElementType
	}

	// TODO: extract to a configurable constant
	override getLineCommentPrefix() {
		'//'
	}

	// TODO: extract to a configurable constant
	override getBlockCommentPrefix() {
		'/*'
	}

	// TODO: extract to a configurable constant
	override getBlockCommentSuffix() {
		'*/'
	}

	override getCommentedBlockCommentPrefix() {
		null
	}

	override getCommentedBlockCommentSuffix() {
		null
	}

	override getBlockCommentTokenType() {
		mlCommentTokenType
	}

	// TODO: extract to a configurable constant
	override getDocumentationCommentLinePrefix() {
		'*'
	}

	override getDocumentationCommentPrefix() {
		null
	}

	override getDocumentationCommentSuffix() {
		null
	}

	override getDocumentationCommentTokenType() {
		mlCommentTokenType
	}

	override getLineCommentTokenType() {
		slCommentTokenType
	}

	override isDocumentationComment(PsiComment element) {
		false
	}

}
