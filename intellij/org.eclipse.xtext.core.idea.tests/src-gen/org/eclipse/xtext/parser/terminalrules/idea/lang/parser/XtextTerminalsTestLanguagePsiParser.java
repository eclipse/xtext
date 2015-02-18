package org.eclipse.xtext.parser.terminalrules.idea.lang.parser;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.terminalrules.idea.lang.XtextTerminalsTestLanguageElementTypeProvider;
import org.eclipse.xtext.parser.terminalrules.idea.parser.antlr.internal.PsiInternalXtextTerminalsTestLanguageParser;
import org.eclipse.xtext.parser.terminalrules.services.XtextTerminalsTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class XtextTerminalsTestLanguagePsiParser extends AbstractXtextPsiParser {

	private static final Set<String> INITIAL_HIDDEN_TOKENS = new HashSet<String>(Arrays.asList("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT"));

	@Inject 
	private XtextTerminalsTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private XtextTerminalsTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalXtextTerminalsTestLanguageParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

	@Override
	protected Set<String> getInitialHiddenTokens() {
		return INITIAL_HIDDEN_TOKENS;
	}

}
