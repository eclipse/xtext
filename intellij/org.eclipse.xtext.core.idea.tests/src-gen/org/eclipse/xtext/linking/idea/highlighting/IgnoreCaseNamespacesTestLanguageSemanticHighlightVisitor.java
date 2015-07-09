package org.eclipse.xtext.linking.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.linking.idea.lang.IgnoreCaseNamespacesTestLanguageLanguage;

public class IgnoreCaseNamespacesTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public IgnoreCaseNamespacesTestLanguageSemanticHighlightVisitor() {
		IgnoreCaseNamespacesTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
