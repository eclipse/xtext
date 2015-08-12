package org.eclipse.xtext.parser.parameters.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.parameters.idea.lang.TwoParametersTestLanguageLanguage;

class TwoParametersTestLanguageCompletionContributor extends AbstractTwoParametersTestLanguageCompletionContributor {
	new() {
		this(TwoParametersTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}
