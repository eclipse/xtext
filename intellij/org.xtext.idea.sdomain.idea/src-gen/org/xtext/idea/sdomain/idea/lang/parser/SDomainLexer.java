package org.xtext.idea.sdomain.idea.lang.parser;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.Lexer;
import org.eclipse.xtext.idea.parser.AbstractAntlrDelegatingIdeaLexer;
import org.xtext.idea.sdomain.parser.antlr.internal.InternalSDomainLexer;

public class SDomainLexer extends AbstractAntlrDelegatingIdeaLexer {

	@Override
	public Lexer createAntlrLexer(String text) {
		return new InternalSDomainLexer(new ANTLRStringStream(text));
	}

}
