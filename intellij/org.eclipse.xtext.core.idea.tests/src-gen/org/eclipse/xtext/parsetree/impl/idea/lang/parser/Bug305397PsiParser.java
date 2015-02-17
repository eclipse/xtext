package org.eclipse.xtext.parsetree.impl.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parsetree.impl.idea.lang.Bug305397ElementTypeProvider;
import org.eclipse.xtext.parsetree.impl.idea.parser.antlr.internal.PsiInternalBug305397Parser;
import org.eclipse.xtext.parsetree.impl.services.Bug305397GrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class Bug305397PsiParser extends AbstractXtextPsiParser {

	@Inject 
	private Bug305397GrammarAccess grammarAccess;

	@Inject 
	private Bug305397ElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalBug305397Parser(builder, tokenStream, getTokenTypeProvider(), elementTypeProvider, grammarAccess);
	}

}
