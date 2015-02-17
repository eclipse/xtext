package org.eclipse.xtext.grammarinheritance.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.grammarinheritance.idea.lang.AbstractTestLanguageLanguage;

class AbstractTestLanguageCompletionContributor extends AbstractAbstractTestLanguageCompletionContributor {
	new() {
		this(AbstractTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}


