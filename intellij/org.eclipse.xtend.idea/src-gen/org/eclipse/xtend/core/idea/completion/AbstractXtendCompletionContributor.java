package org.eclipse.xtend.core.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.xbase.annotations.idea.completion.XbaseWithAnnotationsCompletionContributor;

public class AbstractXtendCompletionContributor extends XbaseWithAnnotationsCompletionContributor {
	public AbstractXtendCompletionContributor(AbstractXtextLanguage lang) {
		super(lang);
	}
}
