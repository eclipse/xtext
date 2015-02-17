package org.eclipse.xtext.dummy.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.dummy.idea.lang.DummyTestLanguageElementTypeProvider;
import org.eclipse.xtext.dummy.idea.parser.antlr.internal.PsiInternalDummyTestLanguageParser;
import org.eclipse.xtext.dummy.services.DummyTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class DummyTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private DummyTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private DummyTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalDummyTestLanguageParser(builder, tokenStream, getTokenTypeProvider(), elementTypeProvider, grammarAccess);
	}

}
