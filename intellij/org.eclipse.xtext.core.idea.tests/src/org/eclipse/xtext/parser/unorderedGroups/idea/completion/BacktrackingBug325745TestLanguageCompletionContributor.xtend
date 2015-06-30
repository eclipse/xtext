package org.eclipse.xtext.parser.unorderedGroups.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.BacktrackingBug325745TestLanguageLanguage;

class BacktrackingBug325745TestLanguageCompletionContributor extends AbstractBacktrackingBug325745TestLanguageCompletionContributor {
	new() {
		this(BacktrackingBug325745TestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}
