package org.eclipse.xtext.testlanguages.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.testlanguages.idea.lang.LookaheadTestLanguageLanguage;

class LookaheadTestLanguageCompletionContributor extends AbstractLookaheadTestLanguageCompletionContributor {
	new() {
		this(LookaheadTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}
