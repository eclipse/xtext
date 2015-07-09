package org.eclipse.xtext.testlanguages.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.testlanguages.idea.lang.OptionalEmptyTestLanguageLanguage;

public class OptionalEmptyTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public OptionalEmptyTestLanguageSemanticHighlightVisitor() {
		OptionalEmptyTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
