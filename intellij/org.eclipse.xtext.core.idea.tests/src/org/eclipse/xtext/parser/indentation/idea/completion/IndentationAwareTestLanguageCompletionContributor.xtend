package org.eclipse.xtext.parser.indentation.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.indentation.idea.lang.IndentationAwareTestLanguageLanguage;

class IndentationAwareTestLanguageCompletionContributor extends AbstractIndentationAwareTestLanguageCompletionContributor {
	new() {
		this(IndentationAwareTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}


