package org.eclipse.xtext.parsetree.reconstr.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.SimpleReconstrTestLanguageLanguage;

class SimpleReconstrTestLanguageCompletionContributor extends AbstractSimpleReconstrTestLanguageCompletionContributor {
	new() {
		this(SimpleReconstrTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}


