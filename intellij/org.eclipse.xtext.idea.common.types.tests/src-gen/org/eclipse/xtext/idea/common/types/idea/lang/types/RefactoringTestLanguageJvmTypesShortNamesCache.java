package org.eclipse.xtext.idea.common.types.idea.lang.types;

import org.eclipse.xtext.idea.common.types.idea.lang.RefactoringTestLanguageLanguage;
import org.eclipse.xtext.idea.types.JvmTypesShortNamesCache;

import com.intellij.openapi.project.Project;

class RefactoringTestLanguageJvmTypesShortNamesCache extends JvmTypesShortNamesCache {

	public RefactoringTestLanguageJvmTypesShortNamesCache(Project project) {
		super(RefactoringTestLanguageLanguage.INSTANCE, project);
	}

}
