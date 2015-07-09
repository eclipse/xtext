package org.eclipse.xtext.serializer.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.serializer.idea.lang.AssignmentFinderTestLanguageLanguage;

public class AssignmentFinderTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public AssignmentFinderTestLanguageSemanticHighlightVisitor() {
		AssignmentFinderTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
