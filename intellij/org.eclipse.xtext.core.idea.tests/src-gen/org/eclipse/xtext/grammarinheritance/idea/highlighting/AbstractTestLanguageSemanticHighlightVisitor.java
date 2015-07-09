package org.eclipse.xtext.grammarinheritance.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.grammarinheritance.idea.lang.AbstractTestLanguageLanguage;

public class AbstractTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public AbstractTestLanguageSemanticHighlightVisitor() {
		AbstractTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
