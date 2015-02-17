package org.eclipse.xtext.resource.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.common.idea.completion.TerminalsCompletionContributor;

public class AbstractLocationProviderTestLanguageCompletionContributor extends TerminalsCompletionContributor {
	public AbstractLocationProviderTestLanguageCompletionContributor(AbstractXtextLanguage lang) {
		super(lang);
	}
}
