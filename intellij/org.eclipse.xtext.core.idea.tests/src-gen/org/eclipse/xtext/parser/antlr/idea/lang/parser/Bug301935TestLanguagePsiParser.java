package org.eclipse.xtext.parser.antlr.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug301935TestLanguageElementTypeProvider;
import org.eclipse.xtext.parser.antlr.idea.parser.antlr.internal.PsiInternalBug301935TestLanguageParser;
import org.eclipse.xtext.parser.antlr.services.Bug301935TestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class Bug301935TestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private Bug301935TestLanguageGrammarAccess grammarAccess;

	@Inject 
	private Bug301935TestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalBug301935TestLanguageParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

}
