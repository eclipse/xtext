package org.eclipse.xtext.testlanguages.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.testlanguages.idea.lang.PartialParserTestLanguageLanguage;

class PartialParserTestLanguageCompletionContributor extends AbstractPartialParserTestLanguageCompletionContributor {
	new() {
		this(PartialParserTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}
