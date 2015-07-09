package org.eclipse.xtext.testlanguages.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.testlanguages.idea.lang.PartialParserTestLanguageLanguage;

public class PartialParserTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public PartialParserTestLanguageSemanticHighlightVisitor() {
		PartialParserTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
