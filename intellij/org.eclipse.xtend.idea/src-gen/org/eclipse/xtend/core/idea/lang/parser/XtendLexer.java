package org.eclipse.xtend.core.idea.lang.parser;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.Lexer;
import org.eclipse.xtext.idea.parser.AbstractAntlrDelegatingIdeaLexer;
import org.eclipse.xtend.core.parser.antlr.internal.InternalXtendLexer;

public class XtendLexer extends AbstractAntlrDelegatingIdeaLexer {

	@Override
	public Lexer createAntlrLexer(String text) {
		return new InternalXtendLexer(new ANTLRStringStream(text));
	}

}
