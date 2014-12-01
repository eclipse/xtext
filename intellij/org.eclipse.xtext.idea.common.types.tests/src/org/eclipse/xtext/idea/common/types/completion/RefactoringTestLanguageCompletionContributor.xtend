package org.eclipse.xtext.idea.common.types.completion

import org.eclipse.xtext.idea.common.types.idea.lang.RefactoringTestLanguageLanguage
import org.eclipse.xtext.idea.completion.AbstractCompletionContributor

class RefactoringTestLanguageCompletionContributor extends AbstractCompletionContributor {
	new() {
		super(RefactoringTestLanguageLanguage.INSTANCE)
	}
}
