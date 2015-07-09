package org.eclipse.xtext.grammarinheritance.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.grammarinheritance.idea.lang.InheritanceTestLanguageLanguage;

public class InheritanceTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public InheritanceTestLanguageSemanticHighlightVisitor() {
		InheritanceTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
