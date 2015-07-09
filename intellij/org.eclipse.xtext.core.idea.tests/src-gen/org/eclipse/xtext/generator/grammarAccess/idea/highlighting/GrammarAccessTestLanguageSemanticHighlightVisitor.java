package org.eclipse.xtext.generator.grammarAccess.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.generator.grammarAccess.idea.lang.GrammarAccessTestLanguageLanguage;

public class GrammarAccessTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public GrammarAccessTestLanguageSemanticHighlightVisitor() {
		GrammarAccessTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
