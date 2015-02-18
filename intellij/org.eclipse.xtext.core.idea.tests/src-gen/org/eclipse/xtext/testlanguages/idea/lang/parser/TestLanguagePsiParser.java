package org.eclipse.xtext.testlanguages.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.testlanguages.idea.lang.TestLanguageElementTypeProvider;
import org.eclipse.xtext.testlanguages.idea.parser.antlr.internal.PsiInternalTestLanguageParser;
import org.eclipse.xtext.testlanguages.services.TestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class TestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private TestLanguageGrammarAccess grammarAccess;

	@Inject 
	private TestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalTestLanguageParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

}
