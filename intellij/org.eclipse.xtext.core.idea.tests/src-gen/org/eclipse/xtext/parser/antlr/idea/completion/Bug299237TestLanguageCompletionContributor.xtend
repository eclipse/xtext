package org.eclipse.xtext.parser.antlr.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug299237TestLanguageLanguage;

class Bug299237TestLanguageCompletionContributor extends AbstractBug299237TestLanguageCompletionContributor {
	new() {
		this(Bug299237TestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}
