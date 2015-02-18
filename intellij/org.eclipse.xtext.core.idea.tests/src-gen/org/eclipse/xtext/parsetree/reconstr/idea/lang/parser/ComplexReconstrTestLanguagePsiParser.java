package org.eclipse.xtext.parsetree.reconstr.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.ComplexReconstrTestLanguageElementTypeProvider;
import org.eclipse.xtext.parsetree.reconstr.idea.parser.antlr.internal.PsiInternalComplexReconstrTestLanguageParser;
import org.eclipse.xtext.parsetree.reconstr.services.ComplexReconstrTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class ComplexReconstrTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private ComplexReconstrTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private ComplexReconstrTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalComplexReconstrTestLanguageParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

}
