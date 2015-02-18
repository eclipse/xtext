package org.eclipse.xtext.linking.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.linking.idea.lang.Bug313089TestLanguageElementTypeProvider;
import org.eclipse.xtext.linking.idea.parser.antlr.internal.PsiInternalBug313089TestLanguageParser;
import org.eclipse.xtext.linking.services.Bug313089TestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class Bug313089TestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private Bug313089TestLanguageGrammarAccess grammarAccess;

	@Inject 
	private Bug313089TestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalBug313089TestLanguageParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

}
