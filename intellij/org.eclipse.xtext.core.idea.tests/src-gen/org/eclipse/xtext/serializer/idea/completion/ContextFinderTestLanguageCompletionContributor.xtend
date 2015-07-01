package org.eclipse.xtext.serializer.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.serializer.idea.lang.ContextFinderTestLanguageLanguage;

class ContextFinderTestLanguageCompletionContributor extends AbstractContextFinderTestLanguageCompletionContributor {
	new() {
		this(ContextFinderTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}
