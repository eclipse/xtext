package org.eclipse.xtext.enumrules.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.enumrules.idea.lang.MultiRuleEnumTestLanguageElementTypeProvider;
import org.eclipse.xtext.enumrules.idea.parser.antlr.internal.PsiInternalMultiRuleEnumTestLanguageParser;
import org.eclipse.xtext.enumrules.services.MultiRuleEnumTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class MultiRuleEnumTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private MultiRuleEnumTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private MultiRuleEnumTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalMultiRuleEnumTestLanguageParser(builder, tokenStream, getTokenTypeProvider(), elementTypeProvider, grammarAccess);
	}

}
