package org.eclipse.xtext.parser.unorderedGroups.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.UnorderedGroupsTestLanguageLanguage;

public class UnorderedGroupsTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public UnorderedGroupsTestLanguageSemanticHighlightVisitor() {
		UnorderedGroupsTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
