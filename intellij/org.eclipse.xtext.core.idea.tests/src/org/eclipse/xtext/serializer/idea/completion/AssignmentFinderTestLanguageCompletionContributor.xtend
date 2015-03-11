package org.eclipse.xtext.serializer.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.serializer.idea.lang.AssignmentFinderTestLanguageLanguage;

class AssignmentFinderTestLanguageCompletionContributor extends AbstractAssignmentFinderTestLanguageCompletionContributor {
	new() {
		this(AssignmentFinderTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}


