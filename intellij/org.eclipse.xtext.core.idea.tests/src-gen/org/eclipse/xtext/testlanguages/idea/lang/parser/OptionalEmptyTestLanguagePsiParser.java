package org.eclipse.xtext.testlanguages.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.testlanguages.idea.lang.OptionalEmptyTestLanguageElementTypeProvider;
import org.eclipse.xtext.testlanguages.idea.parser.antlr.internal.PsiInternalOptionalEmptyTestLanguageParser;
import org.eclipse.xtext.testlanguages.services.OptionalEmptyTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class OptionalEmptyTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private OptionalEmptyTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private OptionalEmptyTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalOptionalEmptyTestLanguageParser(builder, tokenStream, getTokenTypeProvider(), elementTypeProvider, grammarAccess);
	}

}
