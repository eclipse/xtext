package org.eclipse.xtext.linking.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.common.idea.completion.TerminalsCompletionContributor;

public class AbstractLangATestLanguageCompletionContributor extends TerminalsCompletionContributor {
	public AbstractLangATestLanguageCompletionContributor(AbstractXtextLanguage lang) {
		super(lang);
	}
}
