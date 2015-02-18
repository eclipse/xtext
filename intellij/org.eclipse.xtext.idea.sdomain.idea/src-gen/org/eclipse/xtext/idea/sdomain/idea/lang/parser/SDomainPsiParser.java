package org.eclipse.xtext.idea.sdomain.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.idea.sdomain.idea.lang.SDomainElementTypeProvider;
import org.eclipse.xtext.idea.sdomain.idea.parser.antlr.internal.PsiInternalSDomainParser;
import org.eclipse.xtext.idea.sdomain.services.SDomainGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class SDomainPsiParser extends AbstractXtextPsiParser {

	@Inject 
	private SDomainGrammarAccess grammarAccess;

	@Inject 
	private SDomainElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalSDomainParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

}
