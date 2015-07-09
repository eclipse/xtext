package org.eclipse.xtext.parsetree.reconstr.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.SimpleReconstrTestLanguageLanguage;

public class SimpleReconstrTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public SimpleReconstrTestLanguageSemanticHighlightVisitor() {
		SimpleReconstrTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
