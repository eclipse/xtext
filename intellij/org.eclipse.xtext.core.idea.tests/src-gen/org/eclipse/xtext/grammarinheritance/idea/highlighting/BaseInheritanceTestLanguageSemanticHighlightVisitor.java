package org.eclipse.xtext.grammarinheritance.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.grammarinheritance.idea.lang.BaseInheritanceTestLanguageLanguage;

public class BaseInheritanceTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public BaseInheritanceTestLanguageSemanticHighlightVisitor() {
		BaseInheritanceTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
