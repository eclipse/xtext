package org.eclipse.xtext.parsetree.formatter.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.common.idea.completion.TerminalsCompletionContributor;

public class AbstractFormatterTestLanguageCompletionContributor extends TerminalsCompletionContributor {
	public AbstractFormatterTestLanguageCompletionContributor(AbstractXtextLanguage lang) {
		super(lang);
	}
}
