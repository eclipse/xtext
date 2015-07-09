package org.eclipse.xtext.parser.antlr.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug296889ExTestLanguageLanguage;

public class Bug296889ExTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public Bug296889ExTestLanguageSemanticHighlightVisitor() {
		Bug296889ExTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
