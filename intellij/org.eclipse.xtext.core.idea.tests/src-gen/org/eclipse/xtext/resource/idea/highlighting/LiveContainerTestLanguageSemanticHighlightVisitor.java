package org.eclipse.xtext.resource.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.resource.idea.lang.LiveContainerTestLanguageLanguage;

public class LiveContainerTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public LiveContainerTestLanguageSemanticHighlightVisitor() {
		LiveContainerTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
