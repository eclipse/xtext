package org.eclipse.xtext.parser.terminalrules.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.parser.terminalrules.idea.lang.TerminalRulesTestLanguageLanguage;

public class TerminalRulesTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public TerminalRulesTestLanguageSemanticHighlightVisitor() {
		TerminalRulesTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
