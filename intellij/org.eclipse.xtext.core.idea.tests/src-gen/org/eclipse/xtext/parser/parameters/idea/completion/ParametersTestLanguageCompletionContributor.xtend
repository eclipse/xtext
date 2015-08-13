package org.eclipse.xtext.parser.parameters.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.parameters.idea.lang.ParametersTestLanguageLanguage;

class ParametersTestLanguageCompletionContributor extends AbstractParametersTestLanguageCompletionContributor {
	new() {
		this(ParametersTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}
