package org.eclipse.xtext.parser.antlr.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug289524TestLanguageElementTypeProvider;
import org.eclipse.xtext.parser.antlr.idea.parser.antlr.internal.PsiInternalBug289524TestLanguageParser;
import org.eclipse.xtext.parser.antlr.services.Bug289524TestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class Bug289524TestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private Bug289524TestLanguageGrammarAccess grammarAccess;

	@Inject 
	private Bug289524TestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalBug289524TestLanguageParser(builder, tokenStream, getTokenTypeProvider(), elementTypeProvider, grammarAccess);
	}

}
