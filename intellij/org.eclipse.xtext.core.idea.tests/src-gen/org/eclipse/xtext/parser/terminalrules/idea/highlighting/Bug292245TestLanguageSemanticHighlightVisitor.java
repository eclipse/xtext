package org.eclipse.xtext.parser.terminalrules.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.parser.terminalrules.idea.lang.Bug292245TestLanguageLanguage;

public class Bug292245TestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public Bug292245TestLanguageSemanticHighlightVisitor() {
		Bug292245TestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
