package org.eclipse.xtext.parsetree.impl.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.parsetree.impl.idea.lang.Bug305397Language;

public class Bug305397SemanticHighlightVisitor extends SemanticHighlightVisitor {
	public Bug305397SemanticHighlightVisitor() {
		Bug305397Language.INSTANCE.injectMembers(this);
	}
}
