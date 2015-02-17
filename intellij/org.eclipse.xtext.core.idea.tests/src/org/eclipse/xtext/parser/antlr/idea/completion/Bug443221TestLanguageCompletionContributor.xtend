package org.eclipse.xtext.parser.antlr.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug443221TestLanguageLanguage;

class Bug443221TestLanguageCompletionContributor extends AbstractBug443221TestLanguageCompletionContributor {
	new() {
		this(Bug443221TestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}


