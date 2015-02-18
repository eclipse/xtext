package org.eclipse.xtext.parsetree.reconstr.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.Bug299395TestLanguageElementTypeProvider;
import org.eclipse.xtext.parsetree.reconstr.idea.parser.antlr.internal.PsiInternalBug299395TestLanguageParser;
import org.eclipse.xtext.parsetree.reconstr.services.Bug299395TestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class Bug299395TestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private Bug299395TestLanguageGrammarAccess grammarAccess;

	@Inject 
	private Bug299395TestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalBug299395TestLanguageParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

}
