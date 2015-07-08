package org.eclipse.xtext.purexbase.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.purexbase.idea.lang.PureXbaseLanguage;

public class PureXbaseSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public PureXbaseSemanticHighlightVisitor() {
		PureXbaseLanguage.INSTANCE.injectMembers(this);
	}
}
