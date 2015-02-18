package org.eclipse.xtext.parsetree.reconstr.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.SerializationBug269362TestLanguageLanguage;

class SerializationBug269362TestLanguageCompletionContributor extends AbstractSerializationBug269362TestLanguageCompletionContributor {
	new() {
		this(SerializationBug269362TestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}


