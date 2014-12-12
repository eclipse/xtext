package org.eclipse.xtext.xbase.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.xbase.idea.lang.XtypeLanguage;

class XtypeCompletionContributor extends AbstractXtypeCompletionContributor {
	new() {
		this(XtypeLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}


