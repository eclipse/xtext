package org.eclipse.xtext.idea.sdomain.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.idea.sdomain.idea.lang.SDomainLanguage;

class SDomainCompletionContributor extends AbstractSDomainCompletionContributor {
	new() {
		this(SDomainLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}


