package org.eclipse.xtext.parser.fragments.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.fragments.idea.lang.FragmentTestLanguageExLanguage;

class FragmentTestLanguageExCompletionContributor extends AbstractFragmentTestLanguageExCompletionContributor {
	new() {
		this(FragmentTestLanguageExLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}
