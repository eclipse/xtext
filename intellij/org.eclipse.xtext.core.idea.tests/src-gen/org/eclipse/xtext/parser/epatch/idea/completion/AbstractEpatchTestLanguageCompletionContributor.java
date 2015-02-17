package org.eclipse.xtext.parser.epatch.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.common.idea.completion.TerminalsCompletionContributor;

public class AbstractEpatchTestLanguageCompletionContributor extends TerminalsCompletionContributor {
	public AbstractEpatchTestLanguageCompletionContributor(AbstractXtextLanguage lang) {
		super(lang);
	}
}
