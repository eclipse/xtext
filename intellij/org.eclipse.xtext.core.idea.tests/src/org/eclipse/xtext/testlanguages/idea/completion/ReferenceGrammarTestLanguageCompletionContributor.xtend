package org.eclipse.xtext.testlanguages.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.testlanguages.idea.lang.ReferenceGrammarTestLanguageLanguage;

class ReferenceGrammarTestLanguageCompletionContributor extends AbstractReferenceGrammarTestLanguageCompletionContributor {
	new() {
		this(ReferenceGrammarTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}


