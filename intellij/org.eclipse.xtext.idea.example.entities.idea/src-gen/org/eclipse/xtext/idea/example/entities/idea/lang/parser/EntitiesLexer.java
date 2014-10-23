package org.eclipse.xtext.idea.example.entities.idea.lang.parser;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.Lexer;
import org.eclipse.xtext.idea.parser.AbstractAntlrDelegatingIdeaLexer;
import org.eclipse.xtext.idea.example.entities.parser.antlr.internal.InternalEntitiesLexer;

public class EntitiesLexer extends AbstractAntlrDelegatingIdeaLexer {

	@Override
	public Lexer createAntlrLexer(String text) {
		return new InternalEntitiesLexer(new ANTLRStringStream(text));
	}

}
