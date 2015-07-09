package org.eclipse.xtext.valueconverter.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.valueconverter.idea.lang.Bug250313Language;

public class Bug250313SemanticHighlightVisitor extends SemanticHighlightVisitor {
	public Bug250313SemanticHighlightVisitor() {
		Bug250313Language.INSTANCE.injectMembers(this);
	}
}
