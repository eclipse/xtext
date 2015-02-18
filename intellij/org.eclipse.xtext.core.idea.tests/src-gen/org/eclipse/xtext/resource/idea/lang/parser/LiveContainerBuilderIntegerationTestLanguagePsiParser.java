package org.eclipse.xtext.resource.idea.lang.parser;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.resource.idea.lang.LiveContainerBuilderIntegerationTestLanguageElementTypeProvider;
import org.eclipse.xtext.resource.idea.parser.antlr.internal.PsiInternalLiveContainerBuilderIntegerationTestLanguageParser;
import org.eclipse.xtext.resource.services.LiveContainerBuilderIntegerationTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class LiveContainerBuilderIntegerationTestLanguagePsiParser extends AbstractXtextPsiParser {

	private static final Set<String> INITIAL_HIDDEN_TOKENS = new HashSet<String>(Arrays.asList("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT"));

	@Inject 
	private LiveContainerBuilderIntegerationTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private LiveContainerBuilderIntegerationTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalLiveContainerBuilderIntegerationTestLanguageParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

	@Override
	protected Set<String> getInitialHiddenTokens() {
		return INITIAL_HIDDEN_TOKENS;
	}

}
