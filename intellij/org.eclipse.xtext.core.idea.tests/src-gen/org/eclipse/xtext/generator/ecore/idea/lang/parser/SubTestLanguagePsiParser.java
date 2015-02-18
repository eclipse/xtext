package org.eclipse.xtext.generator.ecore.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.generator.ecore.idea.lang.SubTestLanguageElementTypeProvider;
import org.eclipse.xtext.generator.ecore.idea.parser.antlr.internal.PsiInternalSubTestLanguageParser;
import org.eclipse.xtext.generator.ecore.services.SubTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class SubTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private SubTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private SubTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalSubTestLanguageParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

}
