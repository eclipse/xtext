package org.eclipse.xtext.parser.datatyperules.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.datatyperules.idea.lang.DatatypeRulesTestLanguageElementTypeProvider;
import org.eclipse.xtext.parser.datatyperules.idea.parser.antlr.internal.PsiInternalDatatypeRulesTestLanguageParser;
import org.eclipse.xtext.parser.datatyperules.services.DatatypeRulesTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class DatatypeRulesTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private DatatypeRulesTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private DatatypeRulesTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalDatatypeRulesTestLanguageParser(builder, tokenStream, getTokenTypeProvider(), elementTypeProvider, grammarAccess);
	}

}
