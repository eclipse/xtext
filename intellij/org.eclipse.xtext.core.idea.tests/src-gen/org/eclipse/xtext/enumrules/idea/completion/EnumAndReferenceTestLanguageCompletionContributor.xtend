package org.eclipse.xtext.enumrules.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.enumrules.idea.lang.EnumAndReferenceTestLanguageLanguage;

class EnumAndReferenceTestLanguageCompletionContributor extends AbstractEnumAndReferenceTestLanguageCompletionContributor {
	new() {
		this(EnumAndReferenceTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}
