package org.eclipse.xtext.metamodelreferencing.tests.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.common.idea.completion.TerminalsCompletionContributor;

public class AbstractEcoreReferenceTestLanguageCompletionContributor extends TerminalsCompletionContributor {
	public AbstractEcoreReferenceTestLanguageCompletionContributor(AbstractXtextLanguage lang) {
		super(lang);
	}
}
