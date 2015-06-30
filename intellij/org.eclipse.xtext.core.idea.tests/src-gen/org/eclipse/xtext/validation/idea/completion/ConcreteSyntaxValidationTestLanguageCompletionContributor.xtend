package org.eclipse.xtext.validation.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.validation.idea.lang.ConcreteSyntaxValidationTestLanguageLanguage;

class ConcreteSyntaxValidationTestLanguageCompletionContributor extends AbstractConcreteSyntaxValidationTestLanguageCompletionContributor {
	new() {
		this(ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}
