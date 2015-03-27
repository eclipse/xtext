package org.eclipse.xtext.index.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.index.idea.lang.IndexTestLanguageLanguage;

class IndexTestLanguageCompletionContributor extends AbstractIndexTestLanguageCompletionContributor {
	new() {
		this(IndexTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}


