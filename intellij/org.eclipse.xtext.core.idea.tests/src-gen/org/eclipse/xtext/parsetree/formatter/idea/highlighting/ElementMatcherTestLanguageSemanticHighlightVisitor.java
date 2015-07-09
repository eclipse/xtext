package org.eclipse.xtext.parsetree.formatter.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.parsetree.formatter.idea.lang.ElementMatcherTestLanguageLanguage;

public class ElementMatcherTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public ElementMatcherTestLanguageSemanticHighlightVisitor() {
		ElementMatcherTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
