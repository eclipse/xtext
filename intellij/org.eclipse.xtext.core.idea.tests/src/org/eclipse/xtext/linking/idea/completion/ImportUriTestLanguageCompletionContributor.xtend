package org.eclipse.xtext.linking.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.linking.idea.lang.ImportUriTestLanguageLanguage;

class ImportUriTestLanguageCompletionContributor extends AbstractImportUriTestLanguageCompletionContributor {
	new() {
		this(ImportUriTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}


