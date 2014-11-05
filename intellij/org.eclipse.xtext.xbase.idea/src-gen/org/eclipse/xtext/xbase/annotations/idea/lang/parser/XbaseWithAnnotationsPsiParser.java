package org.eclipse.xtext.xbase.annotations.idea.lang.parser;

import java.io.IOException;

import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.TokenSource;
import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.annotations.idea.lang.XbaseWithAnnotationsElementTypeProvider;
import org.eclipse.xtext.xbase.annotations.idea.parser.antlr.internal.PsiInternalXbaseWithAnnotationsLexer;
import org.eclipse.xtext.xbase.annotations.idea.parser.antlr.internal.PsiInternalXbaseWithAnnotationsParser;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;
import com.intellij.util.text.CharSequenceReader;

public class XbaseWithAnnotationsPsiParser extends AbstractXtextPsiParser {
	
	@Inject 
	private XbaseWithAnnotationsElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalXbaseWithAnnotationsParser(builder, tokenStream, getTokenTypeProvider(), elementTypeProvider);
	}

	@Override
	protected TokenSource createTokenSource(PsiBuilder builder) {
		try {
			CharSequence originalText = builder.getOriginalText();
			CharSequenceReader reader = new CharSequenceReader(originalText);
			return new PsiInternalXbaseWithAnnotationsLexer(new ANTLRReaderStream(reader));
		} catch (IOException e) {
			throw Exceptions.sneakyThrow(e);
		}
	}

}
