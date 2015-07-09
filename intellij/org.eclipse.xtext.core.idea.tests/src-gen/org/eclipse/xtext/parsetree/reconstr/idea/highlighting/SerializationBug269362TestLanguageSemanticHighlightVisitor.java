package org.eclipse.xtext.parsetree.reconstr.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.SerializationBug269362TestLanguageLanguage;

public class SerializationBug269362TestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public SerializationBug269362TestLanguageSemanticHighlightVisitor() {
		SerializationBug269362TestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
