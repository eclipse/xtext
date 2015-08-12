package org.eclipse.xtext.parser.parameters.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.parser.parameters.idea.lang.ParametersTestLanguageExLanguage;

public class ParametersTestLanguageExSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public ParametersTestLanguageExSemanticHighlightVisitor() {
		ParametersTestLanguageExLanguage.INSTANCE.injectMembers(this);
	}
}
