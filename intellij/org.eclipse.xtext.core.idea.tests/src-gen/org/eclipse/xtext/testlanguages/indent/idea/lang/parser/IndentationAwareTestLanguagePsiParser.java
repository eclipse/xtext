package org.eclipse.xtext.testlanguages.indent.idea.lang.parser;

import static java.util.Collections.emptySet;

import java.util.Set;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.testlanguages.indent.idea.lang.IndentationAwareTestLanguageElementTypeProvider;
import org.eclipse.xtext.testlanguages.indent.idea.parser.antlr.internal.PsiInternalIndentationAwareTestLanguageParser;
import org.eclipse.xtext.testlanguages.indent.services.IndentationAwareTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class IndentationAwareTestLanguagePsiParser extends AbstractXtextPsiParser {

	private static final Set<String> INITIAL_HIDDEN_TOKENS = emptySet();

	@Inject 
	private IndentationAwareTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private IndentationAwareTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalIndentationAwareTestLanguageParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

	@Override
	protected Set<String> getInitialHiddenTokens() {
		return INITIAL_HIDDEN_TOKENS;
	}

}
