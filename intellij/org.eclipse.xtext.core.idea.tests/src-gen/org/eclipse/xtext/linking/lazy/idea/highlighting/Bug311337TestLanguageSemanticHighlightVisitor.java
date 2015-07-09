package org.eclipse.xtext.linking.lazy.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.linking.lazy.idea.lang.Bug311337TestLanguageLanguage;

public class Bug311337TestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public Bug311337TestLanguageSemanticHighlightVisitor() {
		Bug311337TestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
