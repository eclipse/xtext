package org.eclipse.xtext.metamodelreferencing.tests.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.metamodelreferencing.tests.idea.lang.EcoreReferenceTestLanguageElementTypeProvider;
import org.eclipse.xtext.metamodelreferencing.tests.idea.parser.antlr.internal.PsiInternalEcoreReferenceTestLanguageParser;
import org.eclipse.xtext.metamodelreferencing.tests.services.EcoreReferenceTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class EcoreReferenceTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private EcoreReferenceTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private EcoreReferenceTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalEcoreReferenceTestLanguageParser(builder, tokenStream, getTokenTypeProvider(), elementTypeProvider, grammarAccess);
	}

}
