package org.eclipse.xtext.parser.fragments.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.fragments.idea.lang.FragmentTestLanguageLanguage;

class FragmentTestLanguageCompletionContributor extends AbstractFragmentTestLanguageCompletionContributor {
	new() {
		this(FragmentTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}
