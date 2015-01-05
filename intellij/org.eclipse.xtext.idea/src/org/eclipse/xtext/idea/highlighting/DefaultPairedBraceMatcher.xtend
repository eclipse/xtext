package org.eclipse.xtext.idea.highlighting

import com.google.inject.Inject
import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType
import org.eclipse.xtext.IGrammarAccess
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.ide.editor.bracketmatching.IBracePairProvider
import org.eclipse.xtext.idea.parser.TokenTypeProvider
import org.eclipse.xtext.parser.antlr.ITokenDefProvider

class DefaultPairedBraceMatcher implements PairedBraceMatcher {

	static val char KEYWORD_START_CHARACTER = "'"

	@Inject
	IGrammarAccess grammarAccess

	@Inject
	ITokenDefProvider tokenDefProvider

	@Inject
	TokenTypeProvider tokenTypeProvider

	@Inject
	IBracePairProvider bracePairProvider

	override getCodeConstructStart(PsiFile file, int openingBraceOffset) {
		openingBraceOffset
	}

	override create {
		bracePairProvider.pairs.map[
			findPairs(leftBrace, rightBrace, structural)
		].flatten as BracePair[]
	} getPairs() {
	}

	protected def findPairs(String leftBraceKeyword, String rightBraceKeyword, boolean structural) {
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

	protected def create {
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
	} getTokenTypes() {
	}

	override isPairedBracesAllowedBeforeType(IElementType lbraceType, IElementType contextType) {
		true
	}

}