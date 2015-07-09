package org.eclipse.xtext.parser.terminalrules.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.parser.terminalrules.idea.lang.UnicodeTestLanguageLanguage;

public class UnicodeTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public UnicodeTestLanguageSemanticHighlightVisitor() {
		UnicodeTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
