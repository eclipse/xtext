package org.eclipse.xtext.testlanguages.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.common.idea.completion.TerminalsCompletionContributor;

public class AbstractActionTestLanguageCompletionContributor extends TerminalsCompletionContributor {
	public AbstractActionTestLanguageCompletionContributor(AbstractXtextLanguage lang) {
		super(lang);
	}
}
