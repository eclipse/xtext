package org.eclipse.xtext.generator.grammarAccess.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.generator.grammarAccess.idea.lang.GrammarAccessTestLanguageElementTypeProvider;
import org.eclipse.xtext.generator.grammarAccess.idea.parser.antlr.internal.PsiInternalGrammarAccessTestLanguageParser;
import org.eclipse.xtext.generator.grammarAccess.services.GrammarAccessTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class GrammarAccessTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private GrammarAccessTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private GrammarAccessTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalGrammarAccessTestLanguageParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

}
