package org.eclipse.xtext.xbase.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.xbase.idea.lang.XbaseLanguage;

class XbaseCompletionContributor extends AbstractXbaseCompletionContributor {
	new() {
		this(XbaseLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}


