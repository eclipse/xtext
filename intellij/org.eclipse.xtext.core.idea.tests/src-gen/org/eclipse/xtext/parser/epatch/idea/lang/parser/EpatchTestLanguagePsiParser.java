package org.eclipse.xtext.parser.epatch.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.epatch.idea.lang.EpatchTestLanguageElementTypeProvider;
import org.eclipse.xtext.parser.epatch.idea.parser.antlr.internal.PsiInternalEpatchTestLanguageParser;
import org.eclipse.xtext.parser.epatch.services.EpatchTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class EpatchTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private EpatchTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private EpatchTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalEpatchTestLanguageParser(builder, tokenStream, getTokenTypeProvider(), elementTypeProvider, grammarAccess);
	}

}
