package org.eclipse.xtext.valueconverter.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.valueconverter.idea.lang.QualifiedNameTestLanguageElementTypeProvider;
import org.eclipse.xtext.valueconverter.idea.parser.antlr.internal.PsiInternalQualifiedNameTestLanguageParser;
import org.eclipse.xtext.valueconverter.services.QualifiedNameTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class QualifiedNameTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private QualifiedNameTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private QualifiedNameTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalQualifiedNameTestLanguageParser(builder, tokenStream, getTokenTypeProvider(), elementTypeProvider, grammarAccess);
	}

}
