package org.eclipse.xtext.parser.assignments.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.parser.assignments.idea.lang.AssignmentsTestLanguageLanguage;

public class AssignmentsTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public AssignmentsTestLanguageSemanticHighlightVisitor() {
		AssignmentsTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
