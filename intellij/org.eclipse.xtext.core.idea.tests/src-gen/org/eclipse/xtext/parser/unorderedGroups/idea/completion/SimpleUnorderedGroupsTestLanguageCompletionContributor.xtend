package org.eclipse.xtext.parser.unorderedGroups.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.SimpleUnorderedGroupsTestLanguageLanguage;

class SimpleUnorderedGroupsTestLanguageCompletionContributor extends AbstractSimpleUnorderedGroupsTestLanguageCompletionContributor {
	new() {
		this(SimpleUnorderedGroupsTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}
