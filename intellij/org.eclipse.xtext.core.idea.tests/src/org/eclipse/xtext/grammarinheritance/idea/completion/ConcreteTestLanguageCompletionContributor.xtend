package org.eclipse.xtext.grammarinheritance.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.grammarinheritance.idea.lang.ConcreteTestLanguageLanguage;

class ConcreteTestLanguageCompletionContributor extends AbstractConcreteTestLanguageCompletionContributor {
	new() {
		this(ConcreteTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}


