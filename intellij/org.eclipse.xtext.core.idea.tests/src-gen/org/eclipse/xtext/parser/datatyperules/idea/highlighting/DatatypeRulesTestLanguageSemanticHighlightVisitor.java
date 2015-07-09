package org.eclipse.xtext.parser.datatyperules.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.parser.datatyperules.idea.lang.DatatypeRulesTestLanguageLanguage;

public class DatatypeRulesTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public DatatypeRulesTestLanguageSemanticHighlightVisitor() {
		DatatypeRulesTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
