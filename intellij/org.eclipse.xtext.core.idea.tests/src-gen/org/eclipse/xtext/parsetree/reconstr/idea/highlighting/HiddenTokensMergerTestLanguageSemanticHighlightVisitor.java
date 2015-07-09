package org.eclipse.xtext.parsetree.reconstr.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.HiddenTokensMergerTestLanguageLanguage;

public class HiddenTokensMergerTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public HiddenTokensMergerTestLanguageSemanticHighlightVisitor() {
		HiddenTokensMergerTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
