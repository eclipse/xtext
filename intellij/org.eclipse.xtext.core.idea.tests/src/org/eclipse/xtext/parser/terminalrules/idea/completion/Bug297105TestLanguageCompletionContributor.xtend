package org.eclipse.xtext.parser.terminalrules.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.terminalrules.idea.lang.Bug297105TestLanguageLanguage;

class Bug297105TestLanguageCompletionContributor extends AbstractBug297105TestLanguageCompletionContributor {
	new() {
		this(Bug297105TestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}


