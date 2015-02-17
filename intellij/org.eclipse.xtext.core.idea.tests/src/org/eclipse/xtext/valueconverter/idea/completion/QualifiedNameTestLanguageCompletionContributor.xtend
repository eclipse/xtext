package org.eclipse.xtext.valueconverter.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.valueconverter.idea.lang.QualifiedNameTestLanguageLanguage;

class QualifiedNameTestLanguageCompletionContributor extends AbstractQualifiedNameTestLanguageCompletionContributor {
	new() {
		this(QualifiedNameTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}


