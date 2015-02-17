package org.eclipse.xtext.testlanguages.indent.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.idea.completion.AbstractCompletionContributor;

public class AbstractIndentationAwareTestLanguageCompletionContributor extends AbstractCompletionContributor {
	public AbstractIndentationAwareTestLanguageCompletionContributor(AbstractXtextLanguage lang) {
		super(lang);
	}
}
