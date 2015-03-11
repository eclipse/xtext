package org.eclipse.xtext.grammarinheritance.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.grammarinheritance.idea.lang.InheritanceTest2LanguageLanguage;

class InheritanceTest2LanguageCompletionContributor extends AbstractInheritanceTest2LanguageCompletionContributor {
	new() {
		this(InheritanceTest2LanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}


