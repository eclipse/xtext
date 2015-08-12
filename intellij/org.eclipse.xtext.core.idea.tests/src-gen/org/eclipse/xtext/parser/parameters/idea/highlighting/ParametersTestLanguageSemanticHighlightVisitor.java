package org.eclipse.xtext.parser.parameters.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.parser.parameters.idea.lang.ParametersTestLanguageLanguage;

public class ParametersTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public ParametersTestLanguageSemanticHighlightVisitor() {
		ParametersTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
