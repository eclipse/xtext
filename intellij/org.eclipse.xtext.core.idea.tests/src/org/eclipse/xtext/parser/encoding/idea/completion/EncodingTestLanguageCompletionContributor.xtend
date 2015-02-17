package org.eclipse.xtext.parser.encoding.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.encoding.idea.lang.EncodingTestLanguageLanguage;

class EncodingTestLanguageCompletionContributor extends AbstractEncodingTestLanguageCompletionContributor {
	new() {
		this(EncodingTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}


