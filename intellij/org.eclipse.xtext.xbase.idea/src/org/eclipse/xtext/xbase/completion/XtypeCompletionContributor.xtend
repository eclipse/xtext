package org.eclipse.xtext.xbase.completion

import org.eclipse.xtext.xbase.idea.lang.XtypeLanguage
import org.eclipse.xtext.idea.completion.AbstractCompletionContributor

class XtypeCompletionContributor extends AbstractCompletionContributor {
	new() {
		super(XtypeLanguage.INSTANCE)
	}
}
