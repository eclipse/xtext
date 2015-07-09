package org.eclipse.xtext.parser.antlr.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug289524TestLanguageLanguage;

public class Bug289524TestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public Bug289524TestLanguageSemanticHighlightVisitor() {
		Bug289524TestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
