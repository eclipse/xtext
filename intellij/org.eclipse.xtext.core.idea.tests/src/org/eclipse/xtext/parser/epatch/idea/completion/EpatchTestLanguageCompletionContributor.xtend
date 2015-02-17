package org.eclipse.xtext.parser.epatch.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.epatch.idea.lang.EpatchTestLanguageLanguage;

class EpatchTestLanguageCompletionContributor extends AbstractEpatchTestLanguageCompletionContributor {
	new() {
		this(EpatchTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}


