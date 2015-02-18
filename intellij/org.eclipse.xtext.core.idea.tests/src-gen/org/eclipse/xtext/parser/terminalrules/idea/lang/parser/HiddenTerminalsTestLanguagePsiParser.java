package org.eclipse.xtext.parser.terminalrules.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.terminalrules.idea.lang.HiddenTerminalsTestLanguageElementTypeProvider;
import org.eclipse.xtext.parser.terminalrules.idea.parser.antlr.internal.PsiInternalHiddenTerminalsTestLanguageParser;
import org.eclipse.xtext.parser.terminalrules.services.HiddenTerminalsTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class HiddenTerminalsTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private HiddenTerminalsTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private HiddenTerminalsTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalHiddenTerminalsTestLanguageParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

}
