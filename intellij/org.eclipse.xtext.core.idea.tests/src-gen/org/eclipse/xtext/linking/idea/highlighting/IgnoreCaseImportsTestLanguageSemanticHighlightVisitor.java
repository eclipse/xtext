package org.eclipse.xtext.linking.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.linking.idea.lang.IgnoreCaseImportsTestLanguageLanguage;

public class IgnoreCaseImportsTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public IgnoreCaseImportsTestLanguageSemanticHighlightVisitor() {
		IgnoreCaseImportsTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
