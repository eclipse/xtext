package org.eclipse.xtext.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.idea.lang.XtextLanguage;

class XtextCompletionContributor extends AbstractXtextCompletionContributor {
	new() {
		this(XtextLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}


