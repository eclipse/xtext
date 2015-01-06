package org.eclipse.xtext.idea.common.types.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.idea.common.types.idea.lang.RefactoringTestLanguageLanguage;

class RefactoringTestLanguageCompletionContributor extends AbstractRefactoringTestLanguageCompletionContributor {
	new() {
		this(RefactoringTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}


