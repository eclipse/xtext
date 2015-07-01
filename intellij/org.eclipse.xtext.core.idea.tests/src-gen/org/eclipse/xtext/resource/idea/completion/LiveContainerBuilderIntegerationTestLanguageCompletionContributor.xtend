package org.eclipse.xtext.resource.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.resource.idea.lang.LiveContainerBuilderIntegerationTestLanguageLanguage;

class LiveContainerBuilderIntegerationTestLanguageCompletionContributor extends AbstractLiveContainerBuilderIntegerationTestLanguageCompletionContributor {
	new() {
		this(LiveContainerBuilderIntegerationTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}
