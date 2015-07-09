package org.eclipse.xtext.parsetree.reconstr.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.ComplexReconstrTestLanguageLanguage;

public class ComplexReconstrTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public ComplexReconstrTestLanguageSemanticHighlightVisitor() {
		ComplexReconstrTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
