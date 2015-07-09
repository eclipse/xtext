package org.eclipse.xtext.resource.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.resource.idea.lang.Bug385636Language;

public class Bug385636SemanticHighlightVisitor extends SemanticHighlightVisitor {
	public Bug385636SemanticHighlightVisitor() {
		Bug385636Language.INSTANCE.injectMembers(this);
	}
}
