package org.eclipse.xtext.testlanguages.backtracking.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.testlanguages.backtracking.idea.lang.SimpleBeeLangTestLanguageLanguage;

class SimpleBeeLangTestLanguageCompletionContributor extends AbstractSimpleBeeLangTestLanguageCompletionContributor {
	new() {
		this(SimpleBeeLangTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}


