package org.eclipse.xtext.lexer.idea.lang.parser;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.lexer.idea.lang.IgnoreCaseLexerTestLanguageElementTypeProvider;
import org.eclipse.xtext.lexer.idea.parser.antlr.internal.PsiInternalIgnoreCaseLexerTestLanguageParser;
import org.eclipse.xtext.lexer.services.IgnoreCaseLexerTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class IgnoreCaseLexerTestLanguagePsiParser extends AbstractXtextPsiParser {

	private static final Set<String> INITIAL_HIDDEN_TOKENS = new HashSet<String>(Arrays.asList("RULE_WS", "RULE_SL_COMMENT"));

	@Inject 
	private IgnoreCaseLexerTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private IgnoreCaseLexerTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalIgnoreCaseLexerTestLanguageParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

	@Override
	protected Set<String> getInitialHiddenTokens() {
		return INITIAL_HIDDEN_TOKENS;
	}

}
