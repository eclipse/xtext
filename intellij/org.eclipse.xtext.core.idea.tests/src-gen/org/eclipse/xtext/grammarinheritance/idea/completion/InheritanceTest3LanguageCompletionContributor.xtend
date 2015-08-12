package org.eclipse.xtext.grammarinheritance.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.grammarinheritance.idea.lang.InheritanceTest3LanguageLanguage;

class InheritanceTest3LanguageCompletionContributor extends AbstractInheritanceTest3LanguageCompletionContributor {
	new() {
		this(InheritanceTest3LanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}
