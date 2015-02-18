package org.eclipse.xtext.parser.assignments.idea.lang.parser;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.assignments.idea.lang.AssignmentsTestLanguageElementTypeProvider;
import org.eclipse.xtext.parser.assignments.idea.parser.antlr.internal.PsiInternalAssignmentsTestLanguageParser;
import org.eclipse.xtext.parser.assignments.services.AssignmentsTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class AssignmentsTestLanguagePsiParser extends AbstractXtextPsiParser {

	private static final Set<String> INITIAL_HIDDEN_TOKENS = new HashSet<String>(Arrays.asList("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT"));

	@Inject 
	private AssignmentsTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private AssignmentsTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalAssignmentsTestLanguageParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

	@Override
	protected Set<String> getInitialHiddenTokens() {
		return INITIAL_HIDDEN_TOKENS;
	}

}
