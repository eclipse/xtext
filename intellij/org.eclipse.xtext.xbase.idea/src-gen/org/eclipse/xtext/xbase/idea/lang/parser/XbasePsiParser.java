package org.eclipse.xtext.xbase.idea.lang.parser;

import java.io.IOException;

import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.TokenSource;
import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.idea.lang.XbaseElementTypeProvider;
import org.eclipse.xtext.xbase.idea.parser.antlr.internal.PsiInternalXbaseLexer;
import org.eclipse.xtext.xbase.idea.parser.antlr.internal.PsiInternalXbaseParser;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;
import com.intellij.util.text.CharSequenceReader;

public class XbasePsiParser extends AbstractXtextPsiParser {
	
	@Inject 
	private XbaseElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalXbaseParser(builder, tokenStream, getTokenTypeProvider(), elementTypeProvider);
	}

	@Override
	protected TokenSource createTokenSource(PsiBuilder builder) {
		try {
			CharSequence originalText = builder.getOriginalText();
			CharSequenceReader reader = new CharSequenceReader(originalText);
			return new PsiInternalXbaseLexer(new ANTLRReaderStream(reader));
		} catch (IOException e) {
			throw Exceptions.sneakyThrow(e);
		}
	}

}
