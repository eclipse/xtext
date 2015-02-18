package org.eclipse.xtext.testlanguages.backtracking.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.testlanguages.backtracking.idea.lang.ExBeeLangTestLanguageElementTypeProvider;
import org.eclipse.xtext.testlanguages.backtracking.idea.parser.antlr.internal.PsiInternalExBeeLangTestLanguageParser;
import org.eclipse.xtext.testlanguages.backtracking.services.ExBeeLangTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class ExBeeLangTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private ExBeeLangTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private ExBeeLangTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalExBeeLangTestLanguageParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

}
