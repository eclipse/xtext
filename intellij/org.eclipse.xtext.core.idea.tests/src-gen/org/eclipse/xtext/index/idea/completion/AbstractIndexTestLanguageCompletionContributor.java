package org.eclipse.xtext.index.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.common.idea.completion.TerminalsCompletionContributor;

public class AbstractIndexTestLanguageCompletionContributor extends TerminalsCompletionContributor {
	public AbstractIndexTestLanguageCompletionContributor(AbstractXtextLanguage lang) {
		super(lang);
	}
}
