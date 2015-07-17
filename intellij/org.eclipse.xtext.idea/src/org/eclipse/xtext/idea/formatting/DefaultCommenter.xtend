/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.formatting

import com.google.inject.Inject
import com.google.inject.name.Named
import com.intellij.lang.CodeDocumentationAwareCommenter
import com.intellij.psi.PsiComment
import com.intellij.psi.tree.IElementType
import org.eclipse.xtext.idea.parser.TokenTypeProvider
import org.eclipse.xtext.parser.antlr.ITokenDefProvider

/**
 * @author kosyakov - Initial contribution and API
 */
class DefaultCommenter implements CodeDocumentationAwareCommenter {

	public static val LINE_COMMENT_PREFIX = 'org.eclipse.xtext.idea.formatting.DefaultCommenter.lineCommentPrefix'
	public static val BLOCK_COMMENT_PREFIX = 'org.eclipse.xtext.idea.formatting.DefaultCommenter.blockCommentPrefix'
	public static val BLOCK_COMMENT_SUFFIX = 'org.eclipse.xtext.idea.formatting.DefaultCommenter.blockCommentPrefix'
	public static val BLOCK_COMMENT_LINE_PREFIX = 'org.eclipse.xtext.idea.formatting.DefaultCommenter.blockCommentLinePrefix'

	IElementType mlCommentTokenType

	IElementType slCommentTokenType

	@Inject(optional=true)
	@Named(LINE_COMMENT_PREFIX)
	String lineCommentPrefix = '//'

	@Inject(optional=true)
	@Named(BLOCK_COMMENT_PREFIX)
	String blockCommentPrefix = '/*'

	@Inject(optional=true)
	@Named(BLOCK_COMMENT_SUFFIX)
	String blockCommentSuffix = '*/'

	@Inject(optional=true)
	@Named(BLOCK_COMMENT_LINE_PREFIX)
	String documentationCommentLinePrefix = '*'

	@Inject
	def void setTokenTypes(TokenTypeProvider tokenTypeProvider, ITokenDefProvider tokenDefProvider) {
		slCommentTokenType = 'RULE_SL_COMMENT'.getTokenType(tokenTypeProvider, tokenDefProvider)
		mlCommentTokenType = 'RULE_ML_COMMENT'.getTokenType(tokenTypeProvider, tokenDefProvider)
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

	override getLineCommentPrefix() {
		if (slCommentTokenType != null)
			return lineCommentPrefix
	}

	override getBlockCommentPrefix() {
		if (mlCommentTokenType != null)
			return blockCommentPrefix
	}

	override getBlockCommentSuffix() {
		if (mlCommentTokenType != null)
			return blockCommentSuffix
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

	override getDocumentationCommentLinePrefix() {
		if (mlCommentTokenType != null)
			return documentationCommentLinePrefix
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
