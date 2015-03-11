package org.eclipse.xtext.dummy.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.dummy.idea.lang.DummyTestLanguageLanguage;

class DummyTestLanguageCompletionContributor extends AbstractDummyTestLanguageCompletionContributor {
	new() {
		this(DummyTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}


