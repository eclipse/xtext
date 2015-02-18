package org.eclipse.xtext.parser.unorderedGroups.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.UnorderedGroupsTestLanguageElementTypeProvider;
import org.eclipse.xtext.parser.unorderedGroups.idea.parser.antlr.internal.PsiInternalUnorderedGroupsTestLanguageParser;
import org.eclipse.xtext.parser.unorderedGroups.services.UnorderedGroupsTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class UnorderedGroupsTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private UnorderedGroupsTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private UnorderedGroupsTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalUnorderedGroupsTestLanguageParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

}
