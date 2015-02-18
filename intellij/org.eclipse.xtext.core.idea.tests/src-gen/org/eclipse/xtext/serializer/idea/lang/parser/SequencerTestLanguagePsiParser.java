package org.eclipse.xtext.serializer.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.serializer.idea.lang.SequencerTestLanguageElementTypeProvider;
import org.eclipse.xtext.serializer.idea.parser.antlr.internal.PsiInternalSequencerTestLanguageParser;
import org.eclipse.xtext.serializer.services.SequencerTestLanguageGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class SequencerTestLanguagePsiParser extends AbstractXtextPsiParser {

	@Inject 
	private SequencerTestLanguageGrammarAccess grammarAccess;

	@Inject 
	private SequencerTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalSequencerTestLanguageParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

}
