package org.eclipse.xtext.parsetree.unassignedtext.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parsetree.unassignedtext.idea.lang.UnassignedTextTestLanguageLanguage;

class UnassignedTextTestLanguageCompletionContributor extends AbstractUnassignedTextTestLanguageCompletionContributor {
	new() {
		this(UnassignedTextTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}
