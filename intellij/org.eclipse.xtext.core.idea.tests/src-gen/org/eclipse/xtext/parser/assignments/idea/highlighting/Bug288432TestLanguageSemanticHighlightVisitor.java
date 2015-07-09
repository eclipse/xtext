package org.eclipse.xtext.parser.assignments.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.parser.assignments.idea.lang.Bug288432TestLanguageLanguage;

public class Bug288432TestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public Bug288432TestLanguageSemanticHighlightVisitor() {
		Bug288432TestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
