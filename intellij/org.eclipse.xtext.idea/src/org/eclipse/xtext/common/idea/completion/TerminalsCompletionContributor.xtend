package org.eclipse.xtext.common.idea.completion

import org.eclipse.xtext.idea.completion.AbstractCompletionContributor
import org.eclipse.xtext.idea.lang.AbstractXtextLanguage

abstract class TerminalsCompletionContributor extends AbstractCompletionContributor {
	
	new(AbstractXtextLanguage lang) {
		super(lang)
	}
	
}