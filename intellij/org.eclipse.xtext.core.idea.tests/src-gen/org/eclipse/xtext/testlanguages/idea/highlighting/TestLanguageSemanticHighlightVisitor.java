package org.eclipse.xtext.testlanguages.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.testlanguages.idea.lang.TestLanguageLanguage;

public class TestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public TestLanguageSemanticHighlightVisitor() {
		TestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
