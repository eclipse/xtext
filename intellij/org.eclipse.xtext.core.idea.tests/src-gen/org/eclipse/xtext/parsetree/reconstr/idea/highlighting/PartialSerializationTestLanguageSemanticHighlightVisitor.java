package org.eclipse.xtext.parsetree.reconstr.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.PartialSerializationTestLanguageLanguage;

public class PartialSerializationTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public PartialSerializationTestLanguageSemanticHighlightVisitor() {
		PartialSerializationTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
