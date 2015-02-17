package org.eclipse.xtext.serializer.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.common.idea.completion.TerminalsCompletionContributor;

public class AbstractContextFinderTestLanguageCompletionContributor extends TerminalsCompletionContributor {
	public AbstractContextFinderTestLanguageCompletionContributor(AbstractXtextLanguage lang) {
		super(lang);
	}
}
