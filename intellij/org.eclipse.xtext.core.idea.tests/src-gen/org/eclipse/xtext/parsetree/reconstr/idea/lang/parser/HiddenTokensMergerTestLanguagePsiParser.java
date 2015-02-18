package org.eclipse.xtext.parsetree.reconstr.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.HiddenTokensMergerTestLanguageElementTypeProvider;
import org.eclipse.xtext.parsetree.reconstr.idea.parser.antlr.internal.PsiInternalHiddenTokensMergerTestLanguageParser;
import org.eclipse.xtext.parsetree.reconstr.services.HiddenTokensMergerTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class HiddenTokensMergerTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private HiddenTokensMergerTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private HiddenTokensMergerTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalHiddenTokensMergerTestLanguageParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

}
