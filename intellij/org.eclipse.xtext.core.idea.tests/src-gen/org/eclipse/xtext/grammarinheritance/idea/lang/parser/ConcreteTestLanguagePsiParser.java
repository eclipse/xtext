package org.eclipse.xtext.grammarinheritance.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.grammarinheritance.idea.lang.ConcreteTestLanguageElementTypeProvider;
import org.eclipse.xtext.grammarinheritance.idea.parser.antlr.internal.PsiInternalConcreteTestLanguageParser;
import org.eclipse.xtext.grammarinheritance.services.ConcreteTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class ConcreteTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private ConcreteTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private ConcreteTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalConcreteTestLanguageParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

}
