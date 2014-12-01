package org.eclipse.xtext.xbase.annotations.completion

import org.eclipse.xtext.xbase.annotations.idea.lang.XbaseWithAnnotationsLanguage
import org.eclipse.xtext.idea.completion.AbstractCompletionContributor

class XbaseWithAnnotationsCompletionContributor extends AbstractCompletionContributor {
	new() {
		super(XbaseWithAnnotationsLanguage.INSTANCE)
	}
}
