package org.eclipse.xtext.parser.antlr.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug296889TestLanguageElementTypeProvider;
import org.eclipse.xtext.parser.antlr.idea.parser.antlr.internal.PsiInternalBug296889TestLanguageParser;
import org.eclipse.xtext.parser.antlr.services.Bug296889TestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class Bug296889TestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private Bug296889TestLanguageGrammarAccess grammarAccess;

	@Inject 
	private Bug296889TestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalBug296889TestLanguageParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

}
