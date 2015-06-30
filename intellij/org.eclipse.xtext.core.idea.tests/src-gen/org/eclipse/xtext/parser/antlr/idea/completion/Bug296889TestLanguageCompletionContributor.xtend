package org.eclipse.xtext.parser.antlr.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug296889TestLanguageLanguage;

class Bug296889TestLanguageCompletionContributor extends AbstractBug296889TestLanguageCompletionContributor {
	new() {
		this(Bug296889TestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}
