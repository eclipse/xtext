package org.eclipse.xtext.parser.unorderedGroups.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.SimpleUnorderedGroupsTestLanguageLanguage;

public class SimpleUnorderedGroupsTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public SimpleUnorderedGroupsTestLanguageSemanticHighlightVisitor() {
		SimpleUnorderedGroupsTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
