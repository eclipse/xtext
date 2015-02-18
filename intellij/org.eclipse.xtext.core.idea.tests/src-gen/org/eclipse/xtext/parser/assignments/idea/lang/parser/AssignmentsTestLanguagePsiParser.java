package org.eclipse.xtext.parser.assignments.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.assignments.idea.lang.AssignmentsTestLanguageElementTypeProvider;
import org.eclipse.xtext.parser.assignments.idea.parser.antlr.internal.PsiInternalAssignmentsTestLanguageParser;
import org.eclipse.xtext.parser.assignments.services.AssignmentsTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class AssignmentsTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private AssignmentsTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private AssignmentsTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalAssignmentsTestLanguageParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

}
