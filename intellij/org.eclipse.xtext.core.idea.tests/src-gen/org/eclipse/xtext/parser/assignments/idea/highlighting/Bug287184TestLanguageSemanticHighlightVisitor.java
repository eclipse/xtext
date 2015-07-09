package org.eclipse.xtext.parser.assignments.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.parser.assignments.idea.lang.Bug287184TestLanguageLanguage;

public class Bug287184TestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public Bug287184TestLanguageSemanticHighlightVisitor() {
		Bug287184TestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
