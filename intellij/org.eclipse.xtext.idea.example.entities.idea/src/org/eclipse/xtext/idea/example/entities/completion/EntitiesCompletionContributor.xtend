package org.eclipse.xtext.idea.example.entities.completion

import org.eclipse.xtext.idea.example.entities.idea.lang.EntitiesLanguage
import org.eclipse.xtext.idea.completion.AbstractCompletionContributor

class EntitiesCompletionContributor extends AbstractCompletionContributor {
	new() {
		super(EntitiesLanguage.INSTANCE)
	}
}
