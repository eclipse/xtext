package org.eclipse.xtext.parser.assignments.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.assignments.idea.lang.Bug287184TestLanguageElementTypeProvider;
import org.eclipse.xtext.parser.assignments.idea.parser.antlr.internal.PsiInternalBug287184TestLanguageParser;
import org.eclipse.xtext.parser.assignments.services.Bug287184TestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class Bug287184TestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private Bug287184TestLanguageGrammarAccess grammarAccess;

	@Inject 
	private Bug287184TestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalBug287184TestLanguageParser(builder, tokenStream, getTokenTypeProvider(), elementTypeProvider, grammarAccess);
	}

}
