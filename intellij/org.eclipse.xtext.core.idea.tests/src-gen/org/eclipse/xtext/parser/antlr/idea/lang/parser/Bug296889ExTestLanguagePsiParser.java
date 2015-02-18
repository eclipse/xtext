package org.eclipse.xtext.parser.antlr.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug296889ExTestLanguageElementTypeProvider;
import org.eclipse.xtext.parser.antlr.idea.parser.antlr.internal.PsiInternalBug296889ExTestLanguageParser;
import org.eclipse.xtext.parser.antlr.services.Bug296889ExTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class Bug296889ExTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private Bug296889ExTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private Bug296889ExTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalBug296889ExTestLanguageParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

}
