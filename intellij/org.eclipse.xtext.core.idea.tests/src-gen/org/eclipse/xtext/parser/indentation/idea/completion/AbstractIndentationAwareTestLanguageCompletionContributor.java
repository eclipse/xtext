package org.eclipse.xtext.parser.indentation.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.common.idea.completion.TerminalsCompletionContributor;

public class AbstractIndentationAwareTestLanguageCompletionContributor extends TerminalsCompletionContributor {
	public AbstractIndentationAwareTestLanguageCompletionContributor(AbstractXtextLanguage lang) {
		super(lang);
	}
}
