package org.eclipse.xtext.parser.parameters.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.parameters.idea.lang.ParametersTestLanguageExLanguage;

class ParametersTestLanguageExCompletionContributor extends AbstractParametersTestLanguageExCompletionContributor {
	new() {
		this(ParametersTestLanguageExLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}
