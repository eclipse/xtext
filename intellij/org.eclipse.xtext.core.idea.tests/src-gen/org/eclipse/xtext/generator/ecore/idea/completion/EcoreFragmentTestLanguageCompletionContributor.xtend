package org.eclipse.xtext.generator.ecore.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.generator.ecore.idea.lang.EcoreFragmentTestLanguageLanguage;

class EcoreFragmentTestLanguageCompletionContributor extends AbstractEcoreFragmentTestLanguageCompletionContributor {
	new() {
		this(EcoreFragmentTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}
