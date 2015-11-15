package org.eclipse.xtext.generator.ecore.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.generator.ecore.idea.lang.SuperTestLanguageLanguage;

class SuperTestLanguageCompletionContributor extends AbstractSuperTestLanguageCompletionContributor {
	new() {
		this(SuperTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}
