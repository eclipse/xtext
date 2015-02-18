package org.eclipse.xtext.linking.lazy.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.linking.lazy.idea.lang.LazyLinkingTestLanguageElementTypeProvider;
import org.eclipse.xtext.linking.lazy.idea.parser.antlr.internal.PsiInternalLazyLinkingTestLanguageParser;
import org.eclipse.xtext.linking.lazy.services.LazyLinkingTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class LazyLinkingTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private LazyLinkingTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private LazyLinkingTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalLazyLinkingTestLanguageParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

}
