package org.eclipse.xtext.parser.unorderedGroups.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.SimpleBacktrackingBug325745TestLanguageLanguage;

public class SimpleBacktrackingBug325745TestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public SimpleBacktrackingBug325745TestLanguageSemanticHighlightVisitor() {
		SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
