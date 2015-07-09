package org.eclipse.xtext.resource.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.resource.idea.lang.EObjectAtOffsetTestLanguageLanguage;

public class EObjectAtOffsetTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public EObjectAtOffsetTestLanguageSemanticHighlightVisitor() {
		EObjectAtOffsetTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
