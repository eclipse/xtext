package org.eclipse.xtext.linking.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.linking.idea.lang.IgnoreCaseImportsTestLanguageLanguage;

class IgnoreCaseImportsTestLanguageCompletionContributor extends AbstractIgnoreCaseImportsTestLanguageCompletionContributor {
	new() {
		this(IgnoreCaseImportsTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}


