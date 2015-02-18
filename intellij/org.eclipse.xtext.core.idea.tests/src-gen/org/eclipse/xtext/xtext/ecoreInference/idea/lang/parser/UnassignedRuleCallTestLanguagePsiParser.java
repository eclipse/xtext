package org.eclipse.xtext.xtext.ecoreInference.idea.lang.parser;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.xtext.ecoreInference.idea.lang.UnassignedRuleCallTestLanguageElementTypeProvider;
import org.eclipse.xtext.xtext.ecoreInference.idea.parser.antlr.internal.PsiInternalUnassignedRuleCallTestLanguageParser;
import org.eclipse.xtext.xtext.ecoreInference.services.UnassignedRuleCallTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class UnassignedRuleCallTestLanguagePsiParser extends AbstractXtextPsiParser {

	private static final Set<String> INITIAL_HIDDEN_TOKENS = new HashSet<String>(Arrays.asList("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT"));

	@Inject 
	private UnassignedRuleCallTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private UnassignedRuleCallTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalUnassignedRuleCallTestLanguageParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

	@Override
	protected Set<String> getInitialHiddenTokens() {
		return INITIAL_HIDDEN_TOKENS;
	}

}
