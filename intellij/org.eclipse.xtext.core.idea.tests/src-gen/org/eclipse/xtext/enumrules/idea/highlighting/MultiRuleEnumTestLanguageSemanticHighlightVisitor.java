package org.eclipse.xtext.enumrules.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.enumrules.idea.lang.MultiRuleEnumTestLanguageLanguage;

public class MultiRuleEnumTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public MultiRuleEnumTestLanguageSemanticHighlightVisitor() {
		MultiRuleEnumTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
