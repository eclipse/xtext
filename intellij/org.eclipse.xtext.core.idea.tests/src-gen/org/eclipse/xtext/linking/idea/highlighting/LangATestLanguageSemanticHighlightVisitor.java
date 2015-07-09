package org.eclipse.xtext.linking.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.linking.idea.lang.LangATestLanguageLanguage;

public class LangATestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public LangATestLanguageSemanticHighlightVisitor() {
		LangATestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
