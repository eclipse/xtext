package org.eclipse.xtext.linking.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.linking.idea.lang.IgnoreCaseImportsTestLanguageElementTypeProvider;
import org.eclipse.xtext.linking.idea.parser.antlr.internal.PsiInternalIgnoreCaseImportsTestLanguageParser;
import org.eclipse.xtext.linking.services.IgnoreCaseImportsTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class IgnoreCaseImportsTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private IgnoreCaseImportsTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private IgnoreCaseImportsTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalIgnoreCaseImportsTestLanguageParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

}
