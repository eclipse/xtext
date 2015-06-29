package org.eclipse.xtext.purexbase.idea.lang.parser;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.purexbase.idea.lang.PureXbaseElementTypeProvider;
import org.eclipse.xtext.purexbase.idea.parser.antlr.internal.PsiInternalPureXbaseParser;
import org.eclipse.xtext.purexbase.services.PureXbaseGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class PureXbasePsiParser extends AbstractXtextPsiParser {

	private static final Set<String> INITIAL_HIDDEN_TOKENS = new HashSet<String>(Arrays.asList("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT"));

	@Inject 
	private PureXbaseGrammarAccess grammarAccess;

	@Inject 
	private PureXbaseElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalPureXbaseParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

	@Override
	protected Set<String> getInitialHiddenTokens() {
		return INITIAL_HIDDEN_TOKENS;
	}

}
