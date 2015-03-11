package org.eclipse.xtext.parsetree.formatter.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.common.idea.completion.TerminalsCompletionContributor;

public class AbstractElementMatcherTestLanguageCompletionContributor extends TerminalsCompletionContributor {
	public AbstractElementMatcherTestLanguageCompletionContributor(AbstractXtextLanguage lang) {
		super(lang);
	}
}
