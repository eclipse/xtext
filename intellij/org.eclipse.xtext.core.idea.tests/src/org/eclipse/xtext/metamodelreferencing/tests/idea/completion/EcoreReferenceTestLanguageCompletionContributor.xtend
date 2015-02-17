package org.eclipse.xtext.metamodelreferencing.tests.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.metamodelreferencing.tests.idea.lang.EcoreReferenceTestLanguageLanguage;

class EcoreReferenceTestLanguageCompletionContributor extends AbstractEcoreReferenceTestLanguageCompletionContributor {
	new() {
		this(EcoreReferenceTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}


