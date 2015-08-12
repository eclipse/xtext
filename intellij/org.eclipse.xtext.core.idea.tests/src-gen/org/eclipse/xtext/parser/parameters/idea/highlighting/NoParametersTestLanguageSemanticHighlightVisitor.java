package org.eclipse.xtext.parser.parameters.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.parser.parameters.idea.lang.NoParametersTestLanguageLanguage;

public class NoParametersTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public NoParametersTestLanguageSemanticHighlightVisitor() {
		NoParametersTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
