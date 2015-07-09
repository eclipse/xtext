package org.eclipse.xtext.parsetree.transientvalues.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.parsetree.transientvalues.idea.lang.TransientValuesTestLanguage;

public class TransientValuesTestSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public TransientValuesTestSemanticHighlightVisitor() {
		TransientValuesTestLanguage.INSTANCE.injectMembers(this);
	}
}
