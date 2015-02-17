package org.eclipse.xtext.linking.lazy.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.common.idea.completion.TerminalsCompletionContributor;

public class AbstractLazyLinkingTestLanguageCompletionContributor extends TerminalsCompletionContributor {
	public AbstractLazyLinkingTestLanguageCompletionContributor(AbstractXtextLanguage lang) {
		super(lang);
	}
}
