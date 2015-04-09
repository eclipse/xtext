package org.eclipse.xtext.idea.common.types.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.common.idea.completion.TerminalsCompletionContributor;

public class AbstractRefactoringTestLanguageCompletionContributor extends TerminalsCompletionContributor {
	public AbstractRefactoringTestLanguageCompletionContributor(AbstractXtextLanguage lang) {
		super(lang);
	}
}
