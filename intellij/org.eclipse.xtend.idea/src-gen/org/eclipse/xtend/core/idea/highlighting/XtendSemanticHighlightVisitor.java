package org.eclipse.xtend.core.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtend.core.idea.lang.XtendLanguage;

public class XtendSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public XtendSemanticHighlightVisitor() {
		XtendLanguage.INSTANCE.injectMembers(this);
	}
}
