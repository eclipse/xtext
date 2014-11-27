package org.eclipse.xtext.idea.parser

import com.google.inject.Inject
import com.intellij.lang.PsiBuilder
import com.intellij.lang.PsiParser
import com.intellij.psi.tree.IElementType
import org.antlr.runtime.TokenSource
import org.antlr.runtime.TokenStream
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.AbstractRule
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.idea.nodemodel.IASTNodeAwareNodeModelBuilder
import org.eclipse.xtext.parser.antlr.ITokenDefProvider
import org.eclipse.xtext.parser.antlr.TokenSourceProvider
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType

abstract class AbstractXtextPsiParser implements PsiParser {

	@Inject
	@Accessors(PROTECTED_GETTER)
	ITokenDefProvider tokenDefProvider

	@Inject
	@Accessors(PROTECTED_GETTER)
	TokenTypeProvider tokenTypeProvider
	
	@Inject
	@Accessors(PROTECTED_GETTER)
	TokenSourceProvider tokenSourceProvider

	override parse(IElementType root, PsiBuilder builder) {
		val parser = builder.createParser(builder.createTokenStream) => [
			tokenTypeMap = tokenDefProvider.tokenDefMap
		]

		var rootMarker = builder.mark

		val entryRuleName = root.entryRuleName
		if (entryRuleName != null) {
			parser.parse(entryRuleName)
		} else {
			parser.parse
		}

		rootMarker.done(root)
		builder.treeBuilt
	}
	
	protected def getEntryRuleName(IElementType type) {
		if (type instanceof IGrammarAwareElementType) {
			switch grammarElement: type.grammarElement {
				AbstractRule: grammarElement.name
				RuleCall: grammarElement.rule.name
			}
		}
	}

	protected def AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream)

	protected def createTokenStream(PsiBuilder builder) {
		val tokenSource = builder.createTokenSource
		new PsiXtextTokenStream(builder, tokenSource, tokenDefProvider) => [
			val lookAhead = builder.getUserData(IASTNodeAwareNodeModelBuilder.LOOK_AHEAD_KEY)
			if (lookAhead != null) {
				initCurrentLookAhead(lookAhead)
			}
			initialHiddenTokens = initialHiddenTokens
		]
	}

	protected def TokenSource createTokenSource(PsiBuilder builder) {
		tokenSourceProvider.createTokenSource(builder.originalText)
	}

	protected def getInitialHiddenTokens() {
		var hiddenTokens = newHashSet
		hiddenTokens += tokenTypeProvider.whitespaceTokens.types.map[toString]
		hiddenTokens += tokenTypeProvider.commentTokens.types.map[toString]
		hiddenTokens
	}

}
