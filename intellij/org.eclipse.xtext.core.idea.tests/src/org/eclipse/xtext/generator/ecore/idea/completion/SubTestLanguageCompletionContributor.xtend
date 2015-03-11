package org.eclipse.xtext.generator.ecore.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.generator.ecore.idea.lang.SubTestLanguageLanguage;

class SubTestLanguageCompletionContributor extends AbstractSubTestLanguageCompletionContributor {
	new() {
		this(SubTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}


