package org.eclipse.xtext.testlanguages.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.common.idea.completion.TerminalsCompletionContributor;

public class AbstractLookaheadTestLanguageCompletionContributor extends TerminalsCompletionContributor {
	public AbstractLookaheadTestLanguageCompletionContributor(AbstractXtextLanguage lang) {
		super(lang);
	}
}
