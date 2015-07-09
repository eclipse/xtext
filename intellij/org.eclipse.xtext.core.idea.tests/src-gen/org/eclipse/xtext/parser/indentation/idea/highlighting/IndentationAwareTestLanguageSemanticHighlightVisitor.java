package org.eclipse.xtext.parser.indentation.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.parser.indentation.idea.lang.IndentationAwareTestLanguageLanguage;

public class IndentationAwareTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public IndentationAwareTestLanguageSemanticHighlightVisitor() {
		IndentationAwareTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
