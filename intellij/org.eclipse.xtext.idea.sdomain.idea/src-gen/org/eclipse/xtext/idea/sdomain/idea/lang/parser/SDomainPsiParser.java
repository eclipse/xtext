package org.eclipse.xtext.idea.sdomain.idea.lang.parser;

import java.io.IOException;

import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.TokenSource;
import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.idea.sdomain.idea.lang.SDomainElementTypeProvider;
import org.eclipse.xtext.idea.sdomain.idea.parser.antlr.internal.PsiInternalSDomainLexer;
import org.eclipse.xtext.idea.sdomain.idea.parser.antlr.internal.PsiInternalSDomainParser;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;
import com.intellij.util.text.CharSequenceReader;

public class SDomainPsiParser extends AbstractXtextPsiParser {
	
	@Inject 
	private SDomainElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalSDomainParser(builder, tokenStream, getTokenTypeProvider(), elementTypeProvider);
	}

	@Override
	protected TokenSource createTokenSource(PsiBuilder builder) {
		try {
			CharSequence originalText = builder.getOriginalText();
			CharSequenceReader reader = new CharSequenceReader(originalText);
			return new PsiInternalSDomainLexer(new ANTLRReaderStream(reader));
		} catch (IOException e) {
			throw Exceptions.sneakyThrow(e);
		}
	}

}
