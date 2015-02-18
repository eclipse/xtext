package org.eclipse.xtext.parser.terminalrules.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.terminalrules.idea.lang.XtextTerminalsTestLanguageElementTypeProvider;
import org.eclipse.xtext.parser.terminalrules.idea.parser.antlr.internal.PsiInternalXtextTerminalsTestLanguageParser;
import org.eclipse.xtext.parser.terminalrules.services.XtextTerminalsTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class XtextTerminalsTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private XtextTerminalsTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private XtextTerminalsTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalXtextTerminalsTestLanguageParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

}
