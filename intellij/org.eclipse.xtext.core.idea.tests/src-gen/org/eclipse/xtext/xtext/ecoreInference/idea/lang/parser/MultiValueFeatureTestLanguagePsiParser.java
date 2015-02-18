package org.eclipse.xtext.xtext.ecoreInference.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.xtext.ecoreInference.idea.lang.MultiValueFeatureTestLanguageElementTypeProvider;
import org.eclipse.xtext.xtext.ecoreInference.idea.parser.antlr.internal.PsiInternalMultiValueFeatureTestLanguageParser;
import org.eclipse.xtext.xtext.ecoreInference.services.MultiValueFeatureTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class MultiValueFeatureTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private MultiValueFeatureTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private MultiValueFeatureTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalMultiValueFeatureTestLanguageParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

}
