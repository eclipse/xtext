package org.eclipse.xtext.serializer.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.serializer.idea.lang.SyntacticSequencerTestLanguageElementTypeProvider;
import org.eclipse.xtext.serializer.idea.parser.antlr.internal.PsiInternalSyntacticSequencerTestLanguageParser;
import org.eclipse.xtext.serializer.services.SyntacticSequencerTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class SyntacticSequencerTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private SyntacticSequencerTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private SyntacticSequencerTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalSyntacticSequencerTestLanguageParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

}
