package org.eclipse.xtext.testlanguages.indent.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.testlanguages.indent.idea.lang.IndentationAwareTestLanguageLanguage;

public class IndentationAwareTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public IndentationAwareTestLanguageSemanticHighlightVisitor() {
		IndentationAwareTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
