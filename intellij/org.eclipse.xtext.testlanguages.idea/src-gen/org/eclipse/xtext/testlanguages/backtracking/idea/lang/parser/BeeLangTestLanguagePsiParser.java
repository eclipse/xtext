package org.eclipse.xtext.testlanguages.backtracking.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.testlanguages.backtracking.idea.lang.BeeLangTestLanguageElementTypeProvider;
import org.eclipse.xtext.testlanguages.backtracking.idea.parser.antlr.internal.PsiInternalBeeLangTestLanguageParser;
import org.eclipse.xtext.testlanguages.backtracking.services.BeeLangTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class BeeLangTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private BeeLangTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private BeeLangTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalBeeLangTestLanguageParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

}
