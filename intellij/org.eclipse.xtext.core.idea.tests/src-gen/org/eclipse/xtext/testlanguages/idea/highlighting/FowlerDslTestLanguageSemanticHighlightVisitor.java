package org.eclipse.xtext.testlanguages.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.testlanguages.idea.lang.FowlerDslTestLanguageLanguage;

public class FowlerDslTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public FowlerDslTestLanguageSemanticHighlightVisitor() {
		FowlerDslTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
