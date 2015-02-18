package org.eclipse.xtext.parsetree.reconstr.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.Bug302128TestLanguageElementTypeProvider;
import org.eclipse.xtext.parsetree.reconstr.idea.parser.antlr.internal.PsiInternalBug302128TestLanguageParser;
import org.eclipse.xtext.parsetree.reconstr.services.Bug302128TestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class Bug302128TestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private Bug302128TestLanguageGrammarAccess grammarAccess;

	@Inject 
	private Bug302128TestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalBug302128TestLanguageParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

}
