/*
 * generated by Xtext
 */
package org.eclipse.xtext.generator.ecore.idea.lang.parser;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.generator.ecore.idea.lang.SuperTestLanguageElementTypeProvider;
import org.eclipse.xtext.generator.ecore.idea.parser.antlr.internal.PsiInternalSuperTestLanguageParser;
import org.eclipse.xtext.generator.ecore.services.SuperTestLanguageGrammarAccess;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;

public class SuperTestLanguagePsiParser extends AbstractXtextPsiParser {

	private static final Set<String> INITIAL_HIDDEN_TOKENS = new HashSet<String>(Arrays.asList("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT"));

	@Inject 
	private SuperTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private SuperTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalSuperTestLanguageParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

	@Override
	protected Set<String> getInitialHiddenTokens() {
		return INITIAL_HIDDEN_TOKENS;
	}
}