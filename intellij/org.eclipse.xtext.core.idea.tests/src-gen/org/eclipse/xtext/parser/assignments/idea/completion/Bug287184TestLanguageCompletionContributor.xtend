package org.eclipse.xtext.parser.assignments.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.assignments.idea.lang.Bug287184TestLanguageLanguage;

class Bug287184TestLanguageCompletionContributor extends AbstractBug287184TestLanguageCompletionContributor {
	new() {
		this(Bug287184TestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}
