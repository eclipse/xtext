package org.eclipse.xtext.lexer.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.lexer.idea.lang.BacktrackingLexerTestLanguageElementTypeProvider;
import org.eclipse.xtext.lexer.idea.parser.antlr.internal.PsiInternalBacktrackingLexerTestLanguageParser;
import org.eclipse.xtext.lexer.services.BacktrackingLexerTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class BacktrackingLexerTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private BacktrackingLexerTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private BacktrackingLexerTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalBacktrackingLexerTestLanguageParser(builder, tokenStream, getTokenTypeProvider(), elementTypeProvider, grammarAccess);
	}

}
