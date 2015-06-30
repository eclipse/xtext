package org.eclipse.xtext.resource.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.resource.idea.lang.LiveContainerTestLanguageLanguage;

class LiveContainerTestLanguageCompletionContributor extends AbstractLiveContainerTestLanguageCompletionContributor {
	new() {
		this(LiveContainerTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}
