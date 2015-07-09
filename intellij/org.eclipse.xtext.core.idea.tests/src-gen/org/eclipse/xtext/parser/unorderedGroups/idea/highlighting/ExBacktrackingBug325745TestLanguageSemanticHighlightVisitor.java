package org.eclipse.xtext.parser.unorderedGroups.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.ExBacktrackingBug325745TestLanguageLanguage;

public class ExBacktrackingBug325745TestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public ExBacktrackingBug325745TestLanguageSemanticHighlightVisitor() {
		ExBacktrackingBug325745TestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
