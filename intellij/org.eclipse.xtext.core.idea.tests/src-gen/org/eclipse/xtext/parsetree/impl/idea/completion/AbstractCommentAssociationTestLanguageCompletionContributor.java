package org.eclipse.xtext.parsetree.impl.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.common.idea.completion.TerminalsCompletionContributor;

public class AbstractCommentAssociationTestLanguageCompletionContributor extends TerminalsCompletionContributor {
	public AbstractCommentAssociationTestLanguageCompletionContributor(AbstractXtextLanguage lang) {
		super(lang);
	}
}
