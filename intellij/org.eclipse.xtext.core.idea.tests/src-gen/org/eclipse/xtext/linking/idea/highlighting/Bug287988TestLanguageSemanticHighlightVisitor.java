package org.eclipse.xtext.linking.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.linking.idea.lang.Bug287988TestLanguageLanguage;

public class Bug287988TestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public Bug287988TestLanguageSemanticHighlightVisitor() {
		Bug287988TestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
