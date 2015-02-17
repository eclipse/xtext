package org.eclipse.xtext.parser.antlr.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug301935ExTestLanguageLanguage;

class Bug301935ExTestLanguageCompletionContributor extends AbstractBug301935ExTestLanguageCompletionContributor {
	new() {
		this(Bug301935ExTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}


