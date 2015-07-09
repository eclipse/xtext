package org.eclipse.xtext.resource.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.resource.idea.lang.LiveContainerBuilderIntegerationTestLanguageLanguage;

public class LiveContainerBuilderIntegerationTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public LiveContainerBuilderIntegerationTestLanguageSemanticHighlightVisitor() {
		LiveContainerBuilderIntegerationTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
