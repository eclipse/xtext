package org.eclipse.xtext.enumrules.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.enumrules.idea.lang.EnumAndReferenceTestLanguageLanguage;

public class EnumAndReferenceTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public EnumAndReferenceTestLanguageSemanticHighlightVisitor() {
		EnumAndReferenceTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
