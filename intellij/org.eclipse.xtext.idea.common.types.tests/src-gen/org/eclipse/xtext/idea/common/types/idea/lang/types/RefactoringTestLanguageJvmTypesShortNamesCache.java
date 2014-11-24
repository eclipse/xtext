package org.eclipse.xtext.idea.common.types.idea.lang.types;

import com.intellij.openapi.project.Project;
import org.eclipse.xtext.idea.types.JvmTypesShortNamesCache;
import org.eclipse.xtext.idea.common.types.idea.lang.RefactoringTestLanguageLanguage;

class RefactoringTestLanguageJvmTypesShortNamesCache extends JvmTypesShortNamesCache {

	public RefactoringTestLanguageJvmTypesShortNamesCache(Project project) {
		super(RefactoringTestLanguageLanguage.INSTANCE, project);
	}

}
