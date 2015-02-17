package org.eclipse.xtext.parser.unorderedGroups.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.SimpleBacktrackingBug325745TestLanguageLanguage;

class SimpleBacktrackingBug325745TestLanguageCompletionContributor extends AbstractSimpleBacktrackingBug325745TestLanguageCompletionContributor {
	new() {
		this(SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}


