package org.eclipse.xtext.parser.terminalrules.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.terminalrules.idea.lang.Bug292245TestLanguageLanguage;

class Bug292245TestLanguageCompletionContributor extends AbstractBug292245TestLanguageCompletionContributor {
	new() {
		this(Bug292245TestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}


