package org.eclipse.xtext.valueconverter.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.valueconverter.idea.lang.QualifiedNameTestLanguageLanguage;

public class QualifiedNameTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public QualifiedNameTestLanguageSemanticHighlightVisitor() {
		QualifiedNameTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
