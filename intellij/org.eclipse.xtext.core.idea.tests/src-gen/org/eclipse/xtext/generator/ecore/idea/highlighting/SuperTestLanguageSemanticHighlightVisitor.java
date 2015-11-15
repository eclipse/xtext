package org.eclipse.xtext.generator.ecore.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.generator.ecore.idea.lang.SuperTestLanguageLanguage;

public class SuperTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public SuperTestLanguageSemanticHighlightVisitor() {
		SuperTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
