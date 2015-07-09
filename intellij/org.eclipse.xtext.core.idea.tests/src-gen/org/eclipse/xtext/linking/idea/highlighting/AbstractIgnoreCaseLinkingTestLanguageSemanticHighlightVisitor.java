package org.eclipse.xtext.linking.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.linking.idea.lang.AbstractIgnoreCaseLinkingTestLanguageLanguage;

public class AbstractIgnoreCaseLinkingTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public AbstractIgnoreCaseLinkingTestLanguageSemanticHighlightVisitor() {
		AbstractIgnoreCaseLinkingTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
