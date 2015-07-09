package org.eclipse.xtext.parser.antlr.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug301935ExTestLanguageLanguage;

public class Bug301935ExTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public Bug301935ExTestLanguageSemanticHighlightVisitor() {
		Bug301935ExTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
