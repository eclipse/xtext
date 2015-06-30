package org.eclipse.xtext.enumrules.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.enumrules.idea.lang.MultiRuleEnumTestLanguageLanguage;

class MultiRuleEnumTestLanguageCompletionContributor extends AbstractMultiRuleEnumTestLanguageCompletionContributor {
	new() {
		this(MultiRuleEnumTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}
