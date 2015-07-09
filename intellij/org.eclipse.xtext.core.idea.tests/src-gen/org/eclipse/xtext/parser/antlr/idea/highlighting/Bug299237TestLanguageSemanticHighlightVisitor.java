package org.eclipse.xtext.parser.antlr.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug299237TestLanguageLanguage;

public class Bug299237TestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public Bug299237TestLanguageSemanticHighlightVisitor() {
		Bug299237TestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
