package org.eclipse.xtext.parser.antlr.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug289515TestLanguageElementTypeProvider;
import org.eclipse.xtext.parser.antlr.idea.parser.antlr.internal.PsiInternalBug289515TestLanguageParser;
import org.eclipse.xtext.parser.antlr.services.Bug289515TestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class Bug289515TestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private Bug289515TestLanguageGrammarAccess grammarAccess;

	@Inject 
	private Bug289515TestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalBug289515TestLanguageParser(builder, tokenStream, getTokenTypeProvider(), elementTypeProvider, grammarAccess);
	}

}
