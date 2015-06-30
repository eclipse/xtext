package org.eclipse.xtext.testlanguages.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.testlanguages.idea.lang.OptionalEmptyTestLanguageLanguage;

class OptionalEmptyTestLanguageCompletionContributor extends AbstractOptionalEmptyTestLanguageCompletionContributor {
	new() {
		this(OptionalEmptyTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}
