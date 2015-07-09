package org.eclipse.xtext.testlanguages.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.testlanguages.idea.lang.ActionTestLanguage2Language;

public class ActionTestLanguage2SemanticHighlightVisitor extends SemanticHighlightVisitor {
	public ActionTestLanguage2SemanticHighlightVisitor() {
		ActionTestLanguage2Language.INSTANCE.injectMembers(this);
	}
}
