package org.eclipse.xtext.parser.parameters.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.parser.parameters.idea.lang.TwoParametersTestLanguageLanguage;

public class TwoParametersTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public TwoParametersTestLanguageSemanticHighlightVisitor() {
		TwoParametersTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
