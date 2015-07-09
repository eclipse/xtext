package org.eclipse.xtext.parser.terminalrules.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.parser.terminalrules.idea.lang.Bug317840TestLanguageLanguage;

public class Bug317840TestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public Bug317840TestLanguageSemanticHighlightVisitor() {
		Bug317840TestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
