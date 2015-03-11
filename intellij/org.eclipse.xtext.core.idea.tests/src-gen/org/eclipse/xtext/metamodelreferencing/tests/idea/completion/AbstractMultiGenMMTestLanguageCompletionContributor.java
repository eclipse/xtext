package org.eclipse.xtext.metamodelreferencing.tests.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.common.idea.completion.TerminalsCompletionContributor;

public class AbstractMultiGenMMTestLanguageCompletionContributor extends TerminalsCompletionContributor {
	public AbstractMultiGenMMTestLanguageCompletionContributor(AbstractXtextLanguage lang) {
		super(lang);
	}
}
