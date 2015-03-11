package org.eclipse.xtext.parser.keywords.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.keywords.idea.lang.KeywordsTestLanguageLanguage;

class KeywordsTestLanguageCompletionContributor extends AbstractKeywordsTestLanguageCompletionContributor {
	new() {
		this(KeywordsTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}


