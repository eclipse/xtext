package org.eclipse.xtext.parser.antlr.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug301935TestLanguageLanguage;

class Bug301935TestLanguageCompletionContributor extends AbstractBug301935TestLanguageCompletionContributor {
	new() {
		this(Bug301935TestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}
