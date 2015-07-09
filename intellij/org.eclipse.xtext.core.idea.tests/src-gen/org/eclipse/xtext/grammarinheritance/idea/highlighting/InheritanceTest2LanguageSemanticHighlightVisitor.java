package org.eclipse.xtext.grammarinheritance.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.grammarinheritance.idea.lang.InheritanceTest2LanguageLanguage;

public class InheritanceTest2LanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public InheritanceTest2LanguageSemanticHighlightVisitor() {
		InheritanceTest2LanguageLanguage.INSTANCE.injectMembers(this);
	}
}
