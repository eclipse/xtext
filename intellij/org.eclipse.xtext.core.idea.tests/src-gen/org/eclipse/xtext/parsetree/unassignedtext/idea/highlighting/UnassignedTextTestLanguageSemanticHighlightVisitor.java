package org.eclipse.xtext.parsetree.unassignedtext.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.parsetree.unassignedtext.idea.lang.UnassignedTextTestLanguageLanguage;

public class UnassignedTextTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public UnassignedTextTestLanguageSemanticHighlightVisitor() {
		UnassignedTextTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
