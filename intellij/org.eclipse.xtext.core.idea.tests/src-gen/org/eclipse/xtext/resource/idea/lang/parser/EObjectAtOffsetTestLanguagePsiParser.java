package org.eclipse.xtext.resource.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.resource.idea.lang.EObjectAtOffsetTestLanguageElementTypeProvider;
import org.eclipse.xtext.resource.idea.parser.antlr.internal.PsiInternalEObjectAtOffsetTestLanguageParser;
import org.eclipse.xtext.resource.services.EObjectAtOffsetTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class EObjectAtOffsetTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private EObjectAtOffsetTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private EObjectAtOffsetTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalEObjectAtOffsetTestLanguageParser(builder, tokenStream, getTokenTypeProvider(), elementTypeProvider, grammarAccess);
	}

}
