package org.eclipse.xtext.parsetree.reconstr.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.PartialSerializationTestLanguageElementTypeProvider;
import org.eclipse.xtext.parsetree.reconstr.idea.parser.antlr.internal.PsiInternalPartialSerializationTestLanguageParser;
import org.eclipse.xtext.parsetree.reconstr.services.PartialSerializationTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class PartialSerializationTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private PartialSerializationTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private PartialSerializationTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalPartialSerializationTestLanguageParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

}
