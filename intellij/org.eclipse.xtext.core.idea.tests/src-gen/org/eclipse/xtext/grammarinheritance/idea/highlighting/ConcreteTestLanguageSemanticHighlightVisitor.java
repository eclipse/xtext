package org.eclipse.xtext.grammarinheritance.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.grammarinheritance.idea.lang.ConcreteTestLanguageLanguage;

public class ConcreteTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public ConcreteTestLanguageSemanticHighlightVisitor() {
		ConcreteTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
