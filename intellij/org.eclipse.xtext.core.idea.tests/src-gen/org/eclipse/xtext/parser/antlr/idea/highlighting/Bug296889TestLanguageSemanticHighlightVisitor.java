package org.eclipse.xtext.parser.antlr.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug296889TestLanguageLanguage;

public class Bug296889TestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public Bug296889TestLanguageSemanticHighlightVisitor() {
		Bug296889TestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
