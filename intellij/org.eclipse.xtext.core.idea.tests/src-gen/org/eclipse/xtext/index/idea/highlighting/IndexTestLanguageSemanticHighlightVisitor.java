package org.eclipse.xtext.index.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.index.idea.lang.IndexTestLanguageLanguage;

public class IndexTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public IndexTestLanguageSemanticHighlightVisitor() {
		IndexTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
