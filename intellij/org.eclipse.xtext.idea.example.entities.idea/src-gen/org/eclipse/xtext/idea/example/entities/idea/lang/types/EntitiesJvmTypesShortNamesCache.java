package org.eclipse.xtext.idea.example.entities.idea.lang.types;

import org.eclipse.xtext.idea.example.entities.idea.lang.EntitiesLanguage;
import org.eclipse.xtext.idea.types.JvmTypesShortNamesCache;

import com.intellij.openapi.project.Project;

class EntitiesJvmTypesShortNamesCache extends JvmTypesShortNamesCache {

	public EntitiesJvmTypesShortNamesCache(Project project) {
		super(EntitiesLanguage.INSTANCE, project);
	}

}
