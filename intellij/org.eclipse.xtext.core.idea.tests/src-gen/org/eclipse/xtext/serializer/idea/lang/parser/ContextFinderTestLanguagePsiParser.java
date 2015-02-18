package org.eclipse.xtext.serializer.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.serializer.idea.lang.ContextFinderTestLanguageElementTypeProvider;
import org.eclipse.xtext.serializer.idea.parser.antlr.internal.PsiInternalContextFinderTestLanguageParser;
import org.eclipse.xtext.serializer.services.ContextFinderTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class ContextFinderTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private ContextFinderTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private ContextFinderTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalContextFinderTestLanguageParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

}
