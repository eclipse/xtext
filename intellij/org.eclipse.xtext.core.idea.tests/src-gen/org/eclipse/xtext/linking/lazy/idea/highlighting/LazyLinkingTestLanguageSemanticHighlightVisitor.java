package org.eclipse.xtext.linking.lazy.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.linking.lazy.idea.lang.LazyLinkingTestLanguageLanguage;

public class LazyLinkingTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public LazyLinkingTestLanguageSemanticHighlightVisitor() {
		LazyLinkingTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
