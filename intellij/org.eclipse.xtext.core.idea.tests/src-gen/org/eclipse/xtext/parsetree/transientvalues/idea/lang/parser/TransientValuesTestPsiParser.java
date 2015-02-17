package org.eclipse.xtext.parsetree.transientvalues.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parsetree.transientvalues.idea.lang.TransientValuesTestElementTypeProvider;
import org.eclipse.xtext.parsetree.transientvalues.idea.parser.antlr.internal.PsiInternalTransientValuesTestParser;
import org.eclipse.xtext.parsetree.transientvalues.services.TransientValuesTestGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class TransientValuesTestPsiParser extends AbstractXtextPsiParser {

	@Inject 
	private TransientValuesTestGrammarAccess grammarAccess;

	@Inject 
	private TransientValuesTestElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalTransientValuesTestParser(builder, tokenStream, getTokenTypeProvider(), elementTypeProvider, grammarAccess);
	}

}
