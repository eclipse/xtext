package org.eclipse.xtext.grammarinheritance.idea.lang.parser;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.grammarinheritance.idea.lang.InheritanceTest2LanguageElementTypeProvider;
import org.eclipse.xtext.grammarinheritance.idea.parser.antlr.internal.PsiInternalInheritanceTest2LanguageParser;
import org.eclipse.xtext.grammarinheritance.services.InheritanceTest2LanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class InheritanceTest2LanguagePsiParser extends AbstractXtextPsiParser {

	private static final Set<String> INITIAL_HIDDEN_TOKENS = new HashSet<String>(Arrays.asList("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT"));

	@Inject 
	private InheritanceTest2LanguageGrammarAccess grammarAccess;

	@Inject 
	private InheritanceTest2LanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalInheritanceTest2LanguageParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

	@Override
	protected Set<String> getInitialHiddenTokens() {
		return INITIAL_HIDDEN_TOKENS;
	}

}
