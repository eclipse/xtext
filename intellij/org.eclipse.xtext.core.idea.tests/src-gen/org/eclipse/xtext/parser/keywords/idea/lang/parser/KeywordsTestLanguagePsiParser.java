package org.eclipse.xtext.parser.keywords.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.keywords.idea.lang.KeywordsTestLanguageElementTypeProvider;
import org.eclipse.xtext.parser.keywords.idea.parser.antlr.internal.PsiInternalKeywordsTestLanguageParser;
import org.eclipse.xtext.parser.keywords.services.KeywordsTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class KeywordsTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private KeywordsTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private KeywordsTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalKeywordsTestLanguageParser(builder, tokenStream, getTokenTypeProvider(), elementTypeProvider, grammarAccess);
	}

}
