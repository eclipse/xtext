package org.eclipse.xtext.metamodelreferencing.tests.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.metamodelreferencing.tests.idea.lang.MultiGenMMTestLanguageLanguage;

class MultiGenMMTestLanguageCompletionContributor extends AbstractMultiGenMMTestLanguageCompletionContributor {
	new() {
		this(MultiGenMMTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}


