package org.eclipse.xtext.testlanguages.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.testlanguages.idea.lang.ReferenceGrammarTestLanguageLanguage;

public class ReferenceGrammarTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public ReferenceGrammarTestLanguageSemanticHighlightVisitor() {
		ReferenceGrammarTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
