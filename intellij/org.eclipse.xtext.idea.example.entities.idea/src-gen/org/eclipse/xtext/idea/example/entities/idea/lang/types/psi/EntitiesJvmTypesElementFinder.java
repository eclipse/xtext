package org.eclipse.xtext.idea.example.entities.idea.lang.types.psi;

import org.eclipse.xtext.idea.example.entities.idea.lang.EntitiesLanguage;
import org.eclipse.xtext.idea.types.psi.JvmTypesElementFinder;

import com.intellij.openapi.project.Project;

public class EntitiesJvmTypesElementFinder extends JvmTypesElementFinder {

	public EntitiesJvmTypesElementFinder(Project project) {
		super(EntitiesLanguage.INSTANCE, project);
	}

}
