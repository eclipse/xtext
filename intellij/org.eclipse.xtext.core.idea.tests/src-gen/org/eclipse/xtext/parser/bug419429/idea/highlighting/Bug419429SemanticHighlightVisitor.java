package org.eclipse.xtext.parser.bug419429.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.parser.bug419429.idea.lang.Bug419429Language;

public class Bug419429SemanticHighlightVisitor extends SemanticHighlightVisitor {
	public Bug419429SemanticHighlightVisitor() {
		Bug419429Language.INSTANCE.injectMembers(this);
	}
}
