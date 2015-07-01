package org.eclipse.xtext.linking.lazy.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.linking.lazy.idea.lang.Bug311337TestLanguageLanguage;

class Bug311337TestLanguageCompletionContributor extends AbstractBug311337TestLanguageCompletionContributor {
	new() {
		this(Bug311337TestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}
