package org.eclipse.xtext.linking.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.linking.idea.lang.Bug362902ElementTypeProvider;
import org.eclipse.xtext.linking.idea.parser.antlr.internal.PsiInternalBug362902Parser;
import org.eclipse.xtext.linking.services.Bug362902GrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class Bug362902PsiParser extends AbstractXtextPsiParser {

	@Inject 
	private Bug362902GrammarAccess grammarAccess;

	@Inject 
	private Bug362902ElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalBug362902Parser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

}
