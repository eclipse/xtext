package org.eclipse.xtext.enumrules.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.enumrules.idea.lang.EnumRulesTestLanguageLanguage;

class EnumRulesTestLanguageCompletionContributor extends AbstractEnumRulesTestLanguageCompletionContributor {
	new() {
		this(EnumRulesTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}
