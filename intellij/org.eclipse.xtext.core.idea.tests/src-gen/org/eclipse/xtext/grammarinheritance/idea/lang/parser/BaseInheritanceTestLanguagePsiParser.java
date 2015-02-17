package org.eclipse.xtext.grammarinheritance.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.grammarinheritance.idea.lang.BaseInheritanceTestLanguageElementTypeProvider;
import org.eclipse.xtext.grammarinheritance.idea.parser.antlr.internal.PsiInternalBaseInheritanceTestLanguageParser;
import org.eclipse.xtext.grammarinheritance.services.BaseInheritanceTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class BaseInheritanceTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private BaseInheritanceTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private BaseInheritanceTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalBaseInheritanceTestLanguageParser(builder, tokenStream, getTokenTypeProvider(), elementTypeProvider, grammarAccess);
	}

}
