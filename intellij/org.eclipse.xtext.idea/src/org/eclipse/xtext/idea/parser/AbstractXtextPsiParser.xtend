package org.eclipse.xtext.idea.parser

import com.google.inject.Inject
import com.intellij.lang.PsiBuilder
import com.intellij.lang.PsiParser
import com.intellij.psi.tree.IElementType
import org.antlr.runtime.TokenSource
import org.antlr.runtime.TokenStream
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.parser.antlr.ITokenDefProvider

abstract class AbstractXtextPsiParser implements PsiParser {

	@Inject
	@Accessors(PROTECTED_GETTER)
	ITokenDefProvider tokenDefProvider

	@Inject
	@Accessors(PROTECTED_GETTER)
	TokenTypeProvider tokenTypeProvider

	override parse(IElementType root, PsiBuilder builder) {
		// TODO: remove the line below
		builder.debugMode = true
		
		var rootMarker = builder.mark

		val parser = builder.createParser(builder.createTokenStream) => [
			tokenTypeMap = tokenDefProvider.tokenDefMap
		]

		parser.parse

		rootMarker.done(root)
		builder.treeBuilt
	}

	protected def AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream)

	protected def createTokenStream(PsiBuilder builder) {
		val tokenSource = builder.createTokenSource
		new PsiXtextTokenStream(builder, tokenSource, tokenDefProvider) => [
			initialHiddenTokens = initialHiddenTokens
		]
	}

	protected def TokenSource createTokenSource(PsiBuilder builder)

	protected def getInitialHiddenTokens() {
		var hiddenTokens = newHashSet
		hiddenTokens += tokenTypeProvider.whitespaceTokens.types.map[toString]
		hiddenTokens += tokenTypeProvider.commentTokens.types.map[toString]
		hiddenTokens
	}

}
