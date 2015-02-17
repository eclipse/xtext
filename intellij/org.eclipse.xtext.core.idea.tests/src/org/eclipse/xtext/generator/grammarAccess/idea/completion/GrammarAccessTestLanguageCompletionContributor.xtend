package org.eclipse.xtext.generator.grammarAccess.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.generator.grammarAccess.idea.lang.GrammarAccessTestLanguageLanguage;

class GrammarAccessTestLanguageCompletionContributor extends AbstractGrammarAccessTestLanguageCompletionContributor {
	new() {
		this(GrammarAccessTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}


