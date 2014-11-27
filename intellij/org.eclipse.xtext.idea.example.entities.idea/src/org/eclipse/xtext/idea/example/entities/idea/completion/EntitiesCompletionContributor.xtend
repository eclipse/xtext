package org.eclipse.xtext.idea.example.entities.idea.completion

import org.eclipse.xtext.idea.completion.AbstractCompletionContributor
import org.eclipse.xtext.idea.example.entities.idea.lang.EntitiesLanguage

class EntitiesCompletionContributor extends AbstractCompletionContributor {
	new() {
		super(EntitiesLanguage.INSTANCE)
	}
	
}