package org.eclipse.xtext.testlanguages.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.testlanguages.idea.lang.FowlerDslTestLanguageLanguage;

class FowlerDslTestLanguageCompletionContributor extends AbstractFowlerDslTestLanguageCompletionContributor {
	new() {
		this(FowlerDslTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}


