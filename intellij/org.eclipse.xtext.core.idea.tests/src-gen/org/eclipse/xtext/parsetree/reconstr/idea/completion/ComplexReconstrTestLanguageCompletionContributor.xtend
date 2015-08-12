package org.eclipse.xtext.parsetree.reconstr.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.ComplexReconstrTestLanguageLanguage;

class ComplexReconstrTestLanguageCompletionContributor extends AbstractComplexReconstrTestLanguageCompletionContributor {
	new() {
		this(ComplexReconstrTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}
