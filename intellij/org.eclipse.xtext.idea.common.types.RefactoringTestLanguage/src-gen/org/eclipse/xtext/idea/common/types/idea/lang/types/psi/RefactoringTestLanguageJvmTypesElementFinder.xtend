package org.eclipse.xtext.idea.common.types.idea.lang.types.psi

import com.intellij.openapi.project.Project
import org.eclipse.xtext.idea.types.psi.JvmTypesElementFinder
import org.eclipse.xtext.idea.common.types.idea.lang.RefactoringTestLanguageLanguage

class RefactoringTestLanguageJvmTypesElementFinder extends JvmTypesElementFinder {

	new(Project project) {
		super(RefactoringTestLanguageLanguage.INSTANCE, project)
	}

}
