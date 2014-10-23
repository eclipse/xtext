package org.eclipse.xtext.idea.common.types.idea.lang.parser;

import java.io.IOException;

import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.TokenSource;
import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.idea.common.types.idea.lang.RefactoringTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.common.types.idea.parser.antlr.internal.PsiInternalRefactoringTestLanguageLexer;
import org.eclipse.xtext.idea.common.types.idea.parser.antlr.internal.PsiInternalRefactoringTestLanguageParser;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;
import com.intellij.util.text.CharSequenceReader;

public class RefactoringTestLanguagePsiParser extends AbstractXtextPsiParser {
	
	@Inject 
	private RefactoringTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalRefactoringTestLanguageParser(builder, tokenStream, getTokenTypeProvider(), elementTypeProvider);
	}

	@Override
	protected TokenSource createTokenSource(PsiBuilder builder) {
		try {
			CharSequence originalText = builder.getOriginalText();
			CharSequenceReader reader = new CharSequenceReader(originalText);
			return new PsiInternalRefactoringTestLanguageLexer(new ANTLRReaderStream(reader));
		} catch (IOException e) {
			throw Exceptions.sneakyThrow(e);
		}
	}

}
