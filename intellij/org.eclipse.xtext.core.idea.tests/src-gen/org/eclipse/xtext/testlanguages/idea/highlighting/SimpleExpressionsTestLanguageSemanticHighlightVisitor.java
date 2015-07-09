package org.eclipse.xtext.testlanguages.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.testlanguages.idea.lang.SimpleExpressionsTestLanguageLanguage;

public class SimpleExpressionsTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public SimpleExpressionsTestLanguageSemanticHighlightVisitor() {
		SimpleExpressionsTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
