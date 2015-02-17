package org.eclipse.xtext.xtext.ecoreInference.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.xtext.ecoreInference.idea.lang.MultiValueFeatureTestLanguageLanguage;

class MultiValueFeatureTestLanguageCompletionContributor extends AbstractMultiValueFeatureTestLanguageCompletionContributor {
	new() {
		this(MultiValueFeatureTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}


