package org.eclipse.xtext.testlanguages.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.common.idea.completion.TerminalsCompletionContributor;

public class AbstractOptionalEmptyTestLanguageCompletionContributor extends TerminalsCompletionContributor {
	public AbstractOptionalEmptyTestLanguageCompletionContributor(AbstractXtextLanguage lang) {
		super(lang);
	}
}
