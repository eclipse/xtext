package org.eclipse.xtext.linking.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.linking.idea.lang.Bug313089TestLanguageLanguage;

public class Bug313089TestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public Bug313089TestLanguageSemanticHighlightVisitor() {
		Bug313089TestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
