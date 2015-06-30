package org.eclipse.xtext.parser.assignments.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.assignments.idea.lang.AssignmentsTestLanguageLanguage;

class AssignmentsTestLanguageCompletionContributor extends AbstractAssignmentsTestLanguageCompletionContributor {
	new() {
		this(AssignmentsTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}
