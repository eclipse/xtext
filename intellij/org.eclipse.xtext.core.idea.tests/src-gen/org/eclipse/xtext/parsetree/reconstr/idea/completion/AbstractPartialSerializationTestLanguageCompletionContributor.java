package org.eclipse.xtext.parsetree.reconstr.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.common.idea.completion.TerminalsCompletionContributor;

public class AbstractPartialSerializationTestLanguageCompletionContributor extends TerminalsCompletionContributor {
	public AbstractPartialSerializationTestLanguageCompletionContributor(AbstractXtextLanguage lang) {
		super(lang);
	}
}
