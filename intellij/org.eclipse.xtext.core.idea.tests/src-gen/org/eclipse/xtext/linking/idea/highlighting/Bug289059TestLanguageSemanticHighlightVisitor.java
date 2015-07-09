package org.eclipse.xtext.linking.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.linking.idea.lang.Bug289059TestLanguageLanguage;

public class Bug289059TestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public Bug289059TestLanguageSemanticHighlightVisitor() {
		Bug289059TestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
