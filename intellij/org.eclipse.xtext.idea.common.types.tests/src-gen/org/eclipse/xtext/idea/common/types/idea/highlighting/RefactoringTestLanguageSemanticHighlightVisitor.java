package org.eclipse.xtext.idea.common.types.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.idea.common.types.idea.lang.RefactoringTestLanguageLanguage;

public class RefactoringTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public RefactoringTestLanguageSemanticHighlightVisitor() {
		RefactoringTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
