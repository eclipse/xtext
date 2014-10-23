package org.eclipse.xtext.idea.example.entities.idea.lang.types.psi.search

import org.eclipse.xtext.idea.types.psi.search.JvmElementsReferencesSearch
import org.eclipse.xtext.idea.example.entities.idea.lang.EntitiesLanguage

class EntitiesJvmElementsReferencesSearch extends JvmElementsReferencesSearch {

	new() {
		super(EntitiesLanguage.INSTANCE)
	}

}
