package org.eclipse.xtext.testlanguages.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.testlanguages.idea.lang.ReferenceGrammarTestLanguageElementTypeProvider;
import org.eclipse.xtext.testlanguages.idea.parser.antlr.internal.PsiInternalReferenceGrammarTestLanguageParser;
import org.eclipse.xtext.testlanguages.services.ReferenceGrammarTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class ReferenceGrammarTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private ReferenceGrammarTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private ReferenceGrammarTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalReferenceGrammarTestLanguageParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

}
