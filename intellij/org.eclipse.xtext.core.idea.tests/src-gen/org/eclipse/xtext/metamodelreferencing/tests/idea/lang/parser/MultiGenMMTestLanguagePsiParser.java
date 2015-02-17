package org.eclipse.xtext.metamodelreferencing.tests.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.metamodelreferencing.tests.idea.lang.MultiGenMMTestLanguageElementTypeProvider;
import org.eclipse.xtext.metamodelreferencing.tests.idea.parser.antlr.internal.PsiInternalMultiGenMMTestLanguageParser;
import org.eclipse.xtext.metamodelreferencing.tests.services.MultiGenMMTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class MultiGenMMTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private MultiGenMMTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private MultiGenMMTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalMultiGenMMTestLanguageParser(builder, tokenStream, getTokenTypeProvider(), elementTypeProvider, grammarAccess);
	}

}
