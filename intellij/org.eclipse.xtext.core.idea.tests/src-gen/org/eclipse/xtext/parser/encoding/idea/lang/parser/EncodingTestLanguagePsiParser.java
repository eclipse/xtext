package org.eclipse.xtext.parser.encoding.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.encoding.idea.lang.EncodingTestLanguageElementTypeProvider;
import org.eclipse.xtext.parser.encoding.idea.parser.antlr.internal.PsiInternalEncodingTestLanguageParser;
import org.eclipse.xtext.parser.encoding.services.EncodingTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class EncodingTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private EncodingTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private EncodingTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalEncodingTestLanguageParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

}
