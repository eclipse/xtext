package org.eclipse.xtext.parsetree.unassignedtext.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parsetree.unassignedtext.idea.lang.UnassignedTextTestLanguageElementTypeProvider;
import org.eclipse.xtext.parsetree.unassignedtext.idea.parser.antlr.internal.PsiInternalUnassignedTextTestLanguageParser;
import org.eclipse.xtext.parsetree.unassignedtext.services.UnassignedTextTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class UnassignedTextTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private UnassignedTextTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private UnassignedTextTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalUnassignedTextTestLanguageParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

}
