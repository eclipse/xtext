package org.eclipse.xtext.parser.antlr.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug289524ExTestLanguageLanguage;

public class Bug289524ExTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public Bug289524ExTestLanguageSemanticHighlightVisitor() {
		Bug289524ExTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
