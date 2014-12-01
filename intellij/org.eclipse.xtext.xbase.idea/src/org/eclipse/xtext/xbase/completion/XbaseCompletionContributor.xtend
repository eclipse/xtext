package org.eclipse.xtext.xbase.completion

import org.eclipse.xtext.xbase.idea.lang.XbaseLanguage
import org.eclipse.xtext.idea.completion.AbstractCompletionContributor

class XbaseCompletionContributor extends AbstractCompletionContributor {
	new() {
		super(XbaseLanguage.INSTANCE)
	}
}
