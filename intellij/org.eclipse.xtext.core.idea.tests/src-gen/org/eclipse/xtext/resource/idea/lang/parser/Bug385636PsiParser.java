package org.eclipse.xtext.resource.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.resource.idea.lang.Bug385636ElementTypeProvider;
import org.eclipse.xtext.resource.idea.parser.antlr.internal.PsiInternalBug385636Parser;
import org.eclipse.xtext.resource.services.Bug385636GrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class Bug385636PsiParser extends AbstractXtextPsiParser {

	@Inject 
	private Bug385636GrammarAccess grammarAccess;

	@Inject 
	private Bug385636ElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalBug385636Parser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

}
