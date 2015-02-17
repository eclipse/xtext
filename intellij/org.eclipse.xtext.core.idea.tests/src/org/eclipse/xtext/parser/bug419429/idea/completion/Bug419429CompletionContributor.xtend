package org.eclipse.xtext.parser.bug419429.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.bug419429.idea.lang.Bug419429Language;

class Bug419429CompletionContributor extends AbstractBug419429CompletionContributor {
	new() {
		this(Bug419429Language.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}


