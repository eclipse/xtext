package org.eclipse.xtext.resource.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.resource.idea.lang.LiveContainerBuilderIntegerationTestLanguageElementTypeProvider;
import org.eclipse.xtext.resource.idea.parser.antlr.internal.PsiInternalLiveContainerBuilderIntegerationTestLanguageParser;
import org.eclipse.xtext.resource.services.LiveContainerBuilderIntegerationTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class LiveContainerBuilderIntegerationTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private LiveContainerBuilderIntegerationTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private LiveContainerBuilderIntegerationTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalLiveContainerBuilderIntegerationTestLanguageParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

}
