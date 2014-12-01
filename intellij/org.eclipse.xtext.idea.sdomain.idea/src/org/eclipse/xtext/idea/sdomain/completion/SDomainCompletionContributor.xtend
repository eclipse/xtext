package org.eclipse.xtext.idea.sdomain.completion

import org.eclipse.xtext.idea.sdomain.idea.lang.SDomainLanguage
import org.eclipse.xtext.idea.completion.AbstractCompletionContributor

class SDomainCompletionContributor extends AbstractCompletionContributor {
	new() {
		super(SDomainLanguage.INSTANCE)
	}
}
