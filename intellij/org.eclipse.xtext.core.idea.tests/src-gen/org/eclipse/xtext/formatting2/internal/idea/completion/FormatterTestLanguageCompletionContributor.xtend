package org.eclipse.xtext.formatting2.internal.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.formatting2.internal.idea.lang.FormatterTestLanguageLanguage;

class FormatterTestLanguageCompletionContributor extends AbstractFormatterTestLanguageCompletionContributor {
	new() {
		this(FormatterTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}
