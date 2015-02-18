package org.eclipse.xtext.parser.unorderedGroups.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.SimpleUnorderedGroupsTestLanguageElementTypeProvider;
import org.eclipse.xtext.parser.unorderedGroups.idea.parser.antlr.internal.PsiInternalSimpleUnorderedGroupsTestLanguageParser;
import org.eclipse.xtext.parser.unorderedGroups.services.SimpleUnorderedGroupsTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class SimpleUnorderedGroupsTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private SimpleUnorderedGroupsTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private SimpleUnorderedGroupsTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalSimpleUnorderedGroupsTestLanguageParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

}
