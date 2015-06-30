package org.eclipse.xtext.parser.terminalrules.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.terminalrules.idea.lang.Bug317840TestLanguageLanguage;

class Bug317840TestLanguageCompletionContributor extends AbstractBug317840TestLanguageCompletionContributor {
	new() {
		this(Bug317840TestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}
