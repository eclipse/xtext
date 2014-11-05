package org.eclipse.xtext.xbase.idea.lang.parser;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.Lexer;
import org.eclipse.xtext.idea.parser.AbstractAntlrDelegatingIdeaLexer;
import org.eclipse.xtext.xbase.parser.antlr.internal.InternalXtypeLexer;

public class XtypeLexer extends AbstractAntlrDelegatingIdeaLexer {

	@Override
	public Lexer createAntlrLexer(String text) {
		return new InternalXtypeLexer(new ANTLRStringStream(text));
	}

}
