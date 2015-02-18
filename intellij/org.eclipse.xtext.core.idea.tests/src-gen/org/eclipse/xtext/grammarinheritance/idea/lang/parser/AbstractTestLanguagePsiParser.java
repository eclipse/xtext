package org.eclipse.xtext.grammarinheritance.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.grammarinheritance.idea.lang.AbstractTestLanguageElementTypeProvider;
import org.eclipse.xtext.grammarinheritance.idea.parser.antlr.internal.PsiInternalAbstractTestLanguageParser;
import org.eclipse.xtext.grammarinheritance.services.AbstractTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class AbstractTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private AbstractTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private AbstractTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalAbstractTestLanguageParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

}
