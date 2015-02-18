package org.eclipse.xtext.generator.ecore.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.generator.ecore.idea.lang.SuperTestLanguageElementTypeProvider;
import org.eclipse.xtext.generator.ecore.idea.parser.antlr.internal.PsiInternalSuperTestLanguageParser;
import org.eclipse.xtext.generator.ecore.services.SuperTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class SuperTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private SuperTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private SuperTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalSuperTestLanguageParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

}
