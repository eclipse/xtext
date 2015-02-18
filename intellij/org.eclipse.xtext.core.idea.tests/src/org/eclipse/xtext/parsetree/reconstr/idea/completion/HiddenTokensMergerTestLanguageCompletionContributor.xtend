package org.eclipse.xtext.parsetree.reconstr.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.HiddenTokensMergerTestLanguageLanguage;

class HiddenTokensMergerTestLanguageCompletionContributor extends AbstractHiddenTokensMergerTestLanguageCompletionContributor {
	new() {
		this(HiddenTokensMergerTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}


