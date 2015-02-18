package org.eclipse.xtext.linking.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.linking.idea.lang.Bug289059TestLanguageElementTypeProvider;
import org.eclipse.xtext.linking.idea.parser.antlr.internal.PsiInternalBug289059TestLanguageParser;
import org.eclipse.xtext.linking.services.Bug289059TestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class Bug289059TestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private Bug289059TestLanguageGrammarAccess grammarAccess;

	@Inject 
	private Bug289059TestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalBug289059TestLanguageParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

}
