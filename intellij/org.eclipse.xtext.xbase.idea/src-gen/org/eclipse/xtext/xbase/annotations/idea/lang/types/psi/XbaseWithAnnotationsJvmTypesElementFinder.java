package org.eclipse.xtext.xbase.annotations.idea.lang.types.psi;

import com.intellij.openapi.project.Project;
import org.eclipse.xtext.idea.types.psi.JvmTypesElementFinder;
import org.eclipse.xtext.xbase.annotations.idea.lang.XbaseWithAnnotationsLanguage;

public class XbaseWithAnnotationsJvmTypesElementFinder extends JvmTypesElementFinder {

	public XbaseWithAnnotationsJvmTypesElementFinder(Project project) {
		super(XbaseWithAnnotationsLanguage.INSTANCE, project);
	}

}
