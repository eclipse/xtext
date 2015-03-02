package org.eclipse.xtext.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.common.idea.completion.TerminalsCompletionContributor;

public class AbstractXtextCompletionContributor extends TerminalsCompletionContributor {
	public AbstractXtextCompletionContributor(AbstractXtextLanguage lang) {
		super(lang);
	}
}
