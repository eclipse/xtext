package org.eclipse.xtext.linking.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.linking.idea.lang.AbstractIgnoreCaseLinkingTestLanguageLanguage;

class AbstractIgnoreCaseLinkingTestLanguageCompletionContributor extends AbstractAbstractIgnoreCaseLinkingTestLanguageCompletionContributor {
	new() {
		this(AbstractIgnoreCaseLinkingTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}


