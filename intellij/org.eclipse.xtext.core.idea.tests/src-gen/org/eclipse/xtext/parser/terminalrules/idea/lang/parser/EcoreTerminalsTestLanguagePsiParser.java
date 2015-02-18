package org.eclipse.xtext.parser.terminalrules.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.terminalrules.idea.lang.EcoreTerminalsTestLanguageElementTypeProvider;
import org.eclipse.xtext.parser.terminalrules.idea.parser.antlr.internal.PsiInternalEcoreTerminalsTestLanguageParser;
import org.eclipse.xtext.parser.terminalrules.services.EcoreTerminalsTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class EcoreTerminalsTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private EcoreTerminalsTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private EcoreTerminalsTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalEcoreTerminalsTestLanguageParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

}
