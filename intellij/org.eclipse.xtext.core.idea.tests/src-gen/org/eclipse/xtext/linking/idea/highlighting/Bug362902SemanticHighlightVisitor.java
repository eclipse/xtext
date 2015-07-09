package org.eclipse.xtext.linking.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.linking.idea.lang.Bug362902Language;

public class Bug362902SemanticHighlightVisitor extends SemanticHighlightVisitor {
	public Bug362902SemanticHighlightVisitor() {
		Bug362902Language.INSTANCE.injectMembers(this);
	}
}
