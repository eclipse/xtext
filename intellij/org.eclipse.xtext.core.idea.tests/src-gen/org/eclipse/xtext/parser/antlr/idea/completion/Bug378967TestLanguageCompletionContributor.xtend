package org.eclipse.xtext.parser.antlr.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug378967TestLanguageLanguage;

class Bug378967TestLanguageCompletionContributor extends AbstractBug378967TestLanguageCompletionContributor {
	new() {
		this(Bug378967TestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}
