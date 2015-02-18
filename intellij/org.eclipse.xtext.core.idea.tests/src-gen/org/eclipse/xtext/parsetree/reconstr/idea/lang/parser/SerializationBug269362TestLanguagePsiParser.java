package org.eclipse.xtext.parsetree.reconstr.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.SerializationBug269362TestLanguageElementTypeProvider;
import org.eclipse.xtext.parsetree.reconstr.idea.parser.antlr.internal.PsiInternalSerializationBug269362TestLanguageParser;
import org.eclipse.xtext.parsetree.reconstr.services.SerializationBug269362TestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class SerializationBug269362TestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private SerializationBug269362TestLanguageGrammarAccess grammarAccess;

	@Inject 
	private SerializationBug269362TestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalSerializationBug269362TestLanguageParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

}
