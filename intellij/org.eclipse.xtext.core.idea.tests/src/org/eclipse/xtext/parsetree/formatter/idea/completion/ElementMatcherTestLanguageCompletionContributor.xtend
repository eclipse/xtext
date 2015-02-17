package org.eclipse.xtext.parsetree.formatter.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parsetree.formatter.idea.lang.ElementMatcherTestLanguageLanguage;

class ElementMatcherTestLanguageCompletionContributor extends AbstractElementMatcherTestLanguageCompletionContributor {
	new() {
		this(ElementMatcherTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}


