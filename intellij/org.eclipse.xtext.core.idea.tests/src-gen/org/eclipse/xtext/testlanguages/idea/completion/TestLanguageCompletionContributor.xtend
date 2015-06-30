package org.eclipse.xtext.testlanguages.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.testlanguages.idea.lang.TestLanguageLanguage;

class TestLanguageCompletionContributor extends AbstractTestLanguageCompletionContributor {
	new() {
		this(TestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}
