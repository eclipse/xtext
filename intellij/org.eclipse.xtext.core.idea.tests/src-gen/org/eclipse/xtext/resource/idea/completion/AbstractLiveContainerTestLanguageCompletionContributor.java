package org.eclipse.xtext.resource.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.common.idea.completion.TerminalsCompletionContributor;

public class AbstractLiveContainerTestLanguageCompletionContributor extends TerminalsCompletionContributor {
	public AbstractLiveContainerTestLanguageCompletionContributor(AbstractXtextLanguage lang) {
		super(lang);
	}
}
