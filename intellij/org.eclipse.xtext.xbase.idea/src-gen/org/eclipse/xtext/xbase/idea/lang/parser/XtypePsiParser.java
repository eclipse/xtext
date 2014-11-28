package org.eclipse.xtext.xbase.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.xbase.idea.lang.XtypeElementTypeProvider;
import org.eclipse.xtext.xbase.idea.parser.antlr.internal.PsiInternalXtypeParser;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class XtypePsiParser extends AbstractXtextPsiParser {
	
	@Inject 
	private XtypeElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalXtypeParser(builder, tokenStream, getTokenTypeProvider(), elementTypeProvider);
	}

}
