package org.eclipse.xtext.parser.terminalrules.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.terminalrules.idea.lang.HiddenTerminalsTestLanguageLanguage;

class HiddenTerminalsTestLanguageCompletionContributor extends AbstractHiddenTerminalsTestLanguageCompletionContributor {
	new() {
		this(HiddenTerminalsTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}


