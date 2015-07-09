package org.eclipse.xtext.parsetree.formatter.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.parsetree.formatter.idea.lang.FormatterTestLanguageLanguage;

public class FormatterTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public FormatterTestLanguageSemanticHighlightVisitor() {
		FormatterTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
