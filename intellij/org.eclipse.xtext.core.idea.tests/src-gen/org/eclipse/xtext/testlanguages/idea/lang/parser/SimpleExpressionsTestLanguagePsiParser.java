package org.eclipse.xtext.testlanguages.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.testlanguages.idea.lang.SimpleExpressionsTestLanguageElementTypeProvider;
import org.eclipse.xtext.testlanguages.idea.parser.antlr.internal.PsiInternalSimpleExpressionsTestLanguageParser;
import org.eclipse.xtext.testlanguages.services.SimpleExpressionsTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class SimpleExpressionsTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private SimpleExpressionsTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private SimpleExpressionsTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalSimpleExpressionsTestLanguageParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

}
