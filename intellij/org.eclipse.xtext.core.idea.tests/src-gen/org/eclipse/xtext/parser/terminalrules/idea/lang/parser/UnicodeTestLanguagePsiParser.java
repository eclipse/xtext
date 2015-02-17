package org.eclipse.xtext.parser.terminalrules.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.terminalrules.idea.lang.UnicodeTestLanguageElementTypeProvider;
import org.eclipse.xtext.parser.terminalrules.idea.parser.antlr.internal.PsiInternalUnicodeTestLanguageParser;
import org.eclipse.xtext.parser.terminalrules.services.UnicodeTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class UnicodeTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private UnicodeTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private UnicodeTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalUnicodeTestLanguageParser(builder, tokenStream, getTokenTypeProvider(), elementTypeProvider, grammarAccess);
	}

}
