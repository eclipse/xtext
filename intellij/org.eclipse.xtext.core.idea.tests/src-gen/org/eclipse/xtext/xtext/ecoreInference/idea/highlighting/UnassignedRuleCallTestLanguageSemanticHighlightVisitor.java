package org.eclipse.xtext.xtext.ecoreInference.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.xtext.ecoreInference.idea.lang.UnassignedRuleCallTestLanguageLanguage;

public class UnassignedRuleCallTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public UnassignedRuleCallTestLanguageSemanticHighlightVisitor() {
		UnassignedRuleCallTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
