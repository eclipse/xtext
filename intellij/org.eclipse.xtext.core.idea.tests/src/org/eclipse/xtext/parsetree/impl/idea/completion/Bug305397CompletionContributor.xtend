package org.eclipse.xtext.parsetree.impl.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parsetree.impl.idea.lang.Bug305397Language;

class Bug305397CompletionContributor extends AbstractBug305397CompletionContributor {
	new() {
		this(Bug305397Language.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}


