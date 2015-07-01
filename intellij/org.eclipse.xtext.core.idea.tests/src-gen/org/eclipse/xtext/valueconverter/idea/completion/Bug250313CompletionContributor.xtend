package org.eclipse.xtext.valueconverter.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.valueconverter.idea.lang.Bug250313Language;

class Bug250313CompletionContributor extends AbstractBug250313CompletionContributor {
	new() {
		this(Bug250313Language.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}
