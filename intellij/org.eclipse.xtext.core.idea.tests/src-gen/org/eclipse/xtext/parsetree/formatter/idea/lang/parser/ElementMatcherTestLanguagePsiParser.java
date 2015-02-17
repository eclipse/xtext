package org.eclipse.xtext.parsetree.formatter.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parsetree.formatter.idea.lang.ElementMatcherTestLanguageElementTypeProvider;
import org.eclipse.xtext.parsetree.formatter.idea.parser.antlr.internal.PsiInternalElementMatcherTestLanguageParser;
import org.eclipse.xtext.parsetree.formatter.services.ElementMatcherTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class ElementMatcherTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private ElementMatcherTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private ElementMatcherTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalElementMatcherTestLanguageParser(builder, tokenStream, getTokenTypeProvider(), elementTypeProvider, grammarAccess);
	}

}
