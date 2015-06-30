package org.eclipse.xtext.parser.antlr.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug289524TestLanguageLanguage;

class Bug289524TestLanguageCompletionContributor extends AbstractBug289524TestLanguageCompletionContributor {
	new() {
		this(Bug289524TestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}
