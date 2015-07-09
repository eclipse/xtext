package org.eclipse.xtext.lexer.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.lexer.idea.lang.IgnoreCaseLexerTestLanguageLanguage;

public class IgnoreCaseLexerTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public IgnoreCaseLexerTestLanguageSemanticHighlightVisitor() {
		IgnoreCaseLexerTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
