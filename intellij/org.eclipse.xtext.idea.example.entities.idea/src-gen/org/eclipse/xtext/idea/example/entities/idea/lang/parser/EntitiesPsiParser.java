package org.eclipse.xtext.idea.example.entities.idea.lang.parser;

import java.io.IOException;

import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.TokenSource;
import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.idea.example.entities.idea.lang.EntitiesElementTypeProvider;
import org.eclipse.xtext.idea.example.entities.idea.parser.antlr.internal.PsiInternalEntitiesLexer;
import org.eclipse.xtext.idea.example.entities.idea.parser.antlr.internal.PsiInternalEntitiesParser;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;
import com.intellij.util.text.CharSequenceReader;

public class EntitiesPsiParser extends AbstractXtextPsiParser {
	
	@Inject 
	private EntitiesElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalEntitiesParser(builder, tokenStream, getTokenTypeProvider(), elementTypeProvider);
	}

	@Override
	protected TokenSource createTokenSource(PsiBuilder builder) {
		try {
			CharSequence originalText = builder.getOriginalText();
			CharSequenceReader reader = new CharSequenceReader(originalText);
			return new PsiInternalEntitiesLexer(new ANTLRReaderStream(reader));
		} catch (IOException e) {
			throw Exceptions.sneakyThrow(e);
		}
	}

}
