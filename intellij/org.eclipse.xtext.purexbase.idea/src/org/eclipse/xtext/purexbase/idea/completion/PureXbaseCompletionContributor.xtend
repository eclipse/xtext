package org.eclipse.xtext.purexbase.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.purexbase.idea.lang.PureXbaseLanguage;

class PureXbaseCompletionContributor extends AbstractPureXbaseCompletionContributor {
	new() {
		this(PureXbaseLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}
