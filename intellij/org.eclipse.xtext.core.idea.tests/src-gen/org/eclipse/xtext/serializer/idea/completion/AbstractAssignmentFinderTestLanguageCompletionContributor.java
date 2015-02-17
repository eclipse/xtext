package org.eclipse.xtext.serializer.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.common.idea.completion.TerminalsCompletionContributor;

public class AbstractAssignmentFinderTestLanguageCompletionContributor extends TerminalsCompletionContributor {
	public AbstractAssignmentFinderTestLanguageCompletionContributor(AbstractXtextLanguage lang) {
		super(lang);
	}
}
