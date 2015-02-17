package org.eclipse.xtext.linking.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.common.idea.completion.TerminalsCompletionContributor;

public class AbstractImportUriTestLanguageCompletionContributor extends TerminalsCompletionContributor {
	public AbstractImportUriTestLanguageCompletionContributor(AbstractXtextLanguage lang) {
		super(lang);
	}
}
