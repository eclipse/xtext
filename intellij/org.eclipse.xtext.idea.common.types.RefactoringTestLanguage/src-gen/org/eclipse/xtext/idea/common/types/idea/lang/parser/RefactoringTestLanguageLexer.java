package org.eclipse.xtext.idea.common.types.idea.lang.parser;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.Lexer;
import org.eclipse.xtext.idea.parser.AbstractAntlrDelegatingIdeaLexer;
import org.eclipse.xtext.idea.common.types.parser.antlr.internal.InternalRefactoringTestLanguageLexer;

public class RefactoringTestLanguageLexer extends AbstractAntlrDelegatingIdeaLexer {

	@Override
	public Lexer createAntlrLexer(String text) {
		return new InternalRefactoringTestLanguageLexer(new ANTLRStringStream(text));
	}

}
