package org.eclipse.xtext.testlanguages.backtracking.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.testlanguages.backtracking.idea.lang.ExBeeLangTestLanguageLanguage;

class ExBeeLangTestLanguageCompletionContributor extends AbstractExBeeLangTestLanguageCompletionContributor {
	new() {
		this(ExBeeLangTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}


