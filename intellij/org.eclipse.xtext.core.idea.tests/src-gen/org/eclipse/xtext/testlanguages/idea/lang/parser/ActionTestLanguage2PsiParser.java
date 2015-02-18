package org.eclipse.xtext.testlanguages.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.testlanguages.idea.lang.ActionTestLanguage2ElementTypeProvider;
import org.eclipse.xtext.testlanguages.idea.parser.antlr.internal.PsiInternalActionTestLanguage2Parser;
import org.eclipse.xtext.testlanguages.services.ActionTestLanguage2GrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class ActionTestLanguage2PsiParser extends AbstractXtextPsiParser {

	@Inject 
	private ActionTestLanguage2GrammarAccess grammarAccess;

	@Inject 
	private ActionTestLanguage2ElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalActionTestLanguage2Parser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

}
