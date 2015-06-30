package org.eclipse.xtext.linking.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.linking.idea.lang.Bug289059TestLanguageLanguage;

class Bug289059TestLanguageCompletionContributor extends AbstractBug289059TestLanguageCompletionContributor {
	new() {
		this(Bug289059TestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}
