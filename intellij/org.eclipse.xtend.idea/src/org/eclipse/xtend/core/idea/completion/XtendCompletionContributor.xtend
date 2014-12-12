package org.eclipse.xtend.core.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage
import org.eclipse.xtend.core.idea.lang.XtendLanguage

class XtendCompletionContributor extends AbstractXtendCompletionContributor {
	new() {
		this(XtendLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}


