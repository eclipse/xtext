package org.eclipse.xtext.parser.terminalrules.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.parser.terminalrules.idea.lang.EcoreTerminalsTestLanguageLanguage;

public class EcoreTerminalsTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public EcoreTerminalsTestLanguageSemanticHighlightVisitor() {
		EcoreTerminalsTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
