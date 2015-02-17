package org.eclipse.xtext.linking.lazy.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.linking.lazy.idea.lang.Bug311337TestLanguageElementTypeProvider;
import org.eclipse.xtext.linking.lazy.idea.parser.antlr.internal.PsiInternalBug311337TestLanguageParser;
import org.eclipse.xtext.linking.lazy.services.Bug311337TestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class Bug311337TestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private Bug311337TestLanguageGrammarAccess grammarAccess;

	@Inject 
	private Bug311337TestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalBug311337TestLanguageParser(builder, tokenStream, getTokenTypeProvider(), elementTypeProvider, grammarAccess);
	}

}
