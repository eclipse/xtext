package org.eclipse.xtend.core.idea.lang.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtend.core.idea.lang.XtendElementTypeProvider;
import org.eclipse.xtend.core.idea.parser.antlr.internal.PsiInternalXtendParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class XtendPsiParser extends AbstractXtextPsiParser {
	
	@Inject 
	private XtendElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalXtendParser(builder, tokenStream, getTokenTypeProvider(), elementTypeProvider);
	}

}
