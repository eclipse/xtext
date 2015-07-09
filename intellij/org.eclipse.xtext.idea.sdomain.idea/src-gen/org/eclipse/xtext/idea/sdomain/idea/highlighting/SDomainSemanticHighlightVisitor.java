package org.eclipse.xtext.idea.sdomain.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.idea.sdomain.idea.lang.SDomainLanguage;

public class SDomainSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public SDomainSemanticHighlightVisitor() {
		SDomainLanguage.INSTANCE.injectMembers(this);
	}
}
