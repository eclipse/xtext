/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.highlighting

import com.google.inject.Inject
import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet
import java.util.Map
import org.eclipse.xtext.IGrammarAccess
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.ide.editor.bracketmatching.IBracePairProvider
import org.eclipse.xtext.idea.parser.TokenTypeProvider
import org.eclipse.xtext.parser.antlr.ITokenDefProvider

/**
 * @author kosyakov - Initial contribution and API
 */
class DefaultPairedBraceMatcher implements PairedBraceMatcher {

	static val char KEYWORD_START_CHARACTER = "'"

	val BracePair[] pairs

	val TokenSet allowedTypes

	val Map<String, IElementType> tokenTypes

	@Inject
	new(
		ITokenDefProvider tokenDefProvider,
		TokenTypeProvider tokenTypeProvider,
		IBracePairProvider bracePairProvider,
		IGrammarAccess grammarAccess
	) {
		tokenTypes = createTokenTypes(tokenDefProvider, tokenTypeProvider)
		pairs = createPairs(bracePairProvider, grammarAccess)
		allowedTypes = createAllowedTypes(tokenTypeProvider, grammarAccess)
	}

	protected def createAllowedTypes(TokenTypeProvider tokenTypeProvider, IGrammarAccess grammarAccess) {
		TokenSet.orSet(
			tokenTypeProvider.commentTokens,
			tokenTypeProvider.whitespaceTokens,
			TokenSet.create(pairs.map[#[leftBraceType, rightBraceType]].flatten),
			TokenSet.create(grammarAccess.findKeywords(';', ',').map[tokenType])
		)
	}

	protected def createTokenTypes(ITokenDefProvider tokenDefProvider, TokenTypeProvider tokenTypeProvider) {
		val tokenTypes = newHashMap
		val tokenDefMap = tokenDefProvider.tokenDefMap
		for (antlrTokenType : tokenDefMap.keySet) {
			val value = tokenDefMap.get(antlrTokenType)
			if (value.charAt(0) == KEYWORD_START_CHARACTER) {
				val tokenType = tokenTypeProvider.getIElementType(antlrTokenType)
				tokenTypes.put(value, tokenType)
			}
		}
		tokenTypes
	}

	protected def createPairs(IBracePairProvider bracePairProvider, IGrammarAccess grammarAccess) {
		bracePairProvider.pairs.map [
			findPairs(leftBrace, rightBrace, structural, grammarAccess)
		].flatten
	}

	protected def findPairs(
		String leftBraceKeyword,
		String rightBraceKeyword,
		boolean structural,
		IGrammarAccess grammarAccess
	) {
		grammarAccess.findKeywordPairs(leftBraceKeyword, rightBraceKeyword).map[createPair(first, second, structural)]
	}

	protected def createPair(Keyword leftBraceKeyword, Keyword rightBraceKeyword, boolean structural) {
		val leftBraceTokenType = leftBraceKeyword.tokenType
		val rightBraceTokenType = rightBraceKeyword.tokenType
		createPair(leftBraceTokenType, rightBraceTokenType, structural)
	}

	protected def createPair(IElementType leftBraceTokenType, IElementType rightBraceTokenType, boolean structural) {
		new BracePair(leftBraceTokenType, rightBraceTokenType, structural)
	}

	protected def getTokenType(Keyword keyword) {
		tokenTypes.get("'" + keyword.value + "'")
	}

	override getCodeConstructStart(PsiFile file, int openingBraceOffset) {
		openingBraceOffset
	}

	override getPairs() {
		pairs
	}

	override isPairedBracesAllowedBeforeType(IElementType lbraceType, IElementType contextType) {
		allowedTypes.contains(contextType)
	}

}