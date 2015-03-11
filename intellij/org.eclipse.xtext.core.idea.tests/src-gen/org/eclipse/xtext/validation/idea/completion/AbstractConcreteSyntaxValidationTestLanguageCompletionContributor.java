package org.eclipse.xtext.validation.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.common.idea.completion.TerminalsCompletionContributor;

public class AbstractConcreteSyntaxValidationTestLanguageCompletionContributor extends TerminalsCompletionContributor {
	public AbstractConcreteSyntaxValidationTestLanguageCompletionContributor(AbstractXtextLanguage lang) {
		super(lang);
	}
}
