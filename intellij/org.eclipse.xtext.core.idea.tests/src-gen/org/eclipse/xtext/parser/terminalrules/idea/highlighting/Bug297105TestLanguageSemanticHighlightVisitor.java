package org.eclipse.xtext.parser.terminalrules.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.parser.terminalrules.idea.lang.Bug297105TestLanguageLanguage;

public class Bug297105TestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public Bug297105TestLanguageSemanticHighlightVisitor() {
		Bug297105TestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
