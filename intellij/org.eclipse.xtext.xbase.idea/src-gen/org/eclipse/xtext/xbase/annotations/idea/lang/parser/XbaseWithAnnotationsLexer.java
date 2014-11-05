package org.eclipse.xtext.xbase.annotations.idea.lang.parser;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.Lexer;
import org.eclipse.xtext.idea.parser.AbstractAntlrDelegatingIdeaLexer;
import org.eclipse.xtext.xbase.annotations.parser.antlr.internal.InternalXbaseWithAnnotationsLexer;

public class XbaseWithAnnotationsLexer extends AbstractAntlrDelegatingIdeaLexer {

	@Override
	public Lexer createAntlrLexer(String text) {
		return new InternalXbaseWithAnnotationsLexer(new ANTLRStringStream(text));
	}

}
