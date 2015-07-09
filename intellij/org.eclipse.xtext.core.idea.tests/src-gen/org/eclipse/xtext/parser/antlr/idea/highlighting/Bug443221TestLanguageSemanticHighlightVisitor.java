package org.eclipse.xtext.parser.antlr.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug443221TestLanguageLanguage;

public class Bug443221TestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public Bug443221TestLanguageSemanticHighlightVisitor() {
		Bug443221TestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
