package org.eclipse.xtext.parser.parameters.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.parameters.idea.lang.NoParametersTestLanguageLanguage;

class NoParametersTestLanguageCompletionContributor extends AbstractNoParametersTestLanguageCompletionContributor {
	new() {
		this(NoParametersTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}
