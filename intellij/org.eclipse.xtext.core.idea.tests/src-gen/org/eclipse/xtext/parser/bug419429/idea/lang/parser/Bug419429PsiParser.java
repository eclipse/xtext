package org.eclipse.xtext.parser.bug419429.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.bug419429.idea.lang.Bug419429ElementTypeProvider;
import org.eclipse.xtext.parser.bug419429.idea.parser.antlr.internal.PsiInternalBug419429Parser;
import org.eclipse.xtext.parser.bug419429.services.Bug419429GrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class Bug419429PsiParser extends AbstractXtextPsiParser {

	@Inject 
	private Bug419429GrammarAccess grammarAccess;

	@Inject 
	private Bug419429ElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalBug419429Parser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

}
