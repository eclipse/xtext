package org.eclipse.xtext.idea.common.types.idea.lang.types.psi;

import com.intellij.openapi.project.Project;
import org.eclipse.xtext.idea.types.psi.JvmTypesElementFinder;
import org.eclipse.xtext.idea.common.types.idea.lang.RefactoringTestLanguageLanguage;

public class RefactoringTestLanguageJvmTypesElementFinder extends JvmTypesElementFinder {

	public RefactoringTestLanguageJvmTypesElementFinder(Project project) {
		super(RefactoringTestLanguageLanguage.INSTANCE, project);
	}

}
