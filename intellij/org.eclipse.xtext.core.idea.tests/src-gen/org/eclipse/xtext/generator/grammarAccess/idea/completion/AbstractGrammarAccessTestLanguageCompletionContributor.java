package org.eclipse.xtext.generator.grammarAccess.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.common.idea.completion.TerminalsCompletionContributor;

public class AbstractGrammarAccessTestLanguageCompletionContributor extends TerminalsCompletionContributor {
	public AbstractGrammarAccessTestLanguageCompletionContributor(AbstractXtextLanguage lang) {
		super(lang);
	}
}
