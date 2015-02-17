package org.eclipse.xtext.parser.antlr.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug299237TestLanguageElementTypeProvider;
import org.eclipse.xtext.parser.antlr.idea.parser.antlr.internal.PsiInternalBug299237TestLanguageParser;
import org.eclipse.xtext.parser.antlr.services.Bug299237TestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class Bug299237TestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private Bug299237TestLanguageGrammarAccess grammarAccess;

	@Inject 
	private Bug299237TestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalBug299237TestLanguageParser(builder, tokenStream, getTokenTypeProvider(), elementTypeProvider, grammarAccess);
	}

}
