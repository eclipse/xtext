package org.eclipse.xtext.testlanguages.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.testlanguages.idea.lang.LookaheadTestLanguageElementTypeProvider;
import org.eclipse.xtext.testlanguages.idea.parser.antlr.internal.PsiInternalLookaheadTestLanguageParser;
import org.eclipse.xtext.testlanguages.services.LookaheadTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class LookaheadTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private LookaheadTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private LookaheadTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalLookaheadTestLanguageParser(builder, tokenStream, getTokenTypeProvider(), elementTypeProvider, grammarAccess);
	}

}
