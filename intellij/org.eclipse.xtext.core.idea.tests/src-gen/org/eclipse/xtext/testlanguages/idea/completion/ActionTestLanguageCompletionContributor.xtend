package org.eclipse.xtext.testlanguages.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.testlanguages.idea.lang.ActionTestLanguageLanguage;

class ActionTestLanguageCompletionContributor extends AbstractActionTestLanguageCompletionContributor {
	new() {
		this(ActionTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}
