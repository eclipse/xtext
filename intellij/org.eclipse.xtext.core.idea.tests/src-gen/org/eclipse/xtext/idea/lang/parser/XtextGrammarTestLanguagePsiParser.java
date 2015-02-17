package org.eclipse.xtext.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.idea.lang.XtextGrammarTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.antlr.internal.PsiInternalXtextGrammarTestLanguageParser;
import org.eclipse.xtext.services.XtextGrammarTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class XtextGrammarTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private XtextGrammarTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private XtextGrammarTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalXtextGrammarTestLanguageParser(builder, tokenStream, getTokenTypeProvider(), elementTypeProvider, grammarAccess);
	}

}
