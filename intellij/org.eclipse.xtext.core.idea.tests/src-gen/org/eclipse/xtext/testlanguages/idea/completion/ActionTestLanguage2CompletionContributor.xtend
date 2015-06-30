package org.eclipse.xtext.testlanguages.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.testlanguages.idea.lang.ActionTestLanguage2Language;

class ActionTestLanguage2CompletionContributor extends AbstractActionTestLanguage2CompletionContributor {
	new() {
		this(ActionTestLanguage2Language.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}
