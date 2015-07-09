package org.eclipse.xtext.parser.antlr.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug289515TestLanguageLanguage;

public class Bug289515TestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public Bug289515TestLanguageSemanticHighlightVisitor() {
		Bug289515TestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
