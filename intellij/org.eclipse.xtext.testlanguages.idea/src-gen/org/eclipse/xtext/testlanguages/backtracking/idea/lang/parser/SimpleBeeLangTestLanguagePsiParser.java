package org.eclipse.xtext.testlanguages.backtracking.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.testlanguages.backtracking.idea.lang.SimpleBeeLangTestLanguageElementTypeProvider;
import org.eclipse.xtext.testlanguages.backtracking.idea.parser.antlr.internal.PsiInternalSimpleBeeLangTestLanguageParser;
import org.eclipse.xtext.testlanguages.backtracking.services.SimpleBeeLangTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class SimpleBeeLangTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private SimpleBeeLangTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private SimpleBeeLangTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalSimpleBeeLangTestLanguageParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

}
