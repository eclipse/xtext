package org.eclipse.xtext.xbase.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.xbase.idea.lang.XbaseElementTypeProvider;
import org.eclipse.xtext.xbase.idea.parser.antlr.internal.PsiInternalXbaseParser;
import org.eclipse.xtext.xbase.services.XbaseGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class XbasePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private XbaseGrammarAccess grammarAccess;

	@Inject 
	private XbaseElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalXbaseParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

}
