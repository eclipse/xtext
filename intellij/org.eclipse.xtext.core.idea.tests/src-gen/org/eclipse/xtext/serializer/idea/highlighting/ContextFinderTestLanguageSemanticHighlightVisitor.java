package org.eclipse.xtext.serializer.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.serializer.idea.lang.ContextFinderTestLanguageLanguage;

public class ContextFinderTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public ContextFinderTestLanguageSemanticHighlightVisitor() {
		ContextFinderTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
