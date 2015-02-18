package org.eclipse.xtext.resource.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.resource.idea.lang.LiveContainerTestLanguageElementTypeProvider;
import org.eclipse.xtext.resource.idea.parser.antlr.internal.PsiInternalLiveContainerTestLanguageParser;
import org.eclipse.xtext.resource.services.LiveContainerTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class LiveContainerTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private LiveContainerTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private LiveContainerTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalLiveContainerTestLanguageParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

}
