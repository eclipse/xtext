package org.eclipse.xtext.serializer.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.serializer.idea.lang.HiddenTokenSequencerTestLanguageLanguage;

class HiddenTokenSequencerTestLanguageCompletionContributor extends AbstractHiddenTokenSequencerTestLanguageCompletionContributor {
	new() {
		this(HiddenTokenSequencerTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}


