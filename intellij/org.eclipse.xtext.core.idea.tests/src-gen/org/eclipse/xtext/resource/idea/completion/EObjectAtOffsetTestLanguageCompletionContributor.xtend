package org.eclipse.xtext.resource.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.resource.idea.lang.EObjectAtOffsetTestLanguageLanguage;

class EObjectAtOffsetTestLanguageCompletionContributor extends AbstractEObjectAtOffsetTestLanguageCompletionContributor {
	new() {
		this(EObjectAtOffsetTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}
