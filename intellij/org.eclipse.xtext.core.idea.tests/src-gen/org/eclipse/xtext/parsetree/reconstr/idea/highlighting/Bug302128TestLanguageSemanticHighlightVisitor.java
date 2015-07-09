package org.eclipse.xtext.parsetree.reconstr.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.Bug302128TestLanguageLanguage;

public class Bug302128TestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public Bug302128TestLanguageSemanticHighlightVisitor() {
		Bug302128TestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
