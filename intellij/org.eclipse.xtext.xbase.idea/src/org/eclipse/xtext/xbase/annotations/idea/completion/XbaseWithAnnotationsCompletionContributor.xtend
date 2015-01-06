package org.eclipse.xtext.xbase.annotations.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.xbase.annotations.idea.lang.XbaseWithAnnotationsLanguage;

class XbaseWithAnnotationsCompletionContributor extends AbstractXbaseWithAnnotationsCompletionContributor {
	new() {
		this(XbaseWithAnnotationsLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}