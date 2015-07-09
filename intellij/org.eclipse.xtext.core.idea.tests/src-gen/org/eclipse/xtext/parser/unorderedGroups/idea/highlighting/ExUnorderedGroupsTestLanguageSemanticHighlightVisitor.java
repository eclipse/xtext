package org.eclipse.xtext.parser.unorderedGroups.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.ExUnorderedGroupsTestLanguageLanguage;

public class ExUnorderedGroupsTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public ExUnorderedGroupsTestLanguageSemanticHighlightVisitor() {
		ExUnorderedGroupsTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
