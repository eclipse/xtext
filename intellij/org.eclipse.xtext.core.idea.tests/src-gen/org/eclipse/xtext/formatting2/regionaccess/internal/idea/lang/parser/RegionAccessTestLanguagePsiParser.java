package org.eclipse.xtext.formatting2.regionaccess.internal.idea.lang.parser;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.formatting2.regionaccess.internal.idea.lang.RegionAccessTestLanguageElementTypeProvider;
import org.eclipse.xtext.formatting2.regionaccess.internal.idea.parser.antlr.internal.PsiInternalRegionAccessTestLanguageParser;
import org.eclipse.xtext.formatting2.regionaccess.internal.services.RegionAccessTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class RegionAccessTestLanguagePsiParser extends AbstractXtextPsiParser {

	private static final Set<String> INITIAL_HIDDEN_TOKENS = new HashSet<String>(Arrays.asList("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT"));

	@Inject 
	private RegionAccessTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private RegionAccessTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalRegionAccessTestLanguageParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

	@Override
	protected Set<String> getInitialHiddenTokens() {
		return INITIAL_HIDDEN_TOKENS;
	}

}
