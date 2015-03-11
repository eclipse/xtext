package org.eclipse.xtext.dummy.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.common.idea.completion.TerminalsCompletionContributor;

public class AbstractDummyTestLanguageCompletionContributor extends TerminalsCompletionContributor {
	public AbstractDummyTestLanguageCompletionContributor(AbstractXtextLanguage lang) {
		super(lang);
	}
}
