package org.eclipse.xtext.parser.terminalrules.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.terminalrules.idea.lang.UnicodeTestLanguageLanguage;

class UnicodeTestLanguageCompletionContributor extends AbstractUnicodeTestLanguageCompletionContributor {
	new() {
		this(UnicodeTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}


