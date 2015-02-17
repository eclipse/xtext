package org.eclipse.xtext.testlanguages.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.testlanguages.idea.lang.TreeTestLanguageLanguage;

class TreeTestLanguageCompletionContributor extends AbstractTreeTestLanguageCompletionContributor {
	new() {
		this(TreeTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}


