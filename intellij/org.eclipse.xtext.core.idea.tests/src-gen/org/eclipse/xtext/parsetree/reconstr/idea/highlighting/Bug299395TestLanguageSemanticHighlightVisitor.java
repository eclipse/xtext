package org.eclipse.xtext.parsetree.reconstr.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.Bug299395TestLanguageLanguage;

public class Bug299395TestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public Bug299395TestLanguageSemanticHighlightVisitor() {
		Bug299395TestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
