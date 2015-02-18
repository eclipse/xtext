package org.eclipse.xtext.parsetree.reconstr.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.SerializationErrorTestLanguageElementTypeProvider;
import org.eclipse.xtext.parsetree.reconstr.idea.parser.antlr.internal.PsiInternalSerializationErrorTestLanguageParser;
import org.eclipse.xtext.parsetree.reconstr.services.SerializationErrorTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class SerializationErrorTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private SerializationErrorTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private SerializationErrorTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalSerializationErrorTestLanguageParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

}
