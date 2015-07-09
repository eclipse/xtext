package org.eclipse.xtext.parser.antlr.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug301935TestLanguageLanguage;

public class Bug301935TestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public Bug301935TestLanguageSemanticHighlightVisitor() {
		Bug301935TestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
