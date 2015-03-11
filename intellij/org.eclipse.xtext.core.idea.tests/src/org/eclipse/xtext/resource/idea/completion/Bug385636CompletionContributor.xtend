package org.eclipse.xtext.resource.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.resource.idea.lang.Bug385636Language;

class Bug385636CompletionContributor extends AbstractBug385636CompletionContributor {
	new() {
		this(Bug385636Language.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}


