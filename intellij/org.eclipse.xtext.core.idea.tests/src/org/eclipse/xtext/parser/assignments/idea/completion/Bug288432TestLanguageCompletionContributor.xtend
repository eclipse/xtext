package org.eclipse.xtext.parser.assignments.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.assignments.idea.lang.Bug288432TestLanguageLanguage;

class Bug288432TestLanguageCompletionContributor extends AbstractBug288432TestLanguageCompletionContributor {
	new() {
		this(Bug288432TestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}


