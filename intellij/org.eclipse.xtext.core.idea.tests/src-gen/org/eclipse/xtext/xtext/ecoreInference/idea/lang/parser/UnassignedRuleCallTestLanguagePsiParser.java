package org.eclipse.xtext.xtext.ecoreInference.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.xtext.ecoreInference.idea.lang.UnassignedRuleCallTestLanguageElementTypeProvider;
import org.eclipse.xtext.xtext.ecoreInference.idea.parser.antlr.internal.PsiInternalUnassignedRuleCallTestLanguageParser;
import org.eclipse.xtext.xtext.ecoreInference.services.UnassignedRuleCallTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class UnassignedRuleCallTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private UnassignedRuleCallTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private UnassignedRuleCallTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalUnassignedRuleCallTestLanguageParser(builder, tokenStream, getTokenTypeProvider(), elementTypeProvider, grammarAccess);
	}

}
