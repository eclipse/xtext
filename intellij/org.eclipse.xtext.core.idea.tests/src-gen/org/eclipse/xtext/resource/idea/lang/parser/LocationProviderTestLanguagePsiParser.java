package org.eclipse.xtext.resource.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.resource.idea.lang.LocationProviderTestLanguageElementTypeProvider;
import org.eclipse.xtext.resource.idea.parser.antlr.internal.PsiInternalLocationProviderTestLanguageParser;
import org.eclipse.xtext.resource.services.LocationProviderTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class LocationProviderTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private LocationProviderTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private LocationProviderTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalLocationProviderTestLanguageParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

}
