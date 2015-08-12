package org.eclipse.xtext.parsetree.reconstr.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.SerializationErrorTestLanguageLanguage;

class SerializationErrorTestLanguageCompletionContributor extends AbstractSerializationErrorTestLanguageCompletionContributor {
	new() {
		this(SerializationErrorTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}
