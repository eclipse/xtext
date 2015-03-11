package org.eclipse.xtext.linking.lazy.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.linking.lazy.idea.lang.LazyLinkingTestLanguageLanguage;

class LazyLinkingTestLanguageCompletionContributor extends AbstractLazyLinkingTestLanguageCompletionContributor {
	new() {
		this(LazyLinkingTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}


