package org.eclipse.xtext.parser.encoding.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.parser.encoding.idea.lang.EncodingTestLanguageLanguage;

public class EncodingTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public EncodingTestLanguageSemanticHighlightVisitor() {
		EncodingTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
