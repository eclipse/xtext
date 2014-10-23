package org.eclipse.xtext.idea.example.entities.idea.lang.types

import com.intellij.openapi.project.Project
import org.eclipse.xtext.idea.types.JvmTypesShortNamesCache
import org.eclipse.xtext.idea.example.entities.idea.lang.EntitiesLanguage

class EntitiesJvmTypesShortNamesCache extends JvmTypesShortNamesCache {

	new(Project project) {
		super(EntitiesLanguage.INSTANCE, project)
	}

}
