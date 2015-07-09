package org.eclipse.xtext.validation.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.validation.idea.lang.ConcreteSyntaxValidationTestLanguageLanguage;

public class ConcreteSyntaxValidationTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public ConcreteSyntaxValidationTestLanguageSemanticHighlightVisitor() {
		ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
