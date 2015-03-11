package org.eclipse.xtext.testlanguages.backtracking.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.testlanguages.backtracking.idea.lang.BeeLangTestLanguageLanguage;

class BeeLangTestLanguageCompletionContributor extends AbstractBeeLangTestLanguageCompletionContributor {
	new() {
		this(BeeLangTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}


