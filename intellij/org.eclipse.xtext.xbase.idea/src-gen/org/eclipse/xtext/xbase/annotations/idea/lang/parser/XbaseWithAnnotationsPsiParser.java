package org.eclipse.xtext.xbase.annotations.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.xbase.annotations.idea.lang.XbaseWithAnnotationsElementTypeProvider;
import org.eclipse.xtext.xbase.annotations.idea.parser.antlr.internal.PsiInternalXbaseWithAnnotationsParser;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class XbaseWithAnnotationsPsiParser extends AbstractXtextPsiParser {
	
	@Inject 
	private XbaseWithAnnotationsElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalXbaseWithAnnotationsParser(builder, tokenStream, getTokenTypeProvider(), elementTypeProvider);
	}

}
