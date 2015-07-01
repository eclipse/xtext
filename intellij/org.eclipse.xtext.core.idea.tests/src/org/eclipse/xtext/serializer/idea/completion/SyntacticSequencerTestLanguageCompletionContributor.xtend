package org.eclipse.xtext.serializer.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.serializer.idea.lang.SyntacticSequencerTestLanguageLanguage;

class SyntacticSequencerTestLanguageCompletionContributor extends AbstractSyntacticSequencerTestLanguageCompletionContributor {
	new() {
		this(SyntacticSequencerTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}
