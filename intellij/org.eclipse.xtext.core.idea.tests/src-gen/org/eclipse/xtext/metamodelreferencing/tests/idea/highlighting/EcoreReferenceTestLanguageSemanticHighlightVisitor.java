package org.eclipse.xtext.metamodelreferencing.tests.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.metamodelreferencing.tests.idea.lang.EcoreReferenceTestLanguageLanguage;

public class EcoreReferenceTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public EcoreReferenceTestLanguageSemanticHighlightVisitor() {
		EcoreReferenceTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
