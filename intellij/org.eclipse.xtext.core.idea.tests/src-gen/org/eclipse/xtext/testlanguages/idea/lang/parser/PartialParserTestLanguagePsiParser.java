package org.eclipse.xtext.testlanguages.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.testlanguages.idea.lang.PartialParserTestLanguageElementTypeProvider;
import org.eclipse.xtext.testlanguages.idea.parser.antlr.internal.PsiInternalPartialParserTestLanguageParser;
import org.eclipse.xtext.testlanguages.services.PartialParserTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class PartialParserTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private PartialParserTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private PartialParserTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalPartialParserTestLanguageParser(builder, tokenStream, getTokenTypeProvider(), elementTypeProvider, grammarAccess);
	}

}
