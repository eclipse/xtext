package org.eclipse.xtext.parser.terminalrules.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.parser.terminalrules.idea.lang.XtextTerminalsTestLanguageLanguage;

public class XtextTerminalsTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public XtextTerminalsTestLanguageSemanticHighlightVisitor() {
		XtextTerminalsTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
