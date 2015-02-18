package org.eclipse.xtext.enumrules.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.enumrules.idea.lang.EnumAndReferenceTestLanguageElementTypeProvider;
import org.eclipse.xtext.enumrules.idea.parser.antlr.internal.PsiInternalEnumAndReferenceTestLanguageParser;
import org.eclipse.xtext.enumrules.services.EnumAndReferenceTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class EnumAndReferenceTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private EnumAndReferenceTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private EnumAndReferenceTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalEnumAndReferenceTestLanguageParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

}
