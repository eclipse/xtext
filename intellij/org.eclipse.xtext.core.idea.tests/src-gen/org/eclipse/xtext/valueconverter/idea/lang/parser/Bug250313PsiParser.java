package org.eclipse.xtext.valueconverter.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.valueconverter.idea.lang.Bug250313ElementTypeProvider;
import org.eclipse.xtext.valueconverter.idea.parser.antlr.internal.PsiInternalBug250313Parser;
import org.eclipse.xtext.valueconverter.services.Bug250313GrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class Bug250313PsiParser extends AbstractXtextPsiParser {

	@Inject 
	private Bug250313GrammarAccess grammarAccess;

	@Inject 
	private Bug250313ElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalBug250313Parser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

}
