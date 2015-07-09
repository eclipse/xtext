package org.eclipse.xtext.parsetree.reconstr.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.SerializationErrorTestLanguageLanguage;

public class SerializationErrorTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public SerializationErrorTestLanguageSemanticHighlightVisitor() {
		SerializationErrorTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
