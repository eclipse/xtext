package org.eclipse.xtext.parser.terminalrules.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.terminalrules.idea.lang.Bug297105TestLanguageElementTypeProvider;
import org.eclipse.xtext.parser.terminalrules.idea.parser.antlr.internal.PsiInternalBug297105TestLanguageParser;
import org.eclipse.xtext.parser.terminalrules.services.Bug297105TestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class Bug297105TestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private Bug297105TestLanguageGrammarAccess grammarAccess;

	@Inject 
	private Bug297105TestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalBug297105TestLanguageParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

}
