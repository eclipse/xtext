package org.eclipse.xtext.parser.terminalrules.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.parser.terminalrules.idea.lang.HiddenTerminalsTestLanguageLanguage;

public class HiddenTerminalsTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public HiddenTerminalsTestLanguageSemanticHighlightVisitor() {
		HiddenTerminalsTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
