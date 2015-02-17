package org.eclipse.xtext.parser.assignments.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.assignments.idea.lang.Bug288432TestLanguageElementTypeProvider;
import org.eclipse.xtext.parser.assignments.idea.parser.antlr.internal.PsiInternalBug288432TestLanguageParser;
import org.eclipse.xtext.parser.assignments.services.Bug288432TestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class Bug288432TestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private Bug288432TestLanguageGrammarAccess grammarAccess;

	@Inject 
	private Bug288432TestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalBug288432TestLanguageParser(builder, tokenStream, getTokenTypeProvider(), elementTypeProvider, grammarAccess);
	}

}
