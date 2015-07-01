package org.eclipse.xtext.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.idea.lang.XtextGrammarTestLanguageLanguage;

class XtextGrammarTestLanguageCompletionContributor extends AbstractXtextGrammarTestLanguageCompletionContributor {
	new() {
		this(XtextGrammarTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}
