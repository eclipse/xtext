package org.eclipse.xtext.parser.keywords.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.parser.keywords.idea.lang.KeywordsTestLanguageLanguage;

public class KeywordsTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public KeywordsTestLanguageSemanticHighlightVisitor() {
		KeywordsTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
