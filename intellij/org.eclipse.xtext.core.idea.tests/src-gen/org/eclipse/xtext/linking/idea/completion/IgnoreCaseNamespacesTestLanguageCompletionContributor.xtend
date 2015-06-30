package org.eclipse.xtext.linking.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.linking.idea.lang.IgnoreCaseNamespacesTestLanguageLanguage;

class IgnoreCaseNamespacesTestLanguageCompletionContributor extends AbstractIgnoreCaseNamespacesTestLanguageCompletionContributor {
	new() {
		this(IgnoreCaseNamespacesTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}
