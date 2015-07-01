package org.eclipse.xtext.parsetree.transientvalues.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parsetree.transientvalues.idea.lang.TransientValuesTestLanguage;

class TransientValuesTestCompletionContributor extends AbstractTransientValuesTestCompletionContributor {
	new() {
		this(TransientValuesTestLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}
