package org.eclipse.xtext.testlanguages.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.testlanguages.idea.lang.LookaheadTestLanguageLanguage;

public class LookaheadTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public LookaheadTestLanguageSemanticHighlightVisitor() {
		LookaheadTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
