package org.eclipse.xtext.parser.datatyperules.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.datatyperules.idea.lang.DatatypeRulesTestLanguageLanguage;

class DatatypeRulesTestLanguageCompletionContributor extends AbstractDatatypeRulesTestLanguageCompletionContributor {
	new() {
		this(DatatypeRulesTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}


