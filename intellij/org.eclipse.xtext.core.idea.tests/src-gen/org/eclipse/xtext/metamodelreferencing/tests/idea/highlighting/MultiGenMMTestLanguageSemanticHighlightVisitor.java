package org.eclipse.xtext.metamodelreferencing.tests.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.metamodelreferencing.tests.idea.lang.MultiGenMMTestLanguageLanguage;

public class MultiGenMMTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public MultiGenMMTestLanguageSemanticHighlightVisitor() {
		MultiGenMMTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
