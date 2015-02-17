package org.eclipse.xtext.parsetree.formatter.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parsetree.formatter.idea.lang.FormatterTestLanguageElementTypeProvider;
import org.eclipse.xtext.parsetree.formatter.idea.parser.antlr.internal.PsiInternalFormatterTestLanguageParser;
import org.eclipse.xtext.parsetree.formatter.services.FormatterTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class FormatterTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private FormatterTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private FormatterTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalFormatterTestLanguageParser(builder, tokenStream, getTokenTypeProvider(), elementTypeProvider, grammarAccess);
	}

}
