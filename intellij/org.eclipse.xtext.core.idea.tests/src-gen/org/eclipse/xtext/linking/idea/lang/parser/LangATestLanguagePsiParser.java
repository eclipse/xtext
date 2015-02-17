package org.eclipse.xtext.linking.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.linking.idea.lang.LangATestLanguageElementTypeProvider;
import org.eclipse.xtext.linking.idea.parser.antlr.internal.PsiInternalLangATestLanguageParser;
import org.eclipse.xtext.linking.services.LangATestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class LangATestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private LangATestLanguageGrammarAccess grammarAccess;

	@Inject 
	private LangATestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalLangATestLanguageParser(builder, tokenStream, getTokenTypeProvider(), elementTypeProvider, grammarAccess);
	}

}
