package org.eclipse.xtext.parser.unorderedGroups.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.SimpleBacktrackingBug325745TestLanguageElementTypeProvider;
import org.eclipse.xtext.parser.unorderedGroups.idea.parser.antlr.internal.PsiInternalSimpleBacktrackingBug325745TestLanguageParser;
import org.eclipse.xtext.parser.unorderedGroups.services.SimpleBacktrackingBug325745TestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class SimpleBacktrackingBug325745TestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private SimpleBacktrackingBug325745TestLanguageGrammarAccess grammarAccess;

	@Inject 
	private SimpleBacktrackingBug325745TestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalSimpleBacktrackingBug325745TestLanguageParser(builder, tokenStream, getTokenTypeProvider(), elementTypeProvider, grammarAccess);
	}

}
