package org.eclipse.xtext.generator.ecore.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.generator.ecore.idea.lang.SubTestLanguageLanguage;

public class SubTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public SubTestLanguageSemanticHighlightVisitor() {
		SubTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
