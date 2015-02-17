package org.eclipse.xtext.parser.unorderedGroups.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.ExBacktrackingBug325745TestLanguageElementTypeProvider;
import org.eclipse.xtext.parser.unorderedGroups.idea.parser.antlr.internal.PsiInternalExBacktrackingBug325745TestLanguageParser;
import org.eclipse.xtext.parser.unorderedGroups.services.ExBacktrackingBug325745TestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class ExBacktrackingBug325745TestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private ExBacktrackingBug325745TestLanguageGrammarAccess grammarAccess;

	@Inject 
	private ExBacktrackingBug325745TestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalExBacktrackingBug325745TestLanguageParser(builder, tokenStream, getTokenTypeProvider(), elementTypeProvider, grammarAccess);
	}

}
