package org.eclipse.xtext.testlanguages.indent.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.testlanguages.indent.idea.lang.IndentationAwareTestLanguageLanguage;

class IndentationAwareTestLanguageCompletionContributor extends AbstractIndentationAwareTestLanguageCompletionContributor {
	new() {
		this(IndentationAwareTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}


