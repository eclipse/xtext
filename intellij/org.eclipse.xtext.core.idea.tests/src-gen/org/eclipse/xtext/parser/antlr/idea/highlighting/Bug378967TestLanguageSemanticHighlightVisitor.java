package org.eclipse.xtext.parser.antlr.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug378967TestLanguageLanguage;

public class Bug378967TestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public Bug378967TestLanguageSemanticHighlightVisitor() {
		Bug378967TestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
