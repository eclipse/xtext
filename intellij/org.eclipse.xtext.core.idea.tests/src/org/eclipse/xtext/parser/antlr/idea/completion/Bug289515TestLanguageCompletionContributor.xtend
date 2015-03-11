package org.eclipse.xtext.parser.antlr.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug289515TestLanguageLanguage;

class Bug289515TestLanguageCompletionContributor extends AbstractBug289515TestLanguageCompletionContributor {
	new() {
		this(Bug289515TestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}


