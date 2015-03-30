package org.eclipse.xtext.idea.common.types.idea.lang.types.psi;

import org.eclipse.xtext.idea.common.types.idea.lang.RefactoringTestLanguageLanguage;
import org.eclipse.xtext.idea.types.psi.JvmTypesElementFinder;

import com.intellij.openapi.project.Project;

public class RefactoringTestLanguageJvmTypesElementFinder extends JvmTypesElementFinder {

	public RefactoringTestLanguageJvmTypesElementFinder(Project project) {
		super(RefactoringTestLanguageLanguage.INSTANCE, project);
	}

}
