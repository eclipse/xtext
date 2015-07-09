package org.eclipse.xtext.parser.unorderedGroups.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.BacktrackingBug325745TestLanguageLanguage;

public class BacktrackingBug325745TestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public BacktrackingBug325745TestLanguageSemanticHighlightVisitor() {
		BacktrackingBug325745TestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
