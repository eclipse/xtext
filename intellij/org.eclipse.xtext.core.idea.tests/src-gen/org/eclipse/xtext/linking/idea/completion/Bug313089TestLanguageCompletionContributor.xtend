package org.eclipse.xtext.linking.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.linking.idea.lang.Bug313089TestLanguageLanguage;

class Bug313089TestLanguageCompletionContributor extends AbstractBug313089TestLanguageCompletionContributor {
	new() {
		this(Bug313089TestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}
