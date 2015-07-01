package org.eclipse.xtext.xtext.ecoreInference.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.xtext.ecoreInference.idea.lang.UnassignedRuleCallTestLanguageLanguage;

class UnassignedRuleCallTestLanguageCompletionContributor extends AbstractUnassignedRuleCallTestLanguageCompletionContributor {
	new() {
		this(UnassignedRuleCallTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}
