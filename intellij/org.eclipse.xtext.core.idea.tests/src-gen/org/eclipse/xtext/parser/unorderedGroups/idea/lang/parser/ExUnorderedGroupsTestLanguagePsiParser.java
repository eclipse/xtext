package org.eclipse.xtext.parser.unorderedGroups.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.ExUnorderedGroupsTestLanguageElementTypeProvider;
import org.eclipse.xtext.parser.unorderedGroups.idea.parser.antlr.internal.PsiInternalExUnorderedGroupsTestLanguageParser;
import org.eclipse.xtext.parser.unorderedGroups.services.ExUnorderedGroupsTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class ExUnorderedGroupsTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private ExUnorderedGroupsTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private ExUnorderedGroupsTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalExUnorderedGroupsTestLanguageParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

}
