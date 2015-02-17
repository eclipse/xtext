package org.eclipse.xtext.parser.unorderedGroups.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.ExBacktrackingBug325745TestLanguageLanguage;

class ExBacktrackingBug325745TestLanguageCompletionContributor extends AbstractExBacktrackingBug325745TestLanguageCompletionContributor {
	new() {
		this(ExBacktrackingBug325745TestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}


