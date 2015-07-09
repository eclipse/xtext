package org.eclipse.xtext.testlanguages.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.testlanguages.idea.lang.TreeTestLanguageLanguage;

public class TreeTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public TreeTestLanguageSemanticHighlightVisitor() {
		TreeTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
