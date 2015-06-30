package org.eclipse.xtext.parser.unorderedGroups.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.ExUnorderedGroupsTestLanguageLanguage;

class ExUnorderedGroupsTestLanguageCompletionContributor extends AbstractExUnorderedGroupsTestLanguageCompletionContributor {
	new() {
		this(ExUnorderedGroupsTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}
