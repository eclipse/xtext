package org.eclipse.xtext.serializer.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.serializer.idea.lang.SequencerTestLanguageLanguage;

class SequencerTestLanguageCompletionContributor extends AbstractSequencerTestLanguageCompletionContributor {
	new() {
		this(SequencerTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}
