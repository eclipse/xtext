package org.eclipse.xtext.enumrules.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.enumrules.idea.lang.EnumRulesTestLanguageElementTypeProvider;
import org.eclipse.xtext.enumrules.idea.parser.antlr.internal.PsiInternalEnumRulesTestLanguageParser;
import org.eclipse.xtext.enumrules.services.EnumRulesTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class EnumRulesTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private EnumRulesTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private EnumRulesTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalEnumRulesTestLanguageParser(builder, tokenStream, getTokenTypeProvider(), elementTypeProvider, grammarAccess);
	}

}
