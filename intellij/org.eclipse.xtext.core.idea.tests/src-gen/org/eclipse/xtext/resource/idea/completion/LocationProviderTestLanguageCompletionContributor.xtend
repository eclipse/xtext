package org.eclipse.xtext.resource.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.resource.idea.lang.LocationProviderTestLanguageLanguage;

class LocationProviderTestLanguageCompletionContributor extends AbstractLocationProviderTestLanguageCompletionContributor {
	new() {
		this(LocationProviderTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}
