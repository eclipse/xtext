package org.eclipse.xtext.linking.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.common.idea.completion.TerminalsCompletionContributor;

public class AbstractAbstractIgnoreCaseLinkingTestLanguageCompletionContributor extends TerminalsCompletionContributor {
	public AbstractAbstractIgnoreCaseLinkingTestLanguageCompletionContributor(AbstractXtextLanguage lang) {
		super(lang);
	}
}
