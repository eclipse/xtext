package org.eclipse.xtext.dummy.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.dummy.idea.lang.DummyTestLanguageLanguage;

public class DummyTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public DummyTestLanguageSemanticHighlightVisitor() {
		DummyTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
