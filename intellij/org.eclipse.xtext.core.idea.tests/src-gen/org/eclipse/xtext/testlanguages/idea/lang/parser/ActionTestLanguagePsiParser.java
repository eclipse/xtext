package org.eclipse.xtext.testlanguages.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.testlanguages.idea.lang.ActionTestLanguageElementTypeProvider;
import org.eclipse.xtext.testlanguages.idea.parser.antlr.internal.PsiInternalActionTestLanguageParser;
import org.eclipse.xtext.testlanguages.services.ActionTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class ActionTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private ActionTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private ActionTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalActionTestLanguageParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

}
