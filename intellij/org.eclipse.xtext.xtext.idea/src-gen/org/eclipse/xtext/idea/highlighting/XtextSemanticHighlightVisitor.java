package org.eclipse.xtext.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.idea.lang.XtextLanguage;

public class XtextSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public XtextSemanticHighlightVisitor() {
		XtextLanguage.INSTANCE.injectMembers(this);
	}
}
