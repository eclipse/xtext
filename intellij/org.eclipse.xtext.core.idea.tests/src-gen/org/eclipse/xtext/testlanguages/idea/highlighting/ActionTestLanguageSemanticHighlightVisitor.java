package org.eclipse.xtext.testlanguages.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.testlanguages.idea.lang.ActionTestLanguageLanguage;

public class ActionTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public ActionTestLanguageSemanticHighlightVisitor() {
		ActionTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
