package org.eclipse.xtext.validation.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.validation.idea.lang.ConcreteSyntaxValidationTestLanguageElementTypeProvider;
import org.eclipse.xtext.validation.idea.parser.antlr.internal.PsiInternalConcreteSyntaxValidationTestLanguageParser;
import org.eclipse.xtext.validation.services.ConcreteSyntaxValidationTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class ConcreteSyntaxValidationTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private ConcreteSyntaxValidationTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private ConcreteSyntaxValidationTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalConcreteSyntaxValidationTestLanguageParser(builder, tokenStream, getTokenTypeProvider(), elementTypeProvider, grammarAccess);
	}

}
