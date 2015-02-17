package org.eclipse.xtext.parser.antlr.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug301935ExTestLanguageElementTypeProvider;
import org.eclipse.xtext.parser.antlr.idea.parser.antlr.internal.PsiInternalBug301935ExTestLanguageParser;
import org.eclipse.xtext.parser.antlr.services.Bug301935ExTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class Bug301935ExTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private Bug301935ExTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private Bug301935ExTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalBug301935ExTestLanguageParser(builder, tokenStream, getTokenTypeProvider(), elementTypeProvider, grammarAccess);
	}

}
