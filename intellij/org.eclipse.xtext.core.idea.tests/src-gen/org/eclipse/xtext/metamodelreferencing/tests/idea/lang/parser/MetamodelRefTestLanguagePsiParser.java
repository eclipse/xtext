package org.eclipse.xtext.metamodelreferencing.tests.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.metamodelreferencing.tests.idea.lang.MetamodelRefTestLanguageElementTypeProvider;
import org.eclipse.xtext.metamodelreferencing.tests.idea.parser.antlr.internal.PsiInternalMetamodelRefTestLanguageParser;
import org.eclipse.xtext.metamodelreferencing.tests.services.MetamodelRefTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class MetamodelRefTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private MetamodelRefTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private MetamodelRefTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalMetamodelRefTestLanguageParser(builder, tokenStream, getTokenTypeProvider(), elementTypeProvider, grammarAccess);
	}

}
