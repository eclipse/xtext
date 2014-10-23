package org.eclipse.xtext.idea.example.entities.idea.lang.types.psi

import com.intellij.openapi.project.Project
import org.eclipse.xtext.idea.types.psi.JvmTypesElementFinder
import org.eclipse.xtext.idea.example.entities.idea.lang.EntitiesLanguage

class EntitiesJvmTypesElementFinder extends JvmTypesElementFinder {

	new(Project project) {
		super(EntitiesLanguage.INSTANCE, project)
	}

}
