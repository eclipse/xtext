package org.eclipse.xtext.xtext.ecoreInference.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.common.idea.completion.TerminalsCompletionContributor;

public class AbstractUnassignedRuleCallTestLanguageCompletionContributor extends TerminalsCompletionContributor {
	public AbstractUnassignedRuleCallTestLanguageCompletionContributor(AbstractXtextLanguage lang) {
		super(lang);
	}
}
