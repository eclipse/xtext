package org.eclipse.xtend.core.idea.completion

import org.eclipse.xtend.core.idea.lang.XtendLanguage
import org.eclipse.xtext.idea.completion.AbstractCompletionContributor

class XtendCompletionContributor extends AbstractCompletionContributor {
	new() {
		super(XtendLanguage.INSTANCE)
	}
}
